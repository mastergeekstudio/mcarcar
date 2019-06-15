package com.icss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.icss.dao.Car_conDao;
import com.icss.dao.Car_verDao;
import com.icss.dao.PicDao;
import com.icss.dao.ProDaoBatis;
import com.icss.entity.Car_condition;
import com.icss.entity.Car_ver;
import com.icss.entity.Pic;
import com.icss.entity.Pro;

import com.icss.entity.query_result;
import com.icss.util.MybatisUtil;

@Controller
public class ProController {

	@RequestMapping("home")
	public void showProOnSell(HttpServletRequest request) {

		System.out.println("show pro--------------");
		ArrayList<Pro> cList = null;

		SqlSession ss = MybatisUtil.getSqlSession();
		ProDaoBatis proDao = ss.getMapper(ProDaoBatis.class);
		cList = proDao.showCarInSell();
		System.out.println(cList);
		request.setAttribute("clist", cList);

	}

	@RequestMapping("inputPro")
	public String inputPro(HttpServletRequest request) {

		System.out.println("inputPro---->");
		SqlSession ss = MybatisUtil.getSqlSession();
		Car_conDao car_conDao = ss.getMapper(Car_conDao.class);
		ArrayList<Car_condition> ccList = car_conDao.selectAllCon();
		request.setAttribute("ccList", ccList);

		return "inputCar";

	}

	@RequestMapping("insertPro")
	public String insertPro(Car_ver c_v, Pro p, String[] car_condition_array, String displacement_str) {

		System.out.println("insertPro---->");
		SqlSession ss = MybatisUtil.getSqlSession();
		Car_verDao car_verDao = ss.getMapper(Car_verDao.class);
		c_v.setDisplacement(Float.parseFloat(displacement_str));
		int r_c = car_verDao.insertCar_ver(c_v);
		ss.commit();
		System.out.println("verid--->");
		if (r_c >= 1) {
			System.out.println("verid--->" + c_v.getVerid() + "----success");
		}
		p.setVer(c_v);
		String car_condition = "";
		for (String string : car_condition_array) {
			car_condition += "," + string;
		}
		;
		car_condition = car_condition.substring(1);
		p.setCondition_car(car_condition);
		ProDaoBatis proDao = ss.getMapper(ProDaoBatis.class);
		int r_p = proDao.inertNewPro(p);
		ss.commit();
		if (r_p >= 1) {
			System.out.println("proid--->success");
		}

		return "redirect:inputPro.do";

	}

	// 列表显示车量
	@RequestMapping("listShow")
	public void listShow(HttpServletRequest request) {
		System.out.println("--->listShow run");
		SqlSession ss = MybatisUtil.getSqlSession();
		ProDaoBatis proDao = ss.getMapper(ProDaoBatis.class);
		HttpSession session = request.getSession();
		if (session.getAttribute("year") == null) {
			Calendar c = Calendar.getInstance();
			session.setAttribute("year", c.get(Calendar.YEAR));
		}

		int year = (Integer) session.getAttribute("year");
		ArrayList<Pro> pList = proDao.listPro(year);
		request.setAttribute("plist", pList);

		System.out.println("year-->" + session.getAttribute("year"));
		System.out.println(pList);

	}

	@RequestMapping("chartData")
	public void charData(HttpServletRequest request, HttpServletResponse response) throws IOException {

		System.out.println("chartData--------------");
		int query_id = Integer.parseInt(request.getParameter("verid"));
		int query_year = (int) request.getSession().getAttribute("year");
		SqlSession ss = MybatisUtil.getSqlSession();
		ProDaoBatis proDao = ss.getMapper(ProDaoBatis.class);
		ArrayList<query_result> count_List1 = proDao.selPriceMovementByVerid(query_id, query_year);
		ArrayList<query_result> count_List2 = proDao.selSalesByVerid(query_id, query_year);

		System.out.println(count_List1);
		System.out.println(count_List2);
		JSONArray data = new JSONArray();
		JSONArray data1 = new JSONArray();
		JSONArray data2 = new JSONArray();

		// 初始化第一个填充值
		createMap(count_List1, data1);

		createMap(count_List2, data2);
		System.out.println(data1);
		System.out.println(data2);

		// JSONObject temp1 = new JSONObject();
		// temp1.put("name", i);
		// temp1.put("value", count_List1.get(i - 1).getCount());
		// data1.add(temp1);

		// 取数据
		// for (
		//
		// int i = 1; i <= 12; i++) {
		// JSONObject temp1 = new JSONObject();
		// temp1.put("name", String.valueOf(i));
		// temp1.put("value", (int) (Math.random() * 10));
		// data1.add(temp1);
		// JSONObject temp2 = new JSONObject();
		// temp2.put("name", String.valueOf(i));
		// temp2.put("value", (int) (Math.random() * 50));
		// data2.add(temp2);
		// }

		data.add(data1);
		data.add(data2);
		PrintWriter out = response.getWriter();
		out.print(data);
		out.flush();
		out.close();

	}

	private void createMap(ArrayList<query_result> count_List, JSONArray data) {
		query_result count_temp = new query_result(1, 0);
		
		if(count_List.size()>0) {
			// 循环取list变量与前一变量比较month值，不相邻，填充0。
			for (int i = 1; i <= count_List.size(); i++) {
				query_result count_i = count_List.get(i - 1);
				int j = 1;
				if (count_i.getMonth_d() > count_temp.getMonth_d()) {

					for (j = count_temp.getMonth_d() + 1; j < count_i.getMonth_d(); j++) {
						putData(data, j, 0);
					}

				}
				putData(data, j, count_i.getResult());
				count_temp = count_i;
			}

			for (int i = count_temp.getMonth_d() + 1; i <= 12; i++) {
				putData(data, i, 0);
			}
		}else {
			for (int i = 1; i <= 12; i++) {
				putData(data, i, 0);
			}
		}
		
	}

	private void putData(JSONArray data1, int name, float value) {
		JSONObject temp1 = new JSONObject();
		temp1.put("name", name);
		temp1.put("value", value);
		data1.add(temp1);
	}

	@RequestMapping("changeSessionYear")

	public String changeSessionYear(int pOrd, HttpServletRequest request) {

		HttpSession session = request.getSession();
		if (session.getAttribute("year") != null) {

			session.setAttribute("year", (Integer) session.getAttribute("year") + pOrd);
		}
		
		 return "redirect:listShow.do";

	}

	@RequestMapping("upPic")
	public String fun5(@RequestParam("upload") CommonsMultipartFile pic) {
		System.out.println("add photo---------------------");
		Pic p = new Pic();
		p.setPic(pic.getBytes());
		SqlSession ss = MybatisUtil.getSqlSession();
		PicDao picDao = ss.getMapper(PicDao.class);
		picDao.insertPic(p);
		return "show";
	}

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.YEAR));

	}

}

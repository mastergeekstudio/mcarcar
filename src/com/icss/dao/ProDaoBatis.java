package com.icss.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.icss.entity.Pro;
import com.icss.entity.query_result;

public interface ProDaoBatis {
	public ArrayList<Pro> showCarInSell();

	public int inertNewPro(Pro p);

	public ArrayList<Pro> listPro();
	public ArrayList<Pro> listPro(Integer year);

	public ArrayList<query_result> selSalesByVerid(int verid, int year);

	public ArrayList<query_result> selPriceMovementByVerid(int verid, int year);

	public ArrayList<query_result> selPriceMovementByVerid(int id, String year);

	public ArrayList<query_result> selSalesByVerid(int verid, String string);

}

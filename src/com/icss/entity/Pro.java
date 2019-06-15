package com.icss.entity;

import java.sql.Timestamp;
import java.util.Date;


public class Pro {
	
	private Integer proid;
	private Car_ver ver;
	private Integer sellerid;
	private String sn;
	private String engine_sn;
	private Integer mileage;
	private String license_plate;
	private Integer transfor_times;
	private Timestamp license_date;
	private String car_home	;
	private Float cost;
	private Float price;
	private Float actual_price;
	private Timestamp date_reg_car;
	private String condition_car;
	private Date date_deal;
	private String status_trans;
	private Integer buyerid;
	private String coverimg;
	private String imgdetial;
	private Integer viewcount;
	private String emission_level;
	
	
	@Override
	public String toString() {
		return "Pro [proid=" + proid + ", ver=" + ver + ", sellerid="
				+ sellerid + ", sn=" + sn + ", engine_sn=" + engine_sn
				+ ", mileage=" + mileage + ", license_plate=" + license_plate
				+ ", car_home=" + car_home + ", cost=" + cost + ", price="
				+ price + ", actual_price=" + actual_price + ", date_reg_car="
				+ date_reg_car + ", condition_car=" + condition_car
				+ ", date_deal=" + date_deal + ", status_trans=" + status_trans
				+ ", buyerid=" + buyerid + ", coverimg=" + coverimg
				+ ", imgdetial=" + imgdetial + "]";
	}
	public Integer getProid() {
		return proid;
	}
	public void setProid(Integer proid) {
		this.proid = proid;
	}
	
	public Integer getSellerid() {
		return sellerid;
	}
	public void setSellerid(Integer sellerid) {
		this.sellerid = sellerid;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getEngine_sn() {
		return engine_sn;
	}
	public void setEngine_sn(String engine_sn) {
		this.engine_sn = engine_sn;
	}
	public Integer getMileage() {
		return mileage;
	}
	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}
	public String getLicense_plate() {
		return license_plate;
	}
	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}
	public String getCar_home() {
		return car_home;
	}
	public void setCar_home(String car_home) {
		this.car_home = car_home;
	}
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getActual_price() {
		return actual_price;
	}
	public void setActual_price(Float actual_price) {
		this.actual_price = actual_price;
	}
	public Date getDate_reg_car() {
		return date_reg_car;
	}
	public void setDate_reg_car(Timestamp date_reg_car) {
		this.date_reg_car = date_reg_car;
	}
	public String getCondition_car() {
		return condition_car;
	}
	public void setCondition_car(String condition_car) {
		this.condition_car = condition_car;
	}
	public Date getDate_deal() {
		return date_deal;
	}
	public void setDate_deal(Date date_deal) {
		this.date_deal =  date_deal;
	}
	public String getStatus_trans() {
		return status_trans;
	}
	public void setStatus_trans(String status_trans) {
		this.status_trans = status_trans;
	}
	public Integer getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(Integer buyerid) {
		this.buyerid = buyerid;
	}
	public String getCoverimg() {
		return coverimg;
	}
	public void setCoverimg(String coverimg) {
		this.coverimg = coverimg;
	}
	public String getImgdetial() {
		return imgdetial;
	}
	public void setImgdetial(String imgdetial) {
		this.imgdetial = imgdetial;
	}
	public Integer getViewcount() {
		return viewcount;
	}
	public void setViewcount(Integer viewcount) {
		this.viewcount = viewcount;
	}
	public Integer getTransfor_times() {
		return transfor_times;
	}
	public void setTransfor_times(Integer transfor_times) {
		this.transfor_times = transfor_times;
	}
	public Timestamp getLicense_date() {
		return license_date;
	}
	public void setLicense_date(Timestamp license_date) {
		this.license_date = license_date;
	}
	public String getEmission_level() {
		return emission_level;
	}
	public void setEmission_level(String emission_level) {
		this.emission_level = emission_level;
	}
	public Car_ver getVer() {
		return ver;
	}
	public void setVer(Car_ver ver) {
		this.ver = ver;
	}
	
	


}

package com.icss.entity;

public class Car_ver {
	
	private Integer verid;
	private String brand;
	private String model;
	private String family;
	private String ver;
	private Float displacement;
	private String gearbox;
	private String emission_level;
	private String uitility;
	private String style;
	private Integer proid;
	private String coverimg;

	public String getCoverimg() {
		return coverimg;
	}
	public void setCoverimg(String coverimg) {
		this.coverimg = coverimg;
	}
	public Integer getVerid() {
		return verid;
	}
	public void setVerid(Integer verid) {
		this.verid = verid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public Float getDisplacement() {
		return displacement;
	}
	public void setDisplacement(Float displacement) {
		this.displacement = displacement;
	}
	public String getGearbox() {
		return gearbox;
	}
	public void setGearbox(String gearbox) {
		this.gearbox = gearbox;
	}
	public String getEmission_level() {
		return emission_level;
	}
	public void setEmission_level(String emission_level) {
		this.emission_level = emission_level;
	}
	public String getUitility() {
		return uitility;
	}
	public void setUitility(String uitility) {
		this.uitility = uitility;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	@Override
	public String toString() {
		return "car_ver [verid=" + verid + ", brand=" + brand + ", model="
				+ model + ", family=" + family + ", ver=" + ver
				+ ", displacement=" + displacement + ", gearbox=" + gearbox
				+ ", emission_level=" + emission_level + ", uitility="
				+ uitility + ", style=" + style + "]";
	}
	public Integer getProid() {
		return proid;
	}
	public void setProid(Integer proid) {
		this.proid = proid;
	}
	
	

}

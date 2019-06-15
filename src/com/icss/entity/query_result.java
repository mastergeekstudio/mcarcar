package com.icss.entity;

public class query_result {
	private int month_d;
	private float result;
	
	
	public query_result() {
		
	}


	public query_result(int month_d, float result) {
		super();
		this.month_d = month_d;
		this.result = result;
	}


	public int getMonth_d() {
		return month_d;
	}


	public void setMonth_d(int month_d) {
		this.month_d = month_d;
	}


	public float getResult() {
		return result;
	}


	public void setResult(float  result) {
		this.result = result;
	}


	@Override
	public String toString() {
		return "query_result [month_d=" + month_d + ", result=" + result + "]";
	}
	


	
	
	
}

package com.ddlab.rnd.di.setter;

public class Organisation {
	
	private String name;
	private String adrs;
	private int totalEmps;
	private boolean isITCompany;
	private double turnOver;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdrs() {
		return adrs;
	}
	public void setAdrs(String adrs) {
		this.adrs = adrs;
	}
	public int getTotalEmps() {
		return totalEmps;
	}
	public void setTotalEmps(int totalEmps) {
		this.totalEmps = totalEmps;
	}
	public boolean isITCompany() {
		return isITCompany;
	}
	public void setITCompany(boolean isITCompany) {
		this.isITCompany = isITCompany;
	}
	public double getTurnOver() {
		return turnOver;
	}
	public void setTurnOver(double turnOver) {
		this.turnOver = turnOver;
	}
	

}

package vo;

import java.time.LocalDateTime;

public class temperature {
	private double nowTemperature;
	private double likeTemperature;
	private String region;
	private String rcdCloth;
	private LocalDateTime tempDate;
	
	public temperature() {
		
	}
	
	public temperature(double nowTemperature, double likeTemperature, String region, String rcdCloth, LocalDateTime tempDate) {
		super();
		this.nowTemperature = nowTemperature;
		this.likeTemperature = likeTemperature;
		this.region = region;
		this.rcdCloth = rcdCloth;
		this.tempDate = tempDate;
	}

	public double getNowTemperature() {
		return nowTemperature;
	}

	public void setNowTemperature(double nowTemperature) {
		this.nowTemperature = nowTemperature;
	}

	public double getLikeTemperature() {
		return likeTemperature;
	}

	public void setLikeTemperature(double likeTemperature) {
		this.likeTemperature = likeTemperature;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRcdCloth() {
		return rcdCloth;
	}

	public void setRcdCloth(String rcdCloth) {
		this.rcdCloth = rcdCloth;
	}

	public LocalDateTime getTempDate() {
		return tempDate;
	}

	public void setTempDate(LocalDateTime tempDate) {
		this.tempDate = tempDate;
	}
	
	
}

package online.edirect.connector.domain;

import java.util.Date;

import com.mysql.jdbc.Blob;

public class Product {
	private long product_id;
	private int category_id;
	private String product_name;
	private String description;
	private boolean featured_product;
	private String company_name;
	private double buy_price;
	private double sell_price;
	private boolean packaging;
	private String video_link;
	private int treshold_max;
	private int treshold_min;
	private double weight;
	private String dimension;
	private double logistic_price;
	private Date featured_product_date;
	private Date update_date;
	private double tarif;
	private int over_stock_days;
	private double percentage_deal;
	private int season_reup_alert_days;
	private Date season_reup_alert_date;

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public boolean isFeatured_product() {
		return featured_product;
	}

	public void setFeatured_product(boolean featured_product) {
		this.featured_product = featured_product;
	}

	public boolean isPackaging() {
		return packaging;
	}

	public void setPackaging(boolean packaging) {
		this.packaging = packaging;
	}

	public int getTreshold_max() {
		return treshold_max;
	}

	public void setTreshold_max(int treshold_max) {
		this.treshold_max = treshold_max;
	}

	public int getTreshold_min() {
		return treshold_min;
	}

	public void setTreshold_min(int treshold_min) {
		this.treshold_min = treshold_min;
	}

	public int getOver_stock_days() {
		return over_stock_days;
	}

	public void setOver_stock_days(int over_stock_days) {
		this.over_stock_days = over_stock_days;
	}

	public int getSeason_reup_alert_days() {
		return season_reup_alert_days;
	}

	public void setSeason_reup_alert_days(int season_reup_alert_days) {
		this.season_reup_alert_days = season_reup_alert_days;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public double getBuy_price() {
		return buy_price;
	}

	public void setBuy_price(double buy_price) {
		this.buy_price = buy_price;
	}

	public double getSell_price() {
		return sell_price;
	}

	public void setSell_price(double sell_price) {
		this.sell_price = sell_price;
	}

	public String getVideo_link() {
		return video_link;
	}

	public void setVideo_link(String video_link) {
		this.video_link = video_link;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public double getLogistic_price() {
		return logistic_price;
	}

	public void setLogistic_price(double logistic_price) {
		this.logistic_price = logistic_price;
	}

	public java.util.Date getFeatured_product_date() {
		return featured_product_date;
	}

	public void setFeatured_product_date(java.util.Date featured_product_date) {
		this.featured_product_date = featured_product_date;
	}

	public java.util.Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(java.util.Date update_date) {
		this.update_date = update_date;
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	public double getPercentage_deal() {
		return percentage_deal;
	}

	public void setPercentage_deal(double percentage_deal) {
		this.percentage_deal = percentage_deal;
	}

	public java.util.Date getSeason_reup_alert_date() {
		return season_reup_alert_date;
	}

	public void setSeason_reup_alert_date(java.util.Date season_reup_alert_date) {
		this.season_reup_alert_date = season_reup_alert_date;
	}

	@Override
	public String toString() {
		return "product_id: " + product_id + ", category_id: " + category_id + ", product_name: " + product_name
				+ ", description: " + description + ", featured_product: " + featured_product + ", company_name: "
				+ company_name + ", buy_price: " + buy_price + ", sell_price: " + sell_price + ", packaging: " + packaging
				+ ", video_link: " + video_link + ", treshold_max: " + treshold_max + ", treshold_min: " + treshold_min
				+ ", weight: " + weight + ", dimension: " + dimension + ", logistic_price: " + logistic_price
				+ ", featured_product_date: " + featured_product_date + ", update_date: " + update_date + ", tarif: "
				+ tarif + ", over_stock_days: " + over_stock_days + ", percentage_deal: " + percentage_deal
				+ ", season_reup_alert_days: " + season_reup_alert_days + ", season_reup_alert_date: "
				+ season_reup_alert_date;
	}

}

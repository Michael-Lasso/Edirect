package online.edirect.connector.domain;

public class Product {
	private String product_name;
	private java.sql.Blob description;
	private String company_name;
	private double buy_price;
	private double sell_price;
	private String video_link;
	private double weight;
	private String dimension;
	private double logistic_price;
	private java.util.Date featured_product_date;
	private java.util.Date update_date;
	private double tarif;
	private double percentage_deal;
	private java.util.Date season_reup_alert_date;

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public java.sql.Blob getDescription() {
		return description;
	}

	public void setDescription(java.sql.Blob description) {
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
}

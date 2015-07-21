package com.jpmorgan.pojo;

import java.util.Date;

public class Trade {

	/*
	 * Stock.
	 */
	private Stock stock;

	/*
	 * Timestamp of the trade.
	 */
	private Date timestamp;

	/*
	 * Share quantity of trade.
	 */
	private Double sharesQuantity;

	/*
	 * Buy or sell indicator.
	 */
	private BuyOrSellEnum buyOrSellIndicator;

	/*
	 * Trade's price.
	 */
	private Double price;

	/**
	 * Default constructor.
	 */
	public Trade() {

	}

	/**
	 * Constructor with all properties.
	 * 
	 * @param stock
	 * @param timestamp
	 * @param sharesQuantity
	 * @param buyOrSellIndicator
	 * @param price
	 */
	public Trade(Stock stock, Date timestamp, Double sharesQuantity,
			BuyOrSellEnum buyOrSellIndicator, Double price) {

		this.stock = stock;
		this.timestamp = timestamp;
		this.sharesQuantity = sharesQuantity;
		this.buyOrSellIndicator = buyOrSellIndicator;
		this.price = price;
	}

	public Stock getStock() {

		return this.stock;
	}

	public void setStock(Stock stock) {

		this.stock = stock;
	}

	public Date getTimestamp() {

		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {

		this.timestamp = timestamp;
	}

	public Double getSharesQuantity() {

		return this.sharesQuantity;
	}

	public void setSharesQuantity(Double sharesQuantity) {

		this.sharesQuantity = sharesQuantity;
	}

	public BuyOrSellEnum getBuyOrSellIndicator() {

		return this.buyOrSellIndicator;
	}

	public void setBuyOrSellIndicator(BuyOrSellEnum buyOrSellIndicator) {

		this.buyOrSellIndicator = buyOrSellIndicator;
	}

	public Double getPrice() {

		return this.price;
	}

	public void setPrice(Double price) {

		this.price = price;
	}

	@Override
	public int hashCode() {

		int hash = 1;

		if (this.stock != null) {

			hash *= this.stock.hashCode();
		}

		if (this.timestamp != null) {

			hash *= this.timestamp.hashCode();
		}

		if (this.sharesQuantity != null) {

			hash *= this.sharesQuantity.hashCode();
		}

		if (this.buyOrSellIndicator != null) {

			hash *= this.buyOrSellIndicator.hashCode();
		}

		if (this.price != null) {

			hash *= this.price.hashCode();
		}

		return hash;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Trade)) {
			return false;
		}

		if (obj == this) {

			return true;
		}

		Trade trade = (Trade) obj;

		boolean equals = true;

		if (this.stock != null) {

			equals &= this.stock.equals(trade.getStock());
		}

		if (this.timestamp != null) {

			equals &= this.timestamp.equals(trade.getTimestamp());
		}

		if (this.sharesQuantity != null) {

			equals &= this.sharesQuantity.equals(trade.getSharesQuantity());
		}

		if (this.buyOrSellIndicator != null) {

			equals &= this.buyOrSellIndicator.equals(trade
					.getBuyOrSellIndicator());
		}

		if (this.price != null) {

			equals &= this.price.equals(trade.getPrice());
		}

		return equals;
	}

}

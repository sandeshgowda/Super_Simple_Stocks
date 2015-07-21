package com.jpmorgan.impl.service;

import java.util.List;

import com.jpmorgan.exception.StockCalculatorException;
import com.jpmorgan.pojo.Stock;
import com.jpmorgan.pojo.Trade;
import com.jpmorgan.service.StockCalculatorService;

public class StockCalculatorServiceImpl implements StockCalculatorService {

	public double calculateDividendYieldCommon(double tickerPrice,
			double lastDividend) {

		return lastDividend / tickerPrice;
	}

	public double calculateDividendYieldPreferred(double tickerPrice,
			double parValue, double fixedDividend) {

		return (fixedDividend * parValue) / tickerPrice;
	}

	public double calculatePeRatio(double tickerPrice, double lastDividend) {

		return tickerPrice / lastDividend;
	}

	public double calculateGeometricMean(double... tradesPrices) {

		if (tradesPrices == null
				|| (tradesPrices != null && tradesPrices.length == 0)) {

			return 0d;
		}

		double geometricMean = tradesPrices[0];

		for (int i = 1; i < tradesPrices.length; i++) {

			geometricMean *= tradesPrices[i];
		}

		Integer n = new Integer(tradesPrices.length);

		return Math.pow(geometricMean, 1.0d / n.doubleValue());
	}

	public double calculateStockPrice(double[] tradesPrices,
			double[] tradesQuantities) throws StockCalculatorException {

		if (tradesPrices == null
				|| (tradesPrices != null && tradesPrices.length == 0)) {

			return 0d;
		}

		if (tradesQuantities == null) {

			throw new StockCalculatorException(
					"trades quantities array is null !");
		}

		if (tradesPrices.length != tradesQuantities.length) {

			throw new StockCalculatorException(
					"trades prices and quantities arrays are not the same length !");
		}

		double pricesPerQuantities = 0d;
		double quantities = 0d;

		for (int i = 1; i < tradesPrices.length; i++) {

			pricesPerQuantities += tradesPrices[i] * tradesQuantities[i];

			quantities += tradesQuantities[i];
		}

		return pricesPerQuantities / quantities;
	}

	public double calculateStockPrice(List<Trade> trades)
			throws StockCalculatorException {

		if (trades == null) {

			return 0d;
		}

		double[] tradesPrices = new double[trades.size()];
		double[] tradesQuantities = new double[trades.size()];

		int i = 0;
		for (Trade trade : trades) {

			tradesPrices[i] = trade.getPrice();
			tradesQuantities[i] = trade.getSharesQuantity();

			i++;
		}

		return calculateStockPrice(tradesPrices, tradesQuantities);
	}

	public double calculateSharesIndexes(List<Stock> stocks) {

		double[] tradesPrices = new double[stocks.size()];

		double totalParValues = 0d;

		int i = 0;
		for (Stock stock : stocks) {

			totalParValues += stock.getParValue();

			tradesPrices[i] = stock.getPrice();

			i++;
		}

		double geometricMean = calculateGeometricMean(tradesPrices);

		return geometricMean / totalParValues;
	}

	public double calculateGeometricMean(List<Stock> stocks) {

		double[] tradesPrices = new double[stocks.size()];

		double totalParValues = 0d;

		int i = 0;
		for (Stock stock : stocks) {

			totalParValues += stock.getParValue();

			tradesPrices[i] = stock.getPrice();

			i++;
		}

		double geometricMean = calculateGeometricMean(tradesPrices);

		return geometricMean / totalParValues;
	}

}

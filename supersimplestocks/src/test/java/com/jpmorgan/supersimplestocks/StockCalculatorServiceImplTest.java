package com.jpmorgan.supersimplestocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jpmorgan.exception.StockCalculatorException;
import com.jpmorgan.impl.service.StockCalculatorServiceImpl;
import com.jpmorgan.pojo.BuyOrSellEnum;
import com.jpmorgan.pojo.Stock;
import com.jpmorgan.pojo.StockTypeEnum;
import com.jpmorgan.pojo.Trade;
import com.jpmorgan.service.StockCalculatorService;

public class StockCalculatorServiceImplTest {
	private StockCalculatorService stockCalculatorService = new StockCalculatorServiceImpl();

	/**
	 * Test method for @see
	 * StockCalculatorServiceImpl.calculateDividendYieldCommon(double, double)
	 */
	@Test
	public void testCalculateDividendYieldCommon() {
		Assert.assertEquals(0.06d, this.stockCalculatorService
				.calculateDividendYieldCommon(25d, 1.5d), 0d);

		Assert.assertEquals(0d, this.stockCalculatorService
				.calculateDividendYieldCommon(25d, 0d), 0d);

		double result = this.stockCalculatorService
				.calculateDividendYieldCommon(0d, 1.5d);

		Assert.assertTrue(result == Double.POSITIVE_INFINITY
				|| result == Double.NEGATIVE_INFINITY);
	}

	/**
	 * Test method for @see
	 * StockCalculatorServiceImpl.calculateDividendYieldPreferred(double,
	 * double, double)
	 */
	@Test
	public void testCalculateDividendYieldPreferred() {
		Assert.assertEquals(0.4d, this.stockCalculatorService
				.calculateDividendYieldPreferred(25d, 20d, 0.5d), 0d);

		Assert.assertEquals(0d, this.stockCalculatorService
				.calculateDividendYieldPreferred(25d, 0d, 0.5d), 0d);

		Assert.assertEquals(0d, this.stockCalculatorService
				.calculateDividendYieldPreferred(25d, 20d, 0d), 0d);

		double result = this.stockCalculatorService
				.calculateDividendYieldPreferred(0d, 20d, 0.5d);

		Assert.assertTrue(result == Double.POSITIVE_INFINITY
				|| result == Double.NEGATIVE_INFINITY);
	}

	/**
	 * Test method for @see StockCalculatorServiceImpl.calculatePeRatio(double,
	 * double)
	 */
	@Test
	public void testCalculatePeRatio() {
		Assert.assertEquals(22.05128205128205d,
				this.stockCalculatorService.calculatePeRatio(43d, 1.95d), 0d);

		Assert.assertEquals(0d,
				this.stockCalculatorService.calculatePeRatio(0d, 1.95d), 0d);

		double result = this.stockCalculatorService.calculatePeRatio(43d, 0d);

		Assert.assertTrue(result == Double.POSITIVE_INFINITY
				|| result == Double.NEGATIVE_INFINITY);
	}

	/**
	 * Test method for @see
	 * StockCalculatorServiceImpl.calculateGeometricMean(double...)
	 */
	@Test
	public void testCalculateGeometricMean() {
		Assert.assertEquals(0d,
				this.stockCalculatorService.calculateGeometricMean(), 0d);

		Assert.assertEquals(0d,
				this.stockCalculatorService.calculateGeometricMean(0d), 0d);

		Assert.assertEquals(23.321576831999096, this.stockCalculatorService
				.calculateGeometricMean(43d, 1.95d, 56d, 63d), 0d);

		Assert.assertEquals(0d,
				this.stockCalculatorService.calculateGeometricMean(0d, 1.95d),
				0d);
	}

	/**
	 * Test method for @see
	 * StockCalculatorServiceImpl.calculateStockPrice(double, double)
	 */
	@Test
	public void testCalculateStockPrice() throws StockCalculatorException {

		Assert.assertEquals(0d,
				this.stockCalculatorService.calculateStockPrice(null, null), 0d);

		try {

			this.stockCalculatorService.calculateStockPrice(new double[] { 24d,
					13d, 2.5d }, null);

			Assert.fail("A StockCalculatorException must have been thrown");

		} catch (StockCalculatorException sce) {
		}

		try {

			this.stockCalculatorService.calculateStockPrice(new double[] { 24d,
					13d, 2.5d }, new double[] { 4d, 8d, 10d, 12d });

			Assert.fail("A StockCalculatorException must have been thrown");

		} catch (StockCalculatorException sce) {
		}

		Assert.assertEquals(
				7.166666666666667d,
				this.stockCalculatorService.calculateStockPrice(new double[] {
						24d, 13d, 2.5d }, new double[] { 4d, 8d, 10d }), 0d);
	}

	/**
	 * Test of @see StockCalculatorServiceImpl.calculateStockPrice(List<Trade>)
	 */
	@Test
	public void testCalculateStockPriceByTradeList()
			throws StockCalculatorException {

		Stock tea = new Stock("TEA", StockTypeEnum.COMMON, 0d, null, 100d, 110d);

		Trade trade1 = new Trade(tea, new Date(), 1000d, BuyOrSellEnum.BUY,
				110d);
		Trade trade2 = new Trade(tea, new Date(), 300d, BuyOrSellEnum.SELL,
				102d);

		List<Trade> trades = new ArrayList<Trade>();
		trades.add(trade1);
		trades.add(trade2);

		Assert.assertEquals(102.0,
				stockCalculatorService.calculateStockPrice(trades), 0d);
	}

	/**
	 * Test of @see
	 * StockCalculatorServiceImpl.calculateSharesIndexes(List<Stock>)
	 */
	@Test
	public void testCalculateSharesIndexes() {

		Stock tea = new Stock("TEA", StockTypeEnum.COMMON, 0d, null, 100d, 110d);
		Stock pop = new Stock("POP", StockTypeEnum.COMMON, 8d, null, 100d, 120d);
		Stock ale = new Stock("ALE", StockTypeEnum.COMMON, 23d, null, 60d, 55d);
		Stock gin = new Stock("GIN", StockTypeEnum.PREFERRED, 8d, 2d, 100d,
				100d);
		Stock joe = new Stock("JOE", StockTypeEnum.COMMON, 13d, null, 250d,
				216.12d);

		List<Stock> stocks = new ArrayList<Stock>();
		stocks.add(tea);
		stocks.add(pop);
		stocks.add(ale);
		stocks.add(gin);
		stocks.add(joe);

		Assert.assertEquals(0.17938927757244394d,
				stockCalculatorService.calculateSharesIndexes(stocks), 0d);
	}

}

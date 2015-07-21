package com.jpmorgan.exception;

/**
 * Class used to throw StockCalculator exceptions.
 */
public class StockCalculatorException extends Exception {

	static final long serialVersionUID = 4423423L;

	/**
	 * Default constructor.
	 */
	public StockCalculatorException() {
	}

	/**
	 * Constructor with error message.
	 * 
	 * @param message
	 *            the error message
	 */
	public StockCalculatorException(String message) {
		super(message);
	}

}

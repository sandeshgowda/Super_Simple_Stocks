package com.jpmorgan.pojo;



public class Stock {
	
	 /**
 	  * the stock symbol.
 	  */
   private String stockSymbol;

   /**
 	  * the stock type.
 	  */
   private StockTypeEnum stockType;
 
   /**
    * the stock last dividend.
    */
   private Double lastDividend;
 
   /**
    * the stock fixed dividend.
    */
   private Double fixedDividend;
 
   /**
    * the stock par value.
    */
   private Double parValue;
 
   /**
    * the stock price.
    */
   private Double price;
 
   /**
    * Default constructor.
    */
   public Stock() {
     
   }
 
	 /**
	  * Constructor with all properties.
	  * @param stockSymbol
	  * @param stockType
	  * @param lastDividend
	  * @param fixedDividend
	  * @param parValue
	  * @param price
	  */
   public Stock(String stockSymbol,
                    StockTypeEnum stockType,
                    Double lastDividend,
                    Double fixedDividend,
                    Double parValue,
                    Double price) {
     
       this.stockSymbol = stockSymbol;
       this.stockType = stockType;
       this.lastDividend = lastDividend;
		  this.fixedDividend = fixedDividend;
		  this.parValue = parValue;
       this.price = price;
   }
 
 
	
 	 public String getStockSymbol() {
       
       return this.stockSymbol;
   }
 
  
   public void setStockSymbol(String stockSymbol) {
     
       this.stockSymbol = stockSymbol;
   }


   
   public StockTypeEnum getStockType() {
     
       return this.stockType;
   }

 
   public void setStockType(StockTypeEnum stockType) {
     
       this.stockType = stockType;
   }
 
  
   public Double getLastDividend() {
       
       return this.lastDividend;
   }

   
   public void setLastDividend(Double lastDividend) {
     
       this.lastDividend = lastDividend;
   }

   
   public Double getFixedDividend() {
       
       return this.fixedDividend;
   }

 
   public void setFixedDividend(Double fixedDividend) {
     
       this.fixedDividend = fixedDividend;
   }
 
  
   public Double getParValue() {
       
       return this.parValue;
   }

 
   public void setParValue(Double parValue) {
     
       this.parValue = parValue;
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
     
       if (this.stockSymbol != null) {
           
           hash *= this.stockSymbol.hashCode();
       }

       if (this.price != null) {
           
           hash *= this.price.hashCode();
       }
     
       return hash;
   }

   @Override
   public boolean equals(Object obj) {
      
       if (!(obj instanceof Stock)) {
           return false;
       }

       if (obj == this) {
       
           return true;
       }
     
       Stock stock = (Stock) obj;

       boolean equals = true;
           
       if (this.stockSymbol != null) {
           
           equals &= this.stockSymbol.equals(stock.getStockSymbol());
       }

       if (this.price != null) {
           
           equals &= this.price.equals(stock.getPrice());
       }
     
       return equals;
   }

}

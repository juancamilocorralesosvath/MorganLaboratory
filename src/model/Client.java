 
 package model;
 import model.*;
 
 /** 
  *This class administrates the information of the client.
  @autor Juan Camilo Corrales Osvath
  */
 public class Client{ 
 
  private String name;
  private int id;
  private int type;
  private int totalKg;
  private int totalValuePaid;
  private String expeditionDate;
  private final static int NORMAL = 1;
  private final static int SILVER = 2;
  private final static int GOLD = 3;
  private final static int PLATINUM = 4;
  
  
 /**
	*Name: Client
	*it is the constructor method of the class, here the values of the 
	*name of the client, the id number, the date of the expedition of the 
	*merchandise number, and the type of the client, are initialized.
	@param name. the name of the client.
	@param id. the id number.
	@param expeditionDate. the date of the expedition of the merchandise number.
	@param type. the type of the client.
	*/
  public Client(String name, int id, String expeditionDate, int type){ 
  
   this.name = name;
   this.id = id;
   this.expeditionDate = expeditionDate;
   this.type = type;
   totalKg = 0;
   totalValuePaid = 0;
  } 
/**
	*Name: setName
	*setter method of the attribute name.
	@param name. the name of the client.
	*/
  public void setName(String name){ 
    this.name = name;
  }
/**
	*Name: getName
	*getter method of the attribute name.
	@return name. the name of the client.
	*/
  public String getName(){ 
    return name;
  }  
 /**
	*Name: setType
	*it calculates which type should be the client,
	*having in mind the total kg transportated and the total value paid.
	*/  
  public void setType(){ 
  
    if(35000 <= totalKg && totalKg < 55000){ 
	
	  type = SILVER;
	  
	}else if(55000 <= totalKg || (2000000 <= totalValuePaid && totalValuePaid < 5000000)){ 
	
	  type = GOLD;
	  
	}else if(5000000 <= totalValuePaid){ 
	
	  type = PLATINUM;
	}else{ 
	  type = NORMAL;
	}
  
 
  } 
  /**
	*Name: getType
	*setter method of the attribute type.
	@return type. the type of the client.
	*/
  public int getType(){ 
    return type;
  
  } 
  /**
	*Name: setId
	*setter method of the attribute id.
	@param id. the id of the client.
	*/
  public void setId(int id){

    this.id = id;	  
  
  } 
  /**
	*Name: getId
	*getter method of the attribute id.
	@return id. the id of the client.
	*/
  public int getId(){ 
  
    return id;
  }
  /**
	*Name: setExpeditionDate
	*setter method of the attribute expeditionDate.
	@param expeditionDate. the expedition date of the number of merchandise of the client.
	*/
   public void setExpeditionDate(String expeditionDate){ 
   
     this.expeditionDate = expeditionDate;
   }
   /**
	*Name: getExpeditionDate
	*getter method of the attribute expeditionDate.
	@return expeditionDate. the expedition date of the number of merchandise of the client.
	*/
   public String getExpeditionDate(){ 
   
     return expeditionDate;
   }
    /**
	*Name: calculateTotalWeight
	*calculates the total weight the client has transportated with the ship.
	@param weight. the weight of the load of the client.
	*/
   public void calculateTotalWeight(int weight){ 
   
     totalKg += weight;
   }
    /**
	*Name: calculateTotalValue
	*calculates the total value the client has paid the ship.
	@param value. the value of the load of the client.
	*/
   public void calculateTotalValue(int value){ 
     totalValuePaid += value;
   }
    /**
	*Name: getTotalWeight
	*returns the total weight transportated by the client.
	@return totalKg. the total weight transportated by the client.
	*/
   public int getTotalWeight(){ 
     return totalKg;
   }
    /**
	*Name: getTotalValue
	*returns the total value paid by the client.
	@return totalValuePaid. the total value paid by the client.
	*/
   public int getTotalValue(){ 
    return totalValuePaid;
   }
   
 
  } 
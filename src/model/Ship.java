  package model;
  
  import java.util.ArrayList;
  import model.*;
  
  /** 
  *This class administrates the information of the ship.
  @autor Juan Camilo Corrales Osvath
  */
  public class Ship{ 
  
    private final static int MAX_CAPACITY = 28000;
	private final static int MINIMUM_CAPACITY = 12000;
	private final static int CLIENTS = 5;
	private final static String NAME = "The Pirate";
	private final static String CAPTAIN = "Morgan";
	private Client[] clients;
	private ArrayList <Journey> journeys;
	
	/**
	*Name: Ship
	*it is the constructor method of the class, here the clients are initialized
	*and the ArrayList of the journeys is created.
	*/
	public Ship(){
		
    clients = new Client[CLIENTS];
	journeys = new ArrayList <Journey>();
	
	clients[0] = new Client("Vania's Secret", 1007489003, "12/12/2001", 1);
	clients[1] = new Client("Achiras Charito", 29121732, "05/11/1997", 1);
	clients[2] = new Client("McDonalds", 36121432, "06/10/2000", 1);
	clients[3] = new Client("The North Face", 79126732, "14/06/1979", 1);
	clients[4] = new Client("Microsoft", 29131742, "27/10/1935", 1);
      	  
	} 
	/**
	*Name: addJourney
	*adds a new journey to the ship, it adds a journey to 
	*the ArrayList.
	*/
	public void addJourney(){ 
	 Journey newJourney = new Journey();
	
	 journeys.add(newJourney); 
	} 
	/**
	*Name: sailIsAllowed
	*verifies the conditions needed to sail.
	*@return isAllowed. is a boolean value, true if the conditions are being respected,
	*false if not, therefore, the ship won't be able to sail.
	*/
	public boolean sailIsAllowed(){ 
	
	  boolean isAllowed = false;
	  
	  Journey currentJourney = journeys.get(journeys.size()-1);
	  
	  int currentWeight = currentJourney.getTotalWeight();
	  int currentLoads = currentJourney.howManyLoads();
	 
	  if((12000 <= currentWeight && currentWeight <= 28000) && (currentLoads >= 2 && currentJourney.journeyIsAllowed())){ 
	    isAllowed = true;
	  }
	  
	  return isAllowed;
	 
	
	} 
	
    /**
	*Name: selectClient
	*selects a client from the array of clients of the ship.
	@param option. the option that the user has to enter.
	*@return the selected client.
	*/
  public Client selectClient(int option){ 
	  return clients[option-1];
	}
	/**
	*Name: getJourney
	*returns the last journey added.
	*@return the journey in the final position of the ArrayList.
	*/
	public Journey getJourney(){ 
	
	  return journeys.get(journeys.size()-1);
	}
	/**
	*Name: getJourney
	*returns how many clients does the ship has.
	*@return the length of the array of clients.
	*/
	public int getHowManyClients(){
		
	  return clients.length;
	}
	

	
  }  
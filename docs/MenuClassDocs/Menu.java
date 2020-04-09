package ui;
import model.*;
import java.util.Scanner;

public class Menu{  

  private final static int ADD_LOAD = 1;
  private final static int EMPTY_SHIP = 2;
  private final static int TOTAL_WEIGHT = 3;
  private final static int IS_ALLOWED = 4;
  private final static int SHOW_INFO = 5;
  
  private Ship ship;
  
  /**
	*Name: Menu
	*it is the constructor method of the class, here an instance of 
	*Ship is created and a journey is added to the ship.
	*/
  public Menu(){ 
    ship = new Ship();
    ship.addJourney();
  }  
  /** 
  *Name: showMenu
  *Shows the user the options of the programm.
  */
  public void showMenu(){ 
    System.out.println("welcome! please select what you want to do: \n");
	System.out.println("(1) to add a new load\n");
	System.out.println("(2) to empty the loads in the ship\n");
	System.out.println("(3) to see the total weight the ship has\n");
	System.out.println("(4) to see if the ship is ready to go!\n");
	System.out.println("(5) to select a client and see his/her information\n");
	System.out.println("(6) to exit the programm\n");
	
  } 
  /**
  *Name: whichClient
  *it allows the user to select which client in the programm is going to add
  *a new cargo.
  */
  public Client whichClient(){
	  
    Scanner sc = new Scanner(System.in);
    int option = 0;
    System.out.println("which client is going to add a cargo?\n");
	showClients(); 
	 
	 option = sc.nextInt();
	 sc.nextLine();
	 
	 return ship.selectClient(option);
  
  } 
   /**
  *Name: addLoad
  *this method enters the information of the load that the client will send.
  */
  public void addLoad(){ 
    Scanner sc = new Scanner(System.in);
    int boxes;
	int weightPerBox;
	int typeOfLoad;
    Client client = whichClient();	
	
    System.out.println("how many boxes?\n");
	boxes = sc.nextInt();
	sc.nextLine();
	
	System.out.println("which would be the weight of each box?(Kg)\n");
	weightPerBox = sc.nextInt();
	sc.nextLine();
	
	System.out.println("which is the type of this load?\n");
	System.out.println("(1) PERISHABLE");
	System.out.println("(2) NON_PERISHABLE");
	System.out.println("(3) HAZARDOUS");
	typeOfLoad = sc.nextInt();
	sc.nextLine();
	
	int currentWeight = ship.getJourney().getTotalWeight();
	
    if((currentWeight + (weightPerBox * boxes)) <= 28000){
	
	ship.getJourney().addLoad(boxes, weightPerBox, typeOfLoad, client);
	
	
	ship.getJourney().getLoad().setTypeOfLoad();
	ship.getJourney().getLoad().calculateKgQuantity();
	ship.getJourney().getLoad().calculateValueOfLoad();
    ship.getJourney().getLoad().weightClient();
	ship.getJourney().getLoad().valueClient(); 
	client.setType();
						   
	int valueTopay = ship.getJourney().getLoad().getValueOfLoad();
	String nameClient = client.getName();
	
	System.out.println("load has been succesfully added!");
	System.out.println("this is the information of the new load: \n");
	System.out.println("client: "+nameClient);
	System.out.println("value of transportating the cargo with us: "+valueTopay);
	System.out.println("thank you for trusting in us!\n");
	
	ship.getJourney().restoreTotalValue();
	ship.getJourney().restoreTotalWeight();
	
	ship.getJourney().calculateTotalWeight();
    ship.getJourney().calculateTotalValue();
	
	
	
	}else{ 
	  System.out.println("we are so sorry, but we don't have enough space to send your cargo,");
	  System.out.println("we promess we will send it on the next journey!\n");
	}
	
	
  } 
   /**
  *Name: readOption
  *receives an option entered by the user.
  *@return the option of the user.
  */
  public int readOption(){ 
   Scanner sc = new Scanner(System.in);
   int choice = sc.nextInt();
   sc.nextLine();

   return choice;   
 } 
  /**
  *Name: doOperation
  *according to the option entered by the user, and by calling other methods,
  *this method is in charge of adding a new load, 
  *empty the loads in the ship, show the user the total weight of the ship,
  *show if the journey is allowed, and show the information of the selected client.
  @param choice is the option/choice entered by the user.
  */
 public void doOperation(int choice){ 
 Scanner sc = new Scanner(System.in);
 
   switch (choice) { 
   
     case ADD_LOAD:             
	          
					addLoad();
	                break;
		
	case EMPTY_SHIP: 
                        ship.getJourney().clearLoads();
					  	ship.addJourney(); 
					  
	                  System.out.println("the ship has been cleared succesfully!\n");
	                   break;
		
	case TOTAL_WEIGHT: 
	
	                   int totalWeight = ship.getJourney().getTotalWeight();
					   System.out.println("the total weight of the ship is: "+ totalWeight+" kg.");
					   int value = ship.getJourney().getTotalValue();
					   System.out.println("the total value the ship has is: "+ value+"\n");
					   
					   
					

        break;

    case IS_ALLOWED:  
	                 boolean yesno = ship.sailIsAllowed();
					 
					 if(yesno){ 
					   System.out.println("ship is able to sail!\n");
					   
					 }else{ 
					   System.out.println("ups! seems like the ship encountered a problem, it won't be able to sail!\n");
					 }

        break; 
		
		case SHOW_INFO: 
		
		               System.out.println("select the client to see the information: \n");
					   showClients();
					   int option = sc.nextInt();
					   sc.nextLine();
					   Client client1 = ship.selectClient(option);
					   
					   System.out.println("the information is: \n");
					   String name1 = client1.getName();
					   int id1 = client1.getId();
					   String expeditionDate1 = client1.getExpeditionDate();
					   int type1 = client1.getType();
					   int totalValue1 = client1.getTotalValue();
					   int totalWeight1 = client1.getTotalWeight();
					   
					   System.out.println("name: "+name1);
					   System.out.println("id: "+id1);
					   System.out.println("expedition Date: "+ expeditionDate1);
					   System.out.println("type: "+ type1);
					   System.out.println("total value paid: "+totalValue1);
					   System.out.println("kg transportated: "+ totalWeight1+"\n");

    case 6: 
  
        break; 
   
    default: 
	
	  System.out.println("sorry, that's not a valid option\n");
   
   } 
   
 }
   /**
  *Name: startProgramm
  *this method calls the main methods so the programm 
  *can execute.
  */
   public void startProgramm(){ 
     int option;
	do { 
	 
	 showMenu();
	 
	 option = readOption();
	 
	 doOperation(option); 
	 
	 }while(option != 6); 
	 
	 if(option == 6){ 
	  System.out.println("thank you for using our programm, don't forget that we are the best \n option when it comes down to send your cargos through the ocean! \n we will be waiting for you!");
	 }
   }

  /**
  *Name: showClients
  *shows the clients that the ship has.
  */
   public void showClients(){ 
	
	for(int i = 0; i < ship.getHowManyClients(); i++){ 
	  System.out.println("("+(i+1)+")"+ ship.selectClient(i+1).getName());
	  
	} 
 }
 
}





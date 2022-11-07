/*
 * This is the Customer were the object Customer and variables is created, I created
 * the setter and getter plus an extra method that prints the info.
 * 
 */
public  class Customers{
  private int id;
  private String name;
  private String last;
  private String username;
  private String password;
  private double moneyAvailable;
  private boolean membership;
  private int ticketPerson = 6;
  
  //This method initializes the variables
  public Customers(){
    id = 0;
    name = "";
    last = "";
    username = "";
    password = "";
    moneyAvailable = 0;
    membership = false; 
    ticketPerson = 0;
  }
  //this method creates the object based on the parameters
  public Customers(int a, String b, String c, String d, String e, double f, boolean g,int h){
    id = a;
    name = b;
    last = c;
    username = d;
    password = e;
    moneyAvailable = f;
    membership = g;
    ticketPerson = h;
    
  }
  //This method gets the ID from the Customer
  public int getID(){
    return this.id; 
  }
  //This method gets the Name from the Customer  
  public String getName(){
    return this.name; 
  }
  //This method gets the Last name from the Customer
  public String getLast(){
    return this.last; 
  }
  //This method gets the username from the Customer
  public String getUsername(){
    return this.username; 
  }
  //This method gets the password from the Customer
  public String getPassword(){
    return this.password;
  }
  //This method gets the money available from the Customer
  public double getMoneyAvailable(){
    return this.moneyAvailable; 
  }
  //This method gets a boolean if the customer is a member or not
  public boolean getMembership(){
    return this.membership; 
  }
  //This method gets the ticket for a specific person 
  public int getTicketPerson(){
   return this.ticketPerson; 
  }
  //This method sets the ID for a customer
  public void setID(int newID){
    this.id = newID; 
  }
  //This method sets the name for a customer
  public void setName(String newName){
    this.name = newName; 
  }
  //This method sets the last name for a customer
  public void setLast(String newLast){
    this.last = newLast; 
  }
  //This method sets the username for a customer
  public void setUsername(String newUsername){
    this.username = newUsername; 
  }
  //This method sets the money available for a customer
  public void setMoneyAvailable(double newMoneyAvailable){
    this.moneyAvailable = newMoneyAvailable; 
  }
  //This method sets the membership for a customer
  public void setMembership(boolean newMembership){
    this.membership = newMembership; 
  } 
  //This method sets the ticket for a customer
  public void serTicketPerson(int newTicket){
   this.ticketPerson = newTicket; 
  }
  //This method prints the info that has the object
   public void printInfo(){
       System.out.println("Name: "+getName()+'\n'+"Last Name: "+getLast()+'\n'+"Username: "+getUsername()+'\n'+"Money Available: "+
         +getMoneyAvailable()+'\n'+"Are you a Member: "+getMembership());
       System.out.println();
     }
}



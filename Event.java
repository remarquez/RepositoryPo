/*
 * This is the Event were the object Event and variables is created, I created
 * the setter and getter plus an extra method that prints the info.
 * 
 */
public class Event extends RunTicketMiner{
  private int id;
  private String type;
  private String name;
  private String date;
  private String time;
  private double vipPrice;
  private double goldPrice;
  private double silverPrice;
  private double broncePrice;
  private double generalAdmissionPrice;
  //This method initializes the variables 
  public Event(){
    id = 0;
    type = "";
    name = "";
    date = "";
    time = "";
    vipPrice = 0;
    goldPrice = 0;
    silverPrice = 0;
    broncePrice = 0;
    generalAdmissionPrice = 0;    
  }
  //this method creates the object based on the parameters
  public Event(int a, String b, String c, String d, String e, double f, double g, double h, double i,double j){
    id = a;
    type = b;
    name = c;
    date = d;
    time = e;
    vipPrice = f;
    goldPrice = g;
    silverPrice = h;
    broncePrice = i;
    generalAdmissionPrice = j;  
  
  }
  //This method gets the ID from the event
  public int getID(){
   return this.id; 
  }
  //This method gets the type from the event
  public String getType(){
   return this.type; 
  }
  //This method gets the name from the event
  public String getName(){
   return this.name; 
  }
  //This method gets the date from the event
  public String getDate(){
   return this.date; 
  }
  //This method gets the time from the event
  public String getTime(){
   return this.time; 
  }
  //This method gets the vip price from the event
  public double getVipPrice(){
   return this.vipPrice; 
  }
  //This method gets the gold price from the event
  public double getGoldPrice(){
   return this.goldPrice; 
  }
  //This method gets the silver price from the event
  public double getSilverPrice(){
   return this.silverPrice; 
  }
  //This method gets the bronze price from the event
  public double getBronzePrice(){
   return this.broncePrice; 
  }
  //This method gets the general admission from the event
  public double getGeneralAdmissionPrice(){
   return this.generalAdmissionPrice; 
  } 
  //This method sets the ID for the event
  public void setID(int newID){
   this.id = newID; 
  }
  //This method sets the type for the event
  public void setType(String newType){
   this.type = newType; 
  }
  //This method sets the date for the event
  public void setDate(String newDate){
   this.date = newDate; 
  }
  //This method sets the time for the event
  public void setTime(String newTime){
   this.time = newTime; 
  }
  //This method sets the vip price for the event
  public void setVipPrice(double newVipPrice){
   this.vipPrice = newVipPrice; 
  }
  //This method sets the gold price for the event
  public void setGoldPrice(double newGoldPrice){
   this.goldPrice = newGoldPrice; 
  }
  //This method sets the silver price for the event
  public void setSilverPrice(double newSilverPrice){
   this.silverPrice = newSilverPrice; 
  }
  //This method sets the bronze price for the event
  public void setBroncePrice(double newBroncePrice){
   this.broncePrice = newBroncePrice; 
  }
  //This method sets the general admission for the event
  public void setGeneralAdmissionPrice(double newGeneralAdmissionPrice){
   this.generalAdmissionPrice = newGeneralAdmissionPrice; 
  }
  //This method prints the info based on the parameter of the object
  public  String toString(){
    return "Event ID: "+getID()+'\n'+"Name: "+getName()+'\n'+"Date: "+getDate()+'\n'+"Time: "+getTime()+'\n'+"Event Type: "+getType()+'\n'+
                      '\n';
     }
  //This method prints only the information necessary to create the ticket for the customer
  public void printTicketInfo(){
    System.out.println("Event ID: "+getID()+'\n'+"Name: "+getName()+'\n'+"Event Type: "+getType()+'\n'+"VIP Seats Price: "+getVipPrice()+'\n'+"Gold Seats Price: "+getGoldPrice()+'\n'+"Silver Seats Price: "+getSilverPrice()+'\n'+
                       "Bronze Seats: "+getBronzePrice()+'\n'+"General Adm Seats: "+getGeneralAdmissionPrice()+'\n');

  }
  }
  
  

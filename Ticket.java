/*
 * This is the Ticket class object Ticket is created, I created
 * the setter and getter
 * 
 */
public class Ticket extends Event{
  
  private int quantityTickets;
  private double totalPrice;
  private String confirmationNumber;


  private int seatsSold;
  private int vipSeatsSold ;
  private int goldSeatsSold ;
  private int silverSeatsSold ;
  private int bronzeSeatsSold ;
  private int genAdmSeatsSold ;
  private double vipTicketsSold ;
  private double goldTicketsSold ;
  private double silverTicketsSold ;
  private double bronzeTicketsSold ;
  private double genAdmTicketsSold;
  private double totalRevenue;
  private double expectedProfit;
  private double netProfit;
  

  //this method creates the object based on the parameters
   public Ticket(int a, double b, String c){
    quantityTickets = a;
    totalPrice = b;
    confirmationNumber = c;
  }
     // This method initializes the variables
  public Ticket(double b,String c){
    quantityTickets = 1000;
    totalPrice = b;
    confirmationNumber = c;
  }
  //This method gets the quantity of tickets that are available 
  public int getQuantityTickets(){
    return this.quantityTickets; 
  }
  //This method gets the total price of the ticke
  public double getTotalPrice(){
    return this.totalPrice; 
  }
  //This method gets the confirmation number
  public String getConfirmationNumber(){
    return this.confirmationNumber; 
  }
  public int getSeatsSold() {
    return seatsSold;
  }
  public int getVipSeatsSold() {
    return vipSeatsSold;
  }

  public void setVipSeatsSold(int vipSeatsSold) {
    this.vipSeatsSold = vipSeatsSold;
  }

  public int getGoldSeatsSold() {
    return goldSeatsSold;
  }

  public void setGoldSeatsSold(int goldSeatsSold) {
    this.goldSeatsSold = goldSeatsSold;
  }

  public int getSilverSeatsSold() {
    return silverSeatsSold;
  }

  public void setSilverSeatsSold(int silverSeatsSold) {
    this.silverSeatsSold = silverSeatsSold;
  }

  public int getBronzeSeatsSold() {
    return bronzeSeatsSold;
  }

  public void setBronzeSeatsSold(int bronzeSeatsSold) {
    this.bronzeSeatsSold = bronzeSeatsSold;
  }

  public int getGenAdmSeatsSold() {
    return genAdmSeatsSold;
  }

  public void setGenAdmSeatsSold(int genAdmSeatsSold) {
    this.genAdmSeatsSold = genAdmSeatsSold;
  }

  public double getVipTicketsSold() {
    return vipTicketsSold;
  }

  public void setVipTicketsSold(double vipTicketsSold) {
    this.vipTicketsSold = vipTicketsSold;
  }

  public double getGoldTicketsSold() {
    return goldTicketsSold;
  }

  public void setGoldTicketsSold(double goldTicketsSold) {
    this.goldTicketsSold = goldTicketsSold;
  }

  public double getSilverTicketsSold() {
    return silverTicketsSold;
  }

  public void setSilverTicketsSold(double silverTicketsSold) {
    this.silverTicketsSold = silverTicketsSold;
  }

  public double getBronzeTicketsSold() {
    return bronzeTicketsSold;
  }

  public void setBronzeTicketsSold(double bronzeTicketsSold) {
    this.bronzeTicketsSold = bronzeTicketsSold;
  }

  public double getGenAdmTicketsSold() {
    return genAdmTicketsSold;
  }

  public void setGenAdmTicketsSold(double genAdmTicketsSold) {
    this.genAdmTicketsSold = genAdmTicketsSold;
  }

  public double getTotalRevenue() {
    return totalRevenue;
  }

  public void setTotalRevenue(double totalRevenue) {
    this.totalRevenue = totalRevenue;
  }

  public double getExpectedProfit() {
    return expectedProfit;
  }

  public void setExpectedProfit(double expectedProfit) {
    this.expectedProfit = expectedProfit;
  }

  public double getNetProfit() {
    return netProfit;
  }

  public void setNetProfit(double netProfit) {
    this.netProfit = netProfit;
  }

  //This method sets the quantity of tickets
  public void setQuantityTickets(int newQuantityTickets){
    this.quantityTickets = newQuantityTickets; 
  }
  //This method sets the confirmation number
  public void setConfirmationNumber(String newConfirmationNumber){
    this.confirmationNumber = newConfirmationNumber; 
  }
  //This method sets the total price of the ticket
  public void setTotalPrice(double newTotalPrice){
    this.totalPrice = newTotalPrice; 
  }

  public void setSeatsSold(int seatsSold) {
    this.seatsSold = seatsSold;
  }

   public void  printTicketInfo() {
       System.out.println("Quantity tickets: " + getQuantityTickets() + '\n' + "Total Price: " + getTotalPrice() + '\n' + "Confirmation Number: " + getConfirmationNumber());
   }
   public String toString(){
    return super.toString()+"Total Seats sold: "+seatsSold+'\n'+"Total VIP Seats sold: "+vipSeatsSold+'\n'+"Total Gold Seats sold: "+goldSeatsSold+'\n'+"Total Silver Seats sold: "+silverSeatsSold+'\n'+
                                      "Total Bronze Seats sold: "+bronzeSeatsSold+'\n'+"Total General Adm Seats sold: "+genAdmSeatsSold+'\n'+"Total revenue for VIP tickets: $"+vipTicketsSold+'\n'+
                                      "Total revenue for Gold tickets: $"+goldTicketsSold+'\n'+"Total revenue for Silver tickets: $"+silverTicketsSold+'\n'+"Total revenue for Bronze tickets: $"+bronzeTicketsSold+'\n'+
                                      "Total revenue for General Admission tickets: $"+genAdmTicketsSold+'\n'+"Total revenue for all tickets: $"+totalRevenue+'\n'+"Expected Profit: $"+expectedProfit+'\n'+
                                      "Actual profit: $"+netProfit+'\n';
   }
 
}

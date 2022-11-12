/*
 * This is the main class were the user interacts with the program, I created
 * method to set things by sections to keep the main mostly for the interaction with the user.
 *
 */
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.lang.*;

public class RunTicketMiner{
  public static void main(String []args)throws IOException {
    try {
      boolean flag = true;
      boolean temp = true;
      double texasSalesTax = 1.0825;
      double membershipDiscount = .10;
      double tempTotal = 0;
      double totalTemp = 0;
      double customerTotalTemp = 0;
      int temp1 = 0;

      String exit = "";
      int eventCounter = eventNumber();
      Customers customer[] = customerGenerator();
      Ticket t[] = new Ticket[eventCounter];
      Venue v[] = venueGenerator();
      Scanner input = new Scanner(System.in);
      Event p[] = eventGenerator(eventCounter, 0, 0);
      while (!exit.equals("EXIT")) {
        System.out.println("Hello! Welcome to the Ticket Miner" + '\n' + "Is this an individual purchase (Y/N)");
        char answer1 = input.next().charAt(0);
        char answer = Character.toLowerCase(answer1);
        input.nextLine();
        if (answer == 'y') {
          System.out.println("Enter you first name");
          String name = input.nextLine();
          System.out.println("Enter your Last Name");
          String lastName = input.nextLine();
          System.out.println("Press l to login or c to conitnue as a guest");
          char c = input.next().charAt(0);
          c = Character.toLowerCase(c);
          input.nextLine();
          if (c == 'l') {
            while (flag == true) {
              System.out.println("Enter your Username");
              String username = input.nextLine();
              System.out.println("Enter your Password");
              String password = input.nextLine();
              boolean log = logIn(customer, username, password);
              int customerID = logInID(customer, username, password);
              if (log == true) {
                System.out.println("Welcome "+customer[customerID].getName()+" "+ customer[customerID].getLast()+'\n');
                while (true) {
                  System.out.println("if you want to see all the events enter [all] if you want to search an event enter [search]");
                  String adminSearch = input.nextLine().toLowerCase();
                  while (true) {
                    if (adminSearch.equals("search")) {
                      System.out.println("Enter the A to inquire the event by ID of the event or B to inquire by the name");
                      String adminInquire = input.nextLine().toLowerCase();
                      if (adminInquire.equals("a")) {
                        System.out.println("Please enter the ID");
                         temp1 = input.nextInt();
                        input.nextLine();
                        printCustomerInquire(p, temp1, "");
                      }
                      if (adminInquire.equals("b")) {
                        System.out.println("Please enter the Name");
                        String eventName = input.nextLine();
                        printCustomerInquire(p, 0, eventName);
                      }
                    } else if (adminSearch.equals("all")) {
                      for (int f = 0; f < p.length; f++) {
                        p[f].printTicketInfo();
                      }
                    }
                    System.out.println("Would you like to see another event? Enter [y] to continue or [n] to exit ");
                    String eventAnswer = input.nextLine().toLowerCase();
                    if (!eventAnswer.equals("y")) {
                      break;
                    } else if (adminSearch.equals("all")) {
                      for (int f = 0; f < p.length; f++) {
                        p[f].printTicketInfo();
                      }
                    }
                  }
                  System.out.println("Which Event would you like to buy tickets for" + '\n' + "Please Enter the ID");
                  int ticket = input.nextInt();
                  input.nextLine();
                  System.out.println("Please enter the seat you would like to purchase: [VIP,Gold,Silver,Bronzer or General]");
                  String seat = input.nextLine().toLowerCase();
                  System.out.println("How many tickets are you buying (from 2 to 7 only)");
                  int ticketsBought = input.nextInt();
                  input.nextLine();
                  if (ticketsBought > 1 && ticketsBought <= 7) {
                    for (int i = 0; i < ticketsBought; i++) {
                      t[i] = new Ticket(printById(p, ticket, seat), confirmationNumberMethod());
                      t[i].setQuantityTickets(t[i].getQuantityTickets() - i);
                      totalTemp += printById(p, ticket, seat);
                      if(totalTemp <= customer[customerID].getMoneyAvailable()) {
                        t[i].printTicketInfo();
                        customerTotalTemp -= totalTemp;
                        customer[customerID].setMoneyAvailable(customer[customerID].getMoneyAvailable()- customerTotalTemp);
                      }else{
                        System.out.println("You dont have enough money"+'\n');
                      }
                      temp = false;
                    }
                    if(customer[customerID].getMembership() == true){
                      tempTotal = totalTemp*membershipDiscount;
                      customer[customerID].setTotalMembershipSaved(tempTotal);
                      p[temp1].setTotalAmountDiscounted(tempTotal);
                      totalTemp = totalTemp - tempTotal;
                      totalTemp = totalTemp*texasSalesTax;
                      System.out.println("Your Total is: " + totalTemp + '\n');
                      System.out.println("Your new balance is: " + customer[customerID].getMoneyAvailable() + '\n' + "Thanks for buying a ticket" + '\n');

                    }else {
                      totalTemp = totalTemp * texasSalesTax;
                      System.out.println("Your Total is: " + totalTemp + '\n');
                      System.out.println("Your new balance is: " + customer[customerID].getMoneyAvailable() + '\n' + "Thanks for buying a ticket" + '\n');
                    }
                    break;
                  } else {
                    System.out.println("You can only buy 7 tickets max");
                  }

                }
              } else {
                System.out.println("Sorry the username of password was incorrect please try again" + '\n');
              }
              flag = false;
            }
            }
          //GUEST SECTION
          else if (c == 'c') {
            System.out.println("You are continuing as a guest" + '\n');
            System.out.println("If you want to see all the events enter [all] if you want to search an event enter [search]");
            String adminSearch = input.nextLine().toLowerCase();
            while (true) {
              if (adminSearch.equals("search")) {
                System.out.println("Enter the A to inquiere the event by ID of the event or B to inquire by the name");
                String adminInquire = input.nextLine().toLowerCase();
                if (adminInquire.equals("a")) {
                  System.out.println("Please enter the ID");
                  temp1 = input.nextInt();
                  input.nextLine();
                  printCustomerInquire(p, temp1, "");
                }
                if (adminInquire.equals("b")) {
                  System.out.println("Please enter the Name");
                  String eventName = input.nextLine();
                  printCustomerInquire(p, 0, name);
                }
              }
              else if (adminSearch.equals("all")) {
                for (int f = 0; f < p.length; f++) {
                  p[f].printTicketInfo();
                }
              }
              System.out.println("Would you like to see another event? Enter [y] to continue or [n] to exit ");
              String eventAnswer = input.nextLine().toLowerCase();
              if (!eventAnswer.equals("y")) {
                break;
              }
              else if (adminSearch.equals("all")) {
                for (int f = 0; f < p.length; f++) {
                  p[f].printTicketInfo();
                }
              }
            }
              System.out.println("Which Event would you like to buy tickets for" + '\n' + "Please Enter the ID");
              int ticket = input.nextInt();
              input.nextLine();
              System.out.println("Please enter the seat you would like to purchase: [VIP,Gold,Silver,Bronzer or General]");
              String seat = input.nextLine().toLowerCase();
              while(temp != false) {
                System.out.println("How many tickets are you buying (from 2 to 7 only)");
                int ticketsBought = input.nextInt();
                if (ticketsBought > 1 && ticketsBought <= 7) {
                  for (int i = 0; i < ticketsBought; i++){
                    t[i] = new Ticket(printById(p, ticket, seat),confirmationNumberMethod());

                    t[i].setQuantityTickets(t[i].getQuantityTickets()-i);
                    t[i].printTicketInfo();
                    temp = false;
                  }
                  System.out.println("Thank you for purchasing your ticket"+'\n');
                } else {
                  System.out.println("You can only buy 7 tickets max"+'\n');
                }
              }

            }
          }
          // ADMINISTRATOR SECTION
          if (answer == 'n') {
            System.out.println("You are accesing as an administrator" + '\n');
            System.out.println("if you want to see all the events enter [all] if you want to search an event enter [search] or create and event enter [create]");
            String adminSearch = input.nextLine().toLowerCase();
            if (adminSearch.equals("search")) {
              System.out.println("Enter the A to inquiere the event by ID of the event or B to inquire by the name");
              String adminInquire = input.nextLine().toLowerCase();
              if (adminInquire.equals("a")) {
                System.out.println("Please enter the ID");
                temp1 = input.nextInt();
                input.nextLine();
                if (t[0] != null) {
                  printAdminInquire(t, temp1, "");
                } else {
                  System.out.println("No tickets bought yet" + '\n');
                }
              } else if (adminInquire.equals("b")) {
                System.out.println("Please enter the Name");
                String nameAdmin = input.nextLine();
                if (t[0] != null) {
                  printAdminInquire(t, 0, nameAdmin);
                } else {
                  System.out.println("No tickets bought yet" + '\n');
                }
              }
            } else if (adminSearch.equals("all")) {
              if (t[0] != null) {
                for (int f = 0; f < t.length; f++) {
                  System.out.println(t[f].toString());
                }
              } else {
                System.out.println("No tickets bought yet" + '\n');
              }
            } else if(adminSearch.equals("create")){
                    createEvent(p,eventCounter,v);
            }else {
              System.out.println("Invalid input please try again" + '\n');
            }
          }
          System.out.println("If you want to exit please enter EXIT otherwise enter any letter");
          exit = input.nextLine().toUpperCase();


        }
      //excelWriter(p);
    }catch(FileNotFoundException file){
      System.out.println(file);
    }
  }
  /*
   *This method is where the user logs in by checking the customers username and password
   * the parameters are the object of customers the string of the usernma and a string for
   * the password
   * it returns a boolean confirming if its true or not
   *
   */
 /* public static void excelWriter(Event e[]){
    BufferedWriter writer = Files.newBufferedWriter(Paths.get("UpdatedEvent.csv"));
    writer.write("ID,First Name,Last Name,Username,Password,Money Available,TicketMiner Membership,Concerts Purchased");
    writer.newLine();
    for(int i; i < e.length;i++){
      writer.write(String.join(",",e[i]));
      writer.newLine();
    }
    writer.close();
  }*/
  public static Event[] createEvent(Event[] p,int a,Venue[] v){
    int newCount = a+1;
    int i = 0;
    double vipPrice = 0;
    double goldPrice = 0;
    double silverPrice = 0;
    double broncePrice = 0;
    double generalPrice = 0;
    Scanner input = new Scanner(System.in);
    System.out.println("Enter event name");
    String eventName = input.nextLine();
    System.out.println("Enter date [MM/DD/YYYY]");
    String eventDate = input.nextLine();
    System.out.println("Enter time [XX:XX AM or PM]");
    String eventTime = input.nextLine();
    System.out.println("Choose a venue from the following options [Sun Bowl Stadium , Don Haskins Center, Magoffin Auditorium, San Jacinto Plaza\n" +
            " Centennial Plaza]");
    String eventVenue = input.nextLine();
    for( i = 0; i < v.length;i++){
      if(v[i].getName().equals(eventVenue)){
        v[i].printInfo();
      }
    }
    while(true){
      System.out.println("Enter general price [max 500]");
      generalPrice = input.nextDouble();
      if(generalPrice <= 500){
         vipPrice = generalPrice*5;
         goldPrice = generalPrice*3;
         silverPrice = generalPrice*2.5;
         broncePrice = generalPrice*1.5;
        break;
      }else{
        System.out.println("Please try again");
      }
    }
    System.out.println("Do you want fireworks [Y / N]");
    String fire = input.nextLine().toLowerCase();
    if(fire.equals("y")){
      v[i].setCost(v[i].getCost()+500);
    }
    Event f = new Event(largestEventID(p),"Sport",eventName,eventDate,eventTime,vipPrice,goldPrice,silverPrice,broncePrice,generalPrice,0);
    p[newCount] = f;
    return p;
  }
  public static int largestEventID(Event []p){
    int id = 0;
    for(int i = 0; i < p.length;i++){
      if(p[i].getID() > p[i+1].getID()){
        id = p[i].getID();
      }
    }
    return id;
  }
  public  static int logInID(Customers[] c,String username, String password) {
    int customerID = 0;
    for(int i = 0; i < c.length; i++) {
      if (c[i].getUsername().equals(username) && c[i].getPassword().equals(password)) {
        customerID = i;
      }
    }
    return customerID;
  }
  public static boolean logIn(Customers[] c,String username, String password) {
    boolean flag = false;
    for(int i=0; i < c.length; i++){
      if(c[i].getUsername().equals(username)&& c[i].getPassword().equals(password)){
        flag = true;
      }
    }
    return flag;
  }

  public static void printAdminInquire(Ticket[] c,int temp, String adminInquire){
    for(int i=0; i < c.length; i++){
      if(c[i].getID()== temp || c[i].getName().equals(adminInquire)){
        System.out.println(c[i].toString());

      }
    }
  }
    public static void printCustomerInquire(Event[] c,int temp, String adminInquire){
        for(int i=0; i < c.length; i++){
            if(c[i].getID()== temp || c[i].getName().equals(adminInquire)){
                c[i].printTicketInfo();

            }
        }
    }
  /*
   * This method print the a ticket based ont the ID of the event and the seat chosen by the user
   * the parameters are an object Event, an int t that is checking the id already provided,
   * a string seat that is given by the user to know what type of seats we wants to purchase and the
   * objet ticket.
   * its a void method so i doesnt return anything
   *
   */
  public static double printById(Event [] e, int t,String seat){
    Ticket temp[] = new Ticket[1000];
    double price= 0;
    for(int i = 0; i< e.length;i++){
      if(e[i].getID() == t){
        if(seat.equals("vip")){
          price = e[i].getVipPrice();
          temp[i].setVipTicketsSold(e[i].getVipPrice());
          temp[i].setVipSeatsSold(temp[i].getVipSeatsSold()+1);
          temp[i].setTotalTicketsSold(temp[i].getTotalTicketsSold()+1);
          temp[i].setTotalRevenue(temp[i].getTotalRevenue());


          }
        else if(seat.equals("gold")){
          price = e[i].getGoldPrice();
          temp[i].setGoldTicketsSold(e[i].getGoldPrice());
          temp[i].setVipSeatsSold(temp[i].getVipSeatsSold()+1) ;
          temp[i].setTotalTicketsSold(temp[i].getTotalTicketsSold()+1);
          temp[i].setTotalRevenue(temp[i].getTotalRevenue());
        }
        else if(seat.equals("silver")){
          price = e[i].getSilverPrice();
          temp[i].setSilverTicketsSold(e[i].getSilverPrice());
          temp[i].setSilverSeatsSold(temp[i].getSilverSeatsSold()+1);
          temp[i].setTotalTicketsSold(temp[i].getTotalTicketsSold()+1);
          temp[i].setTotalRevenue(temp[i].getTotalRevenue());
        }
        else if(seat.equals("bronze")){
          price = e[i].getBronzePrice();
          temp[i].setBronzeTicketsSold(e[i].getSilverPrice());
          temp[i].setSilverSeatsSold(temp[i].getSilverSeatsSold()+1);
          temp[i].setTotalTicketsSold(temp[i].getTotalTicketsSold()+1);
          temp[i].setTotalRevenue(temp[i].getTotalRevenue());
        }
        else if(seat.equals("general")){
          price = e[i].getGeneralAdmissionPrice();
          temp[i].setGenAdmTicketsSold(e[i].getGeneralAdmissionPrice());
          temp[i].setGenAdmSeatsSold(temp[i].getGenAdmSeatsSold()+1);
          temp[i].setTotalTicketsSold(temp[i].getTotalTicketsSold()+1);
          temp[i].setTotalRevenue(temp[i].getTotalRevenue());
        }
      }
    }
    return price;
  }
  /*
   * This method creates an randome alphanumeric string that will be used to be set up as the confirmation number
   * for the ticket
   * it has no paramenters
   * return a string
   */
  public static String confirmationNumberMethod(){
    String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789"+"abcdefghijklmnopqrstuvxyz";
    StringBuilder sb = new StringBuilder(8);
    for (int i = 0; i < 8; i++) {
      int index = (int)(AlphaNumericString.length()* Math.random());
      sb.append(AlphaNumericString.charAt(index));
    }
    return sb.toString();
  }
  /*
   * This method was made to process the file customers and tokenize it into an object customers
   * firts by checking the lenght of the file and the proccessing it.
   * it has no parameters
   * returns a object customers
   *
   */
  public static Customers[] customerGenerator()throws IOException{
    int checker = 0;
    int counterEvents = 0;
    int adder = 0;
    String[] matches = new String[] {"ID","First Name","Last Name","Username","Password","Money Available","TicketMiner Membership","Concerts Purchased"};
    Scanner input = new Scanner(new File ("Customer_List_PA1.csv"));
    while(input.hasNext()){
      String line = input.nextLine();
      if(!line.contains(matches[checker])){
        counterEvents++;
        checker++;
        //System.out.println(counterEvents);
      }
      checker = 0;
    }
    Customers[] customers = new Customers[counterEvents];
    input = new Scanner(new File("Customer_List_PA1.csv"));
    while(input.hasNext()){
      String line = input.nextLine().trim();
      if(!line.contains(matches[checker])){
        checker++;
        String tokens[] = line.trim().split(",\\s*");
        int a = Integer.parseInt(tokens[0]);
        String b = tokens[1];
        String c = tokens[2];
        String d = tokens[3];
        String e = tokens[4];
        double f = Double.parseDouble(tokens[5]);
        boolean g = Boolean.parseBoolean(tokens[6]);
        int h = 0;
        Customers m = new Customers(a,b,c,d,e,f,g,h);
        customers[adder] = m;
        adder++;
        //m.printInfo();
      }
      checker = 0;
    }
    return customers;
  }

  /*
   * This method count the lenght of the file event, i decided to do this section in two parts because the length of
   * event is needed for other operations.
   * it returns an int witht the lenght of the event file skipping the fist row of the csv file
   *
   */
  public static int eventNumber()throws IOException{
    int checker = 0;
    int counterEvents = 0;
    int adder = 0;
    String[] matches = new String[] {"ID","TYPE","Name","Date","Time","VIPPrice","GoldPrice","SilverPrice","BronzePrice","GeneralAdmissionPrice"};
    Scanner events = new Scanner(new File ("Event_List_PA1.csv"));
    while(events.hasNext()){
      String line = events.nextLine();
      if(!line.contains(matches[checker])){
        counterEvents++;
        checker++;
        //System.out.println(checker);
      }
      checker = 0;
    }
    return counterEvents;
  }
  /*
   * This method genereates and object event and tokenizes
   * parameters are an int for the length of the file that comes from the previous method
   * and two pre-declared int that were used in other methods
   *
   *
   */
  public static Event[] eventGenerator(int counterEvents, int adder, int checker)throws IOException{
    String[] matches = new String[] {"ID","TYPE","Name","Date","Time","VIPPrice","GoldPrice","SilverPrice","BronzePrice","GeneralAdmissionPrice"};
    Event[] event = new Event[counterEvents];
    Scanner events = new Scanner(new File("Event_List_PA1.csv"));
    while(events.hasNext()){
      String line = events.nextLine().trim();
      if(!line.contains(matches[checker])){
        checker++;
        String tokens[] = line.trim().split(",\\s*");
        int a = Integer.parseInt(tokens[0]);
        String b = tokens[1];
        String c = tokens[2];
        String d = tokens[3];
        String e = tokens[4];
        double f = Double.parseDouble(tokens[5]);
        double g = Double.parseDouble(tokens[6]);
        double h = Double.parseDouble(tokens[7]);
        double i = Double.parseDouble(tokens[8]);
        double j = Double.parseDouble(tokens[9]);
        double k = 0;
        Event m = new Event(a,b,c,d,e,f,g,h,i,j,k);
        event[adder] = m;
        adder++;
        //m.printTicketInfo();
        //System.out.println(checker);

      }
      checker = 0;
    }
    return event;
  }
  /*
   * This method generates the object venue witht he informations of the venue csv file
   *
   *
   */
  public static Venue[] venueGenerator()throws IOException{
    int checker = 0;
    int counterVenue = 0;
    int adder = 0;
    String[] matches = new String[] {"ID","Name","Type","Capacity","Concer Capacity","Cost","VIP Percent","Gold Percent","Silver Percent"+
      "Bronze Percent","General Admission Percent","Reserved Extra Percent"};
    Scanner input = new Scanner(new File ("Venue_List_PA1.csv"));
    while(input.hasNext()){
      String line = input.nextLine();
      if(!line.contains(matches[checker])){
        counterVenue++;
        checker++;
      }
      checker = 0;
    }
    Venue[] venues = new Venue[counterVenue];
    input = new Scanner(new File("Venue_List_PA1.csv"));
    while(input.hasNext()){
      String line = input.nextLine().trim();
      if(!line.contains(matches[checker])){
        checker++;
        String tokens[] = line.trim().split(",\\s*");
        int a = Integer.parseInt(tokens[0]);
        String b = tokens[1];
        String c = tokens[2];
        int d = Integer.parseInt(tokens[3]);
        int e = Integer.parseInt(tokens[4]);
        double f = Double.parseDouble(tokens[5]);
        int g = Integer.parseInt(tokens[6]);
        int h = Integer.parseInt(tokens[7]);
        int i = Integer.parseInt(tokens[8]);
        int j = Integer.parseInt(tokens[9]);
        int k = Integer.parseInt(tokens[10]);
        int l = Integer.parseInt(tokens[10]);

        Venue m = new Venue(a,b,c,d,e,f,g,h,i,j,k,l);
        venues[adder] = m;
        adder++;
        //m.printInfo();
      }
      checker = 0;
    }
    return venues;
  }
}



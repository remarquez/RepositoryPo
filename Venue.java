public class Venue extends Event{
    private int id;
    private String type;
    private String name;
    private int capacity;
    private int concertCapacity;
    private double cost;
    private int vipPercent;
    private int goldPercent;
    private int silverPercent;
    private int broncePercent;
    private int generalAdmission;
    private int reservedExtraPercent;
    
    public Venue(){
      id = 0;
      name = "";
      type = "";
      capacity = 0;
      concertCapacity = 0;
      cost = 0;
      vipPercent = 0;
      goldPercent = 0;
      silverPercent = 0;
      broncePercent = 0;
      generalAdmission = 0;   
      reservedExtraPercent = 0;
    }
    public Venue(int a, String b, String c, int d, int e, double f, int g, int h, int i,int j, int k, int l){
       id = a;
      name = b;
      type = c;
      capacity = d;
      concertCapacity = e;
      cost = f;
      vipPercent = g;
      goldPercent = h;
      silverPercent = i;
      broncePercent = j;
      generalAdmission = k;   
      reservedExtraPercent = l;       
    }
        
    public int getID(){
      return this.id; 
    }
    public String getType(){
      return this.type; 
    }
    public String getName(){
      return this.name; 
    }
    public int getCapacity(){
      return this.capacity; 
    }
    public int getConcertCapacity(){
      return this.concertCapacity; 
    }
    public double getCost(){
     return this.cost; 
    }
    public int getVipPercent(){
      return this.vipPercent; 
    }
    public int getGoldPercent(){
      return this.goldPercent; 
    }
    public int getSilverPercent(){
      return this.silverPercent; 
    }
    public int getBronzePercent(){
      return this.broncePercent; 
    }
    public int getGeneralAdmission(){
      return this.generalAdmission; 
    }  
     public int getReservedExtraPercent(){
      return this.reservedExtraPercent; 
    } 
    public void setID(int newID){
      this.id = newID; 
    }
    public void setType(String newType){
      this.type = newType; 
    }
    public void setCapacity(int newCapacity){
      this.capacity = newCapacity; 
    }
    public void setConcertCapacity(int newConcertCapacity){
      this.concertCapacity = newConcertCapacity; 
    }
    public void setCost(double newCost){
      this.cost = newCost; 
    }
    
    public void setVipPercent(int newVipPercent){
      this.vipPercent= newVipPercent; 
    }
    public void setGoldPercent(int newGoldPercent){
      this.goldPercent = newGoldPercent; 
    }
    public void setSilverPercent(int newSilverPercent){
      this.silverPercent = newSilverPercent; 
    }
    public void setBroncePercent(int newBroncePercent){
      this.broncePercent = newBroncePercent; 
    }
    public void setGeneralAdmission(int newGeneralAdmission){
      this.generalAdmission = newGeneralAdmission; 
    }
     public void setReservedExtraPercent(int newReservedExtraPercent){
      this.reservedExtraPercent = newReservedExtraPercent; 
     }
     public void printInfo(){
       System.out.println("ID: "+getID()+'\n'+"Type: "+getType()+'\n'+"Name: "+getName()+'\n'+"Capacity: "+getCapacity()+'\n'+"Concet Capacity: "+getConcertCapacity()+
                          '\n'+"Cost: "+getCost()+'\n'+"VIP Percent: "+getVipPercent()+'\n'+"Gold Percent: "+getGoldPercent()+'\n'+"Silver Percent: "+getSilverPercent()+'\n'+"Bronze Percent:"+
                          getBronzePercent()+'\n'+"General Admission: "+getGeneralAdmission()+'\n'+"Reserved Extra Percent: "+getReservedExtraPercent());
         System.out.println();       
     }
  }

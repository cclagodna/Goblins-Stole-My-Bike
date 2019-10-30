package GoblinsStoleMyBike;

public class Attack extends Thing {
    
    /*/// Inherited from 'Thing'
    final String NULL
    final Image DEFAULT
    String name
    String desc
    Image img
    ///*/
    
    String element = NULL;
    double power = 1;
    //Currently String, data type likely will change
    String statusEffect = NULL;
    double statusChance = 0;
    
    //Constructors
    //See 'Thing' class for notes
    public Attack() {
        this(null, null, null, -1, null, -1);
    }
    
    public Attack(String name) {
        this(name, null, null, -1, null, -1);
    }
    
    public Attack(String name, String desc) {
        this(name, desc, null, -1, null, -1);
    }
    
    public Attack(String name, String desc, String element) {
        this(name, desc, element, -1, null, -1);
    }
    
    public Attack(String name, String desc, String element, double power) {
        this(name, desc, element, power, null, -1);
    }
    
    public Attack(String name, String desc, String element, double power, String statusEffect) {
        this(name, desc, element, power, statusEffect, -1);
    }
    
    public Attack(String name, String desc, String element, double power, String statusEffect, double statusChance) {
        //null is an Image object
        super(name, desc, null);
        this.element = element;
        this.power = power;
        this.statusEffect = statusEffect;
        this.statusChance = statusChance;
    }
    //Constructors
    
    //Get and Set Methods
    public String getElement() {return element;}
    public void setElement(String element) {this.element = element;}
    
    public double getPower() {return power;}
    public void setPower(double power) {this.power = power;}
    
    public String getStatusEffect() {return statusEffect;}
    public void setStatusEffect(String statusEffect) {this.statusEffect = statusEffect;}
    
    public double getStatusChance() {return statusChance;}
    public void setStatusChance(double statusChance) {this.statusChance = statusChance;}
    //Get and Set Methods
    
    
    
    //To be continued...
    //
    //
    //
    //
}

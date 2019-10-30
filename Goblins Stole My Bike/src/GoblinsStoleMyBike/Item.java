package GoblinsStoleMyBike;

import javafx.scene.image.Image;

public class Item extends Thing {
    
    /*/// Inherited from 'Thing'
    final String NULL
    final Image DEFAULT
    String name
    String desc
    Image img
    ///*/
    
    String element = NULL;
    int uses = 0;
    double power = 1;
    
    
    //Constructors
    //See 'Thing' class for notes
    public Item() {
        this(null, null, null, null, -1, -1);
    }
    
    public Item(String name) {
        this(name, null, null, null, -1, -1);
    }
    
    public Item(String name, String desc) {
        this(name, desc, null, null, -1, -1);
    }
    
    public Item(String name, String desc, Image img) {
        this(name, desc, img, null, -1, -1);
    }
    
    public Item(String name, String desc, String element) {
        this(name, desc, null, element, -1, -1);
    }
    
    public Item(String name, String desc, Image img, String element) {
        this(name, desc, img, element, -1, -1);
    }
    
    public Item(String name, String desc, Image img, String element, int uses) {
        this(name, desc, img, element, uses, -1);
    }
    
    public Item(String name, String desc, Image img, String element, double power) {
                this(name, desc, img, element, -1, power);
    }
    
    public Item(String name, String desc, Image img, String element, int uses, double power) {
        super(name, desc, img);
        if (element != null) this.element = element;
        if (uses >= 0) this.uses = uses;
        if (power >= 0) this.power = power;
    }
    //Constructors
    
    //Get and Set Methods
    public String getElement() {return element;}
    public void setElement(String element) {this.element = element;}
    
    public int getUses() {return uses;}
    public void setUses(int uses) {this.uses = uses;}
    
    public double getPower() {return power;}
    public void setPower(double power) {this.power = power;}
    //Get and Set Methods
    
    
    
    
    //To be continued...
    //
    //
    //
    //
}

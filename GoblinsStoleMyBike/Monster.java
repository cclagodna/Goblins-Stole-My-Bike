package GoblinsStoleMyBike;

import javafx.scene.image.Image;

public class Monster extends Thing {
    
    /*/// Inherited from 'Thing'
    final String NULL
    final Image DEFAULT
    String name
    String desc
    Image img
    ///*/
    
    //Elemental type of monster. Currently 'String', may change
    private String element = NULL;
    //Stat values of monster
    private double hp = 1;
    private double atk = 1;
    private double def = 1;
    //The Attacks of the monster
    private Attack att1 = new Attack();
    private Attack att2 = new Attack();
    private Attack att3 = new Attack();
    
    
    //Constructors
    //See 'Thing' class for notes
    public Monster() {
        this(null, null, null, null, -1, -1, -1, null, null, null);
    }
    
    public Monster(String name) {
        this(name, null, null, null, -1, -1, -1, null, null, null);
    }
    
    public Monster(String name, String desc) {
        this(name, desc, null, null, -1, -1, -1, null, null, null);
    }
    
    public Monster(String name, String desc, Image img) {
        this(name, desc, img, null, -1, -1, -1, null, null, null);
    }
    
    public Monster(String name, String desc, String element) {
        this(name, desc, null, element, -1, -1, -1, null, null, null);
    }
    
    public Monster(String name, String desc, Image img, String element) {
        this(name, desc, img, element, -1, -1, -1, null, null, null);
    }
    
    public Monster(String name, String desc, Image img, String element, double hp, double atk, double def) {
        this(name, desc, img, element, hp, atk, def, null, null, null);
    }
    
    public Monster(String name, String desc, Image img, String element, double hp,
                    double atk, double def, Attack att1, Attack att2, Attack att3) {
        super(name, desc, img);
        if (element != null) this.element = element;
        if (hp >= 0) this.hp = hp;
        if (atk >= 0) this.atk = atk;
        if (def >= 0) this.def = def;
        if (att1 != null) this.att1 = att1;
        if (att2 != null) this.att2 = att2;
        if (att3 != null) this.att3 = att3;
    }
    //Constructors
    
    //Get and Set Methods
    public String getElement() {return element;}
    public void setElement(String element) {this.element = element;}
    
    public double getHp() {return hp;}
    public void setHp(double hp) {this.hp = hp;}
    
    public double getAtk() {return atk;}
    public void setAtk(double atk) {this.atk = atk;}
    
    public double getDef() {return def;}
    public void setDef(double def) {this.def = def;}
    
    public Attack getAtt1() {return att1;}
    public void setAtt1(Attack att) {att1 = att;}
    
    public Attack getAtt2() {return att2;}
    public void setAtt2(Attack att) {att2 = att;}
    
    public Attack getAtt3() {return att3;}
    public void setAtt3(Attack att) {att3 = att;}
    //Get and Set Methods
    
    
    
    //To be continued...
    //
    //
    //
    //
}

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
    
    //The level of the monster, influences base stats
    int level = 1;
    //Elemental type of monster. Currently 'String' data type, may change
    String element = NULL;
    //Base stat values of monster
    //These
    double base_hp = 1;
    double base_atk = 1;
    double base_def = 1;
    //Current stat values for monster
    //These will change during battle
    double curr_hp = base_hp;
    double curr_atk = base_atk;
    double curr_def = base_def;
    
    //The Attacks of the monster
    Attack att1 = new Attack();
    Attack att2 = new Attack();
    Attack att3 = new Attack();
    
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
    
    public Monster(String name, String desc, Image img, String element, double base_hp, double base_atk, double base_def) {
        this(name, desc, img, element, base_hp, base_atk, base_def, null, null, null);
    }
    
    public Monster(String name, String desc, Image img, String element, double base_hp,
                    double base_atk, double base_def, Attack att1, Attack att2, Attack att3) {
        super(name, desc, img);
        if (element != null) this.element = element;
        if (base_hp >= 0) this.base_hp = this.curr_hp = base_hp;
        if (base_atk >= 0) this.base_atk = this.curr_atk = base_atk;
        if (base_def >= 0) this.base_def = this.curr_def = base_def;
        if (att1 != null) this.att1 = att1;
        if (att2 != null) this.att2 = att2;
        if (att3 != null) this.att3 = att3;
    }
    //Constructors
    
    //Get and Set Methods
    public String getElement() {return element;}
    public void setElement(String element) {this.element = element;}
    
    public double getBaseHp() {return base_hp;}
    public void setBaseHp(double base_hp) {this.base_hp = base_hp;}
    
    public double getBaseAtk() {return base_atk;}
    public void setBaseAtk(double base_atk) {this.base_atk = base_atk;}
    
    public double getBaseDef() {return base_def;}
    public void setBaseDef(double base_def) {this.base_def = base_def;}
    
    public double getCurrHp() {return curr_hp;}
    public void setCurrHp(double curr_hp) {this.curr_hp = curr_hp;}
    
    public double getCurrAtk() {return curr_atk;}
    public void setCurrAtk(double curr_atk) {this.curr_atk = curr_atk;}
    
    public double getCurrDef() {return curr_def;}
    public void setCurrDef(double curr_def) {this.curr_def = curr_def;}
    
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

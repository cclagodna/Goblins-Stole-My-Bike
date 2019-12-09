package GoblinsStoleMyBike;

import javafx.scene.image.Image;

public class Base_Object {
    
    protected String name = "DEFAULT";
    protected String desc;
    protected Image img;
    // Initialize types for calculation within this class 
    protected Element type;
    
    /*///
    Each constructor calls the one on the bottom by using 'this()'
    *////
    
    //Constructors
    public Base_Object() {}
    
    public Base_Object(String name, String desc, Image img, String type) {
        this.name = name;
        this.desc = desc;
        this.img = img;
        this.type = new Element(type);
    }
    
    public Base_Object(String name, String desc, Image img, Element type) {
        this.name = name;
        this.desc = desc;
        this.img = img;
        this.type = type;
    }
    //Constructors
    
    //Get and Set Methods
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    
    public String getDesc() {return desc;}
    public void setDesc(String desc) {this.desc = desc;}
    
    public Image getImg() {return this.img;}
    public void setImg(Image img) {this.img = img;}
    
    //Returns the 'Element' object 'type'
    public Element getElement() { return this.type; }
    //Returns a string representation of the type
    public String getType() { return this.type.toString(); }
    public void setType(String type) {this.type = new Element(type);}
    public void setType(Element element) {this.type = element;}
    //Get and Set Methods
}

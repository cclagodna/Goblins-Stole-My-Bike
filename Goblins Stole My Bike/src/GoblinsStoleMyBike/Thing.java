package GoblinsStoleMyBike;

import javafx.scene.image.Image;

public class Thing {
    
    //These are the 'default' values for any String and Image
    //Mostly for testing and error prevention
    final String NULL = "<null>";
    final Image DEFAULT = new Image(getClass().getResourceAsStream("icons/default.png"));
    
    String name = NULL;
    String desc = NULL;
    Image img = DEFAULT;
    
    /*///
    Each constructor calls the one on the bottom
    They pass 'null' or '-1' if no variable was given, and will use the
      default value assigned above
    Subclasses will call 'super()' and use this bottom constructor
    *////
    //Constructors
    public Thing() {
        this(null, null, null);
    }
    
    public Thing(String name) {
        this(name, null, null);
    }
    
    public Thing(String name, String desc) {
        this(name, desc, null);
    }
    
    public Thing(String name, String desc, Image img) {
        if (name != null) this.name = name;
        if (desc != null) this.desc = desc;
        if (img != null) this.img = img;
    }
    //Constructors
    
    //Get and Set Methods
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    
    public String getDesc() {return desc;}
    public void setDesc(String desc) {this.desc = desc;}
    
    public Image getImg() {return img;}
    public void setImg(Image img) {this.img = img;}
    //Get and Set Methods
    
    
    
    //To be continued...
    //
    //
    //
    //
}

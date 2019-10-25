package GoblinsStoleMyBike;


public class test {
    
    /*
    To test code in this 'main', press SHIFT + F6
    Changes will need the program to be rebuilt, press F11
    F11 -> SHIFT+F6
    */
    
    public static void main(String args[]) {
        
        Thing thing = new Thing("This is my name", "This is a description");
        
        System.out.println(thing.getName());
        System.out.println(thing.getDesc());
        System.out.println(thing.getImg().getWidth());
        
    }
    
}

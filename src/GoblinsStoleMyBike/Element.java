package GoblinsStoleMyBike;

public class Element {
    
    //List of all element types
    //Consider BASIC to be a default type, similar to 'normal' in pokemon
    enum Types {
        BASIC, GRASS, FIRE, WATER, EARTH, SHOCK, WIND, MAGIC, GHOST, CORROSIVE, MACHINE, MUTANT, SPACE
    }
    
    //Carries the 'type' or 'element' of the monster or attack
    protected Types type;
    //An array or every element host monster is weak to
    protected Types[] weakness;
    //Every element the host monster resists
    protected Types[] resistance;
    
    
    
    //Constructors
    public Element() {
    //Sets default element
        this.type = Types.BASIC;
        
        generateWeaknessResistance();
    }
    
    public Element(String type) {
        try {
            //Converts string to uppercase, then checks if that exact value is in 'Types'
            //Since valueOf checks for exact spelling, String needs to be uppercase
            this.type = Types.valueOf(type.toUpperCase());
        }
        catch (Exception e) {
            //In case try block gets an error
            //  likely due to wrong spelling of string being passed through "type"
            //This sets type to BASIC
            this.type = Types.BASIC;
        }
        
        generateWeaknessResistance();
    }
    
    public Element(Types type) {
        this.type = type;
        generateWeaknessResistance();
    }
    //End constructors
    
    
    
    //Get and Set methods
    //Procs the Enum toString() to get the type name, then upper cases it
    public String toString() { return type.toString().toUpperCase(); }
    
    public Types getType() { return type; }
    
    public Types[] getWeaknesses() { return weakness; }
    
    public Types[] getResistances() { return resistance; }
    
    private void generateWeaknessResistance() {
        //This is essentially the type weakness/ resistance chart, translated to code
        //The type is checked, and then a weakness and resistance array is generated
        switch(this.type) {
            case BASIC:
                weakness = new Types[]{Types.MACHINE};
                resistance = new Types[]{Types.MUTANT, Types.SPACE};
                break;
            case GRASS:
                weakness = new Types[]{Types.FIRE, Types.CORROSIVE, Types.SPACE};
                resistance = new Types[]{Types.WATER, Types.EARTH};
                break;
            case FIRE:
                weakness = new Types[]{Types.WATER, Types.EARTH, Types.SPACE};
                resistance = new Types[]{Types.GRASS, Types.WIND, Types.GHOST, Types.MUTANT};
                break;
            case WATER:
                weakness = new Types[]{Types.GRASS, Types.SHOCK, Types.SPACE};
                resistance = new Types[]{Types.FIRE, Types.EARTH, Types.GHOST, Types.MACHINE};
                break;
            case EARTH:
                weakness = new Types[]{Types.WATER, Types.WIND, Types.SPACE};
                resistance = new Types[]{Types.SHOCK, Types.GHOST};
                break;
            case SHOCK:
                weakness = new Types[]{Types.EARTH, Types.MACHINE, Types.MUTANT};
                resistance = new Types[]{Types.WATER, Types.WIND, Types.GHOST, Types.CORROSIVE};
                break;
            case WIND:
                weakness = new Types[]{Types.SHOCK, Types.SPACE};
                resistance = new Types[]{Types.EARTH, Types.GHOST};
                break;
            case MAGIC:
                weakness = new Types[]{Types.GHOST, Types.CORROSIVE, Types.MACHINE};
                resistance = new Types[]{Types.GRASS, Types.FIRE, Types.WATER, Types.EARTH, Types.SHOCK};
                break;
            case GHOST:
                weakness = new Types[]{Types.WATER, Types.EARTH, Types.SHOCK};
                resistance = new Types[]{Types.MAGIC, Types.CORROSIVE, Types.MACHINE};
                break;
            case CORROSIVE:
                weakness = new Types[]{Types.GHOST, Types.MUTANT};
                resistance = new Types[]{Types.GRASS, Types.MAGIC, Types.MACHINE};
                break;
            case MACHINE:
                weakness = new Types[]{Types.WATER, Types.GHOST, Types.CORROSIVE};
                resistance = new Types[]{Types.BASIC, Types.SHOCK, Types.SPACE};
                break;
            case MUTANT:
                weakness = new Types[]{Types.BASIC, Types.FIRE};
                resistance = new Types[]{Types.SHOCK, Types.CORROSIVE, Types.SPACE};
                break;
            case SPACE:
                weakness = new Types[]{Types.BASIC, Types.MACHINE, Types.MUTANT};
                resistance = new Types[]{Types.GRASS, Types.FIRE, Types.WATER, Types.EARTH, Types.WIND};
                break;
        }
    }
    //Get and Set methods
    
}

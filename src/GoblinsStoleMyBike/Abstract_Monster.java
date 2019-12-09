package GoblinsStoleMyBike;

import GoblinsStoleMyBike.Element.Types;

public abstract class Abstract_Monster extends Base_Object{
    
    /*
    From Base_Object, inherits:
    
    protected String name;
    protected String desc;
    protected Image img;
    protected Element type;
    
    public String getName()
    public void setName(String name)
    
    public String getDesc()
    public void setDesc(String desc)
    
    public Image getImg()
    public void setImg(Image img)
    
    public Element getType()
    */
    
    //The level of the monster, increases stats and they learn new attacks
    protected int level = 1;
    //Base stat values of monster
    protected double baseHealth = 1;
    protected double baseStrength = 1;
    protected double baseDefense = 1;
    //Current stat values for monster
    //These will change during battle
    protected double currHealth = baseHealth;
    protected double currStrength = baseStrength;
    protected double currDefense = baseDefense;
    
    //The 4 attacks of the monster
    protected Abstract_Attack att1;
    protected Abstract_Attack att2;
    protected Abstract_Attack att3;
    protected Abstract_Attack att4;
    
    //Variable stores the next attack monster is going to learn
    protected Abstract_Attack newAttack;
    
    //Get and Set methods
    public int getLevel() {return level;}
    
    public double getBaseHealth() {return baseHealth;}
    public void setBaseHealth(double hp) {this.baseHealth = hp;}
    
    public double getBaseStrength() {return baseStrength;}
    public void setBaseStrength(double str) {this.baseStrength = str;}
    
    public double getBaseDefense() {return baseDefense;}
    public void setBaseDefense(double def) {this.baseDefense = def;}
    
    public double getCurrHealth() {return currHealth;}
    public void setCurrHealth(double hp) {this.currHealth = hp;}
    
    public double getCurrStrength() {return currStrength;}
    public void setCurrStrength(double str) {this.currStrength = str;}
    
    public double getCurrDefense() {return currDefense;}
    public void setCurrDefense(double def) {this.currDefense = def;}
    
    public Abstract_Attack getAtt1() {return att1;}
    public void setAtt1(Abstract_Attack att) {att1 = att;}
    
    public Abstract_Attack getAtt2() {return att2;}
    public void setAtt2(Abstract_Attack att) {att2 = att;}
    
    public Abstract_Attack getAtt3() {return att3;}
    public void setAtt3(Abstract_Attack att) {att3 = att;}
    
    public Abstract_Attack getAtt4() {return att4;}
    public void setAtt4(Abstract_Attack att) {att4 = att;}
    //Get and Set Methods
    
    public void resetCurrStats() {
        //Sets all current stats to their base values
        
        setCurrHealth( getBaseHealth() );
        setCurrStrength( getBaseStrength() );
        setCurrDefense( getBaseDefense() );
    }
    
    public void takeDamage(double damage) {
        //Subtracts monster's current health by some damage
        setCurrHealth( getCurrHealth() - damage );
    }
    
    public boolean isWeak(Element attackingElement) {
        //Gathers the array of elements that 'this' monster is weak to
        Types[] weaknesses = this.getElement().getWeaknesses();
        //The attacking type is set to the Element Enum 'Types'
        Types attackingType = attackingElement.getType();
        
        //Iterates over 'weaknesses' array, every value is passed as 'weakType'
        for (Types weakType : weaknesses) {
            //If 'attackingType' appears in the 'weaknesses' list
            if (weakType == attackingType) {
                return true;
            }
        }
        
        //'attackingType' did not appear in the 'weaknesses' array
        return false;
    }
    
    public boolean isResist(Element attackingElement) {
        //Gathers the array of types that 'this' monster is resistant to
        Types[] resistances = this.getElement().getResistances();
        //The 'attackingType' is set to an instance of Element Enum 'Types'
        Types attackingType = attackingElement.getType();
        
        //Iterates over 'resistances' array, every value is passed as 'resistType'
        for (Types resistType : resistances) {
            //If 'attackingType' appears in the 'resistances' list
            if (resistType == attackingType) {
                return true;
            }
        }
        
        //'attackingType' did not appear in the 'resistances' array
        return false;
    }
    
    public abstract void levelUp();
    
    public abstract void scaleHealth();
    
    public abstract void scaleStrength();
    
    public abstract void scaleDefense();
    
    public abstract Abstract_Attack learnNewAttack();
    
}

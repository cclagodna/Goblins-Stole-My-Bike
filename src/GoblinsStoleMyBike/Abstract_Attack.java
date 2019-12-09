package GoblinsStoleMyBike;

abstract public class Abstract_Attack extends Base_Object {
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
    
    
    // How strong the attack is
    protected double power;
    
    // Get and Set Methods 
    public double getPower() {return power;} 
    // Get and Set Methods
    
    public double calcDamage(Abstract_Monster source, Abstract_Monster target) {
        // General damage calculation formula
        // Negative attacks to "heal" might be tempting but, directly changing health values will cause less issues
        // Can be @Overriden in child classes to use different formulas
        
        //Stores the damage boost due to elemental weakness or resistance
        //  If monster is weak to element -> 120% damage
        //  If monster resists element -> 80% damage
        double elementMultiplier = 1;
        
        //Compares the
        if (target.isWeak(this.getElement())) {
            elementMultiplier = 1.3;
        }
        else if (target.isResist(this.getElement())) {
            elementMultiplier = 0.7;
        }
        
        double damage = Math.floor( elementMultiplier * (source.getCurrStrength() * this.getPower()) / (source.getCurrStrength() + target.getCurrDefense()) );
        if (damage <= 1) {damage = 1;}
        return damage;
    }
}

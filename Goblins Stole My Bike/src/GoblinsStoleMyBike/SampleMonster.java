package GoblinsStoleMyBike;

public class SampleMonster extends Monster{
    
    /*// This is a sample of how each specific monster class will look like
    A new class must be created and renamed to what the monster is
        Ex: class Goblin, class Ogre, class Phantom, etc.
    This class will define formulas to scale stats base on creatures level, and
        designate attacks that the monster can use
    //*/
    
    public SampleMonster() {
        this.name = "Goblin";
        this.desc = "Just a simple goblin. Has a rabid fascination with bicycles.";
        this.img = DEFAULT;
        this.element = "basic";
        this.base_hp = scaleHp();
        this.base_atk = scaleAtk();
        this.base_def = scaleDef();
    }
    
    
    //Below are formulas tht scale monster stats based on its level
    
    private double scaleHp() {
        return 5 + level * 5;
    }
    
    private double scaleAtk() {
        return 5 + level * 1.5;
    }
    
    private double scaleDef() {
        return 5 + level * 1.25;
    }
    
    
    
}

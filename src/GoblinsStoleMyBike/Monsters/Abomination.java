package GoblinsStoleMyBike.Monsters;

import GoblinsStoleMyBike.*;
import GoblinsStoleMyBike.Attacks.*;
import GoblinsStoleMyBike.Element;
import javafx.scene.image.Image;

public final class Abomination extends Abstract_Monster{
    
    public Abomination() {
        this.name = "Abomination";
        this.desc = "Do you think God stays in Heaven because he, too, lives in fear of what he's created?";
        this.img = new Image(getClass().getResourceAsStream("Icons/Abomination.png"));
        this.type = new Element("Water");
        scaleHealth();
        scaleStrength();
        scaleDefense();

        this.currHealth = this.baseHealth;
        this.currStrength = this.baseStrength;
        this.currDefense = this.baseDefense;
        
        this.att1 = new Explosion();
        this.att2 = new LeafStab();
        this.att3 = new Melt();
        this.att4 = new WaterRocket();
    }

    public void scaleHealth() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseHealth( Math.floor(50 + 0 * level) );
    }
    
    public void scaleStrength() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseStrength( Math.floor(10 + 5 * level) );
    }
    
    public void scaleDefense() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseDefense( Math.floor(10 + 5 * level) );
    }
    
    public void levelUp() {
        //Monsters can't level higher than 5
        if (this.level < 5) {
            this.level++;
            scaleHealth();
            scaleStrength();
            scaleDefense();
            resetCurrStats();
        }
    }
    
    public Abstract_Attack learnNewAttack() {
        //Since monsters can only know 4 attacks must replace old attack with new
        
        Abstract_Attack levelUpAttack;
        
        switch(level) {
            case 2:
                levelUpAttack = new Shake();
                return levelUpAttack;
            case 3:
                levelUpAttack = new LightBeam();
                return levelUpAttack;
            case 4:
                levelUpAttack = new Restore();
                return levelUpAttack;
            case 5:
                levelUpAttack = new GreenSpit();
                return levelUpAttack;
            default:
                return null;
        }
    }
    
}

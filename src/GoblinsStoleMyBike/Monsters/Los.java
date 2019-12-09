package GoblinsStoleMyBike.Monsters;

import GoblinsStoleMyBike.*;
import GoblinsStoleMyBike.Attacks.*;
import GoblinsStoleMyBike.Element;
import javafx.scene.image.Image;

public final class Los extends Abstract_Monster{
    
    public Los() {
        this.name = "Los";
        this.desc = "";
        this.img = new Image(getClass().getResourceAsStream("Icons/Los.png"));
        this.type = new Element("Ghost");

        scaleHealth();
        scaleStrength();
        scaleDefense();

        this.currHealth = this.baseHealth;
        this.currStrength = this.baseStrength;
        this.currDefense = this.baseDefense;
        
        this.att1 = new Lick();
        this.att2 = new Restore();
        this.att3 = new Shake();
        this.att4 = new AcidBite();
    }

    public void scaleHealth() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseHealth( Math.floor(20 + 8 * level) );
    }
    
    public void scaleStrength() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseStrength( Math.floor(15 + 3 * level) );
    }
    
    public void scaleDefense() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseDefense( Math.floor(12 + 5 * level) );
    }
    
    public void levelUp() {
        //Monsters can't level higher than 5
        if (this.level < 5) {
            this.level++;
            scaleHealth();
            scaleStrength();
            scaleDefense();
            learnNewAttack();
            resetCurrStats();
        }
    }
    
    public Abstract_Attack learnNewAttack() {
        //Since monsters can only know 4 attacks must replace old attack with new
        
        Abstract_Attack levelUpAttack;
        
        switch(level) {
            case 2:
                levelUpAttack = new WaterRocket();
                return levelUpAttack;
            case 3:
                levelUpAttack = new WindPunch();
                return levelUpAttack;
            case 4:
                levelUpAttack = new Strangle();
                return levelUpAttack;
            case 5:
                levelUpAttack = new Heal();
                return levelUpAttack;
            default:
                return null;
        }
    }
    
}

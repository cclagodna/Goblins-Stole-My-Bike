package GoblinsStoleMyBike.Monsters;

import GoblinsStoleMyBike.Abstract_Attack;
import GoblinsStoleMyBike.Abstract_Monster;
import GoblinsStoleMyBike.Attacks.*;
import GoblinsStoleMyBike.Element;
import javafx.scene.image.Image;

public final class Alaz extends Abstract_Monster {
    
    public Alaz() {
        this.name = "Alaz";
        this.desc = "";
        this.img = new Image(getClass().getResourceAsStream("Icons/Alaz.png"));;
        this.type = new Element("Fire");

        scaleHealth();
        scaleStrength();
        scaleDefense();

        this.currHealth = this.baseHealth;
        this.currStrength = this.baseStrength;
        this.currDefense = this.baseDefense;
        
        this.att1 = new Restore();
        this.att2 = new Explosion();
        this.att3 = new AcidBite();
        this.att4 = new WindPunch();
    }

    public void scaleHealth() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseHealth( Math.floor(21 + 7.5 * level) );
    }
    
    public void scaleStrength() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseStrength( Math.floor(14 + 4 * level) );
    }
    
    public void scaleDefense() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseDefense( Math.floor(25 + 2 * level) );
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
                levelUpAttack = new Melt();
                return levelUpAttack;
            case 3:
                levelUpAttack = new Strangle();
                return levelUpAttack;
            case 4:
                levelUpAttack = new Heal();
                return levelUpAttack;
            case 5:
                levelUpAttack = new MeteorBash();
                return levelUpAttack;
            default:
                return null;
        }
    }
    
}

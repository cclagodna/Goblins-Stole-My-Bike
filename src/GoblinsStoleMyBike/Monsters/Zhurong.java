package GoblinsStoleMyBike.Monsters;

import GoblinsStoleMyBike.*;
import GoblinsStoleMyBike.Attacks.*;
import GoblinsStoleMyBike.Element;
import javafx.scene.image.Image;

public final class Zhurong extends Abstract_Monster{
    
    public Zhurong() {
        this.name = "Zhurong";
        this.desc = "";
        this.img = new Image(getClass().getResourceAsStream("Icons/Zhurong.png"));
        this.type = new Element("Mutant");
        scaleHealth();
        scaleStrength();
        scaleDefense();
        
        this.currHealth = this.baseHealth;
        this.currStrength = this.baseStrength;
        this.currDefense = this.baseDefense;
        
        this.att1 = new AcidBite();
        this.att2 = new Explosion();
        this.att3 = new Kick();
        this.att4 = new Strangle();
    }

    public void scaleHealth() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseHealth( Math.floor(35 + 5 * level) );
    }
    
    public void scaleStrength() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseStrength( Math.floor(13 + 3.3 * level) );
    }
    
    public void scaleDefense() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseDefense( Math.floor(15 + 4.2 * level) );
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
                levelUpAttack = new Restore();
                return levelUpAttack;
            case 3:
                levelUpAttack = new GreenSpit();
                return levelUpAttack;
            case 4:
                levelUpAttack = new Hypnotic();
                return levelUpAttack;
            case 5:
                levelUpAttack = new ShockPunch();
                return levelUpAttack;
            default:
                return null;
        }
    }
    
}

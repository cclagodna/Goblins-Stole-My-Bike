package GoblinsStoleMyBike.Monsters;

import GoblinsStoleMyBike.*;
import GoblinsStoleMyBike.Attacks.*;
import GoblinsStoleMyBike.Element;
import javafx.scene.image.Image;

public final class Robot extends Abstract_Monster{
    
    
    public Robot() {

        this.name = "Robot";
        this.desc = "I am a robot! i run on american jobs! beep beep boop maggot!";
        this.img = new Image(getClass().getResourceAsStream("Icons/Robot.png"));
        this.type = new Element("Machine");

        scaleHealth();
        scaleStrength();
        scaleDefense();

        this.currHealth = this.baseHealth;
        this.currStrength = this.baseStrength;
        this.currDefense = this.baseDefense;
        
        this.att1 = new Heal();
        this.att2 = new Strangle();
        this.att3 = new LightBeam();
        this.att4 = new Explosion();
    }

    public void scaleHealth() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseHealth( Math.floor(26 + 2 * level) );
    }
    
    public void scaleStrength() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseStrength( Math.floor(16 + 2 * level) );
    }
    
    public void scaleDefense() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseDefense( Math.floor(26 + 2 * level) );
    }
    
    public void levelUp() {
        //Monsters cap out at level 5. no need to do anything here.
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
                levelUpAttack = new MeteorBash();
                return levelUpAttack;
            case 3:
                levelUpAttack = new ShockPunch();
                return levelUpAttack;
            case 4:
                levelUpAttack = new Melt();
                return levelUpAttack;
            case 5:
                levelUpAttack = new Premonition();
                return levelUpAttack;
            default:
                return null;
        }
    }
    
}

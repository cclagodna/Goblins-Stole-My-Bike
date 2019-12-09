package GoblinsStoleMyBike.Monsters;

import GoblinsStoleMyBike.*;
import GoblinsStoleMyBike.Attacks.*;
import GoblinsStoleMyBike.Element;
import javafx.scene.image.Image;


public final class Shockey extends Abstract_Monster{
    
    
    public Shockey() {
        this.name = "Shockey";
        this.desc = "this will come as a shock to you!";
        this.img = new Image(getClass().getResourceAsStream("Icons/Shockey.png"));
        this.type = new Element("Shock");

        scaleHealth();
        scaleStrength();
        scaleDefense();

        this.currHealth = this.baseHealth;
        this.currStrength = this.baseStrength;
        this.currDefense = this.baseDefense;
        
        this.att1 = new WindPunch();
        this.att2 = new Kick();
        this.att3 = new Heal();
        this.att4 = new LeafStab();
    }

    public void scaleHealth() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseHealth( Math.floor(30 + 2.5 * level) );
    }
    
    public void scaleStrength() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseStrength( Math.floor(10 + 10 * level) );
    }
    
    public void scaleDefense() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseDefense( Math.floor(10 + 6 * level) );
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
                levelUpAttack = new LightBeam();
                return levelUpAttack;
            case 5:
                levelUpAttack = new Premonition();
                return levelUpAttack;
            default:
                return null;
        }
    }
    
}

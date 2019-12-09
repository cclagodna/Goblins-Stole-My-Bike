package GoblinsStoleMyBike.Monsters;

import GoblinsStoleMyBike.*;
import GoblinsStoleMyBike.Attacks.*;
import GoblinsStoleMyBike.Element;
import javafx.scene.image.Image;

public final class Windmon extends Abstract_Monster{
    
    
    public Windmon() {
        this.name = "Windmon";
        this.desc = "";
        this.img = new Image(getClass().getResourceAsStream("Icons/Windmon.png"));
        this.type = new Element("Wind");
        scaleHealth();
        scaleStrength();
        scaleDefense();
        
        this.currHealth = this.baseHealth;
        this.currStrength = this.baseStrength;
        this.currDefense = this.baseDefense;
        
        this.att1 = new Kick();
        this.att2 = new WaterRocket();
        this.att3 = new EarthCrush();
        this.att4 = new Melt();
    }

    public void scaleHealth() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseHealth( Math.floor(30 + 2 * level) );
    }
    
    public void scaleStrength() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseStrength( Math.floor(18 + 3.2 * level) );
    }
    
    public void scaleDefense() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseDefense( Math.floor(10 + 3 * level) );
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
                levelUpAttack = new AirBlast();
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

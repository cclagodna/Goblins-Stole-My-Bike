package GoblinsStoleMyBike.Monsters;

import GoblinsStoleMyBike.*;
import GoblinsStoleMyBike.Attacks.*;
import GoblinsStoleMyBike.Element;
import javafx.scene.image.Image;

public final class Defender extends Abstract_Monster{
    
    
    public Defender() {
        this.name = "Defeneder";
        this.desc = "The best defense is a good defense";
        this.img = new Image(getClass().getResourceAsStream("Icons/Defender.png"));
        this.type = new Element("Corrosive");

        scaleHealth();
        scaleStrength();
        scaleDefense();

        this.currHealth = this.baseHealth;
        this.currStrength = this.baseStrength;
        this.currDefense = this.baseDefense;
        
        this.att1 = new Shake();
        this.att2 = new EarthCrush();
        this.att3 = new GreenSpit();
        this.att4 = new AirBlast();
    }

    public void scaleHealth() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseHealth( Math.floor(30 + 1.5 * level) );
    }
    
    public void scaleStrength() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseStrength( Math.floor(8 + 4 * level) );
    }
    
    public void scaleDefense() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseDefense( Math.floor(20 + 5 * level) );
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
                levelUpAttack = new Melt();
                return levelUpAttack;
            case 3:
                levelUpAttack = new Heal();
                return levelUpAttack;
            case 4:
                levelUpAttack = new Explosion();
                return levelUpAttack;
            case 5:
                levelUpAttack = new Strangle();
                return levelUpAttack;
            default:
                return null;
        }
    }
    
}

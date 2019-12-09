package GoblinsStoleMyBike.Monsters;

import GoblinsStoleMyBike.*;
import GoblinsStoleMyBike.Attacks.*;
import GoblinsStoleMyBike.Element;
import javafx.scene.image.Image;

public final class Ifri extends Abstract_Monster{
    
    public Ifri() {
        this.name = "Ifri";
        this.desc = "";
        this.img = new Image(getClass().getResourceAsStream("Icons/Ifri.png"));
        this.type = new Element("Shock");

        scaleHealth();
        scaleStrength();
        scaleDefense();

        this.currHealth = this.baseHealth;
        this.currStrength = this.baseStrength;
        this.currDefense = this.baseDefense;
        
        this.att1 = new GreenSpit();
        this.att2 = new AirBlast();
        this.att3 = new Melt();
        this.att4 = new Lick();
    }

    public void scaleHealth() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseHealth( Math.floor(25 + 5 * level) );
    }
    
    public void scaleStrength() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseStrength( Math.floor(15 + 6 * level) );
    }
    
    public void scaleDefense() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseDefense( Math.floor(25 + 5 * level) );
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
                levelUpAttack = new AcidBite();
                return levelUpAttack;
            case 3:
                levelUpAttack = new EarthCrush();
                return levelUpAttack;
            case 4:
                levelUpAttack = new Hypnotic();
                return levelUpAttack;
            case 5:
                levelUpAttack = new Heal();
                return levelUpAttack;
            default:
                return null;
        }
    }
    
}

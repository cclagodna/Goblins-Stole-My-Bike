package GoblinsStoleMyBike.Monsters;

import GoblinsStoleMyBike.*;
import GoblinsStoleMyBike.Attacks.*;
import GoblinsStoleMyBike.Element;
import javafx.scene.image.Image;

public final class Goblin extends Abstract_Monster{
    
    //GOBLIN IS THE FINAL BOSS
    //HIS STATS DON'T CHANGE (ALREADY AT LEVEL 5) AND HE HAS A POOL OF RANDOM ATTACKS TO CHOOSE FROM
    
    public Goblin() {
        this.name = "The Goblin";
        this.desc = "You got any of them bikes?";
        this.img = new Image(getClass().getResourceAsStream("Icons/Goblin.png"));
        this.type = new Element("Space");

        scaleHealth();
        scaleStrength();
        scaleDefense();

        this.currHealth = this.baseHealth;
        this.currStrength = this.baseStrength;
        this.currDefense = this.baseDefense;
        
        this.att1 = new MeteorBash();
        this.att2 = new Explosion();
        this.att3 = new AcidBite();
        this.att4 = new Premonition();
    }

    public void scaleHealth() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseHealth( Math.floor(100 + 0 * level) );
    }
    
    public void scaleStrength() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseStrength( Math.floor(25 + 0 * level) );
    }
    
    public void scaleDefense() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseDefense( Math.floor(25 + 0 * level) );
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
                levelUpAttack = new Restore();
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

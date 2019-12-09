package GoblinsStoleMyBike;

import GoblinsStoleMyBike.Monsters.*;
import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class Main extends Application {
    //Initialize all static (or global) variables
    
    //Width and Height of game window
    //  Change these variables to change window size
    //NOTE: The VBox on the right side of the screen is set to 40% total WIDTH
    //NOTE: The buttons in the VBox will be 50% of HEIGHT
    static final int WIDTH = 1200;
    static final int HEIGHT = 500;
    
    //The primary window of the game that displays the primaryScene
    static Stage primaryStage;
    //The primary "scene" from which everything will be displayed
    static Scene primaryScene;
    
    //The main screen of the game. Switches center region to display batle, shop, etc.
    static BorderPane mainPane;
    //Vertical box holding the menu and history. Displayed on the right region of mainPane
    static VBox rightBox;
    //Gridpane that holds all the buttons for the menu. Located in vbox 'rightBox'
    static GridPane menuGrid;
    //Defines how many columns and rows the menuGrid will have
    static final int menuColumns = 2;
    static final int menuRows = 3;
    //Menu buttons and comboBox with events that change current Pane. Located inside the menuGrid
    static Button btn_Battle;
    static Button btn_Boss;
    static Button btn_FinalBoss;
    static Button btn_LevelUp;
    static Button btn_Main;
    static Button btn_End;
    //Displays text of events that occur during battle, contained in rightBox
    static TextArea history;
    //Defines how many rows will be displayed for 'history'
    static final int historyRows = 20;
    
    //Screen that will hold all objects relating to battle (monster, text, etc.)
    static GridPane battle;
    static GridPane bossBattle;
    static boolean isBossBattle = false;
    static GridPane finalBattle;
    static boolean isFinalBossBattle = false;
    //Defines how many columns and rows the GridPane 'battle' will have
    static final int battleColumns = 2;
    static final int battleRows = 3;
    //Text that displays player HP in battle pane
    static Label playerHp;
    //Text that displays enemy HP in battle pane
    static Label enemyHp;
    //Buttons for player to choose an attack
    static Button btn_Att1;
    static Button btn_Att2;
    static Button btn_Att3;
    static Button btn_Att4;
    
    static GridPane monsterChoice;
    static GridPane monsterPane;
    static GridPane levelUpPane;
    
    //Defines a max size for buttons
    static final int maxButtonHeight = Integer.MAX_VALUE;
    static final int maxButtonWidth = Integer.MAX_VALUE;
    //CSS code that changes the design of all the buttons
    static final String buttonStyle = "-fx-background-color:" +
            "linear-gradient(#000020 55%, #606090 100%);" +
            "-fx-background-insets: 5;" +
            "-fx-background-radius: 15, 10;" +
            "-fx-text-fill: #F0F0F0;" +
            "-fx-font: bolder 32 \"Noto Sans Light\";" +
            "-fx-border-color: #E0E0FF;" +
            "-fx-border-width: 8;" +
            "-fx-border-radius: 15, 5;" +
            "-fx-border-insets: 3;" +
            "-fx-padding: 2;";
    
    //Similar to 'buttonStyle', except with a smaller font size
    static final String battleButtonStyle = "-fx-background-color:" +
            "linear-gradient(#000020 55%, #606090 100%);" +
            "-fx-background-insets: 5;" +
            "-fx-background-radius: 15, 10;" +
            "-fx-text-fill: #F0F0F0;" +
            "-fx-font: 16 \"Noto Sans Light\";" +
            "-fx-border-color: #E0E0FF;" +
            "-fx-border-width: 8;" +
            "-fx-border-radius: 15, 5;" +
            "-fx-border-insets: 3;" +
            "-fx-padding: 2;";
    
    static final String textAreaStyle = "-fx-background-color:" +
            "linear-gradient(#000020 33%, #000040 100%);" +
            "-fx-background-insets: 5;" +
            "-fx-background-radius: 15, 10;" +
            "-fx-text-fill: #F0F0F0;" +
            "-fx-font: 16 \"Noto Sans Light\";" +
            "-fx-border-color: #E0E0F0;" +
            "-fx-border-width: 8;" +
            "-fx-border-radius: 15, 5;" +
            "-fx-border-insets: 3;" +
            "-fx-padding: 2;" +
            "-fx-wrap-text: true;";
    
    static final String levelUpTextStyle = "-fx-background-color:" +
            "linear-gradient(#000020 33%, #000040 100%);" +
            "-fx-background-insets: 5;" +
            "-fx-background-radius: 15, 10;" +
            "-fx-text-fill: #F0F0F0;" +
            "-fx-font: 16 \"Noto Sans Light\";" +
            "-fx-border-color: #E0E0F0;" +
            "-fx-border-width: 8;" +
            "-fx-border-radius: 15, 5;" +
            "-fx-border-insets: 3;" +
            "-fx-padding: 2;" +
            "-fx-wrap-text: true;" +
            "-fx-text-alignment: justify;";
            
    static int level = 1;
    
    static int gold = 0;
    
    static Label goldAmt = new Label("Gold: " + gold);
    
    static Abstract_Attack newAttack;
    
    //Creates instances of player and enemy monster
    static Abstract_Monster player = new Goblin();
    static Abstract_Monster enemy = new Goblin();
    
    static Abstract_Monster Monster1;
    static Abstract_Monster Monster2;
    static Abstract_Monster Monster3;
        
    
    @Override
    public void start(Stage stage) {
        //Initialize the main stage/ window
        primaryStage = stage;
        //Sets title of the stage/ window
        primaryStage.setTitle("Goblins Stole My Bike");
        
        //Creates and defines VBox 'right'
        create_VBox_Right();
        
        //Creates entire scene battle will take place on
        create_Battle_Pane();
        
        create_Level_Up_Pane();
        
        monster_Choice();
        
        monster_Pane();
        
        
        
        //Main area that will hold all other UI elements of the game
        //  BorderPanes are divided up into 5 sections: top, right, bottom, left, and center
        //  'main' will (currently) only use right and center regions
        //The 'center' region will swap out for each different screen
        mainPane = new BorderPane();
        
        //Places 'right' onto right region of 'main'
        mainPane.setRight(rightBox);
        
        //Places placeholder image to center region
        mainPane.setCenter(levelUpPane);
        
        //Creates main scene for the game and puts the mainPane onto it
        //The scene will be the WIDTH and HEIGHT defined above
        primaryScene = new Scene(mainPane, WIDTH, HEIGHT);;
        
        
        mainPane.setCenter(monsterChoice);
        
        

        
        //Sets the scene onto the stage
        primaryStage.setScene(primaryScene);
        //Shows the stage (stage is hidden until this is called)
        primaryStage.show();
    }
    
    public void create_VBox_Right() {
        //'VBox right' will hold all menu elements and the 'history' text area
        rightBox = new VBox();
        rightBox.setStyle("-fx-background-color:" +
            "linear-gradient(#000000, #000035);");
        
        //Set alignment to top center of its container pane (in this case, right region of 'main')
        rightBox.setAlignment(Pos.TOP_CENTER);
        //Width is set to 40% of btnWidth of window
        rightBox.setPrefWidth(WIDTH * 0.4);
        //10 px spacing between nodes in vbox
        rightBox.setSpacing(10);
        //10 px 'border' around contents in vbox
        rightBox.setPadding(new Insets(10, 10, 10, 10));
        
        //Defines the menuGrid
        create_GridPane_MenuGrid();
        
        //Creates the history text box
        create_TilePane_History();
        
        //Adds 'menuGrid' and 'history' to 'right'
        rightBox.getChildren().addAll(menuGrid, history);
    }
    
    public void create_GridPane_MenuGrid() {
        //'menuGrid' will be used to hold all buttons that lead to different events
        menuGrid = new GridPane();
        
        //menuGrid will be centered in its container
        menuGrid.setAlignment(Pos.CENTER);
        
        //Sets the preffered btnWidth size for each column in the 'menuGrid'
        //  EX: 4 columns = each has 25% btnWidth of 'right' (which is 40% of total screen size)
        ColumnConstraints cc = new ColumnConstraints();
        cc.setPrefWidth(rightBox.getPrefWidth() / menuColumns);
        //for loop that adds a constraint for each column
        for (int i = 0; i < menuColumns; i++) menuGrid.getColumnConstraints().add(cc);
        
        //Set gap and padding
        menuGrid.setHgap(5);
        menuGrid.setVgap(5);
        menuGrid.setPadding(new Insets(0, 0, 5, 0));
             
        //Creates menu buttons and assigns them to menuGrid
        create_Buttons_For_MenuGrid();
        
        //Add buttons to left column of 'right'
        //  The integers are the (column, row) position
        menuGrid.add(btn_Battle, 0, 0);
        menuGrid.add(btn_FinalBoss, 0, 1);
        menuGrid.add(btn_Main, 0, 2);
        menuGrid.add(btn_Boss, 1, 0);
        menuGrid.add(btn_LevelUp, 1, 1);
        menuGrid.add(btn_End, 1, 2);
    }
    
    public void create_Buttons_For_MenuGrid() {
        //Width will be the maximum value it can be
        final double btnWidth = maxButtonWidth;
        
        //Button btnHeight will be 1/2 screen size divided by number of rows
        //  EX: 3 rows = (1/2 btnHeight of screen) / (3 buttons)
        final double btnHeight = HEIGHT * 0.50 / menuRows;
        
        //Create the "Battle" button
        btn_Battle = new Button("Battle");
        btn_Battle.setPrefWidth(btnWidth);
        btn_Battle.setPrefHeight(btnHeight);
        btn_Battle.setStyle(buttonStyle);
        btn_Battle.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                enemy = generateRandomMonster();
                levelUpEnemyMonster(); 
                create_Battle_Pane();
                set_Battle_Pane();
                btn_Battle.setDisable(true);
                btn_Main.setDisable(true);
                btn_Boss.setDisable(true);
                btn_FinalBoss.setDisable(true);
                mainPane.setCenter(battle);
            }
        });
        
        //Button "Boss"
        btn_Boss = new Button("Boss");
        btn_Boss.setPrefWidth(btnWidth);
        btn_Boss.setPrefHeight(btnHeight);
        btn_Boss.setStyle(buttonStyle);
        btn_Boss.setDisable(true);
        btn_Boss.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                isBossBattle = true;
                enemy = generateRandomMonster();
                levelUpEnemyMonster(); 
                enemy.setBaseHealth( enemy.getBaseHealth() * 1.25);
                enemy.resetCurrStats();
                create_Battle_Pane();
                set_Battle_Pane();
                btn_Battle.setDisable(true);
                btn_Main.setDisable(true);
                btn_Boss.setDisable(true);
                btn_FinalBoss.setDisable(true);
                mainPane.setCenter(battle);
            }
        });
        
        //Button "Inventory"
        btn_FinalBoss = new Button("???");
        btn_FinalBoss.setPrefWidth(btnWidth);
        btn_FinalBoss.setPrefHeight(btnHeight);
        btn_FinalBoss.setStyle(buttonStyle);
        btn_FinalBoss.setDisable(true);
        btn_FinalBoss.setVisible(false);
        btn_FinalBoss.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                isFinalBossBattle = true;
                enemy = new Goblin();
                create_Battle_Pane();
                set_Battle_Pane();
                btn_Battle.setDisable(true);
                btn_Main.setDisable(true);
                btn_FinalBoss.setDisable(true);
                mainPane.setCenter(battle);
            }
        });
        
        btn_End = new Button("Quit");
        btn_End.setPrefWidth(btnWidth);
        btn_End.setPrefHeight(btnHeight);
        btn_End.setStyle(buttonStyle);
        btn_End.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.exit(0);
            }
        });
        
        btn_LevelUp = new Button("Level Up");
        btn_LevelUp.setPrefWidth(btnWidth);
        btn_LevelUp.setPrefHeight(btnHeight);
        btn_LevelUp.setStyle(buttonStyle);
        btn_LevelUp.setDisable(true);
        btn_LevelUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                isBossBattle = false;
                isFinalBossBattle = false;
                btn_Battle.setDisable(true);
                btn_Boss.setDisable(true);
                btn_FinalBoss.setDisable(true);
                btn_LevelUp.setDisable(true);
                btn_Main.setDisable(true);
                player.levelUp();
                create_Level_Up_Pane();
                mainPane.setCenter(levelUpPane);
            }
        });
        
        btn_Main = new Button("Main");
        btn_Main.setPrefWidth(btnWidth);
        btn_Main.setPrefHeight(btnHeight);
        btn_Main.setStyle(buttonStyle);
        btn_Main.setDisable(true);
        btn_Main.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            //If player defeated boss

            if (isBossBattle && (player.getCurrHealth() >= enemy.getCurrHealth())) {
                if (level < 5) {
                    level++;
                    btn_LevelUp.setDisable(false);
                }
            }
            if (isFinalBossBattle && (player.getCurrHealth() >= enemy.getCurrHealth())) {
                mainPane.setCenter(new ImageView(new Image(getClass().getResourceAsStream("Monsters/Icons/TheBike.png"))));
                mainPane.setStyle("-fx-background-color:linear-gradient(#00F0F0 33%, #205050 100%)");
                player = new Goblin();
                player.setBaseStrength(100);
                player.setBaseDefense(100);
            }
            else {
                monster_Pane();
                mainPane.setCenter(monsterPane);
            }
            //If player gets enough gold to fight boss
            if (level == 1 && gold >= 100) {
                btn_Boss.setDisable(false);
            }
            else if (level == 2 && gold >= 1000) {
                btn_Boss.setDisable(false);
            }
            else if (level == 3 && gold >= 10000) {
                btn_Boss.setDisable(false);
            }
            else if (level == 4 && gold >= 100000) {
                btn_Boss.setDisable(false);
            }
            else if (level >= 5 && gold >= 1000000) {
                btn_FinalBoss.setVisible(true);
                btn_FinalBoss.setDisable(false);
            }
            
            isBossBattle = false;
            isFinalBossBattle = false;
            
            btn_Battle.setDisable(false);
            btn_Main.setDisable(true);
            history.clear();
            player.resetCurrStats();
            }
        });
    }
    
    public void create_TilePane_History() {
        history = new TextArea();
        history.setStyle(textAreaStyle);
    }
    
    public void create_Battle_Pane() {
        //Initializes 'battle' as a GridPane
        battle = new GridPane();
        //Sets 'battle' to be in the center of it's container
        battle.setAlignment(Pos.CENTER);
        
        battle.setStyle("-fx-background-color: linear-gradient(#00F0F0 33%, #205050 100%)");
        
        //Creates the formatting used on the columns of the 'battle' pane
        ColumnConstraints cc = new ColumnConstraints();
        //Set to 60% OF WIDTH becasue 'rightBox' always has the other 40% of the screen
        cc.setPrefWidth(WIDTH * 0.6 / battleColumns);
        cc.setMaxWidth(WIDTH * 0.6 / battleColumns);
        cc.setHalignment(HPos.CENTER);
        for (int i = 0; i < battleColumns; i++) battle.getColumnConstraints().add(cc);
        
        //Creates the formatting used on the rows of the 'battle' pane
        RowConstraints rc = new RowConstraints();
        rc.setPrefHeight(HEIGHT / battleRows);
        rc.setMaxHeight(HEIGHT / battleRows);
        rc.setValignment(VPos.CENTER);
        for (int i = 0; i < battleRows; i++) battle.getRowConstraints().add(rc);
        
        //Creates viewable images using the images of both monsters
        ImageView playerImg = new ImageView(player.getImg());
        //Keeps the image ratio and roughly fits it in a 250x250 area
        playerImg.setPreserveRatio(true);
        playerImg.setFitHeight(250);
        playerImg.setFitWidth(250);
        ImageView enemyImg = new ImageView(enemy.getImg());
        enemyImg.setPreserveRatio(true);
        enemyImg.setFitHeight(250);
        enemyImg.setFitWidth(250);
        
        //Create the text that displays the monsters' health
        //Sets the font size to 24
        //Text is displayed as "Enemy HP: 00 / 00"
        enemyHp = new Label("Enemy HP: " + new DecimalFormat("##").format(enemy.getCurrHealth()) + " / " + new DecimalFormat("##").format(enemy.getBaseHealth()));
        enemyHp.setStyle("-fx-font: 24 \"Noto Sans Light\"; -fx-text-fill: #100000;");
        //Text is displayed as "Player HP: 00 / 00"
        playerHp = new Label("Player HP: " + new DecimalFormat("##").format(player.getCurrHealth()) + " / " + new DecimalFormat("##").format(player.getBaseHealth()));
        playerHp.setStyle("-fx-font: 24 \"Noto Sans Light\"; -fx-text-fill: #100000;");
        
        create_Buttons_For_Battle_Pane();
        
        HBox moves = new HBox(); 
        moves.getChildren().addAll(btn_Att1, btn_Att2, btn_Att3, btn_Att4);
        battle.setColumnSpan(moves, 2);
        battle.setRowSpan(rightBox, 3);
        
        battle.add(playerHp, 0, 0);
        battle.add(playerImg, 0, 1);
        battle.add(enemyHp, 1, 0);
        battle.add(enemyImg, 1, 1);
        battle.add(moves, 0, 2);
    }
    
    public void create_Buttons_For_Battle_Pane() {
        //The width and height of buttons will be as large as possible
        int btnWidth = maxButtonWidth;
        int btnHeight = maxButtonHeight;
        
        btn_Att1 = new Button(player.getAtt1().getName());
        btn_Att1.setPrefWidth(btnWidth);
        btn_Att1.setPrefHeight(btnHeight);
        btn_Att1.setStyle(battleButtonStyle);
        btn_Att1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                
                double damage = Math.floor( player.getAtt1().calcDamage(player, enemy) );
                enemy.takeDamage( damage );
                
                if (enemy.isWeak( player.getAtt1().getElement()) ) {
                    history.appendText("Effective! ");
                }
                else if ( enemy.isResist( player.getAtt1().getElement() ) ) {
                    history.appendText("Weak. ");
                }
                
                history.appendText( enemy.getName() + " took " + damage + " damage!\n");
                
                chooseAttack(enemy);
                playerHp.setText("Player HP: " + new DecimalFormat("##").format(player.getCurrHealth()) + " / " + new DecimalFormat("##").format(player.getBaseHealth()));
                enemyHp.setText("Enemy HP: " + new DecimalFormat("##").format(enemy.getCurrHealth()) + " / " + new DecimalFormat("##").format(enemy.getBaseHealth()));

                
                //If player or enemy dies
                if (player.getCurrHealth() <= 0 || enemy.getCurrHealth() <= 0) {
                    btn_Att1.setDisable(true);
                    btn_Att2.setDisable(true);
                    btn_Att3.setDisable(true);
                    btn_Att4.setDisable(true);
                    btn_Main.setDisable(false);
                    if (enemy.getCurrHealth() <= player.getCurrHealth()) {
                        double gainGold = ThreadLocalRandom.current().nextInt(10, 16) * Math.pow(10, level - 1);
                        history.appendText("You win! You gain " + gainGold + " gold.");
                        gold += gainGold;
                    }
                    else {
                        double loseGold = ThreadLocalRandom.current().nextInt(2, 6) * Math.pow(10, level - 1);
                        history.appendText("You were defeated. You lose " + loseGold + " gold.");
                        gold -= loseGold;
                    }
                }
                
                
            }
        });
        
        btn_Att2 = new Button(player.getAtt2().getName());
        btn_Att2.setPrefWidth(btnWidth);
        btn_Att2.setPrefHeight(btnHeight);
        btn_Att2.setStyle(battleButtonStyle);
        btn_Att2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                double damage = Math.floor( player.getAtt2().calcDamage(player, enemy) );
                enemy.takeDamage(damage);
                
                if (enemy.isWeak( player.getAtt2().getElement()) ) {
                    history.appendText("Effective! ");
                }
                else if ( enemy.isResist( player.getAtt2().getElement() ) ) {
                    history.appendText("Weak. ");
                }
                
                history.appendText( enemy.getName() + " took " + damage + " damage!\n");
                
                chooseAttack(enemy);
                playerHp.setText("Player HP: " + new DecimalFormat("##").format(player.getCurrHealth()) + " / " + new DecimalFormat("##").format(player.getBaseHealth()));
                enemyHp.setText("Enemy HP: " + new DecimalFormat("##").format(enemy.getCurrHealth()) + " / " + new DecimalFormat("##").format(enemy.getBaseHealth()));
                
                if (player.getCurrHealth() <= 0 || enemy.getCurrHealth() <= 0) {
                    btn_Att1.setDisable(true);
                    btn_Att2.setDisable(true);
                    btn_Att3.setDisable(true);
                    btn_Att4.setDisable(true);
                    btn_Main.setDisable(false);
                    if (enemy.getCurrHealth() <= player.getCurrHealth()) {
                        double gainGold = ThreadLocalRandom.current().nextInt(10, 16) * Math.pow(10, level - 1);
                        history.appendText("You win! You gain " + gainGold + " gold.");
                        gold += gainGold;
                    }
                    else {
                        double loseGold = ThreadLocalRandom.current().nextInt(2, 6) * Math.pow(10, level - 1);
                        history.appendText("You were defeated. You lose " + loseGold + " gold.");
                        gold -= loseGold;
                    }
                }
            }
        });
        
        btn_Att3 = new Button(player.getAtt3().getName());
        btn_Att3.setPrefWidth(btnWidth);
        btn_Att3.setPrefHeight(btnHeight);
        btn_Att3.setStyle(battleButtonStyle);
        btn_Att3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                double damage = Math.floor( player.getAtt3().calcDamage(player, enemy) );
                enemy.takeDamage(damage);
                
                if (enemy.isWeak( player.getAtt3().getElement()) ) {
                    history.appendText("Effective! ");
                }
                else if ( enemy.isResist( player.getAtt3().getElement() ) ) {
                    history.appendText("Weak. ");
                }
                
                history.appendText( enemy.getName() + " took " + damage + " damage!\n");
                
                chooseAttack(enemy);
                playerHp.setText("Player HP: " + new DecimalFormat("##").format(player.getCurrHealth()) + " / " + new DecimalFormat("##").format(player.getBaseHealth()));
                enemyHp.setText("Enemy HP: " + new DecimalFormat("##").format(enemy.getCurrHealth()) + " / " + new DecimalFormat("##").format(enemy.getBaseHealth()));
                
                if (player.getCurrHealth() <= 0 || enemy.getCurrHealth() <= 0) {
                    btn_Att1.setDisable(true);
                    btn_Att2.setDisable(true);
                    btn_Att3.setDisable(true);
                    btn_Att4.setDisable(true);
                    btn_Main.setDisable(false);
                    if (enemy.getCurrHealth() <= player.getCurrHealth()) {
                        double gainGold = ThreadLocalRandom.current().nextInt(10, 16) * Math.pow(10, level - 1);
                        history.appendText("You win! You gain " + gainGold + " gold.");
                        gold += gainGold;
                    }
                    else {
                        double loseGold = ThreadLocalRandom.current().nextInt(2, 6) * Math.pow(10, level - 1);
                        history.appendText("You were defeated. You lose " + loseGold + " gold.");
                        gold -= loseGold;
                    }
                }
            }
        });
        
        btn_Att4 = new Button(player.getAtt4().getName());
        btn_Att4.setPrefWidth(btnWidth);
        btn_Att4.setPrefHeight(btnHeight);
        btn_Att4.setStyle(battleButtonStyle);
        btn_Att4.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                double damage = Math.floor( player.getAtt4().calcDamage(player, enemy) );
                enemy.takeDamage(damage);
                
                if (enemy.isWeak( player.getAtt4().getElement()) ) {
                    history.appendText("Effective! ");
                }
                else if ( enemy.isResist( player.getAtt4().getElement() ) ) {
                    history.appendText("Weak. ");
                }
                
                history.appendText( enemy.getName() + " took " + damage + " damage!\n");
                
                chooseAttack(enemy);
                playerHp.setText("Player HP: " + new DecimalFormat("##").format(player.getCurrHealth()) + " / " + new DecimalFormat("##").format(player.getBaseHealth()));
                enemyHp.setText("Enemy HP: " + new DecimalFormat("##").format(enemy.getCurrHealth()) + " / " + new DecimalFormat("##").format(enemy.getBaseHealth()));
                
                if (player.getCurrHealth() <= 0 || enemy.getCurrHealth() <= 0) {
                    btn_Att1.setDisable(true);
                    btn_Att2.setDisable(true);
                    btn_Att3.setDisable(true);
                    btn_Att4.setDisable(true);
                    btn_Main.setDisable(false);
                    if (enemy.getCurrHealth() <= player.getCurrHealth()) {
                        double gainGold = ThreadLocalRandom.current().nextInt(10, 16) * Math.pow(10, level - 1);
                        history.appendText("You win! You gain " + gainGold + " gold.");
                        gold += gainGold;
                    }
                    else {
                        double loseGold = ThreadLocalRandom.current().nextInt(2, 6) * Math.pow(10, level - 1);
                        history.appendText("You were defeated. You lose " + loseGold + " gold.");
                        gold -= loseGold;
                    }
                }
            }
        });
    }
    
    public void chooseAttack(Abstract_Monster monster) {
        //Choose a random int 1 - 4
        //nextInt(min, max + 1) Must add 1 to max or else it won't choose '4' (it will be 1-3)
        //Decrease player's HP by the enemy attack
        double damage;
        
        switch(ThreadLocalRandom.current().nextInt(1, 5)){
            case 1:
                damage = Math.floor( enemy.getAtt1().calcDamage(enemy, player) );
                player.takeDamage(damage);
                if (player.isWeak( enemy.getAtt1().getElement()) ) {
                    history.appendText("Effective! ");
                }
                else if ( player.isResist( enemy.getAtt1().getElement() ) ) {
                    history.appendText("Weak. ");
                }
                history.appendText("You took " + damage + " damage!\n\n");
                break;
            case 2:
                damage = Math.floor( enemy.getAtt2().calcDamage(enemy, player) );
                player.takeDamage(damage);
                if (player.isWeak( enemy.getAtt2().getElement()) ) {
                    history.appendText("Effective! ");
                }
                else if ( player.isResist( enemy.getAtt2().getElement() ) ) {
                    history.appendText("Weak. ");
                }
                history.appendText("You took " + damage + " damage!\n\n");
                break;
            case 3:
                damage = Math.floor( enemy.getAtt3().calcDamage(enemy, player) );
                player.takeDamage(damage);
                if (player.isWeak( enemy.getAtt3().getElement()) ) {
                    history.appendText("Effective! ");
                }
                else if ( player.isResist( enemy.getAtt3().getElement() ) ) {
                    history.appendText("Weak. ");
                }
                history.appendText("You took " + damage + " damage!\n\n");
                break;
            case 4:
                damage = Math.floor( enemy.getAtt4().calcDamage(enemy, player) );
                player.takeDamage(damage);
                if (player.isWeak( enemy.getAtt4().getElement()) ) {
                    history.appendText("Effective! ");
                }
                else if ( player.isResist( enemy.getAtt4().getElement() ) ) {
                    history.appendText("Weak. ");
                }
                history.appendText("You took " + damage + " damage!\n\n");
                break;
        }
    }
    
    public void set_Battle_Pane() {
        btn_Battle.setDisable(true);
        btn_Main.setDisable(true);
        
        player.resetCurrStats();
        
        enemy.resetCurrStats();
        btn_Att1.setText( player.getAtt1().getName() );
        btn_Att2.setText( player.getAtt2().getName() );
        btn_Att3.setText( player.getAtt3().getName() );
        btn_Att4.setText( player.getAtt4().getName() );
    }
    
    public Abstract_Monster generateRandomMonster() {
        
        Abstract_Monster newMonster;
        int randInt = ThreadLocalRandom.current().nextInt(1, 22);
        
        //Picks a random number between 1-26 (2nd number needs to be +1)
        switch(randInt) {
            case 1:
                return new Abomination();
            case 2:
                return new Alaz();
            case 3:
                return new Alien();
            case 4:
                return new Baseon();
            case 5:
                return new Defender();
            case 6:
                return new Earthwarm();
            case 7:
                return new Firemon();
            case 8:
                return new Ghostmon();
            case 9:
                return new Ifri();
            case 10:
                return new Lefee();
            case 11:
                return new Los();
            case 12:
                return new Magicon();
            case 13:
                return new Mazu();
            case 14:
                return new Muten();
            case 15:
                return new Osiris();
            case 16:
                return new Robot();
            case 17:
                return new Shockey();
            case 18:
                return new Volos();
            case 19:
                return new Watermon();
            case 20:
                return new Windmon();
            case 21: default:
                return new Zhurong();
        }
    }
    
    public void levelUpEnemyMonster() {
        for (int i = 1; i < level; i++) {
            enemy.levelUp();
            newAttack = enemy.learnNewAttack();
            switch(ThreadLocalRandom.current().nextInt(1, 6)){
                case 1:
                    enemy.setAtt1( newAttack );
                    break;
                case 2:
                    enemy.setAtt2( newAttack );
                    break;
                case 3:
                    enemy.setAtt3( newAttack );
                    break;
                case 4:
                    enemy.setAtt4( newAttack );
                case 5: default:
                    //Enemy does not learn new attack
                    break;
            }
        }
    }
    
    public void create_Level_Up_Pane() {
        levelUpPane = new GridPane();
        levelUpPane.setAlignment(Pos.CENTER);
        
        levelUpPane.setStyle("-fx-background-color: linear-gradient(#000020 33%, #000040 100%);");
        
        final Button btn_newAtt;
        final Button btn_lvlUpAtt1;
        final Button btn_lvlUpAtt2;
        final Button btn_lvlUpAtt3;
        final Button btn_lvlUpAtt4;


        
        ColumnConstraints cc = new ColumnConstraints();
        //Set to 60% OF WIDTH becasue 'rightBox' always has the other 40% of the screen
        cc.setPrefWidth(WIDTH * 0.6);
        cc.setMaxWidth(WIDTH * 0.6);
        cc.setHalignment(HPos.CENTER);
        battle.getColumnConstraints().add(cc);
        
        //Creates the formatting used on the rows of the 'battle' pane
        RowConstraints rc = new RowConstraints();
        rc.setPrefHeight(HEIGHT / 3);
        rc.setMaxHeight(HEIGHT / 3);
        rc.setValignment(VPos.CENTER);
        for (int i = 0; i < 3; i++) levelUpPane.getRowConstraints().add(rc);
        
        if (player.getLevel() > 1) {
            newAttack = player.learnNewAttack();
        }
        else {
            newAttack = player.getAtt1();
        }
        
        btn_newAtt = new Button( newAttack.getName() );
        btn_newAtt.setPrefWidth(maxButtonWidth);
        btn_newAtt.setPrefHeight(maxButtonHeight);
        btn_newAtt.setStyle(buttonStyle);
        
        
        btn_lvlUpAtt1 = new Button( player.getAtt1().getName() );
        btn_lvlUpAtt1.setPrefWidth(maxButtonWidth);
        btn_lvlUpAtt1.setPrefHeight(maxButtonHeight);
        btn_lvlUpAtt1.setStyle(buttonStyle);
        
        
        btn_lvlUpAtt2 = new Button( player.getAtt2().getName() );
        btn_lvlUpAtt2.setPrefWidth(maxButtonWidth);
        btn_lvlUpAtt2.setPrefHeight(maxButtonHeight);
        btn_lvlUpAtt2.setStyle(buttonStyle);
        
        
        btn_lvlUpAtt3 = new Button( player.getAtt3().getName() );
        btn_lvlUpAtt3.setPrefWidth(maxButtonWidth);
        btn_lvlUpAtt3.setPrefHeight(maxButtonHeight);
        btn_lvlUpAtt3.setStyle(buttonStyle);
        
        
        btn_lvlUpAtt4 = new Button( player.getAtt4().getName() );
        btn_lvlUpAtt4.setPrefWidth(maxButtonWidth);
        btn_lvlUpAtt4.setPrefHeight(maxButtonHeight);
        btn_lvlUpAtt4.setStyle(buttonStyle);
        
        
        btn_newAtt.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                btn_newAtt.setDisable(true);
                btn_newAtt.setText(":(");
                btn_lvlUpAtt1.setDisable(true);
                btn_lvlUpAtt2.setDisable(true);
                btn_lvlUpAtt3.setDisable(true);
                btn_lvlUpAtt4.setDisable(true);
                btn_Main.setDisable(false);
            }
        });
        btn_lvlUpAtt1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                player.setAtt1( newAttack );
                btn_lvlUpAtt1.setText( player.getAtt1().getName() );
                btn_newAtt.setDisable(true);
                btn_lvlUpAtt1.setDisable(true);
                btn_lvlUpAtt2.setDisable(true);
                btn_lvlUpAtt3.setDisable(true);
                btn_lvlUpAtt4.setDisable(true);
                btn_Main.setDisable(false);
            }
        });
        btn_lvlUpAtt2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                player.setAtt2( newAttack );
                btn_lvlUpAtt2.setText( player.getAtt2().getName() );
                btn_newAtt.setDisable(true);
                btn_lvlUpAtt1.setDisable(true);
                btn_lvlUpAtt2.setDisable(true);
                btn_lvlUpAtt3.setDisable(true);
                btn_lvlUpAtt4.setDisable(true);
                btn_Main.setDisable(false);
            }
        });
        btn_lvlUpAtt3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                player.setAtt3( newAttack );
                btn_lvlUpAtt3.setText( player.getAtt3().getName() );
                btn_newAtt.setDisable(true);
                btn_lvlUpAtt1.setDisable(true);
                btn_lvlUpAtt2.setDisable(true);
                btn_lvlUpAtt3.setDisable(true);
                btn_lvlUpAtt4.setDisable(true);
                btn_Main.setDisable(false);
            }
        });
        btn_lvlUpAtt4.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                player.setAtt4( newAttack );
                btn_lvlUpAtt4.setText( player.getAtt4().getName() );
                btn_newAtt.setDisable(true);
                btn_lvlUpAtt1.setDisable(true);
                btn_lvlUpAtt2.setDisable(true);
                btn_lvlUpAtt3.setDisable(true);
                btn_lvlUpAtt4.setDisable(true);
                btn_Main.setDisable(false);
            }
        });
        
        TextArea text = new TextArea("Select which move you would like to replace with the new move.\nClick the new move if you don't want to replace any.");
        text.setStyle(levelUpTextStyle);
        
        HBox attacks = new HBox();
        
        attacks.getChildren().addAll(btn_lvlUpAtt1, btn_lvlUpAtt2, btn_lvlUpAtt3, btn_lvlUpAtt4);
        
        levelUpPane.add(text, 0, 0);
        levelUpPane.add(btn_newAtt, 0, 1);
        levelUpPane.add(attacks, 0, 2);
    }
    
    public void monster_Choice(){
        monsterChoice = new GridPane();
        
        monsterChoice.setStyle("-fx-background-color: linear-gradient(#00F0F0 33%, #205050 100%)");
        
        Monster1 = generateRandomMonster();
        Monster2 = generateRandomMonster();
        Monster3 = generateRandomMonster();
        
        Button moBtn1 = new Button(Monster1.getName());
        moBtn1.setPrefWidth(maxButtonWidth);
        moBtn1.setPrefHeight(maxButtonHeight);
        moBtn1.setStyle(buttonStyle);
        moBtn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                player = Monster1;
                monster_Pane();
                mainPane.setCenter(monsterPane);
            }
        });
        
        
        Button moBtn2 = new Button(Monster2.getName());
        moBtn2.setPrefWidth(maxButtonWidth);
        moBtn2.setPrefHeight(maxButtonHeight);
        moBtn2.setStyle(buttonStyle);
        moBtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                player = Monster2;
                monster_Pane();
                mainPane.setCenter(monsterPane);
            }
        });
        
        Button moBtn3 = new Button(Monster3.getName());
        moBtn3.setPrefWidth(maxButtonWidth);
        moBtn3.setPrefHeight(maxButtonHeight);
        moBtn3.setStyle(buttonStyle);
        moBtn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                player = Monster3;
                monster_Pane();
                mainPane.setCenter(monsterPane);
            }
        });
        
        ImageView moImg1 = new ImageView(Monster1.getImg());
        moImg1.setPreserveRatio(true);
        moImg1.setFitHeight(HEIGHT / 3);
        
        ImageView moImg2 = new ImageView(Monster2.getImg());
        moImg2.setPreserveRatio(true);
        moImg2.setFitHeight(HEIGHT / 3);
        
        ImageView moImg3 = new ImageView(Monster3.getImg());
        moImg3.setPreserveRatio(true);
        moImg3.setFitHeight(HEIGHT / 3);
        
        RowConstraints rc = new RowConstraints();
        rc.setValignment(VPos.CENTER);
        rc.setMinHeight(HEIGHT / 3);
        rc.setPrefHeight(HEIGHT / 3);
        rc.setMaxHeight(HEIGHT / 3);
        //for loop that adds a constraint for each column
        for (int i = 0; i < 3; i++) monsterChoice.getRowConstraints().add(rc);
        
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHalignment(HPos.CENTER);
        cc.setMinWidth(HEIGHT / 3);
        cc.setPrefWidth(WIDTH / 3);
        cc.setMaxWidth(WIDTH / 3);
        for (int i = 0; i<3; i++) monsterChoice.getColumnConstraints().add(cc);
        
        TextArea moDet1 = new TextArea();
        moDet1.setStyle(textAreaStyle);
        moDet1.setText("Name: " + Monster1.getName() + "\nLevel: " + Monster1.getLevel()
            + "\nElement: " + Monster1.getElement() + "\n\nHP:  " + Monster1.getCurrHealth() + "\nSTR: " + Monster1.getCurrStrength() + 
            "\nDEF: " + Monster1.getCurrDefense() + "\n\nAttack 1: " + Monster1.getAtt1().getName() + "\nAttack 2: "
            + Monster1.getAtt2().getName() + "\nAttack 3: " + Monster1.getAtt3().getName() + "\nAttack 4: " + Monster1.getAtt4().getName());
        
        
        TextArea moDet2 = new TextArea();
        moDet2.setStyle(textAreaStyle);
        moDet2.setText("Name: " + Monster2.getName() + "\nLevel: " + Monster2.getLevel()
            + "\nElement: " + Monster2.getElement() + "\n\nHP:  " + Monster2.getCurrHealth() + "\nSTR: " + Monster2.getCurrStrength() + 
            "\nDEF: " + Monster2.getCurrDefense() + "\n\nAttack 1: " + Monster2.getAtt1().getName() + "\nAttack 2: "
            + Monster2.getAtt2().getName() + "\nAttack 3: " + Monster2.getAtt3().getName() + "\nAttack 4: " + Monster2.getAtt4().getName());
        
                
        TextArea moDet3 = new TextArea();
        moDet3.setStyle(textAreaStyle);
        moDet3.setText("Name: " + Monster3.getName() + "\nLevel: " + Monster3.getLevel()
            + "\nElement: " + Monster3.getElement() + "\n\nHP:  " + Monster3.getCurrHealth() + "\nSTR: " + Monster3.getCurrStrength() + 
            "\nDEF: " + Monster3.getCurrDefense() + "\n\nAttack 1: " + Monster3.getAtt1().getName() + "\nAttack 2: "
            + Monster3.getAtt2().getName() + "\nAttack 3: " + Monster3.getAtt3().getName() + "\nAttack 4: " + Monster3.getAtt4().getName());
        
        monsterChoice.add(moBtn1, 0,0);
        monsterChoice.add(moBtn2,0,1);
        monsterChoice.add(moBtn3,0,2);
        monsterChoice.add(moImg1,1,0);
        monsterChoice.add(moImg2,1,1);
        monsterChoice.add(moImg3,1,2);
        monsterChoice.add(moDet1,2,0);
        monsterChoice.add(moDet2,2,1);
        monsterChoice.add(moDet3,2,2);
        
        
  }
    
    public void monster_Pane(){
        monsterPane = new GridPane();
        monsterPane.setAlignment(Pos.CENTER);
        
        monsterPane.setStyle("-fx-background-color: linear-gradient(#00F0F0 33%, #205050 100%)");
       
        goldAmt = new Label();
        goldAmt.setText("Gold: " + gold);
        goldAmt.setStyle("-fx-font-size:45; -fx-alignment: center;");
        
        ImageView monsterImg = new ImageView(player.getImg());
        monsterImg.setPreserveRatio(true);
        monsterImg.setFitWidth(250);
        
        
        
        TextArea monsterInfo = new TextArea();
        monsterInfo.setStyle(textAreaStyle);
        monsterInfo.setText("Name: " + player.getName() + "\nLevel: " + player.getLevel()
            + "\nElement: " + player.getElement() + "\n\nHP:  " + player.getBaseHealth() + "\nSTR: " + player.getBaseStrength() + 
            "\nDEF: " + player.getBaseDefense() + "\n\nAttack 1: " + player.getAtt1().getName() + "\nAttack 2: "
            + player.getAtt2().getName() + "\nAttack 3: " + player.getAtt3().getName() + "\nAttack 4: " + player.getAtt4().getName());
        
        monsterPane.setAlignment(Pos.CENTER);
        ColumnConstraints cc = new ColumnConstraints();
        cc.setPrefWidth(WIDTH / 2);
        cc.setMaxWidth(WIDTH / 2);
        cc.setHalignment(HPos.CENTER);
       
        //for loop that adds a constraint for each column
        for (int i = 0; i < 2; i++) monsterPane.getColumnConstraints().add(cc);
        
        VBox box = new VBox();
        box.getChildren().addAll(goldAmt, monsterInfo);
        box.setStyle("-fx-alignment: top-center");
        
        monsterPane.add(monsterImg, 0, 0);
        monsterPane.add(box, 1, 0);
        
    }
    
}

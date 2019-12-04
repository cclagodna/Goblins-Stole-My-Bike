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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

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
    static GridPane monsterPane;
    static GridPane monsterChoice;
    //Defines how many columns and rows the menuGrid will have
    static final int menuColumns = 2;
    static final int menuRows = 3;
    //Menu buttons and comboBox with events that change current Pane. Located inside the menuGrid
    static Button btn_Battle;
    static Button btn_Boss;
    static Button btn_FinalBoss;
    static Button btn_LevelUp;
    static ComboBox monsterSelect;
    static Button btn_Main;
    static Button btn_End;
    //Displays text of events that occur during battle, contained in rightBox
    static TextArea history;
    //Defines how many rows will be displayed for 'history'
    static final int historyRows = 20;
    
    //Screen that will hold all objects relating to battle (monster, text, etc.)
    static GridPane battle;
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
    
    
    //Defines a max size for buttons
    static final int maxButtonHeight = Integer.MAX_VALUE;
    static final int maxButtonWidth = Integer.MAX_VALUE;
    //String holding FXML code that changes the button color
    static final String buttonStyle = "-fx-base: rgb(30,170,255);";
    
    
    static int level = 1;
    
    //Creates instances of player and enemy monster
    static Abstract_Monster player = new Goblin();
    static Abstract_Monster enemy = new Goblin();
    
    public void monster_Choice(){
        monsterChoice = new GridPane();
        Button moBtn1 = new Button("Monster 1");
        Button moBtn2 = new Button("Monster 2");
        Button moBtn3 = new Button("Monster 3");
        ImageView moImg1 = new ImageView(new Image(getClass().getResourceAsStream("icons/icon_shop.png")));
        ImageView moImg2 = new ImageView(new Image(getClass().getResourceAsStream("icons/icon_shop.png")));
        ImageView moImg3 = new ImageView(new Image(getClass().getResourceAsStream("icons/icon_shop.png")));
        
        Abstract_Monster Monster1 =new Goblin();
        Abstract_Monster Monster2 =new Goblin();
        Abstract_Monster Monster3 =new Goblin();
        
        TextArea moDet1 = new TextArea("Name:" + Monster1.getName() + "\n Level:" + Monster1.getLevel()
        + "\nElements:" + Monster1.getElement() + "\n\nHP:" + Monster1.getCurrHealth() + "\n Str:" + Monster1.getCurrStrength() + 
                "\n Def:" + Monster1.getCurrDefense() + "\n\n Attack 1:" + Monster1.getAtt1() + "\nAttack 2:"
                + Monster1.getAtt2() + "\n Attack 3:" + Monster1.getAtt3() + "\n Attack 4:" + Monster1.getAtt4());
        
        
                
            TextArea moDet2 = new TextArea("Name:" + Monster2.getName() + "\n Level:" + Monster2.getLevel()
        + "\nElements:" + Monster2.getElement() + "\n\nHP:" + Monster2.getCurrHealth() + "\n Str:" + Monster2.getCurrStrength() + 
                "\n Def:" + Monster2.getCurrDefense() + "\n\n Attack 1:" + Monster2.getAtt1() + "\nAttack 2:"
                + Monster2.getAtt2() + "\n Attack 3:" + Monster2.getAtt3() + "\n Attack 4:" + Monster2.getAtt4());
        
                
                TextArea moDet3 = new TextArea("Name:" + Monster3.getName() + "\n Level:" + Monster3.getLevel()
        + "\nElements:" + Monster3.getElement() + "\n\nHP:" + Monster3.getCurrHealth() + "\n Str:" + Monster3.getCurrStrength() + 
                "\n Def:" + Monster3.getCurrDefense() + "\n\n Attack 1:" + Monster3.getAtt1() + "\nAttack 2:"
                + Monster3.getAtt2() + "\n Attack 3:" + Monster3.getAtt3() + "\n Attack 4:" + Monster3.getAtt4());
        
        monsterChoice.setAlignment(Pos.CENTER);
        RowConstraints rc = new RowConstraints();
        rc.setPrefHeight(HEIGHT/3);
        //for loop that adds a constraint for each column
        for (int i = 0; i < 3; i++) monsterChoice.getRowConstraints().add(rc);
        
        ColumnConstraints cct = new ColumnConstraints();
        cct.setPrefWidth(WIDTH/3);
        for (int i = 0; i<3; i++) monsterChoice.getColumnConstraints().add(cct);
        
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
       
        Label goldAmt = new Label("Gold: 0");
        goldAmt.setStyle("-fx-border-color:black; -fx-font-size:70");
        ImageView monsterImg = new ImageView(new Image(getClass().getResourceAsStream("icons/icon_shop.png")));
        goldAmt.setStyle("-fx-border-color:black;");
        Label monsterInfo = new Label("Name:\n Level:\nElements:\nHP:\n Str:\n Def:\nAttack 1:\n Attack 2:\n Attack 3:\n Attack 4:");
        
        
        monsterPane.setAlignment(Pos.CENTER);
        RowConstraints rc = new RowConstraints();
        rc.setPrefHeight(HEIGHT/3);
        //for loop that adds a constraint for each column
        for (int i = 0; i < 3; i++) monsterPane.getRowConstraints().add(rc);
        
        monsterPane.add(goldAmt, 0,0);
        monsterPane.add(monsterImg,0,1);
        monsterPane.add(monsterInfo, 0,2);
        
   
        
        // 1/3 wi monster select new 
        
        
    
        
        
                
        
    }
    public void start(Stage stage) {
        //Initialize the main stage/ window
        primaryStage = stage;
        //Sets title of the stage/ window
        primaryStage.setTitle("Goblins Stole My Bike");
        
        //Creates and defines VBox 'right'
        create_VBox_Right();
        
        //Creates entire scene battle will take place on
        create_Battle_Pane();
        
        //Main area that will hold all other UI elements of the game
        //  BorderPanes are divided up into 5 sections: top, right, bottom, left, and center
        //  'main' will (currently) only use right and center regions
        //The 'center' region will swap out for each different screen
        mainPane = new BorderPane();
        
        //Places 'right' onto right region of 'main'
        mainPane.setRight(rightBox);
        monster_Pane();
        monster_Choice();
        //Places placeholder image to center region
        mainPane.setCenter(monsterChoice);
        
        //Creates main scene for the game and puts the mainPane onto it
        //The scene will be the WIDTH and HEIGHT defined above
        primaryScene = new Scene(mainPane, WIDTH, HEIGHT);
        //Fills the background color
        primaryScene.setFill(Paint.valueOf("AQUAMARINE"));
        
        //Sets the scene onto the stage
        primaryStage.setScene(primaryScene);
        //Shows the stage (stage is hidden until this is called)
        primaryStage.show();
    }
    
    public void create_VBox_Right() {
        //'VBox right' will hold all menu elements and the 'history' text area
        rightBox = new VBox();
        
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
        menuGrid.add(monsterSelect, 1, 1);
        menuGrid.add(btn_End, 1, 2);
    }
    
    public void create_Buttons_For_MenuGrid() {
        //Width will be the maximum value it can be
        final double btnWidth = maxButtonWidth;
        
        //Button btnHeight will be 1/2 screen size divided by number of rows
        //  EX: 3 rows = (1/2 btnHeight of screen) / (3 buttons)
        final double btnHeight = HEIGHT * 0.50 / menuRows;
        
        //Create the "Battle" button
        btn_Battle = new Button("Battle", new ImageView(new Image(getClass().getResourceAsStream("icons/icon_battle.png"))));
        btn_Battle.setPrefWidth(btnWidth);
        btn_Battle.setPrefHeight(btnHeight);
        btn_Battle.setStyle(buttonStyle);
        btn_Battle.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                mainPane.setCenter(battle);
            }
        });
        
        //Button "Boss"
        btn_Boss = new Button("Boss", new ImageView(new Image(getClass().getResourceAsStream("icons/icon_shop.png"))));
        btn_Boss.setPrefWidth(btnWidth);
        btn_Boss.setPrefHeight(btnHeight);
        btn_Boss.setStyle(buttonStyle);
        btn_Boss.setDisable(true);
        btn_Boss.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //mainStage.setScene(scene_Shop);
            }
        });
        
        //Button "Inventory"
        btn_FinalBoss = new Button("Backpack");
        btn_FinalBoss.setPrefWidth(btnWidth);
        btn_FinalBoss.setPrefHeight(btnHeight);
        btn_FinalBoss.setStyle(buttonStyle);
        btn_FinalBoss.setDisable(true);
        btn_FinalBoss.setVisible(false);
        btn_FinalBoss.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //mainStage.setScene(scene_Backpack);
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
        
        monsterSelect = new ComboBox();
        monsterSelect.getItems().add("MONSTER 1");
        monsterSelect.getItems().add("MONSTER 2");
        monsterSelect.getItems().add("MONSTER 3");
        monsterSelect.setPrefWidth(btnWidth);
        monsterSelect.setPrefHeight(btnHeight);
        monsterSelect.setStyle(buttonStyle);
        
        btn_Main = new Button("Main");
        btn_Main.setPrefWidth(btnWidth);
        btn_Main.setPrefHeight(btnHeight);
        btn_Main.setStyle(buttonStyle);
        btn_Main.setDisable(true);
        btn_Main.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            mainPane.setCenter(new ImageView(new Image(getClass().getResourceAsStream("icons/main.png"))));
            }
        });
    }
    
    public void create_TilePane_History() {
        //This textArea will display the history of actions and events
        //-----TO-DO-----: Needs functionality or to be removed
        history = new TextArea("This area will display text.");
        /*
        history = new TilePane();
        history.setPrefRows(historyRows);
        */
    }
    
    public void create_Battle_Pane() {
        //Initializes 'battle' as a GridPane
        battle = new GridPane();
        //Sets 'battle' to be in the center of it's container
        battle.setAlignment(Pos.CENTER);
        
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
        enemyHp.setFont(new Font(24));
        //Text is displayed as "Player HP: 00 / 00"
        playerHp = new Label("Player HP: " + new DecimalFormat("##").format(player.getCurrHealth()) + " / " + new DecimalFormat("##").format(player.getBaseHealth()));
        playerHp.setFont(new Font(24));
        
        create_Buttons_For_Battle_Pane();
        
        HBox moves = new HBox(5); 
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
        btn_Att1.setStyle(buttonStyle);
        btn_Att1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                enemy.takeDamage(player.getAtt1().calcDamage(player, enemy));
                enemyHp.setText("Enemy HP: " + new DecimalFormat("##").format(enemy.getCurrHealth()) + " / " + new DecimalFormat("##").format(enemy.getBaseHealth()));
                chooseAttack(enemy);
                playerHp.setText("Player HP: " + new DecimalFormat("##").format(player.getCurrHealth()) + " / " + new DecimalFormat("##").format(player.getBaseHealth()));
            }
        });
        
        btn_Att2 = new Button(player.getAtt2().getName());
        btn_Att2.setPrefWidth(btnWidth);
        btn_Att2.setPrefHeight(btnHeight);
        btn_Att2.setStyle(buttonStyle);
        btn_Att2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                enemy.takeDamage(player.getAtt2().calcDamage(player, enemy));
                enemyHp.setText("Enemy HP: " + new DecimalFormat("##").format(enemy.getCurrHealth()) + " / " + new DecimalFormat("##").format(enemy.getBaseHealth()));
                chooseAttack(enemy);
                playerHp.setText("Player HP: " + new DecimalFormat("##").format(player.getCurrHealth()) + " / " + new DecimalFormat("##").format(player.getBaseHealth()));
            }
        });
        
        btn_Att3 = new Button(player.getAtt3().getName());
        btn_Att3.setPrefWidth(btnWidth);
        btn_Att3.setPrefHeight(btnHeight);
        btn_Att3.setStyle(buttonStyle);
        btn_Att3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                enemy.takeDamage(player.getAtt3().calcDamage(player, enemy));
                enemyHp.setText("Enemy HP: " + new DecimalFormat("##").format(enemy.getCurrHealth()) + " / " + new DecimalFormat("##").format(enemy.getBaseHealth()));
                chooseAttack(enemy);
                playerHp.setText("Player HP: " + new DecimalFormat("##").format(player.getCurrHealth()) + " / " + new DecimalFormat("##").format(player.getBaseHealth()));
            }
        });
        
        btn_Att4 = new Button(player.getAtt4().getName());
        btn_Att4.setPrefWidth(btnWidth);
        btn_Att4.setPrefHeight(btnHeight);
        btn_Att4.setStyle(buttonStyle);
        btn_Att4.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                enemy.takeDamage(player.getAtt4().calcDamage(player, enemy));
                enemyHp.setText("Enemy HP: " + new DecimalFormat("##").format(enemy.getCurrHealth()) + " / " + new DecimalFormat("##").format(enemy.getBaseHealth()));
                chooseAttack(enemy);
                playerHp.setText("Player HP: " + new DecimalFormat("##").format(player.getCurrHealth()) + " / " + new DecimalFormat("##").format(player.getBaseHealth()));
            }
        });
    }
    
    public void chooseAttack(Abstract_Monster monster) {
        //Choose a random int 1 - 4
        //nextInt(min, max + 1) Must add 1 to max or else it won't choose '4' (it will be 1-3)
        //Decrease player's HP by the enemy attack
        switch(ThreadLocalRandom.current().nextInt(1, 5)){
            case 1:
                player.takeDamage(enemy.getAtt1().calcDamage(enemy, player));
                break;
            case 2:
                player.takeDamage(enemy.getAtt2().calcDamage(enemy, player));
                break;
            case 3:
                player.takeDamage(enemy.getAtt3().calcDamage(enemy, player));
                break;
            case 4:
                player.takeDamage(enemy.getAtt4().calcDamage(enemy, player));
                break;
        }
    }
    
    public void set_Battle_Pane() {
        btn_Battle.setDisable(true);
        btn_Main.setDisable(true);
        
        player.resetCurrStats();
        //generateEnemyMonster();
        enemy.resetCurrStats();
        btn_Att1.setText( player.getAtt1().getName() );
        btn_Att2.setText( player.getAtt2().getName() );
        btn_Att3.setText( player.getAtt3().getName() );
        btn_Att4.setText( player.getAtt4().getName() );
    }
    
    public void generateEnemyMonster() {
        /*
        switch(ThreadLocalRandom.current().nextInt(1, 11)) {
            case 1:
                enemy = new Abstract_Monster();
            case 2:
                enemy = new Abstract_Monster();
            case 3:
                enemy = new Abstract_Monster();
            case 4:
                enemy = new Abstract_Monster();
            case 5:
                enemy = new Abstract_Monster();
            case 6:
                enemy = new Abstract_Monster();
            case 7:
                enemy = new Abstract_Monster();
            case 8:
                enemy = new Abstract_Monster();
            case 9:
                enemy = new Abstract_Monster();
            case 10:
                enemy = new Abstract_Monster();
            default:
                enemy = new Abstract_Monster();
                
        }
    
        while (enemy.getLevel() < level) {
            enemy.levelUp();
        }
        */
    }
    
    public void create_Level_Up_Pane() {
        
    }
    
}

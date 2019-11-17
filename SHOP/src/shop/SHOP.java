/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label; 
import javafx.scene.Group;

/**
 *
 * @author ottaviojamil
 */
public class SHOP extends Application {
        //Initialize all static (or global) variables
    
    //Width and Height of game window
    static final int WIDTH = 1500;
    static final int HEIGHT = 900;
    
    //All nodes (or panes) being displayed in the game window
    static VBox right;
    static GridPane menu;
    static Button btn_ATTACKP1;
    static Button btn_ATTACKP2;
    static Button btn_DEFENSEP1;
    static Button btn_DEFENSEP2;
    static Button btn_monsters1;
    //static TilePane history;
    static TextArea history;
    static GridPane default_center;
    
    //Variables used in panes
    static final int menuColumns = 2;
    static final int menuRows = 3;
    static final int historyRows = 20;
           
    @Override
    public void start(Stage primaryStage) {
         primaryStage.setTitle("Goblins Stole My Bike");
        
        //Main area that will hold all other UI elements of the game
        //  BorderPanes are divided up into 5 sections: top, right, bottom, left, and center
        //  'main' will (currently) only use right and center regions
        BorderPane main = new BorderPane();
        
        //Method creating VBox called 'right'
        create_VBox_Right();
        
        //Creates a GridPane called 'menu'
        create_GridPane_Menu();
        
        //Creates all buttons for 'menu'
        create_Buttons_For_Menu();
        
        //Creates a TilePane called 'history'
       create_TilePane_History();
        
        //Adds 'menu' and 'history' to 'right'
        right.getChildren().addAll(menu, history);
        
        //Places 'right' onto right region
        main.setRight(right);
        //Places placeholder image to center region
       // main.setCenter(new ImageView(new Image(getClass().getResourceAsStream("icons/main.png"))));
         

        //Creates a new scene and places 'main' onto it
        Scene scene = new Scene(main, WIDTH, HEIGHT);
        //Places 'scene' onto 'primaryStage'
        primaryStage.setScene(scene);
        //Displays stage
        primaryStage.show();
        
        
        
        /*////////////////////////
        //                      //
        //                      //
        //  Put game loop here  //
        //                      //
        //                      //
        ////////////////////////*/
        
        

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
        
    public void create_VBox_Right() {
        right = new VBox();
        
        //Vertical box holding the UI elements on the right side of the screen
       // right.setAlignment(Pos.TOP_CENTER);
        right.setPrefWidth(WIDTH * .4);
        right.setSpacing(10);
        right.setPadding(new Insets(10, 10, 10, 10));
    }
    
    public void create_GridPane_Menu() {
        
        //'menu' will be used to hold all buttons that lead to different events
        menu = new GridPane();
        
        //Shows lines of the grid, used for debugging
        //menu.setGridLinesVisible(true);
        menu.setAlignment(Pos.CENTER);
        
        //Creates a ColumnConstraint for each column and sets the width as the
        //  width of the parent VBox 'right' divided by number of columns
        //  EX: 4 columns = each has 25% width of 'right'
        ColumnConstraints cc = new ColumnConstraints();
        cc.setPrefWidth(right.getPrefWidth() / menuColumns);
        for (int i = 0; i < menuColumns; i++) menu.getColumnConstraints().add(cc);
        
        //Set gap and padding
        menu.setHgap(5);
        menu.setVgap(5);
        menu.setPadding(new Insets(0, 0, 5, 0));
    }
    
    public void create_Buttons_For_Menu() {
        //Width will be the maximum value it can be
        double btnWidth = Double.MAX_VALUE;
        //Button height will be 1/2 screen size divided by number of rows
        //  EX: 3 rows = (1/2 height of screen) * (1/3 height of 'right')
        double btnHeight = HEIGHT * .5 / menuRows;
        
        //Initialize 'btn_battle' with text and graphic
       // btn_battle = new Button("Battle", new ImageView(new Image(getClass().getResourceAsStream("icons/icon_battle.png"))));
       btn_ATTACKP1 = new Button("THUNDER - 20HP");
       btn_ATTACKP1.setPrefWidth(btnWidth);
        btn_ATTACKP1.setPrefHeight(btnHeight);
                         btn_ATTACKP1.setStyle("-fx-base: rgb(30,170,255);");

        //Sets an EventHandler for button
        /*//-----TO-DO-----//
        Make a separate EventHandler method for each button
        ////-----TO-DO-----*/
        btn_ATTACKP1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.out.println("Button pressed!");
            }
        });
        
        //Button "Shop"
        btn_ATTACKP2 = new Button("EARTHQUAKE - 40HP");
        btn_ATTACKP2.setPrefWidth(btnWidth);
        btn_ATTACKP2.setPrefHeight(btnHeight);
                 btn_ATTACKP2.setStyle("-fx-base: rgb(30,170,255);");

        
        //Button "Inventory"
        btn_DEFENSEP1 = new Button("SHIELD +- 25HP");
        btn_DEFENSEP1.setPrefWidth(btnWidth);
        btn_DEFENSEP1.setPrefHeight(btnHeight);
         btn_DEFENSEP1.setStyle("-fx-base: rgb(30,170,255);");
        
        btn_DEFENSEP2 = new Button("END ENEMYS ATTACK");
        btn_DEFENSEP2.setPrefWidth(btnWidth);
        btn_DEFENSEP2.setPrefHeight(btnHeight);
         btn_DEFENSEP2.setStyle("-fx-base: rgb(30,170,255);");
                
        btn_monsters1 = new Button("RANDOM MONSTER 1");
        btn_monsters1.setPrefWidth(btnWidth);
        btn_monsters1.setPrefHeight(btnHeight);
 btn_monsters1.setStyle("-fx-base: rgb(30,170,255);");
 
        Label lbl_healing = new Label("HEALING POTIONS");
        lbl_healing.setLayoutX(100);
        lbl_healing.setLayoutY(150);

        
        Label lbl_attack = new Label("ATTACKING POTIONS");
        lbl_attack.setLayoutX(300); 
        lbl_attack.setLayoutY(100);
        
         Label lbl_defense = new Label("DEFENDING POTIONS");
        lbl_defense.setLayoutX(500); 
        lbl_defense.setLayoutY(300);
       
        //Add buttons to left column of 'right'
        menu.add(lbl_healing, 0 ,0);
        menu.add(lbl_attack, 0, 5);
        menu.add(lbl_defense, 0, 8);
        menu.add(btn_ATTACKP1, 0, 1);
        menu.add(btn_ATTACKP2, 0, 2);
        menu.add(btn_DEFENSEP1, 1, 1);
        menu.add(btn_DEFENSEP2, 1, 2);
     // menu.add(btn_monsters1, 2, 1);

        

       
    }
    
    public void create_TilePane_History() {
        history = new TextArea("");
        /*
        history = new TilePane();
        history.setPrefRows(historyRows);
        */
    }
    
    public void create_GridPane_Default_Center() {
        default_center = new GridPane();
    }
    
}
   
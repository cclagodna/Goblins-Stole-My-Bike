package GoblinsStoleMyBike;

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

public class Main extends Application{
    
    //Initialize all static (or global) variables
    
    //Width and Height of game window
    static final int WIDTH = 1200;
    static final int HEIGHT = 500;
    
    //All nodes (or panes) being displayed in the game window
    static BorderPane main;
    static VBox right;
    static GridPane menu;
    static Button btn_att1;
    static Button btn_att2;
    static Button btn_att3;
    static Button btn_backpack;
    static Button btn_run;
    static Button btn_endgame;
    //static TilePane history;
    static TextArea history;
    static GridPane default_center;
    
    static GridPane battle;
    static GridPane inventory;
    static GridPane shop;
    
    //Variables used in panes
    static final int menuColumns = 2;
    static final int menuRows = 3;
    static final int historyRows = 20;
    
    
    
    @Override
    public void start(Stage primaryStage) {
        //Sets title of the window
        primaryStage.setTitle("Goblins Stole My Bike");
        
        //Main area that will hold all other UI elements of the game
        //  BorderPanes are divided up into 5 sections: top, right, bottom, left, and center
        //  'main' will (currently) only use right and center regions
        main = new BorderPane();
        
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
        main.setCenter(new ImageView(new Image(getClass().getResourceAsStream("icons/des.png"))));
        
        //Creates a new scene and places 'main' onto it
        Scene scene = new Scene(main, WIDTH, HEIGHT);
        //Places 'scene' onto 'primaryStage'
        primaryStage.setScene(scene);
        //Displays stage
        primaryStage.show();
        
        
        //Battle.startBattle();
        /*////////////////////////
        //                      //
        //                      //
        //  Put game loop here  //
        //                      //
        //                      //
        ////////////////////////*/
        
    }
    
    public void create_VBox_Right() {
        right = new VBox();
        
        //Vertical box holding the UI elements on the right side of the screen
        right.setAlignment(Pos.TOP_CENTER);
        right.setPrefWidth(WIDTH * 0.4);
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
        double btnHeight = HEIGHT * 0.50 / menuRows;
        
        //Initialize 'btn_battle' with text and graphic
        //attack 1
        btn_att1 = new Button("ATTACK 1");
        btn_att1.setPrefWidth(btnWidth);
        btn_att1.setPrefHeight(btnHeight);
        //Sets an EventHandler for button
        /*//-----TO-DO-----//
        Make a separate EventHandler method for each button
        ////-----TO-DO-----*/
        btn_att1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.out.println("Button pressed!");
            }
        });
        
        //Button "Attack2"
        btn_att2 = new Button("ATTACK 2");
        btn_att2.setPrefWidth(btnWidth);
        btn_att2.setPrefHeight(btnHeight);
        
        //Button "Attack3"
        btn_att3 = new Button("ATTACK 3");
        btn_att3.setPrefWidth(btnWidth);
        btn_att3.setPrefHeight(btnHeight);
        
        btn_backpack = new Button("BACKPACK");
        btn_backpack.setPrefWidth(btnWidth);
        btn_backpack.setPrefHeight(btnHeight);
        
        //Button "Attack3"
        btn_run = new Button("RUN");
        btn_run.setPrefWidth(btnWidth);
        btn_run.setPrefHeight(btnHeight);
        
        btn_endgame = new Button("END Game");
        btn_endgame.setPrefWidth(btnWidth);
        btn_endgame.setPrefHeight(btnHeight);
        
        //Add buttons to left column of 'right'
        menu.add(btn_att1, 0, 0);
        menu.add(btn_att2, 0, 1);
        menu.add(btn_att3, 0, 2);
        menu.add(btn_backpack, 1, 0);
        menu.add(btn_run, 1, 1);
        menu.add(btn_endgame, 1, 2);
        
        //Adds 3 dummy buttons to right column
        //Button "Attack2"
        
        
        
        
        
    }
    
    public void create_TilePane_History() {
        history = new TextArea("This area will display text.");
        /*
        history = new TilePane();
        history.setPrefRows(historyRows);
        */
    }
    
    public void create_GridPane_Default_Center() {
        default_center = new GridPane();
    }
    
}
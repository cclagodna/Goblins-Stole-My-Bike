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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Goblins Stole My Bike");
        
        final int WIDTH = 1000;
        final int HEIGHT = 500;
        
        //Main pane that will hold all the UI elements of the game
        //BorderPanes are divided up into 5 sections, top, right, bottom, left, and center
        BorderPane main = new BorderPane();
        
        //Vertical box holding the UI elements on the right side of the screen
        VBox right = new VBox();
        right.setAlignment(Pos.TOP_CENTER);
        right.setPrefWidth(WIDTH * 0.4);
        right.setSpacing(10);
        right.setPadding(new Insets(10, 10, 10, 10));
        
        //Places onto "main" pane
        main.setRight(right);
        main.setCenter(new ImageView(new Image(getClass().getResourceAsStream("icons/main.png"))));
        
        //Grid that will hold all menu buttons
        //This is a GridPane in a VBox on the right side of a BorderPane
        final int columns = 2;
        final int rows = 3;
        GridPane menu = new GridPane();
        //menu.setGridLinesVisible(true);
        menu.setAlignment(Pos.CENTER);
        
        //Creates a ColumnConstraint for each column and sets its width as the width of the parent VBox / # of columns (EX: 4 col = 25% width of VBox)
        ColumnConstraints cc = new ColumnConstraints();
        cc.setPrefWidth(right.getPrefWidth() / columns);
        for (int i = 0; i < columns; i++) menu.getColumnConstraints().add(cc);
        
        //Set gap and padding
        menu.setHgap(5);
        menu.setVgap(5);
        menu.setPadding(new Insets(0, 0, 10, 0));
        
        //Initialize with graphic and "Battle" text
        Button btn_battle = new Button("Battle", new ImageView(new Image(getClass().getResourceAsStream("icons/icon_battle.png"))));
        btn_battle.setPrefWidth(Double.MAX_VALUE); //Width will be the maximum it can be
        btn_battle.setPrefHeight(HEIGHT * 0.50 / rows); //Height will be 1/2 screen size, divided by number of button rows
        btn_battle.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.out.println("Button pressed!");
            }
        });
        
        //Button "Shop"
        Button btn_shop = new Button("Shop", new ImageView(new Image(getClass().getResourceAsStream("icons/icon_shop.png"))));
        btn_shop.setPrefWidth(Double.MAX_VALUE);
        btn_shop.setPrefHeight(HEIGHT * 0.50 / rows);
        
        //Button "Inventory"
        Button btn_inv = new Button("Inventory", new ImageView(new Image(getClass().getResourceAsStream("icons/icon_inv.png"))));
        btn_inv.setPrefWidth(Double.MAX_VALUE);
        btn_inv.setPrefHeight(HEIGHT * 0.50 / rows);
        
        //Add all buttons to menu
        menu.add(btn_battle, 0, 0);
        menu.add(btn_shop, 0, 1);
        menu.add(btn_inv, 0, 2);
        for (int i = 0; i < rows; i++) {
            Button b = new Button("...");
            b.setPrefWidth(Double.MAX_VALUE);
            b.setPrefHeight(HEIGHT * 0.50 / rows);
            menu.add(b, 1, i);
        }
            
        TextArea history = new TextArea("This will display the history of actions.");
        //How many rows the TextArea will contain
        history.setPrefRowCount(10);
        
        //Adds menu and history to the vbox "right"
        right.getChildren().addAll(menu, history);
        
        //Creates a new scene and applies "main" to it
        Scene scene = new Scene(main, WIDTH, HEIGHT);
        //Display the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}

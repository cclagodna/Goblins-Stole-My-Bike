/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicescreen;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author ottaviojamil
 */
public class PrACTICESCREEN extends Application {
    
    Stage window;
    @Override
    public void start(Stage primaryStage) {
     window = primaryStage;
     window.setTitle("GOBLINS STOLE MY BIKE");
     
        //  backgroungim();
     
     GridPane buttongrid = new GridPane();
     buttongrid.setPadding(new Insets(10, 10, 10, 10));
     buttongrid.setVgap(8);
     buttongrid.setHgap(10);
     
     Label LBL_proname = new Label(" GOBLINS STOLE MY BIKE");
     LBL_proname.setFont(new Font("Arial", 30));
     GridPane.setConstraints(LBL_proname, 10, 2);
     
     Button btn_start = new Button("START");
     btn_start.setStyle("-fx-base: rgb(30,170,255);");
     GridPane.setConstraints(btn_start, 10, 5);
     
     Button btn_END = new Button("END");
     btn_END.setStyle("-fx-base: rgb(30,170,255);");
     GridPane.setConstraints(btn_END, 10, 7);
     
     buttongrid.getChildren().addAll(btn_start, btn_END, LBL_proname);
     
     Scene scene = new Scene(buttongrid, 300, 200);
     window.setScene(scene);
     window.show();
    }
    
//     public void backgroungim(Stage stage){
//        Image bgimage = new Image("the file of image goes here");
//        ImageView bgimageview = new ImageView(bgimage);
//        Group root = new Group();
//        Scene scenebg = new Scene(root,1000,800);
//        
//        stage.setScene(scenebg);
//        stage.setResizable(false);
//        stage.show();  
//}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

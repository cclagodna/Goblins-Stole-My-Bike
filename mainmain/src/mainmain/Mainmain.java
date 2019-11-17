package mainmain; 

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Mainmain extends Application {

    Stage window;
    Scene scene1, scene2, scene3;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        //Button 1
        Label label1 = new Label("GOBLINS STOLE MY BIKE");
        Button btn_START = new Button("START");
        btn_START.setOnAction(e -> window.setScene(scene2));
                           btn_START.setStyle("-fx-base: rgb(30,170,255);");


        //Layout 1 - children laid out in vertical column
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, btn_START);
        scene1 = new Scene(layout1, 200, 200);

        //Button 2
        Button btn_END = new Button("END GAME");
        btn_END.setOnAction(e -> window.setScene(scene1));
          btn_END.setStyle("-fx-base: rgb(30,170,255);");

        //Layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(btn_END);
        scene2 = new Scene(layout2, 600, 300);
       //credits
        Label label3 = new Label("Carl LaGodna" + System.lineSeparator() + "George Feliciano"+ System.lineSeparator() + "Abdul Mohammed" + System.lineSeparator() + "Steven Naoum" + System.lineSeparator() + "Kyle Kennedy" + System.lineSeparator() + "Ottavio Jamil" );
        Button btn_CREDITS = new Button("CREDITS");
        btn_CREDITS.setOnAction(e -> window.setScene(scene3));
        btn_CREDITS.setStyle("-fx-base: rgb(30,170,255);");
        
         VBox layout3 = new VBox(40);
        layout1.getChildren().addAll(btn_CREDITS);
        layout3.getChildren().addAll(label3);
        scene3 = new Scene(layout3, 300, 300);
        
        
            //Display scene 1 at first
        window.setScene(scene1);
        window.setTitle("Title Here");
        window.show();
        
    }

}
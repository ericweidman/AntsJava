package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {

    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static final int ANT_COUNT = 100;

    ArrayList<Ant> ants;

    static ArrayList<Ant> createAnts(){
        ArrayList<Ant> ants = new ArrayList<Ant>();
        for(int i = 0; i < ANT_COUNT; i++){
            Random r = new Random();
            ants.add(new Ant(r.nextInt(WIDTH), r.nextInt(HEIGHT)));
        }
        return ants;
    }

    void drawAnts(GraphicsContext context){
        context.clearRect(0, 0, WIDTH, HEIGHT);
        for(Ant ant : ants){
            context.setFill(Color.BLACK);
            context.fillOval(ant.x, ant.y, 5, 5);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        Canvas canvas = (Canvas) scene.lookup("#canvas");
        GraphicsContext context = canvas.getGraphicsContext2D();

        primaryStage.setTitle("AntsJava");
        primaryStage.setScene(scene);
        primaryStage.show();

        ants = createAnts();
        drawAnts(context);
    }


    public static void main(String[] args) {
        launch(args);
    }
}

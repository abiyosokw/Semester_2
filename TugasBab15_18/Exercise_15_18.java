package TugasBab15_18;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise_15_18 extends Application {

    
    private final double[] offset = new double[2];

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        
        Rectangle rectangle = new Rectangle(200, 120, 120, 80);
        rectangle.setFill(Color.RED); 
        rectangle.setStroke(Color.YELLOW); 

        
        rectangle.setOnMousePressed(e -> {
            offset[0] = e.getSceneX() - rectangle.getX();
            offset[1] = e.getSceneY() - rectangle.getY();
        });

        
        rectangle.setOnMouseDragged(e -> {
            rectangle.setX(e.getSceneX() - offset[0]);
            rectangle.setY(e.getSceneY() - offset[1]);
        });

        pane.getChildren().add(rectangle);
        Scene scene = new Scene(pane, 500, 400);
        primaryStage.setTitle("Exercise 15.18: Move Rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
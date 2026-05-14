package TugasBab14_11;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Exercise14_11 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Membuat Pane untuk menampung bentuk
        Pane pane = new Pane();

        // 1. Membuat Wajah (Lingkaran besar)
        Circle face = new Circle(100, 100, 80);
        face.setFill(Color.WHITE);
        face.setStroke(Color.BLACK);

        // 2. Membuat Mata Kiri
        Circle leftEyeCircle = new Circle(70, 70, 15);
        leftEyeCircle.setFill(Color.WHITE);
        leftEyeCircle.setStroke(Color.BLACK);
        Ellipse leftPupil = new Ellipse(70, 70, 8, 10);
        leftPupil.setFill(Color.BLACK);

        // 3. Membuat Mata Kanan
        Circle rightEyeCircle = new Circle(130, 70, 15);
        rightEyeCircle.setFill(Color.WHITE);
        rightEyeCircle.setStroke(Color.BLACK);
        Ellipse rightPupil = new Ellipse(130, 70, 8, 10);
        rightPupil.setFill(Color.BLACK);

        // 4. Membuat Hidung (Segitiga menggunakan Polygon)
        // Koordinat: (atas), (kiri bawah), (kanan bawah)
        Polygon nose = new Polygon(100, 80, 85, 110, 115, 110);
        nose.setFill(Color.WHITE);
        nose.setStroke(Color.BLACK);

        // 5. Membuat Mulut (Busur/Arc)
        // Arc(centerX, centerY, radiusX, radiusY, startAngle, length)
        Arc mouth = new Arc(100, 130, 40, 20, 180, 180);
        mouth.setType(ArcType.OPEN);
        mouth.setFill(Color.WHITE);
        mouth.setStroke(Color.BLACK);

        // Menambahkan semua bagian ke dalam pane
        pane.getChildren().addAll(face, leftEyeCircle, leftPupil, rightEyeCircle, rightPupil, nose, mouth);

        // Menyiapkan Scene dan Stage
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Exercise14_11 - Smiley Face");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false); // Agar ukuran tetap
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
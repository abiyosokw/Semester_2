package TugasBab15_1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;

public class Exercise15_01 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Pane utama untuk menampung kartu
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);

        // Membuat list untuk menyimpan nomor kartu 1-52
        ArrayList<Integer> cards = new ArrayList<>();
        for (int i = 1; i <= 52; i++) {
            cards.add(i);
        }

        // Fungsi untuk mengambil dan menampilkan 4 kartu acak
        refreshCards(hBox, cards);

        // Tombol Refresh
        Button btRefresh = new Button("Refresh");
        btRefresh.setOnAction(e -> refreshCards(hBox, cards));

        // Layouting
        HBox buttonBox = new HBox();
        buttonBox.getChildren().add(btRefresh);
        buttonBox.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane();
        pane.setCenter(hBox);
        pane.setBottom(buttonBox);
        BorderPane.setMargin(buttonBox, new javafx.geometry.Insets(10, 10, 10, 10));

        // Setup Scene dan Stage
        Scene scene = new Scene(pane, 500, 200);
        primaryStage.setTitle("Exercise15_01 - Pick Four Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void refreshCards(HBox hBox, ArrayList<Integer> cards) {
        hBox.getChildren().clear();
        // Mengacak urutan angka dalam list
        Collections.shuffle(cards);

        // Mengambil 4 angka pertama setelah diacak
        for (int i = 0; i < 4; i++) {
            // Asumsi file gambar ada di folder "card/" dengan nama "1.png", "2.png", dst.
            String path = new java.io.File("card/" + cards.get(i) + ".png").toURI().toString();
            ImageView cardView = new ImageView(path);
            cardView.setFitHeight(150);
            cardView.setPreserveRatio(true);
            hBox.getChildren().add(cardView);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
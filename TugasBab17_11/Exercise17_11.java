package TugasBab17_11;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Exercise17_11 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // UI Components
        Label lblFile = new Label("Enter a file:");
        TextField tfFile = new TextField();
        Button btnBrowse = new Button("Browse");
        
        Label lblPieces = new Label("Specify the number of smaller files:");
        TextField tfPieces = new TextField();
        
        Button btnStart = new Button("Start");

        // Layout
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        grid.setAlignment(Pos.CENTER);

        grid.add(new Label("If you split a file, the smaller files will be named\nSourceFile.1, SourceFile.2, etc."), 0, 0, 3, 1);
        grid.add(lblFile, 0, 1);
        grid.add(tfFile, 1, 1);
        grid.add(btnBrowse, 2, 1);
        grid.add(lblPieces, 0, 2);
        grid.add(tfPieces, 1, 2);
        grid.add(btnStart, 1, 3);

        // Events
        btnBrowse.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                tfFile.setText(selectedFile.getAbsolutePath());
            }
        });

        btnStart.setOnAction(e -> {
            try {
                splitFile(tfFile.getText(), Integer.parseInt(tfPieces.getText()));
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "File successfully split!");
                alert.showAndWait();
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error: " + ex.getMessage());
                alert.showAndWait();
            }
        });

        Scene scene = new Scene(grid, 450, 200);
        primaryStage.setTitle("Exercise17_11: Split Files");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void splitFile(String filename, int numberOfPieces) throws IOException {
        File sourceFile = new File(filename);
        if (!sourceFile.exists()) throw new FileNotFoundException("File not found!");

        long fileSize = sourceFile.length();
        // Menggunakan BufferedStream agar efisien untuk file besar (GB)
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile))) {
            
            long splitSize = fileSize / numberOfPieces;
            long remainingBytes = fileSize % numberOfPieces;

            for (int i = 1; i <= numberOfPieces; i++) {
                File targetFile = new File(filename + "." + i);
                try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile))) {
                    
                    // Hitung berapa byte yang harus ditulis untuk bagian ini
                    long currentPartSize = splitSize + (i == numberOfPieces ? remainingBytes : 0);
                    
                    for (long j = 0; j < currentPartSize; j++) {
                        output.write(input.read());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
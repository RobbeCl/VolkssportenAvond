package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    public enum Colors{
        TOP, CENTER
    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        BorderPane root = new BorderPane();
        HBox hboxForTopBorder = createHBox(
                Colors.TOP,
                createTopButton("Lijst"),
                createTopButton("Printen")
        );
        root.setTop(hboxForTopBorder);

        VBox vbox = getLabelsAndTextFields();

        root.setCenter(vbox);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Volkssporten Applicatie");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private VBox getLabelsAndTextFields(){
        HBox hboxSjoelbak = createHBox(
                Colors.CENTER,
                createPointsLabel("Sjoelbak"),
                createTextField()
        );
        HBox hboxTonspel = createHBox(
                Colors.CENTER,
                createPointsLabel("Tonspel"),
                createTextField()
        );
        HBox hboxToptafel = createHBox(
                Colors.CENTER,
                createPointsLabel("Toptafel"),
                createTextField()
        );
        HBox hboxRolBiljart = createHBox(
                Colors.CENTER,
                createPointsLabel("Rol Biljart"),
                createTextField()
        );
        HBox hboxMannetjesspel = createHBox(
                Colors.CENTER,
                createPointsLabel("Mannetjesspel"),
                createTextField()
        );

        return createVBox(
                hboxSjoelbak,
                hboxTonspel,
                hboxToptafel,
                hboxRolBiljart,
                hboxMannetjesspel
        );
    }

    private HBox createHBox( Colors color, Control ... args ){
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);

        if( color == Colors.TOP )
            hbox.setStyle("-fx-background-color: #336699;");

        hbox.getChildren().addAll( args );

        return hbox;
    }

    private VBox createVBox( Pane... args ){
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15, 12, 15, 12));
        vbox.getChildren().addAll( args );
        return vbox;
    }

    private Button createTopButton(String title){
        Button button = new Button(title);
        button.setPrefSize(100, 20);
        return button;
    }

    private Label createPointsLabel(String label){
        Label lb = new Label(label);
        lb.setFont(new Font(15));
        lb.setPadding(new Insets(5));
        return lb;
    }

    private TextField createTextField(){
        return new TextField();
    }


    public static void main(String[] args) {
        launch(args);
    }

}

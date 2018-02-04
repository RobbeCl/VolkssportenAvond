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

    private Scene listScene;
    private Scene printScene;

    private Button listButton;
    private Button printButton;
    private Button submitButton;

    private TextField sjoelbak;
    private TextField tonspel;
    private TextField toptafel;
    private TextField rolbiljart;
    private TextField mannetjesspel;

    private enum Colors{
        TOP, CENTER
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        BorderPane ListRoot = new BorderPane();

        listButton = createButton("Lijst");
        printButton = createButton("Printen");

        HBox hboxForTopBorder = createHBox(
                Colors.TOP,
                listButton,
                printButton
        );

        VBox vbox = getLabelsAndTextFields();
        vbox.getChildren().add(submitButton = createButton("Submit"));

        submitButton.setOnAction( (event) -> {
            System.out.println(sjoelbak.getText());
        });

        ListRoot.setTop(hboxForTopBorder);
        ListRoot.setCenter(vbox);

        listScene = new Scene(ListRoot, 800, 600);

        primaryStage.setTitle("Volkssporten Applicatie");
        primaryStage.setScene(listScene);
        primaryStage.show();

    }

    private VBox getLabelsAndTextFields(){
        HBox hboxSjoelbak = createHBox(
                Colors.CENTER,
                createPointsLabel("Sjoelbak"),
                sjoelbak = createTextField()
        );
        HBox hboxTonspel = createHBox(
                Colors.CENTER,
                createPointsLabel("Tonspel"),
                tonspel = createTextField()
        );
        HBox hboxToptafel = createHBox(
                Colors.CENTER,
                createPointsLabel("Toptafel"),
                toptafel = createTextField()
        );
        HBox hboxRolBiljart = createHBox(
                Colors.CENTER,
                createPointsLabel("Rol Biljart"),
                rolbiljart = createTextField()
        );
        HBox hboxMannetjesspel = createHBox(
                Colors.CENTER,
                createPointsLabel("Mannetjesspel"),
                mannetjesspel = createTextField()
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

    private Button createButton(String title){
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

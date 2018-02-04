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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import sample.Database;

import java.sql.SQLException;
import java.sql.Statement;

public class Main extends Application {

    private Label errorLabel;

    private Scene listScene;

    private Button listButton;
    private Button printButton;
    private Button submitButton;


    private TextField voornaam;
    private TextField achternaam;
    private TextField nummer;
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

        submitButton = createButton("Submit");
        listButton = createButton("Lijst");
        printButton = createButton("Printen");
        errorLabel = createPointsLabel("");
        errorLabel.setTextFill(Color.RED);

        Database database = new Database();


        BorderPane ListRoot = new BorderPane();

        HBox hboxForTopBorder = createHBox(
                Colors.TOP,
                listButton,
                printButton
        );

        VBox vbox = getLabelsAndTextFields();
        vbox.getChildren().add(submitButton);

        submitButton.setOnAction( (event) -> {
            try{
                User user = new User(
                        voornaam.getText(),
                        achternaam.getText(),
                        Integer.parseInt(nummer.getText()),
                        Integer.parseInt(sjoelbak.getText()),
                        Integer.parseInt(tonspel.getText()),
                        Integer.parseInt(toptafel.getText()),
                        Integer.parseInt(rolbiljart.getText()),
                        Integer.parseInt(mannetjesspel.getText()));

                this.clearTextFields(voornaam, achternaam, nummer, sjoelbak, tonspel, toptafel, rolbiljart, mannetjesspel);

                database.insertScore(user);
            } catch (SQLException e){
                errorLabel.setText("Database error: " + e.getMessage());
            }
        });

        ListRoot.setTop(hboxForTopBorder);
        ListRoot.setCenter(vbox);
        ListRoot.setBottom(errorLabel);

        listScene = new Scene(ListRoot, 800, 600);

        primaryStage.setTitle("Volkssporten Applicatie");
        primaryStage.setScene(listScene);
        primaryStage.show();

    }

    private void clearTextFields( TextField ... fields){
        for( TextField tf : fields ){
            tf.setText("");
        }
    }

    private VBox getLabelsAndTextFields(){
        HBox hboxNummer = createHBox(
                Colors.CENTER,
                createPointsLabel("Nummer"),
                nummer = createTextField()
        );
        HBox hboxVoornaam = createHBox(
                Colors.CENTER,
                createPointsLabel("Voornaam"),
                voornaam = createTextField()
        );
        HBox hboxAchternaam = createHBox(
                Colors.CENTER,
                createPointsLabel("Achternaam"),
                achternaam = createTextField()
        );
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
                hboxNummer,
                hboxVoornaam,
                hboxAchternaam,
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

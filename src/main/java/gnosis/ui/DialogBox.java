package gnosis.ui;

import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * An example of a custom control using FXML.
 * This control represents a dialog box consisting of an ImageView to represent the speaker's face and a label
 * containing text from the speaker.
 */
public class DialogBox extends HBox {

    @FXML
    private Label dialog;

    private DialogBox(String text) {
        try {
            ///gnosis/ui/GnosisMainWindow.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gnosis/ui/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            System.out.println("ERROR WITH DIALOG BOX");
            e.printStackTrace();
        }

        dialog.setText(text);
        //displayPicture.setImage(img);
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        setAlignment(Pos.TOP_LEFT);
    }

    public static DialogBox getUserDialog(String text) {
        return new DialogBox(text);
    }

    public static DialogBox getGnosisDialog(String text) {
        var db = new DialogBox(text);
        db.flip();
        return db;
    }
}

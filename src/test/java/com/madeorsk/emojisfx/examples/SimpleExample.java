package com.madeorsk.emojisfx.examples;

import com.madeorsk.emojisfx.EmojisLabel;
import com.madeorsk.emojisfx.Range;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class SimpleExample extends Application
{
  public static void main(String[] args)
  {
    launch();
  }

  @Override
  public void start(Stage primaryStage)
  {
    VBox root = new VBox();

    // Create an EmojisLabel, and we are so happy that we indicate it with an emoji.
    EmojisLabel label = new EmojisLabel("Look! That's a coloured emoji! \uD83D\uDE04");
    label.setFont(Font.font(24)); // Please, I want to see this text!
    label.setSelectionFill(Color.BLACK); // So dark...
    label.setSelectedTextFill(Color.WHITE);
    root.getChildren().add(label);

    Button button = new Button("Append hearts ❤"); // What if we append love?
    button.setOnAction((event) -> {
      label.setText(label.getText() + "\n ❤ \uD83D\uDC99 \uD83D\uDC9B \uD83D\uDC9A \uD83D\uDDA4 \uD83D\uDC9C");
    });
    root.getChildren().add(button);

    EmojisLabel linkedLabel = new EmojisLabel("Do you ❤ this? If yes, consider making a donation.");
    linkedLabel.setLinkTextFill(Color.rgb(255, 90, 121)); // A link with the same color as the heart.
    linkedLabel.addLinkRange(new Range(24, 40, () -> new Thread(() -> { // Link action.
      try
      {
        Desktop.getDesktop().browse(new URI("https://liberapay.com/Madeorsk"));
      }
      catch (IOException | URISyntaxException e)
      { System.err.println("Sorry, I fucked up."); }
    }).start()));
    root.getChildren().add(linkedLabel);

    // Basic stage and scene setup.
    primaryStage.setScene(new Scene(root, 640, 480));
    primaryStage.setTitle("Simple EmojisLabel example");
    primaryStage.show();
  }
}

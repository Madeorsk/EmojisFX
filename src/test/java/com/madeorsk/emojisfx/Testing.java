package com.madeorsk.emojisfx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Testing extends Application
{
  public static void main(String[] args) { launch(); }
	
	@Override
	public void start(Stage stage) throws Exception
	{
		StackPane root = new StackPane();
		root.setAlignment(Pos.TOP_LEFT);
		
		Font.loadFont(this.getClass().getResourceAsStream("/com/madeorsk/emojisfx/AllerLight.ttf"), 12);
		
		VBox box = new VBox();
		box.prefHeightProperty().bind(root.heightProperty());
		box.prefWidthProperty().bind(root.widthProperty());
		root.getChildren().add(box);
		
		String testedString = new String("Test\nwrap multi ligne. 🙃☺️💞⛔️❤️📷🏓🙊😍😂😂".getBytes(), "UTF-8");
		
		EmojisLabel emojisLabel = new EmojisLabel(testedString);
		emojisLabel.setPrefWidth(400);
		emojisLabel.setFont(Font.font("Aller Light", 32));
		emojisLabel.setTextFill(Color.BLACK);
		emojisLabel.setSelectionFill(Color.BLACK);
		emojisLabel.setSelectedTextFill(Color.WHITE);
		emojisLabel.addLinkRange(new Range(0, 3, new Runnable()
		{
			public void run()
			{
				System.out.println("Hello World!");
			}
		}));
		box.getChildren().add(emojisLabel);
		
		Scene scene = new Scene(root, 800, 600);
		stage.setScene(scene);
		
		root.prefHeightProperty().bind(scene.heightProperty());
		root.prefWidthProperty().bind(scene.widthProperty());
		
		stage.setTitle("Testing");
		stage.show();
	}
}

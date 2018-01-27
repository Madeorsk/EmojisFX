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
		
		//this.processStringTests(testedString);
		
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
		
		EmojisField emojisField = new EmojisField();//new EmojisLabel(testedString);
		emojisField.setPrefWidth(400);
		//emojisField.setFont(Font.font("Aller Light", 32));
		//emojisField.setTextFill(Color.BLACK);
		box.getChildren().add(emojisField);
		
		Scene scene = new Scene(root, 800, 600);
		stage.setScene(scene);
		
		root.prefHeightProperty().bind(scene.heightProperty());
		root.prefWidthProperty().bind(scene.widthProperty());
		
		stage.setTitle("Testing");
		stage.show();
	}
	
	/*private void processStringTests(String testedString)
	{
		/*for(int i = 0; i < testedString.length(); i++)
		{
			System.out.println("char " + i + " : " + testedString.charAt(i) + " ; ");
		}*//*
		
		System.out.println("Bytes(" + testedString.getBytes().length + ") = " + Arrays.toString(testedString.getBytes()));
		
		int charCount = 0;
		for(int i = 0; i < testedString.getBytes().length; i++)
		{
			String currentByte = this.byteToBinary(testedString.getBytes()[i]);
			//System.out.println(currentByte + " : " + currentByte.indexOf("0"));
			switch(currentByte.indexOf("0"))
			{
				case 0:
					System.out.println(charCount + " : " + currentByte + " : U+" + String.format("%02X ", testedString.getBytes()[i]));
					break;
				case 2:
					System.out.println(charCount + " : " + currentByte + "." + this.byteToBinary(testedString.getBytes()[i + 1]) + " : U+" + String.format("%02X ", testedString.getBytes()[i]) + String.format("%02X ", testedString.getBytes()[i + 1]));
					i++;
					break;
				case 3:
					System.out.println(charCount + " : " + currentByte + "." + this.byteToBinary(testedString.getBytes()[i + 1]) + "." + this.byteToBinary(testedString.getBytes()[i + 2]) + " : U+" + String.format("%02X ", testedString.getBytes()[i]) + String.format("%02X ", testedString.getBytes()[i + 1]) + String.format("%02X ", testedString.getBytes()[i + 2]));
					i += 2;
					break;
				case 4:
					System.out.println(charCount + " : " + currentByte + "." + this.byteToBinary(testedString.getBytes()[i + 1]) + "." + this.byteToBinary(testedString.getBytes()[i + 2]) + "." + this.byteToBinary(testedString.getBytes()[i + 3]) + " : U+" + String.format("%02X ", testedString.getBytes()[i]) + String.format("%02X ", testedString.getBytes()[i + 1]) + String.format("%02X ", testedString.getBytes()[i + 2]) + String.format("%02X ", testedString.getBytes()[i + 3]));
					i += 3;
					break;
			}
			charCount++;
		}
		System.out.println(charCount);
		
		charCount = 0;
		for(int i = 0; i < testedString.getBytes().length; i++)
		{
			String currentByte = this.byteToBinary(testedString.getBytes()[i]);
			switch(currentByte.indexOf("0"))
			{
				case 0:
					System.out.println(charCount + " : " + currentByte + " : U+" + String.format("%02X", testedString.getBytes()[i]));
					break;
				case 2:
					System.out.println(charCount + " : " + currentByte + "." + this.byteToBinary(testedString.getBytes()[i + 1]) + " : U+" + String.format("%02X", Integer.parseInt(currentByte.substring(2) + this.byteToBinary(testedString.getBytes()[i + 1]).substring(2), 2)));
					i++;
					break;
				case 3:
					System.out.println(charCount + " : " + currentByte + "." + this.byteToBinary(testedString.getBytes()[i + 1]) + "." + this.byteToBinary(testedString.getBytes()[i + 2]) + " : U+" + String.format("%02X", Integer.parseInt(currentByte.substring(3) + this.byteToBinary(testedString.getBytes()[i + 1]).substring(2) + this.byteToBinary(testedString.getBytes()[i + 2]).substring(2), 2)));
					i += 2;
					break;
				case 4:
					System.out.println(charCount + " : " + currentByte + "." + this.byteToBinary(testedString.getBytes()[i + 1]) + "." + this.byteToBinary(testedString.getBytes()[i + 2]) + "." + this.byteToBinary(testedString.getBytes()[i + 3]) + " : U+" + String.format("%02X", Integer.parseInt(currentByte.substring(4) + this.byteToBinary(testedString.getBytes()[i + 1]).substring(2) + this.byteToBinary(testedString.getBytes()[i + 2]).substring(2) + this.byteToBinary(testedString.getBytes()[i + 3]).substring(2), 2)));
					i += 3;
					break;
			}
			charCount++;
		}
	}
	
	private String byteToBinary(byte byt)
	{
		return Integer.toBinaryString(byt & 255 | 256).substring(1);
	}*/
}

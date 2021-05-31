package com.madeorsk.emojisfx;

import javafx.scene.control.Control;
import javafx.scene.control.Skin;

public class EmojisField extends Control
{
	public EmojisField()
	{
		this.getStyleClass().add("emojis-field");
	}
	
	@Override
	protected Skin<?> createDefaultSkin()
	{
		return new EmojisFieldSkin(this);
	}
}

package com.madeorsk.emojisfx;

import java.util.ArrayList;

import com.sun.javafx.scene.control.behavior.BehaviorBase;
import com.sun.javafx.scene.control.behavior.KeyBinding;

public class EmojisFieldBehavior extends BehaviorBase<EmojisField>
{
	public EmojisFieldBehavior(EmojisField control)
	{
		super(control, new ArrayList<KeyBinding>());
	}
}

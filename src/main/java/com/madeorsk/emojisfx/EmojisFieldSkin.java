package com.madeorsk.emojisfx;

import com.sun.javafx.scene.control.skin.BehaviorSkinBase;

public class EmojisFieldSkin extends BehaviorSkinBase<EmojisField, EmojisFieldBehavior>
{
  protected EmojisFieldSkin(EmojisField control)
  {
    super(control, new EmojisFieldBehavior(control));
  }
}

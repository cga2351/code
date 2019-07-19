package com.viber.voip.ui.doodle.commands;

import com.viber.voip.ui.doodle.objects.BaseObject;
import com.viber.voip.ui.doodle.undo.Undo;

public abstract interface a<T extends BaseObject>
{
  public abstract Undo applyTo(T paramT, com.viber.voip.ui.doodle.scene.a parama);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.commands.a
 * JD-Core Version:    0.6.2
 */
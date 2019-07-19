package com.viber.voip.ui.doodle.commands.movable;

import com.viber.voip.ui.doodle.objects.MovableObject;
import com.viber.voip.ui.doodle.undo.RestoreUndo;
import com.viber.voip.ui.doodle.undo.Undo;

public class c
  implements com.viber.voip.ui.doodle.commands.a<MovableObject>
{
  private TransformationCommand a;

  public c()
  {
    this(null);
  }

  public c(TransformationCommand paramTransformationCommand)
  {
    this.a = paramTransformationCommand;
  }

  public Undo a(MovableObject paramMovableObject, com.viber.voip.ui.doodle.scene.a parama)
  {
    Undo localUndo = Undo.None;
    if (this.a != null)
      localUndo = this.a.applyTo(paramMovableObject, parama);
    paramMovableObject.freeResources();
    int i = parama.a(paramMovableObject.getId());
    return new RestoreUndo(paramMovableObject.getId(), i, localUndo);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.commands.movable.c
 * JD-Core Version:    0.6.2
 */
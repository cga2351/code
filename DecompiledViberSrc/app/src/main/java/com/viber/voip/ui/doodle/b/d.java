package com.viber.voip.ui.doodle.b;

import android.content.Context;
import android.os.Bundle;
import com.viber.voip.ui.doodle.a.a.a.b;
import com.viber.voip.ui.doodle.a.d.a;
import com.viber.voip.ui.doodle.extras.g;
import com.viber.voip.ui.doodle.objects.BaseObject;
import com.viber.voip.ui.doodle.objects.MovableObject;
import com.viber.voip.ui.doodle.undo.RemoveUndo;

public abstract class d<T extends MovableObject> extends c<T>
  implements d.a
{
  d(Context paramContext, com.viber.voip.ui.doodle.scene.a parama, a.b paramb, com.viber.voip.ui.doodle.undo.a parama1, com.viber.voip.ui.doodle.objects.c.a parama2, g paramg, c.a parama3, Bundle paramBundle)
  {
    super(parama, parama1, parama2, paramg, parama3, paramBundle);
    parama.a(new com.viber.voip.ui.doodle.a.d(paramContext, parama, this, paramb));
  }

  public void a(com.viber.voip.ui.doodle.commands.a<MovableObject> parama)
  {
    if (this.a == null)
      return;
    a(parama.applyTo(this.a, this.b));
    f();
  }

  public boolean a(com.viber.voip.ui.doodle.commands.d<MovableObject> paramd)
  {
    b((MovableObject)paramd.a(this.b));
    return this.a != null;
  }

  protected abstract boolean a(BaseObject paramBaseObject);

  public boolean a(MovableObject paramMovableObject)
  {
    return b(paramMovableObject);
  }

  final boolean b(MovableObject paramMovableObject)
  {
    if ((paramMovableObject != null) && (a(paramMovableObject)))
    {
      this.a = paramMovableObject;
      return true;
    }
    return false;
  }

  protected void c(T paramT)
  {
    super.b(paramT);
    a(new RemoveUndo(paramT.getId()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.b.d
 * JD-Core Version:    0.6.2
 */
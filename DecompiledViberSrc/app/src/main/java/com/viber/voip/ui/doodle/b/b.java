package com.viber.voip.ui.doodle.b;

import android.content.Context;
import android.os.Bundle;
import com.viber.voip.ui.doodle.extras.d;
import com.viber.voip.ui.doodle.extras.g;
import com.viber.voip.ui.doodle.objects.DoodleObject;
import com.viber.voip.ui.doodle.undo.RemoveUndo;

public class b extends c<DoodleObject>
  implements com.viber.voip.ui.doodle.a.c.a
{
  private final com.viber.voip.ui.doodle.objects.a.a f;

  public b(Context paramContext, com.viber.voip.ui.doodle.scene.a parama, com.viber.voip.ui.doodle.undo.a parama1, com.viber.voip.ui.doodle.objects.c.a parama2, g paramg, c.a parama3, d paramd, Bundle paramBundle)
  {
    super(parama, parama1, parama2, paramg, parama3, paramBundle);
    parama.a(new com.viber.voip.ui.doodle.a.c(paramContext, parama, this));
    this.f = new com.viber.voip.ui.doodle.objects.a.a(paramd);
  }

  public void a(com.viber.voip.ui.doodle.commands.a<DoodleObject> parama)
  {
    if (this.a != null)
    {
      a(parama.applyTo(this.a, this.b));
      f();
    }
  }

  public boolean a(com.viber.voip.ui.doodle.commands.b<DoodleObject, com.viber.voip.ui.doodle.objects.b.a> paramb)
  {
    this.a = paramb.a(this.e.a(), this.b, this.f);
    b(this.a);
    this.c.a(new RemoveUndo(((DoodleObject)this.a).getId()));
    return true;
  }

  public c.b c()
  {
    return c.b.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.b.b
 * JD-Core Version:    0.6.2
 */
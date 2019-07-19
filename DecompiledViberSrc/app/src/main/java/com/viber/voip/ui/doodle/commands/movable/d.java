package com.viber.voip.ui.doodle.commands.movable;

import android.graphics.PointF;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.doodle.objects.BaseObject;
import com.viber.voip.ui.doodle.objects.MovableObject;
import com.viber.voip.ui.doodle.scene.a;
import com.viber.voip.ui.doodle.scene.a.a;

public class d
  implements com.viber.voip.ui.doodle.commands.d<MovableObject>
{
  private static final Logger a = ViberEnv.getLogger();
  private final PointF b;

  public d(PointF paramPointF)
  {
    this.b = paramPointF;
  }

  public MovableObject b(a parama)
  {
    return (MovableObject)parama.a(new a.a()
    {
      public boolean a(BaseObject paramAnonymousBaseObject)
      {
        return paramAnonymousBaseObject.hit(d.a(d.this));
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.commands.movable.d
 * JD-Core Version:    0.6.2
 */
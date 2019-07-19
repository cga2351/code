package com.viber.voip.ui.doodle.commands.a;

import android.graphics.PointF;
import com.viber.voip.ui.doodle.objects.DoodleObject;

public class a
  implements com.viber.voip.ui.doodle.commands.b<DoodleObject, com.viber.voip.ui.doodle.objects.b.a>
{
  private final PointF a;

  public a(PointF paramPointF)
  {
    this.a = paramPointF;
  }

  public DoodleObject b(long paramLong, com.viber.voip.ui.doodle.scene.a parama, com.viber.voip.ui.doodle.objects.a.b<DoodleObject, com.viber.voip.ui.doodle.objects.b.a> paramb)
  {
    return (DoodleObject)paramb.a(new com.viber.voip.ui.doodle.objects.b.a(paramLong, this.a));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.commands.a.a
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.ui.doodle.a.a;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.a.a.a.b.a;
import com.viber.voip.ui.doodle.scene.SceneConfig;
import com.viber.voip.ui.doodle.scene.SceneConfig.CoordinateNormalizer;

public class c extends com.a.a.a.b
  implements b
{
  private PointF h = new PointF();
  private PointF i = new PointF();
  private final com.viber.voip.ui.doodle.scene.b j;

  public c(Context paramContext, com.viber.voip.ui.doodle.scene.b paramb, b.a parama)
  {
    super(paramContext, parama);
    this.j = paramb;
  }

  public boolean a()
  {
    return b();
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    return a_(paramMotionEvent);
  }

  protected void b(MotionEvent paramMotionEvent)
  {
    if ((this.c == null) || (paramMotionEvent == null))
      return;
    super.b(paramMotionEvent);
    PointF localPointF1 = super.c();
    SceneConfig.CoordinateNormalizer localCoordinateNormalizer = this.j.f().getCoordinateNormalizer();
    this.h.set(localCoordinateNormalizer.normalizeDeltaXCoordinate(localPointF1.x), localCoordinateNormalizer.normalizeDeltaYCoordinate(localPointF1.y));
    PointF localPointF2 = this.i;
    localPointF2.x += this.h.x;
    PointF localPointF3 = this.i;
    localPointF3.y += this.h.y;
  }

  public PointF c()
  {
    return this.h;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.a.a.c
 * JD-Core Version:    0.6.2
 */
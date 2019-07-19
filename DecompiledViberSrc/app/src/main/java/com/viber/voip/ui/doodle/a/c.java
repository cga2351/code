package com.viber.voip.ui.doodle.a;

import android.content.Context;
import android.graphics.PointF;
import com.a.a.a.b.a;
import com.viber.voip.ui.doodle.objects.DoodleObject;
import com.viber.voip.ui.doodle.scene.SceneConfig;
import com.viber.voip.ui.doodle.scene.SceneConfig.CoordinateNormalizer;

public class c extends e
  implements b.a
{
  private final a a;
  private float b;
  private float c;
  private final float d;
  private final float e;

  public c(Context paramContext, com.viber.voip.ui.doodle.scene.b paramb, a parama)
  {
    super(paramb, parama);
    this.a = parama;
    com.viber.voip.ui.doodle.a.a.b[] arrayOfb = new com.viber.voip.ui.doodle.a.a.b[1];
    arrayOfb[0] = new com.viber.voip.ui.doodle.a.a.c(paramContext, paramb, this);
    a(arrayOfb);
    SceneConfig.CoordinateNormalizer localCoordinateNormalizer = paramb.f().getCoordinateNormalizer();
    this.d = localCoordinateNormalizer.normalizeDeltaXCoordinate(10.0F);
    this.e = localCoordinateNormalizer.normalizeDeltaYCoordinate(10.0F);
  }

  boolean a(PointF paramPointF)
  {
    this.a.a(new com.viber.voip.ui.doodle.commands.a.a(paramPointF));
    return super.a(paramPointF);
  }

  public boolean a(com.a.a.a.b paramb)
  {
    PointF localPointF = paramb.c();
    this.b += localPointF.x;
    this.c += localPointF.y;
    if ((Math.abs(this.b) >= this.d) || (Math.abs(this.c) >= this.e))
    {
      this.a.a(com.viber.voip.ui.doodle.commands.a.b.a(this.b, this.c));
      this.b = 0.0F;
      this.c = 0.0F;
    }
    return true;
  }

  void b(PointF paramPointF)
  {
    this.a.a(com.viber.voip.ui.doodle.commands.a.b.b(0.0F, 0.0F));
  }

  public boolean b(com.a.a.a.b paramb)
  {
    PointF localPointF = paramb.c();
    this.b = 0.0F;
    this.c = 0.0F;
    this.a.a(com.viber.voip.ui.doodle.commands.a.b.a(localPointF.x, localPointF.y));
    return true;
  }

  public void c(com.a.a.a.b paramb)
  {
    PointF localPointF = paramb.c();
    this.a.a(com.viber.voip.ui.doodle.commands.a.b.a(localPointF.x, localPointF.y));
  }

  public static abstract interface a extends a<DoodleObject>, b<DoodleObject, com.viber.voip.ui.doodle.objects.b.a>, f
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.a.c
 * JD-Core Version:    0.6.2
 */
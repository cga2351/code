package com.viber.voip.ui.doodle.objects.b;

import android.graphics.PointF;
import com.viber.voip.ui.doodle.scene.SceneConfig;

public class c extends b
{
  private final PointF a;
  private final float b;
  private final SceneConfig c;

  c(long paramLong, PointF paramPointF, SceneConfig paramSceneConfig)
  {
    super(paramLong);
    this.a = paramPointF;
    this.b = a(paramSceneConfig.getScaleFactor());
    this.c = paramSceneConfig;
  }

  private float a(float paramFloat)
  {
    if (paramFloat >= 1.0F)
      paramFloat = 1.0F / paramFloat;
    while (paramFloat >= 0.5F)
      return paramFloat;
    return 0.5F / paramFloat;
  }

  public PointF a()
  {
    return this.a;
  }

  public float c()
  {
    return this.b;
  }

  public SceneConfig d()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.objects.b.c
 * JD-Core Version:    0.6.2
 */
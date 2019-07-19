package com.viber.voip.ui.doodle.objects.b;

import android.content.Context;
import android.graphics.PointF;
import com.viber.voip.ui.doodle.extras.TextInfo;
import com.viber.voip.ui.doodle.scene.SceneConfig;

public class e extends c
{
  private final Context a;
  private final TextInfo b;

  public e(long paramLong, Context paramContext, PointF paramPointF, SceneConfig paramSceneConfig, TextInfo paramTextInfo)
  {
    super(paramLong, paramPointF, paramSceneConfig);
    this.a = paramContext;
    this.b = paramTextInfo;
  }

  public Context e()
  {
    return this.a;
  }

  public TextInfo f()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.objects.b.e
 * JD-Core Version:    0.6.2
 */
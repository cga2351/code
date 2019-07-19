package com.viber.voip.ui.doodle.objects.b;

import android.graphics.PointF;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.ui.doodle.scene.SceneConfig;

public class d extends c
{
  private final Sticker a;

  public d(long paramLong, PointF paramPointF, SceneConfig paramSceneConfig, Sticker paramSticker)
  {
    super(paramLong, paramPointF, paramSceneConfig);
    this.a = paramSticker;
  }

  public Sticker e()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.objects.b.d
 * JD-Core Version:    0.6.2
 */
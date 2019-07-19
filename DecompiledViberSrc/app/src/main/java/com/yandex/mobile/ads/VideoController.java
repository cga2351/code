package com.yandex.mobile.ads;

import com.yandex.mobile.ads.impl.dj;

public final class VideoController
{
  private final dj a;

  public VideoController(dj paramdj)
  {
    this.a = paramdj;
  }

  public final void setVideoEventListener(VideoEventListener paramVideoEventListener)
  {
    this.a.a(paramVideoEventListener);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.VideoController
 * JD-Core Version:    0.6.2
 */
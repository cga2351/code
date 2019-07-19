package com.yandex.mobile.ads.video;

public abstract interface RequestListener<T>
{
  public abstract void onFailure(VideoAdError paramVideoAdError);

  public abstract void onSuccess(T paramT);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.video.RequestListener
 * JD-Core Version:    0.6.2
 */
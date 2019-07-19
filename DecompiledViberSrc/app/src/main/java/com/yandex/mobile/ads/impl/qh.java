package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.video.VideoAdRequest;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import java.util.List;

public final class qh extends qg<VideoAdRequest, List<VideoAd>>
{
  public qh(VideoAdRequest paramVideoAdRequest, String paramString, pl.a<List<VideoAd>> parama, fe<VideoAdRequest, List<VideoAd>> paramfe)
  {
    super(paramString, parama, paramVideoAdRequest.getContext(), paramVideoAdRequest, paramfe, (byte)0);
  }

  protected final ok<List<VideoAd>> a(String paramString, Exception paramException)
  {
    return ok.a(new py(paramString));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.qh
 * JD-Core Version:    0.6.2
 */
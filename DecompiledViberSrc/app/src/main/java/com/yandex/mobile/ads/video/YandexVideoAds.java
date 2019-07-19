package com.yandex.mobile.ads.video;

import android.content.Context;
import com.yandex.mobile.ads.impl.px;

public class YandexVideoAds
{
  public static void loadBlocksInfo(BlocksInfoRequest paramBlocksInfoRequest)
  {
    Context localContext = paramBlocksInfoRequest.getContext();
    px.a(localContext).a(localContext, paramBlocksInfoRequest);
  }

  public static void loadVideoAds(VideoAdRequest paramVideoAdRequest)
  {
    Context localContext = paramVideoAdRequest.getContext();
    px.a(localContext).a(localContext, paramVideoAdRequest);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.video.YandexVideoAds
 * JD-Core Version:    0.6.2
 */
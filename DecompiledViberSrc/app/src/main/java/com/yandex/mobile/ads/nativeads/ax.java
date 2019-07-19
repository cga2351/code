package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import com.yandex.mobile.ads.impl.ll;
import java.util.ArrayList;
import java.util.List;

public final class ax extends m
  implements NativeImageAd
{
  public ax(Context paramContext, ll paramll, u paramu, i parami, c paramc)
  {
    super(paramContext, paramll, paramu, parami, paramc);
  }

  protected final List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("media");
    return localArrayList;
  }

  public final void bindImageAd(NativeImageAdView paramNativeImageAdView)
    throws NativeAdException
  {
    if (paramNativeImageAdView != null)
    {
      paramNativeImageAdView.a(this);
      a(paramNativeImageAdView, new ay());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.ax
 * JD-Core Version:    0.6.2
 */
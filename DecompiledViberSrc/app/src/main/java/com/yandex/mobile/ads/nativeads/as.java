package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import com.yandex.mobile.ads.impl.ll;
import java.util.ArrayList;
import java.util.List;

public final class as extends m
  implements at
{
  public as(Context paramContext, ll paramll, u paramu, i parami, c paramc)
  {
    super(paramContext, paramll, paramu, parami, paramc);
  }

  protected final List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("body");
    localArrayList.add("domain");
    localArrayList.add("sponsored");
    localArrayList.add("title");
    return localArrayList;
  }

  public final void bindContentAd(NativeContentAdView paramNativeContentAdView)
    throws NativeAdException
  {
    if (paramNativeContentAdView != null)
    {
      paramNativeContentAdView.a(this);
      a(paramNativeContentAdView, new au());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.as
 * JD-Core Version:    0.6.2
 */
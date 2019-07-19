package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import com.yandex.mobile.ads.impl.ll;
import java.util.ArrayList;
import java.util.List;

public final class am extends m
  implements an
{
  public am(Context paramContext, ll paramll, u paramu, i parami, c paramc)
  {
    super(paramContext, paramll, paramu, parami, paramc);
  }

  protected final List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("age");
    localArrayList.add("body");
    localArrayList.add("call_to_action");
    localArrayList.add("icon");
    localArrayList.add("rating");
    localArrayList.add("sponsored");
    localArrayList.add("title");
    return localArrayList;
  }

  public final void bindAppInstallAd(NativeAppInstallAdView paramNativeAppInstallAdView)
    throws NativeAdException
  {
    if (paramNativeAppInstallAdView != null)
    {
      paramNativeAppInstallAdView.a(this);
      a(paramNativeAppInstallAdView, new ao());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.am
 * JD-Core Version:    0.6.2
 */
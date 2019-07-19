package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.util.WeakHashMap;

class d
{
  private static final WeakHashMap<View, NativeAd> a = new WeakHashMap();

  static View a(View paramView, ViewGroup paramViewGroup, Context paramContext, NativeAd paramNativeAd)
  {
    if (paramView != null)
      a(paramView);
    if ((paramNativeAd == null) || (paramNativeAd.isDestroyed()))
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "NativeAd null or invalid. Returning empty view" });
      if ((paramView == null) || (!a.EMPTY.equals(paramView.getTag())))
      {
        paramView = new View(paramContext);
        paramView.setTag(a.EMPTY);
        paramView.setVisibility(8);
      }
      return paramView;
    }
    if ((paramView == null) || (!a.AD.equals(paramView.getTag())))
    {
      paramView = paramNativeAd.createAdView(paramContext, paramViewGroup);
      paramView.setTag(a.AD);
    }
    a(paramView, paramNativeAd);
    paramNativeAd.renderAdView(paramView);
    return paramView;
  }

  private static void a(View paramView)
  {
    NativeAd localNativeAd = (NativeAd)a.get(paramView);
    if (localNativeAd != null)
      localNativeAd.clear(paramView);
  }

  private static void a(View paramView, NativeAd paramNativeAd)
  {
    a.put(paramView, paramNativeAd);
    paramNativeAd.prepare(paramView);
  }

  @VisibleForTesting
  static enum a
  {
    static
    {
      AD = new a("AD", 1);
      a[] arrayOfa = new a[2];
      arrayOfa[0] = EMPTY;
      arrayOfa[1] = AD;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.d
 * JD-Core Version:    0.6.2
 */
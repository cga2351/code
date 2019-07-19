package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.lang.ref.WeakReference;

public final class AdapterHelper
{
  private final WeakReference<Context> a;
  private final Context b;
  private final int c;
  private final int d;

  public AdapterHelper(Context paramContext, int paramInt1, int paramInt2)
  {
    Preconditions.checkNotNull(paramContext, "Context cannot be null.");
    boolean bool2;
    if (paramInt1 >= 0)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2, "start position must be non-negative");
      if (paramInt2 < 2)
        break label77;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1, "interval must be at least 2");
      this.a = new WeakReference(paramContext);
      this.b = paramContext.getApplicationContext();
      this.c = paramInt1;
      this.d = paramInt2;
      return;
      bool2 = false;
      break;
      label77: bool1 = false;
    }
  }

  private int a(int paramInt)
  {
    if (paramInt <= this.c)
      return 0;
    return 1 + (int)Math.floor((paramInt - this.c) / this.d);
  }

  private int b(int paramInt)
  {
    if (paramInt <= this.c)
      return 0;
    int i = -1 + this.d;
    if ((paramInt - this.c) % i == 0)
      return (paramInt - this.c) / i;
    return 1 + (int)Math.floor((paramInt - this.c) / i);
  }

  public View getAdView(View paramView, ViewGroup paramViewGroup, NativeAd paramNativeAd)
  {
    return getAdView(paramView, paramViewGroup, paramNativeAd, null);
  }

  public View getAdView(View paramView, ViewGroup paramViewGroup, NativeAd paramNativeAd, ViewBinder paramViewBinder)
  {
    Context localContext = (Context)this.a.get();
    if (localContext == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Weak reference to Context in AdapterHelper became null. Returning empty view." });
      return new View(this.b);
    }
    return d.a(paramView, paramViewGroup, localContext, paramNativeAd);
  }

  public boolean isAdPosition(int paramInt)
  {
    if (paramInt < this.c);
    while ((paramInt - this.c) % this.d != 0)
      return false;
    return true;
  }

  public int shiftedCount(int paramInt)
  {
    return paramInt + b(paramInt);
  }

  public int shiftedPosition(int paramInt)
  {
    return paramInt - a(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.AdapterHelper
 * JD-Core Version:    0.6.2
 */
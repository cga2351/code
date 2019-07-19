package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ads.zzaaz;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzxp;

class BaseAdView extends ViewGroup
{
  protected final zzaaz zzaaq;

  public BaseAdView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.zzaaq = new zzaaz(this, paramInt);
  }

  public BaseAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.zzaaq = new zzaaz(this, paramAttributeSet, false, paramInt);
  }

  public BaseAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    this.zzaaq = new zzaaz(this, paramAttributeSet, false, paramInt2);
  }

  public void destroy()
  {
    this.zzaaq.destroy();
  }

  public AdListener getAdListener()
  {
    return this.zzaaq.getAdListener();
  }

  public AdSize getAdSize()
  {
    return this.zzaaq.getAdSize();
  }

  public String getAdUnitId()
  {
    return this.zzaaq.getAdUnitId();
  }

  public String getMediationAdapterClassName()
  {
    return this.zzaaq.getMediationAdapterClassName();
  }

  public boolean isLoading()
  {
    return this.zzaaq.isLoading();
  }

  public void loadAd(AdRequest paramAdRequest)
  {
    this.zzaaq.zza(paramAdRequest.zzde());
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = getChildAt(0);
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      int i = localView.getMeasuredWidth();
      int j = localView.getMeasuredHeight();
      int k = (paramInt3 - paramInt1 - i) / 2;
      int m = (paramInt4 - paramInt2 - j) / 2;
      localView.layout(k, m, i + k, j + m);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = getChildAt(0);
    int j;
    int i;
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      measureChild(localView, paramInt1, paramInt2);
      j = localView.getMeasuredWidth();
      i = localView.getMeasuredHeight();
    }
    while (true)
    {
      int k = Math.max(j, getSuggestedMinimumWidth());
      int m = Math.max(i, getSuggestedMinimumHeight());
      setMeasuredDimension(View.resolveSize(k, paramInt1), View.resolveSize(m, paramInt2));
      return;
      try
      {
        AdSize localAdSize2 = getAdSize();
        localAdSize1 = localAdSize2;
        if (localAdSize1 != null)
        {
          Context localContext = getContext();
          j = localAdSize1.getWidthInPixels(localContext);
          i = localAdSize1.getHeightInPixels(localContext);
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        while (true)
        {
          zzbae.zzc("Unable to retrieve ad size.", localNullPointerException);
          AdSize localAdSize1 = null;
        }
        i = 0;
        j = 0;
      }
    }
  }

  public void pause()
  {
    this.zzaaq.pause();
  }

  public void resume()
  {
    this.zzaaq.resume();
  }

  public void setAdListener(AdListener paramAdListener)
  {
    this.zzaaq.setAdListener(paramAdListener);
    if (paramAdListener == null)
    {
      this.zzaaq.zza(null);
      this.zzaaq.setAppEventListener(null);
    }
    do
    {
      return;
      if ((paramAdListener instanceof zzxp))
        this.zzaaq.zza((zzxp)paramAdListener);
    }
    while (!(paramAdListener instanceof AppEventListener));
    this.zzaaq.setAppEventListener((AppEventListener)paramAdListener);
  }

  public void setAdSize(AdSize paramAdSize)
  {
    this.zzaaq.setAdSizes(new AdSize[] { paramAdSize });
  }

  public void setAdUnitId(String paramString)
  {
    this.zzaaq.setAdUnitId(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.BaseAdView
 * JD-Core Version:    0.6.2
 */
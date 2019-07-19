package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaaz;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzzi;

public final class PublisherAdView extends ViewGroup
{
  private final zzaaz zzabf;

  public PublisherAdView(Context paramContext)
  {
    super(paramContext);
    this.zzabf = new zzaaz(this);
  }

  public PublisherAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.zzabf = new zzaaz(this, paramAttributeSet, true);
    Preconditions.checkNotNull(paramContext, "Context cannot be null");
  }

  public PublisherAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.zzabf = new zzaaz(this, paramAttributeSet, true);
  }

  public final void destroy()
  {
    this.zzabf.destroy();
  }

  public final AdListener getAdListener()
  {
    return this.zzabf.getAdListener();
  }

  public final AdSize getAdSize()
  {
    return this.zzabf.getAdSize();
  }

  public final AdSize[] getAdSizes()
  {
    return this.zzabf.getAdSizes();
  }

  public final String getAdUnitId()
  {
    return this.zzabf.getAdUnitId();
  }

  public final AppEventListener getAppEventListener()
  {
    return this.zzabf.getAppEventListener();
  }

  public final String getMediationAdapterClassName()
  {
    return this.zzabf.getMediationAdapterClassName();
  }

  public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
  {
    return this.zzabf.getOnCustomRenderedAdLoadedListener();
  }

  public final VideoController getVideoController()
  {
    return this.zzabf.getVideoController();
  }

  public final VideoOptions getVideoOptions()
  {
    return this.zzabf.getVideoOptions();
  }

  public final boolean isLoading()
  {
    return this.zzabf.isLoading();
  }

  public final void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    this.zzabf.zza(paramPublisherAdRequest.zzde());
  }

  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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

  protected final void onMeasure(int paramInt1, int paramInt2)
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

  public final void pause()
  {
    this.zzabf.pause();
  }

  public final void recordManualImpression()
  {
    this.zzabf.recordManualImpression();
  }

  public final void resume()
  {
    this.zzabf.resume();
  }

  public final void setAdListener(AdListener paramAdListener)
  {
    this.zzabf.setAdListener(paramAdListener);
  }

  public final void setAdSizes(AdSize[] paramArrayOfAdSize)
  {
    if ((paramArrayOfAdSize == null) || (paramArrayOfAdSize.length <= 0))
      throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
    this.zzabf.zza(paramArrayOfAdSize);
  }

  public final void setAdUnitId(String paramString)
  {
    this.zzabf.setAdUnitId(paramString);
  }

  public final void setAppEventListener(AppEventListener paramAppEventListener)
  {
    this.zzabf.setAppEventListener(paramAppEventListener);
  }

  public final void setCorrelator(Correlator paramCorrelator)
  {
    this.zzabf.setCorrelator(paramCorrelator);
  }

  public final void setManualImpressionsEnabled(boolean paramBoolean)
  {
    this.zzabf.setManualImpressionsEnabled(paramBoolean);
  }

  public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    this.zzabf.setOnCustomRenderedAdLoadedListener(paramOnCustomRenderedAdLoadedListener);
  }

  public final void setVideoOptions(VideoOptions paramVideoOptions)
  {
    this.zzabf.setVideoOptions(paramVideoOptions);
  }

  public final boolean zza(zzzi paramzzzi)
  {
    return this.zzabf.zza(paramzzzi);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.doubleclick.PublisherAdView
 * JD-Core Version:    0.6.2
 */
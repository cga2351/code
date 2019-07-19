package com.google.android.gms.ads.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.ads.zzaaz;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzbae;

@zzare
public final class SearchAdView extends ViewGroup
{
  private final zzaaz zzabf;

  public SearchAdView(Context paramContext)
  {
    super(paramContext);
    this.zzabf = new zzaaz(this);
  }

  public SearchAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.zzabf = new zzaaz(this, paramAttributeSet, false);
  }

  public SearchAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.zzabf = new zzaaz(this, paramAttributeSet, false);
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

  public final String getAdUnitId()
  {
    return this.zzabf.getAdUnitId();
  }

  public final void loadAd(DynamicHeightSearchAdRequest paramDynamicHeightSearchAdRequest)
  {
    if (!AdSize.SEARCH.equals(getAdSize()))
      throw new IllegalStateException("You must use AdSize.SEARCH for a DynamicHeightSearchAdRequest");
    this.zzabf.zza(paramDynamicHeightSearchAdRequest.zzde());
  }

  public final void loadAd(SearchAdRequest paramSearchAdRequest)
  {
    this.zzabf.zza(paramSearchAdRequest.zzde());
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

  public final void resume()
  {
    this.zzabf.resume();
  }

  public final void setAdListener(AdListener paramAdListener)
  {
    this.zzabf.setAdListener(paramAdListener);
  }

  public final void setAdSize(AdSize paramAdSize)
  {
    this.zzabf.setAdSizes(new AdSize[] { paramAdSize });
  }

  public final void setAdUnitId(String paramString)
  {
    this.zzabf.setAdUnitId(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.search.SearchAdView
 * JD-Core Version:    0.6.2
 */
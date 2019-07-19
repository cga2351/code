package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.VisibleForTesting;
import com.mopub.network.AdResponse;
import com.mopub.network.ImpressionData;
import com.mopub.network.SingleImpression;
import com.mopub.network.TrackingRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NativeAd
{
  private final Context a;
  private final BaseNativeAd b;
  private final MoPubAdRenderer c;
  private final Set<String> d;
  private final Set<String> e;
  private final String f;
  private ImpressionData g;
  private MoPubNativeEventListener h;
  private boolean i;
  private boolean j;
  private boolean k;

  NativeAd(Context paramContext, AdResponse paramAdResponse, String paramString, BaseNativeAd paramBaseNativeAd, MoPubAdRenderer paramMoPubAdRenderer)
  {
    this(paramContext, paramAdResponse.getImpressionTrackingUrls(), paramAdResponse.getClickTrackingUrl(), paramString, paramBaseNativeAd, paramMoPubAdRenderer);
    this.g = paramAdResponse.getImpressionData();
  }

  public NativeAd(Context paramContext, List<String> paramList, String paramString1, String paramString2, BaseNativeAd paramBaseNativeAd, MoPubAdRenderer paramMoPubAdRenderer)
  {
    this.a = paramContext.getApplicationContext();
    this.f = paramString2;
    this.g = null;
    this.d = new HashSet();
    this.d.addAll(paramList);
    this.d.addAll(paramBaseNativeAd.c());
    this.e = new HashSet();
    this.e.add(paramString1);
    this.e.addAll(paramBaseNativeAd.d());
    this.b = paramBaseNativeAd;
    this.b.setNativeEventListener(new BaseNativeAd.NativeEventListener()
    {
      public void onAdClicked()
      {
        NativeAd.this.b(null);
      }

      public void onAdImpressed()
      {
        NativeAd.this.a(null);
      }
    });
    this.c = paramMoPubAdRenderer;
  }

  @VisibleForTesting
  void a(View paramView)
  {
    if ((this.i) || (this.k))
      return;
    this.i = true;
    TrackingRequest.makeTrackingHttpRequest(this.d, this.a);
    if (this.h != null)
      this.h.onImpression(paramView);
    new SingleImpression(this.f, this.g).sendImpression();
  }

  @VisibleForTesting
  void b(View paramView)
  {
    if ((this.j) || (this.k))
      return;
    TrackingRequest.makeTrackingHttpRequest(this.e, this.a);
    if (this.h != null)
      this.h.onClick(paramView);
    this.j = true;
  }

  public void clear(View paramView)
  {
    if (this.k)
      return;
    this.b.clear(paramView);
  }

  public View createAdView(Context paramContext, ViewGroup paramViewGroup)
  {
    return this.c.createAdView(paramContext, paramViewGroup);
  }

  public void destroy()
  {
    if (this.k)
      return;
    this.b.destroy();
    this.k = true;
  }

  public String getAdUnitId()
  {
    return this.f;
  }

  public BaseNativeAd getBaseNativeAd()
  {
    return this.b;
  }

  public MoPubAdRenderer getMoPubAdRenderer()
  {
    return this.c;
  }

  public boolean isDestroyed()
  {
    return this.k;
  }

  public void prepare(View paramView)
  {
    if (this.k)
      return;
    this.b.prepare(paramView);
  }

  public void renderAdView(View paramView)
  {
    this.c.renderAdView(paramView, this.b);
  }

  public void setMoPubNativeEventListener(MoPubNativeEventListener paramMoPubNativeEventListener)
  {
    this.h = paramMoPubNativeEventListener;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("\n");
    localStringBuilder.append("impressionTrackers").append(":").append(this.d).append("\n");
    localStringBuilder.append("clickTrackers").append(":").append(this.e).append("\n");
    localStringBuilder.append("recordedImpression").append(":").append(this.i).append("\n");
    localStringBuilder.append("isClicked").append(":").append(this.j).append("\n");
    localStringBuilder.append("isDestroyed").append(":").append(this.k).append("\n");
    return localStringBuilder.toString();
  }

  public static abstract interface MoPubNativeEventListener
  {
    public abstract void onClick(View paramView);

    public abstract void onImpression(View paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.NativeAd
 * JD-Core Version:    0.6.2
 */
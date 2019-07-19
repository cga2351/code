package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.internal.ads.zzare;
import java.util.List;
import java.util.Map;

@zzare
public class UnifiedNativeAdMapper
{
  private Bundle extras = new Bundle();
  private VideoController zzcjf;
  private String zzdnj;
  private View zzenc;
  private boolean zzend;
  private String zzene;
  private List<NativeAd.Image> zzenf;
  private NativeAd.Image zzeng;
  private String zzenh;
  private String zzenj;
  private String zzenk;
  private String zzenm;
  private Double zzenn;
  private View zzeno;
  private Object zzenp;
  private boolean zzenq;
  private boolean zzenr;

  public View getAdChoicesContent()
  {
    return this.zzeno;
  }

  public final String getAdvertiser()
  {
    return this.zzenm;
  }

  public final String getBody()
  {
    return this.zzdnj;
  }

  public final String getCallToAction()
  {
    return this.zzenh;
  }

  public final Bundle getExtras()
  {
    return this.extras;
  }

  public final String getHeadline()
  {
    return this.zzene;
  }

  public final NativeAd.Image getIcon()
  {
    return this.zzeng;
  }

  public final List<NativeAd.Image> getImages()
  {
    return this.zzenf;
  }

  public final boolean getOverrideClickHandling()
  {
    return this.zzenr;
  }

  public final boolean getOverrideImpressionRecording()
  {
    return this.zzenq;
  }

  public final String getPrice()
  {
    return this.zzenk;
  }

  public final Double getStarRating()
  {
    return this.zzenn;
  }

  public final String getStore()
  {
    return this.zzenj;
  }

  public final VideoController getVideoController()
  {
    return this.zzcjf;
  }

  public void handleClick(View paramView)
  {
  }

  public boolean hasVideoContent()
  {
    return this.zzend;
  }

  public void recordImpression()
  {
  }

  public void setAdChoicesContent(View paramView)
  {
    this.zzeno = paramView;
  }

  public final void setAdvertiser(String paramString)
  {
    this.zzenm = paramString;
  }

  public final void setBody(String paramString)
  {
    this.zzdnj = paramString;
  }

  public final void setCallToAction(String paramString)
  {
    this.zzenh = paramString;
  }

  public final void setExtras(Bundle paramBundle)
  {
    this.extras = paramBundle;
  }

  public void setHasVideoContent(boolean paramBoolean)
  {
    this.zzend = paramBoolean;
  }

  public final void setHeadline(String paramString)
  {
    this.zzene = paramString;
  }

  public final void setIcon(NativeAd.Image paramImage)
  {
    this.zzeng = paramImage;
  }

  public final void setImages(List<NativeAd.Image> paramList)
  {
    this.zzenf = paramList;
  }

  public void setMediaView(View paramView)
  {
    this.zzenc = paramView;
  }

  public final void setOverrideClickHandling(boolean paramBoolean)
  {
    this.zzenr = paramBoolean;
  }

  public final void setOverrideImpressionRecording(boolean paramBoolean)
  {
    this.zzenq = paramBoolean;
  }

  public final void setPrice(String paramString)
  {
    this.zzenk = paramString;
  }

  public final void setStarRating(Double paramDouble)
  {
    this.zzenn = paramDouble;
  }

  public final void setStore(String paramString)
  {
    this.zzenj = paramString;
  }

  public void trackViews(View paramView, Map<String, View> paramMap1, Map<String, View> paramMap2)
  {
  }

  public void untrackView(View paramView)
  {
  }

  public final void zza(VideoController paramVideoController)
  {
    this.zzcjf = paramVideoController;
  }

  public final View zzacd()
  {
    return this.zzenc;
  }

  public final Object zzkv()
  {
    return this.zzenp;
  }

  public final void zzp(Object paramObject)
  {
    this.zzenp = paramObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
 * JD-Core Version:    0.6.2
 */
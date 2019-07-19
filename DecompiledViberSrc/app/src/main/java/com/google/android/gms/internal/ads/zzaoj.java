package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@zzare
public final class zzaoj extends zzani
{
  private final UnifiedNativeAdMapper zzdhd;

  public zzaoj(UnifiedNativeAdMapper paramUnifiedNativeAdMapper)
  {
    this.zzdhd = paramUnifiedNativeAdMapper;
  }

  public final String getAdvertiser()
  {
    return this.zzdhd.getAdvertiser();
  }

  public final String getBody()
  {
    return this.zzdhd.getBody();
  }

  public final String getCallToAction()
  {
    return this.zzdhd.getCallToAction();
  }

  public final Bundle getExtras()
  {
    return this.zzdhd.getExtras();
  }

  public final String getHeadline()
  {
    return this.zzdhd.getHeadline();
  }

  public final List getImages()
  {
    List localList = this.zzdhd.getImages();
    ArrayList localArrayList = new ArrayList();
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        NativeAd.Image localImage = (NativeAd.Image)localIterator.next();
        localArrayList.add(new zzadv(localImage.getDrawable(), localImage.getUri(), localImage.getScale(), localImage.getWidth(), localImage.getHeight()));
      }
    }
    return localArrayList;
  }

  public final boolean getOverrideClickHandling()
  {
    return this.zzdhd.getOverrideClickHandling();
  }

  public final boolean getOverrideImpressionRecording()
  {
    return this.zzdhd.getOverrideImpressionRecording();
  }

  public final String getPrice()
  {
    return this.zzdhd.getPrice();
  }

  public final double getStarRating()
  {
    if (this.zzdhd.getStarRating() != null)
      return this.zzdhd.getStarRating().doubleValue();
    return -1.0D;
  }

  public final String getStore()
  {
    return this.zzdhd.getStore();
  }

  public final zzaap getVideoController()
  {
    if (this.zzdhd.getVideoController() != null)
      return this.zzdhd.getVideoController().zzdh();
    return null;
  }

  public final void recordImpression()
  {
    this.zzdhd.recordImpression();
  }

  public final void zzc(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3)
  {
    HashMap localHashMap1 = (HashMap)ObjectWrapper.unwrap(paramIObjectWrapper2);
    HashMap localHashMap2 = (HashMap)ObjectWrapper.unwrap(paramIObjectWrapper3);
    this.zzdhd.trackViews((View)ObjectWrapper.unwrap(paramIObjectWrapper1), localHashMap1, localHashMap2);
  }

  public final zzaeh zzri()
  {
    NativeAd.Image localImage = this.zzdhd.getIcon();
    if (localImage != null)
      return new zzadv(localImage.getDrawable(), localImage.getUri(), localImage.getScale(), localImage.getWidth(), localImage.getHeight());
    return null;
  }

  public final zzadz zzrj()
  {
    return null;
  }

  public final IObjectWrapper zzrk()
  {
    Object localObject = this.zzdhd.zzkv();
    if (localObject == null)
      return null;
    return ObjectWrapper.wrap(localObject);
  }

  public final IObjectWrapper zzso()
  {
    View localView = this.zzdhd.getAdChoicesContent();
    if (localView == null)
      return null;
    return ObjectWrapper.wrap(localView);
  }

  public final IObjectWrapper zzsp()
  {
    View localView = this.zzdhd.zzacd();
    if (localView == null)
      return null;
    return ObjectWrapper.wrap(localView);
  }

  public final float zzsq()
  {
    return 0.0F;
  }

  public final void zzt(IObjectWrapper paramIObjectWrapper)
  {
    this.zzdhd.handleClick((View)ObjectWrapper.unwrap(paramIObjectWrapper));
  }

  public final void zzv(IObjectWrapper paramIObjectWrapper)
  {
    this.zzdhd.untrackView((View)ObjectWrapper.unwrap(paramIObjectWrapper));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaoj
 * JD-Core Version:    0.6.2
 */
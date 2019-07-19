package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@zzare
public final class zzanr extends zzanc
{
  private final NativeAppInstallAdMapper zzdgs;

  public zzanr(NativeAppInstallAdMapper paramNativeAppInstallAdMapper)
  {
    this.zzdgs = paramNativeAppInstallAdMapper;
  }

  public final String getBody()
  {
    return this.zzdgs.getBody();
  }

  public final String getCallToAction()
  {
    return this.zzdgs.getCallToAction();
  }

  public final Bundle getExtras()
  {
    return this.zzdgs.getExtras();
  }

  public final String getHeadline()
  {
    return this.zzdgs.getHeadline();
  }

  public final List getImages()
  {
    List localList = this.zzdgs.getImages();
    if (localList != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        NativeAd.Image localImage = (NativeAd.Image)localIterator.next();
        localArrayList.add(new zzadv(localImage.getDrawable(), localImage.getUri(), localImage.getScale(), localImage.getWidth(), localImage.getHeight()));
      }
      return localArrayList;
    }
    return null;
  }

  public final boolean getOverrideClickHandling()
  {
    return this.zzdgs.getOverrideClickHandling();
  }

  public final boolean getOverrideImpressionRecording()
  {
    return this.zzdgs.getOverrideImpressionRecording();
  }

  public final String getPrice()
  {
    return this.zzdgs.getPrice();
  }

  public final double getStarRating()
  {
    return this.zzdgs.getStarRating();
  }

  public final String getStore()
  {
    return this.zzdgs.getStore();
  }

  public final zzaap getVideoController()
  {
    if (this.zzdgs.getVideoController() != null)
      return this.zzdgs.getVideoController().zzdh();
    return null;
  }

  public final void recordImpression()
  {
    this.zzdgs.recordImpression();
  }

  public final void zzc(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3)
  {
    HashMap localHashMap1 = (HashMap)ObjectWrapper.unwrap(paramIObjectWrapper2);
    HashMap localHashMap2 = (HashMap)ObjectWrapper.unwrap(paramIObjectWrapper3);
    this.zzdgs.trackViews((View)ObjectWrapper.unwrap(paramIObjectWrapper1), localHashMap1, localHashMap2);
  }

  public final zzaeh zzri()
  {
    NativeAd.Image localImage = this.zzdgs.getIcon();
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
    return null;
  }

  public final IObjectWrapper zzso()
  {
    View localView = this.zzdgs.getAdChoicesContent();
    if (localView == null)
      return null;
    return ObjectWrapper.wrap(localView);
  }

  public final IObjectWrapper zzsp()
  {
    View localView = this.zzdgs.zzacd();
    if (localView == null)
      return null;
    return ObjectWrapper.wrap(localView);
  }

  public final void zzt(IObjectWrapper paramIObjectWrapper)
  {
    this.zzdgs.handleClick((View)ObjectWrapper.unwrap(paramIObjectWrapper));
  }

  public final void zzu(IObjectWrapper paramIObjectWrapper)
  {
    this.zzdgs.trackView((View)ObjectWrapper.unwrap(paramIObjectWrapper));
  }

  public final void zzv(IObjectWrapper paramIObjectWrapper)
  {
    this.zzdgs.untrackView((View)ObjectWrapper.unwrap(paramIObjectWrapper));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzanr
 * JD-Core Version:    0.6.2
 */
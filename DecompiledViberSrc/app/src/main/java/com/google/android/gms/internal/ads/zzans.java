package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@zzare
public final class zzans extends zzanf
{
  private final NativeContentAdMapper zzdgt;

  public zzans(NativeContentAdMapper paramNativeContentAdMapper)
  {
    this.zzdgt = paramNativeContentAdMapper;
  }

  public final String getAdvertiser()
  {
    return this.zzdgt.getAdvertiser();
  }

  public final String getBody()
  {
    return this.zzdgt.getBody();
  }

  public final String getCallToAction()
  {
    return this.zzdgt.getCallToAction();
  }

  public final Bundle getExtras()
  {
    return this.zzdgt.getExtras();
  }

  public final String getHeadline()
  {
    return this.zzdgt.getHeadline();
  }

  public final List getImages()
  {
    List localList = this.zzdgt.getImages();
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
    return this.zzdgt.getOverrideClickHandling();
  }

  public final boolean getOverrideImpressionRecording()
  {
    return this.zzdgt.getOverrideImpressionRecording();
  }

  public final zzaap getVideoController()
  {
    if (this.zzdgt.getVideoController() != null)
      return this.zzdgt.getVideoController().zzdh();
    return null;
  }

  public final void recordImpression()
  {
    this.zzdgt.recordImpression();
  }

  public final void zzc(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3)
  {
    HashMap localHashMap1 = (HashMap)ObjectWrapper.unwrap(paramIObjectWrapper2);
    HashMap localHashMap2 = (HashMap)ObjectWrapper.unwrap(paramIObjectWrapper3);
    this.zzdgt.trackViews((View)ObjectWrapper.unwrap(paramIObjectWrapper1), localHashMap1, localHashMap2);
  }

  public final zzadz zzrj()
  {
    return null;
  }

  public final IObjectWrapper zzrk()
  {
    return null;
  }

  public final zzaeh zzrl()
  {
    NativeAd.Image localImage = this.zzdgt.getLogo();
    if (localImage != null)
      return new zzadv(localImage.getDrawable(), localImage.getUri(), localImage.getScale(), localImage.getWidth(), localImage.getHeight());
    return null;
  }

  public final IObjectWrapper zzso()
  {
    View localView = this.zzdgt.getAdChoicesContent();
    if (localView == null)
      return null;
    return ObjectWrapper.wrap(localView);
  }

  public final IObjectWrapper zzsp()
  {
    View localView = this.zzdgt.zzacd();
    if (localView == null)
      return null;
    return ObjectWrapper.wrap(localView);
  }

  public final void zzt(IObjectWrapper paramIObjectWrapper)
  {
    this.zzdgt.handleClick((View)ObjectWrapper.unwrap(paramIObjectWrapper));
  }

  public final void zzu(IObjectWrapper paramIObjectWrapper)
  {
    this.zzdgt.trackView((View)ObjectWrapper.unwrap(paramIObjectWrapper));
  }

  public final void zzv(IObjectWrapper paramIObjectWrapper)
  {
    this.zzdgt.untrackView((View)ObjectWrapper.unwrap(paramIObjectWrapper));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzans
 * JD-Core Version:    0.6.2
 */
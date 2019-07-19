package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public final class zzccf extends zzagg
{

  @Nullable
  private final String zzfir;
  private final zzbys zzfmq;
  private final zzbym zzfpj;

  public zzccf(@Nullable String paramString, zzbym paramzzbym, zzbys paramzzbys)
  {
    this.zzfir = paramString;
    this.zzfpj = paramzzbym;
    this.zzfmq = paramzzbys;
  }

  public final void cancelUnconfirmedClick()
    throws RemoteException
  {
    this.zzfpj.cancelUnconfirmedClick();
  }

  public final void destroy()
    throws RemoteException
  {
    this.zzfpj.destroy();
  }

  public final String getAdvertiser()
    throws RemoteException
  {
    return this.zzfmq.getAdvertiser();
  }

  public final String getBody()
    throws RemoteException
  {
    return this.zzfmq.getBody();
  }

  public final String getCallToAction()
    throws RemoteException
  {
    return this.zzfmq.getCallToAction();
  }

  public final Bundle getExtras()
    throws RemoteException
  {
    return this.zzfmq.getExtras();
  }

  public final String getHeadline()
    throws RemoteException
  {
    return this.zzfmq.getHeadline();
  }

  public final List getImages()
    throws RemoteException
  {
    return this.zzfmq.getImages();
  }

  public final String getMediationAdapterClassName()
    throws RemoteException
  {
    return this.zzfir;
  }

  public final List getMuteThisAdReasons()
    throws RemoteException
  {
    if (isCustomMuteThisAdEnabled())
      return this.zzfmq.getMuteThisAdReasons();
    return Collections.emptyList();
  }

  public final String getPrice()
    throws RemoteException
  {
    return this.zzfmq.getPrice();
  }

  public final double getStarRating()
    throws RemoteException
  {
    return this.zzfmq.getStarRating();
  }

  public final String getStore()
    throws RemoteException
  {
    return this.zzfmq.getStore();
  }

  public final zzaap getVideoController()
    throws RemoteException
  {
    return this.zzfmq.getVideoController();
  }

  public final boolean isCustomMuteThisAdEnabled()
    throws RemoteException
  {
    return (!this.zzfmq.getMuteThisAdReasons().isEmpty()) && (this.zzfmq.zzahx() != null);
  }

  public final void performClick(Bundle paramBundle)
    throws RemoteException
  {
    this.zzfpj.zzf(paramBundle);
  }

  public final void recordCustomClickGesture()
  {
    this.zzfpj.recordCustomClickGesture();
  }

  public final boolean recordImpression(Bundle paramBundle)
    throws RemoteException
  {
    return this.zzfpj.zzh(paramBundle);
  }

  public final void reportTouchEvent(Bundle paramBundle)
    throws RemoteException
  {
    this.zzfpj.zzg(paramBundle);
  }

  public final void zza(zzaae paramzzaae)
    throws RemoteException
  {
    this.zzfpj.zza(paramzzaae);
  }

  public final void zza(@Nullable zzaai paramzzaai)
    throws RemoteException
  {
    this.zzfpj.zza(paramzzaai);
  }

  public final void zza(zzagc paramzzagc)
    throws RemoteException
  {
    this.zzfpj.zza(paramzzagc);
  }

  public final IObjectWrapper zzrh()
    throws RemoteException
  {
    return ObjectWrapper.wrap(this.zzfpj);
  }

  public final zzaeh zzri()
    throws RemoteException
  {
    return this.zzfmq.zzri();
  }

  public final zzadz zzrj()
    throws RemoteException
  {
    return this.zzfmq.zzrj();
  }

  public final IObjectWrapper zzrk()
    throws RemoteException
  {
    return this.zzfmq.zzrk();
  }

  public final void zzro()
  {
    this.zzfpj.zzro();
  }

  public final zzaed zzrp()
    throws RemoteException
  {
    return this.zzfpj.zzrp();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzccf
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import javax.annotation.Nullable;

public final class zzcca extends zzafa
{

  @Nullable
  private final String zzfir;
  private final zzbys zzfmq;
  private final zzbym zzfpj;

  public zzcca(@Nullable String paramString, zzbym paramzzbym, zzbys paramzzbys)
  {
    this.zzfir = paramString;
    this.zzfpj = paramzzbym;
    this.zzfmq = paramzzbys;
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

  public final zzaap getVideoController()
    throws RemoteException
  {
    return this.zzfmq.getVideoController();
  }

  public final void performClick(Bundle paramBundle)
    throws RemoteException
  {
    this.zzfpj.zzf(paramBundle);
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

  public final IObjectWrapper zzrh()
    throws RemoteException
  {
    return ObjectWrapper.wrap(this.zzfpj);
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

  public final zzaeh zzrl()
    throws RemoteException
  {
    return this.zzfmq.zzrl();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcca
 * JD-Core Version:    0.6.2
 */
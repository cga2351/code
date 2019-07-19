package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

public final class zzcla extends zzatm
  implements zzbsl
{

  @GuardedBy("this")
  private zzbsm zzgai;

  @GuardedBy("this")
  private zzatl zzgaj;

  @GuardedBy("this")
  private zzbvn zzgak;

  public final void zza(IObjectWrapper paramIObjectWrapper, zzatp paramzzatp)
    throws RemoteException
  {
    try
    {
      if (this.zzgaj != null)
        this.zzgaj.zza(paramIObjectWrapper, paramzzatp);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzatl paramzzatl)
  {
    try
    {
      this.zzgaj = paramzzatl;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzbsm paramzzbsm)
  {
    try
    {
      this.zzgai = paramzzbsm;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzbvn paramzzbvn)
  {
    try
    {
      this.zzgak = paramzzbvn;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzae(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    try
    {
      if (this.zzgaj != null)
        this.zzgaj.zzae(paramIObjectWrapper);
      if (this.zzgak != null)
        this.zzgak.onInitializationSucceeded();
      return;
    }
    finally
    {
    }
  }

  public final void zzaf(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    try
    {
      if (this.zzgaj != null)
        this.zzgaj.zzaf(paramIObjectWrapper);
      if (this.zzgai != null)
        this.zzgai.onAdLoaded();
      return;
    }
    finally
    {
    }
  }

  public final void zzag(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    try
    {
      if (this.zzgaj != null)
        this.zzgaj.zzag(paramIObjectWrapper);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzah(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    try
    {
      if (this.zzgaj != null)
        this.zzgaj.zzah(paramIObjectWrapper);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzai(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    try
    {
      if (this.zzgaj != null)
        this.zzgaj.zzai(paramIObjectWrapper);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzaj(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    try
    {
      if (this.zzgaj != null)
        this.zzgaj.zzaj(paramIObjectWrapper);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzak(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    try
    {
      if (this.zzgaj != null)
        this.zzgaj.zzak(paramIObjectWrapper);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzal(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    try
    {
      if (this.zzgaj != null)
        this.zzgaj.zzal(paramIObjectWrapper);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzb(Bundle paramBundle)
    throws RemoteException
  {
    try
    {
      if (this.zzgaj != null)
        this.zzgaj.zzb(paramBundle);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzd(IObjectWrapper paramIObjectWrapper, int paramInt)
    throws RemoteException
  {
    try
    {
      if (this.zzgaj != null)
        this.zzgaj.zzd(paramIObjectWrapper, paramInt);
      if (this.zzgak != null)
        this.zzgak.zzdl(paramInt);
      return;
    }
    finally
    {
    }
  }

  public final void zze(IObjectWrapper paramIObjectWrapper, int paramInt)
    throws RemoteException
  {
    try
    {
      if (this.zzgaj != null)
        this.zzgaj.zze(paramIObjectWrapper, paramInt);
      if (this.zzgai != null)
        this.zzgai.onAdFailedToLoad(paramInt);
      return;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcla
 * JD-Core Version:    0.6.2
 */
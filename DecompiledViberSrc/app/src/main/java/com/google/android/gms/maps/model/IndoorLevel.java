package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zzq;

public final class IndoorLevel
{
  private final zzq zzdg;

  public IndoorLevel(zzq paramzzq)
  {
    this.zzdg = ((zzq)Preconditions.checkNotNull(paramzzq));
  }

  public final void activate()
  {
    try
    {
      this.zzdg.activate();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof IndoorLevel))
      return false;
    try
    {
      boolean bool = this.zzdg.zzb(((IndoorLevel)paramObject).zzdg);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final String getName()
  {
    try
    {
      String str = this.zzdg.getName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final String getShortName()
  {
    try
    {
      String str = this.zzdg.getShortName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final int hashCode()
  {
    try
    {
      int i = this.zzdg.zzj();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.IndoorLevel
 * JD-Core Version:    0.6.2
 */
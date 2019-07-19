package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.maps.zzn;
import com.google.android.gms.internal.maps.zzq;
import com.google.android.gms.internal.maps.zzr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class IndoorBuilding
{
  private final zzn zzdd;
  private final zza zzde;

  public IndoorBuilding(zzn paramzzn)
  {
    this(paramzzn, zza.zzdf);
  }

  @VisibleForTesting
  private IndoorBuilding(zzn paramzzn, zza paramzza)
  {
    this.zzdd = ((zzn)Preconditions.checkNotNull(paramzzn, "delegate"));
    this.zzde = ((zza)Preconditions.checkNotNull(paramzza, "shim"));
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof IndoorBuilding))
      return false;
    try
    {
      boolean bool = this.zzdd.zzb(((IndoorBuilding)paramObject).zzdd);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final int getActiveLevelIndex()
  {
    try
    {
      int i = this.zzdd.getActiveLevelIndex();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final int getDefaultLevelIndex()
  {
    try
    {
      int i = this.zzdd.getDefaultLevelIndex();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final List<IndoorLevel> getLevels()
  {
    ArrayList localArrayList;
    try
    {
      List localList = this.zzdd.getLevels();
      localArrayList = new ArrayList(localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
        localArrayList.add(zza.zza(zza.zza((IBinder)localIterator.next())));
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    return localArrayList;
  }

  public final int hashCode()
  {
    try
    {
      int i = this.zzdd.zzj();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final boolean isUnderground()
  {
    try
    {
      boolean bool = this.zzdd.isUnderground();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  @VisibleForTesting
  static final class zza
  {
    public static final zza zzdf = new zza();

    public static zzq zza(IBinder paramIBinder)
    {
      return zzr.zzf(paramIBinder);
    }

    public static IndoorLevel zza(zzq paramzzq)
    {
      return new IndoorLevel(paramzzq);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.IndoorBuilding
 * JD-Core Version:    0.6.2
 */
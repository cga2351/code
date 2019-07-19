package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzer<T>
{
  private final Map<T, zzhk<T>> zzeb = new HashMap();

  public final void zza(IBinder paramIBinder)
  {
    Map localMap = this.zzeb;
    Object localObject1;
    if (paramIBinder == null)
      localObject1 = null;
    while (true)
    {
      try
      {
        zzgz localzzgz = new zzgz();
        Iterator localIterator = this.zzeb.entrySet().iterator();
        if (!localIterator.hasNext())
          break;
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        zzhk localzzhk = (zzhk)localEntry.getValue();
        try
        {
          ((zzep)localObject1).zza(localzzgz, new zzd(localzzhk));
          if (!Log.isLoggable("WearableClient", 3))
            continue;
          String str3 = String.valueOf(localEntry.getKey());
          String str4 = String.valueOf(localzzhk);
          Log.d("WearableClient", 27 + String.valueOf(str3).length() + String.valueOf(str4).length() + "onPostInitHandler: added: " + str3 + "/" + str4);
        }
        catch (RemoteException localRemoteException)
        {
          String str1 = String.valueOf(localEntry.getKey());
          String str2 = String.valueOf(localzzhk);
          Log.w("WearableClient", 32 + String.valueOf(str1).length() + String.valueOf(str2).length() + "onPostInitHandler: Didn't add: " + str1 + "/" + str2);
        }
        continue;
      }
      finally
      {
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
      if ((localIInterface instanceof zzep))
        localObject1 = (zzep)localIInterface;
      else
        localObject1 = new zzeq(paramIBinder);
    }
  }

  public final void zza(zzhg paramzzhg, BaseImplementation.ResultHolder<Status> paramResultHolder, T paramT)
    throws RemoteException
  {
    synchronized (this.zzeb)
    {
      zzhk localzzhk = (zzhk)this.zzeb.remove(paramT);
      if (localzzhk == null)
      {
        if (Log.isLoggable("WearableClient", 2))
        {
          String str1 = String.valueOf(paramT);
          Log.v("WearableClient", 25 + String.valueOf(str1).length() + "remove Listener unknown: " + str1);
        }
        paramResultHolder.setResult(new Status(4002));
        return;
      }
      localzzhk.clear();
      if (Log.isLoggable("WearableClient", 2))
      {
        String str2 = String.valueOf(paramT);
        Log.v("WearableClient", 24 + String.valueOf(str2).length() + "service.removeListener: " + str2);
      }
      ((zzep)paramzzhg.getService()).zza(new zzet(this.zzeb, paramT, paramResultHolder), new zzfw(localzzhk));
      return;
    }
  }

  public final void zza(zzhg paramzzhg, BaseImplementation.ResultHolder<Status> paramResultHolder, T paramT, zzhk<T> paramzzhk)
    throws RemoteException
  {
    synchronized (this.zzeb)
    {
      if (this.zzeb.get(paramT) != null)
      {
        if (Log.isLoggable("WearableClient", 2))
        {
          String str3 = String.valueOf(paramT);
          Log.v("WearableClient", 20 + String.valueOf(str3).length() + "duplicate listener: " + str3);
        }
        paramResultHolder.setResult(new Status(4001));
        return;
      }
      if (Log.isLoggable("WearableClient", 2))
      {
        String str2 = String.valueOf(paramT);
        Log.v("WearableClient", 14 + String.valueOf(str2).length() + "new listener: " + str2);
      }
      this.zzeb.put(paramT, paramzzhk);
    }
    try
    {
      ((zzep)paramzzhg.getService()).zza(new zzes(this.zzeb, paramT, paramResultHolder), new zzd(paramzzhk));
      return;
      localObject = finally;
      throw localObject;
    }
    catch (RemoteException localRemoteException)
    {
      if (Log.isLoggable("WearableClient", 3))
      {
        String str1 = String.valueOf(paramT);
        Log.d("WearableClient", 39 + String.valueOf(str1).length() + "addListener failed, removing listener: " + str1);
      }
      this.zzeb.remove(paramT);
      throw localRemoteException;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzer
 * JD-Core Version:    0.6.2
 */
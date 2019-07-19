package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zac;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zacp
{
  public static final Status zakw = new Status(8, "The connection to Google Play services was lost");
  private static final BasePendingResult<?>[] zakx = new BasePendingResult[0];
  private final Map<Api.AnyClientKey<?>, Api.Client> zagy;

  @VisibleForTesting
  final Set<BasePendingResult<?>> zaky = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
  private final zacs zakz = new zacq(this);

  public zacp(Map<Api.AnyClientKey<?>, Api.Client> paramMap)
  {
    this.zagy = paramMap;
  }

  public final void release()
  {
    BasePendingResult[] arrayOfBasePendingResult = (BasePendingResult[])this.zaky.toArray(zakx);
    int i = arrayOfBasePendingResult.length;
    int j = 0;
    while (j < i)
    {
      BasePendingResult localBasePendingResult = arrayOfBasePendingResult[j];
      localBasePendingResult.zaa(null);
      if (localBasePendingResult.zam() == null)
      {
        if (localBasePendingResult.zat())
          this.zaky.remove(localBasePendingResult);
        j++;
      }
      else
      {
        localBasePendingResult.setResultCallback(null);
        IBinder localIBinder = ((Api.Client)this.zagy.get(((BaseImplementation.ApiMethodImpl)localBasePendingResult).getClientKey())).getServiceBrokerBinder();
        if (localBasePendingResult.isReady())
          localBasePendingResult.zaa(new zacr(localBasePendingResult, null, localIBinder, null));
        while (true)
        {
          this.zaky.remove(localBasePendingResult);
          break;
          if ((localIBinder != null) && (localIBinder.isBinderAlive()))
          {
            zacr localzacr = new zacr(localBasePendingResult, null, localIBinder, null);
            localBasePendingResult.zaa(localzacr);
            try
            {
              localIBinder.linkToDeath(localzacr, 0);
            }
            catch (RemoteException localRemoteException)
            {
              localBasePendingResult.cancel();
              null.remove(localBasePendingResult.zam().intValue());
            }
          }
          else
          {
            localBasePendingResult.zaa(null);
            localBasePendingResult.cancel();
            null.remove(localBasePendingResult.zam().intValue());
          }
        }
      }
    }
  }

  final void zab(BasePendingResult<? extends Result> paramBasePendingResult)
  {
    this.zaky.add(paramBasePendingResult);
    paramBasePendingResult.zaa(this.zakz);
  }

  public final void zabx()
  {
    BasePendingResult[] arrayOfBasePendingResult = (BasePendingResult[])this.zaky.toArray(zakx);
    int i = arrayOfBasePendingResult.length;
    for (int j = 0; j < i; j++)
      arrayOfBasePendingResult[j].zab(zakw);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zacp
 * JD-Core Version:    0.6.2
 */
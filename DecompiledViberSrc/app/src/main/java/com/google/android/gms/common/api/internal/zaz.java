package com.google.android.gms.common.api.internal;

import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

final class zaz
  implements OnCompleteListener<Map<zai<?>, String>>
{
  private zaz(zax paramzax)
  {
  }

  public final void onComplete(Task<Map<zai<?>, String>> paramTask)
  {
    zax.zaa(this.zafh).lock();
    try
    {
      boolean bool = zax.zab(this.zafh);
      if (!bool)
        return;
      if (paramTask.isSuccessful())
      {
        zax.zaa(this.zafh, new ArrayMap(zax.zac(this.zafh).size()));
        Iterator localIterator2 = zax.zac(this.zafh).values().iterator();
        while (localIterator2.hasNext())
        {
          zaw localzaw2 = (zaw)localIterator2.next();
          zax.zad(this.zafh).put(localzaw2.zak(), ConnectionResult.RESULT_SUCCESS);
        }
      }
    }
    finally
    {
      zax.zaa(this.zafh).unlock();
    }
    if ((paramTask.getException() instanceof AvailabilityException))
    {
      AvailabilityException localAvailabilityException = (AvailabilityException)paramTask.getException();
      if (zax.zae(this.zafh))
      {
        zax.zaa(this.zafh, new ArrayMap(zax.zac(this.zafh).size()));
        Iterator localIterator1 = zax.zac(this.zafh).values().iterator();
        while (localIterator1.hasNext())
        {
          zaw localzaw1 = (zaw)localIterator1.next();
          zai localzai = localzaw1.zak();
          ConnectionResult localConnectionResult = localAvailabilityException.getConnectionResult(localzaw1);
          if (zax.zaa(this.zafh, localzaw1, localConnectionResult))
            zax.zad(this.zafh).put(localzai, new ConnectionResult(16));
          else
            zax.zad(this.zafh).put(localzai, localConnectionResult);
        }
      }
      zax.zaa(this.zafh, localAvailabilityException.zaj());
      zax.zaa(this.zafh, zax.zaf(this.zafh));
      if (zax.zag(this.zafh) != null)
      {
        zax.zad(this.zafh).putAll(zax.zag(this.zafh));
        zax.zaa(this.zafh, zax.zaf(this.zafh));
      }
      if (zax.zah(this.zafh) != null)
        break label489;
      zax.zai(this.zafh);
      zax.zaj(this.zafh);
    }
    while (true)
    {
      zax.zal(this.zafh).signalAll();
      zax.zaa(this.zafh).unlock();
      return;
      Log.e("ConnectionlessGAC", "Unexpected availability exception", paramTask.getException());
      zax.zaa(this.zafh, Collections.emptyMap());
      zax.zaa(this.zafh, new ConnectionResult(8));
      break;
      label489: zax.zaa(this.zafh, false);
      zax.zak(this.zafh).zac(zax.zah(this.zafh));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaz
 * JD-Core Version:    0.6.2
 */
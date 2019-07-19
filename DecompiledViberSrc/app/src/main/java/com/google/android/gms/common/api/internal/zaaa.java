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

final class zaaa
  implements OnCompleteListener<Map<zai<?>, String>>
{
  private SignInConnectionListener zafi;

  zaaa(zax paramzax, SignInConnectionListener paramSignInConnectionListener)
  {
    this.zafi = paramSignInConnectionListener;
  }

  final void cancel()
  {
    this.zafi.onComplete();
  }

  public final void onComplete(Task<Map<zai<?>, String>> paramTask)
  {
    zax.zaa(this.zafh).lock();
    try
    {
      if (!zax.zab(this.zafh))
      {
        this.zafi.onComplete();
        return;
      }
      if (paramTask.isSuccessful())
      {
        zax.zab(this.zafh, new ArrayMap(zax.zam(this.zafh).size()));
        Iterator localIterator2 = zax.zam(this.zafh).values().iterator();
        while (localIterator2.hasNext())
        {
          zaw localzaw2 = (zaw)localIterator2.next();
          zax.zag(this.zafh).put(localzaw2.zak(), ConnectionResult.RESULT_SUCCESS);
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
        zax.zab(this.zafh, new ArrayMap(zax.zam(this.zafh).size()));
        Iterator localIterator1 = zax.zam(this.zafh).values().iterator();
        while (localIterator1.hasNext())
        {
          zaw localzaw1 = (zaw)localIterator1.next();
          zai localzai = localzaw1.zak();
          ConnectionResult localConnectionResult = localAvailabilityException.getConnectionResult(localzaw1);
          if (zax.zaa(this.zafh, localzaw1, localConnectionResult))
            zax.zag(this.zafh).put(localzai, new ConnectionResult(16));
          else
            zax.zag(this.zafh).put(localzai, localConnectionResult);
        }
      }
      zax.zab(this.zafh, localAvailabilityException.zaj());
    }
    while (true)
    {
      if (this.zafh.isConnected())
      {
        zax.zad(this.zafh).putAll(zax.zag(this.zafh));
        if (zax.zaf(this.zafh) == null)
        {
          zax.zai(this.zafh);
          zax.zaj(this.zafh);
          zax.zal(this.zafh).signalAll();
        }
      }
      this.zafi.onComplete();
      zax.zaa(this.zafh).unlock();
      return;
      Log.e("ConnectionlessGAC", "Unexpected availability exception", paramTask.getException());
      zax.zab(this.zafh, Collections.emptyMap());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaaa
 * JD-Core Version:    0.6.2
 */
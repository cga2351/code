package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.zac;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

final class zacr
  implements IBinder.DeathRecipient, zacs
{
  private final WeakReference<BasePendingResult<?>> zalb;
  private final WeakReference<zac> zalc;
  private final WeakReference<IBinder> zald;

  private zacr(BasePendingResult<?> paramBasePendingResult, zac paramzac, IBinder paramIBinder)
  {
    this.zalc = new WeakReference(paramzac);
    this.zalb = new WeakReference(paramBasePendingResult);
    this.zald = new WeakReference(paramIBinder);
  }

  private final void zaby()
  {
    BasePendingResult localBasePendingResult = (BasePendingResult)this.zalb.get();
    zac localzac = (zac)this.zalc.get();
    if ((localzac != null) && (localBasePendingResult != null))
      localzac.remove(localBasePendingResult.zam().intValue());
    IBinder localIBinder = (IBinder)this.zald.get();
    if (localIBinder != null);
    try
    {
      localIBinder.unlinkToDeath(this, 0);
      return;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
    }
  }

  public final void binderDied()
  {
    zaby();
  }

  public final void zac(BasePendingResult<?> paramBasePendingResult)
  {
    zaby();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zacr
 * JD-Core Version:    0.6.2
 */
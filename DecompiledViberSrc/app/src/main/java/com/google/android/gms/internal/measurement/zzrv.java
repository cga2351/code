package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;

final class zzrv extends ContentObserver
{
  zzrv(Handler paramHandler)
  {
    super(null);
  }

  public final void onChange(boolean paramBoolean)
  {
    zzru.zzti().set(true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzrv
 * JD-Core Version:    0.6.2
 */
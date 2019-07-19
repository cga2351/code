package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

final class zzcmu
  implements zzbao<T>
{
  zzcmu(zzcmt paramzzcmt, String paramString, long paramLong)
  {
  }

  public final void zzb(Throwable paramThrowable)
  {
    int i = 3;
    long l = zzcmt.zza(this.zzgbj).elapsedRealtime();
    if ((paramThrowable instanceof TimeoutException))
      i = 2;
    while (true)
    {
      zzcmt.zza(this.zzgbj, this.zzgbh, i, l - this.zzgbi);
      return;
      if (!(paramThrowable instanceof zzcmj))
        if ((paramThrowable instanceof CancellationException))
          i = 4;
        else if ((paramThrowable instanceof zzcgl))
        {
          if (((zzcgl)paramThrowable).getErrorCode() == i)
            i = 1;
          else
            i = 6;
        }
        else
          i = 6;
    }
  }

  public final void zzk(T paramT)
  {
    long l = zzcmt.zza(this.zzgbj).elapsedRealtime();
    zzcmt.zza(this.zzgbj, this.zzgbh, 0, l - this.zzgbi);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcmu
 * JD-Core Version:    0.6.2
 */
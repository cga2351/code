package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Map;

final class zzaz
  implements Runnable
{
  private final String packageName;
  private final int status;
  private final zzay zzamp;
  private final Throwable zzamq;
  private final byte[] zzamr;
  private final Map<String, List<String>> zzams;

  private zzaz(String paramString, zzay paramzzay, int paramInt, Throwable paramThrowable, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    Preconditions.checkNotNull(paramzzay);
    this.zzamp = paramzzay;
    this.status = paramInt;
    this.zzamq = paramThrowable;
    this.zzamr = paramArrayOfByte;
    this.packageName = paramString;
    this.zzams = paramMap;
  }

  public final void run()
  {
    this.zzamp.zza(this.packageName, this.status, this.zzamq, this.zzamr, this.zzams);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzaz
 * JD-Core Version:    0.6.2
 */
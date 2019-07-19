package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzku extends Exception
{
  private final int type;
  private final int zzark;

  private zzku(int paramInt1, String paramString, Throwable paramThrowable, int paramInt2)
  {
    super(null, paramThrowable);
    this.type = paramInt1;
    this.zzark = paramInt2;
  }

  public static zzku zza(IOException paramIOException)
  {
    return new zzku(0, null, paramIOException, -1);
  }

  public static zzku zza(Exception paramException, int paramInt)
  {
    return new zzku(1, null, paramException, paramInt);
  }

  static zzku zza(RuntimeException paramRuntimeException)
  {
    return new zzku(2, null, paramRuntimeException, -1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzku
 * JD-Core Version:    0.6.2
 */
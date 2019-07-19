package com.google.android.gms.internal.ads;

import java.io.PrintWriter;

final class zzdmf extends zzdmb
{
  public final void zza(Throwable paramThrowable, PrintWriter paramPrintWriter)
  {
    paramThrowable.printStackTrace(paramPrintWriter);
  }

  public final void zza(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    paramThrowable1.addSuppressed(paramThrowable2);
  }

  public final void zzg(Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdmf
 * JD-Core Version:    0.6.2
 */
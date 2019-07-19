package com.google.android.gms.internal.ads;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

final class zzdme extends zzdmb
{
  private final zzdmc zzhcb = new zzdmc();

  public final void zza(Throwable paramThrowable, PrintWriter paramPrintWriter)
  {
    paramThrowable.printStackTrace(paramPrintWriter);
    List localList = this.zzhcb.zza(paramThrowable, false);
    if (localList == null)
      return;
    try
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Throwable localThrowable = (Throwable)localIterator.next();
        paramPrintWriter.print("Suppressed: ");
        localThrowable.printStackTrace(paramPrintWriter);
      }
    }
    finally
    {
    }
  }

  public final void zza(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    if (paramThrowable2 == paramThrowable1)
      throw new IllegalArgumentException("Self suppression is not allowed.", paramThrowable2);
    if (paramThrowable2 == null)
      throw new NullPointerException("The suppressed exception cannot be null.");
    this.zzhcb.zza(paramThrowable1, true).add(paramThrowable2);
  }

  public final void zzg(Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
    List localList = this.zzhcb.zza(paramThrowable, false);
    if (localList == null)
      return;
    try
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Throwable localThrowable = (Throwable)localIterator.next();
        System.err.print("Suppressed: ");
        localThrowable.printStackTrace();
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdme
 * JD-Core Version:    0.6.2
 */
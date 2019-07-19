package com.google.android.gms.internal.measurement;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

final class zzsv extends zzss
{
  private final zzst zzbsl = new zzst();

  public final void zza(Throwable paramThrowable, PrintStream paramPrintStream)
  {
    paramThrowable.printStackTrace(paramPrintStream);
    List localList = this.zzbsl.zza(paramThrowable, false);
    if (localList == null)
      return;
    try
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Throwable localThrowable = (Throwable)localIterator.next();
        paramPrintStream.print("Suppressed: ");
        localThrowable.printStackTrace(paramPrintStream);
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzsv
 * JD-Core Version:    0.6.2
 */
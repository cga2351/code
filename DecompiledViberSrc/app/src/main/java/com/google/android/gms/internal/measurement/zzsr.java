package com.google.android.gms.internal.measurement;

import java.io.PrintStream;
import java.lang.reflect.Field;

public final class zzsr
{
  private static final zzss zzbsf;
  private static final int zzbsg;

  static
  {
    try
    {
      Integer localInteger2 = zztu();
      localInteger1 = localInteger2;
      if (localInteger1 != null);
      while (true)
      {
        try
        {
          if (localInteger1.intValue() >= 19)
          {
            localObject2 = new zzsw();
            zzbsf = (zzss)localObject2;
            if (localInteger1 != null)
              break label166;
            i = 1;
            zzbsg = i;
            return;
          }
          if (Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic"))
            break label148;
          j = 1;
          if (j == 0)
            break label154;
          localObject2 = new zzsv();
          continue;
        }
        catch (Throwable localThrowable2)
        {
        }
        PrintStream localPrintStream = System.err;
        String str = zza.class.getName();
        localPrintStream.println(132 + String.valueOf(str).length() + "An error has occured when initializing the try-with-resources desuguring strategy. The default strategy " + str + "will be used. The error is: ");
        localThrowable2.printStackTrace(System.err);
        Object localObject2 = new zza();
        continue;
        label148: int j = 0;
        continue;
        label154: localObject2 = new zza();
        continue;
        label166: int i = localInteger1.intValue();
      }
    }
    catch (Throwable localThrowable1)
    {
      while (true)
      {
        Object localObject1 = localThrowable1;
        Integer localInteger1 = null;
      }
    }
  }

  public static void zza(Throwable paramThrowable, PrintStream paramPrintStream)
  {
    zzbsf.zza(paramThrowable, paramPrintStream);
  }

  private static Integer zztu()
  {
    try
    {
      Integer localInteger = (Integer)Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
      return localInteger;
    }
    catch (Exception localException)
    {
      System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
      localException.printStackTrace(System.err);
    }
    return null;
  }

  static final class zza extends zzss
  {
    public final void zza(Throwable paramThrowable, PrintStream paramPrintStream)
    {
      paramThrowable.printStackTrace(paramPrintStream);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzsr
 * JD-Core Version:    0.6.2
 */
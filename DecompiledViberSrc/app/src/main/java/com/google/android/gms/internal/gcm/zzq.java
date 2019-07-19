package com.google.android.gms.internal.gcm;

import java.io.PrintStream;
import java.lang.reflect.Field;

public final class zzq
{
  private static final zzr zzdq;
  private static final int zzdr;

  static
  {
    try
    {
      Integer localInteger2 = zzac();
      localInteger1 = localInteger2;
      if (localInteger1 != null);
      while (true)
      {
        try
        {
          if (localInteger1.intValue() >= 19)
          {
            localObject2 = new zzv();
            zzdq = (zzr)localObject2;
            if (localInteger1 != null)
              break label166;
            i = 1;
            zzdr = i;
            return;
          }
          if (Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic"))
            break label148;
          j = 1;
          if (j == 0)
            break label154;
          localObject2 = new zzu();
          continue;
        }
        catch (Throwable localThrowable2)
        {
        }
        PrintStream localPrintStream = System.err;
        String str = zzd.class.getName();
        localPrintStream.println(133 + String.valueOf(str).length() + "An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy " + str + "will be used. The error is: ");
        localThrowable2.printStackTrace(System.err);
        Object localObject2 = new zzd();
        continue;
        label148: int j = 0;
        continue;
        label154: localObject2 = new zzd();
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

  private static Integer zzac()
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

  public static void zzd(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    zzdq.zzd(paramThrowable1, paramThrowable2);
  }

  static final class zzd extends zzr
  {
    public final void zzd(Throwable paramThrowable1, Throwable paramThrowable2)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gcm.zzq
 * JD-Core Version:    0.6.2
 */
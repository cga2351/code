package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

@KeepForSdk
public class ProcessUtils
{
  private static String zzhd = null;
  private static int zzhe = 0;

  @Nullable
  @KeepForSdk
  public static String getMyProcessName()
  {
    if (zzhd == null)
    {
      if (zzhe == 0)
        zzhe = Process.myPid();
      zzhd = zzd(zzhe);
    }
    return zzhd;
  }

  // ERROR //
  @Nullable
  private static String zzd(int paramInt)
  {
    // Byte code:
    //   0: iload_0
    //   1: ifgt +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 35	java/lang/StringBuilder
    //   9: dup
    //   10: bipush 25
    //   12: invokespecial 38	java/lang/StringBuilder:<init>	(I)V
    //   15: ldc 40
    //   17: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: iload_0
    //   21: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: ldc 49
    //   26: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 56	com/google/android/gms/common/util/ProcessUtils:zzj	(Ljava/lang/String;)Ljava/io/BufferedReader;
    //   35: astore 5
    //   37: aload 5
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 61	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: invokevirtual 66	java/lang/String:trim	()Ljava/lang/String;
    //   47: astore 7
    //   49: aload_2
    //   50: invokestatic 72	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   53: aload 7
    //   55: areturn
    //   56: astore 4
    //   58: aconst_null
    //   59: astore_2
    //   60: aload_2
    //   61: invokestatic 72	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   64: aconst_null
    //   65: areturn
    //   66: astore_1
    //   67: aconst_null
    //   68: astore_2
    //   69: aload_1
    //   70: astore_3
    //   71: aload_2
    //   72: invokestatic 72	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   75: aload_3
    //   76: athrow
    //   77: astore_3
    //   78: goto -7 -> 71
    //   81: astore 6
    //   83: goto -23 -> 60
    //
    // Exception table:
    //   from	to	target	type
    //   6	37	56	java/io/IOException
    //   6	37	66	finally
    //   40	49	77	finally
    //   40	49	81	java/io/IOException
  }

  private static BufferedReader zzj(String paramString)
    throws IOException
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.allowThreadDiskReads();
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader(paramString));
      return localBufferedReader;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.ProcessUtils
 * JD-Core Version:    0.6.2
 */
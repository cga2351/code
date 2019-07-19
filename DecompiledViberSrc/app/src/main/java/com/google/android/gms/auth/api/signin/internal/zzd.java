package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;

public final class zzd
  implements Runnable
{
  private static final Logger zzbd = new Logger("RevokeAccessOperation", new String[0]);
  private final String zzbe;
  private final StatusPendingResult zzbf;

  private zzd(String paramString)
  {
    Preconditions.checkNotEmpty(paramString);
    this.zzbe = paramString;
    this.zzbf = new StatusPendingResult(null);
  }

  public static PendingResult<Status> zzc(String paramString)
  {
    if (paramString == null)
      return PendingResults.immediateFailedResult(new Status(4), null);
    zzd localzzd = new zzd(paramString);
    new Thread(localzzd).start();
    return localzzd.zzbf;
  }

  // ERROR //
  public final void run()
  {
    // Byte code:
    //   0: getstatic 76	com/google/android/gms/common/api/Status:RESULT_INTERNAL_ERROR	Lcom/google/android/gms/common/api/Status;
    //   3: astore_1
    //   4: ldc 78
    //   6: invokestatic 82	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   9: astore 11
    //   11: aload_0
    //   12: getfield 37	com/google/android/gms/auth/api/signin/internal/zzd:zzbe	Ljava/lang/String;
    //   15: invokestatic 82	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   18: astore 12
    //   20: aload 12
    //   22: invokevirtual 86	java/lang/String:length	()I
    //   25: ifeq +100 -> 125
    //   28: aload 11
    //   30: aload 12
    //   32: invokevirtual 89	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore 13
    //   37: new 91	java/net/URL
    //   40: dup
    //   41: aload 13
    //   43: invokespecial 92	java/net/URL:<init>	(Ljava/lang/String;)V
    //   46: invokevirtual 96	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   49: checkcast 98	java/net/HttpURLConnection
    //   52: astore 14
    //   54: aload 14
    //   56: ldc 100
    //   58: ldc 102
    //   60: invokevirtual 106	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload 14
    //   65: invokevirtual 109	java/net/HttpURLConnection:getResponseCode	()I
    //   68: istore 15
    //   70: iload 15
    //   72: sipush 200
    //   75: if_icmpne +115 -> 190
    //   78: getstatic 112	com/google/android/gms/common/api/Status:RESULT_SUCCESS	Lcom/google/android/gms/common/api/Status;
    //   81: astore 6
    //   83: getstatic 26	com/google/android/gms/auth/api/signin/internal/zzd:zzbd	Lcom/google/android/gms/common/logging/Logger;
    //   86: new 114	java/lang/StringBuilder
    //   89: dup
    //   90: bipush 26
    //   92: invokespecial 115	java/lang/StringBuilder:<init>	(I)V
    //   95: ldc 117
    //   97: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: iload 15
    //   102: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: iconst_0
    //   109: anewarray 4	java/lang/Object
    //   112: invokevirtual 132	com/google/android/gms/common/logging/Logger:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: aload_0
    //   116: getfield 44	com/google/android/gms/auth/api/signin/internal/zzd:zzbf	Lcom/google/android/gms/common/api/internal/StatusPendingResult;
    //   119: aload 6
    //   121: invokevirtual 136	com/google/android/gms/common/api/internal/StatusPendingResult:setResult	(Lcom/google/android/gms/common/api/Result;)V
    //   124: return
    //   125: new 20	java/lang/String
    //   128: dup
    //   129: aload 11
    //   131: invokespecial 137	java/lang/String:<init>	(Ljava/lang/String;)V
    //   134: astore 13
    //   136: goto -99 -> 37
    //   139: astore 7
    //   141: getstatic 26	com/google/android/gms/auth/api/signin/internal/zzd:zzbd	Lcom/google/android/gms/common/logging/Logger;
    //   144: astore 8
    //   146: aload 7
    //   148: invokevirtual 138	java/io/IOException:toString	()Ljava/lang/String;
    //   151: invokestatic 82	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   154: astore 9
    //   156: aload 9
    //   158: invokevirtual 86	java/lang/String:length	()I
    //   161: ifeq +47 -> 208
    //   164: ldc 140
    //   166: aload 9
    //   168: invokevirtual 89	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   171: astore 10
    //   173: aload 8
    //   175: aload 10
    //   177: iconst_0
    //   178: anewarray 4	java/lang/Object
    //   181: invokevirtual 143	com/google/android/gms/common/logging/Logger:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: aload_1
    //   185: astore 6
    //   187: goto -72 -> 115
    //   190: getstatic 26	com/google/android/gms/auth/api/signin/internal/zzd:zzbd	Lcom/google/android/gms/common/logging/Logger;
    //   193: ldc 145
    //   195: iconst_0
    //   196: anewarray 4	java/lang/Object
    //   199: invokevirtual 143	com/google/android/gms/common/logging/Logger:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   202: aload_1
    //   203: astore 6
    //   205: goto -122 -> 83
    //   208: new 20	java/lang/String
    //   211: dup
    //   212: ldc 140
    //   214: invokespecial 137	java/lang/String:<init>	(Ljava/lang/String;)V
    //   217: astore 10
    //   219: goto -46 -> 173
    //   222: astore_2
    //   223: getstatic 26	com/google/android/gms/auth/api/signin/internal/zzd:zzbd	Lcom/google/android/gms/common/logging/Logger;
    //   226: astore_3
    //   227: aload_2
    //   228: invokevirtual 146	java/lang/Exception:toString	()Ljava/lang/String;
    //   231: invokestatic 82	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   234: astore 4
    //   236: aload 4
    //   238: invokevirtual 86	java/lang/String:length	()I
    //   241: ifeq +28 -> 269
    //   244: ldc 148
    //   246: aload 4
    //   248: invokevirtual 89	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   251: astore 5
    //   253: aload_3
    //   254: aload 5
    //   256: iconst_0
    //   257: anewarray 4	java/lang/Object
    //   260: invokevirtual 143	com/google/android/gms/common/logging/Logger:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: aload_1
    //   264: astore 6
    //   266: goto -151 -> 115
    //   269: new 20	java/lang/String
    //   272: dup
    //   273: ldc 148
    //   275: invokespecial 137	java/lang/String:<init>	(Ljava/lang/String;)V
    //   278: astore 5
    //   280: goto -27 -> 253
    //   283: astore 17
    //   285: aload 6
    //   287: astore_1
    //   288: aload 17
    //   290: astore_2
    //   291: goto -68 -> 223
    //   294: astore 16
    //   296: aload 6
    //   298: astore_1
    //   299: aload 16
    //   301: astore 7
    //   303: goto -162 -> 141
    //
    // Exception table:
    //   from	to	target	type
    //   4	37	139	java/io/IOException
    //   37	70	139	java/io/IOException
    //   78	83	139	java/io/IOException
    //   125	136	139	java/io/IOException
    //   190	202	139	java/io/IOException
    //   4	37	222	java/lang/Exception
    //   37	70	222	java/lang/Exception
    //   78	83	222	java/lang/Exception
    //   125	136	222	java/lang/Exception
    //   190	202	222	java/lang/Exception
    //   83	115	283	java/lang/Exception
    //   83	115	294	java/io/IOException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzd
 * JD-Core Version:    0.6.2
 */
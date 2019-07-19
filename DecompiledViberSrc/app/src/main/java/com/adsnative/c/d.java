package com.adsnative.c;

import android.content.Context;
import android.os.AsyncTask;
import java.util.Map;

public class d extends AsyncTask<Void, Void, Map<String, String>>
{
  private Context a;

  public d(Context paramContext)
  {
    this.a = paramContext;
  }

  // ERROR //
  protected Map<String, String> a(Void[] paramArrayOfVoid)
  {
    // Byte code:
    //   0: new 23	java/util/HashMap
    //   3: dup
    //   4: invokespecial 24	java/util/HashMap:<init>	()V
    //   7: astore_2
    //   8: invokestatic 30	com/google/android/gms/common/GoogleApiAvailability:getInstance	()Lcom/google/android/gms/common/GoogleApiAvailability;
    //   11: aload_0
    //   12: getfield 14	com/adsnative/c/d:a	Landroid/content/Context;
    //   15: invokevirtual 34	com/google/android/gms/common/GoogleApiAvailability:isGooglePlayServicesAvailable	(Landroid/content/Context;)I
    //   18: istore_3
    //   19: new 36	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   26: ldc 39
    //   28: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: iload_3
    //   32: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 56	com/adsnative/c/i:c	(Ljava/lang/String;)V
    //   41: iload_3
    //   42: ifne +251 -> 293
    //   45: aload_0
    //   46: getfield 14	com/adsnative/c/d:a	Landroid/content/Context;
    //   49: invokestatic 62	com/google/android/gms/ads/identifier/AdvertisingIdClient:getAdvertisingIdInfo	(Landroid/content/Context;)Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    //   52: astore 9
    //   54: aload 9
    //   56: ifnull +89 -> 145
    //   59: aload_2
    //   60: ldc 64
    //   62: aload 9
    //   64: invokevirtual 69	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info:getId	()Ljava/lang/String;
    //   67: invokeinterface 75 3 0
    //   72: pop
    //   73: aload 9
    //   75: invokevirtual 79	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info:isLimitAdTrackingEnabled	()Z
    //   78: ifeq +23 -> 101
    //   81: aload_2
    //   82: ldc 81
    //   84: ldc 83
    //   86: invokeinterface 75 3 0
    //   91: pop
    //   92: aload_0
    //   93: getfield 14	com/adsnative/c/d:a	Landroid/content/Context;
    //   96: invokestatic 88	com/google/android/gms/security/ProviderInstaller:installIfNeeded	(Landroid/content/Context;)V
    //   99: aload_2
    //   100: areturn
    //   101: aload_2
    //   102: ldc 81
    //   104: ldc 90
    //   106: invokeinterface 75 3 0
    //   111: pop
    //   112: goto -20 -> 92
    //   115: astore 8
    //   117: new 36	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   124: ldc 92
    //   126: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload 8
    //   131: invokevirtual 95	java/io/IOException:getMessage	()Ljava/lang/String;
    //   134: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 98	com/adsnative/c/i:e	(Ljava/lang/String;)V
    //   143: aconst_null
    //   144: areturn
    //   145: aload_2
    //   146: ldc 64
    //   148: getstatic 104	android/os/Build:SERIAL	Ljava/lang/String;
    //   151: invokeinterface 75 3 0
    //   156: pop
    //   157: aload_2
    //   158: ldc 81
    //   160: ldc 90
    //   162: invokeinterface 75 3 0
    //   167: pop
    //   168: goto -76 -> 92
    //   171: astore 7
    //   173: new 36	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   180: ldc 106
    //   182: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload 7
    //   187: invokevirtual 107	com/google/android/gms/common/GooglePlayServicesNotAvailableException:getMessage	()Ljava/lang/String;
    //   190: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 98	com/adsnative/c/i:e	(Ljava/lang/String;)V
    //   199: aconst_null
    //   200: areturn
    //   201: astore 6
    //   203: new 36	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   210: ldc 109
    //   212: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 6
    //   217: invokevirtual 110	com/google/android/gms/common/GooglePlayServicesRepairableException:getMessage	()Ljava/lang/String;
    //   220: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 98	com/adsnative/c/i:e	(Ljava/lang/String;)V
    //   229: aconst_null
    //   230: areturn
    //   231: astore 13
    //   233: new 36	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   240: ldc 109
    //   242: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload 13
    //   247: invokevirtual 110	com/google/android/gms/common/GooglePlayServicesRepairableException:getMessage	()Ljava/lang/String;
    //   250: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 98	com/adsnative/c/i:e	(Ljava/lang/String;)V
    //   259: goto -160 -> 99
    //   262: astore 12
    //   264: new 36	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   271: ldc 106
    //   273: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 12
    //   278: invokevirtual 107	com/google/android/gms/common/GooglePlayServicesNotAvailableException:getMessage	()Ljava/lang/String;
    //   281: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 98	com/adsnative/c/i:e	(Ljava/lang/String;)V
    //   290: goto -191 -> 99
    //   293: aload_2
    //   294: ldc 64
    //   296: getstatic 104	android/os/Build:SERIAL	Ljava/lang/String;
    //   299: invokeinterface 75 3 0
    //   304: pop
    //   305: aload_2
    //   306: ldc 81
    //   308: ldc 90
    //   310: invokeinterface 75 3 0
    //   315: pop
    //   316: goto -217 -> 99
    //
    // Exception table:
    //   from	to	target	type
    //   45	54	115	java/io/IOException
    //   59	92	115	java/io/IOException
    //   101	112	115	java/io/IOException
    //   145	168	115	java/io/IOException
    //   45	54	171	com/google/android/gms/common/GooglePlayServicesNotAvailableException
    //   59	92	171	com/google/android/gms/common/GooglePlayServicesNotAvailableException
    //   101	112	171	com/google/android/gms/common/GooglePlayServicesNotAvailableException
    //   145	168	171	com/google/android/gms/common/GooglePlayServicesNotAvailableException
    //   45	54	201	com/google/android/gms/common/GooglePlayServicesRepairableException
    //   59	92	201	com/google/android/gms/common/GooglePlayServicesRepairableException
    //   101	112	201	com/google/android/gms/common/GooglePlayServicesRepairableException
    //   145	168	201	com/google/android/gms/common/GooglePlayServicesRepairableException
    //   92	99	231	com/google/android/gms/common/GooglePlayServicesRepairableException
    //   92	99	262	com/google/android/gms/common/GooglePlayServicesNotAvailableException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.c.d
 * JD-Core Version:    0.6.2
 */
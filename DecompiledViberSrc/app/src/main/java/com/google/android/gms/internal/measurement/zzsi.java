package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public abstract class zzsi<T>
{
  private static final Object zzbro = new Object();
  private static boolean zzbrp = false;
  private static final AtomicInteger zzbrs = new AtomicInteger();

  @SuppressLint({"StaticFieldLeak"})
  private static Context zzri = null;
  private final String name;
  private volatile T zzall;
  private final zzso zzbrq;
  private final T zzbrr;
  private volatile int zzbrt = -1;

  private zzsi(zzso paramzzso, String paramString, T paramT)
  {
    if (zzso.zza(paramzzso) == null)
      throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    this.zzbrq = paramzzso;
    this.name = paramString;
    this.zzbrr = paramT;
  }

  private static zzsi<Double> zza(zzso paramzzso, String paramString, double paramDouble)
  {
    return new zzsm(paramzzso, paramString, Double.valueOf(paramDouble));
  }

  private static zzsi<Integer> zza(zzso paramzzso, String paramString, int paramInt)
  {
    return new zzsk(paramzzso, paramString, Integer.valueOf(paramInt));
  }

  private static zzsi<Long> zza(zzso paramzzso, String paramString, long paramLong)
  {
    return new zzsj(paramzzso, paramString, Long.valueOf(paramLong));
  }

  private static zzsi<String> zza(zzso paramzzso, String paramString1, String paramString2)
  {
    return new zzsn(paramzzso, paramString1, paramString2);
  }

  private static zzsi<Boolean> zza(zzso paramzzso, String paramString, boolean paramBoolean)
  {
    return new zzsl(paramzzso, paramString, Boolean.valueOf(paramBoolean));
  }

  // ERROR //
  public static void zzae(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 32	com/google/android/gms/internal/measurement/zzsi:zzbro	Ljava/lang/Object;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: aload_0
    //   7: invokevirtual 125	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnonnull +91 -> 103
    //   15: getstatic 34	com/google/android/gms/internal/measurement/zzsi:zzri	Landroid/content/Context;
    //   18: aload_0
    //   19: if_acmpeq +52 -> 71
    //   22: ldc 127
    //   24: monitorenter
    //   25: getstatic 131	com/google/android/gms/internal/measurement/zzrx:zzbrd	Ljava/util/Map;
    //   28: invokeinterface 136 1 0
    //   33: ldc 127
    //   35: monitorexit
    //   36: ldc 138
    //   38: monitorenter
    //   39: getstatic 141	com/google/android/gms/internal/measurement/zzsp:zzbsb	Ljava/util/Map;
    //   42: invokeinterface 136 1 0
    //   47: ldc 138
    //   49: monitorexit
    //   50: ldc 143
    //   52: monitorenter
    //   53: aconst_null
    //   54: putstatic 147	com/google/android/gms/internal/measurement/zzse:zzbrl	Lcom/google/android/gms/internal/measurement/zzse;
    //   57: ldc 143
    //   59: monitorexit
    //   60: getstatic 41	com/google/android/gms/internal/measurement/zzsi:zzbrs	Ljava/util/concurrent/atomic/AtomicInteger;
    //   63: invokevirtual 151	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   66: pop
    //   67: aload_0
    //   68: putstatic 34	com/google/android/gms/internal/measurement/zzsi:zzri	Landroid/content/Context;
    //   71: aload_1
    //   72: monitorexit
    //   73: return
    //   74: astore 4
    //   76: ldc 127
    //   78: monitorexit
    //   79: aload 4
    //   81: athrow
    //   82: astore_2
    //   83: aload_1
    //   84: monitorexit
    //   85: aload_2
    //   86: athrow
    //   87: astore 5
    //   89: ldc 138
    //   91: monitorexit
    //   92: aload 5
    //   94: athrow
    //   95: astore 6
    //   97: ldc 143
    //   99: monitorexit
    //   100: aload 6
    //   102: athrow
    //   103: aload_3
    //   104: astore_0
    //   105: goto -90 -> 15
    //
    // Exception table:
    //   from	to	target	type
    //   25	36	74	finally
    //   76	79	74	finally
    //   6	11	82	finally
    //   15	25	82	finally
    //   36	39	82	finally
    //   50	53	82	finally
    //   60	71	82	finally
    //   71	73	82	finally
    //   79	82	82	finally
    //   83	85	82	finally
    //   92	95	82	finally
    //   100	103	82	finally
    //   39	50	87	finally
    //   89	92	87	finally
    //   53	60	95	finally
    //   97	100	95	finally
  }

  private final String zzfr(String paramString)
  {
    if ((paramString != null) && (paramString.isEmpty()))
      return this.name;
    String str1 = String.valueOf(paramString);
    String str2 = String.valueOf(this.name);
    if (str2.length() != 0)
      return str1.concat(str2);
    return new String(str1);
  }

  static void zztq()
  {
    zzbrs.incrementAndGet();
  }

  @Nullable
  private final T zzts()
  {
    String str1 = (String)zzse.zzad(zzri).zzfn("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
    int i;
    int j;
    if ((str1 != null) && (zzru.zzbqq.matcher(str1).matches()))
    {
      i = 1;
      if (i == 0)
        break label114;
      j = 1;
      label46: if (j != 0)
        break label141;
      if (zzso.zza(this.zzbrq) == null)
        break label120;
    }
    label114: label120: Context localContext;
    for (Object localObject1 = zzrx.zza(zzri.getContentResolver(), zzso.zza(this.zzbrq)); ; localObject1 = zzsp.zzi(localContext, null))
    {
      if (localObject1 == null)
        break label175;
      Object localObject2 = ((zzsb)localObject1).zzfn(zztr());
      if (localObject2 == null)
        break label175;
      return zzs(localObject2);
      i = 0;
      break;
      j = 0;
      break label46;
      localContext = zzri;
    }
    label141: String str2 = String.valueOf(zztr());
    if (str2.length() != 0);
    for (String str3 = "Bypass reading Phenotype values for flag: ".concat(str2); ; str3 = new String("Bypass reading Phenotype values for flag: "))
    {
      Log.w("PhenotypeFlag", str3);
      label175: return null;
    }
  }

  @Nullable
  private final T zztt()
  {
    zzse localzzse = zzse.zzad(zzri);
    Object localObject = localzzse.zzfn(zzfr(zzso.zzc(this.zzbrq)));
    if (localObject != null)
      return zzs(localObject);
    return null;
  }

  public final T get()
  {
    int i = zzbrs.get();
    Object localObject2;
    if (this.zzbrt < i)
    {
      try
      {
        if (this.zzbrt >= i)
          break label74;
        if (zzri == null)
          throw new IllegalStateException("Must call PhenotypeFlag.init() first");
      }
      finally
      {
      }
      localObject2 = zzts();
      if (localObject2 == null)
        break label81;
    }
    while (true)
    {
      this.zzall = localObject2;
      this.zzbrt = i;
      label74: return this.zzall;
      label81: localObject2 = zztt();
      if (localObject2 == null)
        localObject2 = this.zzbrr;
    }
  }

  public final T getDefaultValue()
  {
    return this.zzbrr;
  }

  abstract T zzs(Object paramObject);

  public final String zztr()
  {
    return zzfr(zzso.zzb(this.zzbrq));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzsi
 * JD-Core Version:    0.6.2
 */
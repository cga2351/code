package com.google.android.gms.internal.ads;

import android.net.Uri;

final class zzih
  implements zzkc
{
  private final Uri uri;
  private final zzjp zzahu;
  private final zzid zzaic;
  private final zzjr zzaid;
  private final int zzaie;
  private final zzij zzajc;
  private volatile boolean zzajd;
  private boolean zzaje;

  public zzih(Uri paramUri, zzjp paramzzjp, zzid paramzzid, zzjr paramzzjr, int paramInt, long paramLong)
  {
    this.uri = ((Uri)zzkh.checkNotNull(paramUri));
    this.zzahu = ((zzjp)zzkh.checkNotNull(paramzzjp));
    this.zzaic = ((zzid)zzkh.checkNotNull(paramzzid));
    this.zzaid = ((zzjr)zzkh.checkNotNull(paramzzjr));
    this.zzaie = paramInt;
    this.zzajc = new zzij();
    this.zzajc.zzahv = paramLong;
    this.zzaje = true;
  }

  public final void zzfp()
  {
    this.zzajd = true;
  }

  public final boolean zzfq()
  {
    return this.zzajd;
  }

  // ERROR //
  public final void zzfr()
    throws java.io.IOException, java.lang.InterruptedException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 61	com/google/android/gms/internal/ads/zzih:zzaje	Z
    //   4: ifeq +17 -> 21
    //   7: aload_0
    //   8: getfield 44	com/google/android/gms/internal/ads/zzih:zzaic	Lcom/google/android/gms/internal/ads/zzid;
    //   11: invokeinterface 74 1 0
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 61	com/google/android/gms/internal/ads/zzih:zzaje	Z
    //   21: iconst_0
    //   22: istore_1
    //   23: iload_1
    //   24: ifne +215 -> 239
    //   27: aload_0
    //   28: getfield 64	com/google/android/gms/internal/ads/zzih:zzajd	Z
    //   31: ifne +208 -> 239
    //   34: aload_0
    //   35: getfield 55	com/google/android/gms/internal/ads/zzih:zzajc	Lcom/google/android/gms/internal/ads/zzij;
    //   38: getfield 59	com/google/android/gms/internal/ads/zzij:zzahv	J
    //   41: lstore 5
    //   43: aload_0
    //   44: getfield 40	com/google/android/gms/internal/ads/zzih:zzahu	Lcom/google/android/gms/internal/ads/zzjp;
    //   47: new 76	com/google/android/gms/internal/ads/zzjq
    //   50: dup
    //   51: aload_0
    //   52: getfield 36	com/google/android/gms/internal/ads/zzih:uri	Landroid/net/Uri;
    //   55: lload 5
    //   57: ldc2_w 77
    //   60: aconst_null
    //   61: invokespecial 81	com/google/android/gms/internal/ads/zzjq:<init>	(Landroid/net/Uri;JJLjava/lang/String;)V
    //   64: invokeinterface 85 2 0
    //   69: lstore 7
    //   71: lload 7
    //   73: ldc2_w 77
    //   76: lcmp
    //   77: ifeq +10 -> 87
    //   80: lload 7
    //   82: lload 5
    //   84: ladd
    //   85: lstore 7
    //   87: new 87	com/google/android/gms/internal/ads/zzib
    //   90: dup
    //   91: aload_0
    //   92: getfield 40	com/google/android/gms/internal/ads/zzih:zzahu	Lcom/google/android/gms/internal/ads/zzjp;
    //   95: lload 5
    //   97: lload 7
    //   99: invokespecial 90	com/google/android/gms/internal/ads/zzib:<init>	(Lcom/google/android/gms/internal/ads/zzjp;JJ)V
    //   102: astore 9
    //   104: iload_1
    //   105: istore 10
    //   107: iload 10
    //   109: ifne +45 -> 154
    //   112: aload_0
    //   113: getfield 64	com/google/android/gms/internal/ads/zzih:zzajd	Z
    //   116: ifne +38 -> 154
    //   119: aload_0
    //   120: getfield 48	com/google/android/gms/internal/ads/zzih:zzaid	Lcom/google/android/gms/internal/ads/zzjr;
    //   123: aload_0
    //   124: getfield 50	com/google/android/gms/internal/ads/zzih:zzaie	I
    //   127: invokevirtual 94	com/google/android/gms/internal/ads/zzjr:zzaa	(I)V
    //   130: aload_0
    //   131: getfield 44	com/google/android/gms/internal/ads/zzih:zzaic	Lcom/google/android/gms/internal/ads/zzid;
    //   134: aload 9
    //   136: aload_0
    //   137: getfield 55	com/google/android/gms/internal/ads/zzih:zzajc	Lcom/google/android/gms/internal/ads/zzij;
    //   140: invokeinterface 97 3 0
    //   145: istore 13
    //   147: iload 13
    //   149: istore 10
    //   151: goto -44 -> 107
    //   154: iload 10
    //   156: iconst_1
    //   157: if_icmpne +21 -> 178
    //   160: iconst_0
    //   161: istore 11
    //   163: aload_0
    //   164: getfield 40	com/google/android/gms/internal/ads/zzih:zzahu	Lcom/google/android/gms/internal/ads/zzjp;
    //   167: invokeinterface 100 1 0
    //   172: iload 11
    //   174: istore_1
    //   175: goto -152 -> 23
    //   178: aload_0
    //   179: getfield 55	com/google/android/gms/internal/ads/zzih:zzajc	Lcom/google/android/gms/internal/ads/zzij;
    //   182: aload 9
    //   184: invokeinterface 106 1 0
    //   189: putfield 59	com/google/android/gms/internal/ads/zzij:zzahv	J
    //   192: iload 10
    //   194: istore 11
    //   196: goto -33 -> 163
    //   199: astore_2
    //   200: aconst_null
    //   201: astore_3
    //   202: iload_1
    //   203: istore 4
    //   205: iload 4
    //   207: iconst_1
    //   208: if_icmpeq +20 -> 228
    //   211: aload_3
    //   212: ifnull +16 -> 228
    //   215: aload_0
    //   216: getfield 55	com/google/android/gms/internal/ads/zzih:zzajc	Lcom/google/android/gms/internal/ads/zzij;
    //   219: aload_3
    //   220: invokeinterface 106 1 0
    //   225: putfield 59	com/google/android/gms/internal/ads/zzij:zzahv	J
    //   228: aload_0
    //   229: getfield 40	com/google/android/gms/internal/ads/zzih:zzahu	Lcom/google/android/gms/internal/ads/zzjp;
    //   232: invokeinterface 100 1 0
    //   237: aload_2
    //   238: athrow
    //   239: return
    //   240: astore 12
    //   242: iload 10
    //   244: istore 4
    //   246: aload 9
    //   248: astore_3
    //   249: aload 12
    //   251: astore_2
    //   252: goto -47 -> 205
    //
    // Exception table:
    //   from	to	target	type
    //   34	71	199	finally
    //   87	104	199	finally
    //   112	147	240	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzih
 * JD-Core Version:    0.6.2
 */
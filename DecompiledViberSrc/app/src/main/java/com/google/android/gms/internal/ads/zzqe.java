package com.google.android.gms.internal.ads;

import android.net.Uri;

final class zzqe
  implements zzsh
{
  private final Uri uri;
  private volatile boolean zzajd;
  private boolean zzaje;
  private final zzrv zzazi;
  private final zzqf zzbig;
  private final zzsm zzbih;
  private final zznt zzbiv;
  private long zzbiw;
  private long zzcd;

  public zzqe(zzpz paramzzpz, Uri paramUri, zzrv paramzzrv, zzqf paramzzqf, zzsm paramzzsm)
  {
    this.uri = ((Uri)zzsk.checkNotNull(paramUri));
    this.zzazi = ((zzrv)zzsk.checkNotNull(paramzzrv));
    this.zzbig = ((zzqf)zzsk.checkNotNull(paramzzqf));
    this.zzbih = paramzzsm;
    this.zzbiv = new zznt();
    this.zzaje = true;
    this.zzcd = -1L;
  }

  public final void zzf(long paramLong1, long paramLong2)
  {
    this.zzbiv.zzahv = paramLong1;
    this.zzbiw = paramLong2;
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
    //   0: iconst_0
    //   1: istore_1
    //   2: iload_1
    //   3: ifne +330 -> 333
    //   6: aload_0
    //   7: getfield 74	com/google/android/gms/internal/ads/zzqe:zzajd	Z
    //   10: ifne +323 -> 333
    //   13: aload_0
    //   14: getfield 56	com/google/android/gms/internal/ads/zzqe:zzbiv	Lcom/google/android/gms/internal/ads/zznt;
    //   17: getfield 69	com/google/android/gms/internal/ads/zznt:zzahv	J
    //   20: lstore 5
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 45	com/google/android/gms/internal/ads/zzqe:zzazi	Lcom/google/android/gms/internal/ads/zzrv;
    //   27: new 83	com/google/android/gms/internal/ads/zzry
    //   30: dup
    //   31: aload_0
    //   32: getfield 41	com/google/android/gms/internal/ads/zzqe:uri	Landroid/net/Uri;
    //   35: lload 5
    //   37: ldc2_w 59
    //   40: aload_0
    //   41: getfield 28	com/google/android/gms/internal/ads/zzqe:zzbis	Lcom/google/android/gms/internal/ads/zzpz;
    //   44: invokestatic 88	com/google/android/gms/internal/ads/zzpz:zzf	(Lcom/google/android/gms/internal/ads/zzpz;)Ljava/lang/String;
    //   47: invokespecial 91	com/google/android/gms/internal/ads/zzry:<init>	(Landroid/net/Uri;JJLjava/lang/String;)V
    //   50: invokeinterface 95 2 0
    //   55: putfield 62	com/google/android/gms/internal/ads/zzqe:zzcd	J
    //   58: aload_0
    //   59: getfield 62	com/google/android/gms/internal/ads/zzqe:zzcd	J
    //   62: ldc2_w 59
    //   65: lcmp
    //   66: ifeq +14 -> 80
    //   69: aload_0
    //   70: lload 5
    //   72: aload_0
    //   73: getfield 62	com/google/android/gms/internal/ads/zzqe:zzcd	J
    //   76: ladd
    //   77: putfield 62	com/google/android/gms/internal/ads/zzqe:zzcd	J
    //   80: new 97	com/google/android/gms/internal/ads/zznm
    //   83: dup
    //   84: aload_0
    //   85: getfield 45	com/google/android/gms/internal/ads/zzqe:zzazi	Lcom/google/android/gms/internal/ads/zzrv;
    //   88: lload 5
    //   90: aload_0
    //   91: getfield 62	com/google/android/gms/internal/ads/zzqe:zzcd	J
    //   94: invokespecial 100	com/google/android/gms/internal/ads/zznm:<init>	(Lcom/google/android/gms/internal/ads/zzrv;JJ)V
    //   97: astore 7
    //   99: aload_0
    //   100: getfield 49	com/google/android/gms/internal/ads/zzqe:zzbig	Lcom/google/android/gms/internal/ads/zzqf;
    //   103: aload 7
    //   105: aload_0
    //   106: getfield 45	com/google/android/gms/internal/ads/zzqe:zzazi	Lcom/google/android/gms/internal/ads/zzrv;
    //   109: invokeinterface 104 1 0
    //   114: invokevirtual 107	com/google/android/gms/internal/ads/zzqf:zza	(Lcom/google/android/gms/internal/ads/zzno;Landroid/net/Uri;)Lcom/google/android/gms/internal/ads/zznn;
    //   117: astore 9
    //   119: aload_0
    //   120: getfield 58	com/google/android/gms/internal/ads/zzqe:zzaje	Z
    //   123: ifeq +21 -> 144
    //   126: aload 9
    //   128: lload 5
    //   130: aload_0
    //   131: getfield 71	com/google/android/gms/internal/ads/zzqe:zzbiw	J
    //   134: invokeinterface 112 5 0
    //   139: aload_0
    //   140: iconst_0
    //   141: putfield 58	com/google/android/gms/internal/ads/zzqe:zzaje	Z
    //   144: lload 5
    //   146: lstore 10
    //   148: iload_1
    //   149: istore 12
    //   151: iload 12
    //   153: ifne +99 -> 252
    //   156: aload_0
    //   157: getfield 74	com/google/android/gms/internal/ads/zzqe:zzajd	Z
    //   160: ifne +92 -> 252
    //   163: aload_0
    //   164: getfield 51	com/google/android/gms/internal/ads/zzqe:zzbih	Lcom/google/android/gms/internal/ads/zzsm;
    //   167: invokevirtual 117	com/google/android/gms/internal/ads/zzsm:block	()V
    //   170: aload 9
    //   172: aload 7
    //   174: aload_0
    //   175: getfield 56	com/google/android/gms/internal/ads/zzqe:zzbiv	Lcom/google/android/gms/internal/ads/zznt;
    //   178: invokeinterface 120 3 0
    //   183: istore 15
    //   185: iload 15
    //   187: istore 4
    //   189: aload 7
    //   191: invokeinterface 126 1 0
    //   196: lload 10
    //   198: aload_0
    //   199: getfield 28	com/google/android/gms/internal/ads/zzqe:zzbis	Lcom/google/android/gms/internal/ads/zzpz;
    //   202: invokestatic 130	com/google/android/gms/internal/ads/zzpz:zzg	(Lcom/google/android/gms/internal/ads/zzpz;)J
    //   205: ladd
    //   206: lcmp
    //   207: ifle +167 -> 374
    //   210: aload 7
    //   212: invokeinterface 126 1 0
    //   217: lstore 10
    //   219: aload_0
    //   220: getfield 51	com/google/android/gms/internal/ads/zzqe:zzbih	Lcom/google/android/gms/internal/ads/zzsm;
    //   223: invokevirtual 133	com/google/android/gms/internal/ads/zzsm:zzjy	()Z
    //   226: pop
    //   227: aload_0
    //   228: getfield 28	com/google/android/gms/internal/ads/zzqe:zzbis	Lcom/google/android/gms/internal/ads/zzpz;
    //   231: invokestatic 137	com/google/android/gms/internal/ads/zzpz:zzi	(Lcom/google/android/gms/internal/ads/zzpz;)Landroid/os/Handler;
    //   234: aload_0
    //   235: getfield 28	com/google/android/gms/internal/ads/zzqe:zzbis	Lcom/google/android/gms/internal/ads/zzpz;
    //   238: invokestatic 141	com/google/android/gms/internal/ads/zzpz:zzh	(Lcom/google/android/gms/internal/ads/zzpz;)Ljava/lang/Runnable;
    //   241: invokevirtual 147	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   244: pop
    //   245: iload 4
    //   247: istore 12
    //   249: goto -98 -> 151
    //   252: iload 12
    //   254: iconst_1
    //   255: if_icmpne +19 -> 274
    //   258: iconst_0
    //   259: istore 13
    //   261: aload_0
    //   262: getfield 45	com/google/android/gms/internal/ads/zzqe:zzazi	Lcom/google/android/gms/internal/ads/zzrv;
    //   265: invokestatic 152	com/google/android/gms/internal/ads/zzsy:zza	(Lcom/google/android/gms/internal/ads/zzrv;)V
    //   268: iload 13
    //   270: istore_1
    //   271: goto -269 -> 2
    //   274: aload_0
    //   275: getfield 56	com/google/android/gms/internal/ads/zzqe:zzbiv	Lcom/google/android/gms/internal/ads/zznt;
    //   278: aload 7
    //   280: invokeinterface 126 1 0
    //   285: putfield 69	com/google/android/gms/internal/ads/zznt:zzahv	J
    //   288: iload 12
    //   290: istore 13
    //   292: goto -31 -> 261
    //   295: astore_2
    //   296: aconst_null
    //   297: astore_3
    //   298: iload_1
    //   299: istore 4
    //   301: iload 4
    //   303: iconst_1
    //   304: if_icmpeq +20 -> 324
    //   307: aload_3
    //   308: ifnull +16 -> 324
    //   311: aload_0
    //   312: getfield 56	com/google/android/gms/internal/ads/zzqe:zzbiv	Lcom/google/android/gms/internal/ads/zznt;
    //   315: aload_3
    //   316: invokeinterface 126 1 0
    //   321: putfield 69	com/google/android/gms/internal/ads/zznt:zzahv	J
    //   324: aload_0
    //   325: getfield 45	com/google/android/gms/internal/ads/zzqe:zzazi	Lcom/google/android/gms/internal/ads/zzrv;
    //   328: invokestatic 152	com/google/android/gms/internal/ads/zzsy:zza	(Lcom/google/android/gms/internal/ads/zzrv;)V
    //   331: aload_2
    //   332: athrow
    //   333: return
    //   334: astore 8
    //   336: iload_1
    //   337: istore 4
    //   339: aload 8
    //   341: astore_2
    //   342: aload 7
    //   344: astore_3
    //   345: goto -44 -> 301
    //   348: astore 14
    //   350: iload 12
    //   352: istore 4
    //   354: aload 7
    //   356: astore_3
    //   357: aload 14
    //   359: astore_2
    //   360: goto -59 -> 301
    //   363: astore 16
    //   365: aload 7
    //   367: astore_3
    //   368: aload 16
    //   370: astore_2
    //   371: goto -70 -> 301
    //   374: iload 4
    //   376: istore 12
    //   378: goto -227 -> 151
    //
    // Exception table:
    //   from	to	target	type
    //   13	80	295	finally
    //   80	99	295	finally
    //   99	144	334	finally
    //   156	185	348	finally
    //   189	245	363	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzqe
 * JD-Core Version:    0.6.2
 */
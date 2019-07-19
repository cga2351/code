package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;

@zzare
@TargetApi(16)
public abstract class zzbgm extends zzbfu
{
  private final zzbdl zzefs = new zzbdl();
  private boolean zzeij;
  private String zzeiq = null;
  private boolean zzeir;

  public zzbgm(zzbdg paramzzbdg)
  {
    super(paramzzbdg);
    this.zzefs.zza(new zzbgn(this));
  }

  public final void abort()
  {
    try
    {
      this.zzeij = true;
      return;
    }
    finally
    {
    }
  }

  public void release()
  {
    this.zzefs.zzyr();
    super.release();
  }

  // ERROR //
  public final boolean zzex(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 57	com/google/android/gms/internal/ads/zzbgm:zzfa	(Ljava/lang/String;)Lcom/google/android/gms/internal/ads/zzhn;
    //   5: astore_2
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual 61	com/google/android/gms/internal/ads/zzbfu:zzey	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_3
    //   12: ldc 63
    //   14: astore 4
    //   16: aconst_null
    //   17: astore 5
    //   19: aload_0
    //   20: getfield 28	com/google/android/gms/internal/ads/zzbgm:zzefs	Lcom/google/android/gms/internal/ads/zzbdl;
    //   23: aload_2
    //   24: invokevirtual 66	com/google/android/gms/internal/ads/zzbdl:zza	(Lcom/google/android/gms/internal/ads/zzhn;)Z
    //   27: ifne +97 -> 124
    //   30: ldc 68
    //   32: astore 4
    //   34: ldc 70
    //   36: astore 5
    //   38: aload_0
    //   39: invokevirtual 47	com/google/android/gms/internal/ads/zzbfu:release	()V
    //   42: new 51	java/io/IOException
    //   45: dup
    //   46: ldc 72
    //   48: invokespecial 75	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   51: athrow
    //   52: astore 6
    //   54: aload 6
    //   56: invokevirtual 79	java/io/IOException:getMessage	()Ljava/lang/String;
    //   59: astore 7
    //   61: new 81	java/lang/StringBuilder
    //   64: dup
    //   65: bipush 34
    //   67: aload_1
    //   68: invokestatic 87	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   71: invokevirtual 91	java/lang/String:length	()I
    //   74: iadd
    //   75: aload 7
    //   77: invokestatic 87	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   80: invokevirtual 91	java/lang/String:length	()I
    //   83: iadd
    //   84: invokespecial 94	java/lang/StringBuilder:<init>	(I)V
    //   87: ldc 96
    //   89: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_1
    //   93: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc 102
    //   98: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload 7
    //   103: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 110	com/google/android/gms/internal/ads/zzaxa:zzep	(Ljava/lang/String;)V
    //   112: aload_0
    //   113: aload_1
    //   114: aload_3
    //   115: aload 4
    //   117: aload 5
    //   119: invokevirtual 113	com/google/android/gms/internal/ads/zzbfu:zza	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   122: iconst_0
    //   123: ireturn
    //   124: aload_0
    //   125: getfield 28	com/google/android/gms/internal/ads/zzbgm:zzefs	Lcom/google/android/gms/internal/ads/zzbdl;
    //   128: invokevirtual 117	com/google/android/gms/internal/ads/zzbdl:zzys	()Lcom/google/android/gms/internal/ads/zzge;
    //   131: astore 8
    //   133: aload 8
    //   135: ifnonnull +25 -> 160
    //   138: ldc 68
    //   140: astore 4
    //   142: ldc 119
    //   144: astore 5
    //   146: aload_0
    //   147: invokevirtual 47	com/google/android/gms/internal/ads/zzbfu:release	()V
    //   150: new 51	java/io/IOException
    //   153: dup
    //   154: ldc 121
    //   156: invokespecial 75	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   159: athrow
    //   160: aload_0
    //   161: getfield 125	com/google/android/gms/internal/ads/zzbgm:zzehv	Ljava/lang/ref/WeakReference;
    //   164: invokevirtual 131	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   167: checkcast 133	com/google/android/gms/internal/ads/zzbdg
    //   170: astore 9
    //   172: aload 9
    //   174: ifnull +12 -> 186
    //   177: aload 9
    //   179: aload_3
    //   180: aload_0
    //   181: invokeinterface 136 3 0
    //   186: invokestatic 142	com/google/android/gms/ads/internal/zzk:zzln	()Lcom/google/android/gms/common/util/Clock;
    //   189: astore 10
    //   191: aload 10
    //   193: invokeinterface 148 1 0
    //   198: lstore 11
    //   200: getstatic 154	com/google/android/gms/internal/ads/zzact:zzclz	Lcom/google/android/gms/internal/ads/zzaci;
    //   203: astore 13
    //   205: invokestatic 160	com/google/android/gms/internal/ads/zzyr:zzpe	()Lcom/google/android/gms/internal/ads/zzacq;
    //   208: aload 13
    //   210: invokevirtual 166	com/google/android/gms/internal/ads/zzacq:zzd	(Lcom/google/android/gms/internal/ads/zzaci;)Ljava/lang/Object;
    //   213: checkcast 168	java/lang/Long
    //   216: invokevirtual 171	java/lang/Long:longValue	()J
    //   219: lstore 14
    //   221: getstatic 174	com/google/android/gms/internal/ads/zzact:zzcly	Lcom/google/android/gms/internal/ads/zzaci;
    //   224: astore 16
    //   226: ldc2_w 175
    //   229: invokestatic 160	com/google/android/gms/internal/ads/zzyr:zzpe	()Lcom/google/android/gms/internal/ads/zzacq;
    //   232: aload 16
    //   234: invokevirtual 166	com/google/android/gms/internal/ads/zzacq:zzd	(Lcom/google/android/gms/internal/ads/zzaci;)Ljava/lang/Object;
    //   237: checkcast 168	java/lang/Long
    //   240: invokevirtual 171	java/lang/Long:longValue	()J
    //   243: lmul
    //   244: lstore 17
    //   246: getstatic 179	com/google/android/gms/internal/ads/zzact:zzclx	Lcom/google/android/gms/internal/ads/zzaci;
    //   249: astore 19
    //   251: invokestatic 160	com/google/android/gms/internal/ads/zzyr:zzpe	()Lcom/google/android/gms/internal/ads/zzacq;
    //   254: aload 19
    //   256: invokevirtual 166	com/google/android/gms/internal/ads/zzacq:zzd	(Lcom/google/android/gms/internal/ads/zzaci;)Ljava/lang/Object;
    //   259: checkcast 181	java/lang/Integer
    //   262: invokevirtual 184	java/lang/Integer:intValue	()I
    //   265: i2l
    //   266: lstore 20
    //   268: ldc2_w 185
    //   271: lstore 22
    //   273: aload_0
    //   274: monitorenter
    //   275: aload 10
    //   277: invokeinterface 148 1 0
    //   282: lload 11
    //   284: lsub
    //   285: lload 17
    //   287: lcmp
    //   288: ifle +84 -> 372
    //   291: ldc 188
    //   293: astore 25
    //   295: lload 17
    //   297: invokestatic 191	java/lang/Long:toString	(J)Ljava/lang/String;
    //   300: astore 27
    //   302: new 81	java/lang/StringBuilder
    //   305: dup
    //   306: bipush 27
    //   308: aload 27
    //   310: invokestatic 87	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   313: invokevirtual 91	java/lang/String:length	()I
    //   316: iadd
    //   317: invokespecial 94	java/lang/StringBuilder:<init>	(I)V
    //   320: ldc 193
    //   322: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload 27
    //   327: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: ldc 195
    //   332: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: astore 28
    //   340: aload 28
    //   342: astore 26
    //   344: new 51	java/io/IOException
    //   347: dup
    //   348: ldc 197
    //   350: invokespecial 75	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   353: athrow
    //   354: aload_0
    //   355: monitorexit
    //   356: aload 24
    //   358: athrow
    //   359: astore 6
    //   361: aload 26
    //   363: astore 5
    //   365: aload 25
    //   367: astore 4
    //   369: goto -315 -> 54
    //   372: aload_0
    //   373: getfield 41	com/google/android/gms/internal/ads/zzbgm:zzeij	Z
    //   376: ifeq +47 -> 423
    //   379: aload_0
    //   380: getfield 21	com/google/android/gms/internal/ads/zzbgm:zzeiq	Ljava/lang/String;
    //   383: invokestatic 203	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   386: ifne +27 -> 413
    //   389: aload_0
    //   390: getfield 21	com/google/android/gms/internal/ads/zzbgm:zzeiq	Ljava/lang/String;
    //   393: astore 36
    //   395: ldc 205
    //   397: astore 25
    //   399: aload 36
    //   401: astore 26
    //   403: new 51	java/io/IOException
    //   406: dup
    //   407: ldc 207
    //   409: invokespecial 75	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   412: athrow
    //   413: ldc 209
    //   415: astore 25
    //   417: aconst_null
    //   418: astore 26
    //   420: goto -17 -> 403
    //   423: aload_0
    //   424: getfield 211	com/google/android/gms/internal/ads/zzbgm:zzeir	Z
    //   427: ifeq +8 -> 435
    //   430: aload_0
    //   431: monitorexit
    //   432: goto +162 -> 594
    //   435: aload 8
    //   437: invokeinterface 216 1 0
    //   442: lstore 29
    //   444: lload 29
    //   446: lconst_0
    //   447: lcmp
    //   448: ifle +91 -> 539
    //   451: aload 8
    //   453: invokeinterface 219 1 0
    //   458: lstore 31
    //   460: lload 31
    //   462: lload 22
    //   464: lcmp
    //   465: ifeq +29 -> 494
    //   468: lload 31
    //   470: lconst_0
    //   471: lcmp
    //   472: ifle +136 -> 608
    //   475: iconst_1
    //   476: istore 35
    //   478: aload_0
    //   479: aload_1
    //   480: aload_3
    //   481: lload 31
    //   483: lload 29
    //   485: iload 35
    //   487: invokevirtual 222	com/google/android/gms/internal/ads/zzbfu:zza	(Ljava/lang/String;Ljava/lang/String;JJZ)V
    //   490: lload 31
    //   492: lstore 22
    //   494: lload 31
    //   496: lload 29
    //   498: lcmp
    //   499: iflt +16 -> 515
    //   502: aload_0
    //   503: aload_1
    //   504: aload_3
    //   505: lload 29
    //   507: invokevirtual 226	com/google/android/gms/internal/ads/zzbfu:zzb	(Ljava/lang/String;Ljava/lang/String;J)V
    //   510: aload_0
    //   511: monitorexit
    //   512: goto +82 -> 594
    //   515: aload_0
    //   516: invokevirtual 229	com/google/android/gms/internal/ads/zzbgm:zzzw	()I
    //   519: pop
    //   520: lconst_0
    //   521: lload 20
    //   523: lcmp
    //   524: iflt +15 -> 539
    //   527: lload 31
    //   529: lconst_0
    //   530: lcmp
    //   531: ifle +8 -> 539
    //   534: aload_0
    //   535: monitorexit
    //   536: goto +58 -> 594
    //   539: aload_0
    //   540: monitorexit
    //   541: lload 14
    //   543: invokestatic 235	java/lang/Thread:sleep	(J)V
    //   546: goto -273 -> 273
    //   549: astore 34
    //   551: ldc 63
    //   553: astore 4
    //   555: ldc 237
    //   557: astore 5
    //   559: new 51	java/io/IOException
    //   562: dup
    //   563: ldc 239
    //   565: invokespecial 75	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   568: athrow
    //   569: astore 24
    //   571: aconst_null
    //   572: astore 26
    //   574: goto -220 -> 354
    //   577: astore 24
    //   579: ldc 205
    //   581: astore 25
    //   583: aconst_null
    //   584: astore 26
    //   586: goto -232 -> 354
    //   589: astore 24
    //   591: goto -237 -> 354
    //   594: iconst_1
    //   595: ireturn
    //   596: astore 24
    //   598: aload 4
    //   600: astore 25
    //   602: aconst_null
    //   603: astore 26
    //   605: goto -251 -> 354
    //   608: iconst_0
    //   609: istore 35
    //   611: goto -133 -> 478
    //
    // Exception table:
    //   from	to	target	type
    //   19	30	52	java/io/IOException
    //   38	52	52	java/io/IOException
    //   124	133	52	java/io/IOException
    //   146	160	52	java/io/IOException
    //   160	172	52	java/io/IOException
    //   177	186	52	java/io/IOException
    //   186	268	52	java/io/IOException
    //   273	275	52	java/io/IOException
    //   541	546	52	java/io/IOException
    //   559	569	52	java/io/IOException
    //   356	359	359	java/io/IOException
    //   541	546	549	java/lang/InterruptedException
    //   295	340	569	finally
    //   389	395	577	finally
    //   344	354	589	finally
    //   354	356	589	finally
    //   403	413	589	finally
    //   275	291	596	finally
    //   372	389	596	finally
    //   423	432	596	finally
    //   435	444	596	finally
    //   451	460	596	finally
    //   478	490	596	finally
    //   502	512	596	finally
    //   515	520	596	finally
    //   534	536	596	finally
    //   539	541	596	finally
  }

  protected final String zzey(String paramString)
  {
    String str1 = String.valueOf("cache:");
    String str2 = String.valueOf(super.zzey(paramString));
    if (str2.length() != 0)
      return str1.concat(str2);
    return new String(str1);
  }

  protected abstract zzhn zzfa(String paramString);

  protected abstract int zzzw();

  public final void zzzx()
  {
    try
    {
      this.zzeir = true;
      this.zzefs.removeListener();
      return;
    }
    finally
    {
    }
  }

  public final zzbdl zzzy()
  {
    return this.zzefs;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbgm
 * JD-Core Version:    0.6.2
 */
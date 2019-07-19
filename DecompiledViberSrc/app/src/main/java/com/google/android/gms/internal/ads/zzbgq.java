package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

@zzare
@TargetApi(16)
public final class zzbgq extends zzbfu
  implements zzbfj
{
  private String zzech;
  private boolean zzeij;
  private zzbfb zzeiw;
  private Exception zzeix;
  private boolean zzeiy;

  public zzbgq(zzbdg paramzzbdg, zzbdf paramzzbdf)
  {
    super(paramzzbdg);
    this.zzeiw = new zzbfb(paramzzbdg.getContext(), paramzzbdf);
    this.zzeiw.zza(this);
  }

  private static String zzb(String paramString, Exception paramException)
  {
    String str1 = paramException.getClass().getCanonicalName();
    String str2 = paramException.getMessage();
    return 2 + String.valueOf(paramString).length() + String.valueOf(str1).length() + String.valueOf(str2).length() + paramString + "/" + str1 + ":" + str2;
  }

  private final void zzfb(String paramString)
  {
    String str;
    try
    {
      this.zzeij = true;
      notify();
      release();
      if (this.zzech != null)
      {
        str = zzey(this.zzech);
        if (this.zzeix != null)
          zza(this.zzech, str, "badUrl", zzb(paramString, this.zzeix));
      }
      else
      {
        return;
      }
    }
    finally
    {
    }
    zza(this.zzech, str, "externalAbort", "Programmatic precache abort.");
  }

  public final void abort()
  {
    zzfb(null);
  }

  public final void release()
  {
    if (this.zzeiw != null)
    {
      this.zzeiw.zza(null);
      this.zzeiw.release();
    }
    super.release();
  }

  public final void zza(String paramString, Exception paramException)
  {
    this.zzeix = paramException;
    zzaxa.zzd("Precache error", paramException);
    zzfb(paramString);
  }

  public final zzbfb zzaaa()
  {
    try
    {
      this.zzeiy = true;
      notify();
      this.zzeiw.zza(null);
      zzbfb localzzbfb = this.zzeiw;
      this.zzeiw = null;
      return localzzbfb;
    }
    finally
    {
    }
  }

  public final void zzcy(int paramInt)
  {
    this.zzeiw.zzzu().zzdg(paramInt);
  }

  public final void zzcz(int paramInt)
  {
    this.zzeiw.zzzu().zzdh(paramInt);
  }

  public final void zzd(boolean paramBoolean, long paramLong)
  {
    zzbdg localzzbdg = (zzbdg)this.zzehv.get();
    if (localzzbdg != null)
      zzbbn.zzeag.execute(new zzbgr(localzzbdg, paramBoolean, paramLong));
  }

  public final void zzda(int paramInt)
  {
    this.zzeiw.zzzu().zzda(paramInt);
  }

  public final void zzdb(int paramInt)
  {
    this.zzeiw.zzzu().zzdb(paramInt);
  }

  public final void zzde(int paramInt)
  {
  }

  // ERROR //
  public final boolean zze(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 99	com/google/android/gms/internal/ads/zzbgq:zzech	Ljava/lang/String;
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual 103	com/google/android/gms/internal/ads/zzbfu:zzey	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_3
    //   11: ldc 188
    //   13: astore 4
    //   15: aload_2
    //   16: arraylength
    //   17: anewarray 190	android/net/Uri
    //   20: astore 7
    //   22: iconst_0
    //   23: istore 8
    //   25: iload 8
    //   27: aload_2
    //   28: arraylength
    //   29: if_icmpge +21 -> 50
    //   32: aload 7
    //   34: iload 8
    //   36: aload_2
    //   37: iload 8
    //   39: aaload
    //   40: invokestatic 194	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   43: aastore
    //   44: iinc 8 1
    //   47: goto -22 -> 25
    //   50: aload_0
    //   51: getfield 37	com/google/android/gms/internal/ads/zzbgq:zzeiw	Lcom/google/android/gms/internal/ads/zzbfb;
    //   54: aload 7
    //   56: aload_0
    //   57: getfield 197	com/google/android/gms/internal/ads/zzbgq:zzdyd	Ljava/lang/String;
    //   60: invokevirtual 200	com/google/android/gms/internal/ads/zzbfb:zza	([Landroid/net/Uri;Ljava/lang/String;)V
    //   63: aload_0
    //   64: getfield 152	com/google/android/gms/internal/ads/zzbgq:zzehv	Ljava/lang/ref/WeakReference;
    //   67: invokevirtual 158	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   70: checkcast 28	com/google/android/gms/internal/ads/zzbdg
    //   73: astore 9
    //   75: aload 9
    //   77: ifnull +12 -> 89
    //   80: aload 9
    //   82: aload_3
    //   83: aload_0
    //   84: invokeinterface 203 3 0
    //   89: invokestatic 209	com/google/android/gms/ads/internal/zzk:zzln	()Lcom/google/android/gms/common/util/Clock;
    //   92: astore 10
    //   94: aload 10
    //   96: invokeinterface 215 1 0
    //   101: lstore 11
    //   103: getstatic 221	com/google/android/gms/internal/ads/zzact:zzclz	Lcom/google/android/gms/internal/ads/zzaci;
    //   106: astore 13
    //   108: invokestatic 227	com/google/android/gms/internal/ads/zzyr:zzpe	()Lcom/google/android/gms/internal/ads/zzacq;
    //   111: aload 13
    //   113: invokevirtual 232	com/google/android/gms/internal/ads/zzacq:zzd	(Lcom/google/android/gms/internal/ads/zzaci;)Ljava/lang/Object;
    //   116: checkcast 234	java/lang/Long
    //   119: invokevirtual 237	java/lang/Long:longValue	()J
    //   122: lstore 14
    //   124: getstatic 240	com/google/android/gms/internal/ads/zzact:zzcly	Lcom/google/android/gms/internal/ads/zzaci;
    //   127: astore 16
    //   129: ldc2_w 241
    //   132: invokestatic 227	com/google/android/gms/internal/ads/zzyr:zzpe	()Lcom/google/android/gms/internal/ads/zzacq;
    //   135: aload 16
    //   137: invokevirtual 232	com/google/android/gms/internal/ads/zzacq:zzd	(Lcom/google/android/gms/internal/ads/zzaci;)Ljava/lang/Object;
    //   140: checkcast 234	java/lang/Long
    //   143: invokevirtual 237	java/lang/Long:longValue	()J
    //   146: lmul
    //   147: lstore 17
    //   149: getstatic 245	com/google/android/gms/internal/ads/zzact:zzclx	Lcom/google/android/gms/internal/ads/zzaci;
    //   152: astore 19
    //   154: invokestatic 227	com/google/android/gms/internal/ads/zzyr:zzpe	()Lcom/google/android/gms/internal/ads/zzacq;
    //   157: aload 19
    //   159: invokevirtual 232	com/google/android/gms/internal/ads/zzacq:zzd	(Lcom/google/android/gms/internal/ads/zzaci;)Ljava/lang/Object;
    //   162: checkcast 247	java/lang/Integer
    //   165: invokevirtual 250	java/lang/Integer:intValue	()I
    //   168: i2l
    //   169: lstore 20
    //   171: ldc2_w 251
    //   174: lstore 22
    //   176: aload_0
    //   177: monitorenter
    //   178: aload 10
    //   180: invokeinterface 215 1 0
    //   185: lload 11
    //   187: lsub
    //   188: lload 17
    //   190: lcmp
    //   191: ifle +136 -> 327
    //   194: ldc 254
    //   196: astore 25
    //   198: new 256	java/io/IOException
    //   201: dup
    //   202: new 62	java/lang/StringBuilder
    //   205: dup
    //   206: bipush 47
    //   208: invokespecial 75	java/lang/StringBuilder:<init>	(I)V
    //   211: ldc_w 258
    //   214: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: lload 17
    //   219: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   222: ldc_w 263
    //   225: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokespecial 265	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   234: athrow
    //   235: aload_0
    //   236: monitorexit
    //   237: aload 24
    //   239: athrow
    //   240: astore 5
    //   242: aload 25
    //   244: astore 4
    //   246: aload 5
    //   248: invokevirtual 60	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   251: astore 6
    //   253: new 62	java/lang/StringBuilder
    //   256: dup
    //   257: bipush 34
    //   259: aload_1
    //   260: invokestatic 68	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   263: invokevirtual 72	java/lang/String:length	()I
    //   266: iadd
    //   267: aload 6
    //   269: invokestatic 68	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   272: invokevirtual 72	java/lang/String:length	()I
    //   275: iadd
    //   276: invokespecial 75	java/lang/StringBuilder:<init>	(I)V
    //   279: ldc_w 267
    //   282: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload_1
    //   286: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc_w 269
    //   292: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 6
    //   297: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 272	com/google/android/gms/internal/ads/zzaxa:zzep	(Ljava/lang/String;)V
    //   306: aload_0
    //   307: invokevirtual 97	com/google/android/gms/internal/ads/zzbfu:release	()V
    //   310: aload_0
    //   311: aload_1
    //   312: aload_3
    //   313: aload 4
    //   315: aload 4
    //   317: aload 5
    //   319: invokestatic 109	com/google/android/gms/internal/ads/zzbgq:zzb	(Ljava/lang/String;Ljava/lang/Exception;)Ljava/lang/String;
    //   322: invokevirtual 112	com/google/android/gms/internal/ads/zzbfu:zza	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   325: iconst_0
    //   326: ireturn
    //   327: aload_0
    //   328: getfield 90	com/google/android/gms/internal/ads/zzbgq:zzeij	Z
    //   331: ifeq +34 -> 365
    //   334: aload_0
    //   335: getfield 105	com/google/android/gms/internal/ads/zzbgq:zzeix	Ljava/lang/Exception;
    //   338: ifnull +12 -> 350
    //   341: ldc 107
    //   343: astore 25
    //   345: aload_0
    //   346: getfield 105	com/google/android/gms/internal/ads/zzbgq:zzeix	Ljava/lang/Exception;
    //   349: athrow
    //   350: ldc 114
    //   352: astore 25
    //   354: new 256	java/io/IOException
    //   357: dup
    //   358: ldc_w 274
    //   361: invokespecial 265	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   364: athrow
    //   365: aload_0
    //   366: getfield 133	com/google/android/gms/internal/ads/zzbgq:zzeiy	Z
    //   369: ifeq +8 -> 377
    //   372: aload_0
    //   373: monitorexit
    //   374: goto +183 -> 557
    //   377: aload_0
    //   378: getfield 37	com/google/android/gms/internal/ads/zzbgq:zzeiw	Lcom/google/android/gms/internal/ads/zzbfb;
    //   381: invokevirtual 278	com/google/android/gms/internal/ads/zzbfb:zzzt	()Lcom/google/android/gms/internal/ads/zzkv;
    //   384: astore 26
    //   386: aload 26
    //   388: ifnonnull +19 -> 407
    //   391: ldc_w 280
    //   394: astore 25
    //   396: new 256	java/io/IOException
    //   399: dup
    //   400: ldc_w 282
    //   403: invokespecial 265	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   406: athrow
    //   407: aload 26
    //   409: invokeinterface 287 1 0
    //   414: lstore 27
    //   416: lload 27
    //   418: lconst_0
    //   419: lcmp
    //   420: ifle +98 -> 518
    //   423: aload 26
    //   425: invokeinterface 290 1 0
    //   430: lstore 29
    //   432: lload 29
    //   434: lload 22
    //   436: lcmp
    //   437: ifeq +35 -> 472
    //   440: lload 29
    //   442: lconst_0
    //   443: lcmp
    //   444: ifle +124 -> 568
    //   447: iconst_1
    //   448: istore 32
    //   450: aload_0
    //   451: aload_1
    //   452: aload_3
    //   453: lload 29
    //   455: lload 27
    //   457: iload 32
    //   459: invokestatic 293	com/google/android/gms/internal/ads/zzbfb:zzyp	()I
    //   462: invokestatic 296	com/google/android/gms/internal/ads/zzbfb:zzyq	()I
    //   465: invokevirtual 299	com/google/android/gms/internal/ads/zzbfu:zza	(Ljava/lang/String;Ljava/lang/String;JJZII)V
    //   468: lload 29
    //   470: lstore 22
    //   472: lload 29
    //   474: lload 27
    //   476: lcmp
    //   477: iflt +16 -> 493
    //   480: aload_0
    //   481: aload_1
    //   482: aload_3
    //   483: lload 27
    //   485: invokevirtual 302	com/google/android/gms/internal/ads/zzbfu:zzb	(Ljava/lang/String;Ljava/lang/String;J)V
    //   488: aload_0
    //   489: monitorexit
    //   490: goto +67 -> 557
    //   493: aload_0
    //   494: getfield 37	com/google/android/gms/internal/ads/zzbgq:zzeiw	Lcom/google/android/gms/internal/ads/zzbfb;
    //   497: invokevirtual 305	com/google/android/gms/internal/ads/zzbfb:getBytesTransferred	()J
    //   500: lload 20
    //   502: lcmp
    //   503: iflt +15 -> 518
    //   506: lload 29
    //   508: lconst_0
    //   509: lcmp
    //   510: ifle +8 -> 518
    //   513: aload_0
    //   514: monitorexit
    //   515: goto +42 -> 557
    //   518: aload_0
    //   519: lload 14
    //   521: invokevirtual 309	java/lang/Object:wait	(J)V
    //   524: aload_0
    //   525: monitorexit
    //   526: goto -350 -> 176
    //   529: astore 31
    //   531: ldc_w 311
    //   534: astore 25
    //   536: new 256	java/io/IOException
    //   539: dup
    //   540: ldc_w 313
    //   543: invokespecial 265	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   546: athrow
    //   547: astore 5
    //   549: goto -303 -> 246
    //   552: astore 24
    //   554: goto -319 -> 235
    //   557: iconst_1
    //   558: ireturn
    //   559: astore 24
    //   561: aload 4
    //   563: astore 25
    //   565: goto -330 -> 235
    //   568: iconst_0
    //   569: istore 32
    //   571: goto -121 -> 450
    //
    // Exception table:
    //   from	to	target	type
    //   237	240	240	java/lang/Exception
    //   518	524	529	java/lang/InterruptedException
    //   15	22	547	java/lang/Exception
    //   25	44	547	java/lang/Exception
    //   50	75	547	java/lang/Exception
    //   80	89	547	java/lang/Exception
    //   89	171	547	java/lang/Exception
    //   176	178	547	java/lang/Exception
    //   198	235	552	finally
    //   235	237	552	finally
    //   345	350	552	finally
    //   354	365	552	finally
    //   396	407	552	finally
    //   536	547	552	finally
    //   178	194	559	finally
    //   327	341	559	finally
    //   365	374	559	finally
    //   377	386	559	finally
    //   407	416	559	finally
    //   423	432	559	finally
    //   450	468	559	finally
    //   480	490	559	finally
    //   493	506	559	finally
    //   513	515	559	finally
    //   518	524	559	finally
    //   524	526	559	finally
  }

  public final boolean zzex(String paramString)
  {
    return zze(paramString, new String[] { paramString });
  }

  protected final String zzey(String paramString)
  {
    String str1 = String.valueOf("cache:");
    String str2 = String.valueOf(super.zzey(paramString));
    if (str2.length() != 0)
      return str1.concat(str2);
    return new String(str1);
  }

  public final void zzo(int paramInt1, int paramInt2)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbgq
 * JD-Core Version:    0.6.2
 */
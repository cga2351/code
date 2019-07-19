package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

@zzare
public final class zzbgp extends zzbfu
  implements zzsj<zzrv>
{
  private String url;
  private ByteBuffer zzaxl;
  private final zzbdf zzefr;
  private boolean zzeij;
  private final zzbfm zzeik;
  private boolean zzeil;
  private final Object zzeim;
  private boolean zzein;
  private final zzbgo zzeiv;

  public zzbgp(zzbdg paramzzbdg, zzbdf paramzzbdf)
  {
    super(paramzzbdg);
    this.zzefr = paramzzbdf;
    this.zzeiv = new zzbgo();
    this.zzeik = new zzbfm();
    this.zzeim = new Object();
  }

  private final void zzxt()
  {
    int i = (int)this.zzeiv.zzzz();
    int j = (int)this.zzeik.zzl(this.zzaxl);
    int k = this.zzaxl.position();
    int m = Math.round(j * (k / i));
    if (m > 0);
    for (boolean bool = true; ; bool = false)
    {
      int n = zzbfb.zzyp();
      int i1 = zzbfb.zzyq();
      zza(this.url, zzey(this.url), k, i, m, j, bool, n, i1);
      return;
    }
  }

  public final void abort()
  {
    this.zzeij = true;
  }

  public final ByteBuffer getByteBuffer()
  {
    synchronized (this.zzeim)
    {
      if ((this.zzaxl != null) && (!this.zzeil))
      {
        this.zzaxl.flip();
        this.zzeil = true;
      }
      this.zzeij = true;
      return this.zzaxl;
    }
  }

  public final String getUrl()
  {
    return this.url;
  }

  // ERROR //
  public final boolean zzex(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 81	com/google/android/gms/internal/ads/zzbgp:url	Ljava/lang/String;
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual 85	com/google/android/gms/internal/ads/zzbfu:zzey	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_2
    //   11: new 107	com/google/android/gms/internal/ads/zzsa
    //   14: dup
    //   15: aload_0
    //   16: getfield 121	com/google/android/gms/internal/ads/zzbgp:zzdyd	Ljava/lang/String;
    //   19: aconst_null
    //   20: aload_0
    //   21: aload_0
    //   22: getfield 31	com/google/android/gms/internal/ads/zzbgp:zzefr	Lcom/google/android/gms/internal/ads/zzbdf;
    //   25: getfield 127	com/google/android/gms/internal/ads/zzbdf:zzeeh	I
    //   28: aload_0
    //   29: getfield 31	com/google/android/gms/internal/ads/zzbgp:zzefr	Lcom/google/android/gms/internal/ads/zzbdf;
    //   32: getfield 130	com/google/android/gms/internal/ads/zzbdf:zzeej	I
    //   35: iconst_1
    //   36: aconst_null
    //   37: invokespecial 133	com/google/android/gms/internal/ads/zzsa:<init>	(Ljava/lang/String;Lcom/google/android/gms/internal/ads/zzsv;Lcom/google/android/gms/internal/ads/zzsj;IIZLcom/google/android/gms/internal/ads/zzsd;)V
    //   40: astore_3
    //   41: aload_0
    //   42: getfield 31	com/google/android/gms/internal/ads/zzbgp:zzefr	Lcom/google/android/gms/internal/ads/zzbdf;
    //   45: getfield 136	com/google/android/gms/internal/ads/zzbdf:zzeen	Z
    //   48: ifeq +545 -> 593
    //   51: new 138	com/google/android/gms/internal/ads/zzbey
    //   54: dup
    //   55: aload_0
    //   56: getfield 142	com/google/android/gms/internal/ads/zzbgp:mContext	Landroid/content/Context;
    //   59: aload_3
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokespecial 145	com/google/android/gms/internal/ads/zzbey:<init>	(Landroid/content/Context;Lcom/google/android/gms/internal/ads/zzrv;Lcom/google/android/gms/internal/ads/zzsj;Lcom/google/android/gms/internal/ads/zzbez;)V
    //   65: astore 9
    //   67: aload 9
    //   69: new 147	com/google/android/gms/internal/ads/zzry
    //   72: dup
    //   73: aload_1
    //   74: invokestatic 153	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   77: invokespecial 156	com/google/android/gms/internal/ads/zzry:<init>	(Landroid/net/Uri;)V
    //   80: invokeinterface 159 2 0
    //   85: pop2
    //   86: aload_0
    //   87: getfield 163	com/google/android/gms/internal/ads/zzbgp:zzehv	Ljava/lang/ref/WeakReference;
    //   90: invokevirtual 169	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   93: checkcast 171	com/google/android/gms/internal/ads/zzbdg
    //   96: astore 12
    //   98: aload 12
    //   100: ifnull +12 -> 112
    //   103: aload 12
    //   105: aload_2
    //   106: aload_0
    //   107: invokeinterface 174 3 0
    //   112: invokestatic 180	com/google/android/gms/ads/internal/zzk:zzln	()Lcom/google/android/gms/common/util/Clock;
    //   115: astore 13
    //   117: aload 13
    //   119: invokeinterface 185 1 0
    //   124: lstore 14
    //   126: getstatic 191	com/google/android/gms/internal/ads/zzact:zzclz	Lcom/google/android/gms/internal/ads/zzaci;
    //   129: astore 16
    //   131: invokestatic 197	com/google/android/gms/internal/ads/zzyr:zzpe	()Lcom/google/android/gms/internal/ads/zzacq;
    //   134: aload 16
    //   136: invokevirtual 203	com/google/android/gms/internal/ads/zzacq:zzd	(Lcom/google/android/gms/internal/ads/zzaci;)Ljava/lang/Object;
    //   139: checkcast 205	java/lang/Long
    //   142: invokevirtual 208	java/lang/Long:longValue	()J
    //   145: lstore 17
    //   147: getstatic 211	com/google/android/gms/internal/ads/zzact:zzcly	Lcom/google/android/gms/internal/ads/zzaci;
    //   150: astore 19
    //   152: invokestatic 197	com/google/android/gms/internal/ads/zzyr:zzpe	()Lcom/google/android/gms/internal/ads/zzacq;
    //   155: aload 19
    //   157: invokevirtual 203	com/google/android/gms/internal/ads/zzacq:zzd	(Lcom/google/android/gms/internal/ads/zzaci;)Ljava/lang/Object;
    //   160: checkcast 205	java/lang/Long
    //   163: invokevirtual 208	java/lang/Long:longValue	()J
    //   166: lstore 20
    //   168: aload_0
    //   169: aload_0
    //   170: getfield 31	com/google/android/gms/internal/ads/zzbgp:zzefr	Lcom/google/android/gms/internal/ads/zzbdf;
    //   173: getfield 214	com/google/android/gms/internal/ads/zzbdf:zzeeg	I
    //   176: invokestatic 218	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   179: putfield 55	com/google/android/gms/internal/ads/zzbgp:zzaxl	Ljava/nio/ByteBuffer;
    //   182: sipush 8192
    //   185: newarray byte
    //   187: astore 22
    //   189: lload 14
    //   191: lstore 23
    //   193: aload 9
    //   195: aload 22
    //   197: iconst_0
    //   198: aload_0
    //   199: getfield 55	com/google/android/gms/internal/ads/zzbgp:zzaxl	Ljava/nio/ByteBuffer;
    //   202: invokevirtual 221	java/nio/ByteBuffer:remaining	()I
    //   205: sipush 8192
    //   208: invokestatic 225	java/lang/Math:min	(II)I
    //   211: invokeinterface 229 4 0
    //   216: istore 25
    //   218: iload 25
    //   220: iconst_m1
    //   221: if_icmpne +30 -> 251
    //   224: aload_0
    //   225: iconst_1
    //   226: putfield 231	com/google/android/gms/internal/ads/zzbgp:zzein	Z
    //   229: aload_0
    //   230: aload_1
    //   231: aload_2
    //   232: aload_0
    //   233: getfield 43	com/google/android/gms/internal/ads/zzbgp:zzeik	Lcom/google/android/gms/internal/ads/zzbfm;
    //   236: aload_0
    //   237: getfield 55	com/google/android/gms/internal/ads/zzbgp:zzaxl	Ljava/nio/ByteBuffer;
    //   240: invokevirtual 59	com/google/android/gms/internal/ads/zzbfm:zzl	(Ljava/nio/ByteBuffer;)J
    //   243: l2i
    //   244: i2l
    //   245: invokevirtual 235	com/google/android/gms/internal/ads/zzbfu:zzb	(Ljava/lang/String;Ljava/lang/String;J)V
    //   248: goto +343 -> 591
    //   251: aload_0
    //   252: getfield 48	com/google/android/gms/internal/ads/zzbgp:zzeim	Ljava/lang/Object;
    //   255: astore 26
    //   257: aload 26
    //   259: monitorenter
    //   260: aload_0
    //   261: getfield 92	com/google/android/gms/internal/ads/zzbgp:zzeij	Z
    //   264: ifne +16 -> 280
    //   267: aload_0
    //   268: getfield 55	com/google/android/gms/internal/ads/zzbgp:zzaxl	Ljava/nio/ByteBuffer;
    //   271: aload 22
    //   273: iconst_0
    //   274: iload 25
    //   276: invokevirtual 239	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   279: pop
    //   280: aload 26
    //   282: monitorexit
    //   283: aload_0
    //   284: getfield 55	com/google/android/gms/internal/ads/zzbgp:zzaxl	Ljava/nio/ByteBuffer;
    //   287: invokevirtual 221	java/nio/ByteBuffer:remaining	()I
    //   290: ifgt +153 -> 443
    //   293: aload_0
    //   294: invokespecial 241	com/google/android/gms/internal/ads/zzbgp:zzxt	()V
    //   297: goto +294 -> 591
    //   300: astore 4
    //   302: ldc 243
    //   304: astore 5
    //   306: aload 4
    //   308: invokevirtual 247	java/lang/Object:getClass	()Ljava/lang/Class;
    //   311: invokevirtual 252	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   314: astore 6
    //   316: aload 4
    //   318: invokevirtual 255	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   321: astore 7
    //   323: new 257	java/lang/StringBuilder
    //   326: dup
    //   327: iconst_1
    //   328: aload 6
    //   330: invokestatic 263	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   333: invokevirtual 266	java/lang/String:length	()I
    //   336: iadd
    //   337: aload 7
    //   339: invokestatic 263	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   342: invokevirtual 266	java/lang/String:length	()I
    //   345: iadd
    //   346: invokespecial 269	java/lang/StringBuilder:<init>	(I)V
    //   349: aload 6
    //   351: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: ldc_w 275
    //   357: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload 7
    //   362: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: astore 8
    //   370: new 257	java/lang/StringBuilder
    //   373: dup
    //   374: bipush 34
    //   376: aload_1
    //   377: invokestatic 263	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   380: invokevirtual 266	java/lang/String:length	()I
    //   383: iadd
    //   384: aload 8
    //   386: invokestatic 263	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   389: invokevirtual 266	java/lang/String:length	()I
    //   392: iadd
    //   393: invokespecial 269	java/lang/StringBuilder:<init>	(I)V
    //   396: ldc_w 280
    //   399: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload_1
    //   403: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: ldc_w 282
    //   409: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload 8
    //   414: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 288	com/google/android/gms/internal/ads/zzaxa:zzep	(Ljava/lang/String;)V
    //   423: aload_0
    //   424: aload_1
    //   425: aload_2
    //   426: aload 5
    //   428: aload 8
    //   430: invokevirtual 291	com/google/android/gms/internal/ads/zzbfu:zza	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   433: iconst_0
    //   434: ireturn
    //   435: astore 27
    //   437: aload 26
    //   439: monitorexit
    //   440: aload 27
    //   442: athrow
    //   443: aload_0
    //   444: getfield 92	com/google/android/gms/internal/ads/zzbgp:zzeij	Z
    //   447: ifeq +59 -> 506
    //   450: ldc_w 293
    //   453: astore 5
    //   455: aload_0
    //   456: getfield 55	com/google/android/gms/internal/ads/zzbgp:zzaxl	Ljava/nio/ByteBuffer;
    //   459: invokevirtual 296	java/nio/ByteBuffer:limit	()I
    //   462: istore 28
    //   464: new 298	java/io/IOException
    //   467: dup
    //   468: new 257	java/lang/StringBuilder
    //   471: dup
    //   472: bipush 35
    //   474: invokespecial 269	java/lang/StringBuilder:<init>	(I)V
    //   477: ldc_w 300
    //   480: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: iload 28
    //   485: invokevirtual 303	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   488: ldc_w 305
    //   491: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokespecial 307	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   500: athrow
    //   501: astore 4
    //   503: goto -197 -> 306
    //   506: aload 13
    //   508: invokeinterface 185 1 0
    //   513: lstore 29
    //   515: lload 29
    //   517: lload 23
    //   519: lsub
    //   520: lload 17
    //   522: lcmp
    //   523: iflt +11 -> 534
    //   526: aload_0
    //   527: invokespecial 241	com/google/android/gms/internal/ads/zzbgp:zzxt	()V
    //   530: lload 29
    //   532: lstore 23
    //   534: lload 29
    //   536: lload 14
    //   538: lsub
    //   539: ldc2_w 308
    //   542: lload 20
    //   544: lmul
    //   545: lcmp
    //   546: ifle -353 -> 193
    //   549: ldc_w 311
    //   552: astore 5
    //   554: new 298	java/io/IOException
    //   557: dup
    //   558: new 257	java/lang/StringBuilder
    //   561: dup
    //   562: bipush 49
    //   564: invokespecial 269	java/lang/StringBuilder:<init>	(I)V
    //   567: ldc_w 313
    //   570: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: lload 20
    //   575: invokevirtual 316	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   578: ldc_w 318
    //   581: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokespecial 307	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   590: athrow
    //   591: iconst_1
    //   592: ireturn
    //   593: aload_3
    //   594: astore 9
    //   596: goto -529 -> 67
    //
    // Exception table:
    //   from	to	target	type
    //   11	67	300	java/lang/Exception
    //   67	98	300	java/lang/Exception
    //   103	112	300	java/lang/Exception
    //   112	189	300	java/lang/Exception
    //   193	218	300	java/lang/Exception
    //   224	248	300	java/lang/Exception
    //   251	260	300	java/lang/Exception
    //   283	297	300	java/lang/Exception
    //   440	443	300	java/lang/Exception
    //   443	450	300	java/lang/Exception
    //   506	515	300	java/lang/Exception
    //   526	530	300	java/lang/Exception
    //   260	280	435	finally
    //   280	283	435	finally
    //   437	440	435	finally
    //   455	501	501	java/lang/Exception
    //   554	591	501	java/lang/Exception
  }

  protected final String zzey(String paramString)
  {
    String str1 = String.valueOf("cache:");
    String str2 = String.valueOf(super.zzey(paramString));
    if (str2.length() != 0)
      return str1.concat(str2);
    return new String(str1);
  }

  public final boolean zzzv()
  {
    return this.zzein;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbgp
 * JD-Core Version:    0.6.2
 */
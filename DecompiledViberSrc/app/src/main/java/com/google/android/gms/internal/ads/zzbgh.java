package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

@zzare
public final class zzbgh extends zzbfu
{
  private String url;
  private ByteBuffer zzaxl;
  private final zzbdf zzefr;
  private boolean zzeij;
  private final zzbfm zzeik;
  private boolean zzeil;
  private final Object zzeim;
  private boolean zzein;

  public zzbgh(zzbdg paramzzbdg, zzbdf paramzzbdf)
  {
    super(paramzzbdg);
    this.zzefr = paramzzbdf;
    this.zzeik = new zzbfm();
    this.zzeim = new Object();
  }

  private final void zzxt()
  {
    int i = this.zzaxl.position();
    if (i > 0);
    for (boolean bool = true; ; bool = false)
    {
      int j = zzbdl.zzyp();
      int k = zzbdl.zzyq();
      zza(this.url, zzey(this.url), i, 0, bool, j, k);
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
    //   2: putfield 57	com/google/android/gms/internal/ads/zzbgh:url	Ljava/lang/String;
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual 61	com/google/android/gms/internal/ads/zzbfu:zzey	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_2
    //   11: new 84	com/google/android/gms/internal/ads/zzjs
    //   14: dup
    //   15: aload_0
    //   16: getfield 87	com/google/android/gms/internal/ads/zzbgh:zzdyd	Ljava/lang/String;
    //   19: aconst_null
    //   20: aconst_null
    //   21: aload_0
    //   22: getfield 26	com/google/android/gms/internal/ads/zzbgh:zzefr	Lcom/google/android/gms/internal/ads/zzbdf;
    //   25: getfield 93	com/google/android/gms/internal/ads/zzbdf:zzeeh	I
    //   28: aload_0
    //   29: getfield 26	com/google/android/gms/internal/ads/zzbgh:zzefr	Lcom/google/android/gms/internal/ads/zzbdf;
    //   32: getfield 96	com/google/android/gms/internal/ads/zzbdf:zzeej	I
    //   35: iconst_1
    //   36: invokespecial 99	com/google/android/gms/internal/ads/zzjs:<init>	(Ljava/lang/String;Lcom/google/android/gms/internal/ads/zzkn;Lcom/google/android/gms/internal/ads/zzke;IIZ)V
    //   39: astore_3
    //   40: aload_0
    //   41: getfield 26	com/google/android/gms/internal/ads/zzbgh:zzefr	Lcom/google/android/gms/internal/ads/zzbdf;
    //   44: getfield 102	com/google/android/gms/internal/ads/zzbdf:zzeen	Z
    //   47: ifeq +542 -> 589
    //   50: new 104	com/google/android/gms/internal/ads/zzbei
    //   53: dup
    //   54: aload_0
    //   55: getfield 108	com/google/android/gms/internal/ads/zzbgh:mContext	Landroid/content/Context;
    //   58: aload_3
    //   59: aconst_null
    //   60: invokespecial 111	com/google/android/gms/internal/ads/zzbei:<init>	(Landroid/content/Context;Lcom/google/android/gms/internal/ads/zzjp;Lcom/google/android/gms/internal/ads/zzbej;)V
    //   63: astore 9
    //   65: aload 9
    //   67: new 113	com/google/android/gms/internal/ads/zzjq
    //   70: dup
    //   71: aload_1
    //   72: invokestatic 119	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   75: invokespecial 122	com/google/android/gms/internal/ads/zzjq:<init>	(Landroid/net/Uri;)V
    //   78: invokeinterface 127 2 0
    //   83: pop2
    //   84: aload_0
    //   85: getfield 131	com/google/android/gms/internal/ads/zzbgh:zzehv	Ljava/lang/ref/WeakReference;
    //   88: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   91: checkcast 139	com/google/android/gms/internal/ads/zzbdg
    //   94: astore 12
    //   96: aload 12
    //   98: ifnull +12 -> 110
    //   101: aload 12
    //   103: aload_2
    //   104: aload_0
    //   105: invokeinterface 142 3 0
    //   110: invokestatic 148	com/google/android/gms/ads/internal/zzk:zzln	()Lcom/google/android/gms/common/util/Clock;
    //   113: astore 13
    //   115: aload 13
    //   117: invokeinterface 154 1 0
    //   122: lstore 14
    //   124: getstatic 160	com/google/android/gms/internal/ads/zzact:zzclz	Lcom/google/android/gms/internal/ads/zzaci;
    //   127: astore 16
    //   129: invokestatic 166	com/google/android/gms/internal/ads/zzyr:zzpe	()Lcom/google/android/gms/internal/ads/zzacq;
    //   132: aload 16
    //   134: invokevirtual 172	com/google/android/gms/internal/ads/zzacq:zzd	(Lcom/google/android/gms/internal/ads/zzaci;)Ljava/lang/Object;
    //   137: checkcast 174	java/lang/Long
    //   140: invokevirtual 177	java/lang/Long:longValue	()J
    //   143: lstore 17
    //   145: getstatic 180	com/google/android/gms/internal/ads/zzact:zzcly	Lcom/google/android/gms/internal/ads/zzaci;
    //   148: astore 19
    //   150: invokestatic 166	com/google/android/gms/internal/ads/zzyr:zzpe	()Lcom/google/android/gms/internal/ads/zzacq;
    //   153: aload 19
    //   155: invokevirtual 172	com/google/android/gms/internal/ads/zzacq:zzd	(Lcom/google/android/gms/internal/ads/zzaci;)Ljava/lang/Object;
    //   158: checkcast 174	java/lang/Long
    //   161: invokevirtual 177	java/lang/Long:longValue	()J
    //   164: lstore 20
    //   166: aload_0
    //   167: aload_0
    //   168: getfield 26	com/google/android/gms/internal/ads/zzbgh:zzefr	Lcom/google/android/gms/internal/ads/zzbdf;
    //   171: getfield 183	com/google/android/gms/internal/ads/zzbdf:zzeeg	I
    //   174: invokestatic 187	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   177: putfield 41	com/google/android/gms/internal/ads/zzbgh:zzaxl	Ljava/nio/ByteBuffer;
    //   180: sipush 8192
    //   183: newarray byte
    //   185: astore 22
    //   187: lload 14
    //   189: lstore 23
    //   191: aload 9
    //   193: aload 22
    //   195: iconst_0
    //   196: aload_0
    //   197: getfield 41	com/google/android/gms/internal/ads/zzbgh:zzaxl	Ljava/nio/ByteBuffer;
    //   200: invokevirtual 190	java/nio/ByteBuffer:remaining	()I
    //   203: sipush 8192
    //   206: invokestatic 196	java/lang/Math:min	(II)I
    //   209: invokeinterface 200 4 0
    //   214: istore 25
    //   216: iload 25
    //   218: iconst_m1
    //   219: if_icmpne +30 -> 249
    //   222: aload_0
    //   223: iconst_1
    //   224: putfield 202	com/google/android/gms/internal/ads/zzbgh:zzein	Z
    //   227: aload_0
    //   228: aload_1
    //   229: aload_2
    //   230: aload_0
    //   231: getfield 33	com/google/android/gms/internal/ads/zzbgh:zzeik	Lcom/google/android/gms/internal/ads/zzbfm;
    //   234: aload_0
    //   235: getfield 41	com/google/android/gms/internal/ads/zzbgh:zzaxl	Ljava/nio/ByteBuffer;
    //   238: invokevirtual 206	com/google/android/gms/internal/ads/zzbfm:zzl	(Ljava/nio/ByteBuffer;)J
    //   241: l2i
    //   242: i2l
    //   243: invokevirtual 210	com/google/android/gms/internal/ads/zzbfu:zzb	(Ljava/lang/String;Ljava/lang/String;J)V
    //   246: goto +341 -> 587
    //   249: aload_0
    //   250: getfield 38	com/google/android/gms/internal/ads/zzbgh:zzeim	Ljava/lang/Object;
    //   253: astore 26
    //   255: aload 26
    //   257: monitorenter
    //   258: aload_0
    //   259: getfield 68	com/google/android/gms/internal/ads/zzbgh:zzeij	Z
    //   262: ifne +16 -> 278
    //   265: aload_0
    //   266: getfield 41	com/google/android/gms/internal/ads/zzbgh:zzaxl	Ljava/nio/ByteBuffer;
    //   269: aload 22
    //   271: iconst_0
    //   272: iload 25
    //   274: invokevirtual 214	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   277: pop
    //   278: aload 26
    //   280: monitorexit
    //   281: aload_0
    //   282: getfield 41	com/google/android/gms/internal/ads/zzbgh:zzaxl	Ljava/nio/ByteBuffer;
    //   285: invokevirtual 190	java/nio/ByteBuffer:remaining	()I
    //   288: ifgt +151 -> 439
    //   291: aload_0
    //   292: invokespecial 216	com/google/android/gms/internal/ads/zzbgh:zzxt	()V
    //   295: goto +292 -> 587
    //   298: astore 4
    //   300: ldc 218
    //   302: astore 5
    //   304: aload 4
    //   306: invokevirtual 222	java/lang/Object:getClass	()Ljava/lang/Class;
    //   309: invokevirtual 227	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   312: astore 6
    //   314: aload 4
    //   316: invokevirtual 230	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   319: astore 7
    //   321: new 232	java/lang/StringBuilder
    //   324: dup
    //   325: iconst_1
    //   326: aload 6
    //   328: invokestatic 238	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   331: invokevirtual 241	java/lang/String:length	()I
    //   334: iadd
    //   335: aload 7
    //   337: invokestatic 238	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   340: invokevirtual 241	java/lang/String:length	()I
    //   343: iadd
    //   344: invokespecial 244	java/lang/StringBuilder:<init>	(I)V
    //   347: aload 6
    //   349: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: ldc 250
    //   354: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload 7
    //   359: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: astore 8
    //   367: new 232	java/lang/StringBuilder
    //   370: dup
    //   371: bipush 34
    //   373: aload_1
    //   374: invokestatic 238	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   377: invokevirtual 241	java/lang/String:length	()I
    //   380: iadd
    //   381: aload 8
    //   383: invokestatic 238	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   386: invokevirtual 241	java/lang/String:length	()I
    //   389: iadd
    //   390: invokespecial 244	java/lang/StringBuilder:<init>	(I)V
    //   393: ldc 255
    //   395: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload_1
    //   399: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: ldc_w 257
    //   405: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload 8
    //   410: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokestatic 263	com/google/android/gms/internal/ads/zzaxa:zzep	(Ljava/lang/String;)V
    //   419: aload_0
    //   420: aload_1
    //   421: aload_2
    //   422: aload 5
    //   424: aload 8
    //   426: invokevirtual 266	com/google/android/gms/internal/ads/zzbfu:zza	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   429: iconst_0
    //   430: ireturn
    //   431: astore 27
    //   433: aload 26
    //   435: monitorexit
    //   436: aload 27
    //   438: athrow
    //   439: aload_0
    //   440: getfield 68	com/google/android/gms/internal/ads/zzbgh:zzeij	Z
    //   443: ifeq +59 -> 502
    //   446: ldc_w 268
    //   449: astore 5
    //   451: aload_0
    //   452: getfield 41	com/google/android/gms/internal/ads/zzbgh:zzaxl	Ljava/nio/ByteBuffer;
    //   455: invokevirtual 271	java/nio/ByteBuffer:limit	()I
    //   458: istore 28
    //   460: new 273	java/io/IOException
    //   463: dup
    //   464: new 232	java/lang/StringBuilder
    //   467: dup
    //   468: bipush 35
    //   470: invokespecial 244	java/lang/StringBuilder:<init>	(I)V
    //   473: ldc_w 275
    //   476: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: iload 28
    //   481: invokevirtual 278	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   484: ldc_w 280
    //   487: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokespecial 282	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   496: athrow
    //   497: astore 4
    //   499: goto -195 -> 304
    //   502: aload 13
    //   504: invokeinterface 154 1 0
    //   509: lstore 29
    //   511: lload 29
    //   513: lload 23
    //   515: lsub
    //   516: lload 17
    //   518: lcmp
    //   519: iflt +11 -> 530
    //   522: aload_0
    //   523: invokespecial 216	com/google/android/gms/internal/ads/zzbgh:zzxt	()V
    //   526: lload 29
    //   528: lstore 23
    //   530: lload 29
    //   532: lload 14
    //   534: lsub
    //   535: ldc2_w 283
    //   538: lload 20
    //   540: lmul
    //   541: lcmp
    //   542: ifle -351 -> 191
    //   545: ldc_w 286
    //   548: astore 5
    //   550: new 273	java/io/IOException
    //   553: dup
    //   554: new 232	java/lang/StringBuilder
    //   557: dup
    //   558: bipush 49
    //   560: invokespecial 244	java/lang/StringBuilder:<init>	(I)V
    //   563: ldc_w 288
    //   566: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: lload 20
    //   571: invokevirtual 291	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   574: ldc_w 293
    //   577: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokespecial 282	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   586: athrow
    //   587: iconst_1
    //   588: ireturn
    //   589: aload_3
    //   590: astore 9
    //   592: goto -527 -> 65
    //
    // Exception table:
    //   from	to	target	type
    //   11	65	298	java/lang/Exception
    //   65	96	298	java/lang/Exception
    //   101	110	298	java/lang/Exception
    //   110	187	298	java/lang/Exception
    //   191	216	298	java/lang/Exception
    //   222	246	298	java/lang/Exception
    //   249	258	298	java/lang/Exception
    //   281	295	298	java/lang/Exception
    //   436	439	298	java/lang/Exception
    //   439	446	298	java/lang/Exception
    //   502	511	298	java/lang/Exception
    //   522	526	298	java/lang/Exception
    //   258	278	431	finally
    //   278	281	431	finally
    //   433	436	431	finally
    //   451	497	497	java/lang/Exception
    //   550	587	497	java/lang/Exception
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
 * Qualified Name:     com.google.android.gms.internal.ads.zzbgh
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;

@zzare
public final class zzbey
  implements zzrv
{
  private boolean isOpen;
  private Uri uri;
  private InputStream zzege;
  private final zzrv zzegs;
  private final zzsj<zzrv> zzegt;
  private final zzbez zzegu;
  private final Context zzlj;

  public zzbey(Context paramContext, zzrv paramzzrv, zzsj<zzrv> paramzzsj, zzbez paramzzbez)
  {
    this.zzlj = paramContext;
    this.zzegs = paramzzrv;
    this.zzegt = paramzzsj;
    this.zzegu = paramzzbez;
  }

  public final void close()
    throws IOException
  {
    if (!this.isOpen)
      throw new IOException("Attempt to close an already closed CacheDataSource.");
    this.isOpen = false;
    this.uri = null;
    if (this.zzege != null)
    {
      IOUtils.closeQuietly(this.zzege);
      this.zzege = null;
    }
    while (true)
    {
      if (this.zzegt != null)
        this.zzegt.zze(this);
      return;
      this.zzegs.close();
    }
  }

  public final Uri getUri()
  {
    return this.uri;
  }

  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (!this.isOpen)
      throw new IOException("Attempt to read closed CacheDataSource.");
    if (this.zzege != null);
    for (int i = this.zzege.read(paramArrayOfByte, paramInt1, paramInt2); ; i = this.zzegs.read(paramArrayOfByte, paramInt1, paramInt2))
    {
      if (this.zzegt != null)
        this.zzegt.zzc(this, i);
      return i;
    }
  }

  // ERROR //
  public final long zza(zzry paramzzry)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/google/android/gms/internal/ads/zzbey:isOpen	Z
    //   4: ifeq +13 -> 17
    //   7: new 38	java/io/IOException
    //   10: dup
    //   11: ldc 88
    //   13: invokespecial 45	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 40	com/google/android/gms/internal/ads/zzbey:isOpen	Z
    //   22: aload_0
    //   23: aload_1
    //   24: getfield 91	com/google/android/gms/internal/ads/zzry:uri	Landroid/net/Uri;
    //   27: putfield 47	com/google/android/gms/internal/ads/zzbey:uri	Landroid/net/Uri;
    //   30: aload_0
    //   31: getfield 33	com/google/android/gms/internal/ads/zzbey:zzegt	Lcom/google/android/gms/internal/ads/zzsj;
    //   34: ifnull +14 -> 48
    //   37: aload_0
    //   38: getfield 33	com/google/android/gms/internal/ads/zzbey:zzegt	Lcom/google/android/gms/internal/ads/zzsj;
    //   41: aload_0
    //   42: aload_1
    //   43: invokeinterface 94 3 0
    //   48: aload_1
    //   49: getfield 91	com/google/android/gms/internal/ads/zzry:uri	Landroid/net/Uri;
    //   52: invokestatic 99	com/google/android/gms/internal/ads/zzvt:zze	(Landroid/net/Uri;)Lcom/google/android/gms/internal/ads/zzvt;
    //   55: astore_2
    //   56: getstatic 105	com/google/android/gms/internal/ads/zzact:zzctt	Lcom/google/android/gms/internal/ads/zzaci;
    //   59: astore_3
    //   60: invokestatic 111	com/google/android/gms/internal/ads/zzyr:zzpe	()Lcom/google/android/gms/internal/ads/zzacq;
    //   63: aload_3
    //   64: invokevirtual 117	com/google/android/gms/internal/ads/zzacq:zzd	(Lcom/google/android/gms/internal/ads/zzaci;)Ljava/lang/Object;
    //   67: checkcast 119	java/lang/Boolean
    //   70: invokevirtual 123	java/lang/Boolean:booleanValue	()Z
    //   73: ifeq +427 -> 500
    //   76: aload_2
    //   77: ifnull +232 -> 309
    //   80: aload_2
    //   81: aload_1
    //   82: getfield 127	com/google/android/gms/internal/ads/zzry:zzahv	J
    //   85: putfield 130	com/google/android/gms/internal/ads/zzvt:zzbwz	J
    //   88: aload_2
    //   89: getfield 133	com/google/android/gms/internal/ads/zzvt:zzbwy	Z
    //   92: ifeq +130 -> 222
    //   95: getstatic 136	com/google/android/gms/internal/ads/zzact:zzctv	Lcom/google/android/gms/internal/ads/zzaci;
    //   98: astore 28
    //   100: invokestatic 111	com/google/android/gms/internal/ads/zzyr:zzpe	()Lcom/google/android/gms/internal/ads/zzacq;
    //   103: aload 28
    //   105: invokevirtual 117	com/google/android/gms/internal/ads/zzacq:zzd	(Lcom/google/android/gms/internal/ads/zzaci;)Ljava/lang/Object;
    //   108: checkcast 138	java/lang/Long
    //   111: astore 7
    //   113: aload 7
    //   115: invokevirtual 142	java/lang/Long:longValue	()J
    //   118: lstore 8
    //   120: invokestatic 148	com/google/android/gms/ads/internal/zzk:zzln	()Lcom/google/android/gms/common/util/Clock;
    //   123: invokeinterface 153 1 0
    //   128: lstore 10
    //   130: invokestatic 157	com/google/android/gms/ads/internal/zzk:zzma	()Lcom/google/android/gms/internal/ads/zzwg;
    //   133: pop
    //   134: aload_0
    //   135: getfield 29	com/google/android/gms/internal/ads/zzbey:zzlj	Landroid/content/Context;
    //   138: aload_2
    //   139: invokestatic 162	com/google/android/gms/internal/ads/zzwg:zza	(Landroid/content/Context;Lcom/google/android/gms/internal/ads/zzvt;)Ljava/util/concurrent/Future;
    //   142: astore 13
    //   144: aload_0
    //   145: aload 13
    //   147: lload 8
    //   149: getstatic 168	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   152: invokeinterface 174 4 0
    //   157: checkcast 71	java/io/InputStream
    //   160: putfield 49	com/google/android/gms/internal/ads/zzbey:zzege	Ljava/io/InputStream;
    //   163: invokestatic 148	com/google/android/gms/ads/internal/zzk:zzln	()Lcom/google/android/gms/common/util/Clock;
    //   166: invokeinterface 153 1 0
    //   171: lload 10
    //   173: lsub
    //   174: lstore 26
    //   176: aload_0
    //   177: getfield 35	com/google/android/gms/internal/ads/zzbey:zzegu	Lcom/google/android/gms/internal/ads/zzbez;
    //   180: iconst_1
    //   181: lload 26
    //   183: invokeinterface 179 4 0
    //   188: new 181	java/lang/StringBuilder
    //   191: dup
    //   192: bipush 44
    //   194: invokespecial 184	java/lang/StringBuilder:<init>	(I)V
    //   197: ldc 186
    //   199: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: lload 26
    //   204: invokevirtual 193	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   207: ldc 195
    //   209: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 204	com/google/android/gms/internal/ads/zzaxa:zzds	(Ljava/lang/String;)V
    //   218: ldc2_w 205
    //   221: lreturn
    //   222: getstatic 209	com/google/android/gms/internal/ads/zzact:zzctu	Lcom/google/android/gms/internal/ads/zzaci;
    //   225: astore 6
    //   227: invokestatic 111	com/google/android/gms/internal/ads/zzyr:zzpe	()Lcom/google/android/gms/internal/ads/zzacq;
    //   230: aload 6
    //   232: invokevirtual 117	com/google/android/gms/internal/ads/zzacq:zzd	(Lcom/google/android/gms/internal/ads/zzaci;)Ljava/lang/Object;
    //   235: checkcast 138	java/lang/Long
    //   238: astore 7
    //   240: goto -127 -> 113
    //   243: astore 25
    //   245: aload 13
    //   247: iconst_1
    //   248: invokeinterface 213 2 0
    //   253: pop
    //   254: invokestatic 148	com/google/android/gms/ads/internal/zzk:zzln	()Lcom/google/android/gms/common/util/Clock;
    //   257: invokeinterface 153 1 0
    //   262: lload 10
    //   264: lsub
    //   265: lstore 19
    //   267: aload_0
    //   268: getfield 35	com/google/android/gms/internal/ads/zzbey:zzegu	Lcom/google/android/gms/internal/ads/zzbez;
    //   271: iconst_0
    //   272: lload 19
    //   274: invokeinterface 179 4 0
    //   279: new 181	java/lang/StringBuilder
    //   282: dup
    //   283: bipush 44
    //   285: invokespecial 184	java/lang/StringBuilder:<init>	(I)V
    //   288: ldc 186
    //   290: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: lload 19
    //   295: invokevirtual 193	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   298: ldc 195
    //   300: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 204	com/google/android/gms/internal/ads/zzaxa:zzds	(Ljava/lang/String;)V
    //   309: aload_2
    //   310: ifnull +245 -> 555
    //   313: new 90	com/google/android/gms/internal/ads/zzry
    //   316: dup
    //   317: aload_2
    //   318: getfield 217	com/google/android/gms/internal/ads/zzvt:url	Ljava/lang/String;
    //   321: invokestatic 223	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   324: aload_1
    //   325: getfield 227	com/google/android/gms/internal/ads/zzry:zzbmd	[B
    //   328: aload_1
    //   329: getfield 230	com/google/android/gms/internal/ads/zzry:zzapg	J
    //   332: aload_1
    //   333: getfield 127	com/google/android/gms/internal/ads/zzry:zzahv	J
    //   336: aload_1
    //   337: getfield 233	com/google/android/gms/internal/ads/zzry:zzcd	J
    //   340: aload_1
    //   341: getfield 236	com/google/android/gms/internal/ads/zzry:zzcc	Ljava/lang/String;
    //   344: aload_1
    //   345: getfield 240	com/google/android/gms/internal/ads/zzry:flags	I
    //   348: invokespecial 243	com/google/android/gms/internal/ads/zzry:<init>	(Landroid/net/Uri;[BJJJLjava/lang/String;I)V
    //   351: astore 5
    //   353: aload_0
    //   354: getfield 31	com/google/android/gms/internal/ads/zzbey:zzegs	Lcom/google/android/gms/internal/ads/zzrv;
    //   357: aload 5
    //   359: invokeinterface 245 2 0
    //   364: lreturn
    //   365: astore 21
    //   367: aload 13
    //   369: iconst_1
    //   370: invokeinterface 213 2 0
    //   375: pop
    //   376: invokestatic 251	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   379: invokevirtual 254	java/lang/Thread:interrupt	()V
    //   382: invokestatic 148	com/google/android/gms/ads/internal/zzk:zzln	()Lcom/google/android/gms/common/util/Clock;
    //   385: invokeinterface 153 1 0
    //   390: lload 10
    //   392: lsub
    //   393: lstore 23
    //   395: aload_0
    //   396: getfield 35	com/google/android/gms/internal/ads/zzbey:zzegu	Lcom/google/android/gms/internal/ads/zzbez;
    //   399: iconst_0
    //   400: lload 23
    //   402: invokeinterface 179 4 0
    //   407: new 181	java/lang/StringBuilder
    //   410: dup
    //   411: bipush 44
    //   413: invokespecial 184	java/lang/StringBuilder:<init>	(I)V
    //   416: ldc 186
    //   418: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: lload 23
    //   423: invokevirtual 193	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   426: ldc 195
    //   428: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 204	com/google/android/gms/internal/ads/zzaxa:zzds	(Ljava/lang/String;)V
    //   437: goto -128 -> 309
    //   440: astore 15
    //   442: invokestatic 148	com/google/android/gms/ads/internal/zzk:zzln	()Lcom/google/android/gms/common/util/Clock;
    //   445: invokeinterface 153 1 0
    //   450: lload 10
    //   452: lsub
    //   453: lstore 16
    //   455: aload_0
    //   456: getfield 35	com/google/android/gms/internal/ads/zzbey:zzegu	Lcom/google/android/gms/internal/ads/zzbez;
    //   459: iconst_0
    //   460: lload 16
    //   462: invokeinterface 179 4 0
    //   467: new 181	java/lang/StringBuilder
    //   470: dup
    //   471: bipush 44
    //   473: invokespecial 184	java/lang/StringBuilder:<init>	(I)V
    //   476: ldc 186
    //   478: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: lload 16
    //   483: invokevirtual 193	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   486: ldc 195
    //   488: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 204	com/google/android/gms/internal/ads/zzaxa:zzds	(Ljava/lang/String;)V
    //   497: aload 15
    //   499: athrow
    //   500: aconst_null
    //   501: astore 4
    //   503: aload_2
    //   504: ifnull +20 -> 524
    //   507: aload_2
    //   508: aload_1
    //   509: getfield 127	com/google/android/gms/internal/ads/zzry:zzahv	J
    //   512: putfield 130	com/google/android/gms/internal/ads/zzvt:zzbwz	J
    //   515: invokestatic 258	com/google/android/gms/ads/internal/zzk:zzlm	()Lcom/google/android/gms/internal/ads/zzvl;
    //   518: aload_2
    //   519: invokevirtual 263	com/google/android/gms/internal/ads/zzvl:zza	(Lcom/google/android/gms/internal/ads/zzvt;)Lcom/google/android/gms/internal/ads/zzvq;
    //   522: astore 4
    //   524: aload 4
    //   526: ifnull -217 -> 309
    //   529: aload 4
    //   531: invokevirtual 268	com/google/android/gms/internal/ads/zzvq:zznh	()Z
    //   534: ifeq -225 -> 309
    //   537: aload_0
    //   538: aload 4
    //   540: invokevirtual 272	com/google/android/gms/internal/ads/zzvq:zzni	()Ljava/io/InputStream;
    //   543: putfield 49	com/google/android/gms/internal/ads/zzbey:zzege	Ljava/io/InputStream;
    //   546: ldc2_w 205
    //   549: lreturn
    //   550: astore 14
    //   552: goto -307 -> 245
    //   555: aload_1
    //   556: astore 5
    //   558: goto -205 -> 353
    //
    // Exception table:
    //   from	to	target	type
    //   144	163	243	java/util/concurrent/ExecutionException
    //   144	163	365	java/lang/InterruptedException
    //   144	163	440	finally
    //   245	254	440	finally
    //   367	382	440	finally
    //   144	163	550	java/util/concurrent/TimeoutException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbey
 * JD-Core Version:    0.6.2
 */
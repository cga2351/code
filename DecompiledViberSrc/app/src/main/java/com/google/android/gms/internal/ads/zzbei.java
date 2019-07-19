package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

@zzare
public final class zzbei
  implements zzjp
{
  private boolean isOpen;
  private InputStream zzege;
  private final zzjp zzegf;
  private final WeakReference<zzbej> zzegg;
  private final Context zzlj;

  public zzbei(Context paramContext, zzjp paramzzjp, zzbej paramzzbej)
  {
    this.zzlj = paramContext;
    this.zzegf = paramzzjp;
    this.zzegg = new WeakReference(paramzzbej);
  }

  public final void close()
    throws IOException
  {
    if (!this.isOpen)
      throw new IOException("Attempt to close an already closed CacheDataSource.");
    this.isOpen = false;
    if (this.zzege != null)
    {
      IOUtils.closeQuietly(this.zzege);
      this.zzege = null;
      return;
    }
    this.zzegf.close();
  }

  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (!this.isOpen)
      throw new IOException("Attempt to read closed CacheDataSource.");
    if (this.zzege != null)
      return this.zzege.read(paramArrayOfByte, paramInt1, paramInt2);
    return this.zzegf.read(paramArrayOfByte, paramInt1, paramInt2);
  }

  // ERROR //
  public final long zza(zzjq paramzzjq)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/google/android/gms/internal/ads/zzbei:isOpen	Z
    //   4: ifeq +13 -> 17
    //   7: new 37	java/io/IOException
    //   10: dup
    //   11: ldc 73
    //   13: invokespecial 44	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 39	com/google/android/gms/internal/ads/zzbei:isOpen	Z
    //   22: aload_1
    //   23: getfield 79	com/google/android/gms/internal/ads/zzjq:uri	Landroid/net/Uri;
    //   26: invokestatic 85	com/google/android/gms/internal/ads/zzvt:zze	(Landroid/net/Uri;)Lcom/google/android/gms/internal/ads/zzvt;
    //   29: astore_2
    //   30: getstatic 91	com/google/android/gms/internal/ads/zzact:zzctt	Lcom/google/android/gms/internal/ads/zzaci;
    //   33: astore_3
    //   34: invokestatic 97	com/google/android/gms/internal/ads/zzyr:zzpe	()Lcom/google/android/gms/internal/ads/zzacq;
    //   37: aload_3
    //   38: invokevirtual 103	com/google/android/gms/internal/ads/zzacq:zzd	(Lcom/google/android/gms/internal/ads/zzaci;)Ljava/lang/Object;
    //   41: checkcast 105	java/lang/Boolean
    //   44: invokevirtual 109	java/lang/Boolean:booleanValue	()Z
    //   47: ifeq +483 -> 530
    //   50: aload_2
    //   51: ifnull +262 -> 313
    //   54: aload_2
    //   55: aload_1
    //   56: getfield 113	com/google/android/gms/internal/ads/zzjq:zzahv	J
    //   59: putfield 116	com/google/android/gms/internal/ads/zzvt:zzbwz	J
    //   62: aload_2
    //   63: getfield 119	com/google/android/gms/internal/ads/zzvt:zzbwy	Z
    //   66: ifeq +145 -> 211
    //   69: getstatic 122	com/google/android/gms/internal/ads/zzact:zzctv	Lcom/google/android/gms/internal/ads/zzaci;
    //   72: astore 32
    //   74: invokestatic 97	com/google/android/gms/internal/ads/zzyr:zzpe	()Lcom/google/android/gms/internal/ads/zzacq;
    //   77: aload 32
    //   79: invokevirtual 103	com/google/android/gms/internal/ads/zzacq:zzd	(Lcom/google/android/gms/internal/ads/zzaci;)Ljava/lang/Object;
    //   82: checkcast 124	java/lang/Long
    //   85: astore 7
    //   87: aload 7
    //   89: invokevirtual 128	java/lang/Long:longValue	()J
    //   92: lstore 8
    //   94: invokestatic 134	com/google/android/gms/ads/internal/zzk:zzln	()Lcom/google/android/gms/common/util/Clock;
    //   97: invokeinterface 139 1 0
    //   102: lstore 10
    //   104: invokestatic 143	com/google/android/gms/ads/internal/zzk:zzma	()Lcom/google/android/gms/internal/ads/zzwg;
    //   107: pop
    //   108: aload_0
    //   109: getfield 25	com/google/android/gms/internal/ads/zzbei:zzlj	Landroid/content/Context;
    //   112: aload_2
    //   113: invokestatic 148	com/google/android/gms/internal/ads/zzwg:zza	(Landroid/content/Context;Lcom/google/android/gms/internal/ads/zzvt;)Ljava/util/concurrent/Future;
    //   116: astore 13
    //   118: aload_0
    //   119: aload 13
    //   121: lload 8
    //   123: getstatic 154	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   126: invokeinterface 160 4 0
    //   131: checkcast 60	java/io/InputStream
    //   134: putfield 46	com/google/android/gms/internal/ads/zzbei:zzege	Ljava/io/InputStream;
    //   137: invokestatic 134	com/google/android/gms/ads/internal/zzk:zzln	()Lcom/google/android/gms/common/util/Clock;
    //   140: invokeinterface 139 1 0
    //   145: lload 10
    //   147: lsub
    //   148: lstore 29
    //   150: aload_0
    //   151: getfield 34	com/google/android/gms/internal/ads/zzbei:zzegg	Ljava/lang/ref/WeakReference;
    //   154: invokevirtual 163	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   157: checkcast 165	com/google/android/gms/internal/ads/zzbej
    //   160: astore 31
    //   162: aload 31
    //   164: ifnull +13 -> 177
    //   167: aload 31
    //   169: iconst_1
    //   170: lload 29
    //   172: invokeinterface 168 4 0
    //   177: new 170	java/lang/StringBuilder
    //   180: dup
    //   181: bipush 44
    //   183: invokespecial 173	java/lang/StringBuilder:<init>	(I)V
    //   186: ldc 175
    //   188: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: lload 29
    //   193: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   196: ldc 184
    //   198: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 193	com/google/android/gms/internal/ads/zzaxa:zzds	(Ljava/lang/String;)V
    //   207: ldc2_w 194
    //   210: lreturn
    //   211: getstatic 198	com/google/android/gms/internal/ads/zzact:zzctu	Lcom/google/android/gms/internal/ads/zzaci;
    //   214: astore 6
    //   216: invokestatic 97	com/google/android/gms/internal/ads/zzyr:zzpe	()Lcom/google/android/gms/internal/ads/zzacq;
    //   219: aload 6
    //   221: invokevirtual 103	com/google/android/gms/internal/ads/zzacq:zzd	(Lcom/google/android/gms/internal/ads/zzaci;)Ljava/lang/Object;
    //   224: checkcast 124	java/lang/Long
    //   227: astore 7
    //   229: goto -142 -> 87
    //   232: astore 28
    //   234: aload 13
    //   236: iconst_1
    //   237: invokeinterface 202 2 0
    //   242: pop
    //   243: invokestatic 134	com/google/android/gms/ads/internal/zzk:zzln	()Lcom/google/android/gms/common/util/Clock;
    //   246: invokeinterface 139 1 0
    //   251: lload 10
    //   253: lsub
    //   254: lstore 20
    //   256: aload_0
    //   257: getfield 34	com/google/android/gms/internal/ads/zzbei:zzegg	Ljava/lang/ref/WeakReference;
    //   260: invokevirtual 163	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   263: checkcast 165	com/google/android/gms/internal/ads/zzbej
    //   266: astore 22
    //   268: aload 22
    //   270: ifnull +13 -> 283
    //   273: aload 22
    //   275: iconst_0
    //   276: lload 20
    //   278: invokeinterface 168 4 0
    //   283: new 170	java/lang/StringBuilder
    //   286: dup
    //   287: bipush 44
    //   289: invokespecial 173	java/lang/StringBuilder:<init>	(I)V
    //   292: ldc 175
    //   294: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: lload 20
    //   299: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   302: ldc 184
    //   304: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 193	com/google/android/gms/internal/ads/zzaxa:zzds	(Ljava/lang/String;)V
    //   313: aload_2
    //   314: ifnull +271 -> 585
    //   317: new 75	com/google/android/gms/internal/ads/zzjq
    //   320: dup
    //   321: aload_2
    //   322: getfield 206	com/google/android/gms/internal/ads/zzvt:url	Ljava/lang/String;
    //   325: invokestatic 212	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   328: aload_1
    //   329: getfield 215	com/google/android/gms/internal/ads/zzjq:zzapg	J
    //   332: aload_1
    //   333: getfield 113	com/google/android/gms/internal/ads/zzjq:zzahv	J
    //   336: aload_1
    //   337: getfield 218	com/google/android/gms/internal/ads/zzjq:zzcd	J
    //   340: aload_1
    //   341: getfield 221	com/google/android/gms/internal/ads/zzjq:zzcc	Ljava/lang/String;
    //   344: aload_1
    //   345: getfield 225	com/google/android/gms/internal/ads/zzjq:flags	I
    //   348: invokespecial 228	com/google/android/gms/internal/ads/zzjq:<init>	(Landroid/net/Uri;JJJLjava/lang/String;I)V
    //   351: astore 5
    //   353: aload_0
    //   354: getfield 27	com/google/android/gms/internal/ads/zzbei:zzegf	Lcom/google/android/gms/internal/ads/zzjp;
    //   357: aload 5
    //   359: invokeinterface 230 2 0
    //   364: lreturn
    //   365: astore 23
    //   367: aload 13
    //   369: iconst_1
    //   370: invokeinterface 202 2 0
    //   375: pop
    //   376: invokestatic 236	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   379: invokevirtual 239	java/lang/Thread:interrupt	()V
    //   382: invokestatic 134	com/google/android/gms/ads/internal/zzk:zzln	()Lcom/google/android/gms/common/util/Clock;
    //   385: invokeinterface 139 1 0
    //   390: lload 10
    //   392: lsub
    //   393: lstore 25
    //   395: aload_0
    //   396: getfield 34	com/google/android/gms/internal/ads/zzbei:zzegg	Ljava/lang/ref/WeakReference;
    //   399: invokevirtual 163	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   402: checkcast 165	com/google/android/gms/internal/ads/zzbej
    //   405: astore 27
    //   407: aload 27
    //   409: ifnull +13 -> 422
    //   412: aload 27
    //   414: iconst_0
    //   415: lload 25
    //   417: invokeinterface 168 4 0
    //   422: new 170	java/lang/StringBuilder
    //   425: dup
    //   426: bipush 44
    //   428: invokespecial 173	java/lang/StringBuilder:<init>	(I)V
    //   431: ldc 175
    //   433: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: lload 25
    //   438: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   441: ldc 184
    //   443: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokestatic 193	com/google/android/gms/internal/ads/zzaxa:zzds	(Ljava/lang/String;)V
    //   452: goto -139 -> 313
    //   455: astore 15
    //   457: invokestatic 134	com/google/android/gms/ads/internal/zzk:zzln	()Lcom/google/android/gms/common/util/Clock;
    //   460: invokeinterface 139 1 0
    //   465: lload 10
    //   467: lsub
    //   468: lstore 16
    //   470: aload_0
    //   471: getfield 34	com/google/android/gms/internal/ads/zzbei:zzegg	Ljava/lang/ref/WeakReference;
    //   474: invokevirtual 163	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   477: checkcast 165	com/google/android/gms/internal/ads/zzbej
    //   480: astore 18
    //   482: aload 18
    //   484: ifnull +13 -> 497
    //   487: aload 18
    //   489: iconst_0
    //   490: lload 16
    //   492: invokeinterface 168 4 0
    //   497: new 170	java/lang/StringBuilder
    //   500: dup
    //   501: bipush 44
    //   503: invokespecial 173	java/lang/StringBuilder:<init>	(I)V
    //   506: ldc 175
    //   508: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: lload 16
    //   513: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   516: ldc 184
    //   518: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokestatic 193	com/google/android/gms/internal/ads/zzaxa:zzds	(Ljava/lang/String;)V
    //   527: aload 15
    //   529: athrow
    //   530: aconst_null
    //   531: astore 4
    //   533: aload_2
    //   534: ifnull +20 -> 554
    //   537: aload_2
    //   538: aload_1
    //   539: getfield 113	com/google/android/gms/internal/ads/zzjq:zzahv	J
    //   542: putfield 116	com/google/android/gms/internal/ads/zzvt:zzbwz	J
    //   545: invokestatic 243	com/google/android/gms/ads/internal/zzk:zzlm	()Lcom/google/android/gms/internal/ads/zzvl;
    //   548: aload_2
    //   549: invokevirtual 248	com/google/android/gms/internal/ads/zzvl:zza	(Lcom/google/android/gms/internal/ads/zzvt;)Lcom/google/android/gms/internal/ads/zzvq;
    //   552: astore 4
    //   554: aload 4
    //   556: ifnull -243 -> 313
    //   559: aload 4
    //   561: invokevirtual 253	com/google/android/gms/internal/ads/zzvq:zznh	()Z
    //   564: ifeq -251 -> 313
    //   567: aload_0
    //   568: aload 4
    //   570: invokevirtual 257	com/google/android/gms/internal/ads/zzvq:zzni	()Ljava/io/InputStream;
    //   573: putfield 46	com/google/android/gms/internal/ads/zzbei:zzege	Ljava/io/InputStream;
    //   576: ldc2_w 194
    //   579: lreturn
    //   580: astore 14
    //   582: goto -348 -> 234
    //   585: aload_1
    //   586: astore 5
    //   588: goto -235 -> 353
    //
    // Exception table:
    //   from	to	target	type
    //   118	137	232	java/util/concurrent/ExecutionException
    //   118	137	365	java/lang/InterruptedException
    //   118	137	455	finally
    //   234	243	455	finally
    //   367	382	455	finally
    //   118	137	580	java/util/concurrent/TimeoutException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbei
 * JD-Core Version:    0.6.2
 */
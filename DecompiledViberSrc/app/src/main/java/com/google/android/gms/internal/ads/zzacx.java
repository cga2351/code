package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Environment;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzacx
{
  private File file;

  @VisibleForTesting
  private Context mContext;

  @VisibleForTesting
  private BlockingQueue<zzadh> zzcxb = new ArrayBlockingQueue(100);

  @VisibleForTesting
  private ExecutorService zzcxc;

  @VisibleForTesting
  private LinkedHashMap<String, String> zzcxd = new LinkedHashMap();

  @VisibleForTesting
  private Map<String, zzadb> zzcxe = new HashMap();

  @VisibleForTesting
  private String zzcxf;

  @VisibleForTesting
  private String zzcxg;
  private AtomicBoolean zzcxh;

  // ERROR //
  private final void zzqt()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/google/android/gms/internal/ads/zzacx:zzcxb	Ljava/util/concurrent/BlockingQueue;
    //   4: invokeinterface 63 1 0
    //   9: checkcast 65	com/google/android/gms/internal/ads/zzadh
    //   12: astore_2
    //   13: aload_2
    //   14: invokevirtual 69	com/google/android/gms/internal/ads/zzadh:zzqx	()Ljava/lang/String;
    //   17: astore_3
    //   18: aload_3
    //   19: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifne -22 -> 0
    //   25: aload_0
    //   26: aload_0
    //   27: getfield 43	com/google/android/gms/internal/ads/zzacx:zzcxd	Ljava/util/LinkedHashMap;
    //   30: aload_2
    //   31: invokevirtual 79	com/google/android/gms/internal/ads/zzadh:zzqy	()Ljava/util/Map;
    //   34: invokevirtual 82	com/google/android/gms/internal/ads/zzacx:zza	(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;
    //   37: astore 4
    //   39: aload_0
    //   40: getfield 84	com/google/android/gms/internal/ads/zzacx:zzcxf	Ljava/lang/String;
    //   43: invokestatic 90	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   46: invokevirtual 94	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   49: astore 5
    //   51: aload 4
    //   53: invokeinterface 100 1 0
    //   58: invokeinterface 106 1 0
    //   63: astore 6
    //   65: aload 6
    //   67: invokeinterface 112 1 0
    //   72: ifeq +52 -> 124
    //   75: aload 6
    //   77: invokeinterface 115 1 0
    //   82: checkcast 117	java/util/Map$Entry
    //   85: astore 18
    //   87: aload 5
    //   89: aload 18
    //   91: invokeinterface 120 1 0
    //   96: checkcast 122	java/lang/String
    //   99: aload 18
    //   101: invokeinterface 125 1 0
    //   106: checkcast 122	java/lang/String
    //   109: invokevirtual 131	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   112: pop
    //   113: goto -48 -> 65
    //   116: astore_1
    //   117: ldc 133
    //   119: aload_1
    //   120: invokestatic 139	com/google/android/gms/internal/ads/zzaxa:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   123: return
    //   124: new 141	java/lang/StringBuilder
    //   127: dup
    //   128: aload 5
    //   130: invokevirtual 145	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   133: invokevirtual 148	android/net/Uri:toString	()Ljava/lang/String;
    //   136: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: astore 7
    //   141: aload 7
    //   143: ldc 153
    //   145: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_3
    //   149: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 7
    //   155: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: astore 9
    //   160: aload_0
    //   161: getfield 160	com/google/android/gms/internal/ads/zzacx:zzcxh	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   164: invokevirtual 165	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   167: ifeq +138 -> 305
    //   170: aload_0
    //   171: getfield 167	com/google/android/gms/internal/ads/zzacx:file	Ljava/io/File;
    //   174: astore 11
    //   176: aload 11
    //   178: ifnull +119 -> 297
    //   181: new 169	java/io/FileOutputStream
    //   184: dup
    //   185: aload 11
    //   187: iconst_1
    //   188: invokespecial 172	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   191: astore 12
    //   193: aload 12
    //   195: aload 9
    //   197: invokevirtual 176	java/lang/String:getBytes	()[B
    //   200: invokevirtual 180	java/io/FileOutputStream:write	([B)V
    //   203: aload 12
    //   205: bipush 10
    //   207: invokevirtual 182	java/io/FileOutputStream:write	(I)V
    //   210: aload 12
    //   212: invokevirtual 185	java/io/FileOutputStream:close	()V
    //   215: goto -215 -> 0
    //   218: astore 17
    //   220: ldc 187
    //   222: aload 17
    //   224: invokestatic 139	com/google/android/gms/internal/ads/zzaxa:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   227: goto -227 -> 0
    //   230: astore 13
    //   232: aconst_null
    //   233: astore 12
    //   235: ldc 189
    //   237: aload 13
    //   239: invokestatic 139	com/google/android/gms/internal/ads/zzaxa:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   242: aload 12
    //   244: ifnull -244 -> 0
    //   247: aload 12
    //   249: invokevirtual 185	java/io/FileOutputStream:close	()V
    //   252: goto -252 -> 0
    //   255: astore 16
    //   257: ldc 187
    //   259: aload 16
    //   261: invokestatic 139	com/google/android/gms/internal/ads/zzaxa:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   264: goto -264 -> 0
    //   267: astore 14
    //   269: aconst_null
    //   270: astore 12
    //   272: aload 12
    //   274: ifnull +8 -> 282
    //   277: aload 12
    //   279: invokevirtual 185	java/io/FileOutputStream:close	()V
    //   282: aload 14
    //   284: athrow
    //   285: astore 15
    //   287: ldc 187
    //   289: aload 15
    //   291: invokestatic 139	com/google/android/gms/internal/ads/zzaxa:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   294: goto -12 -> 282
    //   297: ldc 191
    //   299: invokestatic 194	com/google/android/gms/internal/ads/zzaxa:zzep	(Ljava/lang/String;)V
    //   302: goto -302 -> 0
    //   305: invokestatic 200	com/google/android/gms/ads/internal/zzk:zzlg	()Lcom/google/android/gms/internal/ads/zzaxj;
    //   308: pop
    //   309: aload_0
    //   310: getfield 202	com/google/android/gms/internal/ads/zzacx:mContext	Landroid/content/Context;
    //   313: aload_0
    //   314: getfield 204	com/google/android/gms/internal/ads/zzacx:zzcxg	Ljava/lang/String;
    //   317: aload 9
    //   319: invokestatic 210	com/google/android/gms/internal/ads/zzaxj:zzb	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   322: goto -322 -> 0
    //   325: astore 14
    //   327: goto -55 -> 272
    //   330: astore 13
    //   332: goto -97 -> 235
    //
    // Exception table:
    //   from	to	target	type
    //   0	18	116	java/lang/InterruptedException
    //   210	215	218	java/io/IOException
    //   181	193	230	java/io/IOException
    //   247	252	255	java/io/IOException
    //   181	193	267	finally
    //   277	282	285	java/io/IOException
    //   193	210	325	finally
    //   235	242	325	finally
    //   193	210	330	java/io/IOException
  }

  final Map<String, String> zza(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(paramMap1);
    if (paramMap2 == null)
      return localLinkedHashMap;
    Iterator localIterator = paramMap2.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str1 = (String)localEntry.getKey();
      String str2 = (String)localEntry.getValue();
      String str3 = (String)localLinkedHashMap.get(str1);
      localLinkedHashMap.put(str1, zzch(str1).zzg(str3, str2));
    }
    return localLinkedHashMap;
  }

  public final void zza(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    this.mContext = paramContext;
    this.zzcxg = paramString1;
    this.zzcxf = paramString2;
    this.zzcxh = new AtomicBoolean(false);
    AtomicBoolean localAtomicBoolean = this.zzcxh;
    zzaci localzzaci = zzact.zzcna;
    localAtomicBoolean.set(((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue());
    if (this.zzcxh.get())
    {
      File localFile = Environment.getExternalStorageDirectory();
      if (localFile != null)
        this.file = new File(localFile, "sdk_csi_data.txt");
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.zzcxd.put((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    this.zzcxc = Executors.newSingleThreadExecutor();
    this.zzcxc.execute(new zzacy(this));
    this.zzcxe.put("action", zzadb.zzcxk);
    this.zzcxe.put("ad_format", zzadb.zzcxk);
    this.zzcxe.put("e", zzadb.zzcxl);
  }

  public final boolean zza(zzadh paramzzadh)
  {
    return this.zzcxb.offer(paramzzadh);
  }

  public final zzadb zzch(String paramString)
  {
    zzadb localzzadb = (zzadb)this.zzcxe.get(paramString);
    if (localzzadb != null)
      return localzzadb;
    return zzadb.zzcxj;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzacx
 * JD-Core Version:    0.6.2
 */
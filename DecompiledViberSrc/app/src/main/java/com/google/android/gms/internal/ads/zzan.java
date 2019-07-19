package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class zzan
  implements zzb
{
  private final Map<String, zzao> zzbx = new LinkedHashMap(16, 0.75F, true);
  private long zzby = 0L;
  private final File zzbz;
  private final int zzca;

  public zzan(File paramFile)
  {
    this(paramFile, 5242880);
  }

  public zzan(File paramFile, int paramInt)
  {
    this.zzbz = paramFile;
    this.zzca = paramInt;
  }

  private final void remove(String paramString)
  {
    try
    {
      boolean bool = zze(paramString).delete();
      removeEntry(paramString);
      if (!bool)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramString;
        arrayOfObject[1] = zzd(paramString);
        zzag.d("Could not delete cache entry for key=%s, filename=%s", arrayOfObject);
      }
      return;
    }
    finally
    {
    }
  }

  private final void removeEntry(String paramString)
  {
    zzao localzzao = (zzao)this.zzbx.remove(paramString);
    if (localzzao != null)
      this.zzby -= localzzao.zzcb;
  }

  private static int zza(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    if (i == -1)
      throw new EOFException();
    return i;
  }

  private static InputStream zza(File paramFile)
    throws FileNotFoundException
  {
    return new FileInputStream(paramFile);
  }

  static String zza(zzap paramzzap)
    throws IOException
  {
    return new String(zza(paramzzap, zzc(paramzzap)), "UTF-8");
  }

  static void zza(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    paramOutputStream.write(paramInt & 0xFF);
    paramOutputStream.write(0xFF & paramInt >> 8);
    paramOutputStream.write(0xFF & paramInt >> 16);
    paramOutputStream.write(paramInt >>> 24);
  }

  static void zza(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    paramOutputStream.write((byte)(int)paramLong);
    paramOutputStream.write((byte)(int)(paramLong >>> 8));
    paramOutputStream.write((byte)(int)(paramLong >>> 16));
    paramOutputStream.write((byte)(int)(paramLong >>> 24));
    paramOutputStream.write((byte)(int)(paramLong >>> 32));
    paramOutputStream.write((byte)(int)(paramLong >>> 40));
    paramOutputStream.write((byte)(int)(paramLong >>> 48));
    paramOutputStream.write((byte)(int)(paramLong >>> 56));
  }

  static void zza(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    zza(paramOutputStream, arrayOfByte.length);
    paramOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
  }

  private final void zza(String paramString, zzao paramzzao)
  {
    if (!this.zzbx.containsKey(paramString));
    zzao localzzao;
    for (this.zzby += paramzzao.zzcb; ; this.zzby += paramzzao.zzcb - localzzao.zzcb)
    {
      this.zzbx.put(paramString, paramzzao);
      return;
      localzzao = (zzao)this.zzbx.get(paramString);
    }
  }

  private static byte[] zza(zzap paramzzap, long paramLong)
    throws IOException
  {
    long l = paramzzap.zzo();
    if ((paramLong < 0L) || (paramLong > l) || ((int)paramLong != paramLong))
      throw new IOException(73 + "streamToBytes length=" + paramLong + ", maxLength=" + l);
    byte[] arrayOfByte = new byte[(int)paramLong];
    new DataInputStream(paramzzap).readFully(arrayOfByte);
    return arrayOfByte;
  }

  static int zzb(InputStream paramInputStream)
    throws IOException
  {
    return 0x0 | zza(paramInputStream) | zza(paramInputStream) << 8 | zza(paramInputStream) << 16 | zza(paramInputStream) << 24;
  }

  static List<zzl> zzb(zzap paramzzap)
    throws IOException
  {
    int i = zzb(paramzzap);
    if (i < 0)
      throw new IOException(31 + "readHeaderList size=" + i);
    if (i == 0);
    for (Object localObject = Collections.emptyList(); ; localObject = new ArrayList())
      for (int j = 0; j < i; j++)
        ((List)localObject).add(new zzl(zza(paramzzap).intern(), zza(paramzzap).intern()));
    return localObject;
  }

  static long zzc(InputStream paramInputStream)
    throws IOException
  {
    return 0L | 0xFF & zza(paramInputStream) | (0xFF & zza(paramInputStream)) << 8 | (0xFF & zza(paramInputStream)) << 16 | (0xFF & zza(paramInputStream)) << 24 | (0xFF & zza(paramInputStream)) << 32 | (0xFF & zza(paramInputStream)) << 40 | (0xFF & zza(paramInputStream)) << 48 | (0xFF & zza(paramInputStream)) << 56;
  }

  private static String zzd(String paramString)
  {
    int i = paramString.length() / 2;
    String str1 = String.valueOf(String.valueOf(paramString.substring(0, i).hashCode()));
    String str2 = String.valueOf(String.valueOf(paramString.substring(i).hashCode()));
    if (str2.length() != 0)
      return str1.concat(str2);
    return new String(str1);
  }

  private final File zze(String paramString)
  {
    return new File(this.zzbz, zzd(paramString));
  }

  public final zzc zza(String paramString)
  {
    try
    {
      zzao localzzao1 = (zzao)this.zzbx.get(paramString);
      Object localObject3;
      if (localzzao1 == null)
        localObject3 = null;
      while (true)
      {
        return localObject3;
        File localFile = zze(paramString);
        zzap localzzap;
        zzc localzzc;
        TreeMap localTreeMap;
        try
        {
          localzzap = new zzap(new BufferedInputStream(zza(localFile)), localFile.length());
          try
          {
            zzao localzzao2 = zzao.zzc(localzzap);
            if (!TextUtils.equals(paramString, localzzao2.zzcc))
            {
              Object[] arrayOfObject2 = new Object[3];
              arrayOfObject2[0] = localFile.getAbsolutePath();
              arrayOfObject2[1] = paramString;
              arrayOfObject2[2] = localzzao2.zzcc;
              zzag.d("%s: key=%s, found=%s", arrayOfObject2);
              removeEntry(paramString);
              localzzap.close();
              localObject3 = null;
              continue;
            }
            byte[] arrayOfByte = zza(localzzap, localzzap.zzo());
            localzzc = new zzc();
            localzzc.data = arrayOfByte;
            localzzc.zza = localzzao1.zza;
            localzzc.zzb = localzzao1.zzb;
            localzzc.zzc = localzzao1.zzc;
            localzzc.zzd = localzzao1.zzd;
            localzzc.zze = localzzao1.zze;
            List localList = localzzao1.zzg;
            localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Iterator localIterator = localList.iterator();
            while (localIterator.hasNext())
            {
              zzl localzzl = (zzl)localIterator.next();
              localTreeMap.put(localzzl.getName(), localzzl.getValue());
            }
          }
          finally
          {
            localzzap.close();
          }
        }
        catch (IOException localIOException)
        {
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = localFile.getAbsolutePath();
          arrayOfObject1[1] = localIOException.toString();
          zzag.d("%s: %s", arrayOfObject1);
          remove(paramString);
          localObject3 = null;
        }
        continue;
        localzzc.zzf = localTreeMap;
        localzzc.zzg = Collections.unmodifiableList(localzzao1.zzg);
        localzzap.close();
        localObject3 = localzzc;
      }
    }
    finally
    {
    }
  }

  // ERROR //
  public final void zza()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/google/android/gms/internal/ads/zzan:zzbz	Ljava/io/File;
    //   6: invokevirtual 341	java/io/File:exists	()Z
    //   9: ifne +41 -> 50
    //   12: aload_0
    //   13: getfield 36	com/google/android/gms/internal/ads/zzan:zzbz	Ljava/io/File;
    //   16: invokevirtual 344	java/io/File:mkdirs	()Z
    //   19: ifne +28 -> 47
    //   22: iconst_1
    //   23: anewarray 4	java/lang/Object
    //   26: astore 13
    //   28: aload 13
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 36	com/google/android/gms/internal/ads/zzan:zzbz	Ljava/io/File;
    //   35: invokevirtual 266	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   38: aastore
    //   39: ldc_w 346
    //   42: aload 13
    //   44: invokestatic 349	com/google/android/gms/internal/ads/zzag:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: getfield 36	com/google/android/gms/internal/ads/zzan:zzbz	Ljava/io/File;
    //   54: invokevirtual 353	java/io/File:listFiles	()[Ljava/io/File;
    //   57: astore_2
    //   58: aload_2
    //   59: ifnull -12 -> 47
    //   62: aload_2
    //   63: arraylength
    //   64: istore_3
    //   65: iconst_0
    //   66: istore 4
    //   68: iload 4
    //   70: iload_3
    //   71: if_icmpge -24 -> 47
    //   74: aload_2
    //   75: iload 4
    //   77: aaload
    //   78: astore 5
    //   80: aload 5
    //   82: invokevirtual 247	java/io/File:length	()J
    //   85: lstore 8
    //   87: new 142	com/google/android/gms/internal/ads/zzap
    //   90: dup
    //   91: new 242	java/io/BufferedInputStream
    //   94: dup
    //   95: aload 5
    //   97: invokestatic 244	com/google/android/gms/internal/ads/zzan:zza	(Ljava/io/File;)Ljava/io/InputStream;
    //   100: invokespecial 245	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   103: lload 8
    //   105: invokespecial 250	com/google/android/gms/internal/ads/zzap:<init>	(Ljava/io/InputStream;J)V
    //   108: astore 10
    //   110: aload 10
    //   112: invokestatic 253	com/google/android/gms/internal/ads/zzao:zzc	(Lcom/google/android/gms/internal/ads/zzap;)Lcom/google/android/gms/internal/ads/zzao;
    //   115: astore 12
    //   117: aload 12
    //   119: lload 8
    //   121: putfield 75	com/google/android/gms/internal/ads/zzao:zzcb	J
    //   124: aload_0
    //   125: aload 12
    //   127: getfield 257	com/google/android/gms/internal/ads/zzao:zzcc	Ljava/lang/String;
    //   130: aload 12
    //   132: invokespecial 355	com/google/android/gms/internal/ads/zzan:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/ads/zzao;)V
    //   135: aload 10
    //   137: invokevirtual 271	com/google/android/gms/internal/ads/zzap:close	()V
    //   140: goto +29 -> 169
    //   143: astore 11
    //   145: aload 10
    //   147: invokevirtual 271	com/google/android/gms/internal/ads/zzap:close	()V
    //   150: aload 11
    //   152: athrow
    //   153: astore 6
    //   155: aload 5
    //   157: invokevirtual 50	java/io/File:delete	()Z
    //   160: pop
    //   161: goto +8 -> 169
    //   164: astore_1
    //   165: aload_0
    //   166: monitorexit
    //   167: aload_1
    //   168: athrow
    //   169: iinc 4 1
    //   172: goto -104 -> 68
    //
    // Exception table:
    //   from	to	target	type
    //   110	135	143	finally
    //   80	110	153	java/io/IOException
    //   135	140	153	java/io/IOException
    //   145	153	153	java/io/IOException
    //   2	47	164	finally
    //   50	58	164	finally
    //   62	65	164	finally
    //   74	80	164	finally
    //   80	110	164	finally
    //   135	140	164	finally
    //   145	153	164	finally
    //   155	161	164	finally
  }

  public final void zza(String paramString, zzc paramzzc)
  {
    int i = 0;
    label179: label325: label461: 
    while (true)
    {
      File localFile;
      BufferedOutputStream localBufferedOutputStream;
      zzao localzzao1;
      try
      {
        if (this.zzby + paramzzc.data.length > this.zzca)
        {
          float f = paramzzc.data.length;
          int k = this.zzca;
          if (f > 0.9F * k)
            return;
        }
        localFile = zze(paramString);
        try
        {
          localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(localFile));
          localzzao1 = new zzao(paramString, paramzzc);
          if (localzzao1.zza(localBufferedOutputStream))
            break label179;
          localBufferedOutputStream.close();
          Object[] arrayOfObject4 = new Object[1];
          arrayOfObject4[0] = localFile.getAbsolutePath();
          zzag.d("Failed to write header for %s", arrayOfObject4);
          throw new IOException();
        }
        catch (IOException localIOException)
        {
        }
        if (localFile.delete())
          continue;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = localFile.getAbsolutePath();
        zzag.d("Could not clean up file %s", arrayOfObject1);
        continue;
      }
      finally
      {
      }
      localBufferedOutputStream.write(paramzzc.data);
      localBufferedOutputStream.close();
      localzzao1.zzcb = localFile.length();
      zza(paramString, localzzao1);
      if (this.zzby >= this.zzca)
      {
        if (zzag.DEBUG)
          zzag.v("Pruning old cache entries.", new Object[0]);
        long l1 = this.zzby;
        long l2 = SystemClock.elapsedRealtime();
        Iterator localIterator = this.zzbx.entrySet().iterator();
        zzao localzzao2;
        int j;
        if (localIterator.hasNext())
        {
          localzzao2 = (zzao)((Map.Entry)localIterator.next()).getValue();
          if (zze(localzzao2.zzcc).delete())
          {
            this.zzby -= localzzao2.zzcb;
            localIterator.remove();
            j = i + 1;
            if ((float)this.zzby >= 0.9F * this.zzca)
              break label451;
          }
        }
        while (true)
        {
          if (!zzag.DEBUG)
            break label461;
          Object[] arrayOfObject2 = new Object[3];
          arrayOfObject2[0] = Integer.valueOf(j);
          arrayOfObject2[1] = Long.valueOf(this.zzby - l1);
          arrayOfObject2[2] = Long.valueOf(SystemClock.elapsedRealtime() - l2);
          zzag.v("pruned %d files, %d bytes, %d ms", arrayOfObject2);
          break;
          Object[] arrayOfObject3 = new Object[2];
          arrayOfObject3[0] = localzzao2.zzcc;
          arrayOfObject3[1] = zzd(localzzao2.zzcc);
          zzag.d("Could not delete cache entry for key=%s, filename=%s", arrayOfObject3);
          break label325;
          i = j;
          break label266;
          j = i;
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzan
 * JD-Core Version:    0.6.2
 */
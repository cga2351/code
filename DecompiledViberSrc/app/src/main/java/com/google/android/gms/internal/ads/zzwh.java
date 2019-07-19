package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

@zzare
public final class zzwh
{
  private final zzwm zzbxl;

  @GuardedBy("this")
  private final zzxl zzbxm;
  private final boolean zzbxn;

  private zzwh()
  {
    this.zzbxn = false;
    this.zzbxl = new zzwm();
    this.zzbxm = new zzxl();
    zznm();
  }

  public zzwh(zzwm paramzzwm)
  {
    this.zzbxl = paramzzwm;
    zzaci localzzaci = zzact.zzcum;
    this.zzbxn = ((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue();
    this.zzbxm = new zzxl();
    zznm();
  }

  private final void zzb(zzwj.zza.zzb paramzzb)
  {
    try
    {
      this.zzbxm.zzcfi = zznn();
      this.zzbxl.zzg(zzdrv.zza(this.zzbxm)).zzby(paramzzb.zzac()).zzdj();
      String str1 = String.valueOf(Integer.toString(paramzzb.zzac(), 10));
      if (str1.length() != 0);
      for (String str2 = "Logging Event with event code : ".concat(str1); ; str2 = new String("Logging Event with event code : "))
      {
        zzaxa.zzds(str2);
        return;
      }
    }
    finally
    {
    }
  }

  // ERROR //
  private final void zzc(zzwj.zza.zzb paramzzb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 133	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   5: astore_3
    //   6: aload_3
    //   7: ifnonnull +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: new 135	java/io/File
    //   16: dup
    //   17: aload_3
    //   18: ldc 137
    //   20: invokespecial 140	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore 4
    //   25: new 142	java/io/FileOutputStream
    //   28: dup
    //   29: aload 4
    //   31: iconst_1
    //   32: invokespecial 145	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   35: astore 5
    //   37: aload 5
    //   39: aload_0
    //   40: aload_1
    //   41: invokespecial 148	com/google/android/gms/internal/ads/zzwh:zzd	(Lcom/google/android/gms/internal/ads/zzwj$zza$zzb;)Ljava/lang/String;
    //   44: invokevirtual 152	java/lang/String:getBytes	()[B
    //   47: invokevirtual 156	java/io/FileOutputStream:write	([B)V
    //   50: aload 5
    //   52: invokevirtual 159	java/io/FileOutputStream:close	()V
    //   55: goto -45 -> 10
    //   58: astore 11
    //   60: ldc 161
    //   62: invokestatic 120	com/google/android/gms/internal/ads/zzaxa:zzds	(Ljava/lang/String;)V
    //   65: goto -55 -> 10
    //   68: astore 8
    //   70: ldc 163
    //   72: invokestatic 120	com/google/android/gms/internal/ads/zzaxa:zzds	(Ljava/lang/String;)V
    //   75: goto -65 -> 10
    //   78: astore_2
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_2
    //   82: athrow
    //   83: astore 9
    //   85: ldc 165
    //   87: invokestatic 120	com/google/android/gms/internal/ads/zzaxa:zzds	(Ljava/lang/String;)V
    //   90: aload 5
    //   92: invokevirtual 159	java/io/FileOutputStream:close	()V
    //   95: goto -85 -> 10
    //   98: astore 10
    //   100: ldc 161
    //   102: invokestatic 120	com/google/android/gms/internal/ads/zzaxa:zzds	(Ljava/lang/String;)V
    //   105: goto -95 -> 10
    //   108: astore 6
    //   110: aload 5
    //   112: invokevirtual 159	java/io/FileOutputStream:close	()V
    //   115: aload 6
    //   117: athrow
    //   118: astore 7
    //   120: ldc 161
    //   122: invokestatic 120	com/google/android/gms/internal/ads/zzaxa:zzds	(Ljava/lang/String;)V
    //   125: goto -10 -> 115
    //
    // Exception table:
    //   from	to	target	type
    //   50	55	58	java/io/IOException
    //   25	37	68	java/io/FileNotFoundException
    //   50	55	68	java/io/FileNotFoundException
    //   60	65	68	java/io/FileNotFoundException
    //   90	95	68	java/io/FileNotFoundException
    //   100	105	68	java/io/FileNotFoundException
    //   110	115	68	java/io/FileNotFoundException
    //   115	118	68	java/io/FileNotFoundException
    //   120	125	68	java/io/FileNotFoundException
    //   2	6	78	finally
    //   13	25	78	finally
    //   25	37	78	finally
    //   50	55	78	finally
    //   60	65	78	finally
    //   70	75	78	finally
    //   90	95	78	finally
    //   100	105	78	finally
    //   110	115	78	finally
    //   115	118	78	finally
    //   120	125	78	finally
    //   37	50	83	java/io/IOException
    //   90	95	98	java/io/IOException
    //   37	50	108	finally
    //   85	90	108	finally
    //   110	115	118	java/io/IOException
  }

  private final String zzd(zzwj.zza.zzb paramzzb)
  {
    try
    {
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = this.zzbxm.zzcfe;
      arrayOfObject[1] = Long.valueOf(zzk.zzln().elapsedRealtime());
      arrayOfObject[2] = Integer.valueOf(paramzzb.zzac());
      arrayOfObject[3] = Base64.encodeToString(zzdrv.zza(this.zzbxm), 3);
      String str = String.format("id=%s,timestamp=%s,event=%s,data=%s\n", arrayOfObject);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static zzwh zznl()
  {
    return new zzwh();
  }

  private final void zznm()
  {
    try
    {
      this.zzbxm.zzcfm = new zzxh();
      this.zzbxm.zzcfm.zzcei = new zzxi();
      this.zzbxm.zzcfj = new zzxj();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static long[] zznn()
  {
    int i = 0;
    List localList = zzact.zzqo();
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = localList.iterator();
    if (localIterator.hasNext())
    {
      String[] arrayOfString = ((String)localIterator.next()).split(",");
      int m = arrayOfString.length;
      int n = 0;
      while (n < m)
      {
        String str = arrayOfString[n];
        try
        {
          localArrayList1.add(Long.valueOf(str));
          n++;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          while (true)
            zzaxa.zzds("Experiment ID is not a number");
        }
      }
    }
    long[] arrayOfLong = new long[localArrayList1.size()];
    ArrayList localArrayList2 = (ArrayList)localArrayList1;
    int j = localArrayList2.size();
    for (int k = 0; i < j; k++)
    {
      Object localObject = localArrayList2.get(i);
      i++;
      arrayOfLong[k] = ((Long)localObject).longValue();
    }
    return arrayOfLong;
  }

  public final void zza(zzwi paramzzwi)
  {
    try
    {
      boolean bool = this.zzbxn;
      if (bool);
      try
      {
        paramzzwi.zza(this.zzbxm);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        while (true)
          zzk.zzlk().zza(localNullPointerException, "AdMobClearcutLogger.modify");
      }
    }
    finally
    {
    }
  }

  public final void zza(zzwj.zza.zzb paramzzb)
  {
    while (true)
    {
      try
      {
        boolean bool = this.zzbxn;
        if (!bool)
          return;
        zzaci localzzaci = zzact.zzcun;
        if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
        {
          zzc(paramzzb);
          continue;
        }
      }
      finally
      {
      }
      zzb(paramzzb);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzwh
 * JD-Core Version:    0.6.2
 */
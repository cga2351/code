package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzak
{
  private SharedPreferences zzde;
  private final zzn zzdf;
  private final Map<String, zzo> zzdg = new ArrayMap();
  private Context zzl;

  public zzak(Context paramContext)
  {
    this(paramContext, new zzn());
  }

  @VisibleForTesting
  private zzak(Context paramContext, zzn paramzzn)
  {
    this.zzl = paramContext;
    this.zzde = paramContext.getSharedPreferences("com.google.android.gms.appid", 0);
    this.zzdf = paramzzn;
    File localFile = new File(ContextCompat.getNoBackupFilesDir(this.zzl), "com.google.android.gms.appid-no-backup");
    if (!localFile.exists());
    String str1;
    try
    {
      if ((localFile.createNewFile()) && (!isEmpty()))
      {
        Log.i("InstanceID/Store", "App restored, clearing state");
        InstanceIDListenerService.zzd(this.zzl, this);
      }
      return;
    }
    catch (IOException localIOException)
    {
      while (!Log.isLoggable("InstanceID/Store", 3));
      str1 = String.valueOf(localIOException.getMessage());
      if (str1.length() == 0);
    }
    for (String str2 = "Error creating file in no backup dir: ".concat(str1); ; str2 = new String("Error creating file in no backup dir: "))
    {
      Log.d("InstanceID/Store", str2);
      return;
    }
  }

  private static String zzd(String paramString1, String paramString2, String paramString3)
  {
    return 4 + String.valueOf(paramString1).length() + String.valueOf(paramString2).length() + String.valueOf(paramString3).length() + paramString1 + "|T|" + paramString2 + "|" + paramString3;
  }

  private static String zze(String paramString1, String paramString2, String paramString3)
  {
    return 14 + String.valueOf(paramString1).length() + String.valueOf(paramString2).length() + String.valueOf(paramString3).length() + paramString1 + "|T-timestamp|" + paramString2 + "|" + paramString3;
  }

  static String zzh(String paramString1, String paramString2)
  {
    return 3 + String.valueOf(paramString1).length() + String.valueOf(paramString2).length() + paramString1 + "|S|" + paramString2;
  }

  final String get(String paramString)
  {
    try
    {
      String str = this.zzde.getString(paramString, null);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final boolean isEmpty()
  {
    return this.zzde.getAll().isEmpty();
  }

  public final void zzd(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      String str1 = zzd(paramString1, paramString2, paramString3);
      String str2 = zze(paramString1, paramString2, paramString3);
      SharedPreferences.Editor localEditor = this.zzde.edit();
      localEditor.putString(str1, paramString4);
      localEditor.putLong(str2, System.currentTimeMillis());
      localEditor.putString("appVersion", paramString5);
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final String zzf(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      String str1 = zzd(paramString1, paramString2, paramString3);
      String str2 = this.zzde.getString(str1, null);
      return str2;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  final long zzg(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      String str = zze(paramString1, paramString2, paramString3);
      long l = this.zzde.getLong(str, -1L);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzh(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.zzde.edit();
      localEditor.remove(zzd(paramString1, paramString2, paramString3));
      localEditor.remove(zze(paramString1, paramString2, paramString3));
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzi(String paramString)
  {
    SharedPreferences.Editor localEditor;
    try
    {
      localEditor = this.zzde.edit();
      Iterator localIterator = this.zzde.getAll().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.startsWith(paramString))
          localEditor.remove(str);
      }
    }
    finally
    {
    }
    localEditor.commit();
  }

  // ERROR //
  public final zzo zzj(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/google/android/gms/iid/zzak:zzdg	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 227 2 0
    //   12: checkcast 229	com/google/android/gms/iid/zzo
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull +7 -> 24
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_3
    //   23: areturn
    //   24: aload_0
    //   25: getfield 46	com/google/android/gms/iid/zzak:zzdf	Lcom/google/android/gms/iid/zzn;
    //   28: aload_0
    //   29: getfield 34	com/google/android/gms/iid/zzak:zzl	Landroid/content/Context;
    //   32: aload_1
    //   33: invokevirtual 232	com/google/android/gms/iid/zzn:zze	(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gms/iid/zzo;
    //   36: astore 8
    //   38: aload 8
    //   40: astore_3
    //   41: aload_0
    //   42: getfield 32	com/google/android/gms/iid/zzak:zzdg	Ljava/util/Map;
    //   45: aload_1
    //   46: aload_3
    //   47: invokeinterface 236 3 0
    //   52: pop
    //   53: goto -33 -> 20
    //   56: astore_2
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_2
    //   60: athrow
    //   61: astore 4
    //   63: ldc 71
    //   65: ldc 238
    //   67: invokestatic 241	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   70: pop
    //   71: aload_0
    //   72: getfield 34	com/google/android/gms/iid/zzak:zzl	Landroid/content/Context;
    //   75: aload_0
    //   76: invokestatic 85	com/google/android/gms/iid/InstanceIDListenerService:zzd	(Landroid/content/Context;Lcom/google/android/gms/iid/zzak;)V
    //   79: aload_0
    //   80: getfield 46	com/google/android/gms/iid/zzak:zzdf	Lcom/google/android/gms/iid/zzn;
    //   83: aload_0
    //   84: getfield 34	com/google/android/gms/iid/zzak:zzl	Landroid/content/Context;
    //   87: aload_1
    //   88: invokevirtual 243	com/google/android/gms/iid/zzn:zzf	(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gms/iid/zzo;
    //   91: astore 6
    //   93: aload 6
    //   95: astore_3
    //   96: goto -55 -> 41
    //
    // Exception table:
    //   from	to	target	type
    //   2	16	56	finally
    //   24	38	56	finally
    //   41	53	56	finally
    //   63	93	56	finally
    //   24	38	61	com/google/android/gms/iid/zzp
  }

  final void zzk(String paramString)
  {
    try
    {
      this.zzdg.remove(paramString);
      zzn.zzg(this.zzl, paramString);
      zzi(String.valueOf(paramString).concat("|"));
      return;
    }
    finally
    {
    }
  }

  public final void zzz()
  {
    try
    {
      this.zzdg.clear();
      zzn.zzi(this.zzl);
      this.zzde.edit().clear().commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.zzak
 * JD-Core Version:    0.6.2
 */
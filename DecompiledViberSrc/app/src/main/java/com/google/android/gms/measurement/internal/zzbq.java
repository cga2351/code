package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzfk;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzxz;
import com.google.android.gms.internal.measurement.zzya;
import com.google.android.gms.internal.measurement.zzyi;
import java.io.IOException;
import java.util.Map;

public final class zzbq extends zzfm
  implements zzs
{

  @VisibleForTesting
  private static int zzaol = 65535;

  @VisibleForTesting
  private static int zzaom = 2;
  private final Map<String, Map<String, String>> zzaon = new ArrayMap();
  private final Map<String, Map<String, Boolean>> zzaoo = new ArrayMap();
  private final Map<String, Map<String, Boolean>> zzaop = new ArrayMap();
  private final Map<String, zzfp> zzaoq = new ArrayMap();
  private final Map<String, Map<String, Integer>> zzaor = new ArrayMap();
  private final Map<String, String> zzaos = new ArrayMap();

  zzbq(zzfn paramzzfn)
  {
    super(paramzzfn);
  }

  private final zzfp zza(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return new zzfp();
    zzxz localzzxz = zzxz.zzj(paramArrayOfByte, 0, paramArrayOfByte.length);
    zzfp localzzfp = new zzfp();
    try
    {
      localzzfp.zza(localzzxz);
      zzgt().zzjo().zze("Parsed config. version, gmp_app_id", localzzfp.zzawm, localzzfp.zzafi);
      return localzzfp;
    }
    catch (IOException localIOException)
    {
      zzgt().zzjj().zze("Unable to merge remote config. appId", zzas.zzbw(paramString), localIOException);
    }
    return new zzfp();
  }

  private static Map<String, String> zza(zzfp paramzzfp)
  {
    ArrayMap localArrayMap = new ArrayMap();
    if ((paramzzfp != null) && (paramzzfp.zzawo != null))
      for (zzfq localzzfq : paramzzfp.zzawo)
        if (localzzfq != null)
          localArrayMap.put(localzzfq.zzoj, localzzfq.value);
    return localArrayMap;
  }

  private final void zza(String paramString, zzfp paramzzfp)
  {
    ArrayMap localArrayMap1 = new ArrayMap();
    ArrayMap localArrayMap2 = new ArrayMap();
    ArrayMap localArrayMap3 = new ArrayMap();
    if ((paramzzfp != null) && (paramzzfp.zzawp != null))
    {
      zzfo[] arrayOfzzfo = paramzzfp.zzawp;
      int i = arrayOfzzfo.length;
      int j = 0;
      if (j < i)
      {
        zzfo localzzfo = arrayOfzzfo[j];
        if (TextUtils.isEmpty(localzzfo.name))
          zzgt().zzjj().zzby("EventConfig contained null event name");
        while (true)
        {
          j++;
          break;
          String str = zzcu.zzco(localzzfo.name);
          if (!TextUtils.isEmpty(str))
            localzzfo.name = str;
          localArrayMap1.put(localzzfo.name, localzzfo.zzawj);
          localArrayMap2.put(localzzfo.name, localzzfo.zzawk);
          if (localzzfo.zzawl != null)
            if ((localzzfo.zzawl.intValue() < zzaom) || (localzzfo.zzawl.intValue() > zzaol))
              zzgt().zzjj().zze("Invalid sampling rate. Event name, sample rate", localzzfo.name, localzzfo.zzawl);
            else
              localArrayMap3.put(localzzfo.name, localzzfo.zzawl);
        }
      }
    }
    this.zzaoo.put(paramString, localArrayMap1);
    this.zzaop.put(paramString, localArrayMap2);
    this.zzaor.put(paramString, localArrayMap3);
  }

  private final void zzcf(String paramString)
  {
    zzcl();
    zzaf();
    Preconditions.checkNotEmpty(paramString);
    byte[] arrayOfByte;
    if (this.zzaoq.get(paramString) == null)
    {
      arrayOfByte = zzjt().zzbo(paramString);
      if (arrayOfByte == null)
      {
        this.zzaon.put(paramString, null);
        this.zzaoo.put(paramString, null);
        this.zzaop.put(paramString, null);
        this.zzaoq.put(paramString, null);
        this.zzaos.put(paramString, null);
        this.zzaor.put(paramString, null);
      }
    }
    else
    {
      return;
    }
    zzfp localzzfp = zza(paramString, arrayOfByte);
    this.zzaon.put(paramString, zza(localzzfp));
    zza(paramString, localzzfp);
    this.zzaoq.put(paramString, localzzfp);
    this.zzaos.put(paramString, null);
  }

  protected final boolean zza(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    zzcl();
    zzaf();
    Preconditions.checkNotEmpty(paramString1);
    zzfp localzzfp = zza(paramString1, paramArrayOfByte);
    if (localzzfp == null)
      return false;
    zza(paramString1, localzzfp);
    this.zzaoq.put(paramString1, localzzfp);
    this.zzaos.put(paramString1, paramString2);
    this.zzaon.put(paramString1, zza(localzzfp));
    zzm localzzm = zzjs();
    zzfi[] arrayOfzzfi = localzzfp.zzawq;
    Preconditions.checkNotNull(arrayOfzzfi);
    int i = arrayOfzzfi.length;
    for (int j = 0; j < i; j++)
    {
      zzfi localzzfi = arrayOfzzfi[j];
      for (zzfj localzzfj : localzzfi.zzavi)
      {
        String str2 = zzcu.zzco(localzzfj.zzavn);
        if (str2 != null)
          localzzfj.zzavn = str2;
        for (zzfk localzzfk : localzzfj.zzavo)
        {
          String str3 = zzcv.zzco(localzzfk.zzavv);
          if (str3 != null)
            localzzfk.zzavv = str3;
        }
      }
      for (com.google.android.gms.internal.measurement.zzfm localzzfm : localzzfi.zzavh)
      {
        String str1 = zzcw.zzco(localzzfm.zzawc);
        if (str1 != null)
          localzzfm.zzawc = str1;
      }
    }
    localzzm.zzjt().zza(paramString1, arrayOfzzfi);
    try
    {
      localzzfp.zzawq = null;
      byte[] arrayOfByte = new byte[localzzfp.zzvx()];
      localzzfp.zza(zzya.zzk(arrayOfByte, 0, arrayOfByte.length));
      paramArrayOfByte = arrayOfByte;
      localzzt = zzjt();
      Preconditions.checkNotEmpty(paramString1);
      localzzt.zzaf();
      localzzt.zzcl();
      localContentValues = new ContentValues();
      localContentValues.put("remote_config", paramArrayOfByte);
    }
    catch (IOException localIOException)
    {
      try
      {
        ContentValues localContentValues;
        if (localzzt.getWritableDatabase().update("apps", localContentValues, "app_id = ?", new String[] { paramString1 }) == 0L)
          localzzt.zzgt().zzjg().zzg("Failed to update remote config (got 0). appId", zzas.zzbw(paramString1));
        return true;
        localIOException = localIOException;
        zzgt().zzjj().zze("Unable to serialize reduced-size config. Storing full config instead. appId", zzas.zzbw(paramString1), localIOException);
      }
      catch (SQLiteException localSQLiteException)
      {
        while (true)
        {
          zzt localzzt;
          localzzt.zzgt().zzjg().zze("Error storing remote config. appId", zzas.zzbw(paramString1), localSQLiteException);
        }
      }
    }
  }

  protected final zzfp zzcg(String paramString)
  {
    zzcl();
    zzaf();
    Preconditions.checkNotEmpty(paramString);
    zzcf(paramString);
    return (zzfp)this.zzaoq.get(paramString);
  }

  protected final String zzch(String paramString)
  {
    zzaf();
    return (String)this.zzaos.get(paramString);
  }

  protected final void zzci(String paramString)
  {
    zzaf();
    this.zzaos.put(paramString, null);
  }

  final void zzcj(String paramString)
  {
    zzaf();
    this.zzaoq.remove(paramString);
  }

  final long zzck(String paramString)
  {
    String str = zzf(paramString, "measurement.account.time_zone_offset_minutes");
    if (!TextUtils.isEmpty(str))
      try
      {
        long l = Long.parseLong(str);
        return l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        zzgt().zzjj().zze("Unable to parse timezone offset. appId", zzas.zzbw(paramString), localNumberFormatException);
      }
    return 0L;
  }

  final boolean zzcl(String paramString)
  {
    return "1".equals(zzf(paramString, "measurement.upload.blacklist_internal"));
  }

  final boolean zzcm(String paramString)
  {
    return "1".equals(zzf(paramString, "measurement.upload.blacklist_public"));
  }

  public final String zzf(String paramString1, String paramString2)
  {
    zzaf();
    zzcf(paramString1);
    Map localMap = (Map)this.zzaon.get(paramString1);
    if (localMap != null)
      return (String)localMap.get(paramString2);
    return null;
  }

  protected final boolean zzgy()
  {
    return false;
  }

  final boolean zzo(String paramString1, String paramString2)
  {
    zzaf();
    zzcf(paramString1);
    if ((zzcl(paramString1)) && (zzfx.zzcy(paramString2)));
    while ((zzcm(paramString1)) && (zzfx.zzct(paramString2)))
      return true;
    Map localMap = (Map)this.zzaoo.get(paramString1);
    if (localMap != null)
    {
      Boolean localBoolean = (Boolean)localMap.get(paramString2);
      if (localBoolean == null)
        return false;
      return localBoolean.booleanValue();
    }
    return false;
  }

  final boolean zzp(String paramString1, String paramString2)
  {
    zzaf();
    zzcf(paramString1);
    if ("ecommerce_purchase".equals(paramString2))
      return true;
    Map localMap = (Map)this.zzaop.get(paramString1);
    if (localMap != null)
    {
      Boolean localBoolean = (Boolean)localMap.get(paramString2);
      if (localBoolean == null)
        return false;
      return localBoolean.booleanValue();
    }
    return false;
  }

  final int zzq(String paramString1, String paramString2)
  {
    zzaf();
    zzcf(paramString1);
    Map localMap = (Map)this.zzaor.get(paramString1);
    if (localMap != null)
    {
      Integer localInteger = (Integer)localMap.get(paramString2);
      if (localInteger == null)
        return 1;
      return localInteger.intValue();
    }
    return 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzbq
 * JD-Core Version:    0.6.2
 */
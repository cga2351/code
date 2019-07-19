package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import org.json.JSONObject;

@zzare
public abstract class zzaci<T>
{
  private final String zzcc;
  private final int zzckh;
  private final T zzcki;

  private zzaci(int paramInt, String paramString, T paramT)
  {
    this.zzckh = paramInt;
    this.zzcc = paramString;
    this.zzcki = paramT;
    zzyr.zzpd().zza(this);
  }

  public static zzaci<Float> zza(int paramInt, String paramString, float paramFloat)
  {
    return new zzacm(paramInt, paramString, Float.valueOf(paramFloat));
  }

  public static zzaci<Integer> zza(int paramInt1, String paramString, int paramInt2)
  {
    return new zzack(paramInt1, paramString, Integer.valueOf(paramInt2));
  }

  public static zzaci<Long> zza(int paramInt, String paramString, long paramLong)
  {
    return new zzacl(paramInt, paramString, Long.valueOf(paramLong));
  }

  public static zzaci<Boolean> zza(int paramInt, String paramString, Boolean paramBoolean)
  {
    return new zzacj(paramInt, paramString, paramBoolean);
  }

  public static zzaci<String> zza(int paramInt, String paramString1, String paramString2)
  {
    return new zzacn(paramInt, paramString1, paramString2);
  }

  public static zzaci<String> zzb(int paramInt, String paramString)
  {
    zzaci localzzaci = zza(paramInt, paramString, null);
    zzyr.zzpd().zzb(localzzaci);
    return localzzaci;
  }

  public static zzaci<String> zzc(int paramInt, String paramString)
  {
    zzaci localzzaci = zza(paramInt, paramString, null);
    zzyr.zzpd().zzc(localzzaci);
    return localzzaci;
  }

  public final String getKey()
  {
    return this.zzcc;
  }

  public final int getSource()
  {
    return this.zzckh;
  }

  protected abstract T zza(SharedPreferences paramSharedPreferences);

  public abstract T zza(Bundle paramBundle);

  protected abstract T zza(JSONObject paramJSONObject);

  public abstract void zza(SharedPreferences.Editor paramEditor, T paramT);

  public final T zzqm()
  {
    return this.zzcki;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaci
 * JD-Core Version:    0.6.2
 */
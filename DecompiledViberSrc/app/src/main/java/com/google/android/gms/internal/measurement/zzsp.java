package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzsp
  implements zzsb
{
  static final Map<String, zzsp> zzbsb = new HashMap();
  private final Object zzbrf = new Object();
  private volatile Map<String, ?> zzbrg;
  private final List<zzsa> zzbrh = new ArrayList();
  private final SharedPreferences zzbsc;
  private final SharedPreferences.OnSharedPreferenceChangeListener zzbsd = new zzsq(this);

  private zzsp(SharedPreferences paramSharedPreferences)
  {
    this.zzbsc = paramSharedPreferences;
    this.zzbsc.registerOnSharedPreferenceChangeListener(this.zzbsd);
  }

  static zzsp zzi(Context paramContext, String paramString)
  {
    if ((zzrw.zztj()) && (!paramString.startsWith("direct_boot:")));
    for (boolean bool = zzrw.isUserUnlocked(paramContext); !bool; bool = true)
      return null;
    while (true)
    {
      try
      {
        zzsp localzzsp = (zzsp)zzbsb.get(paramString);
        if (localzzsp == null)
        {
          if (paramString.startsWith("direct_boot:"))
          {
            if (zzrw.zztj())
              paramContext = paramContext.createDeviceProtectedStorageContext();
            localObject2 = paramContext.getSharedPreferences(paramString.substring(12), 0);
            localzzsp = new zzsp((SharedPreferences)localObject2);
            zzbsb.put(paramString, localzzsp);
          }
        }
        else
          return localzzsp;
      }
      finally
      {
      }
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(paramString, 0);
      Object localObject2 = localSharedPreferences;
    }
  }

  public final Object zzfn(String paramString)
  {
    Map localMap = this.zzbrg;
    if (localMap == null);
    synchronized (this.zzbrf)
    {
      localMap = this.zzbrg;
      if (localMap == null)
      {
        localMap = this.zzbsc.getAll();
        this.zzbrg = localMap;
      }
      if (localMap != null)
        return localMap.get(paramString);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzsp
 * JD-Core Version:    0.6.2
 */
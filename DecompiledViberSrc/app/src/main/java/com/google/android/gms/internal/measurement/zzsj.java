package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzsj extends zzsi<Long>
{
  zzsj(zzso paramzzso, String paramString, Long paramLong)
  {
    super(paramzzso, paramString, paramLong, null);
  }

  private final Long zzt(Object paramObject)
  {
    if ((paramObject instanceof Long))
      return (Long)paramObject;
    if ((paramObject instanceof String))
      try
      {
        Long localLong = Long.valueOf(Long.parseLong((String)paramObject));
        return localLong;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    String str1 = super.zztr();
    String str2 = String.valueOf(paramObject);
    Log.e("PhenotypeFlag", 25 + String.valueOf(str1).length() + String.valueOf(str2).length() + "Invalid long value for " + str1 + ": " + str2);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzsj
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzsk extends zzsi<Integer>
{
  zzsk(zzso paramzzso, String paramString, Integer paramInteger)
  {
    super(paramzzso, paramString, paramInteger, null);
  }

  private final Integer zzu(Object paramObject)
  {
    if ((paramObject instanceof Integer))
      return (Integer)paramObject;
    if ((paramObject instanceof Long))
      return Integer.valueOf(((Long)paramObject).intValue());
    if ((paramObject instanceof String))
      try
      {
        Integer localInteger = Integer.valueOf(Integer.parseInt((String)paramObject));
        return localInteger;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    String str1 = super.zztr();
    String str2 = String.valueOf(paramObject);
    Log.e("PhenotypeFlag", 24 + String.valueOf(str1).length() + String.valueOf(str2).length() + "Invalid int value for " + str1 + ": " + str2);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzsk
 * JD-Core Version:    0.6.2
 */
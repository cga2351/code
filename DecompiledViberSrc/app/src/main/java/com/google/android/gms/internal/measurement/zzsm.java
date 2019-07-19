package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzsm extends zzsi<Double>
{
  zzsm(zzso paramzzso, String paramString, Double paramDouble)
  {
    super(paramzzso, paramString, paramDouble, null);
  }

  private final Double zzv(Object paramObject)
  {
    if ((paramObject instanceof Double))
      return (Double)paramObject;
    if ((paramObject instanceof Float))
      return Double.valueOf(((Float)paramObject).doubleValue());
    if ((paramObject instanceof String))
      try
      {
        Double localDouble = Double.valueOf(Double.parseDouble((String)paramObject));
        return localDouble;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    String str1 = super.zztr();
    String str2 = String.valueOf(paramObject);
    Log.e("PhenotypeFlag", 27 + String.valueOf(str1).length() + String.valueOf(str2).length() + "Invalid double value for " + str1 + ": " + str2);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzsm
 * JD-Core Version:    0.6.2
 */
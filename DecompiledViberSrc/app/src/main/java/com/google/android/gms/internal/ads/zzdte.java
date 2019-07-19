package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public final class zzdte
{
  public static <T> List<T> zzhk(int paramInt)
  {
    if (paramInt == 0)
      return Collections.emptyList();
    return new ArrayList(paramInt);
  }

  static <T> HashSet<T> zzhl(int paramInt)
  {
    return new HashSet(zzhn(paramInt));
  }

  public static <K, V> LinkedHashMap<K, V> zzhm(int paramInt)
  {
    return new LinkedHashMap(zzhn(paramInt));
  }

  private static int zzhn(int paramInt)
  {
    if (paramInt < 3)
      return paramInt + 1;
    if (paramInt < 1073741824)
      return (int)(1.0F + paramInt / 0.75F);
    return 2147483647;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdte
 * JD-Core Version:    0.6.2
 */
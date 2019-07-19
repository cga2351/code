package com.google.android.gms.common.util;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@KeepForSdk
public final class CollectionUtils
{
  @KeepForSdk
  public static boolean isEmpty(Collection<?> paramCollection)
  {
    if (paramCollection == null)
      return true;
    return paramCollection.isEmpty();
  }

  @Deprecated
  @KeepForSdk
  public static <T> List<T> listOf()
  {
    return Collections.emptyList();
  }

  @Deprecated
  @KeepForSdk
  public static <T> List<T> listOf(T paramT)
  {
    return Collections.singletonList(paramT);
  }

  @Deprecated
  @KeepForSdk
  public static <T> List<T> listOf(T[] paramArrayOfT)
  {
    switch (paramArrayOfT.length)
    {
    default:
      return Collections.unmodifiableList(Arrays.asList(paramArrayOfT));
    case 0:
      return listOf();
    case 1:
    }
    return listOf(paramArrayOfT[0]);
  }

  @KeepForSdk
  public static <K, V> Map<K, V> mapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    Map localMap = zzb(3, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    return Collections.unmodifiableMap(localMap);
  }

  @KeepForSdk
  public static <K, V> Map<K, V> mapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5, K paramK6, V paramV6)
  {
    Map localMap = zzb(6, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    localMap.put(paramK4, paramV4);
    localMap.put(paramK5, paramV5);
    localMap.put(paramK6, paramV6);
    return Collections.unmodifiableMap(localMap);
  }

  @KeepForSdk
  public static <K, V> Map<K, V> mapOfKeyValueArrays(K[] paramArrayOfK, V[] paramArrayOfV)
  {
    int i = 0;
    if (paramArrayOfK.length != paramArrayOfV.length)
    {
      int j = paramArrayOfK.length;
      int k = paramArrayOfV.length;
      throw new IllegalArgumentException(66 + "Key and values array lengths not equal: " + j + " != " + k);
    }
    Map localMap;
    switch (paramArrayOfK.length)
    {
    default:
      localMap = zzb(paramArrayOfK.length, false);
    case 0:
    case 1:
    }
    while (i < paramArrayOfK.length)
    {
      localMap.put(paramArrayOfK[i], paramArrayOfV[i]);
      i++;
      continue;
      return Collections.emptyMap();
      return Collections.singletonMap(paramArrayOfK[0], paramArrayOfV[0]);
    }
    return Collections.unmodifiableMap(localMap);
  }

  @KeepForSdk
  public static <T> Set<T> mutableSetOfWithSize(int paramInt)
  {
    if (paramInt == 0)
      return new ArraySet();
    return zza(paramInt, true);
  }

  @Deprecated
  @KeepForSdk
  public static <T> Set<T> setOf(T paramT1, T paramT2, T paramT3)
  {
    Set localSet = zza(3, false);
    localSet.add(paramT1);
    localSet.add(paramT2);
    localSet.add(paramT3);
    return Collections.unmodifiableSet(localSet);
  }

  @Deprecated
  @KeepForSdk
  public static <T> Set<T> setOf(T[] paramArrayOfT)
  {
    switch (paramArrayOfT.length)
    {
    default:
      Set localSet3 = zza(paramArrayOfT.length, false);
      Collections.addAll(localSet3, paramArrayOfT);
      return Collections.unmodifiableSet(localSet3);
    case 0:
      return Collections.emptySet();
    case 1:
      return Collections.singleton(paramArrayOfT[0]);
    case 2:
      T ? = paramArrayOfT[0];
      T ? = paramArrayOfT[1];
      Set localSet2 = zza(2, false);
      localSet2.add(?);
      localSet2.add(?);
      return Collections.unmodifiableSet(localSet2);
    case 3:
      return setOf(paramArrayOfT[0], paramArrayOfT[1], paramArrayOfT[2]);
    case 4:
    }
    T ? = paramArrayOfT[0];
    T ? = paramArrayOfT[1];
    T ? = paramArrayOfT[2];
    T ? = paramArrayOfT[3];
    Set localSet1 = zza(4, false);
    localSet1.add(?);
    localSet1.add(?);
    localSet1.add(?);
    localSet1.add(?);
    return Collections.unmodifiableSet(localSet1);
  }

  private static <T> Set<T> zza(int paramInt, boolean paramBoolean)
  {
    float f;
    if (paramBoolean)
    {
      f = 0.75F;
      if (!paramBoolean)
        break label34;
    }
    label34: for (int i = 128; ; i = 256)
    {
      if (paramInt > i)
        break label41;
      return new ArraySet(paramInt);
      f = 1.0F;
      break;
    }
    label41: return new HashSet(paramInt, f);
  }

  private static <K, V> Map<K, V> zzb(int paramInt, boolean paramBoolean)
  {
    if (paramInt <= 256)
      return new ArrayMap(paramInt);
    return new HashMap(paramInt, 1.0F);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.CollectionUtils
 * JD-Core Version:    0.6.2
 */
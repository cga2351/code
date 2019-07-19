package com.google.android.gms.internal.wearable;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

@VisibleForTesting
public final class zze
{
  public static zzf zza(DataMap paramDataMap)
  {
    zzg localzzg = new zzg();
    ArrayList localArrayList = new ArrayList();
    TreeSet localTreeSet = new TreeSet(paramDataMap.keySet());
    zzh[] arrayOfzzh = new zzh[localTreeSet.size()];
    Iterator localIterator = localTreeSet.iterator();
    for (int i = 0; localIterator.hasNext(); i++)
    {
      String str = (String)localIterator.next();
      Object localObject = paramDataMap.get(str);
      arrayOfzzh[i] = new zzh();
      arrayOfzzh[i].name = str;
      arrayOfzzh[i].zzga = zza(localArrayList, localObject);
    }
    localzzg.zzfy = arrayOfzzh;
    return new zzf(localzzg, localArrayList);
  }

  private static zzi zza(List<Asset> paramList, Object paramObject)
  {
    zzi localzzi1 = new zzi();
    if (paramObject == null)
    {
      localzzi1.type = 14;
      return localzzi1;
    }
    localzzi1.zzgc = new zzj();
    if ((paramObject instanceof String))
    {
      localzzi1.type = 2;
      localzzi1.zzgc.zzge = ((String)paramObject);
    }
    while (true)
    {
      return localzzi1;
      if ((paramObject instanceof Integer))
      {
        localzzi1.type = 6;
        localzzi1.zzgc.zzgi = ((Integer)paramObject).intValue();
      }
      else if ((paramObject instanceof Long))
      {
        localzzi1.type = 5;
        localzzi1.zzgc.zzgh = ((Long)paramObject).longValue();
      }
      else if ((paramObject instanceof Double))
      {
        localzzi1.type = 3;
        localzzi1.zzgc.zzgf = ((Double)paramObject).doubleValue();
      }
      else if ((paramObject instanceof Float))
      {
        localzzi1.type = 4;
        localzzi1.zzgc.zzgg = ((Float)paramObject).floatValue();
      }
      else if ((paramObject instanceof Boolean))
      {
        localzzi1.type = 8;
        localzzi1.zzgc.zzgk = ((Boolean)paramObject).booleanValue();
      }
      else if ((paramObject instanceof Byte))
      {
        localzzi1.type = 7;
        localzzi1.zzgc.zzgj = ((Byte)paramObject).byteValue();
      }
      else if ((paramObject instanceof byte[]))
      {
        localzzi1.type = 1;
        localzzi1.zzgc.zzgd = ((byte[])paramObject);
      }
      else if ((paramObject instanceof String[]))
      {
        localzzi1.type = 11;
        localzzi1.zzgc.zzgn = ((String[])paramObject);
      }
      else if ((paramObject instanceof long[]))
      {
        localzzi1.type = 12;
        localzzi1.zzgc.zzgo = ((long[])paramObject);
      }
      else if ((paramObject instanceof float[]))
      {
        localzzi1.type = 15;
        localzzi1.zzgc.zzgp = ((float[])paramObject);
      }
      else if ((paramObject instanceof Asset))
      {
        localzzi1.type = 13;
        zzj localzzj = localzzi1.zzgc;
        paramList.add((Asset)paramObject);
        localzzj.zzgq = (-1 + paramList.size());
      }
      else
      {
        if (!(paramObject instanceof DataMap))
          break;
        localzzi1.type = 9;
        DataMap localDataMap = (DataMap)paramObject;
        TreeSet localTreeSet = new TreeSet(localDataMap.keySet());
        zzh[] arrayOfzzh = new zzh[localTreeSet.size()];
        Iterator localIterator = localTreeSet.iterator();
        for (int n = 0; localIterator.hasNext(); n++)
        {
          String str6 = (String)localIterator.next();
          arrayOfzzh[n] = new zzh();
          arrayOfzzh[n].name = str6;
          arrayOfzzh[n].zzga = zza(paramList, localDataMap.get(str6));
        }
        localzzi1.zzgc.zzgl = arrayOfzzh;
      }
    }
    zzi[] arrayOfzzi;
    Object localObject1;
    int j;
    int k;
    label567: Object localObject2;
    zzi localzzi2;
    if ((paramObject instanceof ArrayList))
    {
      localzzi1.type = 10;
      ArrayList localArrayList = (ArrayList)paramObject;
      arrayOfzzi = new zzi[localArrayList.size()];
      localObject1 = null;
      int i = localArrayList.size();
      j = 0;
      k = 14;
      if (j < i)
      {
        localObject2 = localArrayList.get(j);
        localzzi2 = zza(paramList, localObject2);
        if ((localzzi2.type != 14) && (localzzi2.type != 2) && (localzzi2.type != 6) && (localzzi2.type != 9))
        {
          String str5 = String.valueOf(localObject2.getClass());
          throw new IllegalArgumentException(130 + String.valueOf(str5).length() + "The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + str5);
        }
        if ((k != 14) || (localzzi2.type == 14));
      }
    }
    for (int m = localzzi2.type; ; m = k)
    {
      arrayOfzzi[j] = localzzi2;
      j++;
      k = m;
      localObject1 = localObject2;
      break label567;
      if (localzzi2.type != k)
      {
        String str3 = String.valueOf(localObject1.getClass());
        String str4 = String.valueOf(localObject2.getClass());
        throw new IllegalArgumentException(80 + String.valueOf(str3).length() + String.valueOf(str4).length() + "ArrayList elements must all be of the sameclass, but this one contains a " + str3 + " and a " + str4);
        localzzi1.zzgc.zzgm = arrayOfzzi;
        break;
        String str1 = String.valueOf(paramObject.getClass().getSimpleName());
        if (str1.length() != 0);
        for (String str2 = "newFieldValueFromValue: unexpected value ".concat(str1); ; str2 = new String("newFieldValueFromValue: unexpected value "))
          throw new RuntimeException(str2);
      }
      localObject2 = localObject1;
    }
  }

  public static DataMap zza(zzf paramzzf)
  {
    DataMap localDataMap = new DataMap();
    for (zzh localzzh : paramzzf.zzfw.zzfy)
      zza(paramzzf.zzfx, localDataMap, localzzh.name, localzzh.zzga);
    return localDataMap;
  }

  private static void zza(List<Asset> paramList, DataMap paramDataMap, String paramString, zzi paramzzi)
  {
    int i = paramzzi.type;
    if (i == 14)
    {
      paramDataMap.putString(paramString, null);
      return;
    }
    zzj localzzj = paramzzi.zzgc;
    if (i == 1)
    {
      paramDataMap.putByteArray(paramString, localzzj.zzgd);
      return;
    }
    if (i == 11)
    {
      paramDataMap.putStringArray(paramString, localzzj.zzgn);
      return;
    }
    if (i == 12)
    {
      paramDataMap.putLongArray(paramString, localzzj.zzgo);
      return;
    }
    if (i == 15)
    {
      paramDataMap.putFloatArray(paramString, localzzj.zzgp);
      return;
    }
    if (i == 2)
    {
      paramDataMap.putString(paramString, localzzj.zzge);
      return;
    }
    if (i == 3)
    {
      paramDataMap.putDouble(paramString, localzzj.zzgf);
      return;
    }
    if (i == 4)
    {
      paramDataMap.putFloat(paramString, localzzj.zzgg);
      return;
    }
    if (i == 5)
    {
      paramDataMap.putLong(paramString, localzzj.zzgh);
      return;
    }
    if (i == 6)
    {
      paramDataMap.putInt(paramString, localzzj.zzgi);
      return;
    }
    if (i == 7)
    {
      paramDataMap.putByte(paramString, (byte)localzzj.zzgj);
      return;
    }
    if (i == 8)
    {
      paramDataMap.putBoolean(paramString, localzzj.zzgk);
      return;
    }
    if (i == 13)
    {
      if (paramList == null)
      {
        String str1 = String.valueOf(paramString);
        if (str1.length() != 0);
        for (String str2 = "populateBundle: unexpected type for: ".concat(str1); ; str2 = new String("populateBundle: unexpected type for: "))
          throw new RuntimeException(str2);
      }
      paramDataMap.putAsset(paramString, (Asset)paramList.get((int)localzzj.zzgq));
      return;
    }
    if (i == 9)
    {
      DataMap localDataMap1 = new DataMap();
      for (zzh localzzh1 : localzzj.zzgl)
        zza(paramList, localDataMap1, localzzh1.name, localzzh1.zzga);
      paramDataMap.putDataMap(paramString, localDataMap1);
      return;
    }
    if (i == 10)
    {
      zzi[] arrayOfzzi1 = localzzj.zzgm;
      int m = arrayOfzzi1.length;
      int n = 14;
      int i1 = 0;
      if (i1 < m)
      {
        zzi localzzi2 = arrayOfzzi1[i1];
        if (n == 14)
          if ((localzzi2.type == 9) || (localzzi2.type == 2) || (localzzi2.type == 6))
            n = localzzi2.type;
        while (localzzi2.type == n)
        {
          do
          {
            i1++;
            break;
          }
          while (localzzi2.type == 14);
          int i7 = localzzi2.type;
          throw new IllegalArgumentException(48 + String.valueOf(paramString).length() + "Unexpected TypedValue type: " + i7 + " for key " + paramString);
        }
        int i6 = localzzi2.type;
        throw new IllegalArgumentException(126 + String.valueOf(paramString).length() + "The ArrayList elements should all be the same type, but ArrayList with key " + paramString + " contains items of type " + n + " and " + i6);
      }
      ArrayList localArrayList = new ArrayList(localzzj.zzgm.length);
      zzi[] arrayOfzzi2 = localzzj.zzgm;
      int i2 = arrayOfzzi2.length;
      int i3 = 0;
      if (i3 < i2)
      {
        zzi localzzi1 = arrayOfzzi2[i3];
        if (localzzi1.type == 14)
          localArrayList.add(null);
        while (true)
        {
          i3++;
          break;
          if (n == 9)
          {
            DataMap localDataMap2 = new DataMap();
            for (zzh localzzh2 : localzzi1.zzgc.zzgl)
              zza(paramList, localDataMap2, localzzh2.name, localzzh2.zzga);
            localArrayList.add(localDataMap2);
          }
          else if (n == 2)
          {
            localArrayList.add(localzzi1.zzgc.zzge);
          }
          else
          {
            if (n != 6)
              break label806;
            localArrayList.add(Integer.valueOf(localzzi1.zzgc.zzgi));
          }
        }
        label806: throw new IllegalArgumentException(39 + "Unexpected typeOfArrayList: " + n);
      }
      if (n == 14)
      {
        paramDataMap.putStringArrayList(paramString, localArrayList);
        return;
      }
      if (n == 9)
      {
        paramDataMap.putDataMapArrayList(paramString, localArrayList);
        return;
      }
      if (n == 2)
      {
        paramDataMap.putStringArrayList(paramString, localArrayList);
        return;
      }
      if (n == 6)
      {
        paramDataMap.putIntegerArrayList(paramString, localArrayList);
        return;
      }
      throw new IllegalStateException(39 + "Unexpected typeOfArrayList: " + n);
    }
    throw new RuntimeException(43 + "populateBundle: unexpected type " + i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zze
 * JD-Core Version:    0.6.2
 */
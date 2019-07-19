package com.google.android.gms.wearable;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.wearable.zze;
import com.google.android.gms.internal.wearable.zzf;
import com.google.android.gms.internal.wearable.zzg;
import com.google.android.gms.internal.wearable.zzs;
import com.google.android.gms.internal.wearable.zzt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

@VisibleForTesting
public class DataMap
{
  public static final String TAG = "DataMap";
  private final HashMap<String, Object> zzq = new HashMap();

  public static ArrayList<DataMap> arrayListFromBundleArrayList(ArrayList<Bundle> paramArrayList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = (ArrayList)paramArrayList;
    int i = localArrayList2.size();
    int j = 0;
    while (j < i)
    {
      Object localObject = localArrayList2.get(j);
      j++;
      localArrayList1.add(fromBundle((Bundle)localObject));
    }
    return localArrayList1;
  }

  public static DataMap fromBundle(Bundle paramBundle)
  {
    paramBundle.setClassLoader(Asset.class.getClassLoader());
    DataMap localDataMap = new DataMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if ((localObject instanceof String))
        localDataMap.putString(str, (String)localObject);
      else if ((localObject instanceof Integer))
        localDataMap.putInt(str, ((Integer)localObject).intValue());
      else if ((localObject instanceof Long))
        localDataMap.putLong(str, ((Long)localObject).longValue());
      else if ((localObject instanceof Double))
        localDataMap.putDouble(str, ((Double)localObject).doubleValue());
      else if ((localObject instanceof Float))
        localDataMap.putFloat(str, ((Float)localObject).floatValue());
      else if ((localObject instanceof Boolean))
        localDataMap.putBoolean(str, ((Boolean)localObject).booleanValue());
      else if ((localObject instanceof Byte))
        localDataMap.putByte(str, ((Byte)localObject).byteValue());
      else if ((localObject instanceof byte[]))
        localDataMap.putByteArray(str, (byte[])localObject);
      else if ((localObject instanceof String[]))
        localDataMap.putStringArray(str, (String[])localObject);
      else if ((localObject instanceof long[]))
        localDataMap.putLongArray(str, (long[])localObject);
      else if ((localObject instanceof float[]))
        localDataMap.putFloatArray(str, (float[])localObject);
      else if ((localObject instanceof Asset))
        localDataMap.putAsset(str, (Asset)localObject);
      else if ((localObject instanceof Bundle))
        localDataMap.putDataMap(str, fromBundle((Bundle)localObject));
      else if ((localObject instanceof ArrayList))
        switch (zza((ArrayList)localObject))
        {
        case 4:
        default:
          break;
        case 0:
          localDataMap.putStringArrayList(str, (ArrayList)localObject);
          break;
        case 1:
          localDataMap.putStringArrayList(str, (ArrayList)localObject);
          break;
        case 3:
          localDataMap.putStringArrayList(str, (ArrayList)localObject);
          break;
        case 2:
          localDataMap.putIntegerArrayList(str, (ArrayList)localObject);
          break;
        case 5:
          localDataMap.putDataMapArrayList(str, arrayListFromBundleArrayList((ArrayList)localObject));
        }
    }
    return localDataMap;
  }

  public static DataMap fromByteArray(byte[] paramArrayOfByte)
  {
    try
    {
      DataMap localDataMap = zze.zza(new zzf(zzg.zza(paramArrayOfByte), new ArrayList()));
      return localDataMap;
    }
    catch (zzs localzzs)
    {
      throw new IllegalArgumentException("Unable to convert data", localzzs);
    }
  }

  private static int zza(ArrayList<?> paramArrayList)
  {
    int i = 0;
    if (paramArrayList.isEmpty())
      return 0;
    ArrayList localArrayList = (ArrayList)paramArrayList;
    int j = localArrayList.size();
    while (i < j)
    {
      Object localObject = localArrayList.get(i);
      i++;
      if (localObject != null)
      {
        if ((localObject instanceof Integer))
          return 2;
        if ((localObject instanceof String))
          return 3;
        if ((localObject instanceof DataMap))
          return 4;
        if ((localObject instanceof Bundle))
          return 5;
      }
    }
    return 1;
  }

  private static void zza(String paramString1, Object paramObject, String paramString2, ClassCastException paramClassCastException)
  {
    zza(paramString1, paramObject, paramString2, "<null>", paramClassCastException);
  }

  private static void zza(String paramString1, Object paramObject1, String paramString2, Object paramObject2, ClassCastException paramClassCastException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Key ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" expected ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" but value was a ");
    localStringBuilder.append(paramObject1.getClass().getName());
    localStringBuilder.append(".  The default value ");
    localStringBuilder.append(paramObject2);
    localStringBuilder.append(" was returned.");
    Log.w("DataMap", localStringBuilder.toString());
    Log.w("DataMap", "Attempt to cast generated internal exception:", paramClassCastException);
  }

  public void clear()
  {
    this.zzq.clear();
  }

  public boolean containsKey(String paramString)
  {
    return this.zzq.containsKey(paramString);
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DataMap))
      return false;
    DataMap localDataMap = (DataMap)paramObject;
    if (size() != localDataMap.size())
      return false;
    Iterator localIterator = keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject1 = get(str);
      Object localObject2 = localDataMap.get(str);
      if ((localObject1 instanceof Asset))
      {
        if (!(localObject2 instanceof Asset))
          return false;
        Asset localAsset1 = (Asset)localObject1;
        Asset localAsset2 = (Asset)localObject2;
        boolean bool;
        if ((localAsset1 == null) || (localAsset2 == null))
          if (localAsset1 == localAsset2)
            bool = true;
        while (!bool)
        {
          return false;
          bool = false;
          continue;
          if (!TextUtils.isEmpty(localAsset1.getDigest()))
            bool = localAsset1.getDigest().equals(localAsset2.getDigest());
          else
            bool = Arrays.equals(localAsset1.getData(), localAsset2.getData());
        }
      }
      else if ((localObject1 instanceof String[]))
      {
        if (!(localObject2 instanceof String[]))
          return false;
        if (!Arrays.equals((String[])localObject1, (String[])localObject2))
          return false;
      }
      else if ((localObject1 instanceof long[]))
      {
        if (!(localObject2 instanceof long[]))
          return false;
        if (!Arrays.equals((long[])localObject1, (long[])localObject2))
          return false;
      }
      else if ((localObject1 instanceof float[]))
      {
        if (!(localObject2 instanceof float[]))
          return false;
        if (!Arrays.equals((float[])localObject1, (float[])localObject2))
          return false;
      }
      else if ((localObject1 instanceof byte[]))
      {
        if (!(localObject2 instanceof byte[]))
          return false;
        if (!Arrays.equals((byte[])localObject1, (byte[])localObject2))
          return false;
      }
      else if ((localObject1 == null) || (localObject2 == null))
      {
        if (localObject1 != localObject2)
          return false;
      }
      else if (!localObject1.equals(localObject2))
      {
        return false;
      }
    }
    return true;
  }

  public <T> T get(String paramString)
  {
    return this.zzq.get(paramString);
  }

  public Asset getAsset(String paramString)
  {
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
      return null;
    try
    {
      Asset localAsset = (Asset)localObject;
      return localAsset;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Asset", localClassCastException);
    }
    return null;
  }

  public boolean getBoolean(String paramString)
  {
    return getBoolean(paramString, false);
  }

  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
      return paramBoolean;
    try
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Boolean", Boolean.valueOf(paramBoolean), localClassCastException);
    }
    return paramBoolean;
  }

  public byte getByte(String paramString)
  {
    return getByte(paramString, (byte)0);
  }

  public byte getByte(String paramString, byte paramByte)
  {
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
      return paramByte;
    try
    {
      byte b = ((Byte)localObject).byteValue();
      return b;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Byte", Byte.valueOf(paramByte), localClassCastException);
    }
    return paramByte;
  }

  public byte[] getByteArray(String paramString)
  {
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
      return null;
    try
    {
      byte[] arrayOfByte = (byte[])localObject;
      return arrayOfByte;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "byte[]", localClassCastException);
    }
    return null;
  }

  public DataMap getDataMap(String paramString)
  {
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
      return null;
    try
    {
      DataMap localDataMap = (DataMap)localObject;
      return localDataMap;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "DataMap", localClassCastException);
    }
    return null;
  }

  public ArrayList<DataMap> getDataMapArrayList(String paramString)
  {
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
      return null;
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "ArrayList<DataMap>", localClassCastException);
    }
    return null;
  }

  public double getDouble(String paramString)
  {
    return getDouble(paramString, 0.0D);
  }

  public double getDouble(String paramString, double paramDouble)
  {
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
      return paramDouble;
    try
    {
      double d = ((Double)localObject).doubleValue();
      return d;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Double", Double.valueOf(paramDouble), localClassCastException);
    }
    return paramDouble;
  }

  public float getFloat(String paramString)
  {
    return getFloat(paramString, 0.0F);
  }

  public float getFloat(String paramString, float paramFloat)
  {
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
      return paramFloat;
    try
    {
      float f = ((Float)localObject).floatValue();
      return f;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Float", Float.valueOf(paramFloat), localClassCastException);
    }
    return paramFloat;
  }

  public float[] getFloatArray(String paramString)
  {
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
      return null;
    try
    {
      float[] arrayOfFloat = (float[])localObject;
      return arrayOfFloat;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "float[]", localClassCastException);
    }
    return null;
  }

  public int getInt(String paramString)
  {
    return getInt(paramString, 0);
  }

  public int getInt(String paramString, int paramInt)
  {
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
      return paramInt;
    try
    {
      int i = ((Integer)localObject).intValue();
      return i;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Integer", localClassCastException);
    }
    return paramInt;
  }

  public ArrayList<Integer> getIntegerArrayList(String paramString)
  {
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
      return null;
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "ArrayList<Integer>", localClassCastException);
    }
    return null;
  }

  public long getLong(String paramString)
  {
    return getLong(paramString, 0L);
  }

  public long getLong(String paramString, long paramLong)
  {
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
      return paramLong;
    try
    {
      long l = ((Long)localObject).longValue();
      return l;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "long", localClassCastException);
    }
    return paramLong;
  }

  public long[] getLongArray(String paramString)
  {
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
      return null;
    try
    {
      long[] arrayOfLong = (long[])localObject;
      return arrayOfLong;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "long[]", localClassCastException);
    }
    return null;
  }

  public String getString(String paramString)
  {
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
      return null;
    try
    {
      String str = (String)localObject;
      return str;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "String", localClassCastException);
    }
    return null;
  }

  public String getString(String paramString1, String paramString2)
  {
    String str = getString(paramString1);
    if (str == null)
      return paramString2;
    return str;
  }

  public String[] getStringArray(String paramString)
  {
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
      return null;
    try
    {
      String[] arrayOfString = (String[])localObject;
      return arrayOfString;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "String[]", localClassCastException);
    }
    return null;
  }

  public ArrayList<String> getStringArrayList(String paramString)
  {
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
      return null;
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "ArrayList<String>", localClassCastException);
    }
    return null;
  }

  public int hashCode()
  {
    return 29 * this.zzq.hashCode();
  }

  public boolean isEmpty()
  {
    return this.zzq.isEmpty();
  }

  public Set<String> keySet()
  {
    return this.zzq.keySet();
  }

  public void putAll(DataMap paramDataMap)
  {
    Iterator localIterator = paramDataMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.zzq.put(str, paramDataMap.get(str));
    }
  }

  public void putAsset(String paramString, Asset paramAsset)
  {
    this.zzq.put(paramString, paramAsset);
  }

  public void putBoolean(String paramString, boolean paramBoolean)
  {
    this.zzq.put(paramString, Boolean.valueOf(paramBoolean));
  }

  public void putByte(String paramString, byte paramByte)
  {
    this.zzq.put(paramString, Byte.valueOf(paramByte));
  }

  public void putByteArray(String paramString, byte[] paramArrayOfByte)
  {
    this.zzq.put(paramString, paramArrayOfByte);
  }

  public void putDataMap(String paramString, DataMap paramDataMap)
  {
    this.zzq.put(paramString, paramDataMap);
  }

  public void putDataMapArrayList(String paramString, ArrayList<DataMap> paramArrayList)
  {
    this.zzq.put(paramString, paramArrayList);
  }

  public void putDouble(String paramString, double paramDouble)
  {
    this.zzq.put(paramString, Double.valueOf(paramDouble));
  }

  public void putFloat(String paramString, float paramFloat)
  {
    this.zzq.put(paramString, Float.valueOf(paramFloat));
  }

  public void putFloatArray(String paramString, float[] paramArrayOfFloat)
  {
    this.zzq.put(paramString, paramArrayOfFloat);
  }

  public void putInt(String paramString, int paramInt)
  {
    this.zzq.put(paramString, Integer.valueOf(paramInt));
  }

  public void putIntegerArrayList(String paramString, ArrayList<Integer> paramArrayList)
  {
    this.zzq.put(paramString, paramArrayList);
  }

  public void putLong(String paramString, long paramLong)
  {
    this.zzq.put(paramString, Long.valueOf(paramLong));
  }

  public void putLongArray(String paramString, long[] paramArrayOfLong)
  {
    this.zzq.put(paramString, paramArrayOfLong);
  }

  public void putString(String paramString1, String paramString2)
  {
    this.zzq.put(paramString1, paramString2);
  }

  public void putStringArray(String paramString, String[] paramArrayOfString)
  {
    this.zzq.put(paramString, paramArrayOfString);
  }

  public void putStringArrayList(String paramString, ArrayList<String> paramArrayList)
  {
    this.zzq.put(paramString, paramArrayList);
  }

  public Object remove(String paramString)
  {
    return this.zzq.remove(paramString);
  }

  public int size()
  {
    return this.zzq.size();
  }

  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.zzq.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject1 = this.zzq.get(str);
      if ((localObject1 instanceof String))
        localBundle.putString(str, (String)localObject1);
      else if ((localObject1 instanceof Integer))
        localBundle.putInt(str, ((Integer)localObject1).intValue());
      else if ((localObject1 instanceof Long))
        localBundle.putLong(str, ((Long)localObject1).longValue());
      else if ((localObject1 instanceof Double))
        localBundle.putDouble(str, ((Double)localObject1).doubleValue());
      else if ((localObject1 instanceof Float))
        localBundle.putFloat(str, ((Float)localObject1).floatValue());
      else if ((localObject1 instanceof Boolean))
        localBundle.putBoolean(str, ((Boolean)localObject1).booleanValue());
      else if ((localObject1 instanceof Byte))
        localBundle.putByte(str, ((Byte)localObject1).byteValue());
      else if ((localObject1 instanceof byte[]))
        localBundle.putByteArray(str, (byte[])localObject1);
      else if ((localObject1 instanceof String[]))
        localBundle.putStringArray(str, (String[])localObject1);
      else if ((localObject1 instanceof long[]))
        localBundle.putLongArray(str, (long[])localObject1);
      else if ((localObject1 instanceof float[]))
        localBundle.putFloatArray(str, (float[])localObject1);
      else if ((localObject1 instanceof Asset))
        localBundle.putParcelable(str, (Asset)localObject1);
      else if ((localObject1 instanceof DataMap))
        localBundle.putParcelable(str, ((DataMap)localObject1).toBundle());
      else if ((localObject1 instanceof ArrayList))
        switch (zza((ArrayList)localObject1))
        {
        default:
          break;
        case 0:
          localBundle.putStringArrayList(str, (ArrayList)localObject1);
          break;
        case 1:
          localBundle.putStringArrayList(str, (ArrayList)localObject1);
          break;
        case 3:
          localBundle.putStringArrayList(str, (ArrayList)localObject1);
          break;
        case 2:
          localBundle.putIntegerArrayList(str, (ArrayList)localObject1);
          break;
        case 4:
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = (ArrayList)localObject1;
          int i = localArrayList2.size();
          int j = 0;
          while (j < i)
          {
            Object localObject2 = localArrayList2.get(j);
            j++;
            localArrayList1.add(((DataMap)localObject2).toBundle());
          }
          localBundle.putParcelableArrayList(str, localArrayList1);
        }
    }
    return localBundle;
  }

  public byte[] toByteArray()
  {
    return zzt.zzb(zze.zza(this).zzfw);
  }

  public String toString()
  {
    return this.zzq.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.DataMap
 * JD-Core Version:    0.6.2
 */
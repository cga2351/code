package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@KeepForSdk
@SafeParcelable.Class(creator="SafeParcelResponseCreator")
@VisibleForTesting
public class SafeParcelResponse extends FastSafeParcelableJsonResponse
{

  @KeepForSdk
  public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new zap();
  private final String mClassName;

  @SafeParcelable.VersionField(getter="getVersionCode", id=1)
  private final int zale;

  @SafeParcelable.Field(getter="getFieldMappingDictionary", id=3)
  private final zak zapy;

  @SafeParcelable.Field(getter="getParcel", id=2)
  private final Parcel zara;
  private final int zarb;
  private int zarc;
  private int zard;

  @SafeParcelable.Constructor
  SafeParcelResponse(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) Parcel paramParcel, @SafeParcelable.Param(id=3) zak paramzak)
  {
    this.zale = paramInt;
    this.zara = ((Parcel)Preconditions.checkNotNull(paramParcel));
    this.zarb = 2;
    this.zapy = paramzak;
    if (this.zapy == null);
    for (this.mClassName = null; ; this.mClassName = this.zapy.zact())
    {
      this.zarc = 2;
      return;
    }
  }

  private SafeParcelResponse(SafeParcelable paramSafeParcelable, zak paramzak, String paramString)
  {
    this.zale = 1;
    this.zara = Parcel.obtain();
    paramSafeParcelable.writeToParcel(this.zara, 0);
    this.zarb = 1;
    this.zapy = ((zak)Preconditions.checkNotNull(paramzak));
    this.mClassName = ((String)Preconditions.checkNotNull(paramString));
    this.zarc = 2;
  }

  public SafeParcelResponse(zak paramzak, String paramString)
  {
    this.zale = 1;
    this.zara = Parcel.obtain();
    this.zarb = 0;
    this.zapy = ((zak)Preconditions.checkNotNull(paramzak));
    this.mClassName = ((String)Preconditions.checkNotNull(paramString));
    this.zarc = 0;
  }

  @KeepForSdk
  public static <T extends FastJsonResponse,  extends SafeParcelable> SafeParcelResponse from(T paramT)
  {
    String str = paramT.getClass().getCanonicalName();
    zak localzak = new zak(paramT.getClass());
    zaa(localzak, paramT);
    localzak.zacs();
    localzak.zacr();
    return new SafeParcelResponse((SafeParcelable)paramT, localzak, str);
  }

  private static void zaa(zak paramzak, FastJsonResponse paramFastJsonResponse)
  {
    Class localClass1 = paramFastJsonResponse.getClass();
    if (!paramzak.zaa(localClass1))
    {
      Map localMap = paramFastJsonResponse.getFieldMappings();
      paramzak.zaa(localClass1, localMap);
      Iterator localIterator = localMap.keySet().iterator();
      while (true)
        if (localIterator.hasNext())
        {
          FastJsonResponse.Field localField = (FastJsonResponse.Field)localMap.get((String)localIterator.next());
          Class localClass2 = localField.zapw;
          if (localClass2 != null)
            try
            {
              zaa(paramzak, (FastJsonResponse)localClass2.newInstance());
            }
            catch (InstantiationException localInstantiationException)
            {
              String str3 = String.valueOf(localField.zapw.getCanonicalName());
              if (str3.length() != 0);
              for (String str4 = "Could not instantiate an object of type ".concat(str3); ; str4 = new String("Could not instantiate an object of type "))
                throw new IllegalStateException(str4, localInstantiationException);
            }
            catch (IllegalAccessException localIllegalAccessException)
            {
              String str1 = String.valueOf(localField.zapw.getCanonicalName());
              if (str1.length() != 0);
              for (String str2 = "Could not access object of type ".concat(str1); ; str2 = new String("Could not access object of type "))
                throw new IllegalStateException(str2, localIllegalAccessException);
            }
        }
    }
  }

  private static void zaa(StringBuilder paramStringBuilder, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException(26 + "Unknown type = " + paramInt);
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
      paramStringBuilder.append(paramObject);
      return;
    case 7:
      paramStringBuilder.append("\"").append(JsonUtils.escapeString(paramObject.toString())).append("\"");
      return;
    case 8:
      paramStringBuilder.append("\"").append(Base64Utils.encode((byte[])paramObject)).append("\"");
      return;
    case 9:
      paramStringBuilder.append("\"").append(Base64Utils.encodeUrlSafe((byte[])paramObject));
      paramStringBuilder.append("\"");
      return;
    case 10:
      MapUtils.writeStringMapToJson(paramStringBuilder, (HashMap)paramObject);
      return;
    case 11:
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }

  private final void zaa(StringBuilder paramStringBuilder, Map<String, FastJsonResponse.Field<?, ?>> paramMap, Parcel paramParcel)
  {
    SparseArray localSparseArray = new SparseArray();
    Iterator localIterator1 = paramMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
      localSparseArray.put(((FastJsonResponse.Field)localEntry2.getValue()).getSafeParcelableFieldId(), localEntry2);
    }
    paramStringBuilder.append('{');
    int i = SafeParcelReader.validateObjectHeader(paramParcel);
    int j = 0;
    while (paramParcel.dataPosition() < i)
    {
      int k = SafeParcelReader.readHeader(paramParcel);
      Map.Entry localEntry1 = (Map.Entry)localSparseArray.get(SafeParcelReader.getFieldId(k));
      if (localEntry1 != null)
      {
        if (j != 0)
          paramStringBuilder.append(",");
        String str1 = (String)localEntry1.getKey();
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localEntry1.getValue();
        paramStringBuilder.append("\"").append(str1).append("\":");
        if (localField.zacn())
          switch (localField.zaps)
          {
          default:
            int i2 = localField.zaps;
            throw new IllegalArgumentException(36 + "Unknown field out type = " + i2);
          case 0:
            zab(paramStringBuilder, localField, zab(localField, Integer.valueOf(SafeParcelReader.readInt(paramParcel, k))));
          case 1:
          case 2:
          case 3:
          case 4:
          case 5:
          case 6:
          case 7:
          case 8:
          case 9:
          case 10:
          case 11:
          }
        while (true)
        {
          j = 1;
          break;
          zab(paramStringBuilder, localField, zab(localField, SafeParcelReader.createBigInteger(paramParcel, k)));
          continue;
          zab(paramStringBuilder, localField, zab(localField, Long.valueOf(SafeParcelReader.readLong(paramParcel, k))));
          continue;
          zab(paramStringBuilder, localField, zab(localField, Float.valueOf(SafeParcelReader.readFloat(paramParcel, k))));
          continue;
          zab(paramStringBuilder, localField, zab(localField, Double.valueOf(SafeParcelReader.readDouble(paramParcel, k))));
          continue;
          zab(paramStringBuilder, localField, zab(localField, SafeParcelReader.createBigDecimal(paramParcel, k)));
          continue;
          zab(paramStringBuilder, localField, zab(localField, Boolean.valueOf(SafeParcelReader.readBoolean(paramParcel, k))));
          continue;
          zab(paramStringBuilder, localField, zab(localField, SafeParcelReader.createString(paramParcel, k)));
          continue;
          zab(paramStringBuilder, localField, zab(localField, SafeParcelReader.createByteArray(paramParcel, k)));
          continue;
          Bundle localBundle2 = SafeParcelReader.createBundle(paramParcel, k);
          HashMap localHashMap = new HashMap();
          Iterator localIterator3 = localBundle2.keySet().iterator();
          while (localIterator3.hasNext())
          {
            String str4 = (String)localIterator3.next();
            localHashMap.put(str4, localBundle2.getString(str4));
          }
          zab(paramStringBuilder, localField, zab(localField, localHashMap));
          continue;
          throw new IllegalArgumentException("Method does not accept concrete type.");
          if (localField.zapt)
          {
            paramStringBuilder.append("[");
            switch (localField.zaps)
            {
            default:
              throw new IllegalStateException("Unknown field type out.");
            case 0:
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createIntArray(paramParcel, k));
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            }
            while (true)
            {
              paramStringBuilder.append("]");
              break;
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createBigIntegerArray(paramParcel, k));
              continue;
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createLongArray(paramParcel, k));
              continue;
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createFloatArray(paramParcel, k));
              continue;
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createDoubleArray(paramParcel, k));
              continue;
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createBigDecimalArray(paramParcel, k));
              continue;
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createBooleanArray(paramParcel, k));
              continue;
              ArrayUtils.writeStringArray(paramStringBuilder, SafeParcelReader.createStringArray(paramParcel, k));
              continue;
              throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
              Parcel[] arrayOfParcel = SafeParcelReader.createParcelArray(paramParcel, k);
              int n = arrayOfParcel.length;
              for (int i1 = 0; i1 < n; i1++)
              {
                if (i1 > 0)
                  paramStringBuilder.append(",");
                arrayOfParcel[i1].setDataPosition(0);
                zaa(paramStringBuilder, localField.zacq(), arrayOfParcel[i1]);
              }
            }
          }
          switch (localField.zaps)
          {
          default:
            throw new IllegalStateException("Unknown field type out");
          case 0:
            paramStringBuilder.append(SafeParcelReader.readInt(paramParcel, k));
            break;
          case 1:
            paramStringBuilder.append(SafeParcelReader.createBigInteger(paramParcel, k));
            break;
          case 2:
            paramStringBuilder.append(SafeParcelReader.readLong(paramParcel, k));
            break;
          case 3:
            paramStringBuilder.append(SafeParcelReader.readFloat(paramParcel, k));
            break;
          case 4:
            paramStringBuilder.append(SafeParcelReader.readDouble(paramParcel, k));
            break;
          case 5:
            paramStringBuilder.append(SafeParcelReader.createBigDecimal(paramParcel, k));
            break;
          case 6:
            paramStringBuilder.append(SafeParcelReader.readBoolean(paramParcel, k));
            break;
          case 7:
            String str3 = SafeParcelReader.createString(paramParcel, k);
            paramStringBuilder.append("\"").append(JsonUtils.escapeString(str3)).append("\"");
            break;
          case 8:
            byte[] arrayOfByte2 = SafeParcelReader.createByteArray(paramParcel, k);
            paramStringBuilder.append("\"").append(Base64Utils.encode(arrayOfByte2)).append("\"");
            break;
          case 9:
            byte[] arrayOfByte1 = SafeParcelReader.createByteArray(paramParcel, k);
            paramStringBuilder.append("\"").append(Base64Utils.encodeUrlSafe(arrayOfByte1));
            paramStringBuilder.append("\"");
            break;
          case 10:
            Bundle localBundle1 = SafeParcelReader.createBundle(paramParcel, k);
            Set localSet = localBundle1.keySet();
            localSet.size();
            paramStringBuilder.append("{");
            Iterator localIterator2 = localSet.iterator();
            for (int m = 1; localIterator2.hasNext(); m = 0)
            {
              String str2 = (String)localIterator2.next();
              if (m == 0)
                paramStringBuilder.append(",");
              paramStringBuilder.append("\"").append(str2).append("\"");
              paramStringBuilder.append(":");
              paramStringBuilder.append("\"").append(JsonUtils.escapeString(localBundle1.getString(str2))).append("\"");
            }
            paramStringBuilder.append("}");
            break;
          case 11:
            Parcel localParcel = SafeParcelReader.createParcel(paramParcel, k);
            localParcel.setDataPosition(0);
            zaa(paramStringBuilder, localField.zacq(), localParcel);
          }
        }
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new SafeParcelReader.ParseException(37 + "Overread allowed size end=" + i, paramParcel);
    paramStringBuilder.append('}');
  }

  private final void zab(FastJsonResponse.Field<?, ?> paramField)
  {
    if (paramField.zapv != -1);
    for (int i = 1; i == 0; i = 0)
      throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
    if (this.zara == null)
      throw new IllegalStateException("Internal Parcel object is null.");
    switch (this.zarc)
    {
    default:
      throw new IllegalStateException("Unknown parse state in SafeParcelResponse.");
    case 0:
      this.zard = SafeParcelWriter.beginObjectHeader(this.zara);
      this.zarc = 1;
    case 1:
      return;
    case 2:
    }
    throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
  }

  private final void zab(StringBuilder paramStringBuilder, FastJsonResponse.Field<?, ?> paramField, Object paramObject)
  {
    if (paramField.zapr)
    {
      ArrayList localArrayList = (ArrayList)paramObject;
      paramStringBuilder.append("[");
      int i = localArrayList.size();
      for (int j = 0; j < i; j++)
      {
        if (j != 0)
          paramStringBuilder.append(",");
        zaa(paramStringBuilder, paramField.zapq, localArrayList.get(j));
      }
      paramStringBuilder.append("]");
      return;
    }
    zaa(paramStringBuilder, paramField.zapq, paramObject);
  }

  private final Parcel zacu()
  {
    switch (this.zarc)
    {
    default:
    case 0:
    case 1:
    }
    while (true)
    {
      return this.zara;
      this.zard = SafeParcelWriter.beginObjectHeader(this.zara);
      SafeParcelWriter.finishObjectHeader(this.zara, this.zard);
      this.zarc = 2;
    }
  }

  public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<T> paramArrayList)
  {
    zab(paramField);
    ArrayList localArrayList1 = new ArrayList();
    paramArrayList.size();
    ArrayList localArrayList2 = (ArrayList)paramArrayList;
    int i = localArrayList2.size();
    int j = 0;
    while (j < i)
    {
      Object localObject = localArrayList2.get(j);
      j++;
      localArrayList1.add(((SafeParcelResponse)localObject).zacu());
    }
    SafeParcelWriter.writeParcelList(this.zara, paramField.getSafeParcelableFieldId(), localArrayList1, true);
  }

  public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, T paramT)
  {
    zab(paramField);
    Parcel localParcel = ((SafeParcelResponse)paramT).zacu();
    SafeParcelWriter.writeParcel(this.zara, paramField.getSafeParcelableFieldId(), localParcel, true);
  }

  public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings()
  {
    if (this.zapy == null)
      return null;
    return this.zapy.zai(this.mClassName);
  }

  public Object getValueObject(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }

  public boolean isPrimitiveFieldSet(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }

  protected void setBooleanInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, boolean paramBoolean)
  {
    zab(paramField);
    SafeParcelWriter.writeBoolean(this.zara, paramField.getSafeParcelableFieldId(), paramBoolean);
  }

  protected void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, byte[] paramArrayOfByte)
  {
    zab(paramField);
    SafeParcelWriter.writeByteArray(this.zara, paramField.getSafeParcelableFieldId(), paramArrayOfByte, true);
  }

  protected void setIntegerInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, int paramInt)
  {
    zab(paramField);
    SafeParcelWriter.writeInt(this.zara, paramField.getSafeParcelableFieldId(), paramInt);
  }

  protected void setLongInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, long paramLong)
  {
    zab(paramField);
    SafeParcelWriter.writeLong(this.zara, paramField.getSafeParcelableFieldId(), paramLong);
  }

  protected void setStringInternal(FastJsonResponse.Field<?, ?> paramField, String paramString1, String paramString2)
  {
    zab(paramField);
    SafeParcelWriter.writeString(this.zara, paramField.getSafeParcelableFieldId(), paramString2, true);
  }

  protected void setStringsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<String> paramArrayList)
  {
    zab(paramField);
    int i = paramArrayList.size();
    String[] arrayOfString = new String[i];
    for (int j = 0; j < i; j++)
      arrayOfString[j] = ((String)paramArrayList.get(j));
    SafeParcelWriter.writeStringArray(this.zara, paramField.getSafeParcelableFieldId(), arrayOfString, true);
  }

  public String toString()
  {
    Preconditions.checkNotNull(this.zapy, "Cannot convert to JSON on client side.");
    Parcel localParcel = zacu();
    localParcel.setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    zaa(localStringBuilder, this.zapy.zai(this.mClassName), localParcel);
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    SafeParcelWriter.writeParcel(paramParcel, 2, zacu(), false);
    Object localObject;
    switch (this.zarb)
    {
    default:
      int j = this.zarb;
      throw new IllegalStateException(34 + "Invalid creation type: " + j);
    case 0:
      localObject = null;
    case 1:
    case 2:
    }
    while (true)
    {
      SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)localObject, paramInt, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, i);
      return;
      localObject = this.zapy;
      continue;
      localObject = this.zapy;
    }
  }

  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, double paramDouble)
  {
    zab(paramField);
    SafeParcelWriter.writeDouble(this.zara, paramField.getSafeParcelableFieldId(), paramDouble);
  }

  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, float paramFloat)
  {
    zab(paramField);
    SafeParcelWriter.writeFloat(this.zara, paramField.getSafeParcelableFieldId(), paramFloat);
  }

  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, BigDecimal paramBigDecimal)
  {
    zab(paramField);
    SafeParcelWriter.writeBigDecimal(this.zara, paramField.getSafeParcelableFieldId(), paramBigDecimal, true);
  }

  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, BigInteger paramBigInteger)
  {
    zab(paramField);
    SafeParcelWriter.writeBigInteger(this.zara, paramField.getSafeParcelableFieldId(), paramBigInteger, true);
  }

  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Integer> paramArrayList)
  {
    zab(paramField);
    int i = paramArrayList.size();
    int[] arrayOfInt = new int[i];
    for (int j = 0; j < i; j++)
      arrayOfInt[j] = ((Integer)paramArrayList.get(j)).intValue();
    SafeParcelWriter.writeIntArray(this.zara, paramField.getSafeParcelableFieldId(), arrayOfInt, true);
  }

  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, Map<String, String> paramMap)
  {
    zab(paramField);
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localBundle.putString(str, (String)paramMap.get(str));
    }
    SafeParcelWriter.writeBundle(this.zara, paramField.getSafeParcelableFieldId(), localBundle, true);
  }

  protected final void zab(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<BigInteger> paramArrayList)
  {
    zab(paramField);
    int i = paramArrayList.size();
    BigInteger[] arrayOfBigInteger = new BigInteger[i];
    for (int j = 0; j < i; j++)
      arrayOfBigInteger[j] = ((BigInteger)paramArrayList.get(j));
    SafeParcelWriter.writeBigIntegerArray(this.zara, paramField.getSafeParcelableFieldId(), arrayOfBigInteger, true);
  }

  protected final void zac(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Long> paramArrayList)
  {
    zab(paramField);
    int i = paramArrayList.size();
    long[] arrayOfLong = new long[i];
    for (int j = 0; j < i; j++)
      arrayOfLong[j] = ((Long)paramArrayList.get(j)).longValue();
    SafeParcelWriter.writeLongArray(this.zara, paramField.getSafeParcelableFieldId(), arrayOfLong, true);
  }

  protected final void zad(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Float> paramArrayList)
  {
    zab(paramField);
    int i = paramArrayList.size();
    float[] arrayOfFloat = new float[i];
    for (int j = 0; j < i; j++)
      arrayOfFloat[j] = ((Float)paramArrayList.get(j)).floatValue();
    SafeParcelWriter.writeFloatArray(this.zara, paramField.getSafeParcelableFieldId(), arrayOfFloat, true);
  }

  protected final void zae(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Double> paramArrayList)
  {
    zab(paramField);
    int i = paramArrayList.size();
    double[] arrayOfDouble = new double[i];
    for (int j = 0; j < i; j++)
      arrayOfDouble[j] = ((Double)paramArrayList.get(j)).doubleValue();
    SafeParcelWriter.writeDoubleArray(this.zara, paramField.getSafeParcelableFieldId(), arrayOfDouble, true);
  }

  protected final void zaf(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<BigDecimal> paramArrayList)
  {
    zab(paramField);
    int i = paramArrayList.size();
    BigDecimal[] arrayOfBigDecimal = new BigDecimal[i];
    for (int j = 0; j < i; j++)
      arrayOfBigDecimal[j] = ((BigDecimal)paramArrayList.get(j));
    SafeParcelWriter.writeBigDecimalArray(this.zara, paramField.getSafeParcelableFieldId(), arrayOfBigDecimal, true);
  }

  protected final void zag(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Boolean> paramArrayList)
  {
    zab(paramField);
    int i = paramArrayList.size();
    boolean[] arrayOfBoolean = new boolean[i];
    for (int j = 0; j < i; j++)
      arrayOfBoolean[j] = ((Boolean)paramArrayList.get(j)).booleanValue();
    SafeParcelWriter.writeBooleanArray(this.zara, paramField.getSafeParcelableFieldId(), arrayOfBoolean, true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.server.response.SafeParcelResponse
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class SafeParcelWriter
{
  public static int beginObjectHeader(Parcel paramParcel)
  {
    return zza(paramParcel, 20293);
  }

  public static void finishObjectHeader(Parcel paramParcel, int paramInt)
  {
    zzb(paramParcel, paramInt);
  }

  public static void writeBigDecimal(Parcel paramParcel, int paramInt, BigDecimal paramBigDecimal, boolean paramBoolean)
  {
    if (paramBigDecimal == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    paramParcel.writeByteArray(paramBigDecimal.unscaledValue().toByteArray());
    paramParcel.writeInt(paramBigDecimal.scale());
    zzb(paramParcel, i);
  }

  public static void writeBigDecimalArray(Parcel paramParcel, int paramInt, BigDecimal[] paramArrayOfBigDecimal, boolean paramBoolean)
  {
    int i = 0;
    if (paramArrayOfBigDecimal == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int j = zza(paramParcel, paramInt);
    int k = paramArrayOfBigDecimal.length;
    paramParcel.writeInt(k);
    while (i < k)
    {
      paramParcel.writeByteArray(paramArrayOfBigDecimal[i].unscaledValue().toByteArray());
      paramParcel.writeInt(paramArrayOfBigDecimal[i].scale());
      i++;
    }
    zzb(paramParcel, j);
  }

  public static void writeBigInteger(Parcel paramParcel, int paramInt, BigInteger paramBigInteger, boolean paramBoolean)
  {
    if (paramBigInteger == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    paramParcel.writeByteArray(paramBigInteger.toByteArray());
    zzb(paramParcel, i);
  }

  public static void writeBigIntegerArray(Parcel paramParcel, int paramInt, BigInteger[] paramArrayOfBigInteger, boolean paramBoolean)
  {
    int i = 0;
    if (paramArrayOfBigInteger == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int j = zza(paramParcel, paramInt);
    int k = paramArrayOfBigInteger.length;
    paramParcel.writeInt(k);
    while (i < k)
    {
      paramParcel.writeByteArray(paramArrayOfBigInteger[i].toByteArray());
      i++;
    }
    zzb(paramParcel, j);
  }

  public static void writeBoolean(Parcel paramParcel, int paramInt, boolean paramBoolean)
  {
    zzb(paramParcel, paramInt, 4);
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }

  public static void writeBooleanArray(Parcel paramParcel, int paramInt, boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    if (paramArrayOfBoolean == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    paramParcel.writeBooleanArray(paramArrayOfBoolean);
    zzb(paramParcel, i);
  }

  public static void writeBooleanList(Parcel paramParcel, int paramInt, List<Boolean> paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    int k = 0;
    if (k < j)
    {
      if (((Boolean)paramList.get(k)).booleanValue());
      for (int m = 1; ; m = 0)
      {
        paramParcel.writeInt(m);
        k++;
        break;
      }
    }
    zzb(paramParcel, i);
  }

  public static void writeBooleanObject(Parcel paramParcel, int paramInt, Boolean paramBoolean, boolean paramBoolean1)
  {
    if (paramBoolean == null)
    {
      if (paramBoolean1)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    zzb(paramParcel, paramInt, 4);
    boolean bool = paramBoolean.booleanValue();
    int i = 0;
    if (bool)
      i = 1;
    paramParcel.writeInt(i);
  }

  public static void writeBundle(Parcel paramParcel, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    paramParcel.writeBundle(paramBundle);
    zzb(paramParcel, i);
  }

  public static void writeByte(Parcel paramParcel, int paramInt, byte paramByte)
  {
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramByte);
  }

  public static void writeByteArray(Parcel paramParcel, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    paramParcel.writeByteArray(paramArrayOfByte);
    zzb(paramParcel, i);
  }

  public static void writeByteArrayArray(Parcel paramParcel, int paramInt, byte[][] paramArrayOfByte, boolean paramBoolean)
  {
    int i = 0;
    if (paramArrayOfByte == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int j = zza(paramParcel, paramInt);
    int k = paramArrayOfByte.length;
    paramParcel.writeInt(k);
    while (i < k)
    {
      paramParcel.writeByteArray(paramArrayOfByte[i]);
      i++;
    }
    zzb(paramParcel, j);
  }

  public static void writeByteArraySparseArray(Parcel paramParcel, int paramInt, SparseArray<byte[]> paramSparseArray, boolean paramBoolean)
  {
    if (paramSparseArray == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    for (int k = 0; k < j; k++)
    {
      paramParcel.writeInt(paramSparseArray.keyAt(k));
      paramParcel.writeByteArray((byte[])paramSparseArray.valueAt(k));
    }
    zzb(paramParcel, i);
  }

  public static void writeChar(Parcel paramParcel, int paramInt, char paramChar)
  {
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramChar);
  }

  public static void writeCharArray(Parcel paramParcel, int paramInt, char[] paramArrayOfChar, boolean paramBoolean)
  {
    if (paramArrayOfChar == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    paramParcel.writeCharArray(paramArrayOfChar);
    zzb(paramParcel, i);
  }

  public static void writeDouble(Parcel paramParcel, int paramInt, double paramDouble)
  {
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeDouble(paramDouble);
  }

  public static void writeDoubleArray(Parcel paramParcel, int paramInt, double[] paramArrayOfDouble, boolean paramBoolean)
  {
    if (paramArrayOfDouble == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    paramParcel.writeDoubleArray(paramArrayOfDouble);
    zzb(paramParcel, i);
  }

  public static void writeDoubleList(Parcel paramParcel, int paramInt, List<Double> paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    for (int k = 0; k < j; k++)
      paramParcel.writeDouble(((Double)paramList.get(k)).doubleValue());
    zzb(paramParcel, i);
  }

  public static void writeDoubleObject(Parcel paramParcel, int paramInt, Double paramDouble, boolean paramBoolean)
  {
    if (paramDouble == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeDouble(paramDouble.doubleValue());
  }

  public static void writeDoubleSparseArray(Parcel paramParcel, int paramInt, SparseArray<Double> paramSparseArray, boolean paramBoolean)
  {
    if (paramSparseArray == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    for (int k = 0; k < j; k++)
    {
      paramParcel.writeInt(paramSparseArray.keyAt(k));
      paramParcel.writeDouble(((Double)paramSparseArray.valueAt(k)).doubleValue());
    }
    zzb(paramParcel, i);
  }

  public static void writeFloat(Parcel paramParcel, int paramInt, float paramFloat)
  {
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeFloat(paramFloat);
  }

  public static void writeFloatArray(Parcel paramParcel, int paramInt, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if (paramArrayOfFloat == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    paramParcel.writeFloatArray(paramArrayOfFloat);
    zzb(paramParcel, i);
  }

  public static void writeFloatList(Parcel paramParcel, int paramInt, List<Float> paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    for (int k = 0; k < j; k++)
      paramParcel.writeFloat(((Float)paramList.get(k)).floatValue());
    zzb(paramParcel, i);
  }

  public static void writeFloatObject(Parcel paramParcel, int paramInt, Float paramFloat, boolean paramBoolean)
  {
    if (paramFloat == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeFloat(paramFloat.floatValue());
  }

  public static void writeFloatSparseArray(Parcel paramParcel, int paramInt, SparseArray<Float> paramSparseArray, boolean paramBoolean)
  {
    if (paramSparseArray == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    for (int k = 0; k < j; k++)
    {
      paramParcel.writeInt(paramSparseArray.keyAt(k));
      paramParcel.writeFloat(((Float)paramSparseArray.valueAt(k)).floatValue());
    }
    zzb(paramParcel, i);
  }

  public static void writeIBinder(Parcel paramParcel, int paramInt, IBinder paramIBinder, boolean paramBoolean)
  {
    if (paramIBinder == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    paramParcel.writeStrongBinder(paramIBinder);
    zzb(paramParcel, i);
  }

  public static void writeIBinderArray(Parcel paramParcel, int paramInt, IBinder[] paramArrayOfIBinder, boolean paramBoolean)
  {
    if (paramArrayOfIBinder == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    paramParcel.writeBinderArray(paramArrayOfIBinder);
    zzb(paramParcel, i);
  }

  public static void writeIBinderList(Parcel paramParcel, int paramInt, List<IBinder> paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    paramParcel.writeBinderList(paramList);
    zzb(paramParcel, i);
  }

  public static void writeIBinderSparseArray(Parcel paramParcel, int paramInt, SparseArray<IBinder> paramSparseArray, boolean paramBoolean)
  {
    if (paramSparseArray == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    for (int k = 0; k < j; k++)
    {
      paramParcel.writeInt(paramSparseArray.keyAt(k));
      paramParcel.writeStrongBinder((IBinder)paramSparseArray.valueAt(k));
    }
    zzb(paramParcel, i);
  }

  public static void writeInt(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    zzb(paramParcel, paramInt1, 4);
    paramParcel.writeInt(paramInt2);
  }

  public static void writeIntArray(Parcel paramParcel, int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    if (paramArrayOfInt == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    paramParcel.writeIntArray(paramArrayOfInt);
    zzb(paramParcel, i);
  }

  public static void writeIntegerList(Parcel paramParcel, int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    for (int k = 0; k < j; k++)
      paramParcel.writeInt(((Integer)paramList.get(k)).intValue());
    zzb(paramParcel, i);
  }

  public static void writeIntegerObject(Parcel paramParcel, int paramInt, Integer paramInteger, boolean paramBoolean)
  {
    if (paramInteger == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramInteger.intValue());
  }

  public static void writeList(Parcel paramParcel, int paramInt, List paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    paramParcel.writeList(paramList);
    zzb(paramParcel, i);
  }

  public static void writeLong(Parcel paramParcel, int paramInt, long paramLong)
  {
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong);
  }

  public static void writeLongArray(Parcel paramParcel, int paramInt, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (paramArrayOfLong == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    paramParcel.writeLongArray(paramArrayOfLong);
    zzb(paramParcel, i);
  }

  public static void writeLongList(Parcel paramParcel, int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    for (int k = 0; k < j; k++)
      paramParcel.writeLong(((Long)paramList.get(k)).longValue());
    zzb(paramParcel, i);
  }

  public static void writeLongObject(Parcel paramParcel, int paramInt, Long paramLong, boolean paramBoolean)
  {
    if (paramLong == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong.longValue());
  }

  public static void writeParcel(Parcel paramParcel1, int paramInt, Parcel paramParcel2, boolean paramBoolean)
  {
    if (paramParcel2 == null)
    {
      if (paramBoolean)
        zzb(paramParcel1, paramInt, 0);
      return;
    }
    int i = zza(paramParcel1, paramInt);
    paramParcel1.appendFrom(paramParcel2, 0, paramParcel2.dataSize());
    zzb(paramParcel1, i);
  }

  public static void writeParcelArray(Parcel paramParcel, int paramInt, Parcel[] paramArrayOfParcel, boolean paramBoolean)
  {
    if (paramArrayOfParcel == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramArrayOfParcel.length;
    paramParcel.writeInt(j);
    int k = 0;
    if (k < j)
    {
      Parcel localParcel = paramArrayOfParcel[k];
      if (localParcel != null)
      {
        paramParcel.writeInt(localParcel.dataSize());
        paramParcel.appendFrom(localParcel, 0, localParcel.dataSize());
      }
      while (true)
      {
        k++;
        break;
        paramParcel.writeInt(0);
      }
    }
    zzb(paramParcel, i);
  }

  public static void writeParcelList(Parcel paramParcel, int paramInt, List<Parcel> paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    int k = 0;
    if (k < j)
    {
      Parcel localParcel = (Parcel)paramList.get(k);
      if (localParcel != null)
      {
        paramParcel.writeInt(localParcel.dataSize());
        paramParcel.appendFrom(localParcel, 0, localParcel.dataSize());
      }
      while (true)
      {
        k++;
        break;
        paramParcel.writeInt(0);
      }
    }
    zzb(paramParcel, i);
  }

  public static void writeParcelSparseArray(Parcel paramParcel, int paramInt, SparseArray<Parcel> paramSparseArray, boolean paramBoolean)
  {
    if (paramSparseArray == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    int k = 0;
    if (k < j)
    {
      paramParcel.writeInt(paramSparseArray.keyAt(k));
      Parcel localParcel = (Parcel)paramSparseArray.valueAt(k);
      if (localParcel != null)
      {
        paramParcel.writeInt(localParcel.dataSize());
        paramParcel.appendFrom(localParcel, 0, localParcel.dataSize());
      }
      while (true)
      {
        k++;
        break;
        paramParcel.writeInt(0);
      }
    }
    zzb(paramParcel, i);
  }

  public static void writeParcelable(Parcel paramParcel, int paramInt1, Parcelable paramParcelable, int paramInt2, boolean paramBoolean)
  {
    if (paramParcelable == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt1, 0);
      return;
    }
    int i = zza(paramParcel, paramInt1);
    paramParcelable.writeToParcel(paramParcel, paramInt2);
    zzb(paramParcel, i);
  }

  public static void writeShort(Parcel paramParcel, int paramInt, short paramShort)
  {
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramShort);
  }

  public static void writeSparseBooleanArray(Parcel paramParcel, int paramInt, SparseBooleanArray paramSparseBooleanArray, boolean paramBoolean)
  {
    if (paramSparseBooleanArray == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    paramParcel.writeSparseBooleanArray(paramSparseBooleanArray);
    zzb(paramParcel, i);
  }

  public static void writeSparseIntArray(Parcel paramParcel, int paramInt, SparseIntArray paramSparseIntArray, boolean paramBoolean)
  {
    int i = 0;
    if (paramSparseIntArray == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int j = zza(paramParcel, paramInt);
    int k = paramSparseIntArray.size();
    paramParcel.writeInt(k);
    while (i < k)
    {
      paramParcel.writeInt(paramSparseIntArray.keyAt(i));
      paramParcel.writeInt(paramSparseIntArray.valueAt(i));
      i++;
    }
    zzb(paramParcel, j);
  }

  public static void writeSparseLongArray(Parcel paramParcel, int paramInt, SparseLongArray paramSparseLongArray, boolean paramBoolean)
  {
    int i = 0;
    if (paramSparseLongArray == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int j = zza(paramParcel, paramInt);
    int k = paramSparseLongArray.size();
    paramParcel.writeInt(k);
    while (i < k)
    {
      paramParcel.writeInt(paramSparseLongArray.keyAt(i));
      paramParcel.writeLong(paramSparseLongArray.valueAt(i));
      i++;
    }
    zzb(paramParcel, j);
  }

  public static void writeString(Parcel paramParcel, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    paramParcel.writeString(paramString);
    zzb(paramParcel, i);
  }

  public static void writeStringArray(Parcel paramParcel, int paramInt, String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramArrayOfString == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    paramParcel.writeStringArray(paramArrayOfString);
    zzb(paramParcel, i);
  }

  public static void writeStringList(Parcel paramParcel, int paramInt, List<String> paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    paramParcel.writeStringList(paramList);
    zzb(paramParcel, i);
  }

  public static void writeStringSparseArray(Parcel paramParcel, int paramInt, SparseArray<String> paramSparseArray, boolean paramBoolean)
  {
    if (paramSparseArray == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    for (int k = 0; k < j; k++)
    {
      paramParcel.writeInt(paramSparseArray.keyAt(k));
      paramParcel.writeString((String)paramSparseArray.valueAt(k));
    }
    zzb(paramParcel, i);
  }

  public static <T extends Parcelable> void writeTypedArray(Parcel paramParcel, int paramInt1, T[] paramArrayOfT, int paramInt2, boolean paramBoolean)
  {
    if (paramArrayOfT == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt1, 0);
      return;
    }
    int i = zza(paramParcel, paramInt1);
    int j = paramArrayOfT.length;
    paramParcel.writeInt(j);
    int k = 0;
    if (k < j)
    {
      T ? = paramArrayOfT[k];
      if (? == null)
        paramParcel.writeInt(0);
      while (true)
      {
        k++;
        break;
        zza(paramParcel, ?, paramInt2);
      }
    }
    zzb(paramParcel, i);
  }

  public static <T extends Parcelable> void writeTypedList(Parcel paramParcel, int paramInt, List<T> paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    int k = 0;
    if (k < j)
    {
      Parcelable localParcelable = (Parcelable)paramList.get(k);
      if (localParcelable == null)
        paramParcel.writeInt(0);
      while (true)
      {
        k++;
        break;
        zza(paramParcel, localParcelable, 0);
      }
    }
    zzb(paramParcel, i);
  }

  public static <T extends Parcelable> void writeTypedSparseArray(Parcel paramParcel, int paramInt, SparseArray<T> paramSparseArray, boolean paramBoolean)
  {
    if (paramSparseArray == null)
    {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    int k = 0;
    if (k < j)
    {
      paramParcel.writeInt(paramSparseArray.keyAt(k));
      Parcelable localParcelable = (Parcelable)paramSparseArray.valueAt(k);
      if (localParcelable == null)
        paramParcel.writeInt(0);
      while (true)
      {
        k++;
        break;
        zza(paramParcel, localParcelable, 0);
      }
    }
    zzb(paramParcel, i);
  }

  private static int zza(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(0xFFFF0000 | paramInt);
    paramParcel.writeInt(0);
    return paramParcel.dataPosition();
  }

  private static <T extends Parcelable> void zza(Parcel paramParcel, T paramT, int paramInt)
  {
    int i = paramParcel.dataPosition();
    paramParcel.writeInt(1);
    int j = paramParcel.dataPosition();
    paramT.writeToParcel(paramParcel, paramInt);
    int k = paramParcel.dataPosition();
    paramParcel.setDataPosition(i);
    paramParcel.writeInt(k - j);
    paramParcel.setDataPosition(k);
  }

  private static void zzb(Parcel paramParcel, int paramInt)
  {
    int i = paramParcel.dataPosition();
    int j = i - paramInt;
    paramParcel.setDataPosition(paramInt - 4);
    paramParcel.writeInt(j);
    paramParcel.setDataPosition(i);
  }

  private static void zzb(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 65535)
    {
      paramParcel.writeInt(0xFFFF0000 | paramInt1);
      paramParcel.writeInt(paramInt2);
      return;
    }
    paramParcel.writeInt(paramInt1 | paramInt2 << 16);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SafeParcelReader
{
  public static BigDecimal createBigDecimal(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    byte[] arrayOfByte = paramParcel.createByteArray();
    int k = paramParcel.readInt();
    paramParcel.setDataPosition(i + j);
    return new BigDecimal(new BigInteger(arrayOfByte), k);
  }

  public static BigDecimal[] createBigDecimalArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    int k = paramParcel.readInt();
    BigDecimal[] arrayOfBigDecimal = new BigDecimal[k];
    for (int m = 0; m < k; m++)
    {
      byte[] arrayOfByte = paramParcel.createByteArray();
      int n = paramParcel.readInt();
      arrayOfBigDecimal[m] = new BigDecimal(new BigInteger(arrayOfByte), n);
    }
    paramParcel.setDataPosition(j + i);
    return arrayOfBigDecimal;
  }

  public static BigInteger createBigInteger(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(i + j);
    return new BigInteger(arrayOfByte);
  }

  public static BigInteger[] createBigIntegerArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    int k = paramParcel.readInt();
    BigInteger[] arrayOfBigInteger = new BigInteger[k];
    for (int m = 0; m < k; m++)
      arrayOfBigInteger[m] = new BigInteger(paramParcel.createByteArray());
    paramParcel.setDataPosition(j + i);
    return arrayOfBigInteger;
  }

  public static boolean[] createBooleanArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    boolean[] arrayOfBoolean = paramParcel.createBooleanArray();
    paramParcel.setDataPosition(i + j);
    return arrayOfBoolean;
  }

  public static ArrayList<Boolean> createBooleanList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    int m = 0;
    if (m < k)
    {
      if (paramParcel.readInt() != 0);
      for (boolean bool = true; ; bool = false)
      {
        localArrayList.add(Boolean.valueOf(bool));
        m++;
        break;
      }
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }

  public static Bundle createBundle(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    Bundle localBundle = paramParcel.readBundle();
    paramParcel.setDataPosition(i + j);
    return localBundle;
  }

  public static byte[] createByteArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(i + j);
    return arrayOfByte;
  }

  public static byte[][] createByteArrayArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    int k = paramParcel.readInt();
    byte[][] arrayOfByte = new byte[k][];
    for (int m = 0; m < k; m++)
      arrayOfByte[m] = paramParcel.createByteArray();
    paramParcel.setDataPosition(j + i);
    return arrayOfByte;
  }

  public static SparseArray<byte[]> createByteArraySparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    int k = paramParcel.readInt();
    SparseArray localSparseArray = new SparseArray(k);
    for (int m = 0; m < k; m++)
      localSparseArray.append(paramParcel.readInt(), paramParcel.createByteArray());
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }

  public static char[] createCharArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    char[] arrayOfChar = paramParcel.createCharArray();
    paramParcel.setDataPosition(i + j);
    return arrayOfChar;
  }

  public static double[] createDoubleArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    double[] arrayOfDouble = paramParcel.createDoubleArray();
    paramParcel.setDataPosition(i + j);
    return arrayOfDouble;
  }

  public static ArrayList<Double> createDoubleList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    for (int m = 0; m < k; m++)
      localArrayList.add(Double.valueOf(paramParcel.readDouble()));
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }

  public static SparseArray<Double> createDoubleSparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    SparseArray localSparseArray = new SparseArray();
    int k = paramParcel.readInt();
    for (int m = 0; m < k; m++)
      localSparseArray.append(paramParcel.readInt(), Double.valueOf(paramParcel.readDouble()));
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }

  public static float[] createFloatArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    float[] arrayOfFloat = paramParcel.createFloatArray();
    paramParcel.setDataPosition(i + j);
    return arrayOfFloat;
  }

  public static ArrayList<Float> createFloatList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    for (int m = 0; m < k; m++)
      localArrayList.add(Float.valueOf(paramParcel.readFloat()));
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }

  public static SparseArray<Float> createFloatSparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    SparseArray localSparseArray = new SparseArray();
    int k = paramParcel.readInt();
    for (int m = 0; m < k; m++)
      localSparseArray.append(paramParcel.readInt(), Float.valueOf(paramParcel.readFloat()));
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }

  public static IBinder[] createIBinderArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    IBinder[] arrayOfIBinder = paramParcel.createBinderArray();
    paramParcel.setDataPosition(i + j);
    return arrayOfIBinder;
  }

  public static ArrayList<IBinder> createIBinderList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    ArrayList localArrayList = paramParcel.createBinderArrayList();
    paramParcel.setDataPosition(i + j);
    return localArrayList;
  }

  public static SparseArray<IBinder> createIBinderSparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    int k = paramParcel.readInt();
    SparseArray localSparseArray = new SparseArray(k);
    for (int m = 0; m < k; m++)
      localSparseArray.append(paramParcel.readInt(), paramParcel.readStrongBinder());
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }

  public static int[] createIntArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    int[] arrayOfInt = paramParcel.createIntArray();
    paramParcel.setDataPosition(i + j);
    return arrayOfInt;
  }

  public static ArrayList<Integer> createIntegerList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    for (int m = 0; m < k; m++)
      localArrayList.add(Integer.valueOf(paramParcel.readInt()));
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }

  public static long[] createLongArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    long[] arrayOfLong = paramParcel.createLongArray();
    paramParcel.setDataPosition(i + j);
    return arrayOfLong;
  }

  public static ArrayList<Long> createLongList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    for (int m = 0; m < k; m++)
      localArrayList.add(Long.valueOf(paramParcel.readLong()));
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }

  public static Parcel createParcel(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    Parcel localParcel = Parcel.obtain();
    localParcel.appendFrom(paramParcel, j, i);
    paramParcel.setDataPosition(i + j);
    return localParcel;
  }

  public static Parcel[] createParcelArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    int k = paramParcel.readInt();
    Parcel[] arrayOfParcel = new Parcel[k];
    int m = 0;
    if (m < k)
    {
      int n = paramParcel.readInt();
      if (n != 0)
      {
        int i1 = paramParcel.dataPosition();
        Parcel localParcel = Parcel.obtain();
        localParcel.appendFrom(paramParcel, i1, n);
        arrayOfParcel[m] = localParcel;
        paramParcel.setDataPosition(n + i1);
      }
      while (true)
      {
        m++;
        break;
        arrayOfParcel[m] = null;
      }
    }
    paramParcel.setDataPosition(j + i);
    return arrayOfParcel;
  }

  public static ArrayList<Parcel> createParcelList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    int k = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList();
    int m = 0;
    if (m < k)
    {
      int n = paramParcel.readInt();
      if (n != 0)
      {
        int i1 = paramParcel.dataPosition();
        Parcel localParcel = Parcel.obtain();
        localParcel.appendFrom(paramParcel, i1, n);
        localArrayList.add(localParcel);
        paramParcel.setDataPosition(n + i1);
      }
      while (true)
      {
        m++;
        break;
        localArrayList.add(null);
      }
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }

  public static SparseArray<Parcel> createParcelSparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    int k = paramParcel.readInt();
    SparseArray localSparseArray = new SparseArray();
    int m = 0;
    if (m < k)
    {
      int n = paramParcel.readInt();
      int i1 = paramParcel.readInt();
      if (i1 != 0)
      {
        int i2 = paramParcel.dataPosition();
        Parcel localParcel = Parcel.obtain();
        localParcel.appendFrom(paramParcel, i2, i1);
        localSparseArray.append(n, localParcel);
        paramParcel.setDataPosition(i2 + i1);
      }
      while (true)
      {
        m++;
        break;
        localSparseArray.append(n, null);
      }
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }

  public static <T extends Parcelable> T createParcelable(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    Parcelable localParcelable = (Parcelable)paramCreator.createFromParcel(paramParcel);
    paramParcel.setDataPosition(i + j);
    return localParcelable;
  }

  public static SparseBooleanArray createSparseBooleanArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    SparseBooleanArray localSparseBooleanArray = paramParcel.readSparseBooleanArray();
    paramParcel.setDataPosition(i + j);
    return localSparseBooleanArray;
  }

  public static SparseIntArray createSparseIntArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int k = paramParcel.readInt();
    for (int m = 0; m < k; m++)
      localSparseIntArray.append(paramParcel.readInt(), paramParcel.readInt());
    paramParcel.setDataPosition(j + i);
    return localSparseIntArray;
  }

  public static SparseLongArray createSparseLongArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    SparseLongArray localSparseLongArray = new SparseLongArray();
    int k = paramParcel.readInt();
    for (int m = 0; m < k; m++)
      localSparseLongArray.append(paramParcel.readInt(), paramParcel.readLong());
    paramParcel.setDataPosition(j + i);
    return localSparseLongArray;
  }

  public static String createString(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    String str = paramParcel.readString();
    paramParcel.setDataPosition(i + j);
    return str;
  }

  public static String[] createStringArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    String[] arrayOfString = paramParcel.createStringArray();
    paramParcel.setDataPosition(i + j);
    return arrayOfString;
  }

  public static ArrayList<String> createStringList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    ArrayList localArrayList = paramParcel.createStringArrayList();
    paramParcel.setDataPosition(i + j);
    return localArrayList;
  }

  public static SparseArray<String> createStringSparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    SparseArray localSparseArray = new SparseArray();
    int k = paramParcel.readInt();
    for (int m = 0; m < k; m++)
      localSparseArray.append(paramParcel.readInt(), paramParcel.readString());
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }

  public static <T> T[] createTypedArray(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    Object[] arrayOfObject = paramParcel.createTypedArray(paramCreator);
    paramParcel.setDataPosition(i + j);
    return arrayOfObject;
  }

  public static <T> ArrayList<T> createTypedList(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    ArrayList localArrayList = paramParcel.createTypedArrayList(paramCreator);
    paramParcel.setDataPosition(i + j);
    return localArrayList;
  }

  public static <T> SparseArray<T> createTypedSparseArray(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    int k = paramParcel.readInt();
    SparseArray localSparseArray = new SparseArray();
    int m = 0;
    if (m < k)
    {
      int n = paramParcel.readInt();
      if (paramParcel.readInt() != 0);
      for (Object localObject = paramCreator.createFromParcel(paramParcel); ; localObject = null)
      {
        localSparseArray.append(n, localObject);
        m++;
        break;
      }
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }

  public static void ensureAtEnd(Parcel paramParcel, int paramInt)
  {
    if (paramParcel.dataPosition() != paramInt)
      throw new ParseException(37 + "Overread allowed size end=" + paramInt, paramParcel);
  }

  public static int getFieldId(int paramInt)
  {
    return 0xFFFF & paramInt;
  }

  public static boolean readBoolean(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 4);
    return paramParcel.readInt() != 0;
  }

  public static Boolean readBooleanObject(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
      return null;
    zza(paramParcel, paramInt, i, 4);
    if (paramParcel.readInt() != 0);
    for (boolean bool = true; ; bool = false)
      return Boolean.valueOf(bool);
  }

  public static byte readByte(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 4);
    return (byte)paramParcel.readInt();
  }

  public static char readChar(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 4);
    return (char)paramParcel.readInt();
  }

  public static double readDouble(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 8);
    return paramParcel.readDouble();
  }

  public static Double readDoubleObject(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
      return null;
    zza(paramParcel, paramInt, i, 8);
    return Double.valueOf(paramParcel.readDouble());
  }

  public static float readFloat(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 4);
    return paramParcel.readFloat();
  }

  public static Float readFloatObject(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
      return null;
    zza(paramParcel, paramInt, i, 4);
    return Float.valueOf(paramParcel.readFloat());
  }

  public static int readHeader(Parcel paramParcel)
  {
    return paramParcel.readInt();
  }

  public static IBinder readIBinder(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    IBinder localIBinder = paramParcel.readStrongBinder();
    paramParcel.setDataPosition(i + j);
    return localIBinder;
  }

  public static int readInt(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 4);
    return paramParcel.readInt();
  }

  public static Integer readIntegerObject(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
      return null;
    zza(paramParcel, paramInt, i, 4);
    return Integer.valueOf(paramParcel.readInt());
  }

  public static void readList(Parcel paramParcel, int paramInt, List paramList, ClassLoader paramClassLoader)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return;
    paramParcel.readList(paramList, paramClassLoader);
    paramParcel.setDataPosition(i + j);
  }

  public static long readLong(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 8);
    return paramParcel.readLong();
  }

  public static Long readLongObject(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
      return null;
    zza(paramParcel, paramInt, i, 8);
    return Long.valueOf(paramParcel.readLong());
  }

  public static short readShort(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 4);
    return (short)paramParcel.readInt();
  }

  public static int readSize(Parcel paramParcel, int paramInt)
  {
    if ((paramInt & 0xFFFF0000) != -65536)
      return 0xFFFF & paramInt >> 16;
    return paramParcel.readInt();
  }

  public static void skipUnknownField(Parcel paramParcel, int paramInt)
  {
    paramParcel.setDataPosition(readSize(paramParcel, paramInt) + paramParcel.dataPosition());
  }

  public static int validateObjectHeader(Parcel paramParcel)
  {
    int i = readHeader(paramParcel);
    int j = readSize(paramParcel, i);
    int k = paramParcel.dataPosition();
    if (getFieldId(i) != 20293)
    {
      String str1 = String.valueOf(Integer.toHexString(i));
      if (str1.length() != 0);
      for (String str2 = "Expected object header. Got 0x".concat(str1); ; str2 = new String("Expected object header. Got 0x"))
        throw new ParseException(str2, paramParcel);
    }
    int m = k + j;
    if ((m < k) || (m > paramParcel.dataSize()))
      throw new ParseException(54 + "Size read is invalid start=" + k + " end=" + m, paramParcel);
    return m;
  }

  private static void zza(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    int i = readSize(paramParcel, paramInt1);
    if (i != paramInt2)
    {
      String str = Integer.toHexString(i);
      throw new ParseException(46 + String.valueOf(str).length() + "Expected size " + paramInt2 + " got " + i + " (0x" + str + ")", paramParcel);
    }
  }

  private static void zza(Parcel paramParcel, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 != paramInt3)
    {
      String str = Integer.toHexString(paramInt2);
      throw new ParseException(46 + String.valueOf(str).length() + "Expected size " + paramInt3 + " got " + paramInt2 + " (0x" + str + ")", paramParcel);
    }
  }

  public static class ParseException extends RuntimeException
  {
    public ParseException(String paramString, Parcel paramParcel)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.SafeParcelReader
 * JD-Core Version:    0.6.2
 */
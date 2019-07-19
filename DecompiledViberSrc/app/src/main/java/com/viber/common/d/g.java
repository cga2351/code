package com.viber.common.d;

import android.os.Parcel;
import android.os.Parcelable;

public final class g
{
  public static <T extends Parcelable> T a(byte[] paramArrayOfByte, ClassLoader paramClassLoader)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      return null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
      localParcel.setDataPosition(0);
      Parcelable localParcelable = localParcel.readParcelable(paramClassLoader);
      return localParcelable;
    }
    finally
    {
      localParcel.recycle();
    }
  }

  public static byte[] a(Parcelable paramParcelable)
  {
    if (paramParcelable == null)
      return new byte[0];
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeParcelable(paramParcelable, 0);
      byte[] arrayOfByte = localParcel.marshall();
      return arrayOfByte;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.d.g
 * JD-Core Version:    0.6.2
 */
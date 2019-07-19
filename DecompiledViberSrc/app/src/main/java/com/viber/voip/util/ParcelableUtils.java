package com.viber.voip.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class ParcelableUtils
{
  public static <T extends Parcelable> ParcelableArray<T> a(T[] paramArrayOfT)
  {
    return new ParcelableArray(paramArrayOfT, null);
  }

  public static <T extends Parcelable> T[] a(Object paramObject)
  {
    if (paramObject != null)
      return ((ParcelableArray)paramObject).items();
    return null;
  }

  public static class ParcelableArray<T extends Parcelable>
    implements Parcelable
  {
    public static final Parcelable.Creator<ParcelableArray> CREATOR = new Parcelable.Creator()
    {
      public ParcelableUtils.ParcelableArray a(Parcel paramAnonymousParcel)
      {
        return new ParcelableUtils.ParcelableArray(paramAnonymousParcel);
      }

      public ParcelableUtils.ParcelableArray[] a(int paramAnonymousInt)
      {
        return new ParcelableUtils.ParcelableArray[paramAnonymousInt];
      }
    };
    private Class<T> mItemClazz;
    private T[] mItems;
    private Class<? extends T[]> mItemsClazz;

    private ParcelableArray()
    {
    }

    protected ParcelableArray(Parcel paramParcel)
    {
      this.mItemsClazz = ((Class)paramParcel.readSerializable());
      this.mItemClazz = ((Class)paramParcel.readSerializable());
      Parcelable[] arrayOfParcelable1 = paramParcel.readParcelableArray(this.mItemClazz.getClassLoader());
      if (this.mItemClazz != null);
      for (Parcelable[] arrayOfParcelable2 = (Parcelable[])Arrays.copyOf(arrayOfParcelable1, arrayOfParcelable1.length, this.mItemsClazz); ; arrayOfParcelable2 = null)
      {
        this.mItems = arrayOfParcelable2;
        return;
      }
    }

    private ParcelableArray(T[] paramArrayOfT)
    {
      this.mItems = paramArrayOfT;
      if (paramArrayOfT != null);
      for (Class localClass1 = paramArrayOfT.getClass(); ; localClass1 = null)
      {
        this.mItemsClazz = localClass1;
        Class localClass2 = null;
        if (paramArrayOfT != null)
          localClass2 = paramArrayOfT.getClass().getComponentType();
        this.mItemClazz = localClass2;
        return;
      }
    }

    public int describeContents()
    {
      return 0;
    }

    public T[] items()
    {
      return this.mItems;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeSerializable(this.mItemsClazz);
      paramParcel.writeSerializable(this.mItemClazz);
      paramParcel.writeParcelableArray(this.mItems, paramInt);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.ParcelableUtils
 * JD-Core Version:    0.6.2
 */
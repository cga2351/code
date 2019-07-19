package com.viber.voip.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;

public class ParcelableSparseArray<T> extends SparseArray<T>
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableSparseArray> CREATOR = new Parcelable.Creator()
  {
    public ParcelableSparseArray a(Parcel paramAnonymousParcel)
    {
      return new ParcelableSparseArray(paramAnonymousParcel, null);
    }

    public ParcelableSparseArray[] a(int paramAnonymousInt)
    {
      return new ParcelableSparseArray[paramAnonymousInt];
    }
  };
  private SparseArray<Object> sparseArray;

  public ParcelableSparseArray()
  {
  }

  public ParcelableSparseArray(int paramInt)
  {
    super(paramInt);
  }

  private ParcelableSparseArray(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    this.sparseArray = paramParcel.readSparseArray(ParcelableSparseArray.class.getClassLoader());
    for (int j = 0; j < i; j++)
      put(this.sparseArray.keyAt(j), this.sparseArray.valueAt(j));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = size();
    paramParcel.writeInt(i);
    this.sparseArray = new SparseArray(i);
    for (int j = 0; j < i; j++)
      this.sparseArray.put(keyAt(j), valueAt(j));
    paramParcel.writeSparseArray(this.sparseArray);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.ParcelableSparseArray
 * JD-Core Version:    0.6.2
 */
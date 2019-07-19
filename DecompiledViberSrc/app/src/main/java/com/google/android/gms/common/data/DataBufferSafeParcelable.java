package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
public class DataBufferSafeParcelable<T extends SafeParcelable> extends AbstractDataBuffer<T>
{
  private static final String[] zaln = { "data" };
  private final Parcelable.Creator<T> zalo;

  @KeepForSdk
  public DataBufferSafeParcelable(DataHolder paramDataHolder, Parcelable.Creator<T> paramCreator)
  {
    super(paramDataHolder);
    this.zalo = paramCreator;
  }

  @KeepForSdk
  public static <T extends SafeParcelable> void addValue(DataHolder.Builder paramBuilder, T paramT)
  {
    Parcel localParcel = Parcel.obtain();
    paramT.writeToParcel(localParcel, 0);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("data", localParcel.marshall());
    paramBuilder.withRow(localContentValues);
    localParcel.recycle();
  }

  @KeepForSdk
  public static DataHolder.Builder buildDataHolder()
  {
    return DataHolder.builder(zaln);
  }

  @KeepForSdk
  public T get(int paramInt)
  {
    byte[] arrayOfByte = this.mDataHolder.getByteArray("data", paramInt, this.mDataHolder.getWindowIndex(paramInt));
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
    localParcel.setDataPosition(0);
    SafeParcelable localSafeParcelable = (SafeParcelable)this.zalo.createFromParcel(localParcel);
    localParcel.recycle();
    return localSafeParcelable;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.DataBufferSafeParcelable
 * JD-Core Version:    0.6.2
 */
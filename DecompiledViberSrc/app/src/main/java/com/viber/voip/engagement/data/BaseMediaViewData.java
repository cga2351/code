package com.viber.voip.engagement.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseMediaViewData<T extends Parcelable>
  implements Parcelable
{
  private final float mAspectRatio;
  private final List<T> mItems;

  public BaseMediaViewData()
  {
    this(new ArrayList(0), 0.0F);
  }

  protected BaseMediaViewData(Parcel paramParcel)
  {
    this.mItems = paramParcel.createTypedArrayList(getItemCreator());
    this.mAspectRatio = paramParcel.readFloat();
  }

  public BaseMediaViewData(List<T> paramList, float paramFloat)
  {
    this.mItems = paramList;
    this.mAspectRatio = paramFloat;
  }

  public int describeContents()
  {
    return 0;
  }

  public float getAspectRatio()
  {
    return this.mAspectRatio;
  }

  public T getItem(int paramInt)
  {
    return (Parcelable)this.mItems.get(paramInt);
  }

  protected abstract Parcelable.Creator<T> getItemCreator();

  public int getItemWidth(int paramInt)
  {
    return Math.round(paramInt * this.mAspectRatio);
  }

  public List<T> getItems()
  {
    return new ArrayList(this.mItems);
  }

  public int getItemsCount()
  {
    return this.mItems.size();
  }

  public boolean isEmpty()
  {
    return getItemsCount() == 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.mItems);
    paramParcel.writeFloat(this.mAspectRatio);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.data.BaseMediaViewData
 * JD-Core Version:    0.6.2
 */
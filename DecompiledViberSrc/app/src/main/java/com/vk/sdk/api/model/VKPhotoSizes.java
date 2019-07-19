package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class VKPhotoSizes extends VKList<VKApiPhotoSize>
  implements Parcelable
{
  public static Parcelable.Creator<VKPhotoSizes> CREATOR = new Parcelable.Creator()
  {
    public VKPhotoSizes createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKPhotoSizes(paramAnonymousParcel, null);
    }

    public VKPhotoSizes[] newArray(int paramAnonymousInt)
    {
      return new VKPhotoSizes[paramAnonymousInt];
    }
  };
  private static float sQuality = 1.0F;
  private String mHeightThumb;
  private int mLastHeight;
  private int mLastWidth;
  private int mOriginalHeight = 1;
  private int mOriginalWidth = 1;
  private String mWidthThumb;
  private final VKList.Parser<VKApiPhotoSize> parser = new VKList.Parser()
  {
    public VKApiPhotoSize parseObject(JSONObject paramAnonymousJSONObject)
      throws Exception
    {
      return VKApiPhotoSize.parse(paramAnonymousJSONObject, VKPhotoSizes.this.mOriginalWidth, VKPhotoSizes.this.mOriginalHeight);
    }
  };

  public VKPhotoSizes()
  {
  }

  private VKPhotoSizes(Parcel paramParcel)
  {
    super(paramParcel);
    this.mOriginalWidth = paramParcel.readInt();
    this.mOriginalHeight = paramParcel.readInt();
    this.mWidthThumb = paramParcel.readString();
    this.mLastWidth = paramParcel.readInt();
  }

  public VKPhotoSizes(JSONArray paramJSONArray)
  {
    fill(paramJSONArray);
  }

  private String getImageForHeight(int paramInt)
  {
    if (((this.mHeightThumb != null) && (this.mLastHeight != paramInt)) || (isEmpty()))
      return this.mHeightThumb;
    this.mLastHeight = paramInt;
    this.mHeightThumb = null;
    int i = (int)(paramInt * sQuality);
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      VKApiPhotoSize localVKApiPhotoSize = (VKApiPhotoSize)localIterator.next();
      if (localVKApiPhotoSize.height >= i)
        this.mHeightThumb = localVKApiPhotoSize.src;
    }
    return this.mHeightThumb;
  }

  private String getImageForWidth(int paramInt)
  {
    if (((this.mWidthThumb != null) && (this.mLastWidth != paramInt)) || (isEmpty()))
      return this.mWidthThumb;
    this.mLastWidth = paramInt;
    this.mWidthThumb = null;
    int i = (int)(paramInt * sQuality);
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      VKApiPhotoSize localVKApiPhotoSize = (VKApiPhotoSize)localIterator.next();
      if (localVKApiPhotoSize.width >= i)
        this.mWidthThumb = localVKApiPhotoSize.src;
    }
    return this.mWidthThumb;
  }

  public static void setQuality(float paramFloat)
  {
    sQuality = paramFloat;
  }

  public int describeContents()
  {
    return 0;
  }

  public void fill(JSONArray paramJSONArray)
  {
    fill(paramJSONArray, this.parser);
    sort();
  }

  public void fill(JSONArray paramJSONArray, int paramInt1, int paramInt2)
  {
    setOriginalDimension(paramInt1, paramInt2);
    fill(paramJSONArray);
  }

  public String getByType(char paramChar)
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      VKApiPhotoSize localVKApiPhotoSize = (VKApiPhotoSize)localIterator.next();
      if (localVKApiPhotoSize.type == paramChar)
        return localVKApiPhotoSize.src;
    }
    return null;
  }

  public String getImageForDimension(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramInt2)
      return getImageForWidth(paramInt1);
    return getImageForHeight(paramInt2);
  }

  public void setOriginalDimension(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
      this.mOriginalWidth = paramInt1;
    if (paramInt2 != 0)
      this.mOriginalHeight = paramInt2;
  }

  public void sort()
  {
    Collections.sort(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mOriginalWidth);
    paramParcel.writeInt(this.mOriginalHeight);
    paramParcel.writeString(this.mWidthThumb);
    paramParcel.writeInt(this.mLastWidth);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKPhotoSizes
 * JD-Core Version:    0.6.2
 */
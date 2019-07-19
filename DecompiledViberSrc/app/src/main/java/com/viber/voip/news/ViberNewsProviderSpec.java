package com.viber.voip.news;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.util.ParcelableSparseArray;
import com.viber.voip.util.da;

public class ViberNewsProviderSpec
  implements Parcelable
{
  public static final int CACHE_TIME_UNDEFINED;
  public static final Parcelable.Creator<ViberNewsProviderSpec> CREATOR = new Parcelable.Creator()
  {
    public ViberNewsProviderSpec a(Parcel paramAnonymousParcel)
    {
      return new ViberNewsProviderSpec(paramAnonymousParcel);
    }

    public ViberNewsProviderSpec[] a(int paramAnonymousInt)
    {
      return new ViberNewsProviderSpec[paramAnonymousInt];
    }
  };
  static final ViberNewsProviderSpec NO_NEWS_PROVIDER = new ViberNewsProviderSpec(0, "", -1, 0L, false, 0, 0, new int[0]);
  private final int mArticlesDetectionStrategy;
  private final long mCacheTimeMillis;
  private final int mEntryPoint;
  private final int mFeedScreenOrientation;
  private final int mId;
  private final boolean mOpenArticleOnNewScreen;
  private final String mUrl;
  private final ParcelableSparseArray<Boolean> mUrlParams;

  public ViberNewsProviderSpec(int paramInt1, String paramString, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    this.mId = paramInt1;
    this.mUrl = paramString;
    this.mFeedScreenOrientation = paramInt2;
    this.mCacheTimeMillis = paramLong;
    this.mOpenArticleOnNewScreen = paramBoolean;
    this.mArticlesDetectionStrategy = paramInt3;
    this.mEntryPoint = paramInt4;
    this.mUrlParams = new ParcelableSparseArray(paramArrayOfInt.length);
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
    {
      int k = paramArrayOfInt[j];
      this.mUrlParams.put(k, Boolean.TRUE);
    }
  }

  ViberNewsProviderSpec(Parcel paramParcel)
  {
    this.mId = paramParcel.readInt();
    String str = paramParcel.readString();
    boolean bool;
    label51: ParcelableSparseArray localParcelableSparseArray;
    if (str != null)
    {
      this.mUrl = str;
      this.mFeedScreenOrientation = paramParcel.readInt();
      this.mCacheTimeMillis = paramParcel.readLong();
      if (paramParcel.readByte() == 0)
        break label104;
      bool = true;
      this.mOpenArticleOnNewScreen = bool;
      this.mArticlesDetectionStrategy = paramParcel.readInt();
      this.mEntryPoint = paramParcel.readInt();
      localParcelableSparseArray = (ParcelableSparseArray)paramParcel.readParcelable(ParcelableSparseArray.class.getClassLoader());
      if (localParcelableSparseArray == null)
        break label109;
    }
    while (true)
    {
      this.mUrlParams = localParcelableSparseArray;
      return;
      str = "";
      break;
      label104: bool = false;
      break label51;
      label109: localParcelableSparseArray = new ParcelableSparseArray(0);
    }
  }

  public boolean canBeDisplayedAsHomeTab()
  {
    return (isNewsProviderExists()) && ((getEntryPoint() == 2) || (getEntryPoint() == 3));
  }

  public boolean canBeDisplayedOnMoreScreen()
  {
    return (isNewsProviderExists()) && ((getEntryPoint() == 1) || (getEntryPoint() == 3));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject)
      bool = true;
    ViberNewsProviderSpec localViberNewsProviderSpec;
    int k;
    int m;
    do
    {
      int i;
      int j;
      do
      {
        Class localClass1;
        Class localClass2;
        do
        {
          do
          {
            return bool;
            bool = false;
          }
          while (paramObject == null);
          localClass1 = getClass();
          localClass2 = paramObject.getClass();
          bool = false;
        }
        while (localClass1 != localClass2);
        localViberNewsProviderSpec = (ViberNewsProviderSpec)paramObject;
        i = this.mId;
        j = localViberNewsProviderSpec.mId;
        bool = false;
      }
      while (i != j);
      k = this.mEntryPoint;
      m = localViberNewsProviderSpec.mEntryPoint;
      bool = false;
    }
    while (k != m);
    return this.mUrl.equals(localViberNewsProviderSpec.mUrl);
  }

  public int getArticlesDetectionStrategy()
  {
    return this.mArticlesDetectionStrategy;
  }

  public long getCacheTimeMillis()
  {
    return this.mCacheTimeMillis;
  }

  public int getEntryPoint()
  {
    return this.mEntryPoint;
  }

  public int getFeedScreenOrientation()
  {
    return this.mFeedScreenOrientation;
  }

  public int getId()
  {
    return this.mId;
  }

  public String getUrl()
  {
    return this.mUrl;
  }

  public int hashCode()
  {
    return 31 * (31 * this.mId + this.mUrl.hashCode()) + this.mEntryPoint;
  }

  public boolean isNewsProviderExists()
  {
    return (this != NO_NEWS_PROVIDER) && (!da.a(getUrl()));
  }

  public boolean isUrlParameterRequired(int paramInt)
  {
    return ((Boolean)this.mUrlParams.get(paramInt, Boolean.FALSE)).booleanValue();
  }

  public boolean openArticleOnNewScreen()
  {
    return this.mOpenArticleOnNewScreen;
  }

  public String toString()
  {
    return "ViberNewsProviderSpec{mId=" + getId() + "mUrl='" + getUrl() + '\'' + ",mFeedScreenOrientation =" + getFeedScreenOrientation() + ",mCacheTimeMillis =" + getCacheTimeMillis() + ", mOpenArticleOnNewScreen=" + openArticleOnNewScreen() + ", mArticlesDetectionStrategy=" + getArticlesDetectionStrategy() + ", mEntryPoint=" + getEntryPoint() + ", mUrlParams=" + this.mUrlParams + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(getId());
    paramParcel.writeString(getUrl());
    paramParcel.writeInt(this.mFeedScreenOrientation);
    paramParcel.writeLong(this.mCacheTimeMillis);
    if (openArticleOnNewScreen());
    for (byte b = 1; ; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(getArticlesDetectionStrategy());
      paramParcel.writeInt(getEntryPoint());
      paramParcel.writeParcelable(this.mUrlParams, paramInt);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.news.ViberNewsProviderSpec
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.publicaccount.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class CrmItem
  implements Parcelable
{
  public static final Parcelable.Creator<CrmItem> CREATOR = new Parcelable.Creator()
  {
    public CrmItem a(Parcel paramAnonymousParcel)
    {
      return new CrmItem(paramAnonymousParcel);
    }

    public CrmItem[] a(int paramAnonymousInt)
    {
      return new CrmItem[paramAnonymousInt];
    }
  };
  private String mAction;
  private String mImage;
  private String mName;

  protected CrmItem(Parcel paramParcel)
  {
    this.mAction = paramParcel.readString();
    this.mName = paramParcel.readString();
    this.mImage = paramParcel.readString();
  }

  public CrmItem(String paramString)
  {
    this.mName = paramString;
  }

  public CrmItem(String paramString1, String paramString2, String paramString3)
  {
    this.mAction = paramString1;
    this.mName = paramString2;
    this.mImage = paramString3;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this == paramObject)
      bool2 = bool1;
    CrmItem localCrmItem;
    boolean bool3;
    do
    {
      boolean bool4;
      do
      {
        Class localClass1;
        Class localClass2;
        do
        {
          do
          {
            return bool2;
            bool2 = false;
          }
          while (paramObject == null);
          localClass1 = getClass();
          localClass2 = paramObject.getClass();
          bool2 = false;
        }
        while (localClass1 != localClass2);
        localCrmItem = (CrmItem)paramObject;
        if (this.mAction == null)
          break;
        bool4 = this.mAction.equals(localCrmItem.mAction);
        bool2 = false;
      }
      while (!bool4);
      if (this.mName == null)
        break label132;
      bool3 = this.mName.equals(localCrmItem.mName);
      bool2 = false;
    }
    while (!bool3);
    label100: if (this.mImage != null)
      bool1 = this.mImage.equals(localCrmItem.mImage);
    while (true)
    {
      return bool1;
      if (localCrmItem.mAction == null)
        break;
      return false;
      label132: if (localCrmItem.mName == null)
        break label100;
      return false;
      if (localCrmItem.mImage != null)
        bool1 = false;
    }
  }

  public String getAction()
  {
    return this.mAction;
  }

  public String getImage()
  {
    return this.mImage;
  }

  public String getName()
  {
    return this.mName;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.mAction != null)
    {
      i = this.mAction.hashCode();
      j = 31 * (i + 31);
      if (this.mName == null)
        break label80;
    }
    label80: for (int k = this.mName.hashCode(); ; k = 0)
    {
      int m = 31 * (k + j);
      String str = this.mImage;
      int n = 0;
      if (str != null)
        n = this.mImage.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }

  public String toString()
  {
    return "CrmItem{mAction=" + this.mAction + ", mName='" + this.mName + '\'' + ", mImage='" + this.mImage + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mAction);
    paramParcel.writeString(this.mName);
    paramParcel.writeString(this.mImage);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.entity.CrmItem
 * JD-Core Version:    0.6.2
 */
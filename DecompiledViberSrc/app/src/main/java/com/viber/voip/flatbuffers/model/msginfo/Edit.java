package com.viber.voip.flatbuffers.model.msginfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;
import com.viber.voip.flatbuffers.model.util.UnsignedLong;

public class Edit
  implements Parcelable
{
  public static final Parcelable.Creator<Edit> CREATOR = new Parcelable.Creator()
  {
    public Edit a(Parcel paramAnonymousParcel)
    {
      return new Edit(paramAnonymousParcel);
    }

    public Edit[] a(int paramAnonymousInt)
    {
      return new Edit[paramAnonymousInt];
    }
  };

  @c(a="editedWithToken")
  private UnsignedLong mEditedWithToken;

  @c(a="token")
  private UnsignedLong mToken;

  public Edit()
  {
  }

  protected Edit(Parcel paramParcel)
  {
    ClassLoader localClassLoader = getClass().getClassLoader();
    this.mToken = ((UnsignedLong)paramParcel.readParcelable(localClassLoader));
    this.mEditedWithToken = ((UnsignedLong)paramParcel.readParcelable(localClassLoader));
  }

  public Edit(UnsignedLong paramUnsignedLong)
  {
    this.mToken = paramUnsignedLong;
  }

  public int describeContents()
  {
    return 0;
  }

  public long getEditedWithToken()
  {
    if (this.mEditedWithToken != null)
      return this.mEditedWithToken.get();
    return 0L;
  }

  public long getToken()
  {
    if (this.mToken != null)
      return this.mToken.get();
    return 0L;
  }

  public void setEditedWithToken(long paramLong)
  {
    this.mEditedWithToken = new UnsignedLong(paramLong);
  }

  public void setToken(long paramLong)
  {
    this.mToken = new UnsignedLong(paramLong);
  }

  public String toString()
  {
    return "Edit{, mToken=" + this.mToken + ", mEditedWithToken=" + this.mEditedWithToken + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mToken, paramInt);
    paramParcel.writeParcelable(this.mEditedWithToken, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.Edit
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.invitelinks.linkscreen;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

abstract interface ScreenView
{
  public abstract void a(Error paramError);

  public abstract void a(String paramString);

  public abstract void a(boolean paramBoolean);

  public abstract void b();

  public abstract void c(Error paramError);

  public static class Error
    implements Parcelable
  {
    public static final Parcelable.Creator<Error> CREATOR = new Parcelable.Creator()
    {
      public ScreenView.Error a(Parcel paramAnonymousParcel)
      {
        return new ScreenView.Error(paramAnonymousParcel);
      }

      public ScreenView.Error[] a(int paramAnonymousInt)
      {
        return new ScreenView.Error[paramAnonymousInt];
      }
    };
    public final int operation;
    public final int status;

    public Error(int paramInt1, int paramInt2)
    {
      this.operation = paramInt1;
      this.status = paramInt2;
    }

    protected Error(Parcel paramParcel)
    {
      this.operation = paramParcel.readInt();
      this.status = paramParcel.readInt();
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      Error localError;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        localError = (Error)paramObject;
        if (this.operation != localError.operation)
          return false;
      }
      while (this.status == localError.status);
      return false;
    }

    public int hashCode()
    {
      return 31 * this.operation + this.status;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.operation);
      paramParcel.writeInt(this.status);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.linkscreen.ScreenView
 * JD-Core Version:    0.6.2
 */
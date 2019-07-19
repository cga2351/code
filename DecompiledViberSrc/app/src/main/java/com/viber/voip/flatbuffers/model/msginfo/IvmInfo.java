package com.viber.voip.flatbuffers.model.msginfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.b;
import com.google.d.a.c;

public class IvmInfo
  implements Parcelable
{
  public static final Parcelable.Creator<IvmInfo> CREATOR = new Parcelable.Creator()
  {
    public IvmInfo a(Parcel paramAnonymousParcel)
    {
      return new IvmInfo(paramAnonymousParcel);
    }

    public IvmInfo[] a(int paramAnonymousInt)
    {
      return new IvmInfo[paramAnonymousInt];
    }
  };

  @b(a="Lcom/viber/voip/flatbuffers/c/k;")
  @c(a="shape")
  private a mShape;

  public IvmInfo()
  {
    this.mShape = a.CIRCLE;
  }

  IvmInfo(Parcel paramParcel)
  {
    this.mShape = a.values()[paramParcel.readInt()];
  }

  public int describeContents()
  {
    return 0;
  }

  public a getShape()
  {
    return this.mShape;
  }

  public void setShape(a parama)
  {
    this.mShape = parama;
  }

  public String toString()
  {
    return "IvmInfo{mShape=" + this.mShape + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mShape.ordinal());
  }

  public static enum a
  {
    final String shapeName;

    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = CIRCLE;
      arrayOfa[1] = HEART;
    }

    private a(String paramString)
    {
      this.shapeName = paramString;
    }

    public static a fromName(String paramString)
    {
      for (a locala : values())
        if (locala.shapeName.equals(paramString))
          return locala;
      return CIRCLE;
    }

    public String getShapeName()
    {
      return this.shapeName;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.IvmInfo
 * JD-Core Version:    0.6.2
 */
package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class bf
  implements Parcelable
{
  public static final Parcelable.Creator<bf> CREATOR = new Parcelable.Creator()
  {
  };
  private final boolean a;
  private final be b;
  private final bg c;

  protected bf(Parcel paramParcel)
  {
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.a = bool;
      this.b = ((be)paramParcel.readParcelable(be.class.getClassLoader()));
      this.c = ((bg)paramParcel.readParcelable(bg.class.getClassLoader()));
      return;
    }
  }

  private bf(a parama)
  {
    this.b = a.a(parama);
    this.c = a.b(parama);
    this.a = a.c(parama);
  }

  public final be a()
  {
    return this.b;
  }

  public final bg b()
  {
    return this.c;
  }

  public final boolean c()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.a);
    for (byte b1 = 1; ; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeParcelable(this.b, paramInt);
      paramParcel.writeParcelable(this.c, paramInt);
      return;
    }
  }

  public static final class a
  {
    private boolean a;
    private be b;
    private bg c;

    public final a a(be parambe)
    {
      this.b = parambe;
      return this;
    }

    public final a a(bg parambg)
    {
      this.c = parambg;
      return this;
    }

    public final a a(boolean paramBoolean)
    {
      this.a = paramBoolean;
      return this;
    }

    public final bf a()
    {
      return new bf(this, (byte)0);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.bf
 * JD-Core Version:    0.6.2
 */
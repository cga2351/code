package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Locale;

public class aj
  implements Parcelable
{
  public static final Parcelable.Creator<aj> CREATOR = new Parcelable.Creator()
  {
  };
  private final int a;
  private final int b;
  private final String c;
  private final a d;

  public aj(int paramInt1, int paramInt2, a parama)
  {
    int i;
    if ((paramInt1 >= 0) || (-1 == paramInt1))
    {
      i = paramInt1;
      this.a = i;
      if ((paramInt2 < 0) && (-2 != paramInt2))
        break label93;
    }
    label93: for (int j = paramInt2; ; j = 0)
    {
      this.b = j;
      this.d = parama;
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramInt1);
      arrayOfObject[1] = Integer.valueOf(paramInt2);
      this.c = String.format(localLocale, "%dx%d", arrayOfObject);
      return;
      i = 0;
      break;
    }
  }

  protected aj(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.d = a.values()[paramParcel.readInt()];
    this.c = paramParcel.readString();
  }

  public final int a()
  {
    return this.a;
  }

  public final int a(Context paramContext)
  {
    if (-2 == this.b)
      return dh.d(paramContext);
    return this.b;
  }

  public final int b()
  {
    return this.b;
  }

  public final int b(Context paramContext)
  {
    if (-1 == this.a)
      return dh.c(paramContext);
    return this.a;
  }

  public final int c(Context paramContext)
  {
    if (-2 == this.b)
      return dh.b(paramContext);
    return dh.a(paramContext, this.b);
  }

  public final a c()
  {
    return this.d;
  }

  public final int d(Context paramContext)
  {
    if (-1 == this.a)
      return dh.a(paramContext);
    return dh.a(paramContext, this.a);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    aj localaj;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localaj = (aj)paramObject;
      if (this.a != localaj.a)
        return false;
      if (this.b != localaj.b)
        return false;
    }
    while (this.d == localaj.d);
    return false;
  }

  public int hashCode()
  {
    return 31 * (31 * (31 * this.a + this.b) + this.c.hashCode()) + this.d.hashCode();
  }

  public String toString()
  {
    return this.c;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.d.ordinal());
    paramParcel.writeString(this.c);
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.aj
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzpw extends zzpv
{
  public static final Parcelable.Creator<zzpw> CREATOR = new zzpx();
  private final String description;
  private final String value;

  zzpw(Parcel paramParcel)
  {
    super(paramParcel.readString());
    this.description = paramParcel.readString();
    this.value = paramParcel.readString();
  }

  public zzpw(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1);
    this.description = null;
    this.value = paramString3;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzpw localzzpw;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localzzpw = (zzpw)paramObject;
    }
    while ((this.zzatl.equals(localzzpw.zzatl)) && (zzsy.zza(this.description, localzzpw.description)) && (zzsy.zza(this.value, localzzpw.value)));
    return false;
  }

  public final int hashCode()
  {
    int i = 31 * (527 + this.zzatl.hashCode());
    if (this.description != null);
    for (int j = this.description.hashCode(); ; j = 0)
    {
      int k = 31 * (j + i);
      String str = this.value;
      int m = 0;
      if (str != null)
        m = this.value.hashCode();
      return k + m;
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.zzatl);
    paramParcel.writeString(this.description);
    paramParcel.writeString(this.value);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzpw
 * JD-Core Version:    0.6.2
 */
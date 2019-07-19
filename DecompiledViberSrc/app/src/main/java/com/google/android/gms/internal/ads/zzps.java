package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzps extends zzpv
{
  public static final Parcelable.Creator<zzps> CREATOR = new zzpt();
  public final String description;
  private final String zzauc;
  public final String zzbhy;

  zzps(Parcel paramParcel)
  {
    super("COMM");
    this.zzauc = paramParcel.readString();
    this.description = paramParcel.readString();
    this.zzbhy = paramParcel.readString();
  }

  public zzps(String paramString1, String paramString2, String paramString3)
  {
    super("COMM");
    this.zzauc = paramString1;
    this.description = paramString2;
    this.zzbhy = paramString3;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzps localzzps;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localzzps = (zzps)paramObject;
    }
    while ((zzsy.zza(this.description, localzzps.description)) && (zzsy.zza(this.zzauc, localzzps.zzauc)) && (zzsy.zza(this.zzbhy, localzzps.zzbhy)));
    return false;
  }

  public final int hashCode()
  {
    int i;
    int j;
    if (this.zzauc != null)
    {
      i = this.zzauc.hashCode();
      j = 31 * (i + 527);
      if (this.description == null)
        break label81;
    }
    label81: for (int k = this.description.hashCode(); ; k = 0)
    {
      int m = 31 * (k + j);
      String str = this.zzbhy;
      int n = 0;
      if (str != null)
        n = this.zzbhy.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.zzatl);
    paramParcel.writeString(this.zzauc);
    paramParcel.writeString(this.zzbhy);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzps
 * JD-Core Version:    0.6.2
 */
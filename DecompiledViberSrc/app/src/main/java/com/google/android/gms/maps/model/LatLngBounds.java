package com.google.android.gms.maps.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.maps.GoogleMapOptions;

@SafeParcelable.Class(creator="LatLngBoundsCreator")
@SafeParcelable.Reserved({1})
public final class LatLngBounds extends AbstractSafeParcelable
  implements ReflectedParcelable
{

  @KeepForSdk
  public static final Parcelable.Creator<LatLngBounds> CREATOR = new zze();

  @SafeParcelable.Field(id=3)
  public final LatLng northeast;

  @SafeParcelable.Field(id=2)
  public final LatLng southwest;

  @SafeParcelable.Constructor
  public LatLngBounds(@SafeParcelable.Param(id=2) LatLng paramLatLng1, @SafeParcelable.Param(id=3) LatLng paramLatLng2)
  {
    Preconditions.checkNotNull(paramLatLng1, "null southwest");
    Preconditions.checkNotNull(paramLatLng2, "null northeast");
    if (paramLatLng2.latitude >= paramLatLng1.latitude);
    for (boolean bool = true; ; bool = false)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Double.valueOf(paramLatLng1.latitude);
      arrayOfObject[1] = Double.valueOf(paramLatLng2.latitude);
      Preconditions.checkArgument(bool, "southern latitude exceeds northern latitude (%s > %s)", arrayOfObject);
      this.southwest = paramLatLng1;
      this.northeast = paramLatLng2;
      return;
    }
  }

  public static Builder builder()
  {
    return new Builder();
  }

  public static LatLngBounds createFromAttributes(Context paramContext, AttributeSet paramAttributeSet)
  {
    return GoogleMapOptions.zza(paramContext, paramAttributeSet);
  }

  private static double zza(double paramDouble1, double paramDouble2)
  {
    return (360.0D + (paramDouble1 - paramDouble2)) % 360.0D;
  }

  private final boolean zza(double paramDouble)
  {
    if (this.southwest.longitude <= this.northeast.longitude)
      if ((this.southwest.longitude > paramDouble) || (paramDouble > this.northeast.longitude));
    while ((this.southwest.longitude <= paramDouble) || (paramDouble <= this.northeast.longitude))
    {
      return true;
      return false;
    }
    return false;
  }

  private static double zzb(double paramDouble1, double paramDouble2)
  {
    return (360.0D + (paramDouble2 - paramDouble1)) % 360.0D;
  }

  public final boolean contains(LatLng paramLatLng)
  {
    double d = paramLatLng.latitude;
    if ((this.southwest.latitude <= d) && (d <= this.northeast.latitude));
    for (int i = 1; (i != 0) && (zza(paramLatLng.longitude)); i = 0)
      return true;
    return false;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    LatLngBounds localLatLngBounds;
    do
    {
      return true;
      if (!(paramObject instanceof LatLngBounds))
        return false;
      localLatLngBounds = (LatLngBounds)paramObject;
    }
    while ((this.southwest.equals(localLatLngBounds.southwest)) && (this.northeast.equals(localLatLngBounds.northeast)));
    return false;
  }

  public final LatLng getCenter()
  {
    double d1 = (this.southwest.latitude + this.northeast.latitude) / 2.0D;
    double d2 = this.northeast.longitude;
    double d3 = this.southwest.longitude;
    if (d3 <= d2);
    for (double d4 = (d2 + d3) / 2.0D; ; d4 = (d3 + (d2 + 360.0D)) / 2.0D)
      return new LatLng(d1, d4);
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.southwest;
    arrayOfObject[1] = this.northeast;
    return Objects.hashCode(arrayOfObject);
  }

  public final LatLngBounds including(LatLng paramLatLng)
  {
    double d1 = Math.min(this.southwest.latitude, paramLatLng.latitude);
    double d2 = Math.max(this.northeast.latitude, paramLatLng.latitude);
    double d3 = this.northeast.longitude;
    double d4 = this.southwest.longitude;
    double d5 = paramLatLng.longitude;
    double d6;
    if (!zza(d5))
      if (zza(d4, d5) < zzb(d3, d5))
        d6 = d3;
    while (true)
    {
      return new LatLngBounds(new LatLng(d1, d5), new LatLng(d2, d6));
      d6 = d5;
      d5 = d4;
      continue;
      d5 = d4;
      d6 = d3;
    }
  }

  public final String toString()
  {
    return Objects.toStringHelper(this).add("southwest", this.southwest).add("northeast", this.northeast).toString();
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.southwest, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.northeast, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public static final class Builder
  {
    private double zzdh = (1.0D / 0.0D);
    private double zzdi = (-1.0D / 0.0D);
    private double zzdj = (0.0D / 0.0D);
    private double zzdk = (0.0D / 0.0D);

    public final LatLngBounds build()
    {
      if (!Double.isNaN(this.zzdj));
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkState(bool, "no included points");
        return new LatLngBounds(new LatLng(this.zzdh, this.zzdj), new LatLng(this.zzdi, this.zzdk));
      }
    }

    public final Builder include(LatLng paramLatLng)
    {
      int i = 1;
      this.zzdh = Math.min(this.zzdh, paramLatLng.latitude);
      this.zzdi = Math.max(this.zzdi, paramLatLng.latitude);
      double d = paramLatLng.longitude;
      if (Double.isNaN(this.zzdj))
      {
        this.zzdj = d;
        this.zzdk = d;
      }
      label146: 
      while (true)
      {
        return this;
        if (this.zzdj <= this.zzdk)
          if ((this.zzdj > d) || (d > this.zzdk));
        while (true)
        {
          if (i != 0)
            break label146;
          if (LatLngBounds.zzc(this.zzdj, d) >= LatLngBounds.zzd(this.zzdk, d))
            break;
          this.zzdj = d;
          return this;
          i = 0;
          continue;
          if ((this.zzdj > d) && (d > this.zzdk))
            i = 0;
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.LatLngBounds
 * JD-Core Version:    0.6.2
 */
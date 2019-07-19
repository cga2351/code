package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@SafeParcelable.Class(creator="LocationResultCreator")
@SafeParcelable.Reserved({1000})
public final class LocationResult extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<LocationResult> CREATOR = new zzac();
  static final List<Location> zzbb = Collections.emptyList();

  @SafeParcelable.Field(defaultValueUnchecked="LocationResult.DEFAULT_LOCATIONS", getter="getLocations", id=1)
  private final List<Location> zzbc;

  @SafeParcelable.Constructor
  LocationResult(@SafeParcelable.Param(id=1) List<Location> paramList)
  {
    this.zzbc = paramList;
  }

  public static LocationResult create(List<Location> paramList)
  {
    if (paramList == null)
      paramList = zzbb;
    return new LocationResult(paramList);
  }

  public static LocationResult extractResult(Intent paramIntent)
  {
    if (!hasResult(paramIntent))
      return null;
    return (LocationResult)paramIntent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
  }

  public static boolean hasResult(Intent paramIntent)
  {
    if (paramIntent == null)
      return false;
    return paramIntent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LocationResult))
      return false;
    LocationResult localLocationResult = (LocationResult)paramObject;
    if (localLocationResult.zzbc.size() != this.zzbc.size())
      return false;
    Iterator localIterator1 = localLocationResult.zzbc.iterator();
    Iterator localIterator2 = this.zzbc.iterator();
    while (localIterator1.hasNext())
    {
      Location localLocation1 = (Location)localIterator2.next();
      Location localLocation2 = (Location)localIterator1.next();
      if (localLocation1.getTime() != localLocation2.getTime())
        return false;
    }
    return true;
  }

  public final Location getLastLocation()
  {
    int i = this.zzbc.size();
    if (i == 0)
      return null;
    return (Location)this.zzbc.get(i - 1);
  }

  public final List<Location> getLocations()
  {
    return this.zzbc;
  }

  public final int hashCode()
  {
    Iterator localIterator = this.zzbc.iterator();
    long l;
    for (int i = 17; localIterator.hasNext(); i = (int)(l ^ l >>> 32) + i * 31)
      l = ((Location)localIterator.next()).getTime();
    return i;
  }

  public final String toString()
  {
    String str = String.valueOf(this.zzbc);
    return 27 + String.valueOf(str).length() + "LocationResult[locations: " + str + "]";
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, getLocations(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.LocationResult
 * JD-Core Version:    0.6.2
 */
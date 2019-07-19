package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.VisibleForTesting;

@SafeParcelable.Class(creator="PlaceReportCreator")
public class PlaceReport extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<PlaceReport> CREATOR = new zza();

  @SafeParcelable.Field(getter="getTag", id=3)
  private final String tag;

  @SafeParcelable.VersionField(id=1)
  private final int versionCode;

  @SafeParcelable.Field(getter="getPlaceId", id=2)
  private final String zza;

  @SafeParcelable.Field(getter="getSource", id=4)
  private final String zzb;

  @SafeParcelable.Constructor
  PlaceReport(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) String paramString3)
  {
    this.versionCode = paramInt;
    this.zza = paramString1;
    this.tag = paramString2;
    this.zzb = paramString3;
  }

  @VisibleForTesting
  public static PlaceReport create(String paramString1, String paramString2)
  {
    Preconditions.checkNotNull(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotEmpty("unknown");
    int i = -1;
    boolean bool;
    switch ("unknown".hashCode())
    {
    default:
      bool = false;
      switch (i)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
      break;
    case -284840886:
    case -1194968642:
    case -1436706272:
    case 1287171955:
    case -262743844:
    case 1164924125:
    }
    while (true)
    {
      Preconditions.checkArgument(bool, "Invalid source");
      return new PlaceReport(1, paramString1, paramString2, "unknown");
      if (!"unknown".equals("unknown"))
        break;
      i = 0;
      break;
      if (!"unknown".equals("userReported"))
        break;
      i = 1;
      break;
      if (!"unknown".equals("inferredGeofencing"))
        break;
      i = 2;
      break;
      if (!"unknown".equals("inferredRadioSignals"))
        break;
      i = 3;
      break;
      if (!"unknown".equals("inferredReverseGeocoding"))
        break;
      i = 4;
      break;
      if (!"unknown".equals("inferredSnappedToRoad"))
        break;
      i = 5;
      break;
      bool = true;
    }
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlaceReport));
    PlaceReport localPlaceReport;
    do
    {
      return false;
      localPlaceReport = (PlaceReport)paramObject;
    }
    while ((!Objects.equal(this.zza, localPlaceReport.zza)) || (!Objects.equal(this.tag, localPlaceReport.tag)) || (!Objects.equal(this.zzb, localPlaceReport.zzb)));
    return true;
  }

  public String getPlaceId()
  {
    return this.zza;
  }

  public String getTag()
  {
    return this.tag;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.zza;
    arrayOfObject[1] = this.tag;
    arrayOfObject[2] = this.zzb;
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    Objects.ToStringHelper localToStringHelper = Objects.toStringHelper(this);
    localToStringHelper.add("placeId", this.zza);
    localToStringHelper.add("tag", this.tag);
    if (!"unknown".equals(this.zzb))
      localToStringHelper.add("source", this.zzb);
    return localToStringHelper.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, getPlaceId(), false);
    SafeParcelWriter.writeString(paramParcel, 3, getTag(), false);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzb, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.places.PlaceReport
 * JD-Core Version:    0.6.2
 */
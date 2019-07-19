package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator="RemoveGeofencingRequestCreator")
@SafeParcelable.Reserved({1000})
public final class zzal extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzal> CREATOR = new zzam();

  @SafeParcelable.Field(defaultValue="", getter="getTag", id=3)
  private final String tag;

  @SafeParcelable.Field(getter="getGeofenceIds", id=1)
  private final List<String> zzbu;

  @SafeParcelable.Field(getter="getPendingIntent", id=2)
  private final PendingIntent zzbv;

  @SafeParcelable.Constructor
  zzal(@SafeParcelable.Param(id=1) List<String> paramList, @SafeParcelable.Param(id=2) PendingIntent paramPendingIntent, @SafeParcelable.Param(id=3) String paramString)
  {
    if (paramList == null);
    for (List localList = Collections.emptyList(); ; localList = Collections.unmodifiableList(paramList))
    {
      this.zzbu = localList;
      this.zzbv = paramPendingIntent;
      this.tag = paramString;
      return;
    }
  }

  public static zzal zza(PendingIntent paramPendingIntent)
  {
    Preconditions.checkNotNull(paramPendingIntent, "PendingIntent can not be null.");
    return new zzal(null, paramPendingIntent, "");
  }

  public static zzal zza(List<String> paramList)
  {
    Preconditions.checkNotNull(paramList, "geofence can't be null.");
    if (!paramList.isEmpty());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "Geofences must contains at least one id.");
      return new zzal(paramList, null, "");
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeStringList(paramParcel, 1, this.zzbu, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzbv, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.tag, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.zzal
 * JD-Core Version:    0.6.2
 */
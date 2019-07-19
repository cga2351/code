package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@SafeParcelable.Class(creator="LocationSettingsRequestCreator")
@SafeParcelable.Reserved({1000})
public final class LocationSettingsRequest extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzag();

  @SafeParcelable.Field(getter="getLocationRequests", id=1)
  private final List<LocationRequest> zzbg;

  @SafeParcelable.Field(defaultValue="false", getter="alwaysShow", id=2)
  private final boolean zzbh;

  @SafeParcelable.Field(getter="needBle", id=3)
  private final boolean zzbi;

  @SafeParcelable.Field(getter="getConfiguration", id=5)
  private zzae zzbj;

  @SafeParcelable.Constructor
  LocationSettingsRequest(@SafeParcelable.Param(id=1) List<LocationRequest> paramList, @SafeParcelable.Param(id=2) boolean paramBoolean1, @SafeParcelable.Param(id=3) boolean paramBoolean2, @SafeParcelable.Param(id=5) zzae paramzzae)
  {
    this.zzbg = paramList;
    this.zzbh = paramBoolean1;
    this.zzbi = paramBoolean2;
    this.zzbj = paramzzae;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, Collections.unmodifiableList(this.zzbg), false);
    SafeParcelWriter.writeBoolean(paramParcel, 2, this.zzbh);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzbi);
    SafeParcelWriter.writeParcelable(paramParcel, 5, this.zzbj, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public static final class Builder
  {
    private boolean zzbh = false;
    private boolean zzbi = false;
    private zzae zzbj = null;
    private final ArrayList<LocationRequest> zzbk = new ArrayList();

    public final Builder addAllLocationRequests(Collection<LocationRequest> paramCollection)
    {
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        LocationRequest localLocationRequest = (LocationRequest)localIterator.next();
        if (localLocationRequest != null)
          this.zzbk.add(localLocationRequest);
      }
      return this;
    }

    public final Builder addLocationRequest(LocationRequest paramLocationRequest)
    {
      if (paramLocationRequest != null)
        this.zzbk.add(paramLocationRequest);
      return this;
    }

    public final LocationSettingsRequest build()
    {
      return new LocationSettingsRequest(this.zzbk, this.zzbh, this.zzbi, null);
    }

    public final Builder setAlwaysShow(boolean paramBoolean)
    {
      this.zzbh = paramBoolean;
      return this;
    }

    public final Builder setNeedBle(boolean paramBoolean)
    {
      this.zzbi = paramBoolean;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.LocationSettingsRequest
 * JD-Core Version:    0.6.2
 */
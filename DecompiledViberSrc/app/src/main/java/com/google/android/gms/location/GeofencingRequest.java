package com.google.android.gms.location;

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
import com.google.android.gms.internal.location.zzbh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SafeParcelable.Class(creator="GeofencingRequestCreator")
@SafeParcelable.Reserved({1000})
public class GeofencingRequest extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GeofencingRequest> CREATOR = new zzq();
  public static final int INITIAL_TRIGGER_DWELL = 4;
  public static final int INITIAL_TRIGGER_ENTER = 1;
  public static final int INITIAL_TRIGGER_EXIT = 2;

  @SafeParcelable.Field(defaultValue="", getter="getTag", id=3)
  private final String tag;

  @SafeParcelable.Field(getter="getParcelableGeofences", id=1)
  private final List<zzbh> zzap;

  @SafeParcelable.Field(getter="getInitialTrigger", id=2)
  private final int zzaq;

  @SafeParcelable.Constructor
  GeofencingRequest(@SafeParcelable.Param(id=1) List<zzbh> paramList, @SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) String paramString)
  {
    this.zzap = paramList;
    this.zzaq = paramInt;
    this.tag = paramString;
  }

  public List<Geofence> getGeofences()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.zzap);
    return localArrayList;
  }

  public int getInitialTrigger()
  {
    return this.zzaq;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GeofencingRequest[");
    localStringBuilder.append("geofences=");
    localStringBuilder.append(this.zzap);
    int i = this.zzaq;
    localStringBuilder.append(30 + ", initialTrigger=" + i + ", ");
    String str1 = String.valueOf(this.tag);
    if (str1.length() != 0);
    for (String str2 = "tag=".concat(str1); ; str2 = new String("tag="))
    {
      localStringBuilder.append(str2);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, this.zzap, false);
    SafeParcelWriter.writeInt(paramParcel, 2, getInitialTrigger());
    SafeParcelWriter.writeString(paramParcel, 3, this.tag, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public static final class Builder
  {
    private String tag = "";
    private final List<zzbh> zzap = new ArrayList();
    private int zzaq = 5;

    public final Builder addGeofence(Geofence paramGeofence)
    {
      Preconditions.checkNotNull(paramGeofence, "geofence can't be null.");
      Preconditions.checkArgument(paramGeofence instanceof zzbh, "Geofence must be created using Geofence.Builder.");
      this.zzap.add((zzbh)paramGeofence);
      return this;
    }

    public final Builder addGeofences(List<Geofence> paramList)
    {
      if ((paramList == null) || (paramList.isEmpty()));
      while (true)
      {
        return this;
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          Geofence localGeofence = (Geofence)localIterator.next();
          if (localGeofence != null)
            addGeofence(localGeofence);
        }
      }
    }

    public final GeofencingRequest build()
    {
      if (!this.zzap.isEmpty());
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkArgument(bool, "No geofence has been added to this request.");
        return new GeofencingRequest(this.zzap, this.zzaq, this.tag);
      }
    }

    public final Builder setInitialTrigger(int paramInt)
    {
      this.zzaq = (paramInt & 0x7);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.GeofencingRequest
 * JD-Core Version:    0.6.2
 */
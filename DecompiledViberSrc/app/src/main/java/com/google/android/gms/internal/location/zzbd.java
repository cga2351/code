package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator="LocationRequestInternalCreator")
@SafeParcelable.Reserved({1000, 2, 3, 4})
public final class zzbd extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzbd> CREATOR = new zzbe();
  static final List<ClientIdentity> zzcd = Collections.emptyList();

  @SafeParcelable.Field(defaultValueUnchecked="null", id=10)
  private String moduleId;

  @SafeParcelable.Field(defaultValueUnchecked="null", id=6)
  private String tag;

  @SafeParcelable.Field(defaultValueUnchecked="null", id=1)
  private LocationRequest zzdg;

  @SafeParcelable.Field(defaultValueUnchecked="LocationRequestInternal.DEFAULT_HIDE_FROM_APP_OPS", id=7)
  private boolean zzdh;

  @SafeParcelable.Field(defaultValueUnchecked="LocationRequestInternal.DEFAULT_FORCE_COARSE_LOCATION", id=8)
  private boolean zzdi;

  @SafeParcelable.Field(defaultValueUnchecked="LocationRequestInternal.DEFAULT_EXEMPT_FROM_THROTTLE", id=9)
  private boolean zzdj;
  private boolean zzdk = true;

  @SafeParcelable.Field(defaultValueUnchecked="LocationRequestInternal.DEFAULT_CLIENTS", id=5)
  private List<ClientIdentity> zzm;

  @SafeParcelable.Constructor
  zzbd(@SafeParcelable.Param(id=1) LocationRequest paramLocationRequest, @SafeParcelable.Param(id=5) List<ClientIdentity> paramList, @SafeParcelable.Param(id=6) String paramString1, @SafeParcelable.Param(id=7) boolean paramBoolean1, @SafeParcelable.Param(id=8) boolean paramBoolean2, @SafeParcelable.Param(id=9) boolean paramBoolean3, @SafeParcelable.Param(id=10) String paramString2)
  {
    this.zzdg = paramLocationRequest;
    this.zzm = paramList;
    this.tag = paramString1;
    this.zzdh = paramBoolean1;
    this.zzdi = paramBoolean2;
    this.zzdj = paramBoolean3;
    this.moduleId = paramString2;
  }

  @Deprecated
  public static zzbd zza(LocationRequest paramLocationRequest)
  {
    return new zzbd(paramLocationRequest, zzcd, null, false, false, false, null);
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzbd));
    zzbd localzzbd;
    do
    {
      return false;
      localzzbd = (zzbd)paramObject;
    }
    while ((!Objects.equal(this.zzdg, localzzbd.zzdg)) || (!Objects.equal(this.zzm, localzzbd.zzm)) || (!Objects.equal(this.tag, localzzbd.tag)) || (this.zzdh != localzzbd.zzdh) || (this.zzdi != localzzbd.zzdi) || (this.zzdj != localzzbd.zzdj) || (!Objects.equal(this.moduleId, localzzbd.moduleId)));
    return true;
  }

  public final int hashCode()
  {
    return this.zzdg.hashCode();
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.zzdg);
    if (this.tag != null)
      localStringBuilder.append(" tag=").append(this.tag);
    if (this.moduleId != null)
      localStringBuilder.append(" moduleId=").append(this.moduleId);
    localStringBuilder.append(" hideAppOps=").append(this.zzdh);
    localStringBuilder.append(" clients=").append(this.zzm);
    localStringBuilder.append(" forceCoarseLocation=").append(this.zzdi);
    if (this.zzdj)
      localStringBuilder.append(" exemptFromBackgroundThrottle");
    return localStringBuilder.toString();
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, this.zzdg, paramInt, false);
    SafeParcelWriter.writeTypedList(paramParcel, 5, this.zzm, false);
    SafeParcelWriter.writeString(paramParcel, 6, this.tag, false);
    SafeParcelWriter.writeBoolean(paramParcel, 7, this.zzdh);
    SafeParcelWriter.writeBoolean(paramParcel, 8, this.zzdi);
    SafeParcelWriter.writeBoolean(paramParcel, 9, this.zzdj);
    SafeParcelWriter.writeString(paramParcel, 10, this.moduleId, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.location.zzbd
 * JD-Core Version:    0.6.2
 */
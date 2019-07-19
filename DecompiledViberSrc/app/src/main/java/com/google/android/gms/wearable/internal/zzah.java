package com.google.android.gms.wearable.internal;

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
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

@SafeParcelable.Class(creator="CapabilityInfoParcelableCreator")
@SafeParcelable.Reserved({1})
public final class zzah extends AbstractSafeParcelable
  implements CapabilityInfo
{
  public static final Parcelable.Creator<zzah> CREATOR = new zzai();
  private final Object lock = new Object();

  @SafeParcelable.Field(getter="getName", id=2)
  private final String name;

  @GuardedBy("lock")
  private Set<Node> zzbt;

  @SafeParcelable.Field(getter="getNodeParcelables", id=3)
  private final List<zzfo> zzca;

  @SafeParcelable.Constructor
  public zzah(@SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) List<zzfo> paramList)
  {
    this.name = paramString;
    this.zzca = paramList;
    this.zzbt = null;
    Preconditions.checkNotNull(this.name);
    Preconditions.checkNotNull(this.zzca);
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzah localzzah;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localzzah = (zzah)paramObject;
      if (this.name != null)
      {
        if (this.name.equals(localzzah.name));
      }
      else
        while (localzzah.name != null)
          return false;
      if (this.zzca == null)
        break;
    }
    while (this.zzca.equals(localzzah.zzca));
    while (true)
    {
      return false;
      if (localzzah.zzca == null)
        break;
    }
  }

  public final String getName()
  {
    return this.name;
  }

  public final Set<Node> getNodes()
  {
    synchronized (this.lock)
    {
      if (this.zzbt == null)
        this.zzbt = new HashSet(this.zzca);
      Set localSet = this.zzbt;
      return localSet;
    }
  }

  public final int hashCode()
  {
    if (this.name != null);
    for (int i = this.name.hashCode(); ; i = 0)
    {
      int j = 31 * (i + 31);
      List localList = this.zzca;
      int k = 0;
      if (localList != null)
        k = this.zzca.hashCode();
      return j + k;
    }
  }

  public final String toString()
  {
    String str1 = this.name;
    String str2 = String.valueOf(this.zzca);
    return 18 + String.valueOf(str1).length() + String.valueOf(str2).length() + "CapabilityInfo{" + str1 + ", " + str2 + "}";
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, getName(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 3, this.zzca, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzah
 * JD-Core Version:    0.6.2
 */
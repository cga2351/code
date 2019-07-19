package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@KeepForSdk
@SafeParcelable.Class(creator="ClientIdentityCreator")
@SafeParcelable.Reserved({1000})
public class ClientIdentity extends AbstractSafeParcelable
{

  @KeepForSdk
  public static final Parcelable.Creator<ClientIdentity> CREATOR = new zab();

  @SafeParcelable.Field(defaultValueUnchecked="null", id=2)
  private final String packageName;

  @SafeParcelable.Field(defaultValueUnchecked="0", id=1)
  private final int uid;

  @SafeParcelable.Constructor
  public ClientIdentity(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString)
  {
    this.uid = paramInt;
    this.packageName = paramString;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    ClientIdentity localClientIdentity;
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof ClientIdentity)))
        return false;
      localClientIdentity = (ClientIdentity)paramObject;
    }
    while ((localClientIdentity.uid == this.uid) && (Objects.equal(localClientIdentity.packageName, this.packageName)));
    return false;
  }

  public int hashCode()
  {
    return this.uid;
  }

  public String toString()
  {
    int i = this.uid;
    String str = this.packageName;
    return 12 + String.valueOf(str).length() + i + ":" + str;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.uid);
    SafeParcelWriter.writeString(paramParcel, 2, this.packageName, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.ClientIdentity
 * JD-Core Version:    0.6.2
 */
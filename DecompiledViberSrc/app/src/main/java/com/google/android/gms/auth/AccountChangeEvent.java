package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="AccountChangeEventCreator")
public class AccountChangeEvent extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();

  @SafeParcelable.VersionField(id=1)
  private final int zze;

  @SafeParcelable.Field(id=2)
  private final long zzf;

  @SafeParcelable.Field(id=3)
  private final String zzg;

  @SafeParcelable.Field(id=4)
  private final int zzh;

  @SafeParcelable.Field(id=5)
  private final int zzi;

  @SafeParcelable.Field(id=6)
  private final String zzj;

  @SafeParcelable.Constructor
  AccountChangeEvent(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) long paramLong, @SafeParcelable.Param(id=3) String paramString1, @SafeParcelable.Param(id=4) int paramInt2, @SafeParcelable.Param(id=5) int paramInt3, @SafeParcelable.Param(id=6) String paramString2)
  {
    this.zze = paramInt1;
    this.zzf = paramLong;
    this.zzg = ((String)Preconditions.checkNotNull(paramString1));
    this.zzh = paramInt2;
    this.zzi = paramInt3;
    this.zzj = paramString2;
  }

  public AccountChangeEvent(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.zze = 1;
    this.zzf = paramLong;
    this.zzg = ((String)Preconditions.checkNotNull(paramString1));
    this.zzh = paramInt1;
    this.zzi = paramInt2;
    this.zzj = paramString2;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    AccountChangeEvent localAccountChangeEvent;
    do
    {
      return true;
      if (!(paramObject instanceof AccountChangeEvent))
        break;
      localAccountChangeEvent = (AccountChangeEvent)paramObject;
    }
    while ((this.zze == localAccountChangeEvent.zze) && (this.zzf == localAccountChangeEvent.zzf) && (Objects.equal(this.zzg, localAccountChangeEvent.zzg)) && (this.zzh == localAccountChangeEvent.zzh) && (this.zzi == localAccountChangeEvent.zzi) && (Objects.equal(this.zzj, localAccountChangeEvent.zzj)));
    return false;
    return false;
  }

  public String getAccountName()
  {
    return this.zzg;
  }

  public String getChangeData()
  {
    return this.zzj;
  }

  public int getChangeType()
  {
    return this.zzh;
  }

  public int getEventIndex()
  {
    return this.zzi;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = Integer.valueOf(this.zze);
    arrayOfObject[1] = Long.valueOf(this.zzf);
    arrayOfObject[2] = this.zzg;
    arrayOfObject[3] = Integer.valueOf(this.zzh);
    arrayOfObject[4] = Integer.valueOf(this.zzi);
    arrayOfObject[5] = this.zzj;
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    String str1 = "UNKNOWN";
    switch (this.zzh)
    {
    default:
    case 1:
    case 2:
    case 4:
    case 3:
    }
    while (true)
    {
      String str2 = this.zzg;
      String str3 = this.zzj;
      int i = this.zzi;
      return 91 + String.valueOf(str2).length() + String.valueOf(str1).length() + String.valueOf(str3).length() + "AccountChangeEvent {accountName = " + str2 + ", changeType = " + str1 + ", changeData = " + str3 + ", eventIndex = " + i + "}";
      str1 = "ADDED";
      continue;
      str1 = "REMOVED";
      continue;
      str1 = "RENAMED_TO";
      continue;
      str1 = "RENAMED_FROM";
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zze);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzf);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzg, false);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzh);
    SafeParcelWriter.writeInt(paramParcel, 5, this.zzi);
    SafeParcelWriter.writeString(paramParcel, 6, this.zzj, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEvent
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator="AncsNotificationParcelableCreator")
@SafeParcelable.Reserved({1})
public final class zzl extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzl> CREATOR = new zzm();

  @SafeParcelable.Field(getter="getId", id=2)
  private int id;

  @Nullable
  @SafeParcelable.Field(getter="getPackageName", id=13)
  private final String packageName;

  @SafeParcelable.Field(getter="getAppId", id=3)
  private final String zzbf;

  @Nullable
  @SafeParcelable.Field(getter="getDateTime", id=4)
  private final String zzbg;

  @SafeParcelable.Field(getter="getNotificationText", id=5)
  private final String zzbh;

  @SafeParcelable.Field(getter="getTitle", id=6)
  private final String zzbi;

  @SafeParcelable.Field(getter="getSubtitle", id=7)
  private final String zzbj;

  @Nullable
  @SafeParcelable.Field(getter="getDisplayName", id=8)
  private final String zzbk;

  @SafeParcelable.Field(getter="getEventId", id=9)
  private final byte zzbl;

  @SafeParcelable.Field(getter="getEventFlags", id=10)
  private final byte zzbm;

  @SafeParcelable.Field(getter="getCategoryId", id=11)
  private final byte zzbn;

  @SafeParcelable.Field(getter="getCategoryCount", id=12)
  private final byte zzbo;

  @SafeParcelable.Constructor
  public zzl(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) String paramString1, @SafeParcelable.Param(id=4) @Nullable String paramString2, @SafeParcelable.Param(id=5) String paramString3, @SafeParcelable.Param(id=6) String paramString4, @SafeParcelable.Param(id=7) String paramString5, @SafeParcelable.Param(id=8) @Nullable String paramString6, @SafeParcelable.Param(id=9) byte paramByte1, @SafeParcelable.Param(id=10) byte paramByte2, @SafeParcelable.Param(id=11) byte paramByte3, @SafeParcelable.Param(id=12) byte paramByte4, @SafeParcelable.Param(id=13) @Nullable String paramString7)
  {
    this.id = paramInt;
    this.zzbf = paramString1;
    this.zzbg = paramString2;
    this.zzbh = paramString3;
    this.zzbi = paramString4;
    this.zzbj = paramString5;
    this.zzbk = paramString6;
    this.zzbl = paramByte1;
    this.zzbm = paramByte2;
    this.zzbn = paramByte3;
    this.zzbo = paramByte4;
    this.packageName = paramString7;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzl localzzl;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localzzl = (zzl)paramObject;
      if (this.id != localzzl.id)
        return false;
      if (this.zzbl != localzzl.zzbl)
        return false;
      if (this.zzbm != localzzl.zzbm)
        return false;
      if (this.zzbn != localzzl.zzbn)
        return false;
      if (this.zzbo != localzzl.zzbo)
        return false;
      if (!this.zzbf.equals(localzzl.zzbf))
        return false;
      if (this.zzbg != null)
      {
        if (this.zzbg.equals(localzzl.zzbg));
      }
      else
        while (localzzl.zzbg != null)
          return false;
      if (!this.zzbh.equals(localzzl.zzbh))
        return false;
      if (!this.zzbi.equals(localzzl.zzbi))
        return false;
      if (!this.zzbj.equals(localzzl.zzbj))
        return false;
      if (this.zzbk != null)
      {
        if (this.zzbk.equals(localzzl.zzbk));
      }
      else
        while (localzzl.zzbk != null)
          return false;
      if (this.packageName != null)
        return this.packageName.equals(localzzl.packageName);
    }
    while (localzzl.packageName == null);
    return false;
  }

  public final int hashCode()
  {
    int i = 31 * (31 * (31 + this.id) + this.zzbf.hashCode());
    int j;
    int k;
    if (this.zzbg != null)
    {
      j = this.zzbg.hashCode();
      k = 31 * (31 * (31 * (31 * (j + i) + this.zzbh.hashCode()) + this.zzbi.hashCode()) + this.zzbj.hashCode());
      if (this.zzbk == null)
        break label168;
    }
    label168: for (int m = this.zzbk.hashCode(); ; m = 0)
    {
      int n = 31 * (31 * (31 * (31 * (31 * (m + k) + this.zzbl) + this.zzbm) + this.zzbn) + this.zzbo);
      String str = this.packageName;
      int i1 = 0;
      if (str != null)
        i1 = this.packageName.hashCode();
      return n + i1;
      j = 0;
      break;
    }
  }

  public final String toString()
  {
    int i = this.id;
    String str1 = this.zzbf;
    String str2 = this.zzbg;
    String str3 = this.zzbh;
    String str4 = this.zzbi;
    String str5 = this.zzbj;
    String str6 = this.zzbk;
    int j = this.zzbl;
    int k = this.zzbm;
    int m = this.zzbn;
    int n = this.zzbo;
    String str7 = this.packageName;
    return 211 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length() + String.valueOf(str7).length() + "AncsNotificationParcelable{, id=" + i + ", appId='" + str1 + '\'' + ", dateTime='" + str2 + '\'' + ", notificationText='" + str3 + '\'' + ", title='" + str4 + '\'' + ", subtitle='" + str5 + '\'' + ", displayName='" + str6 + '\'' + ", eventId=" + j + ", eventFlags=" + k + ", categoryId=" + m + ", categoryCount=" + n + ", packageName='" + str7 + '\'' + '}';
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.id);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzbf, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzbg, false);
    SafeParcelWriter.writeString(paramParcel, 5, this.zzbh, false);
    SafeParcelWriter.writeString(paramParcel, 6, this.zzbi, false);
    SafeParcelWriter.writeString(paramParcel, 7, this.zzbj, false);
    if (this.zzbk == null);
    for (String str = this.zzbf; ; str = this.zzbk)
    {
      SafeParcelWriter.writeString(paramParcel, 8, str, false);
      SafeParcelWriter.writeByte(paramParcel, 9, this.zzbl);
      SafeParcelWriter.writeByte(paramParcel, 10, this.zzbm);
      SafeParcelWriter.writeByte(paramParcel, 11, this.zzbn);
      SafeParcelWriter.writeByte(paramParcel, 12, this.zzbo);
      SafeParcelWriter.writeString(paramParcel, 13, this.packageName, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, i);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzl
 * JD-Core Version:    0.6.2
 */
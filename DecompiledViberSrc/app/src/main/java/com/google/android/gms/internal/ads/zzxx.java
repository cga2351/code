package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.List;
import javax.annotation.Nullable;

@zzare
@SafeParcelable.Class(creator="AdRequestParcelCreator")
public final class zzxx extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzxx> CREATOR = new zzxz();

  @SafeParcelable.Field(id=3)
  public final Bundle extras;

  @SafeParcelable.Field(id=1)
  public final int versionCode;

  @SafeParcelable.Field(id=8)
  public final boolean zzbqn;

  @Deprecated
  @SafeParcelable.Field(id=2)
  public final long zzcgo;

  @Deprecated
  @SafeParcelable.Field(id=4)
  public final int zzcgp;

  @SafeParcelable.Field(id=5)
  public final List<String> zzcgq;

  @SafeParcelable.Field(id=6)
  public final boolean zzcgr;

  @SafeParcelable.Field(id=7)
  public final int zzcgs;

  @SafeParcelable.Field(id=9)
  public final String zzcgt;

  @SafeParcelable.Field(id=10)
  public final zzabz zzcgu;

  @SafeParcelable.Field(id=12)
  public final String zzcgv;

  @SafeParcelable.Field(id=13)
  public final Bundle zzcgw;

  @SafeParcelable.Field(id=14)
  public final Bundle zzcgx;

  @SafeParcelable.Field(id=15)
  public final List<String> zzcgy;

  @SafeParcelable.Field(id=16)
  public final String zzcgz;

  @SafeParcelable.Field(id=17)
  public final String zzcha;

  @Deprecated
  @SafeParcelable.Field(id=18)
  public final boolean zzchb;

  @Nullable
  @SafeParcelable.Field(id=19)
  public final zzxr zzchc;

  @SafeParcelable.Field(id=20)
  public final int zzchd;

  @Nullable
  @SafeParcelable.Field(id=21)
  public final String zzche;

  @SafeParcelable.Field(id=11)
  public final Location zzmw;

  @SafeParcelable.Constructor
  public zzxx(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) long paramLong, @SafeParcelable.Param(id=3) Bundle paramBundle1, @SafeParcelable.Param(id=4) int paramInt2, @SafeParcelable.Param(id=5) List<String> paramList1, @SafeParcelable.Param(id=6) boolean paramBoolean1, @SafeParcelable.Param(id=7) int paramInt3, @SafeParcelable.Param(id=8) boolean paramBoolean2, @SafeParcelable.Param(id=9) String paramString1, @SafeParcelable.Param(id=10) zzabz paramzzabz, @SafeParcelable.Param(id=11) Location paramLocation, @SafeParcelable.Param(id=12) String paramString2, @SafeParcelable.Param(id=13) Bundle paramBundle2, @SafeParcelable.Param(id=14) Bundle paramBundle3, @SafeParcelable.Param(id=15) List<String> paramList2, @SafeParcelable.Param(id=16) String paramString3, @SafeParcelable.Param(id=17) String paramString4, @SafeParcelable.Param(id=18) boolean paramBoolean3, @SafeParcelable.Param(id=19) zzxr paramzzxr, @SafeParcelable.Param(id=20) int paramInt4, @SafeParcelable.Param(id=21) @Nullable String paramString5)
  {
    this.versionCode = paramInt1;
    this.zzcgo = paramLong;
    if (paramBundle1 == null)
      paramBundle1 = new Bundle();
    this.extras = paramBundle1;
    this.zzcgp = paramInt2;
    this.zzcgq = paramList1;
    this.zzcgr = paramBoolean1;
    this.zzcgs = paramInt3;
    this.zzbqn = paramBoolean2;
    this.zzcgt = paramString1;
    this.zzcgu = paramzzabz;
    this.zzmw = paramLocation;
    this.zzcgv = paramString2;
    if (paramBundle2 == null)
      paramBundle2 = new Bundle();
    this.zzcgw = paramBundle2;
    this.zzcgx = paramBundle3;
    this.zzcgy = paramList2;
    this.zzcgz = paramString3;
    this.zzcha = paramString4;
    this.zzchb = paramBoolean3;
    this.zzchc = paramzzxr;
    this.zzchd = paramInt4;
    this.zzche = paramString5;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzxx));
    zzxx localzzxx;
    do
    {
      return false;
      localzzxx = (zzxx)paramObject;
    }
    while ((this.versionCode != localzzxx.versionCode) || (this.zzcgo != localzzxx.zzcgo) || (!Objects.equal(this.extras, localzzxx.extras)) || (this.zzcgp != localzzxx.zzcgp) || (!Objects.equal(this.zzcgq, localzzxx.zzcgq)) || (this.zzcgr != localzzxx.zzcgr) || (this.zzcgs != localzzxx.zzcgs) || (this.zzbqn != localzzxx.zzbqn) || (!Objects.equal(this.zzcgt, localzzxx.zzcgt)) || (!Objects.equal(this.zzcgu, localzzxx.zzcgu)) || (!Objects.equal(this.zzmw, localzzxx.zzmw)) || (!Objects.equal(this.zzcgv, localzzxx.zzcgv)) || (!Objects.equal(this.zzcgw, localzzxx.zzcgw)) || (!Objects.equal(this.zzcgx, localzzxx.zzcgx)) || (!Objects.equal(this.zzcgy, localzzxx.zzcgy)) || (!Objects.equal(this.zzcgz, localzzxx.zzcgz)) || (!Objects.equal(this.zzcha, localzzxx.zzcha)) || (this.zzchb != localzzxx.zzchb) || (this.zzchd != localzzxx.zzchd) || (!Objects.equal(this.zzche, localzzxx.zzche)));
    return true;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[20];
    arrayOfObject[0] = Integer.valueOf(this.versionCode);
    arrayOfObject[1] = Long.valueOf(this.zzcgo);
    arrayOfObject[2] = this.extras;
    arrayOfObject[3] = Integer.valueOf(this.zzcgp);
    arrayOfObject[4] = this.zzcgq;
    arrayOfObject[5] = Boolean.valueOf(this.zzcgr);
    arrayOfObject[6] = Integer.valueOf(this.zzcgs);
    arrayOfObject[7] = Boolean.valueOf(this.zzbqn);
    arrayOfObject[8] = this.zzcgt;
    arrayOfObject[9] = this.zzcgu;
    arrayOfObject[10] = this.zzmw;
    arrayOfObject[11] = this.zzcgv;
    arrayOfObject[12] = this.zzcgw;
    arrayOfObject[13] = this.zzcgx;
    arrayOfObject[14] = this.zzcgy;
    arrayOfObject[15] = this.zzcgz;
    arrayOfObject[16] = this.zzcha;
    arrayOfObject[17] = Boolean.valueOf(this.zzchb);
    arrayOfObject[18] = Integer.valueOf(this.zzchd);
    arrayOfObject[19] = this.zzche;
    return Objects.hashCode(arrayOfObject);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzcgo);
    SafeParcelWriter.writeBundle(paramParcel, 3, this.extras, false);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzcgp);
    SafeParcelWriter.writeStringList(paramParcel, 5, this.zzcgq, false);
    SafeParcelWriter.writeBoolean(paramParcel, 6, this.zzcgr);
    SafeParcelWriter.writeInt(paramParcel, 7, this.zzcgs);
    SafeParcelWriter.writeBoolean(paramParcel, 8, this.zzbqn);
    SafeParcelWriter.writeString(paramParcel, 9, this.zzcgt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 10, this.zzcgu, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 11, this.zzmw, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 12, this.zzcgv, false);
    SafeParcelWriter.writeBundle(paramParcel, 13, this.zzcgw, false);
    SafeParcelWriter.writeBundle(paramParcel, 14, this.zzcgx, false);
    SafeParcelWriter.writeStringList(paramParcel, 15, this.zzcgy, false);
    SafeParcelWriter.writeString(paramParcel, 16, this.zzcgz, false);
    SafeParcelWriter.writeString(paramParcel, 17, this.zzcha, false);
    SafeParcelWriter.writeBoolean(paramParcel, 18, this.zzchb);
    SafeParcelWriter.writeParcelable(paramParcel, 19, this.zzchc, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 20, this.zzchd);
    SafeParcelWriter.writeString(paramParcel, 21, this.zzche, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzxx
 * JD-Core Version:    0.6.2
 */
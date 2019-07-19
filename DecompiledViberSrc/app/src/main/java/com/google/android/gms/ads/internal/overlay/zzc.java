package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.ads.zzare;

@zzare
@SafeParcelable.Class(creator="AdLauncherIntentInfoCreator")
@SafeParcelable.Reserved({1})
public final class zzc extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzc> CREATOR = new zzb();

  @SafeParcelable.Field(id=9)
  public final Intent intent;

  @SafeParcelable.Field(id=4)
  public final String mimeType;

  @SafeParcelable.Field(id=5)
  public final String packageName;

  @SafeParcelable.Field(id=3)
  public final String url;

  @SafeParcelable.Field(id=2)
  private final String zzdji;

  @SafeParcelable.Field(id=6)
  public final String zzdjj;

  @SafeParcelable.Field(id=7)
  public final String zzdjk;

  @SafeParcelable.Field(id=8)
  private final String zzdjl;

  public zzc(Intent paramIntent)
  {
    this(null, null, null, null, null, null, null, paramIntent);
  }

  public zzc(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, null);
  }

  @SafeParcelable.Constructor
  public zzc(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) String paramString3, @SafeParcelable.Param(id=5) String paramString4, @SafeParcelable.Param(id=6) String paramString5, @SafeParcelable.Param(id=7) String paramString6, @SafeParcelable.Param(id=8) String paramString7, @SafeParcelable.Param(id=9) Intent paramIntent)
  {
    this.zzdji = paramString1;
    this.url = paramString2;
    this.mimeType = paramString3;
    this.packageName = paramString4;
    this.zzdjj = paramString5;
    this.zzdjk = paramString6;
    this.zzdjl = paramString7;
    this.intent = paramIntent;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzdji, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.url, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.mimeType, false);
    SafeParcelWriter.writeString(paramParcel, 5, this.packageName, false);
    SafeParcelWriter.writeString(paramParcel, 6, this.zzdjj, false);
    SafeParcelWriter.writeString(paramParcel, 7, this.zzdjk, false);
    SafeParcelWriter.writeString(paramParcel, 8, this.zzdjl, false);
    SafeParcelWriter.writeParcelable(paramParcel, 9, this.intent, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzc
 * JD-Core Version:    0.6.2
 */
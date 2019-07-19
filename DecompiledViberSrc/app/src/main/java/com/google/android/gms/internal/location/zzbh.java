package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

@SafeParcelable.Class(creator="ParcelableGeofenceCreator")
@SafeParcelable.Reserved({1000})
@VisibleForTesting
public final class zzbh extends AbstractSafeParcelable
  implements Geofence
{
  public static final Parcelable.Creator<zzbh> CREATOR = new zzbi();

  @SafeParcelable.Field(getter="getRequestId", id=1)
  private final String zzad;

  @SafeParcelable.Field(getter="getTransitionTypes", id=7)
  private final int zzae;

  @SafeParcelable.Field(getter="getType", id=3)
  private final short zzag;

  @SafeParcelable.Field(getter="getLatitude", id=4)
  private final double zzah;

  @SafeParcelable.Field(getter="getLongitude", id=5)
  private final double zzai;

  @SafeParcelable.Field(getter="getRadius", id=6)
  private final float zzaj;

  @SafeParcelable.Field(defaultValue="0", getter="getNotificationResponsiveness", id=8)
  private final int zzak;

  @SafeParcelable.Field(defaultValue="-1", getter="getLoiteringDelay", id=9)
  private final int zzal;

  @SafeParcelable.Field(getter="getExpirationTime", id=2)
  private final long zzdo;

  @SafeParcelable.Constructor
  public zzbh(@SafeParcelable.Param(id=1) String paramString, @SafeParcelable.Param(id=7) int paramInt1, @SafeParcelable.Param(id=3) short paramShort, @SafeParcelable.Param(id=4) double paramDouble1, @SafeParcelable.Param(id=5) double paramDouble2, @SafeParcelable.Param(id=6) float paramFloat, @SafeParcelable.Param(id=2) long paramLong, @SafeParcelable.Param(id=8) int paramInt2, @SafeParcelable.Param(id=9) int paramInt3)
  {
    if ((paramString == null) || (paramString.length() > 100))
    {
      String str1 = String.valueOf(paramString);
      if (str1.length() != 0);
      for (String str2 = "requestId is null or too long: ".concat(str1); ; str2 = new String("requestId is null or too long: "))
        throw new IllegalArgumentException(str2);
    }
    if (paramFloat <= 0.0F)
      throw new IllegalArgumentException(31 + "invalid radius: " + paramFloat);
    if ((paramDouble1 > 90.0D) || (paramDouble1 < -90.0D))
      throw new IllegalArgumentException(42 + "invalid latitude: " + paramDouble1);
    if ((paramDouble2 > 180.0D) || (paramDouble2 < -180.0D))
      throw new IllegalArgumentException(43 + "invalid longitude: " + paramDouble2);
    int i = paramInt1 & 0x7;
    if (i == 0)
      throw new IllegalArgumentException(46 + "No supported transition specified: " + paramInt1);
    this.zzag = paramShort;
    this.zzad = paramString;
    this.zzah = paramDouble1;
    this.zzai = paramDouble2;
    this.zzaj = paramFloat;
    this.zzdo = paramLong;
    this.zzae = i;
    this.zzak = paramInt2;
    this.zzal = paramInt3;
  }

  public static zzbh zza(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    zzbh localzzbh = (zzbh)CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    return localzzbh;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzbh localzzbh;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (!(paramObject instanceof zzbh))
        return false;
      localzzbh = (zzbh)paramObject;
      if (this.zzaj != localzzbh.zzaj)
        return false;
      if (this.zzah != localzzbh.zzah)
        return false;
      if (this.zzai != localzzbh.zzai)
        return false;
    }
    while (this.zzag == localzzbh.zzag);
    return false;
  }

  public final String getRequestId()
  {
    return this.zzad;
  }

  public final int hashCode()
  {
    long l1 = Double.doubleToLongBits(this.zzah);
    int i = 31 + (int)(l1 ^ l1 >>> 32);
    long l2 = Double.doubleToLongBits(this.zzai);
    return 31 * (31 * (31 * (i * 31 + (int)(l2 ^ l2 >>> 32)) + Float.floatToIntBits(this.zzaj)) + this.zzag) + this.zzae;
  }

  public final String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[9];
    switch (this.zzag)
    {
    default:
    case 1:
    }
    for (String str = null; ; str = "CIRCLE")
    {
      arrayOfObject[0] = str;
      arrayOfObject[1] = this.zzad.replaceAll("\\p{C}", "?");
      arrayOfObject[2] = Integer.valueOf(this.zzae);
      arrayOfObject[3] = Double.valueOf(this.zzah);
      arrayOfObject[4] = Double.valueOf(this.zzai);
      arrayOfObject[5] = Float.valueOf(this.zzaj);
      arrayOfObject[6] = Integer.valueOf(this.zzak / 1000);
      arrayOfObject[7] = Integer.valueOf(this.zzal);
      arrayOfObject[8] = Long.valueOf(this.zzdo);
      return String.format(localLocale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", arrayOfObject);
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getRequestId(), false);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzdo);
    SafeParcelWriter.writeShort(paramParcel, 3, this.zzag);
    SafeParcelWriter.writeDouble(paramParcel, 4, this.zzah);
    SafeParcelWriter.writeDouble(paramParcel, 5, this.zzai);
    SafeParcelWriter.writeFloat(paramParcel, 6, this.zzaj);
    SafeParcelWriter.writeInt(paramParcel, 7, this.zzae);
    SafeParcelWriter.writeInt(paramParcel, 8, this.zzak);
    SafeParcelWriter.writeInt(paramParcel, 9, this.zzal);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.location.zzbh
 * JD-Core Version:    0.6.2
 */
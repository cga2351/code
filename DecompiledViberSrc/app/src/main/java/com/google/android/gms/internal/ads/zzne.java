package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

public final class zzne
  implements Parcelable, Comparator<zza>
{
  public static final Parcelable.Creator<zzne> CREATOR = new zznf();
  private int zzafx;
  private final zza[] zzazf;
  public final int zzazg;

  zzne(Parcel paramParcel)
  {
    this.zzazf = ((zza[])paramParcel.createTypedArray(zza.CREATOR));
    this.zzazg = this.zzazf.length;
  }

  private zzne(boolean paramBoolean, zza[] paramArrayOfzza)
  {
    zza[] arrayOfzza = (zza[])paramArrayOfzza.clone();
    Arrays.sort(arrayOfzza, this);
    for (int i = 1; i < arrayOfzza.length; i++)
      if (zza.zza(arrayOfzza[(i - 1)]).equals(zza.zza(arrayOfzza[i])))
      {
        String str = String.valueOf(zza.zza(arrayOfzza[i]));
        throw new IllegalArgumentException(25 + String.valueOf(str).length() + "Duplicate data for uuid: " + str);
      }
    this.zzazf = arrayOfzza;
    this.zzazg = arrayOfzza.length;
  }

  public zzne(zza[] paramArrayOfzza)
  {
    this(true, paramArrayOfzza);
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    return Arrays.equals(this.zzazf, ((zzne)paramObject).zzazf);
  }

  public final int hashCode()
  {
    if (this.zzafx == 0)
      this.zzafx = Arrays.hashCode(this.zzazf);
    return this.zzafx;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.zzazf, 0);
  }

  public final zza zzap(int paramInt)
  {
    return this.zzazf[paramInt];
  }

  public static final class zza
    implements Parcelable
  {
    public static final Parcelable.Creator<zza> CREATOR = new zzng();
    private final byte[] data;
    private final String mimeType;
    private final UUID uuid;
    private int zzafx;
    public final boolean zzazh;

    zza(Parcel paramParcel)
    {
      this.uuid = new UUID(paramParcel.readLong(), paramParcel.readLong());
      this.mimeType = paramParcel.readString();
      this.data = paramParcel.createByteArray();
      if (paramParcel.readByte() != 0);
      for (boolean bool = true; ; bool = false)
      {
        this.zzazh = bool;
        return;
      }
    }

    public zza(UUID paramUUID, String paramString, byte[] paramArrayOfByte)
    {
      this(paramUUID, paramString, paramArrayOfByte, false);
    }

    private zza(UUID paramUUID, String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      this.uuid = ((UUID)zzsk.checkNotNull(paramUUID));
      this.mimeType = ((String)zzsk.checkNotNull(paramString));
      this.data = ((byte[])zzsk.checkNotNull(paramArrayOfByte));
      this.zzazh = false;
    }

    public final int describeContents()
    {
      return 0;
    }

    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zza));
      zza localzza;
      do
      {
        return false;
        if (paramObject == this)
          return true;
        localzza = (zza)paramObject;
      }
      while ((!this.mimeType.equals(localzza.mimeType)) || (!zzsy.zza(this.uuid, localzza.uuid)) || (!Arrays.equals(this.data, localzza.data)));
      return true;
    }

    public final int hashCode()
    {
      if (this.zzafx == 0)
        this.zzafx = (31 * (31 * this.uuid.hashCode() + this.mimeType.hashCode()) + Arrays.hashCode(this.data));
      return this.zzafx;
    }

    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeLong(this.uuid.getMostSignificantBits());
      paramParcel.writeLong(this.uuid.getLeastSignificantBits());
      paramParcel.writeString(this.mimeType);
      paramParcel.writeByteArray(this.data);
      if (this.zzazh);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeByte((byte)i);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzne
 * JD-Core Version:    0.6.2
 */
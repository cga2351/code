package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Arrays;

@SafeParcelable.Class(creator="AssetCreator")
@SafeParcelable.Reserved({1})
@VisibleForTesting
public class Asset extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<Asset> CREATOR = new zze();

  @SafeParcelable.Field(getter="getData", id=2)
  private byte[] data;

  @SafeParcelable.Field(id=5)
  private Uri uri;

  @SafeParcelable.Field(getter="getDigest", id=3)
  private String zze;

  @SafeParcelable.Field(id=4)
  private ParcelFileDescriptor zzf;

  @SafeParcelable.Constructor
  Asset(@SafeParcelable.Param(id=2) byte[] paramArrayOfByte, @SafeParcelable.Param(id=3) String paramString, @SafeParcelable.Param(id=4) ParcelFileDescriptor paramParcelFileDescriptor, @SafeParcelable.Param(id=5) Uri paramUri)
  {
    this.data = paramArrayOfByte;
    this.zze = paramString;
    this.zzf = paramParcelFileDescriptor;
    this.uri = paramUri;
  }

  @VisibleForTesting
  public static Asset createFromBytes(byte[] paramArrayOfByte)
  {
    Asserts.checkNotNull(paramArrayOfByte);
    return new Asset(paramArrayOfByte, null, null, null);
  }

  @VisibleForTesting
  public static Asset createFromFd(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    Asserts.checkNotNull(paramParcelFileDescriptor);
    return new Asset(null, null, paramParcelFileDescriptor, null);
  }

  public static Asset createFromRef(String paramString)
  {
    Asserts.checkNotNull(paramString);
    return new Asset(null, paramString, null, null);
  }

  @VisibleForTesting
  public static Asset createFromUri(Uri paramUri)
  {
    Asserts.checkNotNull(paramUri);
    return new Asset(null, null, null, paramUri);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Asset localAsset;
    do
    {
      return true;
      if (!(paramObject instanceof Asset))
        return false;
      localAsset = (Asset)paramObject;
    }
    while ((Arrays.equals(this.data, localAsset.data)) && (Objects.equal(this.zze, localAsset.zze)) && (Objects.equal(this.zzf, localAsset.zzf)) && (Objects.equal(this.uri, localAsset.uri)));
    return false;
  }

  public final byte[] getData()
  {
    return this.data;
  }

  public String getDigest()
  {
    return this.zze;
  }

  public ParcelFileDescriptor getFd()
  {
    return this.zzf;
  }

  public Uri getUri()
  {
    return this.uri;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = this.data;
    arrayOfObject[1] = this.zze;
    arrayOfObject[2] = this.zzf;
    arrayOfObject[3] = this.uri;
    return Arrays.deepHashCode(arrayOfObject);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Asset[@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.zze == null)
      localStringBuilder.append(", nodigest");
    while (true)
    {
      if (this.data != null)
      {
        localStringBuilder.append(", size=");
        localStringBuilder.append(this.data.length);
      }
      if (this.zzf != null)
      {
        localStringBuilder.append(", fd=");
        localStringBuilder.append(this.zzf);
      }
      if (this.uri != null)
      {
        localStringBuilder.append(", uri=");
        localStringBuilder.append(this.uri);
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(", ");
      localStringBuilder.append(this.zze);
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Asserts.checkNotNull(paramParcel);
    int i = paramInt | 0x1;
    int j = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeByteArray(paramParcel, 2, this.data, false);
    SafeParcelWriter.writeString(paramParcel, 3, getDigest(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, this.zzf, i, false);
    SafeParcelWriter.writeParcelable(paramParcel, 5, this.uri, i, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, j);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.Asset
 * JD-Core Version:    0.6.2
 */
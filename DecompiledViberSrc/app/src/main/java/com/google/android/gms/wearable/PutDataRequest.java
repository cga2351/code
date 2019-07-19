package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator="PutDataRequestCreator")
@SafeParcelable.Reserved({1})
@VisibleForTesting
public class PutDataRequest extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<PutDataRequest> CREATOR = new zzh();
  public static final String WEAR_URI_SCHEME = "wear";
  private static final long zzt = TimeUnit.MINUTES.toMillis(30L);
  private static final Random zzu = new SecureRandom();

  @SafeParcelable.Field(getter="getData", id=5)
  private byte[] data;

  @SafeParcelable.Field(getter="getUri", id=2)
  private final Uri uri;

  @SafeParcelable.Field(getter="getAssetsInternal", id=4)
  private final Bundle zzv;

  @SafeParcelable.Field(getter="getSyncDeadline", id=6)
  private long zzw;

  private PutDataRequest(Uri paramUri)
  {
    this(paramUri, new Bundle(), null, zzt);
  }

  @SafeParcelable.Constructor
  PutDataRequest(@SafeParcelable.Param(id=2) Uri paramUri, @SafeParcelable.Param(id=4) Bundle paramBundle, @SafeParcelable.Param(id=5) byte[] paramArrayOfByte, @SafeParcelable.Param(id=6) long paramLong)
  {
    this.uri = paramUri;
    this.zzv = paramBundle;
    this.zzv.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    this.data = paramArrayOfByte;
    this.zzw = paramLong;
  }

  public static PutDataRequest create(String paramString)
  {
    Asserts.checkNotNull(paramString, "path must not be null");
    return zza(zza(paramString));
  }

  public static PutDataRequest createFromDataItem(DataItem paramDataItem)
  {
    Asserts.checkNotNull(paramDataItem, "source must not be null");
    PutDataRequest localPutDataRequest = zza(paramDataItem.getUri());
    Iterator localIterator = paramDataItem.getAssets().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((DataItemAsset)localEntry.getValue()).getId() == null)
      {
        String str1 = String.valueOf((String)localEntry.getKey());
        if (str1.length() != 0);
        for (String str2 = "Cannot create an asset for a put request without a digest: ".concat(str1); ; str2 = new String("Cannot create an asset for a put request without a digest: "))
          throw new IllegalStateException(str2);
      }
      localPutDataRequest.putAsset((String)localEntry.getKey(), Asset.createFromRef(((DataItemAsset)localEntry.getValue()).getId()));
    }
    localPutDataRequest.setData(paramDataItem.getData());
    return localPutDataRequest;
  }

  public static PutDataRequest createWithAutoAppendedId(String paramString)
  {
    Asserts.checkNotNull(paramString, "pathPrefix must not be null");
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    if (!paramString.endsWith("/"))
      localStringBuilder.append("/");
    localStringBuilder.append("PN").append(zzu.nextLong());
    return new PutDataRequest(zza(localStringBuilder.toString()));
  }

  private static Uri zza(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("An empty path was supplied.");
    if (!paramString.startsWith("/"))
      throw new IllegalArgumentException("A path must start with a single / .");
    if (paramString.startsWith("//"))
      throw new IllegalArgumentException("A path must start with a single / .");
    return new Uri.Builder().scheme("wear").path(paramString).build();
  }

  public static PutDataRequest zza(Uri paramUri)
  {
    Asserts.checkNotNull(paramUri, "uri must not be null");
    return new PutDataRequest(paramUri);
  }

  @VisibleForTesting
  public Asset getAsset(String paramString)
  {
    Asserts.checkNotNull(paramString, "key must not be null");
    return (Asset)this.zzv.getParcelable(paramString);
  }

  public Map<String, Asset> getAssets()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.zzv.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, (Asset)this.zzv.getParcelable(str));
    }
    return Collections.unmodifiableMap(localHashMap);
  }

  @VisibleForTesting
  public byte[] getData()
  {
    return this.data;
  }

  public Uri getUri()
  {
    return this.uri;
  }

  public boolean hasAsset(String paramString)
  {
    Asserts.checkNotNull(paramString, "key must not be null");
    return this.zzv.containsKey(paramString);
  }

  public boolean isUrgent()
  {
    return this.zzw == 0L;
  }

  public PutDataRequest putAsset(String paramString, Asset paramAsset)
  {
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramAsset);
    this.zzv.putParcelable(paramString, paramAsset);
    return this;
  }

  public PutDataRequest removeAsset(String paramString)
  {
    Asserts.checkNotNull(paramString, "key must not be null");
    this.zzv.remove(paramString);
    return this;
  }

  public PutDataRequest setData(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
    return this;
  }

  public PutDataRequest setUrgent()
  {
    this.zzw = 0L;
    return this;
  }

  public String toString()
  {
    return toString(Log.isLoggable("DataMap", 3));
  }

  public String toString(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("PutDataRequest[");
    if (this.data == null);
    for (Object localObject = "null"; ; localObject = Integer.valueOf(this.data.length))
    {
      String str1 = String.valueOf(localObject);
      localStringBuilder.append(7 + String.valueOf(str1).length() + "dataSz=" + str1);
      int i = this.zzv.size();
      localStringBuilder.append(23 + ", numAssets=" + i);
      String str2 = String.valueOf(this.uri);
      localStringBuilder.append(6 + String.valueOf(str2).length() + ", uri=" + str2);
      long l = this.zzw;
      localStringBuilder.append(35 + ", syncDeadline=" + l);
      if (paramBoolean)
        break;
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    localStringBuilder.append("]\n  assets: ");
    Iterator localIterator = this.zzv.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      String str4 = String.valueOf(this.zzv.getParcelable(str3));
      localStringBuilder.append(7 + String.valueOf(str3).length() + String.valueOf(str4).length() + "\n    " + str3 + ": " + str4);
    }
    localStringBuilder.append("\n  ]");
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Asserts.checkNotNull(paramParcel, "dest must not be null");
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getUri(), paramInt, false);
    SafeParcelWriter.writeBundle(paramParcel, 4, this.zzv, false);
    SafeParcelWriter.writeByteArray(paramParcel, 5, getData(), false);
    SafeParcelWriter.writeLong(paramParcel, 6, this.zzw);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.PutDataRequest
 * JD-Core Version:    0.6.2
 */
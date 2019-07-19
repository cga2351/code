package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@SafeParcelable.Class(creator="DataItemParcelableCreator")
@SafeParcelable.Reserved({1})
@VisibleForTesting
public final class zzdd extends AbstractSafeParcelable
  implements DataItem
{
  public static final Parcelable.Creator<zzdd> CREATOR = new zzde();

  @SafeParcelable.Field(getter="getData", id=5)
  private byte[] data;

  @SafeParcelable.Field(getter="getUri", id=2)
  private final Uri uri;

  @SafeParcelable.Field(getter="getAssetsInternal", id=4, type="android.os.Bundle")
  private final Map<String, DataItemAsset> zzdo;

  @SafeParcelable.Constructor
  zzdd(@SafeParcelable.Param(id=2) Uri paramUri, @SafeParcelable.Param(id=4) Bundle paramBundle, @SafeParcelable.Param(id=5) byte[] paramArrayOfByte)
  {
    this.uri = paramUri;
    HashMap localHashMap = new HashMap();
    paramBundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, (DataItemAssetParcelable)paramBundle.getParcelable(str));
    }
    this.zzdo = localHashMap;
    this.data = paramArrayOfByte;
  }

  public final Map<String, DataItemAsset> getAssets()
  {
    return this.zzdo;
  }

  @VisibleForTesting
  public final byte[] getData()
  {
    return this.data;
  }

  public final Uri getUri()
  {
    return this.uri;
  }

  public final boolean isDataValid()
  {
    return true;
  }

  public final String toString()
  {
    boolean bool = Log.isLoggable("DataItem", 3);
    StringBuilder localStringBuilder = new StringBuilder("DataItemParcelable[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.data == null);
    for (Object localObject = "null"; ; localObject = Integer.valueOf(this.data.length))
    {
      String str1 = String.valueOf(localObject);
      localStringBuilder.append(8 + String.valueOf(str1).length() + ",dataSz=" + str1);
      int i = this.zzdo.size();
      localStringBuilder.append(23 + ", numAssets=" + i);
      String str2 = String.valueOf(this.uri);
      localStringBuilder.append(6 + String.valueOf(str2).length() + ", uri=" + str2);
      if (bool)
        break;
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    localStringBuilder.append("]\n  assets: ");
    Iterator localIterator = this.zzdo.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      String str4 = String.valueOf(this.zzdo.get(str3));
      localStringBuilder.append(7 + String.valueOf(str3).length() + String.valueOf(str4).length() + "\n    " + str3 + ": " + str4);
    }
    localStringBuilder.append("\n  ]");
    return localStringBuilder.toString();
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getUri(), paramInt, false);
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    Iterator localIterator = this.zzdo.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localBundle.putParcelable((String)localEntry.getKey(), new DataItemAssetParcelable((DataItemAsset)localEntry.getValue()));
    }
    SafeParcelWriter.writeBundle(paramParcel, 4, localBundle, false);
    SafeParcelWriter.writeByteArray(paramParcel, 5, getData(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzdd
 * JD-Core Version:    0.6.2
 */
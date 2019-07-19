package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzdf extends DataBufferRef
  implements DataItem
{
  private final int zzdl;

  public zzdf(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.zzdl = paramInt2;
  }

  public final Map<String, DataItemAsset> getAssets()
  {
    HashMap localHashMap = new HashMap(this.zzdl);
    for (int i = 0; i < this.zzdl; i++)
    {
      zzdb localzzdb = new zzdb(this.mDataHolder, i + this.mDataRow);
      if (localzzdb.getDataItemKey() != null)
        localHashMap.put(localzzdb.getDataItemKey(), localzzdb);
    }
    return localHashMap;
  }

  public final byte[] getData()
  {
    return getByteArray("data");
  }

  public final Uri getUri()
  {
    return Uri.parse(getString("path"));
  }

  public final DataItem setData(byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException();
  }

  public final String toString()
  {
    boolean bool = Log.isLoggable("DataItem", 3);
    byte[] arrayOfByte = getData();
    Map localMap = getAssets();
    StringBuilder localStringBuilder = new StringBuilder("DataItemRef{ ");
    String str1 = String.valueOf(getUri());
    localStringBuilder.append(4 + String.valueOf(str1).length() + "uri=" + str1);
    if (arrayOfByte == null);
    for (Object localObject = "null"; ; localObject = Integer.valueOf(arrayOfByte.length))
    {
      String str2 = String.valueOf(localObject);
      localStringBuilder.append(9 + String.valueOf(str2).length() + ", dataSz=" + str2);
      int i = localMap.size();
      localStringBuilder.append(23 + ", numAssets=" + i);
      if ((!bool) || (localMap.isEmpty()))
        break label339;
      localStringBuilder.append(", assets=[");
      Iterator localIterator = localMap.entrySet().iterator();
      for (String str3 = ""; localIterator.hasNext(); str3 = ", ")
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str4 = (String)localEntry.getKey();
        String str5 = ((DataItemAsset)localEntry.getValue()).getId();
        localStringBuilder.append(2 + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + str3 + str4 + ": " + str5);
      }
    }
    localStringBuilder.append("]");
    label339: localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzdf
 * JD-Core Version:    0.6.2
 */
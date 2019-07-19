package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzdc
  implements DataItem
{
  private byte[] data;
  private Uri uri;
  private Map<String, DataItemAsset> zzdo;

  public zzdc(DataItem paramDataItem)
  {
    this.uri = paramDataItem.getUri();
    this.data = paramDataItem.getData();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramDataItem.getAssets().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getKey() != null)
        localHashMap.put((String)localEntry.getKey(), (DataItemAsset)((DataItemAsset)localEntry.getValue()).freeze());
    }
    this.zzdo = Collections.unmodifiableMap(localHashMap);
  }

  public final Map<String, DataItemAsset> getAssets()
  {
    return this.zzdo;
  }

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

  public final DataItem setData(byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException();
  }

  public final String toString()
  {
    boolean bool = Log.isLoggable("DataItem", 3);
    StringBuilder localStringBuilder = new StringBuilder("DataItemEntity{ ");
    String str1 = String.valueOf(this.uri);
    localStringBuilder.append(4 + String.valueOf(str1).length() + "uri=" + str1);
    if (this.data == null);
    for (Object localObject = "null"; ; localObject = Integer.valueOf(this.data.length))
    {
      String str2 = String.valueOf(localObject);
      localStringBuilder.append(9 + String.valueOf(str2).length() + ", dataSz=" + str2);
      int i = this.zzdo.size();
      localStringBuilder.append(23 + ", numAssets=" + i);
      if ((!bool) || (this.zzdo.isEmpty()))
        break label334;
      localStringBuilder.append(", assets=[");
      Iterator localIterator = this.zzdo.entrySet().iterator();
      for (String str3 = ""; localIterator.hasNext(); str3 = ", ")
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str4 = (String)localEntry.getKey();
        String str5 = ((DataItemAsset)localEntry.getValue()).getId();
        localStringBuilder.append(2 + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + str3 + str4 + ": " + str5);
      }
    }
    localStringBuilder.append("]");
    label334: localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzdc
 * JD-Core Version:    0.6.2
 */
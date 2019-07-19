package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.wearable.zze;
import com.google.android.gms.internal.wearable.zzf;
import com.google.android.gms.internal.wearable.zzg;
import com.google.android.gms.internal.wearable.zzs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@VisibleForTesting
public class DataMapItem
{
  private final Uri uri;
  private final DataMap zzr;

  private DataMapItem(DataItem paramDataItem)
  {
    this.uri = paramDataItem.getUri();
    this.zzr = zza((DataItem)paramDataItem.freeze());
  }

  public static DataMapItem fromDataItem(DataItem paramDataItem)
  {
    Asserts.checkNotNull(paramDataItem, "dataItem must not be null");
    return new DataMapItem(paramDataItem);
  }

  private static DataMap zza(DataItem paramDataItem)
  {
    if ((paramDataItem.getData() == null) && (paramDataItem.getAssets().size() > 0))
      throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
    if (paramDataItem.getData() == null)
      return new DataMap();
    try
    {
      localArrayList = new ArrayList();
      int i = paramDataItem.getAssets().size();
      j = 0;
      if (j < i)
      {
        localDataItemAsset = (DataItemAsset)paramDataItem.getAssets().get(Integer.toString(j));
        if (localDataItemAsset == null)
        {
          String str4 = String.valueOf(paramDataItem);
          throw new IllegalStateException(64 + String.valueOf(str4).length() + "Cannot find DataItemAsset referenced in data at " + j + " for " + str4);
        }
      }
    }
    catch (zzs localzzs)
    {
      ArrayList localArrayList;
      while (true)
      {
        int j;
        DataItemAsset localDataItemAsset;
        String str1 = String.valueOf(paramDataItem.getUri());
        String str2 = Base64.encodeToString(paramDataItem.getData(), 0);
        Log.w("DataItem", 50 + String.valueOf(str1).length() + String.valueOf(str2).length() + "Unable to parse datamap from dataItem. uri=" + str1 + ", data=" + str2);
        String str3 = String.valueOf(paramDataItem.getUri());
        throw new IllegalStateException(44 + String.valueOf(str3).length() + "Unable to parse datamap from dataItem.  uri=" + str3, localzzs);
        localArrayList.add(Asset.createFromRef(localDataItemAsset.getId()));
        j++;
      }
      DataMap localDataMap = zze.zza(new zzf(zzg.zza(paramDataItem.getData()), localArrayList));
      return localDataMap;
    }
    catch (NullPointerException localNullPointerException)
    {
      label163: break label163;
    }
  }

  public DataMap getDataMap()
  {
    return this.zzr;
  }

  public Uri getUri()
  {
    return this.uri;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.DataMapItem
 * JD-Core Version:    0.6.2
 */
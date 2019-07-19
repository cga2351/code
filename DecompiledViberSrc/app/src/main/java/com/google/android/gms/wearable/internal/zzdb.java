package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemAsset;

public final class zzdb extends DataBufferRef
  implements DataItemAsset
{
  public zzdb(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }

  public final String getDataItemKey()
  {
    return getString("asset_key");
  }

  public final String getId()
  {
    return getString("asset_id");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzdb
 * JD-Core Version:    0.6.2
 */
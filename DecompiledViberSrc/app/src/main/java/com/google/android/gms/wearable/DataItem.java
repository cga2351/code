package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;

@VisibleForTesting
public abstract interface DataItem extends Freezable<DataItem>
{
  public abstract Map<String, DataItemAsset> getAssets();

  public abstract byte[] getData();

  public abstract Uri getUri();

  public abstract DataItem setData(byte[] paramArrayOfByte);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.DataItem
 * JD-Core Version:    0.6.2
 */
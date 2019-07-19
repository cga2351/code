package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public final class zzcy extends DataBufferRef
  implements DataEvent
{
  private final int zzdl;

  public zzcy(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.zzdl = paramInt2;
  }

  public final DataItem getDataItem()
  {
    return new zzdf(this.mDataHolder, this.mDataRow, this.zzdl);
  }

  public final int getType()
  {
    return getInteger("event_type");
  }

  public final String toString()
  {
    String str1;
    if (getType() == 1)
      str1 = "changed";
    while (true)
    {
      String str2 = String.valueOf(getDataItem());
      return 32 + String.valueOf(str1).length() + String.valueOf(str2).length() + "DataEventRef{ type=" + str1 + ", dataitem=" + str2 + " }";
      if (getType() == 2)
        str1 = "deleted";
      else
        str1 = "unknown";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcy
 * JD-Core Version:    0.6.2
 */
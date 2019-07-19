package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public final class zzcx
  implements DataEvent
{
  private int type;
  private DataItem zzdg;

  public zzcx(DataEvent paramDataEvent)
  {
    this.type = paramDataEvent.getType();
    this.zzdg = ((DataItem)paramDataEvent.getDataItem().freeze());
  }

  public final DataItem getDataItem()
  {
    return this.zzdg;
  }

  public final int getType()
  {
    return this.type;
  }

  public final boolean isDataValid()
  {
    return true;
  }

  public final String toString()
  {
    String str1;
    if (getType() == 1)
      str1 = "changed";
    while (true)
    {
      String str2 = String.valueOf(getDataItem());
      return 35 + String.valueOf(str1).length() + String.valueOf(str2).length() + "DataEventEntity{ type=" + str1 + ", dataitem=" + str2 + " }";
      if (getType() == 2)
        str1 = "deleted";
      else
        str1 = "unknown";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcx
 * JD-Core Version:    0.6.2
 */
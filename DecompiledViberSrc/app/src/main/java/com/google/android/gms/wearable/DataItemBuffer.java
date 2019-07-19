package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public class DataItemBuffer extends EntityBuffer<DataItem>
  implements Result
{
  private final Status zzp;

  public DataItemBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.zzp = new Status(paramDataHolder.getStatusCode());
  }

  protected String getPrimaryDataMarkerColumn()
  {
    return "path";
  }

  public Status getStatus()
  {
    return this.zzp;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.DataItemBuffer
 * JD-Core Version:    0.6.2
 */
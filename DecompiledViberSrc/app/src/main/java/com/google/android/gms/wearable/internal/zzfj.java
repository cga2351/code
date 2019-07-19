package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import java.util.List;

public final class zzfj
  implements NodeApi.GetConnectedNodesResult
{
  private final List<Node> zzdx;
  private final Status zzp;

  public zzfj(Status paramStatus, List<Node> paramList)
  {
    this.zzp = paramStatus;
    this.zzdx = paramList;
  }

  public final List<Node> getNodes()
  {
    return this.zzdx;
  }

  public final Status getStatus()
  {
    return this.zzp;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzfj
 * JD-Core Version:    0.6.2
 */
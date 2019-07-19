package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;

public final class zzfk
  implements NodeApi.GetLocalNodeResult
{
  private final Node zzel;
  private final Status zzp;

  public zzfk(Status paramStatus, Node paramNode)
  {
    this.zzp = paramStatus;
    this.zzel = paramNode;
  }

  public final Node getNode()
  {
    return this.zzel;
  }

  public final Status getStatus()
  {
    return this.zzp;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzfk
 * JD-Core Version:    0.6.2
 */
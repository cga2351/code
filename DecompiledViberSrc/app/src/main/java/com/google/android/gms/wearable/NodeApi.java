package com.google.android.gms.wearable;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import java.util.List;

@Deprecated
public abstract interface NodeApi
{
  public abstract PendingResult<GetConnectedNodesResult> getConnectedNodes(GoogleApiClient paramGoogleApiClient);

  public abstract PendingResult<GetLocalNodeResult> getLocalNode(GoogleApiClient paramGoogleApiClient);

  @Deprecated
  public static abstract interface GetConnectedNodesResult extends Result
  {
    public abstract List<Node> getNodes();
  }

  @Deprecated
  public static abstract interface GetLocalNodeResult extends Result
  {
    public abstract Node getNode();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.NodeApi
 * JD-Core Version:    0.6.2
 */
package com.facebook.imagepipeline.producers;

import java.util.Map;
import javax.annotation.Nullable;

public abstract class BaseNetworkFetcher<FETCH_STATE extends FetchState>
  implements NetworkFetcher<FETCH_STATE>
{
  @Nullable
  public Map<String, String> getExtraMap(FETCH_STATE paramFETCH_STATE, int paramInt)
  {
    return null;
  }

  public void onFetchCompletion(FETCH_STATE paramFETCH_STATE, int paramInt)
  {
  }

  public boolean shouldPropagate(FETCH_STATE paramFETCH_STATE)
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.BaseNetworkFetcher
 * JD-Core Version:    0.6.2
 */
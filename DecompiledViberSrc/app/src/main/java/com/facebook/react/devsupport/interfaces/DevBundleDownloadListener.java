package com.facebook.react.devsupport.interfaces;

import com.facebook.react.bridge.NativeDeltaClient;
import javax.annotation.Nullable;

public abstract interface DevBundleDownloadListener
{
  public abstract void onFailure(Exception paramException);

  public abstract void onProgress(@Nullable String paramString, @Nullable Integer paramInteger1, @Nullable Integer paramInteger2);

  public abstract void onSuccess(@Nullable NativeDeltaClient paramNativeDeltaClient);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.interfaces.DevBundleDownloadListener
 * JD-Core Version:    0.6.2
 */
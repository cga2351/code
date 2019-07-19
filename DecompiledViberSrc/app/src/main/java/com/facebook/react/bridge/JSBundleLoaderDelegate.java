package com.facebook.react.bridge;

import android.content.res.AssetManager;

public abstract interface JSBundleLoaderDelegate
{
  public abstract void loadScriptFromAssets(AssetManager paramAssetManager, String paramString, boolean paramBoolean);

  public abstract void loadScriptFromDeltaBundle(String paramString, NativeDeltaClient paramNativeDeltaClient, boolean paramBoolean);

  public abstract void loadScriptFromFile(String paramString1, String paramString2, boolean paramBoolean);

  public abstract void setSourceURLs(String paramString1, String paramString2);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JSBundleLoaderDelegate
 * JD-Core Version:    0.6.2
 */
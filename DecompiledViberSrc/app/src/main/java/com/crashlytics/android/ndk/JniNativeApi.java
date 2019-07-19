package com.crashlytics.android.ndk;

import android.content.res.AssetManager;

class JniNativeApi
  implements d
{
  static
  {
    System.loadLibrary("crashlytics");
  }

  private native boolean nativeInit(String paramString, Object paramObject);

  public boolean a(String paramString, AssetManager paramAssetManager)
  {
    return nativeInit(paramString, paramAssetManager);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.ndk.JniNativeApi
 * JD-Core Version:    0.6.2
 */
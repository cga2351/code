package com.mopub.nativeads;

abstract interface PositioningSource
{
  public abstract void loadPositions(String paramString, PositioningListener paramPositioningListener);

  public static abstract interface PositioningListener
  {
    public abstract void onFailed();

    public abstract void onLoad(MoPubNativeAdPositioning.MoPubClientPositioning paramMoPubClientPositioning);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.PositioningSource
 * JD-Core Version:    0.6.2
 */
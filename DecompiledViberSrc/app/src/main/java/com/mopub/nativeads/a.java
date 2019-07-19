package com.mopub.nativeads;

import android.os.Handler;

class a
  implements PositioningSource
{
  private final Handler a = new Handler();
  private final MoPubNativeAdPositioning.MoPubClientPositioning b;

  a(MoPubNativeAdPositioning.MoPubClientPositioning paramMoPubClientPositioning)
  {
    this.b = MoPubNativeAdPositioning.a(paramMoPubClientPositioning);
  }

  public void loadPositions(String paramString, final PositioningSource.PositioningListener paramPositioningListener)
  {
    this.a.post(new Runnable()
    {
      public void run()
      {
        paramPositioningListener.onLoad(a.a(a.this));
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.a
 * JD-Core Version:    0.6.2
 */
package com.vk.sdk;

public abstract class VKAccessTokenTracker
{
  private boolean isTracking = false;

  public boolean isTracking()
  {
    return this.isTracking;
  }

  public abstract void onVKAccessTokenChanged(VKAccessToken paramVKAccessToken1, VKAccessToken paramVKAccessToken2);

  public void startTracking()
  {
    VKSdk.addVKTokenTracker(this);
    this.isTracking = true;
  }

  public void stopTracking()
  {
    VKSdk.removeVKTokenTracker(this);
    this.isTracking = false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.VKAccessTokenTracker
 * JD-Core Version:    0.6.2
 */
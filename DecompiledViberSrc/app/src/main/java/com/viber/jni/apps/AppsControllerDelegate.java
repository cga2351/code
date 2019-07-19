package com.viber.jni.apps;

import com.viber.jni.CGetAppDetails;

public abstract interface AppsControllerDelegate
{
  public static abstract interface AppDetailsReceiver
  {
    public abstract void onGetAppDetails(CGetAppDetails[] paramArrayOfCGetAppDetails, int paramInt1, int paramInt2);
  }

  public static abstract interface AppsDelegate extends AppsControllerDelegate.AppDetailsReceiver, AppsControllerDelegate.Authenticator, AppsControllerDelegate.Blocker, AppsControllerDelegate.Support, AppsControllerDelegate.UserAppsReceiver
  {
  }

  public static abstract interface Authenticator
  {
    public abstract void onAuthenticateAppReply(String paramString, int paramInt1, int paramInt2, int paramInt3);

    public abstract void onUnregisterAppReply(int paramInt1, int paramInt2);
  }

  public static abstract interface Blocker
  {
    public abstract void onBlockAppReply(int paramInt1, int paramInt2);
  }

  public static abstract interface Support
  {
    public abstract void onAppsApiSupported();
  }

  public static abstract interface UserAppsReceiver
  {
    public abstract void onGetUserAppsReply(int[] paramArrayOfInt, int paramInt1, int paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.apps.AppsControllerDelegate
 * JD-Core Version:    0.6.2
 */
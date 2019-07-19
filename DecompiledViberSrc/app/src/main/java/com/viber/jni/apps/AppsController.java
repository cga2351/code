package com.viber.jni.apps;

public abstract interface AppsController
{
  public abstract boolean handleAuthenticateApp(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean);

  public abstract boolean handleBlockApp(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3);

  public abstract boolean handleGetAppDetails(int[] paramArrayOfInt, int paramInt);

  public abstract boolean handleGetUserApps(String paramString, int paramInt);

  public abstract boolean handleUnregisterApp(int paramInt1, int paramInt2);

  public static class EAppsApiStatus
  {
    public static final int APPS_API_APP_BLOCKED = 12;
    public static final int APPS_API_BAD_APPID = 2;
    public static final int APPS_API_BAD_PARAMETERS = 11;
    public static final int APPS_API_INTERNAL_FAILURE = 1;
    public static final int APPS_API_INVALID_DATA = 7;
    public static final int APPS_API_INVALID_DESTINATION = 9;
    public static final int APPS_API_INVALID_MESSAGE_TYPE = 8;
    public static final int APPS_API_MESSAGE_TYPE_BLOCKED = 14;
    public static final int APPS_API_NOT_AUTHENTICATED = 5;
    public static final int APPS_API_NOT_PERMITTED = 3;
    public static final int APPS_API_NOT_REGISTERED = 4;
    public static final int APPS_API_NO_SUITABLE_DEVICE = 10;
    public static final int APPS_API_RECEIVER_NOT_REG = 6;
    public static final int APPS_API_SUCCESS = 0;
    public static final int APPS_API_TIMEOUT = 13;
  }

  public static final class EUserAppsReply
  {
    public static final int USER_APPS_REPLY_FAIL = 1;
    public static final int USER_APPS_REPLY_OK = 0;
    public static final int USER_APPS_REPLY_TIMEOUT = 2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.apps.AppsController
 * JD-Core Version:    0.6.2
 */
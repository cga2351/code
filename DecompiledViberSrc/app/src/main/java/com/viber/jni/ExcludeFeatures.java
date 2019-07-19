package com.viber.jni;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ExcludeFeatures
{
  static byte[] exclude(int[] paramArrayOfInt)
  {
    byte[] arrayOfByte = new byte[paramArrayOfInt.length];
    for (int i = 0; i < paramArrayOfInt.length; i++)
      arrayOfByte[i] = ((byte)paramArrayOfInt[i]);
    return arrayOfByte;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ClientFeatureId
  {
    public static final int FEATURE_APPS_API = 3;
    public static final int FEATURE_BANNER_AND_SPLASH = 20;
    public static final int FEATURE_DELETE_MESSAGE_IN_GROUP = 21;
    public static final int FEATURE_FILE_SHARING = 22;
    public static final int FEATURE_FORMATTED_MESSAGES = 2;
    public static final int FEATURE_GROUP_ADMIN = 14;
    public static final int FEATURE_GROUP_ICON = 7;
    public static final int FEATURE_GROUP_LIKES = 18;
    public static final int FEATURE_IOS8_PUSH_SERVER_NOTIFICATION = 0;
    public static final int FEATURE_MESSAGE_INFO_IN_GROUP = 24;
    public static final int FEATURE_MIXPANEL_SETTINGS = 6;
    public static final int FEATURE_PG_AGE_RESTRICTED = 15;
    public static final int FEATURE_PG_MULTI_DEVICE_SUPPORT = 1;
    public static final int FEATURE_PG_NOT_SEARCHABLE = 16;
    public static final int FEATURE_PUBLIC_ACCOUNT = 26;
    public static final int FEATURE_PUBLIC_ACCOUNT_EX = 28;
    public static final int FEATURE_PUBLIC_CHAT_INVITES = 4;
    public static final int FEATURE_PUBLIC_CHAT_INVITE_TO_GROUP = 12;
    public static final int FEATURE_REMOTE_SETTINGS = 27;
    public static final int FEATURE_REPLYABLE_SERVICE = 25;
    public static final int FEATURE_SECRET_CHAT = 29;
    public static final int FEATURE_SEND_LOCATION = 11;
    public static final int FEATURE_SEND_MEDIA_WITH_URL = 8;
    public static final int FEATURE_SHARE_ADDRESS_BOOK = 13;
    public static final int FEATURE_SHARE_CONTACT = 9;
    public static final int FEATURE_SPAM_HANDLING_IN_GROUP = 17;
    public static final int FEATURE_URL_MESSAGE = 10;
    public static final int FEATURE_VIBEROUT_BALANCE_NOTIFY = 19;
    public static final int FEATURE_VIBER_DETAILS_ANYWHERE = 5;
    public static final int FEATURE_WINK_MESSAGE = 23;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.ExcludeFeatures
 * JD-Core Version:    0.6.2
 */
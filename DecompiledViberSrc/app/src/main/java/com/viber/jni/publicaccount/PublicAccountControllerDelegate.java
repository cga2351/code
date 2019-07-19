package com.viber.jni.publicaccount;

import com.viber.jni.PublicAccountFieldStatusMap;
import com.viber.jni.PublicAccountInfo;
import com.viber.jni.PublicGroupInfo;
import java.util.Map;

public abstract interface PublicAccountControllerDelegate
{
  public static class CValidateStatus
  {
    public static int INVALID_CHARS = 2;
    public static int RESTRICTED_NAME = 3;
    public static int VALID = 0;
    public static int VALUE_TOO_LONG = 1;
  }

  public static abstract interface PublicAccountChangeInfoReceiver
  {
    public abstract void onChangePublicAccountReply(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }

  public static abstract interface PublicAccountConversationStatusReceiver
  {
    public abstract void onSendConversationStatusReply(String paramString, int paramInt1, int paramInt2);
  }

  public static abstract interface PublicAccountCreateReceiver
  {
    public abstract void onCreatePublicAccountReply(int paramInt1, int paramInt2, long paramLong, String paramString1, Map<String, Integer> paramMap, String paramString2);
  }

  public static abstract interface PublicAccountDelegate extends PublicAccountControllerDelegate.PublicAccountChangeInfoReceiver, PublicAccountControllerDelegate.PublicAccountCreateReceiver, PublicAccountControllerDelegate.PublicAccountJoinReceiver, PublicAccountControllerDelegate.PublicAccountRefreshTokenReceiver
  {
  }

  public static abstract interface PublicAccountFieldsValidatorReceiver
  {
    public abstract void onValidatePublicAccountFieldsReply(int paramInt1, PublicAccountFieldStatusMap paramPublicAccountFieldStatusMap, int paramInt2);
  }

  public static abstract interface PublicAccountInfoReceiver
  {
    public abstract void onPublicAccountInfo(int paramInt1, int paramInt2, PublicAccountInfo paramPublicAccountInfo);
  }

  public static abstract interface PublicAccountJoinReceiver
  {
    public abstract void onJoinPublicGroup(long paramLong, int paramInt1, int paramInt2);
  }

  public static abstract interface PublicAccountRefreshTokenReceiver
  {
    public abstract void onPublicAccountRefreshToken(int paramInt1, int paramInt2, String paramString1, String paramString2);
  }

  public static abstract interface PublicAccountSearchReceiver
  {
    public abstract void onSearchPublicAccounts(int paramInt1, PublicAccountInfo[] paramArrayOfPublicAccountInfo, int paramInt2);

    public abstract void onSearchPublicGroups(int paramInt1, PublicGroupInfo[] paramArrayOfPublicGroupInfo, int paramInt2);
  }

  public static abstract interface PublicAccountSubscribersCountReceiver
  {
    public abstract void onPublicAccountSubscribersCount(int paramInt1, int paramInt2, String paramString, int paramInt3);
  }

  public static abstract interface PublicAccountSubscriptionStatusReceiver
  {
    public abstract void onSubscribeToPublicAccountReply(int paramInt1, int paramInt2);

    public abstract void onUnSubscribeFromPublicAccountReply(int paramInt1, int paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicaccount.PublicAccountControllerDelegate
 * JD-Core Version:    0.6.2
 */
package com.viber.jni.messenger;

import com.viber.jni.CGroupMessageStatus;
import com.viber.jni.EncryptionParams;
import com.viber.jni.LocationInfo;
import com.viber.voip.util.LongSparseSet;

public abstract interface MessengerDelegate
{
  public static final int APP_ID_SENDER_RAKUTEN = 2;
  public static final int APP_ID_SENDER_REGULAR = 0;
  public static final int APP_ID_SENDER_VIBER = 1;
  public static final int FEATURE_PROMOTION_SERVICE_ID = 12829;
  public static final int RAKUTEN_GAMES_SERVICE_ID = 1037;
  public static final int VIBER_SERVICE_ID = 10118;
  public static final LongSparseSet VIBER_SYSTEM_IDS = LongSparseSet.from(new long[] { 1L, 2L, 10118L, 12829L });

  public static abstract interface DeleteMessages
  {
    public abstract void onDeleteMessageReply(long paramLong, int paramInt1, int paramInt2);

    public abstract boolean onDeletedGroupMessage(String paramString, long paramLong1, long paramLong2);

    public abstract boolean onDeletedMessage(String paramString, long paramLong);
  }

  public static abstract interface FormattedReceiver
  {
    public abstract boolean onFormattedMessageReceivedFromGroup(long paramLong1, String paramString1, long paramLong2, String paramString2, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, String paramString3, String paramString4, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  }

  public static abstract interface GroupMessageStatusReply
  {
    public abstract boolean onGetGroupMessageStatusReply(long paramLong, int paramInt1, int paramInt2, CGroupMessageStatus[] paramArrayOfCGroupMessageStatus);
  }

  public static abstract interface MediaReceiver
  {
    public abstract boolean onMediaReceivedFromGroup(long paramLong1, String paramString1, long paramLong2, String paramString2, byte[] paramArrayOfByte, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, EncryptionParams paramEncryptionParams, int paramInt6, int paramInt7);
  }

  public static abstract interface MessagesReceiver extends MessengerDelegate.FormattedReceiver, MessengerDelegate.MediaReceiver, MessengerDelegate.PttReceiver, MessengerDelegate.TextReceiver, MessengerDelegate.VideoReceiver
  {
  }

  public static abstract interface MessagesSender
  {
    public abstract boolean onMessageDelivered(long paramLong1, long paramLong2, int paramInt1, int paramInt2);

    public abstract void onSendMessageReply(int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString);
  }

  public static abstract interface PttReceiver
  {
    public abstract boolean onPttReceivedFromGroup(long paramLong1, String paramString1, long paramLong2, String paramString2, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, String paramString3, int paramInt3, String paramString4, int paramInt4, int paramInt5, String paramString5, int paramInt6, int paramInt7);
  }

  public static abstract interface RecentMessagesEnded
  {
    public abstract void onGetRecentMessagesEnded(int paramInt);
  }

  public static abstract interface SyncConversations
  {
    public abstract boolean onSyncConversation(String paramString, long paramLong, int paramInt1, int paramInt2);

    public abstract boolean onSyncGroup(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  }

  public static abstract interface SyncConversationsReply
  {
    public abstract void onSyncConversationReply(String paramString, long paramLong, int paramInt);

    public abstract void onSyncGroupReply(long paramLong1, long paramLong2, int paramInt);
  }

  public static abstract interface SyncMessages
  {
    public abstract boolean onSyncMessages(long[] paramArrayOfLong1, long[] paramArrayOfLong2);
  }

  public static abstract interface SyncMessagesReply
  {
    public abstract void onSyncMessagesReply(int paramInt1, long[] paramArrayOfLong, int paramInt2);
  }

  public static abstract interface SyncReceiver extends MessengerDelegate.SyncConversations, MessengerDelegate.SyncConversationsReply, MessengerDelegate.SyncMessages, MessengerDelegate.SyncMessagesReply
  {
  }

  public static abstract interface TextReceiver
  {
    public abstract boolean onTextReceivedFromGroup(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, String paramString4, int paramInt3, int paramInt4, String paramString5, int paramInt5, int paramInt6);
  }

  public static abstract interface VideoReceiver
  {
    public abstract boolean onVideoReceivedFromGroup(long paramLong1, String paramString1, long paramLong2, String paramString2, byte[] paramArrayOfByte, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, EncryptionParams paramEncryptionParams, int paramInt6, int paramInt7);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.messenger.MessengerDelegate
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.messages.conversation;

import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.util.av;
import java.util.Arrays;

public class RegularConversationLoaderEntity extends ConversationLoaderEntity
  implements Parcelable
{
  public static final String ALIAS_GROUPING_KEY = "INBOX";
  public static final String BROADCAST_LIST_PARTICIPANTS_COUNT = "(CASE WHEN conversations.conversation_type=4 THEN (SELECT COUNT(*) FROM [participants] WHERE [participants].[conversation_id] = conversations._id AND [participants].[active] = 0) ELSE  0 END) AS broadcast_list_participants_count";
  public static final int BROADCAST_LIST_PARTICIPANTS_COUNT_INDX = 0;
  public static final Parcelable.Creator<RegularConversationLoaderEntity> CREATOR = new Parcelable.Creator()
  {
    public RegularConversationLoaderEntity a(Parcel paramAnonymousParcel)
    {
      return new RegularConversationLoaderEntity(paramAnonymousParcel);
    }

    public RegularConversationLoaderEntity[] a(int paramAnonymousInt)
    {
      return new RegularConversationLoaderEntity[paramAnonymousInt];
    }
  };
  public static final int FAVOURITE_CHAT_INDX = 0;
  public static final String GROUPING_KEY = "IFNULL(conversations.grouping_key,conversations._id) AS INBOX";
  public static final int INBOX_INDX = 0;
  public static final String MAX_CONVERSATION_DATE = "MAX(conversations.date)";
  public static final int MAX_DATE_INDX = 0;
  public static final int MESSAGE_COUNT_ID_INDX = 0;
  public static final int[] PARTICIPANTS_INDXES;
  public static final int PARTICIPANT_INFO_ID_2_INDX = 0;
  public static final int PARTICIPANT_INFO_ID_3_INDX = 0;
  public static final int PARTICIPANT_INFO_ID_4_INDX = 0;
  public static final String[] PROJECTIONS = new String[9 + ConversationLoaderEntity.PROJECTIONS.length];
  public static final int UNREAD_CALLS_COUNT_INDX = 0;
  public static final String UNREAD_CALL_COUNT = "SUM(IFNULL((SELECT SUM ([messages].[unread]) FROM messages WHERE messages.conversation_id = conversations._id AND messages.unread>0 AND messages.extra_mime = 1002 AND messages.deleted=0), 0)) as unread_call_count";
  private int conversationSortPriority;
  private boolean isSystemConversation;
  private int mBroadcastListParticipantsCount;
  private int messageCount;
  private long[] participants = new long[4];
  private int unreadCallsCount;

  static
  {
    PARTICIPANT_INFO_ID_2_INDX = ConversationLoaderEntity.PROJECTIONS.length;
    PARTICIPANT_INFO_ID_3_INDX = 1 + PARTICIPANT_INFO_ID_2_INDX;
    PARTICIPANT_INFO_ID_4_INDX = 1 + PARTICIPANT_INFO_ID_3_INDX;
    MESSAGE_COUNT_ID_INDX = 1 + PARTICIPANT_INFO_ID_4_INDX;
    UNREAD_CALLS_COUNT_INDX = 1 + MESSAGE_COUNT_ID_INDX;
    FAVOURITE_CHAT_INDX = 1 + UNREAD_CALLS_COUNT_INDX;
    BROADCAST_LIST_PARTICIPANTS_COUNT_INDX = 1 + FAVOURITE_CHAT_INDX;
    MAX_DATE_INDX = 1 + BROADCAST_LIST_PARTICIPANTS_COUNT_INDX;
    INBOX_INDX = 1 + MAX_DATE_INDX;
    System.arraycopy(ConversationLoaderEntity.PROJECTIONS, 0, PROJECTIONS, 0, ConversationLoaderEntity.PROJECTIONS.length);
    PROJECTIONS[PARTICIPANT_INFO_ID_2_INDX] = "conversations.participant_id_2";
    PROJECTIONS[PARTICIPANT_INFO_ID_3_INDX] = "conversations.participant_id_3";
    PROJECTIONS[PARTICIPANT_INFO_ID_4_INDX] = "conversations.participant_id_4";
    PROJECTIONS[MESSAGE_COUNT_ID_INDX] = "messages.event_count";
    PROJECTIONS[UNREAD_CALLS_COUNT_INDX] = "SUM(IFNULL((SELECT SUM ([messages].[unread]) FROM messages WHERE messages.conversation_id = conversations._id AND messages.unread>0 AND messages.extra_mime = 1002 AND messages.deleted=0), 0)) as unread_call_count";
    PROJECTIONS[FAVOURITE_CHAT_INDX] = "conversations.favourite_conversation";
    PROJECTIONS[BROADCAST_LIST_PARTICIPANTS_COUNT_INDX] = "(CASE WHEN conversations.conversation_type=4 THEN (SELECT COUNT(*) FROM [participants] WHERE [participants].[conversation_id] = conversations._id AND [participants].[active] = 0) ELSE  0 END) AS broadcast_list_participants_count";
    PROJECTIONS[MAX_DATE_INDX] = "MAX(conversations.date)";
    PROJECTIONS[INBOX_INDX] = "IFNULL(conversations.grouping_key,conversations._id) AS INBOX";
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = 14;
    arrayOfInt[1] = PARTICIPANT_INFO_ID_2_INDX;
    arrayOfInt[2] = PARTICIPANT_INFO_ID_3_INDX;
    arrayOfInt[3] = PARTICIPANT_INFO_ID_4_INDX;
    PARTICIPANTS_INDXES = arrayOfInt;
  }

  public RegularConversationLoaderEntity(Cursor paramCursor)
  {
    super(paramCursor);
    init(this, paramCursor);
  }

  public RegularConversationLoaderEntity(Cursor paramCursor, boolean paramBoolean)
  {
    super(paramCursor, paramBoolean);
    init(this, paramCursor);
  }

  public RegularConversationLoaderEntity(Parcel paramParcel)
  {
    super(paramParcel);
    for (int i = 0; i < this.participants.length; i++)
      this.participants[i] = paramParcel.readLong();
    this.unreadCallsCount = paramParcel.readInt();
    this.messageCount = paramParcel.readInt();
    this.mBroadcastListParticipantsCount = paramParcel.readInt();
    this.conversationSortPriority = paramParcel.readInt();
    this.isSystemConversation = av.c(this.flags, 0);
  }

  public RegularConversationLoaderEntity(RegularConversationLoaderEntity paramRegularConversationLoaderEntity)
  {
    super(paramRegularConversationLoaderEntity);
    this.participants = paramRegularConversationLoaderEntity.participants;
    this.unreadCallsCount = paramRegularConversationLoaderEntity.unreadCallsCount;
    this.messageCount = paramRegularConversationLoaderEntity.messageCount;
    this.isSystemConversation = paramRegularConversationLoaderEntity.isSystemConversation;
    this.conversationSortPriority = paramRegularConversationLoaderEntity.conversationSortPriority;
    this.mBroadcastListParticipantsCount = paramRegularConversationLoaderEntity.mBroadcastListParticipantsCount;
  }

  public RegularConversationLoaderEntity(String paramString, long paramLong, int paramInt1, int paramInt2, Uri paramUri)
  {
    super(paramString, paramLong, paramInt1, paramInt2, paramUri);
  }

  public RegularConversationLoaderEntity(String paramString1, String paramString2, Uri paramUri)
  {
    super(paramString1, paramString2, paramUri);
  }

  private static void init(RegularConversationLoaderEntity paramRegularConversationLoaderEntity, Cursor paramCursor)
  {
    initParticipantsInfoIds(paramRegularConversationLoaderEntity, paramCursor);
    paramRegularConversationLoaderEntity.unreadCallsCount = paramCursor.getInt(UNREAD_CALLS_COUNT_INDX);
    paramRegularConversationLoaderEntity.messageCount = paramCursor.getInt(MESSAGE_COUNT_ID_INDX);
    paramRegularConversationLoaderEntity.isSystemConversation = av.c(paramRegularConversationLoaderEntity.flags, 0);
    paramRegularConversationLoaderEntity.conversationSortPriority = paramCursor.getInt(FAVOURITE_CHAT_INDX);
    paramRegularConversationLoaderEntity.mBroadcastListParticipantsCount = paramCursor.getInt(BROADCAST_LIST_PARTICIPANTS_COUNT_INDX);
  }

  private static void initParticipantsInfoIds(RegularConversationLoaderEntity paramRegularConversationLoaderEntity, Cursor paramCursor)
  {
    int i = 0;
    int j = PARTICIPANTS_INDXES.length;
    while (i < j)
    {
      paramRegularConversationLoaderEntity.participants[i] = paramCursor.getLong(PARTICIPANTS_INDXES[i]);
      i++;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public int getBroadcastListParticipantsCount()
  {
    return this.mBroadcastListParticipantsCount;
  }

  public int getMessageCount()
  {
    return this.messageCount;
  }

  public long[] getParticipantInfos()
  {
    return this.participants;
  }

  public int getUnreadCallsCount()
  {
    return this.unreadCallsCount;
  }

  public int getUnreadEventsCount()
  {
    return getUnreadMessagesCount() + this.unreadCallsCount;
  }

  public boolean hasPublicChat()
  {
    return false;
  }

  public boolean isFavouriteConversation()
  {
    return this.conversationSortPriority == 1;
  }

  public boolean isSnoozedConversation()
  {
    return this.conversationSortPriority == -1;
  }

  public boolean isSystemConversation()
  {
    return this.isSystemConversation;
  }

  public String toString()
  {
    return super.toString() + ", RegularConversationLoaderEntity{, participants=" + Arrays.toString(this.participants) + ", messageCount='" + this.messageCount + '\'' + ", unreadCallsCount=" + this.unreadCallsCount + ", mBroadcastListParticipantsCount=" + this.mBroadcastListParticipantsCount + ", conversationSortPriority" + this.conversationSortPriority + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    for (int i = 0; i < this.participants.length; i++)
      paramParcel.writeLong(this.participants[i]);
    paramParcel.writeInt(this.unreadCallsCount);
    paramParcel.writeInt(this.messageCount);
    paramParcel.writeInt(this.mBroadcastListParticipantsCount);
    paramParcel.writeInt(this.conversationSortPriority);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.RegularConversationLoaderEntity
 * JD-Core Version:    0.6.2
 */
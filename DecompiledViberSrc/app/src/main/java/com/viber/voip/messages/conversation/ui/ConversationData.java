package com.viber.voip.messages.conversation.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.flatbuffers.b.d;
import com.viber.voip.flatbuffers.b.e;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.m;
import com.viber.voip.util.da;

public class ConversationData
  implements Parcelable
{
  public static final Parcelable.Creator<ConversationData> CREATOR = new Parcelable.Creator()
  {
    public ConversationData a(Parcel paramAnonymousParcel)
    {
      return new ConversationData(paramAnonymousParcel);
    }

    public ConversationData[] a(int paramAnonymousInt)
    {
      return new ConversationData[paramAnonymousInt];
    }
  };
  public int broadcastListParticipantsCount;
  public boolean canSendTimeBomb;
  public String contactName;
  public long conversationId = -1L;
  public final int conversationType;
  public long foundMessageHightlitingTime = -1L;
  public long foundMessageOrderKey;
  public long foundMessageToken;
  public final long groupId;
  public String groupName;
  public boolean ignorePin;
  public final boolean isInBusinessInbox;
  public final boolean isInSmsInbox;
  public final boolean isPublicAccount;
  public final String landBackgroud;
  public String lastPinMessageRawMsgInfo;
  public final String memberId;
  public final boolean nonReplyableConversation;
  public final String number;
  public final String portBackgroud;
  public String searchMessageText;
  public final boolean secretConversation;
  public final boolean systemConversation;
  public final int unreadMessagesAndCallsCount;
  public String viberName;

  public ConversationData(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    this(paramLong1, paramLong2, paramString1, paramString2, paramInt, "", paramString3, paramString4, 0, true, false, false, false);
  }

  public ConversationData(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.conversationId = paramLong1;
    this.memberId = paramString1;
    this.number = paramString2;
    this.viberName = paramString3;
    this.contactName = paramString4;
    this.groupName = paramString5;
    this.searchMessageText = "";
    this.foundMessageToken = -1L;
    this.groupId = paramLong2;
    this.systemConversation = false;
    this.isPublicAccount = false;
    this.nonReplyableConversation = false;
    this.conversationType = paramInt1;
    this.unreadMessagesAndCallsCount = paramInt2;
    this.portBackgroud = "";
    this.landBackgroud = "";
    this.ignorePin = paramBoolean1;
    this.canSendTimeBomb = false;
    this.secretConversation = paramBoolean2;
    this.isInBusinessInbox = paramBoolean3;
    this.isInSmsInbox = paramBoolean4;
  }

  protected ConversationData(Parcel paramParcel)
  {
    this.conversationId = paramParcel.readLong();
    this.memberId = paramParcel.readString();
    this.number = paramParcel.readString();
    this.viberName = paramParcel.readString();
    this.contactName = paramParcel.readString();
    this.groupName = paramParcel.readString();
    this.searchMessageText = paramParcel.readString();
    this.foundMessageToken = paramParcel.readLong();
    this.groupId = paramParcel.readLong();
    int j;
    int k;
    label118: int m;
    label167: int n;
    label184: int i1;
    label201: int i2;
    label218: int i3;
    if (paramParcel.readInt() == i)
    {
      j = i;
      this.systemConversation = j;
      if (paramParcel.readInt() != i)
        break label292;
      k = i;
      this.nonReplyableConversation = k;
      this.conversationType = paramParcel.readInt();
      this.unreadMessagesAndCallsCount = paramParcel.readInt();
      this.portBackgroud = paramParcel.readString();
      this.landBackgroud = paramParcel.readString();
      if (paramParcel.readInt() != i)
        break label298;
      m = i;
      this.ignorePin = m;
      if (paramParcel.readInt() != i)
        break label304;
      n = i;
      this.isPublicAccount = n;
      if (paramParcel.readInt() != i)
        break label310;
      i1 = i;
      this.canSendTimeBomb = i1;
      if (paramParcel.readInt() != i)
        break label316;
      i2 = i;
      this.secretConversation = i2;
      this.broadcastListParticipantsCount = paramParcel.readInt();
      this.lastPinMessageRawMsgInfo = paramParcel.readString();
      if (paramParcel.readInt() != i)
        break label322;
      i3 = i;
      label251: this.isInBusinessInbox = i3;
      if (paramParcel.readInt() != i)
        break label328;
    }
    while (true)
    {
      this.isInSmsInbox = i;
      this.foundMessageOrderKey = paramParcel.readLong();
      this.foundMessageHightlitingTime = paramParcel.readLong();
      return;
      j = 0;
      break;
      label292: k = 0;
      break label118;
      label298: m = 0;
      break label167;
      label304: n = 0;
      break label184;
      label310: i1 = 0;
      break label201;
      label316: i2 = 0;
      break label218;
      label322: i3 = 0;
      break label251;
      label328: i = 0;
    }
  }

  public ConversationData(com.viber.voip.messages.adapters.a.a parama)
  {
    this(parama.a(), "", false);
  }

  public ConversationData(ConversationLoaderEntity paramConversationLoaderEntity, String paramString, boolean paramBoolean)
  {
    this.conversationId = paramConversationLoaderEntity.getId();
    this.memberId = paramConversationLoaderEntity.getParticipantMemberId();
    this.number = paramConversationLoaderEntity.getNumber();
    this.secretConversation = paramConversationLoaderEntity.isSecret();
    this.viberName = paramConversationLoaderEntity.getViberName();
    this.contactName = paramConversationLoaderEntity.getContactName();
    this.groupName = paramConversationLoaderEntity.getGroupName();
    this.searchMessageText = paramString;
    this.foundMessageToken = paramConversationLoaderEntity.getMessageToken();
    this.foundMessageOrderKey = paramConversationLoaderEntity.getMessageOrderKey();
    this.groupId = paramConversationLoaderEntity.getGroupId();
    this.systemConversation = paramConversationLoaderEntity.isSystemConversation();
    this.isPublicAccount = paramConversationLoaderEntity.isPublicAccount();
    this.conversationType = paramConversationLoaderEntity.getConversationType();
    this.nonReplyableConversation = paramConversationLoaderEntity.isNonreplyableConversation();
    this.unreadMessagesAndCallsCount = paramConversationLoaderEntity.getUnreadEventsCount();
    this.portBackgroud = paramConversationLoaderEntity.getPortBackgroud();
    this.landBackgroud = paramConversationLoaderEntity.getLandBackgroud();
    this.ignorePin = paramBoolean;
    this.canSendTimeBomb = paramConversationLoaderEntity.canSendTimeBomb();
    this.broadcastListParticipantsCount = paramConversationLoaderEntity.getBroadcastListParticipantsCount();
    this.lastPinMessageRawMsgInfo = paramConversationLoaderEntity.getLastPinMessageRawMsgInfo();
    this.isInBusinessInbox = paramConversationLoaderEntity.isInBusinessInbox();
    this.isInSmsInbox = paramConversationLoaderEntity.isVlnConversation();
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ConversationData localConversationData;
    do
    {
      do
      {
        do
        {
          return true;
          if (paramObject == null)
            return false;
          if (getClass() != paramObject.getClass())
            return false;
          localConversationData = (ConversationData)paramObject;
        }
        while ((this.conversationId > 0L) && (localConversationData.conversationId > 0L) && (this.conversationId == localConversationData.conversationId));
        if (this.conversationType != localConversationData.conversationType)
          return false;
        if (this.groupId != localConversationData.groupId)
          return false;
        if (this.memberId != null)
          break;
      }
      while (localConversationData.memberId == null);
      return false;
      if (!this.memberId.equals(localConversationData.memberId))
        return false;
    }
    while (this.secretConversation == localConversationData.secretConversation);
    return false;
  }

  public int getConversationType()
  {
    return this.conversationType;
  }

  public Pin getLastMessagePin()
  {
    if (da.a(this.lastPinMessageRawMsgInfo))
      return null;
    return ((MsgInfo)e.a().a().a(this.lastPinMessageRawMsgInfo)).getPin();
  }

  public int hashCode()
  {
    return 0;
  }

  public boolean isBroadcastListType()
  {
    return m.c(this.conversationType);
  }

  public boolean isGroupBehavior()
  {
    return m.d(this.conversationType);
  }

  public boolean isPublicGroupType()
  {
    return m.a(this.conversationType);
  }

  public String toString()
  {
    return "ConversationData{contactName='" + this.contactName + '\'' + ", viberName='" + this.viberName + '\'' + ", groupName='" + this.groupName + '\'' + ", memberId='" + this.memberId + '\'' + ", number='" + this.number + '\'' + ", conversationId=" + this.conversationId + ", groupId=" + this.groupId + ", searchMessageText=" + this.searchMessageText + ", foundMessageToken=" + this.foundMessageToken + ", systemConversation=" + this.systemConversation + ", isOneToOneWithPublicAccount=" + this.isPublicAccount + ", nonReplyableConversation=" + this.nonReplyableConversation + ", conversationType=" + this.conversationType + ", unreadMessagesAndCallsCount=" + this.unreadMessagesAndCallsCount + ", portBackgroud='" + this.portBackgroud + '\'' + ", landBackgroud='" + this.landBackgroud + '\'' + ", ignorePin=" + this.ignorePin + ", canSendTimeBomb=" + this.canSendTimeBomb + ", secretConversation=" + this.secretConversation + ", broadcastListParticipantsCount=" + this.broadcastListParticipantsCount + ", lastPinMessageRawMsgInfo=" + this.lastPinMessageRawMsgInfo + ", isInBusinessInbox=" + this.isInBusinessInbox + ", isInSmsInbox=" + this.isInSmsInbox + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeLong(this.conversationId);
    paramParcel.writeString(this.memberId);
    paramParcel.writeString(this.number);
    paramParcel.writeString(this.viberName);
    paramParcel.writeString(this.contactName);
    paramParcel.writeString(this.groupName);
    paramParcel.writeString(this.searchMessageText);
    paramParcel.writeLong(this.foundMessageToken);
    paramParcel.writeLong(this.groupId);
    int j;
    int k;
    label100: int m;
    label148: int n;
    label164: int i1;
    label180: int i2;
    label196: int i3;
    if (this.systemConversation)
    {
      j = i;
      paramParcel.writeInt(j);
      if (!this.nonReplyableConversation)
        break label269;
      k = i;
      paramParcel.writeInt(k);
      paramParcel.writeInt(this.conversationType);
      paramParcel.writeInt(this.unreadMessagesAndCallsCount);
      paramParcel.writeString(this.portBackgroud);
      paramParcel.writeString(this.landBackgroud);
      if (!this.ignorePin)
        break label275;
      m = i;
      paramParcel.writeInt(m);
      if (!this.isPublicAccount)
        break label281;
      n = i;
      paramParcel.writeInt(n);
      if (!this.canSendTimeBomb)
        break label287;
      i1 = i;
      paramParcel.writeInt(i1);
      if (!this.secretConversation)
        break label293;
      i2 = i;
      paramParcel.writeInt(i2);
      paramParcel.writeInt(this.broadcastListParticipantsCount);
      paramParcel.writeString(this.lastPinMessageRawMsgInfo);
      if (!this.isInBusinessInbox)
        break label299;
      i3 = i;
      label228: paramParcel.writeInt(i3);
      if (!this.isInSmsInbox)
        break label305;
    }
    while (true)
    {
      paramParcel.writeInt(i);
      paramParcel.writeLong(this.foundMessageOrderKey);
      paramParcel.writeLong(this.foundMessageHightlitingTime);
      return;
      j = 0;
      break;
      label269: k = 0;
      break label100;
      label275: m = 0;
      break label148;
      label281: n = 0;
      break label164;
      label287: i1 = 0;
      break label180;
      label293: i2 = 0;
      break label196;
      label299: i3 = 0;
      break label228;
      label305: i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.ConversationData
 * JD-Core Version:    0.6.2
 */
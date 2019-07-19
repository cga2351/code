package com.viber.voip.messages.conversation.publicaccount;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.messages.adapters.a.a;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.publicaccount.entity.PublicAccount;

public class PublicGroupConversationData extends ConversationData
  implements Parcelable
{
  public static final Parcelable.Creator<PublicGroupConversationData> CREATOR = new Parcelable.Creator()
  {
    public PublicGroupConversationData a(Parcel paramAnonymousParcel)
    {
      return new PublicGroupConversationData(paramAnonymousParcel);
    }

    public PublicGroupConversationData[] a(int paramAnonymousInt)
    {
      return new PublicGroupConversationData[paramAnonymousInt];
    }
  };
  public String invitationNumber = "";
  public long invitationToken = 0L;
  public String publicAccountId;
  public PublicAccount publicGroupInfo;

  public PublicGroupConversationData(long paramLong1, long paramLong2, String paramString1, Uri paramUri, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    super(paramLong1, paramLong2, "", "", 3, "", "", paramString1, paramInt3, true, false, false, false);
    PublicAccount localPublicAccount = new PublicAccount();
    localPublicAccount.setGroupID(paramLong2);
    localPublicAccount.setName(paramString1);
    localPublicAccount.setRevision(paramInt1);
    localPublicAccount.setWatchersCount(paramInt2);
    localPublicAccount.setGroupRole(3);
    localPublicAccount.setIcon(paramUri);
    localPublicAccount.setGroupUri(paramString2);
    this.publicGroupInfo = localPublicAccount;
    this.lastPinMessageRawMsgInfo = paramString3;
  }

  public PublicGroupConversationData(long paramLong1, long paramLong2, String paramString1, Uri paramUri, String paramString2, int paramInt1, int paramInt2, long paramLong3, String paramString3, String paramString4)
  {
    this(paramLong1, paramLong2, paramString1, paramUri, paramString2, paramInt1, paramInt2, 0, null);
    this.invitationToken = paramLong3;
    this.invitationNumber = paramString3;
    this.publicAccountId = paramString4;
  }

  public PublicGroupConversationData(long paramLong, PublicAccount paramPublicAccount)
  {
    super(paramLong, paramPublicAccount.getGroupID(), "", "", 3, "", paramPublicAccount.getName());
    this.publicGroupInfo = paramPublicAccount;
  }

  public PublicGroupConversationData(long paramLong, String paramString)
  {
    this(-1L, paramLong, "", null, paramString, 0, 0, 0, null);
  }

  protected PublicGroupConversationData(Parcel paramParcel)
  {
    super(paramParcel);
    this.publicGroupInfo = ((PublicAccount)paramParcel.readParcelable(PublicAccount.class.getClassLoader()));
    this.invitationToken = paramParcel.readLong();
    this.invitationNumber = paramParcel.readString();
    this.publicAccountId = paramParcel.readString();
  }

  public PublicGroupConversationData(a parama)
  {
    super(parama);
  }

  public PublicGroupConversationData(PublicAccount paramPublicAccount)
  {
    super(-1L, paramPublicAccount.getGroupID(), "", "", 3, "", paramPublicAccount.getName());
    this.publicGroupInfo = paramPublicAccount;
  }

  public PublicGroupConversationData(PublicAccount paramPublicAccount, long paramLong, String paramString)
  {
    super(-1L, paramPublicAccount.getGroupID(), "", "", 3, "", paramPublicAccount.getName());
    this.publicGroupInfo = paramPublicAccount;
    this.invitationToken = paramLong;
    this.invitationNumber = paramString;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.publicGroupInfo, paramInt);
    paramParcel.writeLong(this.invitationToken);
    paramParcel.writeString(this.invitationNumber);
    paramParcel.writeString(this.publicAccountId);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationData
 * JD-Core Version:    0.6.2
 */
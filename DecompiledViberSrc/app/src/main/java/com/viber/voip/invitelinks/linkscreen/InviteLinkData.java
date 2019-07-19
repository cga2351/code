package com.viber.voip.invitelinks.linkscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class InviteLinkData
  implements Parcelable
{
  public static final Parcelable.Creator<InviteLinkData> CREATOR = new Parcelable.Creator()
  {
    public InviteLinkData a(Parcel paramAnonymousParcel)
    {
      return new InviteLinkData(paramAnonymousParcel);
    }

    public InviteLinkData[] a(int paramAnonymousInt)
    {
      return new InviteLinkData[paramAnonymousInt];
    }
  };
  private static final String KEY = InviteLinkData.class.getName();
  public final long conversationId;
  public final int conversationType;
  public final long groupId;
  public final boolean sendCommunityInvite;
  public final String shareUrl;

  public InviteLinkData(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    this.groupId = paramLong1;
    this.conversationId = paramLong2;
    this.shareUrl = null;
    this.conversationType = paramInt;
    this.sendCommunityInvite = paramBoolean;
  }

  protected InviteLinkData(Parcel paramParcel)
  {
    this.groupId = paramParcel.readLong();
    this.conversationId = paramParcel.readLong();
    this.shareUrl = paramParcel.readString();
    this.conversationType = paramParcel.readInt();
    if (paramParcel.readByte() == i);
    while (true)
    {
      this.sendCommunityInvite = i;
      return;
      i = 0;
    }
  }

  InviteLinkData(InviteLinkData paramInviteLinkData, String paramString)
  {
    this.groupId = paramInviteLinkData.groupId;
    this.conversationId = paramInviteLinkData.conversationId;
    this.shareUrl = paramString;
    this.conversationType = paramInviteLinkData.conversationType;
    this.sendCommunityInvite = paramInviteLinkData.sendCommunityInvite;
  }

  public static InviteLinkData restoreFrom(Bundle paramBundle)
  {
    if (paramBundle != null)
      return (InviteLinkData)paramBundle.getParcelable(KEY);
    return null;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "InviteLinkData{groupId=" + this.groupId + ", conversationId=" + this.conversationId + ", conversationType=" + this.conversationType + ", sendCommunityInvite=" + this.sendCommunityInvite + ", shareUrl='" + this.shareUrl + '\'' + '}';
  }

  public void writeTo(Intent paramIntent)
  {
    paramIntent.putExtra(KEY, this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.groupId);
    paramParcel.writeLong(this.conversationId);
    paramParcel.writeString(this.shareUrl);
    paramParcel.writeInt(this.conversationType);
    if (this.sendCommunityInvite);
    for (byte b = 1; ; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.linkscreen.InviteLinkData
 * JD-Core Version:    0.6.2
 */
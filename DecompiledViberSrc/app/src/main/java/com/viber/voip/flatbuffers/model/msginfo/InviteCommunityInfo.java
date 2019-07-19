package com.viber.voip.flatbuffers.model.msginfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;

public class InviteCommunityInfo
  implements Parcelable
{
  public static final Parcelable.Creator<InviteCommunityInfo> CREATOR = new Parcelable.Creator()
  {
    public InviteCommunityInfo a(Parcel paramAnonymousParcel)
    {
      return new InviteCommunityInfo(paramAnonymousParcel);
    }

    public InviteCommunityInfo[] a(int paramAnonymousInt)
    {
      return new InviteCommunityInfo[paramAnonymousInt];
    }
  };

  @c(a="communityDescription")
  private String mCommunityDescription;

  @c(a="communityName")
  private String mCommunityName;

  @c(a="groupID")
  private long mGroupId;

  @c(a="hasPersonalLink")
  private boolean mHasPersonalLink;

  @c(a="iconID")
  private String mIconId;

  @c(a="inviteLink")
  private String mInviteLink;

  @c(a="participantsCount")
  private int mParticipantsCount;

  public InviteCommunityInfo()
  {
  }

  InviteCommunityInfo(Parcel paramParcel)
  {
    if (paramParcel.readByte() > 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mHasPersonalLink = bool;
      this.mCommunityName = paramParcel.readString();
      this.mCommunityDescription = paramParcel.readString();
      this.mIconId = paramParcel.readString();
      this.mInviteLink = paramParcel.readString();
      this.mGroupId = paramParcel.readLong();
      this.mParticipantsCount = paramParcel.readInt();
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public String getCommunityDescription()
  {
    return this.mCommunityDescription;
  }

  public String getCommunityName()
  {
    return this.mCommunityName;
  }

  public long getGroupId()
  {
    return this.mGroupId;
  }

  public String getIconId()
  {
    return this.mIconId;
  }

  public String getInviteLink()
  {
    return this.mInviteLink;
  }

  public int getParticipantsCount()
  {
    return this.mParticipantsCount;
  }

  public boolean hasPersonalLink()
  {
    return this.mHasPersonalLink;
  }

  public void setCommunityDescription(String paramString)
  {
    this.mCommunityDescription = paramString;
  }

  public void setCommunityName(String paramString)
  {
    this.mCommunityName = paramString;
  }

  public void setGroupId(long paramLong)
  {
    this.mGroupId = paramLong;
  }

  public void setHasPersonalLink(boolean paramBoolean)
  {
    this.mHasPersonalLink = paramBoolean;
  }

  public void setIconId(String paramString)
  {
    this.mIconId = paramString;
  }

  public void setInviteLink(String paramString)
  {
    this.mInviteLink = paramString;
  }

  public void setParticipantsCount(int paramInt)
  {
    this.mParticipantsCount = paramInt;
  }

  public String toString()
  {
    return "InviteCommunityInfo{mHasPersonalLink=" + this.mHasPersonalLink + ", mCommunityName='" + this.mCommunityName + '\'' + ", mCommunityDescription='" + this.mCommunityDescription + '\'' + ", mIconId='" + this.mIconId + '\'' + ", mInviteLink='" + this.mInviteLink + '\'' + ", mGroupId=" + this.mGroupId + ", mParticipantsCount=" + this.mParticipantsCount + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.mHasPersonalLink);
    for (byte b = 1; ; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeString(this.mCommunityName);
      paramParcel.writeString(this.mCommunityDescription);
      paramParcel.writeString(this.mIconId);
      paramParcel.writeString(this.mInviteLink);
      paramParcel.writeLong(this.mGroupId);
      paramParcel.writeInt(this.mParticipantsCount);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.InviteCommunityInfo
 * JD-Core Version:    0.6.2
 */
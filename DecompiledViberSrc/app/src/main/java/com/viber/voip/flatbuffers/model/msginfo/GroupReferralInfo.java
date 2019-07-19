package com.viber.voip.flatbuffers.model.msginfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;

public class GroupReferralInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GroupReferralInfo> CREATOR = new Parcelable.Creator()
  {
    public GroupReferralInfo a(Parcel paramAnonymousParcel)
    {
      return new GroupReferralInfo(paramAnonymousParcel);
    }

    public GroupReferralInfo[] a(int paramAnonymousInt)
    {
      return new GroupReferralInfo[paramAnonymousInt];
    }
  };

  @c(a="groupID")
  private long mGroupId;

  @c(a="groupName")
  private String mGroupName;

  @c(a="inviteLink")
  private String mInviteLink;

  @c(a="messageID")
  private int mMessageId;

  @c(a="messageToken")
  private long mMessageToken;

  public GroupReferralInfo()
  {
  }

  protected GroupReferralInfo(Parcel paramParcel)
  {
    this.mGroupId = paramParcel.readLong();
    this.mMessageId = paramParcel.readInt();
    this.mMessageToken = paramParcel.readLong();
    this.mGroupName = paramParcel.readString();
    this.mInviteLink = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public long getGroupId()
  {
    return this.mGroupId;
  }

  public String getGroupName()
  {
    return this.mGroupName;
  }

  public String getInviteLink()
  {
    return this.mInviteLink;
  }

  public int getMessageId()
  {
    return this.mMessageId;
  }

  public long getMessageToken()
  {
    return this.mMessageToken;
  }

  public void setGroupId(long paramLong)
  {
    this.mGroupId = paramLong;
  }

  public void setGroupName(String paramString)
  {
    this.mGroupName = paramString;
  }

  public void setInviteLink(String paramString)
  {
    this.mInviteLink = paramString;
  }

  public void setMessageId(int paramInt)
  {
    this.mMessageId = paramInt;
  }

  public void setMessageToken(long paramLong)
  {
    this.mMessageToken = paramLong;
  }

  public String toString()
  {
    return "GroupReferralInfo{mGroupId=" + this.mGroupId + ", mMessageId=" + this.mMessageId + ", mMessageToken=" + this.mMessageToken + ", mGroupName='" + this.mGroupName + '\'' + ", mInviteLink='" + this.mInviteLink + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mGroupId);
    paramParcel.writeInt(this.mMessageId);
    paramParcel.writeLong(this.mMessageToken);
    paramParcel.writeString(this.mGroupName);
    paramParcel.writeString(this.mInviteLink);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.GroupReferralInfo
 * JD-Core Version:    0.6.2
 */
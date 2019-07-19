package com.viber.voip.messages.forward;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GroupReferralForwardInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GroupReferralForwardInfo> CREATOR = new Parcelable.Creator()
  {
    public GroupReferralForwardInfo a(Parcel paramAnonymousParcel)
    {
      return new GroupReferralForwardInfo(paramAnonymousParcel);
    }

    public GroupReferralForwardInfo[] a(int paramAnonymousInt)
    {
      return new GroupReferralForwardInfo[paramAnonymousInt];
    }
  };
  private long mGroupId;
  private String mGroupName;
  private int mGroupRole;
  private String mInviteLink;

  public GroupReferralForwardInfo(long paramLong, int paramInt, String paramString)
  {
    this.mGroupId = paramLong;
    this.mGroupRole = paramInt;
    this.mGroupName = paramString;
  }

  protected GroupReferralForwardInfo(Parcel paramParcel)
  {
    this.mGroupId = paramParcel.readLong();
    this.mGroupRole = paramParcel.readInt();
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

  public int getGroupRole()
  {
    return this.mGroupRole;
  }

  public String getInviteLink()
  {
    return this.mInviteLink;
  }

  public void setGroupId(long paramLong)
  {
    this.mGroupId = paramLong;
  }

  public void setGroupName(String paramString)
  {
    this.mGroupName = paramString;
  }

  public void setGroupRole(int paramInt)
  {
    this.mGroupRole = paramInt;
  }

  public void setInviteLink(String paramString)
  {
    this.mInviteLink = paramString;
  }

  public String toString()
  {
    return "GroupReferralForwardInfo{mGroupId=" + this.mGroupId + ", mGroupRole=" + this.mGroupRole + ", mGroupName='" + this.mGroupName + '\'' + ", mInviteLink='" + this.mInviteLink + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mGroupId);
    paramParcel.writeInt(this.mGroupRole);
    paramParcel.writeString(this.mGroupName);
    paramParcel.writeString(this.mInviteLink);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.forward.GroupReferralForwardInfo
 * JD-Core Version:    0.6.2
 */
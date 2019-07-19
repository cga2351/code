package com.viber.voip.invitelinks;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.flatbuffers.model.msginfo.GroupReferralInfo;

public class CommunityFollowerData
  implements Parcelable
{
  public static final Parcelable.Creator<CommunityFollowerData> CREATOR = new Parcelable.Creator()
  {
    public CommunityFollowerData a(Parcel paramAnonymousParcel)
    {
      return new CommunityFollowerData(paramAnonymousParcel);
    }

    public CommunityFollowerData[] a(int paramAnonymousInt)
    {
      return new CommunityFollowerData[paramAnonymousInt];
    }
  };
  public final int cdrViewSource;
  public final int groupFlags;
  public final long groupId;
  public final String groupName;
  public final GroupReferralInfo groupReferralInfo;
  public final Uri iconUri;
  public final long inviteToken;
  public final int joinSource;
  public final String tagLine;
  public final String userName;

  public CommunityFollowerData(long paramLong1, String paramString1, Uri paramUri, String paramString2, long paramLong2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramLong1, paramString1, paramUri, paramString2, paramLong2, paramString3, paramInt1, null, paramInt2, paramInt3);
  }

  public CommunityFollowerData(long paramLong1, String paramString1, Uri paramUri, String paramString2, long paramLong2, String paramString3, int paramInt1, GroupReferralInfo paramGroupReferralInfo, int paramInt2, int paramInt3)
  {
    this.groupId = paramLong1;
    this.groupName = paramString1;
    this.iconUri = paramUri;
    this.tagLine = paramString2;
    this.inviteToken = paramLong2;
    this.userName = paramString3;
    this.groupReferralInfo = paramGroupReferralInfo;
    this.groupFlags = paramInt1;
    this.joinSource = paramInt2;
    this.cdrViewSource = paramInt3;
  }

  protected CommunityFollowerData(Parcel paramParcel)
  {
    this.groupId = paramParcel.readLong();
    this.groupName = paramParcel.readString();
    this.iconUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.tagLine = paramParcel.readString();
    this.inviteToken = paramParcel.readLong();
    this.userName = paramParcel.readString();
    this.groupReferralInfo = ((GroupReferralInfo)paramParcel.readParcelable(GroupReferralInfo.class.getClassLoader()));
    this.groupFlags = paramParcel.readInt();
    this.joinSource = paramParcel.readInt();
    this.cdrViewSource = paramParcel.readInt();
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "CommunityFollowerData{groupId=" + this.groupId + ", groupName='" + this.groupName + '\'' + ", iconUri=" + this.iconUri + ", tagLine='" + this.tagLine + '\'' + ", inviteToken=" + this.inviteToken + ", userName='" + this.userName + '\'' + ", groupReferralInfo=" + this.groupReferralInfo + ", groupFlags='" + this.groupFlags + '\'' + ", joinSource=" + this.joinSource + ", cdrViewSource=" + this.cdrViewSource + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.groupId);
    paramParcel.writeString(this.groupName);
    paramParcel.writeParcelable(this.iconUri, paramInt);
    paramParcel.writeString(this.tagLine);
    paramParcel.writeLong(this.inviteToken);
    paramParcel.writeString(this.userName);
    paramParcel.writeParcelable(this.groupReferralInfo, paramInt);
    paramParcel.writeInt(this.groupFlags);
    paramParcel.writeInt(this.joinSource);
    paramParcel.writeInt(this.cdrViewSource);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.CommunityFollowerData
 * JD-Core Version:    0.6.2
 */
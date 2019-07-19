package com.viber.jni;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ChatUserInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ChatUserInfo> CREATOR = new Parcelable.Creator()
  {
    public ChatUserInfo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ChatUserInfo(paramAnonymousParcel);
    }

    public ChatUserInfo[] newArray(int paramAnonymousInt)
    {
      return new ChatUserInfo[paramAnonymousInt];
    }
  };
  private String mClientName;
  private String mDownloadID;
  private String mEncryptedPhoneNumber;
  private int mGroupRole;
  private String mMID;
  private String mPhoneNumber;
  private String mVID;

  public ChatUserInfo(Bundle paramBundle)
  {
    this.mMID = paramBundle.getString("MID");
    this.mVID = paramBundle.getString("VID");
    this.mPhoneNumber = paramBundle.getString("PhoneNumber");
    this.mClientName = paramBundle.getString("ClientName");
    this.mDownloadID = paramBundle.getString("DownloadID");
    this.mEncryptedPhoneNumber = paramBundle.getString("EncryptedPhoneNumber");
    this.mGroupRole = paramBundle.getInt("GroupRole");
  }

  public ChatUserInfo(Parcel paramParcel)
  {
    this.mMID = paramParcel.readString();
    this.mVID = paramParcel.readString();
    this.mPhoneNumber = paramParcel.readString();
    this.mClientName = paramParcel.readString();
    this.mDownloadID = paramParcel.readString();
    this.mEncryptedPhoneNumber = paramParcel.readString();
    this.mGroupRole = paramParcel.readInt();
  }

  public ChatUserInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    this.mMID = paramString1;
    this.mVID = paramString2;
    this.mPhoneNumber = paramString3;
    this.mClientName = paramString4;
    this.mDownloadID = paramString5;
    this.mEncryptedPhoneNumber = paramString6;
    this.mGroupRole = paramInt;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getClientName()
  {
    return this.mClientName;
  }

  public String getDownloadID()
  {
    return this.mDownloadID;
  }

  public String getEncryptedPhoneNumber()
  {
    return this.mEncryptedPhoneNumber;
  }

  public int getGroupRole()
  {
    return this.mGroupRole;
  }

  public String getMID()
  {
    return this.mMID;
  }

  public String getPhoneNumber()
  {
    return this.mPhoneNumber;
  }

  public String getVID()
  {
    return this.mVID;
  }

  public String toString()
  {
    return "ChatUserInfo{mMID='" + this.mMID + '\'' + ", mVID='" + this.mVID + '\'' + ", mPhoneNumber='" + this.mPhoneNumber + '\'' + ", mClientName='" + this.mClientName + '\'' + ", mDownloadID='" + this.mDownloadID + '\'' + ", mEncryptedPhoneNumber='" + this.mEncryptedPhoneNumber + '\'' + ", mGroupRole=" + this.mGroupRole + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mMID);
    paramParcel.writeString(this.mVID);
    paramParcel.writeString(this.mPhoneNumber);
    paramParcel.writeString(this.mClientName);
    paramParcel.writeString(this.mDownloadID);
    paramParcel.writeString(this.mEncryptedPhoneNumber);
    paramParcel.writeInt(this.mGroupRole);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.ChatUserInfo
 * JD-Core Version:    0.6.2
 */
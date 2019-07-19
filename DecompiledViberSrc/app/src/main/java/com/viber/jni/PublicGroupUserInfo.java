package com.viber.jni;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PublicGroupUserInfo extends GroupUserInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
  {
    public PublicGroupUserInfo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new PublicGroupUserInfo(paramAnonymousParcel);
    }

    public PublicGroupUserInfo[] newArray(int paramAnonymousInt)
    {
      return new PublicGroupUserInfo[paramAnonymousInt];
    }
  };
  public final String encryptedPhoneNumber;
  public final int groupRole;

  public PublicGroupUserInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.groupRole = paramParcel.readInt();
    this.encryptedPhoneNumber = paramParcel.readString();
  }

  public PublicGroupUserInfo(ChatUserInfo paramChatUserInfo)
  {
    super(paramChatUserInfo.getMID(), paramChatUserInfo.getClientName(), paramChatUserInfo.getDownloadID(), paramChatUserInfo.getVID(), paramChatUserInfo.getPhoneNumber());
    this.groupRole = paramChatUserInfo.getGroupRole();
    this.encryptedPhoneNumber = paramChatUserInfo.getEncryptedPhoneNumber();
  }

  public PublicGroupUserInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    super(paramString1, paramString3, paramString4);
    this.groupRole = paramInt;
    this.encryptedPhoneNumber = paramString2;
  }

  public static PublicGroupUserInfo[] convert(ChatUserInfo[] paramArrayOfChatUserInfo)
  {
    int i = 0;
    if (paramArrayOfChatUserInfo == null)
      return new PublicGroupUserInfo[0];
    PublicGroupUserInfo[] arrayOfPublicGroupUserInfo = new PublicGroupUserInfo[paramArrayOfChatUserInfo.length];
    while (i < paramArrayOfChatUserInfo.length)
    {
      arrayOfPublicGroupUserInfo[i] = new PublicGroupUserInfo(paramArrayOfChatUserInfo[i]);
      i++;
    }
    return arrayOfPublicGroupUserInfo;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool3;
    if (this == paramObject)
      bool3 = bool1;
    PublicGroupUserInfo localPublicGroupUserInfo;
    int i;
    int j;
    do
    {
      boolean bool4;
      do
      {
        boolean bool2;
        do
        {
          return bool3;
          bool2 = paramObject instanceof PublicGroupUserInfo;
          bool3 = false;
        }
        while (!bool2);
        bool4 = super.equals(paramObject);
        bool3 = false;
      }
      while (!bool4);
      localPublicGroupUserInfo = (PublicGroupUserInfo)paramObject;
      i = this.groupRole;
      j = localPublicGroupUserInfo.groupRole;
      bool3 = false;
    }
    while (i != j);
    if (this.encryptedPhoneNumber != null)
      bool1 = this.encryptedPhoneNumber.equals(localPublicGroupUserInfo.encryptedPhoneNumber);
    while (true)
    {
      return bool1;
      if (localPublicGroupUserInfo.encryptedPhoneNumber != null)
        bool1 = false;
    }
  }

  public String toString()
  {
    return "PublicGroupUserInfo memberId='" + this.memberId + '\'' + ", encryptedPhoneNumber='" + this.encryptedPhoneNumber + '\'' + ", clientName='" + this.clientName + '\'' + ", downloadId='" + this.downloadID + '\'' + ", groupRole='" + this.groupRole + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.groupRole);
    paramParcel.writeString(this.encryptedPhoneNumber);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.PublicGroupUserInfo
 * JD-Core Version:    0.6.2
 */
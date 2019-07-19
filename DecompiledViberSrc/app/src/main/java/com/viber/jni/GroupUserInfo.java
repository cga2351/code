package com.viber.jni;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class GroupUserInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GroupUserInfo> CREATOR = new Parcelable.Creator()
  {
    public GroupUserInfo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new GroupUserInfo(paramAnonymousParcel);
    }

    public GroupUserInfo[] newArray(int paramAnonymousInt)
    {
      return new GroupUserInfo[paramAnonymousInt];
    }
  };
  private static final Logger L = ViberEnv.getLogger();
  public final String clientName;
  public final String downloadID;
  public final String memberId;
  private final String phoneNumber;
  public final String viberId;

  public GroupUserInfo(Parcel paramParcel)
  {
    this.memberId = paramParcel.readString();
    this.clientName = paramParcel.readString();
    this.downloadID = paramParcel.readString();
    this.viberId = paramParcel.readString();
    this.phoneNumber = paramParcel.readString();
  }

  public GroupUserInfo(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, null, null);
  }

  public GroupUserInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    L.c("GroupUserInfo: memberId=?, clientName=?, downloadID=?", new Object[] { paramString1, paramString2, paramString3 });
    this.memberId = paramString1;
    this.clientName = paramString2;
    this.downloadID = paramString3;
    this.viberId = paramString4;
    this.phoneNumber = paramString5;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this == paramObject)
      bool2 = bool1;
    GroupUserInfo localGroupUserInfo;
    label100: boolean bool3;
    label128: 
    do
    {
      boolean bool4;
      do
      {
        boolean bool5;
        do
        {
          boolean bool6;
          do
          {
            Class localClass1;
            Class localClass2;
            do
            {
              do
              {
                return bool2;
                bool2 = false;
              }
              while (paramObject == null);
              localClass1 = getClass();
              localClass2 = paramObject.getClass();
              bool2 = false;
            }
            while (localClass1 != localClass2);
            localGroupUserInfo = (GroupUserInfo)paramObject;
            if (this.memberId == null)
              break;
            bool6 = this.memberId.equals(localGroupUserInfo.memberId);
            bool2 = false;
          }
          while (!bool6);
          if (this.clientName == null)
            break label188;
          bool5 = this.clientName.equals(localGroupUserInfo.clientName);
          bool2 = false;
        }
        while (!bool5);
        if (this.downloadID == null)
          break label198;
        bool4 = this.downloadID.equals(localGroupUserInfo.downloadID);
        bool2 = false;
      }
      while (!bool4);
      if (this.viberId == null)
        break label208;
      bool3 = this.viberId.equals(localGroupUserInfo.viberId);
      bool2 = false;
    }
    while (!bool3);
    label156: if (this.phoneNumber != null)
      bool1 = this.phoneNumber.equals(localGroupUserInfo.phoneNumber);
    while (true)
    {
      return bool1;
      if (localGroupUserInfo.memberId == null)
        break;
      return false;
      label188: if (localGroupUserInfo.clientName == null)
        break label100;
      return false;
      label198: if (localGroupUserInfo.downloadID == null)
        break label128;
      return false;
      label208: if (localGroupUserInfo.viberId == null)
        break label156;
      return false;
      if (localGroupUserInfo.phoneNumber != null)
        bool1 = false;
    }
  }

  public String toString()
  {
    return "GroupUserInfo{memberId='" + this.memberId + '\'' + ", clientName='" + this.clientName + '\'' + ", downloadID='" + this.downloadID + '\'' + ", viberId='" + this.viberId + '\'' + ", phoneNumber='" + this.phoneNumber + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.memberId);
    paramParcel.writeString(this.clientName);
    paramParcel.writeString(this.downloadID);
    paramParcel.writeString(this.viberId);
    paramParcel.writeString(this.phoneNumber);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.GroupUserInfo
 * JD-Core Version:    0.6.2
 */
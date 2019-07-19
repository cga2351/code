package com.viber.jni.memberid;

import android.os.Bundle;

public class CRegisteredContactInfo
{
  private final String downloadID;
  private int flags;
  private final String memberId;
  private final String phoneNumber;
  private final String viberId;

  private CRegisteredContactInfo(Bundle paramBundle)
  {
    this.phoneNumber = paramBundle.getString("PhoneNumber");
    this.downloadID = paramBundle.getString("DownloadID");
    this.memberId = paramBundle.getString("MemberId");
    this.viberId = paramBundle.getString("ViberId");
    this.flags = paramBundle.getInt("Flags");
  }

  public CRegisteredContactInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.phoneNumber = paramString1;
    this.downloadID = paramString2;
    this.memberId = paramString3;
    this.viberId = paramString4;
    this.flags = paramInt;
  }

  public String getDownloadID()
  {
    return this.downloadID;
  }

  public int getFlags()
  {
    return this.flags;
  }

  public String getMemberId()
  {
    return this.memberId;
  }

  public String getPhoneNumber()
  {
    return this.phoneNumber;
  }

  public String getViberId()
  {
    return this.viberId;
  }

  public String toString()
  {
    return "CRegisteredContactInfo{phoneNumber='" + this.phoneNumber + '\'' + ", downloadID='" + this.downloadID + '\'' + ", memberId='" + this.memberId + '\'' + ", viberId='" + this.viberId + '\'' + ", flags=" + this.flags + '}';
  }

  public static class CRegisteredContactInfoFlags
  {
    public static final int PHONE_NUMBER_CHANGED = 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.memberid.CRegisteredContactInfo
 * JD-Core Version:    0.6.2
 */
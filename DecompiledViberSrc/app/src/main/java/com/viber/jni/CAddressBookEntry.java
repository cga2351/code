package com.viber.jni;

import android.os.Bundle;

public class CAddressBookEntry
{
  private String clientName;
  private String clientSortName;
  private String downloadID;
  private int flags;
  private String memberId;
  private String phoneNumber;
  private String viberId;

  protected CAddressBookEntry(Bundle paramBundle)
  {
    this.clientName = paramBundle.getString("ClientName");
    this.phoneNumber = paramBundle.getString("PhoneNumber");
    this.clientSortName = paramBundle.getString("ClientSortName");
    this.downloadID = paramBundle.getString("DownloadID");
    this.memberId = paramBundle.getString("MemberId");
    this.viberId = paramBundle.getString("ViberId");
    this.flags = paramBundle.getInt("Flags");
  }

  public CAddressBookEntry(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    this.memberId = paramString1;
    this.viberId = paramString2;
    this.phoneNumber = paramString3;
    this.clientSortName = paramString5;
    this.clientName = paramString4;
    this.downloadID = paramString6;
    this.flags = paramInt;
  }

  public String getClientName()
  {
    return this.clientName;
  }

  public String getClientSortName()
  {
    return this.clientSortName;
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
    return "CAddressBookEntry{clientName='" + this.clientName + '\'' + ", phoneNumber='" + this.phoneNumber + '\'' + ", clientSortName='" + this.clientSortName + '\'' + ", downloadID='" + this.downloadID + '\'' + ", memberId='" + this.memberId + '\'' + ", viberId='" + this.viberId + '\'' + ", flags=" + this.flags + '}';
  }

  public static final class CAddressBookEntryFlags
  {
    public static final int NOT_REG = 2;
    public static final int REG = 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.CAddressBookEntry
 * JD-Core Version:    0.6.2
 */
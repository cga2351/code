package com.viber.jni.im2;

public class CAddressBookEntryV2
{
  public final String clientName;
  public final String clientSortName;
  public final String downloadID;
  public final int flags;
  public final String mid;
  public final CMoreUserInfo moreInfo;
  public final String phoneNumber;
  public final String vid;

  public CAddressBookEntryV2(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, CMoreUserInfo paramCMoreUserInfo, int paramInt)
  {
    this.mid = Im2Utils.checkStringValue(paramString1);
    this.vid = Im2Utils.checkStringValue(paramString2);
    this.phoneNumber = Im2Utils.checkStringValue(paramString3);
    this.clientName = Im2Utils.checkStringValue(paramString4);
    this.clientSortName = Im2Utils.checkStringValue(paramString5);
    this.downloadID = Im2Utils.checkStringValue(paramString6);
    this.moreInfo = ((CMoreUserInfo)Im2Utils.checkStructValue(paramCMoreUserInfo));
    this.flags = paramInt;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CAddressBookEntryV2{mid='" + this.mid + '\'' + ", vid='" + this.vid + '\'' + ", phoneNumber='" + this.phoneNumber + '\'' + ", clientName='" + this.clientName + '\'' + ", clientSortName='" + this.clientSortName + '\'' + ", downloadID='" + this.downloadID + '\'' + ", moreInfo=" + this.moreInfo + ", flags=" + this.flags + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CAddressBookEntryV2
 * JD-Core Version:    0.6.2
 */
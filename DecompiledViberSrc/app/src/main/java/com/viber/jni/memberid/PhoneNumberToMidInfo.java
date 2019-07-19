package com.viber.jni.memberid;

public class PhoneNumberToMidInfo
{
  private String memberId;
  private String phoneNumber;
  private int status;
  private String viberId;

  private PhoneNumberToMidInfo(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.phoneNumber = paramString1;
    this.memberId = paramString2;
    this.viberId = paramString3;
    this.status = paramInt;
  }

  public String getMemberId()
  {
    return this.memberId;
  }

  public String getPhoneNumber()
  {
    return this.phoneNumber;
  }

  public int getStatus()
  {
    return this.status;
  }

  public String getViberId()
  {
    return this.viberId;
  }

  public String toString()
  {
    return "PhoneNumberToMidInfo{phoneNumber='" + this.phoneNumber + '\'' + ", memberId='" + this.memberId + '\'' + ", viberId='" + this.viberId + '\'' + ", status='" + this.status + '\'' + '}';
  }

  public static final class State
  {
    public static final int INVALID_NUMBER = 2;
    public static final int NOT_REG = 3;
    public static final int OK = 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.memberid.PhoneNumberToMidInfo
 * JD-Core Version:    0.6.2
 */
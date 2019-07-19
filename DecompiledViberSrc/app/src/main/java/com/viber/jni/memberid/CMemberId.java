package com.viber.jni.memberid;

public class CMemberId
{
  private String memberId;
  private String viberId;

  public CMemberId(String paramString1, String paramString2)
  {
    this.memberId = paramString1;
    this.viberId = paramString2;
  }

  public String getMemberId()
  {
    return this.memberId;
  }

  public String getViberId()
  {
    return this.viberId;
  }

  public String toString()
  {
    return "CMemberId{memberId='" + this.memberId + '\'' + ", viberId='" + this.viberId + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.memberid.CMemberId
 * JD-Core Version:    0.6.2
 */
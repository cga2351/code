package com.viber.jni;

public class CGroupMessageData
{
  String senderPhoneNumber;
  long timeSent;
  long token;

  public CGroupMessageData(long paramLong1, long paramLong2, String paramString)
  {
    this.token = paramLong1;
    this.timeSent = paramLong2;
    this.senderPhoneNumber = paramString;
  }

  public String getSenderPhoneNumber()
  {
    return this.senderPhoneNumber;
  }

  public long getTimeSent()
  {
    return this.timeSent;
  }

  public long getToken()
  {
    return this.token;
  }

  public String toString()
  {
    return "CGroupMessageData{token=" + this.token + ", timeSent=" + this.timeSent + ", senderPhoneNumber=" + this.senderPhoneNumber + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.CGroupMessageData
 * JD-Core Version:    0.6.2
 */
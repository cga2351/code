package com.viber.jni;

public class ConversationToken
{
  public String peerNum = "";
  public long token = 0L;

  public ConversationToken(long paramLong, String paramString)
  {
    this.token = paramLong;
    this.peerNum = paramString;
  }

  public String toString()
  {
    return "tk:" + this.token + " pn:" + this.peerNum;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.ConversationToken
 * JD-Core Version:    0.6.2
 */
package com.viber.jni.im2;

public class ConversationToken
{
  public final String peerNum;
  public final long token;

  public ConversationToken(long paramLong, String paramString)
  {
    this.token = paramLong;
    this.peerNum = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.ConversationToken
 * JD-Core Version:    0.6.2
 */
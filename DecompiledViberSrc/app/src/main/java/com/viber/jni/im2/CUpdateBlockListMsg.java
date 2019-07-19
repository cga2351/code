package com.viber.jni.im2;

public class CUpdateBlockListMsg
{
  public final String[] blockedNumbers;
  public final CBlockedUserInfo[] blockedNumbersWithFlags;
  public final int sequence;

  public CUpdateBlockListMsg(int paramInt, String[] paramArrayOfString)
  {
    this.sequence = paramInt;
    this.blockedNumbers = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.blockedNumbersWithFlags = null;
    init();
  }

  public CUpdateBlockListMsg(int paramInt, String[] paramArrayOfString, CBlockedUserInfo[] paramArrayOfCBlockedUserInfo)
  {
    this.sequence = paramInt;
    this.blockedNumbers = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.blockedNumbersWithFlags = ((CBlockedUserInfo[])Im2Utils.checkArrayValue(paramArrayOfCBlockedUserInfo, [Lcom.viber.jni.im2.CBlockedUserInfo.class));
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCUpdateBlockListMsg(CUpdateBlockListMsg paramCUpdateBlockListMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUpdateBlockListMsg
 * JD-Core Version:    0.6.2
 */
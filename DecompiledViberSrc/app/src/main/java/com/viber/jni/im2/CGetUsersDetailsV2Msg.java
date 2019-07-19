package com.viber.jni.im2;

public class CGetUsersDetailsV2Msg
{
  public final int inputType;
  public final int seq;
  public final String[] userIDs;

  public CGetUsersDetailsV2Msg(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    this.userIDs = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.inputType = paramInt1;
    this.seq = paramInt2;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCGetUsersDetailsV2Msg(CGetUsersDetailsV2Msg paramCGetUsersDetailsV2Msg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetUsersDetailsV2Msg
 * JD-Core Version:    0.6.2
 */
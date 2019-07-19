package com.viber.jni.im2;

import java.util.Arrays;

public class CGetEncryptedMIDsMsg
{
  public final String[] mIDsList;
  public final int seq;

  public CGetEncryptedMIDsMsg(int paramInt, String[] paramArrayOfString)
  {
    this.seq = paramInt;
    this.mIDsList = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CGetEncryptedMIDsMsg{seq=" + this.seq + ", mIDsList=" + Arrays.toString(this.mIDsList) + '}';
  }

  public static abstract interface Sender
  {
    public abstract void handleCGetEncryptedMIDsMsg(CGetEncryptedMIDsMsg paramCGetEncryptedMIDsMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetEncryptedMIDsMsg
 * JD-Core Version:    0.6.2
 */
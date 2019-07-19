package com.viber.jni.im2;

public class CCreateConferenceCallMsg
{
  public final String attachment;
  public final String[] memberIDs;
  public final int peerCID;
  public final int seq;

  public CCreateConferenceCallMsg(int paramInt1, String[] paramArrayOfString, String paramString, int paramInt2)
  {
    this.seq = paramInt1;
    this.memberIDs = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.attachment = Im2Utils.checkStringValue(paramString);
    this.peerCID = paramInt2;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCCreateConferenceCallMsg(CCreateConferenceCallMsg paramCCreateConferenceCallMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CCreateConferenceCallMsg
 * JD-Core Version:    0.6.2
 */
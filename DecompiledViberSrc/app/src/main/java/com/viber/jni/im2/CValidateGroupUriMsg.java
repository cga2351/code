package com.viber.jni.im2;

public class CValidateGroupUriMsg
{
  public final int context;
  public final String groupUri;

  public CValidateGroupUriMsg(String paramString, int paramInt)
  {
    this.groupUri = Im2Utils.checkStringValue(paramString);
    this.context = paramInt;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCValidateGroupUriMsg(CValidateGroupUriMsg paramCValidateGroupUriMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CValidateGroupUriMsg
 * JD-Core Version:    0.6.2
 */
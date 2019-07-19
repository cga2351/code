package com.viber.jni.im2;

public class CUpdateUserNameMsg
{
  public final String newName;

  public CUpdateUserNameMsg(String paramString)
  {
    this.newName = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCUpdateUserNameMsg(CUpdateUserNameMsg paramCUpdateUserNameMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUpdateUserNameMsg
 * JD-Core Version:    0.6.2
 */
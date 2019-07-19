package com.viber.jni.im2;

public class CIsRegisteredNumberMsg
{
  public final String toNumber;

  public CIsRegisteredNumberMsg(String paramString)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCIsRegisteredNumberMsg(CIsRegisteredNumberMsg paramCIsRegisteredNumberMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CIsRegisteredNumberMsg
 * JD-Core Version:    0.6.2
 */
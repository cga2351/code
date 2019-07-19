package com.viber.jni.im2;

public class CBillingTokenMsg
{
  public CBillingTokenMsg()
  {
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCBillingTokenMsg(CBillingTokenMsg paramCBillingTokenMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CBillingTokenMsg
 * JD-Core Version:    0.6.2
 */
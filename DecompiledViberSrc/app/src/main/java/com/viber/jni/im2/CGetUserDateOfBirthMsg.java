package com.viber.jni.im2;

public class CGetUserDateOfBirthMsg
{
  public final int seq;

  public CGetUserDateOfBirthMsg(int paramInt)
  {
    this.seq = paramInt;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCGetUserDateOfBirthMsg(CGetUserDateOfBirthMsg paramCGetUserDateOfBirthMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetUserDateOfBirthMsg
 * JD-Core Version:    0.6.2
 */
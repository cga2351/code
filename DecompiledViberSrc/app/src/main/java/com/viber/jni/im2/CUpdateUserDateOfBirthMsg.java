package com.viber.jni.im2;

public class CUpdateUserDateOfBirthMsg
{
  public final byte day;
  public final byte month;
  public final int seq;
  public final short year;

  public CUpdateUserDateOfBirthMsg(int paramInt, byte paramByte1, byte paramByte2, short paramShort)
  {
    this.seq = paramInt;
    this.day = paramByte1;
    this.month = paramByte2;
    this.year = paramShort;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCUpdateUserDateOfBirthMsg(CUpdateUserDateOfBirthMsg paramCUpdateUserDateOfBirthMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUpdateUserDateOfBirthMsg
 * JD-Core Version:    0.6.2
 */
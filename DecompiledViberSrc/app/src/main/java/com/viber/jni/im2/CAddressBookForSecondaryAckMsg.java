package com.viber.jni.im2;

public class CAddressBookForSecondaryAckMsg
{
  public final short genNum;
  public final boolean lastMsg;
  public final int seq;

  public CAddressBookForSecondaryAckMsg(short paramShort, boolean paramBoolean, int paramInt)
  {
    this.genNum = paramShort;
    this.lastMsg = paramBoolean;
    this.seq = paramInt;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCAddressBookForSecondaryAckMsg(CAddressBookForSecondaryAckMsg paramCAddressBookForSecondaryAckMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CAddressBookForSecondaryAckMsg
 * JD-Core Version:    0.6.2
 */
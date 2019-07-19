package com.viber.jni.im2;

public class CShareAddressBook2Msg
{
  public final CContactInfo[] addressBookList;
  public final int seq;

  public CShareAddressBook2Msg(CContactInfo[] paramArrayOfCContactInfo, int paramInt)
  {
    this.addressBookList = ((CContactInfo[])Im2Utils.checkArrayValue(paramArrayOfCContactInfo, [Lcom.viber.jni.im2.CContactInfo.class));
    this.seq = paramInt;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCShareAddressBook2Msg(CShareAddressBook2Msg paramCShareAddressBook2Msg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CShareAddressBook2Msg
 * JD-Core Version:    0.6.2
 */
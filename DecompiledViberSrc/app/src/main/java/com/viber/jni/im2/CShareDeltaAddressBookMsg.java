package com.viber.jni.im2;

public class CShareDeltaAddressBookMsg
{
  public final CContactInfo[] changedPhones;
  public final String[] deletedPhones;
  public final CContactInfo[] newPhones;
  public final short revision;
  public final int seq;

  public CShareDeltaAddressBookMsg(CContactInfo[] paramArrayOfCContactInfo1, CContactInfo[] paramArrayOfCContactInfo2, String[] paramArrayOfString, int paramInt, short paramShort)
  {
    this.newPhones = ((CContactInfo[])Im2Utils.checkArrayValue(paramArrayOfCContactInfo1, [Lcom.viber.jni.im2.CContactInfo.class));
    this.changedPhones = ((CContactInfo[])Im2Utils.checkArrayValue(paramArrayOfCContactInfo2, [Lcom.viber.jni.im2.CContactInfo.class));
    this.deletedPhones = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.seq = paramInt;
    this.revision = paramShort;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCShareDeltaAddressBookMsg(CShareDeltaAddressBookMsg paramCShareDeltaAddressBookMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CShareDeltaAddressBookMsg
 * JD-Core Version:    0.6.2
 */
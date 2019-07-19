package com.viber.jni.im2;

import java.util.Arrays;

public class CAddressBookForSecondaryV2Msg
{
  public final CAddressBookEntryV2[] addressBookList;
  public final boolean clearAll;
  public final int context;
  public final short genNum;
  public final boolean lastMsg;
  public final int seq;

  public CAddressBookForSecondaryV2Msg(int paramInt1, CAddressBookEntryV2[] paramArrayOfCAddressBookEntryV2, short paramShort, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    this.context = paramInt1;
    this.addressBookList = ((CAddressBookEntryV2[])Im2Utils.checkArrayValue(paramArrayOfCAddressBookEntryV2, [Lcom.viber.jni.im2.CAddressBookEntryV2.class));
    this.genNum = paramShort;
    this.lastMsg = paramBoolean1;
    this.clearAll = paramBoolean2;
    this.seq = paramInt2;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CAddressBookForSecondaryV2Msg{context=" + this.context + ", addressBookList=" + Arrays.toString(this.addressBookList) + ", genNum=" + this.genNum + ", lastMsg=" + this.lastMsg + ", clearAll=" + this.clearAll + ", seq=" + this.seq + '}';
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCAddressBookForSecondaryV2Msg(CAddressBookForSecondaryV2Msg paramCAddressBookForSecondaryV2Msg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CAddressBookForSecondaryV2Msg
 * JD-Core Version:    0.6.2
 */
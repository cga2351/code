package com.viber.jni.im2;

import java.util.Arrays;

public class CAddressBookDeltaUpdateV2Msg
{
  public final int baseRevision;
  public final CAddressBookEntryV2[] changedPhones;
  public final String[] deletedPhones;
  public final long messageToken;
  public final CAddressBookEntryV2[] newPhones;
  public final int revision;

  public CAddressBookDeltaUpdateV2Msg(int paramInt1, int paramInt2, CAddressBookEntryV2[] paramArrayOfCAddressBookEntryV21, CAddressBookEntryV2[] paramArrayOfCAddressBookEntryV22, String[] paramArrayOfString, long paramLong)
  {
    this.baseRevision = paramInt1;
    this.revision = paramInt2;
    this.newPhones = ((CAddressBookEntryV2[])Im2Utils.checkArrayValue(paramArrayOfCAddressBookEntryV21, [Lcom.viber.jni.im2.CAddressBookEntryV2.class));
    this.changedPhones = ((CAddressBookEntryV2[])Im2Utils.checkArrayValue(paramArrayOfCAddressBookEntryV22, [Lcom.viber.jni.im2.CAddressBookEntryV2.class));
    this.deletedPhones = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.messageToken = paramLong;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CAddressBookDeltaUpdateV2Msg{baseRevision=" + this.baseRevision + ", revision=" + this.revision + ", newPhones=" + Arrays.toString(this.newPhones) + ", changedPhones=" + Arrays.toString(this.changedPhones) + ", deletedPhones=" + Arrays.toString(this.deletedPhones) + ", messageToken=" + this.messageToken + '}';
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCAddressBookDeltaUpdateV2Msg(CAddressBookDeltaUpdateV2Msg paramCAddressBookDeltaUpdateV2Msg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CAddressBookDeltaUpdateV2Msg
 * JD-Core Version:    0.6.2
 */
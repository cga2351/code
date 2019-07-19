package com.viber.jni.im2;

public class CAddressBookDeltaUpdateAckMsg
{
  public final long messageToken;
  public final Integer revision;

  public CAddressBookDeltaUpdateAckMsg(long paramLong)
  {
    this.messageToken = paramLong;
    this.revision = null;
    init();
  }

  public CAddressBookDeltaUpdateAckMsg(long paramLong, int paramInt)
  {
    this.messageToken = paramLong;
    this.revision = Integer.valueOf(paramInt);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCAddressBookDeltaUpdateAckMsg(CAddressBookDeltaUpdateAckMsg paramCAddressBookDeltaUpdateAckMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CAddressBookDeltaUpdateAckMsg
 * JD-Core Version:    0.6.2
 */
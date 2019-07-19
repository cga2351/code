package com.viber.jni.im2;

import java.util.Arrays;

public class CRegisteredContactsMsg
{
  public final short aBRevision;
  public final boolean clearAll;
  public final boolean lastMsg;
  public final CRegisteredContactInfo[] registeredContacts;
  public final int seq;
  public final long token;

  public CRegisteredContactsMsg(int paramInt, CRegisteredContactInfo[] paramArrayOfCRegisteredContactInfo, long paramLong, short paramShort, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.seq = paramInt;
    this.registeredContacts = ((CRegisteredContactInfo[])Im2Utils.checkArrayValue(paramArrayOfCRegisteredContactInfo, [Lcom.viber.jni.im2.CRegisteredContactInfo.class));
    this.token = paramLong;
    this.aBRevision = paramShort;
    this.clearAll = paramBoolean1;
    this.lastMsg = paramBoolean2;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CRegisteredContactsMsg{seq=" + this.seq + ", registeredContacts=" + Arrays.toString(this.registeredContacts) + ", token=" + this.token + ", aBRevision=" + this.aBRevision + ", clearAll=" + this.clearAll + ", lastMsg=" + this.lastMsg + '}';
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCRegisteredContactsMsg(CRegisteredContactsMsg paramCRegisteredContactsMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CRegisteredContactsMsg
 * JD-Core Version:    0.6.2
 */
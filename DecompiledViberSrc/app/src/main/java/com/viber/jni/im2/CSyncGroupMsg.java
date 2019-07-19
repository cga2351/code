package com.viber.jni.im2;

import java.util.Set;

public class CSyncGroupMsg
{
  public final int flags;
  public final long groupID;
  public final Long lastMessageToken;
  public final Set<String> senders;
  public final Integer seqInPG;

  public CSyncGroupMsg(long paramLong, int paramInt)
  {
    this.groupID = paramLong;
    this.flags = paramInt;
    this.lastMessageToken = null;
    this.seqInPG = null;
    this.senders = null;
    init();
  }

  public CSyncGroupMsg(long paramLong1, int paramInt, long paramLong2)
  {
    this.groupID = paramLong1;
    this.flags = paramInt;
    this.lastMessageToken = Long.valueOf(paramLong2);
    this.seqInPG = null;
    this.senders = null;
    init();
  }

  public CSyncGroupMsg(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    this.groupID = paramLong1;
    this.flags = paramInt1;
    this.lastMessageToken = Long.valueOf(paramLong2);
    this.seqInPG = Integer.valueOf(paramInt2);
    this.senders = null;
    init();
  }

  public CSyncGroupMsg(long paramLong1, int paramInt1, long paramLong2, int paramInt2, Set<String> paramSet)
  {
    this.groupID = paramLong1;
    this.flags = paramInt1;
    this.lastMessageToken = Long.valueOf(paramLong2);
    this.seqInPG = Integer.valueOf(paramInt2);
    this.senders = Im2Utils.checkSetValue(paramSet);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCSyncGroupMsg(CSyncGroupMsg paramCSyncGroupMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSyncGroupMsg
 * JD-Core Version:    0.6.2
 */
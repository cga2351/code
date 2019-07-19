package com.viber.jni.im2;

public class CCheckAllowsM2MChatMsg
{
  public final long groupId;
  public final int seq;
  public final String toEMID;

  public CCheckAllowsM2MChatMsg(int paramInt, long paramLong, String paramString)
  {
    this.seq = paramInt;
    this.groupId = paramLong;
    this.toEMID = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CCheckAllowsM2MChatMsg{seq=" + this.seq + ", groupId=" + this.groupId + ", toEMID='" + this.toEMID + '\'' + '}';
  }

  public static abstract interface Sender
  {
    public abstract void handleCCheckAllowsM2MChatMsg(CCheckAllowsM2MChatMsg paramCCheckAllowsM2MChatMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CCheckAllowsM2MChatMsg
 * JD-Core Version:    0.6.2
 */
package com.viber.jni.im2;

public class CCreateGroupMsg
{
  public final Integer chatType;
  public final int context;
  public final CGroupAttributes groupAttributes;
  public final String[] members;
  public final Integer timebombInSec;

  public CCreateGroupMsg(int paramInt, String[] paramArrayOfString, CGroupAttributes paramCGroupAttributes)
  {
    this.context = paramInt;
    this.members = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.groupAttributes = ((CGroupAttributes)Im2Utils.checkStructValue(paramCGroupAttributes));
    this.chatType = null;
    this.timebombInSec = null;
    init();
  }

  public CCreateGroupMsg(int paramInt1, String[] paramArrayOfString, CGroupAttributes paramCGroupAttributes, int paramInt2)
  {
    this.context = paramInt1;
    this.members = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.groupAttributes = ((CGroupAttributes)Im2Utils.checkStructValue(paramCGroupAttributes));
    this.chatType = Integer.valueOf(paramInt2);
    this.timebombInSec = null;
    init();
  }

  public CCreateGroupMsg(int paramInt1, String[] paramArrayOfString, CGroupAttributes paramCGroupAttributes, int paramInt2, int paramInt3)
  {
    this.context = paramInt1;
    this.members = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.groupAttributes = ((CGroupAttributes)Im2Utils.checkStructValue(paramCGroupAttributes));
    this.chatType = Integer.valueOf(paramInt2);
    this.timebombInSec = Integer.valueOf(paramInt3);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCCreateGroupMsg(CCreateGroupMsg paramCCreateGroupMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CCreateGroupMsg
 * JD-Core Version:    0.6.2
 */
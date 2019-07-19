package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGetSecondaryDeviceDetailsReplyMsg
{
  public final CSecondaryDeviceDetailsElement[] devices;
  public final Integer status;

  public CGetSecondaryDeviceDetailsReplyMsg(CSecondaryDeviceDetailsElement[] paramArrayOfCSecondaryDeviceDetailsElement)
  {
    this.devices = ((CSecondaryDeviceDetailsElement[])Im2Utils.checkArrayValue(paramArrayOfCSecondaryDeviceDetailsElement, [Lcom.viber.jni.im2.CSecondaryDeviceDetailsElement.class));
    this.status = null;
    init();
  }

  public CGetSecondaryDeviceDetailsReplyMsg(CSecondaryDeviceDetailsElement[] paramArrayOfCSecondaryDeviceDetailsElement, int paramInt)
  {
    this.devices = ((CSecondaryDeviceDetailsElement[])Im2Utils.checkArrayValue(paramArrayOfCSecondaryDeviceDetailsElement, [Lcom.viber.jni.im2.CSecondaryDeviceDetailsElement.class));
    this.status = Integer.valueOf(paramInt);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 1;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGetSecondaryDeviceDetailsReplyMsg(CGetSecondaryDeviceDetailsReplyMsg paramCGetSecondaryDeviceDetailsReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetSecondaryDeviceDetailsReplyMsg
 * JD-Core Version:    0.6.2
 */
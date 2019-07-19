package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public class CGetEncryptedMIDsReplyMsg
{
  public final EncryptedMIDMap[] encryptedMids;
  public final int seq;
  public final int status;

  public CGetEncryptedMIDsReplyMsg(int paramInt1, int paramInt2, EncryptedMIDMap[] paramArrayOfEncryptedMIDMap)
  {
    this.seq = paramInt1;
    this.status = paramInt2;
    this.encryptedMids = ((EncryptedMIDMap[])Im2Utils.checkArrayValue(paramArrayOfEncryptedMIDMap, [Lcom.viber.jni.im2.EncryptedMIDMap.class));
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CGetEncryptedMIDsReplyMsg{seq=" + this.seq + ", status=" + this.status + ", encryptedMids=" + Arrays.toString(this.encryptedMids) + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 1;
    public static final int INPUT_TOO_LONG = 3;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGetEncryptedMIDsReplyMsg(CGetEncryptedMIDsReplyMsg paramCGetEncryptedMIDsReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetEncryptedMIDsReplyMsg
 * JD-Core Version:    0.6.2
 */
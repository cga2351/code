package com.viber.jni.im2;

public class CViberIdChangedMsg
{
  public final String email;
  public final int flags;
  public final CMoreUserInfo moreUserInfo;
  public final int version;

  public CViberIdChangedMsg(String paramString, int paramInt1, int paramInt2, CMoreUserInfo paramCMoreUserInfo)
  {
    this.email = Im2Utils.checkStringValue(paramString);
    this.flags = paramInt1;
    this.version = paramInt2;
    this.moreUserInfo = ((CMoreUserInfo)Im2Utils.checkStructValue(paramCMoreUserInfo));
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CViberIdChangedMsg{email='" + this.email + '\'' + ", flags=" + this.flags + ", version=" + this.version + ", moreUserInfo=" + this.moreUserInfo + '}';
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCViberIdChangedMsg(CViberIdChangedMsg paramCViberIdChangedMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CViberIdChangedMsg
 * JD-Core Version:    0.6.2
 */
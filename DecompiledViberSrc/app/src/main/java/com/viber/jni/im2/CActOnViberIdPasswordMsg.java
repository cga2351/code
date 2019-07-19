package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CActOnViberIdPasswordMsg
{
  public final int action;
  public final String email;
  public final String newPassword;
  public final String oldPassword;
  public final int seq;

  public CActOnViberIdPasswordMsg(int paramInt1, int paramInt2)
  {
    this.seq = paramInt1;
    this.action = paramInt2;
    this.oldPassword = null;
    this.newPassword = null;
    this.email = null;
    init();
  }

  public CActOnViberIdPasswordMsg(int paramInt1, int paramInt2, String paramString)
  {
    this.seq = paramInt1;
    this.action = paramInt2;
    this.oldPassword = Im2Utils.checkStringValue(paramString);
    this.newPassword = null;
    this.email = null;
    init();
  }

  public CActOnViberIdPasswordMsg(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.seq = paramInt1;
    this.action = paramInt2;
    this.oldPassword = Im2Utils.checkStringValue(paramString1);
    this.newPassword = Im2Utils.checkStringValue(paramString2);
    this.email = null;
    init();
  }

  public CActOnViberIdPasswordMsg(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    this.seq = paramInt1;
    this.action = paramInt2;
    this.oldPassword = Im2Utils.checkStringValue(paramString1);
    this.newPassword = Im2Utils.checkStringValue(paramString2);
    this.email = Im2Utils.checkStringValue(paramString3);
    init();
  }

  public static CActOnViberIdPasswordMsg createChangePasswordMessage(int paramInt, String paramString1, String paramString2)
  {
    return new CActOnViberIdPasswordMsg(paramInt, 1, paramString1, paramString2, "");
  }

  public static CActOnViberIdPasswordMsg createForgotPasswordMessage(int paramInt, String paramString)
  {
    return new CActOnViberIdPasswordMsg(paramInt, 0, "", "", paramString);
  }

  public static CActOnViberIdPasswordMsg createRetypePasswordMessage(int paramInt, String paramString)
  {
    return new CActOnViberIdPasswordMsg(paramInt, 2, paramString, "", "");
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CActOnViberIdPasswordMsg{seq=" + this.seq + ", action=" + this.action + ", email='" + this.email + '\'' + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EAction
  {
    public static final int CHANGE_PASSWORD = 1;
    public static final int FORGOT_PASSWORD = 0;
    public static final int RETYPE_PASSWORD = 2;
  }

  public static abstract interface Sender
  {
    public abstract void handleCActOnViberIdPasswordMsg(CActOnViberIdPasswordMsg paramCActOnViberIdPasswordMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CActOnViberIdPasswordMsg
 * JD-Core Version:    0.6.2
 */
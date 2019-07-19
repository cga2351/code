package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CUpdatePersonalDetailsMsg
{
  public final String email;
  public final Integer emailCampaign;
  public final Boolean emailConsent;
  public final Boolean emailIsRemove;
  public final Integer emailOrigin;
  public final int seq;
  public final int updateType;

  public CUpdatePersonalDetailsMsg(int paramInt1, int paramInt2)
  {
    this.seq = paramInt1;
    this.updateType = paramInt2;
    this.email = null;
    this.emailIsRemove = null;
    this.emailConsent = null;
    this.emailOrigin = null;
    this.emailCampaign = null;
    init();
  }

  public CUpdatePersonalDetailsMsg(int paramInt1, int paramInt2, String paramString)
  {
    this.seq = paramInt1;
    this.updateType = paramInt2;
    this.email = Im2Utils.checkStringValue(paramString);
    this.emailIsRemove = null;
    this.emailConsent = null;
    this.emailOrigin = null;
    this.emailCampaign = null;
    init();
  }

  public CUpdatePersonalDetailsMsg(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    this.seq = paramInt1;
    this.updateType = paramInt2;
    this.email = Im2Utils.checkStringValue(paramString);
    this.emailIsRemove = Boolean.valueOf(paramBoolean);
    this.emailConsent = null;
    this.emailOrigin = null;
    this.emailCampaign = null;
    init();
  }

  public CUpdatePersonalDetailsMsg(int paramInt1, int paramInt2, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.seq = paramInt1;
    this.updateType = paramInt2;
    this.email = Im2Utils.checkStringValue(paramString);
    this.emailIsRemove = Boolean.valueOf(paramBoolean1);
    this.emailConsent = Boolean.valueOf(paramBoolean2);
    this.emailOrigin = null;
    this.emailCampaign = null;
    init();
  }

  public CUpdatePersonalDetailsMsg(int paramInt1, int paramInt2, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    this.seq = paramInt1;
    this.updateType = paramInt2;
    this.email = Im2Utils.checkStringValue(paramString);
    this.emailIsRemove = Boolean.valueOf(paramBoolean1);
    this.emailConsent = Boolean.valueOf(paramBoolean2);
    this.emailOrigin = Integer.valueOf(paramInt3);
    this.emailCampaign = null;
    init();
  }

  public CUpdatePersonalDetailsMsg(int paramInt1, int paramInt2, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, int paramInt4)
  {
    this.seq = paramInt1;
    this.updateType = paramInt2;
    this.email = Im2Utils.checkStringValue(paramString);
    this.emailIsRemove = Boolean.valueOf(paramBoolean1);
    this.emailConsent = Boolean.valueOf(paramBoolean2);
    this.emailOrigin = Integer.valueOf(paramInt3);
    this.emailCampaign = Integer.valueOf(paramInt4);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EPersonalDetailtsUpdateType
  {
    public static final int UPDATE_EMAIL = 1;
  }

  public static abstract interface Sender
  {
    public abstract void handleCUpdatePersonalDetailsMsg(CUpdatePersonalDetailsMsg paramCUpdatePersonalDetailsMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUpdatePersonalDetailsMsg
 * JD-Core Version:    0.6.2
 */
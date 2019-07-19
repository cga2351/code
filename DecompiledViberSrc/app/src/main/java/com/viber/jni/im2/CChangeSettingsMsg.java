package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CChangeSettingsMsg
{
  public final Boolean disableServices;
  public final Boolean disableViberIn;
  public final Boolean disabledP2P;
  public final Long gdprPrivacyFlag;
  public final boolean joinNotification;
  public final Integer sequence;
  public final Boolean showMyPhoto;
  public final boolean showText;

  public CChangeSettingsMsg(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.joinNotification = paramBoolean1;
    this.showText = paramBoolean2;
    this.disableViberIn = null;
    this.sequence = null;
    this.showMyPhoto = null;
    this.disableServices = null;
    this.gdprPrivacyFlag = null;
    this.disabledP2P = null;
    init();
  }

  public CChangeSettingsMsg(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.joinNotification = paramBoolean1;
    this.showText = paramBoolean2;
    this.disableViberIn = Boolean.valueOf(paramBoolean3);
    this.sequence = null;
    this.showMyPhoto = null;
    this.disableServices = null;
    this.gdprPrivacyFlag = null;
    this.disabledP2P = null;
    init();
  }

  public CChangeSettingsMsg(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    this.joinNotification = paramBoolean1;
    this.showText = paramBoolean2;
    this.disableViberIn = Boolean.valueOf(paramBoolean3);
    this.sequence = Integer.valueOf(paramInt);
    this.showMyPhoto = null;
    this.disableServices = null;
    this.gdprPrivacyFlag = null;
    this.disabledP2P = null;
    init();
  }

  public CChangeSettingsMsg(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, boolean paramBoolean4)
  {
    this.joinNotification = paramBoolean1;
    this.showText = paramBoolean2;
    this.disableViberIn = Boolean.valueOf(paramBoolean3);
    this.sequence = Integer.valueOf(paramInt);
    this.showMyPhoto = Boolean.valueOf(paramBoolean4);
    this.disableServices = null;
    this.gdprPrivacyFlag = null;
    this.disabledP2P = null;
    init();
  }

  public CChangeSettingsMsg(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.joinNotification = paramBoolean1;
    this.showText = paramBoolean2;
    this.disableViberIn = Boolean.valueOf(paramBoolean3);
    this.sequence = Integer.valueOf(paramInt);
    this.showMyPhoto = Boolean.valueOf(paramBoolean4);
    this.disableServices = Boolean.valueOf(paramBoolean5);
    this.gdprPrivacyFlag = null;
    this.disabledP2P = null;
    init();
  }

  public CChangeSettingsMsg(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, boolean paramBoolean4, boolean paramBoolean5, long paramLong)
  {
    this.joinNotification = paramBoolean1;
    this.showText = paramBoolean2;
    this.disableViberIn = Boolean.valueOf(paramBoolean3);
    this.sequence = Integer.valueOf(paramInt);
    this.showMyPhoto = Boolean.valueOf(paramBoolean4);
    this.disableServices = Boolean.valueOf(paramBoolean5);
    this.gdprPrivacyFlag = Long.valueOf(paramLong);
    this.disabledP2P = null;
    init();
  }

  public CChangeSettingsMsg(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, boolean paramBoolean4, boolean paramBoolean5, long paramLong, boolean paramBoolean6)
  {
    this.joinNotification = paramBoolean1;
    this.showText = paramBoolean2;
    this.disableViberIn = Boolean.valueOf(paramBoolean3);
    this.sequence = Integer.valueOf(paramInt);
    this.showMyPhoto = Boolean.valueOf(paramBoolean4);
    this.disableServices = Boolean.valueOf(paramBoolean5);
    this.gdprPrivacyFlag = Long.valueOf(paramLong);
    this.disabledP2P = Boolean.valueOf(paramBoolean6);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CChangeSettingsMsg{sequence=" + this.sequence + ", joinNotification=" + this.joinNotification + ", showText=" + this.showText + ", disableViberIn=" + this.disableViberIn + ", showMyPhoto=" + this.showMyPhoto + ", disableServices=" + this.disableServices + ", gdprPrivacyFlag=" + this.gdprPrivacyFlag + ", disabledP2P=" + this.disabledP2P + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface GdprPrivacyFlagBits
  {
    public static final long DISABLE_ANALYTICS = 1L;
    public static final long DISABLE_CONTENT_PERSONALIZATION = 2L;
    public static final long DISABLE_INTEREST_BASED_ADS = 4L;
    public static final long DISABLE_LOCATION_BASED_SERVICES = 8L;
  }

  public static abstract interface Sender
  {
    public abstract void handleCChangeSettingsMsg(CChangeSettingsMsg paramCChangeSettingsMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CChangeSettingsMsg
 * JD-Core Version:    0.6.2
 */
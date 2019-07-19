package com.viber.voip.registration;

import com.viber.jni.Version;

public abstract interface HardwareParameters
{
  @Deprecated
  public abstract Version getAppVersion();

  public abstract String getCC();

  public abstract String getCN();

  public abstract String getDeviceManufacturer();

  public abstract String getDeviceType();

  @Deprecated
  public abstract String getFullAppVersion();

  public abstract String getIMEI();

  public abstract String getImsi();

  public abstract String getMCC();

  public abstract String getMNC();

  public abstract String getMsin();

  public abstract String getSimCC();

  public abstract String getSimMCC();

  public abstract String getSimMNC();

  public abstract String getSystemVersion();

  public abstract String getUdid();

  public abstract boolean isGsmSupported();

  public abstract boolean isGsmSupportedOrHavePhoneType();

  public abstract boolean isSimChanged();

  public abstract void updatePhoneRelatedInfo();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.HardwareParameters
 * JD-Core Version:    0.6.2
 */
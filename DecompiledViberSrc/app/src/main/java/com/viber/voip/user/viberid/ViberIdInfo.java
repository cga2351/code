package com.viber.voip.user.viberid;

import com.viber.voip.util.da;

public class ViberIdInfo
{
  public static final String DEFAULT_EMAIL = "";
  public static final int DEFAULT_VERSION;
  private final String mEmail;
  private final boolean mRegisteredOnCurrentDevice;
  private final int mVersion;

  public ViberIdInfo(String paramString, int paramInt, boolean paramBoolean)
  {
    this.mEmail = paramString;
    this.mVersion = paramInt;
    this.mRegisteredOnCurrentDevice = paramBoolean;
  }

  public String getEmail()
  {
    return this.mEmail;
  }

  public int getVersion()
  {
    return this.mVersion;
  }

  public boolean isAccountExist()
  {
    return (!da.a(this.mEmail)) && (this.mVersion > 0);
  }

  public boolean isRegisteredOnCurrentDevice()
  {
    return this.mRegisteredOnCurrentDevice;
  }

  public String toString()
  {
    return "ViberIdInfo{mEmail='" + this.mEmail + '\'' + ", mVersion=" + this.mVersion + ", mRegisteredOnCurrentDevice=" + this.mRegisteredOnCurrentDevice + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.ViberIdInfo
 * JD-Core Version:    0.6.2
 */
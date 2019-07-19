package com.viber.voip.registration;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.jni.Version;
import com.viber.voip.ViberEnv;
import com.viber.voip.p;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.da;

public class HardwareParametersImpl
  implements HardwareParameters
{
  private static final Logger L = ViberEnv.getLogger();
  private static final String UNKNOWN_IMEI = "unknown";
  private final Context ctx;
  private String deviceManufacturer;
  private final String deviceType;
  private boolean hasTelephony;
  private String imsi;
  private final ao mUserInfo;
  private String msin;
  private String netCC;
  private String netCN;
  private String netMCC;
  private String netMNC;
  private String phoneIMEI;
  private int phoneType;
  private String simCC;
  private String simMCC;
  private String simMNC;
  private final String sysVersion;

  public HardwareParametersImpl(Context paramContext)
  {
    this.ctx = paramContext;
    this.mUserInfo = UserManager.from(paramContext).getRegistrationValues().a();
    this.deviceType = Build.MODEL;
    this.sysVersion = Build.VERSION.RELEASE;
    this.deviceManufacturer = Build.MANUFACTURER;
    if (!da.a(this.deviceManufacturer))
      this.deviceManufacturer = this.deviceManufacturer.toLowerCase();
    updatePhoneRelatedInfo();
  }

  private String getIMSI(TelephonyManager paramTelephonyManager)
  {
    if (!c.a(this.ctx).a(new String[] { "android.permission.READ_PHONE_STATE" }))
      return null;
    try
    {
      String str = paramTelephonyManager.getSubscriberId();
      return str;
    }
    catch (SecurityException localSecurityException)
    {
    }
    return null;
  }

  @Deprecated
  public Version getAppVersion()
  {
    return Version.parseVersionString(getFullAppVersion());
  }

  public String getCC()
  {
    return this.netCC;
  }

  public String getCN()
  {
    return this.netCN;
  }

  public String getDeviceManufacturer()
  {
    return this.deviceManufacturer;
  }

  public String getDeviceType()
  {
    return this.deviceType;
  }

  @Deprecated
  public String getFullAppVersion()
  {
    return p.d();
  }

  public String getIMEI()
  {
    return this.phoneIMEI;
  }

  public String getImsi()
  {
    return this.imsi;
  }

  public String getMCC()
  {
    return this.netMCC;
  }

  public String getMNC()
  {
    return this.netMNC;
  }

  public String getMsin()
  {
    return this.msin;
  }

  public String getSimCC()
  {
    return this.simCC;
  }

  public String getSimMCC()
  {
    return this.simMCC;
  }

  public String getSimMNC()
  {
    return this.simMNC;
  }

  public String getSystemVersion()
  {
    return this.sysVersion;
  }

  public String getUdid()
  {
    try
    {
      String str = this.mUserInfo.a();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean isGsmSupported()
  {
    return this.hasTelephony;
  }

  public boolean isGsmSupportedOrHavePhoneType()
  {
    return (this.hasTelephony) || (this.phoneType != 0);
  }

  public boolean isSimChanged()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)this.ctx.getSystemService("phone");
    return (!da.a(this.simCC, localTelephonyManager.getSimCountryIso())) || (!da.a(this.imsi, getIMSI(localTelephonyManager)));
  }

  public String toString()
  {
    return "HardwareParametersImpl{androidId='" + getUdid() + '\'' + ", deviceType='" + this.deviceType + '\'' + ", sysVersion='" + this.sysVersion + '\'' + ", GsmSupported='" + isGsmSupported() + '\'' + ", isGsmSupportedOrHavePhoneType='" + isGsmSupportedOrHavePhoneType() + '\'' + '}';
  }

  public void updatePhoneRelatedInfo()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)this.ctx.getSystemService("phone");
    String str1 = localTelephonyManager.getNetworkOperator();
    int i;
    label85: label109: String str3;
    if ((str1 != null) && (str1.length() > 3))
    {
      this.netMCC = str1.substring(0, 3);
      this.netMNC = str1.substring(3);
      this.netCC = localTelephonyManager.getNetworkCountryIso();
      this.netCN = localTelephonyManager.getNetworkOperatorName();
      String str2 = localTelephonyManager.getSimOperator();
      if ((str2 == null) || (str2.length() <= 3))
        break label226;
      i = 1;
      if (i == 0)
        break label232;
      this.simMCC = str2.substring(0, 3);
      this.simMNC = str2.substring(3);
      this.simCC = localTelephonyManager.getSimCountryIso();
      this.imsi = getIMSI(localTelephonyManager);
      if ((i == 0) || (this.imsi == null) || (this.imsi.length() <= str2.length()))
        break label249;
      this.msin = this.imsi.substring(str2.length());
      label167: this.hasTelephony = this.ctx.getPackageManager().hasSystemFeature("android.hardware.telephony");
      this.phoneType = localTelephonyManager.getPhoneType();
      str3 = ao.c();
      if (str3 == null)
        break label259;
    }
    while (true)
    {
      this.phoneIMEI = str3;
      return;
      this.netMNC = "";
      this.netMCC = "";
      break;
      label226: i = 0;
      break label85;
      label232: this.simMNC = "";
      this.simMCC = "";
      break label109;
      label249: this.msin = "";
      break label167;
      label259: str3 = "unknown";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.HardwareParametersImpl
 * JD-Core Version:    0.6.2
 */
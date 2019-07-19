package com.mopub.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.privacy.MoPubIdentifier;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import java.util.Locale;

public class ClientMetadata
{
  private static volatile ClientMetadata i;
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private final MoPubIdentifier h;
  private final String j;
  private final String k;
  private final String l;
  private final String m;
  private final String n;
  private final String o;
  private final String p;
  private String q;
  private final Context r;
  private final ConnectivityManager s;

  private ClientMetadata(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    this.r = paramContext.getApplicationContext();
    this.s = ((ConnectivityManager)this.r.getSystemService("connectivity"));
    this.j = Build.MANUFACTURER;
    this.k = Build.MODEL;
    this.l = Build.PRODUCT;
    this.m = Build.VERSION.RELEASE;
    this.n = "5.7.1";
    this.o = a(this.r);
    PackageManager localPackageManager = this.r.getPackageManager();
    this.p = this.r.getPackageName();
    try
    {
      ApplicationInfo localApplicationInfo2 = localPackageManager.getApplicationInfo(this.p, 0);
      localApplicationInfo1 = localApplicationInfo2;
      if (localApplicationInfo1 != null)
        this.q = ((String)localPackageManager.getApplicationLabel(localApplicationInfo1));
      localTelephonyManager = (TelephonyManager)this.r.getSystemService("phone");
      if (localTelephonyManager != null)
      {
        this.a = localTelephonyManager.getNetworkOperator();
        this.b = localTelephonyManager.getNetworkOperator();
        if ((localTelephonyManager.getPhoneType() == 2) && (localTelephonyManager.getSimState() == 5))
        {
          this.a = localTelephonyManager.getSimOperator();
          this.c = localTelephonyManager.getSimOperator();
        }
        if (!MoPub.canCollectPersonalInformation())
          break label276;
        this.d = localTelephonyManager.getNetworkCountryIso();
        this.e = localTelephonyManager.getSimCountryIso();
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      try
      {
        while (true)
        {
          TelephonyManager localTelephonyManager;
          this.f = localTelephonyManager.getNetworkOperatorName();
          if (localTelephonyManager.getSimState() == 5)
            this.g = localTelephonyManager.getSimOperatorName();
          this.h = new MoPubIdentifier(this.r);
          return;
          localNameNotFoundException = localNameNotFoundException;
          ApplicationInfo localApplicationInfo1 = null;
          continue;
          label276: this.d = "";
          this.e = "";
        }
      }
      catch (SecurityException localSecurityException)
      {
        while (true)
        {
          this.f = null;
          this.g = null;
        }
      }
    }
  }

  private static String a(Context paramContext)
  {
    try
    {
      String str1 = paramContext.getPackageName();
      String str2 = paramContext.getPackageManager().getPackageInfo(str1, 0).versionName;
      return str2;
    }
    catch (Exception localException)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Failed to retrieve PackageInfo#versionName." });
    }
    return null;
  }

  @Deprecated
  @VisibleForTesting
  public static void clearForTesting()
  {
    i = null;
  }

  public static String getCurrentLanguage(Context paramContext)
  {
    String str = Locale.getDefault().getLanguage().trim();
    Locale localLocale = paramContext.getResources().getConfiguration().locale;
    if ((localLocale != null) && (!localLocale.getLanguage().trim().isEmpty()))
      str = localLocale.getLanguage().trim();
    return str;
  }

  public static ClientMetadata getInstance()
  {
    ClientMetadata localClientMetadata1 = i;
    if (localClientMetadata1 == null)
      try
      {
        ClientMetadata localClientMetadata2 = i;
        return localClientMetadata2;
      }
      finally
      {
      }
    return localClientMetadata1;
  }

  public static ClientMetadata getInstance(Context paramContext)
  {
    ClientMetadata localClientMetadata1 = i;
    if (localClientMetadata1 == null)
      try
      {
        ClientMetadata localClientMetadata2 = i;
        if (localClientMetadata2 == null)
        {
          localClientMetadata2 = new ClientMetadata(paramContext);
          i = localClientMetadata2;
        }
        return localClientMetadata2;
      }
      finally
      {
      }
    return localClientMetadata1;
  }

  @Deprecated
  @VisibleForTesting
  public static void setInstance(ClientMetadata paramClientMetadata)
  {
    try
    {
      i = paramClientMetadata;
      return;
    }
    finally
    {
    }
  }

  @SuppressLint({"MissingPermission"})
  public MoPubNetworkType getActiveNetworkType()
  {
    if (!DeviceUtils.isPermissionGranted(this.r, "android.permission.ACCESS_NETWORK_STATE"))
      return MoPubNetworkType.UNKNOWN;
    NetworkInfo localNetworkInfo1 = this.s.getActiveNetworkInfo();
    if ((localNetworkInfo1 == null) || (!localNetworkInfo1.isConnected()))
      return MoPubNetworkType.UNKNOWN;
    if (Build.VERSION.SDK_INT < 21)
    {
      if (localNetworkInfo1.getType() == 9)
        return MoPubNetworkType.ETHERNET;
    }
    else
      for (Network localNetwork : this.s.getAllNetworks())
      {
        NetworkCapabilities localNetworkCapabilities = this.s.getNetworkCapabilities(localNetwork);
        if ((localNetworkCapabilities != null) && (localNetworkCapabilities.hasTransport(3)))
          return MoPubNetworkType.ETHERNET;
      }
    NetworkInfo localNetworkInfo2 = this.s.getNetworkInfo(1);
    if ((localNetworkInfo2 != null) && (localNetworkInfo2.isConnected()))
      return MoPubNetworkType.WIFI;
    NetworkInfo localNetworkInfo3 = this.s.getNetworkInfo(0);
    if ((localNetworkInfo3 != null) && (localNetworkInfo3.isConnected()))
    {
      switch (localNetworkInfo3.getSubtype())
      {
      default:
        return MoPubNetworkType.MOBILE;
      case 1:
      case 2:
      case 4:
      case 7:
      case 11:
        return MoPubNetworkType.GG;
      case 3:
      case 5:
      case 6:
      case 8:
      case 9:
      case 10:
      case 12:
      case 14:
        return MoPubNetworkType.GGG;
      case 13:
      case 15:
      }
      return MoPubNetworkType.GGGG;
    }
    return MoPubNetworkType.UNKNOWN;
  }

  public String getAppName()
  {
    return this.q;
  }

  public String getAppPackageName()
  {
    return this.p;
  }

  public String getAppVersion()
  {
    return this.o;
  }

  public float getDensity()
  {
    return this.r.getResources().getDisplayMetrics().density;
  }

  public Point getDeviceDimensions()
  {
    if (Preconditions.NoThrow.checkNotNull(this.r))
      return DeviceUtils.getDeviceDimensions(this.r);
    return new Point(0, 0);
  }

  public Locale getDeviceLocale()
  {
    return this.r.getResources().getConfiguration().locale;
  }

  public String getDeviceManufacturer()
  {
    return this.j;
  }

  public String getDeviceModel()
  {
    return this.k;
  }

  public String getDeviceOsVersion()
  {
    return this.m;
  }

  public String getDeviceProduct()
  {
    return this.l;
  }

  public int getDeviceScreenHeightDip()
  {
    return Dips.screenHeightAsIntDips(this.r);
  }

  public int getDeviceScreenWidthDip()
  {
    return Dips.screenWidthAsIntDips(this.r);
  }

  public String getIsoCountryCode()
  {
    if (MoPub.canCollectPersonalInformation())
      return this.d;
    return "";
  }

  public MoPubIdentifier getMoPubIdentifier()
  {
    return this.h;
  }

  public String getNetworkOperator()
  {
    return this.b;
  }

  public String getNetworkOperatorForUrl()
  {
    return this.a;
  }

  public String getNetworkOperatorName()
  {
    return this.f;
  }

  public String getOrientationString()
  {
    int i1 = this.r.getResources().getConfiguration().orientation;
    String str = "u";
    if (i1 == 1)
      str = "p";
    do
    {
      return str;
      if (i1 == 2)
        return "l";
    }
    while (i1 != 3);
    return "s";
  }

  public String getSdkVersion()
  {
    return this.n;
  }

  public String getSimIsoCountryCode()
  {
    if (MoPub.canCollectPersonalInformation())
      return this.e;
    return "";
  }

  public String getSimOperator()
  {
    return this.c;
  }

  public String getSimOperatorName()
  {
    return this.g;
  }

  public void repopulateCountryData()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)this.r.getSystemService("phone");
    if ((MoPub.canCollectPersonalInformation()) && (localTelephonyManager != null))
    {
      this.d = localTelephonyManager.getNetworkCountryIso();
      this.e = localTelephonyManager.getSimCountryIso();
    }
  }

  public static enum MoPubNetworkType
  {
    private final int a;

    static
    {
      ETHERNET = new MoPubNetworkType("ETHERNET", 1, 1);
      WIFI = new MoPubNetworkType("WIFI", 2, 2);
      MOBILE = new MoPubNetworkType("MOBILE", 3, 3);
      GG = new MoPubNetworkType("GG", 4, 4);
      GGG = new MoPubNetworkType("GGG", 5, 5);
      GGGG = new MoPubNetworkType("GGGG", 6, 6);
      MoPubNetworkType[] arrayOfMoPubNetworkType = new MoPubNetworkType[7];
      arrayOfMoPubNetworkType[0] = UNKNOWN;
      arrayOfMoPubNetworkType[1] = ETHERNET;
      arrayOfMoPubNetworkType[2] = WIFI;
      arrayOfMoPubNetworkType[3] = MOBILE;
      arrayOfMoPubNetworkType[4] = GG;
      arrayOfMoPubNetworkType[5] = GGG;
      arrayOfMoPubNetworkType[6] = GGGG;
    }

    private MoPubNetworkType(int paramInt)
    {
      this.a = paramInt;
    }

    public int getId()
    {
      return this.a;
    }

    public String toString()
    {
      return Integer.toString(this.a);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.ClientMetadata
 * JD-Core Version:    0.6.2
 */
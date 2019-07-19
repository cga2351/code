package com.my.target;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class ak extends al
{
  private boolean a = true;
  private boolean b = true;

  private static boolean b(String paramString, Context paramContext)
  {
    int i = -1;
    try
    {
      int j = paramContext.checkCallingOrSelfPermission(paramString);
      i = j;
      if (i == 0)
        return true;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        dp.a("unable to check " + paramString + " permission! Unexpected throwable in Context.checkCallingOrSelfPermission() method: " + localThrowable.getMessage());
    }
    return false;
  }

  private static boolean c(Context paramContext)
  {
    return (b("android.permission.ACCESS_FINE_LOCATION", paramContext)) || (b("android.permission.ACCESS_COARSE_LOCATION", paramContext));
  }

  @SuppressLint({"MissingPermission"})
  private void d(Context paramContext)
  {
    float f1 = 3.4028235E+38F;
    long l1 = 0L;
    Object localObject1 = null;
    Object localObject2 = null;
    LocationManager localLocationManager = (LocationManager)paramContext.getSystemService("location");
    if (localLocationManager == null);
    do
    {
      return;
      Iterator localIterator = localLocationManager.getAllProviders().iterator();
      while (true)
        if (localIterator.hasNext())
        {
          Object localObject3 = (String)localIterator.next();
          try
          {
            Location localLocation = localLocationManager.getLastKnownLocation((String)localObject3);
            if (localLocation != null)
            {
              dp.a("locationProvider: " + (String)localObject3);
              float f3 = localLocation.getAccuracy();
              long l3 = localLocation.getTime();
              if ((localObject1 == null) || ((l3 > l1) && (f3 < f1)))
              {
                localObject4 = localLocation;
                f2 = f3;
                l2 = l3;
                l1 = l2;
                f1 = f2;
                localObject1 = localObject4;
                localObject2 = localObject3;
              }
            }
          }
          catch (SecurityException localSecurityException)
          {
            while (true)
            {
              dp.a("No permissions for get geo data");
              localObject3 = localObject2;
              Object localObject4 = localObject1;
              float f2 = f1;
              long l2 = l1;
            }
          }
        }
    }
    while (localObject1 == null);
    a("location", localObject1.getLatitude() + "," + localObject1.getLongitude() + "," + localObject1.getAccuracy() + "," + localObject1.getSpeed() + "," + l1 / 1000L);
    a("location_provider", localObject2);
    dp.a("location: " + localObject1.getLatitude() + ", " + localObject1.getLongitude() + " accuracy = " + localObject1.getAccuracy() + " speed = " + localObject1.getSpeed() + " time = " + l1 / 1000L + "  provider: " + localObject2);
  }

  @SuppressLint({"HardwareIds"})
  private void e(Context paramContext)
  {
    c localc = new c(paramContext);
    if (localc.a != null)
    {
      WifiInfo localWifiInfo = localc.a;
      String str3 = localWifiInfo.getBSSID();
      if (str3 == null)
        str3 = "";
      int k = localWifiInfo.getLinkSpeed();
      int m = localWifiInfo.getNetworkId();
      int n = localWifiInfo.getRssi();
      String str4 = localWifiInfo.getSSID();
      if (str4 == null)
        str4 = "";
      a("wifi", str3 + "," + str4 + "," + n + "," + m + "," + k);
      dp.a("mac: " + localWifiInfo.getMacAddress());
      dp.a("ip: " + localWifiInfo.getIpAddress());
      dp.a("wifi: " + str3 + "," + str4 + "," + n + "," + m + "," + k);
    }
    int i;
    if (localc.b != null)
    {
      Iterator localIterator = localc.b.iterator();
      i = 1;
      if (localIterator.hasNext())
      {
        ScanResult localScanResult = (ScanResult)localIterator.next();
        if (i >= 6)
          break label490;
        dp.a(localScanResult.level + "");
        String str1 = localScanResult.BSSID;
        if (str1 == null)
          str1 = "";
        String str2 = localScanResult.SSID;
        if (str2 == null)
          str2 = "";
        a("wifi" + i, str1 + "," + str2 + "," + localScanResult.level);
        dp.a("wifi" + i + ": " + str1 + "," + str2 + "," + localScanResult.level);
      }
    }
    label490: for (int j = i + 1; ; j = i)
    {
      i = j;
      break;
      return;
    }
  }

  private void f(Context paramContext)
  {
    a locala = new a(paramContext);
    if (a.a(locala) != null)
    {
      int i = 0;
      if (i < a.a(locala).size())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        b localb = (b)a.a(locala).get(i);
        label231: StringBuilder localStringBuilder2;
        if (!"cdma".equals(localb.a))
        {
          localStringBuilder1.append(localb.a).append(",").append(localb.b).append(",").append(localb.c).append(",").append(localb.d).append(",").append(localb.e).append(",").append(localb.f).append(",").append(localb.g).append(",").append(localb.h).append(",").append(localb.i).append(",").append(localb.j).append(",").append(localb.k).append(",").append(localb.l).append(",").append(localb.m);
          localStringBuilder2 = new StringBuilder().append("cell");
          if (i == 0)
            break label478;
        }
        label478: for (Object localObject = Integer.valueOf(i); ; localObject = "")
        {
          a(localObject, localStringBuilder1.toString());
          i++;
          break;
          localStringBuilder1.append(localb.n).append(",").append(localb.o).append(",").append(localb.p).append(",").append(localb.q).append(",").append(localb.r).append(",").append(localb.s).append(",").append(localb.f).append(",").append(localb.t).append(",").append(localb.h).append(",").append(localb.u).append(",").append(localb.g).append(",").append(localb.v).append(",").append(localb.w).append(",").append(localb.x).append(",").append(localb.y);
          break label231;
        }
      }
    }
  }

  public void a(Context paramContext)
  {
    try
    {
      b();
      boolean bool = this.a;
      if (!bool);
      while (true)
      {
        return;
        if ((b("android.permission.ACCESS_FINE_LOCATION", paramContext)) || (b("android.permission.ACCESS_COARSE_LOCATION", paramContext)))
          d(paramContext);
        if (this.b)
        {
          if (b("android.permission.ACCESS_WIFI_STATE", paramContext))
            e(paramContext);
          if (b("android.permission.ACCESS_COARSE_LOCATION", paramContext))
            f(paramContext);
        }
      }
    }
    finally
    {
    }
  }

  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public void b(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  private static class a
  {
    private String a;
    private ArrayList<ak.b> b = null;

    a(Context paramContext)
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (localTelephonyManager == null);
      while (true)
      {
        return;
        try
        {
          if ((Build.VERSION.SDK_INT >= 17) && (ak.a("android.permission.ACCESS_COARSE_LOCATION", paramContext)))
            this.b = b(localTelephonyManager);
          if (((this.b == null) || (this.b.isEmpty())) && ((ak.a("android.permission.ACCESS_FINE_LOCATION", paramContext)) || (ak.a("android.permission.ACCESS_COARSE_LOCATION", paramContext))))
          {
            this.b = a(localTelephonyManager);
            return;
          }
        }
        catch (Exception localException)
        {
          dp.a("Environment provider exception " + localException.getMessage());
        }
      }
    }

    @SuppressLint({"MissingPermission"})
    private ArrayList<ak.b> a(TelephonyManager paramTelephonyManager)
    {
      CellLocation localCellLocation = paramTelephonyManager.getCellLocation();
      if ((localCellLocation != null) && ((localCellLocation instanceof GsmCellLocation)))
      {
        ArrayList localArrayList = new ArrayList();
        GsmCellLocation localGsmCellLocation = (GsmCellLocation)localCellLocation;
        ak.b localb = new ak.b("gsm");
        localArrayList.add(localb);
        localb.b = localGsmCellLocation.getCid();
        localb.c = localGsmCellLocation.getLac();
        this.a = paramTelephonyManager.getNetworkOperator();
        if (!TextUtils.isEmpty(this.a));
        try
        {
          localb.d = Integer.parseInt(this.a.substring(0, 3));
          localb.e = Integer.parseInt(this.a.substring(3));
          dp.a("current cell: " + localb.b + "," + localb.c + "," + localb.d + "," + localb.e);
          return localArrayList;
        }
        catch (Exception localException)
        {
          while (true)
            dp.a("unable to substring network operator " + this.a);
        }
      }
      return null;
    }

    @SuppressLint({"MissingPermission"})
    @TargetApi(17)
    private ArrayList<ak.b> b(TelephonyManager paramTelephonyManager)
    {
      List localList = paramTelephonyManager.getAllCellInfo();
      Object localObject1 = null;
      if (localList != null)
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          CellInfo localCellInfo = (CellInfo)localIterator.next();
          if (localCellInfo.isRegistered())
          {
            Object localObject2;
            if ((localCellInfo instanceof CellInfoLte))
            {
              ak.b localb1 = new ak.b("lte");
              CellIdentityLte localCellIdentityLte = ((CellInfoLte)localCellInfo).getCellIdentity();
              CellSignalStrengthLte localCellSignalStrengthLte = ((CellInfoLte)localCellInfo).getCellSignalStrength();
              localb1.b = localCellIdentityLte.getCi();
              localb1.c = 2147483647;
              localb1.d = localCellIdentityLte.getMcc();
              localb1.e = localCellIdentityLte.getMnc();
              localb1.f = localCellSignalStrengthLte.getLevel();
              localb1.g = localCellSignalStrengthLte.getDbm();
              localb1.h = localCellSignalStrengthLte.getAsuLevel();
              localb1.i = localCellSignalStrengthLte.getTimingAdvance();
              if (Build.VERSION.SDK_INT >= 24)
                localb1.j = localCellIdentityLte.getEarfcn();
              localb1.k = 2147483647;
              localb1.l = 2147483647;
              localb1.m = localCellIdentityLte.getTac();
              localObject2 = localb1;
            }
            while (true)
            {
              localArrayList.add(localObject2);
              break;
              if ((localCellInfo instanceof CellInfoGsm))
              {
                ak.b localb2 = new ak.b("gsm");
                CellIdentityGsm localCellIdentityGsm = ((CellInfoGsm)localCellInfo).getCellIdentity();
                CellSignalStrengthGsm localCellSignalStrengthGsm = ((CellInfoGsm)localCellInfo).getCellSignalStrength();
                localb2.b = localCellIdentityGsm.getCid();
                localb2.c = localCellIdentityGsm.getLac();
                localb2.d = localCellIdentityGsm.getMcc();
                localb2.e = localCellIdentityGsm.getMnc();
                localb2.f = localCellSignalStrengthGsm.getLevel();
                localb2.g = localCellSignalStrengthGsm.getDbm();
                localb2.h = localCellSignalStrengthGsm.getAsuLevel();
                if (Build.VERSION.SDK_INT >= 26);
                for (localb2.i = localCellSignalStrengthGsm.getTimingAdvance(); ; localb2.i = 2147483647)
                {
                  localb2.j = 2147483647;
                  if (Build.VERSION.SDK_INT >= 24)
                    localb2.k = localCellIdentityGsm.getBsic();
                  localb2.l = localCellIdentityGsm.getPsc();
                  localb2.m = 2147483647;
                  localObject2 = localb2;
                  break;
                }
              }
              if ((Build.VERSION.SDK_INT >= 18) && ((localCellInfo instanceof CellInfoWcdma)))
              {
                ak.b localb4 = new ak.b("wcdma");
                CellIdentityWcdma localCellIdentityWcdma = ((CellInfoWcdma)localCellInfo).getCellIdentity();
                CellSignalStrengthWcdma localCellSignalStrengthWcdma = ((CellInfoWcdma)localCellInfo).getCellSignalStrength();
                localb4.b = localCellIdentityWcdma.getCid();
                localb4.c = localCellIdentityWcdma.getLac();
                localb4.d = localCellIdentityWcdma.getMcc();
                localb4.e = localCellIdentityWcdma.getMnc();
                localb4.f = localCellSignalStrengthWcdma.getLevel();
                localb4.g = localCellSignalStrengthWcdma.getDbm();
                localb4.h = localCellSignalStrengthWcdma.getAsuLevel();
                localb4.i = 2147483647;
                if (Build.VERSION.SDK_INT >= 24)
                  localb4.j = localCellIdentityWcdma.getUarfcn();
                localb4.k = 2147483647;
                localb4.l = localCellIdentityWcdma.getPsc();
                localb4.m = 2147483647;
                localObject2 = localb4;
              }
              else
              {
                if (!(localCellInfo instanceof CellInfoCdma))
                  break;
                ak.b localb3 = new ak.b("cdma");
                CellIdentityCdma localCellIdentityCdma = ((CellInfoCdma)localCellInfo).getCellIdentity();
                CellSignalStrengthCdma localCellSignalStrengthCdma = ((CellInfoCdma)localCellInfo).getCellSignalStrength();
                localb3.n = localCellIdentityCdma.getNetworkId();
                localb3.o = localCellIdentityCdma.getSystemId();
                localb3.p = localCellIdentityCdma.getBasestationId();
                localb3.q = localCellIdentityCdma.getLatitude();
                localb3.r = localCellIdentityCdma.getLongitude();
                localb3.s = localCellSignalStrengthCdma.getCdmaLevel();
                localb3.f = localCellSignalStrengthCdma.getLevel();
                localb3.t = localCellSignalStrengthCdma.getEvdoLevel();
                localb3.h = localCellSignalStrengthCdma.getAsuLevel();
                localb3.u = localCellSignalStrengthCdma.getCdmaDbm();
                localb3.g = localCellSignalStrengthCdma.getDbm();
                localb3.v = localCellSignalStrengthCdma.getEvdoDbm();
                localb3.w = localCellSignalStrengthCdma.getEvdoEcio();
                localb3.x = localCellSignalStrengthCdma.getCdmaEcio();
                localb3.y = localCellSignalStrengthCdma.getEvdoSnr();
                localObject2 = localb3;
              }
            }
          }
        }
        localObject1 = localArrayList;
      }
      return localObject1;
    }
  }

  private static class b
  {
    public final String a;
    int b = 2147483647;
    int c = 2147483647;
    int d = 2147483647;
    int e = 2147483647;
    int f = 2147483647;
    int g = 2147483647;
    int h = 2147483647;
    int i = 2147483647;
    int j = 2147483647;
    int k = 2147483647;
    int l = 2147483647;
    int m = 2147483647;
    int n = 2147483647;
    int o = 2147483647;
    int p = 2147483647;
    int q = 2147483647;
    int r = 2147483647;
    int s = 2147483647;
    int t = 2147483647;
    int u = 2147483647;
    int v = 2147483647;
    int w = 2147483647;
    int x = 2147483647;
    int y = 2147483647;

    b(String paramString)
    {
      this.a = paramString;
    }
  }

  private static class c
  {
    WifiInfo a;
    List<ScanResult> b;

    @SuppressLint({"MissingPermission"})
    c(Context paramContext)
    {
      try
      {
        WifiManager localWifiManager = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
        if (localWifiManager == null)
          return;
        if (localWifiManager.isWifiEnabled())
        {
          this.a = localWifiManager.getConnectionInfo();
          if ((Build.VERSION.SDK_INT < 24) || (ak.b(paramContext)))
            this.b = localWifiManager.getScanResults();
          if (this.b != null)
          {
            Collections.sort(this.b, new Comparator()
            {
              public int a(ScanResult paramAnonymousScanResult1, ScanResult paramAnonymousScanResult2)
              {
                if (paramAnonymousScanResult1.level < paramAnonymousScanResult2.level)
                  return 1;
                if (paramAnonymousScanResult1.level > paramAnonymousScanResult2.level)
                  return -1;
                return 0;
              }
            });
            return;
          }
        }
      }
      catch (SecurityException localSecurityException)
      {
        dp.a("No permissions for access to wifi state");
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.ak
 * JD-Core Version:    0.6.2
 */
package com.appnexus.opensdk.ut;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.appnexus.opensdk.ANClickThroughAction;
import com.appnexus.opensdk.ANGDPRSettings;
import com.appnexus.opensdk.AdSize;
import com.appnexus.opensdk.AdView.GENDER;
import com.appnexus.opensdk.MediaType;
import com.appnexus.opensdk.R.string;
import com.appnexus.opensdk.SDKSettings;
import com.appnexus.opensdk.TargetingParameters;
import com.appnexus.opensdk.utils.AdvertisingIDUtil;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.Settings;
import com.appnexus.opensdk.utils.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UTRequestParameters
{
  private MediaType a;
  private String b;
  private String c;
  private int d;
  private String e;
  private boolean f = true;
  private AdSize g;
  private ArrayList<AdSize> h = new ArrayList();
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private float m = 0.0F;
  private String n;
  private AdView.GENDER o = AdView.GENDER.UNKNOWN;
  private ArrayList<Pair<String, String>> p = new ArrayList();
  private int q;
  private int r;
  private int s = 0;
  private ANClickThroughAction t = ANClickThroughAction.OPEN_SDK_BROWSER;
  private String u = "ansdk";
  private Context v;
  private String w;

  public UTRequestParameters(Context paramContext)
  {
    this.v = paramContext;
  }

  private JSONArray a(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray1 = new JSONArray();
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray2;
    while (true)
    {
      try
      {
        if ((StringUtil.isEmpty(getInvCode())) || (getMemberID() <= 0))
          break label270;
        localJSONObject1.put("code", getInvCode());
        paramJSONObject.put("member_id", getMemberID());
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("width", this.g.width());
        localJSONObject2.put("height", this.g.height());
        localJSONObject1.put("primary_size", localJSONObject2);
        if (this.s > 0)
          localJSONObject1.put("force_creative_id", this.s);
        ArrayList localArrayList = getSizes();
        localJSONArray2 = new JSONArray();
        if ((localArrayList == null) || (localArrayList.size() <= 0))
          break;
        Iterator localIterator = localArrayList.iterator();
        if (!localIterator.hasNext())
          break;
        AdSize localAdSize = (AdSize)localIterator.next();
        JSONObject localJSONObject4 = new JSONObject();
        localJSONObject4.put("width", localAdSize.width());
        localJSONObject4.put("height", localAdSize.height());
        localJSONArray2.put(localJSONObject4);
        continue;
      }
      catch (JSONException localJSONException)
      {
        Clog.e(Clog.baseLogTag, "Exception: " + localJSONException.getMessage());
      }
      if (localJSONObject1.length() > 0)
        localJSONArray1.put(localJSONObject1);
      return localJSONArray1;
      label270: if (!StringUtil.isEmpty(getPlacementID()))
        localJSONObject1.put("id", StringUtil.getIntegerValue(getPlacementID()));
      else
        localJSONObject1.put("id", 0);
    }
    localJSONObject1.put("sizes", localJSONArray2);
    localJSONObject1.put("allow_smaller_sizes", getAllowSmallerSizes());
    JSONArray localJSONArray3 = new JSONArray();
    if (getMediaType() == MediaType.BANNER)
    {
      localJSONArray3.put(1);
      if (this.k)
        localJSONArray3.put(4);
      if (this.l)
        localJSONArray3.put(12);
    }
    while (true)
    {
      localJSONObject1.put("allowed_media_types", localJSONArray3);
      if (getMediaType() == MediaType.INSTREAM_VIDEO)
      {
        JSONObject localJSONObject3 = e();
        if (localJSONObject3.length() > 0)
          localJSONObject1.put("video", localJSONObject3);
      }
      localJSONObject1.put("prebid", false);
      if (getReserve() <= 0.0F)
        break label541;
      localJSONObject1.put("reserve", getReserve());
      localJSONObject1.put("disable_psa", true);
      localJSONObject1.put("require_asset_url", false);
      break;
      if (getMediaType() == MediaType.INTERSTITIAL)
      {
        localJSONArray3.put(1);
        localJSONArray3.put(3);
      }
      else if (getMediaType() == MediaType.NATIVE)
      {
        localJSONArray3.put(12);
      }
      else if (getMediaType() == MediaType.INSTREAM_VIDEO)
      {
        localJSONArray3.put(4);
      }
    }
    label541: if (!getShouldServePSAs());
    for (boolean bool = true; ; bool = false)
    {
      localJSONObject1.put("disable_psa", bool);
      break;
    }
  }

  private boolean a(String paramString1, String paramString2, JSONArray paramJSONArray)
    throws JSONException
  {
    for (int i1 = 0; ; i1++)
    {
      int i2 = paramJSONArray.length();
      boolean bool = false;
      if (i1 < i2)
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i1);
        if (localJSONObject.getString("key").equalsIgnoreCase(paramString1))
        {
          localJSONObject.getJSONArray("value").put(paramString2);
          bool = true;
        }
      }
      else
      {
        return bool;
      }
    }
  }

  private JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (StringUtil.getIntegerValue(getAge()) > 0)
        localJSONObject.put("age", StringUtil.getIntegerValue(getAge()));
      AdView.GENDER localGENDER = getGender();
      int i1 = 1.a[localGENDER.ordinal()];
      int i2 = 0;
      switch (i1)
      {
      case 3:
      default:
      case 1:
      case 2:
      }
      while (true)
      {
        localJSONObject.put("gender", i2);
        if (!StringUtil.isEmpty(Settings.getSettings().language))
          localJSONObject.put("language", Settings.getSettings().language);
        if (!StringUtil.isEmpty(getExternalUid()))
          localJSONObject.put("external_uid", getExternalUid());
        return localJSONObject;
        i2 = 2;
        continue;
        i2 = 1;
      }
    }
    catch (JSONException localJSONException)
    {
    }
    return localJSONObject;
  }

  private JSONObject c()
  {
    JSONObject localJSONObject1 = new JSONObject();
    while (true)
    {
      Object localObject1;
      Object localObject4;
      try
      {
        if (!StringUtil.isEmpty(Settings.getSettings().deviceMake))
          localJSONObject1.put("make", Settings.getSettings().deviceMake);
        if (!StringUtil.isEmpty(Settings.getSettings().deviceModel))
          localJSONObject1.put("model", Settings.getSettings().deviceModel);
        Context localContext = getContext();
        TelephonyManager localTelephonyManager;
        String str1;
        if (localContext != null)
        {
          if (!StringUtil.isEmpty(Settings.getSettings().ua))
            localJSONObject1.put("useragent", Settings.getSettings().ua);
          localTelephonyManager = (TelephonyManager)localContext.getSystemService("phone");
          if ((Settings.getSettings().mcc == null) || (Settings.getSettings().mnc == null))
          {
            str1 = localTelephonyManager.getNetworkOperator();
            boolean bool = StringUtil.isEmpty(str1);
            if (bool);
          }
        }
        try
        {
          Settings.getSettings().mcc = str1.substring(0, 3);
          Settings.getSettings().mnc = str1.substring(3);
          if ((Settings.getSettings().mcc != null) && (Settings.getSettings().mnc != null))
          {
            localJSONObject1.put("mnc", StringUtil.getIntegerValue(Settings.getSettings().mnc));
            localJSONObject1.put("mcc", StringUtil.getIntegerValue(Settings.getSettings().mcc));
          }
          String str2 = Settings.getSettings().carrierName;
          if (str2 != null);
        }
        catch (Exception localException)
        {
          try
          {
            Settings.getSettings().carrierName = localTelephonyManager.getNetworkOperatorName();
            if (!StringUtil.isEmpty(Settings.getSettings().carrierName))
              localJSONObject1.put("carrier", Settings.getSettings().carrierName);
            ConnectivityManager localConnectivityManager = (ConnectivityManager)localContext.getSystemService("connectivity");
            NetworkInfo localNetworkInfo1 = localConnectivityManager.getActiveNetworkInfo();
            if ((localNetworkInfo1 == null) || (!localNetworkInfo1.isConnected()))
              continue;
            NetworkInfo localNetworkInfo2 = localConnectivityManager.getNetworkInfo(1);
            if (localNetworkInfo2 == null)
              continue;
            if (!localNetworkInfo2.isConnected())
              break label962;
            i1 = 1;
            localJSONObject1.put("connectiontype", i1);
            Location localLocation = SDKSettings.getLocation();
            if (!SDKSettings.getLocationEnabled())
              break label989;
            if (localLocation != null)
            {
              localObject2 = localLocation;
              if (localLocation != localObject2)
                SDKSettings.setLocation((Location)localObject2);
              if (localObject2 == null)
                continue;
              if (SDKSettings.getLocationDecimalDigits() > -1)
                continue;
              localDouble1 = Double.valueOf(((Location)localObject2).getLatitude());
              localObject3 = Double.valueOf(((Location)localObject2).getLongitude());
              localInteger1 = Integer.valueOf(Math.round(((Location)localObject2).getAccuracy()));
              localInteger2 = Integer.valueOf((int)Math.max(0L, System.currentTimeMillis() - ((Location)localObject2).getTime()));
              JSONObject localJSONObject2 = new JSONObject();
              if ((localDouble1 != null) && (localObject3 != null))
              {
                localJSONObject2.put("lat", localDouble1);
                localJSONObject2.put("lng", localObject3);
                if (localInteger2 != null)
                  localJSONObject2.put("loc_age", localInteger2);
                if (localInteger1 != null)
                  localJSONObject2.put("loc_precision", localInteger1);
              }
              if (localJSONObject2.length() > 0)
                localJSONObject1.put("geo", localJSONObject2);
              localJSONObject1.put("devtime", System.currentTimeMillis());
              localJSONObject1.put("limit_ad_tracking", Settings.getSettings().limitTrackingEnabled);
              if ((!StringUtil.isEmpty(Settings.getSettings().aaid)) && (Settings.getSettings().aaidEnabled))
              {
                JSONObject localJSONObject3 = new JSONObject();
                localJSONObject3.put("aaid", Settings.getSettings().aaid);
                localJSONObject1.put("device_id", localJSONObject3);
              }
              localJSONObject1.put("os", "android");
              return localJSONObject1;
              localException = localException;
              Settings.getSettings().mcc = null;
              Settings.getSettings().mnc = null;
            }
          }
          catch (SecurityException localSecurityException)
          {
            Settings.getSettings().carrierName = "";
            continue;
            if ((localContext != null) && ((localContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) || (localContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)))
            {
              LocationManager localLocationManager = (LocationManager)localContext.getSystemService("location");
              Iterator localIterator = localLocationManager.getProviders(true).iterator();
              localObject1 = null;
              if (!localIterator.hasNext())
                break label982;
              localObject4 = localLocationManager.getLastKnownLocation((String)localIterator.next());
              if (localObject4 == null)
                continue;
              if (localObject1 == null)
                break label968;
              if ((((Location)localObject4).getTime() <= 0L) || (localObject1.getTime() <= 0L))
                break label975;
              if (((Location)localObject4).getTime() > localObject1.getTime())
                break label968;
              break label975;
            }
            Clog.w(Clog.baseLogTag, "Location permissions ACCESS_COARSE_LOCATION and/or ACCESS_FINE_LOCATION are not set in the host app. This may affect demand.");
            break label989;
          }
        }
        Locale localLocale1 = Locale.ENGLISH;
        String str3 = "%." + SDKSettings.getLocationDecimalDigits() + "f";
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Double.valueOf(((Location)localObject2).getLatitude());
        Double localDouble1 = Double.valueOf(Double.parseDouble(String.format(localLocale1, str3, arrayOfObject1)));
        Locale localLocale2 = Locale.ENGLISH;
        String str4 = "%." + SDKSettings.getLocationDecimalDigits() + "f";
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Double.valueOf(((Location)localObject2).getLongitude());
        Double localDouble2 = Double.valueOf(Double.parseDouble(String.format(localLocale2, str4, arrayOfObject2)));
        Object localObject3 = localDouble2;
        continue;
        Integer localInteger1 = null;
        localObject3 = null;
        localDouble1 = null;
        Integer localInteger2 = null;
        continue;
        i1 = 0;
        continue;
      }
      catch (JSONException localJSONException)
      {
        return localJSONObject1;
      }
      label962: int i1 = 2;
      continue;
      while (true)
      {
        label968: localObject1 = localObject4;
        break;
        label975: localObject4 = localObject1;
      }
      label982: Object localObject2 = localObject1;
      continue;
      label989: localObject2 = null;
    }
  }

  private JSONObject d()
  {
    if (StringUtil.isEmpty(Settings.getSettings().app_id))
    {
      Context localContext = getContext();
      if (localContext != null)
        Settings.getSettings().app_id = localContext.getApplicationContext().getPackageName();
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (!StringUtil.isEmpty(Settings.getSettings().app_id))
        localJSONObject.put("appid", Settings.getSettings().app_id);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return localJSONObject;
  }

  private JSONObject e()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.q > 0)
        localJSONObject.put("minduration", this.q);
      if (this.r > 0)
        localJSONObject.put("maxduration", this.r);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return localJSONObject;
  }

  private JSONObject f()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("source", this.u);
      Settings.getSettings().getClass();
      localJSONObject.put("version", "4.11.2");
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return localJSONObject;
  }

  private JSONObject g()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Context localContext = getContext();
      if (localContext != null)
      {
        Boolean localBoolean = ANGDPRSettings.getConsentRequired(localContext);
        if (localBoolean != null)
        {
          localJSONObject.put("consent_required", localBoolean);
          localJSONObject.put("consent_string", ANGDPRSettings.getConsentString(localContext));
        }
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return localJSONObject;
  }

  private JSONArray h()
  {
    JSONArray localJSONArray1 = new JSONArray();
    try
    {
      ArrayList localArrayList = getCustomKeywords();
      if (localArrayList != null)
      {
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          Pair localPair = (Pair)localIterator.next();
          if ((!StringUtil.isEmpty((String)localPair.first)) && (!StringUtil.isEmpty((String)localPair.second)) && (!a((String)localPair.first, (String)localPair.second, localJSONArray1)))
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("key", localPair.first);
            JSONArray localJSONArray2 = new JSONArray();
            localJSONArray2.put(localPair.second);
            localJSONObject.put("value", localJSONArray2);
            localJSONArray1.put(localJSONObject);
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
    }
    return localJSONArray1;
  }

  String a()
  {
    Context localContext = getContext();
    if (localContext == null)
    {
      Clog.e(Clog.baseLogTag, "UTRequestParameters.getPostData() -- context is NULL.");
      return "";
    }
    AdvertisingIDUtil.retrieveAndSetAAID(localContext);
    String str;
    if (localContext.getResources().getConfiguration().orientation == 2)
      str = "h";
    while (true)
    {
      this.w = str;
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        JSONArray localJSONArray1 = a(localJSONObject1);
        if ((localJSONArray1 != null) && (localJSONArray1.length() > 0))
          localJSONObject1.put("tags", localJSONArray1);
        JSONObject localJSONObject2 = b();
        if ((localJSONObject2 != null) && (localJSONObject2.length() > 0))
          localJSONObject1.put("user", localJSONObject2);
        JSONObject localJSONObject3 = c();
        if ((localJSONObject3 != null) && (localJSONObject3.length() > 0))
          localJSONObject1.put("device", localJSONObject3);
        JSONObject localJSONObject4 = d();
        if ((localJSONObject3 != null) && (localJSONObject3.length() > 0))
          localJSONObject1.put("app", localJSONObject4);
        StringBuilder localStringBuilder = new StringBuilder().append(this.u);
        Settings.getSettings().getClass();
        localJSONObject1.put("sdkver", "4.11.2");
        JSONObject localJSONObject5 = f();
        if ((localJSONObject5 != null) && (localJSONObject5.length() > 0))
          localJSONObject1.put("sdk", localJSONObject5);
        localJSONObject1.put("supply_type", "mobile_app");
        JSONArray localJSONArray2 = h();
        if ((localJSONArray2 != null) && (localJSONArray2.length() > 0))
          localJSONObject1.put("keywords", localJSONArray2);
        JSONObject localJSONObject6 = g();
        if ((localJSONObject6 != null) && (localJSONObject6.length() > 0))
          localJSONObject1.put("gdpr_consent", localJSONObject6);
        Clog.i(Clog.httpReqLogTag, "POST data: " + localJSONObject1.toString());
        return localJSONObject1.toString();
        str = "v";
      }
      catch (JSONException localJSONException)
      {
        while (true)
          Clog.e(Clog.httpReqLogTag, "JSONException: " + localJSONException.getMessage());
      }
    }
  }

  public void addCustomKeywords(String paramString1, String paramString2)
  {
    if ((StringUtil.isEmpty(paramString1)) || (paramString2 == null))
      return;
    this.p.add(new Pair(paramString1, paramString2));
  }

  public void clearCustomKeywords()
  {
    this.p.clear();
  }

  public String getAge()
  {
    return this.n;
  }

  public boolean getAllowSmallerSizes()
  {
    return this.i;
  }

  public ANClickThroughAction getClickThroughAction()
  {
    return this.t;
  }

  public Context getContext()
  {
    return this.v;
  }

  public ArrayList<Pair<String, String>> getCustomKeywords()
  {
    return this.p;
  }

  public String getExternalUid()
  {
    return this.c;
  }

  public AdView.GENDER getGender()
  {
    return this.o;
  }

  public String getInvCode()
  {
    return this.e;
  }

  public boolean getLoadsInBackground()
  {
    return this.f;
  }

  public MediaType getMediaType()
  {
    return this.a;
  }

  public int getMemberID()
  {
    return this.d;
  }

  public boolean getOpensNativeBrowser()
  {
    return getClickThroughAction() == ANClickThroughAction.OPEN_DEVICE_BROWSER;
  }

  public String getOrientation()
  {
    return this.w;
  }

  public String getPlacementID()
  {
    return this.b;
  }

  public AdSize getPrimarySize()
  {
    return this.g;
  }

  public float getReserve()
  {
    return this.m;
  }

  public boolean getShouldServePSAs()
  {
    return this.j;
  }

  public ArrayList<AdSize> getSizes()
  {
    return this.h;
  }

  public TargetingParameters getTargetingParameters()
  {
    return new TargetingParameters(this.n, this.o, this.p, SDKSettings.getLocation(), this.c);
  }

  public int getVideoAdMaxDuration()
  {
    return this.r;
  }

  public int getVideoAdMinDuration()
  {
    return this.q;
  }

  public boolean isBannerNativeEnabled()
  {
    return this.l;
  }

  public boolean isBannerVideoEnabled()
  {
    return this.k;
  }

  public boolean isReadyForRequest()
  {
    if (((StringUtil.isEmpty(this.e)) || (this.d <= 0)) && (StringUtil.isEmpty(this.b)))
    {
      Clog.e(Clog.baseLogTag, Clog.getString(R.string.no_identification));
      return false;
    }
    if ((this.g == null) || (this.g.width() <= 0) || (this.g.height() <= 0))
    {
      Clog.e(Clog.baseLogTag, Clog.getString(R.string.no_size_info));
      return false;
    }
    return true;
  }

  public void removeCustomKeyword(String paramString)
  {
    if (StringUtil.isEmpty(paramString));
    while (true)
    {
      return;
      for (int i1 = 0; i1 < this.p.size(); i1++)
        if (((String)((Pair)this.p.get(i1)).first).equals(paramString))
        {
          this.p.remove(i1);
          return;
        }
    }
  }

  public void setAge(String paramString)
  {
    this.n = paramString;
  }

  public void setAllowSmallerSizes(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public void setBannerNativeEnabled(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }

  public void setBannerVideoEnabled(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }

  public void setClickThroughAction(ANClickThroughAction paramANClickThroughAction)
  {
    this.t = paramANClickThroughAction;
  }

  public void setContext(Context paramContext)
  {
    this.v = paramContext;
  }

  public void setExternalUid(String paramString)
  {
    this.c = paramString;
  }

  public void setGender(AdView.GENDER paramGENDER)
  {
    this.o = paramGENDER;
  }

  public void setInventoryCodeAndMemberID(int paramInt, String paramString)
  {
    this.d = paramInt;
    this.e = paramString;
  }

  public void setLoadsInBackground(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public void setMediaType(MediaType paramMediaType)
  {
    this.a = paramMediaType;
  }

  public void setOpensNativeBrowser(boolean paramBoolean)
  {
    if (paramBoolean);
    for (ANClickThroughAction localANClickThroughAction = ANClickThroughAction.OPEN_DEVICE_BROWSER; ; localANClickThroughAction = ANClickThroughAction.OPEN_SDK_BROWSER)
    {
      setClickThroughAction(localANClickThroughAction);
      return;
    }
  }

  public void setPlacementID(String paramString)
  {
    this.b = paramString;
  }

  public void setPrimarySize(AdSize paramAdSize)
  {
    this.g = paramAdSize;
  }

  public void setReserve(float paramFloat)
  {
    this.m = paramFloat;
  }

  public void setShouldServePSAs(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }

  public void setSizes(ArrayList<AdSize> paramArrayList)
  {
    this.h = paramArrayList;
  }

  public void setVideoAdMaxDuration(int paramInt)
  {
    this.r = paramInt;
  }

  public void setVideoAdMinDuration(int paramInt)
  {
    this.q = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.ut.UTRequestParameters
 * JD-Core Version:    0.6.2
 */
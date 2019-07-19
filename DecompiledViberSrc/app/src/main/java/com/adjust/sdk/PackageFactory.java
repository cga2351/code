package com.adjust.sdk;

import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.net.UrlQuerySanitizer.ParameterValuePair;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PackageFactory
{
  private static final String ADJUST_PREFIX = "adjust_";

  public static ActivityPackage buildDeeplinkSdkClickPackage(Uri paramUri, long paramLong, ActivityState paramActivityState, AdjustConfig paramAdjustConfig, a parama, SessionParameters paramSessionParameters)
  {
    if (paramUri == null);
    b localb;
    do
    {
      String str;
      do
      {
        return null;
        str = paramUri.toString();
      }
      while ((str == null) || (str.length() == 0));
      AdjustFactory.getLogger().verbose("Url to parse (%s)", new Object[] { paramUri });
      UrlQuerySanitizer localUrlQuerySanitizer = new UrlQuerySanitizer();
      localUrlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
      localUrlQuerySanitizer.setAllowUnregisteredParamaters(true);
      localUrlQuerySanitizer.parseUrl(str);
      localb = queryStringClickPackageBuilder(localUrlQuerySanitizer.getParameterList(), paramActivityState, paramAdjustConfig, parama, paramSessionParameters);
    }
    while (localb == null);
    localb.f = paramUri.toString();
    localb.g = paramLong;
    return localb.a("deeplink");
  }

  public static ActivityPackage buildInstallReferrerSdkClickPackage(String paramString, long paramLong1, long paramLong2, ActivityState paramActivityState, AdjustConfig paramAdjustConfig, a parama, SessionParameters paramSessionParameters)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return null;
    b localb = new b(paramAdjustConfig, parama, paramActivityState, paramSessionParameters, System.currentTimeMillis());
    if (localb == null)
      return null;
    localb.d = paramString;
    localb.h = paramLong1;
    localb.i = paramLong2;
    return localb.a("install_referrer");
  }

  public static ActivityPackage buildReftagSdkClickPackage(String paramString, long paramLong, ActivityState paramActivityState, AdjustConfig paramAdjustConfig, a parama, SessionParameters paramSessionParameters)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return null;
    b localb;
    try
    {
      String str2 = URLDecoder.decode(paramString, "UTF-8");
      str1 = str2;
      AdjustFactory.getLogger().verbose("Referrer to parse (%s)", new Object[] { str1 });
      UrlQuerySanitizer localUrlQuerySanitizer = new UrlQuerySanitizer();
      localUrlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
      localUrlQuerySanitizer.setAllowUnregisteredParamaters(true);
      localUrlQuerySanitizer.parseQuery(str1);
      localb = queryStringClickPackageBuilder(localUrlQuerySanitizer.getParameterList(), paramActivityState, paramAdjustConfig, parama, paramSessionParameters);
      if (localb == null)
        return null;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
      {
        str1 = "malformed";
        ILogger localILogger3 = AdjustFactory.getLogger();
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = localUnsupportedEncodingException.getMessage();
        localILogger3.error("Referrer decoding failed due to UnsupportedEncodingException. Message: (%s)", arrayOfObject3);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
      {
        str1 = "malformed";
        ILogger localILogger2 = AdjustFactory.getLogger();
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = localIllegalArgumentException.getMessage();
        localILogger2.error("Referrer decoding failed due to IllegalArgumentException. Message: (%s)", arrayOfObject2);
      }
    }
    catch (Exception localException)
    {
      String str1;
      while (true)
      {
        str1 = "malformed";
        ILogger localILogger1 = AdjustFactory.getLogger();
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = localException.getMessage();
        localILogger1.error("Referrer decoding failed. Message: (%s)", arrayOfObject1);
      }
      localb.d = str1;
      localb.g = paramLong;
      localb.e = paramString;
    }
    return localb.a("reftag");
  }

  private static b queryStringClickPackageBuilder(List<UrlQuerySanitizer.ParameterValuePair> paramList, ActivityState paramActivityState, AdjustConfig paramAdjustConfig, a parama, SessionParameters paramSessionParameters)
  {
    if (paramList == null)
      return null;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    AdjustAttribution localAdjustAttribution = new AdjustAttribution();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      UrlQuerySanitizer.ParameterValuePair localParameterValuePair = (UrlQuerySanitizer.ParameterValuePair)localIterator.next();
      readQueryString(localParameterValuePair.mParameter, localParameterValuePair.mValue, localLinkedHashMap, localAdjustAttribution);
    }
    long l = System.currentTimeMillis();
    String str = (String)localLinkedHashMap.remove("reftag");
    if (paramActivityState != null)
      paramActivityState.lastInterval = (l - paramActivityState.lastActivity);
    b localb = new b(paramAdjustConfig, parama, paramActivityState, paramSessionParameters, l);
    localb.a = localLinkedHashMap;
    localb.b = localAdjustAttribution;
    localb.c = str;
    return localb;
  }

  private static boolean readQueryString(String paramString1, String paramString2, Map<String, String> paramMap, AdjustAttribution paramAdjustAttribution)
  {
    if ((paramString1 == null) || (paramString2 == null));
    String str;
    do
    {
      do
        return false;
      while (!paramString1.startsWith("adjust_"));
      str = paramString1.substring("adjust_".length());
    }
    while ((str.length() == 0) || (paramString2.length() == 0));
    if (!tryToSetAttribution(paramAdjustAttribution, str, paramString2))
      paramMap.put(str, paramString2);
    return true;
  }

  private static boolean tryToSetAttribution(AdjustAttribution paramAdjustAttribution, String paramString1, String paramString2)
  {
    if (paramString1.equals("tracker"))
    {
      paramAdjustAttribution.trackerName = paramString2;
      return true;
    }
    if (paramString1.equals("campaign"))
    {
      paramAdjustAttribution.campaign = paramString2;
      return true;
    }
    if (paramString1.equals("adgroup"))
    {
      paramAdjustAttribution.adgroup = paramString2;
      return true;
    }
    if (paramString1.equals("creative"))
    {
      paramAdjustAttribution.creative = paramString2;
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.PackageFactory
 * JD-Core Version:    0.6.2
 */
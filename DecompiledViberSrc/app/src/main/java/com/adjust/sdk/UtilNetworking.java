package com.adjust.sdk;

import android.net.Uri;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public class UtilNetworking
{
  private static String userAgent;

  private static String buildAuthorizationHeader(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
      return null;
    Map localMap = getSignature(paramMap, paramString3, paramString1);
    String str1 = Util.sha256((String)localMap.get("clear_signature"));
    String str2 = (String)localMap.get("fields");
    String str3 = Util.formatString("Signature %s,%s,%s,%s", new Object[] { Util.formatString("secret_id=\"%s\"", new Object[] { paramString2 }), Util.formatString("signature=\"%s\"", new Object[] { str1 }), Util.formatString("algorithm=\"%s\"", new Object[] { "sha256" }), Util.formatString("headers=\"%s\"", new Object[] { str2 }) });
    getLogger().verbose("authorizationHeader: %s", new Object[] { str3 });
    return str3;
  }

  // ERROR //
  private static Uri buildUri(String paramString1, Map<String, String> paramMap, String paramString2)
  {
    // Byte code:
    //   0: new 75	android/net/Uri$Builder
    //   3: dup
    //   4: invokespecial 76	android/net/Uri$Builder:<init>	()V
    //   7: astore_3
    //   8: ldc 78
    //   10: astore 4
    //   12: ldc 80
    //   14: astore 5
    //   16: invokestatic 85	com/adjust/sdk/AdjustFactory:getBaseUrl	()Ljava/lang/String;
    //   19: astore 21
    //   21: aload_2
    //   22: ifnull +24 -> 46
    //   25: new 87	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   32: aload 21
    //   34: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_2
    //   38: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: astore 21
    //   46: new 97	java/net/URL
    //   49: dup
    //   50: aload 21
    //   52: invokespecial 100	java/net/URL:<init>	(Ljava/lang/String;)V
    //   55: astore 22
    //   57: aload 22
    //   59: invokevirtual 103	java/net/URL:getProtocol	()Ljava/lang/String;
    //   62: astore 4
    //   64: aload 22
    //   66: invokevirtual 106	java/net/URL:getAuthority	()Ljava/lang/String;
    //   69: astore 23
    //   71: aload 23
    //   73: astore 7
    //   75: aload 22
    //   77: invokevirtual 109	java/net/URL:getPath	()Ljava/lang/String;
    //   80: astore 24
    //   82: aload 24
    //   84: astore 5
    //   86: aload_3
    //   87: aload 4
    //   89: invokevirtual 113	android/net/Uri$Builder:scheme	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   92: pop
    //   93: aload_3
    //   94: aload 7
    //   96: invokevirtual 116	android/net/Uri$Builder:encodedAuthority	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   99: pop
    //   100: aload_3
    //   101: aload 5
    //   103: invokevirtual 119	android/net/Uri$Builder:path	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   106: pop
    //   107: aload_3
    //   108: aload_0
    //   109: invokevirtual 122	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   112: pop
    //   113: aload_1
    //   114: invokeinterface 126 1 0
    //   119: invokeinterface 132 1 0
    //   124: astore 15
    //   126: aload 15
    //   128: invokeinterface 138 1 0
    //   133: ifeq +87 -> 220
    //   136: aload 15
    //   138: invokeinterface 142 1 0
    //   143: checkcast 144	java/util/Map$Entry
    //   146: astore 19
    //   148: aload_3
    //   149: aload 19
    //   151: invokeinterface 147 1 0
    //   156: checkcast 18	java/lang/String
    //   159: aload 19
    //   161: invokeinterface 150 1 0
    //   166: checkcast 18	java/lang/String
    //   169: invokevirtual 154	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   172: pop
    //   173: goto -47 -> 126
    //   176: astore 6
    //   178: ldc 156
    //   180: astore 7
    //   182: aload 6
    //   184: astore 8
    //   186: invokestatic 61	com/adjust/sdk/UtilNetworking:getLogger	()Lcom/adjust/sdk/ILogger;
    //   189: astore 9
    //   191: iconst_1
    //   192: anewarray 4	java/lang/Object
    //   195: astore 10
    //   197: aload 10
    //   199: iconst_0
    //   200: aload 8
    //   202: invokevirtual 159	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   205: aastore
    //   206: aload 9
    //   208: ldc 161
    //   210: aload 10
    //   212: invokeinterface 164 3 0
    //   217: goto -131 -> 86
    //   220: invokestatic 170	java/lang/System:currentTimeMillis	()J
    //   223: lstore 16
    //   225: aload_3
    //   226: ldc 172
    //   228: getstatic 176	com/adjust/sdk/Util:dateFormatter	Ljava/text/SimpleDateFormat;
    //   231: lload 16
    //   233: invokestatic 182	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   236: invokevirtual 188	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   239: invokevirtual 154	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   242: pop
    //   243: aload_3
    //   244: invokevirtual 192	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   247: areturn
    //   248: astore 8
    //   250: goto -64 -> 186
    //
    // Exception table:
    //   from	to	target	type
    //   16	21	176	java/net/MalformedURLException
    //   25	46	176	java/net/MalformedURLException
    //   46	71	176	java/net/MalformedURLException
    //   75	82	248	java/net/MalformedURLException
  }

  public static ResponseData createGETHttpsURLConnection(ActivityPackage paramActivityPackage, String paramString)
    throws Exception
  {
    try
    {
      HashMap localHashMap = new HashMap(paramActivityPackage.getParameters());
      String str1 = extractAppSecret(localHashMap);
      String str2 = extractSecretId(localHashMap);
      extractEventCallbackId(localHashMap);
      HttpsURLConnection localHttpsURLConnection = AdjustFactory.getHttpsURLConnection(new URL(buildUri(paramActivityPackage.getPath(), localHashMap, paramString).toString()));
      AdjustFactory.getConnectionOptions().applyConnectionOptions(localHttpsURLConnection, paramActivityPackage.getClientSdk());
      String str3 = buildAuthorizationHeader(localHashMap, str1, str2, paramActivityPackage.getActivityKind().toString());
      if (str3 != null)
        localHttpsURLConnection.setRequestProperty("Authorization", str3);
      localHttpsURLConnection.setRequestMethod("GET");
      ResponseData localResponseData = readHttpResponse(localHttpsURLConnection, paramActivityPackage);
      return localResponseData;
    }
    catch (Exception localException)
    {
      throw localException;
    }
  }

  // ERROR //
  public static ResponseData createPOSTHttpsURLConnection(String paramString, ActivityPackage paramActivityPackage, int paramInt)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 97	java/net/URL
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 100	java/net/URL:<init>	(Ljava/lang/String;)V
    //   10: invokestatic 227	com/adjust/sdk/AdjustFactory:getHttpsURLConnection	(Ljava/net/URL;)Ljavax/net/ssl/HttpsURLConnection;
    //   13: astore 7
    //   15: new 198	java/util/HashMap
    //   18: dup
    //   19: aload_1
    //   20: invokevirtual 204	com/adjust/sdk/ActivityPackage:getParameters	()Ljava/util/Map;
    //   23: invokespecial 207	java/util/HashMap:<init>	(Ljava/util/Map;)V
    //   26: astore 8
    //   28: invokestatic 231	com/adjust/sdk/AdjustFactory:getConnectionOptions	()Lcom/adjust/sdk/UtilNetworking$IConnectionOptions;
    //   31: aload 7
    //   33: aload_1
    //   34: invokevirtual 234	com/adjust/sdk/ActivityPackage:getClientSdk	()Ljava/lang/String;
    //   37: invokeinterface 240 3 0
    //   42: aload 8
    //   44: invokestatic 211	com/adjust/sdk/UtilNetworking:extractAppSecret	(Ljava/util/Map;)Ljava/lang/String;
    //   47: astore 9
    //   49: aload 8
    //   51: invokestatic 214	com/adjust/sdk/UtilNetworking:extractSecretId	(Ljava/util/Map;)Ljava/lang/String;
    //   54: astore 10
    //   56: aload 8
    //   58: invokestatic 217	com/adjust/sdk/UtilNetworking:extractEventCallbackId	(Ljava/util/Map;)V
    //   61: aload 8
    //   63: aload 9
    //   65: aload 10
    //   67: aload_1
    //   68: invokevirtual 244	com/adjust/sdk/ActivityPackage:getActivityKind	()Lcom/adjust/sdk/ActivityKind;
    //   71: invokevirtual 247	com/adjust/sdk/ActivityKind:toString	()Ljava/lang/String;
    //   74: invokestatic 249	com/adjust/sdk/UtilNetworking:buildAuthorizationHeader	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 11
    //   79: aload 11
    //   81: ifnull +12 -> 93
    //   84: aload 7
    //   86: ldc 251
    //   88: aload 11
    //   90: invokevirtual 257	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload 7
    //   95: ldc_w 270
    //   98: invokevirtual 262	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   101: aload 7
    //   103: iconst_0
    //   104: invokevirtual 274	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   107: aload 7
    //   109: iconst_1
    //   110: invokevirtual 277	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   113: aload 7
    //   115: iconst_1
    //   116: invokevirtual 280	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   119: new 282	java/io/DataOutputStream
    //   122: dup
    //   123: aload 7
    //   125: invokevirtual 286	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   128: invokespecial 289	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   131: astore 12
    //   133: aload 12
    //   135: aload 8
    //   137: iload_2
    //   138: invokestatic 293	com/adjust/sdk/UtilNetworking:getPostDataString	(Ljava/util/Map;I)Ljava/lang/String;
    //   141: invokevirtual 296	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   144: aload 7
    //   146: aload_1
    //   147: invokestatic 266	com/adjust/sdk/UtilNetworking:readHttpResponse	(Ljavax/net/ssl/HttpsURLConnection;Lcom/adjust/sdk/ActivityPackage;)Lcom/adjust/sdk/ResponseData;
    //   150: astore 13
    //   152: aload 12
    //   154: ifnull +13 -> 167
    //   157: aload 12
    //   159: invokevirtual 299	java/io/DataOutputStream:flush	()V
    //   162: aload 12
    //   164: invokevirtual 302	java/io/DataOutputStream:close	()V
    //   167: aload 13
    //   169: areturn
    //   170: astore 6
    //   172: aload 6
    //   174: athrow
    //   175: astore 4
    //   177: aload_3
    //   178: ifnull +11 -> 189
    //   181: aload_3
    //   182: invokevirtual 299	java/io/DataOutputStream:flush	()V
    //   185: aload_3
    //   186: invokevirtual 302	java/io/DataOutputStream:close	()V
    //   189: aload 4
    //   191: athrow
    //   192: astore 5
    //   194: goto -5 -> 189
    //   197: astore 4
    //   199: aload 12
    //   201: astore_3
    //   202: goto -25 -> 177
    //   205: astore 6
    //   207: aload 12
    //   209: astore_3
    //   210: goto -38 -> 172
    //   213: astore 14
    //   215: aload 13
    //   217: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   2	79	170	java/lang/Exception
    //   84	93	170	java/lang/Exception
    //   93	133	170	java/lang/Exception
    //   2	79	175	finally
    //   84	93	175	finally
    //   93	133	175	finally
    //   172	175	175	finally
    //   181	189	192	java/lang/Exception
    //   133	152	197	finally
    //   133	152	205	java/lang/Exception
    //   157	167	213	java/lang/Exception
  }

  private static String extractAppSecret(Map<String, String> paramMap)
  {
    return (String)paramMap.remove("app_secret");
  }

  private static void extractEventCallbackId(Map<String, String> paramMap)
  {
    paramMap.remove("event_callback_id");
  }

  private static String extractSecretId(Map<String, String> paramMap)
  {
    return (String)paramMap.remove("secret_id");
  }

  private static ILogger getLogger()
  {
    return AdjustFactory.getLogger();
  }

  private static String getPostDataString(Map<String, String> paramMap, int paramInt)
    throws UnsupportedEncodingException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str2 = URLEncoder.encode((String)localEntry.getKey(), "UTF-8");
      String str3 = (String)localEntry.getValue();
      if (str3 != null);
      for (String str4 = URLEncoder.encode(str3, "UTF-8"); ; str4 = "")
      {
        if (localStringBuilder.length() > 0)
          localStringBuilder.append("&");
        localStringBuilder.append(str2);
        localStringBuilder.append("=");
        localStringBuilder.append(str4);
        break;
      }
    }
    long l = System.currentTimeMillis();
    String str1 = Util.dateFormatter.format(Long.valueOf(l));
    localStringBuilder.append("&");
    localStringBuilder.append(URLEncoder.encode("sent_at", "UTF-8"));
    localStringBuilder.append("=");
    localStringBuilder.append(URLEncoder.encode(str1, "UTF-8"));
    if (paramInt > 0)
    {
      localStringBuilder.append("&");
      localStringBuilder.append(URLEncoder.encode("queue_size", "UTF-8"));
      localStringBuilder.append("=");
      localStringBuilder.append(URLEncoder.encode("" + paramInt, "UTF-8"));
    }
    return localStringBuilder.toString();
  }

  private static Map<String, String> getSignature(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    String str1 = (String)paramMap.get("created_at");
    String str2 = getValidIdentifier(paramMap);
    String str3 = (String)paramMap.get(str2);
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("app_secret", paramString2);
    localHashMap1.put("created_at", str1);
    localHashMap1.put("activity_kind", paramString1);
    localHashMap1.put(str2, str3);
    String str4 = "";
    Object localObject1 = "";
    Iterator localIterator = localHashMap1.entrySet().iterator();
    Map.Entry localEntry;
    if (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getValue() == null)
        break label263;
      str4 = str4 + (String)localEntry.getKey() + " ";
    }
    label263: for (Object localObject2 = (String)localObject1 + (String)localEntry.getValue(); ; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      break;
      String str5 = str4.substring(0, -1 + str4.length());
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("clear_signature", localObject1);
      localHashMap2.put("fields", str5);
      return localHashMap2;
    }
  }

  private static String getValidIdentifier(Map<String, String> paramMap)
  {
    if (paramMap.get("gps_adid") != null)
      return "gps_adid";
    if (paramMap.get("fire_adid") != null)
      return "fire_adid";
    if (paramMap.get("android_id") != null)
      return "android_id";
    if (paramMap.get("mac_sha1") != null)
      return "mac_sha1";
    if (paramMap.get("mac_md5") != null)
      return "mac_md5";
    if (paramMap.get("android_uuid") != null)
      return "android_uuid";
    return null;
  }

  private static ResponseData readHttpResponse(HttpsURLConnection paramHttpsURLConnection, ActivityPackage paramActivityPackage)
    throws Exception
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ILogger localILogger = getLogger();
    ResponseData localResponseData = ResponseData.buildResponseData(paramActivityPackage);
    Integer localInteger;
    while (true)
    {
      try
      {
        paramHttpsURLConnection.connect();
        localInteger = Integer.valueOf(paramHttpsURLConnection.getResponseCode());
        if (localInteger.intValue() >= 400)
        {
          localObject2 = paramHttpsURLConnection.getErrorStream();
          BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader((InputStream)localObject2));
          String str1 = localBufferedReader.readLine();
          if (str1 == null)
            break;
          localStringBuffer.append(str1);
          continue;
        }
      }
      catch (Exception localException)
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = localException.getMessage();
        localILogger.error("Failed to read response. (%s)", arrayOfObject1);
        throw localException;
      }
      finally
      {
        if (paramHttpsURLConnection != null)
          paramHttpsURLConnection.disconnect();
      }
      InputStream localInputStream = paramHttpsURLConnection.getInputStream();
      Object localObject2 = localInputStream;
    }
    if (paramHttpsURLConnection != null)
      paramHttpsURLConnection.disconnect();
    String str2 = localStringBuffer.toString();
    localILogger.verbose("Response: %s", new Object[] { str2 });
    if (localInteger.intValue() == 429)
      localILogger.error("Too frequent requests to the endpoint (429)", new Object[0]);
    while (true)
    {
      return localResponseData;
      if ((str2 != null) && (str2.length() != 0))
        try
        {
          JSONObject localJSONObject1 = new JSONObject(str2);
          localJSONObject2 = localJSONObject1;
          if (localJSONObject2 != null)
          {
            localResponseData.jsonResponse = localJSONObject2;
            str3 = localJSONObject2.optString("message", null);
            localResponseData.message = str3;
            localResponseData.timestamp = localJSONObject2.optString("timestamp", null);
            localResponseData.adid = localJSONObject2.optString("adid", null);
            String str4 = localJSONObject2.optString("tracking_state", null);
            if ((str4 != null) && (str4.equals("opted_out")))
              localResponseData.trackingState = TrackingState.OPTED_OUT;
            if (str3 == null)
              str3 = "No message found";
            if ((localInteger != null) && (localInteger.intValue() == 200))
            {
              localILogger.info("%s", new Object[] { str3 });
              localResponseData.success = true;
              return localResponseData;
            }
          }
        }
        catch (JSONException localJSONException)
        {
          String str3;
          while (true)
          {
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = localJSONException.getMessage();
            String str5 = Util.formatString("Failed to parse json response. (%s)", arrayOfObject2);
            localILogger.error(str5, new Object[0]);
            localResponseData.message = str5;
            JSONObject localJSONObject2 = null;
          }
          localILogger.error("%s", new Object[] { str3 });
        }
    }
    return localResponseData;
  }

  public static void setUserAgent(String paramString)
  {
    userAgent = paramString;
  }

  public static abstract interface IConnectionOptions
  {
    public abstract void applyConnectionOptions(HttpsURLConnection paramHttpsURLConnection, String paramString);
  }

  static class a
    implements UtilNetworking.IConnectionOptions
  {
    public void applyConnectionOptions(HttpsURLConnection paramHttpsURLConnection, String paramString)
    {
      paramHttpsURLConnection.setRequestProperty("Client-SDK", paramString);
      paramHttpsURLConnection.setConnectTimeout(60000);
      paramHttpsURLConnection.setReadTimeout(60000);
      if (UtilNetworking.userAgent != null)
        paramHttpsURLConnection.setRequestProperty("User-Agent", UtilNetworking.userAgent);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.UtilNetworking
 * JD-Core Version:    0.6.2
 */
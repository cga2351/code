package com.appnexus.opensdk.ut;

import android.text.TextUtils;
import com.appnexus.opensdk.ANNativeAdResponse;
import com.appnexus.opensdk.MediaType;
import com.appnexus.opensdk.R.string;
import com.appnexus.opensdk.ut.adresponse.BaseAdResponse;
import com.appnexus.opensdk.ut.adresponse.CSMSDKAdResponse;
import com.appnexus.opensdk.ut.adresponse.CSMVASTAdResponse;
import com.appnexus.opensdk.ut.adresponse.RTBHTMLAdResponse;
import com.appnexus.opensdk.ut.adresponse.RTBNativeAdResponse;
import com.appnexus.opensdk.ut.adresponse.RTBVASTAdResponse;
import com.appnexus.opensdk.ut.adresponse.SSMHTMLAdResponse;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.JsonUtil;
import com.appnexus.opensdk.utils.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class UTAdResponse
{
  private boolean a = false;
  private LinkedList<BaseAdResponse> b;
  private String c;
  private int d;
  private int e;
  private int f;
  private MediaType g;
  private String h;

  public UTAdResponse(String paramString1, Map<String, List<String>> paramMap, MediaType paramMediaType, String paramString2)
  {
    if (StringUtil.isEmpty(paramString1))
    {
      Clog.clearLastResponse();
      return;
    }
    this.g = paramMediaType;
    this.h = paramString2;
    Clog.setLastResponse(paramString1);
    Clog.d(Clog.httpRespLogTag, Clog.getString(R.string.response_body, paramString1));
    a(paramMap);
    a(paramString1);
  }

  public UTAdResponse(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  // ERROR //
  private void a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 31	com/appnexus/opensdk/utils/StringUtil:isEmpty	(Ljava/lang/String;)Z
    //   4: ifne +48 -> 52
    //   7: new 71	org/json/JSONObject
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 73	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15: astore_3
    //   16: aload_3
    //   17: ldc 75
    //   19: invokestatic 81	com/appnexus/opensdk/utils/JsonUtil:getJSONArray	(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONArray;
    //   22: astore 5
    //   24: aload 5
    //   26: ifnull +25 -> 51
    //   29: aload 5
    //   31: iconst_0
    //   32: invokestatic 85	com/appnexus/opensdk/utils/JsonUtil:getJSONObjectFromArray	(Lorg/json/JSONArray;I)Lorg/json/JSONObject;
    //   35: astore 6
    //   37: aload 6
    //   39: ldc 87
    //   41: invokestatic 91	com/appnexus/opensdk/utils/JsonUtil:getJSONBoolean	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   44: istore 7
    //   46: iload 7
    //   48: ifeq +45 -> 93
    //   51: return
    //   52: getstatic 47	com/appnexus/opensdk/utils/Clog:httpRespLogTag	Ljava/lang/String;
    //   55: new 93	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   62: ldc 96
    //   64: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_1
    //   68: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 106	com/appnexus/opensdk/utils/Clog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: return
    //   78: astore_2
    //   79: getstatic 47	com/appnexus/opensdk/utils/Clog:httpRespLogTag	Ljava/lang/String;
    //   82: getstatic 109	com/appnexus/opensdk/R$string:response_json_error	I
    //   85: aload_1
    //   86: invokestatic 56	com/appnexus/opensdk/utils/Clog:getString	(ILjava/lang/String;)Ljava/lang/String;
    //   89: invokestatic 106	com/appnexus/opensdk/utils/Clog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: return
    //   93: aload_0
    //   94: aload 6
    //   96: invokespecial 112	com/appnexus/opensdk/ut/UTAdResponse:a	(Lorg/json/JSONObject;)V
    //   99: return
    //   100: astore 4
    //   102: getstatic 47	com/appnexus/opensdk/utils/Clog:httpRespLogTag	Ljava/lang/String;
    //   105: new 93	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   112: ldc 114
    //   114: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload 4
    //   119: invokevirtual 117	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   122: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 106	com/appnexus/opensdk/utils/Clog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: return
    //
    // Exception table:
    //   from	to	target	type
    //   0	16	78	org/json/JSONException
    //   52	77	78	org/json/JSONException
    //   16	24	100	java/lang/Exception
    //   29	46	100	java/lang/Exception
    //   93	99	100	java/lang/Exception
  }

  private void a(Map<String, List<String>> paramMap)
  {
    if (paramMap != null)
    {
      Iterator localIterator1 = paramMap.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        if (localEntry.getKey() != null)
        {
          Iterator localIterator2 = ((List)localEntry.getValue()).iterator();
          while (localIterator2.hasNext())
          {
            String str = (String)localIterator2.next();
            if (!TextUtils.isEmpty(str))
              Clog.v(Clog.httpRespLogTag, Clog.getString(R.string.response_header, (String)localEntry.getKey(), str));
          }
        }
      }
    }
  }

  private void a(JSONObject paramJSONObject)
    throws Exception
  {
    this.c = JsonUtil.getJSONString(paramJSONObject, "no_ad_url");
    this.d = JsonUtil.getJSONInt(paramJSONObject, "tag_id");
    this.e = JsonUtil.getJSONInt(paramJSONObject, "auction_id");
    this.f = JsonUtil.getJSONInt(paramJSONObject, "timeout_ms");
    JSONArray localJSONArray = JsonUtil.getJSONArray(paramJSONObject, "ads");
    if (localJSONArray != null)
    {
      this.b = new LinkedList();
      int i = 0;
      if (i < localJSONArray.length())
      {
        JSONObject localJSONObject = JsonUtil.getJSONObjectFromArray(localJSONArray, i);
        String str1 = JsonUtil.getJSONString(localJSONObject, "ad_type");
        String str2 = JsonUtil.getJSONString(localJSONObject, "notify_url");
        String str3 = JsonUtil.getJSONString(localJSONObject, "content_source");
        String str4 = JsonUtil.getJSONString(localJSONObject, "creative_id");
        if ((str3 != null) && (str3.equalsIgnoreCase("csm")))
          c(localJSONObject, str1, str2, str4);
        while (true)
        {
          i++;
          break;
          if ((str3 != null) && (str3.equalsIgnoreCase("ssm")))
            d(localJSONObject, str1, str4);
          else if ((str3 != null) && (str3.equalsIgnoreCase("rtb")))
            a(localJSONObject, str1, str2, str4);
          else
            Clog.e(Clog.httpRespLogTag, "handleAdResponse unknown content_source");
        }
      }
    }
  }

  private void a(JSONObject paramJSONObject, String paramString1, String paramString2)
    throws Exception
  {
    JSONObject localJSONObject = JsonUtil.getJSONObject(paramJSONObject, "banner");
    int i;
    int j;
    String str;
    if (localJSONObject != null)
    {
      i = JsonUtil.getJSONInt(localJSONObject, "height");
      j = JsonUtil.getJSONInt(localJSONObject, "width");
      str = JsonUtil.getJSONString(localJSONObject, "content");
      if (StringUtil.isEmpty(str))
        Clog.e(Clog.httpRespLogTag, Clog.getString(R.string.blank_ad));
    }
    else
    {
      return;
    }
    RTBHTMLAdResponse localRTBHTMLAdResponse = new RTBHTMLAdResponse(j, i, paramString1, b(paramJSONObject), paramString2);
    localRTBHTMLAdResponse.setAdContent(str);
    localRTBHTMLAdResponse.setContentSource("rtb");
    if (str.contains("mraid.js"))
      localRTBHTMLAdResponse.addToExtras("MRAID", Boolean.valueOf(true));
    localRTBHTMLAdResponse.addToExtras("ORIENTATION", this.h);
    this.b.add(localRTBHTMLAdResponse);
    Clog.d(Clog.httpRespLogTag, "Html response parsed");
  }

  private void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
    throws Exception
  {
    JSONObject localJSONObject1 = JsonUtil.getJSONObject(paramJSONObject, "rtb");
    if (localJSONObject1 != null)
    {
      if (localJSONObject1.has("banner"))
      {
        Clog.i(Clog.httpRespLogTag, "it's an HTML Ad");
        a(localJSONObject1, paramString1, paramString3);
      }
    }
    else
      return;
    if (localJSONObject1.has("video"))
    {
      Clog.i(Clog.httpRespLogTag, "it's a Video Ad");
      b(localJSONObject1, paramString1, paramString2, paramString3);
      return;
    }
    if (localJSONObject1.has("native"))
    {
      JSONObject localJSONObject2 = JsonUtil.getJSONObject(localJSONObject1, "native");
      if (localJSONObject2 != null)
      {
        Clog.i(Clog.httpRespLogTag, "it's a NATIVE Ad");
        b(localJSONObject2, paramString3, paramString1);
        return;
      }
      Clog.i(Clog.httpRespLogTag, "NATIVE Ad is empty");
      return;
    }
    Clog.e(Clog.httpRespLogTag, "handleRTB UNKNOWN AD_TYPE");
  }

  private ArrayList<String> b(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = JsonUtil.getJSONArray(paramJSONObject, "trackers");
    ArrayList localArrayList = new ArrayList();
    if (localJSONArray != null)
      localArrayList = JsonUtil.getStringArrayList(JsonUtil.getJSONArray(JsonUtil.getJSONObjectFromArray(localJSONArray, 0), "impression_urls"));
    return localArrayList;
  }

  private void b(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    JSONArray localJSONArray = JsonUtil.getJSONArray(paramJSONObject, "native");
    if (localJSONArray != null)
    {
      JSONObject localJSONObject = JsonUtil.getJSONObjectFromArray(localJSONArray, 0);
      if (localJSONObject != null)
      {
        ANNativeAdResponse localANNativeAdResponse = ANNativeAdResponse.create(localJSONObject);
        if (localANNativeAdResponse != null)
        {
          RTBNativeAdResponse localRTBNativeAdResponse = new RTBNativeAdResponse(1, 1, paramString2, localANNativeAdResponse, null, paramString1);
          localRTBNativeAdResponse.setContentSource("rtb");
          this.b.add(localRTBNativeAdResponse);
        }
      }
    }
  }

  private void b(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
    throws Exception
  {
    JSONObject localJSONObject = JsonUtil.getJSONObject(paramJSONObject, "video");
    if (localJSONObject != null)
    {
      String str = JsonUtil.getJSONString(localJSONObject, "content");
      int i = JsonUtil.getJSONInt(localJSONObject, "player_height");
      int j = JsonUtil.getJSONInt(localJSONObject, "player_width");
      if (!StringUtil.isEmpty(str))
      {
        RTBVASTAdResponse localRTBVASTAdResponse = new RTBVASTAdResponse(j, i, paramString1, paramString2, b(paramJSONObject), paramString3);
        localRTBVASTAdResponse.setAdContent(str);
        localRTBVASTAdResponse.setContentSource("rtb");
        localRTBVASTAdResponse.addToExtras("MRAID", Boolean.valueOf(true));
        this.b.add(localRTBVASTAdResponse);
      }
    }
  }

  private void c(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    JSONObject localJSONObject1 = JsonUtil.getJSONObject(paramJSONObject, "csm");
    if (localJSONObject1 != null)
    {
      JSONArray localJSONArray = JsonUtil.getJSONArray(localJSONObject1, "handler");
      ArrayList localArrayList = b(localJSONObject1);
      String str1 = JsonUtil.getJSONString(localJSONObject1, "response_url");
      if (localJSONArray != null)
        for (int i = 0; i < localJSONArray.length(); i++)
        {
          JSONObject localJSONObject2 = JsonUtil.getJSONObjectFromArray(localJSONArray, i);
          if (localJSONObject2 != null)
          {
            String str2 = JsonUtil.getJSONString(localJSONObject2, "type");
            if (str2 != null)
              str2 = str2.toLowerCase(Locale.US);
            if ((str2 != null) && (str2.equals("android")))
            {
              String str3 = JsonUtil.getJSONString(localJSONObject2, "class");
              String str4 = JsonUtil.getJSONString(localJSONObject2, "param");
              int j = JsonUtil.getJSONInt(localJSONObject2, "height");
              int k = JsonUtil.getJSONInt(localJSONObject2, "width");
              String str5 = JsonUtil.getJSONString(localJSONObject2, "id");
              if (!StringUtil.isEmpty(str3))
              {
                CSMSDKAdResponse localCSMSDKAdResponse = new CSMSDKAdResponse(k, j, paramString1, str1, localArrayList, paramString2);
                localCSMSDKAdResponse.setClassName(str3);
                localCSMSDKAdResponse.setId(str5);
                localCSMSDKAdResponse.setParam(str4);
                localCSMSDKAdResponse.setContentSource("csm");
                this.b.add(localCSMSDKAdResponse);
              }
            }
          }
        }
    }
  }

  private void c(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    if (paramString1.equalsIgnoreCase("banner"))
    {
      Clog.i(Clog.httpRespLogTag, "Parsing SDK Mediation Ad");
      c(paramJSONObject, paramString1, paramString3);
    }
    do
    {
      return;
      if (paramString1.equalsIgnoreCase("native"))
      {
        Clog.i(Clog.httpRespLogTag, "Parsing Native Mediation Ad");
        c(paramJSONObject, paramString1, paramString3);
        return;
      }
    }
    while (!paramString1.equalsIgnoreCase("video"));
    Clog.i(Clog.httpRespLogTag, "Parsing Video CSM Ad");
    d(paramJSONObject, paramString1, paramString2, paramString3);
  }

  private void d(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    JSONObject localJSONObject1 = JsonUtil.getJSONObject(paramJSONObject, "ssm");
    if (localJSONObject1 != null)
    {
      JSONArray localJSONArray = JsonUtil.getJSONArray(localJSONObject1, "handler");
      JSONObject localJSONObject2 = JsonUtil.getJSONObject(localJSONObject1, "banner");
      int i = JsonUtil.getJSONInt(localJSONObject1, "timeout_ms");
      int j = JsonUtil.getJSONInt(localJSONObject2, "height");
      int k = JsonUtil.getJSONInt(localJSONObject2, "width");
      if (localJSONArray != null)
        for (int m = 0; m < localJSONArray.length(); m++)
        {
          JSONObject localJSONObject3 = JsonUtil.getJSONObjectFromArray(localJSONArray, m);
          if (localJSONObject3 != null)
          {
            String str = JsonUtil.getJSONString(localJSONObject3, "url");
            if (!StringUtil.isEmpty(str))
            {
              SSMHTMLAdResponse localSSMHTMLAdResponse = new SSMHTMLAdResponse(k, j, paramString1, JsonUtil.getJSONString(localJSONObject1, "response_url"), b(localJSONObject1), paramString2);
              localSSMHTMLAdResponse.setAdUrl(str);
              localSSMHTMLAdResponse.setSsmTimeout(i);
              localSSMHTMLAdResponse.setContentSource("ssm");
              localSSMHTMLAdResponse.addToExtras("ORIENTATION", this.h);
              this.b.add(localSSMHTMLAdResponse);
            }
          }
        }
    }
  }

  private void d(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = JsonUtil.getJSONObject(paramJSONObject, "csm");
    if ((localJSONObject != null) && (JsonUtil.getJSONArray(localJSONObject, "handler") != null))
    {
      CSMVASTAdResponse localCSMVASTAdResponse = new CSMVASTAdResponse(-1, -1, paramString1, null, paramString3);
      localCSMVASTAdResponse.setAdJSONContent(paramJSONObject);
      localCSMVASTAdResponse.setAuction_id(String.valueOf(this.e));
      localCSMVASTAdResponse.setTag_id(this.d);
      localCSMVASTAdResponse.setTimeout_ms(this.f);
      localCSMVASTAdResponse.setContentSource("csmvideo");
      this.b.add(localCSMVASTAdResponse);
    }
  }

  boolean a()
  {
    return this.a;
  }

  public LinkedList<BaseAdResponse> getAdList()
  {
    return this.b;
  }

  public MediaType getMediaType()
  {
    return this.g;
  }

  public String getNoAdUrl()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.ut.UTAdResponse
 * JD-Core Version:    0.6.2
 */
package com.mopub.network;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.common.logging.MoPubLog.LogLevel;
import com.mopub.common.util.ResponseHeader;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.toolbox.HttpHeaderParser;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MultiAdResponse
  implements Iterator<AdResponse>
{
  private static ServerOverrideListener c;
  private final Iterator<AdResponse> a;
  private String b;

  public MultiAdResponse(Context paramContext, NetworkResponse paramNetworkResponse, AdFormat paramAdFormat, String paramString)
    throws JSONException, MoPubNetworkError
  {
    String str1 = a(paramNetworkResponse);
    JSONObject localJSONObject1 = new JSONObject(str1);
    this.b = localJSONObject1.optString(ResponseHeader.FAIL_URL.getKey());
    String str2 = localJSONObject1.optString(ResponseHeader.REQUEST_ID.getKey());
    Integer localInteger1 = HeaderUtils.extractIntegerHeader(localJSONObject1, ResponseHeader.BACKOFF_MS);
    String str3 = HeaderUtils.extractHeader(localJSONObject1, ResponseHeader.BACKOFF_REASON);
    RequestRateTracker.getInstance().a(paramString, localInteger1, str3);
    boolean bool1 = HeaderUtils.extractBooleanHeader(localJSONObject1, ResponseHeader.INVALIDATE_CONSENT, false);
    boolean bool2 = HeaderUtils.extractBooleanHeader(localJSONObject1, ResponseHeader.FORCE_EXPLICIT_NO, false);
    boolean bool3 = HeaderUtils.extractBooleanHeader(localJSONObject1, ResponseHeader.REACQUIRE_CONSENT, false);
    String str4 = HeaderUtils.extractHeader(localJSONObject1, ResponseHeader.CONSENT_CHANGE_REASON);
    boolean bool4 = HeaderUtils.extractBooleanHeader(localJSONObject1, ResponseHeader.FORCE_GDPR_APPLIES, false);
    if (c != null)
    {
      if (bool4)
        c.onForceGdprApplies();
      if (!bool2)
        break label286;
      c.onForceExplicitNo(str4);
    }
    while (true)
    {
      if (HeaderUtils.extractBooleanHeader(localJSONObject1, ResponseHeader.ENABLE_DEBUG_LOGGING, false))
        MoPubLog.setLogLevel(MoPubLog.LogLevel.DEBUG);
      JSONArray localJSONArray = localJSONObject1.getJSONArray(ResponseHeader.AD_RESPONSES.getKey());
      ArrayList localArrayList = new ArrayList(3);
      Object localObject1 = null;
      int i = 0;
      label216: if (i < localJSONArray.length());
      try
      {
        JSONObject localJSONObject2 = localJSONArray.getJSONObject(i);
        localObject2 = a(paramContext, paramNetworkResponse, localJSONObject2, paramString, paramAdFormat, str2);
        if (!"clear".equals(((AdResponse)localObject2).getAdType()))
        {
          localArrayList.add(localObject2);
          localObject2 = localObject1;
        }
        while (true)
        {
          i++;
          localObject1 = localObject2;
          break label216;
          label286: if (bool1)
          {
            c.onInvalidateConsent(str4);
            break;
          }
          if (!bool3)
            break;
          c.onReacquireConsent(str4);
          break;
          this.b = "";
          try
          {
            if (b(localJSONObject2))
              throw new MoPubNetworkError("Server is preparing this Ad Unit.", MoPubNetworkError.Reason.WARMING_UP, ((AdResponse)localObject2).getRefreshTimeMillis());
          }
          catch (JSONException localJSONException2)
          {
            MoPubLog.AdLogEvent localAdLogEvent1 = MoPubLog.AdLogEvent.CUSTOM;
            Object[] arrayOfObject1 = new Object[1];
            arrayOfObject1[0] = ("Invalid response item. Body: " + str1);
            MoPubLog.log(localAdLogEvent1, arrayOfObject1);
            continue;
            localObject1 = localObject2;
            this.a = localArrayList.iterator();
            if (this.a.hasNext())
              break label577;
            Integer localInteger2 = Integer.valueOf(30000);
            if (localObject1 != null)
              localInteger2 = localObject1.getRefreshTimeMillis();
            throw new MoPubNetworkError("No ads found for ad unit.", MoPubNetworkError.Reason.NO_FILL, localInteger2);
          }
          catch (MoPubNetworkError localMoPubNetworkError2)
          {
            if (localMoPubNetworkError2.getReason() == MoPubNetworkError.Reason.WARMING_UP)
              throw localMoPubNetworkError2;
            MoPubLog.AdLogEvent localAdLogEvent2 = MoPubLog.AdLogEvent.CUSTOM;
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = ("Invalid response item. Error: " + localMoPubNetworkError2.getReason());
            MoPubLog.log(localAdLogEvent2, arrayOfObject2);
          }
          catch (Exception localException2)
          {
            MoPubLog.AdLogEvent localAdLogEvent3 = MoPubLog.AdLogEvent.CUSTOM;
            Object[] arrayOfObject3 = new Object[1];
            arrayOfObject3[0] = ("Unexpected error parsing response item. " + localException2.getMessage());
            MoPubLog.log(localAdLogEvent3, arrayOfObject3);
          }
        }
        label577: return;
      }
      catch (Exception localException1)
      {
        while (true)
        {
          Object localObject4 = localException1;
          localObject2 = localObject1;
        }
      }
      catch (MoPubNetworkError localMoPubNetworkError1)
      {
        while (true)
        {
          Object localObject3 = localMoPubNetworkError1;
          localObject2 = localObject1;
        }
      }
      catch (JSONException localJSONException1)
      {
        while (true)
          Object localObject2 = localObject1;
      }
    }
  }

  // ERROR //
  protected static AdResponse a(Context paramContext, NetworkResponse paramNetworkResponse, JSONObject paramJSONObject, String paramString1, AdFormat paramAdFormat, String paramString2)
    throws JSONException, MoPubNetworkError
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 253	com/mopub/common/Preconditions:checkNotNull	(Ljava/lang/Object;)V
    //   4: aload_1
    //   5: invokestatic 253	com/mopub/common/Preconditions:checkNotNull	(Ljava/lang/Object;)V
    //   8: aload_2
    //   9: invokestatic 253	com/mopub/common/Preconditions:checkNotNull	(Ljava/lang/Object;)V
    //   12: aload 4
    //   14: invokestatic 253	com/mopub/common/Preconditions:checkNotNull	(Ljava/lang/Object;)V
    //   17: getstatic 256	com/mopub/common/logging/MoPubLog$AdLogEvent:RESPONSE_RECEIVED	Lcom/mopub/common/logging/MoPubLog$AdLogEvent;
    //   20: astore 6
    //   22: iconst_1
    //   23: anewarray 5	java/lang/Object
    //   26: astore 7
    //   28: aload 7
    //   30: iconst_0
    //   31: aload_2
    //   32: invokevirtual 257	org/json/JSONObject:toString	()Ljava/lang/String;
    //   35: aastore
    //   36: aload 6
    //   38: aload 7
    //   40: invokestatic 212	com/mopub/common/logging/MoPubLog:log	(Lcom/mopub/common/logging/MoPubLog$a;[Ljava/lang/Object;)V
    //   43: new 259	com/mopub/network/AdResponse$Builder
    //   46: dup
    //   47: invokespecial 260	com/mopub/network/AdResponse$Builder:<init>	()V
    //   50: astore 8
    //   52: aload_2
    //   53: getstatic 263	com/mopub/common/util/ResponseHeader:CONTENT	Lcom/mopub/common/util/ResponseHeader;
    //   56: invokevirtual 43	com/mopub/common/util/ResponseHeader:getKey	()Ljava/lang/String;
    //   59: invokevirtual 47	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore 9
    //   64: aload_2
    //   65: getstatic 266	com/mopub/common/util/ResponseHeader:METADATA	Lcom/mopub/common/util/ResponseHeader;
    //   68: invokevirtual 43	com/mopub/common/util/ResponseHeader:getKey	()Ljava/lang/String;
    //   71: invokevirtual 269	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   74: astore 10
    //   76: aload 8
    //   78: aload_3
    //   79: invokevirtual 273	com/mopub/network/AdResponse$Builder:setAdUnitId	(Ljava/lang/String;)Lcom/mopub/network/AdResponse$Builder;
    //   82: pop
    //   83: aload 8
    //   85: aload 9
    //   87: invokevirtual 276	com/mopub/network/AdResponse$Builder:setResponseBody	(Ljava/lang/String;)Lcom/mopub/network/AdResponse$Builder;
    //   90: pop
    //   91: aload 10
    //   93: getstatic 279	com/mopub/common/util/ResponseHeader:AD_TYPE	Lcom/mopub/common/util/ResponseHeader;
    //   96: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   99: astore 13
    //   101: aload 10
    //   103: getstatic 282	com/mopub/common/util/ResponseHeader:FULL_AD_TYPE	Lcom/mopub/common/util/ResponseHeader;
    //   106: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   109: astore 14
    //   111: aload 8
    //   113: aload 13
    //   115: invokevirtual 285	com/mopub/network/AdResponse$Builder:setAdType	(Ljava/lang/String;)Lcom/mopub/network/AdResponse$Builder;
    //   118: pop
    //   119: aload 8
    //   121: aload 14
    //   123: invokevirtual 288	com/mopub/network/AdResponse$Builder:setFullAdType	(Ljava/lang/String;)Lcom/mopub/network/AdResponse$Builder;
    //   126: pop
    //   127: aload 8
    //   129: aload_2
    //   130: invokestatic 291	com/mopub/network/MultiAdResponse:a	(Lorg/json/JSONObject;)Ljava/lang/Integer;
    //   133: invokevirtual 295	com/mopub/network/AdResponse$Builder:setRefreshTimeMilliseconds	(Ljava/lang/Integer;)Lcom/mopub/network/AdResponse$Builder;
    //   136: pop
    //   137: ldc 148
    //   139: aload 13
    //   141: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   144: ifeq +9 -> 153
    //   147: aload 8
    //   149: invokevirtual 299	com/mopub/network/AdResponse$Builder:build	()Lcom/mopub/network/AdResponse;
    //   152: areturn
    //   153: aload 8
    //   155: aload 10
    //   157: getstatic 302	com/mopub/common/util/ResponseHeader:DSP_CREATIVE_ID	Lcom/mopub/common/util/ResponseHeader;
    //   160: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   163: invokevirtual 305	com/mopub/network/AdResponse$Builder:setDspCreativeId	(Ljava/lang/String;)Lcom/mopub/network/AdResponse$Builder;
    //   166: pop
    //   167: aload 8
    //   169: aload 10
    //   171: getstatic 308	com/mopub/common/util/ResponseHeader:NETWORK_TYPE	Lcom/mopub/common/util/ResponseHeader;
    //   174: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   177: invokevirtual 311	com/mopub/network/AdResponse$Builder:setNetworkType	(Ljava/lang/String;)Lcom/mopub/network/AdResponse$Builder;
    //   180: pop
    //   181: aload 8
    //   183: aload 10
    //   185: getstatic 314	com/mopub/common/util/ResponseHeader:IMPRESSION_DATA	Lcom/mopub/common/util/ResponseHeader;
    //   188: invokestatic 318	com/mopub/network/HeaderUtils:extractJsonObjectHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Lorg/json/JSONObject;
    //   191: invokestatic 323	com/mopub/network/ImpressionData:a	(Lorg/json/JSONObject;)Lcom/mopub/network/ImpressionData;
    //   194: invokevirtual 327	com/mopub/network/AdResponse$Builder:setImpressionData	(Lcom/mopub/network/ImpressionData;)Lcom/mopub/network/AdResponse$Builder;
    //   197: pop
    //   198: aload 10
    //   200: getstatic 330	com/mopub/common/util/ResponseHeader:CLICK_TRACKING_URL	Lcom/mopub/common/util/ResponseHeader;
    //   203: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   206: astore 21
    //   208: aload 8
    //   210: aload 21
    //   212: invokevirtual 333	com/mopub/network/AdResponse$Builder:setClickTrackingUrl	(Ljava/lang/String;)Lcom/mopub/network/AdResponse$Builder;
    //   215: pop
    //   216: aload 10
    //   218: getstatic 336	com/mopub/common/util/ResponseHeader:IMPRESSION_URLS	Lcom/mopub/common/util/ResponseHeader;
    //   221: invokestatic 339	com/mopub/network/HeaderUtils:a	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/util/List;
    //   224: astore 23
    //   226: aload 23
    //   228: invokeinterface 342 1 0
    //   233: ifeq +19 -> 252
    //   236: aload 23
    //   238: aload 10
    //   240: getstatic 345	com/mopub/common/util/ResponseHeader:IMPRESSION_URL	Lcom/mopub/common/util/ResponseHeader;
    //   243: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   246: invokeinterface 164 2 0
    //   251: pop
    //   252: aload 8
    //   254: aload 23
    //   256: invokevirtual 349	com/mopub/network/AdResponse$Builder:setImpressionTrackingUrls	(Ljava/util/List;)Lcom/mopub/network/AdResponse$Builder;
    //   259: pop
    //   260: aload 8
    //   262: aload 10
    //   264: getstatic 352	com/mopub/common/util/ResponseHeader:BEFORE_LOAD_URL	Lcom/mopub/common/util/ResponseHeader;
    //   267: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   270: invokevirtual 355	com/mopub/network/AdResponse$Builder:setBeforeLoadUrl	(Ljava/lang/String;)Lcom/mopub/network/AdResponse$Builder;
    //   273: pop
    //   274: aload 10
    //   276: getstatic 358	com/mopub/common/util/ResponseHeader:AFTER_LOAD_URL	Lcom/mopub/common/util/ResponseHeader;
    //   279: invokestatic 339	com/mopub/network/HeaderUtils:a	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/util/List;
    //   282: astore 26
    //   284: aload 26
    //   286: invokeinterface 342 1 0
    //   291: ifeq +19 -> 310
    //   294: aload 26
    //   296: aload 10
    //   298: getstatic 358	com/mopub/common/util/ResponseHeader:AFTER_LOAD_URL	Lcom/mopub/common/util/ResponseHeader;
    //   301: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   304: invokeinterface 164 2 0
    //   309: pop
    //   310: aload 8
    //   312: aload 26
    //   314: invokevirtual 361	com/mopub/network/AdResponse$Builder:setAfterLoadUrls	(Ljava/util/List;)Lcom/mopub/network/AdResponse$Builder;
    //   317: pop
    //   318: aload 10
    //   320: getstatic 364	com/mopub/common/util/ResponseHeader:AFTER_LOAD_SUCCESS_URL	Lcom/mopub/common/util/ResponseHeader;
    //   323: invokestatic 339	com/mopub/network/HeaderUtils:a	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/util/List;
    //   326: astore 28
    //   328: aload 28
    //   330: invokeinterface 342 1 0
    //   335: ifeq +19 -> 354
    //   338: aload 28
    //   340: aload 10
    //   342: getstatic 364	com/mopub/common/util/ResponseHeader:AFTER_LOAD_SUCCESS_URL	Lcom/mopub/common/util/ResponseHeader;
    //   345: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   348: invokeinterface 164 2 0
    //   353: pop
    //   354: aload 8
    //   356: aload 28
    //   358: invokevirtual 367	com/mopub/network/AdResponse$Builder:setAfterLoadSuccessUrls	(Ljava/util/List;)Lcom/mopub/network/AdResponse$Builder;
    //   361: pop
    //   362: aload 10
    //   364: getstatic 370	com/mopub/common/util/ResponseHeader:AFTER_LOAD_FAIL_URL	Lcom/mopub/common/util/ResponseHeader;
    //   367: invokestatic 339	com/mopub/network/HeaderUtils:a	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/util/List;
    //   370: astore 30
    //   372: aload 30
    //   374: invokeinterface 342 1 0
    //   379: ifeq +19 -> 398
    //   382: aload 30
    //   384: aload 10
    //   386: getstatic 370	com/mopub/common/util/ResponseHeader:AFTER_LOAD_FAIL_URL	Lcom/mopub/common/util/ResponseHeader;
    //   389: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   392: invokeinterface 164 2 0
    //   397: pop
    //   398: aload 8
    //   400: aload 30
    //   402: invokevirtual 373	com/mopub/network/AdResponse$Builder:setAfterLoadFailUrls	(Ljava/util/List;)Lcom/mopub/network/AdResponse$Builder;
    //   405: pop
    //   406: aload 8
    //   408: aload 5
    //   410: invokevirtual 376	com/mopub/network/AdResponse$Builder:setRequestId	(Ljava/lang/String;)Lcom/mopub/network/AdResponse$Builder;
    //   413: pop
    //   414: aload 8
    //   416: aload 10
    //   418: getstatic 379	com/mopub/common/util/ResponseHeader:WIDTH	Lcom/mopub/common/util/ResponseHeader;
    //   421: invokestatic 61	com/mopub/network/HeaderUtils:extractIntegerHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/Integer;
    //   424: aload 10
    //   426: getstatic 382	com/mopub/common/util/ResponseHeader:HEIGHT	Lcom/mopub/common/util/ResponseHeader;
    //   429: invokestatic 61	com/mopub/network/HeaderUtils:extractIntegerHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/Integer;
    //   432: invokevirtual 386	com/mopub/network/AdResponse$Builder:setDimensions	(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/mopub/network/AdResponse$Builder;
    //   435: pop
    //   436: aload 8
    //   438: aload 10
    //   440: getstatic 389	com/mopub/common/util/ResponseHeader:AD_TIMEOUT	Lcom/mopub/common/util/ResponseHeader;
    //   443: invokestatic 61	com/mopub/network/HeaderUtils:extractIntegerHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/Integer;
    //   446: invokevirtual 392	com/mopub/network/AdResponse$Builder:setAdTimeoutDelayMilliseconds	(Ljava/lang/Integer;)Lcom/mopub/network/AdResponse$Builder;
    //   449: pop
    //   450: ldc_w 394
    //   453: aload 13
    //   455: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   458: ifne +14 -> 472
    //   461: ldc_w 396
    //   464: aload 13
    //   466: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   469: ifeq +18 -> 487
    //   472: aload 8
    //   474: new 30	org/json/JSONObject
    //   477: dup
    //   478: aload 9
    //   480: invokespecial 33	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   483: invokevirtual 400	com/mopub/network/AdResponse$Builder:setJsonBody	(Lorg/json/JSONObject;)Lcom/mopub/network/AdResponse$Builder;
    //   486: pop
    //   487: aload 8
    //   489: aload 4
    //   491: aload 13
    //   493: aload 14
    //   495: aload 10
    //   497: invokestatic 406	com/mopub/mobileads/AdTypeTranslator:getCustomEventName	(Lcom/mopub/common/AdFormat;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    //   500: invokevirtual 409	com/mopub/network/AdResponse$Builder:setCustomEventClassName	(Ljava/lang/String;)Lcom/mopub/network/AdResponse$Builder;
    //   503: pop
    //   504: aload 10
    //   506: getstatic 412	com/mopub/common/util/ResponseHeader:BROWSER_AGENT	Lcom/mopub/common/util/ResponseHeader;
    //   509: invokestatic 61	com/mopub/network/HeaderUtils:extractIntegerHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/Integer;
    //   512: invokestatic 418	com/mopub/common/MoPub$BrowserAgent:fromHeader	(Ljava/lang/Integer;)Lcom/mopub/common/MoPub$BrowserAgent;
    //   515: astore 38
    //   517: aload 38
    //   519: invokestatic 424	com/mopub/common/MoPub:setBrowserAgentFromAdServer	(Lcom/mopub/common/MoPub$BrowserAgent;)V
    //   522: aload 8
    //   524: aload 38
    //   526: invokevirtual 428	com/mopub/network/AdResponse$Builder:setBrowserAgent	(Lcom/mopub/common/MoPub$BrowserAgent;)Lcom/mopub/network/AdResponse$Builder;
    //   529: pop
    //   530: aload 10
    //   532: getstatic 431	com/mopub/common/util/ResponseHeader:CUSTOM_EVENT_DATA	Lcom/mopub/common/util/ResponseHeader;
    //   535: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   538: astore 40
    //   540: aload 40
    //   542: invokestatic 436	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   545: ifeq +13 -> 558
    //   548: aload 10
    //   550: getstatic 439	com/mopub/common/util/ResponseHeader:NATIVE_PARAMS	Lcom/mopub/common/util/ResponseHeader;
    //   553: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   556: astore 40
    //   558: aload 40
    //   560: invokestatic 445	com/mopub/common/util/Json:jsonStringToMap	(Ljava/lang/String;)Ljava/util/Map;
    //   563: astore 42
    //   565: aload 10
    //   567: ldc_w 447
    //   570: invokevirtual 47	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   573: invokevirtual 448	java/lang/String:isEmpty	()Z
    //   576: ifne +22 -> 598
    //   579: aload 42
    //   581: ldc_w 447
    //   584: aload 10
    //   586: ldc_w 447
    //   589: invokevirtual 451	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   592: invokeinterface 457 3 0
    //   597: pop
    //   598: aload 21
    //   600: invokestatic 436	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   603: ifne +16 -> 619
    //   606: aload 42
    //   608: ldc_w 459
    //   611: aload 21
    //   613: invokeinterface 457 3 0
    //   618: pop
    //   619: aload 13
    //   621: aload 14
    //   623: invokestatic 462	com/mopub/network/MultiAdResponse:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   626: ifeq +35 -> 661
    //   629: aload 42
    //   631: ldc_w 464
    //   634: aload 9
    //   636: invokeinterface 457 3 0
    //   641: pop
    //   642: aload 42
    //   644: ldc_w 466
    //   647: aload 10
    //   649: getstatic 469	com/mopub/common/util/ResponseHeader:ORIENTATION	Lcom/mopub/common/util/ResponseHeader;
    //   652: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   655: invokeinterface 457 3 0
    //   660: pop
    //   661: ldc_w 394
    //   664: aload 13
    //   666: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   669: ifne +14 -> 683
    //   672: ldc_w 396
    //   675: aload 13
    //   677: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   680: ifeq +96 -> 776
    //   683: aload 10
    //   685: getstatic 472	com/mopub/common/util/ResponseHeader:IMPRESSION_MIN_VISIBLE_PERCENT	Lcom/mopub/common/util/ResponseHeader;
    //   688: invokestatic 474	com/mopub/network/HeaderUtils:b	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   691: astore 44
    //   693: aload 10
    //   695: getstatic 477	com/mopub/common/util/ResponseHeader:IMPRESSION_VISIBLE_MS	Lcom/mopub/common/util/ResponseHeader;
    //   698: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   701: astore 45
    //   703: aload 10
    //   705: getstatic 480	com/mopub/common/util/ResponseHeader:IMPRESSION_MIN_VISIBLE_PX	Lcom/mopub/common/util/ResponseHeader;
    //   708: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   711: astore 46
    //   713: aload 44
    //   715: invokestatic 436	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   718: ifne +16 -> 734
    //   721: aload 42
    //   723: ldc_w 482
    //   726: aload 44
    //   728: invokeinterface 457 3 0
    //   733: pop
    //   734: aload 45
    //   736: invokestatic 436	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   739: ifne +16 -> 755
    //   742: aload 42
    //   744: ldc_w 484
    //   747: aload 45
    //   749: invokeinterface 457 3 0
    //   754: pop
    //   755: aload 46
    //   757: invokestatic 436	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   760: ifne +16 -> 776
    //   763: aload 42
    //   765: ldc_w 486
    //   768: aload 46
    //   770: invokeinterface 457 3 0
    //   775: pop
    //   776: ldc_w 396
    //   779: aload 13
    //   781: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   784: ifeq +60 -> 844
    //   787: aload 42
    //   789: ldc_w 488
    //   792: aload 10
    //   794: getstatic 491	com/mopub/common/util/ResponseHeader:PLAY_VISIBLE_PERCENT	Lcom/mopub/common/util/ResponseHeader;
    //   797: invokestatic 474	com/mopub/network/HeaderUtils:b	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   800: invokeinterface 457 3 0
    //   805: pop
    //   806: aload 42
    //   808: ldc_w 493
    //   811: aload 10
    //   813: getstatic 496	com/mopub/common/util/ResponseHeader:PAUSE_VISIBLE_PERCENT	Lcom/mopub/common/util/ResponseHeader;
    //   816: invokestatic 474	com/mopub/network/HeaderUtils:b	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   819: invokeinterface 457 3 0
    //   824: pop
    //   825: aload 42
    //   827: ldc_w 498
    //   830: aload 10
    //   832: getstatic 501	com/mopub/common/util/ResponseHeader:MAX_BUFFER_MS	Lcom/mopub/common/util/ResponseHeader;
    //   835: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   838: invokeinterface 457 3 0
    //   843: pop
    //   844: aload 10
    //   846: getstatic 504	com/mopub/common/util/ResponseHeader:VIDEO_TRACKERS	Lcom/mopub/common/util/ResponseHeader;
    //   849: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   852: astore 47
    //   854: aload 47
    //   856: invokestatic 436	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   859: ifne +16 -> 875
    //   862: aload 42
    //   864: ldc_w 506
    //   867: aload 47
    //   869: invokeinterface 457 3 0
    //   874: pop
    //   875: ldc_w 508
    //   878: aload 13
    //   880: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   883: ifne +25 -> 908
    //   886: ldc_w 510
    //   889: aload 13
    //   891: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   894: ifeq +33 -> 927
    //   897: ldc_w 512
    //   900: aload 14
    //   902: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   905: ifeq +22 -> 927
    //   908: aload 42
    //   910: ldc_w 514
    //   913: aload 10
    //   915: getstatic 517	com/mopub/common/util/ResponseHeader:VIDEO_VIEWABILITY_TRACKERS	Lcom/mopub/common/util/ResponseHeader;
    //   918: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   921: invokeinterface 457 3 0
    //   926: pop
    //   927: getstatic 523	com/mopub/common/AdFormat:BANNER	Lcom/mopub/common/AdFormat;
    //   930: aload 4
    //   932: invokevirtual 524	com/mopub/common/AdFormat:equals	(Ljava/lang/Object;)Z
    //   935: ifeq +41 -> 976
    //   938: aload 42
    //   940: ldc_w 526
    //   943: aload 10
    //   945: getstatic 529	com/mopub/common/util/ResponseHeader:BANNER_IMPRESSION_MIN_VISIBLE_MS	Lcom/mopub/common/util/ResponseHeader;
    //   948: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   951: invokeinterface 457 3 0
    //   956: pop
    //   957: aload 42
    //   959: ldc_w 531
    //   962: aload 10
    //   964: getstatic 534	com/mopub/common/util/ResponseHeader:BANNER_IMPRESSION_MIN_VISIBLE_DIPS	Lcom/mopub/common/util/ResponseHeader;
    //   967: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   970: invokeinterface 457 3 0
    //   975: pop
    //   976: aload 10
    //   978: getstatic 537	com/mopub/common/util/ResponseHeader:DISABLE_VIEWABILITY	Lcom/mopub/common/util/ResponseHeader;
    //   981: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   984: astore 49
    //   986: aload 49
    //   988: invokestatic 436	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   991: ifne +20 -> 1011
    //   994: aload 49
    //   996: invokestatic 543	com/mopub/common/ExternalViewabilitySessionManager$ViewabilityVendor:fromKey	(Ljava/lang/String;)Lcom/mopub/common/ExternalViewabilitySessionManager$ViewabilityVendor;
    //   999: astore 63
    //   1001: aload 63
    //   1003: ifnull +8 -> 1011
    //   1006: aload 63
    //   1008: invokevirtual 546	com/mopub/common/ExternalViewabilitySessionManager$ViewabilityVendor:disable	()V
    //   1011: aload 8
    //   1013: aload 42
    //   1015: invokevirtual 550	com/mopub/network/AdResponse$Builder:setServerExtras	(Ljava/util/Map;)Lcom/mopub/network/AdResponse$Builder;
    //   1018: pop
    //   1019: ldc_w 508
    //   1022: aload 13
    //   1024: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1027: ifne +25 -> 1052
    //   1030: ldc_w 552
    //   1033: aload 13
    //   1035: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1038: ifne +14 -> 1052
    //   1041: ldc_w 554
    //   1044: aload 13
    //   1046: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1049: ifeq +112 -> 1161
    //   1052: aload 10
    //   1054: getstatic 557	com/mopub/common/util/ResponseHeader:REWARDED_VIDEO_CURRENCY_NAME	Lcom/mopub/common/util/ResponseHeader;
    //   1057: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   1060: astore 51
    //   1062: aload 10
    //   1064: getstatic 560	com/mopub/common/util/ResponseHeader:REWARDED_VIDEO_CURRENCY_AMOUNT	Lcom/mopub/common/util/ResponseHeader;
    //   1067: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   1070: astore 52
    //   1072: aload 10
    //   1074: getstatic 563	com/mopub/common/util/ResponseHeader:REWARDED_CURRENCIES	Lcom/mopub/common/util/ResponseHeader;
    //   1077: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   1080: astore 53
    //   1082: aload 10
    //   1084: getstatic 566	com/mopub/common/util/ResponseHeader:REWARDED_VIDEO_COMPLETION_URL	Lcom/mopub/common/util/ResponseHeader;
    //   1087: invokestatic 68	com/mopub/network/HeaderUtils:extractHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/String;
    //   1090: astore 54
    //   1092: aload 10
    //   1094: getstatic 569	com/mopub/common/util/ResponseHeader:REWARDED_DURATION	Lcom/mopub/common/util/ResponseHeader;
    //   1097: invokestatic 61	com/mopub/network/HeaderUtils:extractIntegerHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;)Ljava/lang/Integer;
    //   1100: astore 55
    //   1102: aload 10
    //   1104: getstatic 572	com/mopub/common/util/ResponseHeader:SHOULD_REWARD_ON_CLICK	Lcom/mopub/common/util/ResponseHeader;
    //   1107: iconst_0
    //   1108: invokestatic 84	com/mopub/network/HeaderUtils:extractBooleanHeader	(Lorg/json/JSONObject;Lcom/mopub/common/util/ResponseHeader;Z)Z
    //   1111: istore 56
    //   1113: aload 8
    //   1115: aload 51
    //   1117: invokevirtual 575	com/mopub/network/AdResponse$Builder:setRewardedVideoCurrencyName	(Ljava/lang/String;)Lcom/mopub/network/AdResponse$Builder;
    //   1120: pop
    //   1121: aload 8
    //   1123: aload 52
    //   1125: invokevirtual 578	com/mopub/network/AdResponse$Builder:setRewardedVideoCurrencyAmount	(Ljava/lang/String;)Lcom/mopub/network/AdResponse$Builder;
    //   1128: pop
    //   1129: aload 8
    //   1131: aload 53
    //   1133: invokevirtual 581	com/mopub/network/AdResponse$Builder:setRewardedCurrencies	(Ljava/lang/String;)Lcom/mopub/network/AdResponse$Builder;
    //   1136: pop
    //   1137: aload 8
    //   1139: aload 54
    //   1141: invokevirtual 584	com/mopub/network/AdResponse$Builder:setRewardedVideoCompletionUrl	(Ljava/lang/String;)Lcom/mopub/network/AdResponse$Builder;
    //   1144: pop
    //   1145: aload 8
    //   1147: aload 55
    //   1149: invokevirtual 587	com/mopub/network/AdResponse$Builder:setRewardedDuration	(Ljava/lang/Integer;)Lcom/mopub/network/AdResponse$Builder;
    //   1152: pop
    //   1153: aload 8
    //   1155: iload 56
    //   1157: invokevirtual 591	com/mopub/network/AdResponse$Builder:setShouldRewardOnClick	(Z)Lcom/mopub/network/AdResponse$Builder;
    //   1160: pop
    //   1161: aload 8
    //   1163: invokevirtual 299	com/mopub/network/AdResponse$Builder:build	()Lcom/mopub/network/AdResponse;
    //   1166: areturn
    //   1167: astore 35
    //   1169: new 20	com/mopub/network/MoPubNetworkError
    //   1172: dup
    //   1173: ldc_w 593
    //   1176: aload 35
    //   1178: getstatic 596	com/mopub/network/MoPubNetworkError$Reason:BAD_BODY	Lcom/mopub/network/MoPubNetworkError$Reason;
    //   1181: invokespecial 599	com/mopub/network/MoPubNetworkError:<init>	(Ljava/lang/String;Ljava/lang/Throwable;Lcom/mopub/network/MoPubNetworkError$Reason;)V
    //   1184: athrow
    //   1185: astore 41
    //   1187: new 20	com/mopub/network/MoPubNetworkError
    //   1190: dup
    //   1191: ldc_w 601
    //   1194: aload 41
    //   1196: getstatic 604	com/mopub/network/MoPubNetworkError$Reason:BAD_HEADER_DATA	Lcom/mopub/network/MoPubNetworkError$Reason;
    //   1199: invokespecial 599	com/mopub/network/MoPubNetworkError:<init>	(Ljava/lang/String;Ljava/lang/Throwable;Lcom/mopub/network/MoPubNetworkError$Reason;)V
    //   1202: athrow
    //   1203: astore 43
    //   1205: new 20	com/mopub/network/MoPubNetworkError
    //   1208: dup
    //   1209: ldc_w 606
    //   1212: aload 43
    //   1214: getstatic 596	com/mopub/network/MoPubNetworkError$Reason:BAD_BODY	Lcom/mopub/network/MoPubNetworkError$Reason;
    //   1217: invokespecial 599	com/mopub/network/MoPubNetworkError:<init>	(Ljava/lang/String;Ljava/lang/Throwable;Lcom/mopub/network/MoPubNetworkError$Reason;)V
    //   1220: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   472	487	1167	org/json/JSONException
    //   558	565	1185	org/json/JSONException
    //   565	598	1203	org/json/JSONException
  }

  private static Integer a(JSONObject paramJSONObject)
    throws JSONException
  {
    Preconditions.checkNotNull(paramJSONObject);
    Integer localInteger = HeaderUtils.extractIntegerHeader(paramJSONObject.getJSONObject(ResponseHeader.METADATA.getKey()), ResponseHeader.REFRESH_TIME);
    if (localInteger == null)
      return null;
    return Integer.valueOf(1000 * localInteger.intValue());
  }

  private static String a(NetworkResponse paramNetworkResponse)
  {
    Preconditions.checkNotNull(paramNetworkResponse);
    try
    {
      String str = new String(paramNetworkResponse.data, HttpHeaderParser.parseCharset(paramNetworkResponse.headers));
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return new String(paramNetworkResponse.data);
  }

  private static boolean a(String paramString1, String paramString2)
  {
    return ("mraid".equals(paramString1)) || ("html".equals(paramString1)) || (("interstitial".equals(paramString1)) && ("vast".equals(paramString2))) || (("rewarded_video".equals(paramString1)) && ("vast".equals(paramString2))) || ("rewarded_playable".equals(paramString1));
  }

  private static boolean b(JSONObject paramJSONObject)
  {
    Preconditions.checkNotNull(paramJSONObject);
    return HeaderUtils.extractBooleanHeader(paramJSONObject.optJSONObject(ResponseHeader.METADATA.getKey()), ResponseHeader.WARMUP, false);
  }

  public static void setServerOverrideListener(ServerOverrideListener paramServerOverrideListener)
  {
    c = paramServerOverrideListener;
  }

  boolean a()
  {
    return TextUtils.isEmpty(this.b);
  }

  public String getFailURL()
  {
    return this.b;
  }

  public boolean hasNext()
  {
    return this.a.hasNext();
  }

  public AdResponse next()
  {
    return (AdResponse)this.a.next();
  }

  public static abstract interface ServerOverrideListener
  {
    public abstract void onForceExplicitNo(String paramString);

    public abstract void onForceGdprApplies();

    public abstract void onInvalidateConsent(String paramString);

    public abstract void onReacquireConsent(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.MultiAdResponse
 * JD-Core Version:    0.6.2
 */
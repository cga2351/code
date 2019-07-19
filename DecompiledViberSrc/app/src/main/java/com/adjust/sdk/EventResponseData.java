package com.adjust.sdk;

import java.util.Map;
import org.json.JSONObject;

public class EventResponseData extends ResponseData
{
  private String callbackId;
  private String eventToken;
  private String sdkPlatform;

  public EventResponseData(ActivityPackage paramActivityPackage)
  {
    this.eventToken = ((String)paramActivityPackage.getParameters().get("event_token"));
    this.callbackId = ((String)paramActivityPackage.getParameters().get("event_callback_id"));
    this.sdkPlatform = Util.getSdkPrefixPlatform(paramActivityPackage.getClientSdk());
  }

  public AdjustEventFailure getFailureResponseData()
  {
    if (this.success)
      return null;
    AdjustEventFailure localAdjustEventFailure = new AdjustEventFailure();
    String str1;
    String str2;
    label58: String str3;
    label76: String str4;
    label95: String str5;
    label114: JSONObject localJSONObject;
    if ("unity".equals(this.sdkPlatform))
      if (this.eventToken != null)
      {
        str1 = this.eventToken;
        localAdjustEventFailure.eventToken = str1;
        if (this.message == null)
          break label155;
        str2 = this.message;
        localAdjustEventFailure.message = str2;
        if (this.timestamp == null)
          break label161;
        str3 = this.timestamp;
        localAdjustEventFailure.timestamp = str3;
        if (this.adid == null)
          break label168;
        str4 = this.adid;
        localAdjustEventFailure.adid = str4;
        if (this.callbackId == null)
          break label175;
        str5 = this.callbackId;
        localAdjustEventFailure.callbackId = str5;
        localAdjustEventFailure.willRetry = this.willRetry;
        if (this.jsonResponse == null)
          break label182;
        localJSONObject = this.jsonResponse;
      }
    label141: for (localAdjustEventFailure.jsonResponse = localJSONObject; ; localAdjustEventFailure.jsonResponse = this.jsonResponse)
    {
      return localAdjustEventFailure;
      str1 = "";
      break;
      label155: str2 = "";
      break label58;
      label161: str3 = "";
      break label76;
      label168: str4 = "";
      break label95;
      label175: str5 = "";
      break label114;
      label182: localJSONObject = new JSONObject();
      break label141;
      localAdjustEventFailure.eventToken = this.eventToken;
      localAdjustEventFailure.message = this.message;
      localAdjustEventFailure.timestamp = this.timestamp;
      localAdjustEventFailure.adid = this.adid;
      localAdjustEventFailure.callbackId = this.callbackId;
      localAdjustEventFailure.willRetry = this.willRetry;
    }
  }

  public AdjustEventSuccess getSuccessResponseData()
  {
    if (!this.success)
      return null;
    AdjustEventSuccess localAdjustEventSuccess = new AdjustEventSuccess();
    String str1;
    String str2;
    label58: String str3;
    label76: String str4;
    label95: String str5;
    label114: JSONObject localJSONObject;
    if ("unity".equals(this.sdkPlatform))
      if (this.eventToken != null)
      {
        str1 = this.eventToken;
        localAdjustEventSuccess.eventToken = str1;
        if (this.message == null)
          break label147;
        str2 = this.message;
        localAdjustEventSuccess.message = str2;
        if (this.timestamp == null)
          break label153;
        str3 = this.timestamp;
        localAdjustEventSuccess.timestamp = str3;
        if (this.adid == null)
          break label160;
        str4 = this.adid;
        localAdjustEventSuccess.adid = str4;
        if (this.callbackId == null)
          break label167;
        str5 = this.callbackId;
        localAdjustEventSuccess.callbackId = str5;
        if (this.jsonResponse == null)
          break label174;
        localJSONObject = this.jsonResponse;
      }
    label133: for (localAdjustEventSuccess.jsonResponse = localJSONObject; ; localAdjustEventSuccess.jsonResponse = this.jsonResponse)
    {
      return localAdjustEventSuccess;
      str1 = "";
      break;
      label147: str2 = "";
      break label58;
      label153: str3 = "";
      break label76;
      label160: str4 = "";
      break label95;
      label167: str5 = "";
      break label114;
      label174: localJSONObject = new JSONObject();
      break label133;
      localAdjustEventSuccess.eventToken = this.eventToken;
      localAdjustEventSuccess.message = this.message;
      localAdjustEventSuccess.timestamp = this.timestamp;
      localAdjustEventSuccess.adid = this.adid;
      localAdjustEventSuccess.callbackId = this.callbackId;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.EventResponseData
 * JD-Core Version:    0.6.2
 */
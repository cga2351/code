package com.adjust.sdk;

import org.json.JSONObject;

public class SessionResponseData extends ResponseData
{
  private String sdkPlatform;

  public SessionResponseData(ActivityPackage paramActivityPackage)
  {
    this.sdkPlatform = Util.getSdkPrefixPlatform(paramActivityPackage.getClientSdk());
  }

  public AdjustSessionFailure getFailureResponseData()
  {
    if (this.success)
      return null;
    AdjustSessionFailure localAdjustSessionFailure = new AdjustSessionFailure();
    String str1;
    String str2;
    label58: String str3;
    label76: JSONObject localJSONObject;
    if ("unity".equals(this.sdkPlatform))
      if (this.message != null)
      {
        str1 = this.message;
        localAdjustSessionFailure.message = str1;
        if (this.timestamp == null)
          break label117;
        str2 = this.timestamp;
        localAdjustSessionFailure.timestamp = str2;
        if (this.adid == null)
          break label123;
        str3 = this.adid;
        localAdjustSessionFailure.adid = str3;
        localAdjustSessionFailure.willRetry = this.willRetry;
        if (this.jsonResponse == null)
          break label130;
        localJSONObject = this.jsonResponse;
      }
    label103: for (localAdjustSessionFailure.jsonResponse = localJSONObject; ; localAdjustSessionFailure.jsonResponse = this.jsonResponse)
    {
      return localAdjustSessionFailure;
      str1 = "";
      break;
      label117: str2 = "";
      break label58;
      label123: str3 = "";
      break label76;
      localJSONObject = new JSONObject();
      break label103;
      localAdjustSessionFailure.message = this.message;
      localAdjustSessionFailure.timestamp = this.timestamp;
      localAdjustSessionFailure.adid = this.adid;
      localAdjustSessionFailure.willRetry = this.willRetry;
    }
  }

  public AdjustSessionSuccess getSuccessResponseData()
  {
    if (!this.success)
      return null;
    AdjustSessionSuccess localAdjustSessionSuccess = new AdjustSessionSuccess();
    String str1;
    String str2;
    label58: String str3;
    label76: JSONObject localJSONObject;
    if ("unity".equals(this.sdkPlatform))
      if (this.message != null)
      {
        str1 = this.message;
        localAdjustSessionSuccess.message = str1;
        if (this.timestamp == null)
          break label109;
        str2 = this.timestamp;
        localAdjustSessionSuccess.timestamp = str2;
        if (this.adid == null)
          break label115;
        str3 = this.adid;
        localAdjustSessionSuccess.adid = str3;
        if (this.jsonResponse == null)
          break label122;
        localJSONObject = this.jsonResponse;
      }
    label95: for (localAdjustSessionSuccess.jsonResponse = localJSONObject; ; localAdjustSessionSuccess.jsonResponse = this.jsonResponse)
    {
      return localAdjustSessionSuccess;
      str1 = "";
      break;
      label109: str2 = "";
      break label58;
      label115: str3 = "";
      break label76;
      label122: localJSONObject = new JSONObject();
      break label95;
      localAdjustSessionSuccess.message = this.message;
      localAdjustSessionSuccess.timestamp = this.timestamp;
      localAdjustSessionSuccess.adid = this.adid;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.SessionResponseData
 * JD-Core Version:    0.6.2
 */
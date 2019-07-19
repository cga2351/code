package com.adjust.sdk;

import org.json.JSONObject;

public class ResponseData
{
  public ActivityKind activityKind;
  public String adid;
  public AdjustAttribution attribution;
  public JSONObject jsonResponse;
  public String message;
  public boolean success;
  public String timestamp;
  public TrackingState trackingState;
  public boolean willRetry;

  public static ResponseData buildResponseData(ActivityPackage paramActivityPackage)
  {
    ActivityKind localActivityKind = paramActivityPackage.getActivityKind();
    Object localObject;
    switch (1.a[localActivityKind.ordinal()])
    {
    default:
      localObject = new ResponseData();
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      ((ResponseData)localObject).activityKind = localActivityKind;
      return localObject;
      localObject = new SessionResponseData(paramActivityPackage);
      continue;
      localObject = new SdkClickResponseData();
      continue;
      localObject = new AttributionResponseData();
      continue;
      localObject = new EventResponseData(paramActivityPackage);
    }
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.message;
    arrayOfObject[1] = this.timestamp;
    arrayOfObject[2] = this.jsonResponse;
    return Util.formatString("message:%s timestamp:%s json:%s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.ResponseData
 * JD-Core Version:    0.6.2
 */
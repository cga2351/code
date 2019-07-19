package com.mopub.common;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import org.json.JSONException;
import org.json.JSONObject;

public class MoPubAdvancedBidderData
{
  final String a;
  final String b;

  public MoPubAdvancedBidderData(String paramString1, String paramString2)
  {
    Preconditions.checkNotNull(paramString1);
    Preconditions.checkNotNull(paramString2);
    this.a = paramString1;
    this.b = paramString2;
  }

  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("token", this.a);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Invalid token format: " + this.a);
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
    }
    return localJSONObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.MoPubAdvancedBidderData
 * JD-Core Version:    0.6.2
 */
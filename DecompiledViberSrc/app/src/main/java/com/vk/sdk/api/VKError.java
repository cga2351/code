package com.vk.sdk.api;

import android.net.Uri;
import com.vk.sdk.VKObject;
import com.vk.sdk.util.VKJsonHelper;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class VKError extends VKObject
{
  private static final String ERROR_DESCRIPTION = "error_description";
  private static final String ERROR_REASON = "error_reason";
  private static final String FAIL = "fail";
  public static final int VK_API_ERROR = -101;
  public static final int VK_CANCELED = -102;
  public static final int VK_JSON_FAILED = -104;
  public static final int VK_REQUEST_HTTP_FAILED = -105;
  public static final int VK_REQUEST_NOT_PREPARED = -103;
  public VKError apiError;
  public String captchaImg;
  public String captchaSid;
  public int errorCode;
  public String errorMessage;
  public String errorReason;
  public Exception httpError;
  public String redirectUri;
  public VKRequest request;
  public ArrayList<Map<String, String>> requestParams;

  public VKError(int paramInt)
  {
    this.errorCode = paramInt;
  }

  public VKError(Map<String, String> paramMap)
  {
    this.errorCode = -101;
    this.errorReason = ((String)paramMap.get("error_reason"));
    this.errorMessage = Uri.decode((String)paramMap.get("error_description"));
    if (paramMap.containsKey("fail"))
      this.errorReason = "Action failed";
    if (paramMap.containsKey("cancel"))
    {
      this.errorCode = -102;
      this.errorReason = "User canceled request";
    }
  }

  public VKError(JSONObject paramJSONObject)
    throws JSONException
  {
    VKError localVKError = new VKError(paramJSONObject.getInt("error_code"));
    localVKError.errorMessage = paramJSONObject.getString("error_msg");
    localVKError.requestParams = ((ArrayList)VKJsonHelper.toList(paramJSONObject.getJSONArray("request_params")));
    if (localVKError.errorCode == 14)
    {
      localVKError.captchaImg = paramJSONObject.getString("captcha_img");
      localVKError.captchaSid = paramJSONObject.getString("captcha_sid");
    }
    if (localVKError.errorCode == 17)
      localVKError.redirectUri = paramJSONObject.getString("redirect_uri");
    this.errorCode = -101;
    this.apiError = localVKError;
  }

  private void appendFields(StringBuilder paramStringBuilder)
  {
    if (this.errorReason != null)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.errorReason;
      paramStringBuilder.append(String.format("; %s", arrayOfObject2));
    }
    if (this.errorMessage != null)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = this.errorMessage;
      paramStringBuilder.append(String.format("; %s", arrayOfObject1));
    }
  }

  public static VKError getRegisteredError(long paramLong)
  {
    return (VKError)getRegisteredObject(paramLong);
  }

  public void answerCaptcha(String paramString)
  {
    VKParameters localVKParameters = new VKParameters();
    localVKParameters.put("captcha_sid", this.captchaSid);
    localVKParameters.put("captcha_key", paramString);
    this.request.addExtraParameters(localVKParameters);
    this.request.repeat();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("VKError (");
    switch (this.errorCode)
    {
    default:
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.errorCode);
      localStringBuilder.append(String.format("code: %d; ", arrayOfObject));
    case -101:
    case -102:
    case -103:
    case -104:
    case -105:
    }
    while (true)
    {
      appendFields(localStringBuilder);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append("API error");
      if (this.apiError != null)
      {
        localStringBuilder.append(this.apiError.toString());
        continue;
        localStringBuilder.append("Canceled");
        continue;
        localStringBuilder.append("Request wasn't prepared");
        continue;
        localStringBuilder.append("JSON failed");
        continue;
        localStringBuilder.append("HTTP failed");
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.VKError
 * JD-Core Version:    0.6.2
 */
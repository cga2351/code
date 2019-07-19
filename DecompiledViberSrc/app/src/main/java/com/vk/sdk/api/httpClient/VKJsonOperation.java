package com.vk.sdk.api.httpClient;

import org.json.JSONObject;

public class VKJsonOperation extends VKHttpOperation<JSONObject>
{
  private JSONObject mResponseJson;

  public VKJsonOperation(VKHttpClient.VKHTTPRequest paramVKHTTPRequest)
  {
    super(paramVKHTTPRequest);
  }

  public JSONObject getResponseJson()
  {
    String str;
    if (this.mResponseJson == null)
    {
      str = getResponseString();
      if (str == null)
        return null;
    }
    try
    {
      this.mResponseJson = new JSONObject(str);
      return this.mResponseJson;
    }
    catch (Exception localException)
    {
      while (true)
        this.mLastException = localException;
    }
  }

  public JSONObject getResultObject()
  {
    return this.mResponseJson;
  }

  protected boolean postExecution()
  {
    if (!super.postExecution())
      return false;
    this.mResponseJson = getResponseJson();
    return true;
  }

  public static abstract class VKJSONOperationCompleteListener extends VKAbstractOperation.VKAbstractCompleteListener<VKJsonOperation, JSONObject>
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.httpClient.VKJsonOperation
 * JD-Core Version:    0.6.2
 */
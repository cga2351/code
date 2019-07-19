package com.vk.sdk.api.httpClient;

import com.vk.sdk.api.VKDefaultParser;
import com.vk.sdk.api.VKParser;
import com.vk.sdk.api.model.VKApiModel;
import org.json.JSONObject;

public class VKModelOperation extends VKJsonOperation
{
  protected final VKParser mParser;
  public Object parsedModel;

  public VKModelOperation(VKHttpClient.VKHTTPRequest paramVKHTTPRequest, VKParser paramVKParser)
  {
    super(paramVKHTTPRequest);
    this.mParser = paramVKParser;
  }

  public VKModelOperation(VKHttpClient.VKHTTPRequest paramVKHTTPRequest, Class<? extends VKApiModel> paramClass)
  {
    super(paramVKHTTPRequest);
    this.mParser = new VKDefaultParser(paramClass);
  }

  protected boolean postExecution()
  {
    if (!super.postExecution());
    while (this.mParser == null)
      return false;
    try
    {
      JSONObject localJSONObject = getResponseJson();
      this.parsedModel = this.mParser.createModel(localJSONObject);
      return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.httpClient.VKModelOperation
 * JD-Core Version:    0.6.2
 */
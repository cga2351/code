package com.vk.sdk.api;

import com.vk.sdk.api.model.VKApiModel;
import org.json.JSONObject;

public class VKDefaultParser extends VKParser
{
  private final Class<? extends VKApiModel> mModelClass;

  public VKDefaultParser(Class<? extends VKApiModel> paramClass)
  {
    this.mModelClass = paramClass;
  }

  public Object createModel(JSONObject paramJSONObject)
  {
    try
    {
      VKApiModel localVKApiModel = (VKApiModel)this.mModelClass.newInstance();
      localVKApiModel.parse(paramJSONObject);
      return localVKApiModel;
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.VKDefaultParser
 * JD-Core Version:    0.6.2
 */
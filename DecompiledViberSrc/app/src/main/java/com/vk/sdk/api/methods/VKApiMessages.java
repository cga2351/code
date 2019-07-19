package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKParser;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKApiGetDialogResponse;
import com.vk.sdk.api.model.VKApiGetMessagesResponse;
import org.json.JSONObject;

public class VKApiMessages extends VKApiBase
{
  public VKRequest get()
  {
    return get(VKParameters.from(new Object[] { "count", "10" }));
  }

  public VKRequest get(VKParameters paramVKParameters)
  {
    return prepareRequest("get", paramVKParameters, new VKParser()
    {
      public Object createModel(JSONObject paramAnonymousJSONObject)
      {
        return new VKApiGetMessagesResponse(paramAnonymousJSONObject);
      }
    });
  }

  public VKRequest getDialogs()
  {
    return getDialogs(VKParameters.from(new Object[] { "count", "5" }));
  }

  public VKRequest getDialogs(VKParameters paramVKParameters)
  {
    return prepareRequest("getDialogs", paramVKParameters, new VKParser()
    {
      public Object createModel(JSONObject paramAnonymousJSONObject)
      {
        return new VKApiGetDialogResponse(paramAnonymousJSONObject);
      }
    });
  }

  protected String getMethodsGroup()
  {
    return "messages";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.methods.VKApiMessages
 * JD-Core Version:    0.6.2
 */
package com.vk.sdk.api.model;

import org.json.JSONException;
import org.json.JSONObject;

public class VKApiCommunityArray extends VKList<VKApiCommunityFull>
{
  public VKApiModel parse(JSONObject paramJSONObject)
    throws JSONException
  {
    fill(paramJSONObject, VKApiCommunityFull.class);
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiCommunityArray
 * JD-Core Version:    0.6.2
 */
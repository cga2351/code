package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKParser;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKApiUserFull;
import com.vk.sdk.api.model.VKList;
import com.vk.sdk.api.model.VKUsersArray;
import org.json.JSONObject;

public class VKApiUsers extends VKApiBase
{
  public VKRequest get()
  {
    return get(null);
  }

  public VKRequest get(VKParameters paramVKParameters)
  {
    return prepareRequest("get", paramVKParameters, new VKParser()
    {
      public Object createModel(JSONObject paramAnonymousJSONObject)
      {
        return new VKList(paramAnonymousJSONObject, VKApiUserFull.class);
      }
    });
  }

  public VKRequest getFollowers()
  {
    return getFollowers(null);
  }

  public VKRequest getFollowers(VKParameters paramVKParameters)
  {
    return prepareRequest("getFollowers", paramVKParameters);
  }

  protected String getMethodsGroup()
  {
    return "users";
  }

  public VKRequest getSubscriptions()
  {
    return getSubscriptions(null);
  }

  public VKRequest getSubscriptions(VKParameters paramVKParameters)
  {
    return prepareRequest("getSubscriptions", paramVKParameters);
  }

  public VKRequest isAppUser()
  {
    return prepareRequest("isAppUser", null);
  }

  public VKRequest isAppUser(final int paramInt)
  {
    return prepareRequest("isAppUser", new VKParameters()
    {
      private static final long serialVersionUID = 7458591447441581671L;
    });
  }

  public VKRequest report(VKParameters paramVKParameters)
  {
    return prepareRequest("report", paramVKParameters);
  }

  public VKRequest search(VKParameters paramVKParameters)
  {
    return prepareRequest("search", paramVKParameters, VKUsersArray.class);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.methods.VKApiUsers
 * JD-Core Version:    0.6.2
 */
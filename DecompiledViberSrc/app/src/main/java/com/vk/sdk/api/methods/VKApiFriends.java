package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKUsersArray;

public class VKApiFriends extends VKApiBase
{
  public VKRequest add(VKParameters paramVKParameters)
  {
    return prepareRequest("add", paramVKParameters);
  }

  public VKRequest addList(VKParameters paramVKParameters)
  {
    return prepareRequest("addList", paramVKParameters);
  }

  public VKRequest areFriends(VKParameters paramVKParameters)
  {
    return prepareRequest("areFriends", paramVKParameters);
  }

  public VKRequest delete(VKParameters paramVKParameters)
  {
    return prepareRequest("delete", paramVKParameters);
  }

  public VKRequest deleteAllRequests(VKParameters paramVKParameters)
  {
    return prepareRequest("deleteAllRequests", paramVKParameters);
  }

  public VKRequest deleteList(VKParameters paramVKParameters)
  {
    return prepareRequest("deleteList", paramVKParameters);
  }

  public VKRequest edit(VKParameters paramVKParameters)
  {
    return prepareRequest("edit", paramVKParameters);
  }

  public VKRequest editList(VKParameters paramVKParameters)
  {
    return prepareRequest("editList", paramVKParameters);
  }

  public VKRequest get(VKParameters paramVKParameters)
  {
    if (paramVKParameters.get("fields") != null)
      return prepareRequest("get", paramVKParameters, VKUsersArray.class);
    return prepareRequest("get", paramVKParameters);
  }

  public VKRequest getAppUsers(VKParameters paramVKParameters)
  {
    return prepareRequest("getAppUsers", paramVKParameters);
  }

  public VKRequest getByPhones(VKParameters paramVKParameters)
  {
    return prepareRequest("getByPhones", paramVKParameters, VKUsersArray.class);
  }

  public VKRequest getLists(VKParameters paramVKParameters)
  {
    return prepareRequest("getLists", paramVKParameters);
  }

  protected String getMethodsGroup()
  {
    return "friends";
  }

  public VKRequest getMutual(VKParameters paramVKParameters)
  {
    return prepareRequest("getMutual", paramVKParameters);
  }

  public VKRequest getOnline(VKParameters paramVKParameters)
  {
    return prepareRequest("getOnline", paramVKParameters);
  }

  public VKRequest getRecent(VKParameters paramVKParameters)
  {
    return prepareRequest("getRecent", paramVKParameters);
  }

  public VKRequest getRequests(VKParameters paramVKParameters)
  {
    return prepareRequest("getRequests", paramVKParameters);
  }

  public VKRequest getSuggestions(VKParameters paramVKParameters)
  {
    return prepareRequest("getSuggestions", paramVKParameters);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.methods.VKApiFriends
 * JD-Core Version:    0.6.2
 */
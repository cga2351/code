package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKApiCommunityArray;
import com.vk.sdk.api.model.VKUsersArray;

public class VKApiGroups extends VKApiBase
{
  public VKRequest banUser(VKParameters paramVKParameters)
  {
    return prepareRequest("banUser", paramVKParameters);
  }

  public VKRequest get(VKParameters paramVKParameters)
  {
    if ((paramVKParameters.containsKey("extended")) && (((Integer)paramVKParameters.get("extended")).intValue() == 1))
      return prepareRequest("get", paramVKParameters, VKApiCommunityArray.class);
    return prepareRequest("get", paramVKParameters);
  }

  public VKRequest getBanned(VKParameters paramVKParameters)
  {
    return prepareRequest("getBanned", paramVKParameters, VKUsersArray.class);
  }

  public VKRequest getById(VKParameters paramVKParameters)
  {
    return prepareRequest("getById", paramVKParameters, VKApiCommunityArray.class);
  }

  public VKRequest getInvites(VKParameters paramVKParameters)
  {
    return prepareRequest("getInvites", paramVKParameters, VKApiCommunityArray.class);
  }

  public VKRequest getMembers(VKParameters paramVKParameters)
  {
    return prepareRequest("getMembers", paramVKParameters);
  }

  protected String getMethodsGroup()
  {
    return "groups";
  }

  public VKRequest isMember(VKParameters paramVKParameters)
  {
    return prepareRequest("isMember", paramVKParameters);
  }

  public VKRequest join(VKParameters paramVKParameters)
  {
    return prepareRequest("join", paramVKParameters);
  }

  public VKRequest leave(final int paramInt)
  {
    return prepareRequest("leave", new VKParameters()
    {
    });
  }

  public VKRequest leave(VKParameters paramVKParameters)
  {
    return prepareRequest("leave", paramVKParameters);
  }

  public VKRequest search(VKParameters paramVKParameters)
  {
    return prepareRequest("search", paramVKParameters, VKApiCommunityArray.class);
  }

  public VKRequest unbanUser(VKParameters paramVKParameters)
  {
    return prepareRequest("unbanUser", paramVKParameters);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.methods.VKApiGroups
 * JD-Core Version:    0.6.2
 */
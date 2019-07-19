package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKCommentArray;
import com.vk.sdk.api.model.VKPostArray;
import com.vk.sdk.api.model.VKWallPostResult;

public class VKApiWall extends VKApiBase
{
  public static final String EXTENDED = "extended";

  public VKRequest addComment(VKParameters paramVKParameters)
  {
    return prepareRequest("addComment", paramVKParameters);
  }

  public VKRequest delete(VKParameters paramVKParameters)
  {
    return prepareRequest("delete", paramVKParameters);
  }

  public VKRequest deleteComment(VKParameters paramVKParameters)
  {
    return prepareRequest("deleteComment", paramVKParameters);
  }

  public VKRequest edit(VKParameters paramVKParameters)
  {
    return prepareRequest("edit", paramVKParameters);
  }

  public VKRequest editComment(VKParameters paramVKParameters)
  {
    return prepareRequest("editComment", paramVKParameters);
  }

  public VKRequest get(VKParameters paramVKParameters)
  {
    if ((paramVKParameters.containsKey("extended")) && (((Integer)paramVKParameters.get("extended")).intValue() == 1))
      return prepareRequest("get", paramVKParameters, VKPostArray.class);
    return prepareRequest("get", paramVKParameters);
  }

  public VKRequest getById(VKParameters paramVKParameters)
  {
    return prepareRequest("getById", paramVKParameters, VKPostArray.class);
  }

  public VKRequest getComments(VKParameters paramVKParameters)
  {
    return prepareRequest("getComments", paramVKParameters, VKCommentArray.class);
  }

  protected String getMethodsGroup()
  {
    return "wall";
  }

  public VKRequest getReposts(VKParameters paramVKParameters)
  {
    return prepareRequest("getReposts", paramVKParameters);
  }

  public VKRequest post(VKParameters paramVKParameters)
  {
    return prepareRequest("post", paramVKParameters, VKWallPostResult.class);
  }

  public VKRequest reportComment(VKParameters paramVKParameters)
  {
    return prepareRequest("reportComment", paramVKParameters);
  }

  public VKRequest reportPost(VKParameters paramVKParameters)
  {
    return prepareRequest("reportPost", paramVKParameters);
  }

  public VKRequest repost(VKParameters paramVKParameters)
  {
    return prepareRequest("repost", paramVKParameters);
  }

  public VKRequest restore(VKParameters paramVKParameters)
  {
    return prepareRequest("restore", paramVKParameters);
  }

  public VKRequest restoreComment(VKParameters paramVKParameters)
  {
    return prepareRequest("restoreComment", paramVKParameters);
  }

  public VKRequest savePost(VKParameters paramVKParameters)
  {
    return prepareRequest("savePost", paramVKParameters);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.methods.VKApiWall
 * JD-Core Version:    0.6.2
 */
package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VkVideoArray;

public class VKApiVideo extends VKApiBase
{
  public VKRequest add(VKParameters paramVKParameters)
  {
    return prepareRequest("add", paramVKParameters);
  }

  public VKRequest addAlbum(VKParameters paramVKParameters)
  {
    return prepareRequest("addAlbum", paramVKParameters);
  }

  public VKRequest addToAlbum(VKParameters paramVKParameters)
  {
    return prepareRequest("addToAlbum", paramVKParameters);
  }

  public VKRequest createComment(VKParameters paramVKParameters)
  {
    return prepareRequest("createComment", paramVKParameters);
  }

  public VKRequest delete(VKParameters paramVKParameters)
  {
    return prepareRequest("delete", paramVKParameters);
  }

  public VKRequest deleteAlbum(VKParameters paramVKParameters)
  {
    return prepareRequest("deleteAlbum", paramVKParameters);
  }

  public VKRequest deleteComment(VKParameters paramVKParameters)
  {
    return prepareRequest("deleteComment", paramVKParameters);
  }

  public VKRequest edit(VKParameters paramVKParameters)
  {
    return prepareRequest("edit", paramVKParameters);
  }

  public VKRequest editAlbum(VKParameters paramVKParameters)
  {
    return prepareRequest("editAlbum", paramVKParameters);
  }

  public VKRequest editComment(VKParameters paramVKParameters)
  {
    return prepareRequest("editComment", paramVKParameters);
  }

  public VKRequest get()
  {
    return get(null);
  }

  public VKRequest get(VKParameters paramVKParameters)
  {
    return prepareRequest("get", paramVKParameters, VkVideoArray.class);
  }

  public VKRequest getAlbumById(VKParameters paramVKParameters)
  {
    return prepareRequest("getAlbumById", paramVKParameters);
  }

  public VKRequest getAlbums()
  {
    return getAlbums(null);
  }

  public VKRequest getAlbums(VKParameters paramVKParameters)
  {
    return prepareRequest("getAlbums", paramVKParameters);
  }

  public VKRequest getAlbumsByVideo(VKParameters paramVKParameters)
  {
    return prepareRequest("getAlbumsByVideo", paramVKParameters);
  }

  public VKRequest getComments(VKParameters paramVKParameters)
  {
    return prepareRequest("getComments", paramVKParameters);
  }

  protected String getMethodsGroup()
  {
    return "video";
  }

  public VKRequest getNewTags(VKParameters paramVKParameters)
  {
    return prepareRequest("getNewTags", paramVKParameters);
  }

  public VKRequest getTags(VKParameters paramVKParameters)
  {
    return prepareRequest("getTags", paramVKParameters);
  }

  public VKRequest getUserVideos(VKParameters paramVKParameters)
  {
    return prepareRequest("getUserVideos", paramVKParameters, VkVideoArray.class);
  }

  public VKRequest putTag(VKParameters paramVKParameters)
  {
    return prepareRequest("putTag", paramVKParameters);
  }

  public VKRequest removeFromAlbum(VKParameters paramVKParameters)
  {
    return prepareRequest("removeFromAlbum", paramVKParameters);
  }

  public VKRequest removeTag(VKParameters paramVKParameters)
  {
    return prepareRequest("removeTag", paramVKParameters);
  }

  public VKRequest reorderAlbums(VKParameters paramVKParameters)
  {
    return prepareRequest("getAlbumById", paramVKParameters);
  }

  public VKRequest reorderVideos(VKParameters paramVKParameters)
  {
    return prepareRequest("getAlbumById", paramVKParameters);
  }

  public VKRequest report(VKParameters paramVKParameters)
  {
    return prepareRequest("report", paramVKParameters);
  }

  public VKRequest reportComment(VKParameters paramVKParameters)
  {
    return prepareRequest("reportComment", paramVKParameters);
  }

  public VKRequest restore(VKParameters paramVKParameters)
  {
    return prepareRequest("restore", paramVKParameters);
  }

  public VKRequest restoreComment(VKParameters paramVKParameters)
  {
    return prepareRequest("restoreComment", paramVKParameters);
  }

  public VKRequest save(VKParameters paramVKParameters)
  {
    return prepareRequest("save", paramVKParameters);
  }

  public VKRequest search(VKParameters paramVKParameters)
  {
    return prepareRequest("search", paramVKParameters, VkVideoArray.class);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.methods.VKApiVideo
 * JD-Core Version:    0.6.2
 */
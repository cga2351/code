package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VkAudioArray;

public class VKApiAudio extends VKApiBase
{
  public VKRequest add(VKParameters paramVKParameters)
  {
    return prepareRequest("add", paramVKParameters);
  }

  public VKRequest addAlbum(VKParameters paramVKParameters)
  {
    return prepareRequest("addAlbum", paramVKParameters);
  }

  public VKRequest delete(VKParameters paramVKParameters)
  {
    return prepareRequest("delete", paramVKParameters);
  }

  public VKRequest deleteAlbum(VKParameters paramVKParameters)
  {
    return prepareRequest("deleteAlbum", paramVKParameters);
  }

  public VKRequest edit(VKParameters paramVKParameters)
  {
    return prepareRequest("edit", paramVKParameters);
  }

  public VKRequest editAlbum(VKParameters paramVKParameters)
  {
    return prepareRequest("editAlbum", paramVKParameters);
  }

  public VKRequest get()
  {
    return get(null);
  }

  public VKRequest get(VKParameters paramVKParameters)
  {
    return prepareRequest("get", paramVKParameters, VkAudioArray.class);
  }

  public VKRequest getAlbums()
  {
    return getAlbums(null);
  }

  public VKRequest getAlbums(VKParameters paramVKParameters)
  {
    return prepareRequest("getAlbums", paramVKParameters);
  }

  public VKRequest getBroadcastList()
  {
    return getBroadcastList(null);
  }

  public VKRequest getBroadcastList(VKParameters paramVKParameters)
  {
    return prepareRequest("getBroadcastList", paramVKParameters);
  }

  public VKRequest getById(VKParameters paramVKParameters)
  {
    return prepareRequest("getById", paramVKParameters);
  }

  public VKRequest getCount(VKParameters paramVKParameters)
  {
    return prepareRequest("getCount", paramVKParameters);
  }

  public VKRequest getLyrics(VKParameters paramVKParameters)
  {
    return prepareRequest("getLyrics", paramVKParameters);
  }

  protected String getMethodsGroup()
  {
    return "audio";
  }

  public VKRequest getPopular()
  {
    return getPopular(null);
  }

  public VKRequest getPopular(VKParameters paramVKParameters)
  {
    return prepareRequest("getPopular", paramVKParameters, VkAudioArray.class);
  }

  public VKRequest getRecommendations()
  {
    return getRecommendations(null);
  }

  public VKRequest getRecommendations(VKParameters paramVKParameters)
  {
    return prepareRequest("getRecommendations", paramVKParameters, VkAudioArray.class);
  }

  public VKRequest getUploadServer()
  {
    return getUploadServer(null);
  }

  public VKRequest getUploadServer(VKParameters paramVKParameters)
  {
    return prepareRequest("getUploadServer", paramVKParameters);
  }

  public VKRequest moveToAlbum(VKParameters paramVKParameters)
  {
    return prepareRequest("moveToAlbum", paramVKParameters);
  }

  public VKRequest reorder(VKParameters paramVKParameters)
  {
    return prepareRequest("reorder", paramVKParameters);
  }

  public VKRequest restore(VKParameters paramVKParameters)
  {
    return prepareRequest("restore", paramVKParameters);
  }

  public VKRequest save(VKParameters paramVKParameters)
  {
    return prepareRequest("save", paramVKParameters);
  }

  public VKRequest search(VKParameters paramVKParameters)
  {
    return prepareRequest("search", paramVKParameters, VkAudioArray.class);
  }

  public VKRequest setBroadcast(VKParameters paramVKParameters)
  {
    return prepareRequest("setBroadcast", paramVKParameters);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.methods.VKApiAudio
 * JD-Core Version:    0.6.2
 */
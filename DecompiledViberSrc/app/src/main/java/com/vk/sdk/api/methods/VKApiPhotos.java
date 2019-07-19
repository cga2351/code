package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.util.VKUtil;

public class VKApiPhotos extends VKApiBase
{
  public VKRequest getMessagesUploadServer()
  {
    return prepareRequest("getMessagesUploadServer", null);
  }

  protected String getMethodsGroup()
  {
    return "photos";
  }

  public VKRequest getUploadServer(long paramLong)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "album_id";
    arrayOfObject[1] = String.valueOf(paramLong);
    return prepareRequest("getUploadServer", VKUtil.paramsFrom(arrayOfObject));
  }

  public VKRequest getUploadServer(long paramLong1, long paramLong2)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = "album_id";
    arrayOfObject[1] = Long.valueOf(paramLong1);
    arrayOfObject[2] = "group_id";
    arrayOfObject[3] = Long.valueOf(paramLong2);
    return prepareRequest("getUploadServer", VKUtil.paramsFrom(arrayOfObject));
  }

  public VKRequest getWallUploadServer()
  {
    return prepareRequest("getWallUploadServer", null);
  }

  public VKRequest getWallUploadServer(long paramLong)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "group_id";
    arrayOfObject[1] = Long.valueOf(paramLong);
    return prepareRequest("getWallUploadServer", VKUtil.paramsFrom(arrayOfObject));
  }

  public VKRequest save(VKParameters paramVKParameters)
  {
    return prepareRequest("save", paramVKParameters, VKPhotoArray.class);
  }

  public VKRequest saveMessagesPhoto(VKParameters paramVKParameters)
  {
    return prepareRequest("saveMessagesPhoto", paramVKParameters, VKPhotoArray.class);
  }

  public VKRequest saveWallPhoto(VKParameters paramVKParameters)
  {
    return prepareRequest("saveWallPhoto", paramVKParameters, VKPhotoArray.class);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.methods.VKApiPhotos
 * JD-Core Version:    0.6.2
 */
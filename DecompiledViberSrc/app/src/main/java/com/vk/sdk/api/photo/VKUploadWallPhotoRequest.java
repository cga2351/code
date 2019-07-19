package com.vk.sdk.api.photo;

import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.methods.VKApiPhotos;
import com.vk.sdk.util.VKJsonHelper;
import com.vk.sdk.util.VKUtil;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class VKUploadWallPhotoRequest extends VKUploadPhotoBase
{
  private static final long serialVersionUID = 4732771149932923938L;

  public VKUploadWallPhotoRequest(VKUploadImage paramVKUploadImage, long paramLong, int paramInt)
  {
    this.mUserId = paramLong;
    this.mGroupId = paramInt;
    File[] arrayOfFile = new File[1];
    arrayOfFile[0] = paramVKUploadImage.getTmpFile();
    this.mImages = arrayOfFile;
  }

  public VKUploadWallPhotoRequest(File paramFile, long paramLong, int paramInt)
  {
    this.mUserId = paramLong;
    this.mGroupId = paramInt;
    this.mImages = new File[] { paramFile };
  }

  public VKUploadWallPhotoRequest(VKUploadImage[] paramArrayOfVKUploadImage, long paramLong, int paramInt)
  {
    this.mUserId = paramLong;
    this.mGroupId = paramInt;
    this.mImages = new File[paramArrayOfVKUploadImage.length];
    for (int i = 0; i < paramArrayOfVKUploadImage.length; i++)
      this.mImages[i] = paramArrayOfVKUploadImage[i].getTmpFile();
  }

  protected VKRequest getSaveRequest(JSONObject paramJSONObject)
  {
    try
    {
      VKRequest localVKRequest = VKApi.photos().saveWallPhoto(new VKParameters(VKJsonHelper.toMap(paramJSONObject)));
      if (this.mUserId != 0L)
      {
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = "user_id";
        arrayOfObject2[1] = Long.valueOf(this.mUserId);
        localVKRequest.addExtraParameters(VKUtil.paramsFrom(arrayOfObject2));
      }
      if (this.mGroupId != 0L)
      {
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = "group_id";
        arrayOfObject1[1] = Long.valueOf(this.mGroupId);
        localVKRequest.addExtraParameters(VKUtil.paramsFrom(arrayOfObject1));
      }
      return localVKRequest;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  protected VKRequest getServerRequest()
  {
    if (this.mGroupId != 0L)
      return VKApi.photos().getWallUploadServer(this.mGroupId);
    return VKApi.photos().getWallUploadServer();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.photo.VKUploadWallPhotoRequest
 * JD-Core Version:    0.6.2
 */
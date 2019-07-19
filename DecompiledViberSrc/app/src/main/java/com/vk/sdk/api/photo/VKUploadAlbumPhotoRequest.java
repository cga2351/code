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

public class VKUploadAlbumPhotoRequest extends VKUploadPhotoBase
{
  private static final long serialVersionUID = 5439648671595840976L;

  public VKUploadAlbumPhotoRequest(VKUploadImage paramVKUploadImage, long paramLong1, long paramLong2)
  {
    this.mAlbumId = paramLong1;
    this.mGroupId = paramLong2;
    File[] arrayOfFile = new File[1];
    arrayOfFile[0] = paramVKUploadImage.getTmpFile();
    this.mImages = arrayOfFile;
  }

  public VKUploadAlbumPhotoRequest(File paramFile, long paramLong1, long paramLong2)
  {
    this.mAlbumId = paramLong1;
    this.mGroupId = paramLong2;
    this.mImages = new File[] { paramFile };
  }

  protected VKRequest getSaveRequest(JSONObject paramJSONObject)
  {
    try
    {
      VKRequest localVKRequest = VKApi.photos().save(new VKParameters(VKJsonHelper.toMap(paramJSONObject)));
      if (this.mAlbumId != 0L)
      {
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = "album_id";
        arrayOfObject2[1] = Long.valueOf(this.mAlbumId);
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
    if ((this.mAlbumId != 0L) && (this.mGroupId != 0L))
      return VKApi.photos().getUploadServer(this.mAlbumId, this.mGroupId);
    return VKApi.photos().getUploadServer(this.mAlbumId);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.photo.VKUploadAlbumPhotoRequest
 * JD-Core Version:    0.6.2
 */
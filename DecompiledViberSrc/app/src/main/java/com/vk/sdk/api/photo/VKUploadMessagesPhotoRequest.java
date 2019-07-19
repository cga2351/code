package com.vk.sdk.api.photo;

import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.methods.VKApiPhotos;
import com.vk.sdk.util.VKJsonHelper;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class VKUploadMessagesPhotoRequest extends VKUploadPhotoBase
{
  private static final long serialVersionUID = 1L;

  public VKUploadMessagesPhotoRequest(VKUploadImage paramVKUploadImage)
  {
    File[] arrayOfFile = new File[1];
    arrayOfFile[0] = paramVKUploadImage.getTmpFile();
    this.mImages = arrayOfFile;
  }

  public VKUploadMessagesPhotoRequest(File paramFile)
  {
    this.mImages = new File[] { paramFile };
  }

  protected VKRequest getSaveRequest(JSONObject paramJSONObject)
  {
    try
    {
      VKRequest localVKRequest = VKApi.photos().saveMessagesPhoto(new VKParameters(VKJsonHelper.toMap(paramJSONObject)));
      return localVKRequest;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  protected VKRequest getServerRequest()
  {
    return VKApi.photos().getMessagesUploadServer();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.photo.VKUploadMessagesPhotoRequest
 * JD-Core Version:    0.6.2
 */
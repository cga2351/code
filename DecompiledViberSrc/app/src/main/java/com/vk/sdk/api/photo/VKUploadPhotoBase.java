package com.vk.sdk.api.photo;

import com.vk.sdk.api.VKUploadBase;
import com.vk.sdk.api.httpClient.VKHttpClient;
import com.vk.sdk.api.httpClient.VKJsonOperation;
import java.io.File;

public abstract class VKUploadPhotoBase extends VKUploadBase
{
  private static final long serialVersionUID = -4566961568409572159L;
  protected long mAlbumId;
  protected long mGroupId;
  protected File[] mImages;
  protected long mUserId;

  protected VKJsonOperation getUploadOperation(String paramString)
  {
    return new VKJsonOperation(VKHttpClient.fileUploadRequest(paramString, this.mImages));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.photo.VKUploadPhotoBase
 * JD-Core Version:    0.6.2
 */
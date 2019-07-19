package com.vk.sdk.api.docs;

import com.vk.sdk.api.VKUploadBase;
import com.vk.sdk.api.httpClient.VKHttpClient;
import com.vk.sdk.api.httpClient.VKJsonOperation;
import java.io.File;

public abstract class VKUploadDocBase extends VKUploadBase
{
  protected File mDoc;
  protected long mGroupId;

  protected VKJsonOperation getUploadOperation(String paramString)
  {
    return new VKJsonOperation(VKHttpClient.docUploadRequest(paramString, this.mDoc));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.docs.VKUploadDocBase
 * JD-Core Version:    0.6.2
 */
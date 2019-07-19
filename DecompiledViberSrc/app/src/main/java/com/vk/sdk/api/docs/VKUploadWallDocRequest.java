package com.vk.sdk.api.docs;

import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.methods.VKApiDocs;
import com.vk.sdk.util.VKJsonHelper;
import com.vk.sdk.util.VKUtil;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class VKUploadWallDocRequest extends VKUploadDocBase
{
  public VKUploadWallDocRequest(File paramFile)
  {
    this.mDoc = paramFile;
    this.mGroupId = 0L;
  }

  public VKUploadWallDocRequest(File paramFile, long paramLong)
  {
    this.mDoc = paramFile;
    this.mGroupId = paramLong;
  }

  protected VKRequest getSaveRequest(JSONObject paramJSONObject)
  {
    try
    {
      VKRequest localVKRequest = VKApi.docs().save(new VKParameters(VKJsonHelper.toMap(paramJSONObject)));
      if (this.mGroupId != 0L)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = "group_id";
        arrayOfObject[1] = Long.valueOf(this.mGroupId);
        localVKRequest.addExtraParameters(VKUtil.paramsFrom(arrayOfObject));
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
      return VKApi.docs().getUploadWallServer(this.mGroupId);
    return VKApi.docs().getUploadWallServer();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.docs.VKUploadWallDocRequest
 * JD-Core Version:    0.6.2
 */
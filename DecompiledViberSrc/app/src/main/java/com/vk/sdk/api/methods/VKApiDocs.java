package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.docs.VKUploadDocRequest;
import com.vk.sdk.api.docs.VKUploadWallDocRequest;
import com.vk.sdk.api.model.VKDocsArray;
import com.vk.sdk.util.VKUtil;
import java.io.File;

public class VKApiDocs extends VKApiBase
{
  protected String getMethodsGroup()
  {
    return "docs";
  }

  public VKRequest getUploadServer()
  {
    return prepareRequest("getUploadServer", null);
  }

  public VKRequest getUploadServer(long paramLong)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "group_id";
    arrayOfObject[1] = Long.valueOf(paramLong);
    return prepareRequest("getUploadServer", VKUtil.paramsFrom(arrayOfObject));
  }

  public VKRequest getUploadWallServer()
  {
    return prepareRequest("getWallUploadServer", null);
  }

  public VKRequest getUploadWallServer(long paramLong)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "group_id";
    arrayOfObject[1] = Long.valueOf(paramLong);
    return prepareRequest("getWallUploadServer", VKUtil.paramsFrom(arrayOfObject));
  }

  public VKRequest save(VKParameters paramVKParameters)
  {
    return prepareRequest("save", paramVKParameters, VKDocsArray.class);
  }

  public VKRequest uploadDocRequest(File paramFile)
  {
    return new VKUploadDocRequest(paramFile);
  }

  public VKRequest uploadDocRequest(File paramFile, long paramLong)
  {
    return new VKUploadDocRequest(paramFile, paramLong);
  }

  public VKRequest uploadWallDocRequest(File paramFile)
  {
    return new VKUploadWallDocRequest(paramFile);
  }

  public VKRequest uploadWallDocRequest(File paramFile, long paramLong)
  {
    return new VKUploadWallDocRequest(paramFile, paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.methods.VKApiDocs
 * JD-Core Version:    0.6.2
 */
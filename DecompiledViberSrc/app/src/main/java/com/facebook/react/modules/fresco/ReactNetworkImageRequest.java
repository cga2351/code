package com.facebook.react.modules.fresco;

import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.ReadableMap;

public class ReactNetworkImageRequest extends ImageRequest
{
  private final ReadableMap mHeaders;

  protected ReactNetworkImageRequest(ImageRequestBuilder paramImageRequestBuilder, ReadableMap paramReadableMap)
  {
    super(paramImageRequestBuilder);
    this.mHeaders = paramReadableMap;
  }

  public static ReactNetworkImageRequest fromBuilderWithHeaders(ImageRequestBuilder paramImageRequestBuilder, ReadableMap paramReadableMap)
  {
    return new ReactNetworkImageRequest(paramImageRequestBuilder, paramReadableMap);
  }

  public ReadableMap getHeaders()
  {
    return this.mHeaders;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.fresco.ReactNetworkImageRequest
 * JD-Core Version:    0.6.2
 */
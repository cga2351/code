package com.facebook.imagepipeline.backends.okhttp3;

import android.content.Context;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineConfig.Builder;
import okhttp3.OkHttpClient;

public class OkHttpImagePipelineConfigFactory
{
  public static ImagePipelineConfig.Builder newBuilder(Context paramContext, OkHttpClient paramOkHttpClient)
  {
    return ImagePipelineConfig.newBuilder(paramContext).setNetworkFetcher(new OkHttpNetworkFetcher(paramOkHttpClient));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory
 * JD-Core Version:    0.6.2
 */
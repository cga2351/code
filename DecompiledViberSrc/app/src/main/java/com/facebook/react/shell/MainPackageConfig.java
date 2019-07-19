package com.facebook.react.shell;

import com.facebook.imagepipeline.core.ImagePipelineConfig;

public class MainPackageConfig
{
  private ImagePipelineConfig mFrescoConfig;

  private MainPackageConfig(Builder paramBuilder)
  {
    this.mFrescoConfig = paramBuilder.mFrescoConfig;
  }

  public ImagePipelineConfig getFrescoConfig()
  {
    return this.mFrescoConfig;
  }

  public static class Builder
  {
    private ImagePipelineConfig mFrescoConfig;

    public MainPackageConfig build()
    {
      return new MainPackageConfig(this, null);
    }

    public Builder setFrescoConfig(ImagePipelineConfig paramImagePipelineConfig)
    {
      this.mFrescoConfig = paramImagePipelineConfig;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.shell.MainPackageConfig
 * JD-Core Version:    0.6.2
 */
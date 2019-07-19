package com.facebook.imagepipeline.nativecode;

import com.facebook.soloader.SoLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImagePipelineNativeLoader
{
  public static final List<String> DEPENDENCIES = Collections.unmodifiableList(new ArrayList());
  public static final String DSO_NAME = "imagepipeline";

  public static void load()
  {
    SoLoader.loadLibrary("imagepipeline");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.nativecode.ImagePipelineNativeLoader
 * JD-Core Version:    0.6.2
 */
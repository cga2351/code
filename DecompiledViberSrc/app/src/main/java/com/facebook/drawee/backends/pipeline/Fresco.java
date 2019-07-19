package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.soloader.SoLoader;
import java.io.IOException;
import javax.annotation.Nullable;

public class Fresco
{
  private static final Class<?> TAG = Fresco.class;
  private static PipelineDraweeControllerBuilderSupplier sDraweeControllerBuilderSupplier;
  private static volatile boolean sIsInitialized = false;

  public static PipelineDraweeControllerBuilderSupplier getDraweeControllerBuilderSupplier()
  {
    return sDraweeControllerBuilderSupplier;
  }

  public static ImagePipeline getImagePipeline()
  {
    return getImagePipelineFactory().getImagePipeline();
  }

  public static ImagePipelineFactory getImagePipelineFactory()
  {
    return ImagePipelineFactory.getInstance();
  }

  public static boolean hasBeenInitialized()
  {
    return sIsInitialized;
  }

  public static void initialize(Context paramContext)
  {
    initialize(paramContext, null, null);
  }

  public static void initialize(Context paramContext, @Nullable ImagePipelineConfig paramImagePipelineConfig)
  {
    initialize(paramContext, paramImagePipelineConfig, null);
  }

  public static void initialize(Context paramContext, @Nullable ImagePipelineConfig paramImagePipelineConfig, @Nullable DraweeConfig paramDraweeConfig)
  {
    if (sIsInitialized)
      FLog.w(TAG, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
    while (true)
    {
      try
      {
        SoLoader.init(paramContext, 0);
        Context localContext = paramContext.getApplicationContext();
        if (paramImagePipelineConfig == null)
        {
          ImagePipelineFactory.initialize(localContext);
          initializeDrawee(localContext, paramDraweeConfig);
          return;
          sIsInitialized = true;
          continue;
        }
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException("Could not initialize SoLoader", localIOException);
      }
      ImagePipelineFactory.initialize(paramImagePipelineConfig);
    }
  }

  private static void initializeDrawee(Context paramContext, @Nullable DraweeConfig paramDraweeConfig)
  {
    sDraweeControllerBuilderSupplier = new PipelineDraweeControllerBuilderSupplier(paramContext, paramDraweeConfig);
    SimpleDraweeView.initialize(sDraweeControllerBuilderSupplier);
  }

  public static PipelineDraweeControllerBuilder newDraweeControllerBuilder()
  {
    return sDraweeControllerBuilderSupplier.get();
  }

  public static void shutDown()
  {
    sDraweeControllerBuilderSupplier = null;
    SimpleDraweeView.shutDown();
    ImagePipelineFactory.shutDown();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.backends.pipeline.Fresco
 * JD-Core Version:    0.6.2
 */
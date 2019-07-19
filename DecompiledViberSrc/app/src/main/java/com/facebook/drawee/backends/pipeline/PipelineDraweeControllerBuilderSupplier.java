package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import java.util.Set;
import javax.annotation.Nullable;

public class PipelineDraweeControllerBuilderSupplier
  implements Supplier<PipelineDraweeControllerBuilder>
{
  private final Set<ControllerListener> mBoundControllerListeners;
  private final Context mContext;
  private final ImagePipeline mImagePipeline;
  private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

  public PipelineDraweeControllerBuilderSupplier(Context paramContext)
  {
    this(paramContext, null);
  }

  public PipelineDraweeControllerBuilderSupplier(Context paramContext, @Nullable DraweeConfig paramDraweeConfig)
  {
    this(paramContext, ImagePipelineFactory.getInstance(), paramDraweeConfig);
  }

  public PipelineDraweeControllerBuilderSupplier(Context paramContext, ImagePipelineFactory paramImagePipelineFactory, @Nullable DraweeConfig paramDraweeConfig)
  {
    this(paramContext, paramImagePipelineFactory, null, paramDraweeConfig);
  }

  public PipelineDraweeControllerBuilderSupplier(Context paramContext, ImagePipelineFactory paramImagePipelineFactory, Set<ControllerListener> paramSet, @Nullable DraweeConfig paramDraweeConfig)
  {
    this.mContext = paramContext;
    this.mImagePipeline = paramImagePipelineFactory.getImagePipeline();
    PipelineDraweeControllerFactory localPipelineDraweeControllerFactory;
    Resources localResources;
    DeferredReleaser localDeferredReleaser;
    DrawableFactory localDrawableFactory;
    UiThreadImmediateExecutorService localUiThreadImmediateExecutorService;
    MemoryCache localMemoryCache;
    if ((paramDraweeConfig != null) && (paramDraweeConfig.getPipelineDraweeControllerFactory() != null))
    {
      this.mPipelineDraweeControllerFactory = paramDraweeConfig.getPipelineDraweeControllerFactory();
      localPipelineDraweeControllerFactory = this.mPipelineDraweeControllerFactory;
      localResources = paramContext.getResources();
      localDeferredReleaser = DeferredReleaser.getInstance();
      localDrawableFactory = paramImagePipelineFactory.getAnimatedDrawableFactory(paramContext);
      localUiThreadImmediateExecutorService = UiThreadImmediateExecutorService.getInstance();
      localMemoryCache = this.mImagePipeline.getBitmapMemoryCache();
      if (paramDraweeConfig == null)
        break label143;
    }
    label143: for (ImmutableList localImmutableList = paramDraweeConfig.getCustomDrawableFactories(); ; localImmutableList = null)
    {
      Supplier localSupplier = null;
      if (paramDraweeConfig != null)
        localSupplier = paramDraweeConfig.getDebugOverlayEnabledSupplier();
      localPipelineDraweeControllerFactory.init(localResources, localDeferredReleaser, localDrawableFactory, localUiThreadImmediateExecutorService, localMemoryCache, localImmutableList, localSupplier);
      this.mBoundControllerListeners = paramSet;
      return;
      this.mPipelineDraweeControllerFactory = new PipelineDraweeControllerFactory();
      break;
    }
  }

  public PipelineDraweeControllerBuilder get()
  {
    return new PipelineDraweeControllerBuilder(this.mContext, this.mPipelineDraweeControllerFactory, this.mImagePipeline, this.mBoundControllerListeners);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilderSupplier
 * JD-Core Version:    0.6.2
 */
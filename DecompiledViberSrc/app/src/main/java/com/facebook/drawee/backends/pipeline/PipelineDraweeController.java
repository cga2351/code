package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.backends.pipeline.info.ForwardingImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.facebook.drawee.debug.listener.ImageLoadingTimeControllerListener;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class PipelineDraweeController extends AbstractDraweeController<CloseableReference<CloseableImage>, ImageInfo>
{
  private static final Class<?> TAG = PipelineDraweeController.class;
  private CacheKey mCacheKey;

  @Nullable
  private ImmutableList<DrawableFactory> mCustomDrawableFactories;
  private Supplier<DataSource<CloseableReference<CloseableImage>>> mDataSourceSupplier;
  private final DrawableFactory mDefaultDrawableFactory;
  private boolean mDrawDebugOverlay;

  @Nullable
  private final ImmutableList<DrawableFactory> mGlobalDrawableFactories;

  @Nullable
  @GuardedBy("this")
  private ImageOriginListener mImageOriginListener;

  @Nullable
  private ImagePerfMonitor mImagePerfMonitor;

  @Nullable
  private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

  @Nullable
  @GuardedBy("this")
  private Set<RequestListener> mRequestListeners;
  private final Resources mResources;

  public PipelineDraweeController(Resources paramResources, DeferredReleaser paramDeferredReleaser, DrawableFactory paramDrawableFactory, Executor paramExecutor, @Nullable MemoryCache<CacheKey, CloseableImage> paramMemoryCache, @Nullable ImmutableList<DrawableFactory> paramImmutableList)
  {
    super(paramDeferredReleaser, paramExecutor, null, null);
    this.mResources = paramResources;
    this.mDefaultDrawableFactory = new DefaultDrawableFactory(paramResources, paramDrawableFactory);
    this.mGlobalDrawableFactories = paramImmutableList;
    this.mMemoryCache = paramMemoryCache;
  }

  private void init(Supplier<DataSource<CloseableReference<CloseableImage>>> paramSupplier)
  {
    this.mDataSourceSupplier = paramSupplier;
    maybeUpdateDebugOverlay(null);
  }

  private Drawable maybeCreateDrawableFromFactories(@Nullable ImmutableList<DrawableFactory> paramImmutableList, CloseableImage paramCloseableImage)
  {
    if (paramImmutableList == null)
      return null;
    Iterator localIterator = paramImmutableList.iterator();
    while (localIterator.hasNext())
    {
      DrawableFactory localDrawableFactory = (DrawableFactory)localIterator.next();
      if (localDrawableFactory.supportsImageType(paramCloseableImage))
      {
        Drawable localDrawable = localDrawableFactory.createDrawable(paramCloseableImage);
        if (localDrawable != null)
          return localDrawable;
      }
    }
    return null;
  }

  private void maybeUpdateDebugOverlay(@Nullable CloseableImage paramCloseableImage)
  {
    if (!this.mDrawDebugOverlay);
    do
    {
      return;
      if (getControllerOverlay() == null)
      {
        DebugControllerOverlayDrawable localDebugControllerOverlayDrawable1 = new DebugControllerOverlayDrawable();
        addControllerListener(new ImageLoadingTimeControllerListener(localDebugControllerOverlayDrawable1));
        setControllerOverlay(localDebugControllerOverlayDrawable1);
      }
    }
    while (!(getControllerOverlay() instanceof DebugControllerOverlayDrawable));
    DebugControllerOverlayDrawable localDebugControllerOverlayDrawable2 = (DebugControllerOverlayDrawable)getControllerOverlay();
    localDebugControllerOverlayDrawable2.setControllerId(getId());
    DraweeHierarchy localDraweeHierarchy = getHierarchy();
    ScalingUtils.ScaleType localScaleType = null;
    if (localDraweeHierarchy != null)
    {
      ScaleTypeDrawable localScaleTypeDrawable = ScalingUtils.getActiveScaleTypeDrawable(localDraweeHierarchy.getTopLevelDrawable());
      localScaleType = null;
      if (localScaleTypeDrawable != null)
        localScaleType = localScaleTypeDrawable.getScaleType();
    }
    localDebugControllerOverlayDrawable2.setScaleType(localScaleType);
    if (paramCloseableImage != null)
    {
      localDebugControllerOverlayDrawable2.setDimensions(paramCloseableImage.getWidth(), paramCloseableImage.getHeight());
      localDebugControllerOverlayDrawable2.setImageSize(paramCloseableImage.getSizeInBytes());
      return;
    }
    localDebugControllerOverlayDrawable2.reset();
  }

  public void addImageOriginListener(ImageOriginListener paramImageOriginListener)
  {
    while (true)
    {
      try
      {
        if ((this.mImageOriginListener instanceof ForwardingImageOriginListener))
        {
          ((ForwardingImageOriginListener)this.mImageOriginListener).addImageOriginListener(paramImageOriginListener);
          return;
        }
        if (this.mImageOriginListener != null)
        {
          ImageOriginListener[] arrayOfImageOriginListener = new ImageOriginListener[2];
          arrayOfImageOriginListener[0] = this.mImageOriginListener;
          arrayOfImageOriginListener[1] = paramImageOriginListener;
          this.mImageOriginListener = new ForwardingImageOriginListener(arrayOfImageOriginListener);
          continue;
        }
      }
      finally
      {
      }
      this.mImageOriginListener = paramImageOriginListener;
    }
  }

  public void addRequestListener(RequestListener paramRequestListener)
  {
    try
    {
      if (this.mRequestListeners == null)
        this.mRequestListeners = new HashSet();
      this.mRequestListeners.add(paramRequestListener);
      return;
    }
    finally
    {
    }
  }

  protected void clearImageOriginListeners()
  {
    try
    {
      this.mImageOriginListener = null;
      return;
    }
    finally
    {
    }
  }

  protected Drawable createDrawable(CloseableReference<CloseableImage> paramCloseableReference)
  {
    Preconditions.checkState(CloseableReference.isValid(paramCloseableReference));
    CloseableImage localCloseableImage = (CloseableImage)paramCloseableReference.get();
    maybeUpdateDebugOverlay(localCloseableImage);
    Drawable localDrawable1 = maybeCreateDrawableFromFactories(this.mCustomDrawableFactories, localCloseableImage);
    if (localDrawable1 != null)
      return localDrawable1;
    Drawable localDrawable2 = maybeCreateDrawableFromFactories(this.mGlobalDrawableFactories, localCloseableImage);
    if (localDrawable2 != null)
      return localDrawable2;
    Drawable localDrawable3 = this.mDefaultDrawableFactory.createDrawable(localCloseableImage);
    if (localDrawable3 != null)
      return localDrawable3;
    throw new UnsupportedOperationException("Unrecognized image class: " + localCloseableImage);
  }

  protected CacheKey getCacheKey()
  {
    return this.mCacheKey;
  }

  protected CloseableReference<CloseableImage> getCachedImage()
  {
    if ((this.mMemoryCache == null) || (this.mCacheKey == null))
      return null;
    CloseableReference localCloseableReference = this.mMemoryCache.get(this.mCacheKey);
    if ((localCloseableReference != null) && (!((CloseableImage)localCloseableReference.get()).getQualityInfo().isOfFullQuality()))
    {
      localCloseableReference.close();
      return null;
    }
    return localCloseableReference;
  }

  protected DataSource<CloseableReference<CloseableImage>> getDataSource()
  {
    if (FLog.isLoggable(2))
      FLog.v(TAG, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
    return (DataSource)this.mDataSourceSupplier.get();
  }

  protected Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier()
  {
    return this.mDataSourceSupplier;
  }

  protected int getImageHash(@Nullable CloseableReference<CloseableImage> paramCloseableReference)
  {
    if (paramCloseableReference != null)
      return paramCloseableReference.getValueHash();
    return 0;
  }

  protected ImageInfo getImageInfo(CloseableReference<CloseableImage> paramCloseableReference)
  {
    Preconditions.checkState(CloseableReference.isValid(paramCloseableReference));
    return (ImageInfo)paramCloseableReference.get();
  }

  @Nullable
  public RequestListener getRequestListener()
  {
    try
    {
      ImageOriginListener localImageOriginListener = this.mImageOriginListener;
      ImageOriginRequestListener localImageOriginRequestListener = null;
      if (localImageOriginListener != null)
        localImageOriginRequestListener = new ImageOriginRequestListener(getId(), this.mImageOriginListener);
      Object localObject2;
      if (this.mRequestListeners != null)
      {
        localObject2 = new ForwardingRequestListener(this.mRequestListeners);
        if (localImageOriginRequestListener != null)
          ((ForwardingRequestListener)localObject2).addRequestListener(localImageOriginRequestListener);
      }
      while (true)
      {
        return localObject2;
        localObject2 = localImageOriginRequestListener;
      }
    }
    finally
    {
    }
  }

  protected Resources getResources()
  {
    return this.mResources;
  }

  public void initialize(Supplier<DataSource<CloseableReference<CloseableImage>>> paramSupplier, String paramString, CacheKey paramCacheKey, Object paramObject, @Nullable ImmutableList<DrawableFactory> paramImmutableList, @Nullable ImageOriginListener paramImageOriginListener)
  {
    super.initialize(paramString, paramObject);
    init(paramSupplier);
    this.mCacheKey = paramCacheKey;
    setCustomDrawableFactories(paramImmutableList);
    clearImageOriginListeners();
    addImageOriginListener(paramImageOriginListener);
  }

  protected void initializePerformanceMonitoring(@Nullable ImagePerfDataListener paramImagePerfDataListener)
  {
    try
    {
      if (this.mImagePerfMonitor != null)
        this.mImagePerfMonitor.reset();
      if (paramImagePerfDataListener != null)
      {
        if (this.mImagePerfMonitor == null)
          this.mImagePerfMonitor = new ImagePerfMonitor(RealtimeSinceBootClock.get(), this);
        this.mImagePerfMonitor.addImagePerfDataListener(paramImagePerfDataListener);
        this.mImagePerfMonitor.setEnabled(true);
      }
      return;
    }
    finally
    {
    }
  }

  public boolean isSameImageRequest(@Nullable DraweeController paramDraweeController)
  {
    if ((this.mCacheKey != null) && ((paramDraweeController instanceof PipelineDraweeController)))
      return Objects.equal(this.mCacheKey, ((PipelineDraweeController)paramDraweeController).getCacheKey());
    return false;
  }

  protected void onImageLoadedFromCacheImmediately(String paramString, CloseableReference<CloseableImage> paramCloseableReference)
  {
    super.onImageLoadedFromCacheImmediately(paramString, paramCloseableReference);
    try
    {
      if (this.mImageOriginListener != null)
        this.mImageOriginListener.onImageLoaded(paramString, 3, true);
      return;
    }
    finally
    {
    }
  }

  protected void releaseDrawable(@Nullable Drawable paramDrawable)
  {
    if ((paramDrawable instanceof DrawableWithCaches))
      ((DrawableWithCaches)paramDrawable).dropCaches();
  }

  protected void releaseImage(@Nullable CloseableReference<CloseableImage> paramCloseableReference)
  {
    CloseableReference.closeSafely(paramCloseableReference);
  }

  public void removeImageOriginListener(ImageOriginListener paramImageOriginListener)
  {
    while (true)
    {
      try
      {
        if ((this.mImageOriginListener instanceof ForwardingImageOriginListener))
        {
          ((ForwardingImageOriginListener)this.mImageOriginListener).removeImageOriginListener(paramImageOriginListener);
          return;
        }
        if (this.mImageOriginListener != null)
        {
          ImageOriginListener[] arrayOfImageOriginListener = new ImageOriginListener[2];
          arrayOfImageOriginListener[0] = this.mImageOriginListener;
          arrayOfImageOriginListener[1] = paramImageOriginListener;
          this.mImageOriginListener = new ForwardingImageOriginListener(arrayOfImageOriginListener);
          continue;
        }
      }
      finally
      {
      }
      this.mImageOriginListener = paramImageOriginListener;
    }
  }

  public void removeRequestListener(RequestListener paramRequestListener)
  {
    try
    {
      Set localSet = this.mRequestListeners;
      if (localSet == null);
      while (true)
      {
        return;
        this.mRequestListeners.remove(paramRequestListener);
      }
    }
    finally
    {
    }
  }

  public void setCustomDrawableFactories(@Nullable ImmutableList<DrawableFactory> paramImmutableList)
  {
    this.mCustomDrawableFactories = paramImmutableList;
  }

  public void setDrawDebugOverlay(boolean paramBoolean)
  {
    this.mDrawDebugOverlay = paramBoolean;
  }

  public void setHierarchy(@Nullable DraweeHierarchy paramDraweeHierarchy)
  {
    super.setHierarchy(paramDraweeHierarchy);
    maybeUpdateDebugOverlay(null);
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("super", super.toString()).add("dataSourceSupplier", this.mDataSourceSupplier).toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.backends.pipeline.PipelineDraweeController
 * JD-Core Version:    0.6.2
 */
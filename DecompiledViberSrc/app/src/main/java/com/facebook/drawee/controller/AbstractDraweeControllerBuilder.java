package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO>
  implements SimpleDraweeControllerBuilder
{
  private static final NullPointerException NO_REQUEST_EXCEPTION = new NullPointerException("No image request was specified!");
  private static final ControllerListener<Object> sAutoPlayAnimationsListener = new BaseControllerListener()
  {
    public void onFinalImageSet(String paramAnonymousString, @Nullable Object paramAnonymousObject, @Nullable Animatable paramAnonymousAnimatable)
    {
      if (paramAnonymousAnimatable != null)
        paramAnonymousAnimatable.start();
    }
  };
  private static final AtomicLong sIdCounter = new AtomicLong();
  private boolean mAutoPlayAnimations;
  private final Set<ControllerListener> mBoundControllerListeners;

  @Nullable
  private Object mCallerContext;
  private String mContentDescription;
  private final Context mContext;

  @Nullable
  private ControllerListener<? super INFO> mControllerListener;

  @Nullable
  private ControllerViewportVisibilityListener mControllerViewportVisibilityListener;

  @Nullable
  private Supplier<DataSource<IMAGE>> mDataSourceSupplier;

  @Nullable
  private REQUEST mImageRequest;

  @Nullable
  private REQUEST mLowResImageRequest;

  @Nullable
  private REQUEST[] mMultiImageRequests;

  @Nullable
  private DraweeController mOldController;
  private boolean mRetainImageOnFailure;
  private boolean mTapToRetryEnabled;
  private boolean mTryCacheOnlyFirst;

  protected AbstractDraweeControllerBuilder(Context paramContext, Set<ControllerListener> paramSet)
  {
    this.mContext = paramContext;
    this.mBoundControllerListeners = paramSet;
    init();
  }

  protected static String generateUniqueControllerId()
  {
    return String.valueOf(sIdCounter.getAndIncrement());
  }

  private void init()
  {
    this.mCallerContext = null;
    this.mImageRequest = null;
    this.mLowResImageRequest = null;
    this.mMultiImageRequests = null;
    this.mTryCacheOnlyFirst = true;
    this.mControllerListener = null;
    this.mControllerViewportVisibilityListener = null;
    this.mTapToRetryEnabled = false;
    this.mAutoPlayAnimations = false;
    this.mOldController = null;
    this.mContentDescription = null;
  }

  public AbstractDraweeController build()
  {
    validate();
    if ((this.mImageRequest == null) && (this.mMultiImageRequests == null) && (this.mLowResImageRequest != null))
    {
      this.mImageRequest = this.mLowResImageRequest;
      this.mLowResImageRequest = null;
    }
    return buildController();
  }

  protected AbstractDraweeController buildController()
  {
    AbstractDraweeController localAbstractDraweeController = obtainController();
    localAbstractDraweeController.setRetainImageOnFailure(getRetainImageOnFailure());
    localAbstractDraweeController.setContentDescription(getContentDescription());
    localAbstractDraweeController.setControllerViewportVisibilityListener(getControllerViewportVisibilityListener());
    maybeBuildAndSetRetryManager(localAbstractDraweeController);
    maybeAttachListeners(localAbstractDraweeController);
    return localAbstractDraweeController;
  }

  public boolean getAutoPlayAnimations()
  {
    return this.mAutoPlayAnimations;
  }

  @Nullable
  public Object getCallerContext()
  {
    return this.mCallerContext;
  }

  @Nullable
  public String getContentDescription()
  {
    return this.mContentDescription;
  }

  protected Context getContext()
  {
    return this.mContext;
  }

  @Nullable
  public ControllerListener<? super INFO> getControllerListener()
  {
    return this.mControllerListener;
  }

  @Nullable
  public ControllerViewportVisibilityListener getControllerViewportVisibilityListener()
  {
    return this.mControllerViewportVisibilityListener;
  }

  protected abstract DataSource<IMAGE> getDataSourceForRequest(DraweeController paramDraweeController, String paramString, REQUEST paramREQUEST, Object paramObject, CacheLevel paramCacheLevel);

  @Nullable
  public Supplier<DataSource<IMAGE>> getDataSourceSupplier()
  {
    return this.mDataSourceSupplier;
  }

  protected Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(DraweeController paramDraweeController, String paramString, REQUEST paramREQUEST)
  {
    return getDataSourceSupplierForRequest(paramDraweeController, paramString, paramREQUEST, CacheLevel.FULL_FETCH);
  }

  protected Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(final DraweeController paramDraweeController, final String paramString, final REQUEST paramREQUEST, final CacheLevel paramCacheLevel)
  {
    return new Supplier()
    {
      public DataSource<IMAGE> get()
      {
        return AbstractDraweeControllerBuilder.this.getDataSourceForRequest(paramDraweeController, paramString, paramREQUEST, this.val$callerContext, paramCacheLevel);
      }

      public String toString()
      {
        return Objects.toStringHelper(this).add("request", paramREQUEST.toString()).toString();
      }
    };
  }

  protected Supplier<DataSource<IMAGE>> getFirstAvailableDataSourceSupplier(DraweeController paramDraweeController, String paramString, REQUEST[] paramArrayOfREQUEST, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(2 * paramArrayOfREQUEST.length);
    int i = 0;
    if (paramBoolean)
      for (int j = 0; ; j++)
      {
        int k = paramArrayOfREQUEST.length;
        i = 0;
        if (j >= k)
          break;
        localArrayList.add(getDataSourceSupplierForRequest(paramDraweeController, paramString, paramArrayOfREQUEST[j], CacheLevel.BITMAP_MEMORY_CACHE));
      }
    while (i < paramArrayOfREQUEST.length)
    {
      localArrayList.add(getDataSourceSupplierForRequest(paramDraweeController, paramString, paramArrayOfREQUEST[i]));
      i++;
    }
    return FirstAvailableDataSourceSupplier.create(localArrayList);
  }

  @Nullable
  public REQUEST[] getFirstAvailableImageRequests()
  {
    return this.mMultiImageRequests;
  }

  @Nullable
  public REQUEST getImageRequest()
  {
    return this.mImageRequest;
  }

  @Nullable
  public REQUEST getLowResImageRequest()
  {
    return this.mLowResImageRequest;
  }

  @Nullable
  public DraweeController getOldController()
  {
    return this.mOldController;
  }

  public boolean getRetainImageOnFailure()
  {
    return this.mRetainImageOnFailure;
  }

  public boolean getTapToRetryEnabled()
  {
    return this.mTapToRetryEnabled;
  }

  protected final BUILDER getThis()
  {
    return this;
  }

  protected void maybeAttachListeners(AbstractDraweeController paramAbstractDraweeController)
  {
    if (this.mBoundControllerListeners != null)
    {
      Iterator localIterator = this.mBoundControllerListeners.iterator();
      while (localIterator.hasNext())
        paramAbstractDraweeController.addControllerListener((ControllerListener)localIterator.next());
    }
    if (this.mControllerListener != null)
      paramAbstractDraweeController.addControllerListener(this.mControllerListener);
    if (this.mAutoPlayAnimations)
      paramAbstractDraweeController.addControllerListener(sAutoPlayAnimationsListener);
  }

  protected void maybeBuildAndSetGestureDetector(AbstractDraweeController paramAbstractDraweeController)
  {
    if (paramAbstractDraweeController.getGestureDetector() == null)
      paramAbstractDraweeController.setGestureDetector(GestureDetector.newInstance(this.mContext));
  }

  protected void maybeBuildAndSetRetryManager(AbstractDraweeController paramAbstractDraweeController)
  {
    if (!this.mTapToRetryEnabled)
      return;
    paramAbstractDraweeController.getRetryManager().setTapToRetryEnabled(this.mTapToRetryEnabled);
    maybeBuildAndSetGestureDetector(paramAbstractDraweeController);
  }

  @ReturnsOwnership
  protected abstract AbstractDraweeController obtainController();

  protected Supplier<DataSource<IMAGE>> obtainDataSourceSupplier(DraweeController paramDraweeController, String paramString)
  {
    Object localObject;
    if (this.mDataSourceSupplier != null)
    {
      localObject = this.mDataSourceSupplier;
      return localObject;
    }
    if (this.mImageRequest != null)
      localObject = getDataSourceSupplierForRequest(paramDraweeController, paramString, this.mImageRequest);
    while (true)
    {
      if ((localObject != null) && (this.mLowResImageRequest != null))
      {
        ArrayList localArrayList = new ArrayList(2);
        localArrayList.add(localObject);
        localArrayList.add(getDataSourceSupplierForRequest(paramDraweeController, paramString, this.mLowResImageRequest));
        localObject = IncreasingQualityDataSourceSupplier.create(localArrayList, false);
      }
      if (localObject != null)
        break;
      return DataSources.getFailedDataSourceSupplier(NO_REQUEST_EXCEPTION);
      Object[] arrayOfObject = this.mMultiImageRequests;
      localObject = null;
      if (arrayOfObject != null)
        localObject = getFirstAvailableDataSourceSupplier(paramDraweeController, paramString, this.mMultiImageRequests, this.mTryCacheOnlyFirst);
    }
  }

  public BUILDER reset()
  {
    init();
    return getThis();
  }

  public BUILDER setAutoPlayAnimations(boolean paramBoolean)
  {
    this.mAutoPlayAnimations = paramBoolean;
    return getThis();
  }

  public BUILDER setCallerContext(Object paramObject)
  {
    this.mCallerContext = paramObject;
    return getThis();
  }

  public BUILDER setContentDescription(String paramString)
  {
    this.mContentDescription = paramString;
    return getThis();
  }

  public BUILDER setControllerListener(ControllerListener<? super INFO> paramControllerListener)
  {
    this.mControllerListener = paramControllerListener;
    return getThis();
  }

  public BUILDER setControllerViewportVisibilityListener(@Nullable ControllerViewportVisibilityListener paramControllerViewportVisibilityListener)
  {
    this.mControllerViewportVisibilityListener = paramControllerViewportVisibilityListener;
    return getThis();
  }

  public BUILDER setDataSourceSupplier(@Nullable Supplier<DataSource<IMAGE>> paramSupplier)
  {
    this.mDataSourceSupplier = paramSupplier;
    return getThis();
  }

  public BUILDER setFirstAvailableImageRequests(REQUEST[] paramArrayOfREQUEST)
  {
    return setFirstAvailableImageRequests(paramArrayOfREQUEST, true);
  }

  public BUILDER setFirstAvailableImageRequests(REQUEST[] paramArrayOfREQUEST, boolean paramBoolean)
  {
    if ((paramArrayOfREQUEST == null) || (paramArrayOfREQUEST.length > 0));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "No requests specified!");
      this.mMultiImageRequests = paramArrayOfREQUEST;
      this.mTryCacheOnlyFirst = paramBoolean;
      return getThis();
    }
  }

  public BUILDER setImageRequest(REQUEST paramREQUEST)
  {
    this.mImageRequest = paramREQUEST;
    return getThis();
  }

  public BUILDER setLowResImageRequest(REQUEST paramREQUEST)
  {
    this.mLowResImageRequest = paramREQUEST;
    return getThis();
  }

  public BUILDER setOldController(@Nullable DraweeController paramDraweeController)
  {
    this.mOldController = paramDraweeController;
    return getThis();
  }

  public BUILDER setRetainImageOnFailure(boolean paramBoolean)
  {
    this.mRetainImageOnFailure = paramBoolean;
    return getThis();
  }

  public BUILDER setTapToRetryEnabled(boolean paramBoolean)
  {
    this.mTapToRetryEnabled = paramBoolean;
    return getThis();
  }

  protected void validate()
  {
    if ((this.mMultiImageRequests == null) || (this.mImageRequest == null));
    for (boolean bool1 = true; ; bool1 = false)
    {
      Preconditions.checkState(bool1, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
      boolean bool2;
      if (this.mDataSourceSupplier != null)
      {
        Object[] arrayOfObject = this.mMultiImageRequests;
        bool2 = false;
        if (arrayOfObject == null)
        {
          Object localObject1 = this.mImageRequest;
          bool2 = false;
          if (localObject1 == null)
          {
            Object localObject2 = this.mLowResImageRequest;
            bool2 = false;
            if (localObject2 != null);
          }
        }
      }
      else
      {
        bool2 = true;
      }
      Preconditions.checkState(bool2, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
      return;
    }
  }

  public static enum CacheLevel
  {
    static
    {
      DISK_CACHE = new CacheLevel("DISK_CACHE", 1);
      BITMAP_MEMORY_CACHE = new CacheLevel("BITMAP_MEMORY_CACHE", 2);
      CacheLevel[] arrayOfCacheLevel = new CacheLevel[3];
      arrayOfCacheLevel[0] = FULL_FETCH;
      arrayOfCacheLevel[1] = DISK_CACHE;
      arrayOfCacheLevel[2] = BITMAP_MEMORY_CACHE;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.controller.AbstractDraweeControllerBuilder
 * JD-Core Version:    0.6.2
 */
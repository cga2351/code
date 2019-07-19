package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DeferredReleaser.Releasable;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.DraweeEventTracker.Event;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.gestures.GestureDetector.ClickListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public abstract class AbstractDraweeController<T, INFO>
  implements DeferredReleaser.Releasable, GestureDetector.ClickListener, DraweeController
{
  private static final Class<?> TAG = AbstractDraweeController.class;
  private Object mCallerContext;

  @Nullable
  private String mContentDescription;

  @Nullable
  private ControllerListener<INFO> mControllerListener;

  @Nullable
  private Drawable mControllerOverlay;

  @Nullable
  private ControllerViewportVisibilityListener mControllerViewportVisibilityListener;

  @Nullable
  private DataSource<T> mDataSource;
  private final DeferredReleaser mDeferredReleaser;

  @Nullable
  private Drawable mDrawable;
  private final DraweeEventTracker mEventTracker = DraweeEventTracker.newInstance();

  @Nullable
  private T mFetchedImage;

  @Nullable
  private GestureDetector mGestureDetector;
  private boolean mHasFetchFailed;
  private String mId;
  private boolean mIsAttached;
  private boolean mIsRequestSubmitted;
  private boolean mIsVisibleInViewportHint;
  private boolean mJustConstructed = true;
  private boolean mRetainImageOnFailure;

  @Nullable
  private RetryManager mRetryManager;

  @Nullable
  private SettableDraweeHierarchy mSettableDraweeHierarchy;
  private final Executor mUiThreadImmediateExecutor;

  public AbstractDraweeController(DeferredReleaser paramDeferredReleaser, Executor paramExecutor, String paramString, Object paramObject)
  {
    this.mDeferredReleaser = paramDeferredReleaser;
    this.mUiThreadImmediateExecutor = paramExecutor;
    init(paramString, paramObject);
  }

  private void init(String paramString, Object paramObject)
  {
    try
    {
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
      if ((!this.mJustConstructed) && (this.mDeferredReleaser != null))
        this.mDeferredReleaser.cancelDeferredRelease(this);
      this.mIsAttached = false;
      this.mIsVisibleInViewportHint = false;
      releaseFetch();
      this.mRetainImageOnFailure = false;
      if (this.mRetryManager != null)
        this.mRetryManager.init();
      if (this.mGestureDetector != null)
      {
        this.mGestureDetector.init();
        this.mGestureDetector.setClickListener(this);
      }
      if ((this.mControllerListener instanceof InternalForwardingListener))
        ((InternalForwardingListener)this.mControllerListener).clearListeners();
      while (true)
      {
        this.mControllerViewportVisibilityListener = null;
        if (this.mSettableDraweeHierarchy != null)
        {
          this.mSettableDraweeHierarchy.reset();
          this.mSettableDraweeHierarchy.setControllerOverlay(null);
          this.mSettableDraweeHierarchy = null;
        }
        this.mControllerOverlay = null;
        if (FLog.isLoggable(2))
          FLog.v(TAG, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, paramString);
        this.mId = paramString;
        this.mCallerContext = paramObject;
        return;
        this.mControllerListener = null;
      }
    }
    finally
    {
    }
  }

  private boolean isExpectedDataSource(String paramString, DataSource<T> paramDataSource)
  {
    if ((paramDataSource == null) && (this.mDataSource == null));
    while ((paramString.equals(this.mId)) && (paramDataSource == this.mDataSource) && (this.mIsRequestSubmitted))
      return true;
    return false;
  }

  private void logMessageAndFailure(String paramString, Throwable paramThrowable)
  {
    if (FLog.isLoggable(2))
      FLog.v(TAG, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, paramString, paramThrowable);
  }

  private void logMessageAndImage(String paramString, T paramT)
  {
    if (FLog.isLoggable(2))
    {
      Class localClass = TAG;
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = Integer.valueOf(System.identityHashCode(this));
      arrayOfObject[1] = this.mId;
      arrayOfObject[2] = paramString;
      arrayOfObject[3] = getImageClass(paramT);
      arrayOfObject[4] = Integer.valueOf(getImageHash(paramT));
      FLog.v(localClass, "controller %x %s: %s: image: %s %x", arrayOfObject);
    }
  }

  private void onFailureInternal(String paramString, DataSource<T> paramDataSource, Throwable paramThrowable, boolean paramBoolean)
  {
    if (!isExpectedDataSource(paramString, paramDataSource))
    {
      logMessageAndFailure("ignore_old_datasource @ onFailure", paramThrowable);
      paramDataSource.close();
      return;
    }
    DraweeEventTracker localDraweeEventTracker = this.mEventTracker;
    DraweeEventTracker.Event localEvent;
    if (paramBoolean)
    {
      localEvent = DraweeEventTracker.Event.ON_DATASOURCE_FAILURE;
      localDraweeEventTracker.recordEvent(localEvent);
      if (!paramBoolean)
        break label154;
      logMessageAndFailure("final_failed @ onFailure", paramThrowable);
      this.mDataSource = null;
      this.mHasFetchFailed = true;
      if ((!this.mRetainImageOnFailure) || (this.mDrawable == null))
        break label121;
      this.mSettableDraweeHierarchy.setImage(this.mDrawable, 1.0F, true);
    }
    while (true)
    {
      getControllerListener().onFailure(this.mId, paramThrowable);
      return;
      localEvent = DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT;
      break;
      label121: if (shouldRetryOnTap())
        this.mSettableDraweeHierarchy.setRetry(paramThrowable);
      else
        this.mSettableDraweeHierarchy.setFailure(paramThrowable);
    }
    label154: logMessageAndFailure("intermediate_failed @ onFailure", paramThrowable);
    getControllerListener().onIntermediateImageFailed(this.mId, paramThrowable);
  }

  // ERROR //
  private void onNewResultInternal(String paramString, DataSource<T> paramDataSource, @Nullable T paramT, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial 221	com/facebook/drawee/controller/AbstractDraweeController:isExpectedDataSource	(Ljava/lang/String;Lcom/facebook/datasource/DataSource;)Z
    //   6: ifne +24 -> 30
    //   9: aload_0
    //   10: ldc_w 275
    //   13: aload_3
    //   14: invokespecial 277	com/facebook/drawee/controller/AbstractDraweeController:logMessageAndImage	(Ljava/lang/String;Ljava/lang/Object;)V
    //   17: aload_0
    //   18: aload_3
    //   19: invokevirtual 281	com/facebook/drawee/controller/AbstractDraweeController:releaseImage	(Ljava/lang/Object;)V
    //   22: aload_2
    //   23: invokeinterface 231 1 0
    //   28: pop
    //   29: return
    //   30: aload_0
    //   31: getfield 69	com/facebook/drawee/controller/AbstractDraweeController:mEventTracker	Lcom/facebook/drawee/components/DraweeEventTracker;
    //   34: astore 7
    //   36: iload 5
    //   38: ifeq +141 -> 179
    //   41: getstatic 284	com/facebook/drawee/components/DraweeEventTracker$Event:ON_DATASOURCE_RESULT	Lcom/facebook/drawee/components/DraweeEventTracker$Event;
    //   44: astore 8
    //   46: aload 7
    //   48: aload 8
    //   50: invokevirtual 107	com/facebook/drawee/components/DraweeEventTracker:recordEvent	(Lcom/facebook/drawee/components/DraweeEventTracker$Event;)V
    //   53: aload_0
    //   54: aload_3
    //   55: invokevirtual 288	com/facebook/drawee/controller/AbstractDraweeController:createDrawable	(Ljava/lang/Object;)Landroid/graphics/drawable/Drawable;
    //   58: astore 10
    //   60: aload_0
    //   61: getfield 290	com/facebook/drawee/controller/AbstractDraweeController:mFetchedImage	Ljava/lang/Object;
    //   64: astore 11
    //   66: aload_0
    //   67: getfield 240	com/facebook/drawee/controller/AbstractDraweeController:mDrawable	Landroid/graphics/drawable/Drawable;
    //   70: astore 12
    //   72: aload_0
    //   73: aload_3
    //   74: putfield 290	com/facebook/drawee/controller/AbstractDraweeController:mFetchedImage	Ljava/lang/Object;
    //   77: aload_0
    //   78: aload 10
    //   80: putfield 240	com/facebook/drawee/controller/AbstractDraweeController:mDrawable	Landroid/graphics/drawable/Drawable;
    //   83: iload 5
    //   85: ifeq +128 -> 213
    //   88: aload_0
    //   89: ldc_w 292
    //   92: aload_3
    //   93: invokespecial 277	com/facebook/drawee/controller/AbstractDraweeController:logMessageAndImage	(Ljava/lang/String;Ljava/lang/Object;)V
    //   96: aload_0
    //   97: aconst_null
    //   98: putfield 191	com/facebook/drawee/controller/AbstractDraweeController:mDataSource	Lcom/facebook/datasource/DataSource;
    //   101: aload_0
    //   102: getfield 148	com/facebook/drawee/controller/AbstractDraweeController:mSettableDraweeHierarchy	Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;
    //   105: aload 10
    //   107: fconst_1
    //   108: iload 6
    //   110: invokeinterface 244 4 0
    //   115: aload_0
    //   116: invokevirtual 248	com/facebook/drawee/controller/AbstractDraweeController:getControllerListener	()Lcom/facebook/drawee/controller/ControllerListener;
    //   119: aload_1
    //   120: aload_0
    //   121: aload_3
    //   122: invokevirtual 296	com/facebook/drawee/controller/AbstractDraweeController:getImageInfo	(Ljava/lang/Object;)Ljava/lang/Object;
    //   125: aload_0
    //   126: invokevirtual 300	com/facebook/drawee/controller/AbstractDraweeController:getAnimatable	()Landroid/graphics/drawable/Animatable;
    //   129: invokeinterface 304 4 0
    //   134: aload 12
    //   136: ifnull +16 -> 152
    //   139: aload 12
    //   141: aload 10
    //   143: if_acmpeq +9 -> 152
    //   146: aload_0
    //   147: aload 12
    //   149: invokevirtual 307	com/facebook/drawee/controller/AbstractDraweeController:releaseDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   152: aload 11
    //   154: ifnull -125 -> 29
    //   157: aload 11
    //   159: aload_3
    //   160: if_acmpeq -131 -> 29
    //   163: aload_0
    //   164: ldc_w 309
    //   167: aload 11
    //   169: invokespecial 277	com/facebook/drawee/controller/AbstractDraweeController:logMessageAndImage	(Ljava/lang/String;Ljava/lang/Object;)V
    //   172: aload_0
    //   173: aload 11
    //   175: invokevirtual 281	com/facebook/drawee/controller/AbstractDraweeController:releaseImage	(Ljava/lang/Object;)V
    //   178: return
    //   179: getstatic 312	com/facebook/drawee/components/DraweeEventTracker$Event:ON_DATASOURCE_RESULT_INT	Lcom/facebook/drawee/components/DraweeEventTracker$Event;
    //   182: astore 8
    //   184: goto -138 -> 46
    //   187: astore 9
    //   189: aload_0
    //   190: ldc_w 314
    //   193: aload_3
    //   194: invokespecial 277	com/facebook/drawee/controller/AbstractDraweeController:logMessageAndImage	(Ljava/lang/String;Ljava/lang/Object;)V
    //   197: aload_0
    //   198: aload_3
    //   199: invokevirtual 281	com/facebook/drawee/controller/AbstractDraweeController:releaseImage	(Ljava/lang/Object;)V
    //   202: aload_0
    //   203: aload_1
    //   204: aload_2
    //   205: aload 9
    //   207: iload 5
    //   209: invokespecial 91	com/facebook/drawee/controller/AbstractDraweeController:onFailureInternal	(Ljava/lang/String;Lcom/facebook/datasource/DataSource;Ljava/lang/Throwable;Z)V
    //   212: return
    //   213: aload_0
    //   214: ldc_w 316
    //   217: aload_3
    //   218: invokespecial 277	com/facebook/drawee/controller/AbstractDraweeController:logMessageAndImage	(Ljava/lang/String;Ljava/lang/Object;)V
    //   221: aload_0
    //   222: getfield 148	com/facebook/drawee/controller/AbstractDraweeController:mSettableDraweeHierarchy	Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;
    //   225: aload 10
    //   227: fload 4
    //   229: iload 6
    //   231: invokeinterface 244 4 0
    //   236: aload_0
    //   237: invokevirtual 248	com/facebook/drawee/controller/AbstractDraweeController:getControllerListener	()Lcom/facebook/drawee/controller/ControllerListener;
    //   240: aload_1
    //   241: aload_0
    //   242: aload_3
    //   243: invokevirtual 296	com/facebook/drawee/controller/AbstractDraweeController:getImageInfo	(Ljava/lang/Object;)Ljava/lang/Object;
    //   246: invokeinterface 319 3 0
    //   251: goto -117 -> 134
    //   254: astore 13
    //   256: aload 12
    //   258: ifnull +16 -> 274
    //   261: aload 12
    //   263: aload 10
    //   265: if_acmpeq +9 -> 274
    //   268: aload_0
    //   269: aload 12
    //   271: invokevirtual 307	com/facebook/drawee/controller/AbstractDraweeController:releaseDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   274: aload 11
    //   276: ifnull +24 -> 300
    //   279: aload 11
    //   281: aload_3
    //   282: if_acmpeq +18 -> 300
    //   285: aload_0
    //   286: ldc_w 309
    //   289: aload 11
    //   291: invokespecial 277	com/facebook/drawee/controller/AbstractDraweeController:logMessageAndImage	(Ljava/lang/String;Ljava/lang/Object;)V
    //   294: aload_0
    //   295: aload 11
    //   297: invokevirtual 281	com/facebook/drawee/controller/AbstractDraweeController:releaseImage	(Ljava/lang/Object;)V
    //   300: aload 13
    //   302: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   53	60	187	java/lang/Exception
    //   88	134	254	finally
    //   213	251	254	finally
  }

  private void onProgressUpdateInternal(String paramString, DataSource<T> paramDataSource, float paramFloat, boolean paramBoolean)
  {
    if (!isExpectedDataSource(paramString, paramDataSource))
    {
      logMessageAndFailure("ignore_old_datasource @ onProgress", null);
      paramDataSource.close();
    }
    while (paramBoolean)
      return;
    this.mSettableDraweeHierarchy.setProgress(paramFloat, false);
  }

  private void releaseFetch()
  {
    boolean bool = this.mIsRequestSubmitted;
    this.mIsRequestSubmitted = false;
    this.mHasFetchFailed = false;
    if (this.mDataSource != null)
    {
      this.mDataSource.close();
      this.mDataSource = null;
    }
    if (this.mDrawable != null)
      releaseDrawable(this.mDrawable);
    if (this.mContentDescription != null)
      this.mContentDescription = null;
    this.mDrawable = null;
    if (this.mFetchedImage != null)
    {
      logMessageAndImage("release", this.mFetchedImage);
      releaseImage(this.mFetchedImage);
      this.mFetchedImage = null;
    }
    if (bool)
      getControllerListener().onRelease(this.mId);
  }

  private boolean shouldRetryOnTap()
  {
    return (this.mHasFetchFailed) && (this.mRetryManager != null) && (this.mRetryManager.shouldRetryOnTap());
  }

  public void addControllerListener(ControllerListener<? super INFO> paramControllerListener)
  {
    Preconditions.checkNotNull(paramControllerListener);
    if ((this.mControllerListener instanceof InternalForwardingListener))
    {
      ((InternalForwardingListener)this.mControllerListener).addListener(paramControllerListener);
      return;
    }
    if (this.mControllerListener != null)
    {
      this.mControllerListener = InternalForwardingListener.createInternal(this.mControllerListener, paramControllerListener);
      return;
    }
    this.mControllerListener = paramControllerListener;
  }

  protected abstract Drawable createDrawable(T paramT);

  @Nullable
  public Animatable getAnimatable()
  {
    if ((this.mDrawable instanceof Animatable))
      return (Animatable)this.mDrawable;
    return null;
  }

  protected T getCachedImage()
  {
    return null;
  }

  public Object getCallerContext()
  {
    return this.mCallerContext;
  }

  @Nullable
  public String getContentDescription()
  {
    return this.mContentDescription;
  }

  protected ControllerListener<INFO> getControllerListener()
  {
    if (this.mControllerListener == null)
      return BaseControllerListener.getNoOpListener();
    return this.mControllerListener;
  }

  @Nullable
  protected Drawable getControllerOverlay()
  {
    return this.mControllerOverlay;
  }

  protected abstract DataSource<T> getDataSource();

  @Nullable
  protected GestureDetector getGestureDetector()
  {
    return this.mGestureDetector;
  }

  @Nullable
  public DraweeHierarchy getHierarchy()
  {
    return this.mSettableDraweeHierarchy;
  }

  public String getId()
  {
    return this.mId;
  }

  protected String getImageClass(@Nullable T paramT)
  {
    if (paramT != null)
      return paramT.getClass().getSimpleName();
    return "<null>";
  }

  protected int getImageHash(@Nullable T paramT)
  {
    return System.identityHashCode(paramT);
  }

  @Nullable
  protected abstract INFO getImageInfo(T paramT);

  @ReturnsOwnership
  protected RetryManager getRetryManager()
  {
    if (this.mRetryManager == null)
      this.mRetryManager = new RetryManager();
    return this.mRetryManager;
  }

  protected void initialize(String paramString, Object paramObject)
  {
    init(paramString, paramObject);
    this.mJustConstructed = false;
  }

  public void onAttach()
  {
    Class localClass;
    Integer localInteger;
    String str1;
    if (FLog.isLoggable(2))
    {
      localClass = TAG;
      localInteger = Integer.valueOf(System.identityHashCode(this));
      str1 = this.mId;
      if (!this.mIsRequestSubmitted)
        break label92;
    }
    label92: for (String str2 = "request already submitted"; ; str2 = "request needs submit")
    {
      FLog.v(localClass, "controller %x %s: onAttach: %s", localInteger, str1, str2);
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
      Preconditions.checkNotNull(this.mSettableDraweeHierarchy);
      this.mDeferredReleaser.cancelDeferredRelease(this);
      this.mIsAttached = true;
      if (!this.mIsRequestSubmitted)
        submitRequest();
      return;
    }
  }

  public boolean onClick()
  {
    if (FLog.isLoggable(2))
      FLog.v(TAG, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
    if (shouldRetryOnTap())
    {
      this.mRetryManager.notifyTapToRetry();
      this.mSettableDraweeHierarchy.reset();
      submitRequest();
      return true;
    }
    return false;
  }

  public void onDetach()
  {
    if (FLog.isLoggable(2))
      FLog.v(TAG, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
    this.mIsAttached = false;
    this.mDeferredReleaser.scheduleDeferredRelease(this);
  }

  protected void onImageLoadedFromCacheImmediately(String paramString, T paramT)
  {
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (FLog.isLoggable(2))
      FLog.v(TAG, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, paramMotionEvent);
    if (this.mGestureDetector == null);
    while ((!this.mGestureDetector.isCapturingGesture()) && (!shouldHandleGesture()))
      return false;
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    return true;
  }

  public void onViewportVisibilityHint(boolean paramBoolean)
  {
    ControllerViewportVisibilityListener localControllerViewportVisibilityListener = this.mControllerViewportVisibilityListener;
    if (localControllerViewportVisibilityListener != null)
    {
      if ((!paramBoolean) || (this.mIsVisibleInViewportHint))
        break label36;
      localControllerViewportVisibilityListener.onDraweeViewportEntry(this.mId);
    }
    while (true)
    {
      this.mIsVisibleInViewportHint = paramBoolean;
      return;
      label36: if ((!paramBoolean) && (this.mIsVisibleInViewportHint))
        localControllerViewportVisibilityListener.onDraweeViewportExit(this.mId);
    }
  }

  public void release()
  {
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
    if (this.mRetryManager != null)
      this.mRetryManager.reset();
    if (this.mGestureDetector != null)
      this.mGestureDetector.reset();
    if (this.mSettableDraweeHierarchy != null)
      this.mSettableDraweeHierarchy.reset();
    releaseFetch();
  }

  protected abstract void releaseDrawable(@Nullable Drawable paramDrawable);

  protected abstract void releaseImage(@Nullable T paramT);

  public void removeControllerListener(ControllerListener<? super INFO> paramControllerListener)
  {
    Preconditions.checkNotNull(paramControllerListener);
    if ((this.mControllerListener instanceof InternalForwardingListener))
      ((InternalForwardingListener)this.mControllerListener).removeListener(paramControllerListener);
    while (this.mControllerListener != paramControllerListener)
      return;
    this.mControllerListener = null;
  }

  public void setContentDescription(@Nullable String paramString)
  {
    this.mContentDescription = paramString;
  }

  protected void setControllerOverlay(@Nullable Drawable paramDrawable)
  {
    this.mControllerOverlay = paramDrawable;
    if (this.mSettableDraweeHierarchy != null)
      this.mSettableDraweeHierarchy.setControllerOverlay(this.mControllerOverlay);
  }

  public void setControllerViewportVisibilityListener(@Nullable ControllerViewportVisibilityListener paramControllerViewportVisibilityListener)
  {
    this.mControllerViewportVisibilityListener = paramControllerViewportVisibilityListener;
  }

  protected void setGestureDetector(@Nullable GestureDetector paramGestureDetector)
  {
    this.mGestureDetector = paramGestureDetector;
    if (this.mGestureDetector != null)
      this.mGestureDetector.setClickListener(this);
  }

  public void setHierarchy(@Nullable DraweeHierarchy paramDraweeHierarchy)
  {
    if (FLog.isLoggable(2))
      FLog.v(TAG, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, paramDraweeHierarchy);
    DraweeEventTracker localDraweeEventTracker = this.mEventTracker;
    if (paramDraweeHierarchy != null);
    for (DraweeEventTracker.Event localEvent = DraweeEventTracker.Event.ON_SET_HIERARCHY; ; localEvent = DraweeEventTracker.Event.ON_CLEAR_HIERARCHY)
    {
      localDraweeEventTracker.recordEvent(localEvent);
      if (this.mIsRequestSubmitted)
      {
        this.mDeferredReleaser.cancelDeferredRelease(this);
        release();
      }
      if (this.mSettableDraweeHierarchy != null)
      {
        this.mSettableDraweeHierarchy.setControllerOverlay(null);
        this.mSettableDraweeHierarchy = null;
      }
      if (paramDraweeHierarchy != null)
      {
        Preconditions.checkArgument(paramDraweeHierarchy instanceof SettableDraweeHierarchy);
        this.mSettableDraweeHierarchy = ((SettableDraweeHierarchy)paramDraweeHierarchy);
        this.mSettableDraweeHierarchy.setControllerOverlay(this.mControllerOverlay);
      }
      return;
    }
  }

  protected void setRetainImageOnFailure(boolean paramBoolean)
  {
    this.mRetainImageOnFailure = paramBoolean;
  }

  protected boolean shouldHandleGesture()
  {
    return shouldRetryOnTap();
  }

  protected void submitRequest()
  {
    Object localObject = getCachedImage();
    if (localObject != null)
    {
      this.mDataSource = null;
      this.mIsRequestSubmitted = true;
      this.mHasFetchFailed = false;
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
      getControllerListener().onSubmit(this.mId, this.mCallerContext);
      onImageLoadedFromCacheImmediately(this.mId, localObject);
      onNewResultInternal(this.mId, this.mDataSource, localObject, 1.0F, true, true);
      return;
    }
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
    getControllerListener().onSubmit(this.mId, this.mCallerContext);
    this.mSettableDraweeHierarchy.setProgress(0.0F, true);
    this.mIsRequestSubmitted = true;
    this.mHasFetchFailed = false;
    this.mDataSource = getDataSource();
    if (FLog.isLoggable(2))
      FLog.v(TAG, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.mDataSource)));
    BaseDataSubscriber local1 = new BaseDataSubscriber()
    {
      public void onFailureImpl(DataSource<T> paramAnonymousDataSource)
      {
        AbstractDraweeController.this.onFailureInternal(this.val$id, paramAnonymousDataSource, paramAnonymousDataSource.getFailureCause(), true);
      }

      public void onNewResultImpl(DataSource<T> paramAnonymousDataSource)
      {
        boolean bool = paramAnonymousDataSource.isFinished();
        float f = paramAnonymousDataSource.getProgress();
        Object localObject = paramAnonymousDataSource.getResult();
        if (localObject != null)
          AbstractDraweeController.this.onNewResultInternal(this.val$id, paramAnonymousDataSource, localObject, f, bool, this.val$wasImmediate);
        while (!bool)
          return;
        AbstractDraweeController.this.onFailureInternal(this.val$id, paramAnonymousDataSource, new NullPointerException(), true);
      }

      public void onProgressUpdate(DataSource<T> paramAnonymousDataSource)
      {
        boolean bool = paramAnonymousDataSource.isFinished();
        float f = paramAnonymousDataSource.getProgress();
        AbstractDraweeController.this.onProgressUpdateInternal(this.val$id, paramAnonymousDataSource, f, bool);
      }
    };
    this.mDataSource.subscribe(local1, this.mUiThreadImmediateExecutor);
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("isAttached", this.mIsAttached).add("isRequestSubmitted", this.mIsRequestSubmitted).add("hasFetchFailed", this.mHasFetchFailed).add("fetchedImage", getImageHash(this.mFetchedImage)).add("events", this.mEventTracker.toString()).toString();
  }

  private static class InternalForwardingListener<INFO> extends ForwardingControllerListener<INFO>
  {
    public static <INFO> InternalForwardingListener<INFO> createInternal(ControllerListener<? super INFO> paramControllerListener1, ControllerListener<? super INFO> paramControllerListener2)
    {
      InternalForwardingListener localInternalForwardingListener = new InternalForwardingListener();
      localInternalForwardingListener.addListener(paramControllerListener1);
      localInternalForwardingListener.addListener(paramControllerListener2);
      return localInternalForwardingListener;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.controller.AbstractDraweeController
 * JD-Core Version:    0.6.2
 */
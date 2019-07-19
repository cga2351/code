package com.facebook.react;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.common.MeasureSpecProvider;
import com.facebook.react.uimanager.common.SizeMonitoringFrameLayout;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;
import javax.annotation.Nullable;

public class ReactRootView extends SizeMonitoringFrameLayout
  implements RootView, MeasureSpecProvider
{
  private final ReactAndroidHWInputDeviceHelper mAndroidHWInputDeviceHelper = new ReactAndroidHWInputDeviceHelper(this);

  @Nullable
  private Bundle mAppProperties;

  @Nullable
  private CustomGlobalLayoutListener mCustomGlobalLayoutListener;
  private int mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);

  @Nullable
  private String mInitialUITemplate;
  private boolean mIsAttachedToInstance;

  @Nullable
  private String mJSModuleName;

  @Nullable
  private JSTouchDispatcher mJSTouchDispatcher;

  @Nullable
  private ReactInstanceManager mReactInstanceManager;

  @Nullable
  private ReactRootViewEventListener mRootViewEventListener;
  private int mRootViewTag;
  private boolean mShouldLogContentAppeared;
  private int mUIManagerType = 1;
  private boolean mWasMeasured = false;
  private int mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);

  public ReactRootView(Context paramContext)
  {
    super(paramContext);
    init();
  }

  public ReactRootView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }

  public ReactRootView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }

  private void attachToReactInstanceManager()
  {
    Systrace.beginSection(0L, "attachToReactInstanceManager");
    try
    {
      boolean bool = this.mIsAttachedToInstance;
      if (bool)
        return;
      this.mIsAttachedToInstance = true;
      ((ReactInstanceManager)Assertions.assertNotNull(this.mReactInstanceManager)).attachRootView(this);
      getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
      return;
    }
    finally
    {
      Systrace.endSection(0L);
    }
  }

  private void dispatchJSTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mReactInstanceManager == null) || (!this.mIsAttachedToInstance) || (this.mReactInstanceManager.getCurrentReactContext() == null))
    {
      FLog.w("ReactNative", "Unable to dispatch touch to JS as the catalyst instance has not been attached");
      return;
    }
    if (this.mJSTouchDispatcher == null)
    {
      FLog.w("ReactNative", "Unable to dispatch touch to JS before the dispatcher is available");
      return;
    }
    EventDispatcher localEventDispatcher = ((UIManagerModule)this.mReactInstanceManager.getCurrentReactContext().getNativeModule(UIManagerModule.class)).getEventDispatcher();
    this.mJSTouchDispatcher.handleTouchEvent(paramMotionEvent, localEventDispatcher);
  }

  private void enableLayoutCalculation()
  {
    if (this.mReactInstanceManager == null)
      FLog.w("ReactNative", "Unable to enable layout calculation for uninitialized ReactInstanceManager");
    ReactContext localReactContext;
    do
    {
      return;
      localReactContext = this.mReactInstanceManager.getCurrentReactContext();
    }
    while (localReactContext == null);
    ((UIManagerModule)localReactContext.getCatalystInstance().getNativeModule(UIManagerModule.class)).getUIImplementation().enableLayoutCalculationForRootNode(getRootViewTag());
  }

  private CustomGlobalLayoutListener getCustomGlobalLayoutListener()
  {
    if (this.mCustomGlobalLayoutListener == null)
      this.mCustomGlobalLayoutListener = new CustomGlobalLayoutListener();
    return this.mCustomGlobalLayoutListener;
  }

  private void init()
  {
    setClipChildren(false);
  }

  private void removeOnGlobalLayoutListener()
  {
    getViewTreeObserver().removeOnGlobalLayoutListener(getCustomGlobalLayoutListener());
  }

  private void updateRootLayoutSpecs(int paramInt1, int paramInt2)
  {
    if (this.mReactInstanceManager == null)
      FLog.w("ReactNative", "Unable to update root layout specs for uninitialized ReactInstanceManager");
    ReactContext localReactContext;
    do
    {
      return;
      localReactContext = this.mReactInstanceManager.getCurrentReactContext();
    }
    while (localReactContext == null);
    UIManagerHelper.getUIManager(localReactContext, getUIManagerType()).updateRootLayoutSpecs(getRootViewTag(), paramInt1, paramInt2);
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (StackOverflowError localStackOverflowError)
    {
      handleException(localStackOverflowError);
    }
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((this.mReactInstanceManager == null) || (!this.mIsAttachedToInstance) || (this.mReactInstanceManager.getCurrentReactContext() == null))
    {
      FLog.w("ReactNative", "Unable to handle key event as the catalyst instance has not been attached");
      return super.dispatchKeyEvent(paramKeyEvent);
    }
    this.mAndroidHWInputDeviceHelper.handleKeyEvent(paramKeyEvent);
    return super.dispatchKeyEvent(paramKeyEvent);
  }

  protected void finalize()
    throws Throwable
  {
    super.finalize();
    if (!this.mIsAttachedToInstance);
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool, "The application this ReactRootView was rendering was not unmounted before the ReactRootView was garbage collected. This usually means that your application is leaking large amounts of memory. To solve this, make sure to call ReactRootView#unmountReactApplication in the onDestroy() of your hosting Activity or in the onDestroyView() of your hosting Fragment.");
      return;
    }
  }

  @Nullable
  public Bundle getAppProperties()
  {
    return this.mAppProperties;
  }

  public int getHeightMeasureSpec()
  {
    if ((!this.mWasMeasured) && (getLayoutParams() != null) && (getLayoutParams().height > 0))
      return View.MeasureSpec.makeMeasureSpec(getLayoutParams().height, 1073741824);
    return this.mHeightMeasureSpec;
  }

  @Nullable
  public String getInitialUITemplate()
  {
    return this.mInitialUITemplate;
  }

  String getJSModuleName()
  {
    return (String)Assertions.assertNotNull(this.mJSModuleName);
  }

  @Nullable
  public ReactInstanceManager getReactInstanceManager()
  {
    return this.mReactInstanceManager;
  }

  public int getRootViewTag()
  {
    return this.mRootViewTag;
  }

  public int getUIManagerType()
  {
    return this.mUIManagerType;
  }

  public int getWidthMeasureSpec()
  {
    if ((!this.mWasMeasured) && (getLayoutParams() != null) && (getLayoutParams().width > 0))
      return View.MeasureSpec.makeMeasureSpec(getLayoutParams().width, 1073741824);
    return this.mWidthMeasureSpec;
  }

  public void handleException(Throwable paramThrowable)
  {
    if ((this.mReactInstanceManager == null) || (this.mReactInstanceManager.getCurrentReactContext() == null))
      throw new RuntimeException(paramThrowable);
    IllegalViewOperationException localIllegalViewOperationException = new IllegalViewOperationException(paramThrowable.getMessage(), this, paramThrowable);
    this.mReactInstanceManager.getCurrentReactContext().handleException(localIllegalViewOperationException);
  }

  public void onAttachedToReactInstance()
  {
    this.mJSTouchDispatcher = new JSTouchDispatcher(this);
    if (this.mRootViewEventListener != null)
      this.mRootViewEventListener.onAttachedToReactInstance(this);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mIsAttachedToInstance)
    {
      removeOnGlobalLayoutListener();
      getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
    }
  }

  public void onChildStartedNativeGesture(MotionEvent paramMotionEvent)
  {
    if ((this.mReactInstanceManager == null) || (!this.mIsAttachedToInstance) || (this.mReactInstanceManager.getCurrentReactContext() == null))
    {
      FLog.w("ReactNative", "Unable to dispatch touch to JS as the catalyst instance has not been attached");
      return;
    }
    if (this.mJSTouchDispatcher == null)
    {
      FLog.w("ReactNative", "Unable to dispatch touch to JS before the dispatcher is available");
      return;
    }
    EventDispatcher localEventDispatcher = ((UIManagerModule)this.mReactInstanceManager.getCurrentReactContext().getNativeModule(UIManagerModule.class)).getEventDispatcher();
    this.mJSTouchDispatcher.onChildStartedNativeGesture(paramMotionEvent, localEventDispatcher);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mIsAttachedToInstance)
      removeOnGlobalLayoutListener();
  }

  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    if ((this.mReactInstanceManager == null) || (!this.mIsAttachedToInstance) || (this.mReactInstanceManager.getCurrentReactContext() == null))
    {
      FLog.w("ReactNative", "Unable to handle focus changed event as the catalyst instance has not been attached");
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      return;
    }
    this.mAndroidHWInputDeviceHelper.clearFocus();
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    dispatchJSTouchEvent(paramMotionEvent);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Systrace.beginSection(0L, "ReactRootView.onMeasure");
    while (true)
    {
      try
      {
        this.mWidthMeasureSpec = paramInt1;
        this.mHeightMeasureSpec = paramInt2;
        int i = View.MeasureSpec.getMode(paramInt1);
        if (i != -2147483648)
        {
          if (i == 0)
          {
            break label256;
            if (k >= getChildCount())
              break label265;
            View localView2 = getChildAt(k);
            int i4 = Math.max(j, localView2.getLeft() + localView2.getMeasuredWidth() + localView2.getPaddingLeft() + localView2.getPaddingRight());
            k++;
            j = i4;
            continue;
            int n = View.MeasureSpec.getMode(paramInt2);
            if (n == -2147483648)
              break label272;
            if (n == 0)
            {
              break label272;
              if (i2 >= getChildCount())
                continue;
              View localView1 = getChildAt(i2);
              int i3 = Math.max(i1, localView1.getTop() + localView1.getMeasuredHeight() + localView1.getPaddingTop() + localView1.getPaddingBottom());
              i2++;
              i1 = i3;
              continue;
            }
          }
          else
          {
            m = View.MeasureSpec.getSize(paramInt1);
            continue;
          }
          i1 = View.MeasureSpec.getSize(paramInt2);
          setMeasuredDimension(m, i1);
          this.mWasMeasured = true;
          if ((this.mReactInstanceManager != null) && (!this.mIsAttachedToInstance))
          {
            attachToReactInstanceManager();
            enableLayoutCalculation();
            return;
          }
          enableLayoutCalculation();
          updateRootLayoutSpecs(this.mWidthMeasureSpec, this.mHeightMeasureSpec);
          continue;
        }
      }
      finally
      {
        Systrace.endSection(0L);
      }
      label256: int j = 0;
      int k = 0;
      continue;
      label265: int m = j;
      continue;
      label272: int i1 = 0;
      int i2 = 0;
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    dispatchJSTouchEvent(paramMotionEvent);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }

  public void onViewAdded(View paramView)
  {
    super.onViewAdded(paramView);
    if (this.mShouldLogContentAppeared)
    {
      this.mShouldLogContentAppeared = false;
      if (this.mJSModuleName != null)
        ReactMarker.logMarker(ReactMarkerConstants.CONTENT_APPEARED, this.mJSModuleName, this.mRootViewTag);
    }
  }

  public void requestChildFocus(View paramView1, View paramView2)
  {
    if ((this.mReactInstanceManager == null) || (!this.mIsAttachedToInstance) || (this.mReactInstanceManager.getCurrentReactContext() == null))
    {
      FLog.w("ReactNative", "Unable to handle child focus changed event as the catalyst instance has not been attached");
      super.requestChildFocus(paramView1, paramView2);
      return;
    }
    this.mAndroidHWInputDeviceHelper.onFocusChanged(paramView2);
    super.requestChildFocus(paramView1, paramView2);
  }

  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (getParent() != null)
      getParent().requestDisallowInterceptTouchEvent(paramBoolean);
  }

  void runApplication()
  {
    Systrace.beginSection(0L, "ReactRootView.runApplication");
    try
    {
      if (this.mReactInstanceManager != null)
      {
        boolean bool = this.mIsAttachedToInstance;
        if (bool);
      }
      else
      {
        return;
      }
      ReactContext localReactContext = this.mReactInstanceManager.getCurrentReactContext();
      if (localReactContext == null)
        return;
      CatalystInstance localCatalystInstance = localReactContext.getCatalystInstance();
      WritableNativeMap localWritableNativeMap = new WritableNativeMap();
      localWritableNativeMap.putDouble("rootTag", getRootViewTag());
      Bundle localBundle = getAppProperties();
      if (localBundle != null)
        localWritableNativeMap.putMap("initialProps", Arguments.fromBundle(localBundle));
      if (getUIManagerType() == 2)
        localWritableNativeMap.putBoolean("fabric", true);
      this.mShouldLogContentAppeared = true;
      String str = getJSModuleName();
      ((AppRegistry)localCatalystInstance.getJSModule(AppRegistry.class)).runApplication(str, localWritableNativeMap);
      return;
    }
    finally
    {
      Systrace.endSection(0L);
    }
  }

  void sendEvent(String paramString, @Nullable WritableMap paramWritableMap)
  {
    if (this.mReactInstanceManager != null)
      ((DeviceEventManagerModule.RCTDeviceEventEmitter)this.mReactInstanceManager.getCurrentReactContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(paramString, paramWritableMap);
  }

  public void setAppProperties(@Nullable Bundle paramBundle)
  {
    UiThreadUtil.assertOnUiThread();
    this.mAppProperties = paramBundle;
    if (getRootViewTag() != 0)
      runApplication();
  }

  public void setEventListener(ReactRootViewEventListener paramReactRootViewEventListener)
  {
    this.mRootViewEventListener = paramReactRootViewEventListener;
  }

  public void setIsFabric(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 2; ; i = 1)
    {
      this.mUIManagerType = i;
      return;
    }
  }

  public void setRootViewTag(int paramInt)
  {
    this.mRootViewTag = paramInt;
  }

  @VisibleForTesting
  void simulateAttachForTesting()
  {
    this.mIsAttachedToInstance = true;
    this.mJSTouchDispatcher = new JSTouchDispatcher(this);
  }

  public void startReactApplication(ReactInstanceManager paramReactInstanceManager, String paramString)
  {
    startReactApplication(paramReactInstanceManager, paramString, null);
  }

  public void startReactApplication(ReactInstanceManager paramReactInstanceManager, String paramString, @Nullable Bundle paramBundle)
  {
    startReactApplication(paramReactInstanceManager, paramString, paramBundle, null);
  }

  public void startReactApplication(ReactInstanceManager paramReactInstanceManager, String paramString1, @Nullable Bundle paramBundle, @Nullable String paramString2)
  {
    Systrace.beginSection(0L, "startReactApplication");
    try
    {
      UiThreadUtil.assertOnUiThread();
      if (this.mReactInstanceManager == null);
      for (boolean bool = true; ; bool = false)
      {
        Assertions.assertCondition(bool, "This root view has already been attached to a catalyst instance manager");
        this.mReactInstanceManager = paramReactInstanceManager;
        this.mJSModuleName = paramString1;
        this.mAppProperties = paramBundle;
        this.mInitialUITemplate = paramString2;
        if (!this.mReactInstanceManager.hasStartedCreatingInitialContext())
          this.mReactInstanceManager.createReactContextInBackground();
        attachToReactInstanceManager();
        return;
      }
    }
    finally
    {
      Systrace.endSection(0L);
    }
  }

  public void unmountReactApplication()
  {
    if ((this.mReactInstanceManager != null) && (this.mIsAttachedToInstance))
    {
      this.mReactInstanceManager.detachRootView(this);
      this.mReactInstanceManager = null;
      this.mIsAttachedToInstance = false;
    }
    this.mShouldLogContentAppeared = false;
  }

  private class CustomGlobalLayoutListener
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    private int mDeviceRotation = 0;
    private int mKeyboardHeight = 0;
    private final int mMinKeyboardHeightDetected;
    private DisplayMetrics mScreenMetrics = new DisplayMetrics();
    private final Rect mVisibleViewArea;
    private DisplayMetrics mWindowMetrics = new DisplayMetrics();

    CustomGlobalLayoutListener()
    {
      DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(ReactRootView.this.getContext().getApplicationContext());
      this.mVisibleViewArea = new Rect();
      this.mMinKeyboardHeightDetected = ((int)PixelUtil.toPixelFromDIP(60.0F));
    }

    private boolean areMetricsEqual(DisplayMetrics paramDisplayMetrics1, DisplayMetrics paramDisplayMetrics2)
    {
      if (Build.VERSION.SDK_INT >= 17)
        return paramDisplayMetrics1.equals(paramDisplayMetrics2);
      return (paramDisplayMetrics1.widthPixels == paramDisplayMetrics2.widthPixels) && (paramDisplayMetrics1.heightPixels == paramDisplayMetrics2.heightPixels) && (paramDisplayMetrics1.density == paramDisplayMetrics2.density) && (paramDisplayMetrics1.densityDpi == paramDisplayMetrics2.densityDpi) && (paramDisplayMetrics1.scaledDensity == paramDisplayMetrics2.scaledDensity) && (paramDisplayMetrics1.xdpi == paramDisplayMetrics2.xdpi) && (paramDisplayMetrics1.ydpi == paramDisplayMetrics2.ydpi);
    }

    private void checkForDeviceDimensionsChanges()
    {
      DisplayMetricsHolder.initDisplayMetrics(ReactRootView.this.getContext());
      if ((!areMetricsEqual(this.mWindowMetrics, DisplayMetricsHolder.getWindowDisplayMetrics())) || (!areMetricsEqual(this.mScreenMetrics, DisplayMetricsHolder.getScreenDisplayMetrics())))
      {
        this.mWindowMetrics.setTo(DisplayMetricsHolder.getWindowDisplayMetrics());
        this.mScreenMetrics.setTo(DisplayMetricsHolder.getScreenDisplayMetrics());
        emitUpdateDimensionsEvent();
      }
    }

    private void checkForDeviceOrientationChanges()
    {
      int i = ((WindowManager)ReactRootView.this.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
      if (this.mDeviceRotation == i)
        return;
      this.mDeviceRotation = i;
      emitOrientationChanged(i);
    }

    private void checkForKeyboardEvents()
    {
      ReactRootView.this.getRootView().getWindowVisibleDisplayFrame(this.mVisibleViewArea);
      int i = DisplayMetricsHolder.getWindowDisplayMetrics().heightPixels - this.mVisibleViewArea.bottom;
      if ((this.mKeyboardHeight != i) && (i > this.mMinKeyboardHeightDetected))
      {
        this.mKeyboardHeight = i;
        localWritableMap1 = Arguments.createMap();
        localWritableMap2 = Arguments.createMap();
        localWritableMap2.putDouble("screenY", PixelUtil.toDIPFromPixel(this.mVisibleViewArea.bottom));
        localWritableMap2.putDouble("screenX", PixelUtil.toDIPFromPixel(this.mVisibleViewArea.left));
        localWritableMap2.putDouble("width", PixelUtil.toDIPFromPixel(this.mVisibleViewArea.width()));
        localWritableMap2.putDouble("height", PixelUtil.toDIPFromPixel(this.mKeyboardHeight));
        localWritableMap1.putMap("endCoordinates", localWritableMap2);
        ReactRootView.this.sendEvent("keyboardDidShow", localWritableMap1);
      }
      while ((this.mKeyboardHeight == 0) || (i > this.mMinKeyboardHeightDetected))
      {
        WritableMap localWritableMap1;
        WritableMap localWritableMap2;
        return;
      }
      this.mKeyboardHeight = 0;
      ReactRootView.this.sendEvent("keyboardDidHide", null);
    }

    private void emitOrientationChanged(int paramInt)
    {
      boolean bool = false;
      String str;
      double d;
      switch (paramInt)
      {
      default:
        return;
      case 0:
        str = "portrait-primary";
        d = 0.0D;
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        WritableMap localWritableMap = Arguments.createMap();
        localWritableMap.putString("name", str);
        localWritableMap.putDouble("rotationDegrees", d);
        localWritableMap.putBoolean("isLandscape", bool);
        ReactRootView.this.sendEvent("namedOrientationDidChange", localWritableMap);
        return;
        d = -90.0D;
        str = "landscape-primary";
        bool = true;
        continue;
        str = "portrait-secondary";
        d = 180.0D;
        bool = false;
        continue;
        d = 90.0D;
        str = "landscape-secondary";
        bool = true;
      }
    }

    private void emitUpdateDimensionsEvent()
    {
      ((DeviceInfoModule)ReactRootView.this.mReactInstanceManager.getCurrentReactContext().getNativeModule(DeviceInfoModule.class)).emitUpdateDimensionsEvent();
    }

    public void onGlobalLayout()
    {
      if ((ReactRootView.this.mReactInstanceManager == null) || (!ReactRootView.this.mIsAttachedToInstance) || (ReactRootView.this.mReactInstanceManager.getCurrentReactContext() == null))
        return;
      checkForKeyboardEvents();
      checkForDeviceOrientationChanges();
      checkForDeviceDimensionsChanges();
    }
  }

  public static abstract interface ReactRootViewEventListener
  {
    public abstract void onAttachedToReactInstance(ReactRootView paramReactRootView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.ReactRootView
 * JD-Core Version:    0.6.2
 */
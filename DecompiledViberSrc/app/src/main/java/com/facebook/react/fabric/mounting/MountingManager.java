package com.facebook.react.fabric.mounting;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.fabric.jsi.EventEmitterWrapper;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.react.uimanager.common.SizeMonitoringFrameLayout;
import com.facebook.yoga.YogaMeasureMode;
import java.util.concurrent.ConcurrentHashMap;

public class MountingManager
{
  private final RootViewManager mRootViewManager = new RootViewManager();
  private final ConcurrentHashMap<Integer, ViewState> mTagToViewState = new ConcurrentHashMap();
  private final ViewManagerRegistry mViewManagerRegistry;
  private final ContextBasedViewPool mViewPool;

  public MountingManager(ViewManagerRegistry paramViewManagerRegistry)
  {
    this.mViewManagerRegistry = paramViewManagerRegistry;
    this.mViewPool = new ContextBasedViewPool(paramViewManagerRegistry);
  }

  private void dropView(View paramView)
  {
    UiThreadUtil.assertOnUiThread();
    int i = paramView.getId();
    ViewState localViewState = getViewState(i);
    ViewManager localViewManager = localViewState.mViewManager;
    if ((!localViewState.mIsRoot) && (localViewManager != null))
      localViewManager.onDropViewInstance(paramView);
    if (((paramView instanceof ViewGroup)) && ((localViewManager instanceof ViewGroupManager)))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      ViewGroupManager localViewGroupManager = getViewGroupManager(localViewState);
      for (int j = -1 + localViewGroupManager.getChildCount(localViewGroup); j >= 0; j--)
      {
        View localView = localViewGroupManager.getChildAt(localViewGroup, j);
        if (this.mTagToViewState.get(Integer.valueOf(localView.getId())) != null)
          dropView(localView);
        localViewGroupManager.removeViewAt(localViewGroup, j);
      }
    }
    this.mTagToViewState.remove(Integer.valueOf(i));
    Context localContext = paramView.getContext();
    this.mViewPool.returnToPool((ThemedReactContext)localContext, ((ViewManager)Assertions.assertNotNull(localViewManager)).getName(), paramView);
  }

  private static ViewGroupManager<ViewGroup> getViewGroupManager(ViewState paramViewState)
  {
    if (paramViewState.mViewManager == null)
      throw new IllegalStateException("Unable to find ViewManager");
    return (ViewGroupManager)paramViewState.mViewManager;
  }

  private ViewState getViewState(int paramInt)
  {
    ViewState localViewState = (ViewState)this.mTagToViewState.get(Integer.valueOf(paramInt));
    if (localViewState == null)
      throw new IllegalStateException("Unable to find viewState for tag " + paramInt);
    return localViewState;
  }

  public void addRootView(int paramInt, SizeMonitoringFrameLayout paramSizeMonitoringFrameLayout)
  {
    if (paramSizeMonitoringFrameLayout.getId() != -1)
      throw new IllegalViewOperationException("Trying to add a root view with an explicit id already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addRootView.");
    this.mTagToViewState.put(Integer.valueOf(paramInt), new ViewState(paramInt, paramSizeMonitoringFrameLayout, this.mRootViewManager, true, null));
    paramSizeMonitoringFrameLayout.setId(paramInt);
  }

  public void addViewAt(int paramInt1, int paramInt2, int paramInt3)
  {
    UiThreadUtil.assertOnUiThread();
    ViewState localViewState = getViewState(paramInt1);
    ViewGroup localViewGroup = (ViewGroup)localViewState.mView;
    View localView = getViewState(paramInt2).mView;
    if (localView == null)
      throw new IllegalStateException("Unable to find view for tag " + paramInt2);
    getViewGroupManager(localViewState).addView(localViewGroup, localView, paramInt3);
  }

  public void createView(ThemedReactContext paramThemedReactContext, String paramString, int paramInt, boolean paramBoolean)
  {
    UiThreadUtil.assertOnUiThread();
    ViewManager localViewManager;
    View localView;
    if (!paramBoolean)
    {
      localViewManager = this.mViewManagerRegistry.get(paramString);
      localView = this.mViewPool.getOrCreateView(paramString, paramThemedReactContext);
      localView.setId(paramInt);
    }
    while (true)
    {
      this.mTagToViewState.put(Integer.valueOf(paramInt), new ViewState(paramInt, localView, localViewManager, null));
      return;
      localViewManager = null;
      localView = null;
    }
  }

  public void deleteView(int paramInt)
  {
    UiThreadUtil.assertOnUiThread();
    View localView = getViewState(paramInt).mView;
    if (localView != null)
    {
      dropView(localView);
      return;
    }
    this.mTagToViewState.remove(Integer.valueOf(paramInt));
  }

  public EventEmitterWrapper getEventEmitter(int paramInt)
  {
    ViewState localViewState = (ViewState)this.mTagToViewState.get(Integer.valueOf(paramInt));
    if (localViewState == null)
      return null;
    return localViewState.mEventEmitter;
  }

  public long measure(ReactContext paramReactContext, String paramString, ReadableNativeMap paramReadableNativeMap1, ReadableNativeMap paramReadableNativeMap2, float paramFloat1, YogaMeasureMode paramYogaMeasureMode1, float paramFloat2, YogaMeasureMode paramYogaMeasureMode2)
  {
    return this.mViewManagerRegistry.get(paramString).measure(paramReactContext, paramReadableNativeMap1, paramReadableNativeMap2, paramFloat1, paramYogaMeasureMode1, paramFloat2, paramYogaMeasureMode2);
  }

  public void preallocateView(ThemedReactContext paramThemedReactContext, String paramString)
  {
    this.mViewPool.createView(paramThemedReactContext, paramString);
  }

  public void receiveCommand(int paramInt1, int paramInt2, ReadableArray paramReadableArray)
  {
    ViewState localViewState = getViewState(paramInt1);
    if (localViewState.mViewManager == null)
      throw new IllegalStateException("Unable to find viewState manager for tag " + paramInt1);
    if (localViewState.mView == null)
      throw new IllegalStateException("Unable to find viewState view for tag " + paramInt1);
    localViewState.mViewManager.receiveCommand(localViewState.mView, paramInt2, paramReadableArray);
  }

  public void removeRootView(int paramInt)
  {
    UiThreadUtil.assertOnUiThread();
    ViewState localViewState = (ViewState)this.mTagToViewState.get(Integer.valueOf(paramInt));
    if ((localViewState == null) || (!localViewState.mIsRoot))
      SoftAssertions.assertUnreachable("View with tag " + paramInt + " is not registered as a root view");
    if (localViewState.mView != null)
      dropView(localViewState.mView);
  }

  public void removeViewAt(int paramInt1, int paramInt2)
  {
    UiThreadUtil.assertOnUiThread();
    ViewState localViewState = getViewState(paramInt1);
    ViewGroup localViewGroup = (ViewGroup)localViewState.mView;
    if (localViewGroup == null)
      throw new IllegalStateException("Unable to find view for tag " + paramInt1);
    getViewGroupManager(localViewState).removeViewAt(localViewGroup, paramInt2);
  }

  public void updateEventEmitter(int paramInt, EventEmitterWrapper paramEventEmitterWrapper)
  {
    UiThreadUtil.assertOnUiThread();
    getViewState(paramInt).mEventEmitter = paramEventEmitterWrapper;
  }

  public void updateLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    UiThreadUtil.assertOnUiThread();
    ViewState localViewState = getViewState(paramInt1);
    if (localViewState.mIsRoot)
      return;
    View localView = localViewState.mView;
    if (localView == null)
      throw new IllegalStateException("Unable to find View for tag: " + paramInt1);
    localView.measure(View.MeasureSpec.makeMeasureSpec(paramInt4, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt5, 1073741824));
    ViewParent localViewParent = localView.getParent();
    if ((localViewParent instanceof RootView))
      localViewParent.requestLayout();
    localView.layout(paramInt2, paramInt3, paramInt2 + paramInt4, paramInt3 + paramInt5);
  }

  public void updateLocalData(int paramInt, ReadableMap paramReadableMap)
  {
    UiThreadUtil.assertOnUiThread();
    ViewState localViewState = getViewState(paramInt);
    if (localViewState.mCurrentProps == null)
      throw new IllegalStateException("Can not update local data to view without props: " + paramInt);
    if ((localViewState.mCurrentLocalData != null) && (paramReadableMap.hasKey("hash")) && (localViewState.mCurrentLocalData.getDouble("hash") == paramReadableMap.getDouble("hash")) && (localViewState.mCurrentLocalData.toString().equals(paramReadableMap.toString())));
    ViewManager localViewManager;
    Object localObject;
    do
    {
      return;
      localViewState.mCurrentLocalData = paramReadableMap;
      localViewManager = localViewState.mViewManager;
      if (localViewManager == null)
        throw new IllegalStateException("Unable to find ViewManager for tag: " + paramInt);
      localObject = localViewManager.updateLocalData(localViewState.mView, localViewState.mCurrentProps, new ReactStylesDiffMap(localViewState.mCurrentLocalData));
    }
    while (localObject == null);
    localViewManager.updateExtraData(localViewState.mView, localObject);
  }

  public void updateProps(int paramInt, ReadableMap paramReadableMap)
  {
    if (paramReadableMap == null)
      return;
    UiThreadUtil.assertOnUiThread();
    ViewState localViewState = getViewState(paramInt);
    localViewState.mCurrentProps = new ReactStylesDiffMap(paramReadableMap);
    View localView = localViewState.mView;
    if (localView == null)
      throw new IllegalStateException("Unable to find view for tag " + paramInt);
    ((ViewManager)Assertions.assertNotNull(localViewState.mViewManager)).updateProperties(localView, localViewState.mCurrentProps);
  }

  private static class ViewState
  {
    public ReadableMap mCurrentLocalData;
    public ReactStylesDiffMap mCurrentProps;
    public EventEmitterWrapper mEventEmitter;
    final boolean mIsRoot;
    final int mReactTag;
    final View mView;
    final ViewManager mViewManager;

    private ViewState(int paramInt, View paramView, ViewManager paramViewManager)
    {
      this(paramInt, paramView, paramViewManager, false);
    }

    private ViewState(int paramInt, View paramView, ViewManager paramViewManager, boolean paramBoolean)
    {
      this.mReactTag = paramInt;
      this.mView = paramView;
      this.mIsRoot = paramBoolean;
      this.mViewManager = paramViewManager;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.mounting.MountingManager
 * JD-Core Version:    0.6.2
 */
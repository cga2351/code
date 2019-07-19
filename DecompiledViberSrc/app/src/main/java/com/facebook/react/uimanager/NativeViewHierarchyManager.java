package com.facebook.react.uimanager;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnDismissListener;
import android.widget.PopupMenu.OnMenuItemClickListener;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R.id;
import com.facebook.react.animation.Animation;
import com.facebook.react.animation.AnimationListener;
import com.facebook.react.animation.AnimationRegistry;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.common.SizeMonitoringFrameLayout;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationController;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationListener;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class NativeViewHierarchyManager
{
  private static final String TAG = NativeViewHierarchyManager.class.getSimpleName();
  private final AnimationRegistry mAnimationRegistry = new AnimationRegistry();
  private final JSResponderHandler mJSResponderHandler = new JSResponderHandler();
  private boolean mLayoutAnimationEnabled;
  private final LayoutAnimationController mLayoutAnimator = new LayoutAnimationController();
  private PopupMenu mPopupMenu;
  private final SparseBooleanArray mRootTags;
  private final RootViewManager mRootViewManager;
  private final SparseArray<ViewManager> mTagsToViewManagers;
  private final SparseArray<View> mTagsToViews;
  private final ViewManagerRegistry mViewManagers;

  public NativeViewHierarchyManager(ViewManagerRegistry paramViewManagerRegistry)
  {
    this(paramViewManagerRegistry, new RootViewManager());
  }

  public NativeViewHierarchyManager(ViewManagerRegistry paramViewManagerRegistry, RootViewManager paramRootViewManager)
  {
    this.mViewManagers = paramViewManagerRegistry;
    this.mTagsToViews = new SparseArray();
    this.mTagsToViewManagers = new SparseArray();
    this.mRootTags = new SparseBooleanArray();
    this.mRootViewManager = paramRootViewManager;
  }

  private boolean arrayContains(@Nullable int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null);
    while (true)
    {
      return false;
      int i = paramArrayOfInt.length;
      for (int j = 0; j < i; j++)
        if (paramArrayOfInt[j] == paramInt)
          return true;
    }
  }

  private static String constructManageChildrenErrorMessage(ViewGroup paramViewGroup, ViewGroupManager paramViewGroupManager, @Nullable int[] paramArrayOfInt1, @Nullable ViewAtIndex[] paramArrayOfViewAtIndex, @Nullable int[] paramArrayOfInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramViewGroup != null)
    {
      localStringBuilder.append("View tag:" + paramViewGroup.getId() + "\n");
      localStringBuilder.append("  children(" + paramViewGroupManager.getChildCount(paramViewGroup) + "): [\n");
      for (int i2 = 0; i2 < paramViewGroupManager.getChildCount(paramViewGroup); i2 += 16)
      {
        for (int i3 = 0; (i2 + i3 < paramViewGroupManager.getChildCount(paramViewGroup)) && (i3 < 16); i3++)
          localStringBuilder.append(paramViewGroupManager.getChildAt(paramViewGroup, i2 + i3).getId() + ",");
        localStringBuilder.append("\n");
      }
      localStringBuilder.append(" ],\n");
    }
    if (paramArrayOfInt1 != null)
    {
      localStringBuilder.append("  indicesToRemove(" + paramArrayOfInt1.length + "): [\n");
      for (int n = 0; n < paramArrayOfInt1.length; n += 16)
      {
        for (int i1 = 0; (n + i1 < paramArrayOfInt1.length) && (i1 < 16); i1++)
          localStringBuilder.append(paramArrayOfInt1[(n + i1)] + ",");
        localStringBuilder.append("\n");
      }
      localStringBuilder.append(" ],\n");
    }
    if (paramArrayOfViewAtIndex != null)
    {
      localStringBuilder.append("  viewsToAdd(" + paramArrayOfViewAtIndex.length + "): [\n");
      for (int k = 0; k < paramArrayOfViewAtIndex.length; k += 16)
      {
        for (int m = 0; (k + m < paramArrayOfViewAtIndex.length) && (m < 16); m++)
          localStringBuilder.append("[" + paramArrayOfViewAtIndex[(k + m)].mIndex + "," + paramArrayOfViewAtIndex[(k + m)].mTag + "],");
        localStringBuilder.append("\n");
      }
      localStringBuilder.append(" ],\n");
    }
    if (paramArrayOfInt2 != null)
    {
      localStringBuilder.append("  tagsToDelete(" + paramArrayOfInt2.length + "): [\n");
      for (int i = 0; i < paramArrayOfInt2.length; i += 16)
      {
        for (int j = 0; (i + j < paramArrayOfInt2.length) && (j < 16); j++)
          localStringBuilder.append(paramArrayOfInt2[(i + j)] + ",");
        localStringBuilder.append("\n");
      }
      localStringBuilder.append(" ]\n");
    }
    return localStringBuilder.toString();
  }

  private static String constructSetChildrenErrorMessage(ViewGroup paramViewGroup, ViewGroupManager paramViewGroupManager, ReadableArray paramReadableArray)
  {
    ViewAtIndex[] arrayOfViewAtIndex = new ViewAtIndex[paramReadableArray.size()];
    for (int i = 0; i < paramReadableArray.size(); i++)
      arrayOfViewAtIndex[i] = new ViewAtIndex(paramReadableArray.getInt(i), i);
    return constructManageChildrenErrorMessage(paramViewGroup, paramViewGroupManager, null, arrayOfViewAtIndex, null);
  }

  private ThemedReactContext getReactContextForView(int paramInt)
  {
    View localView = (View)this.mTagsToViews.get(paramInt);
    if (localView == null)
      throw new JSApplicationIllegalArgumentException("Could not find view with tag " + paramInt);
    return (ThemedReactContext)localView.getContext();
  }

  private void updateInstanceHandle(View paramView, long paramLong)
  {
    UiThreadUtil.assertOnUiThread();
    paramView.setTag(R.id.view_tag_instance_handle, Long.valueOf(paramLong));
  }

  private void updateLayout(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.mLayoutAnimationEnabled) && (this.mLayoutAnimator.shouldAnimateLayout(paramView)))
    {
      this.mLayoutAnimator.applyLayoutUpdate(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }

  public void addRootView(int paramInt, SizeMonitoringFrameLayout paramSizeMonitoringFrameLayout, ThemedReactContext paramThemedReactContext)
  {
    try
    {
      addRootViewGroup(paramInt, paramSizeMonitoringFrameLayout, paramThemedReactContext);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected final void addRootViewGroup(int paramInt, ViewGroup paramViewGroup, ThemedReactContext paramThemedReactContext)
  {
    try
    {
      if (paramViewGroup.getId() != -1)
        FLog.e(TAG, "Trying to add a root view with an explicit id (" + paramViewGroup.getId() + ") already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addRootView.");
      this.mTagsToViews.put(paramInt, paramViewGroup);
      this.mTagsToViewManagers.put(paramInt, this.mRootViewManager);
      this.mRootTags.put(paramInt, true);
      paramViewGroup.setId(paramInt);
      return;
    }
    finally
    {
    }
  }

  public void clearJSResponder()
  {
    this.mJSResponderHandler.clearJSResponder();
  }

  void clearLayoutAnimation()
  {
    this.mLayoutAnimator.reset();
  }

  void configureLayoutAnimation(ReadableMap paramReadableMap)
  {
    this.mLayoutAnimator.initializeFromConfig(paramReadableMap);
  }

  public void createView(ThemedReactContext paramThemedReactContext, int paramInt, String paramString, @Nullable ReactStylesDiffMap paramReactStylesDiffMap)
  {
    try
    {
      UiThreadUtil.assertOnUiThread();
      SystraceMessage.beginSection(0L, "NativeViewHierarchyManager_createView").arg("tag", paramInt).arg("className", paramString).flush();
      try
      {
        ViewManager localViewManager = this.mViewManagers.get(paramString);
        View localView = localViewManager.createView(paramThemedReactContext, this.mJSResponderHandler);
        this.mTagsToViews.put(paramInt, localView);
        this.mTagsToViewManagers.put(paramInt, localViewManager);
        localView.setId(paramInt);
        if (paramReactStylesDiffMap != null)
          localViewManager.updateProperties(localView, paramReactStylesDiffMap);
        Systrace.endSection(0L);
        return;
      }
      finally
      {
        Systrace.endSection(0L);
      }
    }
    finally
    {
    }
  }

  public void dismissPopupMenu()
  {
    if (this.mPopupMenu != null)
      this.mPopupMenu.dismiss();
  }

  public void dispatchCommand(int paramInt1, int paramInt2, @Nullable ReadableArray paramReadableArray)
  {
    View localView;
    try
    {
      UiThreadUtil.assertOnUiThread();
      localView = (View)this.mTagsToViews.get(paramInt1);
      if (localView == null)
        throw new IllegalViewOperationException("Trying to send command to a non-existing view with tag " + paramInt1);
    }
    finally
    {
    }
    resolveViewManager(paramInt1).receiveCommand(localView, paramInt2, paramReadableArray);
  }

  protected void dropView(View paramView)
  {
    while (true)
    {
      ViewGroup localViewGroup;
      ViewGroupManager localViewGroupManager;
      int i;
      try
      {
        UiThreadUtil.assertOnUiThread();
        Object localObject2 = this.mTagsToViewManagers.get(paramView.getId());
        if (localObject2 == null)
          return;
        if (!this.mRootTags.get(paramView.getId()))
          resolveViewManager(paramView.getId()).onDropViewInstance(paramView);
        ViewManager localViewManager = (ViewManager)this.mTagsToViewManagers.get(paramView.getId());
        if ((!(paramView instanceof ViewGroup)) || (!(localViewManager instanceof ViewGroupManager)))
          break label174;
        localViewGroup = (ViewGroup)paramView;
        localViewGroupManager = (ViewGroupManager)localViewManager;
        i = -1 + localViewGroupManager.getChildCount(localViewGroup);
        if (i >= 0)
        {
          View localView = localViewGroupManager.getChildAt(localViewGroup, i);
          if (localView == null)
            FLog.e(TAG, "Unable to drop null child view");
          else if (this.mTagsToViews.get(localView.getId()) != null)
            dropView(localView);
        }
      }
      finally
      {
      }
      localViewGroupManager.removeAllViews(localViewGroup);
      label174: this.mTagsToViews.remove(paramView.getId());
      this.mTagsToViewManagers.remove(paramView.getId());
      continue;
      i--;
    }
  }

  public int findTargetTagForTouch(int paramInt, float paramFloat1, float paramFloat2)
  {
    View localView;
    try
    {
      UiThreadUtil.assertOnUiThread();
      localView = (View)this.mTagsToViews.get(paramInt);
      if (localView == null)
        throw new JSApplicationIllegalArgumentException("Could not find view with tag " + paramInt);
    }
    finally
    {
    }
    int i = TouchTargetHelper.findTargetTagForTouch(paramFloat1, paramFloat2, (ViewGroup)localView);
    return i;
  }

  public AnimationRegistry getAnimationRegistry()
  {
    return this.mAnimationRegistry;
  }

  @Nullable
  public long getInstanceHandle(int paramInt)
  {
    View localView = (View)this.mTagsToViews.get(paramInt);
    if (localView == null)
      throw new IllegalViewOperationException("Unable to find view for tag: " + paramInt);
    Long localLong = (Long)localView.getTag(R.id.view_tag_instance_handle);
    if (localLong == null)
      throw new IllegalViewOperationException("Unable to find instanceHandle for tag: " + paramInt);
    return localLong.longValue();
  }

  public void manageChildren(int paramInt, @Nullable int[] paramArrayOfInt1, @Nullable ViewAtIndex[] paramArrayOfViewAtIndex, @Nullable int[] paramArrayOfInt2)
  {
    final ViewGroup localViewGroup;
    final ViewGroupManager localViewGroupManager;
    try
    {
      UiThreadUtil.assertOnUiThread();
      localViewGroup = (ViewGroup)this.mTagsToViews.get(paramInt);
      localViewGroupManager = (ViewGroupManager)resolveViewManager(paramInt);
      if (localViewGroup == null)
        throw new IllegalViewOperationException("Trying to manageChildren view with tag " + paramInt + " which doesn't exist\n detail: " + constructManageChildrenErrorMessage(localViewGroup, localViewGroupManager, paramArrayOfInt1, paramArrayOfViewAtIndex, paramArrayOfInt2));
    }
    finally
    {
    }
    int i = localViewGroupManager.getChildCount(localViewGroup);
    int j;
    int k;
    if (paramArrayOfInt1 != null)
    {
      j = -1 + paramArrayOfInt1.length;
      if (j >= 0)
      {
        k = paramArrayOfInt1[j];
        if (k < 0)
          throw new IllegalViewOperationException("Trying to remove a negative view index:" + k + " view tag: " + paramInt + "\n detail: " + constructManageChildrenErrorMessage(localViewGroup, localViewGroupManager, paramArrayOfInt1, paramArrayOfViewAtIndex, paramArrayOfInt2));
        if (k >= localViewGroupManager.getChildCount(localViewGroup))
          if (this.mRootTags.get(paramInt))
          {
            int m = localViewGroupManager.getChildCount(localViewGroup);
            if (m != 0);
          }
      }
    }
    label406: label681: label685: 
    while (true)
    {
      label219: return;
      throw new IllegalViewOperationException("Trying to remove a view index above child count " + k + " view tag: " + paramInt + "\n detail: " + constructManageChildrenErrorMessage(localViewGroup, localViewGroupManager, paramArrayOfInt1, paramArrayOfViewAtIndex, paramArrayOfInt2));
      if (k >= i)
        throw new IllegalViewOperationException("Trying to remove an out of order view index:" + k + " view tag: " + paramInt + "\n detail: " + constructManageChildrenErrorMessage(localViewGroup, localViewGroupManager, paramArrayOfInt1, paramArrayOfViewAtIndex, paramArrayOfInt2));
      View localView1 = localViewGroupManager.getChildAt(localViewGroup, k);
      int n;
      if ((!this.mLayoutAnimationEnabled) || (!this.mLayoutAnimator.shouldAnimateLayout(localView1)) || (!arrayContains(paramArrayOfInt2, localView1.getId())))
      {
        localViewGroupManager.removeViewAt(localViewGroup, k);
        break label650;
        while (n < paramArrayOfViewAtIndex.length)
        {
          ViewAtIndex localViewAtIndex = paramArrayOfViewAtIndex[n];
          View localView3 = (View)this.mTagsToViews.get(localViewAtIndex.mTag);
          if (localView3 == null)
            throw new IllegalViewOperationException("Trying to add unknown view tag: " + localViewAtIndex.mTag + "\n detail: " + constructManageChildrenErrorMessage(localViewGroup, localViewGroupManager, paramArrayOfInt1, paramArrayOfViewAtIndex, paramArrayOfInt2));
          localViewGroupManager.addView(localViewGroup, localView3, localViewAtIndex.mIndex);
          n++;
        }
      }
      while (true)
      {
        int i1;
        if (i1 >= paramArrayOfInt2.length)
          break label685;
        int i2 = paramArrayOfInt2[i1];
        final View localView2 = (View)this.mTagsToViews.get(i2);
        if (localView2 == null)
          throw new IllegalViewOperationException("Trying to destroy unknown view tag: " + i2 + "\n detail: " + constructManageChildrenErrorMessage(localViewGroup, localViewGroupManager, paramArrayOfInt1, paramArrayOfViewAtIndex, paramArrayOfInt2));
        if ((this.mLayoutAnimationEnabled) && (this.mLayoutAnimator.shouldAnimateLayout(localView2)))
        {
          this.mLayoutAnimator.deleteView(localView2, new LayoutAnimationListener()
          {
            public void onAnimationEnd()
            {
              localViewGroupManager.removeView(localViewGroup, localView2);
              NativeViewHierarchyManager.this.dropView(localView2);
            }
          });
        }
        else
        {
          dropView(localView2);
          break label681;
          j--;
          i = k;
          break;
          if (paramArrayOfViewAtIndex != null)
          {
            n = 0;
            break label406;
          }
          if (paramArrayOfInt2 == null)
            break label219;
          i1 = 0;
          continue;
        }
        i1++;
      }
    }
  }

  public void measure(int paramInt, int[] paramArrayOfInt)
  {
    View localView1;
    try
    {
      UiThreadUtil.assertOnUiThread();
      localView1 = (View)this.mTagsToViews.get(paramInt);
      if (localView1 == null)
        throw new NoSuchNativeViewException("No native view for " + paramInt + " currently exists");
    }
    finally
    {
    }
    View localView2 = (View)RootViewUtil.getRootView(localView1);
    if (localView2 == null)
      throw new NoSuchNativeViewException("Native view " + paramInt + " is no longer on screen");
    localView2.getLocationInWindow(paramArrayOfInt);
    int i = paramArrayOfInt[0];
    int j = paramArrayOfInt[1];
    localView1.getLocationInWindow(paramArrayOfInt);
    paramArrayOfInt[0] -= i;
    paramArrayOfInt[1] -= j;
    paramArrayOfInt[2] = localView1.getWidth();
    paramArrayOfInt[3] = localView1.getHeight();
  }

  public void measureInWindow(int paramInt, int[] paramArrayOfInt)
  {
    View localView;
    try
    {
      UiThreadUtil.assertOnUiThread();
      localView = (View)this.mTagsToViews.get(paramInt);
      if (localView == null)
        throw new NoSuchNativeViewException("No native view for " + paramInt + " currently exists");
    }
    finally
    {
    }
    localView.getLocationOnScreen(paramArrayOfInt);
    Resources localResources = localView.getContext().getResources();
    int i = localResources.getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0)
    {
      int j = (int)localResources.getDimension(i);
      paramArrayOfInt[1] -= j;
    }
    paramArrayOfInt[2] = localView.getWidth();
    paramArrayOfInt[3] = localView.getHeight();
  }

  public void removeRootView(int paramInt)
  {
    try
    {
      UiThreadUtil.assertOnUiThread();
      if (!this.mRootTags.get(paramInt))
        SoftAssertions.assertUnreachable("View with tag " + paramInt + " is not registered as a root view");
      dropView((View)this.mTagsToViews.get(paramInt));
      this.mRootTags.delete(paramInt);
      return;
    }
    finally
    {
    }
  }

  public final View resolveView(int paramInt)
  {
    View localView;
    try
    {
      localView = (View)this.mTagsToViews.get(paramInt);
      if (localView == null)
        throw new IllegalViewOperationException("Trying to resolve view with tag " + paramInt + " which doesn't exist");
    }
    finally
    {
    }
    return localView;
  }

  public final ViewManager resolveViewManager(int paramInt)
  {
    ViewManager localViewManager;
    try
    {
      localViewManager = (ViewManager)this.mTagsToViewManagers.get(paramInt);
      if (localViewManager == null)
        throw new IllegalViewOperationException("ViewManager for tag " + paramInt + " could not be found");
    }
    finally
    {
    }
    return localViewManager;
  }

  public void sendAccessibilityEvent(int paramInt1, int paramInt2)
  {
    View localView = (View)this.mTagsToViews.get(paramInt1);
    if (localView == null)
      throw new JSApplicationIllegalArgumentException("Could not find view with tag " + paramInt1);
    AccessibilityHelper.sendAccessibilityEvent(localView, paramInt2);
  }

  public void setChildren(int paramInt, ReadableArray paramReadableArray)
  {
    while (true)
    {
      ViewGroup localViewGroup;
      ViewGroupManager localViewGroupManager;
      int i;
      View localView;
      try
      {
        UiThreadUtil.assertOnUiThread();
        localViewGroup = (ViewGroup)this.mTagsToViews.get(paramInt);
        localViewGroupManager = (ViewGroupManager)resolveViewManager(paramInt);
        i = 0;
        if (i >= paramReadableArray.size())
          break;
        localView = (View)this.mTagsToViews.get(paramReadableArray.getInt(i));
        if (localView == null)
          throw new IllegalViewOperationException("Trying to add unknown view tag: " + paramReadableArray.getInt(i) + "\n detail: " + constructSetChildrenErrorMessage(localViewGroup, localViewGroupManager, paramReadableArray));
      }
      finally
      {
      }
      localViewGroupManager.addView(localViewGroup, localView, i);
      i++;
    }
  }

  public void setJSResponder(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!paramBoolean);
    while (true)
    {
      View localView;
      try
      {
        this.mJSResponderHandler.setJSResponder(paramInt2, null);
        return;
        localView = (View)this.mTagsToViews.get(paramInt1);
        if ((paramInt2 != paramInt1) && ((localView instanceof ViewParent)))
        {
          this.mJSResponderHandler.setJSResponder(paramInt2, (ViewParent)localView);
          continue;
        }
      }
      finally
      {
      }
      if (this.mRootTags.get(paramInt1))
        SoftAssertions.assertUnreachable("Cannot block native responder on " + paramInt1 + " that is a root view");
      this.mJSResponderHandler.setJSResponder(paramInt2, localView.getParent());
    }
  }

  public void setLayoutAnimationEnabled(boolean paramBoolean)
  {
    this.mLayoutAnimationEnabled = paramBoolean;
  }

  public void showPopupMenu(int paramInt, ReadableArray paramReadableArray, Callback paramCallback1, Callback paramCallback2)
  {
    try
    {
      UiThreadUtil.assertOnUiThread();
      View localView = (View)this.mTagsToViews.get(paramInt);
      if (localView == null)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = ("Can't display popup. Could not find view with tag " + paramInt);
        paramCallback2.invoke(arrayOfObject);
      }
      while (true)
      {
        return;
        this.mPopupMenu = new PopupMenu(getReactContextForView(paramInt), localView);
        Menu localMenu = this.mPopupMenu.getMenu();
        for (int i = 0; i < paramReadableArray.size(); i++)
          localMenu.add(0, 0, i, paramReadableArray.getString(i));
        PopupMenuCallbackHandler localPopupMenuCallbackHandler = new PopupMenuCallbackHandler(paramCallback1, null);
        this.mPopupMenu.setOnMenuItemClickListener(localPopupMenuCallbackHandler);
        this.mPopupMenu.setOnDismissListener(localPopupMenuCallbackHandler);
        this.mPopupMenu.show();
      }
    }
    finally
    {
    }
  }

  void startAnimationForNativeView(int paramInt, Animation paramAnimation, @Nullable final Callback paramCallback)
  {
    try
    {
      UiThreadUtil.assertOnUiThread();
      View localView = (View)this.mTagsToViews.get(paramInt);
      final int i = paramAnimation.getAnimationID();
      if (localView != null)
      {
        paramAnimation.setAnimationListener(new AnimationListener()
        {
          public void onCancel()
          {
            Assertions.assertNotNull(NativeViewHierarchyManager.this.mAnimationRegistry.removeAnimation(i), "Animation was already removed somehow!");
            if (paramCallback != null)
            {
              Callback localCallback = paramCallback;
              Object[] arrayOfObject = new Object[1];
              arrayOfObject[0] = Boolean.valueOf(false);
              localCallback.invoke(arrayOfObject);
            }
          }

          public void onFinished()
          {
            Assertions.assertNotNull(NativeViewHierarchyManager.this.mAnimationRegistry.removeAnimation(i), "Animation was already removed somehow!");
            if (paramCallback != null)
            {
              Callback localCallback = paramCallback;
              Object[] arrayOfObject = new Object[1];
              arrayOfObject[0] = Boolean.valueOf(true);
              localCallback.invoke(arrayOfObject);
            }
          }
        });
        paramAnimation.start(localView);
        return;
      }
      throw new IllegalViewOperationException("View with tag " + paramInt + " not found");
    }
    finally
    {
    }
  }

  public void updateInstanceHandle(int paramInt, long paramLong)
  {
    try
    {
      UiThreadUtil.assertOnUiThread();
      try
      {
        updateInstanceHandle(resolveView(paramInt), paramLong);
        return;
      }
      catch (IllegalViewOperationException localIllegalViewOperationException)
      {
        while (true)
          FLog.e(TAG, "Unable to update properties for view tag " + paramInt, localIllegalViewOperationException);
      }
    }
    finally
    {
    }
  }

  public void updateLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    while (true)
    {
      View localView;
      try
      {
        UiThreadUtil.assertOnUiThread();
        SystraceMessage.beginSection(0L, "NativeViewHierarchyManager_updateLayout").arg("parentTag", paramInt1).arg("tag", paramInt2).flush();
        try
        {
          localView = resolveView(paramInt2);
          localView.measure(View.MeasureSpec.makeMeasureSpec(paramInt5, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt6, 1073741824));
          ViewParent localViewParent = localView.getParent();
          if ((localViewParent instanceof RootView))
            localViewParent.requestLayout();
          if (!this.mRootTags.get(paramInt1))
          {
            ViewManager localViewManager = (ViewManager)this.mTagsToViewManagers.get(paramInt1);
            if ((localViewManager instanceof ViewGroupManager))
            {
              ViewGroupManager localViewGroupManager = (ViewGroupManager)localViewManager;
              if ((localViewGroupManager != null) && (!localViewGroupManager.needsCustomLayoutForChildren()))
                updateLayout(localView, paramInt3, paramInt4, paramInt5, paramInt6);
              Systrace.endSection(0L);
              return;
            }
            throw new IllegalViewOperationException("Trying to use view with tag " + paramInt1 + " as a parent, but its Manager doesn't extends ViewGroupManager");
          }
        }
        finally
        {
          Systrace.endSection(0L);
        }
      }
      finally
      {
      }
      updateLayout(localView, paramInt3, paramInt4, paramInt5, paramInt6);
    }
  }

  public void updateProperties(int paramInt, ReactStylesDiffMap paramReactStylesDiffMap)
  {
    try
    {
      UiThreadUtil.assertOnUiThread();
      try
      {
        ViewManager localViewManager = resolveViewManager(paramInt);
        View localView = resolveView(paramInt);
        if (paramReactStylesDiffMap != null)
          localViewManager.updateProperties(localView, paramReactStylesDiffMap);
        return;
      }
      catch (IllegalViewOperationException localIllegalViewOperationException)
      {
        while (true)
          FLog.e(TAG, "Unable to update properties for view tag " + paramInt, localIllegalViewOperationException);
      }
    }
    finally
    {
    }
  }

  public void updateViewExtraData(int paramInt, Object paramObject)
  {
    try
    {
      UiThreadUtil.assertOnUiThread();
      resolveViewManager(paramInt).updateExtraData(resolveView(paramInt), paramObject);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static class PopupMenuCallbackHandler
    implements PopupMenu.OnDismissListener, PopupMenu.OnMenuItemClickListener
  {
    boolean mConsumed = false;
    final Callback mSuccess;

    private PopupMenuCallbackHandler(Callback paramCallback)
    {
      this.mSuccess = paramCallback;
    }

    public void onDismiss(PopupMenu paramPopupMenu)
    {
      if (!this.mConsumed)
      {
        this.mSuccess.invoke(new Object[] { "dismissed" });
        this.mConsumed = true;
      }
    }

    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      if (!this.mConsumed)
      {
        Callback localCallback = this.mSuccess;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = "itemSelected";
        arrayOfObject[1] = Integer.valueOf(paramMenuItem.getOrder());
        localCallback.invoke(arrayOfObject);
        this.mConsumed = true;
        return true;
      }
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.NativeViewHierarchyManager
 * JD-Core Version:    0.6.2
 */
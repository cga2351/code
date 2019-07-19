package com.facebook.react.uimanager;

import android.os.SystemClock;
import android.view.View.MeasureSpec;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.animation.Animation;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.common.MeasureSpecProvider;
import com.facebook.react.uimanager.common.SizeMonitoringFrameLayout;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import com.facebook.yoga.YogaDirection;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public class UIImplementation
{
  protected final EventDispatcher mEventDispatcher;
  private long mLastCalculateLayoutTime = 0L;

  @Nullable
  protected LayoutUpdateListener mLayoutUpdateListener;
  private final int[] mMeasureBuffer = new int[4];
  private final Set<Integer> mMeasuredRootNodes = new HashSet();
  private final NativeViewHierarchyOptimizer mNativeViewHierarchyOptimizer;
  private final UIViewOperationQueue mOperationsQueue;
  protected final ReactApplicationContext mReactContext;
  protected final ShadowNodeRegistry mShadowNodeRegistry = new ShadowNodeRegistry();
  private final ViewManagerRegistry mViewManagers;

  public UIImplementation(ReactApplicationContext paramReactApplicationContext, UIManagerModule.ViewManagerResolver paramViewManagerResolver, EventDispatcher paramEventDispatcher, int paramInt)
  {
    this(paramReactApplicationContext, new ViewManagerRegistry(paramViewManagerResolver), paramEventDispatcher, paramInt);
  }

  protected UIImplementation(ReactApplicationContext paramReactApplicationContext, ViewManagerRegistry paramViewManagerRegistry, UIViewOperationQueue paramUIViewOperationQueue, EventDispatcher paramEventDispatcher)
  {
    this.mReactContext = paramReactApplicationContext;
    this.mViewManagers = paramViewManagerRegistry;
    this.mOperationsQueue = paramUIViewOperationQueue;
    this.mNativeViewHierarchyOptimizer = new NativeViewHierarchyOptimizer(this.mOperationsQueue, this.mShadowNodeRegistry);
    this.mEventDispatcher = paramEventDispatcher;
  }

  UIImplementation(ReactApplicationContext paramReactApplicationContext, ViewManagerRegistry paramViewManagerRegistry, EventDispatcher paramEventDispatcher, int paramInt)
  {
    this(paramReactApplicationContext, paramViewManagerRegistry, new UIViewOperationQueue(paramReactApplicationContext, new NativeViewHierarchyManager(paramViewManagerRegistry), paramInt), paramEventDispatcher);
  }

  public UIImplementation(ReactApplicationContext paramReactApplicationContext, List<ViewManager> paramList, EventDispatcher paramEventDispatcher, int paramInt)
  {
    this(paramReactApplicationContext, new ViewManagerRegistry(paramList), paramEventDispatcher, paramInt);
  }

  private void assertNodeDoesNotNeedCustomLayoutForChildren(ReactShadowNode paramReactShadowNode)
  {
    ViewManager localViewManager = (ViewManager)Assertions.assertNotNull(this.mViewManagers.get(paramReactShadowNode.getViewClass()));
    if ((localViewManager instanceof ViewGroupManager))
    {
      ViewGroupManager localViewGroupManager = (ViewGroupManager)localViewManager;
      if ((localViewGroupManager != null) && (localViewGroupManager.needsCustomLayoutForChildren()))
        throw new IllegalViewOperationException("Trying to measure a view using measureLayout/measureLayoutRelativeToParent relative to an ancestor that requires custom layout for it's children (" + paramReactShadowNode.getViewClass() + "). Use measure instead.");
    }
    else
    {
      throw new IllegalViewOperationException("Trying to use view " + paramReactShadowNode.getViewClass() + " as a parent, but its Manager doesn't extends ViewGroupManager");
    }
  }

  private void assertViewExists(int paramInt, String paramString)
  {
    if (this.mShadowNodeRegistry.getNode(paramInt) == null)
      throw new IllegalViewOperationException("Unable to execute operation " + paramString + " on view with tag: " + paramInt + ", since the view does not exists");
  }

  private void dispatchViewUpdatesIfNeeded()
  {
    if (this.mOperationsQueue.isEmpty())
      dispatchViewUpdates(-1);
  }

  private void measureLayout(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    ReactShadowNode localReactShadowNode1 = this.mShadowNodeRegistry.getNode(paramInt1);
    ReactShadowNode localReactShadowNode2 = this.mShadowNodeRegistry.getNode(paramInt2);
    if ((localReactShadowNode1 == null) || (localReactShadowNode2 == null))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Tag ");
      if (localReactShadowNode1 == null);
      while (true)
      {
        throw new IllegalViewOperationException(paramInt1 + " does not exist");
        paramInt1 = paramInt2;
      }
    }
    if (localReactShadowNode1 != localReactShadowNode2)
      for (ReactShadowNode localReactShadowNode3 = localReactShadowNode1.getParent(); localReactShadowNode3 != localReactShadowNode2; localReactShadowNode3 = localReactShadowNode3.getParent())
        if (localReactShadowNode3 == null)
          throw new IllegalViewOperationException("Tag " + paramInt2 + " is not an ancestor of tag " + paramInt1);
    measureLayoutRelativeToVerifiedAncestor(localReactShadowNode1, localReactShadowNode2, paramArrayOfInt);
  }

  private void measureLayoutRelativeToParent(int paramInt, int[] paramArrayOfInt)
  {
    ReactShadowNode localReactShadowNode1 = this.mShadowNodeRegistry.getNode(paramInt);
    if (localReactShadowNode1 == null)
      throw new IllegalViewOperationException("No native view for tag " + paramInt + " exists!");
    ReactShadowNode localReactShadowNode2 = localReactShadowNode1.getParent();
    if (localReactShadowNode2 == null)
      throw new IllegalViewOperationException("View with tag " + paramInt + " doesn't have a parent!");
    measureLayoutRelativeToVerifiedAncestor(localReactShadowNode1, localReactShadowNode2, paramArrayOfInt);
  }

  private void measureLayoutRelativeToVerifiedAncestor(ReactShadowNode paramReactShadowNode1, ReactShadowNode paramReactShadowNode2, int[] paramArrayOfInt)
  {
    int i;
    int j;
    if (paramReactShadowNode1 != paramReactShadowNode2)
    {
      int k = Math.round(paramReactShadowNode1.getLayoutX());
      int m = Math.round(paramReactShadowNode1.getLayoutY());
      ReactShadowNode localReactShadowNode1 = paramReactShadowNode1.getParent();
      i = m;
      j = k;
      ReactShadowNode localReactShadowNode2 = localReactShadowNode1;
      while (localReactShadowNode2 != paramReactShadowNode2)
      {
        Assertions.assertNotNull(localReactShadowNode2);
        assertNodeDoesNotNeedCustomLayoutForChildren(localReactShadowNode2);
        int n = j + Math.round(localReactShadowNode2.getLayoutX());
        int i1 = i + Math.round(localReactShadowNode2.getLayoutY());
        localReactShadowNode2 = localReactShadowNode2.getParent();
        i = i1;
        j = n;
      }
      assertNodeDoesNotNeedCustomLayoutForChildren(paramReactShadowNode2);
    }
    while (true)
    {
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = i;
      paramArrayOfInt[2] = paramReactShadowNode1.getScreenWidth();
      paramArrayOfInt[3] = paramReactShadowNode1.getScreenHeight();
      return;
      i = 0;
      j = 0;
    }
  }

  private void notifyOnBeforeLayoutRecursive(ReactShadowNode paramReactShadowNode)
  {
    if (!paramReactShadowNode.hasUpdates())
      return;
    for (int i = 0; i < paramReactShadowNode.getChildCount(); i++)
      notifyOnBeforeLayoutRecursive(paramReactShadowNode.getChildAt(i));
    paramReactShadowNode.onBeforeLayout();
  }

  private void removeShadowNodeRecursive(ReactShadowNode paramReactShadowNode)
  {
    NativeViewHierarchyOptimizer.handleRemoveNode(paramReactShadowNode);
    this.mShadowNodeRegistry.removeNode(paramReactShadowNode.getReactTag());
    this.mMeasuredRootNodes.remove(Integer.valueOf(paramReactShadowNode.getReactTag()));
    for (int i = -1 + paramReactShadowNode.getChildCount(); i >= 0; i--)
      removeShadowNodeRecursive(paramReactShadowNode.getChildAt(i));
    paramReactShadowNode.removeAndDisposeAllChildren();
  }

  public void addAnimation(int paramInt1, int paramInt2, Callback paramCallback)
  {
    assertViewExists(paramInt1, "addAnimation");
    this.mOperationsQueue.enqueueAddAnimation(paramInt1, paramInt2, paramCallback);
  }

  public void addUIBlock(UIBlock paramUIBlock)
  {
    this.mOperationsQueue.enqueueUIBlock(paramUIBlock);
  }

  protected void applyUpdatesRecursive(ReactShadowNode paramReactShadowNode, float paramFloat1, float paramFloat2)
  {
    if (!paramReactShadowNode.hasUpdates())
      return;
    if (!paramReactShadowNode.isVirtualAnchor())
      for (int j = 0; j < paramReactShadowNode.getChildCount(); j++)
        applyUpdatesRecursive(paramReactShadowNode.getChildAt(j), paramFloat1 + paramReactShadowNode.getLayoutX(), paramFloat2 + paramReactShadowNode.getLayoutY());
    int i = paramReactShadowNode.getReactTag();
    if ((!this.mShadowNodeRegistry.isRootNode(i)) && (paramReactShadowNode.dispatchUpdates(paramFloat1, paramFloat2, this.mOperationsQueue, this.mNativeViewHierarchyOptimizer)) && (paramReactShadowNode.shouldNotifyOnLayout()))
      this.mEventDispatcher.dispatchEvent(OnLayoutEvent.obtain(i, paramReactShadowNode.getScreenX(), paramReactShadowNode.getScreenY(), paramReactShadowNode.getScreenWidth(), paramReactShadowNode.getScreenHeight()));
    paramReactShadowNode.markUpdateSeen();
  }

  protected void calculateRootLayout(ReactShadowNode paramReactShadowNode)
  {
    SystraceMessage.beginSection(0L, "cssRoot.calculateLayout").arg("rootTag", paramReactShadowNode.getReactTag()).flush();
    long l = SystemClock.uptimeMillis();
    try
    {
      paramReactShadowNode.calculateLayout();
      return;
    }
    finally
    {
      Systrace.endSection(0L);
      this.mLastCalculateLayoutTime = (SystemClock.uptimeMillis() - l);
    }
  }

  public void clearJSResponder()
  {
    this.mOperationsQueue.enqueueClearJSResponder();
  }

  public void configureNextLayoutAnimation(ReadableMap paramReadableMap, Callback paramCallback1, Callback paramCallback2)
  {
    this.mOperationsQueue.enqueueConfigureLayoutAnimation(paramReadableMap, paramCallback1, paramCallback2);
  }

  protected ReactShadowNode createRootShadowNode()
  {
    ReactShadowNodeImpl localReactShadowNodeImpl = new ReactShadowNodeImpl();
    if (I18nUtil.getInstance().isRTL(this.mReactContext))
      localReactShadowNodeImpl.setLayoutDirection(YogaDirection.RTL);
    localReactShadowNodeImpl.setViewClassName("Root");
    return localReactShadowNodeImpl;
  }

  protected ReactShadowNode createShadowNode(String paramString)
  {
    return this.mViewManagers.get(paramString).createShadowNodeInstance(this.mReactContext);
  }

  public void createView(int paramInt1, String paramString, int paramInt2, ReadableMap paramReadableMap)
  {
    ReactShadowNode localReactShadowNode1 = createShadowNode(paramString);
    ReactShadowNode localReactShadowNode2 = this.mShadowNodeRegistry.getNode(paramInt2);
    Assertions.assertNotNull(localReactShadowNode2, "Root node with tag " + paramInt2 + " doesn't exist");
    localReactShadowNode1.setReactTag(paramInt1);
    localReactShadowNode1.setViewClassName(paramString);
    localReactShadowNode1.setRootTag(localReactShadowNode2.getReactTag());
    localReactShadowNode1.setThemedContext(localReactShadowNode2.getThemedContext());
    this.mShadowNodeRegistry.addNode(localReactShadowNode1);
    ReactStylesDiffMap localReactStylesDiffMap = null;
    if (paramReadableMap != null)
    {
      localReactStylesDiffMap = new ReactStylesDiffMap(paramReadableMap);
      localReactShadowNode1.updateProperties(localReactStylesDiffMap);
    }
    handleCreateView(localReactShadowNode1, paramInt2, localReactStylesDiffMap);
  }

  public void dismissPopupMenu()
  {
    this.mOperationsQueue.enqueueDismissPopupMenu();
  }

  public void dispatchViewManagerCommand(int paramInt1, int paramInt2, @Nullable ReadableArray paramReadableArray)
  {
    assertViewExists(paramInt1, "dispatchViewManagerCommand");
    this.mOperationsQueue.enqueueDispatchCommand(paramInt1, paramInt2, paramReadableArray);
  }

  public void dispatchViewUpdates(int paramInt)
  {
    SystraceMessage.beginSection(0L, "UIImplementation.dispatchViewUpdates").arg("batchId", paramInt).flush();
    long l = SystemClock.uptimeMillis();
    try
    {
      updateViewHierarchy();
      this.mNativeViewHierarchyOptimizer.onBatchComplete();
      this.mOperationsQueue.dispatchViewUpdates(paramInt, l, this.mLastCalculateLayoutTime);
      return;
    }
    finally
    {
      Systrace.endSection(0L);
    }
  }

  public void enableLayoutCalculationForRootNode(int paramInt)
  {
    this.mMeasuredRootNodes.add(Integer.valueOf(paramInt));
  }

  public void findSubviewIn(int paramInt, float paramFloat1, float paramFloat2, Callback paramCallback)
  {
    this.mOperationsQueue.enqueueFindTargetForTouch(paramInt, paramFloat1, paramFloat2, paramCallback);
  }

  public Map<String, Long> getProfiledBatchPerfCounters()
  {
    return this.mOperationsQueue.getProfiledBatchPerfCounters();
  }

  UIViewOperationQueue getUIViewOperationQueue()
  {
    return this.mOperationsQueue;
  }

  protected void handleCreateView(ReactShadowNode paramReactShadowNode, int paramInt, @Nullable ReactStylesDiffMap paramReactStylesDiffMap)
  {
    if (!paramReactShadowNode.isVirtual())
      this.mNativeViewHierarchyOptimizer.handleCreateView(paramReactShadowNode, paramReactShadowNode.getThemedContext(), paramReactStylesDiffMap);
  }

  protected void handleUpdateView(ReactShadowNode paramReactShadowNode, String paramString, ReactStylesDiffMap paramReactStylesDiffMap)
  {
    if (!paramReactShadowNode.isVirtual())
      this.mNativeViewHierarchyOptimizer.handleUpdateView(paramReactShadowNode, paramString, paramReactStylesDiffMap);
  }

  public void manageChildren(int paramInt, @Nullable ReadableArray paramReadableArray1, @Nullable ReadableArray paramReadableArray2, @Nullable ReadableArray paramReadableArray3, @Nullable ReadableArray paramReadableArray4, @Nullable ReadableArray paramReadableArray5)
  {
    ReactShadowNode localReactShadowNode1 = this.mShadowNodeRegistry.getNode(paramInt);
    int i;
    int j;
    if (paramReadableArray1 == null)
    {
      i = 0;
      if (paramReadableArray3 != null)
        break label75;
      j = 0;
      label25: if (paramReadableArray5 != null)
        break label87;
    }
    label75: label87: for (int k = 0; ; k = paramReadableArray5.size())
    {
      if ((i == 0) || ((paramReadableArray2 != null) && (i == paramReadableArray2.size())))
        break label99;
      throw new IllegalViewOperationException("Size of moveFrom != size of moveTo!");
      i = paramReadableArray1.size();
      break;
      j = paramReadableArray3.size();
      break label25;
    }
    label99: if ((j != 0) && ((paramReadableArray4 == null) || (j != paramReadableArray4.size())))
      throw new IllegalViewOperationException("Size of addChildTags != size of addAtIndices!");
    ViewAtIndex[] arrayOfViewAtIndex = new ViewAtIndex[i + j];
    int[] arrayOfInt1 = new int[i + k];
    int[] arrayOfInt2 = new int[arrayOfInt1.length];
    int[] arrayOfInt3 = new int[k];
    if (i > 0)
    {
      Assertions.assertNotNull(paramReadableArray1);
      Assertions.assertNotNull(paramReadableArray2);
      for (int i9 = 0; i9 < i; i9++)
      {
        int i10 = paramReadableArray1.getInt(i9);
        int i11 = localReactShadowNode1.getChildAt(i10).getReactTag();
        arrayOfViewAtIndex[i9] = new ViewAtIndex(i11, paramReadableArray2.getInt(i9));
        arrayOfInt1[i9] = i10;
        arrayOfInt2[i9] = i11;
      }
    }
    if (j > 0)
    {
      Assertions.assertNotNull(paramReadableArray3);
      Assertions.assertNotNull(paramReadableArray4);
      for (int i6 = 0; i6 < j; i6++)
      {
        int i7 = paramReadableArray3.getInt(i6);
        int i8 = paramReadableArray4.getInt(i6);
        arrayOfViewAtIndex[(i + i6)] = new ViewAtIndex(i7, i8);
      }
    }
    if (k > 0)
    {
      Assertions.assertNotNull(paramReadableArray5);
      for (int i3 = 0; i3 < k; i3++)
      {
        int i4 = paramReadableArray5.getInt(i3);
        int i5 = localReactShadowNode1.getChildAt(i4).getReactTag();
        arrayOfInt1[(i + i3)] = i4;
        arrayOfInt2[(i + i3)] = i5;
        arrayOfInt3[i3] = i5;
      }
    }
    Arrays.sort(arrayOfViewAtIndex, ViewAtIndex.COMPARATOR);
    Arrays.sort(arrayOfInt1);
    int m = -1;
    for (int n = -1 + arrayOfInt1.length; n >= 0; n--)
    {
      if (arrayOfInt1[n] == m)
        throw new IllegalViewOperationException("Repeated indices in Removal list for view tag: " + paramInt);
      localReactShadowNode1.removeChildAt(arrayOfInt1[n]);
      m = arrayOfInt1[n];
    }
    for (int i1 = 0; i1 < arrayOfViewAtIndex.length; i1++)
    {
      ViewAtIndex localViewAtIndex = arrayOfViewAtIndex[i1];
      ReactShadowNode localReactShadowNode2 = this.mShadowNodeRegistry.getNode(localViewAtIndex.mTag);
      if (localReactShadowNode2 == null)
        throw new IllegalViewOperationException("Trying to add unknown view tag: " + localViewAtIndex.mTag);
      localReactShadowNode1.addChildAt(localReactShadowNode2, localViewAtIndex.mIndex);
    }
    if ((!localReactShadowNode1.isVirtual()) && (!localReactShadowNode1.isVirtualAnchor()))
      this.mNativeViewHierarchyOptimizer.handleManageChildren(localReactShadowNode1, arrayOfInt1, arrayOfInt2, arrayOfViewAtIndex, arrayOfInt3);
    for (int i2 = 0; i2 < arrayOfInt3.length; i2++)
      removeShadowNode(this.mShadowNodeRegistry.getNode(arrayOfInt3[i2]));
  }

  public void measure(int paramInt, Callback paramCallback)
  {
    this.mOperationsQueue.enqueueMeasure(paramInt, paramCallback);
  }

  public void measureInWindow(int paramInt, Callback paramCallback)
  {
    this.mOperationsQueue.enqueueMeasureInWindow(paramInt, paramCallback);
  }

  public void measureLayout(int paramInt1, int paramInt2, Callback paramCallback1, Callback paramCallback2)
  {
    try
    {
      measureLayout(paramInt1, paramInt2, this.mMeasureBuffer);
      float f1 = PixelUtil.toDIPFromPixel(this.mMeasureBuffer[0]);
      float f2 = PixelUtil.toDIPFromPixel(this.mMeasureBuffer[1]);
      float f3 = PixelUtil.toDIPFromPixel(this.mMeasureBuffer[2]);
      float f4 = PixelUtil.toDIPFromPixel(this.mMeasureBuffer[3]);
      Object[] arrayOfObject2 = new Object[4];
      arrayOfObject2[0] = Float.valueOf(f1);
      arrayOfObject2[1] = Float.valueOf(f2);
      arrayOfObject2[2] = Float.valueOf(f3);
      arrayOfObject2[3] = Float.valueOf(f4);
      paramCallback2.invoke(arrayOfObject2);
      return;
    }
    catch (IllegalViewOperationException localIllegalViewOperationException)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = localIllegalViewOperationException.getMessage();
      paramCallback1.invoke(arrayOfObject1);
    }
  }

  public void measureLayoutRelativeToParent(int paramInt, Callback paramCallback1, Callback paramCallback2)
  {
    try
    {
      measureLayoutRelativeToParent(paramInt, this.mMeasureBuffer);
      float f1 = PixelUtil.toDIPFromPixel(this.mMeasureBuffer[0]);
      float f2 = PixelUtil.toDIPFromPixel(this.mMeasureBuffer[1]);
      float f3 = PixelUtil.toDIPFromPixel(this.mMeasureBuffer[2]);
      float f4 = PixelUtil.toDIPFromPixel(this.mMeasureBuffer[3]);
      Object[] arrayOfObject2 = new Object[4];
      arrayOfObject2[0] = Float.valueOf(f1);
      arrayOfObject2[1] = Float.valueOf(f2);
      arrayOfObject2[2] = Float.valueOf(f3);
      arrayOfObject2[3] = Float.valueOf(f4);
      paramCallback2.invoke(arrayOfObject2);
      return;
    }
    catch (IllegalViewOperationException localIllegalViewOperationException)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = localIllegalViewOperationException.getMessage();
      paramCallback1.invoke(arrayOfObject1);
    }
  }

  public void onHostDestroy()
  {
  }

  public void onHostPause()
  {
    this.mOperationsQueue.pauseFrameCallback();
  }

  public void onHostResume()
  {
    this.mOperationsQueue.resumeFrameCallback();
  }

  public void prependUIBlock(UIBlock paramUIBlock)
  {
    this.mOperationsQueue.prependUIBlock(paramUIBlock);
  }

  public void profileNextBatch()
  {
    this.mOperationsQueue.profileNextBatch();
  }

  public void registerAnimation(Animation paramAnimation)
  {
    this.mOperationsQueue.enqueueRegisterAnimation(paramAnimation);
  }

  public <T extends SizeMonitoringFrameLayout,  extends MeasureSpecProvider> void registerRootView(T paramT, int paramInt, ThemedReactContext paramThemedReactContext)
  {
    final ReactShadowNode localReactShadowNode = createRootShadowNode();
    localReactShadowNode.setReactTag(paramInt);
    localReactShadowNode.setThemedContext(paramThemedReactContext);
    updateRootView(localReactShadowNode, ((MeasureSpecProvider)paramT).getWidthMeasureSpec(), ((MeasureSpecProvider)paramT).getHeightMeasureSpec());
    paramThemedReactContext.runOnNativeModulesQueueThread(new Runnable()
    {
      public void run()
      {
        UIImplementation.this.mShadowNodeRegistry.addRootNode(localReactShadowNode);
      }
    });
    this.mOperationsQueue.addRootView(paramInt, paramT, paramThemedReactContext);
  }

  public void removeAnimation(int paramInt1, int paramInt2)
  {
    assertViewExists(paramInt1, "removeAnimation");
    this.mOperationsQueue.enqueueRemoveAnimation(paramInt2);
  }

  public void removeLayoutUpdateListener()
  {
    this.mLayoutUpdateListener = null;
  }

  public void removeRootShadowNode(int paramInt)
  {
    this.mShadowNodeRegistry.removeRootNode(paramInt);
  }

  public void removeRootView(int paramInt)
  {
    removeRootShadowNode(paramInt);
    this.mOperationsQueue.enqueueRemoveRootView(paramInt);
  }

  protected final void removeShadowNode(ReactShadowNode paramReactShadowNode)
  {
    removeShadowNodeRecursive(paramReactShadowNode);
    paramReactShadowNode.dispose();
  }

  public void removeSubviewsFromContainerWithID(int paramInt)
  {
    ReactShadowNode localReactShadowNode = this.mShadowNodeRegistry.getNode(paramInt);
    if (localReactShadowNode == null)
      throw new IllegalViewOperationException("Trying to remove subviews of an unknown view tag: " + paramInt);
    WritableArray localWritableArray = Arguments.createArray();
    for (int i = 0; i < localReactShadowNode.getChildCount(); i++)
      localWritableArray.pushInt(i);
    manageChildren(paramInt, null, null, null, null, localWritableArray);
  }

  public void replaceExistingNonRootView(int paramInt1, int paramInt2)
  {
    if ((this.mShadowNodeRegistry.isRootNode(paramInt1)) || (this.mShadowNodeRegistry.isRootNode(paramInt2)))
      throw new IllegalViewOperationException("Trying to add or replace a root tag!");
    ReactShadowNode localReactShadowNode1 = this.mShadowNodeRegistry.getNode(paramInt1);
    if (localReactShadowNode1 == null)
      throw new IllegalViewOperationException("Trying to replace unknown view tag: " + paramInt1);
    ReactShadowNode localReactShadowNode2 = localReactShadowNode1.getParent();
    if (localReactShadowNode2 == null)
      throw new IllegalViewOperationException("Node is not attached to a parent: " + paramInt1);
    int i = localReactShadowNode2.indexOf(localReactShadowNode1);
    if (i < 0)
      throw new IllegalStateException("Didn't find child tag in parent");
    WritableArray localWritableArray1 = Arguments.createArray();
    localWritableArray1.pushInt(paramInt2);
    WritableArray localWritableArray2 = Arguments.createArray();
    localWritableArray2.pushInt(i);
    WritableArray localWritableArray3 = Arguments.createArray();
    localWritableArray3.pushInt(i);
    manageChildren(localReactShadowNode2.getReactTag(), null, null, localWritableArray1, localWritableArray2, localWritableArray3);
  }

  public int resolveRootTagFromReactTag(int paramInt)
  {
    if (this.mShadowNodeRegistry.isRootNode(paramInt))
      return paramInt;
    ReactShadowNode localReactShadowNode = resolveShadowNode(paramInt);
    if (localReactShadowNode != null);
    for (int i = localReactShadowNode.getRootTag(); ; i = 0)
    {
      return i;
      FLog.w("ReactNative", "Warning : attempted to resolve a non-existent react shadow node. reactTag=" + paramInt);
    }
  }

  public final ReactShadowNode resolveShadowNode(int paramInt)
  {
    return this.mShadowNodeRegistry.getNode(paramInt);
  }

  protected final ViewManager resolveViewManager(String paramString)
  {
    return this.mViewManagers.get(paramString);
  }

  public void sendAccessibilityEvent(int paramInt1, int paramInt2)
  {
    this.mOperationsQueue.enqueueSendAccessibilityEvent(paramInt1, paramInt2);
  }

  public void setChildren(int paramInt, ReadableArray paramReadableArray)
  {
    ReactShadowNode localReactShadowNode1 = this.mShadowNodeRegistry.getNode(paramInt);
    for (int i = 0; i < paramReadableArray.size(); i++)
    {
      ReactShadowNode localReactShadowNode2 = this.mShadowNodeRegistry.getNode(paramReadableArray.getInt(i));
      if (localReactShadowNode2 == null)
        throw new IllegalViewOperationException("Trying to add unknown view tag: " + paramReadableArray.getInt(i));
      localReactShadowNode1.addChildAt(localReactShadowNode2, i);
    }
    if ((!localReactShadowNode1.isVirtual()) && (!localReactShadowNode1.isVirtualAnchor()))
      this.mNativeViewHierarchyOptimizer.handleSetChildren(localReactShadowNode1, paramReadableArray);
  }

  public void setJSResponder(int paramInt, boolean paramBoolean)
  {
    ReactShadowNode localReactShadowNode = this.mShadowNodeRegistry.getNode(paramInt);
    if (localReactShadowNode == null)
      return;
    while ((localReactShadowNode.isVirtual()) || (localReactShadowNode.isLayoutOnly()))
      localReactShadowNode = localReactShadowNode.getParent();
    this.mOperationsQueue.enqueueSetJSResponder(localReactShadowNode.getReactTag(), paramInt, paramBoolean);
  }

  public void setLayoutAnimationEnabledExperimental(boolean paramBoolean)
  {
    this.mOperationsQueue.enqueueSetLayoutAnimationEnabled(paramBoolean);
  }

  public void setLayoutUpdateListener(LayoutUpdateListener paramLayoutUpdateListener)
  {
    this.mLayoutUpdateListener = paramLayoutUpdateListener;
  }

  public void setViewHierarchyUpdateDebugListener(@Nullable NotThreadSafeViewHierarchyUpdateDebugListener paramNotThreadSafeViewHierarchyUpdateDebugListener)
  {
    this.mOperationsQueue.setViewHierarchyUpdateDebugListener(paramNotThreadSafeViewHierarchyUpdateDebugListener);
  }

  public void setViewLocalData(int paramInt, Object paramObject)
  {
    ReactShadowNode localReactShadowNode = this.mShadowNodeRegistry.getNode(paramInt);
    if (localReactShadowNode == null)
    {
      FLog.w("ReactNative", "Attempt to set local data for view with unknown tag: " + paramInt);
      return;
    }
    localReactShadowNode.setLocalData(paramObject);
    dispatchViewUpdatesIfNeeded();
  }

  public void showPopupMenu(int paramInt, ReadableArray paramReadableArray, Callback paramCallback1, Callback paramCallback2)
  {
    assertViewExists(paramInt, "showPopupMenu");
    this.mOperationsQueue.enqueueShowPopupMenu(paramInt, paramReadableArray, paramCallback1, paramCallback2);
  }

  public void synchronouslyUpdateViewOnUIThread(int paramInt, ReactStylesDiffMap paramReactStylesDiffMap)
  {
    UiThreadUtil.assertOnUiThread();
    this.mOperationsQueue.getNativeViewHierarchyManager().updateProperties(paramInt, paramReactStylesDiffMap);
  }

  public void updateNodeSize(int paramInt1, int paramInt2, int paramInt3)
  {
    ReactShadowNode localReactShadowNode = this.mShadowNodeRegistry.getNode(paramInt1);
    if (localReactShadowNode == null)
    {
      FLog.w("ReactNative", "Tried to update size of non-existent tag: " + paramInt1);
      return;
    }
    localReactShadowNode.setStyleWidth(paramInt2);
    localReactShadowNode.setStyleHeight(paramInt3);
    dispatchViewUpdatesIfNeeded();
  }

  public void updateRootView(int paramInt1, int paramInt2, int paramInt3)
  {
    ReactShadowNode localReactShadowNode = this.mShadowNodeRegistry.getNode(paramInt1);
    if (localReactShadowNode == null)
    {
      FLog.w("ReactNative", "Tried to update non-existent root tag: " + paramInt1);
      return;
    }
    updateRootView(localReactShadowNode, paramInt2, paramInt3);
  }

  public void updateRootView(ReactShadowNode paramReactShadowNode, int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    switch (i)
    {
    default:
    case 1073741824:
    case -2147483648:
    case 0:
    }
    int m;
    while (true)
    {
      int k = View.MeasureSpec.getMode(paramInt2);
      m = View.MeasureSpec.getSize(paramInt2);
      switch (k)
      {
      default:
        return;
        paramReactShadowNode.setStyleWidth(j);
        continue;
        paramReactShadowNode.setStyleMaxWidth(j);
        continue;
        paramReactShadowNode.setStyleWidthAuto();
      case 1073741824:
      case -2147483648:
      case 0:
      }
    }
    paramReactShadowNode.setStyleHeight(m);
    return;
    paramReactShadowNode.setStyleMaxHeight(m);
    return;
    paramReactShadowNode.setStyleHeightAuto();
  }

  public void updateView(int paramInt, String paramString, ReadableMap paramReadableMap)
  {
    if (this.mViewManagers.get(paramString) == null)
      throw new IllegalViewOperationException("Got unknown view type: " + paramString);
    ReactShadowNode localReactShadowNode = this.mShadowNodeRegistry.getNode(paramInt);
    if (localReactShadowNode == null)
      throw new IllegalViewOperationException("Trying to update non-existent view with tag " + paramInt);
    if (paramReadableMap != null)
    {
      ReactStylesDiffMap localReactStylesDiffMap = new ReactStylesDiffMap(paramReadableMap);
      localReactShadowNode.updateProperties(localReactStylesDiffMap);
      handleUpdateView(localReactShadowNode, paramString, localReactStylesDiffMap);
    }
  }

  // ERROR //
  protected void updateViewHierarchy()
  {
    // Byte code:
    //   0: lconst_0
    //   1: ldc_w 783
    //   4: invokestatic 786	com/facebook/systrace/Systrace:beginSection	(JLjava/lang/String;)V
    //   7: iconst_0
    //   8: istore_1
    //   9: iload_1
    //   10: aload_0
    //   11: getfield 45	com/facebook/react/uimanager/UIImplementation:mShadowNodeRegistry	Lcom/facebook/react/uimanager/ShadowNodeRegistry;
    //   14: invokevirtual 789	com/facebook/react/uimanager/ShadowNodeRegistry:getRootNodeCount	()I
    //   17: if_icmpge +160 -> 177
    //   20: aload_0
    //   21: getfield 45	com/facebook/react/uimanager/UIImplementation:mShadowNodeRegistry	Lcom/facebook/react/uimanager/ShadowNodeRegistry;
    //   24: iload_1
    //   25: invokevirtual 791	com/facebook/react/uimanager/ShadowNodeRegistry:getRootTag	(I)I
    //   28: istore_3
    //   29: aload_0
    //   30: getfield 45	com/facebook/react/uimanager/UIImplementation:mShadowNodeRegistry	Lcom/facebook/react/uimanager/ShadowNodeRegistry;
    //   33: iload_3
    //   34: invokevirtual 140	com/facebook/react/uimanager/ShadowNodeRegistry:getNode	(I)Lcom/facebook/react/uimanager/ReactShadowNode;
    //   37: astore 4
    //   39: aload_0
    //   40: getfield 50	com/facebook/react/uimanager/UIImplementation:mMeasuredRootNodes	Ljava/util/Set;
    //   43: iload_3
    //   44: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: invokeinterface 794 2 0
    //   52: ifeq +130 -> 182
    //   55: lconst_0
    //   56: ldc_w 796
    //   59: invokestatic 308	com/facebook/systrace/SystraceMessage:beginSection	(JLjava/lang/String;)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   62: ldc_w 310
    //   65: aload 4
    //   67: invokeinterface 227 1 0
    //   72: invokevirtual 316	com/facebook/systrace/SystraceMessage$Builder:arg	(Ljava/lang/String;I)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   75: invokevirtual 319	com/facebook/systrace/SystraceMessage$Builder:flush	()V
    //   78: aload_0
    //   79: aload 4
    //   81: invokespecial 217	com/facebook/react/uimanager/UIImplementation:notifyOnBeforeLayoutRecursive	(Lcom/facebook/react/uimanager/ReactShadowNode;)V
    //   84: lconst_0
    //   85: invokestatic 334	com/facebook/systrace/Systrace:endSection	(J)V
    //   88: aload_0
    //   89: aload 4
    //   91: invokevirtual 798	com/facebook/react/uimanager/UIImplementation:calculateRootLayout	(Lcom/facebook/react/uimanager/ReactShadowNode;)V
    //   94: lconst_0
    //   95: ldc_w 800
    //   98: invokestatic 308	com/facebook/systrace/SystraceMessage:beginSection	(JLjava/lang/String;)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   101: ldc_w 310
    //   104: aload 4
    //   106: invokeinterface 227 1 0
    //   111: invokevirtual 316	com/facebook/systrace/SystraceMessage$Builder:arg	(Ljava/lang/String;I)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   114: invokevirtual 319	com/facebook/systrace/SystraceMessage$Builder:flush	()V
    //   117: aload_0
    //   118: aload 4
    //   120: fconst_0
    //   121: fconst_0
    //   122: invokevirtual 267	com/facebook/react/uimanager/UIImplementation:applyUpdatesRecursive	(Lcom/facebook/react/uimanager/ReactShadowNode;FF)V
    //   125: lconst_0
    //   126: invokestatic 334	com/facebook/systrace/Systrace:endSection	(J)V
    //   129: aload_0
    //   130: getfield 619	com/facebook/react/uimanager/UIImplementation:mLayoutUpdateListener	Lcom/facebook/react/uimanager/UIImplementation$LayoutUpdateListener;
    //   133: ifnull +49 -> 182
    //   136: aload_0
    //   137: getfield 60	com/facebook/react/uimanager/UIImplementation:mOperationsQueue	Lcom/facebook/react/uimanager/UIViewOperationQueue;
    //   140: aload 4
    //   142: aload_0
    //   143: getfield 619	com/facebook/react/uimanager/UIImplementation:mLayoutUpdateListener	Lcom/facebook/react/uimanager/UIImplementation$LayoutUpdateListener;
    //   146: invokevirtual 804	com/facebook/react/uimanager/UIViewOperationQueue:enqueueLayoutUpdateFinished	(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/UIImplementation$LayoutUpdateListener;)V
    //   149: goto +33 -> 182
    //   152: astore 5
    //   154: lconst_0
    //   155: invokestatic 334	com/facebook/systrace/Systrace:endSection	(J)V
    //   158: aload 5
    //   160: athrow
    //   161: astore_2
    //   162: lconst_0
    //   163: invokestatic 334	com/facebook/systrace/Systrace:endSection	(J)V
    //   166: aload_2
    //   167: athrow
    //   168: astore 6
    //   170: lconst_0
    //   171: invokestatic 334	com/facebook/systrace/Systrace:endSection	(J)V
    //   174: aload 6
    //   176: athrow
    //   177: lconst_0
    //   178: invokestatic 334	com/facebook/systrace/Systrace:endSection	(J)V
    //   181: return
    //   182: iinc 1 1
    //   185: goto -176 -> 9
    //
    // Exception table:
    //   from	to	target	type
    //   78	84	152	finally
    //   9	78	161	finally
    //   84	117	161	finally
    //   125	149	161	finally
    //   154	161	161	finally
    //   170	177	161	finally
    //   117	125	168	finally
  }

  public void viewIsDescendantOf(int paramInt1, int paramInt2, Callback paramCallback)
  {
    ReactShadowNode localReactShadowNode1 = this.mShadowNodeRegistry.getNode(paramInt1);
    ReactShadowNode localReactShadowNode2 = this.mShadowNodeRegistry.getNode(paramInt2);
    if ((localReactShadowNode1 == null) || (localReactShadowNode2 == null))
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Boolean.valueOf(false);
      paramCallback.invoke(arrayOfObject1);
      return;
    }
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = Boolean.valueOf(localReactShadowNode1.isDescendantOf(localReactShadowNode2));
    paramCallback.invoke(arrayOfObject2);
  }

  public static abstract interface LayoutUpdateListener
  {
    public abstract void onLayoutUpdated(ReactShadowNode paramReactShadowNode);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.UIImplementation
 * JD-Core Version:    0.6.2
 */
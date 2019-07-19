package com.facebook.react.uimanager;

import android.os.SystemClock;
import com.facebook.common.logging.FLog;
import com.facebook.react.animation.Animation;
import com.facebook.react.animation.AnimationRegistry;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import com.facebook.react.uimanager.common.SizeMonitoringFrameLayout;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class UIViewOperationQueue
{
  public static final int DEFAULT_MIN_TIME_LEFT_IN_FRAME_FOR_NONBATCHED_OPERATION_MS = 8;
  private final AnimationRegistry mAnimationRegistry;
  private final Object mDispatchRunnablesLock = new Object();
  private final DispatchUIFrameCallback mDispatchUIFrameCallback;

  @GuardedBy("mDispatchRunnablesLock")
  private ArrayList<Runnable> mDispatchUIRunnables = new ArrayList();
  private boolean mIsDispatchUIFrameCallbackEnqueued = false;
  private boolean mIsInIllegalUIState = false;
  private boolean mIsProfilingNextBatch = false;
  private final int[] mMeasureBuffer = new int[4];
  private final NativeViewHierarchyManager mNativeViewHierarchyManager;
  private long mNonBatchedExecutionTotalTime;

  @GuardedBy("mNonBatchedOperationsLock")
  private ArrayDeque<UIOperation> mNonBatchedOperations = new ArrayDeque();
  private final Object mNonBatchedOperationsLock = new Object();
  private ArrayList<UIOperation> mOperations = new ArrayList();
  private long mProfiledBatchBatchedExecutionTime;
  private long mProfiledBatchCommitStartTime;
  private long mProfiledBatchDispatchViewUpdatesTime;
  private long mProfiledBatchLayoutTime;
  private long mProfiledBatchNonBatchedExecutionTime;
  private long mProfiledBatchRunStartTime;
  private final ReactApplicationContext mReactApplicationContext;
  private long mThreadCpuTime;

  @Nullable
  private NotThreadSafeViewHierarchyUpdateDebugListener mViewHierarchyUpdateDebugListener;

  public UIViewOperationQueue(ReactApplicationContext paramReactApplicationContext, NativeViewHierarchyManager paramNativeViewHierarchyManager, int paramInt)
  {
    this.mNativeViewHierarchyManager = paramNativeViewHierarchyManager;
    this.mAnimationRegistry = paramNativeViewHierarchyManager.getAnimationRegistry();
    if (paramInt == -1)
      paramInt = 8;
    this.mDispatchUIFrameCallback = new DispatchUIFrameCallback(paramReactApplicationContext, paramInt, null);
    this.mReactApplicationContext = paramReactApplicationContext;
  }

  private void flushPendingBatches()
  {
    if (this.mIsInIllegalUIState)
    {
      FLog.w("ReactNative", "Not flushing pending UI operations because of previously thrown Exception");
      return;
    }
    long l;
    synchronized (this.mDispatchRunnablesLock)
    {
      if (!this.mDispatchUIRunnables.isEmpty())
      {
        ArrayList localArrayList = this.mDispatchUIRunnables;
        this.mDispatchUIRunnables = new ArrayList();
        l = SystemClock.uptimeMillis();
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
          ((Runnable)localIterator.next()).run();
      }
      return;
    }
    if (this.mIsProfilingNextBatch)
    {
      this.mProfiledBatchBatchedExecutionTime = (SystemClock.uptimeMillis() - l);
      this.mProfiledBatchNonBatchedExecutionTime = this.mNonBatchedExecutionTotalTime;
      this.mIsProfilingNextBatch = false;
      Systrace.beginAsyncSection(0L, "batchedExecutionTime", 0, 1000000L * l);
      Systrace.endAsyncSection(0L, "batchedExecutionTime", 0);
    }
    this.mNonBatchedExecutionTotalTime = 0L;
  }

  public void addRootView(int paramInt, SizeMonitoringFrameLayout paramSizeMonitoringFrameLayout, ThemedReactContext paramThemedReactContext)
  {
    this.mNativeViewHierarchyManager.addRootView(paramInt, paramSizeMonitoringFrameLayout, paramThemedReactContext);
  }

  // ERROR //
  public void dispatchViewUpdates(final int paramInt, final long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: lconst_0
    //   1: ldc 208
    //   3: invokestatic 214	com/facebook/systrace/SystraceMessage:beginSection	(JLjava/lang/String;)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   6: ldc 216
    //   8: iload_1
    //   9: invokevirtual 222	com/facebook/systrace/SystraceMessage$Builder:arg	(Ljava/lang/String;I)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   12: invokevirtual 225	com/facebook/systrace/SystraceMessage$Builder:flush	()V
    //   15: invokestatic 164	android/os/SystemClock:uptimeMillis	()J
    //   18: lstore 7
    //   20: invokestatic 228	android/os/SystemClock:currentThreadTimeMillis	()J
    //   23: lstore 9
    //   25: aload_0
    //   26: getfield 62	com/facebook/react/uimanager/UIViewOperationQueue:mOperations	Ljava/util/ArrayList;
    //   29: invokevirtual 158	java/util/ArrayList:isEmpty	()Z
    //   32: ifne +165 -> 197
    //   35: aload_0
    //   36: getfield 62	com/facebook/react/uimanager/UIViewOperationQueue:mOperations	Ljava/util/ArrayList;
    //   39: astore 11
    //   41: aload_0
    //   42: new 59	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 60	java/util/ArrayList:<init>	()V
    //   49: putfield 62	com/facebook/react/uimanager/UIViewOperationQueue:mOperations	Ljava/util/ArrayList;
    //   52: aload_0
    //   53: getfield 57	com/facebook/react/uimanager/UIViewOperationQueue:mNonBatchedOperationsLock	Ljava/lang/Object;
    //   56: astore 12
    //   58: aload 12
    //   60: monitorenter
    //   61: aload_0
    //   62: getfield 69	com/facebook/react/uimanager/UIViewOperationQueue:mNonBatchedOperations	Ljava/util/ArrayDeque;
    //   65: invokevirtual 229	java/util/ArrayDeque:isEmpty	()Z
    //   68: ifne +135 -> 203
    //   71: aload_0
    //   72: getfield 69	com/facebook/react/uimanager/UIViewOperationQueue:mNonBatchedOperations	Ljava/util/ArrayDeque;
    //   75: astore 14
    //   77: aload_0
    //   78: new 66	java/util/ArrayDeque
    //   81: dup
    //   82: invokespecial 67	java/util/ArrayDeque:<init>	()V
    //   85: putfield 69	com/facebook/react/uimanager/UIViewOperationQueue:mNonBatchedOperations	Ljava/util/ArrayDeque;
    //   88: aload 12
    //   90: monitorexit
    //   91: aload_0
    //   92: getfield 126	com/facebook/react/uimanager/UIViewOperationQueue:mViewHierarchyUpdateDebugListener	Lcom/facebook/react/uimanager/debug/NotThreadSafeViewHierarchyUpdateDebugListener;
    //   95: ifnull +12 -> 107
    //   98: aload_0
    //   99: getfield 126	com/facebook/react/uimanager/UIViewOperationQueue:mViewHierarchyUpdateDebugListener	Lcom/facebook/react/uimanager/debug/NotThreadSafeViewHierarchyUpdateDebugListener;
    //   102: invokeinterface 234 1 0
    //   107: new 236	com/facebook/react/uimanager/UIViewOperationQueue$1
    //   110: dup
    //   111: aload_0
    //   112: iload_1
    //   113: aload 14
    //   115: aload 11
    //   117: lload_2
    //   118: lload 4
    //   120: lload 7
    //   122: lload 9
    //   124: invokespecial 239	com/facebook/react/uimanager/UIViewOperationQueue$1:<init>	(Lcom/facebook/react/uimanager/UIViewOperationQueue;ILjava/util/ArrayDeque;Ljava/util/ArrayList;JJJJ)V
    //   127: astore 15
    //   129: lconst_0
    //   130: ldc 241
    //   132: invokestatic 214	com/facebook/systrace/SystraceMessage:beginSection	(JLjava/lang/String;)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   135: ldc 216
    //   137: iload_1
    //   138: invokevirtual 222	com/facebook/systrace/SystraceMessage$Builder:arg	(Ljava/lang/String;I)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   141: invokevirtual 225	com/facebook/systrace/SystraceMessage$Builder:flush	()V
    //   144: aload_0
    //   145: getfield 55	com/facebook/react/uimanager/UIViewOperationQueue:mDispatchRunnablesLock	Ljava/lang/Object;
    //   148: astore 16
    //   150: aload 16
    //   152: monitorenter
    //   153: lconst_0
    //   154: invokestatic 245	com/facebook/systrace/Systrace:endSection	(J)V
    //   157: aload_0
    //   158: getfield 64	com/facebook/react/uimanager/UIViewOperationQueue:mDispatchUIRunnables	Ljava/util/ArrayList;
    //   161: aload 15
    //   163: invokevirtual 249	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   166: pop
    //   167: aload 16
    //   169: monitorexit
    //   170: aload_0
    //   171: getfield 71	com/facebook/react/uimanager/UIViewOperationQueue:mIsDispatchUIFrameCallbackEnqueued	Z
    //   174: ifne +18 -> 192
    //   177: new 251	com/facebook/react/uimanager/UIViewOperationQueue$2
    //   180: dup
    //   181: aload_0
    //   182: aload_0
    //   183: getfield 94	com/facebook/react/uimanager/UIViewOperationQueue:mReactApplicationContext	Lcom/facebook/react/bridge/ReactApplicationContext;
    //   186: invokespecial 254	com/facebook/react/uimanager/UIViewOperationQueue$2:<init>	(Lcom/facebook/react/uimanager/UIViewOperationQueue;Lcom/facebook/react/bridge/ReactContext;)V
    //   189: invokestatic 260	com/facebook/react/bridge/UiThreadUtil:runOnUiThread	(Ljava/lang/Runnable;)V
    //   192: lconst_0
    //   193: invokestatic 245	com/facebook/systrace/Systrace:endSection	(J)V
    //   196: return
    //   197: aconst_null
    //   198: astore 11
    //   200: goto -148 -> 52
    //   203: aconst_null
    //   204: astore 14
    //   206: goto -118 -> 88
    //   209: astore 13
    //   211: aload 12
    //   213: monitorexit
    //   214: aload 13
    //   216: athrow
    //   217: astore 6
    //   219: lconst_0
    //   220: invokestatic 245	com/facebook/systrace/Systrace:endSection	(J)V
    //   223: aload 6
    //   225: athrow
    //   226: astore 17
    //   228: aload 16
    //   230: monitorexit
    //   231: aload 17
    //   233: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   61	88	209	finally
    //   88	91	209	finally
    //   211	214	209	finally
    //   15	52	217	finally
    //   52	61	217	finally
    //   91	107	217	finally
    //   107	153	217	finally
    //   170	192	217	finally
    //   214	217	217	finally
    //   231	234	217	finally
    //   153	170	226	finally
    //   228	231	226	finally
  }

  public void enqueueAddAnimation(int paramInt1, int paramInt2, Callback paramCallback)
  {
    this.mOperations.add(new AddAnimationOperation(paramInt1, paramInt2, paramCallback, null));
  }

  public void enqueueClearJSResponder()
  {
    this.mOperations.add(new ChangeJSResponderOperation(0, 0, true, false));
  }

  public void enqueueConfigureLayoutAnimation(ReadableMap paramReadableMap, Callback paramCallback1, Callback paramCallback2)
  {
    this.mOperations.add(new ConfigureLayoutAnimationOperation(paramReadableMap, null));
  }

  public void enqueueCreateView(ThemedReactContext paramThemedReactContext, int paramInt, String paramString, @Nullable ReactStylesDiffMap paramReactStylesDiffMap)
  {
    synchronized (this.mNonBatchedOperationsLock)
    {
      this.mNonBatchedOperations.addLast(new CreateViewOperation(paramThemedReactContext, paramInt, paramString, paramReactStylesDiffMap));
      return;
    }
  }

  public void enqueueDismissPopupMenu()
  {
    this.mOperations.add(new DismissPopupMenuOperation(null));
  }

  public void enqueueDispatchCommand(int paramInt1, int paramInt2, @Nullable ReadableArray paramReadableArray)
  {
    this.mOperations.add(new DispatchCommandOperation(paramInt1, paramInt2, paramReadableArray));
  }

  public void enqueueFindTargetForTouch(int paramInt, float paramFloat1, float paramFloat2, Callback paramCallback)
  {
    this.mOperations.add(new FindTargetForTouchOperation(paramInt, paramFloat1, paramFloat2, paramCallback, null));
  }

  public void enqueueLayoutUpdateFinished(ReactShadowNode paramReactShadowNode, UIImplementation.LayoutUpdateListener paramLayoutUpdateListener)
  {
    this.mOperations.add(new LayoutUpdateFinishedOperation(paramReactShadowNode, paramLayoutUpdateListener, null));
  }

  public void enqueueManageChildren(int paramInt, @Nullable int[] paramArrayOfInt1, @Nullable ViewAtIndex[] paramArrayOfViewAtIndex, @Nullable int[] paramArrayOfInt2)
  {
    this.mOperations.add(new ManageChildrenOperation(paramInt, paramArrayOfInt1, paramArrayOfViewAtIndex, paramArrayOfInt2));
  }

  public void enqueueMeasure(int paramInt, Callback paramCallback)
  {
    this.mOperations.add(new MeasureOperation(paramInt, paramCallback, null));
  }

  public void enqueueMeasureInWindow(int paramInt, Callback paramCallback)
  {
    this.mOperations.add(new MeasureInWindowOperation(paramInt, paramCallback, null));
  }

  public void enqueueOnLayoutEvent(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mOperations.add(new EmitOnLayoutEventOperation(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5));
  }

  public void enqueueRegisterAnimation(Animation paramAnimation)
  {
    this.mOperations.add(new RegisterAnimationOperation(paramAnimation, null));
  }

  public void enqueueRemoveAnimation(int paramInt)
  {
    this.mOperations.add(new RemoveAnimationOperation(paramInt, null));
  }

  public void enqueueRemoveRootView(int paramInt)
  {
    this.mOperations.add(new RemoveRootViewOperation(paramInt));
  }

  public void enqueueSendAccessibilityEvent(int paramInt1, int paramInt2)
  {
    this.mOperations.add(new SendAccessibilityEvent(paramInt1, paramInt2, null));
  }

  public void enqueueSetChildren(int paramInt, ReadableArray paramReadableArray)
  {
    this.mOperations.add(new SetChildrenOperation(paramInt, paramReadableArray));
  }

  public void enqueueSetJSResponder(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mOperations.add(new ChangeJSResponderOperation(paramInt1, paramInt2, false, paramBoolean));
  }

  public void enqueueSetLayoutAnimationEnabled(boolean paramBoolean)
  {
    this.mOperations.add(new SetLayoutAnimationEnabledOperation(paramBoolean, null));
  }

  public void enqueueShowPopupMenu(int paramInt, ReadableArray paramReadableArray, Callback paramCallback1, Callback paramCallback2)
  {
    this.mOperations.add(new ShowPopupMenuOperation(paramInt, paramReadableArray, paramCallback1, paramCallback2));
  }

  public void enqueueUIBlock(UIBlock paramUIBlock)
  {
    this.mOperations.add(new UIBlockOperation(paramUIBlock));
  }

  protected void enqueueUIOperation(UIOperation paramUIOperation)
  {
    SoftAssertions.assertNotNull(paramUIOperation);
    this.mOperations.add(paramUIOperation);
  }

  public void enqueueUpdateExtraData(int paramInt, Object paramObject)
  {
    this.mOperations.add(new UpdateViewExtraData(paramInt, paramObject));
  }

  public void enqueueUpdateInstanceHandle(int paramInt, long paramLong)
  {
    this.mOperations.add(new UpdateInstanceHandleOperation(paramInt, paramLong, null));
  }

  public void enqueueUpdateLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mOperations.add(new UpdateLayoutOperation(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }

  public void enqueueUpdateProperties(int paramInt, String paramString, ReactStylesDiffMap paramReactStylesDiffMap)
  {
    this.mOperations.add(new UpdatePropertiesOperation(paramInt, paramReactStylesDiffMap, null));
  }

  NativeViewHierarchyManager getNativeViewHierarchyManager()
  {
    return this.mNativeViewHierarchyManager;
  }

  public Map<String, Long> getProfiledBatchPerfCounters()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("CommitStartTime", Long.valueOf(this.mProfiledBatchCommitStartTime));
    localHashMap.put("LayoutTime", Long.valueOf(this.mProfiledBatchLayoutTime));
    localHashMap.put("DispatchViewUpdatesTime", Long.valueOf(this.mProfiledBatchDispatchViewUpdatesTime));
    localHashMap.put("RunStartTime", Long.valueOf(this.mProfiledBatchRunStartTime));
    localHashMap.put("BatchedExecutionTime", Long.valueOf(this.mProfiledBatchBatchedExecutionTime));
    localHashMap.put("NonBatchedExecutionTime", Long.valueOf(this.mProfiledBatchNonBatchedExecutionTime));
    localHashMap.put("NativeModulesThreadCpuTime", Long.valueOf(this.mThreadCpuTime));
    return localHashMap;
  }

  public boolean isEmpty()
  {
    return this.mOperations.isEmpty();
  }

  void pauseFrameCallback()
  {
    this.mIsDispatchUIFrameCallbackEnqueued = false;
    ReactChoreographer.getInstance().removeFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
    flushPendingBatches();
  }

  public void prependUIBlock(UIBlock paramUIBlock)
  {
    this.mOperations.add(0, new UIBlockOperation(paramUIBlock));
  }

  public void profileNextBatch()
  {
    this.mIsProfilingNextBatch = true;
    this.mProfiledBatchCommitStartTime = 0L;
  }

  void resumeFrameCallback()
  {
    this.mIsDispatchUIFrameCallbackEnqueued = true;
    ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
  }

  public void setViewHierarchyUpdateDebugListener(@Nullable NotThreadSafeViewHierarchyUpdateDebugListener paramNotThreadSafeViewHierarchyUpdateDebugListener)
  {
    this.mViewHierarchyUpdateDebugListener = paramNotThreadSafeViewHierarchyUpdateDebugListener;
  }

  private class AddAnimationOperation extends UIViewOperationQueue.AnimationOperation
  {
    private final int mReactTag;
    private final Callback mSuccessCallback;

    private AddAnimationOperation(int paramInt1, int paramCallback, Callback arg4)
    {
      super();
      this.mReactTag = paramInt1;
      Object localObject;
      this.mSuccessCallback = localObject;
    }

    public void execute()
    {
      Animation localAnimation = UIViewOperationQueue.this.mAnimationRegistry.getAnimation(this.mAnimationID);
      if (localAnimation != null)
      {
        UIViewOperationQueue.this.mNativeViewHierarchyManager.startAnimationForNativeView(this.mReactTag, localAnimation, this.mSuccessCallback);
        return;
      }
      throw new IllegalViewOperationException("Animation with id " + this.mAnimationID + " was not found");
    }
  }

  private static abstract class AnimationOperation
    implements UIViewOperationQueue.UIOperation
  {
    protected final int mAnimationID;

    public AnimationOperation(int paramInt)
    {
      this.mAnimationID = paramInt;
    }
  }

  private final class ChangeJSResponderOperation extends UIViewOperationQueue.ViewOperation
  {
    private final boolean mBlockNativeResponder;
    private final boolean mClearResponder;
    private final int mInitialTag;

    public ChangeJSResponderOperation(int paramInt1, int paramBoolean1, boolean paramBoolean2, boolean arg5)
    {
      super(paramInt1);
      this.mInitialTag = paramBoolean1;
      this.mClearResponder = paramBoolean2;
      boolean bool;
      this.mBlockNativeResponder = bool;
    }

    public void execute()
    {
      if (!this.mClearResponder)
      {
        UIViewOperationQueue.this.mNativeViewHierarchyManager.setJSResponder(this.mTag, this.mInitialTag, this.mBlockNativeResponder);
        return;
      }
      UIViewOperationQueue.this.mNativeViewHierarchyManager.clearJSResponder();
    }
  }

  private class ConfigureLayoutAnimationOperation
    implements UIViewOperationQueue.UIOperation
  {
    private final ReadableMap mConfig;

    private ConfigureLayoutAnimationOperation(ReadableMap arg2)
    {
      Object localObject;
      this.mConfig = localObject;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.configureLayoutAnimation(this.mConfig);
    }
  }

  private final class CreateViewOperation extends UIViewOperationQueue.ViewOperation
  {
    private final String mClassName;

    @Nullable
    private final ReactStylesDiffMap mInitialProps;
    private final ThemedReactContext mThemedContext;

    public CreateViewOperation(ThemedReactContext paramInt, int paramString, String paramReactStylesDiffMap, @Nullable ReactStylesDiffMap arg5)
    {
      super(paramString);
      this.mThemedContext = paramInt;
      this.mClassName = paramReactStylesDiffMap;
      Object localObject;
      this.mInitialProps = localObject;
      Systrace.startAsyncFlow(0L, "createView", this.mTag);
    }

    public void execute()
    {
      Systrace.endAsyncFlow(0L, "createView", this.mTag);
      UIViewOperationQueue.this.mNativeViewHierarchyManager.createView(this.mThemedContext, this.mTag, this.mClassName, this.mInitialProps);
    }
  }

  private final class DismissPopupMenuOperation
    implements UIViewOperationQueue.UIOperation
  {
    private DismissPopupMenuOperation()
    {
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.dismissPopupMenu();
    }
  }

  private final class DispatchCommandOperation extends UIViewOperationQueue.ViewOperation
  {

    @Nullable
    private final ReadableArray mArgs;
    private final int mCommand;

    public DispatchCommandOperation(int paramInt1, int paramReadableArray, @Nullable ReadableArray arg4)
    {
      super(paramInt1);
      this.mCommand = paramReadableArray;
      Object localObject;
      this.mArgs = localObject;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.dispatchCommand(this.mTag, this.mCommand, this.mArgs);
    }
  }

  private class DispatchUIFrameCallback extends GuardedFrameCallback
  {
    private static final int FRAME_TIME_MS = 16;
    private final int mMinTimeLeftInFrameForNonBatchedOperationMs;

    private DispatchUIFrameCallback(ReactContext paramInt, int arg3)
    {
      super();
      int i;
      this.mMinTimeLeftInFrameForNonBatchedOperationMs = i;
    }

    private void dispatchPendingNonBatchedOperations(long paramLong)
    {
      while (true)
      {
        if (16L - (System.nanoTime() - paramLong) / 1000000L < this.mMinTimeLeftInFrameForNonBatchedOperationMs)
          return;
        synchronized (UIViewOperationQueue.this.mNonBatchedOperationsLock)
        {
          if (UIViewOperationQueue.this.mNonBatchedOperations.isEmpty())
            return;
        }
        UIViewOperationQueue.UIOperation localUIOperation = (UIViewOperationQueue.UIOperation)UIViewOperationQueue.this.mNonBatchedOperations.pollFirst();
        try
        {
          long l = SystemClock.uptimeMillis();
          localUIOperation.execute();
          UIViewOperationQueue.access$2902(UIViewOperationQueue.this, UIViewOperationQueue.this.mNonBatchedExecutionTotalTime + (SystemClock.uptimeMillis() - l));
        }
        catch (Exception localException)
        {
          UIViewOperationQueue.access$2502(UIViewOperationQueue.this, true);
          throw localException;
        }
      }
    }

    public void doFrameGuarded(long paramLong)
    {
      if (UIViewOperationQueue.this.mIsInIllegalUIState)
      {
        FLog.w("ReactNative", "Not flushing pending UI operations because of previously thrown Exception");
        return;
      }
      Systrace.beginSection(0L, "dispatchNonBatchedUIOperations");
      try
      {
        dispatchPendingNonBatchedOperations(paramLong);
        Systrace.endSection(0L);
        UIViewOperationQueue.this.flushPendingBatches();
        ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this);
        return;
      }
      finally
      {
        Systrace.endSection(0L);
      }
    }
  }

  private final class EmitOnLayoutEventOperation extends UIViewOperationQueue.ViewOperation
  {
    private final int mScreenHeight;
    private final int mScreenWidth;
    private final int mScreenX;
    private final int mScreenY;

    public EmitOnLayoutEventOperation(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int arg6)
    {
      super(paramInt1);
      this.mScreenX = paramInt2;
      this.mScreenY = paramInt3;
      this.mScreenWidth = paramInt4;
      int i;
      this.mScreenHeight = i;
    }

    public void execute()
    {
      ((UIManagerModule)UIViewOperationQueue.this.mReactApplicationContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(OnLayoutEvent.obtain(this.mTag, this.mScreenX, this.mScreenY, this.mScreenWidth, this.mScreenHeight));
    }
  }

  private final class FindTargetForTouchOperation
    implements UIViewOperationQueue.UIOperation
  {
    private final Callback mCallback;
    private final int mReactTag;
    private final float mTargetX;
    private final float mTargetY;

    private FindTargetForTouchOperation(int paramFloat1, float paramFloat2, float paramCallback, Callback arg5)
    {
      this.mReactTag = paramFloat1;
      this.mTargetX = paramFloat2;
      this.mTargetY = paramCallback;
      Object localObject;
      this.mCallback = localObject;
    }

    // ERROR //
    public void execute()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 19	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   4: invokestatic 42	com/facebook/react/uimanager/UIViewOperationQueue:access$000	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;
      //   7: aload_0
      //   8: getfield 24	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:mReactTag	I
      //   11: aload_0
      //   12: getfield 19	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   15: invokestatic 46	com/facebook/react/uimanager/UIViewOperationQueue:access$300	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I
      //   18: invokevirtual 52	com/facebook/react/uimanager/NativeViewHierarchyManager:measure	(I[I)V
      //   21: aload_0
      //   22: getfield 19	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   25: invokestatic 46	com/facebook/react/uimanager/UIViewOperationQueue:access$300	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I
      //   28: iconst_0
      //   29: iaload
      //   30: i2f
      //   31: fstore_2
      //   32: aload_0
      //   33: getfield 19	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   36: invokestatic 46	com/facebook/react/uimanager/UIViewOperationQueue:access$300	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I
      //   39: iconst_1
      //   40: iaload
      //   41: i2f
      //   42: fstore_3
      //   43: aload_0
      //   44: getfield 19	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   47: invokestatic 42	com/facebook/react/uimanager/UIViewOperationQueue:access$000	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;
      //   50: aload_0
      //   51: getfield 24	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:mReactTag	I
      //   54: aload_0
      //   55: getfield 26	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:mTargetX	F
      //   58: aload_0
      //   59: getfield 28	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:mTargetY	F
      //   62: invokevirtual 56	com/facebook/react/uimanager/NativeViewHierarchyManager:findTargetTagForTouch	(IFF)I
      //   65: istore 4
      //   67: aload_0
      //   68: getfield 19	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   71: invokestatic 42	com/facebook/react/uimanager/UIViewOperationQueue:access$000	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;
      //   74: iload 4
      //   76: aload_0
      //   77: getfield 19	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   80: invokestatic 46	com/facebook/react/uimanager/UIViewOperationQueue:access$300	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I
      //   83: invokevirtual 52	com/facebook/react/uimanager/NativeViewHierarchyManager:measure	(I[I)V
      //   86: aload_0
      //   87: getfield 19	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   90: invokestatic 46	com/facebook/react/uimanager/UIViewOperationQueue:access$300	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I
      //   93: iconst_0
      //   94: iaload
      //   95: i2f
      //   96: fload_2
      //   97: fsub
      //   98: invokestatic 62	com/facebook/react/uimanager/PixelUtil:toDIPFromPixel	(F)F
      //   101: fstore 6
      //   103: aload_0
      //   104: getfield 19	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   107: invokestatic 46	com/facebook/react/uimanager/UIViewOperationQueue:access$300	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I
      //   110: iconst_1
      //   111: iaload
      //   112: i2f
      //   113: fload_3
      //   114: fsub
      //   115: invokestatic 62	com/facebook/react/uimanager/PixelUtil:toDIPFromPixel	(F)F
      //   118: fstore 7
      //   120: aload_0
      //   121: getfield 19	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   124: invokestatic 46	com/facebook/react/uimanager/UIViewOperationQueue:access$300	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I
      //   127: iconst_2
      //   128: iaload
      //   129: i2f
      //   130: invokestatic 62	com/facebook/react/uimanager/PixelUtil:toDIPFromPixel	(F)F
      //   133: fstore 8
      //   135: aload_0
      //   136: getfield 19	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   139: invokestatic 46	com/facebook/react/uimanager/UIViewOperationQueue:access$300	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I
      //   142: iconst_3
      //   143: iaload
      //   144: i2f
      //   145: invokestatic 62	com/facebook/react/uimanager/PixelUtil:toDIPFromPixel	(F)F
      //   148: fstore 9
      //   150: aload_0
      //   151: getfield 30	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:mCallback	Lcom/facebook/react/bridge/Callback;
      //   154: astore 10
      //   156: iconst_5
      //   157: anewarray 4	java/lang/Object
      //   160: astore 11
      //   162: aload 11
      //   164: iconst_0
      //   165: iload 4
      //   167: invokestatic 68	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   170: aastore
      //   171: aload 11
      //   173: iconst_1
      //   174: fload 6
      //   176: invokestatic 73	java/lang/Float:valueOf	(F)Ljava/lang/Float;
      //   179: aastore
      //   180: aload 11
      //   182: iconst_2
      //   183: fload 7
      //   185: invokestatic 73	java/lang/Float:valueOf	(F)Ljava/lang/Float;
      //   188: aastore
      //   189: aload 11
      //   191: iconst_3
      //   192: fload 8
      //   194: invokestatic 73	java/lang/Float:valueOf	(F)Ljava/lang/Float;
      //   197: aastore
      //   198: aload 11
      //   200: iconst_4
      //   201: fload 9
      //   203: invokestatic 73	java/lang/Float:valueOf	(F)Ljava/lang/Float;
      //   206: aastore
      //   207: aload 10
      //   209: aload 11
      //   211: invokeinterface 79 2 0
      //   216: return
      //   217: astore_1
      //   218: aload_0
      //   219: getfield 30	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:mCallback	Lcom/facebook/react/bridge/Callback;
      //   222: iconst_0
      //   223: anewarray 4	java/lang/Object
      //   226: invokeinterface 79 2 0
      //   231: return
      //   232: astore 5
      //   234: aload_0
      //   235: getfield 30	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:mCallback	Lcom/facebook/react/bridge/Callback;
      //   238: iconst_0
      //   239: anewarray 4	java/lang/Object
      //   242: invokeinterface 79 2 0
      //   247: return
      //
      // Exception table:
      //   from	to	target	type
      //   0	21	217	com/facebook/react/uimanager/IllegalViewOperationException
      //   67	86	232	com/facebook/react/uimanager/IllegalViewOperationException
    }
  }

  private final class LayoutUpdateFinishedOperation
    implements UIViewOperationQueue.UIOperation
  {
    private final UIImplementation.LayoutUpdateListener mListener;
    private final ReactShadowNode mNode;

    private LayoutUpdateFinishedOperation(ReactShadowNode paramLayoutUpdateListener, UIImplementation.LayoutUpdateListener arg3)
    {
      this.mNode = paramLayoutUpdateListener;
      Object localObject;
      this.mListener = localObject;
    }

    public void execute()
    {
      this.mListener.onLayoutUpdated(this.mNode);
    }
  }

  private final class ManageChildrenOperation extends UIViewOperationQueue.ViewOperation
  {

    @Nullable
    private final int[] mIndicesToRemove;

    @Nullable
    private final int[] mTagsToDelete;

    @Nullable
    private final ViewAtIndex[] mViewsToAdd;

    public ManageChildrenOperation(int paramArrayOfInt1, @Nullable int[] paramArrayOfViewAtIndex, @Nullable ViewAtIndex[] paramArrayOfInt2, @Nullable int[] arg5)
    {
      super(paramArrayOfInt1);
      this.mIndicesToRemove = paramArrayOfViewAtIndex;
      this.mViewsToAdd = paramArrayOfInt2;
      Object localObject;
      this.mTagsToDelete = localObject;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.manageChildren(this.mTag, this.mIndicesToRemove, this.mViewsToAdd, this.mTagsToDelete);
    }
  }

  private final class MeasureInWindowOperation
    implements UIViewOperationQueue.UIOperation
  {
    private final Callback mCallback;
    private final int mReactTag;

    private MeasureInWindowOperation(int paramCallback, Callback arg3)
    {
      this.mReactTag = paramCallback;
      Object localObject;
      this.mCallback = localObject;
    }

    public void execute()
    {
      try
      {
        UIViewOperationQueue.this.mNativeViewHierarchyManager.measureInWindow(this.mReactTag, UIViewOperationQueue.this.mMeasureBuffer);
        float f1 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[0]);
        float f2 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[1]);
        float f3 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[2]);
        float f4 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[3]);
        Callback localCallback = this.mCallback;
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = Float.valueOf(f1);
        arrayOfObject[1] = Float.valueOf(f2);
        arrayOfObject[2] = Float.valueOf(f3);
        arrayOfObject[3] = Float.valueOf(f4);
        localCallback.invoke(arrayOfObject);
        return;
      }
      catch (NoSuchNativeViewException localNoSuchNativeViewException)
      {
        this.mCallback.invoke(new Object[0]);
      }
    }
  }

  private final class MeasureOperation
    implements UIViewOperationQueue.UIOperation
  {
    private final Callback mCallback;
    private final int mReactTag;

    private MeasureOperation(int paramCallback, Callback arg3)
    {
      this.mReactTag = paramCallback;
      Object localObject;
      this.mCallback = localObject;
    }

    public void execute()
    {
      try
      {
        UIViewOperationQueue.this.mNativeViewHierarchyManager.measure(this.mReactTag, UIViewOperationQueue.this.mMeasureBuffer);
        float f1 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[0]);
        float f2 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[1]);
        float f3 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[2]);
        float f4 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[3]);
        Callback localCallback = this.mCallback;
        Object[] arrayOfObject = new Object[6];
        arrayOfObject[0] = Integer.valueOf(0);
        arrayOfObject[1] = Integer.valueOf(0);
        arrayOfObject[2] = Float.valueOf(f3);
        arrayOfObject[3] = Float.valueOf(f4);
        arrayOfObject[4] = Float.valueOf(f1);
        arrayOfObject[5] = Float.valueOf(f2);
        localCallback.invoke(arrayOfObject);
        return;
      }
      catch (NoSuchNativeViewException localNoSuchNativeViewException)
      {
        this.mCallback.invoke(new Object[0]);
      }
    }
  }

  private class RegisterAnimationOperation extends UIViewOperationQueue.AnimationOperation
  {
    private final Animation mAnimation;

    private RegisterAnimationOperation(Animation arg2)
    {
      super();
      this.mAnimation = localObject;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mAnimationRegistry.registerAnimation(this.mAnimation);
    }
  }

  private final class RemoveAnimationOperation extends UIViewOperationQueue.AnimationOperation
  {
    private RemoveAnimationOperation(int arg2)
    {
      super();
    }

    public void execute()
    {
      Animation localAnimation = UIViewOperationQueue.this.mAnimationRegistry.getAnimation(this.mAnimationID);
      if (localAnimation != null)
        localAnimation.cancel();
    }
  }

  private final class RemoveRootViewOperation extends UIViewOperationQueue.ViewOperation
  {
    public RemoveRootViewOperation(int arg2)
    {
      super(i);
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.removeRootView(this.mTag);
    }
  }

  private final class SendAccessibilityEvent extends UIViewOperationQueue.ViewOperation
  {
    private final int mEventType;

    private SendAccessibilityEvent(int paramInt1, int arg3)
    {
      super(paramInt1);
      int i;
      this.mEventType = i;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.sendAccessibilityEvent(this.mTag, this.mEventType);
    }
  }

  private final class SetChildrenOperation extends UIViewOperationQueue.ViewOperation
  {
    private final ReadableArray mChildrenTags;

    public SetChildrenOperation(int paramReadableArray, ReadableArray arg3)
    {
      super(paramReadableArray);
      Object localObject;
      this.mChildrenTags = localObject;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.setChildren(this.mTag, this.mChildrenTags);
    }
  }

  private class SetLayoutAnimationEnabledOperation
    implements UIViewOperationQueue.UIOperation
  {
    private final boolean mEnabled;

    private SetLayoutAnimationEnabledOperation(boolean arg2)
    {
      boolean bool;
      this.mEnabled = bool;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.setLayoutAnimationEnabled(this.mEnabled);
    }
  }

  private final class ShowPopupMenuOperation extends UIViewOperationQueue.ViewOperation
  {
    private final Callback mError;
    private final ReadableArray mItems;
    private final Callback mSuccess;

    public ShowPopupMenuOperation(int paramReadableArray, ReadableArray paramCallback1, Callback paramCallback2, Callback arg5)
    {
      super(paramReadableArray);
      this.mItems = paramCallback1;
      this.mError = paramCallback2;
      Object localObject;
      this.mSuccess = localObject;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.showPopupMenu(this.mTag, this.mItems, this.mSuccess, this.mError);
    }
  }

  private class UIBlockOperation
    implements UIViewOperationQueue.UIOperation
  {
    private final UIBlock mBlock;

    public UIBlockOperation(UIBlock arg2)
    {
      Object localObject;
      this.mBlock = localObject;
    }

    public void execute()
    {
      this.mBlock.execute(UIViewOperationQueue.this.mNativeViewHierarchyManager);
    }
  }

  public static abstract interface UIOperation
  {
    public abstract void execute();
  }

  private final class UpdateInstanceHandleOperation extends UIViewOperationQueue.ViewOperation
  {
    private final long mInstanceHandle;

    private UpdateInstanceHandleOperation(int paramLong, long arg3)
    {
      super(paramLong);
      Object localObject;
      this.mInstanceHandle = localObject;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.updateInstanceHandle(this.mTag, this.mInstanceHandle);
    }
  }

  private final class UpdateLayoutOperation extends UIViewOperationQueue.ViewOperation
  {
    private final int mHeight;
    private final int mParentTag;
    private final int mWidth;
    private final int mX;
    private final int mY;

    public UpdateLayoutOperation(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int arg7)
    {
      super(paramInt2);
      this.mParentTag = paramInt1;
      this.mX = paramInt3;
      this.mY = paramInt4;
      this.mWidth = paramInt5;
      int i;
      this.mHeight = i;
      Systrace.startAsyncFlow(0L, "updateLayout", this.mTag);
    }

    public void execute()
    {
      Systrace.endAsyncFlow(0L, "updateLayout", this.mTag);
      UIViewOperationQueue.this.mNativeViewHierarchyManager.updateLayout(this.mParentTag, this.mTag, this.mX, this.mY, this.mWidth, this.mHeight);
    }
  }

  private final class UpdatePropertiesOperation extends UIViewOperationQueue.ViewOperation
  {
    private final ReactStylesDiffMap mProps;

    private UpdatePropertiesOperation(int paramReactStylesDiffMap, ReactStylesDiffMap arg3)
    {
      super(paramReactStylesDiffMap);
      Object localObject;
      this.mProps = localObject;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.updateProperties(this.mTag, this.mProps);
    }
  }

  private final class UpdateViewExtraData extends UIViewOperationQueue.ViewOperation
  {
    private final Object mExtraData;

    public UpdateViewExtraData(int paramObject, Object arg3)
    {
      super(paramObject);
      Object localObject;
      this.mExtraData = localObject;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.updateViewExtraData(this.mTag, this.mExtraData);
    }
  }

  private abstract class ViewOperation
    implements UIViewOperationQueue.UIOperation
  {
    public int mTag;

    public ViewOperation(int arg2)
    {
      int i;
      this.mTag = i;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.UIViewOperationQueue
 * JD-Core Version:    0.6.2
 */
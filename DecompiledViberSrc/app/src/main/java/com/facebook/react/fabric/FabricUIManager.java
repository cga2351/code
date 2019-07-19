package com.facebook.react.fabric;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.fabric.jsi.Binding;
import com.facebook.react.fabric.jsi.EventBeatManager;
import com.facebook.react.fabric.jsi.EventEmitterWrapper;
import com.facebook.react.fabric.jsi.FabricSoLoader;
import com.facebook.react.fabric.mounting.LayoutMetricsConversions;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.mountitems.BatchMountItem;
import com.facebook.react.fabric.mounting.mountitems.CreateMountItem;
import com.facebook.react.fabric.mounting.mountitems.DeleteMountItem;
import com.facebook.react.fabric.mounting.mountitems.DispatchCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.InsertMountItem;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.fabric.mounting.mountitems.PreAllocateViewMountItem;
import com.facebook.react.fabric.mounting.mountitems.RemoveMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateEventEmitterMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateLayoutMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateLocalDataMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdatePropsMountItem;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import com.facebook.react.uimanager.ReactRootViewTagGenerator;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.react.uimanager.common.MeasureSpecProvider;
import com.facebook.react.uimanager.common.SizeMonitoringFrameLayout;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressLint({"MissingNativeLoadLibrary"})
public class FabricUIManager
  implements LifecycleEventListener, UIManager
{
  private static final String TAG = FabricUIManager.class.getSimpleName();
  private static final Map<String, String> sComponentNames = new HashMap();
  private long mBatchedExecutionTime = 0L;
  private Binding mBinding;
  private long mCommitStartTime = 0L;

  @ThreadConfined("UI")
  private final DispatchUIFrameCallback mDispatchUIFrameCallback;
  private long mDispatchViewUpdatesTime = 0L;
  private final EventBeatManager mEventBeatManager;
  private final EventDispatcher mEventDispatcher;
  private long mFinishTransactionTime = 0L;

  @ThreadConfined("UI")
  private boolean mIsMountingEnabled = true;
  private long mLayoutTime = 0L;
  private List<MountItem> mMountItems = new ArrayList();
  private final Object mMountItemsLock = new Object();
  private final MountingManager mMountingManager;
  private long mNonBatchedExecutionTime = 0L;
  private List<MountItem> mPreMountItems = new ArrayList();
  private final Object mPreMountItemsLock = new Object();
  private final ReactApplicationContext mReactApplicationContext;
  private final ConcurrentHashMap<Integer, ThemedReactContext> mReactContextForRootTag = new ConcurrentHashMap();
  private long mRunStartTime = 0L;

  static
  {
    FabricSoLoader.staticInit();
    sComponentNames.put("View", "RCTView");
    sComponentNames.put("Image", "RCTImageView");
    sComponentNames.put("ScrollView", "RCTScrollView");
    sComponentNames.put("ReactPerformanceLoggerFlag", "ReactPerformanceLoggerFlag");
    sComponentNames.put("Paragraph", "RCTText");
    sComponentNames.put("Text", "RCText");
    sComponentNames.put("RawText", "RCTRawText");
    sComponentNames.put("ActivityIndicatorView", "AndroidProgressBar");
    sComponentNames.put("ShimmeringView", "RKShimmeringView");
    sComponentNames.put("TemplateView", "RCTTemplateView");
  }

  public FabricUIManager(ReactApplicationContext paramReactApplicationContext, ViewManagerRegistry paramViewManagerRegistry, EventDispatcher paramEventDispatcher, EventBeatManager paramEventBeatManager)
  {
    this.mDispatchUIFrameCallback = new DispatchUIFrameCallback(paramReactApplicationContext, null);
    this.mReactApplicationContext = paramReactApplicationContext;
    this.mMountingManager = new MountingManager(paramViewManagerRegistry);
    this.mEventDispatcher = paramEventDispatcher;
    this.mEventBeatManager = paramEventBeatManager;
    this.mReactApplicationContext.addLifecycleEventListener(this);
  }

  @DoNotStrip
  private MountItem createBatchMountItem(MountItem[] paramArrayOfMountItem, int paramInt)
  {
    return new BatchMountItem(paramArrayOfMountItem, paramInt);
  }

  @DoNotStrip
  private MountItem createMountItem(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str = (String)sComponentNames.get(paramString);
    if (str == null)
      throw new IllegalArgumentException("Unable to find component with name " + paramString);
    ThemedReactContext localThemedReactContext = (ThemedReactContext)this.mReactContextForRootTag.get(Integer.valueOf(paramInt1));
    if (localThemedReactContext == null)
      throw new IllegalArgumentException("Unable to find ReactContext for root: " + paramInt1);
    return new CreateMountItem(localThemedReactContext, str, paramInt2, paramBoolean);
  }

  @DoNotStrip
  private MountItem deleteMountItem(int paramInt)
  {
    return new DeleteMountItem(paramInt);
  }

  // ERROR //
  private void flushMountItems()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 136	com/facebook/react/fabric/FabricUIManager:mIsMountingEnabled	Z
    //   4: ifne +12 -> 16
    //   7: ldc 254
    //   9: ldc_w 256
    //   12: invokestatic 262	com/facebook/common/logging/FLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: return
    //   16: aload_0
    //   17: getfield 127	com/facebook/react/fabric/FabricUIManager:mPreMountItemsLock	Ljava/lang/Object;
    //   20: astore_2
    //   21: aload_2
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 134	com/facebook/react/fabric/FabricUIManager:mPreMountItems	Ljava/util/List;
    //   27: astore 4
    //   29: aload_0
    //   30: new 129	java/util/ArrayList
    //   33: dup
    //   34: invokespecial 130	java/util/ArrayList:<init>	()V
    //   37: putfield 134	com/facebook/react/fabric/FabricUIManager:mPreMountItems	Ljava/util/List;
    //   40: aload_2
    //   41: monitorexit
    //   42: aload_0
    //   43: invokestatic 268	android/os/SystemClock:uptimeMillis	()J
    //   46: putfield 138	com/facebook/react/fabric/FabricUIManager:mRunStartTime	J
    //   49: aload_0
    //   50: getfield 125	com/facebook/react/fabric/FabricUIManager:mMountItemsLock	Ljava/lang/Object;
    //   53: astore 5
    //   55: aload 5
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 132	com/facebook/react/fabric/FabricUIManager:mMountItems	Ljava/util/List;
    //   62: astore 7
    //   64: aload_0
    //   65: new 129	java/util/ArrayList
    //   68: dup
    //   69: invokespecial 130	java/util/ArrayList:<init>	()V
    //   72: putfield 132	com/facebook/react/fabric/FabricUIManager:mMountItems	Ljava/util/List;
    //   75: aload 5
    //   77: monitorexit
    //   78: invokestatic 268	android/os/SystemClock:uptimeMillis	()J
    //   81: lstore 8
    //   83: lconst_0
    //   84: new 211	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   91: ldc_w 270
    //   94: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload 4
    //   99: invokeinterface 276 1 0
    //   104: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: ldc_w 278
    //   110: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 284	com/facebook/systrace/Systrace:beginSection	(JLjava/lang/String;)V
    //   119: aload 4
    //   121: invokeinterface 288 1 0
    //   126: astore 10
    //   128: aload 10
    //   130: invokeinterface 294 1 0
    //   135: ifeq +55 -> 190
    //   138: aload 10
    //   140: invokeinterface 298 1 0
    //   145: checkcast 300	com/facebook/react/fabric/mounting/mountitems/MountItem
    //   148: aload_0
    //   149: getfield 166	com/facebook/react/fabric/FabricUIManager:mMountingManager	Lcom/facebook/react/fabric/mounting/MountingManager;
    //   152: invokeinterface 304 2 0
    //   157: goto -29 -> 128
    //   160: astore_1
    //   161: ldc 254
    //   163: ldc_w 306
    //   166: aload_1
    //   167: invokestatic 310	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   170: aload_0
    //   171: iconst_0
    //   172: putfield 136	com/facebook/react/fabric/FabricUIManager:mIsMountingEnabled	Z
    //   175: aload_1
    //   176: athrow
    //   177: astore_3
    //   178: aload_2
    //   179: monitorexit
    //   180: aload_3
    //   181: athrow
    //   182: astore 6
    //   184: aload 5
    //   186: monitorexit
    //   187: aload 6
    //   189: athrow
    //   190: aload_0
    //   191: invokestatic 268	android/os/SystemClock:uptimeMillis	()J
    //   194: lload 8
    //   196: lsub
    //   197: putfield 142	com/facebook/react/fabric/FabricUIManager:mNonBatchedExecutionTime	J
    //   200: lconst_0
    //   201: invokestatic 314	com/facebook/systrace/Systrace:endSection	(J)V
    //   204: lconst_0
    //   205: new 211	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 316
    //   215: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload 7
    //   220: invokeinterface 276 1 0
    //   225: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   228: ldc_w 278
    //   231: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 284	com/facebook/systrace/Systrace:beginSection	(JLjava/lang/String;)V
    //   240: invokestatic 268	android/os/SystemClock:uptimeMillis	()J
    //   243: lstore 11
    //   245: aload 7
    //   247: invokeinterface 288 1 0
    //   252: astore 13
    //   254: aload 13
    //   256: invokeinterface 294 1 0
    //   261: ifeq +25 -> 286
    //   264: aload 13
    //   266: invokeinterface 298 1 0
    //   271: checkcast 300	com/facebook/react/fabric/mounting/mountitems/MountItem
    //   274: aload_0
    //   275: getfield 166	com/facebook/react/fabric/FabricUIManager:mMountingManager	Lcom/facebook/react/fabric/mounting/MountingManager;
    //   278: invokeinterface 304 2 0
    //   283: goto -29 -> 254
    //   286: aload_0
    //   287: invokestatic 268	android/os/SystemClock:uptimeMillis	()J
    //   290: lload 11
    //   292: lsub
    //   293: putfield 140	com/facebook/react/fabric/FabricUIManager:mBatchedExecutionTime	J
    //   296: lconst_0
    //   297: invokestatic 314	com/facebook/systrace/Systrace:endSection	(J)V
    //   300: return
    //
    // Exception table:
    //   from	to	target	type
    //   16	23	160	java/lang/Exception
    //   42	58	160	java/lang/Exception
    //   78	128	160	java/lang/Exception
    //   128	157	160	java/lang/Exception
    //   180	182	160	java/lang/Exception
    //   187	190	160	java/lang/Exception
    //   190	254	160	java/lang/Exception
    //   254	283	160	java/lang/Exception
    //   286	300	160	java/lang/Exception
    //   23	42	177	finally
    //   178	180	177	finally
    //   58	78	182	finally
    //   184	187	182	finally
  }

  @DoNotStrip
  private MountItem insertMountItem(int paramInt1, int paramInt2, int paramInt3)
  {
    return new InsertMountItem(paramInt1, paramInt2, paramInt3);
  }

  @DoNotStrip
  private long measure(String paramString, ReadableNativeMap paramReadableNativeMap1, ReadableNativeMap paramReadableNativeMap2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.mMountingManager.measure(this.mReactApplicationContext, paramString, paramReadableNativeMap1, paramReadableNativeMap2, LayoutMetricsConversions.getYogaSize(paramInt1, paramInt2), LayoutMetricsConversions.getYogaMeasureMode(paramInt1, paramInt2), LayoutMetricsConversions.getYogaSize(paramInt3, paramInt4), LayoutMetricsConversions.getYogaMeasureMode(paramInt3, paramInt4));
  }

  @DoNotStrip
  private void preallocateView(int paramInt, String paramString)
  {
    if (UiThreadUtil.isOnUiThread())
      return;
    synchronized (this.mPreMountItemsLock)
    {
      ThemedReactContext localThemedReactContext = (ThemedReactContext)Assertions.assertNotNull(this.mReactContextForRootTag.get(Integer.valueOf(paramInt)));
      String str = (String)sComponentNames.get(paramString);
      Assertions.assertNotNull(str);
      this.mPreMountItems.add(new PreAllocateViewMountItem(localThemedReactContext, paramInt, str));
      return;
    }
  }

  @DoNotStrip
  private MountItem removeMountItem(int paramInt1, int paramInt2, int paramInt3)
  {
    return new RemoveMountItem(paramInt1, paramInt2, paramInt3);
  }

  @DoNotStrip
  private void scheduleMountItems(MountItem paramMountItem, long paramLong1, long paramLong2, long paramLong3)
  {
    this.mCommitStartTime = paramLong1;
    this.mLayoutTime = paramLong2;
    this.mFinishTransactionTime = (SystemClock.uptimeMillis() - paramLong3);
    this.mDispatchViewUpdatesTime = SystemClock.uptimeMillis();
    synchronized (this.mMountItemsLock)
    {
      this.mMountItems.add(paramMountItem);
      if (UiThreadUtil.isOnUiThread())
        flushMountItems();
      return;
    }
  }

  @DoNotStrip
  private MountItem updateEventEmitterMountItem(int paramInt, Object paramObject)
  {
    return new UpdateEventEmitterMountItem(paramInt, (EventEmitterWrapper)paramObject);
  }

  @DoNotStrip
  private MountItem updateLayoutMountItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return new UpdateLayoutMountItem(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }

  @DoNotStrip
  private MountItem updateLocalDataMountItem(int paramInt, ReadableNativeMap paramReadableNativeMap)
  {
    return new UpdateLocalDataMountItem(paramInt, paramReadableNativeMap);
  }

  @DoNotStrip
  private MountItem updatePropsMountItem(int paramInt, ReadableNativeMap paramReadableNativeMap)
  {
    return new UpdatePropsMountItem(paramInt, paramReadableNativeMap);
  }

  public <T extends SizeMonitoringFrameLayout,  extends MeasureSpecProvider> int addRootView(T paramT, WritableMap paramWritableMap, String paramString)
  {
    int i = ReactRootViewTagGenerator.getNextRootViewTag();
    ThemedReactContext localThemedReactContext = new ThemedReactContext(this.mReactApplicationContext, paramT.getContext());
    this.mMountingManager.addRootView(i, paramT);
    this.mReactContextForRootTag.put(Integer.valueOf(i), localThemedReactContext);
    this.mBinding.startSurface(i, (NativeMap)paramWritableMap);
    updateRootLayoutSpecs(i, ((MeasureSpecProvider)paramT).getWidthMeasureSpec(), ((MeasureSpecProvider)paramT).getHeightMeasureSpec());
    if (paramString != null)
      this.mBinding.renderTemplateToSurface(i, paramString);
    return i;
  }

  public void clearJSResponder()
  {
  }

  public void dispatchCommand(int paramInt1, int paramInt2, ReadableArray paramReadableArray)
  {
    synchronized (this.mMountItemsLock)
    {
      this.mMountItems.add(new DispatchCommandMountItem(paramInt1, paramInt2, paramReadableArray));
      return;
    }
  }

  public Map<String, Long> getPerformanceCounters()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("CommitStartTime", Long.valueOf(this.mCommitStartTime));
    localHashMap.put("LayoutTime", Long.valueOf(this.mLayoutTime));
    localHashMap.put("DispatchViewUpdatesTime", Long.valueOf(this.mDispatchViewUpdatesTime));
    localHashMap.put("RunStartTime", Long.valueOf(this.mRunStartTime));
    localHashMap.put("BatchedExecutionTime", Long.valueOf(this.mBatchedExecutionTime));
    localHashMap.put("NonBatchedExecutionTime", Long.valueOf(this.mNonBatchedExecutionTime));
    localHashMap.put("FinishFabricTransactionTime", Long.valueOf(this.mFinishTransactionTime));
    return localHashMap;
  }

  public void initialize()
  {
    this.mEventDispatcher.registerEventEmitter(2, new FabricEventEmitter(this));
    this.mEventDispatcher.addBatchEventDispatchedListener(this.mEventBeatManager);
  }

  public void onCatalystInstanceDestroy()
  {
    this.mEventDispatcher.removeBatchEventDispatchedListener(this.mEventBeatManager);
    this.mEventDispatcher.unregisterEventEmitter(2);
    this.mBinding.unregister();
    ViewManagerPropertyUpdater.clear();
  }

  public void onHostDestroy()
  {
  }

  public void onHostPause()
  {
    ReactChoreographer.getInstance().removeFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
  }

  public void onHostResume()
  {
    ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
  }

  @DoNotStrip
  public void onRequestEventBeat()
  {
    this.mEventDispatcher.dispatchAllEvents();
  }

  public void profileNextBatch()
  {
  }

  public void receiveEvent(int paramInt, String paramString, WritableMap paramWritableMap)
  {
    EventEmitterWrapper localEventEmitterWrapper = this.mMountingManager.getEventEmitter(paramInt);
    if (localEventEmitterWrapper == null)
    {
      FLog.d(TAG, "Unable to invoke event: " + paramString + " for reactTag: " + paramInt);
      return;
    }
    localEventEmitterWrapper.invoke(paramString, paramWritableMap);
  }

  public void removeRootView(int paramInt)
  {
    this.mMountingManager.removeRootView(paramInt);
    this.mReactContextForRootTag.remove(Integer.valueOf(paramInt));
  }

  public void setBinding(Binding paramBinding)
  {
    this.mBinding = paramBinding;
  }

  public void setJSResponder(int paramInt, boolean paramBoolean)
  {
  }

  public void updateRootLayoutSpecs(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    this.mReactApplicationContext.runOnJSQueueThread(new GuardedRunnable(this.mReactApplicationContext)
    {
      public void runGuarded()
      {
        FabricUIManager.this.mBinding.setConstraints(paramInt1, LayoutMetricsConversions.getMinSize(paramInt2), LayoutMetricsConversions.getMaxSize(paramInt2), LayoutMetricsConversions.getMinSize(paramInt3), LayoutMetricsConversions.getMaxSize(paramInt3));
      }
    });
  }

  private class DispatchUIFrameCallback extends GuardedFrameCallback
  {
    private DispatchUIFrameCallback(ReactContext arg2)
    {
      super();
    }

    public void doFrameGuarded(long paramLong)
    {
      if (!FabricUIManager.this.mIsMountingEnabled)
      {
        FLog.w("ReactNative", "Not flushing pending UI operations because of previously thrown Exception");
        return;
      }
      try
      {
        FabricUIManager.this.flushMountItems();
        return;
      }
      catch (Exception localException)
      {
        FLog.i("ReactNative", "Exception thrown when executing UIFrameGuarded", localException);
        FabricUIManager.access$202(FabricUIManager.this, false);
        throw localException;
      }
      finally
      {
        ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, FabricUIManager.this.mDispatchUIFrameCallback);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.FabricUIManager
 * JD-Core Version:    0.6.2
 */
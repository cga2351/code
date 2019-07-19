package com.facebook.react.animated;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import com.facebook.react.uimanager.GuardedFrameCallback;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerModuleListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.Nullable;

@ReactModule(name="NativeAnimatedModule")
public class NativeAnimatedModule extends ReactContextBaseJavaModule
  implements LifecycleEventListener, UIManagerModuleListener
{
  public static final String NAME = "NativeAnimatedModule";
  private final GuardedFrameCallback mAnimatedFrameCallback;

  @Nullable
  private NativeAnimatedNodesManager mNodesManager;
  private ArrayList<UIThreadOperation> mOperations = new ArrayList();
  private ArrayList<UIThreadOperation> mPreOperations = new ArrayList();
  private final ReactChoreographer mReactChoreographer = ReactChoreographer.getInstance();

  public NativeAnimatedModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
    this.mAnimatedFrameCallback = new GuardedFrameCallback(paramReactApplicationContext)
    {
      protected void doFrameGuarded(long paramAnonymousLong)
      {
        NativeAnimatedNodesManager localNativeAnimatedNodesManager = NativeAnimatedModule.this.getNodesManager();
        if (localNativeAnimatedNodesManager.hasActiveAnimations())
          localNativeAnimatedNodesManager.runUpdates(paramAnonymousLong);
        ((ReactChoreographer)Assertions.assertNotNull(NativeAnimatedModule.this.mReactChoreographer)).postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, NativeAnimatedModule.this.mAnimatedFrameCallback);
      }
    };
  }

  private void clearFrameCallback()
  {
    ((ReactChoreographer)Assertions.assertNotNull(this.mReactChoreographer)).removeFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mAnimatedFrameCallback);
  }

  private void enqueueFrameCallback()
  {
    ((ReactChoreographer)Assertions.assertNotNull(this.mReactChoreographer)).postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mAnimatedFrameCallback);
  }

  private NativeAnimatedNodesManager getNodesManager()
  {
    if (this.mNodesManager == null)
      this.mNodesManager = new NativeAnimatedNodesManager((UIManagerModule)getReactApplicationContext().getNativeModule(UIManagerModule.class));
    return this.mNodesManager;
  }

  @ReactMethod
  public void addAnimatedEventToView(final int paramInt, final String paramString, final ReadableMap paramReadableMap)
  {
    this.mOperations.add(new UIThreadOperation()
    {
      public void execute(NativeAnimatedNodesManager paramAnonymousNativeAnimatedNodesManager)
      {
        paramAnonymousNativeAnimatedNodesManager.addAnimatedEventToView(paramInt, paramString, paramReadableMap);
      }
    });
  }

  @ReactMethod
  public void connectAnimatedNodeToView(final int paramInt1, final int paramInt2)
  {
    this.mOperations.add(new UIThreadOperation()
    {
      public void execute(NativeAnimatedNodesManager paramAnonymousNativeAnimatedNodesManager)
      {
        paramAnonymousNativeAnimatedNodesManager.connectAnimatedNodeToView(paramInt1, paramInt2);
      }
    });
  }

  @ReactMethod
  public void connectAnimatedNodes(final int paramInt1, final int paramInt2)
  {
    this.mOperations.add(new UIThreadOperation()
    {
      public void execute(NativeAnimatedNodesManager paramAnonymousNativeAnimatedNodesManager)
      {
        paramAnonymousNativeAnimatedNodesManager.connectAnimatedNodes(paramInt1, paramInt2);
      }
    });
  }

  @ReactMethod
  public void createAnimatedNode(final int paramInt, final ReadableMap paramReadableMap)
  {
    this.mOperations.add(new UIThreadOperation()
    {
      public void execute(NativeAnimatedNodesManager paramAnonymousNativeAnimatedNodesManager)
      {
        paramAnonymousNativeAnimatedNodesManager.createAnimatedNode(paramInt, paramReadableMap);
      }
    });
  }

  @ReactMethod
  public void disconnectAnimatedNodeFromView(final int paramInt1, final int paramInt2)
  {
    this.mPreOperations.add(new UIThreadOperation()
    {
      public void execute(NativeAnimatedNodesManager paramAnonymousNativeAnimatedNodesManager)
      {
        paramAnonymousNativeAnimatedNodesManager.restoreDefaultValues(paramInt1, paramInt2);
      }
    });
    this.mOperations.add(new UIThreadOperation()
    {
      public void execute(NativeAnimatedNodesManager paramAnonymousNativeAnimatedNodesManager)
      {
        paramAnonymousNativeAnimatedNodesManager.disconnectAnimatedNodeFromView(paramInt1, paramInt2);
      }
    });
  }

  @ReactMethod
  public void disconnectAnimatedNodes(final int paramInt1, final int paramInt2)
  {
    this.mOperations.add(new UIThreadOperation()
    {
      public void execute(NativeAnimatedNodesManager paramAnonymousNativeAnimatedNodesManager)
      {
        paramAnonymousNativeAnimatedNodesManager.disconnectAnimatedNodes(paramInt1, paramInt2);
      }
    });
  }

  @ReactMethod
  public void dropAnimatedNode(final int paramInt)
  {
    this.mOperations.add(new UIThreadOperation()
    {
      public void execute(NativeAnimatedNodesManager paramAnonymousNativeAnimatedNodesManager)
      {
        paramAnonymousNativeAnimatedNodesManager.dropAnimatedNode(paramInt);
      }
    });
  }

  @ReactMethod
  public void extractAnimatedNodeOffset(final int paramInt)
  {
    this.mOperations.add(new UIThreadOperation()
    {
      public void execute(NativeAnimatedNodesManager paramAnonymousNativeAnimatedNodesManager)
      {
        paramAnonymousNativeAnimatedNodesManager.extractAnimatedNodeOffset(paramInt);
      }
    });
  }

  @ReactMethod
  public void flattenAnimatedNodeOffset(final int paramInt)
  {
    this.mOperations.add(new UIThreadOperation()
    {
      public void execute(NativeAnimatedNodesManager paramAnonymousNativeAnimatedNodesManager)
      {
        paramAnonymousNativeAnimatedNodesManager.flattenAnimatedNodeOffset(paramInt);
      }
    });
  }

  public String getName()
  {
    return "NativeAnimatedModule";
  }

  public void initialize()
  {
    ReactApplicationContext localReactApplicationContext = getReactApplicationContext();
    UIManagerModule localUIManagerModule = (UIManagerModule)localReactApplicationContext.getNativeModule(UIManagerModule.class);
    localReactApplicationContext.addLifecycleEventListener(this);
    localUIManagerModule.addUIManagerListener(this);
  }

  public void onHostDestroy()
  {
  }

  public void onHostPause()
  {
    clearFrameCallback();
  }

  public void onHostResume()
  {
    enqueueFrameCallback();
  }

  @ReactMethod
  public void removeAnimatedEventFromView(final int paramInt1, final String paramString, final int paramInt2)
  {
    this.mOperations.add(new UIThreadOperation()
    {
      public void execute(NativeAnimatedNodesManager paramAnonymousNativeAnimatedNodesManager)
      {
        paramAnonymousNativeAnimatedNodesManager.removeAnimatedEventFromView(paramInt1, paramString, paramInt2);
      }
    });
  }

  @ReactMethod
  public void setAnimatedNodeOffset(final int paramInt, final double paramDouble)
  {
    this.mOperations.add(new UIThreadOperation()
    {
      public void execute(NativeAnimatedNodesManager paramAnonymousNativeAnimatedNodesManager)
      {
        paramAnonymousNativeAnimatedNodesManager.setAnimatedNodeOffset(paramInt, paramDouble);
      }
    });
  }

  @ReactMethod
  public void setAnimatedNodeValue(final int paramInt, final double paramDouble)
  {
    this.mOperations.add(new UIThreadOperation()
    {
      public void execute(NativeAnimatedNodesManager paramAnonymousNativeAnimatedNodesManager)
      {
        paramAnonymousNativeAnimatedNodesManager.setAnimatedNodeValue(paramInt, paramDouble);
      }
    });
  }

  @VisibleForTesting
  public void setNodesManager(NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
  {
    this.mNodesManager = paramNativeAnimatedNodesManager;
  }

  @ReactMethod
  public void startAnimatingNode(final int paramInt1, final int paramInt2, final ReadableMap paramReadableMap, final Callback paramCallback)
  {
    this.mOperations.add(new UIThreadOperation()
    {
      public void execute(NativeAnimatedNodesManager paramAnonymousNativeAnimatedNodesManager)
      {
        paramAnonymousNativeAnimatedNodesManager.startAnimatingNode(paramInt1, paramInt2, paramReadableMap, paramCallback);
      }
    });
  }

  @ReactMethod
  public void startListeningToAnimatedNodeValue(final int paramInt)
  {
    final AnimatedNodeValueListener local5 = new AnimatedNodeValueListener()
    {
      public void onValueUpdate(double paramAnonymousDouble)
      {
        WritableMap localWritableMap = Arguments.createMap();
        localWritableMap.putInt("tag", paramInt);
        localWritableMap.putDouble("value", paramAnonymousDouble);
        ((DeviceEventManagerModule.RCTDeviceEventEmitter)NativeAnimatedModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onAnimatedValueUpdate", localWritableMap);
      }
    };
    this.mOperations.add(new UIThreadOperation()
    {
      public void execute(NativeAnimatedNodesManager paramAnonymousNativeAnimatedNodesManager)
      {
        paramAnonymousNativeAnimatedNodesManager.startListeningToAnimatedNodeValue(paramInt, local5);
      }
    });
  }

  @ReactMethod
  public void stopAnimation(final int paramInt)
  {
    this.mOperations.add(new UIThreadOperation()
    {
      public void execute(NativeAnimatedNodesManager paramAnonymousNativeAnimatedNodesManager)
      {
        paramAnonymousNativeAnimatedNodesManager.stopAnimation(paramInt);
      }
    });
  }

  @ReactMethod
  public void stopListeningToAnimatedNodeValue(final int paramInt)
  {
    this.mOperations.add(new UIThreadOperation()
    {
      public void execute(NativeAnimatedNodesManager paramAnonymousNativeAnimatedNodesManager)
      {
        paramAnonymousNativeAnimatedNodesManager.stopListeningToAnimatedNodeValue(paramInt);
      }
    });
  }

  public void willDispatchViewUpdates(UIManagerModule paramUIManagerModule)
  {
    if ((this.mOperations.isEmpty()) && (this.mPreOperations.isEmpty()))
      return;
    final ArrayList localArrayList1 = this.mPreOperations;
    final ArrayList localArrayList2 = this.mOperations;
    this.mPreOperations = new ArrayList();
    this.mOperations = new ArrayList();
    paramUIManagerModule.prependUIBlock(new UIBlock()
    {
      public void execute(NativeViewHierarchyManager paramAnonymousNativeViewHierarchyManager)
      {
        NativeAnimatedNodesManager localNativeAnimatedNodesManager = NativeAnimatedModule.this.getNodesManager();
        Iterator localIterator = localArrayList1.iterator();
        while (localIterator.hasNext())
          ((NativeAnimatedModule.UIThreadOperation)localIterator.next()).execute(localNativeAnimatedNodesManager);
      }
    });
    paramUIManagerModule.addUIBlock(new UIBlock()
    {
      public void execute(NativeViewHierarchyManager paramAnonymousNativeViewHierarchyManager)
      {
        NativeAnimatedNodesManager localNativeAnimatedNodesManager = NativeAnimatedModule.this.getNodesManager();
        Iterator localIterator = localArrayList2.iterator();
        while (localIterator.hasNext())
          ((NativeAnimatedModule.UIThreadOperation)localIterator.next()).execute(localNativeAnimatedNodesManager);
      }
    });
  }

  private static abstract interface UIThreadOperation
  {
    public abstract void execute(NativeAnimatedNodesManager paramNativeAnimatedNodesManager);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.NativeAnimatedModule
 * JD-Core Version:    0.6.2
 */
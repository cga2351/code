package com.facebook.react.fabric.jsi;

import android.annotation.SuppressLint;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.events.BatchEventDispatchedListener;

@SuppressLint({"MissingNativeLoadLibrary"})
public class EventBeatManager
  implements BatchEventDispatchedListener
{

  @DoNotStrip
  private final HybridData mHybridData;
  private final ReactApplicationContext mReactApplicationContext;

  static
  {
    FabricSoLoader.staticInit();
  }

  public EventBeatManager(JavaScriptContextHolder paramJavaScriptContextHolder, ReactApplicationContext paramReactApplicationContext)
  {
    this.mHybridData = initHybrid(paramJavaScriptContextHolder.get());
    this.mReactApplicationContext = paramReactApplicationContext;
  }

  private native void beat();

  private void dispatchEventsAsync()
  {
    if (this.mReactApplicationContext.isOnJSQueueThread())
    {
      beat();
      return;
    }
    this.mReactApplicationContext.runOnJSQueueThread(new Runnable()
    {
      public void run()
      {
        EventBeatManager.this.beat();
      }
    });
  }

  private static native HybridData initHybrid(long paramLong);

  public void onBatchEventDispatched()
  {
    dispatchEventsAsync();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.jsi.EventBeatManager
 * JD-Core Version:    0.6.2
 */
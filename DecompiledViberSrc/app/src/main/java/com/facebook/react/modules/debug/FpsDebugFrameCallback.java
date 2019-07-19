package com.facebook.react.modules.debug;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.core.ChoreographerCompat;
import com.facebook.react.modules.core.ChoreographerCompat.FrameCallback;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.annotation.Nullable;

public class FpsDebugFrameCallback extends ChoreographerCompat.FrameCallback
{
  private static final double EXPECTED_FRAME_TIME = 16.899999999999999D;
  private int m4PlusFrameStutters = 0;

  @Nullable
  private ChoreographerCompat mChoreographer;
  private final DidJSUpdateUiDuringFrameDetector mDidJSUpdateUiDuringFrameDetector;
  private int mExpectedNumFramesPrev = 0;
  private long mFirstFrameTime = -1L;
  private boolean mIsRecordingFpsInfoAtEachFrame = false;
  private long mLastFrameTime = -1L;
  private int mNumFrameCallbacks = 0;
  private int mNumFrameCallbacksWithBatchDispatches = 0;
  private final ReactContext mReactContext;
  private boolean mShouldStop = false;

  @Nullable
  private TreeMap<Long, FpsInfo> mTimeToFps;
  private final UIManagerModule mUIManagerModule;

  public FpsDebugFrameCallback(ReactContext paramReactContext)
  {
    this.mReactContext = paramReactContext;
    this.mUIManagerModule = ((UIManagerModule)paramReactContext.getNativeModule(UIManagerModule.class));
    this.mDidJSUpdateUiDuringFrameDetector = new DidJSUpdateUiDuringFrameDetector();
  }

  public void doFrame(long paramLong)
  {
    if (this.mShouldStop);
    do
    {
      return;
      if (this.mFirstFrameTime == -1L)
        this.mFirstFrameTime = paramLong;
      long l = this.mLastFrameTime;
      this.mLastFrameTime = paramLong;
      if (this.mDidJSUpdateUiDuringFrameDetector.getDidJSHitFrameAndCleanup(l, paramLong))
        this.mNumFrameCallbacksWithBatchDispatches = (1 + this.mNumFrameCallbacksWithBatchDispatches);
      this.mNumFrameCallbacks = (1 + this.mNumFrameCallbacks);
      int i = getExpectedNumFrames();
      if (-1 + (i - this.mExpectedNumFramesPrev) >= 4)
        this.m4PlusFrameStutters = (1 + this.m4PlusFrameStutters);
      if (this.mIsRecordingFpsInfoAtEachFrame)
      {
        Assertions.assertNotNull(this.mTimeToFps);
        FpsInfo localFpsInfo = new FpsInfo(getNumFrames(), getNumJSFrames(), i, this.m4PlusFrameStutters, getFPS(), getJSFPS(), getTotalTimeMS());
        this.mTimeToFps.put(Long.valueOf(System.currentTimeMillis()), localFpsInfo);
      }
      this.mExpectedNumFramesPrev = i;
    }
    while (this.mChoreographer == null);
    this.mChoreographer.postFrameCallback(this);
  }

  public int get4PlusFrameStutters()
  {
    return this.m4PlusFrameStutters;
  }

  public int getExpectedNumFrames()
  {
    return (int)(1.0D + getTotalTimeMS() / 16.899999999999999D);
  }

  public double getFPS()
  {
    if (this.mLastFrameTime == this.mFirstFrameTime)
      return 0.0D;
    return 1000000000.0D * getNumFrames() / (this.mLastFrameTime - this.mFirstFrameTime);
  }

  @Nullable
  public FpsInfo getFpsInfo(long paramLong)
  {
    Assertions.assertNotNull(this.mTimeToFps, "FPS was not recorded at each frame!");
    Map.Entry localEntry = this.mTimeToFps.floorEntry(Long.valueOf(paramLong));
    if (localEntry == null)
      return null;
    return (FpsInfo)localEntry.getValue();
  }

  public double getJSFPS()
  {
    if (this.mLastFrameTime == this.mFirstFrameTime)
      return 0.0D;
    return 1000000000.0D * getNumJSFrames() / (this.mLastFrameTime - this.mFirstFrameTime);
  }

  public int getNumFrames()
  {
    return -1 + this.mNumFrameCallbacks;
  }

  public int getNumJSFrames()
  {
    return -1 + this.mNumFrameCallbacksWithBatchDispatches;
  }

  public int getTotalTimeMS()
  {
    return (int)(this.mLastFrameTime - this.mFirstFrameTime) / 1000000;
  }

  public void reset()
  {
    this.mFirstFrameTime = -1L;
    this.mLastFrameTime = -1L;
    this.mNumFrameCallbacks = 0;
    this.m4PlusFrameStutters = 0;
    this.mNumFrameCallbacksWithBatchDispatches = 0;
    this.mIsRecordingFpsInfoAtEachFrame = false;
    this.mTimeToFps = null;
  }

  public void start()
  {
    this.mShouldStop = false;
    this.mReactContext.getCatalystInstance().addBridgeIdleDebugListener(this.mDidJSUpdateUiDuringFrameDetector);
    this.mUIManagerModule.setViewHierarchyUpdateDebugListener(this.mDidJSUpdateUiDuringFrameDetector);
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        FpsDebugFrameCallback.access$002(FpsDebugFrameCallback.this, ChoreographerCompat.getInstance());
        FpsDebugFrameCallback.this.mChoreographer.postFrameCallback(jdField_this);
      }
    });
  }

  public void startAndRecordFpsAtEachFrame()
  {
    this.mTimeToFps = new TreeMap();
    this.mIsRecordingFpsInfoAtEachFrame = true;
    start();
  }

  public void stop()
  {
    this.mShouldStop = true;
    this.mReactContext.getCatalystInstance().removeBridgeIdleDebugListener(this.mDidJSUpdateUiDuringFrameDetector);
    this.mUIManagerModule.setViewHierarchyUpdateDebugListener(null);
  }

  public static class FpsInfo
  {
    public final double fps;
    public final double jsFps;
    public final int total4PlusFrameStutters;
    public final int totalExpectedFrames;
    public final int totalFrames;
    public final int totalJsFrames;
    public final int totalTimeMs;

    public FpsInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble1, double paramDouble2, int paramInt5)
    {
      this.totalFrames = paramInt1;
      this.totalJsFrames = paramInt2;
      this.totalExpectedFrames = paramInt3;
      this.total4PlusFrameStutters = paramInt4;
      this.fps = paramDouble1;
      this.jsFps = paramDouble2;
      this.totalTimeMs = paramInt5;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.debug.FpsDebugFrameCallback
 * JD-Core Version:    0.6.2
 */
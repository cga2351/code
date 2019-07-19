package com.facebook.react.modules.core;

import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.ArrayDeque;
import javax.annotation.Nullable;

public class ReactChoreographer
{
  private static ReactChoreographer sInstance;
  private final ArrayDeque<ChoreographerCompat.FrameCallback>[] mCallbackQueues = new ArrayDeque[CallbackType.values().length];

  @Nullable
  private volatile ChoreographerCompat mChoreographer;
  private boolean mHasPostedCallback = false;
  private final ReactChoreographerDispatcher mReactChoreographerDispatcher = new ReactChoreographerDispatcher(null);
  private int mTotalCallbacks = 0;

  private ReactChoreographer()
  {
    while (i < this.mCallbackQueues.length)
    {
      this.mCallbackQueues[i] = new ArrayDeque();
      i++;
    }
    initializeChoreographer(null);
  }

  public static ReactChoreographer getInstance()
  {
    Assertions.assertNotNull(sInstance, "ReactChoreographer needs to be initialized.");
    return sInstance;
  }

  public static void initialize()
  {
    if (sInstance == null)
      sInstance = new ReactChoreographer();
  }

  private void maybeRemoveFrameCallback()
  {
    if (this.mTotalCallbacks >= 0);
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool);
      if ((this.mTotalCallbacks == 0) && (this.mHasPostedCallback))
      {
        if (this.mChoreographer != null)
          this.mChoreographer.removeFrameCallback(this.mReactChoreographerDispatcher);
        this.mHasPostedCallback = false;
      }
      return;
    }
  }

  public void initializeChoreographer(@Nullable final Runnable paramRunnable)
  {
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        try
        {
          if (ReactChoreographer.this.mChoreographer == null)
            ReactChoreographer.access$102(ReactChoreographer.this, ChoreographerCompat.getInstance());
          if (paramRunnable != null)
            paramRunnable.run();
          return;
        }
        finally
        {
        }
      }
    });
  }

  public void postFrameCallback(CallbackType paramCallbackType, ChoreographerCompat.FrameCallback paramFrameCallback)
  {
    try
    {
      this.mCallbackQueues[paramCallbackType.getOrder()].addLast(paramFrameCallback);
      this.mTotalCallbacks = (1 + this.mTotalCallbacks);
      boolean bool;
      if (this.mTotalCallbacks > 0)
      {
        bool = true;
        Assertions.assertCondition(bool);
        if (!this.mHasPostedCallback)
        {
          if (this.mChoreographer != null)
            break label75;
          initializeChoreographer(new Runnable()
          {
            public void run()
            {
              ReactChoreographer.this.postFrameCallbackOnChoreographer();
            }
          });
        }
      }
      while (true)
      {
        return;
        bool = false;
        break;
        label75: postFrameCallbackOnChoreographer();
      }
    }
    finally
    {
    }
  }

  public void postFrameCallbackOnChoreographer()
  {
    this.mChoreographer.postFrameCallback(this.mReactChoreographerDispatcher);
    this.mHasPostedCallback = true;
  }

  public void removeFrameCallback(CallbackType paramCallbackType, ChoreographerCompat.FrameCallback paramFrameCallback)
  {
    try
    {
      if (this.mCallbackQueues[paramCallbackType.getOrder()].removeFirstOccurrence(paramFrameCallback))
      {
        this.mTotalCallbacks = (-1 + this.mTotalCallbacks);
        maybeRemoveFrameCallback();
      }
      while (true)
      {
        return;
        FLog.e("ReactNative", "Tried to remove non-existent frame callback");
      }
    }
    finally
    {
    }
  }

  public static enum CallbackType
  {
    private final int mOrder;

    static
    {
      DISPATCH_UI = new CallbackType("DISPATCH_UI", 1, 1);
      NATIVE_ANIMATED_MODULE = new CallbackType("NATIVE_ANIMATED_MODULE", 2, 2);
      TIMERS_EVENTS = new CallbackType("TIMERS_EVENTS", 3, 3);
      IDLE_EVENT = new CallbackType("IDLE_EVENT", 4, 4);
      CallbackType[] arrayOfCallbackType = new CallbackType[5];
      arrayOfCallbackType[0] = PERF_MARKERS;
      arrayOfCallbackType[1] = DISPATCH_UI;
      arrayOfCallbackType[2] = NATIVE_ANIMATED_MODULE;
      arrayOfCallbackType[3] = TIMERS_EVENTS;
      arrayOfCallbackType[4] = IDLE_EVENT;
    }

    private CallbackType(int paramInt)
    {
      this.mOrder = paramInt;
    }

    int getOrder()
    {
      return this.mOrder;
    }
  }

  private class ReactChoreographerDispatcher extends ChoreographerCompat.FrameCallback
  {
    private ReactChoreographerDispatcher()
    {
    }

    public void doFrame(long paramLong)
    {
      while (true)
      {
        int i;
        synchronized (ReactChoreographer.this)
        {
          ReactChoreographer.access$202(ReactChoreographer.this, false);
          i = 0;
          if (i < ReactChoreographer.this.mCallbackQueues.length)
          {
            int j = ReactChoreographer.this.mCallbackQueues[i].size();
            int k = 0;
            if (k < j)
            {
              ((ChoreographerCompat.FrameCallback)ReactChoreographer.this.mCallbackQueues[i].removeFirst()).doFrame(paramLong);
              ReactChoreographer.access$410(ReactChoreographer.this);
              k++;
              continue;
            }
          }
          else
          {
            ReactChoreographer.this.maybeRemoveFrameCallback();
            return;
          }
        }
        i++;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.core.ReactChoreographer
 * JD-Core Version:    0.6.2
 */
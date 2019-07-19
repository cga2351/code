package com.facebook.react.modules.core;

import android.os.Handler;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.facebook.react.bridge.UiThreadUtil;

public class ChoreographerCompat
{
  private static final long ONE_FRAME_MILLIS = 17L;
  private static ChoreographerCompat sInstance;
  private Choreographer mChoreographer = getChoreographer();
  private Handler mHandler;

  private void choreographerPostFrameCallback(Choreographer.FrameCallback paramFrameCallback)
  {
    this.mChoreographer.postFrameCallback(paramFrameCallback);
  }

  private void choreographerPostFrameCallbackDelayed(Choreographer.FrameCallback paramFrameCallback, long paramLong)
  {
    this.mChoreographer.postFrameCallbackDelayed(paramFrameCallback, paramLong);
  }

  private void choreographerRemoveFrameCallback(Choreographer.FrameCallback paramFrameCallback)
  {
    this.mChoreographer.removeFrameCallback(paramFrameCallback);
  }

  private Choreographer getChoreographer()
  {
    return Choreographer.getInstance();
  }

  public static ChoreographerCompat getInstance()
  {
    UiThreadUtil.assertOnUiThread();
    if (sInstance == null)
      sInstance = new ChoreographerCompat();
    return sInstance;
  }

  public void postFrameCallback(FrameCallback paramFrameCallback)
  {
    choreographerPostFrameCallback(paramFrameCallback.getFrameCallback());
  }

  public void postFrameCallbackDelayed(FrameCallback paramFrameCallback, long paramLong)
  {
    choreographerPostFrameCallbackDelayed(paramFrameCallback.getFrameCallback(), paramLong);
  }

  public void removeFrameCallback(FrameCallback paramFrameCallback)
  {
    choreographerRemoveFrameCallback(paramFrameCallback.getFrameCallback());
  }

  public static abstract class FrameCallback
  {
    private Choreographer.FrameCallback mFrameCallback;
    private Runnable mRunnable;

    public abstract void doFrame(long paramLong);

    Choreographer.FrameCallback getFrameCallback()
    {
      if (this.mFrameCallback == null)
        this.mFrameCallback = new Choreographer.FrameCallback()
        {
          public void doFrame(long paramAnonymousLong)
          {
            ChoreographerCompat.FrameCallback.this.doFrame(paramAnonymousLong);
          }
        };
      return this.mFrameCallback;
    }

    Runnable getRunnable()
    {
      if (this.mRunnable == null)
        this.mRunnable = new Runnable()
        {
          public void run()
          {
            ChoreographerCompat.FrameCallback.this.doFrame(System.nanoTime());
          }
        };
      return this.mRunnable;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.core.ChoreographerCompat
 * JD-Core Version:    0.6.2
 */
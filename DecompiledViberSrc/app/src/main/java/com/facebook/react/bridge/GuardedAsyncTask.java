package com.facebook.react.bridge;

import android.os.AsyncTask;

public abstract class GuardedAsyncTask<Params, Progress> extends AsyncTask<Params, Progress, Void>
{
  private final ReactContext mReactContext;

  protected GuardedAsyncTask(ReactContext paramReactContext)
  {
    this.mReactContext = paramReactContext;
  }

  protected final Void doInBackground(Params[] paramArrayOfParams)
  {
    try
    {
      doInBackgroundGuarded(paramArrayOfParams);
      return null;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (true)
        this.mReactContext.handleException(localRuntimeException);
    }
  }

  protected abstract void doInBackgroundGuarded(Params[] paramArrayOfParams);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.GuardedAsyncTask
 * JD-Core Version:    0.6.2
 */
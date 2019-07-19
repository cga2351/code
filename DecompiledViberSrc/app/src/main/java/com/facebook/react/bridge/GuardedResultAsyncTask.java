package com.facebook.react.bridge;

import android.os.AsyncTask;

public abstract class GuardedResultAsyncTask<Result> extends AsyncTask<Void, Void, Result>
{
  private final ReactContext mReactContext;

  protected GuardedResultAsyncTask(ReactContext paramReactContext)
  {
    this.mReactContext = paramReactContext;
  }

  protected final Result doInBackground(Void[] paramArrayOfVoid)
  {
    try
    {
      Object localObject = doInBackgroundGuarded();
      return localObject;
    }
    catch (RuntimeException localRuntimeException)
    {
      this.mReactContext.handleException(localRuntimeException);
      throw localRuntimeException;
    }
  }

  protected abstract Result doInBackgroundGuarded();

  protected final void onPostExecute(Result paramResult)
  {
    try
    {
      onPostExecuteGuarded(paramResult);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      this.mReactContext.handleException(localRuntimeException);
    }
  }

  protected abstract void onPostExecuteGuarded(Result paramResult);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.GuardedResultAsyncTask
 * JD-Core Version:    0.6.2
 */
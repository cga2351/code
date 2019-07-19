package com.vk.sdk.api.httpClient;

import com.vk.sdk.api.VKError;
import java.util.concurrent.ExecutorService;

public abstract class VKAbstractOperation
{
  private boolean mCanceled = false;
  private VKOperationCompleteListener mCompleteListener;
  private ExecutorService mResponseQueue;
  private VKOperationState mState = VKOperationState.Created;

  public VKAbstractOperation()
  {
    setState(VKOperationState.Ready);
  }

  private boolean isStateTransitionInvalid(VKOperationState paramVKOperationState1, VKOperationState paramVKOperationState2, boolean paramBoolean)
  {
    boolean bool = true;
    switch (2.$SwitchMap$com$vk$sdk$api$httpClient$VKAbstractOperation$VKOperationState[paramVKOperationState1.ordinal()])
    {
    default:
      bool = false;
    case 3:
    case 4:
    case 5:
    case 2:
    case 1:
    }
    do
    {
      do
      {
        return bool;
        switch (2.$SwitchMap$com$vk$sdk$api$httpClient$VKAbstractOperation$VKOperationState[paramVKOperationState2.ordinal()])
        {
        default:
          return bool;
        case 1:
        case 2:
        case 3:
          return false;
        case 4:
        }
      }
      while (!paramBoolean);
      return false;
      switch (2.$SwitchMap$com$vk$sdk$api$httpClient$VKAbstractOperation$VKOperationState[paramVKOperationState2.ordinal()])
      {
      case 2:
      default:
        return bool;
      case 1:
      case 3:
      case 4:
      }
      return false;
      switch (2.$SwitchMap$com$vk$sdk$api$httpClient$VKAbstractOperation$VKOperationState[paramVKOperationState2.ordinal()])
      {
      default:
      case 3:
      }
    }
    while (paramVKOperationState2 != VKOperationState.Ready);
    return false;
    return false;
  }

  public void cancel()
  {
    this.mCanceled = true;
    setState(VKOperationState.Canceled);
  }

  public void finish()
  {
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        if (VKAbstractOperation.this.mCompleteListener != null)
          VKAbstractOperation.this.mCompleteListener.onComplete();
      }
    };
    if (this.mResponseQueue != null)
    {
      this.mResponseQueue.submit(local1);
      return;
    }
    local1.run();
  }

  public abstract Object getResultObject();

  protected void setCompleteListener(VKOperationCompleteListener paramVKOperationCompleteListener)
  {
    this.mCompleteListener = paramVKOperationCompleteListener;
  }

  protected void setState(VKOperationState paramVKOperationState)
  {
    if (isStateTransitionInvalid(this.mState, paramVKOperationState, this.mCanceled));
    do
    {
      return;
      this.mState = paramVKOperationState;
    }
    while ((this.mState != VKOperationState.Finished) && (this.mState != VKOperationState.Canceled));
    finish();
  }

  public void start(ExecutorService paramExecutorService)
  {
    this.mResponseQueue = paramExecutorService;
  }

  protected VKOperationState state()
  {
    return this.mState;
  }

  public static abstract class VKAbstractCompleteListener<OperationType extends VKAbstractOperation, ResponseType>
  {
    public abstract void onComplete(OperationType paramOperationType, ResponseType paramResponseType);

    public abstract void onError(OperationType paramOperationType, VKError paramVKError);
  }

  public static abstract interface VKOperationCompleteListener
  {
    public abstract void onComplete();
  }

  public static enum VKOperationState
  {
    static
    {
      Executing = new VKOperationState("Executing", 2);
      Paused = new VKOperationState("Paused", 3);
      Finished = new VKOperationState("Finished", 4);
      Canceled = new VKOperationState("Canceled", 5);
      VKOperationState[] arrayOfVKOperationState = new VKOperationState[6];
      arrayOfVKOperationState[0] = Created;
      arrayOfVKOperationState[1] = Ready;
      arrayOfVKOperationState[2] = Executing;
      arrayOfVKOperationState[3] = Paused;
      arrayOfVKOperationState[4] = Finished;
      arrayOfVKOperationState[5] = Canceled;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.httpClient.VKAbstractOperation
 * JD-Core Version:    0.6.2
 */
package com.vk.sdk.api;

import android.os.Handler;
import android.os.Looper;
import com.vk.sdk.VKObject;
import com.vk.sdk.api.httpClient.VKHttpClient;

public class VKBatchRequest extends VKObject
{
  private boolean mCanceled = false;
  private final VKRequest.VKRequestListener[] mOriginalListeners;
  private final VKRequest[] mRequests;
  private final VKResponse[] mResponses;
  public VKBatchRequestListener requestListener;

  public VKBatchRequest(VKRequest[] paramArrayOfVKRequest)
  {
    this.mRequests = paramArrayOfVKRequest;
    this.mResponses = new VKResponse[this.mRequests.length];
    this.mOriginalListeners = new VKRequest.VKRequestListener[this.mRequests.length];
    while (i < this.mRequests.length)
    {
      this.mOriginalListeners[i] = this.mRequests[i].requestListener;
      i++;
    }
  }

  private int indexOfRequest(VKRequest paramVKRequest)
  {
    for (int i = 0; i < this.mRequests.length; i++)
      if (this.mRequests[i].equals(paramVKRequest))
        return i;
    return -1;
  }

  public void cancel()
  {
    if (this.mCanceled);
    while (true)
    {
      return;
      this.mCanceled = true;
      VKRequest[] arrayOfVKRequest = this.mRequests;
      int i = arrayOfVKRequest.length;
      for (int j = 0; j < i; j++)
        arrayOfVKRequest[j].cancel();
    }
  }

  public void executeWithListener(VKBatchRequestListener paramVKBatchRequestListener)
  {
    int i = 0;
    if (this.mRequests == null)
      provideError(new VKError(-103));
    while (true)
    {
      return;
      this.requestListener = paramVKBatchRequestListener;
      Handler localHandler = new Handler(Looper.myLooper());
      VKRequest[] arrayOfVKRequest = this.mRequests;
      int j = arrayOfVKRequest.length;
      int k = 0;
      while (i < j)
      {
        localHandler.postDelayed(new Runnable()
        {
          public void run()
          {
            final VKRequest.VKRequestListener localVKRequestListener = this.val$request.requestListener;
            this.val$request.setRequestListener(new VKRequest.VKRequestListener()
            {
              public void onComplete(VKResponse paramAnonymous2VKResponse)
              {
                VKBatchRequest.this.provideResponse(paramAnonymous2VKResponse);
              }

              public void onError(VKError paramAnonymous2VKError)
              {
                VKBatchRequest.this.provideError(paramAnonymous2VKError);
              }

              public void onProgress(VKRequest.VKProgressType paramAnonymous2VKProgressType, long paramAnonymous2Long1, long paramAnonymous2Long2)
              {
                if (localVKRequestListener != null)
                  localVKRequestListener.onProgress(paramAnonymous2VKProgressType, paramAnonymous2Long1, paramAnonymous2Long2);
              }
            });
            VKHttpClient.enqueueOperation(this.val$request.getOperation());
          }
        }
        , k);
        k += 333;
        i++;
      }
    }
  }

  protected void provideError(VKError paramVKError)
  {
    if (this.mCanceled)
      return;
    for (int i = 0; i < this.mRequests.length; i++)
    {
      VKRequest.VKRequestListener localVKRequestListener = this.mOriginalListeners[i];
      if (localVKRequestListener != null)
        localVKRequestListener.onError(paramVKError);
    }
    if (this.requestListener != null)
      this.requestListener.onError(paramVKError);
    cancel();
  }

  protected void provideResponse(VKResponse paramVKResponse)
  {
    this.mResponses[indexOfRequest(paramVKResponse.request)] = paramVKResponse;
    VKResponse[] arrayOfVKResponse = this.mResponses;
    int i = arrayOfVKResponse.length;
    int j = 0;
    int k = 0;
    if (j < i)
      if (arrayOfVKResponse[j] != null);
    do
    {
      return;
      j++;
      break;
      while (k < this.mRequests.length)
      {
        VKRequest.VKRequestListener localVKRequestListener = this.mOriginalListeners[k];
        if (localVKRequestListener != null)
          localVKRequestListener.onComplete(this.mResponses[k]);
        k++;
      }
    }
    while (this.requestListener == null);
    this.requestListener.onComplete(this.mResponses);
  }

  public static abstract class VKBatchRequestListener
  {
    public void onComplete(VKResponse[] paramArrayOfVKResponse)
    {
    }

    public void onError(VKError paramVKError)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.VKBatchRequest
 * JD-Core Version:    0.6.2
 */
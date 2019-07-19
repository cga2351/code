package com.vk.sdk.api;

import com.vk.sdk.api.httpClient.VKAbstractOperation;
import com.vk.sdk.api.httpClient.VKAbstractOperation.VKOperationState;
import com.vk.sdk.api.httpClient.VKHttpClient;
import com.vk.sdk.api.httpClient.VKJsonOperation;
import com.vk.sdk.api.httpClient.VKJsonOperation.VKJSONOperationCompleteListener;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class VKUploadBase extends VKRequest
{
  public VKUploadBase()
  {
    super(null);
  }

  public VKAbstractOperation getOperation()
  {
    return new VKUploadOperation(null);
  }

  protected abstract VKRequest getSaveRequest(JSONObject paramJSONObject);

  protected abstract VKRequest getServerRequest();

  protected abstract VKJsonOperation getUploadOperation(String paramString);

  private class VKUploadOperation extends VKAbstractOperation
  {
    protected VKAbstractOperation lastOperation;

    private VKUploadOperation()
    {
    }

    public void cancel()
    {
      if (this.lastOperation != null)
        this.lastOperation.cancel();
      super.cancel();
    }

    public void finish()
    {
      super.finish();
      this.lastOperation = null;
    }

    public Object getResultObject()
    {
      return null;
    }

    public void start(ExecutorService paramExecutorService)
    {
      super.start(paramExecutorService);
      final VKRequest.VKRequestListener localVKRequestListener = VKUploadBase.this.requestListener;
      VKUploadBase.this.requestListener = new VKRequest.VKRequestListener()
      {
        public void onComplete(VKResponse paramAnonymousVKResponse)
        {
          VKUploadBase.VKUploadOperation.this.setState(VKAbstractOperation.VKOperationState.Finished);
          paramAnonymousVKResponse.request = VKUploadBase.this;
          if (localVKRequestListener != null)
            localVKRequestListener.onComplete(paramAnonymousVKResponse);
        }

        public void onError(VKError paramAnonymousVKError)
        {
          VKUploadBase.VKUploadOperation.this.setState(VKAbstractOperation.VKOperationState.Finished);
          paramAnonymousVKError.request = VKUploadBase.this;
          if (localVKRequestListener != null)
            localVKRequestListener.onError(paramAnonymousVKError);
        }

        public void onProgress(VKRequest.VKProgressType paramAnonymousVKProgressType, long paramAnonymousLong1, long paramAnonymousLong2)
        {
          if (localVKRequestListener != null)
            localVKRequestListener.onProgress(paramAnonymousVKProgressType, paramAnonymousLong1, paramAnonymousLong2);
        }
      };
      setState(VKAbstractOperation.VKOperationState.Executing);
      VKRequest localVKRequest = VKUploadBase.this.getServerRequest();
      localVKRequest.setRequestListener(new VKUploadRequestListener(null));
      this.lastOperation = localVKRequest.getOperation();
      VKHttpClient.enqueueOperation(this.lastOperation);
    }

    private class VKUploadRequestListener extends VKRequest.VKRequestListener
    {
      private VKUploadRequestListener()
      {
      }

      public void onComplete(VKResponse paramVKResponse)
      {
        try
        {
          String str = paramVKResponse.json.getJSONObject("response").getString("upload_url");
          VKJsonOperation localVKJsonOperation = VKUploadBase.this.getUploadOperation(str);
          localVKJsonOperation.setHttpOperationListener(new VKJsonOperation.VKJSONOperationCompleteListener()
          {
            public void onComplete(VKJsonOperation paramAnonymousVKJsonOperation, JSONObject paramAnonymousJSONObject)
            {
              VKRequest localVKRequest = VKUploadBase.this.getSaveRequest(paramAnonymousJSONObject);
              localVKRequest.setRequestListener(new VKRequest.VKRequestListener()
              {
                public void onComplete(VKResponse paramAnonymous2VKResponse)
                {
                  if (VKUploadBase.this.requestListener != null)
                    VKUploadBase.this.requestListener.onComplete(paramAnonymous2VKResponse);
                  VKUploadBase.VKUploadOperation.this.setState(VKAbstractOperation.VKOperationState.Finished);
                }

                public void onError(VKError paramAnonymous2VKError)
                {
                  if (VKUploadBase.this.requestListener != null)
                    VKUploadBase.this.requestListener.onError(paramAnonymous2VKError);
                }
              });
              VKUploadBase.VKUploadOperation.this.lastOperation = localVKRequest.getOperation();
              VKHttpClient.enqueueOperation(VKUploadBase.VKUploadOperation.this.lastOperation);
            }

            public void onError(VKJsonOperation paramAnonymousVKJsonOperation, VKError paramAnonymousVKError)
            {
              if (VKUploadBase.this.requestListener != null)
                VKUploadBase.this.requestListener.onError(paramAnonymousVKError);
            }
          });
          VKUploadBase.VKUploadOperation.this.lastOperation = localVKJsonOperation;
          VKHttpClient.enqueueOperation(VKUploadBase.VKUploadOperation.this.lastOperation);
          return;
        }
        catch (JSONException localJSONException)
        {
          VKError localVKError;
          do
          {
            localVKError = new VKError(-104);
            localVKError.httpError = localJSONException;
            localVKError.errorMessage = localJSONException.getMessage();
          }
          while (VKUploadBase.this.requestListener == null);
          VKUploadBase.this.requestListener.onError(localVKError);
        }
      }

      public void onError(VKError paramVKError)
      {
        if (VKUploadBase.this.requestListener != null)
          VKUploadBase.this.requestListener.onError(paramVKError);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.VKUploadBase
 * JD-Core Version:    0.6.2
 */
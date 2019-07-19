package com.vk.sdk.api.httpClient;

import com.vk.sdk.api.VKError;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;

public class VKHttpOperation<ResponseType> extends VKAbstractOperation
{
  protected Exception mLastException;
  private String mResponseString;
  private final VKHttpClient.VKHTTPRequest mUriRequest;
  public VKHttpClient.VKHttpResponse response;

  public VKHttpOperation(VKHttpClient.VKHTTPRequest paramVKHTTPRequest)
  {
    this.mUriRequest = paramVKHTTPRequest;
  }

  public void cancel()
  {
    VKHttpClient.cancelHttpOperation(this);
    super.cancel();
  }

  public void finish()
  {
    postExecution();
    super.finish();
  }

  protected VKError generateError(Exception paramException)
  {
    if (state() == VKAbstractOperation.VKOperationState.Canceled);
    for (VKError localVKError = new VKError(-102); ; localVKError = new VKError(-105))
    {
      if (paramException != null)
      {
        localVKError.errorMessage = paramException.getMessage();
        if (localVKError.errorMessage == null)
          localVKError.errorMessage = paramException.toString();
        localVKError.httpError = paramException;
      }
      return localVKError;
    }
  }

  public byte[] getResponseData()
  {
    if (this.response != null)
      return this.response.responseBytes;
    return null;
  }

  public String getResponseString()
  {
    if ((this.response == null) || (this.response.responseBytes == null))
      return null;
    if (this.mResponseString == null);
    try
    {
      this.mResponseString = new String(this.response.responseBytes, "UTF-8");
      return this.mResponseString;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        this.mLastException = localUnsupportedEncodingException;
    }
  }

  public ResponseType getResultObject()
  {
    if (this.response != null)
      return this.response.responseBytes;
    return null;
  }

  public VKHttpClient.VKHTTPRequest getUriRequest()
  {
    return this.mUriRequest;
  }

  protected boolean postExecution()
  {
    return true;
  }

  public <OperationType extends VKHttpOperation> void setHttpOperationListener(final VKAbstractOperation.VKAbstractCompleteListener<OperationType, ResponseType> paramVKAbstractCompleteListener)
  {
    setCompleteListener(new VKAbstractOperation.VKOperationCompleteListener()
    {
      public void onComplete()
      {
        if ((VKHttpOperation.this.state() != VKAbstractOperation.VKOperationState.Finished) || (VKHttpOperation.this.mLastException != null))
        {
          paramVKAbstractCompleteListener.onError(VKHttpOperation.this, VKHttpOperation.this.generateError(VKHttpOperation.this.mLastException));
          return;
        }
        paramVKAbstractCompleteListener.onComplete(VKHttpOperation.this, VKHttpOperation.this.getResultObject());
      }
    });
  }

  public void start(ExecutorService paramExecutorService)
  {
    super.start(paramExecutorService);
    setState(VKAbstractOperation.VKOperationState.Executing);
    try
    {
      if (this.mUriRequest.isAborted)
        return;
      this.response = VKHttpClient.execute(this.mUriRequest);
      setState(VKAbstractOperation.VKOperationState.Finished);
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        this.mLastException = localIOException;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.httpClient.VKHttpOperation
 * JD-Core Version:    0.6.2
 */
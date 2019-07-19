package com.facebook.imagepipeline.listener;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public class ForwardingRequestListener
  implements RequestListener
{
  private static final String TAG = "ForwardingRequestListener";
  private final List<RequestListener> mRequestListeners;

  public ForwardingRequestListener(Set<RequestListener> paramSet)
  {
    this.mRequestListeners = new ArrayList(paramSet.size());
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      RequestListener localRequestListener = (RequestListener)localIterator.next();
      if (localRequestListener != null)
        this.mRequestListeners.add(localRequestListener);
    }
  }

  public ForwardingRequestListener(RequestListener[] paramArrayOfRequestListener)
  {
    this.mRequestListeners = new ArrayList(paramArrayOfRequestListener.length);
    int i = paramArrayOfRequestListener.length;
    for (int j = 0; j < i; j++)
    {
      RequestListener localRequestListener = paramArrayOfRequestListener[j];
      if (localRequestListener != null)
        this.mRequestListeners.add(localRequestListener);
    }
  }

  private void onException(String paramString, Throwable paramThrowable)
  {
    FLog.e("ForwardingRequestListener", paramString, paramThrowable);
  }

  public void addRequestListener(RequestListener paramRequestListener)
  {
    this.mRequestListeners.add(paramRequestListener);
  }

  public void onProducerEvent(String paramString1, String paramString2, String paramString3)
  {
    int i = this.mRequestListeners.size();
    int j = 0;
    while (true)
      if (j < i)
      {
        RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(j);
        try
        {
          localRequestListener.onProducerEvent(paramString1, paramString2, paramString3);
          j++;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onIntermediateChunkStart", localException);
        }
      }
  }

  public void onProducerFinishWithCancellation(String paramString1, String paramString2, @Nullable Map<String, String> paramMap)
  {
    int i = this.mRequestListeners.size();
    int j = 0;
    while (true)
      if (j < i)
      {
        RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(j);
        try
        {
          localRequestListener.onProducerFinishWithCancellation(paramString1, paramString2, paramMap);
          j++;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onProducerFinishWithCancellation", localException);
        }
      }
  }

  public void onProducerFinishWithFailure(String paramString1, String paramString2, Throwable paramThrowable, @Nullable Map<String, String> paramMap)
  {
    int i = this.mRequestListeners.size();
    int j = 0;
    while (true)
      if (j < i)
      {
        RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(j);
        try
        {
          localRequestListener.onProducerFinishWithFailure(paramString1, paramString2, paramThrowable, paramMap);
          j++;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onProducerFinishWithFailure", localException);
        }
      }
  }

  public void onProducerFinishWithSuccess(String paramString1, String paramString2, @Nullable Map<String, String> paramMap)
  {
    int i = this.mRequestListeners.size();
    int j = 0;
    while (true)
      if (j < i)
      {
        RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(j);
        try
        {
          localRequestListener.onProducerFinishWithSuccess(paramString1, paramString2, paramMap);
          j++;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onProducerFinishWithSuccess", localException);
        }
      }
  }

  public void onProducerStart(String paramString1, String paramString2)
  {
    int i = this.mRequestListeners.size();
    int j = 0;
    while (true)
      if (j < i)
      {
        RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(j);
        try
        {
          localRequestListener.onProducerStart(paramString1, paramString2);
          j++;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onProducerStart", localException);
        }
      }
  }

  public void onRequestCancellation(String paramString)
  {
    int i = this.mRequestListeners.size();
    int j = 0;
    while (true)
      if (j < i)
      {
        RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(j);
        try
        {
          localRequestListener.onRequestCancellation(paramString);
          j++;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onRequestCancellation", localException);
        }
      }
  }

  public void onRequestFailure(ImageRequest paramImageRequest, String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    int i = this.mRequestListeners.size();
    int j = 0;
    while (true)
      if (j < i)
      {
        RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(j);
        try
        {
          localRequestListener.onRequestFailure(paramImageRequest, paramString, paramThrowable, paramBoolean);
          j++;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onRequestFailure", localException);
        }
      }
  }

  public void onRequestStart(ImageRequest paramImageRequest, Object paramObject, String paramString, boolean paramBoolean)
  {
    int i = this.mRequestListeners.size();
    int j = 0;
    while (true)
      if (j < i)
      {
        RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(j);
        try
        {
          localRequestListener.onRequestStart(paramImageRequest, paramObject, paramString, paramBoolean);
          j++;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onRequestStart", localException);
        }
      }
  }

  public void onRequestSuccess(ImageRequest paramImageRequest, String paramString, boolean paramBoolean)
  {
    int i = this.mRequestListeners.size();
    int j = 0;
    while (true)
      if (j < i)
      {
        RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(j);
        try
        {
          localRequestListener.onRequestSuccess(paramImageRequest, paramString, paramBoolean);
          j++;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onRequestSuccess", localException);
        }
      }
  }

  public void onUltimateProducerReached(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = this.mRequestListeners.size();
    int j = 0;
    while (true)
      if (j < i)
      {
        RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(j);
        try
        {
          localRequestListener.onUltimateProducerReached(paramString1, paramString2, paramBoolean);
          j++;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onProducerFinishWithSuccess", localException);
        }
      }
  }

  public boolean requiresExtraMap(String paramString)
  {
    int i = this.mRequestListeners.size();
    for (int j = 0; j < i; j++)
      if (((RequestListener)this.mRequestListeners.get(j)).requiresExtraMap(paramString))
        return true;
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.listener.ForwardingRequestListener
 * JD-Core Version:    0.6.2
 */
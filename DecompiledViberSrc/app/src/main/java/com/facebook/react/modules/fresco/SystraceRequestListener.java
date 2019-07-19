package com.facebook.react.modules.fresco;

import android.net.Uri;
import android.util.Pair;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.Systrace.EventScope;
import java.util.HashMap;
import java.util.Map;

public class SystraceRequestListener extends BaseRequestListener
{
  int mCurrentID = 0;
  Map<String, Pair<Integer, String>> mProducerID = new HashMap();
  Map<String, Pair<Integer, String>> mRequestsID = new HashMap();

  public void onProducerEvent(String paramString1, String paramString2, String paramString3)
  {
    if (!Systrace.isTracing(0L))
      return;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FRESCO_PRODUCER_EVENT_");
    localStringBuilder.append(paramString1.replace(':', '_'));
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2.replace(':', '_'));
    localStringBuilder.append("_");
    localStringBuilder.append(paramString3.replace(':', '_'));
    Systrace.traceInstant(0L, localStringBuilder.toString(), Systrace.EventScope.THREAD);
  }

  public void onProducerFinishWithCancellation(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    if (!Systrace.isTracing(0L));
    while (!this.mProducerID.containsKey(paramString1))
      return;
    Pair localPair = (Pair)this.mProducerID.get(paramString1);
    Systrace.endAsyncSection(0L, (String)localPair.second, ((Integer)localPair.first).intValue());
    this.mProducerID.remove(paramString1);
  }

  public void onProducerFinishWithFailure(String paramString1, String paramString2, Throwable paramThrowable, Map<String, String> paramMap)
  {
    if (!Systrace.isTracing(0L));
    while (!this.mProducerID.containsKey(paramString1))
      return;
    Pair localPair = (Pair)this.mProducerID.get(paramString1);
    Systrace.endAsyncSection(0L, (String)localPair.second, ((Integer)localPair.first).intValue());
    this.mProducerID.remove(paramString1);
  }

  public void onProducerFinishWithSuccess(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    if (!Systrace.isTracing(0L));
    while (!this.mProducerID.containsKey(paramString1))
      return;
    Pair localPair = (Pair)this.mProducerID.get(paramString1);
    Systrace.endAsyncSection(0L, (String)localPair.second, ((Integer)localPair.first).intValue());
    this.mProducerID.remove(paramString1);
  }

  public void onProducerStart(String paramString1, String paramString2)
  {
    if (!Systrace.isTracing(0L))
      return;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FRESCO_PRODUCER_");
    localStringBuilder.append(paramString2.replace(':', '_'));
    Pair localPair = Pair.create(Integer.valueOf(this.mCurrentID), localStringBuilder.toString());
    Systrace.beginAsyncSection(0L, (String)localPair.second, this.mCurrentID);
    this.mProducerID.put(paramString1, localPair);
    this.mCurrentID = (1 + this.mCurrentID);
  }

  public void onRequestCancellation(String paramString)
  {
    if (!Systrace.isTracing(0L));
    while (!this.mRequestsID.containsKey(paramString))
      return;
    Pair localPair = (Pair)this.mRequestsID.get(paramString);
    Systrace.endAsyncSection(0L, (String)localPair.second, ((Integer)localPair.first).intValue());
    this.mRequestsID.remove(paramString);
  }

  public void onRequestFailure(ImageRequest paramImageRequest, String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    if (!Systrace.isTracing(0L));
    while (!this.mRequestsID.containsKey(paramString))
      return;
    Pair localPair = (Pair)this.mRequestsID.get(paramString);
    Systrace.endAsyncSection(0L, (String)localPair.second, ((Integer)localPair.first).intValue());
    this.mRequestsID.remove(paramString);
  }

  public void onRequestStart(ImageRequest paramImageRequest, Object paramObject, String paramString, boolean paramBoolean)
  {
    if (!Systrace.isTracing(0L))
      return;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FRESCO_REQUEST_");
    localStringBuilder.append(paramImageRequest.getSourceUri().toString().replace(':', '_'));
    Pair localPair = Pair.create(Integer.valueOf(this.mCurrentID), localStringBuilder.toString());
    Systrace.beginAsyncSection(0L, (String)localPair.second, this.mCurrentID);
    this.mRequestsID.put(paramString, localPair);
    this.mCurrentID = (1 + this.mCurrentID);
  }

  public void onRequestSuccess(ImageRequest paramImageRequest, String paramString, boolean paramBoolean)
  {
    if (!Systrace.isTracing(0L));
    while (!this.mRequestsID.containsKey(paramString))
      return;
    Pair localPair = (Pair)this.mRequestsID.get(paramString);
    Systrace.endAsyncSection(0L, (String)localPair.second, ((Integer)localPair.first).intValue());
    this.mRequestsID.remove(paramString);
  }

  public boolean requiresExtraMap(String paramString)
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.fresco.SystraceRequestListener
 * JD-Core Version:    0.6.2
 */
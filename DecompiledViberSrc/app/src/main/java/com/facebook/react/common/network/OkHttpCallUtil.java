package com.facebook.react.common.network;

import java.util.Iterator;
import java.util.List;
import okhttp3.Call;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpCallUtil
{
  public static void cancelTag(OkHttpClient paramOkHttpClient, Object paramObject)
  {
    Iterator localIterator1 = paramOkHttpClient.dispatcher().queuedCalls().iterator();
    while (localIterator1.hasNext())
    {
      Call localCall2 = (Call)localIterator1.next();
      if (paramObject.equals(localCall2.request().tag()))
        localCall2.cancel();
    }
    Call localCall1;
    do
    {
      return;
      Iterator localIterator2;
      while (!localIterator2.hasNext())
        localIterator2 = paramOkHttpClient.dispatcher().runningCalls().iterator();
      localCall1 = (Call)localIterator2.next();
    }
    while (!paramObject.equals(localCall1.request().tag()));
    localCall1.cancel();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.common.network.OkHttpCallUtil
 * JD-Core Version:    0.6.2
 */
package com.viber.libnativehttp;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class DefaultHttpDelegate
  implements Http.Delegate
{
  protected static final int DEFAULT_BUFFER_SIZE = 1024;
  protected static AtomicInteger requestId = new AtomicInteger();

  public void close(Http.Downloader paramDownloader, Http paramHttp)
  {
    paramDownloader.onDisconnected(paramHttp);
    Log.d("DefaultHttpDelegate", "after onConnected");
  }

  public void connect(String paramString, Http.Downloader paramDownloader, Http paramHttp)
  {
    paramDownloader.onConnected(paramHttp);
    Log.d("DefaultHttpDelegate", "after onConnected");
  }

  public void executeGet(Http.Request paramRequest, Http.Downloader paramDownloader, Http paramHttp)
  {
    executeRequest("GET", paramRequest, paramDownloader, paramHttp);
  }

  public void executeHead(Http.Request paramRequest, Http.Downloader paramDownloader, Http paramHttp)
  {
    executeRequest("HEAD", paramRequest, paramDownloader, paramHttp);
  }

  public void executePost(Http.Request paramRequest, Http.Downloader paramDownloader, Http paramHttp)
  {
    executeRequest("POST", paramRequest, paramDownloader, paramHttp);
  }

  protected abstract void executeRequest(String paramString, Http.Request paramRequest, Http.Downloader paramDownloader, Http paramHttp);

  protected Http.RequestHeader[] getHeaders(Map<String, List<String>> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList.add(new Http.RequestHeader((String)localEntry.getKey(), (String)((List)localEntry.getValue()).get(0)));
    }
    return (Http.RequestHeader[])localArrayList.toArray(new Http.RequestHeader[localArrayList.size()]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.libnativehttp.DefaultHttpDelegate
 * JD-Core Version:    0.6.2
 */
package com.viber.libnativehttp;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayList;
import java.util.Iterator;

public class AndroidHttp extends Http
{
  private static final int THREAD_COUNT = 4;
  private static Http.DelegateFactory sGlobalDelegateFactory = new DefaultHttpDelegateFactory();
  private static boolean sInit = false;
  private static ArrayList<Worker> sThreadPool = null;
  private Http.Delegate mDelegate = sGlobalDelegateFactory.createDelegate();
  private Worker mWorker;
  private long nativePtr;

  public static void init()
  {
    try
    {
      boolean bool = sInit;
      if (bool);
      while (true)
      {
        return;
        sThreadPool = new ArrayList(4);
        for (int i = 0; i < 4; i++)
        {
          Worker localWorker = newWorker(i);
          sThreadPool.add(localWorker);
        }
        sInit = true;
      }
    }
    finally
    {
    }
  }

  private static Worker newWorker(int paramInt)
  {
    HandlerThread localHandlerThread = new HandlerThread("AndroidHttp thread no " + paramInt);
    localHandlerThread.start();
    return new Worker(localHandlerThread, new Handler(localHandlerThread.getLooper()));
  }

  public static void setGlobalDelegateFactory(Http.DelegateFactory paramDelegateFactory)
  {
    sGlobalDelegateFactory = paramDelegateFactory;
  }

  public void close(final Http.Downloader paramDownloader)
  {
    execute(new Runnable()
    {
      public void run()
      {
        AndroidHttp.this.mDelegate.close(paramDownloader, AndroidHttp.this);
        AndroidHttp.this.mWorker.owner = null;
        AndroidHttp.access$102(AndroidHttp.this, null);
      }
    });
  }

  public void connect(final String paramString, final Http.Downloader paramDownloader)
  {
    execute(new Runnable()
    {
      public void run()
      {
        AndroidHttp.this.mDelegate.connect(paramString, paramDownloader, AndroidHttp.this);
      }
    });
  }

  public void execute(Runnable paramRunnable)
  {
    try
    {
      if (!sInit)
        init();
      if (this.mWorker == null)
      {
        Iterator localIterator1 = sThreadPool.iterator();
        while (localIterator1.hasNext())
        {
          Worker localWorker3 = (Worker)localIterator1.next();
          if (localWorker3.owner == null)
          {
            this.mWorker = localWorker3;
            localWorker3.owner = this;
          }
        }
        if (this.mWorker != null)
          break label122;
        Worker localWorker2 = newWorker(sThreadPool.size());
        sThreadPool.add(localWorker2);
        this.mWorker = localWorker2;
        localWorker2.owner = this;
        break label141;
      }
      label141: 
      while (true)
      {
        this.mWorker.handler.post(paramRunnable);
        return;
        label122: if (sThreadPool.size() > 8)
        {
          Iterator localIterator2 = sThreadPool.iterator();
          if (localIterator2.hasNext())
          {
            Worker localWorker1 = (Worker)localIterator2.next();
            if (localWorker1.owner != null)
              break;
            localWorker1.thread.quit();
            localIterator2.remove();
          }
        }
      }
    }
    finally
    {
    }
  }

  public void executeGet(final Http.Request paramRequest, final Http.Downloader paramDownloader)
  {
    execute(new Runnable()
    {
      public void run()
      {
        AndroidHttp.this.mDelegate.executeGet(paramRequest, paramDownloader, AndroidHttp.this);
      }
    });
  }

  public void executeHead(final Http.Request paramRequest, final Http.Downloader paramDownloader)
  {
    execute(new Runnable()
    {
      public void run()
      {
        AndroidHttp.this.mDelegate.executeHead(paramRequest, paramDownloader, AndroidHttp.this);
      }
    });
  }

  public void executePost(final Http.Request paramRequest, final Http.Downloader paramDownloader)
  {
    execute(new Runnable()
    {
      public void run()
      {
        AndroidHttp.this.mDelegate.executePost(paramRequest, paramDownloader, AndroidHttp.this);
      }
    });
  }

  static class Worker
  {
    Handler handler;
    AndroidHttp owner;
    HandlerThread thread;

    Worker(HandlerThread paramHandlerThread, Handler paramHandler)
    {
      this.thread = paramHandlerThread;
      this.handler = paramHandler;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.libnativehttp.AndroidHttp
 * JD-Core Version:    0.6.2
 */
package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.util.Pools.SynchronizedPool;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.concurrent.ArrayBlockingQueue;

public final class AsyncLayoutInflater
{
  private static final String TAG = "AsyncLayoutInflater";
  Handler mHandler;
  private Handler.Callback mHandlerCallback = new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      AsyncLayoutInflater.InflateRequest localInflateRequest = (AsyncLayoutInflater.InflateRequest)paramAnonymousMessage.obj;
      if (localInflateRequest.view == null)
        localInflateRequest.view = AsyncLayoutInflater.this.mInflater.inflate(localInflateRequest.resid, localInflateRequest.parent, false);
      localInflateRequest.callback.onInflateFinished(localInflateRequest.view, localInflateRequest.resid, localInflateRequest.parent);
      AsyncLayoutInflater.this.mInflateThread.releaseRequest(localInflateRequest);
      return true;
    }
  };
  InflateThread mInflateThread;
  LayoutInflater mInflater;

  public AsyncLayoutInflater(Context paramContext)
  {
    this.mInflater = new BasicInflater(paramContext);
    this.mHandler = new Handler(this.mHandlerCallback);
    this.mInflateThread = InflateThread.getInstance();
  }

  public void inflate(int paramInt, ViewGroup paramViewGroup, OnInflateFinishedListener paramOnInflateFinishedListener)
  {
    if (paramOnInflateFinishedListener == null)
      throw new NullPointerException("callback argument may not be null!");
    InflateRequest localInflateRequest = this.mInflateThread.obtainRequest();
    localInflateRequest.inflater = this;
    localInflateRequest.resid = paramInt;
    localInflateRequest.parent = paramViewGroup;
    localInflateRequest.callback = paramOnInflateFinishedListener;
    this.mInflateThread.enqueue(localInflateRequest);
  }

  private static class BasicInflater extends LayoutInflater
  {
    private static final String[] sClassPrefixList = { "android.widget.", "android.webkit.", "android.app." };

    BasicInflater(Context paramContext)
    {
      super();
    }

    public LayoutInflater cloneInContext(Context paramContext)
    {
      return new BasicInflater(paramContext);
    }

    protected View onCreateView(String paramString, AttributeSet paramAttributeSet)
      throws ClassNotFoundException
    {
      String[] arrayOfString = sClassPrefixList;
      int i = arrayOfString.length;
      int j = 0;
      while (j < i)
      {
        String str = arrayOfString[j];
        try
        {
          View localView = createView(paramString, str, paramAttributeSet);
          if (localView != null)
            return localView;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          j++;
        }
      }
      return super.onCreateView(paramString, paramAttributeSet);
    }
  }

  private static class InflateRequest
  {
    AsyncLayoutInflater.OnInflateFinishedListener callback;
    AsyncLayoutInflater inflater;
    ViewGroup parent;
    int resid;
    View view;
  }

  private static class InflateThread extends Thread
  {
    private static final InflateThread sInstance = new InflateThread();
    private ArrayBlockingQueue<AsyncLayoutInflater.InflateRequest> mQueue = new ArrayBlockingQueue(10);
    private Pools.SynchronizedPool<AsyncLayoutInflater.InflateRequest> mRequestPool = new Pools.SynchronizedPool(10);

    static
    {
      sInstance.start();
    }

    public static InflateThread getInstance()
    {
      return sInstance;
    }

    public void enqueue(AsyncLayoutInflater.InflateRequest paramInflateRequest)
    {
      try
      {
        this.mQueue.put(paramInflateRequest);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new RuntimeException("Failed to enqueue async inflate request", localInterruptedException);
      }
    }

    public AsyncLayoutInflater.InflateRequest obtainRequest()
    {
      AsyncLayoutInflater.InflateRequest localInflateRequest = (AsyncLayoutInflater.InflateRequest)this.mRequestPool.acquire();
      if (localInflateRequest == null)
        localInflateRequest = new AsyncLayoutInflater.InflateRequest();
      return localInflateRequest;
    }

    public void releaseRequest(AsyncLayoutInflater.InflateRequest paramInflateRequest)
    {
      paramInflateRequest.callback = null;
      paramInflateRequest.inflater = null;
      paramInflateRequest.parent = null;
      paramInflateRequest.resid = 0;
      paramInflateRequest.view = null;
      this.mRequestPool.release(paramInflateRequest);
    }

    public void run()
    {
      while (true)
        runInner();
    }

    // ERROR //
    public void runInner()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 30	android/support/v4/view/AsyncLayoutInflater$InflateThread:mQueue	Ljava/util/concurrent/ArrayBlockingQueue;
      //   4: invokevirtual 93	java/util/concurrent/ArrayBlockingQueue:take	()Ljava/lang/Object;
      //   7: checkcast 60	android/support/v4/view/AsyncLayoutInflater$InflateRequest
      //   10: astore_3
      //   11: aload_3
      //   12: aload_3
      //   13: getfield 70	android/support/v4/view/AsyncLayoutInflater$InflateRequest:inflater	Landroid/support/v4/view/AsyncLayoutInflater;
      //   16: getfield 99	android/support/v4/view/AsyncLayoutInflater:mInflater	Landroid/view/LayoutInflater;
      //   19: aload_3
      //   20: getfield 78	android/support/v4/view/AsyncLayoutInflater$InflateRequest:resid	I
      //   23: aload_3
      //   24: getfield 74	android/support/v4/view/AsyncLayoutInflater$InflateRequest:parent	Landroid/view/ViewGroup;
      //   27: iconst_0
      //   28: invokevirtual 105	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
      //   31: putfield 82	android/support/v4/view/AsyncLayoutInflater$InflateRequest:view	Landroid/view/View;
      //   34: aload_3
      //   35: getfield 70	android/support/v4/view/AsyncLayoutInflater$InflateRequest:inflater	Landroid/support/v4/view/AsyncLayoutInflater;
      //   38: getfield 109	android/support/v4/view/AsyncLayoutInflater:mHandler	Landroid/os/Handler;
      //   41: iconst_0
      //   42: aload_3
      //   43: invokestatic 115	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
      //   46: invokevirtual 118	android/os/Message:sendToTarget	()V
      //   49: return
      //   50: astore_1
      //   51: ldc 120
      //   53: aload_1
      //   54: invokestatic 126	android/util/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
      //   57: pop
      //   58: return
      //   59: astore 4
      //   61: ldc 120
      //   63: ldc 128
      //   65: aload 4
      //   67: invokestatic 131	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   70: pop
      //   71: goto -37 -> 34
      //
      // Exception table:
      //   from	to	target	type
      //   0	11	50	java/lang/InterruptedException
      //   11	34	59	java/lang/RuntimeException
    }
  }

  public static abstract interface OnInflateFinishedListener
  {
    public abstract void onInflateFinished(View paramView, int paramInt, ViewGroup paramViewGroup);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.view.AsyncLayoutInflater
 * JD-Core Version:    0.6.2
 */
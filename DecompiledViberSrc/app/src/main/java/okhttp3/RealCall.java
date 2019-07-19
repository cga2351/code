package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;

final class RealCall
  implements Call
{
  final OkHttpClient client;
  private EventListener eventListener;
  private boolean executed;
  final boolean forWebSocket;
  final Request originalRequest;
  final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;

  private RealCall(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean)
  {
    this.client = paramOkHttpClient;
    this.originalRequest = paramRequest;
    this.forWebSocket = paramBoolean;
    this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(paramOkHttpClient, paramBoolean);
  }

  private void captureCallStackTrace()
  {
    Object localObject = Platform.get().getStackTraceForCloseable("response.body().close()");
    this.retryAndFollowUpInterceptor.setCallStackTrace(localObject);
  }

  static RealCall newRealCall(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean)
  {
    RealCall localRealCall = new RealCall(paramOkHttpClient, paramRequest, paramBoolean);
    localRealCall.eventListener = paramOkHttpClient.eventListenerFactory().create(localRealCall);
    return localRealCall;
  }

  public void cancel()
  {
    this.retryAndFollowUpInterceptor.cancel();
  }

  public RealCall clone()
  {
    return newRealCall(this.client, this.originalRequest, this.forWebSocket);
  }

  public void enqueue(Callback paramCallback)
  {
    try
    {
      if (this.executed)
        throw new IllegalStateException("Already Executed");
    }
    finally
    {
    }
    this.executed = true;
    captureCallStackTrace();
    this.eventListener.callStart(this);
    this.client.dispatcher().enqueue(new AsyncCall(paramCallback));
  }

  public Response execute()
    throws IOException
  {
    try
    {
      if (this.executed)
        throw new IllegalStateException("Already Executed");
    }
    finally
    {
    }
    this.executed = true;
    captureCallStackTrace();
    this.eventListener.callStart(this);
    Response localResponse;
    try
    {
      this.client.dispatcher().executed(this);
      localResponse = getResponseWithInterceptorChain();
      if (localResponse == null)
        throw new IOException("Canceled");
    }
    catch (IOException localIOException)
    {
      this.eventListener.callFailed(this, localIOException);
      throw localIOException;
    }
    finally
    {
      this.client.dispatcher().finished(this);
    }
    this.client.dispatcher().finished(this);
    return localResponse;
  }

  Response getResponseWithInterceptorChain()
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.client.interceptors());
    localArrayList.add(this.retryAndFollowUpInterceptor);
    localArrayList.add(new BridgeInterceptor(this.client.cookieJar()));
    localArrayList.add(new CacheInterceptor(this.client.internalCache()));
    localArrayList.add(new ConnectInterceptor(this.client));
    if (!this.forWebSocket)
      localArrayList.addAll(this.client.networkInterceptors());
    localArrayList.add(new CallServerInterceptor(this.forWebSocket));
    return new RealInterceptorChain(localArrayList, null, null, null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
  }

  public boolean isCanceled()
  {
    return this.retryAndFollowUpInterceptor.isCanceled();
  }

  public boolean isExecuted()
  {
    try
    {
      boolean bool = this.executed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  String redactedUrl()
  {
    return this.originalRequest.url().redact();
  }

  public Request request()
  {
    return this.originalRequest;
  }

  StreamAllocation streamAllocation()
  {
    return this.retryAndFollowUpInterceptor.streamAllocation();
  }

  String toLoggableString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1;
    StringBuilder localStringBuilder2;
    if (isCanceled())
    {
      str1 = "canceled ";
      localStringBuilder2 = localStringBuilder1.append(str1);
      if (!this.forWebSocket)
        break label63;
    }
    label63: for (String str2 = "web socket"; ; str2 = "call")
    {
      return str2 + " to " + redactedUrl();
      str1 = "";
      break;
    }
  }

  final class AsyncCall extends NamedRunnable
  {
    private final Callback responseCallback;

    AsyncCall(Callback arg2)
    {
      super(arrayOfObject);
      Object localObject;
      this.responseCallback = localObject;
    }

    // ERROR //
    protected void execute()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_1
      //   2: aload_0
      //   3: getfield 12	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   6: invokevirtual 35	okhttp3/RealCall:getResponseWithInterceptorChain	()Lokhttp3/Response;
      //   9: astore 4
      //   11: aload_0
      //   12: getfield 12	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   15: getfield 39	okhttp3/RealCall:retryAndFollowUpInterceptor	Lokhttp3/internal/http/RetryAndFollowUpInterceptor;
      //   18: invokevirtual 45	okhttp3/internal/http/RetryAndFollowUpInterceptor:isCanceled	()Z
      //   21: istore 5
      //   23: iload 5
      //   25: ifeq +40 -> 65
      //   28: aload_0
      //   29: getfield 27	okhttp3/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
      //   32: aload_0
      //   33: getfield 12	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   36: new 31	java/io/IOException
      //   39: dup
      //   40: ldc 47
      //   42: invokespecial 50	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   45: invokeinterface 56 3 0
      //   50: aload_0
      //   51: getfield 12	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   54: getfield 60	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
      //   57: invokevirtual 66	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
      //   60: aload_0
      //   61: invokevirtual 72	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall$AsyncCall;)V
      //   64: return
      //   65: aload_0
      //   66: getfield 27	okhttp3/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
      //   69: aload_0
      //   70: getfield 12	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   73: aload 4
      //   75: invokeinterface 76 3 0
      //   80: goto -30 -> 50
      //   83: astore_2
      //   84: iload_1
      //   85: ifeq +51 -> 136
      //   88: invokestatic 82	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
      //   91: iconst_4
      //   92: new 84	java/lang/StringBuilder
      //   95: dup
      //   96: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   99: ldc 88
      //   101: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   104: aload_0
      //   105: getfield 12	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   108: invokevirtual 95	okhttp3/RealCall:toLoggableString	()Ljava/lang/String;
      //   111: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   114: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   117: aload_2
      //   118: invokevirtual 102	okhttp3/internal/platform/Platform:log	(ILjava/lang/String;Ljava/lang/Throwable;)V
      //   121: aload_0
      //   122: getfield 12	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   125: getfield 60	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
      //   128: invokevirtual 66	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
      //   131: aload_0
      //   132: invokevirtual 72	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall$AsyncCall;)V
      //   135: return
      //   136: aload_0
      //   137: getfield 12	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   140: invokestatic 106	okhttp3/RealCall:access$000	(Lokhttp3/RealCall;)Lokhttp3/EventListener;
      //   143: aload_0
      //   144: getfield 12	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   147: aload_2
      //   148: invokevirtual 111	okhttp3/EventListener:callFailed	(Lokhttp3/Call;Ljava/io/IOException;)V
      //   151: aload_0
      //   152: getfield 27	okhttp3/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
      //   155: aload_0
      //   156: getfield 12	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   159: aload_2
      //   160: invokeinterface 56 3 0
      //   165: goto -44 -> 121
      //   168: astore_3
      //   169: aload_0
      //   170: getfield 12	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   173: getfield 60	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
      //   176: invokevirtual 66	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
      //   179: aload_0
      //   180: invokevirtual 72	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall$AsyncCall;)V
      //   183: aload_3
      //   184: athrow
      //   185: astore_2
      //   186: iconst_0
      //   187: istore_1
      //   188: goto -104 -> 84
      //
      // Exception table:
      //   from	to	target	type
      //   28	50	83	java/io/IOException
      //   65	80	83	java/io/IOException
      //   2	23	168	finally
      //   28	50	168	finally
      //   65	80	168	finally
      //   88	121	168	finally
      //   136	165	168	finally
      //   2	23	185	java/io/IOException
    }

    RealCall get()
    {
      return RealCall.this;
    }

    String host()
    {
      return RealCall.this.originalRequest.url().host();
    }

    Request request()
    {
      return RealCall.this.originalRequest;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.RealCall
 * JD-Core Version:    0.6.2
 */
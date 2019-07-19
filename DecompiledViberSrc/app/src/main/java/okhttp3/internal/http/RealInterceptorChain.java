package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;

public final class RealInterceptorChain
  implements Interceptor.Chain
{
  private final Call call;
  private int calls;
  private final int connectTimeout;
  private final RealConnection connection;
  private final EventListener eventListener;
  private final HttpCodec httpCodec;
  private final int index;
  private final List<Interceptor> interceptors;
  private final int readTimeout;
  private final Request request;
  private final StreamAllocation streamAllocation;
  private final int writeTimeout;

  public RealInterceptorChain(List<Interceptor> paramList, StreamAllocation paramStreamAllocation, HttpCodec paramHttpCodec, RealConnection paramRealConnection, int paramInt1, Request paramRequest, Call paramCall, EventListener paramEventListener, int paramInt2, int paramInt3, int paramInt4)
  {
    this.interceptors = paramList;
    this.connection = paramRealConnection;
    this.streamAllocation = paramStreamAllocation;
    this.httpCodec = paramHttpCodec;
    this.index = paramInt1;
    this.request = paramRequest;
    this.call = paramCall;
    this.eventListener = paramEventListener;
    this.connectTimeout = paramInt2;
    this.readTimeout = paramInt3;
    this.writeTimeout = paramInt4;
  }

  public Call call()
  {
    return this.call;
  }

  public int connectTimeoutMillis()
  {
    return this.connectTimeout;
  }

  public Connection connection()
  {
    return this.connection;
  }

  public EventListener eventListener()
  {
    return this.eventListener;
  }

  public HttpCodec httpStream()
  {
    return this.httpCodec;
  }

  public Response proceed(Request paramRequest)
    throws IOException
  {
    return proceed(paramRequest, this.streamAllocation, this.httpCodec, this.connection);
  }

  public Response proceed(Request paramRequest, StreamAllocation paramStreamAllocation, HttpCodec paramHttpCodec, RealConnection paramRealConnection)
    throws IOException
  {
    if (this.index >= this.interceptors.size())
      throw new AssertionError();
    this.calls = (1 + this.calls);
    if ((this.httpCodec != null) && (!this.connection.supportsUrl(paramRequest.url())))
      throw new IllegalStateException("network interceptor " + this.interceptors.get(-1 + this.index) + " must retain the same host and port");
    if ((this.httpCodec != null) && (this.calls > 1))
      throw new IllegalStateException("network interceptor " + this.interceptors.get(-1 + this.index) + " must call proceed() exactly once");
    RealInterceptorChain localRealInterceptorChain = new RealInterceptorChain(this.interceptors, paramStreamAllocation, paramHttpCodec, paramRealConnection, 1 + this.index, paramRequest, this.call, this.eventListener, this.connectTimeout, this.readTimeout, this.writeTimeout);
    Interceptor localInterceptor = (Interceptor)this.interceptors.get(this.index);
    Response localResponse = localInterceptor.intercept(localRealInterceptorChain);
    if ((paramHttpCodec != null) && (1 + this.index < this.interceptors.size()) && (localRealInterceptorChain.calls != 1))
      throw new IllegalStateException("network interceptor " + localInterceptor + " must call proceed() exactly once");
    if (localResponse == null)
      throw new NullPointerException("interceptor " + localInterceptor + " returned null");
    if (localResponse.body() == null)
      throw new IllegalStateException("interceptor " + localInterceptor + " returned a response with no body");
    return localResponse;
  }

  public int readTimeoutMillis()
  {
    return this.readTimeout;
  }

  public Request request()
  {
    return this.request;
  }

  public StreamAllocation streamAllocation()
  {
    return this.streamAllocation;
  }

  public Interceptor.Chain withConnectTimeout(int paramInt, TimeUnit paramTimeUnit)
  {
    int i = Util.checkDuration("timeout", paramInt, paramTimeUnit);
    return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, i, this.readTimeout, this.writeTimeout);
  }

  public Interceptor.Chain withReadTimeout(int paramInt, TimeUnit paramTimeUnit)
  {
    int i = Util.checkDuration("timeout", paramInt, paramTimeUnit);
    return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, i, this.writeTimeout);
  }

  public Interceptor.Chain withWriteTimeout(int paramInt, TimeUnit paramTimeUnit)
  {
    int i = Util.checkDuration("timeout", paramInt, paramTimeUnit);
    return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, this.readTimeout, i);
  }

  public int writeTimeoutMillis()
  {
    return this.writeTimeout;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.http.RealInterceptorChain
 * JD-Core Version:    0.6.2
 */
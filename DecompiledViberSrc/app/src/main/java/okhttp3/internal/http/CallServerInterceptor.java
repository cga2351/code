package okhttp3.internal.http;

import f.c;
import f.d;
import f.g;
import f.l;
import f.s;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;

public final class CallServerInterceptor
  implements Interceptor
{
  private final boolean forWebSocket;

  public CallServerInterceptor(boolean paramBoolean)
  {
    this.forWebSocket = paramBoolean;
  }

  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    RealInterceptorChain localRealInterceptorChain = (RealInterceptorChain)paramChain;
    HttpCodec localHttpCodec = localRealInterceptorChain.httpStream();
    StreamAllocation localStreamAllocation = localRealInterceptorChain.streamAllocation();
    RealConnection localRealConnection = (RealConnection)localRealInterceptorChain.connection();
    Request localRequest = localRealInterceptorChain.request();
    long l = System.currentTimeMillis();
    localRealInterceptorChain.eventListener().requestHeadersStart(localRealInterceptorChain.call());
    localHttpCodec.writeRequestHeaders(localRequest);
    localRealInterceptorChain.eventListener().requestHeadersEnd(localRealInterceptorChain.call(), localRequest);
    Response.Builder localBuilder2;
    Response.Builder localBuilder1;
    if ((HttpMethod.permitsRequestBody(localRequest.method())) && (localRequest.body() != null))
    {
      boolean bool = "100-continue".equalsIgnoreCase(localRequest.header("Expect"));
      localBuilder2 = null;
      if (bool)
      {
        localHttpCodec.flushRequest();
        localRealInterceptorChain.eventListener().responseHeadersStart(localRealInterceptorChain.call());
        localBuilder2 = localHttpCodec.readResponseHeaders(true);
      }
      if (localBuilder2 == null)
      {
        localRealInterceptorChain.eventListener().requestBodyStart(localRealInterceptorChain.call());
        CountingSink localCountingSink = new CountingSink(localHttpCodec.createRequestBody(localRequest, localRequest.body().contentLength()));
        d locald = l.a(localCountingSink);
        localRequest.body().writeTo(locald);
        locald.close();
        localRealInterceptorChain.eventListener().requestBodyEnd(localRealInterceptorChain.call(), localCountingSink.successfulCount);
        localBuilder1 = localBuilder2;
      }
    }
    while (true)
    {
      localHttpCodec.finishRequest();
      if (localBuilder1 == null)
      {
        localRealInterceptorChain.eventListener().responseHeadersStart(localRealInterceptorChain.call());
        localBuilder1 = localHttpCodec.readResponseHeaders(false);
      }
      Response localResponse1 = localBuilder1.request(localRequest).handshake(localStreamAllocation.connection().handshake()).sentRequestAtMillis(l).receivedResponseAtMillis(System.currentTimeMillis()).build();
      int i = localResponse1.code();
      if (i == 100)
      {
        localResponse1 = localHttpCodec.readResponseHeaders(false).request(localRequest).handshake(localStreamAllocation.connection().handshake()).sentRequestAtMillis(l).receivedResponseAtMillis(System.currentTimeMillis()).build();
        i = localResponse1.code();
      }
      localRealInterceptorChain.eventListener().responseHeadersEnd(localRealInterceptorChain.call(), localResponse1);
      if ((this.forWebSocket) && (i == 101));
      for (Response localResponse2 = localResponse1.newBuilder().body(Util.EMPTY_RESPONSE).build(); ; localResponse2 = localResponse1.newBuilder().body(localHttpCodec.openResponseBody(localResponse1)).build())
      {
        if (("close".equalsIgnoreCase(localResponse2.request().header("Connection"))) || ("close".equalsIgnoreCase(localResponse2.header("Connection"))))
          localStreamAllocation.noNewStreams();
        if (((i != 204) && (i != 205)) || (localResponse2.body().contentLength() <= 0L))
          break label543;
        throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + localResponse2.body().contentLength());
        if (!localRealConnection.isMultiplexed())
          localStreamAllocation.noNewStreams();
        localBuilder1 = localBuilder2;
        break;
      }
      label543: return localResponse2;
      localBuilder1 = null;
    }
  }

  static final class CountingSink extends g
  {
    long successfulCount;

    CountingSink(s params)
    {
      super();
    }

    public void write(c paramc, long paramLong)
      throws IOException
    {
      super.write(paramc, paramLong);
      this.successfulCount = (paramLong + this.successfulCount);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.http.CallServerInterceptor
 * JD-Core Version:    0.6.2
 */
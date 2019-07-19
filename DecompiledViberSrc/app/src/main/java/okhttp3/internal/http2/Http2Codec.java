package okhttp3.internal.http2;

import f.c;
import f.f;
import f.h;
import f.l;
import f.s;
import f.t;
import f.u;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;

public final class Http2Codec
  implements HttpCodec
{
  private static final f CONNECTION = f.a("connection");
  private static final f ENCODING;
  private static final f HOST = f.a("host");
  private static final List<f> HTTP_2_SKIPPED_REQUEST_HEADERS;
  private static final List<f> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList(arrayOff2);
  private static final f KEEP_ALIVE = f.a("keep-alive");
  private static final f PROXY_CONNECTION = f.a("proxy-connection");
  private static final f TE;
  private static final f TRANSFER_ENCODING = f.a("transfer-encoding");
  private static final f UPGRADE;
  private final Interceptor.Chain chain;
  private final OkHttpClient client;
  private final Http2Connection connection;
  private Http2Stream stream;
  final StreamAllocation streamAllocation;

  static
  {
    TE = f.a("te");
    ENCODING = f.a("encoding");
    UPGRADE = f.a("upgrade");
    f[] arrayOff1 = new f[12];
    arrayOff1[0] = CONNECTION;
    arrayOff1[1] = HOST;
    arrayOff1[2] = KEEP_ALIVE;
    arrayOff1[3] = PROXY_CONNECTION;
    arrayOff1[4] = TE;
    arrayOff1[5] = TRANSFER_ENCODING;
    arrayOff1[6] = ENCODING;
    arrayOff1[7] = UPGRADE;
    arrayOff1[8] = Header.TARGET_METHOD;
    arrayOff1[9] = Header.TARGET_PATH;
    arrayOff1[10] = Header.TARGET_SCHEME;
    arrayOff1[11] = Header.TARGET_AUTHORITY;
    HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList(arrayOff1);
    f[] arrayOff2 = new f[8];
    arrayOff2[0] = CONNECTION;
    arrayOff2[1] = HOST;
    arrayOff2[2] = KEEP_ALIVE;
    arrayOff2[3] = PROXY_CONNECTION;
    arrayOff2[4] = TE;
    arrayOff2[5] = TRANSFER_ENCODING;
    arrayOff2[6] = ENCODING;
    arrayOff2[7] = UPGRADE;
  }

  public Http2Codec(OkHttpClient paramOkHttpClient, Interceptor.Chain paramChain, StreamAllocation paramStreamAllocation, Http2Connection paramHttp2Connection)
  {
    this.client = paramOkHttpClient;
    this.chain = paramChain;
    this.streamAllocation = paramStreamAllocation;
    this.connection = paramHttp2Connection;
  }

  public static List<Header> http2HeadersList(Request paramRequest)
  {
    Headers localHeaders = paramRequest.headers();
    ArrayList localArrayList = new ArrayList(4 + localHeaders.size());
    localArrayList.add(new Header(Header.TARGET_METHOD, paramRequest.method()));
    localArrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(paramRequest.url())));
    String str = paramRequest.header("Host");
    if (str != null)
      localArrayList.add(new Header(Header.TARGET_AUTHORITY, str));
    localArrayList.add(new Header(Header.TARGET_SCHEME, paramRequest.url().scheme()));
    int i = 0;
    int j = localHeaders.size();
    while (i < j)
    {
      f localf = f.a(localHeaders.name(i).toLowerCase(Locale.US));
      if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(localf))
        localArrayList.add(new Header(localf, localHeaders.value(i)));
      i++;
    }
    return localArrayList;
  }

  public static Response.Builder readHttp2HeadersList(List<Header> paramList)
    throws IOException
  {
    Object localObject1 = new Headers.Builder();
    int i = paramList.size();
    int j = 0;
    Object localObject2 = null;
    if (j < i)
    {
      Header localHeader = (Header)paramList.get(j);
      Object localObject3;
      Object localObject4;
      if (localHeader == null)
      {
        if ((localObject2 == null) || (localObject2.code != 100))
          break label176;
        localObject3 = new Headers.Builder();
        localObject4 = null;
      }
      while (true)
      {
        j++;
        localObject2 = localObject4;
        localObject1 = localObject3;
        break;
        f localf = localHeader.name;
        String str = localHeader.value.a();
        if (localf.equals(Header.RESPONSE_STATUS))
        {
          StatusLine localStatusLine = StatusLine.parse("HTTP/1.1 " + str);
          Object localObject5 = localObject1;
          localObject4 = localStatusLine;
          localObject3 = localObject5;
        }
        else
        {
          if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(localf))
            Internal.instance.addLenient((Headers.Builder)localObject1, localf.a(), str);
          label176: localObject3 = localObject1;
          localObject4 = localObject2;
        }
      }
    }
    if (localObject2 == null)
      throw new ProtocolException("Expected ':status' header not present");
    return new Response.Builder().protocol(Protocol.HTTP_2).code(localObject2.code).message(localObject2.message).headers(((Headers.Builder)localObject1).build());
  }

  public void cancel()
  {
    if (this.stream != null)
      this.stream.closeLater(ErrorCode.CANCEL);
  }

  public s createRequestBody(Request paramRequest, long paramLong)
  {
    return this.stream.getSink();
  }

  public void finishRequest()
    throws IOException
  {
    this.stream.getSink().close();
  }

  public void flushRequest()
    throws IOException
  {
    this.connection.flush();
  }

  public ResponseBody openResponseBody(Response paramResponse)
    throws IOException
  {
    this.streamAllocation.eventListener.responseBodyStart(this.streamAllocation.call);
    return new RealResponseBody(paramResponse.header("Content-Type"), HttpHeaders.contentLength(paramResponse), l.a(new StreamFinishingSource(this.stream.getSource())));
  }

  public Response.Builder readResponseHeaders(boolean paramBoolean)
    throws IOException
  {
    Response.Builder localBuilder = readHttp2HeadersList(this.stream.takeResponseHeaders());
    if ((paramBoolean) && (Internal.instance.code(localBuilder) == 100))
      localBuilder = null;
    return localBuilder;
  }

  public void writeRequestHeaders(Request paramRequest)
    throws IOException
  {
    if (this.stream != null)
      return;
    if (paramRequest.body() != null);
    for (boolean bool = true; ; bool = false)
    {
      List localList = http2HeadersList(paramRequest);
      this.stream = this.connection.newStream(localList, bool);
      this.stream.readTimeout().timeout(this.chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
      this.stream.writeTimeout().timeout(this.chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
      return;
    }
  }

  class StreamFinishingSource extends h
  {
    long bytesRead = 0L;
    boolean completed = false;

    StreamFinishingSource(t arg2)
    {
      super();
    }

    private void endOfInput(IOException paramIOException)
    {
      if (this.completed)
        return;
      this.completed = true;
      Http2Codec.this.streamAllocation.streamFinished(false, Http2Codec.this, this.bytesRead, paramIOException);
    }

    public void close()
      throws IOException
    {
      super.close();
      endOfInput(null);
    }

    public long read(c paramc, long paramLong)
      throws IOException
    {
      try
      {
        long l = delegate().read(paramc, paramLong);
        if (l > 0L)
          this.bytesRead = (l + this.bytesRead);
        return l;
      }
      catch (IOException localIOException)
      {
        endOfInput(localIOException);
        throw localIOException;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Codec
 * JD-Core Version:    0.6.2
 */
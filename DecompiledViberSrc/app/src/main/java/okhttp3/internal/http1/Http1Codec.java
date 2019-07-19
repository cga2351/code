package okhttp3.internal.http1;

import f.c;
import f.d;
import f.e;
import f.i;
import f.l;
import f.s;
import f.t;
import f.u;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;

public final class Http1Codec
  implements HttpCodec
{
  private static final int HEADER_LIMIT = 262144;
  private static final int STATE_CLOSED = 6;
  private static final int STATE_IDLE = 0;
  private static final int STATE_OPEN_REQUEST_BODY = 1;
  private static final int STATE_OPEN_RESPONSE_BODY = 4;
  private static final int STATE_READING_RESPONSE_BODY = 5;
  private static final int STATE_READ_RESPONSE_HEADERS = 3;
  private static final int STATE_WRITING_REQUEST_BODY = 2;
  final OkHttpClient client;
  private long headerLimit = 262144L;
  final d sink;
  final e source;
  int state = 0;
  final StreamAllocation streamAllocation;

  public Http1Codec(OkHttpClient paramOkHttpClient, StreamAllocation paramStreamAllocation, e parame, d paramd)
  {
    this.client = paramOkHttpClient;
    this.streamAllocation = paramStreamAllocation;
    this.source = parame;
    this.sink = paramd;
  }

  private String readHeaderLine()
    throws IOException
  {
    String str = this.source.f(this.headerLimit);
    this.headerLimit -= str.length();
    return str;
  }

  public void cancel()
  {
    RealConnection localRealConnection = this.streamAllocation.connection();
    if (localRealConnection != null)
      localRealConnection.cancel();
  }

  public s createRequestBody(Request paramRequest, long paramLong)
  {
    if ("chunked".equalsIgnoreCase(paramRequest.header("Transfer-Encoding")))
      return newChunkedSink();
    if (paramLong != -1L)
      return newFixedLengthSink(paramLong);
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }

  void detachTimeout(i parami)
  {
    u localu = parami.a();
    parami.a(u.NONE);
    localu.clearDeadline();
    localu.clearTimeout();
  }

  public void finishRequest()
    throws IOException
  {
    this.sink.flush();
  }

  public void flushRequest()
    throws IOException
  {
    this.sink.flush();
  }

  public boolean isClosed()
  {
    return this.state == 6;
  }

  public s newChunkedSink()
  {
    if (this.state != 1)
      throw new IllegalStateException("state: " + this.state);
    this.state = 2;
    return new ChunkedSink();
  }

  public t newChunkedSource(HttpUrl paramHttpUrl)
    throws IOException
  {
    if (this.state != 4)
      throw new IllegalStateException("state: " + this.state);
    this.state = 5;
    return new ChunkedSource(paramHttpUrl);
  }

  public s newFixedLengthSink(long paramLong)
  {
    if (this.state != 1)
      throw new IllegalStateException("state: " + this.state);
    this.state = 2;
    return new FixedLengthSink(paramLong);
  }

  public t newFixedLengthSource(long paramLong)
    throws IOException
  {
    if (this.state != 4)
      throw new IllegalStateException("state: " + this.state);
    this.state = 5;
    return new FixedLengthSource(paramLong);
  }

  public t newUnknownLengthSource()
    throws IOException
  {
    if (this.state != 4)
      throw new IllegalStateException("state: " + this.state);
    if (this.streamAllocation == null)
      throw new IllegalStateException("streamAllocation == null");
    this.state = 5;
    this.streamAllocation.noNewStreams();
    return new UnknownLengthSource();
  }

  public ResponseBody openResponseBody(Response paramResponse)
    throws IOException
  {
    this.streamAllocation.eventListener.responseBodyStart(this.streamAllocation.call);
    String str = paramResponse.header("Content-Type");
    if (!HttpHeaders.hasBody(paramResponse))
      return new RealResponseBody(str, 0L, l.a(newFixedLengthSource(0L)));
    if ("chunked".equalsIgnoreCase(paramResponse.header("Transfer-Encoding")))
      return new RealResponseBody(str, -1L, l.a(newChunkedSource(paramResponse.request().url())));
    long l = HttpHeaders.contentLength(paramResponse);
    if (l != -1L)
      return new RealResponseBody(str, l, l.a(newFixedLengthSource(l)));
    return new RealResponseBody(str, -1L, l.a(newUnknownLengthSource()));
  }

  public Headers readHeaders()
    throws IOException
  {
    Headers.Builder localBuilder = new Headers.Builder();
    while (true)
    {
      String str = readHeaderLine();
      if (str.length() == 0)
        break;
      Internal.instance.addLenient(localBuilder, str);
    }
    return localBuilder.build();
  }

  public Response.Builder readResponseHeaders(boolean paramBoolean)
    throws IOException
  {
    if ((this.state != 1) && (this.state != 3))
      throw new IllegalStateException("state: " + this.state);
    Response.Builder localBuilder;
    try
    {
      StatusLine localStatusLine = StatusLine.parse(readHeaderLine());
      localBuilder = new Response.Builder().protocol(localStatusLine.protocol).code(localStatusLine.code).message(localStatusLine.message).headers(readHeaders());
      if ((paramBoolean) && (localStatusLine.code == 100))
        return null;
      if (localStatusLine.code == 100)
      {
        this.state = 3;
        return localBuilder;
      }
    }
    catch (EOFException localEOFException)
    {
      IOException localIOException = new IOException("unexpected end of stream on " + this.streamAllocation);
      localIOException.initCause(localEOFException);
      throw localIOException;
    }
    this.state = 4;
    return localBuilder;
  }

  public void writeRequest(Headers paramHeaders, String paramString)
    throws IOException
  {
    if (this.state != 0)
      throw new IllegalStateException("state: " + this.state);
    this.sink.b(paramString).b("\r\n");
    int i = 0;
    int j = paramHeaders.size();
    while (i < j)
    {
      this.sink.b(paramHeaders.name(i)).b(": ").b(paramHeaders.value(i)).b("\r\n");
      i++;
    }
    this.sink.b("\r\n");
    this.state = 1;
  }

  public void writeRequestHeaders(Request paramRequest)
    throws IOException
  {
    String str = RequestLine.get(paramRequest, this.streamAllocation.connection().route().proxy().type());
    writeRequest(paramRequest.headers(), str);
  }

  private abstract class AbstractSource
    implements t
  {
    protected long bytesRead = 0L;
    protected boolean closed;
    protected final i timeout = new i(Http1Codec.this.source.timeout());

    private AbstractSource()
    {
    }

    protected final void endOfInput(boolean paramBoolean, IOException paramIOException)
      throws IOException
    {
      if (Http1Codec.this.state == 6);
      do
      {
        return;
        if (Http1Codec.this.state != 5)
          throw new IllegalStateException("state: " + Http1Codec.this.state);
        Http1Codec.this.detachTimeout(this.timeout);
        Http1Codec.this.state = 6;
      }
      while (Http1Codec.this.streamAllocation == null);
      StreamAllocation localStreamAllocation = Http1Codec.this.streamAllocation;
      if (!paramBoolean);
      for (boolean bool = true; ; bool = false)
      {
        localStreamAllocation.streamFinished(bool, Http1Codec.this, this.bytesRead, paramIOException);
        return;
      }
    }

    public long read(c paramc, long paramLong)
      throws IOException
    {
      try
      {
        long l = Http1Codec.this.source.read(paramc, paramLong);
        if (l > 0L)
          this.bytesRead = (l + this.bytesRead);
        return l;
      }
      catch (IOException localIOException)
      {
        endOfInput(false, localIOException);
        throw localIOException;
      }
    }

    public u timeout()
    {
      return this.timeout;
    }
  }

  private final class ChunkedSink
    implements s
  {
    private boolean closed;
    private final i timeout = new i(Http1Codec.this.sink.timeout());

    ChunkedSink()
    {
    }

    public void close()
      throws IOException
    {
      try
      {
        boolean bool = this.closed;
        if (bool);
        while (true)
        {
          return;
          this.closed = true;
          Http1Codec.this.sink.b("0\r\n\r\n");
          Http1Codec.this.detachTimeout(this.timeout);
          Http1Codec.this.state = 3;
        }
      }
      finally
      {
      }
    }

    public void flush()
      throws IOException
    {
      try
      {
        boolean bool = this.closed;
        if (bool);
        while (true)
        {
          return;
          Http1Codec.this.sink.flush();
        }
      }
      finally
      {
      }
    }

    public u timeout()
    {
      return this.timeout;
    }

    public void write(c paramc, long paramLong)
      throws IOException
    {
      if (this.closed)
        throw new IllegalStateException("closed");
      if (paramLong == 0L)
        return;
      Http1Codec.this.sink.m(paramLong);
      Http1Codec.this.sink.b("\r\n");
      Http1Codec.this.sink.write(paramc, paramLong);
      Http1Codec.this.sink.b("\r\n");
    }
  }

  private class ChunkedSource extends Http1Codec.AbstractSource
  {
    private static final long NO_CHUNK_YET = -1L;
    private long bytesRemainingInChunk = -1L;
    private boolean hasMoreChunks = true;
    private final HttpUrl url;

    ChunkedSource(HttpUrl arg2)
    {
      super(null);
      Object localObject;
      this.url = localObject;
    }

    private void readChunkSize()
      throws IOException
    {
      if (this.bytesRemainingInChunk != -1L)
        Http1Codec.this.source.s();
      try
      {
        this.bytesRemainingInChunk = Http1Codec.this.source.p();
        String str = Http1Codec.this.source.s().trim();
        if ((this.bytesRemainingInChunk < 0L) || ((!str.isEmpty()) && (!str.startsWith(";"))))
          throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + str + "\"");
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new ProtocolException(localNumberFormatException.getMessage());
      }
      if (this.bytesRemainingInChunk == 0L)
      {
        this.hasMoreChunks = false;
        HttpHeaders.receiveHeaders(Http1Codec.this.client.cookieJar(), this.url, Http1Codec.this.readHeaders());
        endOfInput(true, null);
      }
    }

    public void close()
      throws IOException
    {
      if (this.closed)
        return;
      if ((this.hasMoreChunks) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS)))
        endOfInput(false, null);
      this.closed = true;
    }

    public long read(c paramc, long paramLong)
      throws IOException
    {
      if (paramLong < 0L)
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      if (this.closed)
        throw new IllegalStateException("closed");
      if (!this.hasMoreChunks);
      do
      {
        return -1L;
        if ((this.bytesRemainingInChunk != 0L) && (this.bytesRemainingInChunk != -1L))
          break;
        readChunkSize();
      }
      while (!this.hasMoreChunks);
      long l = super.read(paramc, Math.min(paramLong, this.bytesRemainingInChunk));
      if (l == -1L)
      {
        ProtocolException localProtocolException = new ProtocolException("unexpected end of stream");
        endOfInput(false, localProtocolException);
        throw localProtocolException;
      }
      this.bytesRemainingInChunk -= l;
      return l;
    }
  }

  private final class FixedLengthSink
    implements s
  {
    private long bytesRemaining;
    private boolean closed;
    private final i timeout = new i(Http1Codec.this.sink.timeout());

    FixedLengthSink(long arg2)
    {
      Object localObject;
      this.bytesRemaining = localObject;
    }

    public void close()
      throws IOException
    {
      if (this.closed)
        return;
      this.closed = true;
      if (this.bytesRemaining > 0L)
        throw new ProtocolException("unexpected end of stream");
      Http1Codec.this.detachTimeout(this.timeout);
      Http1Codec.this.state = 3;
    }

    public void flush()
      throws IOException
    {
      if (this.closed)
        return;
      Http1Codec.this.sink.flush();
    }

    public u timeout()
    {
      return this.timeout;
    }

    public void write(c paramc, long paramLong)
      throws IOException
    {
      if (this.closed)
        throw new IllegalStateException("closed");
      Util.checkOffsetAndCount(paramc.a(), 0L, paramLong);
      if (paramLong > this.bytesRemaining)
        throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + paramLong);
      Http1Codec.this.sink.write(paramc, paramLong);
      this.bytesRemaining -= paramLong;
    }
  }

  private class FixedLengthSource extends Http1Codec.AbstractSource
  {
    private long bytesRemaining;

    FixedLengthSource(long arg2)
      throws IOException
    {
      super(null);
      Object localObject;
      this.bytesRemaining = localObject;
      if (this.bytesRemaining == 0L)
        endOfInput(true, null);
    }

    public void close()
      throws IOException
    {
      if (this.closed)
        return;
      if ((this.bytesRemaining != 0L) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS)))
        endOfInput(false, null);
      this.closed = true;
    }

    public long read(c paramc, long paramLong)
      throws IOException
    {
      if (paramLong < 0L)
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      if (this.closed)
        throw new IllegalStateException("closed");
      if (this.bytesRemaining == 0L)
        return -1L;
      long l = super.read(paramc, Math.min(this.bytesRemaining, paramLong));
      if (l == -1L)
      {
        ProtocolException localProtocolException = new ProtocolException("unexpected end of stream");
        endOfInput(false, localProtocolException);
        throw localProtocolException;
      }
      this.bytesRemaining -= l;
      if (this.bytesRemaining == 0L)
        endOfInput(true, null);
      return l;
    }
  }

  private class UnknownLengthSource extends Http1Codec.AbstractSource
  {
    private boolean inputExhausted;

    UnknownLengthSource()
    {
      super(null);
    }

    public void close()
      throws IOException
    {
      if (this.closed)
        return;
      if (!this.inputExhausted)
        endOfInput(false, null);
      this.closed = true;
    }

    public long read(c paramc, long paramLong)
      throws IOException
    {
      if (paramLong < 0L)
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      if (this.closed)
        throw new IllegalStateException("closed");
      if (this.inputExhausted)
        return -1L;
      long l = super.read(paramc, paramLong);
      if (l == -1L)
      {
        this.inputExhausted = true;
        endOfInput(true, null);
        return -1L;
      }
      return l;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.http1.Http1Codec
 * JD-Core Version:    0.6.2
 */
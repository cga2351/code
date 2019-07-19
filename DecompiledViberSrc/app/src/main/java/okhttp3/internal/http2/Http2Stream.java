package okhttp3.internal.http2;

import f.a;
import f.c;
import f.e;
import f.s;
import f.t;
import f.u;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public final class Http2Stream
{
  long bytesLeftInWriteWindow;
  final Http2Connection connection;
  ErrorCode errorCode = null;
  private boolean hasResponseHeaders;
  final int id;
  final StreamTimeout readTimeout = new StreamTimeout();
  private final List<Header> requestHeaders;
  private List<Header> responseHeaders;
  final FramingSink sink;
  private final FramingSource source;
  long unacknowledgedBytesRead = 0L;
  final StreamTimeout writeTimeout = new StreamTimeout();

  static
  {
    if (!Http2Stream.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }

  Http2Stream(int paramInt, Http2Connection paramHttp2Connection, boolean paramBoolean1, boolean paramBoolean2, List<Header> paramList)
  {
    if (paramHttp2Connection == null)
      throw new NullPointerException("connection == null");
    if (paramList == null)
      throw new NullPointerException("requestHeaders == null");
    this.id = paramInt;
    this.connection = paramHttp2Connection;
    this.bytesLeftInWriteWindow = paramHttp2Connection.peerSettings.getInitialWindowSize();
    this.source = new FramingSource(paramHttp2Connection.okHttpSettings.getInitialWindowSize());
    this.sink = new FramingSink();
    this.source.finished = paramBoolean2;
    this.sink.finished = paramBoolean1;
    this.requestHeaders = paramList;
  }

  private boolean closeInternal(ErrorCode paramErrorCode)
  {
    assert (!Thread.holdsLock(this));
    try
    {
      if (this.errorCode != null)
        return false;
      if ((this.source.finished) && (this.sink.finished))
        return false;
    }
    finally
    {
    }
    this.errorCode = paramErrorCode;
    notifyAll();
    this.connection.removeStream(this.id);
    return true;
  }

  void addBytesToWriteWindow(long paramLong)
  {
    this.bytesLeftInWriteWindow = (paramLong + this.bytesLeftInWriteWindow);
    if (paramLong > 0L)
      notifyAll();
  }

  void cancelStreamIfNecessary()
    throws IOException
  {
    assert (!Thread.holdsLock(this));
    while (true)
    {
      boolean bool;
      int i;
      try
      {
        if ((!this.source.finished) && (this.source.closed))
        {
          if (this.sink.finished)
            break label112;
          if (this.sink.closed)
          {
            break label112;
            bool = isOpen();
            if (i == 0)
              break label95;
            close(ErrorCode.CANCEL);
            return;
          }
        }
        i = 0;
        continue;
      }
      finally
      {
      }
      label95: if (!bool)
      {
        this.connection.removeStream(this.id);
        return;
        label112: i = 1;
      }
    }
  }

  void checkOutNotClosed()
    throws IOException
  {
    if (this.sink.closed)
      throw new IOException("stream closed");
    if (this.sink.finished)
      throw new IOException("stream finished");
    if (this.errorCode != null)
      throw new StreamResetException(this.errorCode);
  }

  public void close(ErrorCode paramErrorCode)
    throws IOException
  {
    if (!closeInternal(paramErrorCode))
      return;
    this.connection.writeSynReset(this.id, paramErrorCode);
  }

  public void closeLater(ErrorCode paramErrorCode)
  {
    if (!closeInternal(paramErrorCode))
      return;
    this.connection.writeSynResetLater(this.id, paramErrorCode);
  }

  public Http2Connection getConnection()
  {
    return this.connection;
  }

  public ErrorCode getErrorCode()
  {
    try
    {
      ErrorCode localErrorCode = this.errorCode;
      return localErrorCode;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int getId()
  {
    return this.id;
  }

  public List<Header> getRequestHeaders()
  {
    return this.requestHeaders;
  }

  public s getSink()
  {
    try
    {
      if ((!this.hasResponseHeaders) && (!isLocallyInitiated()))
        throw new IllegalStateException("reply before requesting the sink");
    }
    finally
    {
    }
    return this.sink;
  }

  public t getSource()
  {
    return this.source;
  }

  public boolean isLocallyInitiated()
  {
    if ((0x1 & this.id) == 1);
    for (int i = 1; this.connection.client == i; i = 0)
      return true;
    return false;
  }

  public boolean isOpen()
  {
    try
    {
      ErrorCode localErrorCode = this.errorCode;
      boolean bool1 = false;
      if (localErrorCode != null);
      while (true)
      {
        return bool1;
        if (((this.source.finished) || (this.source.closed)) && ((this.sink.finished) || (this.sink.closed)))
        {
          boolean bool2 = this.hasResponseHeaders;
          bool1 = false;
          if (bool2);
        }
        else
        {
          bool1 = true;
        }
      }
    }
    finally
    {
    }
  }

  public u readTimeout()
  {
    return this.readTimeout;
  }

  void receiveData(e parame, int paramInt)
    throws IOException
  {
    assert (!Thread.holdsLock(this));
    this.source.receive(parame, paramInt);
  }

  void receiveFin()
  {
    assert (!Thread.holdsLock(this));
    try
    {
      this.source.finished = true;
      boolean bool = isOpen();
      notifyAll();
      if (!bool)
        this.connection.removeStream(this.id);
      return;
    }
    finally
    {
    }
  }

  void receiveHeaders(List<Header> paramList)
  {
    boolean bool = true;
    assert (!Thread.holdsLock(this));
    try
    {
      this.hasResponseHeaders = true;
      if (this.responseHeaders == null)
      {
        this.responseHeaders = paramList;
        bool = isOpen();
        notifyAll();
      }
      while (true)
      {
        if (!bool)
          this.connection.removeStream(this.id);
        return;
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(this.responseHeaders);
        localArrayList.add(null);
        localArrayList.addAll(paramList);
        this.responseHeaders = localArrayList;
      }
    }
    finally
    {
    }
  }

  void receiveRstStream(ErrorCode paramErrorCode)
  {
    try
    {
      if (this.errorCode == null)
      {
        this.errorCode = paramErrorCode;
        notifyAll();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void sendResponseHeaders(List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    boolean bool = true;
    assert (!Thread.holdsLock(this));
    if (paramList == null)
      throw new NullPointerException("responseHeaders == null");
    while (true)
    {
      try
      {
        this.hasResponseHeaders = true;
        if (!paramBoolean)
        {
          this.sink.finished = true;
          this.connection.writeSynReply(this.id, bool, paramList);
          if (bool)
            this.connection.flush();
          return;
        }
      }
      finally
      {
      }
      bool = false;
    }
  }

  public List<Header> takeResponseHeaders()
    throws IOException
  {
    try
    {
      if (!isLocallyInitiated())
        throw new IllegalStateException("servers cannot read response headers");
    }
    finally
    {
    }
    this.readTimeout.enter();
    try
    {
      if ((this.responseHeaders == null) && (this.errorCode == null))
        waitForIo();
    }
    finally
    {
      this.readTimeout.exitAndThrowIfTimedOut();
    }
    List localList = this.responseHeaders;
    if (localList != null)
    {
      this.responseHeaders = null;
      return localList;
    }
    throw new StreamResetException(this.errorCode);
  }

  void waitForIo()
    throws InterruptedIOException
  {
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
    throw new InterruptedIOException();
  }

  public u writeTimeout()
  {
    return this.writeTimeout;
  }

  final class FramingSink
    implements s
  {
    private static final long EMIT_BUFFER_SIZE = 16384L;
    boolean closed;
    boolean finished;
    private final c sendBuffer = new c();

    static
    {
      if (!Http2Stream.class.desiredAssertionStatus());
      for (boolean bool = true; ; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }

    FramingSink()
    {
    }

    private void emitFrame(boolean paramBoolean)
      throws IOException
    {
      synchronized (Http2Stream.this)
      {
        Http2Stream.this.writeTimeout.enter();
      }
      Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
      Http2Stream.this.checkOutNotClosed();
      long l = Math.min(Http2Stream.this.bytesLeftInWriteWindow, this.sendBuffer.a());
      Http2Stream localHttp2Stream2 = Http2Stream.this;
      localHttp2Stream2.bytesLeftInWriteWindow -= l;
      Http2Stream.this.writeTimeout.enter();
      try
      {
        Http2Connection localHttp2Connection = Http2Stream.this.connection;
        int i = Http2Stream.this.id;
        if ((paramBoolean) && (l == this.sendBuffer.a()));
        for (boolean bool = true; ; bool = false)
        {
          localHttp2Connection.writeData(i, bool, this.sendBuffer, l);
          return;
        }
      }
      finally
      {
        Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
      }
    }

    public void close()
      throws IOException
    {
      assert (!Thread.holdsLock(Http2Stream.this));
      synchronized (Http2Stream.this)
      {
        if (this.closed)
          return;
        if (Http2Stream.this.sink.finished)
          break label113;
        if (this.sendBuffer.a() > 0L)
        {
          if (this.sendBuffer.a() <= 0L)
            break label113;
          emitFrame(true);
        }
      }
      Http2Stream.this.connection.writeData(Http2Stream.this.id, true, null, 0L);
      label113: synchronized (Http2Stream.this)
      {
        this.closed = true;
        Http2Stream.this.connection.flush();
        Http2Stream.this.cancelStreamIfNecessary();
        return;
      }
    }

    public void flush()
      throws IOException
    {
      assert (!Thread.holdsLock(Http2Stream.this));
      synchronized (Http2Stream.this)
      {
        Http2Stream.this.checkOutNotClosed();
        if (this.sendBuffer.a() > 0L)
        {
          emitFrame(false);
          Http2Stream.this.connection.flush();
        }
      }
    }

    public u timeout()
    {
      return Http2Stream.this.writeTimeout;
    }

    public void write(c paramc, long paramLong)
      throws IOException
    {
      assert (!Thread.holdsLock(Http2Stream.this));
      this.sendBuffer.write(paramc, paramLong);
      while (this.sendBuffer.a() >= 16384L)
        emitFrame(false);
    }
  }

  private final class FramingSource
    implements t
  {
    boolean closed;
    boolean finished;
    private final long maxByteCount;
    private final c readBuffer = new c();
    private final c receiveBuffer = new c();

    static
    {
      if (!Http2Stream.class.desiredAssertionStatus());
      for (boolean bool = true; ; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }

    FramingSource(long arg2)
    {
      Object localObject;
      this.maxByteCount = localObject;
    }

    private void checkNotClosed()
      throws IOException
    {
      if (this.closed)
        throw new IOException("stream closed");
      if (Http2Stream.this.errorCode != null)
        throw new StreamResetException(Http2Stream.this.errorCode);
    }

    private void waitUntilReadable()
      throws IOException
    {
      Http2Stream.this.readTimeout.enter();
      try
      {
        if (this.readBuffer.a() == 0L)
          if ((!this.finished) && (!this.closed) && (Http2Stream.this.errorCode == null))
            Http2Stream.this.waitForIo();
      }
      finally
      {
        Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
      }
    }

    public void close()
      throws IOException
    {
      synchronized (Http2Stream.this)
      {
        this.closed = true;
        this.readBuffer.v();
        Http2Stream.this.notifyAll();
        Http2Stream.this.cancelStreamIfNecessary();
        return;
      }
    }

    public long read(c paramc, long paramLong)
      throws IOException
    {
      if (paramLong < 0L)
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      synchronized (Http2Stream.this)
      {
        waitUntilReadable();
        checkNotClosed();
        if (this.readBuffer.a() == 0L)
          return -1L;
        long l = this.readBuffer.read(paramc, Math.min(paramLong, this.readBuffer.a()));
        Http2Stream localHttp2Stream2 = Http2Stream.this;
        localHttp2Stream2.unacknowledgedBytesRead = (l + localHttp2Stream2.unacknowledgedBytesRead);
        if (Http2Stream.this.unacknowledgedBytesRead >= Http2Stream.this.connection.okHttpSettings.getInitialWindowSize() / 2)
        {
          Http2Stream.this.connection.writeWindowUpdateLater(Http2Stream.this.id, Http2Stream.this.unacknowledgedBytesRead);
          Http2Stream.this.unacknowledgedBytesRead = 0L;
        }
        synchronized (Http2Stream.this.connection)
        {
          Http2Connection localHttp2Connection2 = Http2Stream.this.connection;
          localHttp2Connection2.unacknowledgedBytesRead = (l + localHttp2Connection2.unacknowledgedBytesRead);
          if (Http2Stream.this.connection.unacknowledgedBytesRead >= Http2Stream.this.connection.okHttpSettings.getInitialWindowSize() / 2)
          {
            Http2Stream.this.connection.writeWindowUpdateLater(0, Http2Stream.this.connection.unacknowledgedBytesRead);
            Http2Stream.this.connection.unacknowledgedBytesRead = 0L;
          }
          return l;
        }
      }
    }

    void receive(e parame, long paramLong)
      throws IOException
    {
      if ((!$assertionsDisabled) && (Thread.holdsLock(Http2Stream.this)))
        throw new AssertionError();
      while (true)
      {
        Object localObject2;
        paramLong -= localObject2;
        synchronized (Http2Stream.this)
        {
          if (this.readBuffer.a() == 0L)
          {
            j = 1;
            this.readBuffer.a(this.receiveBuffer);
            if (j != 0)
              Http2Stream.this.notifyAll();
            if (paramLong > 0L);
            boolean bool;
            synchronized (Http2Stream.this)
            {
              bool = this.finished;
              int i;
              if (paramLong + this.readBuffer.a() > this.maxByteCount)
              {
                i = 1;
                if (i != 0)
                {
                  parame.i(paramLong);
                  Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                }
              }
              else
              {
                i = 0;
              }
            }
            if (bool)
            {
              parame.i(paramLong);
              return;
            }
            long l = parame.read(this.receiveBuffer, paramLong);
            if (l != -1L)
              continue;
            throw new EOFException();
          }
          int j = 0;
        }
      }
    }

    public u timeout()
    {
      return Http2Stream.this.readTimeout;
    }
  }

  class StreamTimeout extends a
  {
    StreamTimeout()
    {
    }

    public void exitAndThrowIfTimedOut()
      throws IOException
    {
      if (exit())
        throw newTimeoutException(null);
    }

    protected IOException newTimeoutException(IOException paramIOException)
    {
      SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
      if (paramIOException != null)
        localSocketTimeoutException.initCause(paramIOException);
      return localSocketTimeoutException;
    }

    protected void timedOut()
    {
      Http2Stream.this.closeLater(ErrorCode.CANCEL);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Stream
 * JD-Core Version:    0.6.2
 */
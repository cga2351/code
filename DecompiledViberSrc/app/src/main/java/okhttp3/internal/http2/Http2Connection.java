package okhttp3.internal.http2;

import f.c;
import f.d;
import f.e;
import f.f;
import f.l;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

public final class Http2Connection
  implements Closeable
{
  private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
  private static final ExecutorService listenerExecutor;
  private boolean awaitingPong;
  long bytesLeftInWriteWindow;
  final boolean client;
  final Set<Integer> currentPushRequests = new LinkedHashSet();
  final String hostname;
  int lastGoodStreamId;
  final Listener listener;
  int nextStreamId;
  Settings okHttpSettings = new Settings();
  final Settings peerSettings = new Settings();
  private final ExecutorService pushExecutor;
  final PushObserver pushObserver;
  final ReaderRunnable readerRunnable;
  boolean receivedInitialPeerSettings = false;
  boolean shutdown;
  final Socket socket;
  final Map<Integer, Http2Stream> streams = new LinkedHashMap();
  long unacknowledgedBytesRead = 0L;
  final Http2Writer writer;
  private final ScheduledExecutorService writerExecutor;

  static
  {
    if (!Http2Connection.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      listenerExecutor = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
      return;
    }
  }

  Http2Connection(Builder paramBuilder)
  {
    this.pushObserver = paramBuilder.pushObserver;
    this.client = paramBuilder.client;
    this.listener = paramBuilder.listener;
    if (paramBuilder.client);
    for (int i = 1; ; i = 2)
    {
      this.nextStreamId = i;
      if (paramBuilder.client)
        this.nextStreamId = (2 + this.nextStreamId);
      if (paramBuilder.client)
        this.okHttpSettings.set(7, 16777216);
      this.hostname = paramBuilder.hostname;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = this.hostname;
      this.writerExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", arrayOfObject1), false));
      if (paramBuilder.pingIntervalMillis != 0)
        this.writerExecutor.scheduleAtFixedRate(new PingRunnable(false, 0, 0), paramBuilder.pingIntervalMillis, paramBuilder.pingIntervalMillis, TimeUnit.MILLISECONDS);
      TimeUnit localTimeUnit = TimeUnit.SECONDS;
      LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue();
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.hostname;
      this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, localTimeUnit, localLinkedBlockingQueue, Util.threadFactory(Util.format("OkHttp %s Push Observer", arrayOfObject2), true));
      this.peerSettings.set(7, 65535);
      this.peerSettings.set(5, 16384);
      this.bytesLeftInWriteWindow = this.peerSettings.getInitialWindowSize();
      this.socket = paramBuilder.socket;
      this.writer = new Http2Writer(paramBuilder.sink, this.client);
      this.readerRunnable = new ReaderRunnable(new Http2Reader(paramBuilder.source, this.client));
      return;
    }
  }

  private void failConnection()
  {
    try
    {
      close(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  private Http2Stream newStream(int paramInt, List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    if (!paramBoolean);
    for (boolean bool1 = true; ; bool1 = false)
      synchronized (this.writer)
      {
        try
        {
          if (this.nextStreamId > 1073741823)
            shutdown(ErrorCode.REFUSED_STREAM);
          if (!this.shutdown)
            break;
          throw new ConnectionShutdownException();
        }
        finally
        {
        }
      }
    int i = this.nextStreamId;
    this.nextStreamId = (2 + this.nextStreamId);
    Http2Stream localHttp2Stream = new Http2Stream(i, this, bool1, false, paramList);
    int j;
    if ((paramBoolean) && (this.bytesLeftInWriteWindow != 0L))
    {
      boolean bool2 = localHttp2Stream.bytesLeftInWriteWindow < 0L;
      j = 0;
      if (!bool2);
    }
    while (true)
    {
      if (localHttp2Stream.isOpen())
        this.streams.put(Integer.valueOf(i), localHttp2Stream);
      if (paramInt == 0)
        this.writer.synStream(bool1, i, paramInt, paramList);
      while (true)
      {
        if (j != 0)
          this.writer.flush();
        return localHttp2Stream;
        if (this.client)
          throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
        this.writer.pushPromise(paramInt, i, paramList);
      }
      j = 1;
    }
  }

  void addBytesToWriteWindow(long paramLong)
  {
    this.bytesLeftInWriteWindow = (paramLong + this.bytesLeftInWriteWindow);
    if (paramLong > 0L)
      notifyAll();
  }

  void awaitPong()
    throws IOException, InterruptedException
  {
    try
    {
      if (this.awaitingPong)
        wait();
    }
    finally
    {
    }
  }

  public void close()
    throws IOException
  {
    close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
  }

  // ERROR //
  void close(ErrorCode paramErrorCode1, ErrorCode paramErrorCode2)
    throws IOException
  {
    // Byte code:
    //   0: getstatic 57	okhttp3/internal/http2/Http2Connection:$assertionsDisabled	Z
    //   3: ifne +18 -> 21
    //   6: aload_0
    //   7: invokestatic 304	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   10: ifeq +11 -> 21
    //   13: new 306	java/lang/AssertionError
    //   16: dup
    //   17: invokespecial 307	java/lang/AssertionError:<init>	()V
    //   20: athrow
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 237	okhttp3/internal/http2/Http2Connection:shutdown	(Lokhttp3/internal/http2/ErrorCode;)V
    //   26: aconst_null
    //   27: astore_3
    //   28: aload_0
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 93	okhttp3/internal/http2/Http2Connection:streams	Ljava/util/Map;
    //   34: invokeinterface 310 1 0
    //   39: ifne +180 -> 219
    //   42: aload_0
    //   43: getfield 93	okhttp3/internal/http2/Http2Connection:streams	Ljava/util/Map;
    //   46: invokeinterface 314 1 0
    //   51: aload_0
    //   52: getfield 93	okhttp3/internal/http2/Http2Connection:streams	Ljava/util/Map;
    //   55: invokeinterface 317 1 0
    //   60: anewarray 244	okhttp3/internal/http2/Http2Stream
    //   63: invokeinterface 323 2 0
    //   68: checkcast 325	[Lokhttp3/internal/http2/Http2Stream;
    //   71: astore 12
    //   73: aload_0
    //   74: getfield 93	okhttp3/internal/http2/Http2Connection:streams	Ljava/util/Map;
    //   77: invokeinterface 328 1 0
    //   82: aload 12
    //   84: astore 5
    //   86: aload_0
    //   87: monitorexit
    //   88: aload 5
    //   90: ifnull +64 -> 154
    //   93: aload 5
    //   95: arraylength
    //   96: istore 7
    //   98: iconst_0
    //   99: istore 8
    //   101: aload_3
    //   102: astore 9
    //   104: iload 8
    //   106: iload 7
    //   108: if_icmpge +43 -> 151
    //   111: aload 5
    //   113: iload 8
    //   115: aaload
    //   116: astore 10
    //   118: aload 10
    //   120: aload_2
    //   121: invokevirtual 330	okhttp3/internal/http2/Http2Stream:close	(Lokhttp3/internal/http2/ErrorCode;)V
    //   124: iinc 8 1
    //   127: goto -23 -> 104
    //   130: astore 4
    //   132: aload_0
    //   133: monitorexit
    //   134: aload 4
    //   136: athrow
    //   137: astore 11
    //   139: aload 9
    //   141: ifnull -17 -> 124
    //   144: aload 11
    //   146: astore 9
    //   148: goto -24 -> 124
    //   151: aload 9
    //   153: astore_3
    //   154: aload_0
    //   155: getfield 187	okhttp3/internal/http2/Http2Connection:writer	Lokhttp3/internal/http2/Http2Writer;
    //   158: invokevirtual 332	okhttp3/internal/http2/Http2Writer:close	()V
    //   161: aload_3
    //   162: astore 6
    //   164: aload_0
    //   165: getfield 176	okhttp3/internal/http2/Http2Connection:socket	Ljava/net/Socket;
    //   168: invokevirtual 335	java/net/Socket:close	()V
    //   171: aload_0
    //   172: getfield 142	okhttp3/internal/http2/Http2Connection:writerExecutor	Ljava/util/concurrent/ScheduledExecutorService;
    //   175: invokeinterface 337 1 0
    //   180: aload_0
    //   181: getfield 166	okhttp3/internal/http2/Http2Connection:pushExecutor	Ljava/util/concurrent/ExecutorService;
    //   184: invokeinterface 340 1 0
    //   189: aload 6
    //   191: ifnull +22 -> 213
    //   194: aload 6
    //   196: athrow
    //   197: astore 6
    //   199: aload_3
    //   200: ifnull -36 -> 164
    //   203: aload_3
    //   204: astore 6
    //   206: goto -42 -> 164
    //   209: astore_3
    //   210: goto -182 -> 28
    //   213: return
    //   214: astore 6
    //   216: goto -45 -> 171
    //   219: aconst_null
    //   220: astore 5
    //   222: goto -136 -> 86
    //
    // Exception table:
    //   from	to	target	type
    //   30	82	130	finally
    //   86	88	130	finally
    //   132	134	130	finally
    //   118	124	137	java/io/IOException
    //   154	161	197	java/io/IOException
    //   21	26	209	java/io/IOException
    //   164	171	214	java/io/IOException
  }

  public void flush()
    throws IOException
  {
    this.writer.flush();
  }

  public Protocol getProtocol()
  {
    return Protocol.HTTP_2;
  }

  Http2Stream getStream(int paramInt)
  {
    try
    {
      Http2Stream localHttp2Stream = (Http2Stream)this.streams.get(Integer.valueOf(paramInt));
      return localHttp2Stream;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean isShutdown()
  {
    try
    {
      boolean bool = this.shutdown;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int maxConcurrentStreams()
  {
    try
    {
      int i = this.peerSettings.getMaxConcurrentStreams(2147483647);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Http2Stream newStream(List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    return newStream(0, paramList, paramBoolean);
  }

  public int openStreamCount()
  {
    try
    {
      int i = this.streams.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void pushDataLater(final int paramInt1, e parame, final int paramInt2, final boolean paramBoolean)
    throws IOException
  {
    final c localc = new c();
    parame.a(paramInt2);
    parame.read(localc, paramInt2);
    if (localc.a() != paramInt2)
      throw new IOException(localc.a() + " != " + paramInt2);
    ExecutorService localExecutorService = this.pushExecutor;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.hostname;
    arrayOfObject[1] = Integer.valueOf(paramInt1);
    localExecutorService.execute(new NamedRunnable("OkHttp %s Push Data[%s]", arrayOfObject)
    {
      public void execute()
      {
        try
        {
          boolean bool = Http2Connection.this.pushObserver.onData(paramInt1, localc, paramInt2, paramBoolean);
          if (bool)
            Http2Connection.this.writer.rstStream(paramInt1, ErrorCode.CANCEL);
          if ((bool) || (paramBoolean))
            synchronized (Http2Connection.this)
            {
              Http2Connection.this.currentPushRequests.remove(Integer.valueOf(paramInt1));
              return;
            }
        }
        catch (IOException localIOException)
        {
        }
      }
    });
  }

  void pushHeadersLater(final int paramInt, final List<Header> paramList, final boolean paramBoolean)
  {
    try
    {
      ExecutorService localExecutorService = this.pushExecutor;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.hostname;
      arrayOfObject[1] = Integer.valueOf(paramInt);
      localExecutorService.execute(new NamedRunnable("OkHttp %s Push Headers[%s]", arrayOfObject)
      {
        public void execute()
        {
          boolean bool = Http2Connection.this.pushObserver.onHeaders(paramInt, paramList, paramBoolean);
          if (bool);
          try
          {
            Http2Connection.this.writer.rstStream(paramInt, ErrorCode.CANCEL);
            if ((bool) || (paramBoolean))
              synchronized (Http2Connection.this)
              {
                Http2Connection.this.currentPushRequests.remove(Integer.valueOf(paramInt));
                return;
              }
          }
          catch (IOException localIOException)
          {
          }
        }
      });
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
    }
  }

  void pushRequestLater(final int paramInt, final List<Header> paramList)
  {
    try
    {
      if (this.currentPushRequests.contains(Integer.valueOf(paramInt)))
      {
        writeSynResetLater(paramInt, ErrorCode.PROTOCOL_ERROR);
        return;
      }
      this.currentPushRequests.add(Integer.valueOf(paramInt));
      try
      {
        ExecutorService localExecutorService = this.pushExecutor;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = this.hostname;
        arrayOfObject[1] = Integer.valueOf(paramInt);
        localExecutorService.execute(new NamedRunnable("OkHttp %s Push Request[%s]", arrayOfObject)
        {
          public void execute()
          {
            if (Http2Connection.this.pushObserver.onRequest(paramInt, paramList))
              try
              {
                Http2Connection.this.writer.rstStream(paramInt, ErrorCode.CANCEL);
                synchronized (Http2Connection.this)
                {
                  Http2Connection.this.currentPushRequests.remove(Integer.valueOf(paramInt));
                  return;
                }
              }
              catch (IOException localIOException)
              {
              }
          }
        });
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
      }
    }
    finally
    {
    }
  }

  void pushResetLater(final int paramInt, final ErrorCode paramErrorCode)
  {
    ExecutorService localExecutorService = this.pushExecutor;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.hostname;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    localExecutorService.execute(new NamedRunnable("OkHttp %s Push Reset[%s]", arrayOfObject)
    {
      public void execute()
      {
        Http2Connection.this.pushObserver.onReset(paramInt, paramErrorCode);
        synchronized (Http2Connection.this)
        {
          Http2Connection.this.currentPushRequests.remove(Integer.valueOf(paramInt));
          return;
        }
      }
    });
  }

  public Http2Stream pushStream(int paramInt, List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    if (this.client)
      throw new IllegalStateException("Client cannot push requests.");
    return newStream(paramInt, paramList, paramBoolean);
  }

  boolean pushedStream(int paramInt)
  {
    return (paramInt != 0) && ((paramInt & 0x1) == 0);
  }

  Http2Stream removeStream(int paramInt)
  {
    try
    {
      Http2Stream localHttp2Stream = (Http2Stream)this.streams.remove(Integer.valueOf(paramInt));
      notifyAll();
      return localHttp2Stream;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setSettings(Settings paramSettings)
    throws IOException
  {
    synchronized (this.writer)
    {
      try
      {
        if (this.shutdown)
          throw new ConnectionShutdownException();
      }
      finally
      {
      }
    }
    this.okHttpSettings.merge(paramSettings);
    this.writer.settings(paramSettings);
  }

  public void shutdown(ErrorCode paramErrorCode)
    throws IOException
  {
    synchronized (this.writer)
    {
    }
    try
    {
      if (this.shutdown)
        return;
      this.shutdown = true;
      int i = this.lastGoodStreamId;
      this.writer.goAway(i, paramErrorCode, Util.EMPTY_BYTE_ARRAY);
      return;
      localObject1 = finally;
      throw localObject1;
    }
    finally
    {
    }
  }

  public void start()
    throws IOException
  {
    start(true);
  }

  void start(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean)
    {
      this.writer.connectionPreface();
      this.writer.settings(this.okHttpSettings);
      int i = this.okHttpSettings.getInitialWindowSize();
      if (i != 65535)
        this.writer.windowUpdate(0, i - 65535);
    }
    new Thread(this.readerRunnable).start();
  }

  public void writeData(int paramInt, boolean paramBoolean, c paramc, long paramLong)
    throws IOException
  {
    if (paramLong == 0L)
    {
      this.writer.data(paramBoolean, paramInt, paramc, 0);
      return;
    }
    while (true)
    {
      try
      {
        int i = Math.min((int)Math.min(paramLong, this.bytesLeftInWriteWindow), this.writer.maxDataLength());
        this.bytesLeftInWriteWindow -= i;
        paramLong -= i;
        Http2Writer localHttp2Writer = this.writer;
        if ((!paramBoolean) || (paramLong != 0L))
          break label163;
        bool = true;
        localHttp2Writer.data(bool, paramInt, paramc, i);
        if (paramLong <= 0L)
          break;
        try
        {
          if (this.bytesLeftInWriteWindow > 0L)
            continue;
          if (!this.streams.containsKey(Integer.valueOf(paramInt)))
            throw new IOException("stream closed");
        }
        catch (InterruptedException localInterruptedException)
        {
          throw new InterruptedIOException();
        }
      }
      finally
      {
      }
      wait();
      continue;
      label163: boolean bool = false;
    }
  }

  void writePing(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!paramBoolean)
      try
      {
        boolean bool = this.awaitingPong;
        this.awaitingPong = true;
        if (bool)
        {
          failConnection();
          return;
        }
      }
      finally
      {
      }
    try
    {
      this.writer.ping(paramBoolean, paramInt1, paramInt2);
      return;
    }
    catch (IOException localIOException)
    {
      failConnection();
    }
  }

  void writePingAndAwaitPong()
    throws IOException, InterruptedException
  {
    writePing(false, 1330343787, -257978967);
    awaitPong();
  }

  void writeSynReply(int paramInt, boolean paramBoolean, List<Header> paramList)
    throws IOException
  {
    this.writer.synReply(paramBoolean, paramInt, paramList);
  }

  void writeSynReset(int paramInt, ErrorCode paramErrorCode)
    throws IOException
  {
    this.writer.rstStream(paramInt, paramErrorCode);
  }

  void writeSynResetLater(final int paramInt, final ErrorCode paramErrorCode)
  {
    try
    {
      ScheduledExecutorService localScheduledExecutorService = this.writerExecutor;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.hostname;
      arrayOfObject[1] = Integer.valueOf(paramInt);
      localScheduledExecutorService.execute(new NamedRunnable("OkHttp %s stream %d", arrayOfObject)
      {
        public void execute()
        {
          try
          {
            Http2Connection.this.writeSynReset(paramInt, paramErrorCode);
            return;
          }
          catch (IOException localIOException)
          {
            Http2Connection.this.failConnection();
          }
        }
      });
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
    }
  }

  void writeWindowUpdateLater(final int paramInt, final long paramLong)
  {
    try
    {
      ScheduledExecutorService localScheduledExecutorService = this.writerExecutor;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.hostname;
      arrayOfObject[1] = Integer.valueOf(paramInt);
      localScheduledExecutorService.execute(new NamedRunnable("OkHttp Window Update %s stream %d", arrayOfObject)
      {
        public void execute()
        {
          try
          {
            Http2Connection.this.writer.windowUpdate(paramInt, paramLong);
            return;
          }
          catch (IOException localIOException)
          {
            Http2Connection.this.failConnection();
          }
        }
      });
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
    }
  }

  public static class Builder
  {
    boolean client;
    String hostname;
    Http2Connection.Listener listener = Http2Connection.Listener.REFUSE_INCOMING_STREAMS;
    int pingIntervalMillis;
    PushObserver pushObserver = PushObserver.CANCEL;
    d sink;
    Socket socket;
    e source;

    public Builder(boolean paramBoolean)
    {
      this.client = paramBoolean;
    }

    public Http2Connection build()
    {
      return new Http2Connection(this);
    }

    public Builder listener(Http2Connection.Listener paramListener)
    {
      this.listener = paramListener;
      return this;
    }

    public Builder pingIntervalMillis(int paramInt)
    {
      this.pingIntervalMillis = paramInt;
      return this;
    }

    public Builder pushObserver(PushObserver paramPushObserver)
    {
      this.pushObserver = paramPushObserver;
      return this;
    }

    public Builder socket(Socket paramSocket)
      throws IOException
    {
      return socket(paramSocket, ((InetSocketAddress)paramSocket.getRemoteSocketAddress()).getHostName(), l.a(l.b(paramSocket)), l.a(l.a(paramSocket)));
    }

    public Builder socket(Socket paramSocket, String paramString, e parame, d paramd)
    {
      this.socket = paramSocket;
      this.hostname = paramString;
      this.source = parame;
      this.sink = paramd;
      return this;
    }
  }

  public static abstract class Listener
  {
    public static final Listener REFUSE_INCOMING_STREAMS = new Listener()
    {
      public void onStream(Http2Stream paramAnonymousHttp2Stream)
        throws IOException
      {
        paramAnonymousHttp2Stream.close(ErrorCode.REFUSED_STREAM);
      }
    };

    public void onSettings(Http2Connection paramHttp2Connection)
    {
    }

    public abstract void onStream(Http2Stream paramHttp2Stream)
      throws IOException;
  }

  final class PingRunnable extends NamedRunnable
  {
    final int payload1;
    final int payload2;
    final boolean reply;

    PingRunnable(boolean paramInt1, int paramInt2, int arg4)
    {
      super(arrayOfObject);
      this.reply = paramInt1;
      this.payload1 = paramInt2;
      this.payload2 = i;
    }

    public void execute()
    {
      Http2Connection.this.writePing(this.reply, this.payload1, this.payload2);
    }
  }

  class ReaderRunnable extends NamedRunnable
    implements Http2Reader.Handler
  {
    final Http2Reader reader;

    ReaderRunnable(Http2Reader arg2)
    {
      super(arrayOfObject);
      Object localObject;
      this.reader = localObject;
    }

    private void applyAndAckSettings(final Settings paramSettings)
    {
      try
      {
        ScheduledExecutorService localScheduledExecutorService = Http2Connection.this.writerExecutor;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Http2Connection.this.hostname;
        localScheduledExecutorService.execute(new NamedRunnable("OkHttp %s ACK Settings", arrayOfObject)
        {
          public void execute()
          {
            try
            {
              Http2Connection.this.writer.applyAndAckSettings(paramSettings);
              return;
            }
            catch (IOException localIOException)
            {
              Http2Connection.this.failConnection();
            }
          }
        });
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
      }
    }

    public void ackSettings()
    {
    }

    public void alternateService(int paramInt1, String paramString1, f paramf, String paramString2, int paramInt2, long paramLong)
    {
    }

    public void data(boolean paramBoolean, int paramInt1, e parame, int paramInt2)
      throws IOException
    {
      if (Http2Connection.this.pushedStream(paramInt1))
        Http2Connection.this.pushDataLater(paramInt1, parame, paramInt2, paramBoolean);
      Http2Stream localHttp2Stream;
      do
      {
        return;
        localHttp2Stream = Http2Connection.this.getStream(paramInt1);
        if (localHttp2Stream == null)
        {
          Http2Connection.this.writeSynResetLater(paramInt1, ErrorCode.PROTOCOL_ERROR);
          parame.i(paramInt2);
          return;
        }
        localHttp2Stream.receiveData(parame, paramInt2);
      }
      while (!paramBoolean);
      localHttp2Stream.receiveFin();
    }

    // ERROR //
    protected void execute()
    {
      // Byte code:
      //   0: getstatic 98	okhttp3/internal/http2/ErrorCode:INTERNAL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   3: astore_1
      //   4: getstatic 98	okhttp3/internal/http2/ErrorCode:INTERNAL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   7: astore_2
      //   8: aload_0
      //   9: getfield 29	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   12: aload_0
      //   13: invokevirtual 104	okhttp3/internal/http2/Http2Reader:readConnectionPreface	(Lokhttp3/internal/http2/Http2Reader$Handler;)V
      //   16: aload_0
      //   17: getfield 29	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   20: iconst_0
      //   21: aload_0
      //   22: invokevirtual 108	okhttp3/internal/http2/Http2Reader:nextFrame	(ZLokhttp3/internal/http2/Http2Reader$Handler;)Z
      //   25: ifne -9 -> 16
      //   28: getstatic 111	okhttp3/internal/http2/ErrorCode:NO_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   31: astore_1
      //   32: getstatic 114	okhttp3/internal/http2/ErrorCode:CANCEL	Lokhttp3/internal/http2/ErrorCode;
      //   35: astore 10
      //   37: aload_0
      //   38: getfield 14	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   41: aload_1
      //   42: aload 10
      //   44: invokevirtual 118	okhttp3/internal/http2/Http2Connection:close	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
      //   47: aload_0
      //   48: getfield 29	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   51: invokestatic 124	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   54: return
      //   55: astore 7
      //   57: getstatic 76	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   60: astore 4
      //   62: getstatic 76	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   65: astore 8
      //   67: aload_0
      //   68: getfield 14	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   71: aload 4
      //   73: aload 8
      //   75: invokevirtual 118	okhttp3/internal/http2/Http2Connection:close	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
      //   78: aload_0
      //   79: getfield 29	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   82: invokestatic 124	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   85: return
      //   86: astore_3
      //   87: aload_1
      //   88: astore 4
      //   90: aload_3
      //   91: astore 5
      //   93: aload_0
      //   94: getfield 14	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   97: aload 4
      //   99: aload_2
      //   100: invokevirtual 118	okhttp3/internal/http2/Http2Connection:close	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
      //   103: aload_0
      //   104: getfield 29	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   107: invokestatic 124	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   110: aload 5
      //   112: athrow
      //   113: astore 6
      //   115: goto -12 -> 103
      //   118: astore 5
      //   120: goto -27 -> 93
      //   123: astore 9
      //   125: goto -47 -> 78
      //   128: astore 11
      //   130: goto -83 -> 47
      //
      // Exception table:
      //   from	to	target	type
      //   8	16	55	java/io/IOException
      //   16	37	55	java/io/IOException
      //   8	16	86	finally
      //   16	37	86	finally
      //   57	62	86	finally
      //   93	103	113	java/io/IOException
      //   62	67	118	finally
      //   67	78	123	java/io/IOException
      //   37	47	128	java/io/IOException
    }

    public void goAway(int paramInt, ErrorCode paramErrorCode, f paramf)
    {
      if (paramf.h() > 0);
      synchronized (Http2Connection.this)
      {
        Http2Stream[] arrayOfHttp2Stream = (Http2Stream[])Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
        Http2Connection.this.shutdown = true;
        int i = arrayOfHttp2Stream.length;
        int j = 0;
        if (j < i)
        {
          Http2Stream localHttp2Stream = arrayOfHttp2Stream[j];
          if ((localHttp2Stream.getId() > paramInt) && (localHttp2Stream.isLocallyInitiated()))
          {
            localHttp2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
            Http2Connection.this.removeStream(localHttp2Stream.getId());
          }
          j++;
        }
      }
    }

    public void headers(boolean paramBoolean, int paramInt1, int paramInt2, List<Header> paramList)
    {
      if (Http2Connection.this.pushedStream(paramInt1))
        Http2Connection.this.pushHeadersLater(paramInt1, paramList, paramBoolean);
      Http2Stream localHttp2Stream1;
      label203: 
      do
      {
        return;
        synchronized (Http2Connection.this)
        {
          localHttp2Stream1 = Http2Connection.this.getStream(paramInt1);
          if (localHttp2Stream1 != null)
            break label203;
          if (Http2Connection.this.shutdown)
            return;
        }
        if (paramInt1 <= Http2Connection.this.lastGoodStreamId)
          return;
        if (paramInt1 % 2 == Http2Connection.this.nextStreamId % 2)
          return;
        final Http2Stream localHttp2Stream2 = new Http2Stream(paramInt1, Http2Connection.this, false, paramBoolean, paramList);
        Http2Connection.this.lastGoodStreamId = paramInt1;
        Http2Connection.this.streams.put(Integer.valueOf(paramInt1), localHttp2Stream2);
        ExecutorService localExecutorService = Http2Connection.listenerExecutor;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Http2Connection.this.hostname;
        arrayOfObject[1] = Integer.valueOf(paramInt1);
        localExecutorService.execute(new NamedRunnable("OkHttp %s stream %d", arrayOfObject)
        {
          public void execute()
          {
            try
            {
              Http2Connection.this.listener.onStream(localHttp2Stream2);
              return;
            }
            catch (IOException localIOException1)
            {
              Platform.get().log(4, "Http2Connection.Listener failure for " + Http2Connection.this.hostname, localIOException1);
              try
              {
                localHttp2Stream2.close(ErrorCode.PROTOCOL_ERROR);
                return;
              }
              catch (IOException localIOException2)
              {
              }
            }
          }
        });
        return;
        localHttp2Stream1.receiveHeaders(paramList);
      }
      while (!paramBoolean);
      localHttp2Stream1.receiveFin();
    }

    public void ping(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      if (paramBoolean)
        synchronized (Http2Connection.this)
        {
          Http2Connection.access$302(Http2Connection.this, false);
          Http2Connection.this.notifyAll();
          return;
        }
      try
      {
        Http2Connection.this.writerExecutor.execute(new Http2Connection.PingRunnable(Http2Connection.this, true, paramInt1, paramInt2));
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
      }
    }

    public void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
    }

    public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
    {
      Http2Connection.this.pushRequestLater(paramInt2, paramList);
    }

    public void rstStream(int paramInt, ErrorCode paramErrorCode)
    {
      if (Http2Connection.this.pushedStream(paramInt))
        Http2Connection.this.pushResetLater(paramInt, paramErrorCode);
      Http2Stream localHttp2Stream;
      do
      {
        return;
        localHttp2Stream = Http2Connection.this.removeStream(paramInt);
      }
      while (localHttp2Stream == null);
      localHttp2Stream.receiveRstStream(paramErrorCode);
    }

    public void settings(boolean paramBoolean, Settings paramSettings)
    {
      while (true)
      {
        long l2;
        int m;
        synchronized (Http2Connection.this)
        {
          int i = Http2Connection.this.peerSettings.getInitialWindowSize();
          if (paramBoolean)
            Http2Connection.this.peerSettings.clear();
          Http2Connection.this.peerSettings.merge(paramSettings);
          applyAndAckSettings(paramSettings);
          int j = Http2Connection.this.peerSettings.getInitialWindowSize();
          if ((j == -1) || (j == i))
            break label292;
          l2 = j - i;
          if (!Http2Connection.this.receivedInitialPeerSettings)
          {
            Http2Connection.this.addBytesToWriteWindow(l2);
            Http2Connection.this.receivedInitialPeerSettings = true;
          }
          if (Http2Connection.this.streams.isEmpty())
            break label282;
          Http2Stream[] arrayOfHttp2Stream2 = (Http2Stream[])Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
          l1 = l2;
          arrayOfHttp2Stream1 = arrayOfHttp2Stream2;
          ExecutorService localExecutorService = Http2Connection.listenerExecutor;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Http2Connection.this.hostname;
          localExecutorService.execute(new NamedRunnable("OkHttp %s settings", arrayOfObject)
          {
            public void execute()
            {
              Http2Connection.this.listener.onSettings(Http2Connection.this);
            }
          });
          if ((arrayOfHttp2Stream1 == null) || (l1 == 0L))
            break label281;
          int k = arrayOfHttp2Stream1.length;
          m = 0;
          if (m >= k)
            break label281;
        }
        synchronized (arrayOfHttp2Stream1[m])
        {
          ???.addBytesToWriteWindow(l1);
          m++;
          continue;
          localObject1 = finally;
          throw localObject1;
        }
        label281: return;
        label282: long l1 = l2;
        Http2Stream[] arrayOfHttp2Stream1 = null;
        continue;
        label292: l1 = 0L;
        arrayOfHttp2Stream1 = null;
      }
    }

    public void windowUpdate(int paramInt, long paramLong)
    {
      if (paramInt == 0)
        synchronized (Http2Connection.this)
        {
          Http2Connection localHttp2Connection2 = Http2Connection.this;
          localHttp2Connection2.bytesLeftInWriteWindow = (paramLong + localHttp2Connection2.bytesLeftInWriteWindow);
          Http2Connection.this.notifyAll();
          return;
        }
      Http2Stream localHttp2Stream = Http2Connection.this.getStream(paramInt);
      if (localHttp2Stream != null)
        try
        {
          localHttp2Stream.addBytesToWriteWindow(paramLong);
          return;
        }
        finally
        {
        }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Connection
 * JD-Core Version:    0.6.2
 */
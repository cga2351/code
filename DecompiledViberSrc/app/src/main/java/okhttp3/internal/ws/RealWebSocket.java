package okhttp3.internal.ws;

import f.d;
import f.e;
import f.f;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;

public final class RealWebSocket
  implements WebSocket, WebSocketReader.FrameCallback
{
  private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000L;
  private static final long MAX_QUEUE_SIZE = 16777216L;
  private static final List<Protocol> ONLY_HTTP1;
  private boolean awaitingPong;
  private Call call;
  private ScheduledFuture<?> cancelFuture;
  private boolean enqueuedClose;
  private ScheduledExecutorService executor;
  private boolean failed;
  private final String key;
  final WebSocketListener listener;
  private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque();
  private final Request originalRequest;
  private final long pingIntervalMillis;
  private final ArrayDeque<f> pongQueue = new ArrayDeque();
  private long queueSize;
  private final Random random;
  private WebSocketReader reader;
  private int receivedCloseCode = -1;
  private String receivedCloseReason;
  private int receivedPingCount;
  private int receivedPongCount;
  private int sentPingCount;
  private Streams streams;
  private WebSocketWriter writer;
  private final Runnable writerRunnable;

  static
  {
    if (!RealWebSocket.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
      return;
    }
  }

  public RealWebSocket(Request paramRequest, WebSocketListener paramWebSocketListener, Random paramRandom, long paramLong)
  {
    if (!"GET".equals(paramRequest.method()))
      throw new IllegalArgumentException("Request must be GET: " + paramRequest.method());
    this.originalRequest = paramRequest;
    this.listener = paramWebSocketListener;
    this.random = paramRandom;
    this.pingIntervalMillis = paramLong;
    byte[] arrayOfByte = new byte[16];
    paramRandom.nextBytes(arrayOfByte);
    this.key = f.a(arrayOfByte).b();
    this.writerRunnable = new Runnable()
    {
      public void run()
      {
        try
        {
          boolean bool;
          do
            bool = RealWebSocket.this.writeOneFrame();
          while (bool);
          return;
        }
        catch (IOException localIOException)
        {
          RealWebSocket.this.failWebSocket(localIOException, null);
        }
      }
    };
  }

  private void runWriter()
  {
    assert (Thread.holdsLock(this));
    if (this.executor != null)
      this.executor.execute(this.writerRunnable);
  }

  private boolean send(f paramf, int paramInt)
  {
    while (true)
    {
      try
      {
        boolean bool1 = this.failed;
        bool2 = false;
        if (!bool1)
        {
          boolean bool3 = this.enqueuedClose;
          bool2 = false;
          if (!bool3);
        }
        else
        {
          return bool2;
        }
        if (this.queueSize + paramf.h() > 16777216L)
        {
          close(1001, null);
          bool2 = false;
          continue;
        }
      }
      finally
      {
      }
      this.queueSize += paramf.h();
      this.messageAndCloseQueue.add(new Message(paramInt, paramf));
      runWriter();
      boolean bool2 = true;
    }
  }

  void awaitTermination(int paramInt, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    this.executor.awaitTermination(paramInt, paramTimeUnit);
  }

  public void cancel()
  {
    this.call.cancel();
  }

  void checkResponse(Response paramResponse)
    throws ProtocolException
  {
    if (paramResponse.code() != 101)
      throw new ProtocolException("Expected HTTP 101 response but was '" + paramResponse.code() + " " + paramResponse.message() + "'");
    String str1 = paramResponse.header("Connection");
    if (!"Upgrade".equalsIgnoreCase(str1))
      throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + str1 + "'");
    String str2 = paramResponse.header("Upgrade");
    if (!"websocket".equalsIgnoreCase(str2))
      throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + str2 + "'");
    String str3 = paramResponse.header("Sec-WebSocket-Accept");
    String str4 = f.a(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").d().b();
    if (!str4.equals(str3))
      throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + str4 + "' but was '" + str3 + "'");
  }

  public boolean close(int paramInt, String paramString)
  {
    return close(paramInt, paramString, 60000L);
  }

  boolean close(int paramInt, String paramString, long paramLong)
  {
    boolean bool1 = true;
    f localf;
    try
    {
      WebSocketProtocol.validateCloseCode(paramInt);
      localf = null;
      if (paramString != null)
      {
        localf = f.a(paramString);
        if (localf.h() > 123L)
          throw new IllegalArgumentException("reason.size() > 123: " + paramString);
      }
    }
    finally
    {
    }
    if (!this.failed)
    {
      boolean bool2 = this.enqueuedClose;
      if (!bool2);
    }
    else
    {
      bool1 = false;
    }
    while (true)
    {
      return bool1;
      this.enqueuedClose = true;
      this.messageAndCloseQueue.add(new Close(paramInt, localf, paramLong));
      runWriter();
    }
  }

  public void connect(OkHttpClient paramOkHttpClient)
  {
    OkHttpClient localOkHttpClient = paramOkHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
    final Request localRequest = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
    this.call = Internal.instance.newWebSocketCall(localOkHttpClient, localRequest);
    this.call.enqueue(new Callback()
    {
      public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
      {
        RealWebSocket.this.failWebSocket(paramAnonymousIOException, null);
      }

      // ERROR //
      public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 19	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   4: aload_2
        //   5: invokevirtual 40	okhttp3/internal/ws/RealWebSocket:checkResponse	(Lokhttp3/Response;)V
        //   8: getstatic 46	okhttp3/internal/Internal:instance	Lokhttp3/internal/Internal;
        //   11: aload_1
        //   12: invokevirtual 50	okhttp3/internal/Internal:streamAllocation	(Lokhttp3/Call;)Lokhttp3/internal/connection/StreamAllocation;
        //   15: astore 4
        //   17: aload 4
        //   19: invokevirtual 55	okhttp3/internal/connection/StreamAllocation:noNewStreams	()V
        //   22: aload 4
        //   24: invokevirtual 59	okhttp3/internal/connection/StreamAllocation:connection	()Lokhttp3/internal/connection/RealConnection;
        //   27: aload 4
        //   29: invokevirtual 65	okhttp3/internal/connection/RealConnection:newWebSocketStreams	(Lokhttp3/internal/connection/StreamAllocation;)Lokhttp3/internal/ws/RealWebSocket$Streams;
        //   32: astore 5
        //   34: aload_0
        //   35: getfield 19	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   38: getfield 69	okhttp3/internal/ws/RealWebSocket:listener	Lokhttp3/WebSocketListener;
        //   41: aload_0
        //   42: getfield 19	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   45: aload_2
        //   46: invokevirtual 75	okhttp3/WebSocketListener:onOpen	(Lokhttp3/WebSocket;Lokhttp3/Response;)V
        //   49: new 77	java/lang/StringBuilder
        //   52: dup
        //   53: invokespecial 78	java/lang/StringBuilder:<init>	()V
        //   56: ldc 80
        //   58: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   61: aload_0
        //   62: getfield 21	okhttp3/internal/ws/RealWebSocket$2:val$request	Lokhttp3/Request;
        //   65: invokevirtual 90	okhttp3/Request:url	()Lokhttp3/HttpUrl;
        //   68: invokevirtual 96	okhttp3/HttpUrl:redact	()Ljava/lang/String;
        //   71: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   74: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   77: astore 7
        //   79: aload_0
        //   80: getfield 19	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   83: aload 7
        //   85: aload 5
        //   87: invokevirtual 103	okhttp3/internal/ws/RealWebSocket:initReaderAndWriter	(Ljava/lang/String;Lokhttp3/internal/ws/RealWebSocket$Streams;)V
        //   90: aload 4
        //   92: invokevirtual 59	okhttp3/internal/connection/StreamAllocation:connection	()Lokhttp3/internal/connection/RealConnection;
        //   95: invokevirtual 107	okhttp3/internal/connection/RealConnection:socket	()Ljava/net/Socket;
        //   98: iconst_0
        //   99: invokevirtual 113	java/net/Socket:setSoTimeout	(I)V
        //   102: aload_0
        //   103: getfield 19	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   106: invokevirtual 116	okhttp3/internal/ws/RealWebSocket:loopReader	()V
        //   109: return
        //   110: astore_3
        //   111: aload_0
        //   112: getfield 19	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   115: aload_3
        //   116: aload_2
        //   117: invokevirtual 30	okhttp3/internal/ws/RealWebSocket:failWebSocket	(Ljava/lang/Exception;Lokhttp3/Response;)V
        //   120: aload_2
        //   121: invokestatic 122	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
        //   124: return
        //   125: astore 6
        //   127: aload_0
        //   128: getfield 19	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   131: aload 6
        //   133: aconst_null
        //   134: invokevirtual 30	okhttp3/internal/ws/RealWebSocket:failWebSocket	(Ljava/lang/Exception;Lokhttp3/Response;)V
        //   137: return
        //
        // Exception table:
        //   from	to	target	type
        //   0	8	110	java/net/ProtocolException
        //   34	109	125	java/lang/Exception
      }
    });
  }

  // ERROR //
  public void failWebSocket(Exception paramException, @javax.annotation.Nullable Response paramResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 181	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 181	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   17: aload_0
    //   18: getfield 359	okhttp3/internal/ws/RealWebSocket:streams	Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   21: astore 4
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield 359	okhttp3/internal/ws/RealWebSocket:streams	Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   28: aload_0
    //   29: getfield 361	okhttp3/internal/ws/RealWebSocket:cancelFuture	Ljava/util/concurrent/ScheduledFuture;
    //   32: ifnull +14 -> 46
    //   35: aload_0
    //   36: getfield 361	okhttp3/internal/ws/RealWebSocket:cancelFuture	Ljava/util/concurrent/ScheduledFuture;
    //   39: iconst_0
    //   40: invokeinterface 366 2 0
    //   45: pop
    //   46: aload_0
    //   47: getfield 171	okhttp3/internal/ws/RealWebSocket:executor	Ljava/util/concurrent/ScheduledExecutorService;
    //   50: ifnull +12 -> 62
    //   53: aload_0
    //   54: getfield 171	okhttp3/internal/ws/RealWebSocket:executor	Ljava/util/concurrent/ScheduledExecutorService;
    //   57: invokeinterface 369 1 0
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_0
    //   65: getfield 132	okhttp3/internal/ws/RealWebSocket:listener	Lokhttp3/WebSocketListener;
    //   68: aload_0
    //   69: aload_1
    //   70: aload_2
    //   71: invokevirtual 375	okhttp3/WebSocketListener:onFailure	(Lokhttp3/WebSocket;Ljava/lang/Throwable;Lokhttp3/Response;)V
    //   74: aload 4
    //   76: invokestatic 381	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   79: return
    //   80: astore_3
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_3
    //   84: athrow
    //   85: astore 5
    //   87: aload 4
    //   89: invokestatic 381	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   92: aload 5
    //   94: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	11	80	finally
    //   12	46	80	finally
    //   46	62	80	finally
    //   62	64	80	finally
    //   81	83	80	finally
    //   64	74	85	finally
  }

  public void initReaderAndWriter(String paramString, Streams paramStreams)
    throws IOException
  {
    try
    {
      this.streams = paramStreams;
      this.writer = new WebSocketWriter(paramStreams.client, paramStreams.sink, this.random);
      this.executor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(paramString, false));
      if (this.pingIntervalMillis != 0L)
        this.executor.scheduleAtFixedRate(new PingRunnable(), this.pingIntervalMillis, this.pingIntervalMillis, TimeUnit.MILLISECONDS);
      if (!this.messageAndCloseQueue.isEmpty())
        runWriter();
      this.reader = new WebSocketReader(paramStreams.client, paramStreams.source, this);
      return;
    }
    finally
    {
    }
  }

  public void loopReader()
    throws IOException
  {
    while (this.receivedCloseCode == -1)
      this.reader.processNextFrame();
  }

  public void onReadClose(int paramInt, String paramString)
  {
    if (paramInt == -1)
      throw new IllegalArgumentException();
    try
    {
      if (this.receivedCloseCode != -1)
        throw new IllegalStateException("already closed");
    }
    finally
    {
    }
    this.receivedCloseCode = paramInt;
    this.receivedCloseReason = paramString;
    Streams localStreams2;
    if ((this.enqueuedClose) && (this.messageAndCloseQueue.isEmpty()))
    {
      localStreams2 = this.streams;
      this.streams = null;
      if (this.cancelFuture != null)
        this.cancelFuture.cancel(false);
      this.executor.shutdown();
    }
    for (Streams localStreams1 = localStreams2; ; localStreams1 = null)
      try
      {
        this.listener.onClosing(this, paramInt, paramString);
        if (localStreams1 != null)
          this.listener.onClosed(this, paramInt, paramString);
        return;
      }
      finally
      {
        Util.closeQuietly(localStreams1);
      }
  }

  public void onReadMessage(f paramf)
    throws IOException
  {
    this.listener.onMessage(this, paramf);
  }

  public void onReadMessage(String paramString)
    throws IOException
  {
    this.listener.onMessage(this, paramString);
  }

  public void onReadPing(f paramf)
  {
    try
    {
      if (!this.failed)
      {
        if (!this.enqueuedClose)
          break label33;
        boolean bool = this.messageAndCloseQueue.isEmpty();
        if (!bool)
          break label33;
      }
      while (true)
      {
        return;
        label33: this.pongQueue.add(paramf);
        runWriter();
        this.receivedPingCount = (1 + this.receivedPingCount);
      }
    }
    finally
    {
    }
  }

  public void onReadPong(f paramf)
  {
    try
    {
      this.receivedPongCount = (1 + this.receivedPongCount);
      this.awaitingPong = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  boolean pong(f paramf)
  {
    try
    {
      if (!this.failed)
      {
        if (!this.enqueuedClose)
          break label36;
        boolean bool2 = this.messageAndCloseQueue.isEmpty();
        if (!bool2)
          break label36;
      }
      for (boolean bool1 = false; ; bool1 = true)
      {
        return bool1;
        label36: this.pongQueue.add(paramf);
        runWriter();
      }
    }
    finally
    {
    }
  }

  boolean processNextFrame()
    throws IOException
  {
    try
    {
      this.reader.processNextFrame();
      int i = this.receivedCloseCode;
      boolean bool = false;
      if (i == -1)
        bool = true;
      return bool;
    }
    catch (Exception localException)
    {
      failWebSocket(localException, null);
    }
    return false;
  }

  public long queueSize()
  {
    try
    {
      long l = this.queueSize;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  int receivedPingCount()
  {
    try
    {
      int i = this.receivedPingCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  int receivedPongCount()
  {
    try
    {
      int i = this.receivedPongCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Request request()
  {
    return this.originalRequest;
  }

  public boolean send(f paramf)
  {
    if (paramf == null)
      throw new NullPointerException("bytes == null");
    return send(paramf, 2);
  }

  public boolean send(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException("text == null");
    return send(f.a(paramString), 1);
  }

  int sentPingCount()
  {
    try
    {
      int i = this.sentPingCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void tearDown()
    throws InterruptedException
  {
    if (this.cancelFuture != null)
      this.cancelFuture.cancel(false);
    this.executor.shutdown();
    this.executor.awaitTermination(10L, TimeUnit.SECONDS);
  }

  // ERROR //
  boolean writeOneFrame()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 181	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   6: ifeq +7 -> 13
    //   9: aload_0
    //   10: monitorexit
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_0
    //   14: getfield 401	okhttp3/internal/ws/RealWebSocket:writer	Lokhttp3/internal/ws/WebSocketWriter;
    //   17: astore_2
    //   18: aload_0
    //   19: getfield 93	okhttp3/internal/ws/RealWebSocket:pongQueue	Ljava/util/ArrayDeque;
    //   22: invokevirtual 505	java/util/ArrayDeque:poll	()Ljava/lang/Object;
    //   25: checkcast 144	f/f
    //   28: astore_3
    //   29: aload_3
    //   30: ifnonnull +326 -> 356
    //   33: aload_0
    //   34: getfield 95	okhttp3/internal/ws/RealWebSocket:messageAndCloseQueue	Ljava/util/ArrayDeque;
    //   37: invokevirtual 505	java/util/ArrayDeque:poll	()Ljava/lang/Object;
    //   40: astore 4
    //   42: aload 4
    //   44: instanceof 287
    //   47: ifeq +125 -> 172
    //   50: aload_0
    //   51: getfield 97	okhttp3/internal/ws/RealWebSocket:receivedCloseCode	I
    //   54: istore 15
    //   56: aload_0
    //   57: getfield 451	okhttp3/internal/ws/RealWebSocket:receivedCloseReason	Ljava/lang/String;
    //   60: astore 16
    //   62: iload 15
    //   64: iconst_m1
    //   65: if_icmpeq +57 -> 122
    //   68: aload_0
    //   69: getfield 359	okhttp3/internal/ws/RealWebSocket:streams	Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   72: astore 17
    //   74: aload_0
    //   75: aconst_null
    //   76: putfield 359	okhttp3/internal/ws/RealWebSocket:streams	Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   79: aload_0
    //   80: getfield 171	okhttp3/internal/ws/RealWebSocket:executor	Ljava/util/concurrent/ScheduledExecutorService;
    //   83: invokeinterface 369 1 0
    //   88: aload 16
    //   90: astore 8
    //   92: iload 15
    //   94: istore 5
    //   96: aload 4
    //   98: astore 6
    //   100: aload 17
    //   102: astore 7
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_3
    //   107: ifnull +79 -> 186
    //   110: aload_2
    //   111: aload_3
    //   112: invokevirtual 508	okhttp3/internal/ws/WebSocketWriter:writePong	(Lf/f;)V
    //   115: aload 7
    //   117: invokestatic 381	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   120: iconst_1
    //   121: ireturn
    //   122: aload_0
    //   123: aload_0
    //   124: getfield 171	okhttp3/internal/ws/RealWebSocket:executor	Ljava/util/concurrent/ScheduledExecutorService;
    //   127: new 510	okhttp3/internal/ws/RealWebSocket$CancelRunnable
    //   130: dup
    //   131: aload_0
    //   132: invokespecial 511	okhttp3/internal/ws/RealWebSocket$CancelRunnable:<init>	(Lokhttp3/internal/ws/RealWebSocket;)V
    //   135: aload 4
    //   137: checkcast 287	okhttp3/internal/ws/RealWebSocket$Close
    //   140: getfield 514	okhttp3/internal/ws/RealWebSocket$Close:cancelAfterCloseMillis	J
    //   143: getstatic 419	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   146: invokeinterface 518 5 0
    //   151: putfield 361	okhttp3/internal/ws/RealWebSocket:cancelFuture	Ljava/util/concurrent/ScheduledFuture;
    //   154: aload 4
    //   156: astore 6
    //   158: aload 16
    //   160: astore 8
    //   162: iload 15
    //   164: istore 5
    //   166: aconst_null
    //   167: astore 7
    //   169: goto -65 -> 104
    //   172: aload 4
    //   174: ifnonnull +166 -> 340
    //   177: aload_0
    //   178: monitorexit
    //   179: iconst_0
    //   180: ireturn
    //   181: astore_1
    //   182: aload_0
    //   183: monitorexit
    //   184: aload_1
    //   185: athrow
    //   186: aload 6
    //   188: instanceof 195
    //   191: ifeq +92 -> 283
    //   194: aload 6
    //   196: checkcast 195	okhttp3/internal/ws/RealWebSocket$Message
    //   199: getfield 522	okhttp3/internal/ws/RealWebSocket$Message:data	Lf/f;
    //   202: astore 11
    //   204: aload_2
    //   205: aload 6
    //   207: checkcast 195	okhttp3/internal/ws/RealWebSocket$Message
    //   210: getfield 525	okhttp3/internal/ws/RealWebSocket$Message:formatOpcode	I
    //   213: aload 11
    //   215: invokevirtual 189	f/f:h	()I
    //   218: i2l
    //   219: invokevirtual 529	okhttp3/internal/ws/WebSocketWriter:newMessageSink	(IJ)Lf/s;
    //   222: invokestatic 534	f/l:a	(Lf/s;)Lf/d;
    //   225: astore 12
    //   227: aload 12
    //   229: aload 11
    //   231: invokeinterface 540 2 0
    //   236: pop
    //   237: aload 12
    //   239: invokeinterface 542 1 0
    //   244: aload_0
    //   245: monitorenter
    //   246: aload_0
    //   247: aload_0
    //   248: getfield 185	okhttp3/internal/ws/RealWebSocket:queueSize	J
    //   251: aload 11
    //   253: invokevirtual 189	f/f:h	()I
    //   256: i2l
    //   257: lsub
    //   258: putfield 185	okhttp3/internal/ws/RealWebSocket:queueSize	J
    //   261: aload_0
    //   262: monitorexit
    //   263: goto -148 -> 115
    //   266: astore 14
    //   268: aload_0
    //   269: monitorexit
    //   270: aload 14
    //   272: athrow
    //   273: astore 9
    //   275: aload 7
    //   277: invokestatic 381	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   280: aload 9
    //   282: athrow
    //   283: aload 6
    //   285: instanceof 287
    //   288: ifeq +44 -> 332
    //   291: aload 6
    //   293: checkcast 287	okhttp3/internal/ws/RealWebSocket$Close
    //   296: astore 10
    //   298: aload_2
    //   299: aload 10
    //   301: getfield 544	okhttp3/internal/ws/RealWebSocket$Close:code	I
    //   304: aload 10
    //   306: getfield 547	okhttp3/internal/ws/RealWebSocket$Close:reason	Lf/f;
    //   309: invokevirtual 550	okhttp3/internal/ws/WebSocketWriter:writeClose	(ILf/f;)V
    //   312: aload 7
    //   314: ifnull -199 -> 115
    //   317: aload_0
    //   318: getfield 132	okhttp3/internal/ws/RealWebSocket:listener	Lokhttp3/WebSocketListener;
    //   321: aload_0
    //   322: iload 5
    //   324: aload 8
    //   326: invokevirtual 458	okhttp3/WebSocketListener:onClosed	(Lokhttp3/WebSocket;ILjava/lang/String;)V
    //   329: goto -214 -> 115
    //   332: new 168	java/lang/AssertionError
    //   335: dup
    //   336: invokespecial 169	java/lang/AssertionError:<init>	()V
    //   339: athrow
    //   340: iconst_m1
    //   341: istore 5
    //   343: aload 4
    //   345: astore 6
    //   347: aconst_null
    //   348: astore 7
    //   350: aconst_null
    //   351: astore 8
    //   353: goto -249 -> 104
    //   356: iconst_m1
    //   357: istore 5
    //   359: aconst_null
    //   360: astore 6
    //   362: aconst_null
    //   363: astore 7
    //   365: aconst_null
    //   366: astore 8
    //   368: goto -264 -> 104
    //
    // Exception table:
    //   from	to	target	type
    //   2	11	181	finally
    //   13	29	181	finally
    //   33	62	181	finally
    //   68	88	181	finally
    //   104	106	181	finally
    //   122	154	181	finally
    //   177	179	181	finally
    //   182	184	181	finally
    //   246	263	266	finally
    //   268	270	266	finally
    //   110	115	273	finally
    //   186	246	273	finally
    //   270	273	273	finally
    //   283	312	273	finally
    //   317	329	273	finally
    //   332	340	273	finally
  }

  void writePingFrame()
  {
    WebSocketWriter localWebSocketWriter;
    try
    {
      if (this.failed)
        return;
      localWebSocketWriter = this.writer;
      if (this.awaitingPong);
      for (int i = this.sentPingCount; ; i = -1)
      {
        this.sentPingCount = (1 + this.sentPingCount);
        this.awaitingPong = true;
        if (i == -1)
          break;
        failWebSocket(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (i - 1) + " successful ping/pongs)"), null);
        return;
      }
    }
    finally
    {
    }
    try
    {
      localWebSocketWriter.writePing(f.b);
      return;
    }
    catch (IOException localIOException)
    {
      failWebSocket(localIOException, null);
    }
  }

  final class CancelRunnable
    implements Runnable
  {
    CancelRunnable()
    {
    }

    public void run()
    {
      RealWebSocket.this.cancel();
    }
  }

  static final class Close
  {
    final long cancelAfterCloseMillis;
    final int code;
    final f reason;

    Close(int paramInt, f paramf, long paramLong)
    {
      this.code = paramInt;
      this.reason = paramf;
      this.cancelAfterCloseMillis = paramLong;
    }
  }

  static final class Message
  {
    final f data;
    final int formatOpcode;

    Message(int paramInt, f paramf)
    {
      this.formatOpcode = paramInt;
      this.data = paramf;
    }
  }

  private final class PingRunnable
    implements Runnable
  {
    PingRunnable()
    {
    }

    public void run()
    {
      RealWebSocket.this.writePingFrame();
    }
  }

  public static abstract class Streams
    implements Closeable
  {
    public final boolean client;
    public final d sink;
    public final e source;

    public Streams(boolean paramBoolean, e parame, d paramd)
    {
      this.client = paramBoolean;
      this.source = parame;
      this.sink = paramd;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.ws.RealWebSocket
 * JD-Core Version:    0.6.2
 */
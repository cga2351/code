package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

public final class StreamAllocation
{
  public final Address address;
  public final Call call;
  private final Object callStackTrace;
  private boolean canceled;
  private HttpCodec codec;
  private RealConnection connection;
  private final ConnectionPool connectionPool;
  public final EventListener eventListener;
  private int refusedStreamCount;
  private boolean released;
  private boolean reportedAcquired;
  private Route route;
  private RouteSelector.Selection routeSelection;
  private final RouteSelector routeSelector;

  static
  {
    if (!StreamAllocation.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }

  public StreamAllocation(ConnectionPool paramConnectionPool, Address paramAddress, Call paramCall, EventListener paramEventListener, Object paramObject)
  {
    this.connectionPool = paramConnectionPool;
    this.address = paramAddress;
    this.call = paramCall;
    this.eventListener = paramEventListener;
    this.routeSelector = new RouteSelector(paramAddress, routeDatabase(), paramCall, paramEventListener);
    this.callStackTrace = paramObject;
  }

  private Socket deallocate(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    assert (Thread.holdsLock(this.connectionPool));
    if (paramBoolean3)
      this.codec = null;
    if (paramBoolean2)
      this.released = true;
    RealConnection localRealConnection = this.connection;
    Object localObject = null;
    if (localRealConnection != null)
    {
      if (paramBoolean1)
        this.connection.noNewStreams = true;
      HttpCodec localHttpCodec = this.codec;
      localObject = null;
      if (localHttpCodec == null)
        if (!this.released)
        {
          boolean bool = this.connection.noNewStreams;
          localObject = null;
          if (!bool);
        }
        else
        {
          release(this.connection);
          if (!this.connection.allocations.isEmpty())
            break label177;
          this.connection.idleAtNanos = System.nanoTime();
          if (!Internal.instance.connectionBecameIdle(this.connectionPool, this.connection))
            break label177;
        }
    }
    label177: for (Socket localSocket = this.connection.socket(); ; localSocket = null)
    {
      this.connection = null;
      localObject = localSocket;
      return localObject;
    }
  }

  private RealConnection findConnection(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    throws IOException
  {
    synchronized (this.connectionPool)
    {
      if (this.released)
        throw new IllegalStateException("released");
    }
    if (this.codec != null)
      throw new IllegalStateException("codec != null");
    if (this.canceled)
      throw new IOException("Canceled");
    RealConnection localRealConnection1 = this.connection;
    Socket localSocket1 = releaseIfNoNewStreams();
    RealConnection localRealConnection2 = this.connection;
    RealConnection localRealConnection3 = null;
    if (localRealConnection2 != null)
    {
      localRealConnection3 = this.connection;
      localRealConnection1 = null;
    }
    if (!this.reportedAcquired)
      localRealConnection1 = null;
    Route localRoute1 = null;
    int i = 0;
    if (localRealConnection3 == null)
    {
      Internal.instance.get(this.connectionPool, this.address, this, null);
      if (this.connection == null)
        break label209;
      i = 1;
      localRealConnection3 = this.connection;
    }
    while (true)
    {
      Util.closeQuietly(localSocket1);
      if (localRealConnection1 != null)
        this.eventListener.connectionReleased(this.call, localRealConnection1);
      if (i != 0)
        this.eventListener.connectionAcquired(this.call, localRealConnection3);
      if (localRealConnection3 == null)
        break;
      return localRealConnection3;
      label209: localRoute1 = this.route;
      i = 0;
    }
    int j = 0;
    if (localRoute1 == null)
      if (this.routeSelection != null)
      {
        boolean bool2 = this.routeSelection.hasNext();
        j = 0;
        if (bool2);
      }
      else
      {
        j = 1;
        this.routeSelection = this.routeSelector.next();
      }
    synchronized (this.connectionPool)
    {
      if (this.canceled)
        throw new IOException("Canceled");
    }
    int m;
    RealConnection localRealConnection5;
    if (j != 0)
    {
      List localList = this.routeSelection.getAll();
      int k = localList.size();
      m = 0;
      if (m < k)
      {
        Route localRoute3 = (Route)localList.get(m);
        Internal.instance.get(this.connectionPool, this.address, this, localRoute3);
        if (this.connection != null)
        {
          i = 1;
          localRealConnection5 = this.connection;
          this.route = localRoute3;
        }
      }
    }
    for (RealConnection localRealConnection4 = localRealConnection5; ; localRealConnection4 = localRealConnection3)
    {
      if (i == 0)
        if (localRoute1 != null)
          break label606;
      label606: for (Route localRoute2 = this.routeSelection.next(); ; localRoute2 = localRoute1)
      {
        this.route = localRoute2;
        this.refusedStreamCount = 0;
        localRealConnection4 = new RealConnection(this.connectionPool, localRoute2);
        acquire(localRealConnection4, false);
        if (i != 0)
        {
          this.eventListener.connectionAcquired(this.call, localRealConnection4);
          return localRealConnection4;
          m++;
          break;
        }
        localRealConnection4.connect(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, this.call, this.eventListener);
        routeDatabase().connected(localRealConnection4.route());
        synchronized (this.connectionPool)
        {
          this.reportedAcquired = true;
          Internal.instance.put(this.connectionPool, localRealConnection4);
          boolean bool1 = localRealConnection4.isMultiplexed();
          Object localObject4 = null;
          if (bool1)
          {
            Socket localSocket2 = Internal.instance.deduplicate(this.connectionPool, this.address, this);
            localRealConnection4 = this.connection;
            localObject4 = localSocket2;
          }
          Util.closeQuietly(localObject4);
          this.eventListener.connectionAcquired(this.call, localRealConnection4);
          return localRealConnection4;
        }
      }
    }
  }

  private RealConnection findHealthyConnection(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    RealConnection localRealConnection;
    while (true)
    {
      localRealConnection = findConnection(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1);
      synchronized (this.connectionPool)
      {
        if (localRealConnection.successCount == 0)
          return localRealConnection;
        if (!localRealConnection.isHealthy(paramBoolean2))
          noNewStreams();
      }
    }
    return localRealConnection;
  }

  private void release(RealConnection paramRealConnection)
  {
    int i = paramRealConnection.allocations.size();
    for (int j = 0; j < i; j++)
      if (((Reference)paramRealConnection.allocations.get(j)).get() == this)
      {
        paramRealConnection.allocations.remove(j);
        return;
      }
    throw new IllegalStateException();
  }

  private Socket releaseIfNoNewStreams()
  {
    assert (Thread.holdsLock(this.connectionPool));
    RealConnection localRealConnection = this.connection;
    if ((localRealConnection != null) && (localRealConnection.noNewStreams))
      return deallocate(false, false, true);
    return null;
  }

  private RouteDatabase routeDatabase()
  {
    return Internal.instance.routeDatabase(this.connectionPool);
  }

  public void acquire(RealConnection paramRealConnection, boolean paramBoolean)
  {
    assert (Thread.holdsLock(this.connectionPool));
    if (this.connection != null)
      throw new IllegalStateException();
    this.connection = paramRealConnection;
    this.reportedAcquired = paramBoolean;
    paramRealConnection.allocations.add(new StreamAllocationReference(this, this.callStackTrace));
  }

  public void cancel()
  {
    RealConnection localRealConnection;
    do
      synchronized (this.connectionPool)
      {
        this.canceled = true;
        HttpCodec localHttpCodec = this.codec;
        localRealConnection = this.connection;
        if (localHttpCodec != null)
        {
          localHttpCodec.cancel();
          return;
        }
      }
    while (localRealConnection == null);
    localRealConnection.cancel();
  }

  public HttpCodec codec()
  {
    synchronized (this.connectionPool)
    {
      HttpCodec localHttpCodec = this.codec;
      return localHttpCodec;
    }
  }

  public RealConnection connection()
  {
    try
    {
      RealConnection localRealConnection = this.connection;
      return localRealConnection;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean hasMoreRoutes()
  {
    return (this.route != null) || ((this.routeSelection != null) && (this.routeSelection.hasNext())) || (this.routeSelector.hasNext());
  }

  public HttpCodec newStream(OkHttpClient paramOkHttpClient, Interceptor.Chain paramChain, boolean paramBoolean)
  {
    int i = paramChain.connectTimeoutMillis();
    int j = paramChain.readTimeoutMillis();
    int k = paramChain.writeTimeoutMillis();
    int m = paramOkHttpClient.pingIntervalMillis();
    boolean bool = paramOkHttpClient.retryOnConnectionFailure();
    try
    {
      HttpCodec localHttpCodec = findHealthyConnection(i, j, k, m, bool, paramBoolean).newCodec(paramOkHttpClient, paramChain, this);
      synchronized (this.connectionPool)
      {
        this.codec = localHttpCodec;
        return localHttpCodec;
      }
    }
    catch (IOException localIOException)
    {
      throw new RouteException(localIOException);
    }
  }

  public void noNewStreams()
  {
    synchronized (this.connectionPool)
    {
      RealConnection localRealConnection = this.connection;
      Socket localSocket = deallocate(true, false, false);
      if (this.connection != null)
        localRealConnection = null;
      Util.closeQuietly(localSocket);
      if (localRealConnection != null)
        this.eventListener.connectionReleased(this.call, localRealConnection);
      return;
    }
  }

  public void release()
  {
    synchronized (this.connectionPool)
    {
      RealConnection localRealConnection = this.connection;
      Socket localSocket = deallocate(false, true, false);
      if (this.connection != null)
        localRealConnection = null;
      Util.closeQuietly(localSocket);
      if (localRealConnection != null)
        this.eventListener.connectionReleased(this.call, localRealConnection);
      return;
    }
  }

  public Socket releaseAndAcquire(RealConnection paramRealConnection)
  {
    assert (Thread.holdsLock(this.connectionPool));
    if ((this.codec != null) || (this.connection.allocations.size() != 1))
      throw new IllegalStateException();
    Reference localReference = (Reference)this.connection.allocations.get(0);
    Socket localSocket = deallocate(true, false, false);
    this.connection = paramRealConnection;
    paramRealConnection.allocations.add(localReference);
    return localSocket;
  }

  public Route route()
  {
    return this.route;
  }

  public void streamFailed(IOException paramIOException)
  {
    int i = 1;
    while (true)
    {
      int j;
      synchronized (this.connectionPool)
      {
        if ((paramIOException instanceof StreamResetException))
        {
          StreamResetException localStreamResetException = (StreamResetException)paramIOException;
          if (localStreamResetException.errorCode == ErrorCode.REFUSED_STREAM)
            this.refusedStreamCount = (1 + this.refusedStreamCount);
          if (localStreamResetException.errorCode == ErrorCode.REFUSED_STREAM)
          {
            int k = this.refusedStreamCount;
            j = 0;
            if (k <= i)
              break label215;
          }
          this.route = null;
          j = i;
          break label215;
          localRealConnection = this.connection;
          Socket localSocket = deallocate(i, false, true);
          if ((this.connection != null) || (!this.reportedAcquired))
            break label221;
          Util.closeQuietly(localSocket);
          if (localRealConnection != null)
            this.eventListener.connectionReleased(this.call, localRealConnection);
          return;
        }
        if ((this.connection != null) && ((!this.connection.isMultiplexed()) || ((paramIOException instanceof ConnectionShutdownException))))
        {
          if (this.connection.successCount != 0)
            continue;
          if ((this.route != null) && (paramIOException != null))
            this.routeSelector.connectFailed(this.route, paramIOException);
          this.route = null;
        }
      }
      i = 0;
      continue;
      label215: i = j;
      continue;
      label221: RealConnection localRealConnection = null;
    }
  }

  // ERROR //
  public void streamFinished(boolean paramBoolean, HttpCodec paramHttpCodec, long paramLong, IOException paramIOException)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	okhttp3/internal/connection/StreamAllocation:eventListener	Lokhttp3/EventListener;
    //   4: aload_0
    //   5: getfield 51	okhttp3/internal/connection/StreamAllocation:call	Lokhttp3/Call;
    //   8: lload_3
    //   9: invokevirtual 330	okhttp3/EventListener:responseBodyEnd	(Lokhttp3/Call;J)V
    //   12: aload_0
    //   13: getfield 47	okhttp3/internal/connection/StreamAllocation:connectionPool	Lokhttp3/ConnectionPool;
    //   16: astore 6
    //   18: aload 6
    //   20: monitorenter
    //   21: aload_2
    //   22: ifnull +11 -> 33
    //   25: aload_2
    //   26: aload_0
    //   27: getfield 79	okhttp3/internal/connection/StreamAllocation:codec	Lokhttp3/internal/http/HttpCodec;
    //   30: if_acmpeq +52 -> 82
    //   33: new 131	java/lang/IllegalStateException
    //   36: dup
    //   37: new 332	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 335
    //   47: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_0
    //   51: getfield 79	okhttp3/internal/connection/StreamAllocation:codec	Lokhttp3/internal/http/HttpCodec;
    //   54: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   57: ldc_w 344
    //   60: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_2
    //   64: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 348	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokespecial 135	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   73: athrow
    //   74: astore 7
    //   76: aload 6
    //   78: monitorexit
    //   79: aload 7
    //   81: athrow
    //   82: iload_1
    //   83: ifne +21 -> 104
    //   86: aload_0
    //   87: getfield 83	okhttp3/internal/connection/StreamAllocation:connection	Lokhttp3/internal/connection/RealConnection;
    //   90: astore 11
    //   92: aload 11
    //   94: iconst_1
    //   95: aload 11
    //   97: getfield 234	okhttp3/internal/connection/RealConnection:successCount	I
    //   100: iadd
    //   101: putfield 234	okhttp3/internal/connection/RealConnection:successCount	I
    //   104: aload_0
    //   105: getfield 83	okhttp3/internal/connection/StreamAllocation:connection	Lokhttp3/internal/connection/RealConnection;
    //   108: astore 8
    //   110: aload_0
    //   111: iload_1
    //   112: iconst_0
    //   113: iconst_1
    //   114: invokespecial 251	okhttp3/internal/connection/StreamAllocation:deallocate	(ZZZ)Ljava/net/Socket;
    //   117: astore 9
    //   119: aload_0
    //   120: getfield 83	okhttp3/internal/connection/StreamAllocation:connection	Lokhttp3/internal/connection/RealConnection;
    //   123: ifnull +6 -> 129
    //   126: aconst_null
    //   127: astore 8
    //   129: aload_0
    //   130: getfield 81	okhttp3/internal/connection/StreamAllocation:released	Z
    //   133: istore 10
    //   135: aload 6
    //   137: monitorexit
    //   138: aload 9
    //   140: invokestatic 157	okhttp3/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   143: aload 8
    //   145: ifnull +16 -> 161
    //   148: aload_0
    //   149: getfield 53	okhttp3/internal/connection/StreamAllocation:eventListener	Lokhttp3/EventListener;
    //   152: aload_0
    //   153: getfield 51	okhttp3/internal/connection/StreamAllocation:call	Lokhttp3/Call;
    //   156: aload 8
    //   158: invokevirtual 163	okhttp3/EventListener:connectionReleased	(Lokhttp3/Call;Lokhttp3/Connection;)V
    //   161: aload 5
    //   163: ifnull +17 -> 180
    //   166: aload_0
    //   167: getfield 53	okhttp3/internal/connection/StreamAllocation:eventListener	Lokhttp3/EventListener;
    //   170: aload_0
    //   171: getfield 51	okhttp3/internal/connection/StreamAllocation:call	Lokhttp3/Call;
    //   174: aload 5
    //   176: invokevirtual 352	okhttp3/EventListener:callFailed	(Lokhttp3/Call;Ljava/io/IOException;)V
    //   179: return
    //   180: iload 10
    //   182: ifeq -3 -> 179
    //   185: aload_0
    //   186: getfield 53	okhttp3/internal/connection/StreamAllocation:eventListener	Lokhttp3/EventListener;
    //   189: aload_0
    //   190: getfield 51	okhttp3/internal/connection/StreamAllocation:call	Lokhttp3/Call;
    //   193: invokevirtual 356	okhttp3/EventListener:callEnd	(Lokhttp3/Call;)V
    //   196: return
    //
    // Exception table:
    //   from	to	target	type
    //   25	33	74	finally
    //   33	74	74	finally
    //   76	79	74	finally
    //   86	104	74	finally
    //   104	126	74	finally
    //   129	138	74	finally
  }

  public String toString()
  {
    RealConnection localRealConnection = connection();
    if (localRealConnection != null)
      return localRealConnection.toString();
    return this.address.toString();
  }

  public static final class StreamAllocationReference extends WeakReference<StreamAllocation>
  {
    public final Object callStackTrace;

    StreamAllocationReference(StreamAllocation paramStreamAllocation, Object paramObject)
    {
      super();
      this.callStackTrace = paramObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.connection.StreamAllocation
 * JD-Core Version:    0.6.2
 */
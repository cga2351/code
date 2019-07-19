package okhttp3;

import f.c;
import f.d;
import f.e;
import f.f;
import f.g;
import f.h;
import f.l;
import f.s;
import f.t;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.DiskLruCache.Editor;
import okhttp3.internal.cache.DiskLruCache.Snapshot;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;

public final class Cache
  implements Closeable, Flushable
{
  private static final int ENTRY_BODY = 1;
  private static final int ENTRY_COUNT = 2;
  private static final int ENTRY_METADATA = 0;
  private static final int VERSION = 201105;
  final DiskLruCache cache;
  private int hitCount;
  final InternalCache internalCache = new InternalCache()
  {
    public Response get(Request paramAnonymousRequest)
      throws IOException
    {
      return Cache.this.get(paramAnonymousRequest);
    }

    public CacheRequest put(Response paramAnonymousResponse)
      throws IOException
    {
      return Cache.this.put(paramAnonymousResponse);
    }

    public void remove(Request paramAnonymousRequest)
      throws IOException
    {
      Cache.this.remove(paramAnonymousRequest);
    }

    public void trackConditionalCacheHit()
    {
      Cache.this.trackConditionalCacheHit();
    }

    public void trackResponse(CacheStrategy paramAnonymousCacheStrategy)
    {
      Cache.this.trackResponse(paramAnonymousCacheStrategy);
    }

    public void update(Response paramAnonymousResponse1, Response paramAnonymousResponse2)
    {
      Cache.this.update(paramAnonymousResponse1, paramAnonymousResponse2);
    }
  };
  private int networkCount;
  private int requestCount;
  int writeAbortCount;
  int writeSuccessCount;

  public Cache(File paramFile, long paramLong)
  {
    this(paramFile, paramLong, FileSystem.SYSTEM);
  }

  Cache(File paramFile, long paramLong, FileSystem paramFileSystem)
  {
    this.cache = DiskLruCache.create(paramFileSystem, paramFile, 201105, 2, paramLong);
  }

  private void abortQuietly(@Nullable DiskLruCache.Editor paramEditor)
  {
    if (paramEditor != null);
    try
    {
      paramEditor.abort();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  public static String key(HttpUrl paramHttpUrl)
  {
    return f.a(paramHttpUrl.toString()).c().f();
  }

  static int readInt(e parame)
    throws IOException
  {
    long l;
    try
    {
      l = parame.o();
      String str = parame.s();
      if ((l < 0L) || (l > 2147483647L) || (!str.isEmpty()))
        throw new IOException("expected an int but was \"" + l + str + "\"");
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new IOException(localNumberFormatException.getMessage());
    }
    return (int)l;
  }

  public void close()
    throws IOException
  {
    this.cache.close();
  }

  public void delete()
    throws IOException
  {
    this.cache.delete();
  }

  public File directory()
  {
    return this.cache.getDirectory();
  }

  public void evictAll()
    throws IOException
  {
    this.cache.evictAll();
  }

  public void flush()
    throws IOException
  {
    this.cache.flush();
  }

  @Nullable
  Response get(Request paramRequest)
  {
    String str = key(paramRequest.url());
    try
    {
      DiskLruCache.Snapshot localSnapshot = this.cache.get(str);
      if (localSnapshot == null)
        return null;
      Response localResponse;
      try
      {
        Entry localEntry = new Entry(localSnapshot.getSource(0));
        localResponse = localEntry.response(localSnapshot);
        if (!localEntry.matches(paramRequest, localResponse))
        {
          Util.closeQuietly(localResponse.body());
          return null;
        }
      }
      catch (IOException localIOException2)
      {
        Util.closeQuietly(localSnapshot);
        return null;
      }
      return localResponse;
    }
    catch (IOException localIOException1)
    {
    }
    return null;
  }

  public int hitCount()
  {
    try
    {
      int i = this.hitCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void initialize()
    throws IOException
  {
    this.cache.initialize();
  }

  public boolean isClosed()
  {
    return this.cache.isClosed();
  }

  public long maxSize()
  {
    return this.cache.getMaxSize();
  }

  public int networkCount()
  {
    try
    {
      int i = this.networkCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  // ERROR //
  @Nullable
  CacheRequest put(Response paramResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 210	okhttp3/Response:request	()Lokhttp3/Request;
    //   4: invokevirtual 213	okhttp3/Request:method	()Ljava/lang/String;
    //   7: astore_2
    //   8: aload_1
    //   9: invokevirtual 210	okhttp3/Response:request	()Lokhttp3/Request;
    //   12: invokevirtual 213	okhttp3/Request:method	()Ljava/lang/String;
    //   15: invokestatic 219	okhttp3/internal/http/HttpMethod:invalidatesCache	(Ljava/lang/String;)Z
    //   18: ifeq +13 -> 31
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 210	okhttp3/Response:request	()Lokhttp3/Request;
    //   26: invokevirtual 223	okhttp3/Cache:remove	(Lokhttp3/Request;)V
    //   29: aconst_null
    //   30: areturn
    //   31: aload_2
    //   32: ldc 225
    //   34: invokevirtual 229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifeq -8 -> 29
    //   40: aload_1
    //   41: invokestatic 235	okhttp3/internal/http/HttpHeaders:hasVaryAll	(Lokhttp3/Response;)Z
    //   44: ifne -15 -> 29
    //   47: new 160	okhttp3/Cache$Entry
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 238	okhttp3/Cache$Entry:<init>	(Lokhttp3/Response;)V
    //   55: astore_3
    //   56: aload_0
    //   57: getfield 55	okhttp3/Cache:cache	Lokhttp3/internal/cache/DiskLruCache;
    //   60: aload_1
    //   61: invokevirtual 210	okhttp3/Response:request	()Lokhttp3/Request;
    //   64: invokevirtual 153	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   67: invokestatic 155	okhttp3/Cache:key	(Lokhttp3/HttpUrl;)Ljava/lang/String;
    //   70: invokevirtual 242	okhttp3/internal/cache/DiskLruCache:edit	(Ljava/lang/String;)Lokhttp3/internal/cache/DiskLruCache$Editor;
    //   73: astore 6
    //   75: aload 6
    //   77: ifnull -48 -> 29
    //   80: aload_3
    //   81: aload 6
    //   83: invokevirtual 245	okhttp3/Cache$Entry:writeTo	(Lokhttp3/internal/cache/DiskLruCache$Editor;)V
    //   86: new 247	okhttp3/Cache$CacheRequestImpl
    //   89: dup
    //   90: aload_0
    //   91: aload 6
    //   93: invokespecial 250	okhttp3/Cache$CacheRequestImpl:<init>	(Lokhttp3/Cache;Lokhttp3/internal/cache/DiskLruCache$Editor;)V
    //   96: astore 8
    //   98: aload 8
    //   100: areturn
    //   101: astore 4
    //   103: aconst_null
    //   104: astore 5
    //   106: aload_0
    //   107: aload 5
    //   109: invokespecial 252	okhttp3/Cache:abortQuietly	(Lokhttp3/internal/cache/DiskLruCache$Editor;)V
    //   112: aconst_null
    //   113: areturn
    //   114: astore 7
    //   116: aload 6
    //   118: astore 5
    //   120: goto -14 -> 106
    //   123: astore 9
    //   125: aconst_null
    //   126: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   56	75	101	java/io/IOException
    //   80	98	114	java/io/IOException
    //   21	29	123	java/io/IOException
  }

  void remove(Request paramRequest)
    throws IOException
  {
    this.cache.remove(key(paramRequest.url()));
  }

  public int requestCount()
  {
    try
    {
      int i = this.requestCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public long size()
    throws IOException
  {
    return this.cache.size();
  }

  void trackConditionalCacheHit()
  {
    try
    {
      this.hitCount = (1 + this.hitCount);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void trackResponse(CacheStrategy paramCacheStrategy)
  {
    try
    {
      this.requestCount = (1 + this.requestCount);
      if (paramCacheStrategy.networkRequest != null)
        this.networkCount = (1 + this.networkCount);
      while (true)
      {
        return;
        if (paramCacheStrategy.cacheResponse != null)
          this.hitCount = (1 + this.hitCount);
      }
    }
    finally
    {
    }
  }

  void update(Response paramResponse1, Response paramResponse2)
  {
    Entry localEntry = new Entry(paramResponse2);
    DiskLruCache.Snapshot localSnapshot = ((CacheResponseBody)paramResponse1.body()).snapshot;
    DiskLruCache.Editor localEditor = null;
    try
    {
      localEditor = localSnapshot.edit();
      if (localEditor != null)
      {
        localEntry.writeTo(localEditor);
        localEditor.commit();
      }
      return;
    }
    catch (IOException localIOException)
    {
      abortQuietly(localEditor);
    }
  }

  public Iterator<String> urls()
    throws IOException
  {
    return new Iterator()
    {
      boolean canRemove;
      final Iterator<DiskLruCache.Snapshot> delegate = Cache.this.cache.snapshots();

      @Nullable
      String nextUrl;

      // ERROR //
      public boolean hasNext()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 46	okhttp3/Cache$2:nextUrl	Ljava/lang/String;
        //   4: ifnull +5 -> 9
        //   7: iconst_1
        //   8: ireturn
        //   9: aload_0
        //   10: iconst_0
        //   11: putfield 48	okhttp3/Cache$2:canRemove	Z
        //   14: aload_0
        //   15: getfield 42	okhttp3/Cache$2:delegate	Ljava/util/Iterator;
        //   18: invokeinterface 50 1 0
        //   23: ifeq +54 -> 77
        //   26: aload_0
        //   27: getfield 42	okhttp3/Cache$2:delegate	Ljava/util/Iterator;
        //   30: invokeinterface 54 1 0
        //   35: checkcast 56	okhttp3/internal/cache/DiskLruCache$Snapshot
        //   38: astore_1
        //   39: aload_0
        //   40: aload_1
        //   41: iconst_0
        //   42: invokevirtual 60	okhttp3/internal/cache/DiskLruCache$Snapshot:getSource	(I)Lf/t;
        //   45: invokestatic 66	f/l:a	(Lf/t;)Lf/e;
        //   48: invokeinterface 72 1 0
        //   53: putfield 46	okhttp3/Cache$2:nextUrl	Ljava/lang/String;
        //   56: aload_1
        //   57: invokevirtual 75	okhttp3/internal/cache/DiskLruCache$Snapshot:close	()V
        //   60: iconst_1
        //   61: ireturn
        //   62: astore_3
        //   63: aload_1
        //   64: invokevirtual 75	okhttp3/internal/cache/DiskLruCache$Snapshot:close	()V
        //   67: goto -53 -> 14
        //   70: astore_2
        //   71: aload_1
        //   72: invokevirtual 75	okhttp3/internal/cache/DiskLruCache$Snapshot:close	()V
        //   75: aload_2
        //   76: athrow
        //   77: iconst_0
        //   78: ireturn
        //
        // Exception table:
        //   from	to	target	type
        //   39	56	62	java/io/IOException
        //   39	56	70	finally
      }

      public String next()
      {
        if (!hasNext())
          throw new NoSuchElementException();
        String str = this.nextUrl;
        this.nextUrl = null;
        this.canRemove = true;
        return str;
      }

      public void remove()
      {
        if (!this.canRemove)
          throw new IllegalStateException("remove() before next()");
        this.delegate.remove();
      }
    };
  }

  public int writeAbortCount()
  {
    try
    {
      int i = this.writeAbortCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int writeSuccessCount()
  {
    try
    {
      int i = this.writeSuccessCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private final class CacheRequestImpl
    implements CacheRequest
  {
    private s body;
    private s cacheOut;
    boolean done;
    private final DiskLruCache.Editor editor;

    CacheRequestImpl(DiskLruCache.Editor arg2)
    {
      final DiskLruCache.Editor localEditor;
      this.editor = localEditor;
      this.cacheOut = localEditor.newSink(1);
      this.body = new g(this.cacheOut)
      {
        public void close()
          throws IOException
        {
          synchronized (Cache.this)
          {
            if (Cache.CacheRequestImpl.this.done)
              return;
            Cache.CacheRequestImpl.this.done = true;
            Cache localCache2 = Cache.this;
            localCache2.writeSuccessCount = (1 + localCache2.writeSuccessCount);
            super.close();
            localEditor.commit();
            return;
          }
        }
      };
    }

    public void abort()
    {
      synchronized (Cache.this)
      {
        if (this.done)
          return;
        this.done = true;
        Cache localCache2 = Cache.this;
        localCache2.writeAbortCount = (1 + localCache2.writeAbortCount);
        Util.closeQuietly(this.cacheOut);
        try
        {
          this.editor.abort();
          return;
        }
        catch (IOException localIOException)
        {
        }
      }
    }

    public s body()
    {
      return this.body;
    }
  }

  private static class CacheResponseBody extends ResponseBody
  {
    private final e bodySource;

    @Nullable
    private final String contentLength;

    @Nullable
    private final String contentType;
    final DiskLruCache.Snapshot snapshot;

    CacheResponseBody(final DiskLruCache.Snapshot paramSnapshot, String paramString1, String paramString2)
    {
      this.snapshot = paramSnapshot;
      this.contentType = paramString1;
      this.contentLength = paramString2;
      this.bodySource = l.a(new h(paramSnapshot.getSource(1))
      {
        public void close()
          throws IOException
        {
          paramSnapshot.close();
          super.close();
        }
      });
    }

    public long contentLength()
    {
      long l1 = -1L;
      try
      {
        if (this.contentLength != null)
        {
          long l2 = Long.parseLong(this.contentLength);
          l1 = l2;
        }
        return l1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
      return l1;
    }

    public MediaType contentType()
    {
      if (this.contentType != null)
        return MediaType.parse(this.contentType);
      return null;
    }

    public e source()
    {
      return this.bodySource;
    }
  }

  private static final class Entry
  {
    private static final String RECEIVED_MILLIS = Platform.get().getPrefix() + "-Received-Millis";
    private static final String SENT_MILLIS = Platform.get().getPrefix() + "-Sent-Millis";
    private final int code;

    @Nullable
    private final Handshake handshake;
    private final String message;
    private final Protocol protocol;
    private final long receivedResponseMillis;
    private final String requestMethod;
    private final Headers responseHeaders;
    private final long sentRequestMillis;
    private final String url;
    private final Headers varyHeaders;

    Entry(t paramt)
      throws IOException
    {
      e locale;
      while (true)
      {
        try
        {
          locale = l.a(paramt);
          this.url = locale.s();
          this.requestMethod = locale.s();
          Headers.Builder localBuilder1 = new Headers.Builder();
          int j = Cache.readInt(locale);
          int k = 0;
          if (k < j)
          {
            localBuilder1.addLenient(locale.s());
            k++;
            continue;
          }
          this.varyHeaders = localBuilder1.build();
          StatusLine localStatusLine = StatusLine.parse(locale.s());
          this.protocol = localStatusLine.protocol;
          this.code = localStatusLine.code;
          this.message = localStatusLine.message;
          Headers.Builder localBuilder2 = new Headers.Builder();
          int m = Cache.readInt(locale);
          if (i < m)
          {
            localBuilder2.addLenient(locale.s());
            i++;
            continue;
          }
          String str1 = localBuilder2.get(SENT_MILLIS);
          String str2 = localBuilder2.get(RECEIVED_MILLIS);
          localBuilder2.removeAll(SENT_MILLIS);
          localBuilder2.removeAll(RECEIVED_MILLIS);
          if (str1 != null)
          {
            l2 = Long.parseLong(str1);
            this.sentRequestMillis = l2;
            if (str2 != null)
              l1 = Long.parseLong(str2);
            this.receivedResponseMillis = l1;
            this.responseHeaders = localBuilder2.build();
            if (!isHttps())
              break label407;
            String str3 = locale.s();
            if (str3.length() <= 0)
              break;
            throw new IOException("expected \"\" but was \"" + str3 + "\"");
          }
        }
        finally
        {
          paramt.close();
        }
        long l2 = l1;
      }
      CipherSuite localCipherSuite = CipherSuite.forJavaName(locale.s());
      List localList1 = readCertificateList(locale);
      List localList2 = readCertificateList(locale);
      TlsVersion localTlsVersion;
      if (!locale.f())
        localTlsVersion = TlsVersion.forJavaName(locale.s());
      label407: for (this.handshake = Handshake.get(localTlsVersion, localCipherSuite, localList1, localList2); ; this.handshake = null)
      {
        paramt.close();
        return;
        localTlsVersion = TlsVersion.SSL_3_0;
        break;
      }
    }

    Entry(Response paramResponse)
    {
      this.url = paramResponse.request().url().toString();
      this.varyHeaders = HttpHeaders.varyHeaders(paramResponse);
      this.requestMethod = paramResponse.request().method();
      this.protocol = paramResponse.protocol();
      this.code = paramResponse.code();
      this.message = paramResponse.message();
      this.responseHeaders = paramResponse.headers();
      this.handshake = paramResponse.handshake();
      this.sentRequestMillis = paramResponse.sentRequestAtMillis();
      this.receivedResponseMillis = paramResponse.receivedResponseAtMillis();
    }

    private boolean isHttps()
    {
      return this.url.startsWith("https://");
    }

    private List<Certificate> readCertificateList(e parame)
      throws IOException
    {
      int i = Cache.readInt(parame);
      Object localObject;
      if (i == -1)
        localObject = Collections.emptyList();
      while (true)
      {
        return localObject;
        try
        {
          CertificateFactory localCertificateFactory = CertificateFactory.getInstance("X.509");
          localObject = new ArrayList(i);
          for (int j = 0; j < i; j++)
          {
            String str = parame.s();
            c localc = new c();
            localc.a(f.b(str));
            ((List)localObject).add(localCertificateFactory.generateCertificate(localc.g()));
          }
        }
        catch (CertificateException localCertificateException)
        {
          throw new IOException(localCertificateException.getMessage());
        }
      }
    }

    private void writeCertList(d paramd, List<Certificate> paramList)
      throws IOException
    {
      try
      {
        paramd.n(paramList.size()).i(10);
        int i = paramList.size();
        for (int j = 0; j < i; j++)
          paramd.b(f.a(((Certificate)paramList.get(j)).getEncoded()).b()).i(10);
      }
      catch (CertificateEncodingException localCertificateEncodingException)
      {
        throw new IOException(localCertificateEncodingException.getMessage());
      }
    }

    public boolean matches(Request paramRequest, Response paramResponse)
    {
      return (this.url.equals(paramRequest.url().toString())) && (this.requestMethod.equals(paramRequest.method())) && (HttpHeaders.varyMatches(paramResponse, this.varyHeaders, paramRequest));
    }

    public Response response(DiskLruCache.Snapshot paramSnapshot)
    {
      String str1 = this.responseHeaders.get("Content-Type");
      String str2 = this.responseHeaders.get("Content-Length");
      Request localRequest = new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build();
      return new Response.Builder().request(localRequest).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new Cache.CacheResponseBody(paramSnapshot, str1, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
    }

    public void writeTo(DiskLruCache.Editor paramEditor)
      throws IOException
    {
      int i = 0;
      d locald = l.a(paramEditor.newSink(0));
      locald.b(this.url).i(10);
      locald.b(this.requestMethod).i(10);
      locald.n(this.varyHeaders.size()).i(10);
      int j = this.varyHeaders.size();
      for (int k = 0; k < j; k++)
        locald.b(this.varyHeaders.name(k)).b(": ").b(this.varyHeaders.value(k)).i(10);
      locald.b(new StatusLine(this.protocol, this.code, this.message).toString()).i(10);
      locald.n(2 + this.responseHeaders.size()).i(10);
      int m = this.responseHeaders.size();
      while (i < m)
      {
        locald.b(this.responseHeaders.name(i)).b(": ").b(this.responseHeaders.value(i)).i(10);
        i++;
      }
      locald.b(SENT_MILLIS).b(": ").n(this.sentRequestMillis).i(10);
      locald.b(RECEIVED_MILLIS).b(": ").n(this.receivedResponseMillis).i(10);
      if (isHttps())
      {
        locald.i(10);
        locald.b(this.handshake.cipherSuite().javaName()).i(10);
        writeCertList(locald, this.handshake.peerCertificates());
        writeCertList(locald, this.handshake.localCertificates());
        locald.b(this.handshake.tlsVersion().javaName()).i(10);
      }
      locald.close();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.Cache
 * JD-Core Version:    0.6.2
 */
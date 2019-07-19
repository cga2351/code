package okhttp3.internal.cache2;

import f.c;
import f.f;
import f.t;
import f.u;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import okhttp3.internal.Util;

final class Relay
{
  private static final long FILE_HEADER_SIZE = 32L;
  static final f PREFIX_CLEAN = f.a("OkHttp cache v1\n");
  static final f PREFIX_DIRTY = f.a("OkHttp DIRTY :(\n");
  private static final int SOURCE_FILE = 2;
  private static final int SOURCE_UPSTREAM = 1;
  final c buffer = new c();
  final long bufferMaxSize;
  boolean complete;
  RandomAccessFile file;
  private final f metadata;
  int sourceCount;
  t upstream;
  final c upstreamBuffer = new c();
  long upstreamPos;
  Thread upstreamReader;

  private Relay(RandomAccessFile paramRandomAccessFile, t paramt, long paramLong1, f paramf, long paramLong2)
  {
    this.file = paramRandomAccessFile;
    this.upstream = paramt;
    if (paramt == null);
    for (boolean bool = true; ; bool = false)
    {
      this.complete = bool;
      this.upstreamPos = paramLong1;
      this.metadata = paramf;
      this.bufferMaxSize = paramLong2;
      return;
    }
  }

  public static Relay edit(File paramFile, t paramt, f paramf, long paramLong)
    throws IOException
  {
    RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "rw");
    Relay localRelay = new Relay(localRandomAccessFile, paramt, 0L, paramf, paramLong);
    localRandomAccessFile.setLength(0L);
    localRelay.writeHeader(PREFIX_DIRTY, -1L, -1L);
    return localRelay;
  }

  public static Relay read(File paramFile)
    throws IOException
  {
    RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "rw");
    FileOperator localFileOperator = new FileOperator(localRandomAccessFile.getChannel());
    c localc1 = new c();
    localFileOperator.read(0L, localc1, 32L);
    if (!localc1.d(PREFIX_CLEAN.h()).equals(PREFIX_CLEAN))
      throw new IOException("unreadable cache file");
    long l1 = localc1.l();
    long l2 = localc1.l();
    c localc2 = new c();
    localFileOperator.read(32L + l1, localc2, l2);
    return new Relay(localRandomAccessFile, null, l1, localc2.q(), 0L);
  }

  private void writeHeader(f paramf, long paramLong1, long paramLong2)
    throws IOException
  {
    c localc = new c();
    localc.a(paramf);
    localc.j(paramLong1);
    localc.j(paramLong2);
    if (localc.a() != 32L)
      throw new IllegalArgumentException();
    new FileOperator(this.file.getChannel()).write(0L, localc, 32L);
  }

  private void writeMetadata(long paramLong)
    throws IOException
  {
    c localc = new c();
    localc.a(this.metadata);
    new FileOperator(this.file.getChannel()).write(32L + paramLong, localc, this.metadata.h());
  }

  void commit(long paramLong)
    throws IOException
  {
    writeMetadata(paramLong);
    this.file.getChannel().force(false);
    writeHeader(PREFIX_CLEAN, paramLong, this.metadata.h());
    this.file.getChannel().force(false);
    try
    {
      this.complete = true;
      Util.closeQuietly(this.upstream);
      this.upstream = null;
      return;
    }
    finally
    {
    }
  }

  boolean isClosed()
  {
    return this.file == null;
  }

  public f metadata()
  {
    return this.metadata;
  }

  public t newSource()
  {
    try
    {
      if (this.file == null)
        return null;
      this.sourceCount = (1 + this.sourceCount);
      return new RelaySource();
    }
    finally
    {
    }
  }

  class RelaySource
    implements t
  {
    private FileOperator fileOperator = new FileOperator(Relay.this.file.getChannel());
    private long sourcePos;
    private final u timeout = new u();

    RelaySource()
    {
    }

    public void close()
      throws IOException
    {
      if (this.fileOperator == null);
      while (true)
      {
        return;
        this.fileOperator = null;
        synchronized (Relay.this)
        {
          Relay localRelay2 = Relay.this;
          localRelay2.sourceCount = (-1 + localRelay2.sourceCount);
          int i = Relay.this.sourceCount;
          RandomAccessFile localRandomAccessFile = null;
          if (i == 0)
          {
            localRandomAccessFile = Relay.this.file;
            Relay.this.file = null;
          }
          if (localRandomAccessFile == null)
            continue;
          Util.closeQuietly(localRandomAccessFile);
          return;
        }
      }
    }

    // ERROR //
    public long read(c paramc, long paramLong)
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 45	okhttp3/internal/cache2/Relay$RelaySource:fileOperator	Lokhttp3/internal/cache2/FileOperator;
      //   4: ifnonnull +13 -> 17
      //   7: new 62	java/lang/IllegalStateException
      //   10: dup
      //   11: ldc 64
      //   13: invokespecial 67	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   16: athrow
      //   17: aload_0
      //   18: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   21: astore 4
      //   23: aload 4
      //   25: monitorenter
      //   26: aload_0
      //   27: getfield 69	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   30: lstore 6
      //   32: aload_0
      //   33: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   36: getfield 72	okhttp3/internal/cache2/Relay:upstreamPos	J
      //   39: lstore 8
      //   41: lload 6
      //   43: lload 8
      //   45: lcmp
      //   46: ifne +119 -> 165
      //   49: aload_0
      //   50: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   53: getfield 76	okhttp3/internal/cache2/Relay:complete	Z
      //   56: ifeq +10 -> 66
      //   59: aload 4
      //   61: monitorexit
      //   62: ldc2_w 77
      //   65: lreturn
      //   66: aload_0
      //   67: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   70: getfield 82	okhttp3/internal/cache2/Relay:upstreamReader	Ljava/lang/Thread;
      //   73: ifnull +25 -> 98
      //   76: aload_0
      //   77: getfield 26	okhttp3/internal/cache2/Relay$RelaySource:timeout	Lf/u;
      //   80: aload_0
      //   81: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   84: invokevirtual 86	f/u:waitUntilNotified	(Ljava/lang/Object;)V
      //   87: goto -61 -> 26
      //   90: astore 5
      //   92: aload 4
      //   94: monitorexit
      //   95: aload 5
      //   97: athrow
      //   98: aload_0
      //   99: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   102: invokestatic 92	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   105: putfield 82	okhttp3/internal/cache2/Relay:upstreamReader	Ljava/lang/Thread;
      //   108: iconst_1
      //   109: istore 10
      //   111: aload 4
      //   113: monitorexit
      //   114: iload 10
      //   116: iconst_2
      //   117: if_icmpne +133 -> 250
      //   120: lload_2
      //   121: lload 8
      //   123: aload_0
      //   124: getfield 69	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   127: lsub
      //   128: invokestatic 98	java/lang/Math:min	(JJ)J
      //   131: lstore 26
      //   133: aload_0
      //   134: getfield 45	okhttp3/internal/cache2/Relay$RelaySource:fileOperator	Lokhttp3/internal/cache2/FileOperator;
      //   137: ldc2_w 99
      //   140: aload_0
      //   141: getfield 69	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   144: ladd
      //   145: aload_1
      //   146: lload 26
      //   148: invokevirtual 103	okhttp3/internal/cache2/FileOperator:read	(JLf/c;J)V
      //   151: aload_0
      //   152: lload 26
      //   154: aload_0
      //   155: getfield 69	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   158: ladd
      //   159: putfield 69	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   162: lload 26
      //   164: lreturn
      //   165: lload 8
      //   167: aload_0
      //   168: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   171: getfield 107	okhttp3/internal/cache2/Relay:buffer	Lf/c;
      //   174: invokevirtual 113	f/c:a	()J
      //   177: lsub
      //   178: lstore 28
      //   180: aload_0
      //   181: getfield 69	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   184: lload 28
      //   186: lcmp
      //   187: ifge +12 -> 199
      //   190: iconst_2
      //   191: istore 10
      //   193: aload 4
      //   195: monitorexit
      //   196: goto -82 -> 114
      //   199: lload_2
      //   200: lload 8
      //   202: aload_0
      //   203: getfield 69	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   206: lsub
      //   207: invokestatic 98	java/lang/Math:min	(JJ)J
      //   210: lstore 30
      //   212: aload_0
      //   213: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   216: getfield 107	okhttp3/internal/cache2/Relay:buffer	Lf/c;
      //   219: aload_1
      //   220: aload_0
      //   221: getfield 69	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   224: lload 28
      //   226: lsub
      //   227: lload 30
      //   229: invokevirtual 116	f/c:a	(Lf/c;JJ)Lf/c;
      //   232: pop
      //   233: aload_0
      //   234: lload 30
      //   236: aload_0
      //   237: getfield 69	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   240: ladd
      //   241: putfield 69	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   244: aload 4
      //   246: monitorexit
      //   247: lload 30
      //   249: lreturn
      //   250: aload_0
      //   251: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   254: getfield 120	okhttp3/internal/cache2/Relay:upstream	Lf/t;
      //   257: aload_0
      //   258: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   261: getfield 123	okhttp3/internal/cache2/Relay:upstreamBuffer	Lf/c;
      //   264: aload_0
      //   265: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   268: getfield 126	okhttp3/internal/cache2/Relay:bufferMaxSize	J
      //   271: invokeinterface 128 4 0
      //   276: lstore 14
      //   278: lload 14
      //   280: ldc2_w 77
      //   283: lcmp
      //   284: ifne +51 -> 335
      //   287: aload_0
      //   288: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   291: lload 8
      //   293: invokevirtual 132	okhttp3/internal/cache2/Relay:commit	(J)V
      //   296: aload_0
      //   297: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   300: astore 16
      //   302: aload 16
      //   304: monitorenter
      //   305: aload_0
      //   306: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   309: aconst_null
      //   310: putfield 82	okhttp3/internal/cache2/Relay:upstreamReader	Ljava/lang/Thread;
      //   313: aload_0
      //   314: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   317: invokevirtual 135	java/lang/Object:notifyAll	()V
      //   320: aload 16
      //   322: monitorexit
      //   323: ldc2_w 77
      //   326: lreturn
      //   327: astore 17
      //   329: aload 16
      //   331: monitorexit
      //   332: aload 17
      //   334: athrow
      //   335: lload 14
      //   337: lload_2
      //   338: invokestatic 98	java/lang/Math:min	(JJ)J
      //   341: lstore 18
      //   343: aload_0
      //   344: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   347: getfield 123	okhttp3/internal/cache2/Relay:upstreamBuffer	Lf/c;
      //   350: aload_1
      //   351: lconst_0
      //   352: lload 18
      //   354: invokevirtual 116	f/c:a	(Lf/c;JJ)Lf/c;
      //   357: pop
      //   358: aload_0
      //   359: lload 18
      //   361: aload_0
      //   362: getfield 69	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   365: ladd
      //   366: putfield 69	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   369: aload_0
      //   370: getfield 45	okhttp3/internal/cache2/Relay$RelaySource:fileOperator	Lokhttp3/internal/cache2/FileOperator;
      //   373: ldc2_w 99
      //   376: lload 8
      //   378: ladd
      //   379: aload_0
      //   380: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   383: getfield 123	okhttp3/internal/cache2/Relay:upstreamBuffer	Lf/c;
      //   386: invokevirtual 139	f/c:w	()Lf/c;
      //   389: lload 14
      //   391: invokevirtual 142	okhttp3/internal/cache2/FileOperator:write	(JLf/c;J)V
      //   394: aload_0
      //   395: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   398: astore 21
      //   400: aload 21
      //   402: monitorenter
      //   403: aload_0
      //   404: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   407: getfield 107	okhttp3/internal/cache2/Relay:buffer	Lf/c;
      //   410: aload_0
      //   411: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   414: getfield 123	okhttp3/internal/cache2/Relay:upstreamBuffer	Lf/c;
      //   417: lload 14
      //   419: invokevirtual 145	f/c:write	(Lf/c;J)V
      //   422: aload_0
      //   423: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   426: getfield 107	okhttp3/internal/cache2/Relay:buffer	Lf/c;
      //   429: invokevirtual 113	f/c:a	()J
      //   432: aload_0
      //   433: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   436: getfield 126	okhttp3/internal/cache2/Relay:bufferMaxSize	J
      //   439: lcmp
      //   440: ifle +31 -> 471
      //   443: aload_0
      //   444: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   447: getfield 107	okhttp3/internal/cache2/Relay:buffer	Lf/c;
      //   450: aload_0
      //   451: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   454: getfield 107	okhttp3/internal/cache2/Relay:buffer	Lf/c;
      //   457: invokevirtual 113	f/c:a	()J
      //   460: aload_0
      //   461: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   464: getfield 126	okhttp3/internal/cache2/Relay:bufferMaxSize	J
      //   467: lsub
      //   468: invokevirtual 148	f/c:i	(J)V
      //   471: aload_0
      //   472: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   475: astore 23
      //   477: aload 23
      //   479: lload 14
      //   481: aload 23
      //   483: getfield 72	okhttp3/internal/cache2/Relay:upstreamPos	J
      //   486: ladd
      //   487: putfield 72	okhttp3/internal/cache2/Relay:upstreamPos	J
      //   490: aload 21
      //   492: monitorexit
      //   493: aload_0
      //   494: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   497: astore 24
      //   499: aload 24
      //   501: monitorenter
      //   502: aload_0
      //   503: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   506: aconst_null
      //   507: putfield 82	okhttp3/internal/cache2/Relay:upstreamReader	Ljava/lang/Thread;
      //   510: aload_0
      //   511: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   514: invokevirtual 135	java/lang/Object:notifyAll	()V
      //   517: aload 24
      //   519: monitorexit
      //   520: lload 18
      //   522: lreturn
      //   523: astore 25
      //   525: aload 24
      //   527: monitorexit
      //   528: aload 25
      //   530: athrow
      //   531: astore 22
      //   533: aload 21
      //   535: monitorexit
      //   536: aload 22
      //   538: athrow
      //   539: astore 11
      //   541: aload_0
      //   542: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   545: astore 12
      //   547: aload 12
      //   549: monitorenter
      //   550: aload_0
      //   551: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   554: aconst_null
      //   555: putfield 82	okhttp3/internal/cache2/Relay:upstreamReader	Ljava/lang/Thread;
      //   558: aload_0
      //   559: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   562: invokevirtual 135	java/lang/Object:notifyAll	()V
      //   565: aload 12
      //   567: monitorexit
      //   568: aload 11
      //   570: athrow
      //   571: astore 13
      //   573: aload 12
      //   575: monitorexit
      //   576: aload 13
      //   578: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   26	41	90	finally
      //   49	62	90	finally
      //   66	87	90	finally
      //   92	95	90	finally
      //   98	108	90	finally
      //   111	114	90	finally
      //   165	190	90	finally
      //   193	196	90	finally
      //   199	247	90	finally
      //   305	323	327	finally
      //   329	332	327	finally
      //   502	520	523	finally
      //   525	528	523	finally
      //   403	471	531	finally
      //   471	493	531	finally
      //   533	536	531	finally
      //   250	278	539	finally
      //   287	296	539	finally
      //   335	403	539	finally
      //   536	539	539	finally
      //   550	568	571	finally
      //   573	576	571	finally
    }

    public u timeout()
    {
      return this.timeout;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.cache2.Relay
 * JD-Core Version:    0.6.2
 */
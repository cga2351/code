package okhttp3.internal.http2;

import f.c;
import f.e;
import f.f;
import f.t;
import f.u;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;

final class Http2Reader
  implements Closeable
{
  static final Logger logger = Logger.getLogger(Http2.class.getName());
  private final boolean client;
  private final ContinuationSource continuation;
  final Hpack.Reader hpackReader;
  private final e source;

  Http2Reader(e parame, boolean paramBoolean)
  {
    this.source = parame;
    this.client = paramBoolean;
    this.continuation = new ContinuationSource(this.source);
    this.hpackReader = new Hpack.Reader(4096, this.continuation);
  }

  static int lengthWithoutPadding(int paramInt, byte paramByte, short paramShort)
    throws IOException
  {
    if ((paramByte & 0x8) != 0)
      paramInt--;
    if (paramShort > paramInt)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Short.valueOf(paramShort);
      arrayOfObject[1] = Integer.valueOf(paramInt);
      throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", arrayOfObject);
    }
    return (short)(paramInt - paramShort);
  }

  private void readData(Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    boolean bool1 = true;
    if (paramInt2 == 0)
      throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    boolean bool2;
    if ((paramByte & 0x1) != 0)
    {
      bool2 = bool1;
      if ((paramByte & 0x20) == 0)
        break label56;
    }
    while (true)
    {
      if (!bool1)
        break label62;
      throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
      bool2 = false;
      break;
      label56: bool1 = false;
    }
    label62: int i = paramByte & 0x8;
    short s = 0;
    if (i != 0)
      s = (short)(0xFF & this.source.i());
    int j = lengthWithoutPadding(paramInt1, paramByte, s);
    paramHandler.data(bool2, paramInt2, this.source, j);
    this.source.i(s);
  }

  private void readGoAway(Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    if (paramInt1 < 8)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(paramInt1);
      throw Http2.ioException("TYPE_GOAWAY length < 8: %s", arrayOfObject2);
    }
    if (paramInt2 != 0)
      throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
    int i = this.source.k();
    int j = this.source.k();
    int k = paramInt1 - 8;
    ErrorCode localErrorCode = ErrorCode.fromHttp2(j);
    if (localErrorCode == null)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(j);
      throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", arrayOfObject1);
    }
    f localf = f.b;
    if (k > 0)
      localf = this.source.d(k);
    paramHandler.goAway(i, localErrorCode, localf);
  }

  private List<Header> readHeaderBlock(int paramInt1, short paramShort, byte paramByte, int paramInt2)
    throws IOException
  {
    ContinuationSource localContinuationSource = this.continuation;
    this.continuation.left = paramInt1;
    localContinuationSource.length = paramInt1;
    this.continuation.padding = paramShort;
    this.continuation.flags = paramByte;
    this.continuation.streamId = paramInt2;
    this.hpackReader.readHeaders();
    return this.hpackReader.getAndResetHeaderList();
  }

  private void readHeaders(Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    if (paramInt2 == 0)
      throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    if ((paramByte & 0x1) != 0);
    for (boolean bool = true; ; bool = false)
    {
      int i = paramByte & 0x8;
      short s = 0;
      if (i != 0)
        s = (short)(0xFF & this.source.i());
      if ((paramByte & 0x20) != 0)
      {
        readPriority(paramHandler, paramInt2);
        paramInt1 -= 5;
      }
      paramHandler.headers(bool, paramInt2, -1, readHeaderBlock(lengthWithoutPadding(paramInt1, paramByte, s), s, paramByte, paramInt2));
      return;
    }
  }

  static int readMedium(e parame)
    throws IOException
  {
    return (0xFF & parame.i()) << 16 | (0xFF & parame.i()) << 8 | 0xFF & parame.i();
  }

  private void readPing(Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    boolean bool = true;
    if (paramInt1 != 8)
    {
      Object[] arrayOfObject = new Object[bool];
      arrayOfObject[0] = Integer.valueOf(paramInt1);
      throw Http2.ioException("TYPE_PING length != 8: %s", arrayOfObject);
    }
    if (paramInt2 != 0)
      throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
    int i = this.source.k();
    int j = this.source.k();
    if ((paramByte & 0x1) != 0);
    while (true)
    {
      paramHandler.ping(bool, i, j);
      return;
      bool = false;
    }
  }

  private void readPriority(Handler paramHandler, int paramInt)
    throws IOException
  {
    int i = this.source.k();
    if ((0x80000000 & i) != 0);
    for (boolean bool = true; ; bool = false)
    {
      paramHandler.priority(paramInt, i & 0x7FFFFFFF, 1 + (0xFF & this.source.i()), bool);
      return;
    }
  }

  private void readPriority(Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    if (paramInt1 != 5)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt1);
      throw Http2.ioException("TYPE_PRIORITY length: %d != 5", arrayOfObject);
    }
    if (paramInt2 == 0)
      throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
    readPriority(paramHandler, paramInt2);
  }

  private void readPushPromise(Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    if (paramInt2 == 0)
      throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    int i = paramByte & 0x8;
    short s = 0;
    if (i != 0)
      s = (short)(0xFF & this.source.i());
    paramHandler.pushPromise(paramInt2, 0x7FFFFFFF & this.source.k(), readHeaderBlock(lengthWithoutPadding(paramInt1 - 4, paramByte, s), s, paramByte, paramInt2));
  }

  private void readRstStream(Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    if (paramInt1 != 4)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(paramInt1);
      throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", arrayOfObject2);
    }
    if (paramInt2 == 0)
      throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
    int i = this.source.k();
    ErrorCode localErrorCode = ErrorCode.fromHttp2(i);
    if (localErrorCode == null)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(i);
      throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", arrayOfObject1);
    }
    paramHandler.rstStream(paramInt2, localErrorCode);
  }

  private void readSettings(Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    if (paramInt2 != 0)
      throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
    if ((paramByte & 0x1) != 0)
    {
      if (paramInt1 != 0)
        throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
      paramHandler.ackSettings();
      return;
    }
    if (paramInt1 % 6 != 0)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(paramInt1);
      throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", arrayOfObject2);
    }
    Settings localSettings = new Settings();
    int i = 0;
    if (i < paramInt1)
    {
      int j = 0xFFFF & this.source.j();
      int k = this.source.k();
      switch (j)
      {
      case 1:
      case 6:
      default:
      case 2:
      case 3:
      case 4:
      case 5:
      }
      do
      {
        do
        {
          while (true)
          {
            localSettings.set(j, k);
            i += 6;
            break;
            if ((k != 0) && (k != 1))
            {
              throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
              j = 4;
            }
          }
          j = 7;
        }
        while (k >= 0);
        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
      }
      while ((k >= 16384) && (k <= 16777215));
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(k);
      throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", arrayOfObject1);
    }
    paramHandler.settings(false, localSettings);
  }

  private void readWindowUpdate(Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    if (paramInt1 != 4)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(paramInt1);
      throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", arrayOfObject2);
    }
    long l = 0x7FFFFFFF & this.source.k();
    if (l == 0L)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Long.valueOf(l);
      throw Http2.ioException("windowSizeIncrement was 0", arrayOfObject1);
    }
    paramHandler.windowUpdate(paramInt2, l);
  }

  public void close()
    throws IOException
  {
    this.source.close();
  }

  public boolean nextFrame(boolean paramBoolean, Handler paramHandler)
    throws IOException
  {
    int i;
    try
    {
      this.source.a(9L);
      i = readMedium(this.source);
      if ((i < 0) || (i > 16384))
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(i);
        throw Http2.ioException("FRAME_SIZE_ERROR: %s", arrayOfObject1);
      }
    }
    catch (IOException localIOException)
    {
      return false;
    }
    byte b1 = (byte)(0xFF & this.source.i());
    if ((paramBoolean) && (b1 != 4))
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Byte.valueOf(b1);
      throw Http2.ioException("Expected a SETTINGS frame but was %s", arrayOfObject2);
    }
    byte b2 = (byte)(0xFF & this.source.i());
    int j = 0x7FFFFFFF & this.source.k();
    if (logger.isLoggable(Level.FINE))
      logger.fine(Http2.frameLog(true, j, i, b1, b2));
    switch (b1)
    {
    default:
      this.source.i(i);
      return true;
    case 0:
      readData(paramHandler, i, b2, j);
      return true;
    case 1:
      readHeaders(paramHandler, i, b2, j);
      return true;
    case 2:
      readPriority(paramHandler, i, b2, j);
      return true;
    case 3:
      readRstStream(paramHandler, i, b2, j);
      return true;
    case 4:
      readSettings(paramHandler, i, b2, j);
      return true;
    case 5:
      readPushPromise(paramHandler, i, b2, j);
      return true;
    case 6:
      readPing(paramHandler, i, b2, j);
      return true;
    case 7:
      readGoAway(paramHandler, i, b2, j);
      return true;
    case 8:
    }
    readWindowUpdate(paramHandler, i, b2, j);
    return true;
  }

  public void readConnectionPreface(Handler paramHandler)
    throws IOException
  {
    if (this.client)
    {
      if (!nextFrame(true, paramHandler))
        throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
    }
    else
    {
      f localf = this.source.d(Http2.CONNECTION_PREFACE.h());
      if (logger.isLoggable(Level.FINE))
      {
        Logger localLogger = logger;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = localf.f();
        localLogger.fine(Util.format("<< CONNECTION %s", arrayOfObject2));
      }
      if (!Http2.CONNECTION_PREFACE.equals(localf))
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = localf.a();
        throw Http2.ioException("Expected a connection header but was %s", arrayOfObject1);
      }
    }
  }

  static final class ContinuationSource
    implements t
  {
    byte flags;
    int left;
    int length;
    short padding;
    private final e source;
    int streamId;

    ContinuationSource(e parame)
    {
      this.source = parame;
    }

    private void readContinuationHeader()
      throws IOException
    {
      int i = this.streamId;
      int j = Http2Reader.readMedium(this.source);
      this.left = j;
      this.length = j;
      byte b = (byte)(0xFF & this.source.i());
      this.flags = ((byte)(0xFF & this.source.i()));
      if (Http2Reader.logger.isLoggable(Level.FINE))
        Http2Reader.logger.fine(Http2.frameLog(true, this.streamId, this.length, b, this.flags));
      this.streamId = (0x7FFFFFFF & this.source.k());
      if (b != 9)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Byte.valueOf(b);
        throw Http2.ioException("%s != TYPE_CONTINUATION", arrayOfObject);
      }
      if (this.streamId != i)
        throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
    }

    public void close()
      throws IOException
    {
    }

    public long read(c paramc, long paramLong)
      throws IOException
    {
      if (this.left == 0)
      {
        this.source.i(this.padding);
        this.padding = 0;
        if ((0x4 & this.flags) == 0);
      }
      long l;
      do
      {
        return -1L;
        readContinuationHeader();
        break;
        l = this.source.read(paramc, Math.min(paramLong, this.left));
      }
      while (l == -1L);
      this.left = ((int)(this.left - l));
      return l;
    }

    public u timeout()
    {
      return this.source.timeout();
    }
  }

  static abstract interface Handler
  {
    public abstract void ackSettings();

    public abstract void alternateService(int paramInt1, String paramString1, f paramf, String paramString2, int paramInt2, long paramLong);

    public abstract void data(boolean paramBoolean, int paramInt1, e parame, int paramInt2)
      throws IOException;

    public abstract void goAway(int paramInt, ErrorCode paramErrorCode, f paramf);

    public abstract void headers(boolean paramBoolean, int paramInt1, int paramInt2, List<Header> paramList);

    public abstract void ping(boolean paramBoolean, int paramInt1, int paramInt2);

    public abstract void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);

    public abstract void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
      throws IOException;

    public abstract void rstStream(int paramInt, ErrorCode paramErrorCode);

    public abstract void settings(boolean paramBoolean, Settings paramSettings);

    public abstract void windowUpdate(int paramInt, long paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Reader
 * JD-Core Version:    0.6.2
 */
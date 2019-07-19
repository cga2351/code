package okhttp3.internal.http2;

import f.c;
import f.d;
import f.f;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;

final class Http2Writer
  implements Closeable
{
  private static final Logger logger = Logger.getLogger(Http2.class.getName());
  private final boolean client;
  private boolean closed;
  private final c hpackBuffer;
  final Hpack.Writer hpackWriter;
  private int maxFrameSize;
  private final d sink;

  Http2Writer(d paramd, boolean paramBoolean)
  {
    this.sink = paramd;
    this.client = paramBoolean;
    this.hpackBuffer = new c();
    this.hpackWriter = new Hpack.Writer(this.hpackBuffer);
    this.maxFrameSize = 16384;
  }

  private void writeContinuationFrames(int paramInt, long paramLong)
    throws IOException
  {
    if (paramLong > 0L)
    {
      int i = (int)Math.min(this.maxFrameSize, paramLong);
      paramLong -= i;
      if (paramLong == 0L);
      for (byte b = 4; ; b = 0)
      {
        frameHeader(paramInt, i, (byte)9, b);
        this.sink.write(this.hpackBuffer, i);
        break;
      }
    }
  }

  private static void writeMedium(d paramd, int paramInt)
    throws IOException
  {
    paramd.i(0xFF & paramInt >>> 16);
    paramd.i(0xFF & paramInt >>> 8);
    paramd.i(paramInt & 0xFF);
  }

  public void applyAndAckSettings(Settings paramSettings)
    throws IOException
  {
    try
    {
      if (this.closed)
        throw new IOException("closed");
    }
    finally
    {
    }
    this.maxFrameSize = paramSettings.getMaxFrameSize(this.maxFrameSize);
    if (paramSettings.getHeaderTableSize() != -1)
      this.hpackWriter.setHeaderTableSizeSetting(paramSettings.getHeaderTableSize());
    frameHeader(0, 0, (byte)4, (byte)1);
    this.sink.flush();
  }

  public void close()
    throws IOException
  {
    try
    {
      this.closed = true;
      this.sink.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void connectionPreface()
    throws IOException
  {
    try
    {
      if (this.closed)
        throw new IOException("closed");
    }
    finally
    {
    }
    boolean bool = this.client;
    if (!bool);
    while (true)
    {
      return;
      if (logger.isLoggable(Level.FINE))
      {
        Logger localLogger = logger;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Http2.CONNECTION_PREFACE.f();
        localLogger.fine(Util.format(">> CONNECTION %s", arrayOfObject));
      }
      this.sink.c(Http2.CONNECTION_PREFACE.i());
      this.sink.flush();
    }
  }

  public void data(boolean paramBoolean, int paramInt1, c paramc, int paramInt2)
    throws IOException
  {
    try
    {
      if (this.closed)
        throw new IOException("closed");
    }
    finally
    {
    }
    byte b = 0;
    if (paramBoolean)
      b = (byte)1;
    dataFrame(paramInt1, b, paramc, paramInt2);
  }

  void dataFrame(int paramInt1, byte paramByte, c paramc, int paramInt2)
    throws IOException
  {
    frameHeader(paramInt1, paramInt2, (byte)0, paramByte);
    if (paramInt2 > 0)
      this.sink.write(paramc, paramInt2);
  }

  public void flush()
    throws IOException
  {
    try
    {
      if (this.closed)
        throw new IOException("closed");
    }
    finally
    {
    }
    this.sink.flush();
  }

  public void frameHeader(int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
    throws IOException
  {
    if (logger.isLoggable(Level.FINE))
      logger.fine(Http2.frameLog(false, paramInt1, paramInt2, paramByte1, paramByte2));
    if (paramInt2 > this.maxFrameSize)
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(this.maxFrameSize);
      arrayOfObject2[1] = Integer.valueOf(paramInt2);
      throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", arrayOfObject2);
    }
    if ((0x80000000 & paramInt1) != 0)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(paramInt1);
      throw Http2.illegalArgument("reserved bit set: %s", arrayOfObject1);
    }
    writeMedium(this.sink, paramInt2);
    this.sink.i(paramByte1 & 0xFF);
    this.sink.i(paramByte2 & 0xFF);
    this.sink.g(0x7FFFFFFF & paramInt1);
  }

  public void goAway(int paramInt, ErrorCode paramErrorCode, byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      if (this.closed)
        throw new IOException("closed");
    }
    finally
    {
    }
    if (paramErrorCode.httpCode == -1)
      throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
    frameHeader(0, 8 + paramArrayOfByte.length, (byte)7, (byte)0);
    this.sink.g(paramInt);
    this.sink.g(paramErrorCode.httpCode);
    if (paramArrayOfByte.length > 0)
      this.sink.c(paramArrayOfByte);
    this.sink.flush();
  }

  public void headers(int paramInt, List<Header> paramList)
    throws IOException
  {
    try
    {
      if (this.closed)
        throw new IOException("closed");
    }
    finally
    {
    }
    headers(false, paramInt, paramList);
  }

  void headers(boolean paramBoolean, int paramInt, List<Header> paramList)
    throws IOException
  {
    if (this.closed)
      throw new IOException("closed");
    this.hpackWriter.writeHeaders(paramList);
    long l = this.hpackBuffer.a();
    int i = (int)Math.min(this.maxFrameSize, l);
    if (l == i);
    for (byte b = 4; ; b = 0)
    {
      if (paramBoolean)
        b = (byte)(b | 0x1);
      frameHeader(paramInt, i, (byte)1, b);
      this.sink.write(this.hpackBuffer, i);
      if (l > i)
        writeContinuationFrames(paramInt, l - i);
      return;
    }
  }

  public int maxDataLength()
  {
    return this.maxFrameSize;
  }

  public void ping(boolean paramBoolean, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      if (this.closed)
        throw new IOException("closed");
    }
    finally
    {
    }
    byte b = 0;
    if (paramBoolean)
      b = 1;
    frameHeader(0, 8, (byte)6, b);
    this.sink.g(paramInt1);
    this.sink.g(paramInt2);
    this.sink.flush();
  }

  public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
    throws IOException
  {
    try
    {
      if (this.closed)
        throw new IOException("closed");
    }
    finally
    {
    }
    this.hpackWriter.writeHeaders(paramList);
    long l = this.hpackBuffer.a();
    int i = (int)Math.min(-4 + this.maxFrameSize, l);
    if (l == i);
    for (byte b = 4; ; b = 0)
    {
      frameHeader(paramInt1, i + 4, (byte)5, b);
      this.sink.g(0x7FFFFFFF & paramInt2);
      this.sink.write(this.hpackBuffer, i);
      if (l > i)
        writeContinuationFrames(paramInt1, l - i);
      return;
    }
  }

  public void rstStream(int paramInt, ErrorCode paramErrorCode)
    throws IOException
  {
    try
    {
      if (this.closed)
        throw new IOException("closed");
    }
    finally
    {
    }
    if (paramErrorCode.httpCode == -1)
      throw new IllegalArgumentException();
    frameHeader(paramInt, 4, (byte)3, (byte)0);
    this.sink.g(paramErrorCode.httpCode);
    this.sink.flush();
  }

  public void settings(Settings paramSettings)
    throws IOException
  {
    int i = 0;
    try
    {
      if (this.closed)
        throw new IOException("closed");
    }
    finally
    {
    }
    frameHeader(0, 6 * paramSettings.size(), (byte)4, (byte)0);
    if (i < 10)
      if (paramSettings.isSet(i))
        break label111;
    while (true)
    {
      label57: this.sink.h(j);
      this.sink.g(paramSettings.get(i));
      break label105;
      this.sink.flush();
      return;
      label105: label111: 
      do
      {
        j = i;
        break label57;
        i++;
        break;
        if (i == 4)
        {
          j = 3;
          break label57;
        }
      }
      while (i != 7);
      int j = 4;
    }
  }

  public void synReply(boolean paramBoolean, int paramInt, List<Header> paramList)
    throws IOException
  {
    try
    {
      if (this.closed)
        throw new IOException("closed");
    }
    finally
    {
    }
    headers(paramBoolean, paramInt, paramList);
  }

  public void synStream(boolean paramBoolean, int paramInt1, int paramInt2, List<Header> paramList)
    throws IOException
  {
    try
    {
      if (this.closed)
        throw new IOException("closed");
    }
    finally
    {
    }
    headers(paramBoolean, paramInt1, paramList);
  }

  public void windowUpdate(int paramInt, long paramLong)
    throws IOException
  {
    try
    {
      if (this.closed)
        throw new IOException("closed");
    }
    finally
    {
    }
    if ((paramLong == 0L) || (paramLong > 2147483647L))
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(paramLong);
      throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", arrayOfObject);
    }
    frameHeader(paramInt, 4, (byte)8, (byte)0);
    this.sink.g((int)paramLong);
    this.sink.flush();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Writer
 * JD-Core Version:    0.6.2
 */
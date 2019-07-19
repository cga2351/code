package okhttp3.internal.ws;

import f.c;
import f.c.a;
import f.d;
import f.f;
import f.s;
import f.u;
import java.io.IOException;
import java.util.Random;

final class WebSocketWriter
{
  boolean activeWriter;
  final c buffer = new c();
  final FrameSink frameSink = new FrameSink();
  final boolean isClient;
  private final c.a maskCursor;
  private final byte[] maskKey;
  final Random random;
  final d sink;
  final c sinkBuffer;
  boolean writerClosed;

  WebSocketWriter(boolean paramBoolean, d paramd, Random paramRandom)
  {
    if (paramd == null)
      throw new NullPointerException("sink == null");
    if (paramRandom == null)
      throw new NullPointerException("random == null");
    this.isClient = paramBoolean;
    this.sink = paramd;
    this.sinkBuffer = paramd.b();
    this.random = paramRandom;
    if (paramBoolean);
    for (byte[] arrayOfByte = new byte[4]; ; arrayOfByte = null)
    {
      this.maskKey = arrayOfByte;
      c.a locala = null;
      if (paramBoolean)
        locala = new c.a();
      this.maskCursor = locala;
      return;
    }
  }

  private void writeControlFrame(int paramInt, f paramf)
    throws IOException
  {
    if (this.writerClosed)
      throw new IOException("closed");
    int i = paramf.h();
    if (i > 125L)
      throw new IllegalArgumentException("Payload size must be less than or equal to 125");
    int j = paramInt | 0x80;
    this.sinkBuffer.b(j);
    if (this.isClient)
    {
      int k = i | 0x80;
      this.sinkBuffer.b(k);
      this.random.nextBytes(this.maskKey);
      this.sinkBuffer.b(this.maskKey);
      if (i > 0)
      {
        long l = this.sinkBuffer.a();
        this.sinkBuffer.a(paramf);
        this.sinkBuffer.a(this.maskCursor);
        this.maskCursor.a(l);
        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
      }
    }
    while (true)
    {
      this.sink.flush();
      return;
      this.sinkBuffer.b(i);
      this.sinkBuffer.a(paramf);
    }
  }

  s newMessageSink(int paramInt, long paramLong)
  {
    if (this.activeWriter)
      throw new IllegalStateException("Another message writer is active. Did you call close()?");
    this.activeWriter = true;
    this.frameSink.formatOpcode = paramInt;
    this.frameSink.contentLength = paramLong;
    this.frameSink.isFirstFrame = true;
    this.frameSink.closed = false;
    return this.frameSink;
  }

  void writeClose(int paramInt, f paramf)
    throws IOException
  {
    f localf = f.b;
    if ((paramInt != 0) || (paramf != null))
    {
      if (paramInt != 0)
        WebSocketProtocol.validateCloseCode(paramInt);
      c localc = new c();
      localc.c(paramInt);
      if (paramf != null)
        localc.a(paramf);
      localf = localc.q();
    }
    try
    {
      writeControlFrame(8, localf);
      return;
    }
    finally
    {
      this.writerClosed = true;
    }
  }

  void writeMessageFrame(int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    if (this.writerClosed)
      throw new IOException("closed");
    int i;
    if (paramBoolean1)
    {
      i = paramInt;
      if (paramBoolean2)
        i |= 128;
      this.sinkBuffer.b(i);
      if (!this.isClient)
        break label281;
    }
    label266: label281: for (int j = 128; ; j = 0)
    {
      if (paramLong <= 125L)
      {
        int n = j | (int)paramLong;
        this.sinkBuffer.b(n);
        label85: if (!this.isClient)
          break label266;
        this.random.nextBytes(this.maskKey);
        this.sinkBuffer.b(this.maskKey);
        if (paramLong > 0L)
        {
          long l = this.sinkBuffer.a();
          this.sinkBuffer.write(this.buffer, paramLong);
          this.sinkBuffer.a(this.maskCursor);
          this.maskCursor.a(l);
          WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
          this.maskCursor.close();
        }
      }
      while (true)
      {
        this.sink.e();
        return;
        i = 0;
        break;
        if (paramLong <= 65535L)
        {
          int m = j | 0x7E;
          this.sinkBuffer.b(m);
          this.sinkBuffer.c((int)paramLong);
          break label85;
        }
        int k = j | 0x7F;
        this.sinkBuffer.b(k);
        this.sinkBuffer.j(paramLong);
        break label85;
        this.sinkBuffer.write(this.buffer, paramLong);
      }
    }
  }

  void writePing(f paramf)
    throws IOException
  {
    writeControlFrame(9, paramf);
  }

  void writePong(f paramf)
    throws IOException
  {
    writeControlFrame(10, paramf);
  }

  final class FrameSink
    implements s
  {
    boolean closed;
    long contentLength;
    int formatOpcode;
    boolean isFirstFrame;

    FrameSink()
    {
    }

    public void close()
      throws IOException
    {
      if (this.closed)
        throw new IOException("closed");
      WebSocketWriter.this.writeMessageFrame(this.formatOpcode, WebSocketWriter.this.buffer.a(), this.isFirstFrame, true);
      this.closed = true;
      WebSocketWriter.this.activeWriter = false;
    }

    public void flush()
      throws IOException
    {
      if (this.closed)
        throw new IOException("closed");
      WebSocketWriter.this.writeMessageFrame(this.formatOpcode, WebSocketWriter.this.buffer.a(), this.isFirstFrame, false);
      this.isFirstFrame = false;
    }

    public u timeout()
    {
      return WebSocketWriter.this.sink.timeout();
    }

    public void write(c paramc, long paramLong)
      throws IOException
    {
      if (this.closed)
        throw new IOException("closed");
      WebSocketWriter.this.buffer.write(paramc, paramLong);
      if ((this.isFirstFrame) && (this.contentLength != -1L) && (WebSocketWriter.this.buffer.a() > this.contentLength - 8192L));
      for (int i = 1; ; i = 0)
      {
        long l = WebSocketWriter.this.buffer.h();
        if ((l > 0L) && (i == 0))
        {
          WebSocketWriter.this.writeMessageFrame(this.formatOpcode, l, this.isFirstFrame, false);
          this.isFirstFrame = false;
        }
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.ws.WebSocketWriter
 * JD-Core Version:    0.6.2
 */
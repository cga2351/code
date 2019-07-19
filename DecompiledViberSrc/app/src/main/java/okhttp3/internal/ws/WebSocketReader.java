package okhttp3.internal.ws;

import f.c;
import f.c.a;
import f.e;
import f.f;
import f.u;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

final class WebSocketReader
{
  boolean closed;
  private final c controlFrameBuffer = new c();
  final FrameCallback frameCallback;
  long frameLength;
  final boolean isClient;
  boolean isControlFrame;
  boolean isFinalFrame;
  private final c.a maskCursor;
  private final byte[] maskKey;
  private final c messageFrameBuffer = new c();
  int opcode;
  final e source;

  WebSocketReader(boolean paramBoolean, e parame, FrameCallback paramFrameCallback)
  {
    if (parame == null)
      throw new NullPointerException("source == null");
    if (paramFrameCallback == null)
      throw new NullPointerException("frameCallback == null");
    this.isClient = paramBoolean;
    this.source = parame;
    this.frameCallback = paramFrameCallback;
    byte[] arrayOfByte;
    c.a locala;
    if (paramBoolean)
    {
      arrayOfByte = null;
      this.maskKey = arrayOfByte;
      locala = null;
      if (!paramBoolean)
        break label104;
    }
    while (true)
    {
      this.maskCursor = locala;
      return;
      arrayOfByte = new byte[4];
      break;
      label104: locala = new c.a();
    }
  }

  private void readControlFrame()
    throws IOException
  {
    if (this.frameLength > 0L)
    {
      this.source.a(this.controlFrameBuffer, this.frameLength);
      if (!this.isClient)
      {
        this.controlFrameBuffer.a(this.maskCursor);
        this.maskCursor.a(0L);
        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
      }
    }
    switch (this.opcode)
    {
    default:
      throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.opcode));
    case 9:
      this.frameCallback.onReadPing(this.controlFrameBuffer.q());
      return;
    case 10:
      this.frameCallback.onReadPong(this.controlFrameBuffer.q());
      return;
    case 8:
    }
    int i = 1005;
    String str1 = "";
    long l = this.controlFrameBuffer.a();
    if (l == 1L)
      throw new ProtocolException("Malformed close payload length of 1.");
    if (l != 0L)
    {
      i = this.controlFrameBuffer.j();
      str1 = this.controlFrameBuffer.r();
      String str2 = WebSocketProtocol.closeCodeExceptionMessage(i);
      if (str2 != null)
        throw new ProtocolException(str2);
    }
    this.frameCallback.onReadClose(i, str1);
    this.closed = true;
  }

  private void readHeader()
    throws IOException
  {
    boolean bool1 = true;
    if (this.closed)
      throw new IOException("closed");
    long l = this.source.timeout().timeoutNanos();
    this.source.timeout().clearTimeout();
    int j;
    while (true)
    {
      try
      {
        int i = this.source.i();
        j = i & 0xFF;
        this.source.timeout().timeout(l, TimeUnit.NANOSECONDS);
        this.opcode = (j & 0xF);
        if ((j & 0x80) != 0)
        {
          bool2 = bool1;
          this.isFinalFrame = bool2;
          if ((j & 0x8) == 0)
            break label177;
          bool3 = bool1;
          this.isControlFrame = bool3;
          if ((!this.isControlFrame) || (this.isFinalFrame))
            break;
          throw new ProtocolException("Control frames must be final.");
        }
      }
      finally
      {
        this.source.timeout().timeout(l, TimeUnit.NANOSECONDS);
      }
      boolean bool2 = false;
      continue;
      label177: boolean bool3 = false;
    }
    int k;
    int m;
    if ((j & 0x40) != 0)
    {
      k = bool1;
      if ((j & 0x20) == 0)
        break label247;
      m = bool1;
      label205: if ((j & 0x10) == 0)
        break label253;
    }
    label247: label253: for (int n = bool1; ; n = 0)
    {
      if ((k == 0) && (m == 0) && (n == 0))
        break label259;
      throw new ProtocolException("Reserved flags are unsupported.");
      k = 0;
      break;
      m = 0;
      break label205;
    }
    label259: int i1 = 0xFF & this.source.i();
    if ((i1 & 0x80) != 0)
    {
      if (bool1 != this.isClient)
        break label324;
      if (!this.isClient)
        break label317;
    }
    label317: for (String str = "Server-sent frames must not be masked."; ; str = "Client-sent frames must be masked.")
    {
      throw new ProtocolException(str);
      bool1 = false;
      break;
    }
    label324: this.frameLength = (i1 & 0x7F);
    if (this.frameLength == 126L)
      this.frameLength = (0xFFFF & this.source.j());
    while ((this.isControlFrame) && (this.frameLength > 125L))
    {
      throw new ProtocolException("Control frame must be less than 125B.");
      if (this.frameLength == 127L)
      {
        this.frameLength = this.source.l();
        if (this.frameLength < 0L)
          throw new ProtocolException("Frame length 0x" + Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
      }
    }
    if (bool1)
      this.source.a(this.maskKey);
  }

  private void readMessage()
    throws IOException
  {
    do
    {
      if (this.closed)
        throw new IOException("closed");
      if (this.frameLength > 0L)
      {
        this.source.a(this.messageFrameBuffer, this.frameLength);
        if (!this.isClient)
        {
          this.messageFrameBuffer.a(this.maskCursor);
          this.maskCursor.a(this.messageFrameBuffer.a() - this.frameLength);
          WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
          this.maskCursor.close();
        }
      }
      if (this.isFinalFrame)
        return;
      readUntilNonControlFrame();
    }
    while (this.opcode == 0);
    throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.opcode));
  }

  private void readMessageFrame()
    throws IOException
  {
    int i = this.opcode;
    if ((i != 1) && (i != 2))
      throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i));
    readMessage();
    if (i == 1)
    {
      this.frameCallback.onReadMessage(this.messageFrameBuffer.r());
      return;
    }
    this.frameCallback.onReadMessage(this.messageFrameBuffer.q());
  }

  private void readUntilNonControlFrame()
    throws IOException
  {
    while (true)
    {
      if (!this.closed)
      {
        readHeader();
        if (this.isControlFrame);
      }
      else
      {
        return;
      }
      readControlFrame();
    }
  }

  void processNextFrame()
    throws IOException
  {
    readHeader();
    if (this.isControlFrame)
    {
      readControlFrame();
      return;
    }
    readMessageFrame();
  }

  public static abstract interface FrameCallback
  {
    public abstract void onReadClose(int paramInt, String paramString);

    public abstract void onReadMessage(f paramf)
      throws IOException;

    public abstract void onReadMessage(String paramString)
      throws IOException;

    public abstract void onReadPing(f paramf);

    public abstract void onReadPong(f paramf);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.ws.WebSocketReader
 * JD-Core Version:    0.6.2
 */
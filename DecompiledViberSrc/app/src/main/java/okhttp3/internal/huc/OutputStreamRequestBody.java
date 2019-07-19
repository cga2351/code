package okhttp3.internal.huc;

import f.d;
import f.u;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

abstract class OutputStreamRequestBody extends RequestBody
{
  boolean closed;
  private long expectedContentLength;
  private OutputStream outputStream;
  private u timeout;

  public long contentLength()
    throws IOException
  {
    return this.expectedContentLength;
  }

  public final MediaType contentType()
  {
    return null;
  }

  protected void initOutputStream(d paramd, final long paramLong)
  {
    this.timeout = paramd.timeout();
    this.expectedContentLength = paramLong;
    this.outputStream = new OutputStream()
    {
      private long bytesReceived;

      public void close()
        throws IOException
      {
        OutputStreamRequestBody.this.closed = true;
        if ((paramLong != -1L) && (this.bytesReceived < paramLong))
          throw new ProtocolException("expected " + paramLong + " bytes but received " + this.bytesReceived);
        this.val$sink.close();
      }

      public void flush()
        throws IOException
      {
        if (OutputStreamRequestBody.this.closed)
          return;
        this.val$sink.flush();
      }

      public void write(int paramAnonymousInt)
        throws IOException
      {
        byte[] arrayOfByte = new byte[1];
        arrayOfByte[0] = ((byte)paramAnonymousInt);
        write(arrayOfByte, 0, 1);
      }

      public void write(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
        throws IOException
      {
        if (OutputStreamRequestBody.this.closed)
          throw new IOException("closed");
        if ((paramLong != -1L) && (this.bytesReceived + paramAnonymousInt2 > paramLong))
          throw new ProtocolException("expected " + paramLong + " bytes but received " + this.bytesReceived + paramAnonymousInt2);
        this.bytesReceived += paramAnonymousInt2;
        try
        {
          this.val$sink.c(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
          return;
        }
        catch (InterruptedIOException localInterruptedIOException)
        {
          throw new SocketTimeoutException(localInterruptedIOException.getMessage());
        }
      }
    };
  }

  public final boolean isClosed()
  {
    return this.closed;
  }

  public final OutputStream outputStream()
  {
    return this.outputStream;
  }

  public Request prepareToSendRequest(Request paramRequest)
    throws IOException
  {
    return paramRequest;
  }

  public final u timeout()
  {
    return this.timeout;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.huc.OutputStreamRequestBody
 * JD-Core Version:    0.6.2
 */
package okhttp3.internal.huc;

import f.c;
import f.d;
import java.io.IOException;
import java.io.OutputStream;
import okhttp3.Request;
import okhttp3.Request.Builder;

final class BufferedRequestBody extends OutputStreamRequestBody
{
  final c buffer = new c();
  long contentLength = -1L;

  BufferedRequestBody(long paramLong)
  {
    initOutputStream(this.buffer, paramLong);
  }

  public long contentLength()
    throws IOException
  {
    return this.contentLength;
  }

  public Request prepareToSendRequest(Request paramRequest)
    throws IOException
  {
    if (paramRequest.header("Content-Length") != null)
      return paramRequest;
    outputStream().close();
    this.contentLength = this.buffer.a();
    return paramRequest.newBuilder().removeHeader("Transfer-Encoding").header("Content-Length", Long.toString(this.buffer.a())).build();
  }

  public void writeTo(d paramd)
    throws IOException
  {
    this.buffer.a(paramd.b(), 0L, this.buffer.a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.huc.BufferedRequestBody
 * JD-Core Version:    0.6.2
 */
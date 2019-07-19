package okhttp3.internal.http;

import f.s;
import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;

public abstract interface HttpCodec
{
  public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

  public abstract void cancel();

  public abstract s createRequestBody(Request paramRequest, long paramLong);

  public abstract void finishRequest()
    throws IOException;

  public abstract void flushRequest()
    throws IOException;

  public abstract ResponseBody openResponseBody(Response paramResponse)
    throws IOException;

  public abstract Response.Builder readResponseHeaders(boolean paramBoolean)
    throws IOException;

  public abstract void writeRequestHeaders(Request paramRequest)
    throws IOException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.http.HttpCodec
 * JD-Core Version:    0.6.2
 */
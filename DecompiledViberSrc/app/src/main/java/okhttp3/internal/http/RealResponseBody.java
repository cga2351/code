package okhttp3.internal.http;

import f.e;
import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

public final class RealResponseBody extends ResponseBody
{
  private final long contentLength;

  @Nullable
  private final String contentTypeString;
  private final e source;

  public RealResponseBody(@Nullable String paramString, long paramLong, e parame)
  {
    this.contentTypeString = paramString;
    this.contentLength = paramLong;
    this.source = parame;
  }

  public long contentLength()
  {
    return this.contentLength;
  }

  public MediaType contentType()
  {
    if (this.contentTypeString != null)
      return MediaType.parse(this.contentTypeString);
    return null;
  }

  public e source()
  {
    return this.source;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.http.RealResponseBody
 * JD-Core Version:    0.6.2
 */
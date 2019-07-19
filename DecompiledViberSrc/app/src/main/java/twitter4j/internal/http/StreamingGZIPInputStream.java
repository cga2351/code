package twitter4j.internal.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

final class StreamingGZIPInputStream extends GZIPInputStream
{
  private final InputStream wrapped;

  public StreamingGZIPInputStream(InputStream paramInputStream)
    throws IOException
  {
    super(paramInputStream);
    this.wrapped = paramInputStream;
  }

  public int available()
    throws IOException
  {
    return this.wrapped.available();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.http.StreamingGZIPInputStream
 * JD-Core Version:    0.6.2
 */
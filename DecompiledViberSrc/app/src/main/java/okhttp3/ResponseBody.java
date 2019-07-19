package okhttp3;

import f.c;
import f.e;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

public abstract class ResponseBody
  implements Closeable
{
  private Reader reader;

  private Charset charset()
  {
    MediaType localMediaType = contentType();
    if (localMediaType != null)
      return localMediaType.charset(Util.UTF_8);
    return Util.UTF_8;
  }

  public static ResponseBody create(@Nullable MediaType paramMediaType, final long paramLong, e parame)
  {
    if (parame == null)
      throw new NullPointerException("source == null");
    return new ResponseBody()
    {
      public long contentLength()
      {
        return paramLong;
      }

      @Nullable
      public MediaType contentType()
      {
        return ResponseBody.this;
      }

      public e source()
      {
        return this.val$content;
      }
    };
  }

  public static ResponseBody create(@Nullable MediaType paramMediaType, String paramString)
  {
    Charset localCharset = Util.UTF_8;
    if (paramMediaType != null)
    {
      localCharset = paramMediaType.charset();
      if (localCharset == null)
      {
        localCharset = Util.UTF_8;
        paramMediaType = MediaType.parse(paramMediaType + "; charset=utf-8");
      }
    }
    c localc = new c().a(paramString, localCharset);
    return create(paramMediaType, localc.a(), localc);
  }

  public static ResponseBody create(@Nullable MediaType paramMediaType, byte[] paramArrayOfByte)
  {
    c localc = new c().b(paramArrayOfByte);
    return create(paramMediaType, paramArrayOfByte.length, localc);
  }

  public final InputStream byteStream()
  {
    return source().g();
  }

  public final byte[] bytes()
    throws IOException
  {
    long l = contentLength();
    if (l > 2147483647L)
      throw new IOException("Cannot buffer entire body for content length: " + l);
    e locale = source();
    byte[] arrayOfByte;
    try
    {
      arrayOfByte = locale.u();
      Util.closeQuietly(locale);
      if ((l != -1L) && (l != arrayOfByte.length))
        throw new IOException("Content-Length (" + l + ") and stream length (" + arrayOfByte.length + ") disagree");
    }
    finally
    {
      Util.closeQuietly(locale);
    }
    return arrayOfByte;
  }

  public final Reader charStream()
  {
    Reader localReader = this.reader;
    if (localReader != null)
      return localReader;
    BomAwareReader localBomAwareReader = new BomAwareReader(source(), charset());
    this.reader = localBomAwareReader;
    return localBomAwareReader;
  }

  public void close()
  {
    Util.closeQuietly(source());
  }

  public abstract long contentLength();

  @Nullable
  public abstract MediaType contentType();

  public abstract e source();

  public final String string()
    throws IOException
  {
    e locale = source();
    try
    {
      String str = locale.a(Util.bomAwareCharset(locale, charset()));
      return str;
    }
    finally
    {
      Util.closeQuietly(locale);
    }
  }

  static final class BomAwareReader extends Reader
  {
    private final Charset charset;
    private boolean closed;
    private Reader delegate;
    private final e source;

    BomAwareReader(e parame, Charset paramCharset)
    {
      this.source = parame;
      this.charset = paramCharset;
    }

    public void close()
      throws IOException
    {
      this.closed = true;
      if (this.delegate != null)
      {
        this.delegate.close();
        return;
      }
      this.source.close();
    }

    public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
      throws IOException
    {
      if (this.closed)
        throw new IOException("Stream closed");
      Object localObject = this.delegate;
      if (localObject == null)
      {
        Charset localCharset = Util.bomAwareCharset(this.source, this.charset);
        localObject = new InputStreamReader(this.source.g(), localCharset);
        this.delegate = ((Reader)localObject);
      }
      return ((Reader)localObject).read(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.ResponseBody
 * JD-Core Version:    0.6.2
 */
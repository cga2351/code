package okhttp3;

import f.d;
import f.f;
import f.l;
import f.t;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

public abstract class RequestBody
{
  public static RequestBody create(@Nullable MediaType paramMediaType, final f paramf)
  {
    return new RequestBody()
    {
      public long contentLength()
        throws IOException
      {
        return paramf.h();
      }

      @Nullable
      public MediaType contentType()
      {
        return RequestBody.this;
      }

      public void writeTo(d paramAnonymousd)
        throws IOException
      {
        paramAnonymousd.c(paramf);
      }
    };
  }

  public static RequestBody create(@Nullable MediaType paramMediaType, final File paramFile)
  {
    if (paramFile == null)
      throw new NullPointerException("content == null");
    return new RequestBody()
    {
      public long contentLength()
      {
        return paramFile.length();
      }

      @Nullable
      public MediaType contentType()
      {
        return RequestBody.this;
      }

      public void writeTo(d paramAnonymousd)
        throws IOException
      {
        t localt = null;
        try
        {
          localt = l.a(paramFile);
          paramAnonymousd.a(localt);
          return;
        }
        finally
        {
          Util.closeQuietly(localt);
        }
      }
    };
  }

  public static RequestBody create(@Nullable MediaType paramMediaType, String paramString)
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
    return create(paramMediaType, paramString.getBytes(localCharset));
  }

  public static RequestBody create(@Nullable MediaType paramMediaType, byte[] paramArrayOfByte)
  {
    return create(paramMediaType, paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static RequestBody create(@Nullable MediaType paramMediaType, final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2)
  {
    if (paramArrayOfByte == null)
      throw new NullPointerException("content == null");
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    return new RequestBody()
    {
      public long contentLength()
      {
        return paramInt2;
      }

      @Nullable
      public MediaType contentType()
      {
        return RequestBody.this;
      }

      public void writeTo(d paramAnonymousd)
        throws IOException
      {
        paramAnonymousd.c(paramArrayOfByte, paramInt1, paramInt2);
      }
    };
  }

  public long contentLength()
    throws IOException
  {
    return -1L;
  }

  @Nullable
  public abstract MediaType contentType();

  public abstract void writeTo(d paramd)
    throws IOException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.RequestBody
 * JD-Core Version:    0.6.2
 */
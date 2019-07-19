package com.google.a.a.c.a;

import com.google.a.a.f.ac;
import com.google.a.a.f.z;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.AbstractHttpEntity;

final class d extends AbstractHttpEntity
{
  private final long a;
  private final ac b;

  d(long paramLong, ac paramac)
  {
    this.a = paramLong;
    this.b = ((ac)z.a(paramac));
  }

  public InputStream getContent()
  {
    throw new UnsupportedOperationException();
  }

  public long getContentLength()
  {
    return this.a;
  }

  public boolean isRepeatable()
  {
    return false;
  }

  public boolean isStreaming()
  {
    return true;
  }

  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    if (this.a != 0L)
      this.b.a(paramOutputStream);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.a.d
 * JD-Core Version:    0.6.2
 */
package com.google.a.a.c.b;

import com.google.a.a.c.aa;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class d extends aa
{
  private final HttpURLConnection a;
  private final int b;
  private final String c;
  private final ArrayList<String> d = new ArrayList();
  private final ArrayList<String> e = new ArrayList();

  d(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    this.a = paramHttpURLConnection;
    int i = paramHttpURLConnection.getResponseCode();
    if (i == -1)
      i = 0;
    this.b = i;
    this.c = paramHttpURLConnection.getResponseMessage();
    ArrayList localArrayList1 = this.d;
    ArrayList localArrayList2 = this.e;
    Iterator localIterator1 = paramHttpURLConnection.getHeaderFields().entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      String str1 = (String)localEntry.getKey();
      if (str1 != null)
      {
        Iterator localIterator2 = ((List)localEntry.getValue()).iterator();
        while (localIterator2.hasNext())
        {
          String str2 = (String)localIterator2.next();
          if (str2 != null)
          {
            localArrayList1.add(str1);
            localArrayList2.add(str2);
          }
        }
      }
    }
  }

  public InputStream a()
    throws IOException
  {
    InputStream localInputStream1;
    try
    {
      InputStream localInputStream2 = this.a.getInputStream();
      localInputStream1 = localInputStream2;
      if (localInputStream1 == null)
        return null;
    }
    catch (IOException localIOException)
    {
      while (true)
        localInputStream1 = this.a.getErrorStream();
    }
    return new a(localInputStream1);
  }

  public String a(int paramInt)
  {
    return (String)this.d.get(paramInt);
  }

  public String b()
  {
    return this.a.getContentEncoding();
  }

  public String b(int paramInt)
  {
    return (String)this.e.get(paramInt);
  }

  public String c()
  {
    return this.a.getHeaderField("Content-Type");
  }

  public String d()
  {
    String str = this.a.getHeaderField(0);
    if ((str != null) && (str.startsWith("HTTP/1.")))
      return str;
    return null;
  }

  public int e()
  {
    return this.b;
  }

  public String f()
  {
    return this.c;
  }

  public int g()
  {
    return this.d.size();
  }

  public void h()
  {
    this.a.disconnect();
  }

  public long i()
  {
    String str = this.a.getHeaderField("Content-Length");
    if (str == null)
      return -1L;
    return Long.parseLong(str);
  }

  private final class a extends FilterInputStream
  {
    private long b = 0L;

    public a(InputStream arg2)
    {
      super();
    }

    private void a()
      throws IOException
    {
      long l1 = d.this.i();
      if (l1 == -1L);
      while ((this.b == 0L) || (this.b >= l1))
        return;
      long l2 = this.b;
      throw new IOException(102 + "Connection closed prematurely: bytesRead = " + l2 + ", Content-Length = " + l1);
    }

    public int read()
      throws IOException
    {
      int i = this.in.read();
      if (i == -1)
      {
        a();
        return i;
      }
      this.b = (1L + this.b);
      return i;
    }

    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      int i = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i == -1)
      {
        a();
        return i;
      }
      this.b += i;
      return i;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.b.d
 * JD-Core Version:    0.6.2
 */
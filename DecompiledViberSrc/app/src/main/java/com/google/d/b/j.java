package com.google.d.b;

import com.google.d.d.a;
import com.google.d.d.c;
import com.google.d.d.d;
import com.google.d.l;
import com.google.d.m;
import com.google.d.p;
import com.google.d.u;
import com.google.d.w;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

public final class j
{
  public static l a(a parama)
    throws p
  {
    int i = 1;
    try
    {
      parama.f();
      i = 0;
      l locall = (l)com.google.d.b.a.n.X.b(parama);
      return locall;
    }
    catch (EOFException localEOFException)
    {
      if (i != 0)
        return com.google.d.n.a;
      throw new u(localEOFException);
    }
    catch (d locald)
    {
      throw new u(locald);
    }
    catch (IOException localIOException)
    {
      throw new m(localIOException);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new u(localNumberFormatException);
    }
  }

  public static Writer a(Appendable paramAppendable)
  {
    if ((paramAppendable instanceof Writer))
      return (Writer)paramAppendable;
    return new a(paramAppendable);
  }

  public static void a(l paraml, c paramc)
    throws IOException
  {
    com.google.d.b.a.n.X.a(paramc, paraml);
  }

  private static final class a extends Writer
  {
    private final Appendable a;
    private final a b = new a();

    a(Appendable paramAppendable)
    {
      this.a = paramAppendable;
    }

    public void close()
    {
    }

    public void flush()
    {
    }

    public void write(int paramInt)
      throws IOException
    {
      this.a.append((char)paramInt);
    }

    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
      throws IOException
    {
      this.b.a = paramArrayOfChar;
      this.a.append(this.b, paramInt1, paramInt1 + paramInt2);
    }

    static class a
      implements CharSequence
    {
      char[] a;

      public char charAt(int paramInt)
      {
        return this.a[paramInt];
      }

      public int length()
      {
        return this.a.length;
      }

      public CharSequence subSequence(int paramInt1, int paramInt2)
      {
        return new String(this.a, paramInt1, paramInt2 - paramInt1);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.j
 * JD-Core Version:    0.6.2
 */
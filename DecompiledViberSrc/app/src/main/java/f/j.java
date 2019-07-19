package f;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class j
  implements t
{
  private int a = 0;
  private final e b;
  private final Inflater c;
  private final k d;
  private final CRC32 e = new CRC32();

  public j(t paramt)
  {
    if (paramt == null)
      throw new IllegalArgumentException("source == null");
    this.c = new Inflater(true);
    this.b = l.a(paramt);
    this.d = new k(this.b, this.c);
  }

  private void a()
    throws IOException
  {
    this.b.a(10L);
    int i = this.b.b().c(3L);
    if ((0x1 & i >> 1) == 1);
    long l2;
    for (int j = 1; ; j = 0)
    {
      if (j != 0)
        a(this.b.b(), 0L, 10L);
      a("ID1ID2", 8075, this.b.j());
      this.b.i(8L);
      if ((0x1 & i >> 2) == 1)
      {
        this.b.a(2L);
        if (j != 0)
          a(this.b.b(), 0L, 2L);
        int k = this.b.b().m();
        this.b.a(k);
        if (j != 0)
          a(this.b.b(), 0L, k);
        this.b.i(k);
      }
      if ((0x1 & i >> 3) != 1)
        break label269;
      l2 = this.b.a((byte)0);
      if (l2 != -1L)
        break;
      throw new EOFException();
    }
    if (j != 0)
      a(this.b.b(), 0L, 1L + l2);
    this.b.i(1L + l2);
    label269: if ((0x1 & i >> 4) == 1)
    {
      long l1 = this.b.a((byte)0);
      if (l1 == -1L)
        throw new EOFException();
      if (j != 0)
        a(this.b.b(), 0L, 1L + l1);
      this.b.i(1L + l1);
    }
    if (j != 0)
    {
      a("FHCRC", this.b.m(), (short)(int)this.e.getValue());
      this.e.reset();
    }
  }

  private void a(c paramc, long paramLong1, long paramLong2)
  {
    for (p localp = paramc.a; paramLong1 >= localp.c - localp.b; localp = localp.f)
      paramLong1 -= localp.c - localp.b;
    while (paramLong2 > 0L)
    {
      int i = (int)(paramLong1 + localp.b);
      int j = (int)Math.min(localp.c - i, paramLong2);
      this.e.update(localp.a, i, j);
      paramLong2 -= j;
      localp = localp.f;
      paramLong1 = 0L;
    }
  }

  private void a(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 != paramInt1)
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Integer.valueOf(paramInt2);
      arrayOfObject[2] = Integer.valueOf(paramInt1);
      throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", arrayOfObject));
    }
  }

  private void b()
    throws IOException
  {
    a("CRC", this.b.n(), (int)this.e.getValue());
    a("ISIZE", this.b.n(), (int)this.c.getBytesWritten());
  }

  public void close()
    throws IOException
  {
    this.d.close();
  }

  public long read(c paramc, long paramLong)
    throws IOException
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    if (paramLong == 0L)
      return 0L;
    if (this.a == 0)
    {
      a();
      this.a = 1;
    }
    if (this.a == 1)
    {
      long l1 = paramc.b;
      long l2 = this.d.read(paramc, paramLong);
      if (l2 != -1L)
      {
        a(paramc, l1, l2);
        return l2;
      }
      this.a = 2;
    }
    if (this.a == 2)
    {
      b();
      this.a = 3;
      if (!this.b.f())
        throw new IOException("gzip finished without exhausting source");
    }
    return -1L;
  }

  public u timeout()
  {
    return this.b.timeout();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.j
 * JD-Core Version:    0.6.2
 */
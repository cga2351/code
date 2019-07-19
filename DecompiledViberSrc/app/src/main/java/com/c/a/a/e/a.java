package com.c.a.a.e;

public class a
{
  protected final byte[][] a = new byte[a.values().length][];
  protected final char[][] b = new char[b.values().length][];

  private byte[] a(int paramInt)
  {
    return new byte[paramInt];
  }

  private char[] b(int paramInt)
  {
    return new char[paramInt];
  }

  public final void a(a parama, byte[] paramArrayOfByte)
  {
    this.a[parama.ordinal()] = paramArrayOfByte;
  }

  public final void a(b paramb, char[] paramArrayOfChar)
  {
    this.b[paramb.ordinal()] = paramArrayOfChar;
  }

  public final byte[] a(a parama)
  {
    int i = parama.ordinal();
    byte[] arrayOfByte = this.a[i];
    if (arrayOfByte == null)
      return a(parama.e);
    this.a[i] = null;
    return arrayOfByte;
  }

  public final char[] a(b paramb)
  {
    return a(paramb, 0);
  }

  public final char[] a(b paramb, int paramInt)
  {
    if (paramb.e > paramInt)
      paramInt = paramb.e;
    int i = paramb.ordinal();
    char[] arrayOfChar = this.b[i];
    if ((arrayOfChar == null) || (arrayOfChar.length < paramInt))
      return b(paramInt);
    this.b[i] = null;
    return arrayOfChar;
  }

  public static enum a
  {
    protected final int e;

    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
    }

    private a(int paramInt)
    {
      this.e = paramInt;
    }
  }

  public static enum b
  {
    protected final int e;

    static
    {
      b[] arrayOfb = new b[4];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
    }

    private b(int paramInt)
    {
      this.e = paramInt;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.e.a
 * JD-Core Version:    0.6.2
 */
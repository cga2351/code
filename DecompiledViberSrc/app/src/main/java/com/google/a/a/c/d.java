package com.google.a.a.c;

import com.google.a.a.f.z;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class d extends b
{
  private final byte[] a;
  private final int b;
  private final int c;

  public d(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramString);
    this.a = ((byte[])z.a(paramArrayOfByte));
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 + paramInt2 <= paramArrayOfByte.length));
    for (boolean bool = true; ; bool = false)
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(paramInt1);
      arrayOfObject[1] = Integer.valueOf(paramInt2);
      arrayOfObject[2] = Integer.valueOf(paramArrayOfByte.length);
      z.a(bool, "offset %s, length %s, array length %s", arrayOfObject);
      this.b = paramInt1;
      this.c = paramInt2;
      return;
    }
  }

  public long a()
  {
    return this.c;
  }

  public d b(String paramString)
  {
    return (d)super.a(paramString);
  }

  public d b(boolean paramBoolean)
  {
    return (d)super.a(paramBoolean);
  }

  public InputStream b()
  {
    return new ByteArrayInputStream(this.a, this.b, this.c);
  }

  public boolean f()
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.d
 * JD-Core Version:    0.6.2
 */
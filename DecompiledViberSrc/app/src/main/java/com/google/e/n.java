package com.google.e;

import java.util.EnumMap;
import java.util.Map;

public final class n
{
  private final String a;
  private final byte[] b;
  private p[] c;
  private final a d;
  private Map<o, Object> e;
  private final long f;

  public n(String paramString, byte[] paramArrayOfByte, p[] paramArrayOfp, a parama)
  {
    this(paramString, paramArrayOfByte, paramArrayOfp, parama, System.currentTimeMillis());
  }

  public n(String paramString, byte[] paramArrayOfByte, p[] paramArrayOfp, a parama, long paramLong)
  {
    this.a = paramString;
    this.b = paramArrayOfByte;
    this.c = paramArrayOfp;
    this.d = parama;
    this.e = null;
    this.f = paramLong;
  }

  public String a()
  {
    return this.a;
  }

  public void a(o paramo, Object paramObject)
  {
    if (this.e == null)
      this.e = new EnumMap(o.class);
    this.e.put(paramo, paramObject);
  }

  public void a(Map<o, Object> paramMap)
  {
    if (paramMap != null)
    {
      if (this.e == null)
        this.e = paramMap;
    }
    else
      return;
    this.e.putAll(paramMap);
  }

  public void a(p[] paramArrayOfp)
  {
    p[] arrayOfp1 = this.c;
    if (arrayOfp1 == null)
      this.c = paramArrayOfp;
    while ((paramArrayOfp == null) || (paramArrayOfp.length <= 0))
      return;
    p[] arrayOfp2 = new p[arrayOfp1.length + paramArrayOfp.length];
    System.arraycopy(arrayOfp1, 0, arrayOfp2, 0, arrayOfp1.length);
    System.arraycopy(paramArrayOfp, 0, arrayOfp2, arrayOfp1.length, paramArrayOfp.length);
    this.c = arrayOfp2;
  }

  public byte[] b()
  {
    return this.b;
  }

  public p[] c()
  {
    return this.c;
  }

  public a d()
  {
    return this.d;
  }

  public Map<o, Object> e()
  {
    return this.e;
  }

  public String toString()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.n
 * JD-Core Version:    0.6.2
 */
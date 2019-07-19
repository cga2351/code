package com.c.a.a.b;

import com.c.a.a.m;
import java.io.Serializable;

public class k
  implements m, Serializable
{
  protected final String a;
  protected byte[] b;

  public k(String paramString)
  {
    if (paramString == null)
      throw new IllegalStateException("Null String illegal for SerializedString");
    this.a = paramString;
  }

  public final String a()
  {
    return this.a;
  }

  public final byte[] b()
  {
    byte[] arrayOfByte = this.b;
    if (arrayOfByte == null)
    {
      arrayOfByte = f.a().a(this.a);
      this.b = arrayOfByte;
    }
    return arrayOfByte;
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if ((paramObject == null) || (paramObject.getClass() != getClass()))
      return false;
    k localk = (k)paramObject;
    return this.a.equals(localk.a);
  }

  public final int hashCode()
  {
    return this.a.hashCode();
  }

  public final String toString()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.b.k
 * JD-Core Version:    0.6.2
 */
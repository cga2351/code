package com.esotericsoftware.reflectasm.shaded.org.objectweb.asm;

public final class Handle
{
  final int a;
  final String b;
  final String c;
  final String d;

  public Handle(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    Handle localHandle;
    do
    {
      return true;
      if (!(paramObject instanceof Handle))
        return false;
      localHandle = (Handle)paramObject;
    }
    while ((this.a == localHandle.a) && (this.b.equals(localHandle.b)) && (this.c.equals(localHandle.c)) && (this.d.equals(localHandle.d)));
    return false;
  }

  public String getDesc()
  {
    return this.d;
  }

  public String getName()
  {
    return this.c;
  }

  public String getOwner()
  {
    return this.b;
  }

  public int getTag()
  {
    return this.a;
  }

  public int hashCode()
  {
    return this.a + this.b.hashCode() * this.c.hashCode() * this.d.hashCode();
  }

  public String toString()
  {
    return this.b + '.' + this.c + this.d + " (" + this.a + ')';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.Handle
 * JD-Core Version:    0.6.2
 */
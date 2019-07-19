package androidx.work.impl.a;

public class b
{
  private boolean a;
  private boolean b;
  private boolean c;
  private boolean d;

  public b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
    this.d = paramBoolean4;
  }

  public boolean a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.b;
  }

  public boolean c()
  {
    return this.c;
  }

  public boolean d()
  {
    return this.d;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    b localb;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localb = (b)paramObject;
    }
    while ((this.a == localb.a) && (this.b == localb.b) && (this.c == localb.c) && (this.d == localb.d));
    return false;
  }

  public int hashCode()
  {
    boolean bool = this.a;
    int i = 0;
    if (bool)
      i = 1;
    if (this.b)
      i += 16;
    if (this.c)
      i += 256;
    if (this.d)
      i += 4096;
    return i;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Boolean.valueOf(this.a);
    arrayOfObject[1] = Boolean.valueOf(this.b);
    arrayOfObject[2] = Boolean.valueOf(this.c);
    arrayOfObject[3] = Boolean.valueOf(this.d);
    return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.a.b
 * JD-Core Version:    0.6.2
 */
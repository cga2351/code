package androidx.work.impl.b;

public class d
{
  public final String a;
  public final int b;

  public d(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject)
      bool = true;
    d locald;
    int i;
    int j;
    do
    {
      Class localClass1;
      Class localClass2;
      do
      {
        do
        {
          return bool;
          bool = false;
        }
        while (paramObject == null);
        localClass1 = getClass();
        localClass2 = paramObject.getClass();
        bool = false;
      }
      while (localClass1 != localClass2);
      locald = (d)paramObject;
      i = this.b;
      j = locald.b;
      bool = false;
    }
    while (i != j);
    return this.a.equals(locald.a);
  }

  public int hashCode()
  {
    return 31 * this.a.hashCode() + this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.b.d
 * JD-Core Version:    0.6.2
 */
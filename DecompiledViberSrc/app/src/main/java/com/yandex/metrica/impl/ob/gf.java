package com.yandex.metrica.impl.ob;

public class gf<T, P extends e>
  implements ge<T>
{
  private final String a;
  private final fe b;
  private final gd<P> c;
  private final gn<T, P> d;

  public gf(String paramString, fe paramfe, gd<P> paramgd, gn<T, P> paramgn)
  {
    this.a = paramString;
    this.b = paramfe;
    this.c = paramgd;
    this.d = paramgn;
  }

  public T a()
  {
    try
    {
      byte[] arrayOfByte = this.b.a(this.a);
      if (arrayOfByte == null)
        return this.d.a(this.c.c());
      Object localObject = this.d.a(this.c.b(arrayOfByte));
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return this.d.a(this.c.c());
  }

  public void a(T paramT)
  {
    this.b.a(this.a, this.c.a(this.d.b(paramT)));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.gf
 * JD-Core Version:    0.6.2
 */
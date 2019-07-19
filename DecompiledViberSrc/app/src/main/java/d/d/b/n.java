package d.d.b;

import d.f.b;
import d.f.d;

public class n
{
  public b a(Class paramClass)
  {
    return new c(paramClass);
  }

  public d a(g paramg)
  {
    return paramg;
  }

  public d.f.f a(k paramk)
  {
    return paramk;
  }

  public String a(f paramf)
  {
    String str = paramf.getClass().getGenericInterfaces()[0].toString();
    if (str.startsWith("kotlin.jvm.functions."))
      str = str.substring("kotlin.jvm.functions.".length());
    return str;
  }

  public String a(i parami)
  {
    return a(parami);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     d.d.b.n
 * JD-Core Version:    0.6.2
 */
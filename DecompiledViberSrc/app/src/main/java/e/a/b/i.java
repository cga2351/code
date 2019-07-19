package e.a.b;

import e.a.b.c.d;
import java.io.IOException;

public class i
{
  public static g a = g.a;
  public static final d b = new d();
  public static final e.a.b.d.e c = new e.a.b.d.e();

  public static String a(String paramString)
  {
    return a(paramString, a);
  }

  public static String a(String paramString, g paramg)
  {
    if (paramString == null)
      return null;
    StringBuilder localStringBuilder = new StringBuilder();
    paramg.a(paramString, localStringBuilder);
    return localStringBuilder.toString();
  }

  public static void a(Object paramObject, Appendable paramAppendable, g paramg)
    throws IOException
  {
    if (paramObject == null)
    {
      paramAppendable.append("null");
      return;
    }
    Class localClass = paramObject.getClass();
    e.a.b.c.e locale = b.b(localClass);
    if (locale == null)
    {
      if (!localClass.isArray())
        break label72;
      locale = d.j;
    }
    while (true)
    {
      b.a(locale, new Class[] { localClass });
      locale.a(paramObject, paramAppendable, paramg);
      return;
      label72: locale = b.a(paramObject.getClass());
      if (locale == null)
        locale = d.h;
    }
  }

  public static void a(String paramString, Appendable paramAppendable, g paramg)
  {
    if (paramString == null)
      return;
    paramg.a(paramString, paramAppendable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.b.i
 * JD-Core Version:    0.6.2
 */
package e.a.b;

import e.a.b.c.d;
import e.a.b.c.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class a extends ArrayList<Object>
  implements c, f, List<Object>
{
  public static String a(List<? extends Object> paramList, g paramg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      a(paramList, localStringBuilder, paramg);
      label14: return localStringBuilder.toString();
    }
    catch (IOException localIOException)
    {
      break label14;
    }
  }

  public static void a(Iterable<? extends Object> paramIterable, Appendable paramAppendable, g paramg)
    throws IOException
  {
    if (paramIterable == null)
    {
      paramAppendable.append("null");
      return;
    }
    d.e.a(paramIterable, paramAppendable, paramg);
  }

  public String a(g paramg)
  {
    return a(this, paramg);
  }

  public void a(Appendable paramAppendable)
    throws IOException
  {
    a(this, paramAppendable, i.a);
  }

  public void a(Appendable paramAppendable, g paramg)
    throws IOException
  {
    a(this, paramAppendable, paramg);
  }

  public String b()
  {
    return a(this, i.a);
  }

  public String toString()
  {
    return b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.b.a
 * JD-Core Version:    0.6.2
 */
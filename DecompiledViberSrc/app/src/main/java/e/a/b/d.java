package e.a.b;

import e.a.b.c.e;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class d extends HashMap<String, Object>
  implements b, c, f
{
  public d()
  {
  }

  public d(Map<String, ?> paramMap)
  {
    super(paramMap);
  }

  public static String a(String paramString)
  {
    return i.a(paramString);
  }

  public static String a(Map<String, ? extends Object> paramMap, g paramg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      a(paramMap, localStringBuilder, paramg);
      label14: return localStringBuilder.toString();
    }
    catch (IOException localIOException)
    {
      break label14;
    }
  }

  public static void a(String paramString, Object paramObject, Appendable paramAppendable, g paramg)
    throws IOException
  {
    if (paramString == null)
      paramAppendable.append("null");
    while (true)
    {
      paramAppendable.append(':');
      if (!(paramObject instanceof String))
        break;
      paramg.a(paramAppendable, (String)paramObject);
      return;
      if (!paramg.a(paramString))
      {
        paramAppendable.append(paramString);
      }
      else
      {
        paramAppendable.append('"');
        i.a(paramString, paramAppendable, paramg);
        paramAppendable.append('"');
      }
    }
    i.a(paramObject, paramAppendable, paramg);
  }

  public static void a(Map<String, ? extends Object> paramMap, Appendable paramAppendable, g paramg)
    throws IOException
  {
    if (paramMap == null)
    {
      paramAppendable.append("null");
      return;
    }
    e.a.b.c.d.g.a(paramMap, paramAppendable, paramg);
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
    return a(this, i.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.b.d
 * JD-Core Version:    0.6.2
 */
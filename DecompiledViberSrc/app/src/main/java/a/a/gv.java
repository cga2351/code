package a.a;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum gv
{
  private static final Map<String, gv> g;
  private final String h;

  static
  {
    gv[] arrayOfgv = new gv[6];
    arrayOfgv[0] = a;
    arrayOfgv[1] = b;
    arrayOfgv[2] = c;
    arrayOfgv[3] = d;
    arrayOfgv[4] = e;
    arrayOfgv[5] = f;
    i = arrayOfgv;
    g = new HashMap();
    Iterator localIterator = EnumSet.allOf(gv.class).iterator();
    while (localIterator.hasNext())
    {
      gv localgv = (gv)localIterator.next();
      g.put(localgv.a(), localgv);
    }
  }

  private gv(String paramString)
  {
    this.h = paramString;
  }

  public String a()
  {
    return this.h;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.gv
 * JD-Core Version:    0.6.2
 */
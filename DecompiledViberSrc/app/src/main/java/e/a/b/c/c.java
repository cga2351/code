package e.a.b.c;

import e.a.a.b;
import e.a.b.g;
import e.a.b.h;
import java.io.IOException;

public class c
  implements e<Object>
{
  public <E> void a(E paramE, Appendable paramAppendable, g paramg)
    throws IOException
  {
    int i = 0;
    while (true)
    {
      int k;
      try
      {
        e.a.a.d locald = e.a.a.d.a(paramE.getClass(), h.a);
        paramAppendable.append('{');
        b[] arrayOfb = locald.a();
        int j = arrayOfb.length;
        k = 0;
        if (k >= j)
        {
          paramAppendable.append('}');
          return;
        }
        b localb = arrayOfb[k];
        Object localObject = locald.a(paramE, localb.a());
        if ((localObject == null) && (paramg.a()))
          break label131;
        if (i != 0)
        {
          paramAppendable.append(',');
          e.a.b.d.a(localb.d(), localObject, paramAppendable, paramg);
        }
      }
      catch (IOException localIOException)
      {
        throw localIOException;
      }
      i = 1;
      continue;
      label131: k++;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.b.c.c
 * JD-Core Version:    0.6.2
 */
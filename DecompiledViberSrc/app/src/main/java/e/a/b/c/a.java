package e.a.b.c;

import e.a.b.g;
import e.a.b.i;
import java.io.IOException;

public class a
  implements e<Object>
{
  public <E> void a(E paramE, Appendable paramAppendable, g paramg)
    throws IOException
  {
    int i = 0;
    paramg.g(paramAppendable);
    Object[] arrayOfObject = (Object[])paramE;
    int j = arrayOfObject.length;
    int k = 0;
    if (k >= j)
    {
      paramg.h(paramAppendable);
      return;
    }
    Object localObject = arrayOfObject[k];
    if (i != 0)
      paramg.d(paramAppendable);
    while (true)
    {
      i.a(localObject, paramAppendable, paramg);
      k++;
      break;
      i = 1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.b.c.a
 * JD-Core Version:    0.6.2
 */
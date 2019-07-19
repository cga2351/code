package e.a.b.c;

import e.a.b.g;
import e.a.b.h;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class b
  implements e<Object>
{
  public <E> void a(E paramE, Appendable paramAppendable, g paramg)
    throws IOException
  {
    while (true)
    {
      Class localClass2;
      int i;
      int k;
      Field localField;
      Object localObject1;
      try
      {
        Class localClass1 = paramE.getClass();
        paramg.a(paramAppendable);
        localClass2 = localClass1;
        i = 0;
        if (localClass2 == Object.class)
        {
          paramg.b(paramAppendable);
          return;
        }
        Field[] arrayOfField = localClass2.getDeclaredFields();
        int j = arrayOfField.length;
        k = 0;
        if (k >= j)
        {
          localClass2 = localClass2.getSuperclass();
          continue;
        }
        localField = arrayOfField[k];
        int m = localField.getModifiers();
        if ((m & 0x98) > 0)
          break label264;
        if ((m & 0x1) > 0)
        {
          localObject1 = localField.get(paramE);
          if ((localObject1 == null) && (paramg.a()))
            break label264;
          if (i == 0)
            break label250;
          paramg.d(paramAppendable);
          d.a(localField.getName(), localObject1, paramAppendable, paramg);
        }
      }
      catch (Exception localException1)
      {
        throw new RuntimeException(localException1);
      }
      String str = h.a(localField.getName());
      try
      {
        Method localMethod2 = localClass2.getDeclaredMethod(str, new Class[0]);
        localMethod1 = localMethod2;
        if (localMethod1 == null)
        {
          Class localClass3 = localField.getType();
          if ((localClass3 == Boolean.TYPE) || (localClass3 == Boolean.class))
            localMethod1 = localClass2.getDeclaredMethod(h.b(localField.getName()), new Class[0]);
        }
        if (localMethod1 != null)
        {
          Object localObject2 = localMethod1.invoke(paramE, new Object[0]);
          localObject1 = localObject2;
          continue;
          label250: i = 1;
        }
      }
      catch (Exception localException2)
      {
        while (true)
          Method localMethod1 = null;
      }
      label264: k++;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.b.c.b
 * JD-Core Version:    0.6.2
 */
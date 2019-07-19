package com.google.d.b.a;

import com.google.d.b.h;
import com.google.d.e;
import com.google.d.f;
import com.google.d.u;
import com.google.d.w;
import com.google.d.x;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class i
  implements x
{
  private final com.google.d.b.c a;
  private final e b;
  private final com.google.d.b.d c;
  private final d d;

  public i(com.google.d.b.c paramc, e parame, com.google.d.b.d paramd, d paramd1)
  {
    this.a = paramc;
    this.b = parame;
    this.c = paramd;
    this.d = paramd1;
  }

  private b a(final f paramf, final Field paramField, String paramString, final com.google.d.c.a<?> parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    final boolean bool1 = com.google.d.b.i.a(parama.getRawType());
    com.google.d.a.b localb = (com.google.d.a.b)paramField.getAnnotation(com.google.d.a.b.class);
    final w localw = null;
    if (localb != null)
      localw = this.d.a(this.a, paramf, parama, localb);
    if (localw != null);
    for (final boolean bool2 = true; ; bool2 = false)
    {
      if (localw == null)
        localw = paramf.a(parama);
      return new b(paramString, paramBoolean1, paramBoolean2)
      {
        void a(com.google.d.d.a paramAnonymousa, Object paramAnonymousObject)
          throws IOException, IllegalAccessException
        {
          Object localObject = localw.b(paramAnonymousa);
          if ((localObject != null) || (!bool1))
            paramField.set(paramAnonymousObject, localObject);
        }

        void a(com.google.d.d.c paramAnonymousc, Object paramAnonymousObject)
          throws IOException, IllegalAccessException
        {
          Object localObject1 = paramField.get(paramAnonymousObject);
          if (bool2);
          for (Object localObject2 = localw; ; localObject2 = new m(paramf, localw, parama.getType()))
          {
            ((w)localObject2).a(paramAnonymousc, localObject1);
            return;
          }
        }

        public boolean a(Object paramAnonymousObject)
          throws IOException, IllegalAccessException
        {
          if (!this.i);
          while (paramField.get(paramAnonymousObject) == paramAnonymousObject)
            return false;
          return true;
        }
      };
    }
  }

  private List<String> a(Field paramField)
  {
    com.google.d.a.c localc = (com.google.d.a.c)paramField.getAnnotation(com.google.d.a.c.class);
    Object localObject;
    if (localc == null)
      localObject = Collections.singletonList(this.b.a(paramField));
    while (true)
    {
      return localObject;
      String str = localc.a();
      String[] arrayOfString = localc.b();
      if (arrayOfString.length == 0)
        return Collections.singletonList(str);
      localObject = new ArrayList(1 + arrayOfString.length);
      ((List)localObject).add(str);
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++)
        ((List)localObject).add(arrayOfString[j]);
    }
  }

  private Map<String, b> a(f paramf, com.google.d.c.a<?> parama, Class<?> paramClass)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramClass.isInterface())
      return localLinkedHashMap;
    Type localType1 = parama.getType();
    label87: Object localObject1;
    int k;
    label136: Object localObject2;
    if (paramClass != Object.class)
    {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int i = arrayOfField.length;
      int j = 0;
      while (true)
        if (j < i)
        {
          Field localField = arrayOfField[j];
          boolean bool1 = a(localField, true);
          boolean bool2 = a(localField, false);
          if ((!bool1) && (!bool2))
          {
            j++;
          }
          else
          {
            localField.setAccessible(true);
            Type localType4 = parama.getType();
            Type localType5 = localField.getGenericType();
            Type localType6 = com.google.d.b.b.a(localType4, paramClass, localType5);
            List localList = a(localField);
            localObject1 = null;
            k = 0;
            if (k < localList.size())
            {
              String str = (String)localList.get(k);
              if (k != 0)
                bool1 = false;
              localObject2 = (b)localLinkedHashMap.put(str, a(paramf, localField, str, com.google.d.c.a.get(localType6), bool1, bool2));
              if (localObject1 != null)
                break label293;
            }
          }
        }
    }
    while (true)
    {
      k++;
      localObject1 = localObject2;
      break label136;
      if (localObject1 == null)
        break label87;
      throw new IllegalArgumentException(localType1 + " declares multiple JSON fields named " + localObject1.h);
      Type localType2 = parama.getType();
      Type localType3 = paramClass.getGenericSuperclass();
      parama = com.google.d.c.a.get(com.google.d.b.b.a(localType2, paramClass, localType3));
      paramClass = parama.getRawType();
      break;
      return localLinkedHashMap;
      label293: localObject2 = localObject1;
    }
  }

  static boolean a(Field paramField, boolean paramBoolean, com.google.d.b.d paramd)
  {
    return (!paramd.a(paramField.getType(), paramBoolean)) && (!paramd.a(paramField, paramBoolean));
  }

  public <T> w<T> a(f paramf, com.google.d.c.a<T> parama)
  {
    Class localClass = parama.getRawType();
    if (!Object.class.isAssignableFrom(localClass))
      return null;
    return new a(this.a.a(parama), a(paramf, parama, localClass));
  }

  public boolean a(Field paramField, boolean paramBoolean)
  {
    return a(paramField, paramBoolean, this.c);
  }

  public static final class a<T> extends w<T>
  {
    private final h<T> a;
    private final Map<String, i.b> b;

    a(h<T> paramh, Map<String, i.b> paramMap)
    {
      this.a = paramh;
      this.b = paramMap;
    }

    public void a(com.google.d.d.c paramc, T paramT)
      throws IOException
    {
      if (paramT == null)
      {
        paramc.f();
        return;
      }
      paramc.d();
      try
      {
        Iterator localIterator = this.b.values().iterator();
        while (localIterator.hasNext())
        {
          i.b localb = (i.b)localIterator.next();
          if (localb.a(paramT))
          {
            paramc.a(localb.h);
            localb.a(paramc, paramT);
          }
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new AssertionError(localIllegalAccessException);
      }
      paramc.e();
    }

    public T b(com.google.d.d.a parama)
      throws IOException
    {
      if (parama.f() == com.google.d.d.b.i)
      {
        parama.j();
        return null;
      }
      Object localObject = this.a.a();
      try
      {
        parama.c();
        while (true)
        {
          if (!parama.e())
            break label111;
          String str = parama.g();
          localb = (i.b)this.b.get(str);
          if ((localb != null) && (localb.j))
            break;
          parama.n();
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        while (true)
        {
          i.b localb;
          throw new u(localIllegalStateException);
          localb.a(parama, localObject);
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new AssertionError(localIllegalAccessException);
      }
      label111: parama.d();
      return localObject;
    }
  }

  static abstract class b
  {
    final String h;
    final boolean i;
    final boolean j;

    protected b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.h = paramString;
      this.i = paramBoolean1;
      this.j = paramBoolean2;
    }

    abstract void a(com.google.d.d.a parama, Object paramObject)
      throws IOException, IllegalAccessException;

    abstract void a(com.google.d.d.c paramc, Object paramObject)
      throws IOException, IllegalAccessException;

    abstract boolean a(Object paramObject)
      throws IOException, IllegalAccessException;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.a.i
 * JD-Core Version:    0.6.2
 */
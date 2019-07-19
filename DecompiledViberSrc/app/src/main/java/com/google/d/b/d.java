package com.google.d.b;

import com.google.d.a.e;
import com.google.d.b;
import com.google.d.f;
import com.google.d.w;
import com.google.d.x;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class d
  implements x, Cloneable
{
  public static final d a = new d();
  private double b = -1.0D;
  private int c = 136;
  private boolean d = true;
  private boolean e;
  private List<b> f = Collections.emptyList();
  private List<b> g = Collections.emptyList();

  private boolean a(com.google.d.a.d paramd)
  {
    return (paramd == null) || (paramd.a() <= this.b);
  }

  private boolean a(com.google.d.a.d paramd, e parame)
  {
    return (a(paramd)) && (a(parame));
  }

  private boolean a(e parame)
  {
    return (parame == null) || (parame.a() > this.b);
  }

  private boolean a(Class<?> paramClass)
  {
    return (!Enum.class.isAssignableFrom(paramClass)) && ((paramClass.isAnonymousClass()) || (paramClass.isLocalClass()));
  }

  private boolean b(Class<?> paramClass)
  {
    return (paramClass.isMemberClass()) && (!c(paramClass));
  }

  private boolean c(Class<?> paramClass)
  {
    return (0x8 & paramClass.getModifiers()) != 0;
  }

  protected d a()
  {
    try
    {
      d locald = (d)super.clone();
      return locald;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }

  public <T> w<T> a(final f paramf, final com.google.d.c.a<T> parama)
  {
    Class localClass = parama.getRawType();
    final boolean bool1 = a(localClass, true);
    final boolean bool2 = a(localClass, false);
    if ((!bool1) && (!bool2))
      return null;
    return new w()
    {
      private w<T> f;

      private w<T> b()
      {
        w localw1 = this.f;
        if (localw1 != null)
          return localw1;
        w localw2 = paramf.a(d.this, parama);
        this.f = localw2;
        return localw2;
      }

      public void a(com.google.d.d.c paramAnonymousc, T paramAnonymousT)
        throws IOException
      {
        if (bool1)
        {
          paramAnonymousc.f();
          return;
        }
        b().a(paramAnonymousc, paramAnonymousT);
      }

      public T b(com.google.d.d.a paramAnonymousa)
        throws IOException
      {
        if (bool2)
        {
          paramAnonymousa.n();
          return null;
        }
        return b().b(paramAnonymousa);
      }
    };
  }

  public boolean a(Class<?> paramClass, boolean paramBoolean)
  {
    if ((this.b != -1.0D) && (!a((com.google.d.a.d)paramClass.getAnnotation(com.google.d.a.d.class), (e)paramClass.getAnnotation(e.class))))
      return true;
    if ((!this.d) && (b(paramClass)))
      return true;
    if (a(paramClass))
      return true;
    if (paramBoolean);
    for (List localList = this.f; ; localList = this.g)
    {
      Iterator localIterator = localList.iterator();
      do
        if (!localIterator.hasNext())
          break;
      while (!((b)localIterator.next()).a(paramClass));
      return true;
    }
    return false;
  }

  public boolean a(Field paramField, boolean paramBoolean)
  {
    if ((this.c & paramField.getModifiers()) != 0)
      return true;
    if ((this.b != -1.0D) && (!a((com.google.d.a.d)paramField.getAnnotation(com.google.d.a.d.class), (e)paramField.getAnnotation(e.class))))
      return true;
    if (paramField.isSynthetic())
      return true;
    if (this.e)
    {
      com.google.d.a.a locala = (com.google.d.a.a)paramField.getAnnotation(com.google.d.a.a.class);
      if (locala != null)
      {
        if (!paramBoolean)
          break label100;
        if (locala.a())
          break label110;
      }
      label100: 
      while (!locala.b())
        return true;
    }
    label110: if ((!this.d) && (b(paramField.getType())))
      return true;
    if (a(paramField.getType()))
      return true;
    if (paramBoolean);
    for (List localList = this.f; !localList.isEmpty(); localList = this.g)
    {
      com.google.d.c localc = new com.google.d.c(paramField);
      Iterator localIterator = localList.iterator();
      do
        if (!localIterator.hasNext())
          break;
      while (!((b)localIterator.next()).a(localc));
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.d
 * JD-Core Version:    0.6.2
 */
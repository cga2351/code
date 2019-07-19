package d.b;

import d.d.b.h;
import d.g.d;
import d.m;
import org.jetbrains.annotations.NotNull;

public final class b
{

  @NotNull
  public static final a a;

  static
  {
    int i = a();
    Object localObject4;
    Object localObject3;
    Object localObject2;
    Object localObject1;
    a locala;
    if (i >= 65544)
    {
      try
      {
        localObject4 = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
        h.a(localObject4, "Class.forName(\"kotlin.in…entations\").newInstance()");
        if (localObject4 != null)
          break label467;
        try
        {
          throw new m("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
        }
        catch (ClassCastException localClassCastException4)
        {
          ClassLoader localClassLoader7 = localObject4.getClass().getClassLoader();
          ClassLoader localClassLoader8 = a.class.getClassLoader();
          Throwable localThrowable4 = new ClassCastException("Instance classloader: " + localClassLoader7 + ", base type classloader: " + localClassLoader8).initCause((Throwable)localClassCastException4);
          h.a(localThrowable4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
          throw localThrowable4;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException3)
      {
        try
        {
          localObject3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
          h.a(localObject3, "Class.forName(\"kotlin.in…entations\").newInstance()");
          if (localObject3 != null)
            break label476;
          try
          {
            throw new m("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
          }
          catch (ClassCastException localClassCastException3)
          {
            ClassLoader localClassLoader5 = localObject3.getClass().getClassLoader();
            ClassLoader localClassLoader6 = a.class.getClassLoader();
            Throwable localThrowable3 = new ClassCastException("Instance classloader: " + localClassLoader5 + ", base type classloader: " + localClassLoader6).initCause((Throwable)localClassCastException3);
            h.a(localThrowable3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
            throw localThrowable3;
          }
        }
        catch (ClassNotFoundException localClassNotFoundException4)
        {
        }
      }
    }
    else
    {
      if (i >= 65543)
        try
        {
          localObject2 = Class.forName("d.b.a.a").newInstance();
          h.a(localObject2, "Class.forName(\"kotlin.in…entations\").newInstance()");
          if (localObject2 != null)
            break label485;
          try
          {
            throw new m("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
          }
          catch (ClassCastException localClassCastException2)
          {
            ClassLoader localClassLoader3 = localObject2.getClass().getClassLoader();
            ClassLoader localClassLoader4 = a.class.getClassLoader();
            Throwable localThrowable2 = new ClassCastException("Instance classloader: " + localClassLoader3 + ", base type classloader: " + localClassLoader4).initCause((Throwable)localClassCastException2);
            h.a(localThrowable2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
            throw localThrowable2;
          }
        }
        catch (ClassNotFoundException localClassNotFoundException1)
        {
          try
          {
            localObject1 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
            h.a(localObject1, "Class.forName(\"kotlin.in…entations\").newInstance()");
            if (localObject1 != null)
              break label494;
            try
            {
              throw new m("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            catch (ClassCastException localClassCastException1)
            {
              ClassLoader localClassLoader1 = localObject1.getClass().getClassLoader();
              ClassLoader localClassLoader2 = a.class.getClassLoader();
              Throwable localThrowable1 = new ClassCastException("Instance classloader: " + localClassLoader1 + ", base type classloader: " + localClassLoader2).initCause((Throwable)localClassCastException1);
              h.a(localThrowable1, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
              throw localThrowable1;
            }
          }
          catch (ClassNotFoundException localClassNotFoundException2)
          {
          }
        }
      locala = new a();
    }
    while (true)
    {
      a = locala;
      return;
      label467: locala = (a)localObject4;
      continue;
      label476: locala = (a)localObject3;
      continue;
      label485: locala = (a)localObject2;
      continue;
      label494: locala = (a)localObject1;
    }
  }

  private static final int a()
  {
    int i = 65542;
    String str1 = System.getProperty("java.specification.version");
    int j;
    if (str1 != null)
    {
      j = d.a((CharSequence)str1, '.', 0, false, 6, null);
      if (j >= 0);
    }
    else
    {
      try
      {
        int i3 = Integer.parseInt(str1);
        i2 = i3 * 65536;
        i = i2;
        return i;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        while (true)
          int i2 = i;
      }
    }
    int k = d.a((CharSequence)str1, '.', j + 1, false, 4, null);
    if (k < 0)
      k = str1.length();
    if (str1 == null)
      throw new m("null cannot be cast to non-null type java.lang.String");
    String str2 = str1.substring(0, j);
    h.a(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    int m = j + 1;
    if (str1 == null)
      throw new m("null cannot be cast to non-null type java.lang.String");
    String str3 = str1.substring(m, k);
    h.a(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    try
    {
      int n = 65536 * Integer.parseInt(str2);
      int i1 = Integer.parseInt(str3);
      return n + i1;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
    }
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     d.b.b
 * JD-Core Version:    0.6.2
 */
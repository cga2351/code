package d.d.b;

import d.f.b;
import d.f.d;
import d.f.f;

public class m
{
  private static final n a;
  private static final b[] b;

  static
  {
    try
    {
      localn = (n)Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
      if (localn != null)
      {
        a = localn;
        b = new b[0];
        return;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      while (true)
        localn = null;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
        localn = null;
    }
    catch (InstantiationException localInstantiationException)
    {
      while (true)
        localn = null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      while (true)
      {
        n localn = null;
        continue;
        localn = new n();
      }
    }
  }

  public static b a(Class paramClass)
  {
    return a.a(paramClass);
  }

  public static d a(g paramg)
  {
    return a.a(paramg);
  }

  public static f a(k paramk)
  {
    return a.a(paramk);
  }

  public static String a(i parami)
  {
    return a.a(parami);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     d.d.b.m
 * JD-Core Version:    0.6.2
 */
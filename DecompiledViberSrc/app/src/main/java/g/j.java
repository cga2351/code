package g;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

class j
{
  private static final j a = c();

  static j a()
  {
    return a;
  }

  private static j c()
  {
    try
    {
      Class.forName("android.os.Build");
      if (Build.VERSION.SDK_INT != 0)
      {
        a locala = new a();
        return locala;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      try
      {
        Class.forName("java.util.Optional");
        b localb = new b();
        return localb;
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
      }
    }
    return new j();
  }

  c.a a(@Nullable Executor paramExecutor)
  {
    if (paramExecutor != null)
      return new g(paramExecutor);
    return f.a;
  }

  @Nullable
  Object a(Method paramMethod, Class<?> paramClass, Object paramObject, @Nullable Object[] paramArrayOfObject)
    throws Throwable
  {
    throw new UnsupportedOperationException();
  }

  boolean a(Method paramMethod)
  {
    return false;
  }

  @Nullable
  Executor b()
  {
    return null;
  }

  static class a extends j
  {
    c.a a(@Nullable Executor paramExecutor)
    {
      if (paramExecutor == null)
        throw new AssertionError();
      return new g(paramExecutor);
    }

    public Executor b()
    {
      return new a();
    }

    static class a
      implements Executor
    {
      private final Handler a = new Handler(Looper.getMainLooper());

      public void execute(Runnable paramRunnable)
      {
        this.a.post(paramRunnable);
      }
    }
  }

  @IgnoreJRERequirement
  static class b extends j
  {
    Object a(Method paramMethod, Class<?> paramClass, Object paramObject, @Nullable Object[] paramArrayOfObject)
      throws Throwable
    {
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = Class.class;
      arrayOfClass[1] = Integer.TYPE;
      Constructor localConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(arrayOfClass);
      localConstructor.setAccessible(true);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramClass;
      arrayOfObject[1] = Integer.valueOf(-1);
      return ((MethodHandles.Lookup)localConstructor.newInstance(arrayOfObject)).unreflectSpecial(paramMethod, paramClass).bindTo(paramObject).invokeWithArguments(paramArrayOfObject);
    }

    boolean a(Method paramMethod)
    {
      return paramMethod.isDefault();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     g.j
 * JD-Core Version:    0.6.2
 */
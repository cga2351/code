package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class a
{
  protected static <T extends c> T a(String paramString, a parama)
  {
    try
    {
      c localc = (c)Class.forName(paramString, true, a.class.getClassLoader()).getDeclaredMethod("read", new Class[] { a.class }).invoke(null, new Object[] { parama });
      return localc;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException("VersionedParcel encountered IllegalAccessException", localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      if ((localInvocationTargetException.getCause() instanceof RuntimeException))
        throw ((RuntimeException)localInvocationTargetException.getCause());
      throw new RuntimeException("VersionedParcel encountered InvocationTargetException", localInvocationTargetException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", localNoSuchMethodException);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", localClassNotFoundException);
    }
  }

  private static Class a(Class<? extends c> paramClass)
    throws ClassNotFoundException
  {
    String str = paramClass.getPackage().getName();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = str;
    arrayOfObject[1] = paramClass.getSimpleName();
    return Class.forName(String.format("%s.%sParcelizer", arrayOfObject), false, paramClass.getClassLoader());
  }

  protected static <T extends c> void a(T paramT, a parama)
  {
    try
    {
      Class localClass = c(paramT);
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = paramT.getClass();
      arrayOfClass[1] = a.class;
      localClass.getDeclaredMethod("write", arrayOfClass).invoke(null, new Object[] { paramT, parama });
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException("VersionedParcel encountered IllegalAccessException", localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      if ((localInvocationTargetException.getCause() instanceof RuntimeException))
        throw ((RuntimeException)localInvocationTargetException.getCause());
      throw new RuntimeException("VersionedParcel encountered InvocationTargetException", localInvocationTargetException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", localNoSuchMethodException);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", localClassNotFoundException);
    }
  }

  private void b(c paramc)
  {
    try
    {
      Class localClass = a(paramc.getClass());
      a(localClass.getName());
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException(paramc.getClass().getSimpleName() + " does not have a Parcelizer", localClassNotFoundException);
    }
  }

  private static <T extends c> Class c(T paramT)
    throws ClassNotFoundException
  {
    return a(paramT.getClass());
  }

  protected abstract void a(int paramInt);

  public void a(int paramInt1, int paramInt2)
  {
    c(paramInt2);
    a(paramInt1);
  }

  protected abstract void a(Parcelable paramParcelable);

  public void a(Parcelable paramParcelable, int paramInt)
  {
    c(paramInt);
    a(paramParcelable);
  }

  protected void a(c paramc)
  {
    if (paramc == null)
    {
      a(null);
      return;
    }
    b(paramc);
    a locala = c();
    a(paramc, locala);
    locala.b();
  }

  public void a(c paramc, int paramInt)
  {
    c(paramInt);
    a(paramc);
  }

  protected abstract void a(String paramString);

  public void a(String paramString, int paramInt)
  {
    c(paramInt);
    a(paramString);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
  }

  protected abstract void a(byte[] paramArrayOfByte);

  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    c(paramInt);
    a(paramArrayOfByte);
  }

  public boolean a()
  {
    return false;
  }

  public int b(int paramInt1, int paramInt2)
  {
    if (!b(paramInt2))
      return paramInt1;
    return d();
  }

  public <T extends Parcelable> T b(T paramT, int paramInt)
  {
    if (!b(paramInt))
      return paramT;
    return g();
  }

  public <T extends c> T b(T paramT, int paramInt)
  {
    if (!b(paramInt))
      return paramT;
    return h();
  }

  public String b(String paramString, int paramInt)
  {
    if (!b(paramInt))
      return paramString;
    return e();
  }

  protected abstract void b();

  protected abstract boolean b(int paramInt);

  public byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    if (!b(paramInt))
      return paramArrayOfByte;
    return f();
  }

  protected abstract a c();

  protected abstract void c(int paramInt);

  protected abstract int d();

  protected abstract String e();

  protected abstract byte[] f();

  protected abstract <T extends Parcelable> T g();

  protected <T extends c> T h()
  {
    String str = e();
    if (str == null)
      return null;
    return a(str, c());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.versionedparcelable.a
 * JD-Core Version:    0.6.2
 */
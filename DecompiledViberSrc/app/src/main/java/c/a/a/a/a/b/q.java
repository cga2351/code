package c.a.a.a.a.b;

import android.content.Context;
import c.a.a.a.c;
import c.a.a.a.l;
import java.lang.reflect.Method;

final class q
  implements p
{
  private final Method a;
  private final Object b;

  private q(Class paramClass, Object paramObject)
    throws NoSuchMethodException
  {
    this.b = paramObject;
    this.a = paramClass.getDeclaredMethod("isDataCollectionDefaultEnabled", new Class[0]);
  }

  public static p a(Context paramContext)
  {
    try
    {
      Class localClass = paramContext.getClassLoader().loadClass("com.google.firebase.FirebaseApp");
      q localq = new q(localClass, localClass.getDeclaredMethod("getInstance", new Class[0]).invoke(localClass, new Object[0]));
      return localq;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      c.g().a("Fabric", "Could not find class: com.google.firebase.FirebaseApp");
      return null;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      while (true)
        c.g().a("Fabric", "Could not find method: " + localNoSuchMethodException.getMessage());
    }
    catch (Exception localException)
    {
      while (true)
        c.g().a("Fabric", "Unexpected error loading FirebaseApp instance.", localException);
    }
  }

  public boolean a()
  {
    try
    {
      boolean bool = ((Boolean)this.a.invoke(this.b, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      c.g().a("Fabric", "Cannot check isDataCollectionDefaultEnabled on FirebaseApp.", localException);
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.b.q
 * JD-Core Version:    0.6.2
 */
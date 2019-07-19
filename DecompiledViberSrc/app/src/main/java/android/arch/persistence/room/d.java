package android.arch.persistence.room;

import android.content.Context;

public class d
{
  public static <T extends e> e.a<T> a(Context paramContext, Class<T> paramClass)
  {
    return new e.a(paramContext, paramClass, null);
  }

  public static <T extends e> e.a<T> a(Context paramContext, Class<T> paramClass, String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0))
      throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
    return new e.a(paramContext, paramClass, paramString);
  }

  static <T, C> T a(Class<C> paramClass, String paramString)
  {
    String str1 = paramClass.getPackage().getName();
    String str2 = paramClass.getCanonicalName();
    if (str1.isEmpty());
    while (true)
    {
      String str3 = str2.replace('.', '_') + paramString;
      try
      {
        if (str1.isEmpty());
        String str4;
        for (Object localObject1 = str3; ; localObject1 = str4)
        {
          Object localObject2 = Class.forName((String)localObject1).newInstance();
          return localObject2;
          str2 = str2.substring(1 + str1.length());
          break;
          str4 = str1 + "." + str3;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new RuntimeException("cannot find implementation for " + paramClass.getCanonicalName() + ". " + str3 + " does not exist");
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException("Cannot access the constructor" + paramClass.getCanonicalName());
      }
      catch (InstantiationException localInstantiationException)
      {
      }
    }
    throw new RuntimeException("Failed to create an instance of " + paramClass.getCanonicalName());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.persistence.room.d
 * JD-Core Version:    0.6.2
 */
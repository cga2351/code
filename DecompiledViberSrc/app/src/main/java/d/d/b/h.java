package d.d.b;

import d.c;
import d.o;
import java.util.Arrays;
import java.util.List;

public class h
{
  private static <T extends Throwable> T a(T paramT)
  {
    return a(paramT, h.class.getName());
  }

  static <T extends Throwable> T a(T paramT, String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = paramT.getStackTrace();
    int i = arrayOfStackTraceElement.length;
    int j = -1;
    for (int k = 0; k < i; k++)
      if (paramString.equals(arrayOfStackTraceElement[k].getClassName()))
        j = k;
    List localList = Arrays.asList(arrayOfStackTraceElement).subList(j + 1, i);
    paramT.setStackTrace((StackTraceElement[])localList.toArray(new StackTraceElement[localList.size()]));
    return paramT;
  }

  public static void a()
  {
    throw ((c)a(new c()));
  }

  public static void a(Object paramObject, String paramString)
  {
    if (paramObject == null)
      throw ((IllegalStateException)a(new IllegalStateException(paramString + " must not be null")));
  }

  public static void a(String paramString)
  {
    throw ((o)a(new o(paramString)));
  }

  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null)
      return paramObject2 == null;
    return paramObject1.equals(paramObject2);
  }

  public static void b(Object paramObject, String paramString)
  {
    if (paramObject == null)
      c(paramString);
  }

  public static void b(String paramString)
  {
    a("lateinit property " + paramString + " has not been initialized");
  }

  private static void c(String paramString)
  {
    StackTraceElement localStackTraceElement = java.lang.Thread.currentThread().getStackTrace()[3];
    String str1 = localStackTraceElement.getClassName();
    String str2 = localStackTraceElement.getMethodName();
    throw ((IllegalArgumentException)a(new IllegalArgumentException("Parameter specified as non-null is null: method " + str1 + "." + str2 + ", parameter " + paramString)));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     d.d.b.h
 * JD-Core Version:    0.6.2
 */
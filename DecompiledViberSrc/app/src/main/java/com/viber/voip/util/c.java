package com.viber.voip.util;

import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import java.lang.reflect.Method;

public class c
{
  private static final e a = ViberEnv.getLogger();

  public static Object a(Method paramMethod)
  {
    if (paramMethod.isAnnotationPresent(ag.class))
      return Boolean.valueOf(((ag)paramMethod.getAnnotation(ag.class)).a());
    if (paramMethod.isAnnotationPresent(aj.class))
      return Long.valueOf(((aj)paramMethod.getAnnotation(aj.class)).a());
    if (paramMethod.isAnnotationPresent(ai.class))
      return Integer.valueOf(((ai)paramMethod.getAnnotation(ai.class)).a());
    if (paramMethod.isAnnotationPresent(ah.class))
    {
      ah localah = (ah)paramMethod.getAnnotation(ah.class);
      try
      {
        Method localMethod = localah.a().getMethod("valueOf", new Class[] { String.class });
        Class localClass = localah.a();
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localah.b();
        Object localObject2 = localClass.cast(localMethod.invoke(null, arrayOfObject));
        return localObject2;
      }
      catch (Exception localException2)
      {
        return null;
      }
    }
    if (paramMethod.isAnnotationPresent(ak.class))
    {
      ak localak = (ak)paramMethod.getAnnotation(ak.class);
      try
      {
        Object localObject1 = localak.a().newInstance();
        return localObject1;
      }
      catch (Exception localException1)
      {
        return null;
      }
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.c
 * JD-Core Version:    0.6.2
 */
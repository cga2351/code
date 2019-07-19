package com.shopchat.library.util;

import android.content.Context;
import android.content.res.Resources;
import com.shopchat.library.R.string;
import com.shopchat.library.RootView;
import java.lang.reflect.Field;

public class BuildConfigUtils
{
  private static b L = RootView.a;

  public static Object getBuildConfigValue(Context paramContext, String paramString)
  {
    String str1 = paramContext.getResources().getString(R.string.shopchat_library_package_name);
    String str2 = paramContext.getResources().getString(R.string.shopchat_container_package_name);
    Class localClass1 = resolveBuildConfigClass(paramContext, str1);
    Class localClass2 = resolveBuildConfigClass(paramContext, str2);
    if (localClass1 != null);
    for (Object localObject1 = getStaticFieldValue(localClass1, paramString); ; localObject1 = null)
    {
      if (localClass2 != null);
      for (Object localObject2 = getStaticFieldValue(localClass2, paramString); ; localObject2 = null)
      {
        if (localObject2 != null)
          return localObject2;
        if (localObject1 != null)
          return localObject1;
        return null;
      }
    }
  }

  private static Object getStaticFieldValue(Class<?> paramClass, String paramString)
  {
    try
    {
      Object localObject = paramClass.getField(paramString).get(null);
      return localObject;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      b localb = L;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = paramClass.getPackage().getName();
      localb.a(localNoSuchFieldException, "Class Field not found: ?, in package: ?", arrayOfObject);
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      L.a(localIllegalAccessException, "Illegal Access when looking for field: ?", new Object[] { paramString });
    }
    return null;
  }

  private static Class<?> loadClass(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      L.a(localClassNotFoundException, "Class not found for name: ?", new Object[] { paramString });
    }
    return null;
  }

  public static Class resolveBuildConfigClass(Context paramContext, String paramString)
  {
    String str = paramContext.getResources().getString(R.string.shopchat_buildconfig_filename);
    Class localClass = loadClass(paramString + str);
    if (localClass != null)
      return localClass;
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.util.BuildConfigUtils
 * JD-Core Version:    0.6.2
 */
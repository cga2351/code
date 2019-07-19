package com.mixpanel.android.mpmetrics;

import android.R.drawable;
import android.R.id;
import android.content.Context;
import android.util.SparseArray;
import com.mixpanel.android.b.f;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class p
  implements o
{
  private final Context a;
  private final Map<String, Integer> b;
  private final SparseArray<String> c;

  protected p(Context paramContext)
  {
    this.a = paramContext;
    this.b = new HashMap();
    this.c = new SparseArray();
  }

  private static void a(Class<?> paramClass, String paramString, Map<String, Integer> paramMap)
  {
    while (true)
    {
      int i;
      try
      {
        Field[] arrayOfField = paramClass.getFields();
        i = 0;
        if (i < arrayOfField.length)
        {
          Field localField = arrayOfField[i];
          if ((!Modifier.isStatic(localField.getModifiers())) || (localField.getType() != Integer.TYPE))
            break label145;
          Object localObject = localField.getName();
          int j = localField.getInt(null);
          if (paramString == null)
          {
            paramMap.put(localObject, Integer.valueOf(j));
            break label145;
          }
          String str = paramString + ":" + (String)localObject;
          localObject = str;
          continue;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        f.e("MixpanelAPI.RsrcReader", "Can't read built-in id names from " + paramClass.getName(), localIllegalAccessException);
      }
      return;
      label145: i++;
    }
  }

  protected abstract Class<?> a();

  public String a(int paramInt)
  {
    return (String)this.c.get(paramInt);
  }

  protected abstract String a(Context paramContext);

  public boolean a(String paramString)
  {
    return this.b.containsKey(paramString);
  }

  public int b(String paramString)
  {
    return ((Integer)this.b.get(paramString)).intValue();
  }

  protected void b()
  {
    this.b.clear();
    this.c.clear();
    a(a(), "android", this.b);
    String str = a(this.a);
    try
    {
      a(Class.forName(str), null, this.b);
      Iterator localIterator = this.b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.c.put(((Integer)localEntry.getValue()).intValue(), localEntry.getKey());
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
      {
        f.d("MixpanelAPI.RsrcReader", "Can't load names for Android view ids from '" + str + "', ids by name will not be available in the events editor.");
        f.c("MixpanelAPI.RsrcReader", "You may be missing a Resources class for your package due to your proguard configuration, or you may be using an applicationId in your build that isn't the same as the package declared in your AndroidManifest.xml file.\nIf you're using proguard, you can fix this issue by adding the following to your proguard configuration:\n\n-keep class **.R$* {\n    <fields>;\n}\n\nIf you're not using proguard, or if your proguard configuration already contains the directive above, you can add the following to your AndroidManifest.xml file to explicitly point the Mixpanel library to the appropriate library for your resources class:\n\n<meta-data android:name=\"com.mixpanel.android.MPConfig.ResourcePackageName\" android:value=\"YOUR_PACKAGE_NAME\" />\n\nwhere YOUR_PACKAGE_NAME is the same string you use for the \"package\" attribute in your <manifest> tag.");
      }
    }
  }

  public static class a extends p
  {
    private final String a;

    protected a(String paramString, Context paramContext)
    {
      super();
      this.a = paramString;
      b();
    }

    protected Class<?> a()
    {
      return R.drawable.class;
    }

    protected String a(Context paramContext)
    {
      return this.a + ".R$drawable";
    }
  }

  public static class b extends p
  {
    private final String a;

    public b(String paramString, Context paramContext)
    {
      super();
      this.a = paramString;
      b();
    }

    protected Class<?> a()
    {
      return R.id.class;
    }

    protected String a(Context paramContext)
    {
      return this.a + ".R$id";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.p
 * JD-Core Version:    0.6.2
 */
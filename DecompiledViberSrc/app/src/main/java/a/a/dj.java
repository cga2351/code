package a.a;

import com.appboy.f.c;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public class dj
{
  private static final String a = c.a(dj.class);

  public static <TargetEnum extends Enum<TargetEnum>> TargetEnum a(String paramString, Class<TargetEnum> paramClass)
  {
    return Enum.valueOf(paramClass, paramString);
  }

  public static <TargetEnum extends Enum<TargetEnum>> EnumSet<TargetEnum> a(Class<TargetEnum> paramClass, Set<String> paramSet)
  {
    EnumSet localEnumSet = EnumSet.noneOf(paramClass);
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        localEnumSet.add(a(str.toUpperCase(Locale.US), paramClass));
      }
      catch (Exception localException)
      {
        c.e(a, "Failed to create valid device key enum from string: " + str);
      }
    }
    return localEnumSet;
  }

  public static Set<String> a(EnumSet paramEnumSet)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramEnumSet.iterator();
    while (localIterator.hasNext())
      localHashSet.add(localIterator.next().toString());
    return localHashSet;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.dj
 * JD-Core Version:    0.6.2
 */
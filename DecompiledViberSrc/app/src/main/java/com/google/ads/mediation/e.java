package com.google.ads.mediation;

import com.google.android.gms.internal.ads.zzbae;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Deprecated
public class e
{
  public void a(Map<String, String> paramMap)
    throws e.a
  {
    HashMap localHashMap = new HashMap();
    for (Field localField3 : getClass().getFields())
    {
      b localb = (b)localField3.getAnnotation(b.class);
      if (localb != null)
        localHashMap.put(localb.a(), localField3);
    }
    if (localHashMap.isEmpty())
      zzbae.zzep("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
    Iterator localIterator1 = paramMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      Field localField2 = (Field)localHashMap.remove(localEntry.getKey());
      if (localField2 != null)
      {
        try
        {
          localField2.set(this, localEntry.getValue());
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          String str8 = (String)localEntry.getKey();
          zzbae.zzep(49 + String.valueOf(str8).length() + "Server option \"" + str8 + "\" could not be set: Illegal Access");
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          String str7 = (String)localEntry.getKey();
          zzbae.zzep(43 + String.valueOf(str7).length() + "Server option \"" + str7 + "\" could not be set: Bad Type");
        }
      }
      else
      {
        String str5 = (String)localEntry.getKey();
        String str6 = (String)localEntry.getValue();
        zzbae.zzdp(31 + String.valueOf(str5).length() + String.valueOf(str6).length() + "Unexpected server option: " + str5 + " = \"" + str6 + "\"");
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator2 = localHashMap.values().iterator();
    while (localIterator2.hasNext())
    {
      Field localField1 = (Field)localIterator2.next();
      if (((b)localField1.getAnnotation(b.class)).b())
      {
        String str3 = String.valueOf(((b)localField1.getAnnotation(b.class)).a());
        if (str3.length() != 0);
        for (String str4 = "Required server option missing: ".concat(str3); ; str4 = new String("Required server option missing: "))
        {
          zzbae.zzep(str4);
          if (localStringBuilder.length() > 0)
            localStringBuilder.append(", ");
          localStringBuilder.append(((b)localField1.getAnnotation(b.class)).a());
          break;
        }
      }
    }
    if (localStringBuilder.length() > 0)
    {
      String str1 = String.valueOf(localStringBuilder.toString());
      if (str1.length() != 0);
      for (String str2 = "Required server option(s) missing: ".concat(str1); ; str2 = new String("Required server option(s) missing: "))
        throw new a(str2);
    }
  }

  public static final class a extends Exception
  {
    public a(String paramString)
    {
      super();
    }
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface b
  {
    public abstract String a();

    public abstract boolean b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.e
 * JD-Core Version:    0.6.2
 */
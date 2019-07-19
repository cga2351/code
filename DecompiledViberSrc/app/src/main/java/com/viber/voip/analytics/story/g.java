package com.viber.voip.analytics.story;

import android.text.TextUtils;
import com.viber.voip.analytics.story.k.b;
import com.viber.voip.analytics.story.k.c;
import com.viber.voip.analytics.story.k.d;
import com.viber.voip.analytics.story.k.e;
import com.viber.voip.analytics.story.k.e.a;
import com.viber.voip.analytics.story.k.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class g
{
  public static j a(float paramFloat)
  {
    f.a locala = new b.a().a("key_property_name", "updated user's vo balance").a();
    return new j().a(com.viber.voip.analytics.b.a.class, locala).a("key_property_name", Float.valueOf(paramFloat)).a(new f(String.valueOf(paramFloat), "updated user's vo balance", ""));
  }

  public static j a(int paramInt)
  {
    return a("number of contacts", Integer.valueOf(paramInt), new Class[] { com.viber.voip.analytics.b.a.class }).a(new c("number of contacts", "", paramInt));
  }

  public static j a(com.appboy.b.i parami)
  {
    return a("push_subscribe", parami, new Class[] { com.viber.voip.analytics.b.a.class }).a(new c("push_subscribe", "", parami.ordinal()));
  }

  static j a(a parama, boolean paramBoolean)
  {
    j localj = b("app attribution changed", parama, new Class[] { com.viber.voip.analytics.b.a.class });
    if (paramBoolean)
    {
      com.viber.voip.analytics.story.k.a locala = localj.d();
      if (locala != null)
        locala.c();
    }
    return localj;
  }

  public static j a(com.viber.voip.analytics.story.k.a parama, String paramString, Object paramObject, Class[] paramArrayOfClass)
  {
    f.a locala = new b.a().a("key_property_name", paramString).a();
    j localj = new j().a("key_property_name", paramObject).a(parama);
    int i = paramArrayOfClass.length;
    for (int j = 0; j < i; j++)
      localj.a(paramArrayOfClass[j], locala);
    return localj;
  }

  public static j a(Boolean paramBoolean)
  {
    return b("deleted message", paramBoolean, new Class[] { com.viber.voip.analytics.b.a.class });
  }

  public static j a(String paramString)
  {
    f.a locala = new b.a().a("key_property_name", "vo destinations").a();
    return new j().a(com.viber.voip.analytics.b.a.class, locala).a("key_property_name", paramString.split(",", -1)).a(new b(paramString, "vo destinations", ""));
  }

  public static j a(String paramString, Object paramObject, Class paramClass)
  {
    return a(new f(paramObject.toString(), paramString, ""), paramString, paramObject, new Class[] { paramClass });
  }

  private static j a(String paramString, Object paramObject, Class[] paramArrayOfClass)
  {
    f.a locala = new b.a().a("key_property_name", paramString).a();
    j localj = new j().a("key_property_name", paramObject);
    int i = paramArrayOfClass.length;
    for (int j = 0; j < i; j++)
      localj.a(paramArrayOfClass[j], locala);
    return localj;
  }

  public static j a(Date paramDate)
  {
    return b("activation date", paramDate, new Class[] { com.viber.voip.analytics.b.a.class });
  }

  public static j a(boolean paramBoolean)
  {
    return b("vo user", Boolean.valueOf(paramBoolean), new Class[] { com.viber.voip.analytics.b.a.class });
  }

  public static j a(String[] paramArrayOfString)
  {
    return a("community member", paramArrayOfString, new Class[] { com.viber.voip.analytics.b.a.class }).a(new d("community_member_role", "", TextUtils.join(",", paramArrayOfString)));
  }

  @NotNull
  private static List<j> a(Map<String, Object> paramMap, a parama, Class[] paramArrayOfClass)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramMap.get(str);
      localArrayList.add(a(parama.a(str, localObject), str, localObject, paramArrayOfClass));
    }
    return localArrayList;
  }

  public static List<j> a(Map<String, Object> paramMap, Class[] paramArrayOfClass)
  {
    return a(paramMap, h.a, paramArrayOfClass);
  }

  public static j b(Boolean paramBoolean)
  {
    return b("sent instant video message", paramBoolean, new Class[] { com.viber.voip.analytics.b.a.class });
  }

  public static j b(String paramString)
  {
    return b("address book top 5 countries", paramString.split(",", -1), new Class[] { com.viber.voip.analytics.b.a.class });
  }

  private static j b(String paramString, Object paramObject, Class[] paramArrayOfClass)
  {
    return a(new e(e.a.a, paramString, ""), paramString, paramObject, paramArrayOfClass);
  }

  public static j b(Date paramDate)
  {
    return b("reinstall activation date", paramDate, new Class[] { com.viber.voip.analytics.b.a.class });
  }

  public static j b(boolean paramBoolean)
  {
    return b("desktop user?", Boolean.valueOf(paramBoolean), new Class[] { com.viber.voip.analytics.b.a.class });
  }

  public static j b(String[] paramArrayOfString)
  {
    return a("community admin", paramArrayOfString, new Class[] { com.viber.voip.analytics.b.a.class }).a(new d("community_admin_role", "", TextUtils.join(",", paramArrayOfString)));
  }

  public static List<j> b(Map<String, Object> paramMap, Class[] paramArrayOfClass)
  {
    return a(paramMap, i.a, paramArrayOfClass);
  }

  public static j c(Boolean paramBoolean)
  {
    return b("sent instant voice message", paramBoolean, new Class[] { com.viber.voip.analytics.b.a.class });
  }

  public static j c(String paramString)
  {
    f.a locala = new b.a().a("key_property_name", "free stickers ids").a();
    return new j().a(com.viber.voip.analytics.b.a.class, locala).a("key_property_name", paramString.split(",", -1)).a(new b(paramString, "free stickers ids", ""));
  }

  public static j c(String[] paramArrayOfString)
  {
    return a("community superadmin", paramArrayOfString, new Class[] { com.viber.voip.analytics.b.a.class }).a(new d("community_super_admin_role", "", TextUtils.join(",", paramArrayOfString)));
  }

  public static j d(Boolean paramBoolean)
  {
    return b("used chat extension", paramBoolean, new Class[] { com.viber.voip.analytics.b.a.class });
  }

  public static j d(String paramString)
  {
    f.a locala = new b.a().a("key_property_name", "paid stickers ids").a();
    return new j().a(com.viber.voip.analytics.b.a.class, locala).a("key_property_name", paramString.split(",", -1)).a(new b(paramString, "paid stickers ids", ""));
  }

  public static j d(String[] paramArrayOfString)
  {
    return a("keyboard language", paramArrayOfString, new Class[] { com.viber.voip.analytics.b.a.class }).a(new d("keyboard language", "", Arrays.toString(paramArrayOfString)));
  }

  public static j e(Boolean paramBoolean)
  {
    return b("used secret chat", paramBoolean, new Class[] { com.viber.voip.analytics.b.a.class });
  }

  public static j e(String paramString)
  {
    return b("mcc", paramString, new Class[] { com.viber.voip.analytics.b.a.class });
  }

  public static j f(Boolean paramBoolean)
  {
    return a("allow content personalization", paramBoolean, new Class[] { com.viber.voip.analytics.b.a.class }).a(new f(paramBoolean.toString(), "allow content personalization", ""));
  }

  public static j f(String paramString)
  {
    return b("mnc", paramString, new Class[] { com.viber.voip.analytics.b.a.class });
  }

  public static j g(String paramString)
  {
    return a(new f(paramString, "home country", ""), "home country", paramString, new Class[] { com.viber.voip.analytics.b.a.class });
  }

  public static j h(String paramString)
  {
    j localj = a("international calling destinations", paramString.split(",", -1), new Class[] { com.viber.voip.analytics.b.a.class });
    localj.a(new b(paramString, "international calling destinations", ""));
    return localj;
  }

  public static j i(String paramString)
  {
    j localj = a("international sending destination", paramString.split(",", -1), new Class[] { com.viber.voip.analytics.b.a.class });
    localj.a(new b(paramString, "international sending destination", ""));
    return localj;
  }

  public static j j(String paramString)
  {
    String str;
    if (paramString == null)
      str = "";
    while (true)
    {
      return a("user first name", str, new Class[] { com.viber.voip.analytics.b.a.class }).a(new f(str, "user first name", ""));
      String[] arrayOfString = paramString.split("\\b[\\s-.]", 2);
      if (arrayOfString.length > 0)
        str = arrayOfString[0];
      else
        str = "";
    }
  }

  private static abstract interface a
  {
    public abstract com.viber.voip.analytics.story.k.a a(String paramString, Object paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.g
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.analytics.story.l;

import com.viber.voip.analytics.story.b;
import com.viber.voip.analytics.story.b.a;
import com.viber.voip.analytics.story.f.a;
import com.viber.voip.analytics.story.k.e.a;
import com.viber.voip.registration.ao;

public class a
{
  public static com.viber.voip.analytics.story.e a()
  {
    f.a locala = b.a(new String[0]).a();
    return new com.viber.voip.analytics.story.e("create group chat").a(com.viber.voip.analytics.b.a.class, locala);
  }

  public static com.viber.voip.analytics.story.e a(String paramString)
  {
    f.a locala = b.a(new String[0]).a(new String[] { "id" }).a();
    return new com.viber.voip.analytics.story.e("fm click").a("id", paramString).a(new com.viber.voip.analytics.story.k.e(e.a.a, "fm click", paramString)).a(com.viber.voip.analytics.b.a.class, locala);
  }

  public static com.viber.voip.analytics.story.e a(String paramString1, String paramString2)
  {
    f.a locala = b.a(new String[] { "community name", "community ID" }).a();
    return new com.viber.voip.analytics.story.e("sent community message").a("community name", paramString1).a("community ID", paramString2).a(com.viber.voip.analytics.b.a.class, locala);
  }

  public static com.viber.voip.analytics.story.e a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "community name";
    arrayOfString[bool] = "role";
    arrayOfString[2] = "community ID";
    f.a locala = b.a(arrayOfString).a();
    if (!ao.f());
    while (true)
    {
      return new com.viber.voip.analytics.story.e(bool, "joined community").a("community name", paramString1).a("role", paramString2).a("community ID", paramString3).a(com.viber.voip.analytics.b.a.class, locala);
      bool = false;
    }
  }

  public static com.viber.voip.analytics.story.e b()
  {
    f.a locala = b.a(new String[0]).a();
    return new com.viber.voip.analytics.story.e("sent message").a(com.viber.voip.analytics.b.a.class, locala);
  }

  public static com.viber.voip.analytics.story.e b(String paramString)
  {
    f.a locala = b.a(new String[0]).a(new String[] { "id" }).a();
    return new com.viber.voip.analytics.story.e("fm impression").a("id", paramString).a(new com.viber.voip.analytics.story.k.e(e.a.a, "fm impression", paramString)).a(com.viber.voip.analytics.b.a.class, locala);
  }

  public static com.viber.voip.analytics.story.e b(String paramString1, String paramString2)
  {
    f.a locala = b.a(new String[] { "community name", "community ID" }).a();
    return new com.viber.voip.analytics.story.e("viewed community").a("community name", paramString1).a("community ID", paramString2).a(com.viber.voip.analytics.b.a.class, locala);
  }

  public static com.viber.voip.analytics.story.e c()
  {
    f.a locala = b.a(new String[0]).a();
    return new com.viber.voip.analytics.story.e("sent group message").a(com.viber.voip.analytics.b.a.class, locala);
  }

  public static com.viber.voip.analytics.story.e c(String paramString)
  {
    f.a locala = b.a(new String[] { "pa_id" }).a();
    return new com.viber.voip.analytics.story.e("sent message to bot").a("pa_id", paramString).a(com.viber.voip.analytics.b.a.class, locala);
  }

  public static com.viber.voip.analytics.story.e c(String paramString1, String paramString2)
  {
    f.a locala = b.a(new String[] { "community name", "community ID" }).a();
    return new com.viber.voip.analytics.story.e("created community").a("community name", paramString1).a("community ID", paramString2).a(com.viber.voip.analytics.b.a.class, locala);
  }

  public static com.viber.voip.analytics.story.e d()
  {
    f.a locala = b.a(new String[0]).a();
    return new com.viber.voip.analytics.story.e("sent sticker").a(com.viber.voip.analytics.b.a.class, locala);
  }

  public static com.viber.voip.analytics.story.e e()
  {
    f.a locala = b.a(new String[0]).a();
    return new com.viber.voip.analytics.story.e("sent group sticker").a(com.viber.voip.analytics.b.a.class, locala);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.l.a
 * JD-Core Version:    0.6.2
 */
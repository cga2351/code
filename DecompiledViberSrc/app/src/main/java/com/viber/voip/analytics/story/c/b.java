package com.viber.voip.analytics.story.c;

import com.viber.voip.analytics.story.b.a;
import com.viber.voip.analytics.story.e;
import com.viber.voip.analytics.story.f.a;

class b
{
  static e a(String paramString, long paramLong)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Button Clicked", "Duration" }).a();
    return new e("Close Chat Extension").a("Button Clicked", paramString).a("Duration", Long.valueOf(paramLong)).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(String paramString1, String paramString2)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Entry Point", "Chat Type" }).a();
    return new e("Open Chat Extension").a("Entry Point", paramString1).a("Chat Type", paramString2).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e b(String paramString1, String paramString2)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Origin", "Extension" }).a();
    return new e("Search Chat Extension").a("Origin", paramString1).a("Extension", paramString2).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e c(String paramString1, String paramString2)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "From Extension", "To Extension" }).a();
    e locale = new e("View Extension");
    if (paramString1 != null);
    while (true)
    {
      return locale.a("From Extension", paramString1).a("To Extension", paramString2).a(com.viber.voip.analytics.e.b.class, locala);
      paramString1 = "";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.c.b
 * JD-Core Version:    0.6.2
 */
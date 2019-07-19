package com.viber.voip.analytics.story.l;

import com.viber.voip.analytics.b.a;
import com.viber.voip.analytics.story.b;
import com.viber.voip.analytics.story.b.a;
import com.viber.voip.analytics.story.e;
import com.viber.voip.analytics.story.e.a;
import com.viber.voip.analytics.story.f.a;

public class f
{
  public static e a()
  {
    f.a locala = b.a(new String[0]).a();
    return new e("sticker market visit").a(a.class, locala);
  }

  public static e a(int paramInt)
  {
    f.a locala = b.a(new String[] { "pack id" }).a();
    return new e("free sticker download").a("pack id", Integer.valueOf(paramInt)).a(a.class, locala);
  }

  public static e a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    f.a locala = b.b(new String[] { "pack id", paramString3 }).a("key_property_price", g.a).a();
    return e.a.a("sticker purchase", paramString2, paramString1, 1).a("pack id", Integer.valueOf(paramInt)).a("name", paramString3).a(a.class, locala);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.l.f
 * JD-Core Version:    0.6.2
 */
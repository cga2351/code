package com.viber.voip.analytics.story.l;

import com.viber.voip.analytics.b.a;
import com.viber.voip.analytics.story.b;
import com.viber.voip.analytics.story.b.a;
import com.viber.voip.analytics.story.e;
import com.viber.voip.analytics.story.e.a;
import com.viber.voip.analytics.story.f.a;
import com.viber.voip.analytics.story.f.a.a;

@Deprecated
public class h
{
  public static e a()
  {
    f.a locala = b.a(new String[0]).a();
    return new e("redeem coupon page visit").a(a.class, locala);
  }

  public static e a(String paramString, long paramLong)
  {
    f.a locala = b.a(new String[0]).a(new String[] { "successful" }).a(new String[] { "destination" }).a(new String[] { "duration" }).a();
    return new e("vo call").a("successful", Boolean.valueOf(true)).a("destination", paramString).a("duration", Long.valueOf(paramLong)).a(a.class, locala);
  }

  public static e a(String paramString1, String paramString2, String paramString3)
  {
    f.a.a locala = i.a;
    f.a locala1 = b.b(new String[] { "name" }).a("key_property_price", locala).a();
    return e.a.a("VLN purchase", paramString2, paramString1, 1).a("name", paramString3).a(a.class, locala1);
  }

  public static e b()
  {
    f.a locala = b.a(new String[0]).a();
    return new e("click vo call button at a specific contact page").a(a.class, locala);
  }

  public static e c()
  {
    f.a locala = b.a(new String[0]).a();
    return new e("try vo click").a(a.class, locala);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.l.h
 * JD-Core Version:    0.6.2
 */
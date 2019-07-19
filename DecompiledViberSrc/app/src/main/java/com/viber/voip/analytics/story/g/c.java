package com.viber.voip.analytics.story.g;

import android.support.v4.util.ArrayMap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.p;
import com.viber.voip.analytics.story.StoryConstants.ab.a;
import com.viber.voip.analytics.story.StoryConstants.b.a;
import com.viber.voip.analytics.story.StoryConstants.l.a;
import com.viber.voip.messages.orm.entity.json.Language;
import com.viber.voip.ui.j.ax;
import com.viber.voip.util.da;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class c
  implements a
{
  private static final Logger a = ViberEnv.getLogger();
  private final g b;

  public c(g paramg)
  {
    this.b = paramg;
  }

  public void a()
  {
    this.b.a(e.c());
  }

  public void a(int paramInt)
  {
    String str = StoryConstants.l.a.a(paramInt);
    this.b.a(e.i(str));
  }

  public void a(long paramLong)
  {
    com.viber.voip.analytics.story.e locale = e.a(paramLong);
    Iterator localIterator = locale.c().iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      ((p)this.b.a(localClass)).a(locale);
    }
  }

  public void a(Language paramLanguage1, Language paramLanguage2)
  {
    this.b.a(e.b(paramLanguage1.getLanguage(), paramLanguage2.getLanguage()));
    this.b.a(d.a(paramLanguage1.getCode(), paramLanguage2.getCode()));
  }

  public void a(ax paramax)
  {
    String str1 = StoryConstants.ab.a.a(paramax);
    String str2 = StoryConstants.b.a.a(paramax);
    this.b.a(e.j(str1));
    this.b.a(d.h(str2));
  }

  public void a(String paramString)
  {
    boolean bool = "Deactivate account".equals(paramString);
    if ("Deactivate account canceled".equals(paramString))
      paramString = "Deactivate account";
    this.b.a(e.c(paramString));
    this.b.a(d.a(bool));
  }

  public void a(String paramString, int paramInt)
  {
    this.b.a(e.a(paramString, paramInt, true));
  }

  public void a(String paramString1, int paramInt, long paramLong, String paramString2, boolean paramBoolean, String paramString3, String paramString4)
  {
    this.b.a(e.a(paramInt, String.valueOf(paramLong), paramString2, paramBoolean, da.h(paramString3), da.h(paramString4)));
    this.b.a(d.a(paramString1));
  }

  public void a(String paramString1, long paramLong, String paramString2)
  {
    this.b.a(e.a(paramString1, paramLong, paramString2));
  }

  public void a(String paramString1, long paramLong, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.b.a(e.a(paramString1, paramLong, paramString2, paramString3, paramBoolean));
  }

  public void a(String paramString1, String paramString2)
  {
    this.b.a(e.a(paramString1, paramString2));
  }

  public void a(String paramString1, String paramString2, double paramDouble)
  {
    this.b.a(e.a(paramString2));
    this.b.a(d.a(paramString1, paramDouble));
  }

  public void a(String paramString1, String paramString2, Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    this.b.a(e.a(paramString1, paramString2, paramObject1, paramObject2));
    ArrayMap localArrayMap = d.b(paramBoolean);
    com.viber.voip.analytics.story.c.a(localArrayMap);
    this.b.a(localArrayMap);
  }

  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.b.a(e.c(paramString1, paramString3));
    this.b.a(e.e());
    this.b.a(d.i(paramString2));
  }

  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b.a(e.a(paramString1, paramString2, paramString3));
    this.b.a(d.f(paramString4));
  }

  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    this.b.a(f.a(paramString2));
    this.b.a(f.b(paramString3));
    this.b.a(e.b(paramString1, paramString2, paramString4));
    this.b.a(d.a(paramString2, paramBoolean));
  }

  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.b.a(f.a(paramString1));
    this.b.a(f.b(paramString2));
    this.b.a(d.a(paramString1, paramBoolean));
  }

  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    this.b.a(e.a(paramString2, paramBoolean, da.h(paramString3)));
    this.b.a(d.b(paramString1));
  }

  public void a(String paramString, boolean paramBoolean)
  {
    this.b.a(e.b(paramString));
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 561774310:
    case 2741:
    case -1654664828:
    }
    while (true)
      switch (i)
      {
      default:
        return;
        if (paramString.equals("Facebook"))
        {
          i = 0;
          continue;
          if (paramString.equals("VK"))
          {
            i = 1;
            continue;
            if (paramString.equals("Rakuten"))
              i = 2;
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      }
    this.b.a(d.c(paramBoolean));
    return;
    this.b.a(d.d(paramBoolean));
    return;
    this.b.a(d.e(paramBoolean));
  }

  public void a(boolean paramBoolean)
  {
    this.b.a(e.a(paramBoolean));
  }

  public void b()
  {
    this.b.a(e.d());
  }

  public void b(long paramLong)
  {
    long l = TimeUnit.MILLISECONDS.toSeconds(paramLong);
    this.b.a(e.b(l));
    this.b.a(d.a(l));
  }

  public void b(String paramString)
  {
    this.b.a(e.d(paramString));
  }

  public void b(String paramString, int paramInt)
  {
    this.b.a(e.b(paramString, paramInt, true));
  }

  public void b(String paramString1, String paramString2)
  {
    this.b.a(e.f(paramString1));
    this.b.a(d.g(paramString2));
  }

  public void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b.a(e.c(paramString1, paramString2, paramString3));
    this.b.a(e.f());
    this.b.a(d.j(paramString4));
  }

  public void c(String paramString)
  {
    this.b.a("change_phone_number_entry_point", paramString);
  }

  public void d(String paramString)
  {
    String str = (String)this.b.b("change_phone_number_entry_point");
    if (da.a(str))
      return;
    this.b.a(e.e(str));
    this.b.a(d.c(paramString));
  }

  public void e(String paramString)
  {
    this.b.a(e.a());
    this.b.a(d.d(paramString));
  }

  public void f(String paramString)
  {
    this.b.a(e.b());
    this.b.a(d.e(paramString));
  }

  public void g(String paramString)
  {
    this.b.a(e.g(paramString));
  }

  public void h(String paramString)
  {
    this.b.a(e.h(paramString));
  }

  public void i(String paramString)
  {
    this.b.a(e.k(paramString));
  }

  public void j(String paramString)
  {
    this.b.a(f.c(paramString));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.g.c
 * JD-Core Version:    0.6.2
 */
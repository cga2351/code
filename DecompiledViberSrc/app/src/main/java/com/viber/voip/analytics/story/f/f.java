package com.viber.voip.analytics.story.f;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.CircularArray;
import com.adjust.sdk.Adjust;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.StoryConstants.a.a;
import com.viber.voip.analytics.story.StoryConstants.b.a;
import com.viber.voip.analytics.story.StoryConstants.g.a;
import com.viber.voip.analytics.story.StoryConstants.i.a;
import com.viber.voip.analytics.story.StoryConstants.x.a;
import com.viber.voip.analytics.story.j;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.registration.ActivationController.b;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.bc;
import com.viber.voip.ui.j.ax;
import com.viber.voip.util.ae;
import com.viber.voip.util.da;
import java.util.Locale;

public class f
  implements d
{
  private static final Logger a = ViberEnv.getLogger();
  private final g b;

  public f(g paramg)
  {
    this.b = paramg;
  }

  public void a()
  {
    this.b.a(b.c());
  }

  public void a(long paramLong)
  {
    this.b.a(b.a((int)(paramLong / 1000L)));
  }

  public void a(com.viber.voip.analytics.story.a parama, boolean paramBoolean)
  {
    String str1 = da.h(parama.a());
    String str2 = da.h(parama.b());
    String str3 = da.h(parama.c());
    String str4 = da.h(parama.d());
    CircularArray localCircularArray = new CircularArray(4);
    localCircularArray.addLast(c.a("Adjust Network", str1));
    localCircularArray.addLast(c.a("Adjust Campaign", str2));
    localCircularArray.addLast(c.a("Adjust Adgroup", str3));
    localCircularArray.addLast(c.a("Adjust Creative", str4));
    int i = localCircularArray.size();
    for (int j = 0; j < i; j++)
    {
      j localj = (j)localCircularArray.get(j);
      if (paramBoolean)
      {
        com.viber.voip.analytics.story.k.a locala = localj.d();
        if (locala != null)
          locala.c();
      }
      this.b.a(localj);
    }
  }

  public void a(aa paramaa, String paramString, boolean paramBoolean)
  {
    String str1 = StoryConstants.g.a.a(paramaa, paramBoolean);
    String str2 = StoryConstants.i.a.a(paramaa);
    if (paramaa.bD());
    for (String str3 = "Replied"; ; str3 = "New")
    {
      this.b.a(b.a(str1, str2, str3));
      this.b.a(a.b(paramString));
      return;
    }
  }

  public void a(ActivationController.b paramb)
  {
    String str = StoryConstants.a.a.a(paramb);
    this.b.a(b.b(str));
    this.b.a(a.a(str));
  }

  public void a(String paramString)
  {
    this.b.a(b.a(paramString));
  }

  public void a(String paramString1, String paramString2)
  {
    this.b.a(b.a(paramString1, paramString2));
  }

  public void a(boolean paramBoolean)
  {
    this.b.a(b.a(paramBoolean));
  }

  public void a(boolean paramBoolean, String paramString)
  {
    this.b.a(b.a(paramBoolean, paramString));
  }

  public void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    String str1 = (String)this.b.b("open_app_origin_entry_point");
    Boolean localBoolean = (Boolean)this.b.a("is_user_registered");
    boolean bool1;
    boolean bool2;
    label49: String str2;
    if (localBoolean != null)
    {
      bool1 = localBoolean.booleanValue();
      if (ao.f())
        break label68;
      bool2 = true;
      str2 = StoryConstants.x.a.a(bool2);
      if (str1 != null)
        break label74;
    }
    label68: label74: 
    while (!paramBoolean1)
    {
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label49;
    }
    this.b.a(b.a(str1, paramString2, paramBoolean2));
    String str3 = ae.b();
    com.viber.voip.model.a.d locald1 = com.viber.voip.model.a.b.c();
    Integer localInteger = locald1.f("app_opened_before_registration_key");
    if (localInteger == null);
    for (int i = 0; ; i = localInteger.intValue())
    {
      if (!bool1)
      {
        com.viber.voip.model.a.d locald2 = com.viber.voip.model.a.b.c();
        i++;
        locald2.a("app_opened_before_registration_key", i);
      }
      String str4 = locald1.e("first_app_opened_key");
      if (str4 == null)
      {
        com.viber.voip.model.a.b.c().f("first_app_opened_key", str3);
        str4 = str3;
      }
      String str5 = StoryConstants.b.a.a(ax.a(d.bc.a.d()));
      this.b.a(a.a(str3, bool1, str2, paramString1, bool2, i, str4, str5));
      return;
    }
  }

  public void a(boolean paramBoolean, String paramString, Locale paramLocale)
  {
    String str1 = Adjust.getAdid();
    if (!ao.f());
    for (boolean bool = true; ; bool = false)
    {
      String str2 = paramLocale.getLanguage();
      String str3 = ae.b();
      String str4 = StoryConstants.x.a.a(bool);
      ArrayMap localArrayMap = a.a(paramBoolean, str2, str3, paramString, str1, bool);
      com.viber.voip.analytics.story.c.a(localArrayMap);
      this.b.a(localArrayMap);
      int i = (int)(System.currentTimeMillis() - this.b.i()) / 1000;
      this.b.a(b.a(str4, i));
      this.b.a("is_user_registered", Boolean.valueOf(true));
      return;
    }
  }

  public void b()
  {
    this.b.a(b.a());
  }

  public void b(String paramString)
  {
    this.b.a(b.c(paramString));
  }

  public void b(boolean paramBoolean)
  {
    this.b.a(c.a(paramBoolean));
    this.b.a(a.a(paramBoolean));
  }

  public void c()
  {
    this.b.a(b.b());
  }

  public void c(String paramString)
  {
    this.b.a(b.d(paramString));
  }

  public void c(boolean paramBoolean)
  {
    this.b.a("is_user_registered", Boolean.valueOf(paramBoolean));
  }

  public void d()
  {
    com.viber.voip.model.a.b.c().b("desktop_system_key", true);
  }

  public void d(String paramString)
  {
    this.b.a("open_app_origin_entry_point", paramString);
  }

  public void e(String paramString)
  {
    com.viber.voip.model.a.d locald = com.viber.voip.model.a.b.c();
    Boolean localBoolean = locald.h("desktop_system_key");
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      locald.i("desktop_system_key");
      this.b.a(b.e(da.h(paramString)));
    }
  }

  public void f(String paramString)
  {
    this.b.a(b.f(paramString));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.f.f
 * JD-Core Version:    0.6.2
 */
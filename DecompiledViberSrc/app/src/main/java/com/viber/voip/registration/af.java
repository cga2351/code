package com.viber.voip.registration;

import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.jni.CountryNameInfo;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.memberid.d;
import com.viber.voip.settings.b.c;
import com.viber.voip.settings.b.e.a;
import com.viber.voip.settings.b.e.a.a;
import com.viber.voip.settings.b.f;
import com.viber.voip.settings.d.bf;
import java.util.Iterator;
import java.util.List;

public class af
{
  private static final Logger a = ViberEnv.getLogger();
  private String b = null;
  private String c = null;
  private int d = -1;
  private String e = null;
  private String f = null;
  private String g = null;
  private String h = null;
  private String i = null;
  private String j = null;
  private String k = null;
  private String l = null;
  private String m = null;
  private String n = null;
  private final ao o = new ao();

  public static String a(String paramString1, String paramString2)
  {
    CountryNameInfo localCountryNameInfo = ViberApplication.getInstance().getEngine(true).getPhoneController().getCountryName("+" + paramString1);
    if ((localCountryNameInfo != null) && (localCountryNameInfo.countryShortName != null))
      return localCountryNameInfo.countryShortName;
    return f(paramString2);
  }

  private static String f(String paramString)
  {
    if (paramString == null)
      return null;
    Iterator localIterator = ViberApplication.getInstance().getCountryCodeManager().b().iterator();
    while (localIterator.hasNext())
    {
      CountryCode localCountryCode = (CountryCode)localIterator.next();
      if (paramString.equals(localCountryCode.getIddCode()))
        return localCountryCode.getCode();
    }
    return null;
  }

  public ao a()
  {
    return this.o;
  }

  public void a(String paramString)
  {
    if (!paramString.equals(this.i))
    {
      this.i = paramString;
      e.a.h.a(this.i);
    }
  }

  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.c = paramString1;
    this.e = paramString2;
    this.f = paramString4;
    this.d = -1;
    e.a.b.a(paramString1);
    e.a.c.a(paramString2);
    e.a.d.a(1);
    e.a.e.a(paramString4);
    e.a.a.a(paramString3);
  }

  public String b()
  {
    if (this.c == null)
      this.c = e.a.b.d();
    return this.c;
  }

  public void b(String paramString)
  {
    if (!paramString.equals(this.k))
    {
      this.k = paramString;
      e.a.g.a(this.k);
    }
  }

  public String c()
  {
    if (this.b == null)
      this.b = e.a.a.d();
    return this.b;
  }

  public void c(String paramString)
  {
    if (!paramString.equals(this.m))
    {
      this.m = paramString;
      d.bf.a.a(paramString);
    }
  }

  public int d()
  {
    if (this.d <= 0)
      this.d = Integer.parseInt(b());
    return this.d;
  }

  public void d(String paramString)
  {
    if (!paramString.equals(this.l))
    {
      this.l = paramString;
      e.a.j.a(this.l);
    }
  }

  public String e()
  {
    if (this.e == null)
    {
      this.e = e.a.c.d();
      int i1 = e.a.d.d();
      if ((this.e.equals("")) || (i1 != 1))
      {
        this.e = a(g(), b());
        if (this.e == null)
          this.e = "";
        e.a.c.a(this.e);
        e.a.d.a(1);
      }
    }
    return this.e;
  }

  public void e(String paramString)
  {
    this.g = paramString;
    this.h = ("+" + paramString);
    e.a.f.a(paramString);
  }

  public String f()
  {
    if (this.f == null)
      this.f = e.a.e.d();
    return this.f;
  }

  public String g()
  {
    if (this.g == null)
      this.g = e.a.f.d();
    return this.g;
  }

  public String h()
  {
    String str1;
    if (this.h == null)
    {
      str1 = g();
      if (str1 == null)
        break label46;
    }
    label46: for (String str2 = "+" + str1; ; str2 = null)
    {
      this.h = str2;
      return this.h;
    }
  }

  public String i()
  {
    String str = g();
    if ((str != null) && (str.length() > 6))
      return str.substring(0, 6);
    return "";
  }

  public String j()
  {
    if (this.k == null)
      this.k = e.a.g.d();
    return this.k;
  }

  public String k()
  {
    if (this.m == null)
      this.m = d.bf.a.d();
    return this.m;
  }

  public String l()
  {
    if (!d.c())
      return h();
    if (this.i == null)
      this.i = e.a.h.d();
    return this.i;
  }

  public String m()
  {
    if (this.j == null)
      this.j = e.a.i.d();
    return this.j;
  }

  public String n()
  {
    if (this.l == null)
      this.l = e.a.j.d();
    return this.l;
  }

  public void o()
  {
    this.c = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.d = -1;
    e.a.b.b();
    e.a.e.b();
    e.a.f.b();
    e.a.a.b();
  }

  public boolean p()
  {
    return 81 == d();
  }

  public boolean q()
  {
    return 1 == d();
  }

  public boolean r()
  {
    return (p()) || (86 == d()) || (850 == d());
  }

  public boolean s()
  {
    return 7 == d();
  }

  public String t()
  {
    if (!d.c())
      return "";
    if (this.i == null)
      this.i = e.a.h.d();
    if ((this.i != null) && (d.a(this.i)))
    {
      if (this.n == null)
        if (!ao.f())
          break label73;
      label73: for (String str = e.a.a.c.d(); ; str = e.a.l.d())
      {
        this.n = str;
        return this.n;
      }
    }
    return this.i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.af
 * JD-Core Version:    0.6.2
 */
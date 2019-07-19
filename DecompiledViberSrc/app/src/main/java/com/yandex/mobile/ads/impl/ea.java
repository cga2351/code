package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.text.TextUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public final class ea
  implements eh
{
  private final dy a;
  private final ds b;
  private final ee c;
  private final ec d;
  private em e;
  private final ef f;
  private final eg g;
  private final String h;
  private final gb i;
  private ed j;
  private gp k;
  private dr l;
  private dk m;
  private ei n;

  public ea(ds paramds)
  {
    this.b = paramds;
    this.c = new ee(new a((byte)0));
    this.b.setWebViewClient(this.c);
    this.a = new dy(this.b);
    this.d = new ec();
    this.i = new gb();
    this.e = em.b;
    this.f = new ef();
    this.g = new eg(paramds, this.f, this);
    this.h = cw.a(this);
  }

  private void a(em paramem)
  {
    this.e = paramem;
    dy localdy = this.a;
    ek[] arrayOfek = new ek[1];
    arrayOfek[0] = this.e;
    localdy.a(arrayOfek);
  }

  private void b(ei paramei)
  {
    if (!paramei.equals(this.n))
    {
      this.n = paramei;
      ej localej = c(paramei);
      this.a.a(new ek[] { localej });
    }
  }

  private static ej c(ei paramei)
  {
    return new ej(paramei.a(), paramei.b());
  }

  public final void a()
  {
    el localel = new el(this.b);
    en localen = new en(gb.a(this.b));
    ej localej = c(ef.a(this.b));
    this.e = em.a;
    dy localdy = this.a;
    ek[] arrayOfek = new ek[4];
    arrayOfek[0] = this.e;
    arrayOfek[1] = localen;
    arrayOfek[2] = localej;
    arrayOfek[3] = localel;
    localdy.a(arrayOfek);
    this.a.a();
    if (this.j != null)
      this.j.a();
  }

  public final void a(dk paramdk)
  {
    this.m = paramdk;
  }

  public final void a(dr paramdr)
  {
    this.l = paramdr;
  }

  public final void a(ed paramed)
  {
    this.j = paramed;
  }

  public final void a(ei paramei)
  {
    b(paramei);
  }

  public final void a(gp paramgp)
  {
    this.k = paramgp;
  }

  public final void a(final String paramString)
  {
    Context localContext = this.b.getContext();
    ec localec = this.d;
    String str = this.h;
    ec.a local1 = new ec.a()
    {
      public final void a(String paramAnonymousString)
      {
        ea.a(ea.this).a(paramAnonymousString);
        ea.b(ea.this).a(paramString);
      }
    };
    et localet = es.a().a(localContext);
    if ((localet == null) || (TextUtils.isEmpty(localet.e())))
    {
      local1.a(ec.a);
      return;
    }
    pg localpg = new pg(localet.e(), new ec.1(localec, local1), new ec.2(localec, local1));
    localpg.a(str);
    af.a().a(localContext, localpg);
  }

  public final void a(boolean paramBoolean)
  {
    en localen = new en(paramBoolean);
    this.a.a(new ek[] { localen });
    if (paramBoolean)
    {
      this.g.a();
      return;
    }
    this.g.b();
    b(ef.a(this.b));
  }

  public final void b()
  {
    if (em.a == this.e)
      a(em.c);
  }

  public final void b(String paramString)
  {
    String str2;
    HashMap localHashMap;
    try
    {
      URI localURI = new URI(paramString);
      String str1 = localURI.getScheme();
      str2 = localURI.getHost();
      if (("mraid".equals(str1)) || ("mobileads".equals(str1)))
      {
        localHashMap = new HashMap();
        Iterator localIterator = URLEncodedUtils.parse(localURI, "UTF-8").iterator();
        while (localIterator.hasNext())
        {
          NameValuePair localNameValuePair = (NameValuePair)localIterator.next();
          localHashMap.put(localNameValuePair.getName(), localNameValuePair.getValue());
        }
      }
    }
    catch (URISyntaxException localURISyntaxException)
    {
      this.a.a(eb.f, "Mraid command sent an invalid URL");
    }
    return;
    eb localeb = eb.a(str2);
    try
    {
      if (this.j == null)
        throw new dz("Invalid state to execute this command");
    }
    catch (dz localdz)
    {
      this.a.a(localeb, localdz.getMessage());
    }
    while (true)
    {
      this.a.a(localeb);
      return;
      switch (2.a[localeb.ordinal()])
      {
      default:
        throw new dz("Unspecified MRAID Javascript command");
      case 1:
        if (em.a == this.e)
        {
          a(em.c);
          if (this.l != null)
            this.l.h();
        }
        break;
      case 2:
        if (this.l != null)
        {
          boolean bool = Boolean.parseBoolean((String)localHashMap.get("shouldUseCustomClose"));
          this.l.a(bool);
        }
        break;
      case 3:
        if (this.j != null)
        {
          String str3 = (String)localHashMap.get("url");
          if (!TextUtils.isEmpty(str3))
          {
            this.j.a(str3);
            new Object[] { str3 };
          }
          else
          {
            throw new dz(String.format("Mraid open command sent an invalid URL: %s", new Object[] { str3 }));
          }
        }
        break;
      case 4:
        if (this.m != null)
          this.m.a();
        break;
      case 5:
        if (this.k != null)
          this.k.i();
        break;
      }
    }
  }

  public final void c()
  {
    this.g.b();
    ec.a(this.b.getContext(), this.h);
    this.j = null;
    this.k = null;
    this.l = null;
    this.m = null;
  }

  private final class a
    implements dm
  {
    private a()
    {
    }

    public final void a(Context paramContext, String paramString)
    {
      ea.c(ea.this).a(paramContext, paramString);
    }

    public final void d()
    {
      ea.c(ea.this).d();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ea
 * JD-Core Version:    0.6.2
 */
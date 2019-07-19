package com.viber.voip.registration.changephonenumber;

import android.content.Context;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.a.a;
import com.viber.voip.contacts.c.a.b;
import com.viber.voip.registration.CountryCode;
import com.viber.voip.registration.ae;
import com.viber.voip.registration.af;
import com.viber.voip.registration.aj;
import com.viber.voip.registration.ao;
import com.viber.voip.registration.ao.b;
import com.viber.voip.registration.c.d;
import com.viber.voip.registration.c.r;
import com.viber.voip.registration.s;
import com.viber.voip.settings.d.a;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cg;
import com.viber.voip.util.cj;
import com.viber.voip.util.t;
import org.greenrobot.eventbus.EventBus;

public class i
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final PhoneController c;
  private final ae d;
  private final com.viber.voip.rakuten.a e;
  private final af f;
  private final m g;
  private PhoneNumberInfo h;
  private t i;
  private t j;
  private EventBus k;

  public i(Context paramContext, PhoneController paramPhoneController, UserManager paramUserManager, ae paramae, com.viber.voip.rakuten.a parama, m paramm)
  {
    this.b = paramContext.getApplicationContext();
    this.c = paramPhoneController;
    this.d = paramae;
    this.e = parama;
    this.f = paramUserManager.getRegistrationValues();
    this.g = paramm;
    this.k = com.viber.voip.h.a.d();
  }

  private void a(String paramString1, final String paramString2, final boolean paramBoolean)
  {
    this.j = new t();
    this.d.a(paramString1, paramString2, new aj()
    {
      public void a(com.viber.voip.registration.c.b paramAnonymousb)
      {
        i.b(i.this, null);
        if (paramAnonymousb != null)
        {
          if ((!paramAnonymousb.f()) && (!"109".equals(paramAnonymousb.g())))
            break label63;
          i.this.a(paramAnonymousb);
        }
        label63: 
        while ((!"118".equals(paramAnonymousb.g())) || (!paramBoolean) || (!i.a(i.this, false)))
        {
          i.b(i.this).post(new com.viber.voip.registration.changephonenumber.a.a(paramString2, paramAnonymousb));
          return;
        }
      }
    }
    , this.j);
  }

  private void a(final String paramString, final boolean paramBoolean)
  {
    this.j = new t();
    this.d.a(paramString, new aj()
    {
      public void a(final d paramAnonymousd)
      {
        i.b(i.this, null);
        if (paramAnonymousd != null)
        {
          if ((!paramAnonymousd.f()) && (!"109".equals(paramAnonymousd.g())))
            break label100;
          i.a(i.this).disconnect();
          i.this.a(paramAnonymousd);
          i.d(i.this).a(i.c(i.this), paramAnonymousd.b());
          i.d(i.this).a(i.c(i.this), new Runnable()
          {
            public void run()
            {
              i.a(i.this).connect();
              ViberApplication.getInstance().getContactManager().b();
              i.this.a(new com.viber.voip.registration.changephonenumber.a.a(i.3.this.a, paramAnonymousd));
            }
          });
        }
        label100: 
        do
        {
          return;
          if ((!"118".equals(paramAnonymousd.g())) || (!paramBoolean))
            break;
        }
        while (i.a(i.this, true));
        i.b(i.this).post(new com.viber.voip.registration.changephonenumber.a.a(paramString, paramAnonymousd));
        return;
        i.b(i.this).post(new com.viber.voip.registration.changephonenumber.a.a(paramString, paramAnonymousd));
      }
    }
    , this.j);
  }

  private boolean a(boolean paramBoolean)
  {
    String str1 = d.a.e.d();
    String str2 = d.a.f.d();
    boolean bool1 = TextUtils.isEmpty(str1);
    boolean bool2 = false;
    if (!bool1)
    {
      boolean bool3 = TextUtils.isEmpty(str2);
      bool2 = false;
      if (!bool3)
      {
        this.h = cg.a(this.c, str1);
        if (!paramBoolean)
          break label70;
        a(str2, false);
      }
    }
    while (true)
    {
      bool2 = true;
      return bool2;
      label70: a(this.h.canonizedPhoneNumber, str2, false);
    }
  }

  private void g()
  {
    String str = d.a.e.d();
    if (!TextUtils.isEmpty(str))
      this.h = cg.a(this.c, str);
  }

  public EventBus a()
  {
    return this.k;
  }

  public void a(final CountryCode paramCountryCode, final String paramString, boolean paramBoolean)
  {
    this.i = new t();
    String str1 = this.f.a().a(ao.b.a);
    if (!TextUtils.isEmpty(str1));
    for (String str2 = "1"; ; str2 = "0")
    {
      this.d.a(paramCountryCode.getIddCode(), paramString, str1, str2, this.f.a().a(ao.b.b), s.a, paramBoolean, new aj()
      {
        public void a(r paramAnonymousr)
        {
          i.a(i.this, null);
          if (paramAnonymousr != null)
          {
            if (!paramAnonymousr.f())
              break label109;
            String str = i.a(i.this).canonizePhoneNumberForCountryCode(Integer.parseInt(paramCountryCode.getIddCode()), paramString);
            i.a(i.this, new PhoneNumberInfo(paramCountryCode, paramString, str));
            d.a.e.a(str);
          }
          while (true)
          {
            i.b(i.this).post(new com.viber.voip.registration.changephonenumber.a.b(paramCountryCode, paramString, paramAnonymousr, true));
            return;
            label109: if ("118".equals(paramAnonymousr.g()))
              i.a(i.this, true);
          }
        }
      }
      , this.i);
      return;
    }
  }

  void a(com.viber.voip.registration.c.h paramh)
  {
    this.e.k();
    this.e.a(paramh);
    this.g.a(this.h, cg.a(this.f));
  }

  void a(final com.viber.voip.registration.changephonenumber.a.a parama)
  {
    if (this.c.isConnected())
    {
      com.viber.voip.contacts.c.a.a(new a.b()
      {
        public void a(a.a paramAnonymousa)
        {
          i.b(i.this).post(parama);
        }
      });
      return;
    }
    this.k.post(parama);
  }

  public void a(String paramString)
  {
    d.a.f.a(paramString);
    a(paramString, true);
  }

  public PhoneNumberInfo b()
  {
    if (this.h == null)
      g();
    return this.h;
  }

  public void b(final CountryCode paramCountryCode, final String paramString, boolean paramBoolean)
  {
    this.i = new t();
    this.d.a(paramCountryCode.getIddCode(), paramString, paramBoolean, new aj()
    {
      public void a(com.viber.voip.registration.c.g paramAnonymousg)
      {
        i.a(i.this, null);
        if (paramAnonymousg != null)
        {
          if (!paramAnonymousg.f())
            break label120;
          String str = paramAnonymousg.c();
          if (str == null)
            str = i.a(i.this).canonizePhoneNumberForCountryCode(Integer.parseInt(paramCountryCode.getIddCode()), paramString);
          i.a(i.this, new PhoneNumberInfo(paramCountryCode, paramString, str));
          d.a.e.a(str);
        }
        while (true)
        {
          i.b(i.this).post(new com.viber.voip.registration.changephonenumber.a.b(paramCountryCode, paramString, paramAnonymousg, false));
          return;
          label120: if ("118".equals(paramAnonymousg.g()))
            i.a(i.this, false);
        }
      }
    }
    , this.i);
  }

  public void b(String paramString)
  {
    d.a.f.a(paramString);
    a(this.f.g(), paramString, true);
  }

  public boolean c()
  {
    return (cj.a(true)) && (this.i == null);
  }

  public boolean d()
  {
    return (cj.a(true)) && (this.j == null);
  }

  public boolean e()
  {
    return (cj.c(this.b)) && (this.j == null);
  }

  public boolean f()
  {
    return this.h != null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.changephonenumber.i
 * JD-Core Version:    0.6.2
 */
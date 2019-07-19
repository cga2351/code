package com.viber.voip.registration;

import android.accounts.Account;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.LocaleList;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.viber.backup.d.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.secure.SecureActivationController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.billing.ac;
import com.viber.voip.billing.ae;
import com.viber.voip.pixie.PixieControllerNativeImpl;
import com.viber.voip.registration.a.a.a;
import com.viber.voip.registration.a.a.c;
import com.viber.voip.registration.c.k;
import com.viber.voip.registration.c.l;
import com.viber.voip.registration.c.m;
import com.viber.voip.registration.c.m.a;
import com.viber.voip.registration.c.n;
import com.viber.voip.registration.c.o;
import com.viber.voip.registration.c.q;
import com.viber.voip.registration.c.q.a;
import com.viber.voip.registration.c.r;
import com.viber.voip.registration.c.t;
import com.viber.voip.registration.c.u;
import com.viber.voip.registration.c.v;
import com.viber.voip.registration.c.w;
import com.viber.voip.registration.c.x;
import com.viber.voip.registration.c.y;
import com.viber.voip.settings.d.ar;
import com.viber.voip.util.ax;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class ah
{
  private static final Logger a = ViberEnv.getLogger();
  private ViberApplication b;
  private Context c;
  private HardwareParameters d;
  private af e;
  private com.viber.voip.fcm.c f;

  public ah(ViberApplication paramViberApplication, Context paramContext, HardwareParameters paramHardwareParameters, af paramaf, com.viber.voip.fcm.c paramc)
  {
    this.b = paramViberApplication;
    this.c = paramContext;
    this.d = paramHardwareParameters;
    this.e = paramaf;
    this.f = paramc;
  }

  private static com.viber.voip.registration.a.a a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, byte paramByte, long paramLong)
  {
    if (!d.ar.a.d())
      return null;
    int i = d.ar.b.d();
    a.c localc;
    ArrayList localArrayList1;
    label88: d.a locala;
    s.a locala1;
    if (TextUtils.isEmpty(paramString3))
    {
      localc = new a.c(paramString1, paramString2, paramLong);
      localArrayList1 = new ArrayList();
      com.viber.backup.d locald = new com.viber.backup.d(paramContext, new com.google.d.f());
      locald.b();
      String str = s.a();
      Iterator localIterator = locald.c().iterator();
      if (!localIterator.hasNext())
        break label188;
      locala = (d.a)localIterator.next();
      locala1 = locala.a(str);
      if (locala1 == null)
        break label167;
    }
    label167: for (a.a locala2 = new a.a(locala.a(), locala1.d, locala1.b); ; locala2 = new a.a(locala.a(), "encrypted", "encrypted"))
    {
      localArrayList1.add(locala2);
      break label88;
      paramString2 = paramString3;
      break;
    }
    label188: ArrayList localArrayList2 = new ArrayList();
    for (Account localAccount : ax.c(paramContext))
      if (!TextUtils.isEmpty(localAccount.name))
        localArrayList2.add(localAccount.name);
    return new com.viber.voip.registration.a.a(paramInt, localc, paramByte, localArrayList1, i, localArrayList2);
  }

  private void a(ag paramag)
    throws IOException
  {
    try
    {
      ac localac = com.viber.voip.billing.g.a().b();
      paramag.a("phone_number", com.viber.voip.billing.b.b());
      paramag.a("token", localac.b);
      paramag.a("ts", Long.toString(localac.a));
      return;
    }
    catch (ae localae)
    {
      throw new IOException("invalid token", localae);
    }
  }

  private void a(ag paramag, String paramString1, String paramString2, String paramString3)
  {
    paramag.a("phone_number", paramString1);
    paramag.a("stoken", paramString2);
    paramag.a("ts", paramString3);
  }

  private Locale c()
  {
    Configuration localConfiguration = this.c.getResources().getConfiguration();
    if (com.viber.common.d.a.k())
      return localConfiguration.getLocales().get(0);
    return localConfiguration.locale;
  }

  public ag<n> a()
  {
    String str1 = ap.c().d;
    if (PixieControllerNativeImpl.getInstance().isEnabled());
    for (String str2 = str1.replace("https:", "http:"); ; str2 = str1)
      return new ag(str2, new m(new m.a(this.d.getSimCC(), this.d.getCN(), this.d.getSimMCC(), this.d.getSimMNC(), "1"), "1"), n.class);
  }

  public ag<v> a(String paramString)
  {
    u localu = new u(this.d.getUdid(), "phone", "Android", c().getLanguage(), com.viber.voip.p.d(), this.d.getSimMCC(), this.d.getSimMNC(), this.d.getMCC(), this.d.getMNC(), this.d.getImsi(), paramString);
    return new ag(ap.c().p, localu, v.class);
  }

  public ag<l> a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    String str1 = this.d.getUdid();
    String str2 = this.e.g();
    String str3 = this.e.f();
    String str4 = this.e.b();
    String str5;
    String str6;
    if (!TextUtils.isEmpty(paramString1))
    {
      str5 = paramString1;
      str6 = com.viber.voip.p.i();
      if (paramInt < 0)
        break label125;
    }
    label125: for (String str7 = String.valueOf(paramInt); ; str7 = null)
    {
      k localk = new k(str3, str4, str1, str5, str6, str7);
      ag localag = new ag(ap.c().f, localk, l.class);
      a(localag, str2, paramString2, paramString3);
      return localag;
      str5 = str1;
      break;
    }
  }

  public ag<com.viber.voip.registration.c.b> a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    com.viber.voip.registration.c.a locala = new com.viber.voip.registration.c.a(this.d.getUdid(), paramString1, com.viber.voip.p.i());
    ag localag = new ag(ap.c().r, locala, com.viber.voip.registration.c.b.class);
    a(localag, paramString2, paramString3, paramString4);
    return localag;
  }

  @SuppressLint({"WifiManagerLeak", "MissingPermission"})
  public ag<r> a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, byte paramByte, boolean paramBoolean)
  {
    String str1 = this.d.getUdid();
    String str2 = this.d.getMCC();
    String str3 = this.d.getMNC();
    String str4 = ao.c();
    if (str4 == null)
      str4 = "";
    WifiInfo localWifiInfo = ((WifiManager)this.c.getSystemService("wifi")).getConnectionInfo();
    String str5;
    if (localWifiInfo == null)
    {
      str5 = "";
      if ((!ao.f()) || (TextUtils.isEmpty(paramString3)))
        break label661;
    }
    label643: label661: for (String str6 = this.b.getEngine(true).getSecureActivationController().getHashForReRegister(com.viber.voip.util.z.b(str1), com.viber.voip.util.z.b(paramString3)); ; str6 = null)
    {
      long l = System.currentTimeMillis();
      String str25;
      label183: q.a locala;
      String str7;
      if ((paramString5.equals("1")) && (paramString3 != null) && (!TextUtils.isEmpty(paramString3)))
      {
        byte[] arrayOfByte1 = com.viber.voip.util.z.a(paramString3 + "login", "fca536d85836e112b4e4f8bc7747159acb84118b8578bd5bd3ee53ecd0");
        if (TextUtils.isEmpty(paramString4))
        {
          str25 = str1;
          byte[] arrayOfByte2 = com.viber.voip.util.z.a(str25, com.viber.voip.util.z.a(arrayOfByte1));
          if ((TextUtils.isEmpty(paramString4)) || (paramString4.equals(str1)))
            paramString4 = null;
          String str26 = String.valueOf(l);
          String str27 = com.viber.voip.util.z.a(arrayOfByte2);
          locala = new q.a(str26, str27, paramString4);
          str7 = paramString4;
        }
      }
      while (true)
      {
        com.viber.voip.registration.a.a locala1 = a(this.c.getApplicationContext(), paramInt, paramString3, str1, str7, paramByte, l);
        String str8 = null;
        if (locala1 != null)
        {
          str8 = locala1.a();
          if (TextUtils.isEmpty(str8))
            str8 = null;
        }
        String str9 = this.c.getResources().getConfiguration().locale.getLanguage();
        String str10 = this.f.b();
        String str11 = this.d.getDeviceType();
        String str12;
        label351: String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        label438: String str22;
        label449: String str23;
        if (ViberApplication.isTablet(this.c))
        {
          str12 = "tablet";
          str13 = this.d.getDeviceManufacturer();
          str14 = this.d.getSystemVersion();
          str15 = com.viber.voip.p.i();
          str16 = com.viber.voip.p.d();
          str17 = this.d.getCC();
          str18 = this.d.getSimMCC();
          str19 = this.d.getSimMNC();
          str20 = this.d.getImsi();
          if (!ao.f())
            break label625;
          str21 = "1";
          if (!ao.f())
            break label631;
          str22 = "1";
          if ((!ao.f()) || (TextUtils.isEmpty(str6)))
            break label637;
          str23 = str6;
          label467: if (!paramBoolean)
            break label643;
        }
        for (String str24 = "0"; ; str24 = "1")
        {
          q localq = new q(paramString2, str10, paramString1, str1, str11, str12, str13, str14, str15, str9, str16, str17, str2, str3, "1", str18, str19, str2, str3, str20, str21, str22, str23, str24, Settings.Secure.getString(this.c.getContentResolver(), "android_id"), str5, str4, null, paramString5, locala, str8);
          return new ag(ap.c().c, localq, r.class);
          str5 = localWifiInfo.getMacAddress();
          break;
          str25 = paramString4 + com.viber.voip.p.i() + l;
          break label183;
          str12 = "phone";
          break label351;
          label625: str21 = null;
          break label438;
          label631: str22 = null;
          break label449;
          label637: str23 = null;
          break label467;
        }
        str7 = paramString4;
        locala = null;
      }
    }
  }

  public ag<com.viber.voip.registration.c.g> a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4)
  {
    String str1 = this.e.g();
    String str2 = this.d.getMCC();
    String str3 = this.d.getMNC();
    com.viber.voip.registration.c.f localf = new com.viber.voip.registration.c.f(paramString2, this.e.f(), this.f.b(), paramString1, this.e.b(), this.e.l(), this.d.getUdid(), this.d.getDeviceType(), this.d.getDeviceManufacturer(), this.d.getSystemVersion(), com.viber.voip.p.i(), ViberApplication.getApplication().getResources().getConfiguration().locale.getLanguage(), com.viber.voip.p.d(), this.d.getCC(), this.d.getCN(), str2, str3, "1", this.d.getSimMCC(), this.d.getSimMNC(), str2, str3, this.d.getImsi(), "1", paramBoolean);
    ag localag = new ag(ap.c().q, localf, com.viber.voip.registration.c.g.class);
    a(localag, str1, paramString3, paramString4);
    return localag;
  }

  public ag<t> b()
  {
    com.viber.voip.registration.c.s locals = new com.viber.voip.registration.c.s(this.d.getUdid(), "AndroidTablet", this.e.g());
    return new ag(ap.c().o, locals, t.class);
  }

  public ag<com.viber.voip.registration.c.d> b(String paramString)
  {
    String str1 = this.d.getUdid();
    String str2 = ViberApplication.getApplication().getResources().getConfiguration().locale.getLanguage();
    if (str1 == null)
      str1 = "";
    com.viber.voip.registration.c.c localc = new com.viber.voip.registration.c.c(str1, paramString, "8", str2, com.viber.voip.p.i());
    return new ag(ap.c().b, localc, com.viber.voip.registration.c.d.class);
  }

  public ag<com.viber.voip.registration.c.p> c(String paramString)
    throws IOException
  {
    o localo = new o(this.d.getUdid(), paramString);
    ag localag = new ag(ap.c().g, localo, com.viber.voip.registration.c.p.class);
    a(localag);
    return localag;
  }

  public ag<x> d(String paramString)
    throws IOException
  {
    w localw = new w(this.d.getUdid(), paramString);
    ag localag = new ag(ap.c().i, localw, x.class);
    a(localag);
    return localag;
  }

  public ag<com.viber.voip.registration.c.z> e(String paramString)
    throws IOException
  {
    y localy = new y(this.d.getUdid(), paramString);
    ag localag = new ag(ap.c().h, localy, com.viber.voip.registration.c.z.class);
    a(localag);
    return localag;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.ah
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.registration.changephonenumber;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.calls.d.d;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.extras.a.e;
import com.viber.voip.registration.CountryCode;
import com.viber.voip.registration.ao;
import com.viber.voip.registration.ao.b;
import com.viber.voip.registration.s;
import com.viber.voip.settings.d.ac;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.az;
import com.viber.voip.settings.d.be;
import com.viber.voip.stickers.i;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.p;
import com.viber.voip.util.ae;
import com.viber.voip.util.cg;

public class m
{
  private static final Logger a = ViberEnv.getLogger();
  private final PhoneController b;
  private final com.viber.voip.registration.af c;
  private final UserData d;
  private final ak e;
  private final com.viber.voip.contacts.c.f.b.c f;
  private final com.viber.voip.backup.h g;
  private final com.viber.voip.billing.af h;
  private final com.viber.voip.viberout.a i;
  private final com.viber.voip.analytics.story.g.a j;

  public m(PhoneController paramPhoneController, UserManager paramUserManager, ak paramak, com.viber.voip.contacts.c.f.b.c paramc, com.viber.voip.backup.h paramh, com.viber.voip.billing.af paramaf, com.viber.voip.viberout.a parama, com.viber.voip.analytics.story.g.a parama1)
  {
    this.b = paramPhoneController;
    this.c = paramUserManager.getRegistrationValues();
    this.d = paramUserManager.getUserData();
    this.e = paramak;
    this.f = paramc;
    this.g = paramh;
    this.h = paramaf;
    this.i = parama;
    this.j = parama1;
  }

  private void a(PhoneNumberInfo paramPhoneNumberInfo)
  {
    this.c.a(paramPhoneNumberInfo.countryCode.getIddCode(), paramPhoneNumberInfo.countryCode.getCode(), paramPhoneNumberInfo.countryCode.getName(), paramPhoneNumberInfo.phoneNumber);
    this.c.e(paramPhoneNumberInfo.canonizedPhoneNumber);
    this.b.changePhoneNumberInfo(Integer.parseInt(paramPhoneNumberInfo.countryCode.getIddCode()), paramPhoneNumberInfo.countryCode.getCode(), paramPhoneNumberInfo.canonizedPhoneNumber);
  }

  private void b(PhoneNumberInfo paramPhoneNumberInfo)
  {
    com.viber.voip.model.entity.m localm = this.e.e();
    if (localm != null)
    {
      this.e.a(localm.getId(), paramPhoneNumberInfo.canonizedPhoneNumber);
      this.d.notifyOwnerChange();
    }
  }

  void a(Context paramContext, final Runnable paramRunnable)
  {
    ViberApplication localViberApplication = ViberApplication.getInstance();
    if (c.a.a.a.c.i())
      com.crashlytics.android.a.a("Cleanup Personal data");
    localViberApplication.getContactManager().g();
    localViberApplication.getContactManager().f().a();
    com.viber.voip.block.b.a().c();
    com.viber.voip.api.a.a().e();
    com.viber.service.contacts.sync.a.a().d();
    com.viber.voip.notif.g.a(paramContext).h();
    localViberApplication.getFacebookManager().a();
    localViberApplication.getWalletController().a();
    new com.viber.voip.banner.d(paramContext).b();
    localViberApplication.getRecentCallsManager().a(new d.d()
    {
      public void a()
      {
        ab.b().u();
        com.viber.voip.model.a.b.e();
        String str1 = ap.d();
        String str2 = d.az.b.d();
        boolean bool = d.be.c.d();
        int i = d.be.d.d();
        int j = d.ac.b.d();
        com.viber.voip.settings.d.a();
        d.az.a.a(str1);
        d.az.b.a(str2);
        d.be.d.a(i);
        d.be.c.a(bool);
        d.ac.b.a(j);
        d.ad.l.a(157);
        i.a().a(false, null);
        if (paramRunnable != null)
          paramRunnable.run();
      }
    });
  }

  public void a(Context paramContext, String paramString)
  {
    if (paramString.equals(this.c.a().e()))
      return;
    ViberApplication localViberApplication = ViberApplication.getInstance();
    this.c.a().a(paramString);
    this.c.a().a(ao.b.a, paramString);
    localViberApplication.setActivated(true);
  }

  public void a(PhoneNumberInfo paramPhoneNumberInfo1, PhoneNumberInfo paramPhoneNumberInfo2)
  {
    if (c.a.a.a.c.i())
      com.crashlytics.android.a.a("Migrate to new phone number");
    s.a(paramPhoneNumberInfo2.canonizedPhoneNumber, paramPhoneNumberInfo1.canonizedPhoneNumber);
    a(paramPhoneNumberInfo1);
    this.h.c();
    this.i.i();
    b(paramPhoneNumberInfo1);
    if (!ao.f())
    {
      if (!cg.a(paramPhoneNumberInfo1, paramPhoneNumberInfo2))
        this.f.a();
      ViberActionRunner.p.b();
      this.g.a();
      this.j.d(ae.b());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.changephonenumber.m
 * JD-Core Version:    0.6.2
 */
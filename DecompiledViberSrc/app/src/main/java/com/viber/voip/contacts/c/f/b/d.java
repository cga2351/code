package com.viber.voip.contacts.c.f.b;

import android.content.Context;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.PhoneControllerDelegateAdapter;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.service.ServiceStateDelegate;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.jni.service.ServiceStateListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.o;
import com.viber.voip.av.e;
import com.viber.voip.contacts.c.d.j;
import com.viber.voip.i.c.i;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.x;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.registration.changephonenumber.PhoneNumberInfo;
import com.viber.voip.schedule.n;
import com.viber.voip.schedule.p.a;
import com.viber.voip.settings.d.p;
import com.viber.voip.settings.d.q;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cg;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class d extends a
  implements ServiceStateDelegate, c
{
  protected boolean e;
  protected boolean f;
  protected final HardwareParameters g;
  protected final c.a h;
  protected final f i;
  protected final g j;
  protected final com.viber.voip.contacts.c.f.a k;
  protected final com.viber.voip.registration.af l;
  protected final UserData m;
  private final Logger n = ViberEnv.getLogger(getClass());
  private final PhoneController o;
  private final com.viber.voip.notif.e.m p;
  private final j q;
  private com.viber.voip.registration.changephonenumber.m r;

  protected d(Context paramContext, ViberApplication paramViberApplication, c.a parama, j paramj)
  {
    super(paramContext, paramViberApplication, av.e.c.a());
    this.p = com.viber.voip.notif.g.a(paramContext).a();
    this.h = parama;
    this.i = f.a(paramContext);
    this.q = paramj;
    this.j = new g(this.i);
    this.k = com.viber.voip.contacts.c.f.a.a(paramContext);
    UserManager localUserManager = UserManager.from(paramContext);
    this.l = localUserManager.getRegistrationValues();
    this.m = localUserManager.getUserData();
    this.g = this.b.getHardwareParameters();
    this.e = this.k.a();
    Engine localEngine = paramViberApplication.getEngine(false);
    localEngine.getDelegatesManager().getServiceStateListener().registerDelegate(new c[] { this });
    this.o = localEngine.getPhoneController();
    this.r = new com.viber.voip.registration.changephonenumber.m(this.o, localUserManager, ak.a(), this, paramViberApplication.getBackupMetadataController(), com.viber.voip.billing.g.a(), com.viber.voip.viberout.a.a(), com.viber.voip.analytics.g.a().c().c());
  }

  public void a()
  {
    try
    {
      this.d.post(new Runnable()
      {
        public void run()
        {
          d.this.i();
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected void a(int paramInt)
  {
    try
    {
      d.p.a.a(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(a.b paramb, int paramInt)
  {
  }

  public void a(a.b paramb, String[] paramArrayOfString, int paramInt)
  {
  }

  public final void a(a.d paramd)
  {
    paramd.f().size();
    g.c localc = this.j.a(paramd);
    if (localc.b())
    {
      this.h.a(localc.d, localc.c, localc.b, localc.e);
      com.viber.service.contacts.sync.a.a().b();
    }
    while (true)
    {
      if (this.e)
      {
        this.e = false;
        this.k.a(4);
      }
      return;
      if (localc.a)
        this.h.o();
    }
  }

  public void a(Member paramMember)
  {
    this.j.a(paramMember);
  }

  public void a(Member paramMember, String paramString1, String paramString2, boolean paramBoolean)
  {
    g.c localc = this.j.a(paramMember, System.currentTimeMillis());
    this.h.a(localc.d, localc.c, localc.b, localc.e);
    com.viber.voip.contacts.c.f.b.a(this.a).a(localc.f);
    Set localSet = this.q.a(paramMember);
    if (localSet.size() > 0);
    for (com.viber.voip.model.a locala = (com.viber.voip.model.a)localSet.iterator().next(); locala == null; locala = null)
      return;
    com.viber.voip.analytics.g.a();
    if (c.i.a.e())
    {
      bs localbs = new bs(this.a);
      h localh = localbs.a(0, paramMember, 0L, true);
      boolean bool = com.viber.voip.util.b.c.a();
      localbs.a(localh, bool, paramBoolean);
      if (bool)
      {
        this.p.b(locala, paramMember, paramBoolean);
        p.a.c.a(this.a, localh.getId(), n.a(localh.getId(), locala.getId()), true);
        return;
      }
    }
    this.p.a(locala, paramMember, paramBoolean);
  }

  public void a(Set<x> paramSet)
  {
    this.j.a(paramSet);
  }

  public void a(boolean paramBoolean)
  {
  }

  public int b()
  {
    return 0;
  }

  public void b(Member paramMember)
  {
    this.j.b(paramMember);
  }

  @Deprecated
  public void c()
  {
  }

  public int d()
  {
    try
    {
      int i1 = d.p.a.d();
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void e()
  {
    this.e = this.k.a();
  }

  public void f()
  {
    a(true);
    this.b.getEngine(false).registerDelegate(new b(this.d, new PhoneControllerDelegateAdapter[] { this }));
  }

  public void g()
  {
    this.b.getEngine(false).getDelegatesManager().getServiceStateListener().removeDelegate(this);
  }

  protected abstract void h();

  protected void i()
  {
    d.q.e.a(true);
    if (this.i.a(this.b) > 0)
      this.j.a();
    this.b.getParticipantManager().b();
    this.h.p();
    com.viber.voip.billing.g.a().c();
    d.q.e.a(false);
  }

  public void j()
  {
  }

  public void onRecanonize(String paramString)
  {
    try
    {
      PhoneNumberInfo localPhoneNumberInfo1 = cg.a(this.l);
      PhoneNumberInfo localPhoneNumberInfo2 = cg.a(this.o, paramString);
      this.r.a(localPhoneNumberInfo2, localPhoneNumberInfo1);
      i();
      this.c.getPhoneController().handleRecanonizeAck(localPhoneNumberInfo1.canonizedPhoneNumber);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void onServiceStateChanged(int paramInt)
  {
    try
    {
      if (paramInt == ServiceStateDelegate.ServiceState.SERVICE_CONNECTED.ordinal());
      for (boolean bool = true; ; bool = false)
      {
        this.f = bool;
        h();
        return;
      }
    }
    finally
    {
    }
  }

  public void onShareAddressBook()
  {
  }

  public void onShareAddressBookReplyOld(boolean paramBoolean, int paramInt1, int paramInt2)
  {
  }

  public final void onShouldRegister()
  {
    if (this.h != null)
      this.h.r();
  }

  public boolean onUnregisteredNumber(String paramString, int paramInt)
  {
    g.c localc = this.j.a(paramString);
    this.h.a(localc.d, localc.c, localc.b, localc.e);
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.f.b.d
 * JD-Core Version:    0.6.2
 */
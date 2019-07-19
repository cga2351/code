package com.viber.voip.invitelinks;

import android.content.Context;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.model.entity.h;

public abstract class a extends ad
{
  protected final Logger a = ViberEnv.getLogger(getClass());
  protected final bv b;
  protected final PhoneController c;
  protected final GroupController d;
  protected final CommunityFollowerData e;
  protected int f;
  protected final bv.t g = new bv.t()
  {
    public void onJoinToPublicGroup(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      if (paramAnonymousInt1 != a.this.f)
        return;
      a.this.b.b(a.this.g);
      switch (paramAnonymousInt3)
      {
      case 1:
      default:
        a.this.a(paramAnonymousInt3);
        return;
      case 0:
        a.this.c();
        return;
      case 2:
      }
      a.this.d();
    }
  };

  public a(Context paramContext, ab paramab, Handler paramHandler, bv parambv, PhoneController paramPhoneController, GroupController paramGroupController, CommunityFollowerData paramCommunityFollowerData)
  {
    super(paramContext, paramab, paramHandler, paramCommunityFollowerData.groupId, paramCommunityFollowerData.cdrViewSource);
    this.b = parambv;
    this.c = paramPhoneController;
    this.d = paramGroupController;
    this.e = paramCommunityFollowerData;
  }

  protected abstract void a(int paramInt);

  protected abstract void b(h paramh);

  protected abstract void c();

  protected void c(h paramh)
  {
    if (paramh.K())
    {
      f();
      return;
    }
    b(paramh);
  }

  protected abstract void d();

  protected void e()
  {
    f();
  }

  protected void f()
  {
    this.f = this.c.generateSequence();
    this.b.a(this.g);
    this.d.a(this.f, this.e.groupId, this.e.groupName, this.e.iconUri, this.e.tagLine, this.e.inviteToken, "", this.e.joinSource);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.a
 * JD-Core Version:    0.6.2
 */
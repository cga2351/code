package com.viber.voip.invitelinks;

import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.GroupReferralInfo;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.messages.conversation.publicaccount.a.a;
import com.viber.voip.messages.m;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.util.az;
import javax.inject.Inject;

public class q
{
  private static final Logger a = ViberEnv.getLogger();
  private final com.viber.voip.messages.controller.manager.ab b;
  private final PhoneController c;
  private final GroupController d;
  private final bv e;
  private final az f;
  private long g;

  @Inject
  public q(com.viber.voip.messages.controller.manager.ab paramab, PhoneController paramPhoneController, GroupController paramGroupController, bv parambv, az paramaz)
  {
    this.b = paramab;
    this.c = paramPhoneController;
    this.d = paramGroupController;
    this.e = parambv;
    this.f = paramaz;
  }

  private void a(GroupReferralInfo paramGroupReferralInfo, h paramh, int paramInt, a parama)
  {
    MessageEntity localMessageEntity = this.b.k(paramGroupReferralInfo.getMessageToken());
    if (m.l(localMessageEntity))
    {
      this.f.b(new s(parama, paramh, localMessageEntity));
      return;
    }
    if (localMessageEntity != null)
    {
      this.f.b(new t(parama, paramh));
      return;
    }
    b(paramGroupReferralInfo, paramh, paramInt, parama);
  }

  private void b(final GroupReferralInfo paramGroupReferralInfo, final h paramh, int paramInt, final a parama)
  {
    int i = a.c(paramGroupReferralInfo.getMessageId(), paramInt);
    if (i <= 0)
    {
      this.f.b(new u(parama, paramh));
      return;
    }
    final int j = this.c.generateSequence();
    bv.t local1 = new bv.t()
    {
      private boolean f;

      public void onPublicGroupSyncFinished(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2)
      {
        if ((j == paramAnonymousInt1) || ((this.f) && (paramAnonymousLong == paramGroupReferralInfo.getGroupId())))
        {
          q.a(q.this).b(this);
          if (q.b(q.this) == paramGroupReferralInfo.getMessageToken());
        }
        else
        {
          return;
        }
        if (paramAnonymousInt2 == 0);
        for (MessageEntity localMessageEntity = q.c(q.this).k(paramGroupReferralInfo.getMessageToken()); ; localMessageEntity = null)
        {
          az localaz = q.d(q.this);
          q.a locala = parama;
          locala.getClass();
          localaz.b(z.a(locala));
          if (!m.l(localMessageEntity))
            break;
          q.d(q.this).b(new aa(parama, paramh, localMessageEntity));
          return;
        }
        q.d(q.this).b(new ab(parama, paramh));
      }

      public void onPublicGroupSyncRequestCanceled(int paramAnonymousInt)
      {
        if (j == paramAnonymousInt)
          this.f = true;
      }
    };
    az localaz = this.f;
    parama.getClass();
    localaz.b(v.a(parama));
    this.e.a(local1, this.f.a());
    this.d.a(j, paramGroupReferralInfo.getGroupId(), i, false);
  }

  public void a()
  {
    this.g = 0L;
  }

  public void a(GroupReferralInfo paramGroupReferralInfo, a parama)
  {
    a(paramGroupReferralInfo, null, parama);
  }

  public void a(GroupReferralInfo paramGroupReferralInfo, h paramh, a parama)
  {
    this.f.a(new r(this, paramGroupReferralInfo, paramh, parama));
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(h paramh);

    public abstract void a(h paramh, long paramLong1, long paramLong2);

    public abstract void a(String paramString, GroupReferralInfo paramGroupReferralInfo);

    public abstract void b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.q
 * JD-Core Version:    0.6.2
 */
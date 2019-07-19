package com.viber.voip.messages.controller.b;

import android.support.v4.util.Pair;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.group.GroupControllerDelegate.GroupCreate;
import com.viber.jni.im2.CUpdateCommunityPrivilegesReplyMsg;
import com.viber.jni.im2.CUpdateCommunityPrivilegesReplyMsg.Receiver;
import com.viber.jni.publicaccount.PublicAccountControllerDelegate.PublicAccountDelegate;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.e.c;
import com.viber.voip.messages.controller.af;
import com.viber.voip.messages.controller.af.b;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.bs.e;
import com.viber.voip.messages.controller.bs.e.a;
import com.viber.voip.messages.controller.bs.f;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.al;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.util.ae;
import com.viber.voip.util.av;
import java.util.Collections;
import java.util.Map;

public class g
  implements GroupControllerDelegate.GroupCreate, CUpdateCommunityPrivilegesReplyMsg.Receiver, PublicAccountControllerDelegate.PublicAccountDelegate
{
  private static final Logger a = ViberEnv.getLogger();
  private o b;
  private af c;
  private com.viber.voip.messages.controller.a d;
  private dagger.a<bs> e;
  private ab f;
  private final PhoneController g;
  private final al h;
  private final com.viber.voip.analytics.story.g.a i;
  private final c j;

  public g(o paramo, af paramaf, com.viber.voip.messages.controller.a parama, dagger.a<bs> parama1, ab paramab, PhoneController paramPhoneController, al paramal, com.viber.voip.analytics.story.g.a parama2, c paramc)
  {
    this.b = paramo;
    this.c = paramaf;
    this.e = parama1;
    this.f = paramab;
    this.g = paramPhoneController;
    this.h = paramal;
    this.d = parama;
    this.i = parama2;
    this.j = paramc;
  }

  public void onCUpdateCommunityPrivilegesReplyMsg(CUpdateCommunityPrivilegesReplyMsg paramCUpdateCommunityPrivilegesReplyMsg)
  {
    PublicAccount localPublicAccount = this.c.i(paramCUpdateCommunityPrivilegesReplyMsg.seq);
    if (localPublicAccount == null)
      return;
    int k;
    int m;
    switch (paramCUpdateCommunityPrivilegesReplyMsg.status)
    {
    default:
      k = 1;
      m = 1;
    case 0:
    case 3:
    case 1:
    case 2:
    case 4:
    }
    while (true)
    {
      if (m != 0)
        this.f.a(localPublicAccount.getGroupID(), 3, false);
      if (k != 0)
      {
        int n = this.g.generateSequence();
        this.c.a(n, localPublicAccount.getGroupID(), null, 1, 5, 3);
      }
      this.c.j(paramCUpdateCommunityPrivilegesReplyMsg.seq);
      return;
      m = 1;
      k = 0;
      continue;
      k = 1;
      m = 1;
      continue;
      k = 1;
      m = 1;
      continue;
      k = 0;
      m = 0;
      continue;
      k = 1;
      m = 1;
    }
  }

  public void onChangePublicAccountReply(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
  }

  public void onCreateGroupReply(int paramInt1, int paramInt2, long paramLong, Map<String, Integer> paramMap)
  {
    PublicAccount localPublicAccount = this.c.i(paramInt2);
    if (localPublicAccount == null)
      return;
    if (paramInt1 == 0)
    {
      this.j.a(String.valueOf(paramLong), "Create Chat Icon", 1);
      localPublicAccount.setGroupID(paramLong);
      localPublicAccount.setGroupRole(2);
      bs.e locale = bs.e.a().a(true).a(Boolean.FALSE).a();
      bs.f localf = ((bs)this.e.get()).a(paramInt2, paramLong, 5, localPublicAccount, locale);
      this.c.j(paramInt2);
      this.b.a(paramInt2, localf.f.getId(), paramLong, "", paramMap, "", localPublicAccount.getName());
      this.b.a(Collections.singleton(Long.valueOf(localf.f.getId())), localf.f.j(), false, false);
      com.viber.voip.analytics.story.g.a locala = this.i;
      String str1 = ae.b();
      String str2 = localf.f.o();
      if (localf.f.q() != null);
      for (boolean bool = true; ; bool = false)
      {
        locala.a(str1, str2, bool, localPublicAccount.getTagLines());
        return;
      }
    }
    this.c.j(paramInt2);
    this.b.b(paramInt2, 1);
  }

  public void onCreatePublicAccountReply(int paramInt1, int paramInt2, long paramLong, String paramString1, Map<String, Integer> paramMap, String paramString2)
  {
  }

  public void onJoinPublicGroup(long paramLong, int paramInt1, int paramInt2)
  {
    af.b localb = this.c.l(paramInt1);
    if (localb == null)
      return;
    long l1 = -1L;
    long l2;
    long l6;
    String str2;
    if ((paramInt2 == 2) || (paramInt2 == 0))
    {
      l2 = av.a(0L, 3);
      com.viber.voip.model.entity.h localh = this.f.b(paramLong);
      if (localh == null)
        break label249;
      l6 = localh.getId();
      this.h.a(l6, localh.p(), ((bs)this.e.get()).a());
      this.f.a(new h(this, localh, l6, paramLong));
      str2 = localh.o();
      if (!localh.ar())
        break label338;
    }
    label338: for (long l7 = av.a(l2, 37); ; l7 = l2)
    {
      l1 = l6;
      long l3 = l7;
      String str1 = str2;
      while (true)
      {
        long l4 = av.a(0L, 36);
        this.f.a(l1, l3, l4);
        com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.l.a.a(str1, "member", String.valueOf(paramLong)));
        long l5 = l1;
        if (paramInt2 != 0)
          this.c.d(paramLong);
        this.b.b(paramInt1, paramLong, 5, paramInt2);
        if (l5 > 0L)
          this.b.a(Collections.singleton(Long.valueOf(l5)), 5, false, false);
        this.c.m(paramInt1);
        return;
        label249: bs.e locale = bs.e.a().a(true).a();
        bs.f localf = ((bs)this.e.get()).a(paramInt1, paramLong, 5, new Pair(localb.c, Long.valueOf(localb.b)), localb.a, System.currentTimeMillis(), locale);
        l1 = localf.f.getId();
        str1 = localf.f.o();
        l3 = l2;
      }
    }
  }

  public void onPublicAccountRefreshToken(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.b.g
 * JD-Core Version:    0.6.2
 */
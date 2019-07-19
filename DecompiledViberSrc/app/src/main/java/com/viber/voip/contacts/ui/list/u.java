package com.viber.voip.contacts.ui.list;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CDeleteAllUserMessagesReplyMsg;
import com.viber.jni.im2.CDeleteAllUserMessagesReplyMsg.Receiver;
import com.viber.jni.im2.CGroupBanUserReplyMsg;
import com.viber.jni.im2.CGroupBanUserReplyMsg.Receiver;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.StoryConstants.f.a;
import com.viber.voip.analytics.story.b.a.h.a;
import com.viber.voip.analytics.story.b.a.h.a.a;
import com.viber.voip.analytics.story.e.c;
import com.viber.voip.i.f;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.a.c.c;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.GroupController.GroupMember;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.messages.controller.manager.an;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.b.n;
import com.viber.voip.messages.conversation.ui.b.o;
import com.viber.voip.messages.conversation.ui.b.p;
import com.viber.voip.messages.m;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInitiationId;
import com.viber.voip.registration.af;
import com.viber.voip.util.cd;
import com.viber.voip.util.cl;
import com.viber.voip.util.cn;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class u extends bv.t
  implements CDeleteAllUserMessagesReplyMsg.Receiver, CGroupBanUserReplyMsg.Receiver, t, o
{
  private static final Logger a = ViberEnv.getLogger();
  private static final w b = (w)cl.b(w.class);
  private final dagger.a<GroupController> c;
  private final dagger.a<com.viber.voip.messages.controller.a> d;
  private final af e;
  private final dagger.a<bv> f;
  private final CallHandler g;
  private final cn h;
  private Im2Exchanger i;
  private final PhoneController j;
  private w k;
  private Handler l;
  private final c m;
  private n n;
  private EventBus o;
  private f p;
  private final String q;
  private final boolean r;

  @SuppressLint({"UseSparseArrays"})
  private Map<Integer, String> s = new HashMap();
  private int t;
  private ConversationItemLoaderEntity u;
  private com.viber.voip.model.h v;
  private boolean w;
  private final dagger.a<com.viber.voip.analytics.story.b.a.h> x;
  private Runnable y = new v(this);

  public u(Im2Exchanger paramIm2Exchanger, w paramw, dagger.a<GroupController> parama, dagger.a<com.viber.voip.messages.controller.a> parama1, af paramaf, CallHandler paramCallHandler, dagger.a<bv> parama2, cn paramcn, PhoneController paramPhoneController, Handler paramHandler, n paramn, c paramc, dagger.a<com.viber.voip.analytics.story.b.a.h> parama3, EventBus paramEventBus, f paramf, String paramString, boolean paramBoolean)
  {
    this.k = paramw;
    this.l = paramHandler;
    this.p = paramf;
    this.c = parama;
    this.d = parama1;
    this.e = paramaf;
    this.g = paramCallHandler;
    this.f = parama2;
    this.h = paramcn;
    this.j = paramPhoneController;
    this.i = paramIm2Exchanger;
    this.n = paramn;
    this.m = paramc;
    this.x = parama3;
    this.q = paramString;
    this.r = paramBoolean;
    this.o = paramEventBus;
    this.o.register(this);
  }

  private void a(int paramInt, Map<String, Integer> paramMap)
  {
    if (paramMap.size() > 0)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      do
        if (!localIterator.hasNext())
          break;
      while (3 == ((Integer)((Map.Entry)localIterator.next()).getValue()).intValue());
    }
    for (int i1 = 1; ; i1 = 0)
    {
      if (i1 != 0)
      {
        if (cd.c(paramInt))
          this.k.g();
      }
      else
        return;
      this.k.f();
      return;
    }
  }

  private void a(String paramString)
  {
    if (m.b(this.u.getConversationType()))
      this.m.b(this.q, paramString, StoryConstants.f.a.a(this.v.a()));
  }

  private void a(String paramString, int paramInt)
  {
    c(true);
    ((GroupController)this.c.get()).a(this.u.getGroupId(), new String[] { paramString }, paramInt);
  }

  private void b(boolean paramBoolean)
  {
    this.m.a(this.v.h(), "Chat Menu", 2);
    if (paramBoolean);
    for (String str = "Start Secret Chat"; ; str = "Message")
    {
      a(str);
      this.k.a(this.v, paramBoolean, this.u.isInBusinessInbox(), this.u.isVlnConversation());
      return;
    }
  }

  private void c(com.viber.voip.model.h paramh)
  {
    int i1 = this.u.getConversationType();
    int i2 = this.u.getGroupRole();
    boolean bool = paramh.isOwner();
    if (paramh.g() > 0L);
    int i4;
    for (int i3 = 1; ; i3 = 0)
    {
      i4 = paramh.a();
      if ((!bool) || (cd.c(i2)))
        break;
      this.k.X_();
      return;
    }
    if ((!bool) && (i3 == 0) && (!this.p.e()) && ((cd.f(i2)) || ((cd.a(i2)) && (cd.b(i4)))))
    {
      String str = paramh.a(i2, i1);
      this.k.a(str, paramh.j(), cd.b(i4));
      return;
    }
    this.v = paramh;
    this.k.a();
  }

  private void c(boolean paramBoolean)
  {
    this.l.removeCallbacks(this.y);
    if (paramBoolean)
    {
      this.l.postDelayed(this.y, 500L);
      return;
    }
    this.k.a(false);
  }

  private void d(com.viber.voip.model.h paramh)
  {
    int i1 = this.u.getConversationType();
    int i2 = this.u.getGroupRole();
    boolean bool = paramh.isOwner();
    if ((bool) && (!cd.c(i2)))
    {
      this.k.X_();
      return;
    }
    if ((!bool) && (cd.f(i2)))
    {
      String str = paramh.a(i2, i1);
      this.k.a(str, paramh.j(), false);
      return;
    }
    if (cd.c(i2))
    {
      this.v = paramh;
      this.k.a();
      return;
    }
    this.k.a(this.u, paramh);
  }

  private void e(com.viber.voip.model.h paramh)
  {
    if (paramh.isOwner())
    {
      this.k.X_();
      return;
    }
    this.v = paramh;
    this.k.a();
  }

  private void f(com.viber.voip.model.h paramh)
  {
    int i1 = this.u.getGroupRole();
    if ((paramh.isOwner()) && (!cd.c(i1)))
    {
      this.k.X_();
      return;
    }
    this.v = paramh;
    this.k.a();
  }

  private void g(com.viber.voip.model.h paramh)
  {
    if (paramh.isOwner())
    {
      this.k.X_();
      return;
    }
    if (this.u.isOneToOneWithPublicAccount())
    {
      this.k.a(this.u);
      return;
    }
    if (this.u.isAnonymous())
    {
      String str = paramh.a(this.u.getGroupRole(), this.u.getConversationType());
      this.k.a(str, paramh.j(), false);
      return;
    }
    this.k.a(this.u, paramh);
  }

  private void w()
  {
    c(((com.viber.voip.messages.controller.a)this.d.get()).a(this.t));
  }

  private void x()
  {
    if (this.w)
      return;
    ((bv)this.f.get()).a(this);
    this.i.registerDelegate(this, this.l);
    if (this.n != null)
      this.n.a(this);
    this.w = true;
  }

  private void y()
  {
    if (!this.w)
      return;
    ((bv)this.f.get()).b(this);
    this.i.removeDelegate(this);
    if (this.n != null)
      this.n.b(this);
    this.w = false;
  }

  public void a()
  {
    x();
    w();
  }

  public void a(long paramLong1, String paramString1, int paramInt, String paramString2, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1);
    for (String str = this.e.l(); ; str = paramString1)
    {
      c(true);
      if (paramBoolean2)
      {
        this.t = this.j.generateSequence();
        ((com.viber.voip.messages.controller.a)this.d.get()).a(this.t, str, paramLong1);
      }
      int i1 = this.j.generateSequence();
      if ((cd.e(this.u.getGroupRole(), this.u.getConversationType())) && (!paramBoolean2) && (!cd.c(paramInt)) && (!paramBoolean1))
        this.s.put(Integer.valueOf(i1), paramString2);
      ((com.viber.voip.messages.controller.a)this.d.get()).a(i1, paramLong2, paramLong1, str, paramBoolean1);
      return;
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    int i1 = 1;
    int i2;
    if ((this.u != null) && (this.u.isCommunityBlocked()))
    {
      i2 = i1;
      if (i2 == paramConversationItemLoaderEntity.isCommunityBlocked())
        break label63;
    }
    while (true)
    {
      this.u = paramConversationItemLoaderEntity;
      if ((i1 != 0) && (this.u.isCommunityBlocked()))
        this.k.k();
      return;
      i2 = 0;
      break;
      label63: i1 = 0;
    }
  }

  public void a(ac paramac, boolean paramBoolean)
  {
    p.a(this, paramac, paramBoolean);
  }

  public void a(com.viber.voip.model.h paramh)
  {
    int i1 = this.u.getConversationType();
    if (m.b(i1))
      c(paramh);
    do
    {
      return;
      if (m.a(i1))
      {
        d(paramh);
        return;
      }
      if (m.c(i1))
      {
        e(paramh);
        return;
      }
      if (m.f(i1))
      {
        f(paramh);
        return;
      }
    }
    while (!m.g(i1));
    g(paramh);
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      x();
      w();
      return;
    }
    y();
  }

  public void b()
  {
    y();
  }

  public void b(com.viber.voip.model.h paramh)
  {
    a(paramh);
  }

  public void c()
  {
    this.k = b;
    this.o.unregister(this);
  }

  public void d()
  {
    int i1 = this.u.getConversationType();
    int i2 = this.u.getGroupRole();
    String str = this.v.a(i2, i1);
    boolean bool1 = this.v.isOwner();
    int i3;
    int i4;
    boolean bool2;
    boolean bool3;
    s locals;
    int i5;
    label159: int i7;
    label258: int i6;
    if (this.v.g() > 0L)
    {
      i3 = 1;
      i4 = this.v.a();
      bool2 = this.v.c();
      bool3 = an.a(this.r);
      locals = new s();
      if (bool1)
        break label725;
      if ((i3 != 0) || (!m.b(i1)) || (!this.p.e()))
        break label478;
      locals.a(R.id.menu_start_anonymous_chat, new s.a(this.h.a(R.string.chat_info_participant_option_message, new Object[] { str })));
      i5 = 1;
      if (i5 != 0)
        locals.a(R.id.menu_view, new s.a(this.h.a(R.string.admin_menu_view_info)));
      if ((cd.c(i2)) && (!m.c(i1)) && ((!m.b(i1)) || (!cd.f(i4))) && ((!m.a(i1)) || (((PublicGroupConversationItemLoaderEntity)this.u).hasPublicChat())))
      {
        if (!m.b(i1))
          break label739;
        if (!cd.c(i4))
          break label731;
        i7 = R.string.remove_as_superadmin;
        locals.a(R.id.admin_assign_role_action, new s.a(this.h.a(i7)));
      }
      if ((m.b(i1)) && (cd.c(i2)) && (cd.f(i4)))
        locals.a(R.id.admin_add_group_members_action, new s.a(this.h.a(R.string.admin_menu_add_as_admin)));
      if ((!bool1) && ((cd.c(i2)) || ((m.b(i1)) && (cd.a(i2)) && (cd.f(i4)))))
      {
        if (!m.c(i1))
          break label763;
        i6 = R.string.admin_menu_remove_from_list;
        label375: locals.a(R.id.remove_from_chat, new s.a(this.h.a(i6)));
      }
      if (!bool1)
      {
        if ((!bool2) || (this.u.isCommunityBlocked()) || (!cd.b(i2, i1)))
          break label771;
        locals.a(R.id.menu_unban, new s.a(this.h.a(R.string.admin_menu_unban_member, new Object[] { str })));
      }
    }
    while (true)
    {
      this.k.a(locals);
      return;
      i3 = 0;
      break;
      label478: if ((!m.a(i1)) && (!m.b(i1)))
      {
        locals.a(R.id.menu_message, new s.a(this.h.a(R.string.chat_info_participant_option_message, new Object[] { str })));
        locals.a(R.id.menu_call, new s.a(this.h.a(R.string.chat_info_participant_option_call, new Object[] { str })));
        if (bool3)
          locals.a(R.id.menu_start_secret_chat, new s.a(this.h.a(R.string.chat_info_participant_option_start_secret_chat, new Object[] { str })));
        locals.a(R.id.menu_view, new s.a(this.h.a(R.string.chat_info_participant_option_view, new Object[] { str })));
        i5 = 0;
        break label159;
      }
      if ((m.b(i1)) && (i3 != 0))
      {
        locals.a(R.id.menu_message, new s.a(this.h.a(R.string.chat_info_participant_option_message, new Object[] { str })));
        locals.a(R.id.menu_view, new s.a(this.h.a(R.string.chat_info_participant_option_view, new Object[] { str })));
        i5 = 0;
        break label159;
      }
      i5 = 1;
      break label159;
      label725: i5 = 1;
      break label159;
      label731: i7 = R.string.add_as_superadmin;
      break label258;
      label739: if (cd.c(i4))
      {
        i7 = R.string.admin_menu_remove_as_admin;
        break label258;
      }
      i7 = R.string.admin_menu_add_as_admin;
      break label258;
      label763: i6 = R.string.admin_menu_remove_from_chat;
      break label375;
      label771: if ((!bool2) && (cd.a(i2, i4, i1)))
        locals.a(R.id.menu_ban, new s.a(this.h.a(R.string.admin_menu_ban_member, new Object[] { str })));
    }
  }

  public void e()
  {
    this.k.a(this.v);
  }

  public void f()
  {
    b(false);
  }

  public void g()
  {
    this.g.setNextCallIsFromSecretConversation(this.u.isSecret());
    CallInitiationId.noteNextCallInitiationAttemptId();
    com.viber.voip.analytics.story.b.a.h localh = (com.viber.voip.analytics.story.b.a.h)this.x.get();
    h.a.a locala = h.a.i();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.v.getNumber();
    localh.b(locala.a(arrayOfString).a("Participants Popup").b("Free Audio 1-On-1 Call").a(true).a());
    a("Call");
    this.g.handleDialViber(new Member(this.v.h(), this.v.getNumber()), false);
  }

  public void h()
  {
    b(true);
  }

  public void i()
  {
    c(true);
    this.t = this.j.generateSequence();
    ((com.viber.voip.messages.controller.a)this.d.get()).a(this.t, this.u.getGroupId(), this.v.p());
    this.m.a(this.v.h(), true, StoryConstants.f.a.a(this.v.a()));
  }

  public void j()
  {
    a("View");
    if (this.v.isOwner())
    {
      this.k.X_();
      return;
    }
    this.k.a(this.u, this.v);
  }

  public void k()
  {
    String str = this.e.l();
    if ((this.u.isCommunityType()) && (cd.f(this.u.getGroupRole())));
    for (int i1 = 1; ; i1 = 2)
    {
      a(str, i1);
      return;
    }
  }

  public void l()
  {
    String str1;
    int i1;
    if (this.v.isOwner())
    {
      str1 = this.e.l();
      if ((!this.v.isOwner()) && (!cd.c(this.v.a())))
        break label83;
      i1 = 1;
      label49: if (i1 != 2)
        break label88;
    }
    label83: label88: for (String str2 = "Add as Superadmin"; ; str2 = "Remove a Superadmin")
    {
      a(str2);
      a(str1, i1);
      return;
      str1 = this.v.h();
      break;
      i1 = 2;
      break label49;
    }
  }

  public void m()
  {
    c(true);
    a("Add as Admin");
    GroupController.GroupMember localGroupMember = new GroupController.GroupMember(this.v.h(), "", this.v.getNumber(), this.v.getViberName(), null, null, 0);
    ((GroupController)this.c.get()).a(this.j.generateSequence(), this.u.getGroupId(), new GroupController.GroupMember[] { localGroupMember });
  }

  public void n()
  {
    a("Remove from Chat");
    if (this.u.isBroadcastListType())
    {
      ((GroupController)this.c.get()).b(this.u.getId(), this.v.h());
      return;
    }
    this.k.b(this.u, this.v);
  }

  public void o()
  {
    c(true);
    GroupController localGroupController = (GroupController)this.c.get();
    long l1 = this.u.getGroupId();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.v.h();
    localGroupController.a(l1, arrayOfString);
  }

  public void onAssignRole(int paramInt1, String[] paramArrayOfString, int paramInt2, Map<String, Integer> paramMap)
  {
    c(false);
    switch (paramInt1)
    {
    default:
      this.k.d();
      return;
    case 0:
      a(paramInt2, paramMap);
      return;
    case 5:
    case 6:
    }
    this.k.c();
  }

  public void onCDeleteAllUserMessagesReplyMsg(CDeleteAllUserMessagesReplyMsg paramCDeleteAllUserMessagesReplyMsg)
  {
    c(((com.viber.voip.messages.controller.a)this.d.get()).a(this.t));
    switch (paramCDeleteAllUserMessagesReplyMsg.status)
    {
    case 1:
    case 3:
    default:
      this.k.f();
    case 4:
    case 2:
    case 0:
    }
    String str;
    do
    {
      return;
      this.k.d();
      return;
      this.k.c();
      return;
      str = (String)this.s.remove(Integer.valueOf(paramCDeleteAllUserMessagesReplyMsg.seq));
    }
    while (str == null);
    this.k.d_(str);
  }

  public void onCGroupBanUserReplyMsg(CGroupBanUserReplyMsg paramCGroupBanUserReplyMsg)
  {
    c(false);
    switch (paramCGroupBanUserReplyMsg.status)
    {
    default:
      return;
    case 5:
      this.k.e();
      return;
    case 4:
      this.k.d();
      return;
    case 1:
    case 2:
    case 3:
    }
    this.k.f();
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onCheckAllowsM2MChatEventReceived(c.c paramc)
  {
    if ((this.v == null) || (paramc.a != this.t))
      return;
    c(false);
    switch (paramc.b)
    {
    default:
      return;
    case 0:
      this.k.a(this.v, this.u.isInBusinessInbox(), this.u.isVlnConversation());
      return;
    case 3:
      this.k.F_();
      return;
    case 1:
      this.k.f();
      return;
    case 2:
    }
    if (this.j.isConnected())
    {
      this.k.f();
      return;
    }
    this.k.c();
  }

  public void onMembersAddedToGroup(int paramInt1, long paramLong, int paramInt2, Map<String, Integer> paramMap)
  {
    c(false);
    switch (paramInt2)
    {
    case 1:
    case 2:
    case 4:
    default:
      this.k.d();
    case 0:
      return;
    case 5:
    case 6:
      this.k.c();
      return;
    case 3:
    }
    this.k.h();
  }

  public void onMembersRemovedFromGroup(long paramLong, int paramInt, String[] paramArrayOfString, Map<String, Integer> paramMap)
  {
    c(false);
    switch (paramInt)
    {
    case 1:
    case 2:
    case 3:
    default:
      this.k.d();
    case 0:
      return;
    case 4:
    case 5:
    }
    this.k.c();
  }

  public void p()
  {
    a("Ban");
    this.k.c(this.u, this.v);
  }

  public void q()
  {
    this.k.E_();
  }

  public void r()
  {
    if (this.j.isConnected())
    {
      c(true);
      this.t = this.j.generateSequence();
      ((com.viber.voip.messages.controller.a)this.d.get()).a(this.t, this.v.p(), this.u.getGroupId());
      return;
    }
    this.k.c();
  }

  public void s()
  {
    if (this.j.isConnected())
    {
      c(true);
      this.t = this.j.generateSequence();
      ((com.viber.voip.messages.controller.a)this.d.get()).b(this.t, this.v.p(), this.u.getGroupId());
      return;
    }
    this.k.c();
  }

  public void t()
  {
    this.k.b(this.u);
  }

  public void u()
  {
    this.k.c(this.u);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.u
 * JD-Core Version:    0.6.2
 */
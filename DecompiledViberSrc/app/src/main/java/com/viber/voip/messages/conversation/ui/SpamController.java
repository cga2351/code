package com.viber.voip.messages.conversation.ui;

import android.app.Activity;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.a;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.o;
import com.viber.voip.av.e;
import com.viber.voip.i.f;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.adapter.k.b;
import com.viber.voip.messages.conversation.adapter.k.b.a;
import com.viber.voip.messages.conversation.adapter.l;
import com.viber.voip.messages.conversation.q;
import com.viber.voip.messages.conversation.s;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView.a;
import com.viber.voip.messages.conversation.ui.banner.aa.a;
import com.viber.voip.messages.conversation.ui.spam.b.b.b;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.permissions.n;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.r;
import com.viber.voip.ui.ViberButton;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.u;
import com.viber.voip.util.ViberActionRunner.c;
import com.viber.voip.util.cg;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SpamController
  implements aa.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final LayoutInflater b;
  private final q c;
  private final Handler d;
  private final PhoneController e;
  private final ai f;
  private final com.viber.voip.messages.controller.a g;
  private final com.viber.voip.analytics.story.d.c h;
  private final com.viber.voip.analytics.story.e.c i;
  private final com.viber.voip.analytics.story.a.a j;
  private final EventBus k;
  private final ConversationFragment l;
  private final ConversationAlertView m;
  private final boolean n;
  private final com.viber.common.permission.c o;
  private final com.viber.common.permission.b p;
  private com.viber.voip.messages.conversation.adapter.k q;
  private ConversationItemLoaderEntity r;
  private com.viber.voip.model.entity.m s;
  private boolean t;
  private int u;
  private final Collection<b> v;
  private final c w;
  private com.viber.voip.messages.conversation.ui.banner.aa x;
  private com.viber.voip.messages.conversation.ui.spam.b.e y;
  private com.viber.voip.messages.conversation.ui.spam.b.b z;

  public SpamController(boolean paramBoolean, q paramq, ConversationFragment paramConversationFragment, ConversationAlertView paramConversationAlertView, PhoneController paramPhoneController, ai paramai, com.viber.voip.messages.controller.a parama, EventBus paramEventBus)
  {
    this.c = paramq;
    this.v = new HashSet();
    this.l = paramConversationFragment;
    this.n = paramBoolean;
    this.m = paramConversationAlertView;
    this.b = paramConversationFragment.getLayoutInflater();
    this.w = new c(this.b);
    this.d = av.e.a.a();
    this.o = com.viber.common.permission.c.a(paramConversationFragment.getActivity());
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(77);
    this.p = new com.viber.voip.permissions.e(paramConversationFragment, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        SpamController.a(SpamController.this);
      }
    };
    this.e = paramPhoneController;
    this.f = paramai;
    this.g = parama;
    o localo = com.viber.voip.analytics.g.a().c();
    this.h = localo.a();
    this.i = localo.g();
    this.j = localo.k();
    this.k = paramEventBus;
    this.k.register(this);
  }

  private void A()
  {
    if (this.o.a(n.k))
    {
      B();
      return;
    }
    this.o.a(this.l, 77, n.k);
  }

  private void B()
  {
    ViberActionRunner.c.a(this.l.getActivity(), this.s.a(), this.s.getNumber(), "Manual", "in-Chat Banner");
  }

  private void C()
  {
    com.viber.voip.block.g.a(this.l.ag(), Collections.singleton(Member.from(this.s)), this.s.getViberName(), D(), new ca(this));
    this.h.b(1.0D, "Non-Contact Popup");
  }

  private boolean D()
  {
    return (this.r != null) && (this.r.isSecret());
  }

  private void E()
  {
    if ((this.r != null) && (this.r.isAnonymous()))
      this.f.a(this.r.getId());
  }

  private void F()
  {
    if (this.r == null)
      return;
    ViberApplication.getInstance().getMessagesManager().c().a(Collections.singleton(Long.valueOf(this.r.getId())), this.r.getConversationType());
  }

  private void G()
  {
    e(false);
    this.d.postDelayed(new Runnable()
    {
      public void run()
      {
        SpamController.a(SpamController.this, true, false, false);
        SpamController.i(SpamController.this);
      }
    }
    , 500L);
  }

  private void H()
  {
    if (this.r.isNewSpamBanner())
      Q();
    while (this.r.isAnonymous())
      return;
    N();
  }

  private void I()
  {
    R();
    O();
  }

  private void J()
  {
    this.r.isNewSpamBanner();
    R();
    O();
  }

  private boolean K()
  {
    if (this.r.isNewSpamBanner())
      return this.r.showSpamOverlay();
    return false;
  }

  private boolean L()
  {
    boolean bool = this.r.isNewSpamBanner();
    if (this.t);
    do
    {
      return false;
      if (bool)
        return this.r.showSpamBanner();
    }
    while ((!this.r.isConversation1on1()) || (this.t));
    return true;
  }

  private void M()
  {
    if (this.r.isNewSpamBanner())
      this.x.a(this.r, this.t, this.n);
  }

  private void N()
  {
    if (this.x != null)
      this.m.a(this.x.a(), false);
    this.w.e();
  }

  private void O()
  {
    if (this.w != null)
      this.w.f();
  }

  private void P()
  {
    if (this.r.isAnonymous())
    {
      this.x = new com.viber.voip.messages.conversation.ui.banner.d(this.m, this, this.b);
      return;
    }
    this.x = new com.viber.voip.messages.conversation.ui.banner.z(this.m, this, this.b);
  }

  private void Q()
  {
    O();
    if (this.x == null)
      P();
    this.x.a(this.r, this.t, this.n);
    this.m.a(this.x, false);
    this.d.post(new cb(this));
  }

  private void R()
  {
    if (this.x != null)
    {
      this.m.a(this.x.a(), false);
      this.d.post(new cc(this));
    }
  }

  private void S()
  {
    if (this.y != null)
      this.y.e();
  }

  private void T()
  {
    if (this.y != null)
      this.y.f();
  }

  private void U()
  {
    if (this.y != null)
      this.y.b();
  }

  private void V()
  {
    this.f.b(this.r.getId(), false, new ce(this));
  }

  private void W()
  {
    Iterator localIterator = this.v.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb != null)
        localb.b();
    }
  }

  private void X()
  {
    Iterator localIterator = this.v.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb != null)
        localb.c();
    }
  }

  private void Y()
  {
    Iterator localIterator = this.v.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb != null)
        localb.d();
    }
  }

  private boolean Z()
  {
    FragmentActivity localFragmentActivity = this.l.getActivity();
    return (localFragmentActivity != null) && (!localFragmentActivity.isFinishing());
  }

  public static com.viber.voip.model.entity.m a(boolean paramBoolean, long paramLong, String paramString)
  {
    com.viber.voip.messages.d.b localb = com.viber.voip.messages.d.c.c();
    if (paramBoolean)
      return localb.b(paramLong);
    return localb.c(paramString, 1);
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.s == null) || (this.s.a() == null))
      return;
    Set localSet = Collections.singleton(Member.from(this.s));
    com.viber.voip.analytics.story.d.c localc;
    if (paramBoolean2)
    {
      com.viber.voip.block.g.a(this.l.ag(), localSet, this.s.getViberName(), paramBoolean1, new bz(this), false, D());
      localc = this.h;
      if ((!paramBoolean3) || (!this.r.isAnonymous()))
        break label112;
    }
    label112: for (String str = "M2M not in AB dialog"; ; str = "Non-Contact Popup")
    {
      localc.a(1.0D, str);
      return;
      com.viber.voip.block.g.a(localSet, paramBoolean1);
      break;
    }
  }

  public static boolean a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    com.viber.voip.model.entity.m localm = a(paramConversationItemLoaderEntity.isGroupBehavior(), paramConversationItemLoaderEntity.getCreatorParticipantInfoId(), paramConversationItemLoaderEntity.getParticipantMemberId());
    return (localm != null) && (!ao.f()) && ((!paramConversationItemLoaderEntity.isSystemConversation()) || (paramConversationItemLoaderEntity.hasBusinessInboxOverlay())) && (!paramConversationItemLoaderEntity.isPublicGroupBehavior()) && (!paramConversationItemLoaderEntity.isVlnConversation()) && (!paramConversationItemLoaderEntity.isOneToOneWithPublicAccount()) && (!paramConversationItemLoaderEntity.isBroadcastListType()) && (!paramConversationItemLoaderEntity.showAddNewParticipantNumberBanner()) && (localm.i() == 0L) && (!localm.isOwner()) && (!localm.q()) && (!cg.c(localm.getNumber())) && (paramConversationItemLoaderEntity.showSpamBanner()) && (paramConversationItemLoaderEntity.isNewSpamBanner());
  }

  public static boolean a(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    boolean bool;
    if ((!ao.f()) && ((!paramConversationLoaderEntity.isSystemConversation()) || (paramConversationLoaderEntity.hasBusinessInboxOverlay())) && (!paramConversationLoaderEntity.isPublicGroupBehavior()) && (!paramConversationLoaderEntity.isVlnConversation()) && (!paramConversationLoaderEntity.isPublicAccount()) && (!paramConversationLoaderEntity.isBroadcastListType()) && (!paramConversationLoaderEntity.showAddNewParticipantNumberBanner()) && (paramConversationLoaderEntity.showSpamBanner()) && (paramConversationLoaderEntity.isNewSpamBanner()))
    {
      bool = true;
      if (!bool)
        break label165;
      if (!paramConversationLoaderEntity.isGroupBehavior())
        break label137;
      localm = a(paramConversationLoaderEntity.isGroupBehavior(), paramConversationLoaderEntity.getCreatorParticipantInfoId(), paramConversationLoaderEntity.getParticipantMemberId());
      if ((localm == null) || (cg.c(localm.getNumber())) || (localm.i() != 0L) || (localm.isOwner()))
        break label135;
    }
    label135: label137: 
    while ((paramConversationLoaderEntity.getContactId() == 0L) && (!paramConversationLoaderEntity.isOwner()) && (!cg.c(paramConversationLoaderEntity.getNumber())))
    {
      com.viber.voip.model.entity.m localm;
      return true;
      bool = false;
      break;
      return false;
    }
    return false;
    label165: return bool;
  }

  public static boolean a(h paramh, MessageEntity paramMessageEntity)
  {
    com.viber.voip.model.entity.m localm = a(paramh.b(), paramh.Z(), paramMessageEntity.getMemberId());
    return (localm != null) && (!ao.f()) && ((!paramh.D()) || (paramh.ak())) && (!paramh.e()) && (!paramh.ao()) && (!paramh.G()) && (!paramh.h()) && (!paramh.H()) && (!cg.c(localm.getNumber())) && (localm.i() == 0L) && (!localm.isOwner()) && (paramh.L()) && (paramh.M());
  }

  private void b(boolean paramBoolean)
  {
    com.viber.voip.block.b localb = com.viber.voip.block.b.a();
    int i1 = this.r.getAppId();
    if (paramBoolean);
    for (int i2 = 2; ; i2 = 1)
    {
      localb.b(i1, i2);
      V();
      this.f.a(this.r.getId(), false, null);
      this.l.ah().b();
      return;
    }
  }

  public static boolean b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    com.viber.voip.model.entity.m localm = a(paramConversationItemLoaderEntity.isGroupBehavior(), paramConversationItemLoaderEntity.getCreatorParticipantInfoId(), paramConversationItemLoaderEntity.getParticipantMemberId());
    return (!ao.f()) && ((!paramConversationItemLoaderEntity.isSystemConversation()) || (paramConversationItemLoaderEntity.hasBusinessInboxOverlay())) && (!paramConversationItemLoaderEntity.isPublicGroupBehavior()) && (!paramConversationItemLoaderEntity.isVlnConversation()) && (!paramConversationItemLoaderEntity.isOneToOneWithPublicAccount()) && (!paramConversationItemLoaderEntity.isBroadcastListType()) && (!paramConversationItemLoaderEntity.showAddNewParticipantNumberBanner()) && ((d.r.j.d()) || (paramConversationItemLoaderEntity.hasBusinessInboxOverlay()) || (paramConversationItemLoaderEntity.isAnonymous())) && (paramConversationItemLoaderEntity.isNewSpamBanner()) && (paramConversationItemLoaderEntity.showSpamOverlay()) && (localm != null) && (0L == localm.i()) && (!localm.isOwner()) && (!localm.q()) && (!cg.c(localm.getNumber()));
  }

  private void c(final boolean paramBoolean)
  {
    if (this.t)
    {
      if ((this.r != null) && (!paramBoolean))
        this.f.a(this.r.getId(), false, null);
      e(false);
      this.d.postDelayed(new Runnable()
      {
        public void run()
        {
          if (SpamController.e(SpamController.this) != null)
          {
            if (SpamController.e(SpamController.this).isAnonymous())
              SpamController.h(SpamController.this);
          }
          else
            return;
          SpamController.i(SpamController.this);
        }
      }
      , 500L);
      return;
    }
    e(false);
    this.d.postDelayed(new Runnable()
    {
      public void run()
      {
        SpamController.a(SpamController.this, false, false, paramBoolean);
        SpamController.h(SpamController.this);
      }
    }
    , 500L);
  }

  private boolean c(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (paramConversationItemLoaderEntity == null);
    FragmentActivity localFragmentActivity;
    com.viber.voip.model.entity.m localm;
    do
    {
      return false;
      localFragmentActivity = this.l.getActivity();
      localm = a(paramConversationItemLoaderEntity.isGroupBehavior(), paramConversationItemLoaderEntity.getCreatorParticipantInfoId(), paramConversationItemLoaderEntity.getParticipantMemberId());
    }
    while ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || ((paramConversationItemLoaderEntity.isSystemConversation()) && (!paramConversationItemLoaderEntity.hasBusinessInboxOverlay())) || (paramConversationItemLoaderEntity.isPublicGroupBehavior()) || (paramConversationItemLoaderEntity.isVlnConversation()) || (paramConversationItemLoaderEntity.isOneToOneWithPublicAccount()) || (paramConversationItemLoaderEntity.showAddNewParticipantNumberBanner()) || (paramConversationItemLoaderEntity.isBroadcastListType()) || (localm == null) || (localm.q()) || (cg.c(localm.getNumber())));
    return true;
  }

  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      e(true);
      F();
    }
    while (true)
    {
      av.e.d.a().post(new by(this));
      return;
      V();
      this.f.a(this.r.getId(), false, null);
      this.j.a("Overlay");
    }
  }

  private boolean d(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.r;
    boolean bool1 = false;
    if (localConversationItemLoaderEntity != null)
    {
      bool1 = false;
      if (paramConversationItemLoaderEntity != null)
        if ((!this.r.isAnonymous()) || (paramConversationItemLoaderEntity.isAnonymous()))
        {
          boolean bool2 = this.r.isAnonymous();
          bool1 = false;
          if (!bool2)
          {
            boolean bool3 = paramConversationItemLoaderEntity.isAnonymous();
            bool1 = false;
            if (!bool3);
          }
        }
        else
        {
          bool1 = true;
        }
    }
    return bool1;
  }

  private void e(boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity;
    if (!this.n)
    {
      localFragmentActivity = this.l.getActivity();
      if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
      {
        if (!paramBoolean)
          break label35;
        localFragmentActivity.onBackPressed();
      }
    }
    return;
    label35: localFragmentActivity.finish();
  }

  private void s()
  {
    if ((this.r.isAnonymous()) && (!this.g.b(this.u)))
    {
      this.u = this.e.generateSequence();
      this.g.a(this.u, this.s.b());
    }
  }

  private void t()
  {
    bx localbx;
    if ((this.y == null) && (this.r != null))
    {
      localbx = new bx(this);
      if (!this.r.isAnonymous())
        break label124;
    }
    label124: for (this.y = new com.viber.voip.messages.conversation.ui.spam.b.a(this.l.getContext(), (ViewGroup)this.l.ag().findViewById(R.id.conversation_top), localbx); ; this.y = new com.viber.voip.messages.conversation.ui.spam.b.d(this.l.getContext(), (ViewGroup)this.l.ag().findViewById(R.id.conversation_top), localbx))
    {
      if (this.y != null)
      {
        this.y.a(this.r);
        this.y.a(this.s);
      }
      if ((this.r == null) || (!this.r.isAnonymous()))
        this.u = 0;
      return;
    }
  }

  private void u()
  {
    boolean bool = true;
    l.a locala = u.a();
    int i1 = R.string.dialog_424b_title;
    Object[] arrayOfObject1 = new Object[bool];
    arrayOfObject1[0] = this.r.getParticipantName();
    a.a locala1 = locala.a(i1, arrayOfObject1);
    int i2 = R.string.dialog_424b_body;
    Object[] arrayOfObject2 = new Object[bool];
    arrayOfObject2[0] = this.r.getParticipantName();
    a.a locala2 = locala1.b(i2, arrayOfObject2).a(new m.a()
    {
      public void onDialogAction(com.viber.common.dialogs.m paramAnonymousm, int paramAnonymousInt)
      {
        boolean bool = true;
        if (paramAnonymousm.a(DialogCode.D424b))
        {
          if (paramAnonymousInt == -1)
            SpamController.b(SpamController.this);
        }
        else
          return;
        if (paramAnonymousInt == -2)
        {
          l.a locala = u.b();
          int i = R.string.dialog_3901_body;
          Object[] arrayOfObject = new Object[bool];
          arrayOfObject[0] = SpamController.e(SpamController.this).getParticipantName();
          a.a locala1 = locala.b(i, arrayOfObject).a(new SpamController.a(SpamController.this, null));
          if (!SpamController.d(SpamController.this));
          while (true)
          {
            locala1.b(bool).b(SpamController.c(SpamController.this));
            return;
            bool = false;
          }
        }
        SpamController.a(SpamController.this, bool);
      }
    });
    if (!this.n);
    while (true)
    {
      locala2.b(bool).b(this.l);
      return;
      bool = false;
    }
  }

  private void v()
  {
    if (this.z == null)
      this.z = new com.viber.voip.messages.conversation.ui.spam.b.b(this.m, this.b, new b.b()
      {
        public void a()
        {
          SpamController.f(SpamController.this).d("Stop Messages");
          SpamController.g(SpamController.this);
        }

        public void b()
        {
          SpamController.f(SpamController.this).d("X Button");
          SpamController.b(SpamController.this, true);
        }
      });
    this.z.a(this.r);
    this.m.a(this.z, false);
    this.j.a(this.r.getParticipantName(), null);
  }

  private void w()
  {
    if (this.z != null)
      this.m.a(this.z.getMode(), true);
  }

  private boolean x()
  {
    return (this.z != null) && (this.m.a(ConversationAlertView.a.r));
  }

  private void y()
  {
    boolean bool = true;
    l.a locala = u.b();
    int i1 = R.string.dialog_3901_body;
    Object[] arrayOfObject = new Object[bool];
    arrayOfObject[0] = this.r.getParticipantName();
    a.a locala1 = locala.b(i1, arrayOfObject).a(new m.a()
    {
      public void onDialogAction(com.viber.common.dialogs.m paramAnonymousm, int paramAnonymousInt)
      {
        if (paramAnonymousm.a(DialogCode.D3901))
        {
          if (paramAnonymousInt == -1)
            SpamController.c(SpamController.this, false);
        }
        else
          return;
        if (paramAnonymousInt == -2)
        {
          SpamController.b(SpamController.this, true);
          return;
        }
        SpamController.a(SpamController.this, true);
      }
    });
    if (!this.n);
    while (true)
    {
      locala1.b(bool).b(this.l);
      return;
      bool = false;
    }
  }

  private void z()
  {
    b(false);
  }

  public Parcelable a()
  {
    return new SaveState(this.u);
  }

  public DialogCode a(com.viber.voip.messages.conversation.aa paramaa)
  {
    com.viber.voip.model.entity.m localm = a(paramaa.aR(), paramaa.u(), paramaa.d());
    if ((!ao.f()) && (!paramaa.aS()) && (!paramaa.O()) && (!paramaa.U()) && (!paramaa.aa()) && (paramaa.ao()) && (localm != null) && (0L == localm.i()) && (!localm.q()) && (!cg.c(localm.getNumber())) && (this.r != null));
    DialogCode localDialogCode;
    for (int i1 = 1; ; i1 = 0)
    {
      localDialogCode = DialogCode.UNKNOWN;
      if (i1 == 0)
        break label172;
      if ((!paramaa.aL()) && (!paramaa.aE()))
        break;
      if ((!this.r.isNewSpamBanner()) || (!this.r.showSpamBanner()) || (this.r.showAddNewParticipantNumberBanner()))
        break label172;
      return DialogCode.D1400;
    }
    if (this.r.showUrlSpamWarning())
      return DialogCode.D1400b;
    label172: return localDialogCode;
  }

  public void a(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SaveState))
      this.u = ((SaveState)paramParcelable).getCommonCommunitiesRequestSeq();
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, com.viber.voip.messages.conversation.adapter.k paramk, boolean paramBoolean)
  {
    boolean bool1 = true;
    if (ao.f())
      return;
    long l1;
    boolean bool2;
    if (this.r != null)
    {
      l1 = this.r.getId();
      bool2 = d(paramConversationItemLoaderEntity);
      this.q = paramk;
      this.r = paramConversationItemLoaderEntity;
      if (paramConversationItemLoaderEntity != null)
        break label139;
    }
    label139: for (com.viber.voip.model.entity.m localm = null; ; localm = a(paramConversationItemLoaderEntity.isGroupBehavior(), paramConversationItemLoaderEntity.getCreatorParticipantInfoId(), paramConversationItemLoaderEntity.getParticipantMemberId()))
    {
      this.s = localm;
      if (bool2)
      {
        T();
        this.y = null;
        I();
        this.x = null;
      }
      t();
      if ((c(paramConversationItemLoaderEntity)) && (this.s != null) && (!this.s.isOwner()))
        break label159;
      T();
      I();
      this.r = null;
      this.s = null;
      t();
      return;
      l1 = -1L;
      break;
    }
    label159: int i1;
    label175: int i2;
    label239: int i3;
    label266: int i4;
    label287: int i5;
    label315: int i6;
    label339: boolean bool4;
    label359: boolean bool5;
    if (this.s.i() == 0L)
    {
      i1 = bool1;
      boolean bool3 = this.t;
      this.t = paramBoolean;
      if (this.y != null)
        this.y.a(this.t);
      if ((l1 <= 0L) || ((l1 == this.r.getId()) && (bool3 == this.t)))
        break label447;
      i2 = bool1;
      if ((!d.r.j.d()) && (!paramConversationItemLoaderEntity.hasBusinessInboxOverlay()) && (!paramConversationItemLoaderEntity.isAnonymous()))
        break label453;
      i3 = bool1;
      if ((i3 == 0) || (i1 == 0) || (!K()))
        break label459;
      i4 = bool1;
      if ((i4 != 0) || (paramConversationItemLoaderEntity.hasBusinessInboxOverlay()) || (i1 == 0) || (!L()))
        break label465;
      i5 = bool1;
      J();
      if ((!paramConversationItemLoaderEntity.hasBusinessInboxOverlay()) || (!com.viber.voip.i.c.d.a.e()))
        break label471;
      i6 = bool1;
      q localq = this.c;
      if ((i4 == 0) || (i6 != 0))
        break label477;
      bool4 = bool1;
      localq.c(bool4);
      bool5 = j();
      if (i5 == 0)
        break label618;
      H();
    }
    while (true)
    {
      if ((i2 != 0) && (bool1))
        M();
      if (paramConversationItemLoaderEntity.hasBusinessInboxOverlay())
      {
        if (bool5)
          T();
        if (com.viber.voip.i.c.d.a.e())
        {
          boolean bool7 = x();
          if ((i4 != 0) && (!bool7))
          {
            v();
            return;
            i1 = 0;
            break label175;
            label447: i2 = 0;
            break label239;
            label453: i3 = 0;
            break label266;
            label459: i4 = 0;
            break label287;
            label465: i5 = 0;
            break label315;
            label471: i6 = 0;
            break label339;
            label477: bool4 = false;
            break label359;
          }
          if ((i4 != 0) || (!bool7))
            break;
          w();
          return;
        }
        com.viber.common.dialogs.m localm1 = com.viber.common.dialogs.z.c(this.l.getFragmentManager(), DialogCode.D424b);
        if ((i4 != 0) && (localm1 == null))
        {
          u();
          return;
        }
        if ((i4 != 0) || (localm1 == null))
          break;
        localm1.dismiss();
        return;
      }
      boolean bool6;
      if ((!bool5) && (i4 != 0) && (!this.r.showInviteBanner()))
      {
        S();
        s();
        bool6 = bool5;
      }
      while ((i2 != 0) && (bool6))
      {
        U();
        return;
        if ((bool5) && (i4 == 0))
        {
          T();
          bool6 = false;
        }
        else
        {
          bool6 = bool5;
        }
      }
      break;
      label618: bool1 = false;
    }
  }

  public void a(b paramb)
  {
    this.v.add(paramb);
  }

  public void a(boolean paramBoolean)
  {
    if (this.m.a(ConversationAlertView.a.c))
      this.x.a(this.r, paramBoolean);
    if ((this.m.a(ConversationAlertView.a.r)) && (this.z != null))
      this.z.a(paramBoolean);
  }

  public void b()
  {
    this.o.a(this.p);
  }

  public void b(b paramb)
  {
    this.v.remove(paramb);
  }

  public void c()
  {
    this.o.b(this.p);
  }

  public void d()
  {
    this.k.unregister(this);
  }

  public boolean e()
  {
    if (this.r != null)
      this.r.isNewSpamBanner();
    return ((this.m != null) && (this.m.a(ConversationAlertView.a.c))) || ((this.w != null) && (this.w.d()));
  }

  public void f()
  {
    this.f.a(this.r.getId(), false, new cd(this));
  }

  public void g()
  {
    if (!this.t)
    {
      c(false);
      return;
    }
    C();
  }

  public void h()
  {
    G();
  }

  public void i()
  {
    A();
  }

  boolean j()
  {
    return (this.y != null) && (this.y.d());
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onCommonCommunitiesReceived(com.viber.voip.messages.a.c.d paramd)
  {
    if ((this.u != paramd.a) || (!Z()))
      return;
    com.viber.voip.messages.conversation.ui.spam.b.a locala = (com.viber.voip.messages.conversation.ui.spam.b.a)this.y;
    if ((paramd.b == 0) && (!paramd.c.isEmpty()))
    {
      locala.a(paramd.c);
      return;
    }
    locala.a();
  }

  private static class SaveState
    implements Parcelable
  {
    public static final Parcelable.Creator<SaveState> CREATOR = new Parcelable.Creator()
    {
      public SpamController.SaveState a(Parcel paramAnonymousParcel)
      {
        return new SpamController.SaveState(paramAnonymousParcel);
      }

      public SpamController.SaveState[] a(int paramAnonymousInt)
      {
        return new SpamController.SaveState[paramAnonymousInt];
      }
    };
    private int mCommonCommunitiesRequestSeq;

    public SaveState(int paramInt)
    {
      this.mCommonCommunitiesRequestSeq = paramInt;
    }

    protected SaveState(Parcel paramParcel)
    {
      this.mCommonCommunitiesRequestSeq = paramParcel.readInt();
    }

    public int describeContents()
    {
      return 0;
    }

    public int getCommonCommunitiesRequestSeq()
    {
      return this.mCommonCommunitiesRequestSeq;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mCommonCommunitiesRequestSeq);
    }
  }

  private class a extends m.a
  {
    private a()
    {
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D3901))
      {
        if (paramInt == -1)
          SpamController.c(SpamController.this, true);
      }
      else
        return;
      if (paramInt == -2)
      {
        SpamController.b(SpamController.this);
        return;
      }
      SpamController.a(SpamController.this, true);
    }
  }

  public static abstract interface b
  {
    public abstract void b();

    public abstract void c();

    public abstract void d();
  }

  private class c
    implements k.b
  {
    private View b;
    private View c;
    private ViberButton d;
    private boolean e;
    private LayoutInflater f;

    public c(LayoutInflater arg2)
    {
      Object localObject;
      this.f = localObject;
    }

    public View a()
    {
      return this.b;
    }

    public View a(ViewGroup paramViewGroup, View paramView)
    {
      if (paramView == null);
      for (this.b = this.f.inflate(R.layout.msg_block_unknown_number, paramViewGroup, false); ; this.b = paramView)
      {
        this.c = this.b.findViewById(R.id.block_banner_content);
        this.d = ((ViberButton)this.c.findViewById(R.id.add_to_contacts));
        this.d.setOnClickListener(new ch(this));
        return this.b;
      }
    }

    public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, at paramat)
    {
      if (this.d != null)
        this.d.setBackgroundColor(paramat.e());
    }

    public k.b.a b()
    {
      return k.b.a.b;
    }

    public int c()
    {
      return l.a(this);
    }

    public boolean d()
    {
      return this.e;
    }

    void e()
    {
      this.e = true;
      if (SpamController.j(SpamController.this) != null)
        SpamController.j(SpamController.this).a(this);
    }

    void f()
    {
      this.e = false;
      if (SpamController.j(SpamController.this) != null)
        SpamController.j(SpamController.this).b(this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.SpamController
 * JD-Core Version:    0.6.2
 */
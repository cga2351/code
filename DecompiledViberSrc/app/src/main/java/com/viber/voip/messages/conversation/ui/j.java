package com.viber.voip.messages.conversation.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.LongSparseArray;
import android.text.ClipboardManager;
import android.text.TextUtils;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.OnlineContactInfo;
import com.viber.jni.dialer.DialerController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.analytics.story.b.a.h.a.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.a.d.c;
import com.viber.voip.messages.a.d.e;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.ae;
import com.viber.voip.messages.conversation.ui.b.v;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.d.c;
import com.viber.voip.messages.forward.GroupReferralForwardInfo;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.action.BlockPublicGroupAction;
import com.viber.voip.messages.orm.entity.json.action.CopyAction;
import com.viber.voip.messages.ui.MessageComposerView;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInitiationId;
import com.viber.voip.registration.changephonenumber.d.a;
import com.viber.voip.stickers.i;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.f;
import com.viber.voip.ui.dialogs.o;
import com.viber.voip.user.OnlineUserActivityHelper;
import com.viber.voip.user.OnlineUserActivityHelper.UiOnlineUserInfoDelegate;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.bn;
import com.viber.voip.util.ViberActionRunner.c;
import com.viber.voip.util.ViberActionRunner.o;
import com.viber.voip.util.ViberActionRunner.u;
import com.viber.voip.util.at;
import com.viber.voip.util.at.a;
import com.viber.voip.util.cd;
import com.viber.voip.util.cj;
import com.viber.voip.util.cj.a;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;
import com.viber.voip.util.dr;
import com.viber.voip.util.dr.a;
import com.viber.voip.util.x;
import dagger.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.onepf.oms.util.Utils;

public class j
{
  private static final Logger a = ViberEnv.getLogger();
  private final com.viber.voip.messages.controller.cl b;
  private final a<h> c;
  private aq d;
  private final Resources e;
  private final ConversationFragment f;
  private final ac g;
  private final b h;
  private final bm i;
  private ConversationItemLoaderEntity j;
  private int k;
  private bg l;
  private final Handler m = av.a(av.e.a);
  private final v n;
  private final EventBus o;
  private final cj.a p = new cj.a()
  {
    public void connectivityChanged(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      ConversationFragment localConversationFragment;
      if (j.a(j.this) != null)
      {
        localConversationFragment = j.a(j.this);
        if (-1 == paramAnonymousInt2)
          break label33;
      }
      label33: for (boolean bool = true; ; bool = false)
      {
        localConversationFragment.b(bool);
        return;
      }
    }
  };
  private final OnlineUserActivityHelper.UiOnlineUserInfoDelegate q = new OnlineUserActivityHelper.UiOnlineUserInfoDelegate()
  {
    public void onOnlineStatusActivityReady(int paramAnonymousInt, OnlineContactInfo[] paramAnonymousArrayOfOnlineContactInfo)
    {
      if ((j.b(j.this) == null) || (j.b(j.this).isGroupBehavior()) || (j.b(j.this).isAnonymous()) || (j.b(j.this).getParticipantMemberId() == null))
        return;
      String str1;
      label66: OnlineContactInfo localOnlineContactInfo;
      if ((paramAnonymousArrayOfOnlineContactInfo != null) && (paramAnonymousArrayOfOnlineContactInfo.length > 0))
      {
        str1 = paramAnonymousArrayOfOnlineContactInfo[0].memberId;
        if (!j.b(j.this).getParticipantMemberId().equals(str1))
          break label121;
        localOnlineContactInfo = paramAnonymousArrayOfOnlineContactInfo[0];
      }
      label121: boolean bool;
      do
      {
        do
        {
          final String str2 = dg.a(localOnlineContactInfo);
          av.a(av.e.a).post(new Runnable()
          {
            public void run()
            {
              if (TextUtils.isEmpty(str2));
              for (String str = null; ; str = str2)
              {
                j.c(j.this).a(str);
                return;
              }
            }
          });
          return;
          str1 = null;
          break label66;
          if (paramAnonymousInt == 0)
            break;
          localOnlineContactInfo = null;
        }
        while (str1 == null);
        bool = j.b(j.this).getParticipantMemberId().equals(str1);
        localOnlineContactInfo = null;
      }
      while (bool);
    }
  };

  public j(ConversationFragment paramConversationFragment, d.a parama, com.viber.voip.contacts.c.d.m paramm, v paramv, ac paramac, com.viber.voip.messages.controller.cl paramcl, a<h> parama1, EventBus paramEventBus)
  {
    this.f = paramConversationFragment;
    this.g = paramac;
    this.b = paramcl;
    this.c = parama1;
    this.o = paramEventBus;
    this.e = ViberApplication.getApplication().getResources();
    this.h = ViberApplication.getInstance().getParticipantManager();
    this.i = new bm(this.f.getContext(), parama, paramm);
    i.a().p();
    cj.a(ViberApplication.getApplication()).a(this.p);
    this.n = paramv;
  }

  private void a(long paramLong, aa paramaa)
  {
    if (this.j == null);
    boolean bool1;
    do
    {
      return;
      if (paramaa != null)
      {
        boolean bool2 = paramaa.ak();
        bool1 = false;
        if (!bool2);
      }
      else
      {
        bool1 = a(c.c().b(paramLong));
      }
    }
    while (bool1);
    if (paramaa != null);
    for (int i1 = paramaa.bG(); ; i1 = 3)
    {
      ViberActionRunner.o.a(this.f.getContext(), this.j.getConversationType(), this.j.getGroupRole(), paramLong, i1);
      return;
    }
  }

  public static void a(Context paramContext, String paramString)
  {
    ViberActionRunner.c.b(paramContext, paramString, "Manual", "In-Message");
  }

  private void a(String paramString)
  {
    FragmentActivity localFragmentActivity = m();
    if (localFragmentActivity == null)
      return;
    ((ClipboardManager)localFragmentActivity.getSystemService("clipboard")).setText(paramString);
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Member paramMember)
  {
    boolean bool = true;
    h.a.a locala1 = com.viber.voip.analytics.story.b.a.h.a.i();
    String[] arrayOfString = new String[bool];
    arrayOfString[0] = paramMember.getPhoneNumber();
    h.a.a locala2 = locala1.a(arrayOfString).a(paramBoolean2, paramBoolean1).b(paramBoolean2);
    h.a.a locala3;
    if (!paramBoolean2)
    {
      locala3 = locala2.a(bool);
      if (!paramBoolean3)
        break label94;
      locala3.a("In-Chat Call Log");
    }
    while (true)
    {
      ((h)this.c.get()).b(locala3.a());
      return;
      bool = false;
      break;
      label94: if (paramBoolean2)
        locala3.a("Chat Drop Down");
      else
        locala3.a(this.j);
    }
  }

  private boolean a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString)
  {
    String str = paramConversationItemLoaderEntity.getParticipantMemberId();
    if (str.equals(paramString))
      return true;
    return str.equals(cd.d(paramString));
  }

  public static void b(Context paramContext, String paramString)
  {
    dr.a(paramString, new dr.a()
    {
      public void onCheckStatus(boolean paramAnonymousBoolean, int paramAnonymousInt, ParticipantSelector.Participant paramAnonymousParticipant, com.viber.voip.model.entity.g paramAnonymousg)
      {
        switch (paramAnonymousInt)
        {
        case 1:
        case 3:
        default:
          String str = x.a(ViberApplication.getApplication(), this.b, this.b);
          com.viber.voip.ui.dialogs.k.a(this.b).b(-1, new Object[] { str }).d();
          return;
        case 0:
          com.viber.voip.model.j localj = paramAnonymousg.n();
          this.a.startActivity(com.viber.voip.messages.m.a(localj.a(), this.b, paramAnonymousg.k(), false, false, false, false));
          return;
        case 4:
          ad.a().d();
          return;
        case 2:
        }
        f.d().d();
      }
    });
  }

  private void b(CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (this.l == null);
    while (((this.l.a()) || (!this.l.b())) && (paramBoolean))
      return;
    this.m.post(new k(this, paramCharSequence, paramBoolean));
  }

  private FragmentActivity m()
  {
    return this.f.getActivity();
  }

  private boolean n()
  {
    return (this.j != null) && (this.j.isPublicGroupBehavior());
  }

  private void o()
  {
    a();
    Iterator localIterator = this.b.b().entrySet().iterator();
    while (localIterator.hasNext())
    {
      cl localcl = (cl)((Map.Entry)localIterator.next()).getValue();
      onUserIsTyping(new d.e(localcl.a(), localcl.b(), true));
    }
    LongSparseArray localLongSparseArray = this.b.a();
    int i1 = localLongSparseArray.size();
    int i2 = 0;
    if (i2 < i1)
    {
      long l1 = localLongSparseArray.keyAt(i2);
      Map localMap = (Map)localLongSparseArray.valueAt(i2);
      Collection localCollection = localMap.values();
      if (!localMap.isEmpty());
      for (boolean bool = true; ; bool = false)
      {
        onGroupUserIsTyping(new d.c(l1, localCollection, bool));
        i2++;
        break;
      }
    }
  }

  public void a()
  {
    this.n.a(null, false);
  }

  public void a(long paramLong)
  {
    a(paramLong, null);
  }

  public void a(Pin paramPin)
  {
    this.d.d.a(paramPin);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    this.j = paramConversationItemLoaderEntity;
    this.f.k();
    if (paramBoolean)
      switch (this.j.getConversationType())
      {
      case 1:
      default:
      case 2:
      case 3:
      case 0:
      }
    while (true)
    {
      o();
      return;
      if ((!this.j.isOneToOneWithPublicAccount()) && (!this.j.isSystemConversation()) && (!this.j.isAnonymous()))
      {
        this.k = ((int)(System.currentTimeMillis() / 1000L));
        ViberApplication.getInstance().getEngine(false).getOnlineUserActivityHelper().obtainInfo(this.j.getParticipantMemberId(), this.k, this.q);
      }
    }
  }

  public void a(aa paramaa)
  {
    a(paramaa.u(), paramaa);
  }

  public void a(aa paramaa, int paramInt1, int paramInt2)
  {
    ViberActionRunner.bn.a(m(), paramaa, paramInt1, paramInt2);
  }

  public void a(aq paramaq)
  {
    this.d = paramaq;
  }

  public void a(bg parambg)
  {
    this.l = parambg;
  }

  public void a(Collection<aa> paramCollection)
  {
    FragmentActivity localFragmentActivity = m();
    if (localFragmentActivity == null)
      return;
    Intent localIntent = ViberActionRunner.u.a(new ArrayList(paramCollection));
    boolean bool = com.viber.voip.messages.m.c(this.j);
    if (!ViberApplication.isTablet(localFragmentActivity))
      localIntent.putExtra("back_intent", m().getIntent());
    Iterator localIterator = paramCollection.iterator();
    int i1 = 0;
    aa localaa;
    if (localIterator.hasNext())
    {
      localaa = (aa)localIterator.next();
      if ((localaa.aE()) && (!localaa.aF()) && (!localaa.aL()))
        localIntent.putExtra("forward_formatted_message_extra", true);
      if (localaa.aZ())
      {
        localIntent.putExtra("show_secret_chats_extra", false);
        localIntent.putExtra("show_broadcast_list_extra", false);
      }
      if ((!bool) || (i1 != 0) || (localaa.bx().getGroupReferralInfo() != null))
        break label280;
    }
    label280: for (int i2 = 1; ; i2 = i1)
    {
      if ((n()) && ((this.f instanceof com.viber.voip.messages.conversation.publicaccount.g)))
        ((com.viber.voip.messages.conversation.publicaccount.g)this.f).b(localaa, null);
      i1 = i2;
      break;
      if ((bool) && (i1 != 0))
      {
        Bundle localBundle = new Bundle(1);
        localBundle.putParcelable("group_referral_extra_info", new GroupReferralForwardInfo(this.j.getGroupId(), this.j.getGroupRole(), this.j.getGroupName()));
        ViberActionRunner.u.a(localIntent, localBundle);
      }
      this.f.startActivity(localIntent);
      return;
    }
  }

  public void a(List<Long> paramList, boolean paramBoolean)
  {
    this.f.a(paramList, paramBoolean);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.j == null)
      return;
    int i1;
    label32: Member localMember;
    if ((this.j.isGroupBehavior()) && (this.g.getCount() == 2))
    {
      i1 = 0;
      localMember = null;
      if (i1 < 2)
      {
        ae localae = this.g.e(i1);
        if (!localae.isOwner())
          localMember = Member.from(localae);
      }
      else
      {
        label67: if (localMember == null)
          break label217;
        if (!Utils.uiThread())
          break label219;
        dj.c(this.d.d);
      }
    }
    CallHandler localCallHandler;
    while (true)
    {
      Engine localEngine = ViberApplication.getInstance().getEngine(true);
      DialerController localDialerController = localEngine.getDialerController();
      localCallHandler = localEngine.getCallHandler();
      this.f.ae();
      localCallHandler.setNextCallIsFromSecretConversation(this.j.isSecret());
      CallInitiationId.noteNextCallInitiationAttemptId();
      a(paramBoolean1, paramBoolean2, paramBoolean3, localMember);
      if (!paramBoolean2)
        break label238;
      localDialerController.handleDialViberOut(localMember.getPhoneNumber());
      return;
      i1++;
      break label32;
      boolean bool = this.j.isConversation1on1();
      localMember = null;
      if (!bool)
        break label67;
      localMember = new Member(this.j.getParticipantMemberId(), this.j.getNumber(), null, this.j.getParticipantName(), null);
      break label67;
      label217: break;
      label219: this.m.post(new Runnable()
      {
        public void run()
        {
          dj.c(j.d(j.this).d);
        }
      });
    }
    label238: localCallHandler.handleDialViber(localMember, paramBoolean1);
  }

  boolean a(com.viber.voip.model.entity.m paramm)
  {
    return this.i.a(paramm, this.j);
  }

  public long b()
  {
    if (this.j != null)
      return this.j.getId();
    return -1L;
  }

  public void b(aa paramaa)
  {
    FormattedMessage localFormattedMessage = paramaa.L();
    if ((localFormattedMessage != null) && (localFormattedMessage.canDoAction(ActionType.BLOCK_PUBLIC_GROUP)))
    {
      FragmentActivity localFragmentActivity = m();
      if (localFragmentActivity == null)
        return;
      BlockPublicGroupAction localBlockPublicGroupAction = (BlockPublicGroupAction)localFormattedMessage.getAction(ActionType.BLOCK_PUBLIC_GROUP);
      if (localBlockPublicGroupAction != null)
      {
        ViberActionRunner.a(localFragmentActivity, localBlockPublicGroupAction.getGroupId());
        return;
      }
    }
    if ((paramaa.aG()) && (paramaa.ap()))
    {
      FileInfo localFileInfo = paramaa.bz();
      if (at.b(localFileInfo.getFileSize()) == at.a.d)
      {
        com.viber.common.dialogs.h.a locala = o.k();
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localFileInfo.getFileName();
        locala.b(-1, arrayOfObject).d();
        return;
      }
    }
    a(Collections.singleton(paramaa));
  }

  public int c()
  {
    if (this.j != null)
      return this.j.getConversationType();
    return -1;
  }

  public void c(aa paramaa)
  {
    if (paramaa.aL())
    {
      FormattedMessage localFormattedMessage2 = paramaa.L();
      if (localFormattedMessage2 != null);
      for (String str2 = localFormattedMessage2.getPreviewText(); ; str2 = "")
      {
        a(str2);
        return;
      }
    }
    if (paramaa.aE())
    {
      FormattedMessage localFormattedMessage1 = paramaa.L();
      if (localFormattedMessage1 != null)
      {
        CopyAction localCopyAction = (CopyAction)localFormattedMessage1.getAction(ActionType.COPY);
        if (localCopyAction != null);
        for (String str1 = localCopyAction.getCopyString(); ; str1 = "")
        {
          a(str1);
          return;
        }
      }
      a("");
      return;
    }
    if (paramaa.al())
    {
      a(paramaa.h() + "\n\n" + paramaa.i());
      return;
    }
    a(paramaa.h());
  }

  public String d()
  {
    if (this.j != null)
      return this.j.getParticipantMemberId();
    return null;
  }

  public String e()
  {
    if (this.j != null)
      return this.j.getNumber();
    return null;
  }

  public boolean f()
  {
    return this.j != null;
  }

  public boolean g()
  {
    return (this.j != null) && (this.j.isSecret());
  }

  public void h()
  {
    o();
    if (!this.o.isRegistered(this))
      this.o.register(this);
  }

  public void i()
  {
    this.o.unregister(this);
  }

  public void j()
  {
    cj.a(ViberApplication.getApplication()).b(this.p);
    ViberApplication.getInstance().getEngine(false).getOnlineUserActivityHelper().removeListener(this.q);
    i.a().q();
    this.i.a();
  }

  public void k()
  {
    FragmentActivity localFragmentActivity = m();
    if (localFragmentActivity != null)
      if (!ViberApplication.isTablet(localFragmentActivity))
        break label33;
    label33: for (String str = "com.viber.voip.action.MORE_DIALOG"; ; str = "com.viber.voip.action.MORE")
    {
      localFragmentActivity.startActivity(new Intent(str));
      return;
    }
  }

  public void l()
  {
    if (this.j == null)
      return;
    this.f.startActivity(com.viber.voip.messages.m.a(this.j.getParticipantMemberId(), this.j.getNumber(), dg.b(this.j), true, false, false, false));
  }

  @Subscribe
  public void onGroupUserIsTyping(d.c paramc)
  {
    if ((this.j == null) || (paramc.a != this.j.getGroupId()))
      return;
    b(this.h.a(this.e, paramc.b, this.j.getConversationType(), this.j.getGroupRole(), 0), paramc.c);
  }

  @Subscribe
  public void onUserIsTyping(d.e parame)
  {
    if ((this.j == null) || (this.j.getNativeChatType() != parame.b) || (this.j.getParticipantMemberId() == null) || (!this.j.isConversation1on1()) || (!a(this.j, parame.a.a())))
      return;
    b(this.h.a(this.e, parame.a, this.j.getConversationType(), this.j.getGroupRole(), 0), parame.c);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.j
 * JD-Core Version:    0.6.2
 */
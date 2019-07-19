package com.viber.voip.api.scheme;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.api.scheme.action.OpenChatExtensionAction;
import com.viber.voip.api.scheme.action.b.a;
import com.viber.voip.api.scheme.action.r.a;
import com.viber.voip.api.scheme.action.s;
import com.viber.voip.api.scheme.action.s.a;
import com.viber.voip.api.scheme.action.y;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.flatbuffers.model.msginfo.GroupReferralInfo;
import com.viber.voip.i.c.f;
import com.viber.voip.i.c.l;
import com.viber.voip.i.f;
import com.viber.voip.invitelinks.CommunityFollowerData;
import com.viber.voip.invitelinks.d.b;
import com.viber.voip.invitelinks.n;
import com.viber.voip.invitelinks.q;
import com.viber.voip.invitelinks.q.a;
import com.viber.voip.market.ExplorePublicGroupsActivity;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.a.c.b;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.ai.e;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.bs.e;
import com.viber.voip.messages.controller.bs.e.a;
import com.viber.voip.messages.controller.bs.f;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationData;
import com.viber.voip.messages.conversation.ui.CommunityIntroActivity;
import com.viber.voip.messages.m;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.ao;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.ci;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.ab;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.ViberActionRunner.bb;
import com.viber.voip.util.ViberActionRunner.d;
import com.viber.voip.util.ViberActionRunner.u;
import com.viber.voip.util.at;
import com.viber.voip.util.ce;
import com.viber.voip.util.cj;
import com.viber.voip.util.dk;
import com.viber.voip.viberout.ui.TermsAndConditionsActivity.a;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public enum e
  implements g
{
  public static final h w = new h()
  {
    public g[] a()
    {
      return e.values();
    }
  };
  private static final Logger x = ViberEnv.getLogger();
  private static final String[] y = { "ptt", "menu", "keyboard", "stickers", "emoticons" };
  private final String A;
  private final String z;

  static
  {
    e[] arrayOfe = new e[22];
    arrayOfe[0] = a;
    arrayOfe[1] = b;
    arrayOfe[2] = c;
    arrayOfe[3] = d;
    arrayOfe[4] = e;
    arrayOfe[5] = f;
    arrayOfe[6] = g;
    arrayOfe[7] = h;
    arrayOfe[8] = i;
    arrayOfe[9] = j;
    arrayOfe[10] = k;
    arrayOfe[11] = l;
    arrayOfe[12] = m;
    arrayOfe[13] = n;
    arrayOfe[14] = o;
    arrayOfe[15] = p;
    arrayOfe[16] = q;
    arrayOfe[17] = r;
    arrayOfe[18] = s;
    arrayOfe[19] = t;
    arrayOfe[20] = u;
    arrayOfe[21] = v;
  }

  private e(String paramString1, String paramString2)
  {
    this.z = paramString1;
    this.A = paramString2;
  }

  private static com.viber.voip.api.scheme.action.c b(final Context paramContext, String paramString, n paramn, ActivationController paramActivationController)
  {
    return new com.viber.voip.api.scheme.action.b(paramString, paramn, paramn.c(), new b.a()
    {
      public void a(long paramAnonymousLong, int paramAnonymousInt)
      {
        if (this.a.getStep() != 8)
          return;
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 0:
        case 4:
          Intent localIntent = m.a(paramAnonymousLong, true, false);
          y.a(paramContext, localIntent);
          return;
        case 1:
        case 2:
        case 3:
          y.a(paramContext, ViberActionRunner.ab.a(paramContext));
          return;
        case 7:
          com.viber.voip.ui.dialogs.h.a().d();
          return;
        case 6:
          com.viber.voip.ui.dialogs.l.i().d();
          return;
        case 5:
        }
        com.viber.voip.ui.dialogs.l.h().d();
      }
    });
  }

  private static com.viber.voip.api.scheme.action.c b(final Context paramContext, String paramString1, String paramString2, final Uri paramUri, final String paramString3, boolean paramBoolean)
  {
    return new com.viber.voip.api.scheme.action.r(paramString1, paramString2, new r.a()
    {
      public void a()
      {
        y.a(paramContext, ViberActionRunner.ab.a(paramContext));
      }

      public void a(boolean paramAnonymousBoolean, PublicAccount paramAnonymousPublicAccount)
      {
        if (paramAnonymousPublicAccount == null)
        {
          a();
          return;
        }
        bs localbs = new bs(ViberApplication.getApplication());
        String str1 = paramAnonymousPublicAccount.getPublicAccountId();
        com.viber.voip.model.entity.h localh = localbs.a(0, new Member(str1, str1), 0L, paramAnonymousPublicAccount, 0, true, false, 0);
        if (localh != null)
        {
          Intent localIntent = m.a(str1, str1, paramAnonymousPublicAccount.getName(), false, false, false, this.a);
          if (paramString3 != null)
          {
            localIntent.putExtra("forward _draft", paramString3);
            ViberApplication.getInstance().getMessagesManager().c().a(localh.getId(), localh.j(), paramString3);
          }
          String str2 = paramUri.getQueryParameter("context");
          ViberApplication.getInstance().getMessagesManager().h().a(1, localh.getId(), str2, str1);
          y.a(paramContext, localIntent);
          return;
        }
        a();
      }
    });
  }

  private static com.viber.voip.api.scheme.action.c b(final Context paramContext, String paramString, final boolean paramBoolean, final GroupReferralInfo paramGroupReferralInfo, com.viber.voip.invitelinks.d paramd, ActivationController paramActivationController)
  {
    return new com.viber.voip.api.scheme.action.a(paramString, paramd, paramd.c(), new com.viber.voip.api.scheme.action.a.a()
    {
      public void a(d.b paramAnonymousb)
      {
        if (this.a.getStep() != 8)
          return;
        switch (paramAnonymousb.f)
        {
        default:
          return;
        case 0:
          String str1 = UserManager.from(paramContext).getUserData().getViberName();
          CommunityFollowerData localCommunityFollowerData = new com.viber.voip.invitelinks.c().a(paramAnonymousb, str1, paramGroupReferralInfo);
          if (paramGroupReferralInfo != null);
          for (String str2 = "Referral"; ; str2 = "Invite Link")
          {
            com.viber.voip.analytics.g.a().c().g().a(paramAnonymousb.a, str2);
            if (!paramBoolean)
              break;
            Intent localIntent = ViberActionRunner.ab.a(paramContext.getApplicationContext(), localCommunityFollowerData);
            localIntent.addFlags(268468224);
            y.a(paramContext, localIntent);
            return;
          }
          com.viber.voip.ui.dialogs.l.a(localCommunityFollowerData, -1).d();
          return;
        case 5:
        case 6:
          if (paramGroupReferralInfo != null)
          {
            q localq = ViberApplication.getInstance().getAppComponent().b();
            localq.a(paramGroupReferralInfo, e.a(localq, paramGroupReferralInfo.getGroupId()));
            return;
          }
          new com.viber.voip.invitelinks.ad(ViberApplication.getApplication(), ab.b(), av.a(av.e.d), paramAnonymousb.a, 2).h();
          return;
        case 1:
        case 2:
        case 3:
          if (paramGroupReferralInfo != null)
          {
            com.viber.voip.ui.dialogs.k.n().d();
            return;
          }
          y.a(paramContext, ViberActionRunner.ab.a(paramContext));
          return;
        case 7:
          com.viber.voip.ui.dialogs.l.k().d();
          return;
        case 4:
        }
        com.viber.voip.ui.dialogs.l.h().d();
      }
    });
  }

  private static com.viber.voip.api.scheme.action.c b(Uri paramUri, ActivationController paramActivationController, String paramString)
  {
    if (paramActivationController.getStep() != 8)
    {
      paramActivationController.resumeActivationWithDeepLink(paramUri);
      return com.viber.voip.api.scheme.action.c.a;
    }
    return null;
  }

  private static s b(final Context paramContext, final String paramString1, final Uri paramUri, final String paramString2, final Bundle paramBundle)
  {
    return new s(paramString1, new b(paramContext, paramUri)
    {
      protected void a(PublicAccount paramAnonymousPublicAccount)
      {
        String str = paramUri.getQueryParameter("message");
        try
        {
          int m = Integer.parseInt(str);
          i = m;
          if (i > 0)
          {
            e.a(paramContext, paramAnonymousPublicAccount, i);
            return;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          while (true)
            int i = -1;
          com.viber.voip.model.entity.h localh = ab.b().d(paramString1);
          int j = 0;
          if (localh != null)
          {
            int k = localh.p();
            j = 0;
            if (3 != k)
              j = 1;
            if ((paramString2 != null) && (j != 0))
              ViberApplication.getInstance().getMessagesManager().c().a(localh.getId(), localh.j(), paramString2);
          }
          Intent localIntent = ViberActionRunner.aq.a(paramContext, true, paramAnonymousPublicAccount.hasPublicChat(), new PublicGroupConversationData(paramAnonymousPublicAccount));
          localIntent.putExtra("go_up", true);
          if (j == 0)
            paramBundle.remove("forward _draft");
          localIntent.putExtras(paramBundle);
          y.a(paramContext, localIntent);
        }
      }
    });
  }

  private static s b(Context paramContext, String paramString, Uri paramUri, boolean paramBoolean)
  {
    return new s(paramString, new d(paramContext, paramUri, paramBoolean));
  }

  private static q.a b(q paramq, long paramLong)
  {
    return new q.a()
    {
      private final EventBus c = com.viber.voip.h.a.b();

      public void a()
      {
        if (!this.c.isRegistered(this))
          this.c.register(this);
        com.viber.voip.ui.dialogs.ad.b().b(true).a(false).a(new ViberDialogHandlers.ci(this.a)).d();
      }

      public void a(com.viber.voip.model.entity.h paramAnonymoush)
      {
        Intent localIntent = m.a(paramAnonymoush.getId(), paramAnonymoush.j(), paramAnonymoush.R(), paramAnonymoush.aj(), paramAnonymoush.ao(), false);
        ViberActionRunner.b(ViberApplication.getApplication(), localIntent);
      }

      public void a(com.viber.voip.model.entity.h paramAnonymoush, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        Intent localIntent = m.a(paramAnonymoush.getId(), paramAnonymousLong1, paramAnonymousLong2, 2000L, paramAnonymoush.k(), "", "", paramAnonymoush.j(), "", "", paramAnonymoush.o(), -1, false, false, paramAnonymoush.R(), paramAnonymoush.aj(), paramAnonymoush.ao()).putExtra("extra_search_message", true);
        ViberActionRunner.b(ViberApplication.getApplication(), localIntent);
      }

      public void a(String paramAnonymousString, GroupReferralInfo paramAnonymousGroupReferralInfo)
      {
        com.viber.voip.ui.dialogs.k.n().d();
      }

      public void b()
      {
        this.c.unregister(this);
        com.viber.common.dialogs.z.a(ViberApplication.getApplication(), DialogCode.D_PROGRESS);
      }

      @Subscribe(threadMode=ThreadMode.MAIN)
      public void onCancelReferralJoinEvent(c.b paramAnonymousb)
      {
        if (this.a == paramAnonymousb.a)
        {
          this.c.unregister(this);
          this.b.a();
        }
      }
    };
  }

  private static void b(final Context paramContext, PublicAccount paramPublicAccount, final int paramInt)
  {
    final com.viber.voip.messages.k localk = ViberApplication.getInstance().getMessagesManager();
    localk.c().a(3, paramPublicAccount.getGroupID(), paramPublicAccount, new ai.e()
    {
      public void a(final ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
      {
        final int i = ViberApplication.getInstance().getEngine(false).getPhoneController().generateSequence();
        bv.t local1 = new bv.t()
        {
          public void onPublicGroupSyncFinished(int paramAnonymous2Int1, long paramAnonymous2Long, int paramAnonymous2Int2)
          {
            if (i == paramAnonymous2Int1)
            {
              MessageEntity localMessageEntity = null;
              if (paramAnonymous2Int2 == 0)
                localMessageEntity = ab.b().b(e.22.this.a.getGroupID(), e.22.this.b);
              PublicGroupConversationData localPublicGroupConversationData = new PublicGroupConversationData(paramAnonymousConversationItemLoaderEntity.getId(), e.22.this.a);
              Intent localIntent = ViberActionRunner.aq.a(e.22.this.c, true, paramAnonymousConversationItemLoaderEntity.hasPublicAccountPublicChat(), localPublicGroupConversationData);
              if (localMessageEntity != null)
              {
                localPublicGroupConversationData.foundMessageToken = localMessageEntity.getMessageToken();
                localPublicGroupConversationData.foundMessageOrderKey = localMessageEntity.getOrderKey();
                localIntent.putExtra("extra_search_message", true);
              }
              y.a(e.22.this.c, localIntent);
              com.viber.voip.messages.controller.manager.o.a().b(this);
            }
          }
        };
        MessageEntity localMessageEntity = ab.b().b(this.a.getGroupID(), paramInt);
        int j = com.viber.voip.messages.conversation.publicaccount.a.a.c(paramInt, this.a.getLastMessageId());
        if ((localMessageEntity == null) && (j > 0))
        {
          com.viber.voip.messages.controller.manager.o.a().a(local1);
          localk.d().a(i, this.a.getGroupID(), j, false);
          return;
        }
        local1.onPublicGroupSyncFinished(i, this.a.getGroupID(), 0);
      }
    });
  }

  private static s c(Context paramContext, String paramString, Uri paramUri)
  {
    return new s(paramString, new d(paramContext, paramUri));
  }

  private static s d(Context paramContext, String paramString, Uri paramUri)
  {
    return new s(paramString, new c(paramContext, paramUri));
  }

  public String a()
  {
    return this.z;
  }

  public String b()
  {
    return this.A;
  }

  public int c()
  {
    return ordinal();
  }

  private static abstract class a extends e.b
  {
    public a(Context paramContext, Uri paramUri)
    {
      super(paramUri);
    }

    private void b(com.viber.voip.model.entity.h paramh)
    {
      if (paramh == null)
      {
        a();
        return;
      }
      a(paramh);
    }

    protected abstract void a();

    protected abstract void a(com.viber.voip.model.entity.h paramh);

    protected void a(PublicAccount paramPublicAccount)
    {
      com.viber.voip.model.entity.h localh = ab.b().b(paramPublicAccount.getGroupID());
      if (localh != null)
      {
        b(localh);
        return;
      }
      Engine localEngine = ViberApplication.getInstance().getEngine(true);
      bs localbs = new bs(ViberApplication.getApplication());
      int i = localEngine.getPhoneController().generateSequence();
      bs.e locale = bs.e.a().a(true).a();
      b(localbs.a(i, paramPublicAccount.getGroupID(), 3, paramPublicAccount, locale).f);
    }
  }

  private static abstract class b
    implements s.a
  {
    protected final Context f;
    protected final Uri g;

    public b(Context paramContext, Uri paramUri)
    {
      this.f = paramContext;
      this.g = paramUri;
    }

    protected abstract void a(PublicAccount paramPublicAccount);

    public void a(boolean paramBoolean, PublicAccount paramPublicAccount)
    {
      if ((this.g.getQueryParameter("checkAge") == null) && (paramBoolean))
      {
        Uri localUri = this.g.buildUpon().appendQueryParameter("checkAge", "0").build();
        com.viber.voip.ui.dialogs.r.b((int)SystemClock.elapsedRealtime(), -1L, paramPublicAccount.getGroupID(), null, paramPublicAccount.getGroupUri(), paramPublicAccount.getName(), 0L, "", TermsAndConditionsActivity.a.e, localUri.toString()).d();
        return;
      }
      a(paramPublicAccount);
    }

    public void b()
    {
      c();
    }

    protected void c()
    {
      y.a(this.f, ViberActionRunner.aq.b());
    }
  }

  private static class c extends e.d
  {
    public c(Context paramContext, Uri paramUri)
    {
      super(paramUri);
    }

    public void a(com.viber.voip.model.entity.h paramh)
    {
      if (2 == paramh.p())
      {
        y.a(this.f, ViberActionRunner.aq.a(paramh.getId()));
        return;
      }
      if (com.viber.voip.publicaccount.d.e.d())
      {
        super.a(paramh);
        return;
      }
      com.viber.voip.ui.dialogs.k.r().a(new ViberDialogHandlers.ao()).d();
    }
  }

  private static class d extends e.a
  {
    boolean a;

    public d(Context paramContext, Uri paramUri)
    {
      super(paramUri);
    }

    public d(Context paramContext, Uri paramUri, boolean paramBoolean)
    {
      super(paramUri);
      this.a = paramBoolean;
    }

    public void a()
    {
      c();
    }

    public void a(com.viber.voip.model.entity.h paramh)
    {
      Intent localIntent = ViberActionRunner.aq.a(this.f, paramh);
      if (this.a)
        localIntent.putExtra("publish_action", true);
      y.a(this.f, localIntent);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.e
 * JD-Core Version:    0.6.2
 */
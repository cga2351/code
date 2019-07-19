package com.viber.voip.settings.c;

import android.content.Context;
import android.os.Handler;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.common.b.d;
import com.viber.common.b.e;
import com.viber.common.b.h;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.bn;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.bs.f;
import com.viber.voip.messages.controller.manager.z;
import com.viber.voip.messages.extensions.i;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.ax;
import com.viber.voip.settings.d.ba;
import com.viber.voip.settings.d.bd;
import com.viber.voip.settings.d.n;
import com.viber.voip.settings.d.r;
import com.viber.voip.settings.ui.x.a;
import java.util.Set;

public class x extends m
{
  private final dagger.a<bn> b;
  private PreferenceScreen c;

  public x(Context paramContext, PreferenceScreen paramPreferenceScreen, dagger.a<bn> parama)
  {
    super(paramContext, paramPreferenceScreen);
    this.c = paramPreferenceScreen;
    this.b = parama;
  }

  private void e()
  {
    av.a(av.e.g).post(new Runnable()
    {
      public void run()
      {
        try
        {
          Set localSet = new z().g();
          if ((localSet != null) && (!localSet.isEmpty()))
            ViberApplication.getInstance().getMessagesManager().c().a(localSet, 1);
          return;
        }
        catch (Exception localException)
        {
        }
      }
    });
  }

  protected void a()
  {
    f(new com.viber.voip.settings.ui.x(this.a, x.a.c, d.r.y.c(), "Show deleted messages in chat").b(d.r.y.d()).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.c, d.bd.c.c(), "Show translation dialog").b(d.bd.c.d()).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.c, d.bd.a.c(), "Show translation banner").b(d.bd.a.d()).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.c, d.bd.b.c(), "ALWAYS show translation banner").b(d.bd.b.d()).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.c, d.r.z.c(), "5 seconds timeout for sending message").b(d.r.z.d()).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "generate_rakuten_msg_key", "Generate Rakuten System Message").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.c, d.r.j.c(), "Spam control").b(d.r.j.d()).a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.c, d.ad.d.c(), "Video converter available").b(d.ad.d.d()).a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "reset_wink_dialog", "Reset introduction Wink Dialog").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.c, d.r.u.c(), "Disable secret chat screenshot protection").b(d.r.u.d()).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, d.n.i.c(), "Activate ChatEx new service indication from now").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, d.n.a.c(), "Reset ChatEx items emphasizing").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, d.n.h.c(), "Reset ChatEx 'Show carrier zero rate dialog'").a(this).a());
    if (!ViberApplication.isTablet(this.a))
      f(new com.viber.voip.settings.ui.x(this.a, x.a.c, d.r.F.c(), "Show share Viber chats trigger").b(d.r.F.d()).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.c, d.r.G.c(), "Emulate send message error reply").a(Boolean.valueOf(d.r.G.f())).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "delete_all_conversations", "Delete All Conversations").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.c, d.r.H.c(), "Force Snooze lifetime").a("for 30 sec").a(Boolean.valueOf(d.r.H.f())).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, d.r.J.c(), "Reset create poll tooltip").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, d.r.C.c(), "Reset search message ftue").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, d.ba.a.c(), "Show swipe to reply banner").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, d.n.l.c(), "Reset ChatEx Suggestions tooltip shown count").a(Integer.valueOf(d.n.l.f())).a("Count: " + d.n.l.d()).a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.d, d.n.m.c(), "Set ChatEx Suggestions JSON url").a(d.n.m.f()).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "debug_suggestions_reset_json_key", "Reset ChatEx Suggestions JSON url").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "debug_suggestions_force_json_update_key", "Force ChatEx Suggestions JSON update").a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("converstaion_key");
    paramPreferenceGroup.c("Conversation (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    String str = paramPreference.C();
    if (str.equals("generate_rakuten_msg_key"))
    {
      final MessageEntity localMessageEntity = new com.viber.voip.messages.controller.c.a("Rakuten", System.currentTimeMillis(), System.currentTimeMillis(), 257, 0, null, 2, 0).a(0, "Your 4 digit code for Viber on desktop is: 4444. This is debug rakuten system message", 0, null, 0);
      av.a(av.e.d).post(new Runnable()
      {
        public void run()
        {
          bs.f localf = new bs(x.this.a).a(localMessageEntity);
          if ((localf.b) && (localMessageEntity.isIncoming()) && (!localMessageEntity.isRead()) && (!localMessageEntity.isRoleFollower()))
            ((bn)x.a(x.this).get()).a(localf.f, localf.g, localf.h, null);
        }
      });
    }
    do
    {
      return false;
      if (str.equals("reset_wink_dialog"))
      {
        d.r.k.e();
        return false;
      }
      if (str.equals(d.ax.w.c()))
      {
        boolean bool = ((CheckBoxPreference)paramPreference).b();
        d.ax.w.a(bool);
        return true;
      }
      if (str.equals(d.n.i.c()))
      {
        i.a().d();
        return true;
      }
      if (str.equals(d.n.a.c()))
      {
        d.n.a.e();
        return false;
      }
      if (str.equals(d.n.h.c()))
      {
        d.n.h.e();
        return false;
      }
      if (str.equals("delete_all_conversations"))
      {
        e();
        return false;
      }
      if (str.equals(d.r.J.c()))
      {
        d.r.J.e();
        return false;
      }
      if (str.equals(d.r.C.c()))
      {
        d.r.C.e();
        return false;
      }
      if (str.equals(d.ba.a.c()))
      {
        d.ba.a.e();
        return false;
      }
      if (d.n.l.c().equals(str))
      {
        d.n.l.e();
        paramPreference.b("Count: " + d.n.l.d());
        return false;
      }
      if ("debug_suggestions_reset_json_key".equals(str))
      {
        d.n.m.e();
        ((EditTextPreference)this.c.a(d.n.m.c())).a(d.n.m.d());
        return false;
      }
    }
    while (!"debug_suggestions_force_json_update_key".equals(str));
    av.e.g.a().post(y.a);
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.x
 * JD-Core Version:    0.6.2
 */
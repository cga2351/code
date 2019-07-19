package com.viber.voip.notif.b.f.d.a;

import android.content.Context;
import android.content.Intent;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.g;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.r;
import com.viber.voip.notif.b.f.d;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.cd;

public class e extends d
{
  private static final Logger h = ViberEnv.getLogger();
  private final dagger.a<ak> i;
  private final dagger.a<ab> j;
  private final dagger.a<com.viber.voip.contacts.c.d.m> k;
  private final String l;
  private a m;

  public e(com.viber.voip.notif.h.m paramm, dagger.a<ak> parama, dagger.a<ab> parama1, dagger.a<com.viber.voip.contacts.c.d.m> parama2, String paramString)
  {
    super(paramm);
    this.i = parama;
    this.j = parama1;
    this.k = parama2;
    this.l = paramString;
  }

  private a i(Context paramContext)
  {
    if (this.m == null)
      this.m = j(paramContext);
    return this.m;
  }

  private a j(Context paramContext)
  {
    a locala = new a(null);
    r localr = ((ab)this.j.get()).d(this.a.e().k());
    if ((localr != null) && (localr.n() == 0) && (localr.D() != null) && (localr.D().equals(this.l)));
    for (int n = 1; n != 0; n = 0)
    {
      locala.a = ViberActionRunner.aq.c(paramContext, localr.d());
      locala.a.putExtra("notif_extra_token", this.a.c().getMessageToken());
      int i3 = R.string.public_account_creation_notification_title;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = this.a.e().o();
      locala.b = paramContext.getString(i3, arrayOfObject3);
      locala.c = paramContext.getString(R.string.public_account_creation_notification_body);
      return locala;
    }
    locala.a = super.c(paramContext);
    String str1 = paramContext.getString(R.string.unknown);
    String str2;
    if (localr != null)
    {
      g localg = ((com.viber.voip.contacts.c.d.m)this.k.get()).c(new Member(localr.D()));
      if (localg != null)
        str2 = localg.k();
    }
    while (true)
    {
      int i1 = R.string.vibe_notify_welcome_title;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = this.a.e().o();
      locala.b = paramContext.getString(i1, arrayOfObject1);
      if (com.viber.voip.messages.m.b(this.a.e().j()))
      {
        locala.c = paramContext.getString(R.string.message_notification_you_added_to_community, new Object[] { str2 });
        return locala;
        com.viber.voip.model.entity.m localm = ((ak)this.i.get()).c(new Member(localr.D()), cd.j(this.a.e().j()));
        if (localm != null)
          str2 = localm.a(this.a.e().j(), this.a.e().p());
      }
      else
      {
        int i2 = R.string.vibe_notify_welcome_msg;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = str2;
        arrayOfObject2[1] = this.a.e().o();
        locala.c = paramContext.getString(i2, arrayOfObject2);
        return locala;
        str2 = str1;
      }
    }
  }

  public String R_()
  {
    return "you_join";
  }

  public CharSequence b(Context paramContext)
  {
    return i(paramContext).c;
  }

  public CharSequence b_(Context paramContext)
  {
    return i(paramContext).b;
  }

  protected Intent c(Context paramContext)
  {
    return i(paramContext).a;
  }

  public CharSequence d(Context paramContext)
  {
    return paramContext.getText(R.string.app_name);
  }

  private static class a
  {
    Intent a;
    String b;
    String c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.d.a.e
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.notif.a;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.a.a.a;
import com.viber.voip.notif.h.n;
import com.viber.voip.util.ViberActionRunner.bm;
import com.viber.voip.util.dg;

public class l extends a
{
  private final h c;
  private final com.viber.voip.model.entity.m d;
  private final MessageEntity e;
  private final n f;

  l(com.viber.voip.notif.h.m paramm)
  {
    this.c = paramm.e();
    this.d = paramm.d();
    this.e = paramm.c();
    this.f = paramm.f();
  }

  protected int a()
  {
    return R.drawable.ic_notification_action_play;
  }

  protected Intent a(Context paramContext)
  {
    String str;
    if (this.c.b())
    {
      str = dg.b(this.c.o());
      if ((this.f != null) && (this.f.e()))
        break label120;
    }
    label120: for (boolean bool = true; ; bool = false)
    {
      Intent localIntent = ViberActionRunner.bm.a(paramContext, this.e.getConversationId(), this.e.getConversationType(), this.e.getId(), str, this.c.p(), this.e.isSecretMessage(), bool, false);
      localIntent.putExtra("navigated_to_conversation_on_back", true);
      localIntent.putExtra("extra_play", true);
      return localIntent;
      str = this.d.a(this.c);
      break;
    }
  }

  protected int b()
  {
    return R.string.notification_play;
  }

  protected int d()
  {
    return (int)this.c.getId();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.a.l
 * JD-Core Version:    0.6.2
 */
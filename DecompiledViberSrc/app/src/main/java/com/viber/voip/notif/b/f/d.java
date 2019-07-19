package com.viber.voip.notif.b.f;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.messages.d.b;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.d.m.a;
import com.viber.voip.registration.af;
import com.viber.voip.util.dg;

public abstract class d extends a
  implements m.a
{
  public d(com.viber.voip.notif.h.m paramm)
  {
    super(paramm, null);
  }

  public int a()
  {
    return (int)this.a.c().getConversationId();
  }

  protected String a(af paramaf, dagger.a<b> parama, Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (com.viber.voip.messages.m.a(paramaf, paramString))
      return paramContext.getString(R.string.conversation_you);
    return ((b)parama.get()).a(paramString, paramInt1, paramInt2);
  }

  public int b()
  {
    return R.drawable.ic_system_notification_group;
  }

  public CharSequence b_(Context paramContext)
  {
    return dg.b(this.a.e().o());
  }

  public CharSequence d(Context paramContext)
  {
    return null;
  }

  public CharSequence f(Context paramContext)
  {
    return null;
  }

  public com.viber.voip.notif.d.m h(Context paramContext)
  {
    return com.viber.voip.notif.d.m.a(this, paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.d
 * JD-Core Version:    0.6.2
 */
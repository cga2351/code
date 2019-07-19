package com.viber.voip.notif.a;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.a.a.a;

public class k extends a
{
  private final h c;
  private final com.viber.voip.model.entity.m d;
  private final MessageEntity e;

  k(com.viber.voip.notif.h.m paramm)
  {
    this.c = paramm.e();
    this.d = paramm.d();
    this.e = paramm.c();
  }

  protected int a()
  {
    return R.drawable.ic_notification_action_play;
  }

  protected Intent a(Context paramContext)
  {
    int i;
    long l1;
    long l2;
    String str1;
    label42: String str2;
    label55: int j;
    String str3;
    if (!this.c.b())
    {
      i = 1;
      l1 = this.c.getId();
      l2 = this.c.k();
      if (i == 0)
        break label164;
      str1 = this.d.a();
      if (i == 0)
        break label170;
      str2 = this.d.getNumber();
      j = this.c.j();
      if (i == 0)
        break label176;
      str3 = this.d.getViberName();
      label77: if (i == 0)
        break label182;
    }
    label164: label170: label176: label182: for (String str4 = this.d.getContactName(); ; str4 = null)
    {
      Intent localIntent = com.viber.voip.messages.m.a(l1, 0L, 0L, l2, str1, str2, j, str3, str4, this.c.o(), 1, false, false, this.c.R(), this.c.aj(), this.c.ao());
      localIntent.putExtra("notif_extra_ptt_message_id_for_playing", this.e.getId());
      return localIntent;
      i = 0;
      break;
      str1 = null;
      break label42;
      str2 = null;
      break label55;
      str3 = null;
      break label77;
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
 * Qualified Name:     com.viber.voip.notif.a.k
 * JD-Core Version:    0.6.2
 */
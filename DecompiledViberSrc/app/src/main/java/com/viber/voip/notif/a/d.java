package com.viber.voip.notif.a;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.a.a.a;
import com.viber.voip.notif.i.i;
import com.viber.voip.util.ViberActionRunner.am;

public class d extends a
{
  private final MessageEntity c;
  private String d;
  private int e;

  d(MessageEntity paramMessageEntity, String paramString, int paramInt)
  {
    this.c = paramMessageEntity;
    this.d = paramString;
    this.e = paramInt;
  }

  protected int a()
  {
    return R.drawable.ic_action_message_like;
  }

  protected Intent a(Context paramContext)
  {
    Intent localIntent = ViberActionRunner.am.a(paramContext, this.c);
    localIntent.putExtra("notification_tag", this.d);
    localIntent.putExtra("notification_id", this.e);
    return localIntent;
  }

  protected int b()
  {
    return R.string.notification_action_like;
  }

  protected int d()
  {
    return i.e((int)this.c.getId());
  }

  protected int e()
  {
    return 0;
  }

  protected int f()
  {
    return R.drawable.ic_action_wear_message_like;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.a.d
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.notif.a;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.messages.extras.map.b;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.a.a.a;
import com.viber.voip.util.ViberActionRunner.bl;

public class j extends a
{
  private final MessageEntity c;

  j(MessageEntity paramMessageEntity)
  {
    this.c = paramMessageEntity;
  }

  protected int a()
  {
    return R.drawable.ic_action_show_map;
  }

  protected Intent a(Context paramContext)
  {
    return ViberActionRunner.bl.a(b.a(this.c));
  }

  protected int b()
  {
    return R.string.wear_action_show_on_map;
  }

  protected int d()
  {
    return (int)this.c.getId();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.a.j
 * JD-Core Version:    0.6.2
 */
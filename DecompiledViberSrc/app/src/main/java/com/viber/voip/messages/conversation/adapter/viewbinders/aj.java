package com.viber.voip.messages.conversation.adapter.viewbinders;

import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.notification.NotificationBackgroundConstraintHelper;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.notification.NotificationBackgroundConstraintHelper.a;
import com.viber.voip.ui.g.e;

public class aj extends e<a, i>
{
  private final NotificationBackgroundConstraintHelper a;

  public aj(NotificationBackgroundConstraintHelper paramNotificationBackgroundConstraintHelper)
  {
    this.a = paramNotificationBackgroundConstraintHelper;
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    NotificationBackgroundConstraintHelper localNotificationBackgroundConstraintHelper = this.a;
    if (localaa.q() == 1008);
    for (boolean bool = true; ; bool = false)
    {
      localNotificationBackgroundConstraintHelper.setTag(new NotificationBackgroundConstraintHelper.a(bool));
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.aj
 * JD-Core Version:    0.6.2
 */
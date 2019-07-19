package com.viber.voip.notif.receivers;

import android.content.Intent;
import com.viber.voip.notif.e.h;
import com.viber.voip.notif.e.m;
import com.viber.voip.notif.e.n;
import com.viber.voip.notif.e.s;
import com.viber.voip.notif.g;
import com.viber.voip.util.LongSparseSet;

public final class a
  implements d
{
  private final g a;

  a(g paramg)
  {
    this.a = paramg;
  }

  public void a(Intent paramIntent)
  {
    if (paramIntent == null);
    do
    {
      long[] arrayOfLong1;
      do
      {
        long[] arrayOfLong2;
        do
        {
          return;
          if (!"com.viber.voip.action.LIKE_NOTIFICATION_CANCELED".equals(paramIntent.getAction()))
            break;
          arrayOfLong2 = paramIntent.getLongArrayExtra("unread_conversation_ids");
        }
        while (arrayOfLong2 == null);
        this.a.e().a(LongSparseSet.from(arrayOfLong2));
        return;
        if (!"com.viber.voip.action.MESSAGE_NOTIFICATION_CANCELED_ACTION".equals(paramIntent.getAction()))
          break;
        arrayOfLong1 = paramIntent.getLongArrayExtra("unread_message_ids");
      }
      while (arrayOfLong1 == null);
      this.a.d().a(LongSparseSet.from(arrayOfLong1));
      return;
      if ("com.viber.voip.action.APPROVE_SYNC_HISTORY_TO_DESKTOP_NOTIFICATION_CANCELED_ACTION".equals(paramIntent.getAction()))
      {
        this.a.a().i();
        return;
      }
    }
    while (!"com.viber.voip.action.COMMUNITY_MESSAGE_NOTIFICATION_CANCELED_ACTION".equals(paramIntent.getAction()));
    long l1 = paramIntent.getLongExtra("conversation_id", 0L);
    long l2 = paramIntent.getLongExtra("extra_group_id", 0L);
    long l3 = paramIntent.getIntExtra("unread_message_ids", 0);
    this.a.g().a(l2, l1, l3);
  }

  public boolean a(String paramString)
  {
    return (paramString.equals("com.viber.voip.action.LIKE_NOTIFICATION_CANCELED")) || (paramString.equals("com.viber.voip.action.MESSAGE_NOTIFICATION_CANCELED_ACTION")) || (paramString.equals("com.viber.voip.action.COMMUNITY_MESSAGE_NOTIFICATION_CANCELED_ACTION")) || (paramString.equals("com.viber.voip.action.APPROVE_SYNC_HISTORY_TO_DESKTOP_NOTIFICATION_CANCELED_ACTION"));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.receivers.a
 * JD-Core Version:    0.6.2
 */
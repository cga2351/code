package com.viber.voip.messages.conversation.ui.view;

import android.content.Intent;

public class d
{
  private final boolean a;
  private final long b;
  private final boolean c;

  private d(boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    this.a = paramBoolean1;
    this.b = paramLong;
    this.c = paramBoolean2;
  }

  public static d a(Intent paramIntent, boolean paramBoolean)
  {
    return new d(paramIntent.getBooleanExtra("extra_search_message", false), paramIntent.getLongExtra("notif_extra_ptt_message_id_for_playing", -1L), paramIntent.getBooleanExtra("clicked", false));
  }

  public boolean a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.c;
  }

  public long c()
  {
    return this.b;
  }

  public String toString()
  {
    return "ConversationArguments{mSearchMessage=" + this.a + ", mAutoPlayPttMessageId=" + this.b + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.d
 * JD-Core Version:    0.6.2
 */
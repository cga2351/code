package com.viber.voip.messages.conversation.chatinfo.presentation;

import android.support.v4.app.Fragment;
import com.viber.voip.messages.k;
import com.viber.voip.ui.j.av;
import dagger.android.c;

public final class a
  implements dagger.b<ChatInfoActivity>
{
  public static void a(ChatInfoActivity paramChatInfoActivity, com.viber.voip.app.b paramb)
  {
    paramChatInfoActivity.b = paramb;
  }

  public static void a(ChatInfoActivity paramChatInfoActivity, dagger.a<k> parama)
  {
    paramChatInfoActivity.c = parama;
  }

  public static void a(ChatInfoActivity paramChatInfoActivity, c<Fragment> paramc)
  {
    paramChatInfoActivity.a = paramc;
  }

  public static void b(ChatInfoActivity paramChatInfoActivity, dagger.a<av> parama)
  {
    paramChatInfoActivity.d = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.a
 * JD-Core Version:    0.6.2
 */
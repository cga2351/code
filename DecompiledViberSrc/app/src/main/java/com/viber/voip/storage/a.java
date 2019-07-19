package com.viber.voip.storage;

import android.view.View;
import com.viber.voip.R.id;
import com.viber.voip.messages.adapters.a.b.f;
import com.viber.voip.messages.adapters.a.b.j;
import com.viber.voip.messages.adapters.g;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.widget.AvatarWithInitialsView;
import com.viber.voip.widget.GroupIconView;

public class a<T extends RegularConversationLoaderEntity>
{
  private final AvatarWithInitialsView a;
  private final GroupIconView b;
  private final com.viber.voip.messages.adapters.a.c.a c;
  private final b<com.viber.voip.messages.adapters.a.a, com.viber.voip.messages.adapters.a.c.a> d;

  public a(View paramView, com.viber.voip.messages.adapters.a.c.a parama, e parame)
  {
    this.a = ((AvatarWithInitialsView)paramView.findViewById(R.id.icon));
    this.b = ((GroupIconView)paramView.findViewById(R.id.group_icon));
    d[] arrayOfd = new d[2];
    arrayOfd[0] = new f(paramView.getContext(), this.a, parame);
    arrayOfd[1] = new j(paramView.getContext(), this.b, parame);
    this.d = new b(arrayOfd);
    this.c = parama;
  }

  private g b(T paramT)
  {
    return new g(paramT, false, false);
  }

  public void a(T paramT)
  {
    AvatarWithInitialsView localAvatarWithInitialsView = this.a;
    if (!paramT.isGroupBehavior());
    for (boolean bool = true; ; bool = false)
    {
      dj.b(localAvatarWithInitialsView, bool);
      dj.b(this.b, paramT.isGroupBehavior());
      this.d.a(b(paramT), this.c);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.a
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.messages.adapters.a.b;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.viber.voip.messages.adapters.a.c.a.a;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.ui.g.e;

public class b<T extends com.viber.voip.messages.adapters.a.a> extends e<T, com.viber.voip.messages.adapters.a.c.a>
{
  private View a;

  public b(View paramView)
  {
    this.a = paramView;
  }

  public void a(T paramT, com.viber.voip.messages.adapters.a.c.a parama)
  {
    int i = 1;
    super.a(paramT, parama);
    ConversationLoaderEntity localConversationLoaderEntity = paramT.a();
    boolean bool1 = paramT.f();
    int j;
    com.viber.voip.messages.adapters.a.c.a.a locala;
    boolean bool2;
    label138: Drawable localDrawable;
    if ((localConversationLoaderEntity.isFavouriteConversation()) && (parama.c() == a.a.a) && (!parama.x()))
    {
      j = i;
      locala = parama.A();
      locala.c(this.a, localConversationLoaderEntity.getId());
      if (!localConversationLoaderEntity.isNewUserJoinedConversation())
        break label223;
      bool2 = locala.a(localConversationLoaderEntity.getId());
      if ((bool2) || (!localConversationLoaderEntity.showEngagementConversationAnimation()))
        break label187;
      if (!parama.z())
        break label175;
      locala.a(this.a, localConversationLoaderEntity.getId());
      parama.a(localConversationLoaderEntity.getId(), false);
      this.a.setActivated(bool1);
      localDrawable = this.a.getBackground();
      if (j == 0)
        break label237;
    }
    while (true)
    {
      localDrawable.setLevel(i);
      label175: label187: 
      do
      {
        return;
        j = 0;
        break;
        locala.a(this.a);
        break label138;
      }
      while ((bool2) && (locala.b(this.a, localConversationLoaderEntity.getId())));
      this.a.setBackground(parama.o());
      break label138;
      label223: this.a.setBackground(parama.o());
      break label138;
      label237: i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.b
 * JD-Core Version:    0.6.2
 */
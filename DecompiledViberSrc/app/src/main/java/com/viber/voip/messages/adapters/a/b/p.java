package com.viber.voip.messages.adapters.a.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.viber.voip.R.attr;
import com.viber.voip.R.drawable;
import com.viber.voip.messages.adapters.c.c;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import javax.annotation.Nullable;

public class p extends e<com.viber.voip.messages.adapters.a.a, com.viber.voip.messages.adapters.a.c.a>
  implements View.OnClickListener
{
  private final ImageView a;

  @Nullable
  private final c b;

  public p(ImageView paramImageView, @Nullable c paramc)
  {
    this.b = paramc;
    this.a = paramImageView;
    this.a.setOnClickListener(this);
  }

  public void a(com.viber.voip.messages.adapters.a.a parama, com.viber.voip.messages.adapters.a.c.a parama1)
  {
    boolean bool1 = true;
    super.a(parama, parama1);
    ConversationLoaderEntity localConversationLoaderEntity = parama.a();
    boolean bool2;
    label49: boolean bool3;
    if ((localConversationLoaderEntity.hasMessageDraft()) && (parama.l() == 0))
    {
      bool2 = bool1;
      if ((!localConversationLoaderEntity.isMissedCall()) || (bool2))
        break label133;
      bool3 = localConversationLoaderEntity.isMissedAudioCall();
      boolean bool4 = localConversationLoaderEntity.isMissedVideoCall();
      if (bool1)
      {
        if (!bool4)
          break label138;
        this.a.setImageDrawable(parama1.a(R.drawable.ic_contacts_item_video_call));
        label86: if (!localConversationLoaderEntity.isFavouriteConversation())
          break label160;
      }
    }
    label133: label138: label160: for (int i = R.attr.conversationPinnedActionButtonBackground; ; i = R.attr.conversationActionButtonBackground)
    {
      this.a.setBackground(dc.g(this.a.getContext(), i));
      dj.b(this.a, bool1);
      return;
      bool2 = false;
      break;
      bool1 = false;
      break label49;
      if (!bool3)
        break label86;
      this.a.setImageDrawable(parama1.a(R.drawable.ic_contacts_item_voice_call));
      break label86;
    }
  }

  public void onClick(View paramView)
  {
    com.viber.voip.messages.adapters.a.a locala = (com.viber.voip.messages.adapters.a.a)d();
    if ((this.b != null) && (locala != null))
      this.b.a(locala.a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.p
 * JD-Core Version:    0.6.2
 */
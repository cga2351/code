package com.viber.voip.engagement.contacts;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.adapters.a.b.f;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.widget.AvatarWithInitialsView;
import com.viber.voip.widget.GroupIconView;

public class j
  implements View.OnClickListener, l
{
  private final b<com.viber.voip.messages.adapters.a.a, com.viber.voip.messages.adapters.a.c.a> a;
  private final TextView b;
  private final g c;
  private final com.viber.voip.messages.adapters.a.c.a d;
  private final SendHiButtonView e;
  private final View f;
  private final GroupIconView g;
  private final AvatarWithInitialsView h;
  private RegularConversationLoaderEntity i;

  j(View paramView, e parame, g paramg, com.viber.voip.messages.adapters.a.c.a parama)
  {
    this.c = paramg;
    this.d = parama;
    this.b = ((TextView)paramView.findViewById(R.id.name));
    this.e = ((SendHiButtonView)paramView.findViewById(R.id.engagement_contact_send_hi));
    this.f = paramView.findViewById(R.id.bottom_divider);
    this.g = ((GroupIconView)paramView.findViewById(R.id.group_icon));
    this.h = ((AvatarWithInitialsView)paramView.findViewById(R.id.icon));
    this.e.setOnClickListener(this);
    d[] arrayOfd = new d[2];
    arrayOfd[0] = new f(paramView.getContext(), this.h, parame);
    arrayOfd[1] = new com.viber.voip.messages.adapters.a.b.j(paramView.getContext(), this.g, parame);
    this.a = new b(arrayOfd);
  }

  public void a(RegularConversationLoaderEntity paramRegularConversationLoaderEntity, boolean paramBoolean)
  {
    this.i = paramRegularConversationLoaderEntity;
    if (this.i == null)
      return;
    String str;
    if (this.i.isGroupBehavior())
    {
      dj.b(this.g, true);
      dj.c(this.h, false);
      TextView localTextView = this.b;
      if (da.a(this.i.getGroupName()))
        if (this.i.isBroadcastListType())
        {
          str = this.d.u();
          localTextView.setText(str);
        }
    }
    while (true)
    {
      this.b.setGravity(19);
      this.a.a(new com.viber.voip.messages.adapters.g(this.i, false, false), this.d);
      dj.b(this.f, paramBoolean);
      return;
      str = this.d.t();
      break;
      str = this.i.getGroupName();
      break;
      dj.b(this.g, false);
      dj.c(this.h, true);
      this.b.setText(this.i.getParticipantName());
    }
  }

  public void a(boolean paramBoolean)
  {
    this.e.a(paramBoolean);
  }

  public void b()
  {
    this.e.a();
  }

  public void c()
  {
    this.e.b();
  }

  public void onClick(View paramView)
  {
    if (this.i != null)
      this.c.a(this.i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.contacts.j
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.messages.conversation.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.ui.aj;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.d.c;
import com.viber.voip.messages.extras.map.BalloonLayout;
import com.viber.voip.model.entity.m;
import com.viber.voip.util.dj;

public class bf
{
  private static final Logger a = ViberEnv.getLogger();
  private ConversationFragment b;
  private ConversationItemLoaderEntity c;
  private m d;
  private View e;
  private View f;
  private BalloonLayout g;
  private TextView h;
  private Button i;
  private int j;
  private RelativeLayout k;

  public bf(ConversationFragment paramConversationFragment)
  {
    this.b = paramConversationFragment;
  }

  private void a(View paramView)
  {
    this.k = ((RelativeLayout)paramView.findViewById(R.id.conversation_top));
    this.f = paramView.findViewById(R.id.swipe_refresh_layout);
    this.e = this.b.getLayoutInflater().inflate(R.layout.invite_to_viber_banner_tablet, this.k, false);
    this.k.addView(this.e);
    this.g = ((BalloonLayout)this.e.findViewById(R.id.content));
    this.g.setMaxWidth(this.g.getContext().getResources().getDimensionPixelSize(R.dimen.invite_to_viber_baner_max_width));
    this.h = ((TextView)this.g.findViewById(R.id.invite_to_viber_text));
    this.i = ((Button)this.g.findViewById(R.id.invite_to_viber_btn));
    this.i.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        aj.a(bf.a(bf.this).getContext(), bf.b(bf.this).getNumber(), false);
      }
    });
    this.j = this.k.getPaddingTop();
  }

  private boolean a()
  {
    return (this.c.showInviteBanner()) && (!this.c.showAddNewParticipantNumberBanner());
  }

  private void b()
  {
    this.e.setVisibility(0);
    TextView localTextView = this.h;
    Context localContext = this.h.getContext();
    int m = R.string.invite_banner_message;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.d.a(1, 1);
    localTextView.setText(localContext.getString(m, arrayOfObject));
    dj.a(this.g, new Runnable()
    {
      public void run()
      {
        int i = 2 * bf.a(bf.this).getResources().getDimensionPixelSize(R.dimen.invite_banner_top_padding) + bf.a(bf.this).getHeight();
        bf.d(bf.this).setPadding(0, i + bf.c(bf.this), 0, 0);
      }
    });
  }

  private void c()
  {
    if (this.e != null)
    {
      this.f.setPadding(0, this.j, 0, 0);
      this.e.setVisibility(8);
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (!paramConversationItemLoaderEntity.isConversation1on1())
      c();
    do
    {
      do
      {
        return;
        this.c = paramConversationItemLoaderEntity;
        if (this.e != null)
          break;
      }
      while (this.b.getView() == null);
      a(this.b.getView());
      this.d = c.c().c(paramConversationItemLoaderEntity.getParticipantMemberId(), 1);
    }
    while (this.d == null);
    if (a())
    {
      b();
      return;
    }
    c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.bf
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.messages.conversation.adapter.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.ui.g.f;
import com.viber.voip.widget.AvatarWithInitialsView;

public class t
  implements f
{
  public final TextView a;
  public final ImageView b;
  public final ImageView c;
  public final View d;
  public final TextView e;
  public final TextView f;
  public final TextView g;
  public final View h;
  public final View i;
  public final View j;
  public final View k;
  public final TextView l;
  public final ImageView m;
  public final LinearLayout n;
  public final TextView o;
  public final AvatarWithInitialsView p;
  public final TextView q;

  public t(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(R.id.timestampView));
    this.b = ((ImageView)paramView.findViewById(R.id.locationView));
    this.c = ((ImageView)paramView.findViewById(R.id.broadcastView));
    this.d = paramView.findViewById(R.id.balloonView);
    this.e = ((TextView)paramView.findViewById(R.id.dateHeaderView));
    this.f = ((TextView)paramView.findViewById(R.id.newMessageHeaderView));
    this.g = ((TextView)paramView.findViewById(R.id.loadMoreMessagesView));
    this.h = paramView.findViewById(R.id.loadingMessagesLabelView);
    this.i = paramView.findViewById(R.id.loadingMessagesAnimationView);
    this.j = paramView.findViewById(R.id.headersSpace);
    this.k = paramView.findViewById(R.id.selectionView);
    this.p = ((AvatarWithInitialsView)paramView.findViewById(R.id.avatarView));
    this.q = ((TextView)paramView.findViewById(R.id.nameView));
    this.m = ((ImageView)paramView.findViewById(R.id.adminIndicatorView));
    this.n = ((LinearLayout)paramView.findViewById(R.id.optionsContainerView));
    this.o = ((TextView)paramView.findViewById(R.id.voteTitleView));
    this.l = ((TextView)paramView.findViewById(R.id.voteCountView));
  }

  public View a()
  {
    return this.n;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.c.t
 * JD-Core Version:    0.6.2
 */
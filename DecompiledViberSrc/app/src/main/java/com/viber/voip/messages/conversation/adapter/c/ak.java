package com.viber.voip.messages.conversation.adapter.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.ui.view.AnimatedLikesView;
import com.viber.voip.ui.g.f;
import com.viber.voip.widget.AvatarWithInitialsView;

public class ak
  implements f
{
  public final AvatarWithInitialsView a;
  public final AnimatedLikesView b;
  public final TextView c;
  public final ImageView d;
  public final ImageView e;
  public final ImageView f;
  public final View g;
  public final TextView h;
  public final TextView i;
  public final TextView j;
  public final View k;
  public final View l;
  public final View m;
  public final View n;
  public final TextView o;
  public final TextView p;
  public final TextView q;
  public final TextView r;

  public ak(View paramView)
  {
    this.a = ((AvatarWithInitialsView)paramView.findViewById(R.id.avatarView));
    this.b = ((AnimatedLikesView)paramView.findViewById(R.id.likeView));
    this.c = ((TextView)paramView.findViewById(R.id.timestampView));
    this.d = ((ImageView)paramView.findViewById(R.id.locationView));
    this.e = ((ImageView)paramView.findViewById(R.id.broadcastView));
    this.f = ((ImageView)paramView.findViewById(R.id.statusView));
    this.g = paramView.findViewById(R.id.balloonView);
    this.h = ((TextView)paramView.findViewById(R.id.dateHeaderView));
    this.i = ((TextView)paramView.findViewById(R.id.newMessageHeaderView));
    this.j = ((TextView)paramView.findViewById(R.id.loadMoreMessagesView));
    this.k = paramView.findViewById(R.id.loadingMessagesLabelView);
    this.l = paramView.findViewById(R.id.loadingMessagesAnimationView);
    this.m = paramView.findViewById(R.id.headersSpace);
    this.n = paramView.findViewById(R.id.selectionView);
    this.o = ((TextView)paramView.findViewById(R.id.referralView));
    this.p = ((TextView)paramView.findViewById(R.id.textMessageView));
    this.q = ((TextView)paramView.findViewById(R.id.translateMessageView));
    this.r = ((TextView)paramView.findViewById(R.id.translateByView));
  }

  public View a()
  {
    return this.p;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.c.ak
 * JD-Core Version:    0.6.2
 */
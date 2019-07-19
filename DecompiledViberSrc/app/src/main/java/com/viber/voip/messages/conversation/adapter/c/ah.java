package com.viber.voip.messages.conversation.adapter.c;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.common.ui.ShapeImageView;
import com.viber.voip.R.id;
import com.viber.voip.messages.ui.view.AnimatedLikesView;
import com.viber.voip.ui.g.f;

public class ah
  implements f
{
  public final AnimatedLikesView a;
  public final TextView b;
  public final ImageView c;
  public final ImageView d;
  public final ImageView e;
  public final View f;
  public final TextView g;
  public final TextView h;
  public final TextView i;
  public final View j;
  public final View k;
  public final View l;
  public final View m;
  public final TextView n;
  public final Button o;
  public final TextView p;
  public final TextView q;
  public final ShapeImageView r;
  public final ImageView s;

  public ah(View paramView)
  {
    this.a = ((AnimatedLikesView)paramView.findViewById(R.id.likeView));
    this.b = ((TextView)paramView.findViewById(R.id.timestampView));
    this.c = ((ImageView)paramView.findViewById(R.id.locationView));
    this.d = ((ImageView)paramView.findViewById(R.id.broadcastView));
    this.e = ((ImageView)paramView.findViewById(R.id.statusView));
    this.f = paramView.findViewById(R.id.balloonView);
    this.g = ((TextView)paramView.findViewById(R.id.dateHeaderView));
    this.h = ((TextView)paramView.findViewById(R.id.newMessageHeaderView));
    this.i = ((TextView)paramView.findViewById(R.id.loadMoreMessagesView));
    this.j = paramView.findViewById(R.id.loadingMessagesLabelView);
    this.k = paramView.findViewById(R.id.loadingMessagesAnimationView);
    this.l = paramView.findViewById(R.id.headersSpace);
    this.m = paramView.findViewById(R.id.selectionView);
    this.q = ((TextView)paramView.findViewById(R.id.referralView));
    this.r = ((ShapeImageView)paramView.findViewById(R.id.imageView));
    this.s = ((ImageView)paramView.findViewById(R.id.forwardView));
    this.o = ((Button)paramView.findViewById(R.id.followButtonView));
    this.n = ((TextView)paramView.findViewById(R.id.communityNameView));
    this.p = ((TextView)paramView.findViewById(R.id.screenshotDescriptionView));
  }

  public View a()
  {
    return this.r;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.c.ah
 * JD-Core Version:    0.6.2
 */
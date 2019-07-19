package com.viber.voip.messages.conversation.adapter.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.ui.view.AnimatedLikesView;
import com.viber.voip.ui.g.f;
import com.viber.voip.widget.AvatarWithInitialsView;
import com.viber.voip.widget.FileIconView;
import com.viber.voip.widget.GifShapeImageView;

public class i
  implements f
{
  public final AvatarWithInitialsView a;
  public final TextView b;
  public final AnimatedLikesView c;
  public final TextView d;
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
  public final ImageView o;
  public final TextView p;
  public final GifShapeImageView q;
  public final FileIconView r;
  public final ImageView s;

  public i(View paramView)
  {
    this.a = ((AvatarWithInitialsView)paramView.findViewById(R.id.avatarView));
    this.b = ((TextView)paramView.findViewById(R.id.nameView));
    this.c = ((AnimatedLikesView)paramView.findViewById(R.id.likeView));
    this.d = ((TextView)paramView.findViewById(R.id.timestampView));
    this.e = ((ImageView)paramView.findViewById(R.id.locationView));
    this.f = ((ImageView)paramView.findViewById(R.id.broadcastView));
    this.g = paramView.findViewById(R.id.balloonView);
    this.h = ((TextView)paramView.findViewById(R.id.dateHeaderView));
    this.i = ((TextView)paramView.findViewById(R.id.newMessageHeaderView));
    this.j = ((TextView)paramView.findViewById(R.id.loadMoreMessagesView));
    this.k = paramView.findViewById(R.id.loadingMessagesLabelView);
    this.l = paramView.findViewById(R.id.loadingMessagesAnimationView);
    this.m = paramView.findViewById(R.id.headersSpace);
    this.n = paramView.findViewById(R.id.selectionView);
    this.o = ((ImageView)paramView.findViewById(R.id.adminIndicatorView));
    this.p = ((TextView)paramView.findViewById(R.id.referralView));
    this.q = ((GifShapeImageView)paramView.findViewById(R.id.imageView));
    this.r = ((FileIconView)paramView.findViewById(R.id.progressView));
    this.s = ((ImageView)paramView.findViewById(R.id.forwardView));
  }

  public View a()
  {
    return this.q;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.c.i
 * JD-Core Version:    0.6.2
 */
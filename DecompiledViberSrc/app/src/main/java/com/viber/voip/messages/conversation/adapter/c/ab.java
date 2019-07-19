package com.viber.voip.messages.conversation.adapter.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.fm.FormattedMessageConstraintHelper;
import com.viber.voip.messages.ui.view.AnimatedLikesView;
import com.viber.voip.ui.g.f;
import com.viber.voip.widget.FormattedMessageLayout;

public class ab
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
  public final FormattedMessageLayout o;
  public final FormattedMessageConstraintHelper p;
  public final ImageView q;
  public final ImageView r;
  public final TextView s;

  public ab(View paramView)
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
    this.n = ((TextView)paramView.findViewById(R.id.referralView));
    this.o = ((FormattedMessageLayout)paramView.findViewById(R.id.formattedMessageView));
    this.p = ((FormattedMessageConstraintHelper)paramView.findViewById(R.id.formattedMessageHelperView));
    this.q = ((ImageView)paramView.findViewById(R.id.forwardView));
    this.r = ((ImageView)paramView.findViewById(R.id.offerClickerView));
    this.s = ((TextView)paramView.findViewById(R.id.editedView));
  }

  public View a()
  {
    return this.o;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.c.ab
 * JD-Core Version:    0.6.2
 */
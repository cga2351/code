package com.viber.voip.messages.conversation.adapter.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.ui.g.f;

public class an
  implements f
{
  public final TextView a;
  public final ImageView b;
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
  public final LinearLayout o;
  public final TextView p;

  public an(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(R.id.timestampView));
    this.b = ((ImageView)paramView.findViewById(R.id.locationView));
    this.c = ((ImageView)paramView.findViewById(R.id.broadcastView));
    this.d = ((ImageView)paramView.findViewById(R.id.statusView));
    this.e = ((ImageView)paramView.findViewById(R.id.resendView));
    this.f = paramView.findViewById(R.id.balloonView);
    this.g = ((TextView)paramView.findViewById(R.id.dateHeaderView));
    this.h = ((TextView)paramView.findViewById(R.id.newMessageHeaderView));
    this.i = ((TextView)paramView.findViewById(R.id.loadMoreMessagesView));
    this.j = paramView.findViewById(R.id.loadingMessagesLabelView);
    this.k = paramView.findViewById(R.id.loadingMessagesAnimationView);
    this.l = paramView.findViewById(R.id.headersSpace);
    this.m = paramView.findViewById(R.id.selectionView);
    this.o = ((LinearLayout)paramView.findViewById(R.id.optionsContainerView));
    this.p = ((TextView)paramView.findViewById(R.id.voteTitleView));
    this.n = ((TextView)paramView.findViewById(R.id.voteCountView));
  }

  public View a()
  {
    return this.o;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.c.an
 * JD-Core Version:    0.6.2
 */
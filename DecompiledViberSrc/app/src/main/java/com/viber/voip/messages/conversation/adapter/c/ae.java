package com.viber.voip.messages.conversation.adapter.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.ui.view.AnimatedLikesView;
import com.viber.voip.ui.g.f;
import com.viber.voip.widget.VideoPttMessageLayout;

public class ae
  implements f
{
  public final AnimatedLikesView a;
  public final TextView b;
  public final ImageView c;
  public final ImageView d;
  public final ImageView e;
  public final TextView f;
  public final TextView g;
  public final TextView h;
  public final View i;
  public final View j;
  public final View k;
  public final View l;
  public final TextView m;
  public final VideoPttMessageLayout n;

  public ae(View paramView)
  {
    this.a = ((AnimatedLikesView)paramView.findViewById(R.id.likeView));
    this.b = ((TextView)paramView.findViewById(R.id.timestampView));
    this.c = ((ImageView)paramView.findViewById(R.id.locationView));
    this.d = ((ImageView)paramView.findViewById(R.id.broadcastView));
    this.e = ((ImageView)paramView.findViewById(R.id.statusView));
    this.f = ((TextView)paramView.findViewById(R.id.dateHeaderView));
    this.g = ((TextView)paramView.findViewById(R.id.newMessageHeaderView));
    this.h = ((TextView)paramView.findViewById(R.id.loadMoreMessagesView));
    this.i = paramView.findViewById(R.id.loadingMessagesLabelView);
    this.j = paramView.findViewById(R.id.loadingMessagesAnimationView);
    this.k = paramView.findViewById(R.id.headersSpace);
    this.l = paramView.findViewById(R.id.selectionView);
    this.m = ((TextView)paramView.findViewById(R.id.referralView));
    this.n = ((VideoPttMessageLayout)paramView.findViewById(R.id.ivmPlayer));
  }

  public View a()
  {
    return this.n;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.c.ae
 * JD-Core Version:    0.6.2
 */
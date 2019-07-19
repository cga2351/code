package com.viber.voip.messages.conversation.adapter.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.rm.RichMessageBottomConstraintHelper;
import com.viber.voip.ui.g.f;

public class ag
  implements f
{
  public final View a;
  public final View b;
  public final View c;
  public final RecyclerView d;
  public final TextView e;
  public final TextView f;
  public final TextView g;
  public final TextView h;
  public final TextView i;
  public final View j;
  public final View k;
  public final ImageView l;
  public final RichMessageBottomConstraintHelper m;

  public ag(View paramView)
  {
    this.a = paramView.findViewById(R.id.headersSpace);
    this.b = paramView.findViewById(R.id.selectionView);
    this.c = paramView.findViewById(R.id.balloonView);
    this.d = ((RecyclerView)paramView.findViewById(R.id.richMsgRecyclerView));
    this.e = ((TextView)paramView.findViewById(R.id.sentViaView));
    this.f = ((TextView)paramView.findViewById(R.id.timestampView));
    this.g = ((TextView)paramView.findViewById(R.id.dateHeaderView));
    this.h = ((TextView)paramView.findViewById(R.id.newMessageHeaderView));
    this.i = ((TextView)paramView.findViewById(R.id.loadMoreMessagesView));
    this.j = paramView.findViewById(R.id.loadingMessagesLabelView);
    this.k = paramView.findViewById(R.id.loadingMessagesAnimationView);
    this.l = ((ImageView)paramView.findViewById(R.id.statusView));
    this.m = ((RichMessageBottomConstraintHelper)paramView.findViewById(R.id.bottomConstraintHelper));
  }

  public View a()
  {
    return this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.c.ag
 * JD-Core Version:    0.6.2
 */
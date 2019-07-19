package com.viber.voip.messages.conversation.adapter.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.ui.g.f;

public class a
  implements f
{
  public final TextView a;
  public final TextView b;
  public final TextView c;
  public final View d;
  public final View e;
  public final TextView f;
  public final TextView g;
  public final TextView h;
  public final TextView i;
  public final View j;
  public final View k;
  public final ImageView l;
  public final TextView m;
  public final View n;

  public a(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(R.id.dateHeaderView));
    this.b = ((TextView)paramView.findViewById(R.id.newMessageHeaderView));
    this.c = ((TextView)paramView.findViewById(R.id.loadMoreMessagesView));
    this.d = paramView.findViewById(R.id.loadingMessagesLabelView);
    this.e = paramView.findViewById(R.id.loadingMessagesAnimationView);
    this.f = ((TextView)paramView.findViewById(R.id.textMessageView));
    this.g = ((TextView)paramView.findViewById(R.id.callDescriptionView));
    this.h = ((TextView)paramView.findViewById(R.id.callSubtitleView));
    this.i = ((TextView)paramView.findViewById(R.id.callSubDescriptionView));
    this.k = paramView.findViewById(R.id.selectionView);
    this.j = paramView.findViewById(R.id.headersSpace);
    this.l = ((ImageView)paramView.findViewById(R.id.callRedialView));
    this.m = ((TextView)paramView.findViewById(R.id.timestampView));
    this.n = paramView.findViewById(R.id.balloonView);
  }

  public View a()
  {
    return this.n;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.c.a
 * JD-Core Version:    0.6.2
 */
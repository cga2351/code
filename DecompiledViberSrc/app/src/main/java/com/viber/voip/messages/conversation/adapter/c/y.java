package com.viber.voip.messages.conversation.adapter.c;

import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.ui.g.f;

public class y
  implements f
{
  public final TextView a;
  public final TextView b;
  public final TextView c;
  public final View d;
  public final View e;
  public final TextView f;
  public final View g;
  public final View h;
  public final View i;

  public y(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(R.id.dateHeaderView));
    this.b = ((TextView)paramView.findViewById(R.id.newMessageHeaderView));
    this.c = ((TextView)paramView.findViewById(R.id.loadMoreMessagesView));
    this.d = paramView.findViewById(R.id.loadingMessagesLabelView);
    this.e = paramView.findViewById(R.id.loadingMessagesAnimationView);
    this.f = ((TextView)paramView.findViewById(R.id.textMessageView));
    this.h = paramView.findViewById(R.id.selectionView);
    this.g = paramView.findViewById(R.id.headersSpace);
    this.i = paramView.findViewById(R.id.balloonView);
  }

  public View a()
  {
    return this.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.c.y
 * JD-Core Version:    0.6.2
 */
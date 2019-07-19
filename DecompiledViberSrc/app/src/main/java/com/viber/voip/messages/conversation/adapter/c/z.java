package com.viber.voip.messages.conversation.adapter.c;

import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.ui.g.f;

public class z
  implements f
{
  public final TextView a;
  public final TextView b;
  public final TextView c;
  public final TextView d;
  public final View e;
  public final View f;
  public final View g;
  public final View h;
  public final View i;
  public final TextView j;

  public z(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(R.id.timestampView));
    this.b = ((TextView)paramView.findViewById(R.id.dateHeaderView));
    this.c = ((TextView)paramView.findViewById(R.id.newMessageHeaderView));
    this.d = ((TextView)paramView.findViewById(R.id.loadMoreMessagesView));
    this.e = paramView.findViewById(R.id.loadingMessagesLabelView);
    this.f = paramView.findViewById(R.id.loadingMessagesAnimationView);
    this.g = paramView.findViewById(R.id.headersSpace);
    this.h = paramView.findViewById(R.id.selectionView);
    this.i = paramView.findViewById(R.id.balloonView);
    this.j = ((TextView)paramView.findViewById(R.id.textMessageView));
  }

  public View a()
  {
    return this.j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.c.z
 * JD-Core Version:    0.6.2
 */
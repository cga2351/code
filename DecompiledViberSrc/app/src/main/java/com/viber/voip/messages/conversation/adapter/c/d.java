package com.viber.voip.messages.conversation.adapter.c;

import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;

public class d extends c
{
  public final TextView b;
  public final View c;
  public final View d;

  public d(View paramView)
  {
    super(paramView);
    this.b = ((TextView)paramView.findViewById(R.id.loadMoreMessagesView));
    this.c = paramView.findViewById(R.id.loadingMessagesLabelView);
    this.d = paramView.findViewById(R.id.loadingMessagesAnimationView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.c.d
 * JD-Core Version:    0.6.2
 */
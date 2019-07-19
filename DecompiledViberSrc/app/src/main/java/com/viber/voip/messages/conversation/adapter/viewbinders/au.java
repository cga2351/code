package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.d.x;
import com.viber.voip.ui.d.g;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.PercentConstraintLayout;

public class au
{
  private final View a;
  private final com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e<PercentConstraintLayout> b;
  private final com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e<TextView> c;
  private final com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e<TextView> d;
  private final com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e<ImageView> e;
  private final com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e<View> f;
  private final x g;
  private final View.OnCreateContextMenuListener h;

  public au(View paramView, x paramx, View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    this.a = paramView;
    this.g = paramx;
    this.h = paramOnCreateContextMenuListener;
    this.b = new com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e((ViewStub)paramView.findViewById(R.id.replyView));
    this.c = new com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e(this.b, R.id.replyAuthorView);
    this.d = new com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e(this.b, R.id.replyQuoteView);
    this.e = new com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e(this.b, R.id.replyIconView);
    this.f = new com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e(this.b, R.id.replyPlayIconView);
  }

  public com.viber.voip.ui.g.e<a, i> a()
  {
    d[] arrayOfd = new d[4];
    arrayOfd[0] = new at(this.a, this.b, new g(), this.g, this.h);
    arrayOfd[1] = new aq(this.c);
    arrayOfd[2] = new as(this.d);
    arrayOfd[3] = new ar(this.b, this.e, this.f);
    return new b(arrayOfd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.au
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.messages.ui;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.messages.o;
import com.viber.voip.ui.d.f;

public class cb extends k
{
  private View b;
  private View c;
  private TextView d;
  private ImageView e;

  public cb(View paramView)
  {
    super(paramView);
    this.b = paramView;
    this.c = paramView.findViewById(R.id.btn_confirm);
    this.d = ((TextView)paramView.findViewById(R.id.description));
    this.e = ((ImageView)paramView.findViewById(R.id.svg_icon));
  }

  public void a(o paramo)
  {
    super.a(paramo);
    if (paramo != null)
    {
      if (this.c != null)
        this.c.setOnClickListener(paramo.a());
      if (this.a != null)
        this.a.setOnClickListener(paramo.a());
      if (this.d != null)
      {
        TextView localTextView = this.d;
        Context localContext = this.b.getContext();
        int i = R.string.hidden_chat_activity_success_description;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramo.e();
        localTextView.setText(Html.fromHtml(localContext.getString(i, arrayOfObject)));
      }
      if (this.e != null)
      {
        f localf = new f("svg/hidden-chat-how-to-search.svg");
        localf.a();
        this.e.setImageDrawable(localf);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.cb
 * JD-Core Version:    0.6.2
 */
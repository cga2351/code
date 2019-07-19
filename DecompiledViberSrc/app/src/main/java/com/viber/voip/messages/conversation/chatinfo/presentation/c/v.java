package com.viber.voip.messages.conversation.chatinfo.presentation.c;

import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.chatinfo.d.n;
import com.viber.voip.messages.conversation.chatinfo.e.e;
import com.viber.voip.messages.conversation.chatinfo.presentation.b.p;

public class v extends g<n>
{
  private final TextView a;
  private n b;

  public v(View paramView, p paramp)
  {
    super(paramView);
    this.itemView.setOnClickListener(new w(this, paramp));
    this.a = ((TextView)this.itemView.findViewById(R.id.title));
  }

  public void a(n paramn, e parame)
  {
    this.b = paramn;
    this.a.setText(paramn.a());
    this.a.setEnabled(paramn.b());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.c.v
 * JD-Core Version:    0.6.2
 */
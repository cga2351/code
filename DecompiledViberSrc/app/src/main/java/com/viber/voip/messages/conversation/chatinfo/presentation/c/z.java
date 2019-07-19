package com.viber.voip.messages.conversation.chatinfo.presentation.c;

import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.chatinfo.d.p;
import com.viber.voip.messages.conversation.chatinfo.e.e;

public class z extends g<p>
{
  private final TextView a = (TextView)this.itemView.findViewById(R.id.title);

  public z(View paramView)
  {
    super(paramView);
  }

  public void a(p paramp, e parame)
  {
    this.a.setText(paramp.a());
    this.a.setPadding(0, paramp.b(), 0, 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.c.z
 * JD-Core Version:    0.6.2
 */
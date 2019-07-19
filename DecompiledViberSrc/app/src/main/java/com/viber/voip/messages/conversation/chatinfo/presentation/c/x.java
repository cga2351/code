package com.viber.voip.messages.conversation.chatinfo.presentation.c;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.chatinfo.d.o;
import com.viber.voip.messages.conversation.chatinfo.e.e;
import com.viber.voip.messages.conversation.chatinfo.presentation.b.q;

public class x extends g<o>
{
  private final TextView a = (TextView)this.itemView.findViewById(R.id.trustBtn);
  private final TextView b;
  private o c;

  public x(View paramView, q paramq)
  {
    super(paramView);
    this.a.setOnClickListener(new y(this, paramq));
    this.b = ((TextView)this.itemView.findViewById(R.id.trustBtnDescription));
  }

  public void a(o paramo, e parame)
  {
    this.c = paramo;
    this.a.setClickable(paramo.a());
    this.a.setText(paramo.b());
    if (paramo.f() == 0);
    for (Drawable localDrawable = null; ; localDrawable = this.a.getResources().getDrawable(paramo.f()))
    {
      this.a.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
      this.b.setText(paramo.c());
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.c.x
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.messages.conversation.chatinfo.presentation.c;

import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.chatinfo.d.j;
import com.viber.voip.messages.conversation.chatinfo.e.e;
import com.viber.voip.messages.conversation.chatinfo.presentation.b.l;
import com.viber.voip.util.da;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;

public class n extends g<j>
{
  private final TextView a;
  private final TextView b;
  private j c;

  public n(View paramView, l paraml)
  {
    super(paramView);
    this.itemView.setOnClickListener(new o(this, paraml));
    this.a = ((TextView)this.itemView.findViewById(R.id.leftText));
    this.b = ((TextView)this.itemView.findViewById(R.id.rightText));
  }

  public void a(j paramj, e parame)
  {
    this.c = paramj;
    this.itemView.setPadding(this.itemView.getPaddingLeft(), this.itemView.getPaddingTop(), this.itemView.getPaddingRight(), paramj.g());
    this.a.setText(paramj.a());
    this.a.setTextColor(dc.d(this.itemView.getContext(), paramj.c()));
    this.a.setTextSize(0, paramj.f());
    String str = paramj.b();
    if (da.a(str))
      dj.b(this.b, false);
    while ((paramj.e() == 4) || (paramj.e() == 5))
    {
      this.a.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_chevron_selecttor, 0);
      return;
      this.b.setText(str);
      dj.b(this.b, true);
    }
    this.a.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.c.n
 * JD-Core Version:    0.6.2
 */
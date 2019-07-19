package com.viber.voip.messages.adapters.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.ui.g.f;

public class k
  implements f
{
  public final TextView a;
  public final TextView b;
  public final View c;
  public final View d;
  public final View e;
  public TextView f;
  public final TextView g;
  public final TextView h;
  public final ImageView i;

  public k(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(R.id.unread_messages_count));
    this.b = ((TextView)paramView.findViewById(R.id.additional_info));
    this.c = paramView.findViewById(R.id.edit_icon);
    this.d = paramView.findViewById(R.id.from_container);
    this.e = paramView.findViewById(R.id.chat_icon);
    this.f = ((TextView)paramView.findViewById(R.id.date));
    this.g = ((TextView)paramView.findViewById(R.id.subject));
    this.h = ((TextView)paramView.findViewById(R.id.from));
    this.i = ((ImageView)paramView.findViewById(R.id.public_group_icon));
  }

  public View a()
  {
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.b.k
 * JD-Core Version:    0.6.2
 */
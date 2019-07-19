package com.viber.voip.messages.adapters.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.ui.g.f;

public class l
  implements f
{
  public final TextView a;
  public TextView b;
  public final View c;
  public final View d;
  public final TextView e;
  public final ImageView f;
  public final TextView g;

  public l(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(R.id.unread_messages_count));
    this.b = ((TextView)paramView.findViewById(R.id.date));
    this.c = paramView.findViewById(R.id.favourite_icon);
    this.d = paramView.findViewById(R.id.favourite);
    this.e = ((TextView)paramView.findViewById(R.id.from));
    this.f = ((ImageView)paramView.findViewById(R.id.icon));
    this.g = ((TextView)paramView.findViewById(R.id.subject));
  }

  public View a()
  {
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.b.l
 * JD-Core Version:    0.6.2
 */
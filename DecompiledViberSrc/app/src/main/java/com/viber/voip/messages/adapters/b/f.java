package com.viber.voip.messages.adapters.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.widget.GroupIconView;

public class f
  implements com.viber.voip.ui.g.f
{
  public final ImageView a;
  public final TextView b;
  public TextView c;
  public final TextView d;
  public final TextView e;
  public final View f;
  public final View g;
  public final GroupIconView h;
  public ImageView i;

  public f(View paramView)
  {
    this.a = ((ImageView)paramView.findViewById(R.id.status_icon));
    this.b = ((TextView)paramView.findViewById(R.id.unread_messages_count));
    this.c = ((TextView)paramView.findViewById(R.id.date));
    this.d = ((TextView)paramView.findViewById(R.id.subject));
    this.e = ((TextView)paramView.findViewById(R.id.from));
    this.f = paramView.findViewById(R.id.favourite_icon);
    this.g = paramView.findViewById(R.id.favourite);
    this.h = ((GroupIconView)paramView.findViewById(R.id.icon));
    this.i = ((ImageView)paramView.findViewById(R.id.message_status_icon));
  }

  public View a()
  {
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.b.f
 * JD-Core Version:    0.6.2
 */
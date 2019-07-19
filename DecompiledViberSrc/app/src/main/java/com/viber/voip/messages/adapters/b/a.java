package com.viber.voip.messages.adapters.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.ui.g.f;

public class a
  implements f
{
  public final TextView a;
  public TextView b;
  public final TextView c;
  public final View d;
  public final View e;
  public final TextView f;
  public final ImageView g;

  public a(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(R.id.unread_messages_count));
    this.b = ((TextView)paramView.findViewById(R.id.date));
    this.c = ((TextView)paramView.findViewById(R.id.subject));
    this.d = paramView.findViewById(R.id.favourite_icon);
    this.e = paramView.findViewById(R.id.favourite);
    this.f = ((TextView)paramView.findViewById(R.id.from));
    this.g = ((ImageView)paramView.findViewById(R.id.icon));
  }

  public View a()
  {
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.b.a
 * JD-Core Version:    0.6.2
 */
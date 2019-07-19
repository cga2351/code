package com.viber.voip.messages.adapters.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.ui.g.f;
import com.viber.voip.widget.AvatarWithInitialsView;

public class c
  implements f
{
  public final ImageView a;
  public final TextView b;
  public final ImageView c;
  public TextView d;
  public final View e;
  public final TextView f;
  public final TextView g;
  public final View h;
  public final View i;
  public final AvatarWithInitialsView j;
  public ImageView k;

  public c(View paramView)
  {
    this.a = ((ImageView)paramView.findViewById(R.id.status_icon));
    this.b = ((TextView)paramView.findViewById(R.id.unread_messages_count));
    this.c = ((ImageView)paramView.findViewById(R.id.unread_calls_icon));
    this.d = ((TextView)paramView.findViewById(R.id.date));
    this.e = paramView.findViewById(R.id.new_label);
    this.f = ((TextView)paramView.findViewById(R.id.subject));
    this.g = ((TextView)paramView.findViewById(R.id.from));
    this.h = paramView.findViewById(R.id.favourite_icon);
    this.i = paramView.findViewById(R.id.favourite);
    this.j = ((AvatarWithInitialsView)paramView.findViewById(R.id.icon));
    this.k = ((ImageView)paramView.findViewById(R.id.message_status_icon));
  }

  public View a()
  {
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.b.c
 * JD-Core Version:    0.6.2
 */
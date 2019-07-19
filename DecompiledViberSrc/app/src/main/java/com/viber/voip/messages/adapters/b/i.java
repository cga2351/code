package com.viber.voip.messages.adapters.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.ui.g.f;
import com.viber.voip.widget.AvatarWithInitialsView;

public class i
  implements f
{
  public final TextView a;
  public TextView b;
  public final TextView c;
  public final TextView d;
  public final AvatarWithInitialsView e;
  public final ImageView f;

  public i(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(R.id.unread_messages_count));
    this.b = ((TextView)paramView.findViewById(R.id.date));
    this.c = ((TextView)paramView.findViewById(R.id.subject));
    this.d = ((TextView)paramView.findViewById(R.id.from));
    this.e = ((AvatarWithInitialsView)paramView.findViewById(R.id.icon));
    this.f = ((ImageView)paramView.findViewById(R.id.message_status_icon));
  }

  public View a()
  {
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.b.i
 * JD-Core Version:    0.6.2
 */
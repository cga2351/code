package com.viber.voip.messages.adapters.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.ui.g.f;

public class j
  implements f
{
  public final View a;
  public final View b;
  public final View c;
  public final TextView d;
  public final ImageView e;

  public j(View paramView)
  {
    this.a = paramView.findViewById(R.id.edit_icon);
    this.b = paramView.findViewById(R.id.from_container);
    this.c = paramView.findViewById(R.id.chat_icon);
    this.d = ((TextView)paramView.findViewById(R.id.from));
    this.e = ((ImageView)paramView.findViewById(R.id.public_group_icon));
  }

  public View a()
  {
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.b.j
 * JD-Core Version:    0.6.2
 */
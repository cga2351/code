package com.viber.voip.messages.adapters.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.ui.g.f;
import com.viber.voip.widget.GroupIconView;

public class e
  implements f
{
  public final ImageView a;
  public View b;
  public TextView c;
  public final TextView d;
  public final GroupIconView e;

  public e(View paramView)
  {
    this.a = ((ImageView)paramView.findViewById(R.id.status_icon));
    this.b = paramView.findViewById(R.id.conversation_header);
    this.c = ((TextView)this.b.findViewById(R.id.label));
    this.d = ((TextView)paramView.findViewById(R.id.from));
    this.e = ((GroupIconView)paramView.findViewById(R.id.group_icon));
  }

  public View a()
  {
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.b.e
 * JD-Core Version:    0.6.2
 */
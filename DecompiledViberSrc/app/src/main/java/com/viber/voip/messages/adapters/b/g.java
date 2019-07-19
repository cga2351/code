package com.viber.voip.messages.adapters.b;

import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.ui.g.f;
import com.viber.voip.widget.AccurateChronometer;
import com.viber.voip.widget.GroupIconView;

public class g
  implements f
{
  public final ViberTextView a;
  public final AccurateChronometer b;
  public final View c;
  public final TextView d;
  public final View e;
  public final View f;
  public final GroupIconView g;

  public g(View paramView)
  {
    this.a = ((ViberTextView)paramView.findViewById(R.id.subject));
    this.b = ((AccurateChronometer)paramView.findViewById(R.id.ongoingConferenceDuration));
    this.c = paramView.findViewById(R.id.joinParticipant);
    this.d = ((TextView)paramView.findViewById(R.id.from));
    this.e = paramView.findViewById(R.id.favourite_icon);
    this.f = paramView.findViewById(R.id.favourite);
    this.g = ((GroupIconView)paramView.findViewById(R.id.icon));
  }

  public View a()
  {
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.b.g
 * JD-Core Version:    0.6.2
 */
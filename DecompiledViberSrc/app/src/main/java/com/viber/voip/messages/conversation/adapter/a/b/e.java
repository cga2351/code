package com.viber.voip.messages.conversation.adapter.a.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.adapter.s;
import com.viber.voip.messages.conversation.adapter.w;

public class e extends d
{
  private TextView b;

  public e(View paramView)
  {
    super(paramView, false);
    this.b = ((TextView)paramView.findViewById(R.id.tx_right_text));
  }

  public void a(s params)
  {
    super.a(params);
    w localw = (w)params;
    if (!TextUtils.isEmpty(localw.b()))
    {
      this.b.setText(localw.b());
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.a.b.e
 * JD-Core Version:    0.6.2
 */
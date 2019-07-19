package com.viber.voip.contacts.ui;

import android.widget.TextView;
import com.viber.voip.R.string;
import com.viber.voip.messages.adapters.p;
import com.viber.voip.messages.adapters.s;

public class bj extends bh
{
  protected p a(boolean paramBoolean, int paramInt)
  {
    return new s(R.string.subtitle_votes, this.e, this.c);
  }

  protected void a(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, String paramString)
  {
    this.d = true;
    a(paramLong3);
  }

  protected void a(boolean paramBoolean)
  {
    this.b.setText("");
    this.a.setText(new s(R.string.subtitle_votes, 0, this.c).a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.bj
 * JD-Core Version:    0.6.2
 */
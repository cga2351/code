package com.viber.voip.ui;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.j;

public class k extends x
{
  private int e;

  public k(int paramInt)
  {
    this.e = paramInt;
  }

  protected void a()
  {
    ImageView localImageView = this.c.d;
    if (this.e == 0);
    for (int i = R.drawable.empty_thats_awkward; ; i = R.drawable.empty_no_groups)
    {
      localImageView.setImageResource(i);
      return;
    }
  }

  protected void a(int paramInt)
  {
    if (this.c.b != null)
    {
      if (2 == paramInt)
        this.c.b.setText(R.string.noMessagesFound);
    }
    else
      return;
    TextView localTextView = this.c.b;
    if (this.e == 0);
    for (int i = R.string.no_recents_yet; ; i = R.string.no_groups_yet)
    {
      localTextView.setText(i);
      return;
    }
  }

  protected void a(j paramj, boolean paramBoolean)
  {
    d(false);
    this.b.setVisibility(0);
    b(0);
    Button localButton = this.c.f;
    if (paramBoolean);
    for (int i = 0; ; i = 8)
    {
      localButton.setVisibility(i);
      this.c.c.setVisibility(8);
      this.a.setVisibility(8);
      this.c.b.setVisibility(0);
      this.c.d.setVisibility(0);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.k
 * JD-Core Version:    0.6.2
 */
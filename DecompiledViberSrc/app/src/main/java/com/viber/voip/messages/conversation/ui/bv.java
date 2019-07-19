package com.viber.voip.messages.conversation.ui;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.viber.common.d.a;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.ui.ViberTextView;

public class bv extends LinearLayout
{
  private ImageView a;
  private ViberTextView b;
  private LinearLayout.LayoutParams c;
  private LinearLayout.LayoutParams d;

  public bv(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    Resources localResources = paramContext.getResources();
    setOrientation(1);
    setPadding(localResources.getDimensionPixelOffset(R.dimen.share_screenshot_button_padding), 0, localResources.getDimensionPixelOffset(R.dimen.share_screenshot_button_padding), 0);
    this.c = new LinearLayout.LayoutParams(-2, -2);
    this.c.gravity = 1;
    this.a = new ImageView(paramContext);
    this.a.setLayoutParams(this.c);
    this.d = new LinearLayout.LayoutParams(-2, -2);
    this.d.topMargin = localResources.getDimensionPixelOffset(R.dimen.share_screenshot_button_text_top_margin);
    this.d.gravity = 1;
    this.b = new ViberTextView(paramContext);
    this.b.setLayoutParams(this.d);
    if (a.j())
      this.b.setTextColor(localResources.getColor(R.color.solid_50, null));
    while (true)
    {
      addView(this.a);
      addView(this.b);
      return;
      this.b.setTextColor(localResources.getColor(R.color.solid_50));
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.a.setImageResource(paramInt1);
    this.b.setText(paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.bv
 * JD-Core Version:    0.6.2
 */
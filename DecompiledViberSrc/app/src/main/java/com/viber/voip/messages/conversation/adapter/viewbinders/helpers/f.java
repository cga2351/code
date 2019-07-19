package com.viber.voip.messages.conversation.adapter.viewbinders.helpers;

import android.view.View;
import com.viber.common.d.a;

public class f
{
  private final View a;

  public f(View paramView)
  {
    this.a = paramView;
  }

  public final void a(float paramFloat1, float paramFloat2)
  {
    if (a.k())
    {
      this.a.performLongClick(paramFloat1, paramFloat2);
      return;
    }
    this.a.performLongClick();
  }

  public final void a(boolean paramBoolean)
  {
    this.a.setPressed(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.f
 * JD-Core Version:    0.6.2
 */
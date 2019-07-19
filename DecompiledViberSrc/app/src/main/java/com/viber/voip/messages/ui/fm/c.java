package com.viber.voip.messages.ui.fm;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Button;
import com.viber.voip.R.dimen;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.e.b;
import com.viber.voip.messages.orm.entity.json.ButtonMessage;
import com.viber.voip.ui.ViberButton;

public class c extends a<Button>
{
  private final ButtonMessage g;
  private final int h;

  public c(ButtonMessage paramButtonMessage, Context paramContext, com.viber.voip.messages.conversation.adapter.a.a parama, i parami, b paramb)
  {
    super(paramButtonMessage, paramContext, parama, parami, paramb);
    this.g = paramButtonMessage;
    this.h = paramContext.getResources().getDimensionPixelOffset(R.dimen.formatted_message_button_horizontal_padding);
  }

  public void a(Button paramButton)
  {
    super.a(paramButton);
    paramButton.setText(this.g.getCaption());
    paramButton.setPadding(this.h, paramButton.getPaddingTop(), this.h, paramButton.getPaddingBottom());
  }

  public Button d()
  {
    return new ViberButton(this.a, null, 16842825);
  }

  public int e()
  {
    return this.a.getResources().getDimensionPixelSize(R.dimen.formatted_message_button_padding);
  }

  public int f()
  {
    return this.a.getResources().getDimensionPixelSize(R.dimen.formatted_message_button_padding);
  }

  public ButtonMessage g()
  {
    return this.g;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.fm.c
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.messages.ui.fm;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.e.b;
import com.viber.voip.messages.orm.entity.json.SeparatorMessage;

public class j extends a<View>
{
  private final SeparatorMessage g;

  public j(SeparatorMessage paramSeparatorMessage, Context paramContext, com.viber.voip.messages.conversation.adapter.a.a parama, i parami, b paramb)
  {
    super(paramSeparatorMessage, paramContext, parama, parami, paramb);
    this.g = paramSeparatorMessage;
  }

  private LinearLayout.LayoutParams g()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, j());
    localLayoutParams.setMargins(localLayoutParams.leftMargin, l(), localLayoutParams.rightMargin, m());
    return localLayoutParams;
  }

  private int j()
  {
    return -2;
  }

  private int k()
  {
    return R.drawable.message_data_divider_arrow;
  }

  private int l()
  {
    return this.a.getResources().getDimensionPixelSize(R.dimen.formatted_message_separator_space_top);
  }

  private int m()
  {
    return this.a.getResources().getDimensionPixelSize(R.dimen.formatted_message_separator_space_bottom);
  }

  public void a(View paramView)
  {
    super.a(paramView);
    paramView.setLayoutParams(g());
    paramView.setBackgroundResource(k());
  }

  public SeparatorMessage d()
  {
    return this.g;
  }

  public int e()
  {
    return 0;
  }

  public int f()
  {
    return 0;
  }

  public View i()
  {
    return new View(this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.fm.j
 * JD-Core Version:    0.6.2
 */
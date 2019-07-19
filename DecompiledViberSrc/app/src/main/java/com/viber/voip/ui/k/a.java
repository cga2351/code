package com.viber.voip.ui.k;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.view.View;
import com.viber.common.ui.c;
import com.viber.common.ui.c.a;
import com.viber.common.ui.c.b;
import com.viber.common.ui.c.d;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.string;

public class a
{
  private static c.b a(View paramView, Context paramContext)
  {
    return new c.b().a(2000L).b(1).i(paramContext.getResources().getDimensionPixelSize(R.dimen.record_message_hold_to_record_tooltip_max_width)).a(paramView);
  }

  public static c a(Context paramContext, View paramView)
  {
    return new c.b().a(Html.fromHtml(paramContext.getString(R.string.chatex_suggestions_tooltip))).a(1).a(paramView).a(c.a.b).b(true).c(true).a(true).a(paramContext);
  }

  public static c a(View paramView)
  {
    Context localContext = paramView.getContext();
    Resources localResources = localContext.getResources();
    return new c.b().a(c.d.a).d(false).c(R.string.voice_message_limit_msg).a(true).d(ContextCompat.getColor(localContext, R.color.tooltip_bg_red)).f(localResources.getDimensionPixelOffset(R.dimen.record_message_max_record_tooltip_offset)).g(localResources.getDimensionPixelOffset(R.dimen.record_message_max_record_tooltip_padding)).a(paramView).a(localContext);
  }

  public static c a(View paramView, Context paramContext, boolean paramBoolean)
  {
    c.b localb = a(paramView, paramContext);
    if (paramBoolean);
    for (int i = R.string.video_ptt_instruction; ; i = R.string.voice_message_button_tooltip)
    {
      localb.c(i);
      return localb.a(paramContext);
    }
  }

  public static c a(View paramView, boolean paramBoolean)
  {
    Context localContext = paramView.getContext();
    if (paramBoolean);
    for (int i = localContext.getResources().getDimensionPixelOffset(R.dimen.world_credit_tooltip_tablet_left_offset); ; i = paramView.getWidth() / 4)
      return new c.b().a(c.d.b).d(true).c(R.string.world_credits_tooltip).a(paramView).b(1).a(c.a.b).f(-localContext.getResources().getDimensionPixelOffset(R.dimen.world_credit_tooltip_top_padding)).e(i).a(b.a).a(localContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.k.a
 * JD-Core Version:    0.6.2
 */
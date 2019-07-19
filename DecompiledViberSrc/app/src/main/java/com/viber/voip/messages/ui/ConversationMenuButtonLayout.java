package com.viber.voip.messages.ui;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;
import com.viber.common.d.a;
import com.viber.voip.R.layout;
import com.viber.voip.util.dg;

public class ConversationMenuButtonLayout extends c
{
  private boolean d;
  private CharSequence e;
  private Spannable f;

  public ConversationMenuButtonLayout(Context paramContext)
  {
    super(paramContext);
  }

  public ConversationMenuButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void a()
  {
    if ((this.e != null) || (this.d))
    {
      this.c.setVisibility(0);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if (this.e != null)
      {
        localSpannableStringBuilder.append(this.e);
        if (this.d)
          localSpannableStringBuilder.append("  ");
      }
      if (this.d)
        localSpannableStringBuilder.append(this.f);
      this.c.setText(localSpannableStringBuilder);
      return;
    }
    this.c.setVisibility(8);
  }

  protected void a(Context paramContext)
  {
    super.a(paramContext);
    this.f = dg.a(paramContext);
  }

  protected int getLayoutId()
  {
    if ((!a.b()) && (com.viber.common.d.c.a()))
      return R.layout._ics_conversation_menu_btn_content_rtl_pre_v17_support;
    return R.layout._ics_conversation_menu_btn_content;
  }

  public void setNew(boolean paramBoolean)
  {
    this.d = paramBoolean;
    a();
  }

  public void setSubtext(CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
    a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.ConversationMenuButtonLayout
 * JD-Core Version:    0.6.2
 */
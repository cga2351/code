package com.viber.voip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.util.dj;
import java.text.DateFormat;
import java.util.Date;

public class TextViewWithDescriptionAndCountdown extends TextViewWithDescription
{
  private DateFormat e = DateFormat.getTimeInstance(3);
  private Date f = new Date();
  private TextView g;

  public TextViewWithDescriptionAndCountdown(Context paramContext)
  {
    super(paramContext);
  }

  public TextViewWithDescriptionAndCountdown(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public TextViewWithDescriptionAndCountdown(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void a(long paramLong)
  {
    this.f.setTime(paramLong);
    this.g.setText(this.e.format(this.f));
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    int i;
    Resources localResources;
    int j;
    if (b())
    {
      i = 9;
      localLayoutParams.addRule(i);
      localLayoutParams.addRule(4, getBodyViewId());
      localResources = getResources();
      j = localResources.getDimensionPixelSize(R.dimen.text_view_with_description_right_drawable_right_margin);
      if (!b())
        break label144;
      localLayoutParams.leftMargin = j;
    }
    while (true)
    {
      this.g = new ViberTextView(paramContext);
      this.g.setLayoutParams(localLayoutParams);
      this.g.setTextSize(2, 13.0F);
      this.g.setTextColor(ResourcesCompat.getColor(localResources, R.color.text_hint_color, null));
      this.g.setVisibility(8);
      addView(this.g);
      return;
      i = 11;
      break;
      label144: localLayoutParams.rightMargin = j;
    }
  }

  public void a(ViewWithDescription.a parama, CharSequence paramCharSequence)
  {
    super.a(parama, paramCharSequence);
    switch (1.a[getState().ordinal()])
    {
    default:
      return;
    case 1:
    case 2:
    case 3:
    case 4:
    }
    a(false);
  }

  public void a(boolean paramBoolean)
  {
    dj.b(this.g, paramBoolean);
  }

  public void setCountdownFormat(DateFormat paramDateFormat)
  {
    this.e = paramDateFormat;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.TextViewWithDescriptionAndCountdown
 * JD-Core Version:    0.6.2
 */
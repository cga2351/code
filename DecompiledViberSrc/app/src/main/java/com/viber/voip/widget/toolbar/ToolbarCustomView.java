package com.viber.voip.widget.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.viber.common.d.c;
import com.viber.voip.R.id;
import com.viber.voip.util.da;

public class ToolbarCustomView extends RelativeLayout
{
  public TextView b;
  public TextView c;

  public ToolbarCustomView(Context paramContext)
  {
    super(paramContext);
  }

  public ToolbarCustomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ToolbarCustomView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    int i;
    if (da.a(paramCharSequence))
    {
      TextView localTextView = this.c;
      if (paramBoolean)
      {
        i = 4;
        localTextView.setVisibility(i);
      }
    }
    while (true)
    {
      this.c.setText(paramCharSequence);
      return;
      i = 8;
      break;
      this.c.setVisibility(0);
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = ((TextView)findViewById(R.id.toolbar_custom_title));
    this.c = ((TextView)findViewById(R.id.toolbar_custom_subtitle));
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    if (da.a(paramCharSequence))
      this.b.setVisibility(8);
    while (true)
    {
      this.b.setText(c.a(paramCharSequence));
      return;
      this.b.setVisibility(0);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.toolbar.ToolbarCustomView
 * JD-Core Version:    0.6.2
 */
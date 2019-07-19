package com.viber.voip.widget.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.viber.voip.R.id;

public class PublicAccountInfoToolbarView extends ToolbarCustomView
{
  public View a;

  public PublicAccountInfoToolbarView(Context paramContext)
  {
    super(paramContext);
  }

  public PublicAccountInfoToolbarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public PublicAccountInfoToolbarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    View localView = this.a;
    if ((paramBoolean1) && (paramBoolean2));
    for (int i = 0; ; i = 4)
    {
      localView.setVisibility(i);
      return;
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = findViewById(R.id.verified);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.toolbar.PublicAccountInfoToolbarView
 * JD-Core Version:    0.6.2
 */
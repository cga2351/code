package com.viber.voip.widget.toolbar;

import android.view.View;
import com.viber.voip.ui.ScalableTextView;

public class b extends d<PublicAccountInfoToolbarView>
  implements e
{
  public b(View paramView)
  {
    super(paramView);
  }

  public void a()
  {
    super.a();
    ((PublicAccountInfoToolbarView)this.a).a.setVisibility(4);
  }

  public void a(boolean paramBoolean)
  {
    if (this.a != null)
      ((PublicAccountInfoToolbarView)this.a).a(paramBoolean, false);
    if (this.b != null)
      ((PublicAccountInfoToolbarView)this.b).a(paramBoolean, true);
  }

  public View b()
  {
    return ((PublicAccountInfoToolbarView)this.b).a;
  }

  public void c()
  {
    super.c();
    ((ScalableTextView)((PublicAccountInfoToolbarView)this.a).b).a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.toolbar.b
 * JD-Core Version:    0.6.2
 */
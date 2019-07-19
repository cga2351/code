package com.viber.voip.messages.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

public class af extends ad
  implements View.OnClickListener, ae
{
  private ae.a a;

  public af(Context paramContext)
  {
    super(paramContext);
  }

  protected void a(Context paramContext)
  {
    super.a(paramContext);
    setOnClickListener(this);
  }

  public boolean a()
  {
    return isSelected();
  }

  public void e_(boolean paramBoolean)
  {
    setSelected(paramBoolean);
  }

  public int getPanelId()
  {
    return getId();
  }

  public void onClick(View paramView)
  {
    if (!a());
    for (boolean bool = true; ; bool = false)
    {
      e_(bool);
      if (this.a != null)
        this.a.a(this);
      return;
    }
  }

  public void setTriggerClickListener(ae.a parama)
  {
    this.a = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.af
 * JD-Core Version:    0.6.2
 */
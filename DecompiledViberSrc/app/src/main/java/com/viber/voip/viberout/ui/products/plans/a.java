package com.viber.voip.viberout.ui.products.plans;

import android.content.Context;
import android.view.View;
import com.viber.voip.util.ck.c;
import java.util.Collections;

public class a extends ck.c
{
  private final View a;
  private boolean b = true;

  public a(Context paramContext, View paramView)
  {
    super(paramContext, Collections.singletonList(paramView));
    this.a = paramView;
  }

  public View a()
  {
    return this.a;
  }

  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    notifyDataSetChanged();
  }

  public int getItemCount()
  {
    if (!this.b)
      return 0;
    return super.getItemCount();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.plans.a
 * JD-Core Version:    0.6.2
 */
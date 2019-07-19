package com.viber.voip.services.inbox;

import android.view.View;
import android.view.ViewStub;
import com.viber.voip.R.id;
import com.viber.voip.ui.h;
import com.viber.voip.util.dj;

public class a extends h
{
  private final int a;
  private View b;

  public a(int paramInt)
  {
    this.a = paramInt;
  }

  public View a()
  {
    return this.b;
  }

  public boolean a(View paramView, boolean paramBoolean)
  {
    if (super.a(paramView, paramBoolean))
    {
      ViewStub localViewStub = (ViewStub)paramView.findViewById(R.id.emptyView);
      localViewStub.setLayoutResource(this.a);
      this.b = localViewStub.inflate();
      View localView = this.b;
      if (!paramBoolean);
      for (boolean bool = true; ; bool = false)
      {
        dj.b(localView, bool);
        return true;
      }
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.services.inbox.a
 * JD-Core Version:    0.6.2
 */
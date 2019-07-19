package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

class l extends k
{
  l(Context paramContext, SupportMenuItem paramSupportMenuItem)
  {
    super(paramContext, paramSupportMenuItem);
  }

  k.a a(ActionProvider paramActionProvider)
  {
    return new a(this.a, paramActionProvider);
  }

  class a extends k.a
    implements android.view.ActionProvider.VisibilityListener
  {
    android.support.v4.view.ActionProvider.VisibilityListener c;

    public a(Context paramActionProvider, ActionProvider arg3)
    {
      super(paramActionProvider, localActionProvider);
    }

    public boolean isVisible()
    {
      return this.a.isVisible();
    }

    public void onActionProviderVisibilityChanged(boolean paramBoolean)
    {
      if (this.c != null)
        this.c.onActionProviderVisibilityChanged(paramBoolean);
    }

    public View onCreateActionView(MenuItem paramMenuItem)
    {
      return this.a.onCreateActionView(paramMenuItem);
    }

    public boolean overridesItemVisibility()
    {
      return this.a.overridesItemVisibility();
    }

    public void refreshVisibility()
    {
      this.a.refreshVisibility();
    }

    public void setVisibilityListener(android.support.v4.view.ActionProvider.VisibilityListener paramVisibilityListener)
    {
      this.c = paramVisibilityListener;
      ActionProvider localActionProvider = this.a;
      if (paramVisibilityListener != null);
      while (true)
      {
        localActionProvider.setVisibilityListener(this);
        return;
        this = null;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.view.menu.l
 * JD-Core Version:    0.6.2
 */
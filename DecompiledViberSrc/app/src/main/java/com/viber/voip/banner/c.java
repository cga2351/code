package com.viber.voip.banner;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.ViberApplication;
import com.viber.voip.banner.d.b;
import com.viber.voip.contacts.ui.ContactsFragment;
import com.viber.voip.messages.ui.bk;
import java.lang.ref.WeakReference;

public class c extends e
{
  private final WeakReference<Fragment> b;

  c(b paramb, dagger.a<com.viber.voip.analytics.story.g.a> parama, Fragment paramFragment)
  {
    super(paramb, parama);
    this.b = new WeakReference(paramFragment);
  }

  protected ViewGroup a()
  {
    Fragment localFragment = (Fragment)this.b.get();
    if (localFragment != null)
    {
      if (ViberApplication.isTablet(b()))
      {
        if ((localFragment.getView() != null) && (((localFragment instanceof bk)) || ((localFragment instanceof ContactsFragment))))
          return (ViewGroup)localFragment.getView().getParent();
        return (ViewGroup)localFragment.getView();
      }
      return com.viber.voip.banner.view.c.a(localFragment.getView());
    }
    return null;
  }

  protected Context b()
  {
    Fragment localFragment = (Fragment)this.b.get();
    if (localFragment == null)
      return null;
    return localFragment.getActivity();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.c
 * JD-Core Version:    0.6.2
 */
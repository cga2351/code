package com.viber.voip;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.viber.voip.contacts.ui.ContactsFragment;
import com.viber.voip.messages.ui.bn;
import com.viber.voip.news.m;
import com.viber.voip.ui.f.c;
import com.viber.voip.user.more.MoreFragment;
import com.viber.voip.widget.m.a;

abstract class af extends m.a
{
  private final c a;

  af(FragmentManager paramFragmentManager, c paramc)
  {
    super(paramFragmentManager);
    this.a = paramc;
  }

  public int getCount()
  {
    return this.a.a();
  }

  @SuppressLint({"SwitchIntDef"})
  public Fragment getItem(int paramInt)
  {
    switch (this.a.b(paramInt))
    {
    default:
      return null;
    case 0:
      return new bn();
    case 1:
      return new ContactsFragment();
    case 2:
      return new MoreFragment();
    case 3:
    }
    return new m();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.af
 * JD-Core Version:    0.6.2
 */
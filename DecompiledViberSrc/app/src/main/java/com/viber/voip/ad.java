package com.viber.voip;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.viber.common.b.d;
import com.viber.voip.calls.ui.KeypadFragment;
import com.viber.voip.calls.ui.RecentCallsFragment;
import com.viber.voip.contacts.ui.ContactsFragment;
import com.viber.voip.messages.ui.bk;
import com.viber.voip.news.m;
import com.viber.voip.settings.d.p;
import com.viber.voip.user.more.MoreFragment;

public class ad
{
  private bk a;
  private ContactsFragment b;
  private MoreFragment c;
  private KeypadFragment d;
  private RecentCallsFragment e;
  private m f;
  private boolean g;
  private boolean h;

  public Fragment a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalStateException("Unknown fragment tabId: " + paramInt);
    case 0:
      return this.a;
    case 1:
      if (this.g)
        return this.d;
      if (this.h)
        return this.e;
      return this.b;
    case 2:
      return this.c;
    case 3:
    }
    return this.f;
  }

  public void a(Bundle paramBundle)
  {
    if (paramBundle == null)
      return;
    this.g = paramBundle.getBoolean("isKeypad");
    this.h = paramBundle.getBoolean("isRecentCalls");
  }

  public void a(Fragment paramFragment)
  {
    if ((paramFragment instanceof bk))
      this.a = ((bk)paramFragment);
    do
    {
      return;
      if ((paramFragment instanceof ContactsFragment))
      {
        this.b = ((ContactsFragment)paramFragment);
        return;
      }
      if ((paramFragment instanceof MoreFragment))
      {
        this.c = ((MoreFragment)paramFragment);
        return;
      }
      if ((paramFragment instanceof KeypadFragment))
      {
        this.d = ((KeypadFragment)paramFragment);
        return;
      }
      if ((paramFragment instanceof RecentCallsFragment))
      {
        this.e = ((RecentCallsFragment)paramFragment);
        return;
      }
    }
    while (!(paramFragment instanceof m));
    this.f = ((m)paramFragment);
  }

  public void a(FragmentManager paramFragmentManager)
  {
    this.d = ((KeypadFragment)paramFragmentManager.findFragmentById(R.id.keypad_fragment));
    this.e = ((RecentCallsFragment)paramFragmentManager.findFragmentById(R.id.phone_fragment));
  }

  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }

  public boolean a()
  {
    return this.g;
  }

  public void b(int paramInt)
  {
    if (this.b != null)
    {
      this.b.e(paramInt);
      return;
    }
    d.p.h.a(paramInt);
  }

  public void b(Bundle paramBundle)
  {
    paramBundle.putBoolean("isKeypad", this.g);
    paramBundle.putBoolean("isRecentCalls", this.h);
  }

  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  public boolean b()
  {
    return this.h;
  }

  public int c()
  {
    int i = 1;
    if (this.g)
      i = 11;
    while (!this.h)
      return i;
    return 12;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ad
 * JD-Core Version:    0.6.2
 */
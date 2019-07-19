package com.viber.voip.user.more;

import com.viber.common.b.a;
import com.viber.voip.settings.d;
import com.viber.voip.settings.d.al;
import com.viber.voip.util.dd;

class MorePrefsListener extends d.al
{
  private PreferencesChangedListener mPreferencesChangedListener;

  MorePrefsListener(a[] paramArrayOfa)
  {
    super(paramArrayOfa);
  }

  public void onPreferencesChanged(a parama)
  {
    dd.a(new MorePrefsListener..Lambda.0(this, parama));
  }

  void register(PreferencesChangedListener paramPreferencesChangedListener)
  {
    d.a(this);
    this.mPreferencesChangedListener = paramPreferencesChangedListener;
  }

  void unregister()
  {
    d.b(this);
    this.mPreferencesChangedListener = null;
  }

  static abstract interface PreferencesChangedListener
  {
    public abstract void onPreferencesChanged(a parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MorePrefsListener
 * JD-Core Version:    0.6.2
 */
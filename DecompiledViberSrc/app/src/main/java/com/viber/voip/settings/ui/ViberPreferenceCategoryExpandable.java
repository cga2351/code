package com.viber.voip.settings.ui;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceCategory;
import android.util.AttributeSet;
import com.viber.voip.R.layout;
import com.viber.voip.util.da;

public class ViberPreferenceCategoryExpandable extends PreferenceCategory
{
  private boolean b;
  private String c;

  public ViberPreferenceCategoryExpandable(Context paramContext)
  {
    super(paramContext);
    j();
  }

  public ViberPreferenceCategoryExpandable(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    j();
  }

  private static boolean a(Preference paramPreference, String paramString)
  {
    CharSequence localCharSequence1 = paramPreference.y();
    CharSequence localCharSequence2 = paramPreference.o();
    return (da.b(paramString)) || ((localCharSequence1 != null) && (localCharSequence1.toString().toLowerCase().contains(paramString))) || ((localCharSequence2 != null) && (localCharSequence2.toString().toLowerCase().contains(paramString)));
  }

  private void j()
  {
    c(R.layout.pref_category_expandable);
  }

  private void m()
  {
    boolean bool1 = a(this, this.c);
    int i = 0;
    boolean bool2 = bool1;
    if (i < e())
    {
      Preference localPreference = b(i);
      int j;
      label47: boolean bool3;
      if ((bool1) || (a(localPreference, this.c)))
      {
        j = 1;
        if ((!this.b) || (j == 0))
          break label92;
        bool3 = true;
        label62: localPreference.b(bool3);
        if ((!bool2) && (j == 0))
          break label98;
      }
      label92: label98: for (bool2 = true; ; bool2 = false)
      {
        i++;
        break;
        j = 0;
        break label47;
        bool3 = false;
        break label62;
      }
    }
  }

  public boolean A()
  {
    return true;
  }

  public void a(String paramString)
  {
    this.c = paramString;
    m();
  }

  void g(boolean paramBoolean)
  {
    if (this.b == paramBoolean)
      return;
    this.b = paramBoolean;
    m();
  }

  public void i()
  {
    if (!this.b);
    for (boolean bool = true; ; bool = false)
    {
      g(bool);
      return;
    }
  }

  public boolean z()
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.ViberPreferenceCategoryExpandable
 * JD-Core Version:    0.6.2
 */
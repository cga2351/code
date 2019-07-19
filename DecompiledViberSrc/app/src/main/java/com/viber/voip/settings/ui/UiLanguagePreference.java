package com.viber.voip.settings.ui;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.util.AttributeSet;
import com.viber.common.b.h;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.orm.entity.json.Language;
import com.viber.voip.messages.translation.a;
import com.viber.voip.settings.d.ad.a;
import com.viber.voip.util.bp;
import com.viber.voip.util.da;
import java.util.Locale;

public class UiLanguagePreference extends Preference
{
  public UiLanguagePreference(Context paramContext)
  {
    super(paramContext);
    b();
  }

  public UiLanguagePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }

  public UiLanguagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }

  public UiLanguagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    b();
  }

  public void b()
  {
    b(e());
  }

  public String e()
  {
    String str = d.ad.a.c.d();
    if (da.a(str))
      str = ViberApplication.getInstance().getCurrentSystemLanguage();
    Language localLanguage = a.b.a(I(), str);
    if (localLanguage != null)
      return localLanguage.getVisibleName();
    return bp.c(str).getDisplayLanguage();
  }

  public void f()
  {
    b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.UiLanguagePreference
 * JD-Core Version:    0.6.2
 */
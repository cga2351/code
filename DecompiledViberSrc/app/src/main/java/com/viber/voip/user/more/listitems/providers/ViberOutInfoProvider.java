package com.viber.voip.user.more.listitems.providers;

import android.text.TextUtils;
import com.viber.voip.settings.a.a.a;
import com.viber.voip.settings.a.a.d;

public class ViberOutInfoProvider
  implements a.a, a.d
{
  private CharSequence mText;

  public boolean get()
  {
    return TextUtils.isEmpty(this.mText);
  }

  public CharSequence getText()
  {
    return this.mText;
  }

  public void setViberOutBalanceText(CharSequence paramCharSequence)
  {
    this.mText = paramCharSequence;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.listitems.providers.ViberOutInfoProvider
 * JD-Core Version:    0.6.2
 */
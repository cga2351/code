package com.viber.voip.user.more;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.user.editinfo.ProfileNameRepository.DefaultNameProvider;
import com.viber.voip.util.dg;

class DefaultNameProvider
  implements ProfileNameRepository.DefaultNameProvider
{
  private final int mColor;
  private final Context mContext;
  private CharSequence mEmptyName;

  DefaultNameProvider(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mColor = paramInt;
  }

  public CharSequence get()
  {
    if (this.mEmptyName == null)
    {
      this.mEmptyName = this.mContext.getString(R.string.more_empty_profile_add_name);
      this.mEmptyName = dg.a(this.mEmptyName, this.mColor);
    }
    return this.mEmptyName;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.DefaultNameProvider
 * JD-Core Version:    0.6.2
 */
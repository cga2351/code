package com.viber.voip.phone.viber;

import android.content.Intent;
import com.viber.voip.ui.l;
import com.viber.voip.ui.m;

public abstract class CallViewHolder
  implements l<CallFragment>
{
  private CallFragment mCallFragment;

  public CallViewHolder(CallFragment paramCallFragment)
  {
    this.mCallFragment = paramCallFragment;
  }

  public CallFragment getFragment()
  {
    return this.mCallFragment;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    m.a(this, paramInt1, paramInt2, paramIntent);
  }

  public void setFragment(CallFragment paramCallFragment)
  {
    this.mCallFragment = paramCallFragment;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.CallViewHolder
 * JD-Core Version:    0.6.2
 */
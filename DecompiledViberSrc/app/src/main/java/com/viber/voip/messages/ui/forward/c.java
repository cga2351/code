package com.viber.voip.messages.ui.forward;

import android.content.Intent;
import com.viber.voip.messages.forward.GroupReferralForwardInfo;
import com.viber.voip.mvp.core.j;

public abstract interface c extends j
{
  public abstract void a(Intent paramIntent);

  public abstract void a(Intent paramIntent, GroupReferralForwardInfo paramGroupReferralForwardInfo);

  public abstract void a(boolean paramBoolean);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.forward.c
 * JD-Core Version:    0.6.2
 */
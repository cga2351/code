package com.viber.voip.messages.conversation.adapter.e;

import android.content.res.Resources;
import android.util.TypedValue;
import com.viber.voip.R.dimen;

public class f extends k
{
  public f(int paramInt, Resources paramResources)
  {
    super(paramInt, paramResources);
  }

  protected float a(Resources paramResources, int paramInt, TypedValue paramTypedValue)
  {
    if (paramInt == 0);
    for (int i = R.dimen.fm_message_incoming_max_width_percents; ; i = R.dimen.fm_message_outgoing_max_width_percents)
    {
      paramResources.getValue(i, paramTypedValue, true);
      return paramTypedValue.getFloat();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.e.f
 * JD-Core Version:    0.6.2
 */
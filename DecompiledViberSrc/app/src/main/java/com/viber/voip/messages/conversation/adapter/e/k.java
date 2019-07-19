package com.viber.voip.messages.conversation.adapter.e;

import android.content.res.Resources;
import android.util.TypedValue;
import com.viber.voip.R.dimen;

public class k
{
  private final float a;
  private final float b;
  private final float c;
  private final float d;

  public k(int paramInt, Resources paramResources)
  {
    TypedValue localTypedValue = new TypedValue();
    paramResources.getValue(R.dimen.image_message_min_width_percents, localTypedValue, true);
    this.a = localTypedValue.getFloat();
    this.b = a(paramResources, paramInt, localTypedValue);
    paramResources.getValue(R.dimen.image_message_max_height_percents, localTypedValue, true);
    this.c = localTypedValue.getFloat();
    paramResources.getValue(R.dimen.image_message_max_landscape_width_ratio, localTypedValue, true);
    this.d = localTypedValue.getFloat();
  }

  public float a()
  {
    return this.a;
  }

  protected float a(Resources paramResources, int paramInt, TypedValue paramTypedValue)
  {
    if (paramInt == 0);
    for (int i = R.dimen.image_message_incoming_max_width_percents; ; i = R.dimen.image_message_outgoing_max_width_percents)
    {
      paramResources.getValue(i, paramTypedValue, true);
      return paramTypedValue.getFloat();
    }
  }

  public float b()
  {
    return this.b;
  }

  public float c()
  {
    return this.c;
  }

  public float d()
  {
    return this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.e.k
 * JD-Core Version:    0.6.2
 */
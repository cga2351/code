package com.vk.sdk.payments;

import android.content.Context;

public abstract class VKPaymentsCallback
{
  public static void requestUserState(Context paramContext, VKPaymentsCallback paramVKPaymentsCallback)
  {
    VKPaymentsServerSender.getInstance(paramContext).requestUserState(paramVKPaymentsCallback);
  }

  public abstract void onUserState(boolean paramBoolean);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.payments.VKPaymentsCallback
 * JD-Core Version:    0.6.2
 */
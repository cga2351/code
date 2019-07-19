package com.viber.voip.ui;

import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class at extends aq
{
  private static final Logger a = ViberEnv.getLogger();

  public static void e()
  {
    try
    {
      Thread.sleep(100L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
  }

  public void onStart()
  {
    super.onStart();
    if ((getActivity() != null) && (!a.a()))
      e();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.at
 * JD-Core Version:    0.6.2
 */
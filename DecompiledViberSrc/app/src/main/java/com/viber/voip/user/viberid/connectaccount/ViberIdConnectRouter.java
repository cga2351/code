package com.viber.voip.user.viberid.connectaccount;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdStepRouters.ViberIdBaseStepRouter;
import com.viber.voip.util.ViberActionRunner.bf;

class ViberIdConnectRouter
  implements ViberIdStepRouters.ViberIdBaseStepRouter
{
  private static final Logger L = ViberEnv.getLogger();
  private final ViberFragmentActivity mActivity;

  public ViberIdConnectRouter(ViberFragmentActivity paramViberFragmentActivity)
  {
    this.mActivity = paramViberFragmentActivity;
  }

  public void closeViberIdConnect()
  {
    this.mActivity.finish();
  }

  public void openEditInfo()
  {
    ViberActionRunner.bf.a(this.mActivity);
    closeViberIdConnect();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.ViberIdConnectRouter
 * JD-Core Version:    0.6.2
 */
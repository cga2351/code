package com.viber.voip.user.editinfo.forgotpassword;

import com.viber.voip.user.actions.Action;
import com.viber.voip.user.actions.ConnectionAwareAction;
import com.viber.voip.user.viberid.ViberIdController;
import com.viber.voip.user.viberid.ViberIdEvents.ViberIdForgotPasswordActionEvent;
import com.viber.voip.util.cj;
import com.viber.voip.util.cl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ForgotPasswordPresenter
{
  private static ForgotPasswordView STUB_VIEW = (ForgotPasswordView)cl.b(ForgotPasswordView.class);
  private ConnectionAwareAction<String> mAction;
  private final ViberIdController mController;
  private String mEmail;
  private final cj mReachability;
  private ForgotPasswordView mView = STUB_VIEW;

  public ForgotPasswordPresenter(ViberIdController paramViberIdController, cj paramcj)
  {
    this.mController = paramViberIdController;
    this.mReachability = paramcj;
  }

  public void attachView(ForgotPasswordView paramForgotPasswordView)
  {
    this.mView = paramForgotPasswordView;
    this.mController.getEventBus().register(this);
    this.mAction = new ConnectionAwareAction(new Action()
    {
      public void execute(String paramAnonymousString)
      {
        ForgotPasswordPresenter.this.mController.performForgotPasswordAction(paramAnonymousString);
      }
    }
    , this.mView, this.mReachability);
  }

  public void detachView()
  {
    this.mView = STUB_VIEW;
    this.mController.getEventBus().unregister(this);
    this.mAction = null;
  }

  public void onForgotPassword()
  {
    if (this.mAction != null)
      this.mAction.execute(this.mEmail);
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onPasswordActionReply(ViberIdEvents.ViberIdForgotPasswordActionEvent paramViberIdForgotPasswordActionEvent)
  {
    switch (paramViberIdForgotPasswordActionEvent.status)
    {
    default:
      this.mView.showGenericError();
      return;
    case 0:
      this.mView.showEmailWasSentDialog();
      return;
    case 4:
    }
    this.mView.showTooManyRequestsError();
  }

  public void setEmail(String paramString)
  {
    if (paramString == null)
      paramString = "";
    this.mEmail = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.forgotpassword.ForgotPasswordPresenter
 * JD-Core Version:    0.6.2
 */
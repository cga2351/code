package com.viber.voip.user.editinfo.diconnectaccount;

import com.viber.voip.user.actions.Action;
import com.viber.voip.user.actions.ConnectionAwareAction;
import com.viber.voip.user.viberid.ViberIdController;
import com.viber.voip.user.viberid.ViberIdEvents.UnlinkViberIdEvent;
import com.viber.voip.util.cj;
import com.viber.voip.util.cl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DisconnectAccountPresenter
{
  private static DisconnectAccountView STUB_VIEW = (DisconnectAccountView)cl.b(DisconnectAccountView.class);
  private ConnectionAwareAction<Void> mAction;
  protected final ViberIdController mController;
  private final DisconnectAccountRouter mDisconnectRouter;
  protected final cj mReachability;
  private DisconnectAccountView mView = STUB_VIEW;

  public DisconnectAccountPresenter(ViberIdController paramViberIdController, DisconnectAccountRouter paramDisconnectAccountRouter, cj paramcj)
  {
    this.mController = paramViberIdController;
    this.mDisconnectRouter = paramDisconnectAccountRouter;
    this.mReachability = paramcj;
  }

  public void attach(DisconnectAccountView paramDisconnectAccountView)
  {
    this.mView = paramDisconnectAccountView;
    this.mController.getEventBus().register(this);
    this.mAction = new ConnectionAwareAction(new Action()
    {
      public void execute(Void paramAnonymousVoid)
      {
        DisconnectAccountPresenter.this.mView.showDisconnectAccountProgress();
        DisconnectAccountPresenter.this.mController.unlinkViberId();
      }
    }
    , this.mView, this.mReachability);
  }

  public void detach()
  {
    this.mView = STUB_VIEW;
    this.mController.getEventBus().unregister(this);
    this.mAction = null;
  }

  public void disconnectAccount()
  {
    if (this.mAction != null)
      this.mAction.execute(null);
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onUnlinkViberIdReply(ViberIdEvents.UnlinkViberIdEvent paramUnlinkViberIdEvent)
  {
    this.mView.hideDisconnectAccountProgress();
    switch (paramUnlinkViberIdEvent.status)
    {
    default:
      this.mView.showDisconnectAccountError();
      return;
    case 0:
    }
    this.mDisconnectRouter.navigateOnDisconnect();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.diconnectaccount.DisconnectAccountPresenter
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.mvp.core;

import android.os.Bundle;

class l
{
  private String a(BaseMvpPresenter paramBaseMvpPresenter)
  {
    return "state_key_" + paramBaseMvpPresenter.getClass().getName();
  }

  void a(BaseMvpPresenter paramBaseMvpPresenter, Bundle paramBundle)
  {
    State localState = paramBaseMvpPresenter.getSaveState();
    if (localState != null)
      paramBundle.putParcelable(a(paramBaseMvpPresenter), localState);
  }

  State b(BaseMvpPresenter paramBaseMvpPresenter, Bundle paramBundle)
  {
    if (paramBundle == null)
      return null;
    return (State)paramBundle.getParcelable(a(paramBaseMvpPresenter));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.mvp.core.l
 * JD-Core Version:    0.6.2
 */
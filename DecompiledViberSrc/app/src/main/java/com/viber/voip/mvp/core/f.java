package com.viber.voip.mvp.core;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class f
{
  private List<BaseMvpPresenter> a = new ArrayList();

  void a(Bundle paramBundle, l paraml)
  {
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      paraml.a((BaseMvpPresenter)this.a.get(j), paramBundle);
  }

  void a(BaseMvpPresenter paramBaseMvpPresenter)
  {
    this.a.add(paramBaseMvpPresenter);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.mvp.core.f
 * JD-Core Version:    0.6.2
 */
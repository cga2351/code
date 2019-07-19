package com.viber.voip.storage.manage;

import android.os.Handler;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.storage.repository.MediaStorageInteractor;
import com.viber.voip.util.da;

abstract class ManageStoragePresenterBase extends BaseMvpPresenter<i, ManageStorageState>
  implements a
{
  protected String a;

  public static ManageStoragePresenterBase a(boolean paramBoolean, MediaStorageInteractor paramMediaStorageInteractor, Handler paramHandler)
  {
    if (paramBoolean)
      return new ManageStoragePresenter(paramMediaStorageInteractor, paramHandler);
    return new ManageStoragePresenterUnauthorizedUser();
  }

  protected void a(ManageStorageState paramManageStorageState)
  {
    super.onViewAttached(paramManageStorageState);
    if (paramManageStorageState != null)
    {
      this.a = paramManageStorageState.getSearchQuery();
      if (!da.a(this.a))
        ((i)this.mView).a(this.a);
    }
  }

  public void a(String paramString)
  {
    this.a = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.manage.ManageStoragePresenterBase
 * JD-Core Version:    0.6.2
 */
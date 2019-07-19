package com.viber.voip.storage.manage;

import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import com.viber.voip.storage.repository.MediaStorageInteractor.MediaStorageInteractorSaveState;

class ManageStoragePresenterUnauthorizedUser extends ManageStoragePresenterBase
{
  protected ManageStorageState a()
  {
    return new ManageStorageState(MediaStorageInteractor.MediaStorageInteractorSaveState.createEmpty(), this.a);
  }

  protected void a(ManageStorageState paramManageStorageState)
  {
    super.a(paramManageStorageState);
    ((i)this.mView).b();
  }

  public void a(ConversationWithMediaSizesEntity paramConversationWithMediaSizesEntity)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.manage.ManageStoragePresenterUnauthorizedUser
 * JD-Core Version:    0.6.2
 */
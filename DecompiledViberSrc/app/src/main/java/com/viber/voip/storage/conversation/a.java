package com.viber.voip.storage.conversation;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.d.f;
import com.viber.voip.R.layout;
import com.viber.voip.messages.k;
import com.viber.voip.mvp.core.g;
import com.viber.voip.storage.a.i;
import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import com.viber.voip.storage.repository.MediaStorageInteractor;
import com.viber.voip.storage.repository.r;
import com.viber.voip.storage.repository.u;
import javax.inject.Inject;

public class a extends g<e>
{

  @Inject
  protected dagger.a<k> a;

  @Inject
  protected f b;

  @Inject
  protected r c;

  @Inject
  protected u d;

  @Inject
  protected Handler e;

  @Inject
  protected Handler f;

  @Inject
  protected com.viber.voip.util.e.e g;

  @Inject
  protected i h;
  private MediaStorageInteractor<com.viber.voip.storage.repository.b> i;
  private com.viber.voip.storage.b<ConversationWithMediaSizesEntity> j;
  private com.viber.voip.storage.a<ConversationWithMediaSizesEntity> k;
  private long l = -1L;
  private int m = 0;

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    ManageConversationStoragePresenter localManageConversationStoragePresenter = new ManageConversationStoragePresenter(this.l, this.m, this.i, this.h);
    FragmentActivity localFragmentActivity = getActivity();
    c localc = new c(localFragmentActivity);
    addMvpView(new e(localFragmentActivity, this, this.j, this.k, localc, localManageConversationStoragePresenter, paramView), localManageConversationStoragePresenter, paramBundle);
  }

  protected void initModelComponent(View paramView, Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
      this.l = localBundle.getLong("extra_conversation_id", -1L);
    this.m = new com.viber.voip.storage.model.a().a(localBundle, "extra_source");
    this.i = new MediaStorageInteractor(new com.viber.voip.storage.repository.b(this.l, getContext(), getLoaderManager(), this.a, this.b), this.c, this.d, this.e, this.f);
    com.viber.voip.messages.adapters.a.c.a locala = new com.viber.voip.messages.adapters.a.c.a(getContext(), null, false, false, false);
    this.j = new com.viber.voip.storage.b(locala);
    this.k = new com.viber.voip.storage.a(paramView, locala, this.g);
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_manage_conversation_storage, paramViewGroup, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.conversation.a
 * JD-Core Version:    0.6.2
 */
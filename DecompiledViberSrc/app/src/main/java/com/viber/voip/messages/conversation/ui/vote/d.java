package com.viber.voip.messages.conversation.ui.vote;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.layout;
import com.viber.voip.mvp.core.g;
import dagger.android.support.a;
import javax.inject.Inject;

public class d extends g<com.viber.voip.mvp.core.d>
{

  @Inject
  VotePresenter a;

  public static d a(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putBundle("send_message_options", paramBundle);
    d locald = new d();
    locald.setArguments(localBundle);
    return locald;
  }

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    FragmentActivity localFragmentActivity = getActivity();
    a locala;
    if ((localFragmentActivity instanceof a))
      locala = (a)localFragmentActivity;
    while (true)
      if (locala == null)
      {
        throw new RuntimeException("Parent must implement VoteFragment.Callback");
        Fragment localFragment = getParentFragment();
        if ((localFragment instanceof a))
          locala = (a)localFragment;
      }
      else
      {
        if (getActivity() != null)
        {
          Intent localIntent = getActivity().getIntent();
          VotePresenter.a locala1 = new VotePresenter.a(localIntent.getLongExtra("extra_conversation_id", 0L), localIntent.getLongExtra("extra_group_id", 0L), localIntent.getIntExtra("extra_conversation_type", 0), localIntent.getIntExtra("extra_native_chat_type", 0), localIntent.getStringExtra("extra_member_id"));
          this.a.a(locala1);
        }
        Bundle localBundle = getArguments();
        if (localBundle != null)
          this.a.a(localBundle.getBundle("send_message_options"));
        addMvpView(new h(this.a, paramView, locala), this.a, paramBundle);
        return;
        locala = null;
      }
  }

  protected void initModelComponent(View paramView, Bundle paramBundle)
  {
  }

  public void onAttach(Context paramContext)
  {
    a.a(this);
    super.onAttach(paramContext);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_vote, paramViewGroup, false);
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.vote.d
 * JD-Core Version:    0.6.2
 */
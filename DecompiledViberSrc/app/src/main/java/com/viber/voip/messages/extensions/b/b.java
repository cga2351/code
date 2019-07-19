package com.viber.voip.messages.extensions.b;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.layout;
import com.viber.voip.messages.extensions.ui.details.ChatExtensionDetailsData;
import com.viber.voip.messages.extensions.ui.details.ChatExtensionDetailsPresenter;
import com.viber.voip.mvp.core.d;
import com.viber.voip.mvp.core.g;
import com.viber.voip.util.e.e;
import javax.inject.Inject;

public class b extends g<d>
  implements a
{

  @Inject
  e a;

  @Inject
  ChatExtensionDetailsPresenter b;

  public static b a(ChatExtensionDetailsData paramChatExtensionDetailsData)
  {
    b localb = new b();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("chat_extension_details", paramChatExtensionDetailsData);
    localb.setArguments(localBundle);
    return localb;
  }

  public void a()
  {
    this.b.b();
  }

  public ChatExtensionDetailsData b()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null)
      throw new RuntimeException("Arguments are required for this fragment");
    ChatExtensionDetailsData localChatExtensionDetailsData = (ChatExtensionDetailsData)localBundle.getParcelable("chat_extension_details");
    if (localChatExtensionDetailsData == null)
      throw new RuntimeException("Chat Extension details must be provided to this fragment");
    return localChatExtensionDetailsData;
  }

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    Fragment localFragment = getParentFragment();
    boolean bool = localFragment instanceof a;
    a locala = null;
    if (bool)
      locala = (a)localFragment;
    if (locala == null)
      throw new RuntimeException("Parent must implement ChatExtensionDetailsFragment.Callback interface");
    addMvpView(new com.viber.voip.messages.extensions.ui.details.b(this.b, paramView, this, this.a, locala), this.b, paramBundle);
  }

  protected void initModelComponent(View paramView, Bundle paramBundle)
  {
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_chat_extension_details, paramViewGroup, false);
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.b.b
 * JD-Core Version:    0.6.2
 */
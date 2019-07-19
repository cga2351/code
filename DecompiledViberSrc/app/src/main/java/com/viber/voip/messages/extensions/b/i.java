package com.viber.voip.messages.extensions.b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.R.anim;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.StoryConstants.g.a;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.banner.o;
import com.viber.voip.messages.conversation.ui.bd;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.messages.extensions.ui.details.ChatExtensionDetailsData;
import com.viber.voip.settings.d.n;
import com.viber.voip.ui.aq;
import com.viber.voip.ui.b.a.a;
import com.viber.voip.util.ae;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class i extends aq
  implements b.a, d.a
{
  private static final Logger f = ViberEnv.getLogger();

  @Inject
  com.viber.voip.messages.extensions.c a;

  @Inject
  com.viber.voip.messages.extensions.a b;

  @Inject
  EventBus c;

  @Inject
  Handler d;

  @Inject
  com.viber.voip.analytics.story.c.c e;
  private View g;
  private Animation h;
  private Animation i;
  private bd j;
  private ConversationItemLoaderEntity k;
  private ChatExtensionLoaderEntity l;
  private String m;
  private boolean n;
  private String o;
  private boolean p;
  private a q;
  private a r;
  private final b s = new b(null);
  private final View.OnClickListener t = new j(this);

  public static i a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, ChatExtensionLoaderEntity paramChatExtensionLoaderEntity, String paramString1, boolean paramBoolean, String paramString2)
  {
    i locali = new i();
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("conversation_data", paramConversationItemLoaderEntity);
    localBundle.putParcelable("chat_extension", paramChatExtensionLoaderEntity);
    localBundle.putString("chat_extension_query", paramString1);
    localBundle.putBoolean("chat_extension_silent_query", paramBoolean);
    localBundle.putString("chat_extension_entry_point", paramString2);
    locali.setArguments(localBundle);
    return locali;
  }

  private void a(ChatExtensionLoaderEntity paramChatExtensionLoaderEntity, String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
    if (paramBoolean2)
      localFragmentTransaction.setCustomAnimations(R.anim.right_side_slide_in_enter, R.anim.right_side_slide_in_exit, R.anim.right_side_slide_out_enter, R.anim.right_side_slide_out_exit);
    if (paramBoolean3)
      localFragmentTransaction.addToBackStack(null);
    String str = this.a.l();
    localFragmentTransaction.replace(R.id.fragmentContainerView, b.a(new ChatExtensionDetailsData(paramChatExtensionLoaderEntity, paramString1, paramBoolean1, paramBoolean4, this.k, paramString2)), "chatex_details");
    localFragmentTransaction.commit();
    this.a.g(paramChatExtensionLoaderEntity.getUri());
    this.e.c(str, paramChatExtensionLoaderEntity.getUri(), ae.b());
  }

  private void a(ChatExtensionLoaderEntity paramChatExtensionLoaderEntity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramChatExtensionLoaderEntity, null, false, paramString, paramBoolean1, paramBoolean2, paramBoolean3);
  }

  private void a(String paramString)
  {
    if (this.p)
      return;
    this.p = true;
    this.g.startAnimation(this.i);
    this.e.a(paramString, TimeUnit.MILLISECONDS.toSeconds(this.s.b()));
  }

  private void a(boolean paramBoolean)
  {
    FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
    if (paramBoolean)
      localFragmentTransaction.setCustomAnimations(R.anim.right_side_slide_out_enter, R.anim.right_side_slide_out_exit);
    localFragmentTransaction.replace(R.id.fragmentContainerView, d.b(), "chatex_list");
    localFragmentTransaction.commit();
  }

  public void a()
  {
    a("Send");
  }

  public void a(ChatExtensionLoaderEntity paramChatExtensionLoaderEntity)
  {
    this.a.f(paramChatExtensionLoaderEntity.getPublicAccountId());
    a(paramChatExtensionLoaderEntity, "Keyboard", true, true, true);
  }

  public void b()
  {
    onBackPressed();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (paramBundle == null)
    {
      this.g.startAnimation(this.h);
      this.s.a();
      if (this.o != null)
        this.e.a(this.o, StoryConstants.g.a.a(this.k), ae.b());
    }
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
    if ((paramContext instanceof a))
      this.q = ((a)paramContext);
    while (this.q == null)
    {
      throw new RuntimeException("Parent must implement ChatExtensionPanelFragment.Callback");
      Fragment localFragment = getParentFragment();
      if ((localFragment instanceof a))
        this.q = ((a)localFragment);
    }
  }

  public void onAttachFragment(Fragment paramFragment)
  {
    super.onAttachFragment(paramFragment);
    if ((paramFragment instanceof a))
      this.r = ((a)paramFragment);
  }

  public boolean onBackPressed()
  {
    FragmentManager localFragmentManager = getChildFragmentManager();
    if (localFragmentManager.getBackStackEntryCount() == 0)
    {
      if ((this.l != null) || (this.b.c(this.k.getId())))
      {
        this.l = null;
        this.m = null;
        this.b.d(this.k.getId());
        this.a.f("");
        a(true);
        return true;
      }
      a("Back");
      return true;
    }
    this.b.d(this.k.getId());
    this.a.f("");
    localFragmentManager.popBackStack();
    return true;
  }

  @Subscribe
  public void onClosePanelRequested(com.viber.voip.messages.a.b.a parama)
  {
    a("Exit");
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    if (localBundle == null)
      throw new RuntimeException("Arguments are not provided to this fragmemnt");
    this.k = ((ConversationItemLoaderEntity)localBundle.getParcelable("conversation_data"));
    ChatExtensionLoaderEntity localChatExtensionLoaderEntity;
    String str1;
    if (paramBundle == null)
    {
      localChatExtensionLoaderEntity = (ChatExtensionLoaderEntity)localBundle.getParcelable("chat_extension");
      this.l = localChatExtensionLoaderEntity;
      if (paramBundle != null)
        break label205;
      str1 = localBundle.getString("chat_extension_query");
      label69: this.m = str1;
      this.n = localBundle.getBoolean("chat_extension_silent_query");
      if (paramBundle != null)
        break label217;
    }
    label205: label217: for (String str2 = localBundle.getString("chat_extension_entry_point"); ; str2 = null)
    {
      this.o = str2;
      Context localContext = requireContext();
      this.h = AnimationUtils.loadAnimation(localContext, R.anim.long_bottom_slide_in);
      this.i = AnimationUtils.loadAnimation(localContext, R.anim.long_bottom_slide_out);
      this.h.setInterpolator(com.viber.voip.ui.b.c.c);
      this.i.setInterpolator(com.viber.voip.ui.b.c.d);
      this.h.setAnimationListener(new a.a()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          if (i.a(i.this) != null)
            i.a(i.this).a();
        }
      });
      this.i.setAnimationListener(new a.a()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          dj.b(i.b(i.this), false);
          if (i.c(i.this) != null)
            i.c(i.this).E();
        }
      });
      d.n.k.a(true);
      return;
      localChatExtensionLoaderEntity = (ChatExtensionLoaderEntity)paramBundle.getParcelable("initial_chat_extension");
      break;
      str1 = paramBundle.getString("initial_search_query");
      break label69;
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView1 = paramLayoutInflater.inflate(R.layout.fragment_chat_extension_panel, paramViewGroup, false);
    Resources localResources = localView1.getResources();
    View localView2 = localView1.findViewById(R.id.collapsePanelButton);
    View localView3 = localView1.findViewById(R.id.topPanelSpaceView);
    this.g = localView1.findViewById(R.id.panelBodyView);
    localView2.setOnClickListener(this.t);
    dj.a(localView2, localResources.getDimensionPixelSize(R.dimen.small_button_touch_area));
    localView3.setOnClickListener(this.t);
    this.j = new bd(localView1.getContext(), new k(localView1), this.d, this.c, 9, o.a, getLayoutInflater());
    String str;
    if (paramBundle == null)
    {
      str = this.b.b(this.k.getId());
      if (this.l != null)
      {
        this.a.f(this.l.getPublicAccountId());
        a(this.l, this.m, this.n, this.o, false, false, true);
      }
    }
    else
    {
      return localView1;
    }
    if ((!da.a(str)) && (this.a.d(str)))
    {
      a((ChatExtensionLoaderEntity)Objects.requireNonNull(this.a.b(str)), this.o, false, false, false);
      return localView1;
    }
    a(false);
    return localView1;
  }

  public void onDetach()
  {
    this.q = null;
    super.onDetach();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("initial_chat_extension", this.l);
    paramBundle.putString("initial_search_query", this.m);
  }

  public void onStart()
  {
    super.onStart();
    this.c.register(this);
    this.j.a();
  }

  public void onStop()
  {
    this.c.unregister(this);
    this.j.b();
    super.onStop();
  }

  public static abstract interface a
  {
    public abstract void E();
  }

  private static class b
  {
    private long a;
    private long b;

    public void a()
    {
      c();
      this.a = System.currentTimeMillis();
    }

    public long b()
    {
      this.b = (System.currentTimeMillis() - this.a);
      return this.b;
    }

    public void c()
    {
      this.a = 0L;
      this.b = 0L;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.b.i
 * JD-Core Version:    0.6.2
 */
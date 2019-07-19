package com.viber.voip.engagement.contacts;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.viber.jni.Engine;
import com.viber.voip.R.attr;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.av.f;
import com.viber.voip.contacts.b.a;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.contacts.ui.ParticipantSelector.d;
import com.viber.voip.engagement.carousel.h;
import com.viber.voip.engagement.d.o;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.manager.z;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.messages.ui.view.SearchNoResultsView;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.t;
import com.viber.voip.ui.ContactsListView;
import com.viber.voip.ui.aq;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cj;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;
import com.viber.voip.util.dj;
import com.viber.voip.util.x;
import com.viber.voip.util.x.a;
import java.util.List;
import java.util.Locale;

public class e extends aq
{
  private final boolean a = false;
  private a b;
  private Presenter c;
  private int d;

  public static e a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    e locale = new e();
    Bundle localBundle = new Bundle(3);
    localBundle.putInt("top_section_type", paramInt1);
    localBundle.putBoolean("show_groups_in_recent_section", paramBoolean);
    localBundle.putInt("min_last_seen_days", paramInt2);
    locale.setArguments(localBundle);
    return locale;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Application localApplication = ViberApplication.getApplication();
    ViberApplication localViberApplication = ViberApplication.getInstance();
    dagger.a locala = localViberApplication.getLazyContactManager();
    a locala1 = new a(getContext(), av.e.a.a(), getLoaderManager(), locala);
    Engine localEngine = localViberApplication.getEngine(false);
    Member localMember = localViberApplication.getUserManager().getUser();
    boolean bool1;
    com.viber.voip.engagement.d.n localn;
    int i;
    cj localcj;
    h localh;
    f localf;
    Object localObject;
    if (!ao.f())
    {
      bool1 = true;
      localn = new com.viber.voip.engagement.d.n(false, new com.viber.voip.engagement.d.g(bool1, localMember, localApplication.getContentResolver(), ((com.viber.voip.contacts.c.d.g)locala.get()).c(), localEngine.getPhoneController(), localEngine.getOnlineUserActivityHelper()), new o().a(), av.e.a.a());
      Bundle localBundle = getArguments();
      this.d = localBundle.getInt("top_section_type", -1);
      boolean bool2 = localBundle.getBoolean("show_groups_in_recent_section");
      i = localBundle.getInt("min_last_seen_days");
      localcj = cj.a(getContext());
      localh = (h)getActivity();
      localf = new f(localViberApplication.getMessagesManager().c(), d.t.g);
      if (this.d != 0)
        break label280;
      localObject = new com.viber.voip.engagement.a.a(getActivity(), getLoaderManager(), localViberApplication.getLazyMessagesManager(), bool2, com.viber.voip.h.a.b());
    }
    while (true)
    {
      this.c = new Presenter(false, this.d, localMember, locala1, localn, localcj, localh, localf, (com.viber.voip.engagement.c)localObject);
      return;
      bool1 = false;
      break;
      label280: if (1 == this.d)
        localObject = new com.viber.voip.engagement.b.a(av.a(av.e.a), av.f.a, localEngine.getPhoneController(), localEngine.getOnlineUserActivityHelper(), new z(), new com.viber.voip.util.i.c(), i);
      else
        localObject = null;
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_engagement_contacts, paramViewGroup, false);
  }

  public void onDestroyView()
  {
    this.c.d();
    super.onDestroyView();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("presenter_state", this.c.a());
  }

  public void onStart()
  {
    super.onStart();
    this.c.b();
  }

  public void onStop()
  {
    super.onStop();
    this.c.c();
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.b = new a(false, ViberApplication.getInstance(), getActivity(), paramView);
    Presenter localPresenter = this.c;
    a locala = this.b;
    if (paramBundle != null);
    for (Parcelable localParcelable = paramBundle.getParcelable("presenter_state"); ; localParcelable = null)
    {
      localPresenter.a(locala, localParcelable);
      return;
    }
  }

  private final class a
    implements View.OnCreateContextMenuListener, AbsListView.OnScrollListener, g, k
  {
    private final boolean b;
    private final ViberApplication c;
    private final Activity d;
    private final View e;
    private final SearchNoResultsView f;
    private final ContactsListView g;
    private final ProgressBar h;
    private final com.b.a.a.a i;
    private m j;
    private final TextWatcher k = new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        e.a(e.this).a(paramAnonymousEditable.toString());
      }

      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }

      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }
    };
    private final TextView.OnEditorActionListener l = new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (paramAnonymousInt == 3)
        {
          dj.d(e.a.a(e.a.this));
          return true;
        }
        return false;
      }
    };
    private c m;
    private n n;
    private i o;
    private boolean p = true;

    public a(boolean paramViberApplication, ViberApplication paramActivity, Activity paramView, View arg5)
    {
      this.b = paramViberApplication;
      this.c = paramActivity;
      this.d = paramView;
      Object localObject;
      this.e = localObject.findViewById(R.id.search_container);
      EditText localEditText = (EditText)this.e.findViewById(R.id.search);
      localEditText.setCompoundDrawablesWithIntrinsicBounds(e(), null, null, null);
      localEditText.addTextChangedListener(this.k);
      localEditText.setOnEditorActionListener(this.l);
      this.g = ((ContactsListView)localObject.findViewById(16908298));
      this.g.a(this);
      if (this.b)
        this.g.setOnCreateContextMenuListener(this);
      this.h = ((ProgressBar)localObject.findViewById(R.id.progress_bar));
      this.i = new com.b.a.a.a();
      this.f = ((SearchNoResultsView)e.this.getLayoutInflater().inflate(R.layout.search_no_results_item, this.g, false));
      this.i.a(this.f);
      this.i.b(this.f, false);
    }

    public void a()
    {
      dj.b(this.h, true);
      dj.b(this.g, false);
      dj.b(this.e, false);
    }

    public void a(ContextMenu paramContextMenu, String paramString, int paramInt, boolean paramBoolean)
    {
      if (!this.b)
        return;
      View localView = e.this.getLayoutInflater().inflate(R.layout.context_menu_header, null);
      ((TextView)localView.findViewById(R.id.text)).setText(paramString);
      paramContextMenu.setHeaderView(localView);
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      arrayOfObject[1] = Boolean.valueOf(paramBoolean);
      paramContextMenu.add(String.format(localLocale, "Score: '%d' \nRecently online = %b", arrayOfObject));
    }

    public void a(b.a parama1, SendButtonReceiverId[] paramArrayOfSendButtonReceiverId, b.a parama2)
    {
      this.j = new m(paramArrayOfSendButtonReceiverId);
      if (e.b(e.this) == 0);
      for (int i1 = R.string.recent_section_title; ; i1 = R.string.title_suggested_contact)
      {
        this.o = new i(this.d, this, this.j, e.c(e.this), i1, e.this.getLayoutInflater());
        this.i.a(this.o);
        this.i.a(this.o, true);
        this.n = new n(this.d, this.j, this, e.this.getLayoutInflater());
        this.i.a(this.n);
        this.i.a(this.n, true);
        this.m = new c(this.d, this.j, parama1, this, parama2, e.this.getLayoutInflater());
        this.i.a(this.m);
        this.i.a(this.m, true);
        this.g.setAdapter(this.i);
        return;
      }
    }

    public void a(SendButtonReceiverId paramSendButtonReceiverId)
    {
      if (this.j != null)
      {
        this.j.a(paramSendButtonReceiverId);
        this.i.notifyDataSetChanged();
      }
    }

    public void a(final SendButtonReceiverId paramSendButtonReceiverId, List<ParticipantSelector.Participant> paramList, final boolean paramBoolean)
    {
      x.a(this.d, paramList, null, null, x.a.c, new ParticipantSelector.d()
      {
        public void a(ParticipantSelector.Participant paramAnonymousParticipant)
        {
        }

        public void a(boolean paramAnonymousBoolean, ParticipantSelector.Participant paramAnonymousParticipant)
        {
          e.a(e.this).a(paramSendButtonReceiverId, paramAnonymousParticipant, paramBoolean);
        }
      });
    }

    public void a(ConversationLoaderEntity paramConversationLoaderEntity)
    {
      e.a(e.this).a(paramConversationLoaderEntity);
    }

    public void a(com.viber.voip.model.c paramc, boolean paramBoolean)
    {
      e.a(e.this).a(paramc, paramBoolean);
    }

    public void a(String paramString)
    {
      this.f.setQueryText(paramString);
      this.i.b(this.f, true);
    }

    public void a(List<com.viber.voip.model.a> paramList)
    {
      int i1 = paramList.size() - this.n.getCount();
      int i2 = this.g.getFirstVisiblePosition();
      View localView = this.g.getChildAt(0);
      if (localView != null);
      for (int i3 = localView.getTop(); ; i3 = 0)
      {
        this.n.a(paramList);
        this.i.notifyDataSetChanged();
        if ((this.p) && (i2 != 0) && (i1 != 0))
        {
          int i4 = Math.min(-1 + this.i.getCount(), Math.max(0, i1 + i2));
          this.g.smoothScrollToPositionFromTop(i4, i3);
        }
        return;
      }
    }

    public void a(boolean paramBoolean)
    {
      if (this.j != null)
      {
        this.j.a(paramBoolean);
        this.i.notifyDataSetChanged();
      }
    }

    public void b()
    {
      dj.b(this.h, false);
      dj.b(this.g, true);
      dj.b(this.e, true);
      c();
    }

    public void b(List<RegularConversationLoaderEntity> paramList)
    {
      if (this.o != null)
        this.o.a(paramList);
    }

    public void b(boolean paramBoolean)
    {
      boolean bool1 = true;
      f();
      com.b.a.a.a locala1 = this.i;
      n localn = this.n;
      boolean bool2;
      com.b.a.a.a locala2;
      i locali;
      if (!paramBoolean)
      {
        bool2 = bool1;
        locala1.a(localn, bool2);
        locala2 = this.i;
        locali = this.o;
        if (paramBoolean)
          break label63;
      }
      while (true)
      {
        locala2.a(locali, bool1);
        return;
        bool2 = false;
        break;
        label63: bool1 = false;
      }
    }

    public void c()
    {
      this.i.notifyDataSetChanged();
    }

    public void d()
    {
      this.c.showToast(R.string.dialog_514_message);
      this.i.notifyDataSetChanged();
    }

    public Drawable e()
    {
      return df.a(ContextCompat.getDrawable(this.d, R.drawable.ic_action_search), dc.d(this.d, R.attr.sayHiSearchIconColor), false);
    }

    public void f()
    {
      this.i.b(this.f, false);
    }

    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      if (!this.b);
      Object localObject;
      do
      {
        return;
        AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
        localObject = this.i.getItem(localAdapterContextMenuInfo.position);
      }
      while ((localObject == null) || (!(localObject instanceof com.viber.voip.model.c)));
      e.a(e.this).a(paramContextMenu, (com.viber.voip.model.c)localObject);
    }

    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
    }

    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if (paramInt == 0);
      for (boolean bool = true; ; bool = false)
      {
        this.p = bool;
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.contacts.e
 * JD-Core Version:    0.6.2
 */
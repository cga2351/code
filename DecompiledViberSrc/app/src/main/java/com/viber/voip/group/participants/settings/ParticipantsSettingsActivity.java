package com.viber.voip.group.participants.settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.LoaderManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.messages.conversation.m;
import com.viber.voip.messages.ui.view.SearchNoResultsView;
import com.viber.voip.ui.MenuSearchMediator;
import com.viber.voip.ui.ac.a;
import com.viber.voip.util.dj;
import java.util.Map;

public class ParticipantsSettingsActivity extends ViberFragmentActivity
{
  private static final Logger a = ViberEnv.getLogger();
  private a b;
  private ParticipantsSettingsPresenter c;
  private long d;
  private long e;

  private void a(Intent paramIntent)
  {
    this.d = paramIntent.getLongExtra("thread_id", -1L);
    this.e = paramIntent.getLongExtra("extra_group_id", -1L);
    if ((this.d == -1L) || (this.e == -1L))
      finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_particpants_settings);
    getSupportActionBar().b(true);
    setActionBarTitle(R.string.member_privileges_title);
    a(getIntent());
    dagger.a locala = ViberApplication.getInstance().getLazyMessagesManager();
    this.b = new a(findViewById(16908290), this);
    LoaderManager localLoaderManager = getSupportLoaderManager();
    d locald = new d(this, localLoaderManager, locala, com.viber.voip.h.a.b());
    com.viber.voip.invitelinks.linkscreen.g localg = new com.viber.voip.invitelinks.linkscreen.g(this.d, new m(5, this, localLoaderManager, locala));
    this.c = new ParticipantsSettingsPresenter(this.d, this.e, locald, new h(((com.viber.voip.messages.k)locala.get()).d()), localg, com.viber.voip.analytics.g.a());
    ParticipantsSettingsPresenter localParticipantsSettingsPresenter = this.c;
    a locala1 = this.b;
    if (paramBundle != null);
    for (Parcelable localParcelable = paramBundle.getParcelable("presenter_state"); ; localParcelable = null)
    {
      localParticipantsSettingsPresenter.a(locala1, localParcelable);
      return;
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.c.b();
    this.b.b();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("presenter_state", this.c.c());
  }

  protected void onStart()
  {
    super.onStart();
    this.c.a();
  }

  protected void onStop()
  {
    this.c.d();
    super.onStop();
  }

  public boolean onSupportNavigateUp()
  {
    onBackPressed();
    return true;
  }

  private static class a
    implements j, ac.a
  {
    private final Activity a;
    private final SearchNoResultsView b;
    private k c;
    private final RecyclerView d;
    private f e;
    private d f;
    private MenuItem g;
    private MenuSearchMediator h;
    private String i;

    public a(View paramView, Activity paramActivity)
    {
      this.a = paramActivity;
      this.d = ((RecyclerView)paramView.findViewById(R.id.participant_settings_list));
      this.d.addOnScrollListener(new RecyclerView.OnScrollListener()
      {
        public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          if ((paramAnonymousInt == 1) && (ParticipantsSettingsActivity.a.a(ParticipantsSettingsActivity.a.this).e()))
            dj.c(paramAnonymousRecyclerView);
        }

        public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
        }
      });
      this.h = new MenuSearchMediator(this);
      this.b = ((SearchNoResultsView)paramView.findViewById(R.id.search_no_results));
    }

    public void a()
    {
      this.a.finish();
    }

    public void a(d paramd, b paramb)
    {
      this.f = paramd;
      this.e = new f(this.a, this.f, paramb, this.c, this.a.getLayoutInflater());
      this.d.setAdapter(this.e);
    }

    public void a(k paramk)
    {
      this.c = paramk;
    }

    public void a(String paramString)
    {
      if (this.g != null)
      {
        if (!TextUtils.isEmpty(paramString));
        for (boolean bool = true; ; bool = false)
        {
          this.h.a(this.g, bool, paramString);
          return;
        }
      }
      this.i = paramString;
    }

    public void a(Map<String, ? extends b> paramMap, b paramb)
    {
      int j;
      if (this.f.c() == 0)
      {
        j = 1;
        if ((j == 0) || (!this.h.e()))
          break label70;
        this.b.setQueryText(this.h.a());
        dj.b(this.b, true);
      }
      while (true)
      {
        this.e.a(paramMap, paramb);
        this.e.notifyDataSetChanged();
        return;
        j = 0;
        break;
        label70: dj.b(this.b, false);
      }
    }

    public void b()
    {
      this.h.c(true);
    }

    public boolean onQueryTextChange(String paramString)
    {
      if (this.c != null)
        this.c.a(paramString);
      return true;
    }

    public boolean onQueryTextSubmit(String paramString)
    {
      return false;
    }

    public boolean onSearchViewShow(boolean paramBoolean)
    {
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.group.participants.settings.ParticipantsSettingsActivity
 * JD-Core Version:    0.6.2
 */
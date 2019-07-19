package com.viber.voip.messages.translation;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.viber.common.b.b;
import com.viber.common.d.c;
import com.viber.dexshared.Logger;
import com.viber.voip.R.attr;
import com.viber.voip.R.color;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.orm.entity.json.Language;
import com.viber.voip.settings.d.ad.a;
import com.viber.voip.settings.ui.aj;
import com.viber.voip.ui.ac.a;
import com.viber.voip.ui.aq;
import com.viber.voip.util.da;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.widget.a.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public class f extends aq
  implements ac.a
{
  private static final Logger d = ViberEnv.getLogger();

  @Inject
  com.viber.voip.analytics.g a;
  aj b;
  Runnable c;
  private b e;
  private Drawable f;
  private Drawable g;
  private boolean h;
  private boolean i;

  private Language a(List<Language> paramList, String paramString)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Language localLanguage = (Language)localIterator.next();
      if (paramString.equals(localLanguage.getCode()))
        return localLanguage;
    }
    return null;
  }

  private void a()
  {
    Language localLanguage = this.e.a();
    Intent localIntent = new Intent().putExtra("selected_lang", localLanguage.getCode()).putExtra("from_url_scheme", this.h);
    getActivity().setResult(-1, localIntent);
    finish();
  }

  private void a(List<Language> paramList)
  {
    Language localLanguage = a(paramList, "en");
    paramList.remove(localLanguage);
    if ((!com.viber.common.d.a.j()) && (!d.ad.a.d.d()))
      paramList.remove(a(paramList, "my"));
    Collections.sort(paramList, new Comparator()
    {
      public int a(Language paramAnonymousLanguage1, Language paramAnonymousLanguage2)
      {
        return paramAnonymousLanguage1.getVisibleName().compareTo(paramAnonymousLanguage2.getVisibleName());
      }
    });
    paramList.add(0, localLanguage);
  }

  private Language b(List<Language> paramList, String paramString)
  {
    int j = paramList.size();
    for (int k = 0; k < j; k++)
    {
      Language localLanguage = (Language)paramList.get(k);
      if (localLanguage.getCode().equals(paramString))
        return localLanguage;
    }
    return null;
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.f = dc.g(requireActivity(), R.attr.listItemDivider);
    this.g = dc.g(requireActivity(), R.attr.listSectionDivider);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    paramMenuInflater.inflate(R.menu.menu_ui_language, paramMenu);
    View localView = paramMenu.findItem(R.id.menu_save).getActionView();
    if ((localView != null) && ((localView instanceof ImageButton)))
    {
      ImageButton localImageButton = (ImageButton)localView;
      localImageButton.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_ab_action_done));
      localImageButton.setBackgroundResource(R.color.transparent);
      localImageButton.setColorFilter(dc.d(getActivity(), R.attr.menuItemIconTint), PorterDuff.Mode.MULTIPLY);
      if (this.i)
      {
        this.c = new g(this, localView);
        av.a(av.e.a).postDelayed(this.c, 1000L);
      }
      localImageButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          f.a(f.this);
        }
      });
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.fragment_participants_list, paramViewGroup, false);
    Bundle localBundle = getArguments();
    String str = localBundle.getString("selected_lang", "");
    this.h = localBundle.getBoolean("from_url_scheme");
    this.i = localBundle.getBoolean("from_url_scheme_with_language");
    List localList = a.b.a(localView.getContext());
    a(localList);
    localList.add(0, new Language(Integer.valueOf(0), getString(R.string.pref_ui_language_use_system), getString(R.string.pref_ui_language_use_system), ""));
    Language localLanguage = b(localList, str);
    this.e = new b(localList, localLanguage, getLayoutInflater());
    RecyclerView localRecyclerView = (RecyclerView)localView.findViewById(R.id.recycler_view);
    localRecyclerView.addItemDecoration(new com.viber.voip.widget.a.a());
    localRecyclerView.setAdapter(this.e);
    int j = this.e.a(localLanguage);
    if (j >= 0)
      localRecyclerView.getLayoutManager().scrollToPosition(j);
    setHasOptionsMenu(true);
    return localView;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (R.id.menu_save == paramMenuItem.getItemId())
      a();
    return true;
  }

  public boolean onQueryTextChange(String paramString)
  {
    this.e.a(paramString);
    return false;
  }

  public boolean onQueryTextSubmit(String paramString)
  {
    return false;
  }

  public boolean onSearchViewShow(boolean paramBoolean)
  {
    return true;
  }

  public void onStop()
  {
    super.onStop();
    if (this.c != null)
      av.a(av.e.a).removeCallbacks(this.c);
    if (this.b != null)
      this.b.b();
  }

  private class a extends RecyclerView.ViewHolder
    implements a.a
  {
    public View a;
    public TextView b;
    public TextView c;

    public a(View arg2)
    {
      super();
      this.a = localView.findViewById(R.id.checkbox);
      this.b = ((TextView)localView.findViewById(R.id.label));
      this.c = ((TextView)localView.findViewById(R.id.label2));
    }

    public Drawable a()
    {
      if (getAdapterPosition() == 0)
        return f.b(f.this);
      return f.c(f.this);
    }

    public void a(Language paramLanguage1, Language paramLanguage2, int paramInt)
    {
      this.itemView.setTag(paramLanguage1);
      this.b.setText(c.b(paramLanguage1.getVisibleName()));
      if (da.a(paramLanguage1.getCode()))
      {
        this.c.setVisibility(0);
        this.c.setText(c.b(f.this.getString(R.string.pref_ui_language_supported_languages)));
      }
      while (true)
      {
        View localView = this.a;
        boolean bool1 = false;
        if (paramLanguage2 != null)
        {
          boolean bool2 = paramLanguage1.getCode().equals(paramLanguage2.getCode());
          bool1 = false;
          if (bool2)
            bool1 = true;
        }
        dj.b(localView, bool1);
        return;
        this.c.setVisibility(8);
      }
    }
  }

  private class b extends RecyclerView.Adapter<f.a>
    implements View.OnClickListener
  {
    private List<Language> b;
    private List<Language> c;
    private Language d;
    private LayoutInflater e;
    private String f = "";

    public b(Language paramLayoutInflater, LayoutInflater arg3)
    {
      this.b = paramLayoutInflater;
      this.c = new ArrayList(this.b);
      Object localObject1;
      this.d = localObject1;
      Object localObject2;
      this.e = localObject2;
    }

    private boolean a(String paramString1, String paramString2)
    {
      if (paramString1 == null)
        return false;
      return paramString1.toLowerCase().startsWith(paramString2.toLowerCase());
    }

    public int a(Language paramLanguage)
    {
      return this.b.indexOf(paramLanguage);
    }

    public Language a()
    {
      return this.d;
    }

    public Language a(int paramInt)
    {
      return (Language)this.c.get(paramInt);
    }

    public f.a a(ViewGroup paramViewGroup, int paramInt)
    {
      View localView = this.e.inflate(R.layout.ui_languages_list_item, paramViewGroup, false);
      localView.setOnClickListener(this);
      return new f.a(f.this, localView);
    }

    public void a(f.a parama, int paramInt)
    {
      parama.a(a(paramInt), this.d, paramInt);
    }

    public void a(String paramString)
    {
      this.f = paramString;
      if (paramString.trim().equals(""));
      ArrayList localArrayList;
      for (this.c = new ArrayList(this.b); ; this.c = localArrayList)
      {
        notifyDataSetChanged();
        return;
        localArrayList = new ArrayList();
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          Language localLanguage = (Language)localIterator.next();
          if ((a(localLanguage.getVisibleName(), paramString)) || (a(localLanguage.getLanguage(), paramString)))
            localArrayList.add(localLanguage);
        }
      }
    }

    public int getItemCount()
    {
      return this.c.size();
    }

    public void onClick(View paramView)
    {
      this.d = ((Language)paramView.getTag());
      notifyDataSetChanged();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.translation.f
 * JD-Core Version:    0.6.2
 */
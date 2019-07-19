package com.viber.voip.messages.translation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.o;
import com.viber.voip.messages.orm.entity.json.Language;
import com.viber.voip.ui.aq;
import com.viber.voip.util.dj;
import com.viber.voip.widget.a.e;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;

public class c extends aq
{

  @Inject
  g a;
  private c b;
  private String c;
  private Language d;
  private com.viber.voip.analytics.story.g.a e;

  private Language a(List<Language> paramList, String paramString)
  {
    int i = paramList.size();
    for (int j = 0; j < i; j++)
    {
      Language localLanguage = (Language)paramList.get(j);
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
    this.e = this.a.c().c();
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.menu_pa_edit, paramMenu);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.fragment_participants_list, paramViewGroup, false);
    this.c = getArguments().getString("selected_lang", "");
    List localList = a.a.a(localView.getContext());
    Locale localLocale = Locale.getDefault();
    Language localLanguage = new Language(Integer.valueOf(0), localLocale.getDisplayName(), localLocale.getDisplayName(), localLocale.getLanguage());
    localList.remove(localLanguage);
    localList.add(0, localLanguage);
    this.d = a(localList, this.c);
    this.b = new c(localList, this.d, getLayoutInflater());
    RecyclerView localRecyclerView = (RecyclerView)localView.findViewById(R.id.recycler_view);
    e locale = new e(ContextCompat.getDrawable(getActivity(), R.drawable.recycler_divider_without_paddings));
    locale.a(0, true);
    localRecyclerView.addItemDecoration(locale);
    localRecyclerView.setAdapter(this.b);
    setHasOptionsMenu(true);
    return localView;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Language localLanguage = this.b.a();
    if ((this.d != null) && (localLanguage != null) && (!this.d.getCode().equals(localLanguage.getCode())))
      this.e.a(this.d, localLanguage);
    Intent localIntent1 = new Intent();
    if (localLanguage != null);
    for (String str = localLanguage.getCode(); ; str = this.c)
    {
      Intent localIntent2 = localIntent1.putExtra("selected_lang", str).putExtra("selected_msg", getArguments().getLong("selected_msg", -1L));
      getActivity().setResult(-1, localIntent2);
      finish();
      return true;
    }
  }

  private static class a extends RecyclerView.ViewHolder
  {
    public TextView a;

    public a(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(R.id.label));
    }

    public void a(Language paramLanguage1, Language paramLanguage2, int paramInt)
    {
      if (paramInt == 0)
      {
        this.a.setText(R.string.default_language);
        return;
      }
      this.a.setText(R.string.all_language);
    }
  }

  private static class b extends c.a
  {
    public View b;

    public b(View paramView)
    {
      super();
      this.b = paramView.findViewById(R.id.checkbox);
    }

    public void a(Language paramLanguage1, Language paramLanguage2, int paramInt)
    {
      this.itemView.setTag(paramLanguage1);
      this.a.setText(com.viber.common.d.c.b(paramLanguage1.getVisibleName()));
      View localView = this.b;
      if ((paramLanguage2 != null) && (paramLanguage1.getCode().equals(paramLanguage2.getCode())));
      for (boolean bool = true; ; bool = false)
      {
        dj.b(localView, bool);
        return;
      }
    }
  }

  private static class c extends RecyclerView.Adapter<c.a>
    implements View.OnClickListener
  {
    private List<Language> a;
    private Language b;
    private LayoutInflater c;

    public c(List<Language> paramList, Language paramLanguage, LayoutInflater paramLayoutInflater)
    {
      this.a = paramList;
      this.b = paramLanguage;
      this.c = paramLayoutInflater;
    }

    public int a(int paramInt)
    {
      if (paramInt == 1)
        return 0;
      if (paramInt > 0)
        return paramInt - 2;
      return -1;
    }

    public Language a()
    {
      return this.b;
    }

    public c.a a(ViewGroup paramViewGroup, int paramInt)
    {
      switch (paramInt)
      {
      default:
        throw new IllegalArgumentException("ViewType = " + paramInt + " is not supported");
      case 1:
        View localView = this.c.inflate(R.layout.languages_list_item, paramViewGroup, false);
        localView.setOnClickListener(this);
        return new c.b(localView);
      case 0:
      }
      return new c.a(this.c.inflate(R.layout.header_select_languages, paramViewGroup, false));
    }

    public void a(c.a parama, int paramInt)
    {
      parama.a(b(paramInt), this.b, paramInt);
    }

    public Language b(int paramInt)
    {
      if (paramInt > 0)
        return (Language)this.a.get(a(paramInt));
      return null;
    }

    public int getItemCount()
    {
      return 2 + this.a.size();
    }

    public int getItemViewType(int paramInt)
    {
      if ((paramInt == 0) || (paramInt == 2))
        return 0;
      return 1;
    }

    public void onClick(View paramView)
    {
      this.b = ((Language)paramView.getTag());
      notifyDataSetChanged();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.translation.c
 * JD-Core Version:    0.6.2
 */
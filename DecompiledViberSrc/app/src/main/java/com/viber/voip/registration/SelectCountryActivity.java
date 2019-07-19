package com.viber.voip.registration;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.support.v7.app.a;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnCloseListener;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SelectCountryActivity extends ViberFragmentActivity
  implements AdapterView.OnItemClickListener
{
  private static final Logger a = ViberEnv.getLogger();
  private ListView b;
  private String c;
  private List<CountryCode> d = new ArrayList();
  private Runnable e = new Runnable()
  {
    public void run()
    {
      ArrayList localArrayList;
      if (!da.a(SelectCountryActivity.d(SelectCountryActivity.this)))
      {
        SelectCountryActivity.a(SelectCountryActivity.this, SelectCountryActivity.d(SelectCountryActivity.this).replace("+", ""));
        localArrayList = new ArrayList(250);
        Pattern localPattern = Pattern.compile(".*\\b\\Q" + SelectCountryActivity.d(SelectCountryActivity.this) + "\\E.*", 2);
        for (int i = 0; i < SelectCountryActivity.a(SelectCountryActivity.this).size(); i++)
        {
          CountryCode localCountryCode = (CountryCode)SelectCountryActivity.a(SelectCountryActivity.this).get(i);
          String str1 = localCountryCode.getName();
          String str2 = localCountryCode.getDefaultName();
          if ((localCountryCode.getIddCode().startsWith(SelectCountryActivity.d(SelectCountryActivity.this))) || (localPattern.matcher(str1).find()) || ((str2 != null) && (localPattern.matcher(str2).find())))
            localArrayList.add(localCountryCode);
        }
      }
      for (Object localObject = localArrayList; ; localObject = SelectCountryActivity.a(SelectCountryActivity.this))
      {
        SelectCountryActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            SelectCountryActivity.a locala = (SelectCountryActivity.a)SelectCountryActivity.b(SelectCountryActivity.this).getAdapter();
            if (locala != null)
            {
              locala.a(this.a);
              locala.notifyDataSetChanged();
            }
            SelectCountryActivity.b(SelectCountryActivity.this).setSelectionAfterHeaderView();
          }
        });
        return;
      }
    }
  };

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.select_country);
    if (ViberApplication.isTablet(this))
      dj.b(this);
    setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
    getSupportActionBar().e(true);
    getSupportActionBar().b(true);
    getSupportActionBar().a("");
    this.b = ((ListView)findViewById(R.id.list));
    this.b.setEmptyView(findViewById(R.id.no_found));
    this.b.setOnItemClickListener(this);
    av.a(av.e.g).postAtFrontOfQueue(new Runnable()
    {
      public void run()
      {
        SelectCountryActivity.a(SelectCountryActivity.this, ViberApplication.getInstance().getCountryCodeManager().b());
        final CountryCode localCountryCode = (CountryCode)SelectCountryActivity.this.getIntent().getParcelableExtra("extra_selected_code");
        if ((localCountryCode != null) && (SelectCountryActivity.a(SelectCountryActivity.this) != null));
        for (final int i = SelectCountryActivity.a(SelectCountryActivity.this).indexOf(localCountryCode); ; i = 0)
        {
          SelectCountryActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              SelectCountryActivity.this.findViewById(R.id.no_found).setVisibility(0);
              SelectCountryActivity.b(SelectCountryActivity.this).setAdapter(new SelectCountryActivity.a(SelectCountryActivity.this, SelectCountryActivity.a(SelectCountryActivity.this), localCountryCode));
              SelectCountryActivity.b(SelectCountryActivity.this).setSelection(i);
            }
          });
          return;
        }
      }
    });
    this.b.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        dj.d(SelectCountryActivity.this);
        return false;
      }
    });
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.menu_select_country, paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(R.id.menu_search);
    localMenuItem.expandActionView();
    SearchView localSearchView = (SearchView)localMenuItem.getActionView();
    localSearchView.setIconified(false);
    localSearchView.clearFocus();
    localSearchView.setQueryHint(getResources().getString(R.string.menu_search));
    if (Build.VERSION.SDK_INT < 21)
      dj.a(localSearchView, ContextCompat.getColor(this, R.color.sub_text));
    localSearchView.setPadding(0, 0, 0, 0);
    localSearchView.setMaxWidth(getResources().getDimensionPixelOffset(R.dimen.search_view_max_width));
    localSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
    {
      public boolean onQueryTextChange(String paramAnonymousString)
      {
        Handler localHandler = av.a(av.e.g);
        SelectCountryActivity.a(SelectCountryActivity.this, paramAnonymousString.toLowerCase());
        localHandler.removeCallbacks(SelectCountryActivity.c(SelectCountryActivity.this));
        localHandler.postDelayed(SelectCountryActivity.c(SelectCountryActivity.this), 100L);
        return false;
      }

      public boolean onQueryTextSubmit(String paramAnonymousString)
      {
        return false;
      }
    });
    localSearchView.setOnCloseListener(new SearchView.OnCloseListener()
    {
      public boolean onClose()
      {
        return true;
      }
    });
    MenuItemCompat.setOnActionExpandListener(localMenuItem, new MenuItemCompat.OnActionExpandListener()
    {
      public boolean onMenuItemActionCollapse(MenuItem paramAnonymousMenuItem)
      {
        SelectCountryActivity.this.finish();
        return true;
      }

      public boolean onMenuItemActionExpand(MenuItem paramAnonymousMenuItem)
      {
        return true;
      }
    });
    return super.onCreateOptionsMenu(paramMenu);
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    b localb = (b)paramView.getTag();
    if ((localb != null) && (localb.a() != null))
    {
      Intent localIntent = new Intent(this, RegistrationActivity.class);
      localIntent.putExtra("extra_selected_code", localb.a());
      setResult(-1, localIntent);
      finish();
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return false;
    case 16908332:
    }
    finish();
    return true;
  }

  private static class a extends BaseAdapter
  {
    private List<CountryCode> a;
    private CountryCode b;
    private LayoutInflater c;

    public a(Context paramContext, List<CountryCode> paramList, CountryCode paramCountryCode)
    {
      this.c = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
      this.a = paramList;
      this.b = paramCountryCode;
    }

    public CountryCode a(int paramInt)
    {
      if (this.a != null)
        return (CountryCode)this.a.get(paramInt);
      return null;
    }

    public void a(List<CountryCode> paramList)
    {
      this.a = paramList;
    }

    public int getCount()
    {
      if (this.a != null)
        return this.a.size();
      return 0;
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      CountryCode localCountryCode = a(paramInt);
      View localView1;
      SelectCountryActivity.b localb2;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        localView1 = this.c.inflate(R.layout.country_item, null);
        SelectCountryActivity.b localb1 = new SelectCountryActivity.b(localView1);
        localView1.setTag(localb1);
        localb2 = localb1;
      }
      for (View localView2 = localView1; (localView2 == null) || (localb2 == null); localView2 = paramView)
      {
        return null;
        localb2 = (SelectCountryActivity.b)paramView.getTag();
      }
      SelectCountryActivity.b.a(localb2, localCountryCode);
      SelectCountryActivity.b.a(localb2).setText(da.a(localCountryCode.getName(), localCountryCode.getIddCode(), localCountryCode.getDefaultName()));
      if (localCountryCode.equals(this.b))
      {
        dj.b(SelectCountryActivity.b.b(localb2), true);
        return localView2;
      }
      dj.b(SelectCountryActivity.b.b(localb2), false);
      return localView2;
    }
  }

  private static class b
  {
    private final TextView a;
    private final ImageView b;
    private CountryCode c;

    public b(View paramView)
    {
      this.a = ((TextView)paramView.findViewById(R.id.name));
      this.b = ((ImageView)paramView.findViewById(R.id.country_selected));
    }

    public CountryCode a()
    {
      return this.c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.SelectCountryActivity
 * JD-Core Version:    0.6.2
 */
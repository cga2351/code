package com.viber.voip.viberout.ui.products.search.country;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.viber.voip.R.color;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.b;
import com.viber.voip.util.u;
import com.viber.voip.viberout.ui.products.model.CountryModel;
import com.viber.voip.widget.ProgressBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a extends BaseAdapter
  implements Filterable
{
  static final CountryModel a = new CountryModel("", "", "");
  private int b = 1;
  private final Context c;
  private final LayoutInflater d;
  private final e e;
  private Filter f;
  private List<CountryModel> g = Collections.emptyList();
  private List<CountryModel> h;
  private String i = "";

  a(Context paramContext, e parame, LayoutInflater paramLayoutInflater)
  {
    this.c = paramContext;
    this.d = paramLayoutInflater;
    this.e = parame;
  }

  private void b(String paramString)
  {
  }

  private void d()
  {
    b("setContentMode");
    b(3);
    notifyDataSetChanged();
  }

  public CountryModel a(int paramInt)
  {
    if (this.b == 3)
      return (CountryModel)this.g.get(paramInt);
    return a;
  }

  void a()
  {
    b("setEmptyMode");
    b(1);
    notifyDataSetChanged();
  }

  public void a(String paramString)
  {
    this.i = paramString;
  }

  public void a(List<CountryModel> paramList)
  {
    b("setItems");
    if (u.a(paramList))
    {
      this.g = Collections.emptyList();
      this.h = Collections.emptyList();
      a();
      return;
    }
    this.g = paramList;
    this.h = new ArrayList(paramList);
    d();
  }

  void a(List<CountryModel> paramList, CharSequence paramCharSequence)
  {
    this.g = paramList;
    this.h = new ArrayList(paramList);
    getFilter().filter(paramCharSequence);
  }

  void b()
  {
    b("setLoadingMode");
    b(2);
    notifyDataSetChanged();
  }

  void b(int paramInt)
  {
    this.b = paramInt;
  }

  void c()
  {
    a(this.h);
  }

  public int getCount()
  {
    int j = 1;
    if (this.b == 3)
      j = this.g.size();
    while (this.b != j)
      return j;
    return j;
  }

  public Filter getFilter()
  {
    if (this.f == null)
      this.f = new a(null);
    return this.f;
  }

  public long getItemId(int paramInt)
  {
    return 0L;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.b == 3)
    {
      b localb2;
      if (!(paramView instanceof LinearLayout))
      {
        paramView = this.d.inflate(R.layout.vo_search_country_item, paramViewGroup, false);
        localb2 = new b((TextView)paramView.findViewById(R.id.title), (ImageView)paramView.findViewById(R.id.icon), null);
        paramView.setTag(localb2);
      }
      for (b localb1 = localb2; ; localb1 = (b)paramView.getTag())
      {
        CountryModel localCountryModel = a(paramInt);
        localb1.a.setText(localCountryModel.getName());
        this.e.a(Uri.parse(localCountryModel.getImage()), localb1.b, f.a(R.drawable.ic_vo_default_country, f.b.a));
        return paramView;
      }
    }
    if (this.b == 2)
    {
      ViewGroup localViewGroup = (ViewGroup)this.d.inflate(R.layout.vo_search_country_load, paramViewGroup, false);
      ((ProgressBar)localViewGroup.findViewById(R.id.progress)).setProgressColor(this.c.getResources().getColor(R.color.my_account_loader));
      return localViewGroup;
    }
    TextView localTextView = (TextView)this.d.inflate(R.layout.vo_search_country_empty, paramViewGroup, false);
    localTextView.setText(this.i);
    return localTextView;
  }

  private class a extends Filter
  {
    private a()
    {
    }

    protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      ArrayList localArrayList1;
      if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
      {
        localArrayList1 = new ArrayList(a.a(a.this));
        localFilterResults.values = localArrayList1;
      }
      ArrayList localArrayList3;
      for (localFilterResults.count = localArrayList1.size(); ; localFilterResults.count = localArrayList3.size())
      {
        if (localFilterResults.count == 0)
        {
          localFilterResults.values = Collections.singletonList(a.a);
          localFilterResults.count = 1;
        }
        return localFilterResults;
        String str1 = paramCharSequence.toString().toLowerCase();
        ArrayList localArrayList2 = new ArrayList(a.a(a.this));
        int i = localArrayList2.size();
        localArrayList3 = new ArrayList();
        int j = 0;
        if (j < i)
        {
          CountryModel localCountryModel = (CountryModel)localArrayList2.get(j);
          String str2 = localCountryModel.getName().toLowerCase();
          if (str2.startsWith(str1))
            localArrayList3.add(localCountryModel);
          label224: 
          while (true)
          {
            j++;
            break;
            String[] arrayOfString = str2.split(" ");
            int k = arrayOfString.length;
            for (int m = 0; ; m++)
            {
              if (m >= k)
                break label224;
              if (arrayOfString[m].startsWith(str1))
              {
                localArrayList3.add(localCountryModel);
                break;
              }
            }
          }
        }
        localFilterResults.values = localArrayList3;
      }
    }

    protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      a.a(a.this, (List)paramFilterResults.values);
      if (((paramFilterResults.count > 0) || (TextUtils.isEmpty(paramCharSequence))) && (!u.a(a.b(a.this))) && (!((CountryModel)a.b(a.this).get(0)).equals(a.a)))
      {
        a.a(a.this, "");
        a.c(a.this);
        return;
      }
      a.a(a.this, Collections.singletonList(a.a));
      a.a(a.this, a.d(a.this).getString(R.string.vo_search_no_matches, new Object[] { paramCharSequence }));
      a.this.a();
    }
  }

  private static final class b
  {
    final TextView a;
    final ImageView b;

    private b(TextView paramTextView, ImageView paramImageView)
    {
      this.a = paramTextView;
      this.b = paramImageView;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.search.country.a
 * JD-Core Version:    0.6.2
 */
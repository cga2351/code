package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.d.c;
import android.support.v7.d.c.a;
import android.support.v7.d.c.b;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class h extends RecyclerView.Adapter<l>
  implements Preference.a
{
  private PreferenceGroup a;
  private List<Preference> b;
  private List<Preference> c;
  private List<a> d;
  private a e = new a();
  private Handler f;
  private a g;
  private Runnable h = new Runnable()
  {
    public void run()
    {
      h.this.a();
    }
  };

  public h(PreferenceGroup paramPreferenceGroup)
  {
    this(paramPreferenceGroup, new Handler());
  }

  private h(PreferenceGroup paramPreferenceGroup, Handler paramHandler)
  {
    this.a = paramPreferenceGroup;
    this.f = paramHandler;
    this.g = new a(paramPreferenceGroup, this);
    this.a.a(this);
    this.b = new ArrayList();
    this.c = new ArrayList();
    this.d = new ArrayList();
    if ((this.a instanceof PreferenceScreen))
      setHasStableIds(((PreferenceScreen)this.a).i());
    while (true)
    {
      a();
      return;
      setHasStableIds(true);
    }
  }

  private a a(Preference paramPreference, a parama)
  {
    if (parama != null);
    while (true)
    {
      parama.c = paramPreference.getClass().getName();
      parama.a = paramPreference.v();
      parama.b = paramPreference.w();
      return parama;
      parama = new a();
    }
  }

  private void a(List<Preference> paramList, PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.h();
    int i = paramPreferenceGroup.e();
    for (int j = 0; j < i; j++)
    {
      Preference localPreference = paramPreferenceGroup.b(j);
      paramList.add(localPreference);
      d(localPreference);
      if ((localPreference instanceof PreferenceGroup))
      {
        PreferenceGroup localPreferenceGroup = (PreferenceGroup)localPreference;
        if (localPreferenceGroup.f())
          a(paramList, localPreferenceGroup);
      }
      localPreference.a(this);
    }
  }

  private void d(Preference paramPreference)
  {
    a locala = a(paramPreference, null);
    if (!this.d.contains(locala))
      this.d.add(locala);
  }

  public Preference a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getItemCount()))
      return null;
    return (Preference)this.b.get(paramInt);
  }

  public l a(ViewGroup paramViewGroup, int paramInt)
  {
    a locala = (a)this.d.get(paramInt);
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    TypedArray localTypedArray = paramViewGroup.getContext().obtainStyledAttributes(null, R.styleable.BackgroundStyle);
    Drawable localDrawable = localTypedArray.getDrawable(R.styleable.BackgroundStyle_android_selectableItemBackground);
    if (localDrawable == null)
      localDrawable = ContextCompat.getDrawable(paramViewGroup.getContext(), 17301602);
    localTypedArray.recycle();
    View localView = localLayoutInflater.inflate(locala.a, paramViewGroup, false);
    if (localView.getBackground() == null)
      ViewCompat.setBackground(localView, localDrawable);
    ViewGroup localViewGroup = (ViewGroup)localView.findViewById(16908312);
    if (localViewGroup != null)
    {
      if (locala.b == 0)
        break label141;
      localLayoutInflater.inflate(locala.b, localViewGroup);
    }
    while (true)
    {
      return new l(localView);
      label141: localViewGroup.setVisibility(8);
    }
  }

  void a()
  {
    Iterator localIterator1 = this.c.iterator();
    while (localIterator1.hasNext())
      ((Preference)localIterator1.next()).a(null);
    ArrayList localArrayList = new ArrayList(this.c.size());
    a(localArrayList, this.a);
    final List localList1 = this.g.a(this.a);
    final List localList2 = this.b;
    this.b = localList1;
    this.c = localArrayList;
    j localj = this.a.L();
    if ((localj != null) && (localj.h() != null))
      c.a(new c.a()
      {
        public boolean areContentsTheSame(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return this.c.b((Preference)localList2.get(paramAnonymousInt1), (Preference)localList1.get(paramAnonymousInt2));
        }

        public boolean areItemsTheSame(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return this.c.a((Preference)localList2.get(paramAnonymousInt1), (Preference)localList1.get(paramAnonymousInt2));
        }

        public int getNewListSize()
        {
          return localList1.size();
        }

        public int getOldListSize()
        {
          return localList2.size();
        }
      }).a(this);
    while (true)
    {
      Iterator localIterator2 = localArrayList.iterator();
      while (localIterator2.hasNext())
        ((Preference)localIterator2.next()).O();
      notifyDataSetChanged();
    }
  }

  public void a(Preference paramPreference)
  {
    int i = this.b.indexOf(paramPreference);
    if (i != -1)
      notifyItemChanged(i, paramPreference);
  }

  public void a(l paraml, int paramInt)
  {
    a(paramInt).a(paraml);
  }

  public void b(Preference paramPreference)
  {
    this.f.removeCallbacks(this.h);
    this.f.post(this.h);
  }

  public void c(Preference paramPreference)
  {
    if (!this.c.contains(paramPreference))
      break label13;
    label13: 
    while (this.g.a(paramPreference))
      return;
    int k;
    if (paramPreference.B())
    {
      Iterator localIterator = this.c.iterator();
      k = -1;
      label46: Preference localPreference;
      if (localIterator.hasNext())
      {
        localPreference = (Preference)localIterator.next();
        if (!paramPreference.equals(localPreference));
      }
      else
      {
        this.b.add(k + 1, paramPreference);
        notifyItemInserted(k + 1);
        return;
      }
      if (!localPreference.B())
        break label185;
    }
    label185: for (int m = k + 1; ; m = k)
    {
      k = m;
      break label46;
      int i = this.b.size();
      for (int j = 0; ; j++)
      {
        if ((j >= i) || (paramPreference.equals(this.b.get(j))))
        {
          this.b.remove(j);
          notifyItemRemoved(j);
          return;
        }
        if (j == i - 1)
          break;
      }
    }
  }

  public int getItemCount()
  {
    return this.b.size();
  }

  public long getItemId(int paramInt)
  {
    if (!hasStableIds())
      return -1L;
    return a(paramInt).c_();
  }

  public int getItemViewType(int paramInt)
  {
    this.e = a(a(paramInt), this.e);
    int i = this.d.indexOf(this.e);
    if (i != -1)
      return i;
    int j = this.d.size();
    this.d.add(new a(this.e));
    return j;
  }

  private static class a
  {
    int a;
    int b;
    String c;

    a()
    {
    }

    a(a parama)
    {
      this.a = parama.a;
      this.b = parama.b;
      this.c = parama.c;
    }

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a));
      a locala;
      do
      {
        return false;
        locala = (a)paramObject;
      }
      while ((this.a != locala.a) || (this.b != locala.b) || (!TextUtils.equals(this.c, locala.c)));
      return true;
    }

    public int hashCode()
    {
      return 31 * (31 * (527 + this.a) + this.b) + this.c.hashCode();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.h
 * JD-Core Version:    0.6.2
 */
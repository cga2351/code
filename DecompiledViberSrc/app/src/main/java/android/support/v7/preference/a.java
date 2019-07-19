package android.support.v7.preference;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class a
{
  final h a;
  private final Context b;
  private boolean c = false;

  a(PreferenceGroup paramPreferenceGroup, h paramh)
  {
    this.a = paramh;
    this.b = paramPreferenceGroup.I();
  }

  private a a(final PreferenceGroup paramPreferenceGroup, List<Preference> paramList)
  {
    a locala = new a(this.b, paramList, paramPreferenceGroup.c_());
    locala.a(new Preference.c()
    {
      public boolean a(Preference paramAnonymousPreference)
      {
        paramPreferenceGroup.a(2147483647);
        a.this.a.b(paramAnonymousPreference);
        PreferenceGroup.a locala = paramPreferenceGroup.g();
        if (locala != null)
          locala.a();
        return true;
      }
    });
    return locala;
  }

  private List<Preference> b(PreferenceGroup paramPreferenceGroup)
  {
    int i = 0;
    this.c = false;
    int j;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    int m;
    label45: Preference localPreference1;
    if (paramPreferenceGroup.b() != 2147483647)
    {
      j = 1;
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      int k = paramPreferenceGroup.e();
      m = 0;
      if (m >= k)
        break label244;
      localPreference1 = paramPreferenceGroup.b(m);
      if (localPreference1.B())
        break label79;
    }
    label79: PreferenceGroup localPreferenceGroup;
    label128: 
    do
    {
      m++;
      break label45;
      j = 0;
      break;
      if ((j == 0) || (i < paramPreferenceGroup.b()))
        localArrayList1.add(localPreference1);
      while (true)
      {
        if ((localPreference1 instanceof PreferenceGroup))
          break label128;
        i++;
        break;
        localArrayList2.add(localPreference1);
      }
      localPreferenceGroup = (PreferenceGroup)localPreference1;
    }
    while (!localPreferenceGroup.f());
    List localList = b(localPreferenceGroup);
    if ((j != 0) && (this.c))
      throw new IllegalArgumentException("Nested expand buttons are not supported!");
    Iterator localIterator = localList.iterator();
    label181: Preference localPreference2;
    if (localIterator.hasNext())
    {
      localPreference2 = (Preference)localIterator.next();
      if ((j != 0) && (i >= paramPreferenceGroup.b()))
        break label231;
      localArrayList1.add(localPreference2);
    }
    while (true)
    {
      i++;
      break label181;
      break;
      label231: localArrayList2.add(localPreference2);
    }
    label244: if ((j != 0) && (i > paramPreferenceGroup.b()))
      localArrayList1.add(a(paramPreferenceGroup, localArrayList2));
    this.c = (j | this.c);
    return localArrayList1;
  }

  public List<Preference> a(PreferenceGroup paramPreferenceGroup)
  {
    return b(paramPreferenceGroup);
  }

  public boolean a(Preference paramPreference)
  {
    if (((paramPreference instanceof PreferenceGroup)) || (this.c))
    {
      this.a.b(paramPreference);
      return true;
    }
    return false;
  }

  static class a extends Preference
  {
    private long a;

    a(Context paramContext, List<Preference> paramList, long paramLong)
    {
      super();
      b();
      a(paramList);
      this.a = (1000000L + paramLong);
    }

    private void a(List<Preference> paramList)
    {
      Object localObject1 = null;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      CharSequence localCharSequence;
      Object localObject2;
      while (true)
        if (localIterator.hasNext())
        {
          Preference localPreference = (Preference)localIterator.next();
          localCharSequence = localPreference.y();
          if (((localPreference instanceof PreferenceGroup)) && (!TextUtils.isEmpty(localCharSequence)))
            localArrayList.add((PreferenceGroup)localPreference);
          if (localArrayList.contains(localPreference.P()))
          {
            if ((localPreference instanceof PreferenceGroup))
              localArrayList.add((PreferenceGroup)localPreference);
          }
          else
          {
            if (TextUtils.isEmpty(localCharSequence))
              break label168;
            if (localObject1 == null)
              localObject2 = localCharSequence;
          }
        }
      while (true)
      {
        localObject1 = localObject2;
        break;
        localObject2 = I().getString(R.string.summary_collapsed_preference_list, new Object[] { localObject1, localCharSequence });
        continue;
        b(localObject1);
        return;
        label168: localObject2 = localObject1;
      }
    }

    private void b()
    {
      c(R.layout.expand_button);
      f(R.drawable.ic_arrow_down_24dp);
      e(R.string.expand_button_title);
      d(999);
    }

    public void a(l paraml)
    {
      super.a(paraml);
      paraml.a(false);
    }

    public long c_()
    {
      return this.a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.a
 * JD-Core Version:    0.6.2
 */
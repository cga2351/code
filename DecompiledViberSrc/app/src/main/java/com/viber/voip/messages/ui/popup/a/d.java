package com.viber.voip.messages.ui.popup.a;

import android.app.Activity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import com.viber.voip.R.layout;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class d extends g
{
  private SparseArray<Integer> a = new SparseArray();
  private SparseArray<Integer> b = new SparseArray();
  private List<String> c = new ArrayList();
  private Map<Integer, View> d = new HashMap();

  public d(Activity paramActivity, z paramz)
  {
    super(paramActivity, paramz, false);
  }

  public View a(View paramView, int paramInt)
  {
    View localView = g().getLayoutInflater().inflate(R.layout.hc_popup_header, null);
    b(localView, paramInt);
    return localView;
  }

  public abstract String a(int paramInt, aa paramaa);

  public void a(int paramInt, boolean paramBoolean)
  {
    int i = ((Integer)c().get(paramInt)).intValue();
    if (e().get(Integer.valueOf(i)) != null)
      ((View)e().get(Integer.valueOf(i))).setVisibility(0);
  }

  public boolean a()
  {
    d().clear();
    c().clear();
    e().clear();
    int i = 0;
    String str1;
    if (i < f().getCount())
    {
      str1 = a(i, f().f(i));
      if (str1 != null)
        break label171;
    }
    label171: for (String str2 = ""; ; str2 = str1)
    {
      if ((this.c.size() == 0) || (!((String)this.c.get(-1 + this.c.size())).equals(str2)))
        this.c.add(str2);
      int j = -1 + this.c.size();
      this.a.put(i, Integer.valueOf(j));
      if (this.b.get(j) == null)
        this.b.put(j, Integer.valueOf(i));
      i++;
      break;
      return true;
    }
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    if ((this.a.size() > paramInt1) && (this.a.size() > paramInt2))
      return ((Integer)this.a.get(paramInt1)).equals(this.a.get(paramInt2));
    return false;
  }

  public int b()
  {
    return this.c.size();
  }

  public int b(int paramInt)
  {
    if (this.a.size() > paramInt)
      return ((Integer)this.a.get(paramInt)).intValue();
    return -1;
  }

  public abstract void b(View paramView, int paramInt);

  public int c(int paramInt)
  {
    if (this.a == null);
    while (this.a.get(paramInt) == null)
      return -1;
    return ((Integer)this.a.get(paramInt)).intValue();
  }

  public SparseArray<Integer> c()
  {
    return this.a;
  }

  public int d(int paramInt)
  {
    return ((Integer)this.b.get(paramInt)).intValue();
  }

  public List<String> d()
  {
    return this.c;
  }

  public Map<Integer, View> e()
  {
    return this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.popup.a.d
 * JD-Core Version:    0.6.2
 */
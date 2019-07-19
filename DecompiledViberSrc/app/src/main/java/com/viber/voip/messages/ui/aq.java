package com.viber.voip.messages.ui;

import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.util.bp;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public abstract class aq<K>
  implements b.a
{
  private b a;
  private LinkedHashSet<K> b = new LinkedHashSet();

  protected abstract b a(b.a parama);

  public void a(K paramK)
  {
    this.b.add(paramK);
    d();
  }

  public void a(String paramString, int paramInt, LayoutInflater paramLayoutInflater)
  {
    Object localObject = this.a.i();
    if ((localObject == null) || (((Integer)this.a.i().getTag()).intValue() != 1))
      if (!bp.a(paramString))
        break label111;
    label111: for (int i = R.layout.view_custom_action_mode_rtl; ; i = R.layout.view_custom_action_mode)
    {
      View localView = paramLayoutInflater.inflate(i, null);
      localView.setTag(Integer.valueOf(1));
      this.a.a(localView);
      localObject = localView;
      ((TextView)((View)localObject).findViewById(R.id.title)).setText(paramString);
      ((TextView)((View)localObject).findViewById(R.id.count)).setText(String.valueOf(paramInt));
      return;
    }
  }

  public void a(Collection<K> paramCollection)
  {
    this.b.addAll(paramCollection);
  }

  public void b(b paramb)
  {
    this.a = paramb;
  }

  public void b(K paramK)
  {
    this.b.remove(paramK);
    d();
  }

  public void b(Collection<K> paramCollection)
  {
    this.b.addAll(paramCollection);
    d();
  }

  public boolean c(K paramK)
  {
    return this.b.contains(paramK);
  }

  protected abstract void d();

  public void d(K paramK)
  {
    if (paramK != null)
      this.b.add(paramK);
    this.a = a(this);
  }

  public LinkedList<K> f()
  {
    return new LinkedList(this.b);
  }

  public int g()
  {
    return this.b.size();
  }

  public b h()
  {
    return this.a;
  }

  public void i()
  {
    this.b.clear();
    d();
  }

  public void j()
  {
    this.a.c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.aq
 * JD-Core Version:    0.6.2
 */
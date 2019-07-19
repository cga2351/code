package com.viber.voip.messages.ui;

import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class ar<K, V>
  implements b.a
{
  protected b a;
  private LinkedHashMap<K, V> b = new LinkedHashMap();

  private View a(LayoutInflater paramLayoutInflater)
  {
    if (this.a == null)
      return null;
    View localView1 = this.a.i();
    if ((localView1 == null) || (((Integer)this.a.i().getTag()).intValue() != 1))
    {
      View localView2 = paramLayoutInflater.inflate(R.layout.view_custom_action_mode, null);
      localView2.setTag(Integer.valueOf(1));
      this.a.a(localView2);
      return localView2;
    }
    return localView1;
  }

  protected abstract b a(b.a parama);

  public void a(K paramK)
  {
    this.b.remove(paramK);
    e();
  }

  public void a(K paramK, V paramV)
  {
    if (paramK != null)
      this.b.put(paramK, paramV);
    this.a = a(this);
  }

  public void a(String paramString, int paramInt, LayoutInflater paramLayoutInflater)
  {
    View localView = a(paramLayoutInflater);
    if (localView == null)
      return;
    ((TextView)localView.findViewById(R.id.title)).setText(paramString);
    ((TextView)localView.findViewById(R.id.count)).setText(String.valueOf(paramInt));
  }

  public void a(Map<K, V> paramMap)
  {
    this.b.putAll(paramMap);
  }

  public void a(Map<K, V> paramMap, boolean paramBoolean)
  {
    if (paramBoolean)
      this.b.clear();
    this.b.putAll(paramMap);
    e();
  }

  public void b(b paramb)
  {
    this.a = paramb;
  }

  public void b(K paramK, V paramV)
  {
    this.b.put(paramK, paramV);
    e();
  }

  public void b(Map<K, V> paramMap)
  {
    a(paramMap, false);
  }

  public boolean b(K paramK)
  {
    return this.b.containsKey(paramK);
  }

  public void d()
  {
    this.b.clear();
    e();
  }

  protected abstract void e();

  public LinkedHashMap<K, V> f()
  {
    return new LinkedHashMap(this.b);
  }

  public int g()
  {
    return this.b.size();
  }

  public void h()
  {
    this.a = a(this);
  }

  public void i()
  {
    if (this.a != null)
      this.a.c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.ar
 * JD-Core Version:    0.6.2
 */
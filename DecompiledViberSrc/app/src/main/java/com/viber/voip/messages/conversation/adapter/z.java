package com.viber.voip.messages.conversation.adapter;

import android.view.View;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class z<T extends Enum<T>>
{
  private final Map<T, Queue<View>> a;

  public z(Class<T> paramClass)
  {
    this.a = new EnumMap(paramClass);
  }

  public View a(T paramT)
  {
    Queue localQueue = (Queue)this.a.get(paramT);
    if (localQueue == null)
      return null;
    while (!localQueue.isEmpty())
    {
      View localView = (View)localQueue.remove();
      if (a(localView))
        return localView;
    }
    return null;
  }

  public void a()
  {
    this.a.clear();
  }

  public void a(T paramT, View paramView)
  {
    Object localObject = (Queue)this.a.get(paramT);
    if (localObject == null)
    {
      localObject = new LinkedList();
      this.a.put(paramT, localObject);
    }
    ((Queue)localObject).add(paramView);
  }

  protected boolean a(View paramView)
  {
    return paramView != null;
  }

  public String toString()
  {
    Iterator localIterator = this.a.values().iterator();
    int i = 0;
    while (localIterator.hasNext())
      i += ((Queue)localIterator.next()).size();
    int j = this.a.size();
    return "types=" + j + " cached=" + i + " hash=" + hashCode();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.z
 * JD-Core Version:    0.6.2
 */
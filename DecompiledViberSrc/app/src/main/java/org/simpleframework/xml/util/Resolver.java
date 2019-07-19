package org.simpleframework.xml.util;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Resolver<M extends Match> extends AbstractSet<M>
{
  protected final Resolver<M>.Cache cache = new Cache();
  protected final Resolver<M>.Stack stack = new Stack(null);

  private boolean match(char[] paramArrayOfChar1, int paramInt1, char[] paramArrayOfChar2, int paramInt2)
  {
    while ((paramInt2 < paramArrayOfChar2.length) && (paramInt1 < paramArrayOfChar1.length))
    {
      if (paramArrayOfChar2[paramInt2] == '*')
      {
        do
        {
          if (paramArrayOfChar2[paramInt2] != '*')
            break;
          paramInt2++;
        }
        while (paramInt2 < paramArrayOfChar2.length);
        do
        {
          return true;
          if (paramArrayOfChar2[paramInt2] != '?')
            break;
          paramInt2++;
        }
        while (paramInt2 >= paramArrayOfChar2.length);
        while (true)
        {
          if (paramInt1 >= paramArrayOfChar1.length)
            break label116;
          if ((paramArrayOfChar1[paramInt1] == paramArrayOfChar2[paramInt2]) || (paramArrayOfChar2[paramInt2] == '?'))
          {
            if (paramArrayOfChar2[(paramInt2 - 1)] == '?')
              break label116;
            if (match(paramArrayOfChar1, paramInt1, paramArrayOfChar2, paramInt2))
              break;
          }
          paramInt1++;
        }
        label116: if (paramArrayOfChar1.length == paramInt1)
          return false;
      }
      int i = paramInt2;
      int j = paramInt1;
      paramInt1 = j + 1;
      int k = paramArrayOfChar1[j];
      paramInt2 = i + 1;
      if ((k != paramArrayOfChar2[i]) && (paramArrayOfChar2[(paramInt2 - 1)] != '?'))
        return false;
    }
    if (paramArrayOfChar2.length == paramInt2)
    {
      if (paramArrayOfChar1.length == paramInt1);
      for (boolean bool = true; ; bool = false)
        return bool;
    }
    while (paramArrayOfChar2[paramInt2] == '*')
    {
      paramInt2++;
      if (paramInt2 >= paramArrayOfChar2.length)
        return true;
    }
    return false;
  }

  private boolean match(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    return match(paramArrayOfChar1, 0, paramArrayOfChar2, 0);
  }

  private List<M> resolveAll(String paramString, char[] paramArrayOfChar)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.stack.iterator();
    while (localIterator.hasNext())
    {
      Match localMatch = (Match)localIterator.next();
      if (match(paramArrayOfChar, localMatch.getPattern().toCharArray()))
      {
        this.cache.put(paramString, localArrayList);
        localArrayList.add(localMatch);
      }
    }
    return localArrayList;
  }

  public boolean add(M paramM)
  {
    this.stack.push(paramM);
    return true;
  }

  public void clear()
  {
    this.cache.clear();
    this.stack.clear();
  }

  public Iterator<M> iterator()
  {
    return this.stack.sequence();
  }

  public boolean remove(M paramM)
  {
    this.cache.clear();
    return this.stack.remove(paramM);
  }

  public M resolve(String paramString)
  {
    List localList = (List)this.cache.get(paramString);
    if (localList == null)
      localList = resolveAll(paramString);
    if (localList.isEmpty())
      return null;
    return (Match)localList.get(0);
  }

  public List<M> resolveAll(String paramString)
  {
    List localList = (List)this.cache.get(paramString);
    if (localList != null)
      return localList;
    char[] arrayOfChar = paramString.toCharArray();
    if (arrayOfChar == null)
      return null;
    return resolveAll(paramString, arrayOfChar);
  }

  public int size()
  {
    return this.stack.size();
  }

  private class Cache extends LimitedCache<List<M>>
  {
    public Cache()
    {
      super();
    }
  }

  private class Stack extends LinkedList<M>
  {
    private Stack()
    {
    }

    public void purge(int paramInt)
    {
      Resolver.this.cache.clear();
      remove(paramInt);
    }

    public void push(M paramM)
    {
      Resolver.this.cache.clear();
      addFirst(paramM);
    }

    public Iterator<M> sequence()
    {
      return new Sequence();
    }

    private class Sequence
      implements Iterator<M>
    {
      private int cursor = Resolver.Stack.this.size();

      public Sequence()
      {
      }

      public boolean hasNext()
      {
        return this.cursor > 0;
      }

      public M next()
      {
        if (hasNext())
        {
          Resolver.Stack localStack = Resolver.Stack.this;
          int i = -1 + this.cursor;
          this.cursor = i;
          return (Match)localStack.get(i);
        }
        return null;
      }

      public void remove()
      {
        Resolver.Stack.this.purge(this.cursor);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.util.Resolver
 * JD-Core Version:    0.6.2
 */
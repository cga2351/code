package org.simpleframework.xml.stream;

import java.util.ArrayList;

class Stack<T> extends ArrayList<T>
{
  public Stack(int paramInt)
  {
    super(paramInt);
  }

  public T bottom()
  {
    if (size() <= 0)
      return null;
    return get(0);
  }

  public T pop()
  {
    int i = size();
    if (i <= 0)
      return null;
    return remove(i - 1);
  }

  public T push(T paramT)
  {
    add(paramT);
    return paramT;
  }

  public T top()
  {
    int i = size();
    if (i <= 0)
      return null;
    return get(i - 1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.Stack
 * JD-Core Version:    0.6.2
 */
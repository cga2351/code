package org.simpleframework.xml.filter;

import java.util.Stack;

public class StackFilter
  implements Filter
{
  private Stack<Filter> stack = new Stack();

  public void push(Filter paramFilter)
  {
    this.stack.push(paramFilter);
  }

  public String replace(String paramString)
  {
    int j;
    for (int i = this.stack.size(); ; i = j)
    {
      j = i - 1;
      if (j < 0)
        break;
      String str = ((Filter)this.stack.get(j)).replace(paramString);
      if (str != null)
        return str;
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.filter.StackFilter
 * JD-Core Version:    0.6.2
 */
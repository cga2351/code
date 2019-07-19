package twitter4j.internal.json;

import java.io.Serializable;

abstract class EntityIndex
  implements Serializable, Comparable<EntityIndex>
{
  private static final long serialVersionUID = 3864336402689899384L;
  private int end = -1;
  private int start = -1;

  public int compareTo(EntityIndex paramEntityIndex)
  {
    long l = this.start - paramEntityIndex.start;
    if (l < -2147483648L)
      return -2147483648;
    if (l > 2147483647L)
      return 2147483647;
    return (int)l;
  }

  int getEnd()
  {
    return this.end;
  }

  int getStart()
  {
    return this.start;
  }

  void setEnd(int paramInt)
  {
    this.end = paramInt;
  }

  void setStart(int paramInt)
  {
    this.start = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.json.EntityIndex
 * JD-Core Version:    0.6.2
 */
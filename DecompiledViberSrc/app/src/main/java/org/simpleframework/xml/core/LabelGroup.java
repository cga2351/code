package org.simpleframework.xml.core;

import java.util.Arrays;
import java.util.List;

class LabelGroup
{
  private final List<Label> list;
  private final int size;

  public LabelGroup(List<Label> paramList)
  {
    this.size = paramList.size();
    this.list = paramList;
  }

  public LabelGroup(Label paramLabel)
  {
    this(Arrays.asList(new Label[] { paramLabel }));
  }

  public List<Label> getList()
  {
    return this.list;
  }

  public Label getPrimary()
  {
    if (this.size > 0)
      return (Label)this.list.get(0);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.LabelGroup
 * JD-Core Version:    0.6.2
 */
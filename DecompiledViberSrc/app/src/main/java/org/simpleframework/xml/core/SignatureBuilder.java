package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

class SignatureBuilder
{
  private final Constructor factory;
  private final ParameterTable table = new ParameterTable();

  public SignatureBuilder(Constructor paramConstructor)
  {
    this.factory = paramConstructor;
  }

  private List<Signature> build(ParameterTable paramParameterTable)
    throws Exception
  {
    if (this.table.isEmpty())
      return create();
    build(paramParameterTable, 0);
    return create(paramParameterTable);
  }

  private void build(ParameterTable paramParameterTable, int paramInt)
  {
    build(paramParameterTable, new ParameterList(), paramInt);
  }

  private void build(ParameterTable paramParameterTable, ParameterList paramParameterList, int paramInt)
  {
    ParameterList localParameterList1 = this.table.get(paramInt);
    int i = localParameterList1.size();
    if (-1 + this.table.width() > paramInt)
      for (int j = 0; j < i; j++)
      {
        ParameterList localParameterList2 = new ParameterList(paramParameterList);
        if (paramParameterList != null)
        {
          localParameterList2.add((Parameter)localParameterList1.get(j));
          build(paramParameterTable, localParameterList2, paramInt + 1);
        }
      }
    populate(paramParameterTable, paramParameterList, paramInt);
  }

  private List<Signature> create()
    throws Exception
  {
    ArrayList localArrayList = new ArrayList();
    Signature localSignature = new Signature(this.factory);
    if (isValid())
      localArrayList.add(localSignature);
    return localArrayList;
  }

  private List<Signature> create(ParameterTable paramParameterTable)
    throws Exception
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramParameterTable.height();
    int j = paramParameterTable.width();
    for (int k = 0; k < i; k++)
    {
      Signature localSignature = new Signature(this.factory);
      for (int m = 0; m < j; m++)
      {
        Parameter localParameter = paramParameterTable.get(m, k);
        String str = localParameter.getPath();
        if (localSignature.contains(localParameter.getKey()))
        {
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = str;
          arrayOfObject[1] = this.factory;
          throw new ConstructorException("Parameter '%s' is a duplicate in %s", arrayOfObject);
        }
        localSignature.add(localParameter);
      }
      localArrayList.add(localSignature);
    }
    return localArrayList;
  }

  private void populate(ParameterTable paramParameterTable, ParameterList paramParameterList, int paramInt)
  {
    ParameterList localParameterList = this.table.get(paramInt);
    int i = paramParameterList.size();
    int j = localParameterList.size();
    for (int k = 0; k < j; k++)
    {
      for (int m = 0; m < i; m++)
        paramParameterTable.get(m).add((Parameter)paramParameterList.get(m));
      paramParameterTable.get(paramInt).add((Parameter)localParameterList.get(k));
    }
  }

  public List<Signature> build()
    throws Exception
  {
    return build(new ParameterTable());
  }

  public void insert(Parameter paramParameter, int paramInt)
  {
    this.table.insert(paramParameter, paramInt);
  }

  public boolean isValid()
  {
    Class[] arrayOfClass = this.factory.getParameterTypes();
    int i = this.table.width();
    return arrayOfClass.length == i;
  }

  private static class ParameterList extends ArrayList<Parameter>
  {
    public ParameterList()
    {
    }

    public ParameterList(ParameterList paramParameterList)
    {
      super();
    }
  }

  private static class ParameterTable extends ArrayList<SignatureBuilder.ParameterList>
  {
    private int height()
    {
      int i = width();
      int j = 0;
      if (i > 0)
        j = get(0).size();
      return j;
    }

    private int width()
    {
      return size();
    }

    public Parameter get(int paramInt1, int paramInt2)
    {
      return (Parameter)get(paramInt1).get(paramInt2);
    }

    public SignatureBuilder.ParameterList get(int paramInt)
    {
      for (int i = size(); i <= paramInt; i++)
        add(new SignatureBuilder.ParameterList());
      return (SignatureBuilder.ParameterList)super.get(paramInt);
    }

    public void insert(Parameter paramParameter, int paramInt)
    {
      SignatureBuilder.ParameterList localParameterList = get(paramInt);
      if (localParameterList != null)
        localParameterList.add(paramParameter);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.SignatureBuilder
 * JD-Core Version:    0.6.2
 */
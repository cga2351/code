package org.simpleframework.xml.stream;

class InputStack extends Stack<InputNode>
{
  public InputStack()
  {
    super(6);
  }

  public boolean isRelevant(InputNode paramInputNode)
  {
    return (contains(paramInputNode)) || (isEmpty());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.InputStack
 * JD-Core Version:    0.6.2
 */
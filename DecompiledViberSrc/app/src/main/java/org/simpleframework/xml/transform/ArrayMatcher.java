package org.simpleframework.xml.transform;

class ArrayMatcher
  implements Matcher
{
  private final Matcher primary;

  public ArrayMatcher(Matcher paramMatcher)
  {
    this.primary = paramMatcher;
  }

  private Transform matchArray(Class paramClass)
    throws Exception
  {
    Transform localTransform = this.primary.match(paramClass);
    if (localTransform == null)
      return null;
    return new ArrayTransform(localTransform, paramClass);
  }

  public Transform match(Class paramClass)
    throws Exception
  {
    Class localClass = paramClass.getComponentType();
    if (localClass == Character.TYPE)
      return new CharacterArrayTransform(localClass);
    if (localClass == Character.class)
      return new CharacterArrayTransform(localClass);
    if (localClass == String.class)
      return new StringArrayTransform();
    return matchArray(localClass);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.ArrayMatcher
 * JD-Core Version:    0.6.2
 */
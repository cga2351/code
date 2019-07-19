package org.simpleframework.xml.transform;

class PrimitiveMatcher
  implements Matcher
{
  public Transform match(Class paramClass)
    throws Exception
  {
    if (paramClass == Integer.TYPE)
      return new IntegerTransform();
    if (paramClass == Boolean.TYPE)
      return new BooleanTransform();
    if (paramClass == Long.TYPE)
      return new LongTransform();
    if (paramClass == Double.TYPE)
      return new DoubleTransform();
    if (paramClass == Float.TYPE)
      return new FloatTransform();
    if (paramClass == Short.TYPE)
      return new ShortTransform();
    if (paramClass == Byte.TYPE)
      return new ByteTransform();
    if (paramClass == Character.TYPE)
      return new CharacterTransform();
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.PrimitiveMatcher
 * JD-Core Version:    0.6.2
 */
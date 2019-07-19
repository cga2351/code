package org.simpleframework.xml.transform;

class DefaultMatcher
  implements Matcher
{
  private Matcher array = new ArrayMatcher(this);
  private Matcher matcher;
  private Matcher primitive = new PrimitiveMatcher();
  private Matcher stock = new PackageMatcher();

  public DefaultMatcher(Matcher paramMatcher)
  {
    this.matcher = paramMatcher;
  }

  private Transform matchType(Class paramClass)
    throws Exception
  {
    if (paramClass.isArray())
      return this.array.match(paramClass);
    if (paramClass.isPrimitive())
      return this.primitive.match(paramClass);
    return this.stock.match(paramClass);
  }

  public Transform match(Class paramClass)
    throws Exception
  {
    Transform localTransform = this.matcher.match(paramClass);
    if (localTransform != null)
      return localTransform;
    return matchType(paramClass);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.DefaultMatcher
 * JD-Core Version:    0.6.2
 */
package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.LimitedCache;

class ExpressionBuilder
{
  private final Cache<Expression> cache = new LimitedCache();
  private final Format format;
  private final Class type;

  public ExpressionBuilder(Detail paramDetail, Support paramSupport)
  {
    this.format = paramSupport.getFormat();
    this.type = paramDetail.getType();
  }

  private Expression create(String paramString)
    throws Exception
  {
    PathParser localPathParser = new PathParser(paramString, new ClassType(this.type), this.format);
    if (this.cache != null)
      this.cache.cache(paramString, localPathParser);
    return localPathParser;
  }

  public Expression build(String paramString)
    throws Exception
  {
    Expression localExpression = (Expression)this.cache.fetch(paramString);
    if (localExpression == null)
      localExpression = create(paramString);
    return localExpression;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ExpressionBuilder
 * JD-Core Version:    0.6.2
 */
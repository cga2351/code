package org.simpleframework.xml.core;

import org.simpleframework.xml.filter.Filter;

class TemplateFilter
  implements Filter
{
  private Context context;
  private Filter filter;

  public TemplateFilter(Context paramContext, Filter paramFilter)
  {
    this.context = paramContext;
    this.filter = paramFilter;
  }

  public String replace(String paramString)
  {
    Object localObject = this.context.getAttribute(paramString);
    if (localObject != null)
      return localObject.toString();
    return this.filter.replace(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.TemplateFilter
 * JD-Core Version:    0.6.2
 */
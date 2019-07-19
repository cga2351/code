package org.simpleframework.xml.core;

class Caller
{
  private final Function commit;
  private final Function complete;
  private final Context context;
  private final Function persist;
  private final Function replace;
  private final Function resolve;
  private final Function validate;

  public Caller(Scanner paramScanner, Context paramContext)
  {
    this.validate = paramScanner.getValidate();
    this.complete = paramScanner.getComplete();
    this.replace = paramScanner.getReplace();
    this.resolve = paramScanner.getResolve();
    this.persist = paramScanner.getPersist();
    this.commit = paramScanner.getCommit();
    this.context = paramContext;
  }

  public void commit(Object paramObject)
    throws Exception
  {
    if (this.commit != null)
      this.commit.call(this.context, paramObject);
  }

  public void complete(Object paramObject)
    throws Exception
  {
    if (this.complete != null)
      this.complete.call(this.context, paramObject);
  }

  public void persist(Object paramObject)
    throws Exception
  {
    if (this.persist != null)
      this.persist.call(this.context, paramObject);
  }

  public Object replace(Object paramObject)
    throws Exception
  {
    if (this.replace != null)
      paramObject = this.replace.call(this.context, paramObject);
    return paramObject;
  }

  public Object resolve(Object paramObject)
    throws Exception
  {
    if (this.resolve != null)
      paramObject = this.resolve.call(this.context, paramObject);
    return paramObject;
  }

  public void validate(Object paramObject)
    throws Exception
  {
    if (this.validate != null)
      this.validate.call(this.context, paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Caller
 * JD-Core Version:    0.6.2
 */
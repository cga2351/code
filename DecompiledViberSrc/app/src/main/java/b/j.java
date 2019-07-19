package b;

public class j<TResult>
{
  private final i<TResult> a = new i();

  public i<TResult> a()
  {
    return this.a;
  }

  public boolean a(Exception paramException)
  {
    return this.a.b(paramException);
  }

  public boolean a(TResult paramTResult)
  {
    return this.a.b(paramTResult);
  }

  public void b(Exception paramException)
  {
    if (!a(paramException))
      throw new IllegalStateException("Cannot set the error on a completed task.");
  }

  public void b(TResult paramTResult)
  {
    if (!a(paramTResult))
      throw new IllegalStateException("Cannot set the result of a completed task.");
  }

  public boolean b()
  {
    return this.a.g();
  }

  public void c()
  {
    if (!b())
      throw new IllegalStateException("Cannot cancel a completed task.");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     b.j
 * JD-Core Version:    0.6.2
 */
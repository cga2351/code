package b;

class k
{
  private i<?> a;

  public k(i<?> parami)
  {
    this.a = parami;
  }

  public void a()
  {
    this.a = null;
  }

  protected void finalize()
    throws Throwable
  {
    try
    {
      i locali = this.a;
      if (locali != null)
      {
        i.a locala = i.a();
        if (locala != null)
          locala.a(locali, new l(locali.f()));
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     b.k
 * JD-Core Version:    0.6.2
 */
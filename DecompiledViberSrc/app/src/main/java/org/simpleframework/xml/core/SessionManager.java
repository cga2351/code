package org.simpleframework.xml.core;

class SessionManager
{
  private ThreadLocal<Reference> local = new ThreadLocal();

  private Session create(boolean paramBoolean)
    throws Exception
  {
    Reference localReference = new Reference(paramBoolean);
    if (localReference != null)
      this.local.set(localReference);
    return localReference.get();
  }

  public void close()
    throws Exception
  {
    Reference localReference = (Reference)this.local.get();
    if (localReference == null)
      throw new PersistenceException("Session does not exist", new Object[0]);
    if (localReference.clear() == 0)
      this.local.remove();
  }

  public Session open()
    throws Exception
  {
    return open(true);
  }

  public Session open(boolean paramBoolean)
    throws Exception
  {
    Reference localReference = (Reference)this.local.get();
    if (localReference != null)
      return localReference.get();
    return create(paramBoolean);
  }

  private static class Reference
  {
    private int count;
    private Session session;

    public Reference(boolean paramBoolean)
    {
      this.session = new Session(paramBoolean);
    }

    public int clear()
    {
      int i = -1 + this.count;
      this.count = i;
      return i;
    }

    public Session get()
    {
      if (this.count >= 0)
        this.count = (1 + this.count);
      return this.session;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.SessionManager
 * JD-Core Version:    0.6.2
 */
package android.support.v8.renderscript;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class BaseObj
{
  private boolean mDestroyed;
  private long mID;
  RenderScript mRS;

  BaseObj(long paramLong, RenderScript paramRenderScript)
  {
    paramRenderScript.validate();
    this.mRS = paramRenderScript;
    this.mID = paramLong;
    this.mDestroyed = false;
  }

  private void helpDestroy()
  {
    int i = 1;
    while (true)
    {
      try
      {
        if (!this.mDestroyed)
        {
          this.mDestroyed = true;
          if (i != 0)
          {
            ReentrantReadWriteLock.ReadLock localReadLock = this.mRS.mRWLock.readLock();
            localReadLock.lock();
            if (this.mRS.isAlive())
              this.mRS.nObjDestroy(this.mID);
            localReadLock.unlock();
            this.mRS = null;
            this.mID = 0L;
          }
          return;
        }
      }
      finally
      {
      }
      i = 0;
    }
  }

  void checkValid()
  {
    if ((this.mID == 0L) && (getNObj() == null))
      throw new RSIllegalArgumentException("Invalid object.");
  }

  public void destroy()
  {
    if (this.mDestroyed)
      throw new RSInvalidStateException("Object already destroyed.");
    helpDestroy();
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    BaseObj localBaseObj;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localBaseObj = (BaseObj)paramObject;
    }
    while (this.mID == localBaseObj.mID);
    return false;
  }

  protected void finalize()
    throws Throwable
  {
    helpDestroy();
    super.finalize();
  }

  long getID(RenderScript paramRenderScript)
  {
    this.mRS.validate();
    if (this.mDestroyed)
      throw new RSInvalidStateException("using a destroyed object.");
    if (this.mID == 0L)
      throw new RSRuntimeException("Internal error: Object id 0.");
    if ((paramRenderScript != null) && (paramRenderScript != this.mRS))
      throw new RSInvalidStateException("using object with mismatched context.");
    return this.mID;
  }

  android.renderscript.BaseObj getNObj()
  {
    return null;
  }

  public int hashCode()
  {
    return (int)(0xFFFFFFF & this.mID ^ this.mID >> 32);
  }

  void setID(long paramLong)
  {
    if (this.mID != 0L)
      throw new RSRuntimeException("Internal Error, reset of object ID.");
    this.mID = paramLong;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.BaseObj
 * JD-Core Version:    0.6.2
 */
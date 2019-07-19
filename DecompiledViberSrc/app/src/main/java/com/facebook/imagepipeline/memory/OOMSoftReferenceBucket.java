package com.facebook.imagepipeline.memory;

import com.facebook.common.references.OOMSoftReference;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
class OOMSoftReferenceBucket<V> extends Bucket<V>
{
  private LinkedList<OOMSoftReference<V>> mSpareReferences = new LinkedList();

  public OOMSoftReferenceBucket(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3, false);
  }

  void addToFreeList(V paramV)
  {
    OOMSoftReference localOOMSoftReference = (OOMSoftReference)this.mSpareReferences.poll();
    if (localOOMSoftReference == null)
      localOOMSoftReference = new OOMSoftReference();
    localOOMSoftReference.set(paramV);
    this.mFreeList.add(localOOMSoftReference);
  }

  public V pop()
  {
    OOMSoftReference localOOMSoftReference = (OOMSoftReference)this.mFreeList.poll();
    Object localObject = localOOMSoftReference.get();
    localOOMSoftReference.clear();
    this.mSpareReferences.add(localOOMSoftReference);
    return localObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.OOMSoftReferenceBucket
 * JD-Core Version:    0.6.2
 */
package com.facebook.cache.disk;

public class DefaultEntryEvictionComparatorSupplier
  implements EntryEvictionComparatorSupplier
{
  public EntryEvictionComparator get()
  {
    return new EntryEvictionComparator()
    {
      public int compare(DiskStorage.Entry paramAnonymousEntry1, DiskStorage.Entry paramAnonymousEntry2)
      {
        long l1 = paramAnonymousEntry1.getTimestamp();
        long l2 = paramAnonymousEntry2.getTimestamp();
        if (l1 < l2)
          return -1;
        if (l2 == l1)
          return 0;
        return 1;
      }
    };
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.cache.disk.DefaultEntryEvictionComparatorSupplier
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.phone.conf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

class DominantDetector
{
  private static final Float ZERO_LEVEL_VALUE = Float.valueOf(0.0F);
  private HashMap<String, SpeakerInfo> mUsers = new HashMap();

  public String update(Map<String, Float> paramMap)
  {
    HashSet localHashSet = new HashSet(this.mUsers.keySet());
    Iterator localIterator1 = paramMap.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str2 = (String)localIterator1.next();
      Float localFloat = (Float)paramMap.get(str2);
      SpeakerInfo localSpeakerInfo2 = (SpeakerInfo)this.mUsers.get(str2);
      if (localSpeakerInfo2 == null)
      {
        localSpeakerInfo2 = new SpeakerInfo();
        this.mUsers.put(str2, localSpeakerInfo2);
      }
      localSpeakerInfo2.put(localFloat);
      localHashSet.remove(str2);
    }
    Iterator localIterator2 = localHashSet.iterator();
    while (localIterator2.hasNext())
    {
      String str1 = (String)localIterator2.next();
      ((SpeakerInfo)this.mUsers.get(str1)).put(ZERO_LEVEL_VALUE);
    }
    Object localObject1 = Float.valueOf(0.0F);
    Object localObject2 = "";
    Iterator localIterator3 = this.mUsers.keySet().iterator();
    Object localObject3;
    SpeakerInfo localSpeakerInfo1;
    if (localIterator3.hasNext())
    {
      localObject3 = (String)localIterator3.next();
      localSpeakerInfo1 = (SpeakerInfo)this.mUsers.get(localObject3);
      if (((Float)localObject1).floatValue() >= localSpeakerInfo1.totalEnergy().floatValue())
        break label268;
    }
    for (Object localObject4 = localSpeakerInfo1.totalEnergy(); ; localObject4 = localObject1)
    {
      localObject2 = localObject3;
      localObject1 = localObject4;
      break;
      return localObject2;
      label268: localObject3 = localObject2;
    }
  }

  private static class SpeakerInfo
  {
    static final int MEASURES_COUNT = 2;
    private LinkedList<Float> mCounts = new LinkedList();

    public void put(Float paramFloat)
    {
      this.mCounts.add(paramFloat);
      if (this.mCounts.size() > 2)
        this.mCounts.removeFirst();
    }

    Float totalEnergy()
    {
      Float localFloat1 = Float.valueOf(0.0F);
      Iterator localIterator = this.mCounts.iterator();
      Float localFloat3;
      for (Float localFloat2 = localFloat1; localIterator.hasNext(); localFloat2 = Float.valueOf(localFloat2.floatValue() + localFloat3.floatValue()))
        localFloat3 = (Float)localIterator.next();
      return localFloat2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.DominantDetector
 * JD-Core Version:    0.6.2
 */
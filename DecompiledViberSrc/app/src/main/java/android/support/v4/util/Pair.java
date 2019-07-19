package android.support.v4.util;

public class Pair<F, S>
{
  public final F first;
  public final S second;

  public Pair(F paramF, S paramS)
  {
    this.first = paramF;
    this.second = paramS;
  }

  public static <A, B> Pair<A, B> create(A paramA, B paramB)
  {
    return new Pair(paramA, paramB);
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Pair));
    Pair localPair;
    do
    {
      return false;
      localPair = (Pair)paramObject;
    }
    while ((!ObjectsCompat.equals(localPair.first, this.first)) || (!ObjectsCompat.equals(localPair.second, this.second)));
    return true;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.first == null)
    {
      i = 0;
      Object localObject = this.second;
      j = 0;
      if (localObject != null)
        break label35;
    }
    while (true)
    {
      return i ^ j;
      i = this.first.hashCode();
      break;
      label35: j = this.second.hashCode();
    }
  }

  public String toString()
  {
    return "Pair{" + String.valueOf(this.first) + " " + String.valueOf(this.second) + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.util.Pair
 * JD-Core Version:    0.6.2
 */
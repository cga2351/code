package org.webrtc;

public class StatsReport
{
  public final String id;
  public final double timestamp;
  public final String type;
  public final Value[] values;

  @CalledByNative
  public StatsReport(String paramString1, String paramString2, double paramDouble, Value[] paramArrayOfValue)
  {
    this.id = paramString1;
    this.type = paramString2;
    this.timestamp = paramDouble;
    this.values = paramArrayOfValue;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id: ").append(this.id).append(", type: ").append(this.type).append(", timestamp: ").append(this.timestamp).append(", values: ");
    for (int i = 0; i < this.values.length; i++)
      localStringBuilder.append(this.values[i].toString()).append(", ");
    return localStringBuilder.toString();
  }

  public static class Value
  {
    public final String name;
    public final String value;

    @CalledByNative("Value")
    public Value(String paramString1, String paramString2)
    {
      this.name = paramString1;
      this.value = paramString2;
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[").append(this.name).append(": ").append(this.value).append("]");
      return localStringBuilder.toString();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.StatsReport
 * JD-Core Version:    0.6.2
 */
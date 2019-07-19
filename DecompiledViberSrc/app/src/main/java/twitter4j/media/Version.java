package twitter4j.media;

import java.io.PrintStream;

public final class Version
{
  private static final String TITLE = "Twitter4J Media support";
  private static final String VERSION = "3.0.6-SNAPSHOT(build: 6b148528110cab823a73f4ae60f90cae89fd2fb5)";

  private Version()
  {
    throw new AssertionError();
  }

  public static String getVersion()
  {
    return "3.0.6-SNAPSHOT(build: 6b148528110cab823a73f4ae60f90cae89fd2fb5)";
  }

  public static void main(String[] paramArrayOfString)
  {
    System.out.println("Twitter4J Media support 3.0.6-SNAPSHOT(build: 6b148528110cab823a73f4ae60f90cae89fd2fb5)");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.media.Version
 * JD-Core Version:    0.6.2
 */
import dynamicProgramming.EggDrop;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by srathi on 11/22/16.
 */
public class EggDroppingTest {

    @Test
    public void testMaxValue()
    {
        EggDrop k = new EggDrop();
        int eggs = 2;
        int floors = 36;
        Assert.assertEquals(8,k.minAttemps(eggs,floors));

    }

}

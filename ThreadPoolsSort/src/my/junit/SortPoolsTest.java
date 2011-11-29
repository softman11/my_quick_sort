package my.junit;

import static org.junit.Assert.*;
import junit.framework.Assert;

import my.test.SortPools;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SortPoolsTest {

	SortPools sp;
	int[] arr,temp;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		int size=100;
		arr=new int[size];
		temp=new int[size];
		sp=new SortPools(arr, temp, 6, 0);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testmakePartion() {
		Assert.assertEquals(sp.partionList.size(), 6);
		Assert.assertEquals(sp.partionList.get(0).begin, 0);
		Assert.assertEquals(sp.partionList.get(0).end, 15);
		Assert.assertEquals(sp.partionList.get(5).begin, 80);
		Assert.assertEquals(sp.partionList.get(5).end, 99);
	}
	
	@Test
	public void testmakeMergeTast()
	{
		sp.makeMergeTask();
		Assert.assertEquals(sp.partionList.size(), 3);
		Assert.assertEquals(sp.partionList.get(0).begin, 0);
		Assert.assertEquals(sp.partionList.get(0).end, 31);
		Assert.assertEquals(sp.partionList.get(1).begin, 32);
		Assert.assertEquals(sp.partionList.get(1).end, 63);
		Assert.assertEquals(sp.partionList.get(2).begin, 64);
		Assert.assertEquals(sp.partionList.get(2).end, 99);
		
		Assert.assertEquals(sp.mergeList.size(), 3);		
		Assert.assertEquals(sp.mergeList.get(0).low, 0);
		Assert.assertEquals(sp.mergeList.get(0).mid, 15);
		Assert.assertEquals(sp.mergeList.get(0).high, 31);
		
		Assert.assertEquals(sp.mergeList.get(1).low, 32);
		Assert.assertEquals(sp.mergeList.get(1).mid, 47);
		Assert.assertEquals(sp.mergeList.get(1).high, 63);
		
		sp.makeMergeTask();
		Assert.assertEquals(sp.partionList.size(), 2);
		Assert.assertEquals(sp.partionList.get(0).begin, 0);
		Assert.assertEquals(sp.partionList.get(0).end, 63);
		Assert.assertEquals(sp.partionList.get(1).begin, 64);
		Assert.assertEquals(sp.partionList.get(1).end, 99);
		
		Assert.assertEquals(sp.mergeList.size(), 1);		
		Assert.assertEquals(sp.mergeList.get(0).low, 0);
		Assert.assertEquals(sp.mergeList.get(0).mid, 31);
		Assert.assertEquals(sp.mergeList.get(0).high, 63);
		
		sp.makeMergeTask();
		Assert.assertEquals(sp.partionList.size(), 1);
		Assert.assertEquals(sp.partionList.get(0).begin, 0);
		Assert.assertEquals(sp.partionList.get(0).end, 99);
		
		Assert.assertEquals(sp.mergeList.size(), 1);		
		Assert.assertEquals(sp.mergeList.get(0).low, 0);
		Assert.assertEquals(sp.mergeList.get(0).mid, 63);
		Assert.assertEquals(sp.mergeList.get(0).high, 99);
		
		sp.makeMergeTask();
		Assert.assertEquals(sp.partionList.size(), 1);
		Assert.assertEquals(sp.mergeList.size(), 0);	
		
	}

}

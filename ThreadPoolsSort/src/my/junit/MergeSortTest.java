package my.junit;

import static org.junit.Assert.*;

import my.test.MergeSort;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MergeSortTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testmerge() {
		int[] arr={4,5,6,4,10,2};
		int[] temp={1,7,9,6,0,0};
		MergeSort.merge(arr, temp, 1, 2, 4);
		Assert.assertArrayEquals(arr, new int[]{4,4,5,6,10,2});
	}

}

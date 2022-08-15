/*August 15, 2022*/

package com.daily;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.daily.Conn.DatabaseConnection;
import com.daily.Conn.GenericClass;
import com.daily.Conn.NetworkConnection;

public class AppTest
{
	@Mock
	HashMap<Integer, String> hashMap;

	@Mock // Create Mock object.
	DatabaseConnection dbOne;

	@Mock // Create Mock object.
	NetworkConnection nwTwo;

	@InjectMocks // Creates an actual object and injects Mocked dependencies into it.
	GenericClass gen;

	@BeforeEach
	public void setUp()
	{
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void validateTest()
	{
		when(dbOne.save("A")).thenReturn(true);
		when(nwTwo.save("B")).thenReturn(true);
	}

	@Test
	public void storeTest()
	{
		hashMap.put(1, "Chris");
		hashMap.put(2, "Saran");
		verify(hashMap, times(2)); // Static Verify Method -> if the method was executed 'n' times.
	}
}
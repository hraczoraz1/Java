import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class test {

	@Test
	public void givenEmptyList_whenIsEmpty_thenTrueIsReturned() {
		List list = new CustomList<>();
		list.add(null);
		assertFalse(list.isEmpty());
	}

		@Test
		public void givenListWithAnElement_whenSize_thenOneIsReturned() {
		    List<Object> list = new CustomList<>();
		    list.add(null);
		 
		    assertEquals(1, list.size());
		}
		
		@Test
		public void givenListWithAnElement_whenGet_thenThatElementIsReturned() {
		    List<Object> list = new CustomList<>();
		    list.add("baeldung");
		    Object element = list.get(0);
		 
		    assertEquals("baeldung", element);
		}
		@Test
		public void givenEmptyList_whenElementIsAdded_thenGetReturnsThatElement() {
		    List<Object> list = new CustomList<>();
		    boolean succeeded = list.add(null);
		 
		    assertTrue(succeeded);
		}
		
		@Test
		public void givenListWithAnElement_whenAnotherIsAdded_thenGetReturnsBoth() {
		    List<Object> list = new CustomList<>();
		    list.add("baeldung");
		    list.add(".com");
		    Object element1 = list.get(0);
		    Object element2 = list.get(1);
		 
		    assertEquals("baeldung", element1);
		    assertEquals(".com", element2);
		}
}

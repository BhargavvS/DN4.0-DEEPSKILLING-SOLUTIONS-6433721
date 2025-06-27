package org.example;

import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MyServiceTest {
    public void testExternalApi() {
        // 1. Create mock
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // 2. Stub method
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Inject mock into service
        MyService service = new MyService(mockApi);

        // 4. Call the method and assert
        String result = service.fetchData();
        assertEquals("Mock Data", result, "Service should return mocked API data");
    }

}
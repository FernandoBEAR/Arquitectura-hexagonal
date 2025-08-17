import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import com.allfym.ms.hexagonal.almacen.domain.models.AlmacenProducto;
import com.allfym.ms.hexagonal.almacen.infrastructure.repositories.JpaAlmacenProductoRepository;
import com.allfym.ms.hexagonal.almacen.infrastructure.entities.AlmacenProductoEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, 
               classes = com.allfym.ms.hexagonal.almacen.MsAlmacenApplication.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class DeleteEndpointIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private JpaAlmacenProductoRepository repository;

    @Test
    public void testDeleteExistingProduct() {
        // Arrange: Insert test data directly into repository
        AlmacenProductoEntity testEntity = new AlmacenProductoEntity();
        testEntity.setIdProducto(5L);
        testEntity.setStock(10);
        repository.save(testEntity);

        // Verify the product exists
        assertEquals(1, repository.count());

        // Act: Call DELETE endpoint
        String url = "http://localhost:" + port + "/api/almacen/producto/5";
        ResponseEntity<String> response = restTemplate.exchange(
                url, 
                org.springframework.http.HttpMethod.DELETE, 
                null, 
                String.class
        );

        // Assert: Verify successful deletion
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Producto eliminado correctamente", response.getBody());
        assertEquals(0, repository.count());
    }

    @Test
    public void testDeleteNonExistentProduct() {
        // Arrange: Ensure database is empty
        assertEquals(0, repository.count());

        // Act: Call DELETE endpoint on non-existent product
        String url = "http://localhost:" + port + "/api/almacen/producto/999";
        ResponseEntity<String> response = restTemplate.exchange(
                url, 
                org.springframework.http.HttpMethod.DELETE, 
                null, 
                String.class
        );

        // Assert: Verify 404 response
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Producto no encontrado con ID: 999", response.getBody());
    }

    @Test
    public void testDeleteProductIdZero() {
        // Act: Call DELETE endpoint with ID 0
        String url = "http://localhost:" + port + "/api/almacen/producto/0";
        ResponseEntity<String> response = restTemplate.exchange(
                url, 
                org.springframework.http.HttpMethod.DELETE, 
                null, 
                String.class
        );

        // Assert: Verify 404 response
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Producto no encontrado con ID: 0", response.getBody());
    }
}
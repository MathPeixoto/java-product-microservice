package com.mpeixoto.product.web.controller;

import com.mpeixoto.product.web.model.ProductDto;
import com.mpeixoto.product.web.model.QueryProduct;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;

/**
 * Interface responsible for defining how the endpoint needs to be implemented.
 *
 * @author mpeixoto
 */
public interface ProductController {

  /**
   * Endpoint responsible for retrieving the products based or not in queries.
   *
   * @param correlationId The identifier of each request
   * @param token Type: String
   * @param queryProduct Type: Map
   * @return A ResponseEntity that contains a List of ProductDto and
   */
  ResponseEntity<List<ProductDto>> retrieveProducts(
      String correlationId, String token, QueryProduct queryProduct);

  /**
   * Endpoint responsible for adding a new product in the database.
   *
   * @param correlationId The identifier of each request
   * @param token Type: String
   * @param product Type: ProductDto
   * @return A ResponseEntity that contains a ProductDto
   */
  ResponseEntity<ProductDto> addProduct(
      String correlationId, String token, @Valid ProductDto product);

  /**
   * Endpoint responsible for retrieving a specific product from database given its id.
   *
   * @param correlationId The identifier of each request
   * @param token Type: String
   * @param fetchSuppliers Type: boolean
   * @param productId Type: String
   * @return A ResponseEntity that contains a ProductDto
   */
  ResponseEntity<ProductDto> retrieveAProduct(
      String correlationId, String token, boolean fetchSuppliers, String productId);

  /**
   * Endpoint responsible for updating a in the database.
   *
   * @param correlationId The identifier of each request
   * @param token Type: String
   * @param product Type: ProductDto
   * @param productId Type: String
   * @return A ResponseEntity that contains a ProductDto
   */
  ResponseEntity<ProductDto> updateAProduct(
      String correlationId, String token, @Valid ProductDto product, String productId);
}
